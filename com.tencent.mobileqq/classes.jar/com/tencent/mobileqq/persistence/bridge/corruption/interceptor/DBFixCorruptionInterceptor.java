package com.tencent.mobileqq.persistence.bridge.corruption.interceptor;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.data.entitymanager.CorruptionInterceptorChain;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class DBFixCorruptionInterceptor
  extends CorruptionInterceptor
{
  private void a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramInt == 0) {
      if (paramBoolean) {
        paramInt = DBFixManager.e;
      }
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("reasonCode", String.valueOf(paramInt));
      localHashMap.put("dDName", paramString1);
      if (paramString2 != null) {
        localHashMap.put("errorStack", paramString2);
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, DBFixManager.j, true, -1L, 0L, localHashMap, null, false);
      return;
      paramInt = DBFixManager.d;
    }
  }
  
  /* Error */
  public java.lang.Void a(com.tencent.mobileqq.data.entitymanager.Interceptor.Chain<java.lang.Void> paramChain)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 69	com/tencent/mobileqq/persistence/bridge/corruption/interceptor/DBFixCorruptionInterceptor:a	()Lmqq/app/AppRuntime;
    //   4: astore 7
    //   6: aload 7
    //   8: ifnonnull +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_1
    //   14: checkcast 71	com/tencent/mobileqq/data/entitymanager/CorruptionInterceptorChain
    //   17: astore 8
    //   19: aload 8
    //   21: getfield 75	com/tencent/mobileqq/data/entitymanager/CorruptionInterceptorChain:database	Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore 9
    //   26: aload 7
    //   28: invokevirtual 81	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   31: getstatic 84	com/tencent/mobileqq/database/corrupt/DBFixManager:b	Ljava/lang/String;
    //   34: iconst_0
    //   35: invokevirtual 90	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   38: astore 10
    //   40: new 92	java/io/File
    //   43: dup
    //   44: aload 9
    //   46: invokevirtual 98	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   49: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: invokevirtual 104	java/io/File:getName	()Ljava/lang/String;
    //   55: astore 11
    //   57: aload 11
    //   59: new 106	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   66: aload 7
    //   68: invokevirtual 110	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   71: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 116
    //   76: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: istore 5
    //   87: aload 7
    //   89: getstatic 128	com/tencent/mobileqq/app/QQManagerFactory:DB_FIX_MANAGER	I
    //   92: invokevirtual 132	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   95: checkcast 13	com/tencent/mobileqq/database/corrupt/DBFixManager
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 135	com/tencent/mobileqq/database/corrupt/DBFixManager:a	()Z
    //   103: istore 4
    //   105: aconst_null
    //   106: astore 6
    //   108: iconst_0
    //   109: istore_2
    //   110: iload 4
    //   112: ifeq +67 -> 179
    //   115: iload 5
    //   117: ifeq +62 -> 179
    //   120: aload 9
    //   122: invokevirtual 138	android/database/sqlite/SQLiteDatabase:close	()V
    //   125: aload_1
    //   126: aconst_null
    //   127: iconst_1
    //   128: invokevirtual 141	com/tencent/mobileqq/database/corrupt/DBFixManager:a	(Landroid/content/Context;Z)V
    //   131: aconst_null
    //   132: areturn
    //   133: astore 6
    //   135: aconst_null
    //   136: astore_1
    //   137: ldc 143
    //   139: iconst_1
    //   140: ldc 145
    //   142: aload 6
    //   144: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   147: getstatic 153	com/tencent/mobileqq/database/corrupt/DBFixManager:jdField_f_of_type_Int	I
    //   150: istore_2
    //   151: aload 6
    //   153: invokestatic 159	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   156: astore 6
    //   158: iconst_0
    //   159: istore 4
    //   161: goto -51 -> 110
    //   164: astore 6
    //   166: ldc 143
    //   168: iconst_1
    //   169: ldc 161
    //   171: aload 6
    //   173: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   176: goto -51 -> 125
    //   179: aload 10
    //   181: new 106	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   188: aload 7
    //   190: invokevirtual 110	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   193: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: getstatic 163	com/tencent/mobileqq/database/corrupt/DBFixManager:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   199: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: iconst_0
    //   206: invokeinterface 169 3 0
    //   211: istore_3
    //   212: ldc 143
    //   214: iconst_1
    //   215: bipush 6
    //   217: anewarray 171	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: ldc 173
    //   224: aastore
    //   225: dup
    //   226: iconst_1
    //   227: aload 11
    //   229: aastore
    //   230: dup
    //   231: iconst_2
    //   232: ldc 175
    //   234: aastore
    //   235: dup
    //   236: iconst_3
    //   237: iload 5
    //   239: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   242: aastore
    //   243: dup
    //   244: iconst_4
    //   245: ldc 182
    //   247: aastore
    //   248: dup
    //   249: iconst_5
    //   250: iload_3
    //   251: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   254: aastore
    //   255: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   258: iload_3
    //   259: getstatic 193	com/tencent/mobileqq/database/corrupt/DBFixManager:c	I
    //   262: if_icmpge +8 -> 270
    //   265: iload 5
    //   267: ifne -256 -> 11
    //   270: aload_0
    //   271: aload 8
    //   273: aload 9
    //   275: aload 10
    //   277: invokevirtual 196	com/tencent/mobileqq/persistence/bridge/corruption/interceptor/DBFixCorruptionInterceptor:a	(Lcom/tencent/mobileqq/data/entitymanager/CorruptionInterceptorChain;Landroid/database/sqlite/SQLiteDatabase;Landroid/content/SharedPreferences;)V
    //   280: aload_0
    //   281: iload_2
    //   282: iload 5
    //   284: aload 11
    //   286: aload 6
    //   288: invokespecial 198	com/tencent/mobileqq/persistence/bridge/corruption/interceptor/DBFixCorruptionInterceptor:a	(IZLjava/lang/String;Ljava/lang/String;)V
    //   291: aconst_null
    //   292: areturn
    //   293: astore 6
    //   295: goto -158 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	DBFixCorruptionInterceptor
    //   0	298	1	paramChain	com.tencent.mobileqq.data.entitymanager.Interceptor.Chain<java.lang.Void>
    //   109	173	2	i	int
    //   211	52	3	j	int
    //   103	57	4	bool1	boolean
    //   85	198	5	bool2	boolean
    //   106	1	6	localObject	java.lang.Object
    //   133	19	6	localThrowable1	java.lang.Throwable
    //   156	1	6	str1	String
    //   164	123	6	localSQLiteException	android.database.sqlite.SQLiteException
    //   293	1	6	localThrowable2	java.lang.Throwable
    //   4	185	7	localAppRuntime	mqq.app.AppRuntime
    //   17	255	8	localCorruptionInterceptorChain	CorruptionInterceptorChain
    //   24	250	9	localSQLiteDatabase	SQLiteDatabase
    //   38	238	10	localSharedPreferences	SharedPreferences
    //   55	230	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   87	99	133	java/lang/Throwable
    //   120	125	164	android/database/sqlite/SQLiteException
    //   99	105	293	java/lang/Throwable
  }
  
  void a(CorruptionInterceptorChain paramCorruptionInterceptorChain, SQLiteDatabase paramSQLiteDatabase, SharedPreferences paramSharedPreferences)
  {
    paramCorruptionInterceptorChain.defaultErrorHandler.onCorruption(paramSQLiteDatabase);
    paramSharedPreferences.edit().remove(DBFixManager.g).apply();
    DBFixManager.a();
    paramSharedPreferences.edit().putBoolean("isFriendlistok", false).apply();
    QLog.d("DBFixCorruptionHandler", 1, "cleared friendlist flag");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.corruption.interceptor.DBFixCorruptionInterceptor
 * JD-Core Version:    0.7.0.1
 */