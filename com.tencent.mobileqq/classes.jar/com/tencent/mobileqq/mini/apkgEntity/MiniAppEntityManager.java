package com.tencent.mobileqq.mini.apkgEntity;

import atmp;
import atmr;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.manager.Manager;

public class MiniAppEntityManager
  implements Manager
{
  private static final long APPINFO_DELETE_TIME = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_appinfoentity_interval_time", 172800000L);
  private static final long OTHER_DELETE_TIME = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_otherentity_interval_time", 345600000L);
  private static final String TAG = "MiniAppEntityManager";
  private atmp mEntityManager = this.miniAppEntityManagerFactory.createEntityManager();
  private MiniAppEntityManagerFactory miniAppEntityManagerFactory = getEntityManagerFactory(paramString);
  
  public MiniAppEntityManager(String paramString) {}
  
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
  
  public void checkDB()
  {
    try
    {
      QLog.d("miniapp-db", 1, "checkDB");
      long l1 = System.currentTimeMillis() - APPINFO_DELETE_TIME;
      long l2 = System.currentTimeMillis();
      long l3 = OTHER_DELETE_TIME;
      execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", new Object[] { MiniAppInfoEntity.class.getSimpleName(), Long.valueOf(l1) }));
      execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", new Object[] { MiniAppByIdEntity.class.getSimpleName(), Long.valueOf(l1) }));
      execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", new Object[] { MiniAppByLinkEntity.class.getSimpleName(), Long.valueOf(l1) }));
      execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", new Object[] { MiniAppShowInfoEntity.class.getSimpleName(), Long.valueOf(l2 - l3) }));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean clearEntityTable(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Latmp;
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
    //   18: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Latmp;
    //   21: new 131	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   28: ldc 134
    //   30: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokevirtual 146	atmp:b	(Ljava/lang/String;)Z
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
    //   6	2	3	localatmp	atmp
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
    //   3: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Latmp;
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
    //   18: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Latmp;
    //   21: aload_1
    //   22: invokevirtual 146	atmp:b	(Ljava/lang/String;)Z
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
    //   6	2	3	localatmp	atmp
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
    //   17	26	29	finally
  }
  
  /* Error */
  public atmo find(Class<? extends atmo> paramClass, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Latmp;
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
    //   20: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Latmp;
    //   23: aload_1
    //   24: iconst_1
    //   25: aload_2
    //   26: aload_3
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: ldc 150
    //   32: invokevirtual 154	atmp:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   35: astore_1
    //   36: aload_1
    //   37: ifnull +17 -> 54
    //   40: aload_1
    //   41: iconst_0
    //   42: invokeinterface 160 2 0
    //   47: checkcast 162	atmo
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
    //   0	64	1	paramClass	Class<? extends atmo>
    //   0	64	2	paramString	String
    //   0	64	3	paramArrayOfString	String[]
    //   6	3	4	localatmp	atmp
    // Exception table:
    //   from	to	target	type
    //   2	8	59	finally
    //   19	36	59	finally
    //   40	51	59	finally
  }
  
  public atmr getTransaction()
  {
    if (this.mEntityManager == null) {
      return null;
    }
    return this.mEntityManager.a();
  }
  
  /* Error */
  public boolean insertOrReplaceEntity(atmo paramatmo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Latmp;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_1
    //   18: invokevirtual 174	atmo:getStatus	()I
    //   21: sipush 1000
    //   24: if_icmpne +26 -> 50
    //   27: aload_0
    //   28: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Latmp;
    //   31: aload_1
    //   32: invokevirtual 177	atmp:b	(Latmo;)V
    //   35: aload_1
    //   36: invokevirtual 174	atmo:getStatus	()I
    //   39: sipush 1001
    //   42: if_icmpne -29 -> 13
    //   45: iconst_1
    //   46: istore_2
    //   47: goto -34 -> 13
    //   50: aload_1
    //   51: invokevirtual 174	atmo:getStatus	()I
    //   54: sipush 1001
    //   57: if_icmpeq +13 -> 70
    //   60: aload_1
    //   61: invokevirtual 174	atmo:getStatus	()I
    //   64: sipush 1002
    //   67: if_icmpne -54 -> 13
    //   70: aload_0
    //   71: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Latmp;
    //   74: aload_1
    //   75: invokevirtual 179	atmp:a	(Latmo;)Z
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
    //   0	87	1	paramatmo	atmo
    //   1	78	2	bool	boolean
    //   8	2	3	localatmp	atmp
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
      this.mEntityManager.a();
    }
    if (this.miniAppEntityManagerFactory != null) {
      this.miniAppEntityManagerFactory.close();
    }
  }
  
  /* Error */
  public java.util.List<? extends atmo> queryEntity(Class<? extends atmo> paramClass, boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Latmp;
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
    //   20: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Latmp;
    //   23: aload_1
    //   24: iload_2
    //   25: aload_3
    //   26: aload 4
    //   28: aload 5
    //   30: aload 6
    //   32: aload 7
    //   34: aload 8
    //   36: invokevirtual 154	atmp:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
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
    //   0	48	1	paramClass	Class<? extends atmo>
    //   0	48	2	paramBoolean	boolean
    //   0	48	3	paramString1	String
    //   0	48	4	paramArrayOfString	String[]
    //   0	48	5	paramString2	String
    //   0	48	6	paramString3	String
    //   0	48	7	paramString4	String
    //   0	48	8	paramString5	String
    //   6	3	9	localatmp	atmp
    // Exception table:
    //   from	to	target	type
    //   2	8	43	finally
    //   19	40	43	finally
  }
  
  /* Error */
  public boolean removeEntity(atmo paramatmo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Latmp;
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
    //   22: getfield 62	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:mEntityManager	Latmp;
    //   25: aload_1
    //   26: invokevirtual 190	atmp:b	(Latmo;)Z
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
    //   0	38	1	paramatmo	atmo
    //   1	29	2	bool	boolean
    //   8	2	3	localatmp	atmp
    // Exception table:
    //   from	to	target	type
    //   4	9	33	finally
    //   21	30	33	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager
 * JD-Core Version:    0.7.0.1
 */