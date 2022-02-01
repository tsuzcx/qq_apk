package com.tencent.mobileqq.troop.honor;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.simpleui.api.ISimpleUIUtil;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService.IGetTroopHonorListCallback;
import com.tencent.mobileqq.troop.honor.config.TroopHonor;
import com.tencent.mobileqq.troop.honor.config.TroopHonorConfig;
import com.tencent.mobileqq.troop.honor.util.TroopHonorUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.oidb_0xdc9.oidb_0xdc9.HonorList;
import tencent.im.troop.honor.troop_honor.HonorChangeGrayTipsReserved;
import tencent.im.troop.honor.troop_honor.UserHonor;

public class TroopHonorManager
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = TroopListHandler.class.getName();
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private TroopHonorConfig jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig;
  private List<oidb_0xdc9.HonorList> jdField_a_of_type_JavaUtilList;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean = false;
  
  public TroopHonorManager(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramAppRuntime.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig = new TroopHonorConfig();
    ThreadManager.getSubThreadHandler().post(new TroopHonorManager.1(this));
  }
  
  private byte a()
  {
    return (byte)this.jdField_a_of_type_MqqAppAppRuntime.getApp().getSharedPreferences(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), 0).getInt("honor_rich_self", 0);
  }
  
  private void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    byte b = a();
    TroopInfo localTroopInfo = ((ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString1);
    if (localTroopInfo != null)
    {
      if (!paramBoolean)
      {
        localTroopInfo.troopHonorGrayFlag = paramInt;
        localTroopInfo.myHonorList = paramString2;
      }
      localTroopInfo.myHonorRichFlag = b;
      a(localTroopInfo);
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonor.manager", 2, String.format("updateHostHonorList| update notUpdateHonors:%s, troopUin: %s, troopHonorGrayFlag: %s,honor_rich: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt), Byte.valueOf(b) }));
      }
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, List<Integer> paramList, String paramString3)
  {
    byte b = a();
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "");
    TroopMemberInfo localTroopMemberInfo2 = localITroopMemberInfoService.getTroopMember(paramString2, paramString1);
    TroopMemberInfo localTroopMemberInfo1 = localTroopMemberInfo2;
    if (localTroopMemberInfo2 == null)
    {
      localTroopMemberInfo1 = localTroopMemberInfo2;
      if (!TextUtils.isEmpty(paramString3))
      {
        localTroopMemberInfo1 = new TroopMemberInfo();
        localTroopMemberInfo1.memberuin = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
        localTroopMemberInfo1.troopuin = paramString2;
      }
    }
    if (localTroopMemberInfo1 != null)
    {
      if (!paramBoolean) {
        localTroopMemberInfo1.honorList = paramString3;
      }
      localTroopMemberInfo1.mHonorRichFlag = b;
      if (localTroopMemberInfo1.getStatus() == 1000) {
        localITroopMemberInfoService.saveTroopMemberInfoInLruCache(paramString2, paramString1, localTroopMemberInfo1);
      }
      paramBoolean = a(localTroopMemberInfo1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonor.manager", 2, String.format("updateHostHonorList| update host memberInfo, troopUin: %s, honorList: %s, result: %s ,honor_rich: %s", new Object[] { paramString2, paramList, Boolean.valueOf(paramBoolean), Byte.valueOf(b) }));
      }
    }
  }
  
  public List<TroopHonor> a(String paramString)
  {
    return a(paramString, Byte.valueOf((byte)0));
  }
  
  public List<TroopHonor> a(String paramString, Byte paramByte)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = TroopHonorUtils.a(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      Iterator localIterator = paramString.iterator();
      label154:
      while (localIterator.hasNext())
      {
        paramString = (Integer)localIterator.next();
        if ((paramString.intValue() == 1) || (paramString.intValue() == 2) || (paramString.intValue() == 3))
        {
          int i = TroopHonorUtils.a(paramString.intValue(), paramByte.byteValue());
          if (i == 1) {
            paramString = this.jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig.a(paramString.intValue(), i);
          }
        }
        for (;;)
        {
          if (paramString == null) {
            break label154;
          }
          localArrayList.add(paramString);
          break;
          paramString = this.jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig.a(paramString.intValue());
          continue;
          paramString = this.jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig.a(paramString.intValue());
        }
      }
    }
    return localArrayList;
  }
  
  public List<TroopHonor> a(String paramString1, String paramString2)
  {
    if (!b(paramString1)) {
      return null;
    }
    Object localObject = ((ITroopMemberInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2);
    if (localObject != null) {}
    for (localObject = a(((TroopMemberInfo)localObject).honorList, Byte.valueOf(((TroopMemberInfo)localObject).mHonorRichFlag));; localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonor.manager", 2, String.format("getTroopHonorList, troopUin: %s, memberUin: %s, honorList: %s", new Object[] { paramString1, paramString2, localObject }));
      }
      return localObject;
    }
  }
  
  public void a(TroopHonorConfig paramTroopHonorConfig, boolean paramBoolean)
  {
    if (paramTroopHonorConfig == null) {}
    for (;;)
    {
      try
      {
        QLog.d("TroopHonor.manager", 1, "updateConfig, config == null");
        return;
      }
      finally {}
      if ((paramBoolean) && (this.jdField_a_of_type_Boolean))
      {
        QLog.d("TroopHonor.manager", 1, "had init config");
      }
      else
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig = paramTroopHonorConfig;
        if (QLog.isColorLevel()) {
          QLog.d("TroopHonor.manager", 2, String.format("updateConfig, isInit: %s, config: %s", new Object[] { Boolean.valueOf(paramBoolean), paramTroopHonorConfig }));
        }
        if (!paramBoolean) {
          ((TroopListHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(jdField_a_of_type_JavaLangString)).notifyUI(TroopNotificationConstants.aC, true, null);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, ITroopHonorService.IGetTroopHonorListCallback paramIGetTroopHonorListCallback)
  {
    ((ITroopMemberInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfo(paramString1, paramString2, new TroopHonorManager.2(this, paramString1, paramString2, paramIGetTroopHonorListCallback));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, byte paramByte)
  {
    a(paramString1, paramString2, paramString3, paramByte, -101L);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, byte paramByte, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "");
      Object localObject = (ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin().equals(paramString2))
      {
        TroopInfo localTroopInfo = ((ITroopInfoService)localObject).getTroopInfo(paramString1);
        if ((localTroopInfo != null) && (paramString3 != null) && ((!paramString3.equals(localTroopInfo.myHonorList)) || (a(paramLong, localTroopInfo.lastMsgUpdateMyHonorRichTime, paramByte, localTroopInfo.myHonorRichFlag))))
        {
          localTroopInfo.myHonorList = paramString3;
          if ((paramByte != -96) && ((paramLong == -101L) || (paramLong > localTroopInfo.lastMsgUpdateMyHonorRichTime)))
          {
            localTroopInfo.myHonorRichFlag = paramByte;
            localTroopInfo.lastMsgUpdateMyHonorRichTime = paramLong;
          }
          ((ITroopInfoService)localObject).saveTroopInfo(localTroopInfo);
        }
      }
      localObject = localITroopMemberInfoService.getTroopMember(paramString1, paramString2);
      if ((localObject == null) && (!TextUtils.isEmpty(paramString3)))
      {
        localObject = new TroopMemberInfo();
        ((TroopMemberInfo)localObject).memberuin = paramString2;
        ((TroopMemberInfo)localObject).troopuin = paramString1;
      }
      while ((localObject != null) && ((!TextUtils.equals(paramString3, ((TroopMemberInfo)localObject).honorList)) || (a(paramLong, ((TroopMemberInfo)localObject).lastMsgUpdateHonorRichTime, paramByte, ((TroopMemberInfo)localObject).mHonorRichFlag))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopHonor.manager", 2, String.format("updateTroopMemberHonor troopUin: %s, memberUin: %s, newHonorList: %s, oldHonorList: %s", new Object[] { paramString1, paramString2, paramString3, ((TroopMemberInfo)localObject).honorList }));
        }
        ((TroopMemberInfo)localObject).honorList = paramString3;
        if (((paramByte != -96) && (paramLong == -101L)) || (paramLong > ((TroopMemberInfo)localObject).lastMsgUpdateHonorRichTime))
        {
          ((TroopMemberInfo)localObject).mHonorRichFlag = paramByte;
          ((TroopMemberInfo)localObject).lastMsgUpdateHonorRichTime = paramLong;
        }
        if (((TroopMemberInfo)localObject).getStatus() == 1000) {
          localITroopMemberInfoService.saveTroopMemberInfoInLruCache(paramString1, paramString2, (TroopMemberInfo)localObject);
        }
        localITroopMemberInfoService.saveTroopMemberInfoToDB(paramString1, paramString2, (TroopMemberInfo)localObject);
        return;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
    TroopInfo localTroopInfo = localITroopInfoService.getTroopInfo(paramString);
    if (localTroopInfo == null) {
      QLog.d("TroopHonor.manager", 1, "updateTroopHonorAIOSwitch troopInfo is null");
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonor.manager", 2, String.format("updateTroopHonorAIOSwitch, troopUin: %s, isOpen: %s, old: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(localTroopInfo.isTroopHonorOpen()) }));
      }
    } while (!(localTroopInfo.isTroopHonorOpen() ^ paramBoolean));
    if (paramBoolean) {}
    for (localTroopInfo.dwGroupFlagExt3 &= 0xFDFFFFFF;; localTroopInfo.dwGroupFlagExt3 |= 0x2000000)
    {
      localITroopInfoService.saveTroopInfo(localTroopInfo);
      ((TroopListHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(jdField_a_of_type_JavaLangString)).notifyUI(TroopNotificationConstants.aC, true, null);
      return;
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject = new troop_honor.HonorChangeGrayTipsReserved();
        ((troop_honor.HonorChangeGrayTipsReserved)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((troop_honor.HonorChangeGrayTipsReserved)localObject).user_honor.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
        {
          localObject = paramArrayOfByte.iterator();
          if (((Iterator)localObject).hasNext())
          {
            troop_honor.UserHonor localUserHonor = (troop_honor.UserHonor)((Iterator)localObject).next();
            String str = String.valueOf(localUserHonor.uin.get());
            if (!localUserHonor.id.has()) {
              break label258;
            }
            paramArrayOfByte = localUserHonor.id.get();
            a(paramString, str, TroopHonorUtils.a(paramArrayOfByte), TroopHonorUtils.a(localUserHonor.rich_flag));
            if ((!TextUtils.isEmpty(str)) && (str.equals(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin()))) {
              ((TroopListHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(jdField_a_of_type_JavaLangString)).notifyUI(TroopNotificationConstants.aC, true, new Object[] { paramString, str });
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("TroopHonor.push", 2, String.format("updatePushTroopHonor, pushType: %s, troopUin: %s, memberUin: %s, ids: %s，honor_rich：%s", new Object[] { Integer.valueOf(paramInt), paramString, str, paramArrayOfByte, Integer.valueOf(localUserHonor.rich_flag.get()) }));
            continue;
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        paramString.printStackTrace();
        QLog.d("TroopHonor.manager", 1, "updatePushTroopHonor", paramString);
      }
      label258:
      paramArrayOfByte = null;
    }
  }
  
  public void a(List<oidb_0xdc9.HonorList> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.d("TroopHonor.manager", 1, "updateHostHonorList| honorList is empty!");
    }
    StringBuilder localStringBuilder;
    label205:
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList = paramList;
      localStringBuilder = new StringBuilder();
      String str1 = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
      if (TextUtils.isEmpty(str1))
      {
        QLog.d("TroopHonor.manager", 1, "updateHostHonorList memberUin is empty");
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (oidb_0xdc9.HonorList)paramList.next();
        String str2 = String.valueOf(((oidb_0xdc9.HonorList)localObject).group_id.get());
        if (((oidb_0xdc9.HonorList)localObject).is_gray.has()) {}
        for (int i = ((oidb_0xdc9.HonorList)localObject).is_gray.get();; i = 0)
        {
          localObject = ((oidb_0xdc9.HonorList)localObject).id.get();
          String str3 = TroopHonorUtils.a((List)localObject);
          localStringBuilder.append(str2).append(": ").append(str3).append("\n");
          if (TextUtils.isEmpty(str2)) {
            break label205;
          }
          a(paramBoolean, str2, i, str3);
          a(paramBoolean, str1, str2, (List)localObject, str3);
          break;
        }
        QLog.d("TroopHonor.manager", 1, String.format("updateHostHonorList| troopUin is empty", new Object[0]));
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopHonor.manager", 2, "updateHostHonorList, " + localStringBuilder.toString());
  }
  
  public void a(short paramShort)
  {
    this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), 0).edit().putInt("honor_rich_self", paramShort).apply();
  }
  
  public void a(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_JavaUtilList, paramBoolean);
  }
  
  public boolean a(long paramLong1, long paramLong2, byte paramByte1, byte paramByte2)
  {
    if (paramByte1 == paramByte2) {}
    while ((paramLong1 != -101L) && (paramLong1 <= paramLong2)) {
      return false;
    }
    return true;
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
  }
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig.jdField_a_of_type_Boolean)) {}
    for (int i = 1;; i = 0)
    {
      ITroopInfoService localITroopInfoService = (ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
      if (i == 0)
      {
        paramString = localITroopInfoService.getTroopInfo(paramString);
        if ((paramString == null) || (paramString.troopHonorGrayFlag != 1)) {
          break;
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    boolean bool6 = false;
    boolean bool2;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig.jdField_a_of_type_Boolean))
    {
      bool2 = true;
      paramString = ((ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString);
      if (bool2) {
        break label254;
      }
      if ((paramString == null) || (paramString.troopHonorGrayFlag != 1)) {
        break label231;
      }
      bool1 = true;
    }
    for (;;)
    {
      label61:
      boolean bool3;
      if ((paramString != null) && ((paramString.dwGroupFlagExt3 & 0x2000000) == 0L))
      {
        bool3 = true;
        label81:
        paramString = (ISimpleUIUtil)QRoute.api(ISimpleUIUtil.class);
        if (paramString == null) {
          break label248;
        }
      }
      label231:
      label248:
      for (boolean bool4 = paramString.getSimpleUISwitch();; bool4 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopHonor.manager", 2, String.format("isSupportTroopHonor, isGlobalOpen: %s, isGrayTroop: %s, isAIOOpen: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) }));
        }
        paramString = ((IProfileDataService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), true);
        if (paramString != null) {}
        for (boolean bool5 = paramString.troopHonorSwitch;; bool5 = false)
        {
          if (!bool2)
          {
            bool2 = bool6;
            if (!bool1) {}
          }
          else
          {
            bool2 = bool6;
            if (bool3)
            {
              bool2 = bool6;
              if (!bool4)
              {
                bool2 = bool6;
                if (bool5) {
                  bool2 = true;
                }
              }
            }
          }
          return bool2;
          bool2 = false;
          break;
          bool1 = false;
          break label61;
          bool3 = false;
          break label81;
        }
      }
      label254:
      bool1 = false;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.TroopHonorManager
 * JD-Core Version:    0.7.0.1
 */