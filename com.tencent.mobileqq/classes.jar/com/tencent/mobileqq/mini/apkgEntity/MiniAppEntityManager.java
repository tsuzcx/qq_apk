package com.tencent.mobileqq.mini.apkgEntity;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class MiniAppEntityManager
  implements Manager
{
  private static final long APPINFO_DELETE_TIME = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_appinfoentity_interval_time", 172800000L);
  private static final long OTHER_DELETE_TIME = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_otherentity_interval_time", 345600000L);
  private static final String TAG = "MiniAppEntityManager";
  private EntityManager mEntityManager = this.miniAppEntityManagerFactory.createEntityManager();
  private MiniAppEntityManagerFactory miniAppEntityManagerFactory = getEntityManagerFactory(paramString);
  
  public MiniAppEntityManager(String paramString) {}
  
  private void deleteDbFile()
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject != null)
      {
        localObject = ((AppRuntime)localObject).getAccount();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          File localFile = BaseApplicationImpl.getContext().getDatabasePath("miniapp_" + (String)localObject + ".db");
          QLog.e("MiniAppEntityManager", 1, "deleteDbFile db : " + localFile.getPath());
          FileUtils.deleteFile(localFile.getPath());
          localFile = BaseApplicationImpl.getContext().getDatabasePath("miniapp_" + (String)localObject + ".db-journal");
          QLog.e("MiniAppEntityManager", 1, "deleteDbFile dbJournal : " + localFile.getPath());
          FileUtils.deleteFile(localFile.getPath());
          localFile = BaseApplicationImpl.getContext().getDatabasePath("miniapp_" + (String)localObject + ".db-wal");
          QLog.e("MiniAppEntityManager", 1, "deleteDbFile dbWal : " + localFile.getPath());
          FileUtils.deleteFile(localFile.getPath());
          localObject = BaseApplicationImpl.getContext().getDatabasePath("miniapp_" + (String)localObject + ".db-shm");
          QLog.e("MiniAppEntityManager", 1, "deleteDbFile dbShm : " + ((File)localObject).getPath());
          FileUtils.deleteFile(((File)localObject).getPath());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppEntityManager", 1, "deleteDbFile error,", localThrowable);
    }
  }
  
  private MiniAppEntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (paramString == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    if (this.miniAppEntityManagerFactory != null) {
      return this.miniAppEntityManagerFactory;
    }
    try
    {
      if (this.miniAppEntityManagerFactory == null)
      {
        paramString = new MiniAppEntityManagerFactory(paramString);
        ThreadManagerV2.excute(new MiniAppEntityManager.1(this, paramString), 32, null, true);
        this.miniAppEntityManagerFactory = paramString;
      }
      return this.miniAppEntityManagerFactory;
    }
    finally {}
  }
  
  /* Error */
  public void checkDB()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 168
    //   4: iconst_1
    //   5: ldc 169
    //   7: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10: invokestatic 178	java/lang/System:currentTimeMillis	()J
    //   13: getstatic 37	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:APPINFO_DELETE_TIME	J
    //   16: lsub
    //   17: lstore_1
    //   18: invokestatic 178	java/lang/System:currentTimeMillis	()J
    //   21: lstore_3
    //   22: getstatic 43	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:OTHER_DELETE_TIME	J
    //   25: lstore 5
    //   27: aload_0
    //   28: ldc 180
    //   30: iconst_2
    //   31: anewarray 4	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: ldc 182
    //   38: invokevirtual 187	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: lload_1
    //   45: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   48: aastore
    //   49: invokestatic 199	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: invokevirtual 202	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:execSQL	(Ljava/lang/String;)Z
    //   55: pop
    //   56: aload_0
    //   57: ldc 180
    //   59: iconst_2
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: ldc 204
    //   67: invokevirtual 187	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: lload_1
    //   74: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   77: aastore
    //   78: invokestatic 199	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   81: invokevirtual 202	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:execSQL	(Ljava/lang/String;)Z
    //   84: pop
    //   85: aload_0
    //   86: ldc 180
    //   88: iconst_2
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: ldc 206
    //   96: invokevirtual 187	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: lload_1
    //   103: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   106: aastore
    //   107: invokestatic 199	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   110: invokevirtual 202	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:execSQL	(Ljava/lang/String;)Z
    //   113: pop
    //   114: aload_0
    //   115: ldc 180
    //   117: iconst_2
    //   118: anewarray 4	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: ldc 208
    //   125: invokevirtual 187	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   128: aastore
    //   129: dup
    //   130: iconst_1
    //   131: lload_3
    //   132: lload 5
    //   134: lsub
    //   135: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   138: aastore
    //   139: invokestatic 199	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   142: invokevirtual 202	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:execSQL	(Ljava/lang/String;)Z
    //   145: pop
    //   146: aload_0
    //   147: ldc 180
    //   149: iconst_2
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: ldc 210
    //   157: invokevirtual 187	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: lload_1
    //   164: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   167: aastore
    //   168: invokestatic 199	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   171: invokevirtual 202	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:execSQL	(Ljava/lang/String;)Z
    //   174: pop
    //   175: aload_0
    //   176: ldc 180
    //   178: iconst_2
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: ldc 212
    //   186: invokevirtual 187	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   189: aastore
    //   190: dup
    //   191: iconst_1
    //   192: lload_1
    //   193: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   196: aastore
    //   197: invokestatic 199	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   200: invokevirtual 202	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:execSQL	(Ljava/lang/String;)Z
    //   203: pop
    //   204: aload_0
    //   205: monitorexit
    //   206: return
    //   207: astore 7
    //   209: ldc 13
    //   211: iconst_1
    //   212: ldc 214
    //   214: aload 7
    //   216: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload 7
    //   221: instanceof 216
    //   224: ifeq -20 -> 204
    //   227: ldc 13
    //   229: iconst_1
    //   230: ldc 218
    //   232: invokestatic 124	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload_0
    //   236: invokespecial 220	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:deleteDbFile	()V
    //   239: goto -35 -> 204
    //   242: astore 7
    //   244: aload_0
    //   245: monitorexit
    //   246: aload 7
    //   248: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	MiniAppEntityManager
    //   17	176	1	l1	long
    //   21	111	3	l2	long
    //   25	108	5	l3	long
    //   207	13	7	localThrowable	Throwable
    //   242	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   27	204	207	java/lang/Throwable
    //   2	27	242	finally
    //   27	204	242	finally
    //   209	239	242	finally
  }
  
  /* Error */
  public boolean clearEntityTable(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   21: new 93	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   28: ldc 223
    //   30: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokevirtual 226	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   43: istore_2
    //   44: goto -31 -> 13
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	MiniAppEntityManager
    //   0	52	1	paramString	String
    //   12	32	2	bool	boolean
    //   6	2	3	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   17	44	47	finally
  }
  
  /* Error */
  public boolean execSQL(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   21: aload_1
    //   22: invokevirtual 226	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   25: istore_2
    //   26: goto -13 -> 13
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	MiniAppEntityManager
    //   0	34	1	paramString	String
    //   12	14	2	bool	boolean
    //   6	2	3	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
    //   17	26	29	finally
  }
  
  /* Error */
  public com.tencent.mobileqq.persistence.Entity find(java.lang.Class<? extends com.tencent.mobileqq.persistence.Entity> paramClass, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +9 -> 19
    //   13: aconst_null
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: aload_0
    //   20: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: aload_1
    //   24: iconst_1
    //   25: aload_2
    //   26: aload_3
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: ldc 230
    //   32: invokevirtual 234	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   35: astore_1
    //   36: aload_1
    //   37: ifnull +17 -> 54
    //   40: aload_1
    //   41: iconst_0
    //   42: invokeinterface 240 2 0
    //   47: checkcast 242	com/tencent/mobileqq/persistence/Entity
    //   50: astore_1
    //   51: goto -36 -> 15
    //   54: aconst_null
    //   55: astore_1
    //   56: goto -41 -> 15
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	MiniAppEntityManager
    //   0	64	1	paramClass	java.lang.Class<? extends com.tencent.mobileqq.persistence.Entity>
    //   0	64	2	paramString	String
    //   0	64	3	paramArrayOfString	String[]
    //   6	3	4	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   2	8	59	finally
    //   19	36	59	finally
    //   40	51	59	finally
  }
  
  public EntityTransaction getTransaction()
  {
    if (this.mEntityManager == null) {
      return null;
    }
    return this.mEntityManager.getTransaction();
  }
  
  /* Error */
  public boolean insertOrReplaceEntity(com.tencent.mobileqq.persistence.Entity paramEntity)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_1
    //   18: invokevirtual 254	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   21: sipush 1000
    //   24: if_icmpne +26 -> 50
    //   27: aload_0
    //   28: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   31: aload_1
    //   32: invokevirtual 258	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   35: aload_1
    //   36: invokevirtual 254	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   39: sipush 1001
    //   42: if_icmpne -29 -> 13
    //   45: iconst_1
    //   46: istore_2
    //   47: goto -34 -> 13
    //   50: aload_1
    //   51: invokevirtual 254	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   54: sipush 1001
    //   57: if_icmpeq +13 -> 70
    //   60: aload_1
    //   61: invokevirtual 254	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   64: sipush 1002
    //   67: if_icmpne -54 -> 13
    //   70: aload_0
    //   71: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   74: aload_1
    //   75: invokevirtual 261	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   78: istore_2
    //   79: goto -66 -> 13
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	MiniAppEntityManager
    //   0	87	1	paramEntity	com.tencent.mobileqq.persistence.Entity
    //   1	78	2	bool	boolean
    //   8	2	3	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   4	9	82	finally
    //   17	35	82	finally
    //   35	45	82	finally
    //   50	60	82	finally
    //   60	70	82	finally
    //   70	79	82	finally
  }
  
  public void onDestroy()
  {
    if (this.mEntityManager != null) {
      this.mEntityManager.close();
    }
    if (this.miniAppEntityManagerFactory != null) {
      this.miniAppEntityManagerFactory.close();
    }
  }
  
  /* Error */
  public java.util.List<? extends com.tencent.mobileqq.persistence.Entity> queryEntity(java.lang.Class<? extends com.tencent.mobileqq.persistence.Entity> paramClass, boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   6: astore 9
    //   8: aload 9
    //   10: ifnonnull +9 -> 19
    //   13: aconst_null
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: aload_0
    //   20: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: aload_1
    //   24: iload_2
    //   25: aload_3
    //   26: aload 4
    //   28: aload 5
    //   30: aload 6
    //   32: aload 7
    //   34: aload 8
    //   36: invokevirtual 234	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   39: astore_1
    //   40: goto -25 -> 15
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	MiniAppEntityManager
    //   0	48	1	paramClass	java.lang.Class<? extends com.tencent.mobileqq.persistence.Entity>
    //   0	48	2	paramBoolean	boolean
    //   0	48	3	paramString1	String
    //   0	48	4	paramArrayOfString	String[]
    //   0	48	5	paramString2	String
    //   0	48	6	paramString3	String
    //   0	48	7	paramString4	String
    //   0	48	8	paramString5	String
    //   6	3	9	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   2	8	43	finally
    //   19	40	43	finally
  }
  
  /* Error */
  public boolean removeEntity(com.tencent.mobileqq.persistence.Entity paramEntity)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_1
    //   18: ifnull -5 -> 13
    //   21: aload_0
    //   22: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: aload_1
    //   26: invokevirtual 272	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   29: istore_2
    //   30: goto -17 -> 13
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	MiniAppEntityManager
    //   0	38	1	paramEntity	com.tencent.mobileqq.persistence.Entity
    //   1	29	2	bool	boolean
    //   8	2	3	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   4	9	33	finally
    //   21	30	33	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager
 * JD-Core Version:    0.7.0.1
 */