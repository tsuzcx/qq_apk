package com.tencent.mobileqq.troop.roamsetting.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.config.RoamSettingProcessorConfig;
import com.tencent.mobileqq.troop.roamsetting.IReqGetSettingsHandler;
import com.tencent.mobileqq.troop.roamsetting.ReqGetSettingsHandler;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingHandler;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingDataService;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;

public class RoamSettingServiceImpl
  implements IRoamSettingService
{
  public static final int RETRY_MAX = 3;
  public static final String TAG = "RoamSettingServiceImpl";
  public static final long TIME_DELAY = 45000L;
  protected AppInterface app = null;
  Lock lock;
  ConcurrentHashMap<String, Integer> mapNewValue = new ConcurrentHashMap();
  protected ConcurrentHashMap<String, Boolean> mapRequest = new ConcurrentHashMap();
  protected ConcurrentHashMap<String, Integer> mapUploading = new ConcurrentHashMap();
  boolean stateAllLoading = false;
  boolean stateNewValue = false;
  boolean stateReqUpgradeSettings = false;
  long timeAllLoading = 0L;
  int uploadTryCount = 0;
  
  private void clearUploading()
  {
    this.lock.lock();
    try
    {
      this.mapUploading.clear();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  private void copyNewValue2Uploading()
  {
    this.lock.lock();
    try
    {
      this.mapUploading.putAll(this.mapNewValue);
      this.mapNewValue.clear();
      this.stateNewValue = false;
      this.lock.unlock();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("copyNewValue2Uploading, change state_newValue=false, mapUploading:");
        localStringBuilder.append(this.mapUploading.toString());
        QLog.d("RoamSettingServiceImpl", 2, localStringBuilder.toString());
      }
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  private void revertUploading2NewValue()
  {
    this.lock.lock();
    try
    {
      Iterator localIterator = this.mapUploading.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (Integer)((Map.Entry)localObject2).getValue();
        if (!this.mapNewValue.containsKey(str)) {
          this.mapNewValue.put(str, Integer.valueOf(((Integer)localObject2).intValue()));
        }
      }
      this.mapUploading.clear();
      this.stateNewValue = true;
      this.lock.unlock();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public static String unMakeGeneralSettingsKey(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramInt == 1)
    {
      if (paramString.contains("message.group.policy."))
      {
        paramString = paramString.split("\\.");
        if ((paramString != null) && (paramString.length > 0)) {
          return paramString[(paramString.length - 1)];
        }
      }
      str = null;
    }
    return str;
  }
  
  private void uploadNewValue()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSettingServiceImpl", 2, "uploadNewValue...");
    }
    Object localObject = this.app;
    if ((localObject != null) && (((AppInterface)localObject).isRunning()))
    {
      if (this.stateAllLoading)
      {
        long l = this.timeAllLoading;
        if ((l > 0L) && (l + 45000L < System.currentTimeMillis()))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("uploadNewValue state_allLoading=");
            ((StringBuilder)localObject).append(this.stateAllLoading);
            ((StringBuilder)localObject).append(" more than 45s, forced to stop");
            QLog.d("RoamSettingServiceImpl", 2, ((StringBuilder)localObject).toString());
          }
          this.timeAllLoading = 0L;
          this.stateAllLoading = false;
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("uploadNewValue but return, state_allLoading=");
            ((StringBuilder)localObject).append(this.stateAllLoading);
            ((StringBuilder)localObject).append(", time_allLoading less than 60s, waitting...");
            QLog.d("RoamSettingServiceImpl", 2, ((StringBuilder)localObject).toString());
          }
          return;
        }
      }
      copyNewValue2Uploading();
      localObject = (RoamSettingHandler)this.app.getBusinessHandler(RoamSettingHandler.class.getName());
      if (localObject != null) {
        ((RoamSettingHandler)localObject).a(((RoamSettingDataServiceImpl)this.app.getRuntimeService(IRoamSettingDataService.class, "")).getRevision(), this.mapUploading);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uploadNewValue return directly, app.isRunning=");
      localObject = this.app;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Boolean.valueOf(((AppInterface)localObject).isRunning());
      }
      localStringBuilder.append(localObject);
      QLog.d("RoamSettingServiceImpl", 2, localStringBuilder.toString());
    }
  }
  
  public boolean enableRetry()
  {
    return this.uploadTryCount < 3;
  }
  
  public int getGeneralSettingType(String paramString)
  {
    return RoamSettingProcessorConfig.a().a(paramString);
  }
  
  public ConcurrentHashMap<String, Boolean> getMapRequest()
  {
    return this.mapRequest;
  }
  
  public ConcurrentHashMap<String, Integer> getMapUploading()
  {
    return this.mapUploading;
  }
  
  public IReqGetSettingsHandler getReqGetSettingsHandler()
  {
    return new ReqGetSettingsHandler(this.app);
  }
  
  public int getSettingValue(String paramString, int paramInt)
  {
    if (paramString == null) {
      return paramInt;
    }
    this.lock.lock();
    try
    {
      if (this.mapNewValue.containsKey(paramString))
      {
        paramInt = ((Integer)this.mapNewValue.get(paramString)).intValue();
        return paramInt;
      }
      if (this.mapUploading.containsKey(paramString))
      {
        paramInt = ((Integer)this.mapUploading.get(paramString)).intValue();
        return paramInt;
      }
      return ((RoamSettingDataServiceImpl)this.app.getRuntimeService(IRoamSettingDataService.class, "")).getRoamSettingValue(paramString, paramInt);
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public int getTroopMsgFilter(String paramString, int paramInt)
  {
    if (paramString == null) {
      return 1;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    return ((Integer)getTroopMsgFilterList(localArrayList, paramInt).get(paramString)).intValue();
  }
  
  /* Error */
  public Map<String, Integer> getTroopMsgFilterList(List<String> paramList, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +231 -> 232
    //   4: aload_1
    //   5: invokeinterface 283 1 0
    //   10: ifne +6 -> 16
    //   13: goto +219 -> 232
    //   16: ldc_w 285
    //   19: invokestatic 291	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   22: checkcast 285	com/tencent/mobileqq/troop/utils/api/IBizTroopDBUtilsApi
    //   25: aload_1
    //   26: iload_2
    //   27: aload_0
    //   28: getfield 39	com/tencent/mobileqq/troop/roamsetting/api/impl/RoamSettingServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   31: invokeinterface 294 4 0
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 62	com/tencent/mobileqq/troop/roamsetting/api/impl/RoamSettingServiceImpl:lock	Ljava/util/concurrent/locks/Lock;
    //   41: invokeinterface 66 1 0
    //   46: aload_1
    //   47: invokeinterface 295 1 0
    //   52: astore_1
    //   53: aload_1
    //   54: invokeinterface 117 1 0
    //   59: ifeq +151 -> 210
    //   62: aload_1
    //   63: invokeinterface 121 1 0
    //   68: checkcast 128	java/lang/String
    //   71: astore 4
    //   73: new 85	java/lang/StringBuilder
    //   76: dup
    //   77: bipush 40
    //   79: invokespecial 298	java/lang/StringBuilder:<init>	(I)V
    //   82: astore 5
    //   84: aload 5
    //   86: ldc 153
    //   88: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 5
    //   94: aload 4
    //   96: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 5
    //   102: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: astore 4
    //   107: aload_0
    //   108: getfield 54	com/tencent/mobileqq/troop/roamsetting/api/impl/RoamSettingServiceImpl:mapNewValue	Ljava/util/concurrent/ConcurrentHashMap;
    //   111: aload 4
    //   113: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   116: ifeq +33 -> 149
    //   119: aload_3
    //   120: aload 4
    //   122: aload_0
    //   123: getfield 54	com/tencent/mobileqq/troop/roamsetting/api/impl/RoamSettingServiceImpl:mapNewValue	Ljava/util/concurrent/ConcurrentHashMap;
    //   126: aload 4
    //   128: invokevirtual 259	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   131: checkcast 133	java/lang/Integer
    //   134: invokevirtual 141	java/lang/Integer:intValue	()I
    //   137: invokestatic 145	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: invokeinterface 299 3 0
    //   145: pop
    //   146: goto -93 -> 53
    //   149: aload_0
    //   150: getfield 52	com/tencent/mobileqq/troop/roamsetting/api/impl/RoamSettingServiceImpl:mapUploading	Ljava/util/concurrent/ConcurrentHashMap;
    //   153: aload 4
    //   155: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   158: ifeq -105 -> 53
    //   161: aload_3
    //   162: aload 4
    //   164: aload_0
    //   165: getfield 52	com/tencent/mobileqq/troop/roamsetting/api/impl/RoamSettingServiceImpl:mapUploading	Ljava/util/concurrent/ConcurrentHashMap;
    //   168: aload 4
    //   170: invokevirtual 259	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   173: checkcast 133	java/lang/Integer
    //   176: invokevirtual 141	java/lang/Integer:intValue	()I
    //   179: invokestatic 145	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   182: invokeinterface 299 3 0
    //   187: pop
    //   188: goto -135 -> 53
    //   191: astore_1
    //   192: goto +29 -> 221
    //   195: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +12 -> 210
    //   201: ldc 13
    //   203: iconst_2
    //   204: ldc_w 301
    //   207: invokestatic 304	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: aload_0
    //   211: getfield 62	com/tencent/mobileqq/troop/roamsetting/api/impl/RoamSettingServiceImpl:lock	Ljava/util/concurrent/locks/Lock;
    //   214: invokeinterface 72 1 0
    //   219: aload_3
    //   220: areturn
    //   221: aload_0
    //   222: getfield 62	com/tencent/mobileqq/troop/roamsetting/api/impl/RoamSettingServiceImpl:lock	Ljava/util/concurrent/locks/Lock;
    //   225: invokeinterface 72 1 0
    //   230: aload_1
    //   231: athrow
    //   232: new 306	java/util/HashMap
    //   235: dup
    //   236: invokespecial 307	java/util/HashMap:<init>	()V
    //   239: areturn
    //   240: astore_1
    //   241: goto -46 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	RoamSettingServiceImpl
    //   0	244	1	paramList	List<String>
    //   0	244	2	paramInt	int
    //   36	184	3	localMap	Map
    //   71	98	4	str	String
    //   82	19	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   46	53	191	finally
    //   53	146	191	finally
    //   149	188	191	finally
    //   195	210	191	finally
    //   46	53	240	java/lang/OutOfMemoryError
    //   53	146	240	java/lang/OutOfMemoryError
    //   149	188	240	java/lang/OutOfMemoryError
  }
  
  public void loadAllRoamSettings(boolean paramBoolean)
  {
    loadAllRoamSettings(paramBoolean, null);
  }
  
  public void loadAllRoamSettings(boolean paramBoolean, RoamSettingHandler paramRoamSettingHandler)
  {
    Object localObject = this.app;
    if ((localObject != null) && (((AppInterface)localObject).isRunning()))
    {
      if (this.stateAllLoading)
      {
        if (QLog.isColorLevel())
        {
          paramRoamSettingHandler = new StringBuilder();
          paramRoamSettingHandler.append("loadAllRoamSettings but return, state_allUpdating=");
          paramRoamSettingHandler.append(this.stateAllLoading);
          QLog.d("RoamSettingServiceImpl", 2, paramRoamSettingHandler.toString());
        }
        return;
      }
      this.stateAllLoading = true;
      int i = ((RoamSettingDataServiceImpl)this.app.getRuntimeService(IRoamSettingDataService.class, "")).getRevision();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadAllRoamSettings, localRevision=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" needTroopSettings=");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(" thread=");
        ((StringBuilder)localObject).append(Thread.currentThread().getName());
        QLog.d("RoamSettingServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      loadRoamSettingsByPage(i, 0L, -1, paramBoolean, paramRoamSettingHandler);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadAllRoamSetting return directly, app.isRunning=");
      paramRoamSettingHandler = this.app;
      if (paramRoamSettingHandler == null) {
        paramRoamSettingHandler = "null";
      } else {
        paramRoamSettingHandler = Boolean.valueOf(paramRoamSettingHandler.isRunning());
      }
      ((StringBuilder)localObject).append(paramRoamSettingHandler);
      QLog.d("RoamSettingServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void loadRoamSettingsByPage(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, RoamSettingHandler paramRoamSettingHandler)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadRoamSettingsByPage,localRevision=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" offset=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" respRevision=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" needTroopSettings=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" thread=");
      ((StringBuilder)localObject).append(Thread.currentThread().getName());
      QLog.d("RoamSettingServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramRoamSettingHandler;
    if (paramRoamSettingHandler == null) {
      localObject = (RoamSettingHandler)this.app.getBusinessHandler(RoamSettingHandler.class.getName());
    }
    ((RoamSettingHandler)localObject).a(paramInt1, paramLong, paramInt2, paramBoolean);
    this.timeAllLoading = System.currentTimeMillis();
  }
  
  public String makeGeneralSettingsKey(String paramString, int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("message.group.policy.");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = RoamSettingProcessorConfig.a().a(paramInt);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return paramString;
    }
    return localObject;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((AppInterface)paramAppRuntime);
    this.lock = new ReentrantLock();
  }
  
  public void onDestroy() {}
  
  public void onGetAllSettingsFinish(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetAllSettingsFinish isSucc=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" next=");
      localStringBuilder.append(paramBoolean2);
      QLog.d("RoamSettingServiceImpl", 2, localStringBuilder.toString());
    }
    this.stateAllLoading = false;
    this.timeAllLoading = 0L;
    if ((paramBoolean2) && (this.stateNewValue)) {
      uploadNewValue();
    }
  }
  
  public void onUploadRomingSettingsFinish(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUploadRomingSettingsFinish isSuccess=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" reload=");
      localStringBuilder.append(paramBoolean2);
      QLog.d("RoamSettingServiceImpl", 2, localStringBuilder.toString());
    }
    clearUploading();
    if ((paramBoolean1) && (paramBoolean2)) {
      loadAllRoamSettings(true, null);
    }
  }
  
  public void setRoamSettingNewValue(String paramString, Integer paramInteger)
  {
    this.stateNewValue = true;
    this.uploadTryCount = 0;
    this.lock.lock();
    try
    {
      this.mapNewValue.put(paramString, paramInteger);
      this.lock.unlock();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("state_newValue=");
        localStringBuilder.append(this.stateNewValue);
        localStringBuilder.append(" setRoamSettingNewValue, path=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" value=");
        localStringBuilder.append(paramInteger);
        localStringBuilder.append(" uploadingCount=");
        localStringBuilder.append(this.uploadTryCount);
        QLog.d("RoamSettingServiceImpl", 2, localStringBuilder.toString());
      }
      uploadNewValue();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.roamsetting.api.impl.RoamSettingServiceImpl
 * JD-Core Version:    0.7.0.1
 */