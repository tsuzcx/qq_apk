package com.tencent.mobileqq.troop.entereffect.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IAnonymousChatApi;
import com.tencent.mobileqq.troop.api.ITroopEnterEffectApi;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig.EffectInfo;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig.EffectInfoData;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService.EntranceStatus;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import tencent.qun.group_effect.group_effect_commu.TGetMyEffectRsp0x2;

public class TroopEnterEffectServiceImpl
  implements ITroopEnterEffectService
{
  private static final String SP_NAME = "troop_enter_effect_";
  public int effectId;
  public int groupLevel;
  private AtomicBoolean hasConfigInited = new AtomicBoolean(false);
  protected AppRuntime mApp;
  protected TroopEnterEffectConfig mEffectConfig;
  protected SparseArray<String> mEffectNameMap = new SparseArray();
  protected HashMap<String, ITroopEnterEffectService.EntranceStatus> mEntranceStatusMap = new HashMap();
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  private HashMap<String, Long> mLastNotifyTimeMap = new HashMap();
  public long mNotifyInterval;
  protected ConcurrentHashMap<String, List<TroopEnterEffectData>> mTroopEnterEffectDatas = new ConcurrentHashMap();
  public int setMode;
  public int svipLevel;
  public int svipType;
  private long todayStartTime;
  
  private TroopEnterEffectConfig.EffectInfo readEffectInfo()
  {
    Object localObject1 = BaseApplication.getContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("troop_enter_effect_config_");
    ((StringBuilder)localObject2).append(this.mApp.getCurrentAccountUin());
    localObject2 = FileUtils.fileToBytes(((BaseApplication)localObject1).getFileStreamPath(((StringBuilder)localObject2).toString()));
    if (localObject2 != null)
    {
      localObject1 = new group_effect_commu.TGetMyEffectRsp0x2();
      try
      {
        ((group_effect_commu.TGetMyEffectRsp0x2)localObject1).mergeFrom((byte[])localObject2);
        localObject2 = new TroopEnterEffectConfig.EffectInfo();
        ((TroopEnterEffectConfig.EffectInfo)localObject2).a((group_effect_commu.TGetMyEffectRsp0x2)localObject1);
        return localObject2;
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("readEffectInfo error: ");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.e("TroopEnterEffect", 1, ((StringBuilder)localObject2).toString());
      }
    }
    return null;
  }
  
  public void addTroopEnterEffectData(TroopEnterEffectData paramTroopEnterEffectData)
  {
    if ((paramTroopEnterEffectData != null) && (!TextUtils.isEmpty(paramTroopEnterEffectData.b)))
    {
      List localList2 = (List)this.mTroopEnterEffectDatas.get(paramTroopEnterEffectData.b);
      List localList1 = localList2;
      if (localList2 == null)
      {
        localList1 = Collections.synchronizedList(new LinkedList());
        this.mTroopEnterEffectDatas.put(paramTroopEnterEffectData.b, localList1);
      }
      if (paramTroopEnterEffectData.jdField_a_of_type_JavaLangString.equals(this.mApp.getCurrentAccountUin()))
      {
        localList1.add(0, paramTroopEnterEffectData);
        return;
      }
      localList1.add(paramTroopEnterEffectData);
    }
  }
  
  public TroopEnterEffectConfig.EffectInfo getAllEffectInfo()
  {
    return this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo;
  }
  
  public int getEffectId()
  {
    return this.effectId;
  }
  
  public int getEffectId(String paramString)
  {
    if (this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo != null)
    {
      paramString = (TroopEnterEffectConfig.EffectInfoData)this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        return paramString.jdField_a_of_type_Int;
      }
    }
    return 0;
  }
  
  public TroopEnterEffectConfig.EffectInfoData getEffectInfo(String paramString)
  {
    if (this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo != null) {
      return (TroopEnterEffectConfig.EffectInfoData)this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public TroopEnterEffectData getFirstEffectData(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = (List)this.mTroopEnterEffectDatas.get(paramString);
      if ((paramString != null) && (!paramString.isEmpty())) {
        return (TroopEnterEffectData)paramString.get(0);
      }
    }
    return null;
  }
  
  public int getGroupLevel()
  {
    return this.groupLevel;
  }
  
  public int getMode()
  {
    return this.setMode;
  }
  
  public long getNotifyInterval()
  {
    return this.mNotifyInterval;
  }
  
  public SharedPreferences getSharedPreferences()
  {
    MobileQQ localMobileQQ = this.mApp.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_enter_effect_");
    localStringBuilder.append(this.mApp.getCurrentAccountUin());
    return localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public int getSvipLevel()
  {
    return this.svipLevel;
  }
  
  public int getSvipType()
  {
    return this.svipType;
  }
  
  public TroopEnterEffectConfig getTroopEnterEffectConfig()
  {
    try
    {
      if (!this.hasConfigInited.get()) {
        readEffectConfigData(true);
      }
      TroopEnterEffectConfig localTroopEnterEffectConfig = this.mEffectConfig;
      return localTroopEnterEffectConfig;
    }
    finally {}
  }
  
  public boolean hasSetEffect(String paramString)
  {
    TroopEnterEffectConfig.EffectInfo localEffectInfo = this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localEffectInfo != null)
    {
      paramString = (TroopEnterEffectConfig.EffectInfoData)this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.b <= 0)
      {
        bool1 = bool2;
        if (paramString != null)
        {
          bool1 = bool2;
          if (paramString.jdField_a_of_type_Int <= 0) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean hasShowGrayTipsToday()
  {
    long l1 = getSharedPreferences().getLong("show_gray_tips_time", 0L);
    boolean bool = false;
    if (l1 == 0L) {
      return false;
    }
    if (this.todayStartTime == 0L)
    {
      long l2 = System.currentTimeMillis();
      this.todayStartTime = (l2 - l2 % 86400000L);
    }
    if (l1 - l1 % 86400000L == this.todayStartTime) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isAllTroopShowEnterance()
  {
    return getTroopEnterEffectConfig().jdField_a_of_type_Boolean;
  }
  
  public boolean isEffectOn(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (!bool2)
    {
      Object localObject;
      if ((this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo != null) && (this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null))
      {
        localObject = (TroopEnterEffectConfig.EffectInfoData)this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if (localObject == null)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("isEffectOn troopUin = ");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(" globalEffectId = ");
            ((StringBuilder)localObject).append(this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.b);
            QLog.d("TroopEnterEffect", 2, ((StringBuilder)localObject).toString());
          }
          if (this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.b > 0) {
            bool1 = true;
          }
          return bool1;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isEffectOn troopUin = ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" isOn = ");
          localStringBuilder.append(((TroopEnterEffectConfig.EffectInfoData)localObject).jdField_a_of_type_Boolean);
          QLog.d("TroopEnterEffect", 2, localStringBuilder.toString());
        }
        return ((TroopEnterEffectConfig.EffectInfoData)localObject).jdField_a_of_type_Boolean;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isEffectOn troopUin = ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" effectInfo is Empty");
        QLog.d("TroopEnterEffect", 2, ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  public void notifyEnterTroop(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyEnterTroop troopUin: ");
      localStringBuilder.append(paramString);
      QLog.d("TroopEnterEffect", 2, localStringBuilder.toString());
    }
    if (!this.hasConfigInited.get())
    {
      ThreadManager.post(new TroopEnterEffectServiceImpl.1(this, paramString), 8, null, true);
      return;
    }
    if (!this.mEffectConfig.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect", 2, "notifyEnterTroop function not enable");
      }
      return;
    }
    if (!isEffectOn(paramString)) {
      return;
    }
    if (((IAnonymousChatApi)QRoute.api(IAnonymousChatApi.class)).getAioAnonymousStatus(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect", 2, "notifyEnterTroop is Anonymous");
      }
      return;
    }
    long l = 0L;
    if (this.mLastNotifyTimeMap.containsKey(paramString)) {
      l = ((Long)this.mLastNotifyTimeMap.get(paramString)).longValue();
    }
    if (l + this.mNotifyInterval < System.currentTimeMillis()) {}
    try
    {
      l = Long.parseLong(paramString);
      ((ITroopEnterEffectApi)QRoute.api(ITroopEnterEffectApi.class)).sendTroopEnterEffectCMD(this.mApp, 8192L, l);
      this.mLastNotifyTimeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      return;
    }
    catch (NumberFormatException paramString)
    {
      label222:
      break label222;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("TroopEnterEffect", 2, "notifyEnterTroop parseLong error");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect", 2, "notifyEnterTroop in time interval");
      }
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mEffectConfig = new TroopEnterEffectConfig();
    requestVIPInfo();
  }
  
  public void onDestroy()
  {
    this.mHandler.removeCallbacksAndMessages(null);
    this.mEntranceStatusMap.clear();
  }
  
  public void readEffectConfigData(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "readEffectConfigData start");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.mApp.getApplication().getFilesDir());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("groupeffect_config.json");
    localObject = ((StringBuilder)localObject).toString();
    localObject = VasUpdateUtil.a(this.mApp, 1000L, "groupeffect_config.json", (String)localObject, paramBoolean, null);
    if (localObject != null)
    {
      localObject = FileUtils.readFileToStringEx((File)localObject, -1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.mEffectConfig.a((String)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect", 2, "readEffectConfigData success");
      }
      this.mEffectConfig.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    updateEffectInfo(readEffectInfo());
    this.hasConfigInited.set(true);
  }
  
  public void removeAllEffectDatas(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = (List)this.mTroopEnterEffectDatas.get(paramString);
      if (paramString != null) {
        paramString.clear();
      }
    }
  }
  
  public void removeEnterEffectData(TroopEnterEffectData paramTroopEnterEffectData)
  {
    if ((paramTroopEnterEffectData != null) && (!TextUtils.isEmpty(paramTroopEnterEffectData.b)))
    {
      List localList = (List)this.mTroopEnterEffectDatas.get(paramTroopEnterEffectData.b);
      if (localList != null) {
        localList.remove(paramTroopEnterEffectData);
      }
    }
  }
  
  public void report(String paramString1, String paramString2, String... paramVarArgs)
  {
    int i = paramVarArgs.length;
    String str4 = "";
    String str1;
    if (i > 0) {
      str1 = paramVarArgs[0];
    } else {
      str1 = "";
    }
    String str2;
    if (paramVarArgs.length > 1) {
      str2 = paramVarArgs[1];
    } else {
      str2 = "";
    }
    String str3;
    if (paramVarArgs.length > 2) {
      str3 = paramVarArgs[2];
    } else {
      str3 = "";
    }
    if (paramVarArgs.length > 3) {
      str4 = paramVarArgs[3];
    }
    ReportController.b(null, "dc00899", "Grp_action", "", paramString1, paramString2, 0, 0, str1, str2, str3, str4);
  }
  
  protected void requestVIPInfo()
  {
    Object localObject = this.mApp.getApplication().getApplicationContext().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0);
    long l = ((SharedPreferences)localObject).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l <= i * 60) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "updateVipInfo");
    }
    localObject = this.mApp.getCurrentAccountUin();
    String str = ((TicketManager)this.mApp.getManager(2)).getSkey((String)localObject);
    ((ITroopEnterEffectApi)QRoute.api(ITroopEnterEffectApi.class)).sendGetBaseVipInfoReq(this.mApp, str, (String)localObject);
  }
  
  public void saveEffectConfigData(group_effect_commu.TGetMyEffectRsp0x2 paramTGetMyEffectRsp0x2)
  {
    paramTGetMyEffectRsp0x2 = new TroopEnterEffectServiceImpl.2(this, paramTGetMyEffectRsp0x2);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(paramTGetMyEffectRsp0x2, 5, null, true);
      return;
    }
    paramTGetMyEffectRsp0x2.run();
  }
  
  public void setGroupLevel(int paramInt)
  {
    this.groupLevel = paramInt;
  }
  
  public void setMode(int paramInt)
  {
    this.setMode = paramInt;
  }
  
  public void setNotifyInterval(long paramLong)
  {
    this.mNotifyInterval = paramLong;
  }
  
  public void setSvipLevel(int paramInt)
  {
    this.svipLevel = paramInt;
  }
  
  public void setSvipType(int paramInt)
  {
    this.svipType = paramInt;
  }
  
  public void updateEffectInfo(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.setMode = 8;
    this.svipLevel = paramInt2;
    this.svipType = paramInt3;
    this.effectId = paramInt1;
    Object localObject = this.mEffectConfig;
    if ((localObject != null) && (((TroopEnterEffectConfig)localObject).jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo != null) && (this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null))
    {
      if ((TroopEnterEffectConfig.EffectInfoData)this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong)) == null)
      {
        this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(paramLong), new TroopEnterEffectConfig.EffectInfoData(paramLong, paramInt1, paramString));
      }
      else
      {
        localObject = this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          TroopEnterEffectConfig.EffectInfoData localEffectInfoData = (TroopEnterEffectConfig.EffectInfoData)((Map.Entry)((Iterator)localObject).next()).getValue();
          localEffectInfoData.jdField_a_of_type_Int = paramInt1;
          localEffectInfoData.jdField_a_of_type_JavaLangString = paramString;
          localEffectInfoData.jdField_a_of_type_Long = paramLong;
        }
      }
      saveEffectConfigData(this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.a());
    }
  }
  
  public void updateEffectInfo(TroopEnterEffectConfig.EffectInfo paramEffectInfo)
  {
    this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo = paramEffectInfo;
  }
  
  public void updateEffectStatus(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateEffectStatus size = ");
      ((StringBuilder)localObject1).append(paramArrayList.size());
      QLog.d("TroopEnterEffect", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.mEffectConfig;
    if ((localObject1 != null) && (((TroopEnterEffectConfig)localObject1).jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo != null))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        paramArrayList = ((String)localIterator.next()).split(",");
        if (paramArrayList.length == 2)
        {
          Object localObject2 = paramArrayList[0];
          Object localObject3 = paramArrayList[1];
          localObject1 = (TroopEnterEffectConfig.EffectInfoData)this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
          paramArrayList = (ArrayList<String>)localObject1;
          if (localObject1 == null) {
            paramArrayList = new TroopEnterEffectConfig.EffectInfoData();
          }
          if (localObject3.equals("1"))
          {
            paramArrayList.jdField_a_of_type_Boolean = false;
            this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, paramArrayList);
            if (QLog.isColorLevel())
            {
              paramArrayList = new StringBuilder();
              paramArrayList.append("updateEffectStatus off group uin = ");
              paramArrayList.append(localObject2);
              QLog.d("TroopEnterEffect", 2, paramArrayList.toString());
            }
          }
          else if (localObject3.equals("0"))
          {
            if (this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.b > 0)
            {
              this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject2);
              if (QLog.isColorLevel())
              {
                paramArrayList = new StringBuilder();
                paramArrayList.append("updateEffectStatus on group uin = ");
                paramArrayList.append(localObject2);
                paramArrayList.append(" has globaleffect remove infodata");
                QLog.d("TroopEnterEffect", 2, paramArrayList.toString());
              }
            }
            else
            {
              paramArrayList.jdField_a_of_type_Boolean = true;
              this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, paramArrayList);
              if (QLog.isColorLevel())
              {
                paramArrayList = new StringBuilder();
                paramArrayList.append("updateEffectStatus on group uin = ");
                paramArrayList.append(localObject2);
                paramArrayList.append(" not has globaleffect update infoData");
                QLog.d("TroopEnterEffect", 2, paramArrayList.toString());
              }
            }
          }
        }
      }
      saveEffectConfigData(this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.a());
    }
  }
  
  public void updateGlobalEffectInfo(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateGlobalEffectInfo: effectId = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" effectName = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" svipLevel = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" svipType = ");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.d("TroopEnterEffect", 2, ((StringBuilder)localObject).toString());
    }
    this.setMode = 8;
    this.svipLevel = paramInt2;
    this.svipType = paramInt3;
    this.effectId = paramInt1;
    Object localObject = this.mEffectConfig;
    if ((localObject != null) && (((TroopEnterEffectConfig)localObject).jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo != null))
    {
      this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.b = paramInt1;
      this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaLangString = paramString;
      saveEffectConfigData(this.mEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectConfig$EffectInfo.a());
    }
  }
  
  public void updateNoLongerShowTips(String paramString)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gray_tips_no_longer_");
    localStringBuilder.append(paramString);
    localEditor.putBoolean(localStringBuilder.toString(), true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.api.impl.TroopEnterEffectServiceImpl
 * JD-Core Version:    0.7.0.1
 */