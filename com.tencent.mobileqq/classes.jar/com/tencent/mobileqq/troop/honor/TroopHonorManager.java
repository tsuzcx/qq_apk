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
import com.tencent.mobileqq.simpleui.api.ISimpleUIUtil;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
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
  private static final String jdField_a_of_type_JavaLangString = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopListHandlerName();
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
      while (localIterator.hasNext())
      {
        paramString = (Integer)localIterator.next();
        if ((paramString.intValue() != 1) && (paramString.intValue() != 2) && (paramString.intValue() != 3))
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig.a(paramString.intValue());
        }
        else
        {
          int i = TroopHonorUtils.a(paramString.intValue(), paramByte.byteValue());
          if (i == 1) {
            paramString = this.jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig.a(paramString.intValue(), i);
          } else {
            paramString = this.jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig.a(paramString.intValue());
          }
        }
        if (paramString != null) {
          localArrayList.add(paramString);
        }
      }
    }
    return localArrayList;
  }
  
  public List<TroopHonor> a(String paramString1, String paramString2)
  {
    boolean bool = b(paramString1);
    List localList = null;
    if (!bool) {
      return null;
    }
    TroopMemberInfo localTroopMemberInfo = ((ITroopMemberInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2);
    if (localTroopMemberInfo != null) {
      localList = a(localTroopMemberInfo.honorList, Byte.valueOf(localTroopMemberInfo.mHonorRichFlag));
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.manager", 2, String.format("getTroopHonorList, troopUin: %s, memberUin: %s, honorList: %s", new Object[] { paramString1, paramString2, localList }));
    }
    return localList;
  }
  
  public void a(TroopHonorConfig paramTroopHonorConfig, boolean paramBoolean)
  {
    if (paramTroopHonorConfig == null) {
      try
      {
        QLog.d("TroopHonor.manager", 1, "updateConfig, config == null");
        return;
      }
      finally
      {
        break label124;
      }
    }
    if ((paramBoolean) && (this.jdField_a_of_type_Boolean))
    {
      QLog.d("TroopHonor.manager", 1, "had init config");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig = paramTroopHonorConfig;
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.manager", 2, String.format("updateConfig, isInit: %s, config: %s", new Object[] { Boolean.valueOf(paramBoolean), paramTroopHonorConfig }));
    }
    if (!paramBoolean) {
      ((ITroopListHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(jdField_a_of_type_JavaLangString)).a(TroopObserver.TYPE_NOTIFY_UPDATE_RECENT_LIST, true, null);
    }
    return;
    label124:
    throw paramTroopHonorConfig;
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
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "");
      Object localObject2 = (ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin().equals(paramString2))
      {
        localObject1 = ((ITroopInfoService)localObject2).getTroopInfo(paramString1);
        if ((localObject1 != null) && (paramString3 != null))
        {
          if ((paramString3.equals(((TroopInfo)localObject1).myHonorList)) && (!a(paramLong, ((TroopInfo)localObject1).lastMsgUpdateMyHonorRichTime, paramByte, ((TroopInfo)localObject1).myHonorRichFlag))) {}
          for (;;)
          {
            break;
            ((TroopInfo)localObject1).myHonorList = paramString3;
            if ((paramByte != -96) && ((paramLong == -101L) || (paramLong > ((TroopInfo)localObject1).lastMsgUpdateMyHonorRichTime)))
            {
              ((TroopInfo)localObject1).myHonorRichFlag = paramByte;
              ((TroopInfo)localObject1).lastMsgUpdateMyHonorRichTime = paramLong;
            }
            ((ITroopInfoService)localObject2).saveTroopInfo((TroopInfo)localObject1);
          }
        }
      }
      Object localObject1 = paramString1;
      localObject2 = localITroopMemberInfoService.getTroopMember((String)localObject1, paramString2);
      paramString1 = (String)localObject2;
      if (localObject2 == null)
      {
        paramString1 = (String)localObject2;
        if (!TextUtils.isEmpty(paramString3))
        {
          paramString1 = new TroopMemberInfo();
          paramString1.memberuin = paramString2;
          paramString1.troopuin = ((String)localObject1);
        }
      }
      if ((paramString1 != null) && ((!TextUtils.equals(paramString3, paramString1.honorList)) || (a(paramLong, paramString1.lastMsgUpdateHonorRichTime, paramByte, paramString1.mHonorRichFlag))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopHonor.manager", 2, String.format("updateTroopMemberHonor troopUin: %s, memberUin: %s, newHonorList: %s, oldHonorList: %s", new Object[] { localObject1, paramString2, paramString3, paramString1.honorList }));
        }
        paramString1.honorList = paramString3;
        if (((paramByte != -96) && (paramLong == -101L)) || (paramLong > paramString1.lastMsgUpdateHonorRichTime))
        {
          paramString1.mHonorRichFlag = paramByte;
          paramString1.lastMsgUpdateHonorRichTime = paramLong;
        }
        if (paramString1.getStatus() == 1000) {
          localITroopMemberInfoService.saveTroopMemberInfoInLruCache((String)localObject1, paramString2, paramString1);
        }
        localITroopMemberInfoService.saveTroopMemberInfoToDB((String)localObject1, paramString2, paramString1);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
    TroopInfo localTroopInfo = localITroopInfoService.getTroopInfo(paramString);
    if (localTroopInfo == null)
    {
      QLog.d("TroopHonor.manager", 1, "updateTroopHonorAIOSwitch troopInfo is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.manager", 2, String.format("updateTroopHonorAIOSwitch, troopUin: %s, isOpen: %s, old: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(localTroopInfo.isTroopHonorOpen()) }));
    }
    if ((localTroopInfo.isTroopHonorOpen() ^ paramBoolean))
    {
      if (paramBoolean) {
        localTroopInfo.dwGroupFlagExt3 &= 0xFDFFFFFF;
      } else {
        localTroopInfo.dwGroupFlagExt3 |= 0x2000000;
      }
      localITroopInfoService.saveTroopInfo(localTroopInfo);
      ((ITroopListHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(jdField_a_of_type_JavaLangString)).a(TroopObserver.TYPE_NOTIFY_UPDATE_RECENT_LIST, true, null);
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
              break label263;
            }
            paramArrayOfByte = localUserHonor.id.get();
            a(paramString, str, TroopHonorUtils.a(paramArrayOfByte), TroopHonorUtils.a(localUserHonor.rich_flag));
            if ((!TextUtils.isEmpty(str)) && (str.equals(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin()))) {
              ((ITroopListHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(jdField_a_of_type_JavaLangString)).a(TroopObserver.TYPE_NOTIFY_UPDATE_RECENT_LIST, true, new Object[] { paramString, str });
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
      label263:
      paramArrayOfByte = null;
    }
  }
  
  public void a(List<oidb_0xdc9.HonorList> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      StringBuilder localStringBuilder = new StringBuilder();
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
        int i;
        if (((oidb_0xdc9.HonorList)localObject).is_gray.has()) {
          i = ((oidb_0xdc9.HonorList)localObject).is_gray.get();
        } else {
          i = 0;
        }
        localObject = ((oidb_0xdc9.HonorList)localObject).id.get();
        String str3 = TroopHonorUtils.a((List)localObject);
        localStringBuilder.append(str2);
        localStringBuilder.append(": ");
        localStringBuilder.append(str3);
        localStringBuilder.append("\n");
        if (!TextUtils.isEmpty(str2))
        {
          a(paramBoolean, str2, i, str3);
          a(paramBoolean, str1, str2, (List)localObject, str3);
        }
        else
        {
          QLog.d("TroopHonor.manager", 1, String.format("updateHostHonorList| troopUin is empty", new Object[0]));
        }
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("updateHostHonorList, ");
        paramList.append(localStringBuilder.toString());
        QLog.d("TroopHonor.manager", 2, paramList.toString());
      }
      return;
    }
    QLog.d("TroopHonor.manager", 1, "updateHostHonorList| honorList is empty!");
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
    boolean bool = false;
    if (paramByte1 == paramByte2) {
      return false;
    }
    if ((paramLong1 == -101L) || (paramLong1 > paramLong2)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(Entity paramEntity)
  {
    int i = paramEntity.getStatus();
    boolean bool = false;
    if (i == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
      return bool;
    }
    if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
  }
  
  public boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig;
    boolean bool = true;
    int i;
    if ((localObject != null) && (((TroopHonorConfig)localObject).jdField_a_of_type_Boolean)) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = (ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
    if (i == 0)
    {
      paramString = ((ITroopInfoService)localObject).getTroopInfo(paramString);
      if ((paramString != null) && (paramString.troopHonorGrayFlag == 1)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean b(String paramString)
  {
    TroopHonorConfig localTroopHonorConfig = this.jdField_a_of_type_ComTencentMobileqqTroopHonorConfigTroopHonorConfig;
    boolean bool1;
    if ((localTroopHonorConfig != null) && (localTroopHonorConfig.jdField_a_of_type_Boolean)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramString = ((ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString);
    boolean bool2;
    if ((!bool1) && (paramString != null) && (paramString.troopHonorGrayFlag == 1)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if ((paramString != null) && ((paramString.dwGroupFlagExt3 & 0x2000000) == 0L)) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    paramString = (ISimpleUIUtil)QRoute.api(ISimpleUIUtil.class);
    boolean bool4;
    if (paramString != null) {
      bool4 = paramString.getSimpleUISwitch();
    } else {
      bool4 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.manager", 2, String.format("isSupportTroopHonor, isGlobalOpen: %s, isGrayTroop: %s, isAIOOpen: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) }));
    }
    paramString = ((IProfileDataService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), true);
    boolean bool5;
    if (paramString != null) {
      bool5 = paramString.troopHonorSwitch;
    } else {
      bool5 = false;
    }
    return ((bool1) || (bool2)) && (bool3) && (!bool4) && (bool5);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.TroopHonorManager
 * JD-Core Version:    0.7.0.1
 */