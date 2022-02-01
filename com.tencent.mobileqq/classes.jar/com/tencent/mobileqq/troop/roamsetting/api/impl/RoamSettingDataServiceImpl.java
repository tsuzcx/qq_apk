package com.tencent.mobileqq.troop.roamsetting.api.impl;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingDataService;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;

public class RoamSettingDataServiceImpl
  implements IRoamSettingDataService
{
  public static final String TAG = "RoamSettingDataServiceImpl";
  protected AppInterface app = null;
  EntityManager em;
  Lock lock;
  boolean mIsLoadDb = false;
  QQHashMap<String, RoamSetting> mSettingCache;
  QQHashMap<String, RoamSetting> mTroopSettingCache;
  RoamSetting tagRevision;
  
  private boolean isTroopRoamSettingLegal(String paramString)
  {
    boolean bool = false;
    try
    {
      int i = Integer.parseInt(paramString);
      if ((i == -2) || (i == -1) || (i == 1) || (i == 2) || (i == 3) || (i == 4)) {
        bool = true;
      }
      return bool;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label42:
      StringBuilder localStringBuilder;
      break label42;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("");
    QLog.e("RoamSettingDataServiceImpl", 1, localStringBuilder.toString());
    return false;
  }
  
  boolean deleteEntity(Entity paramEntity)
  {
    if (this.em.isOpen()) {
      return this.em.remove(paramEntity);
    }
    return false;
  }
  
  public void deleteRoamSetting(String paramString)
  {
    RoamSetting localRoamSetting = findRoamSetting(paramString);
    if ((localRoamSetting != null) && (localRoamSetting.path != null))
    {
      if (localRoamSetting.value == null) {
        return;
      }
      this.lock.lock();
      try
      {
        if (((RoamSettingServiceImpl)this.app.getRuntimeService(IRoamSettingService.class, "")).getGeneralSettingType(paramString) == 1) {
          this.mTroopSettingCache.remove(localRoamSetting.path);
        } else {
          this.mSettingCache.remove(localRoamSetting.path);
        }
        this.lock.unlock();
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
          ThreadManager.post(new RoamSettingDataServiceImpl.3(this, localRoamSetting), 5, null, false);
          return;
        }
        deleteEntity(localRoamSetting);
        return;
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
  
  public RoamSetting findRoamSetting(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    this.lock.lock();
    try
    {
      int i = ((RoamSettingServiceImpl)this.app.getRuntimeService(IRoamSettingService.class, "")).getGeneralSettingType(paramString);
      RoamSetting localRoamSetting;
      if (i == 1) {
        localRoamSetting = (RoamSetting)this.mTroopSettingCache.get(paramString);
      } else {
        localRoamSetting = (RoamSetting)this.mSettingCache.get(paramString);
      }
      Object localObject = localRoamSetting;
      if (localRoamSetting == null)
      {
        localObject = localRoamSetting;
        if (!this.mIsLoadDb)
        {
          paramString = (RoamSetting)this.em.find(RoamSetting.class, paramString);
          localObject = paramString;
          if (paramString != null)
          {
            localObject = paramString;
            if (paramString.path != null)
            {
              localObject = paramString;
              if (paramString.value != null) {
                if (i == 1)
                {
                  this.mTroopSettingCache.put(paramString.path, paramString);
                  localObject = paramString;
                }
                else
                {
                  this.mSettingCache.put(paramString.path, paramString);
                  localObject = paramString;
                }
              }
            }
          }
        }
      }
      return localObject;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public int getRevision()
  {
    if (this.tagRevision == null) {
      this.tagRevision = ((RoamSetting)this.em.find(RoamSetting.class, "setting_revision"));
    }
    Object localObject = this.tagRevision;
    if (localObject == null) {
      return 0;
    }
    if (((RoamSetting)localObject).value == null)
    {
      this.tagRevision = null;
      return 0;
    }
    try
    {
      int i = Integer.parseInt(this.tagRevision.value);
      return i;
    }
    catch (Exception localException)
    {
      label63:
      break label63;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse revision.value exception, revision.value=");
      ((StringBuilder)localObject).append(this.tagRevision.value);
      QLog.d("RoamSettingDataServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    return 0;
  }
  
  public int getRoamSettingValue(String paramString, int paramInt)
  {
    RoamSetting localRoamSetting2 = findRoamSetting(paramString);
    RoamSetting localRoamSetting1 = localRoamSetting2;
    if (localRoamSetting2 == null)
    {
      localRoamSetting1 = localRoamSetting2;
      if (!TextUtils.isEmpty(paramString))
      {
        localRoamSetting1 = new RoamSetting(paramString, Integer.toString(paramInt));
        saveRoamSetting(localRoamSetting1);
      }
    }
    return RoamSetting.getIntValue(localRoamSetting1, paramInt);
  }
  
  public void init()
  {
    ThreadManager.post(new RoamSettingDataServiceImpl.1(this), 8, null, false);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((AppInterface)paramAppRuntime);
    this.em = this.app.getEntityManagerFactory().createEntityManager();
    this.mSettingCache = new QQHashMap(1003, 0, 60);
    this.mTroopSettingCache = new QQHashMap(1004, 0, 60);
    this.lock = new ReentrantLock();
    init();
  }
  
  public void onDestroy()
  {
    Object localObject = this.mTroopSettingCache;
    if (localObject != null) {
      ((QQHashMap)localObject).clear();
    }
    localObject = this.mSettingCache;
    if (localObject != null) {
      ((QQHashMap)localObject).clear();
    }
    localObject = this.em;
    if ((localObject != null) && (((EntityManager)localObject).isOpen())) {
      this.em.close();
    }
  }
  
  public RoamSetting saveRoamSetting(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return null;
      }
      RoamSetting localRoamSetting = findRoamSetting(paramString1);
      if (localRoamSetting == null)
      {
        localRoamSetting = new RoamSetting(paramString1, paramString2);
      }
      else
      {
        if (paramString2.equals(localRoamSetting.value)) {
          return null;
        }
        localRoamSetting.value = paramString2;
      }
      this.lock.lock();
      try
      {
        if (((RoamSettingServiceImpl)this.app.getRuntimeService(IRoamSettingService.class, "")).getGeneralSettingType(paramString1) == 1)
        {
          if (isTroopRoamSettingLegal(paramString2))
          {
            this.mTroopSettingCache.put(localRoamSetting.path, localRoamSetting);
          }
          else if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("isTroopRoamSettingLegal false. path:");
            localStringBuilder.append(paramString1);
            localStringBuilder.append(", value:");
            localStringBuilder.append(paramString2);
            QLog.e("RoamSettingDataServiceImpl", 2, localStringBuilder.toString());
          }
        }
        else {
          this.mSettingCache.put(localRoamSetting.path, localRoamSetting);
        }
        return localRoamSetting;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    return null;
  }
  
  public void saveRoamSetting(RoamSetting paramRoamSetting)
  {
    int j;
    if ((paramRoamSetting != null) && (paramRoamSetting.path != null))
    {
      if (paramRoamSetting.value == null) {
        return;
      }
      j = ((RoamSettingServiceImpl)this.app.getRuntimeService(IRoamSettingService.class, "")).getGeneralSettingType(paramRoamSetting.path);
      this.lock.lock();
      if (j != 1) {}
    }
    for (;;)
    {
      try
      {
        if (isTroopRoamSettingLegal(paramRoamSetting.value))
        {
          this.mTroopSettingCache.put(paramRoamSetting.path, paramRoamSetting);
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label227;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isTroopRoamSettingLegal false. path:");
          localStringBuilder.append(paramRoamSetting.path);
          localStringBuilder.append(", value:");
          localStringBuilder.append(paramRoamSetting.value);
          QLog.e("RoamSettingDataServiceImpl", 2, localStringBuilder.toString());
          break label227;
          this.mSettingCache.put(paramRoamSetting.path, paramRoamSetting);
        }
        i = 1;
        this.lock.unlock();
        if ((j == 1) && (i == 0)) {
          return;
        }
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          updateEntity(paramRoamSetting);
          return;
        }
        ThreadManagerV2.excute(new RoamSettingDataServiceImpl.2(this, paramRoamSetting), 32, null, false);
        return;
      }
      finally
      {
        this.lock.unlock();
      }
      return;
      label227:
      int i = 0;
    }
  }
  
  /* Error */
  public void saveRoamSettingToDB(java.util.List<RoamSetting> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 66	com/tencent/mobileqq/troop/roamsetting/api/impl/RoamSettingDataServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   9: invokevirtual 263	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   12: astore 5
    //   14: aload 5
    //   16: astore 4
    //   18: aload 5
    //   20: astore_3
    //   21: aload 5
    //   23: invokevirtual 268	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   26: aload_1
    //   27: ifnull +51 -> 78
    //   30: iconst_0
    //   31: istore_2
    //   32: aload 5
    //   34: astore 4
    //   36: aload 5
    //   38: astore_3
    //   39: iload_2
    //   40: aload_1
    //   41: invokeinterface 273 1 0
    //   46: if_icmpge +32 -> 78
    //   49: aload 5
    //   51: astore 4
    //   53: aload 5
    //   55: astore_3
    //   56: aload_0
    //   57: aload_1
    //   58: iload_2
    //   59: invokeinterface 276 2 0
    //   64: checkcast 278	com/tencent/mobileqq/persistence/Entity
    //   67: invokevirtual 249	com/tencent/mobileqq/troop/roamsetting/api/impl/RoamSettingDataServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   70: pop
    //   71: iload_2
    //   72: iconst_1
    //   73: iadd
    //   74: istore_2
    //   75: goto -43 -> 32
    //   78: aload 5
    //   80: astore 4
    //   82: aload 5
    //   84: astore_3
    //   85: aload 5
    //   87: invokevirtual 281	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   90: aload 5
    //   92: ifnull +89 -> 181
    //   95: aload 5
    //   97: astore_3
    //   98: goto +79 -> 177
    //   101: astore_1
    //   102: goto +80 -> 182
    //   105: astore_1
    //   106: aload_3
    //   107: astore 4
    //   109: aload_1
    //   110: invokevirtual 284	java/lang/Exception:printStackTrace	()V
    //   113: aload_3
    //   114: astore 4
    //   116: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +54 -> 173
    //   122: aload_3
    //   123: astore 4
    //   125: new 45	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   132: astore 5
    //   134: aload_3
    //   135: astore 4
    //   137: aload 5
    //   139: ldc_w 286
    //   142: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_3
    //   147: astore 4
    //   149: aload 5
    //   151: aload_1
    //   152: invokevirtual 289	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   155: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_3
    //   160: astore 4
    //   162: ldc 10
    //   164: iconst_2
    //   165: aload 5
    //   167: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 292	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_3
    //   174: ifnull +7 -> 181
    //   177: aload_3
    //   178: invokevirtual 295	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   181: return
    //   182: aload 4
    //   184: ifnull +8 -> 192
    //   187: aload 4
    //   189: invokevirtual 295	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   192: goto +5 -> 197
    //   195: aload_1
    //   196: athrow
    //   197: goto -2 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	RoamSettingDataServiceImpl
    //   0	200	1	paramList	java.util.List<RoamSetting>
    //   31	44	2	i	int
    //   1	177	3	localObject1	Object
    //   3	185	4	localObject2	Object
    //   12	154	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	14	101	finally
    //   21	26	101	finally
    //   39	49	101	finally
    //   56	71	101	finally
    //   85	90	101	finally
    //   109	113	101	finally
    //   116	122	101	finally
    //   125	134	101	finally
    //   137	146	101	finally
    //   149	159	101	finally
    //   162	173	101	finally
    //   5	14	105	java/lang/Exception
    //   21	26	105	java/lang/Exception
    //   39	49	105	java/lang/Exception
    //   56	71	105	java/lang/Exception
    //   85	90	105	java/lang/Exception
  }
  
  public void setRevision(int paramInt)
  {
    Object localObject;
    if (this.tagRevision != null)
    {
      localObject = Integer.toString(paramInt);
      if (((String)localObject).equals(this.tagRevision.value)) {
        return;
      }
      this.tagRevision.value = ((String)localObject);
    }
    else
    {
      localObject = new RoamSetting();
      ((RoamSetting)localObject).path = "setting_revision";
      ((RoamSetting)localObject).value = Integer.toString(paramInt);
      this.tagRevision = ((RoamSetting)localObject);
    }
    updateEntity(this.tagRevision);
  }
  
  boolean updateEntity(Entity paramEntity)
  {
    boolean bool2 = this.em.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.em.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.em.update(paramEntity);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.roamsetting.api.impl.RoamSettingDataServiceImpl
 * JD-Core Version:    0.7.0.1
 */