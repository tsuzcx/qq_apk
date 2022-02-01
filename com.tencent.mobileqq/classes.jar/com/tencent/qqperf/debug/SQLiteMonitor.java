package com.tencent.qqperf.debug;

import android.annotation.SuppressLint;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteStatement;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.debug.io.util.JavaMethodHook;
import com.tencent.mobileqq.debug.io.util.JavaMethodHook.AdditionalHookInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Member;
import java.util.ArrayList;

public class SQLiteMonitor
  extends Monitor
{
  private static int jdField_a_of_type_Int = 2000;
  static SQLiteMonitor jdField_a_of_type_ComTencentQqperfDebugSQLiteMonitor;
  private static int jdField_b_of_type_Int = 0;
  private RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(SQLInfo.class, jdField_a_of_type_Int);
  private SQLInfo jdField_a_of_type_ComTencentQqperfDebugSQLInfo = null;
  private File jdField_a_of_type_JavaIoFile;
  private RandomAccessFile jdField_a_of_type_JavaIoRandomAccessFile = null;
  private Class<SQLiteDatabase> jdField_a_of_type_JavaLangClass;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<JavaMethodHook.AdditionalHookInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList(9);
  private boolean jdField_a_of_type_Boolean = false;
  private SQLInfo jdField_b_of_type_ComTencentQqperfDebugSQLInfo = null;
  private File jdField_b_of_type_JavaIoFile = null;
  private Class<SQLiteStatement> jdField_b_of_type_JavaLangClass;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = false;
  private final int jdField_c_of_type_Int = 5242880;
  private File jdField_c_of_type_JavaIoFile = null;
  private Class<SQLiteCursor> jdField_c_of_type_JavaLangClass;
  private String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = false;
  private final int jdField_d_of_type_Int = 6;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  
  static
  {
    jdField_a_of_type_ComTencentQqperfDebugSQLiteMonitor = null;
    if (Runtime.getRuntime().maxMemory() / 10L < jdField_a_of_type_Int * 2048)
    {
      jdField_a_of_type_Int = (int)(Runtime.getRuntime().maxMemory() / 10L / 2048L);
      if (QLog.isColorLevel()) {
        QLog.i("SQLiteMonitor", 2, "Magnifier SQLMonitor Change WRITELEN to:" + jdField_a_of_type_Int);
      }
    }
  }
  
  /* Error */
  private String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 134	android/os/Process:myPid	()I
    //   5: istore_1
    //   6: new 136	java/io/FileInputStream
    //   9: dup
    //   10: new 138	java/io/File
    //   13: dup
    //   14: new 55	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   21: ldc 140
    //   23: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: iload_1
    //   27: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 142
    //   32: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: astore 5
    //   46: new 150	java/io/InputStreamReader
    //   49: dup
    //   50: aload 5
    //   52: invokespecial 153	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   55: astore 4
    //   57: new 155	java/io/BufferedReader
    //   60: dup
    //   61: aload 4
    //   63: invokespecial 158	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore_2
    //   67: aload_2
    //   68: astore 8
    //   70: aload 4
    //   72: astore 7
    //   74: aload 5
    //   76: astore 6
    //   78: aload_2
    //   79: invokevirtual 161	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   82: astore 9
    //   84: aload 9
    //   86: ifnull +20 -> 106
    //   89: aload_2
    //   90: astore 8
    //   92: aload 4
    //   94: astore 7
    //   96: aload 5
    //   98: astore 6
    //   100: aload 9
    //   102: invokevirtual 166	java/lang/String:trim	()Ljava/lang/String;
    //   105: astore_3
    //   106: aload_2
    //   107: invokevirtual 169	java/io/BufferedReader:close	()V
    //   110: aload 4
    //   112: invokevirtual 170	java/io/InputStreamReader:close	()V
    //   115: aload 5
    //   117: invokevirtual 171	java/io/FileInputStream:close	()V
    //   120: aload_3
    //   121: areturn
    //   122: astore_2
    //   123: aload_2
    //   124: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   127: aload_3
    //   128: areturn
    //   129: astore_3
    //   130: aconst_null
    //   131: astore_2
    //   132: aconst_null
    //   133: astore 4
    //   135: aconst_null
    //   136: astore 5
    //   138: aload_2
    //   139: astore 8
    //   141: aload 4
    //   143: astore 7
    //   145: aload 5
    //   147: astore 6
    //   149: aload_3
    //   150: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   153: aload_2
    //   154: invokevirtual 169	java/io/BufferedReader:close	()V
    //   157: aload 4
    //   159: invokevirtual 170	java/io/InputStreamReader:close	()V
    //   162: aload 5
    //   164: invokevirtual 171	java/io/FileInputStream:close	()V
    //   167: aconst_null
    //   168: areturn
    //   169: astore_2
    //   170: aload_2
    //   171: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   174: aconst_null
    //   175: areturn
    //   176: astore_2
    //   177: aconst_null
    //   178: astore_3
    //   179: aconst_null
    //   180: astore 4
    //   182: aconst_null
    //   183: astore 5
    //   185: aload_3
    //   186: invokevirtual 169	java/io/BufferedReader:close	()V
    //   189: aload 4
    //   191: invokevirtual 170	java/io/InputStreamReader:close	()V
    //   194: aload 5
    //   196: invokevirtual 171	java/io/FileInputStream:close	()V
    //   199: aload_2
    //   200: athrow
    //   201: astore_3
    //   202: aload_3
    //   203: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   206: goto -7 -> 199
    //   209: astore_2
    //   210: aconst_null
    //   211: astore_3
    //   212: aconst_null
    //   213: astore 4
    //   215: goto -30 -> 185
    //   218: astore_2
    //   219: aconst_null
    //   220: astore_3
    //   221: goto -36 -> 185
    //   224: astore_2
    //   225: aload 8
    //   227: astore_3
    //   228: aload 7
    //   230: astore 4
    //   232: aload 6
    //   234: astore 5
    //   236: goto -51 -> 185
    //   239: astore_3
    //   240: aconst_null
    //   241: astore_2
    //   242: aconst_null
    //   243: astore 4
    //   245: goto -107 -> 138
    //   248: astore_3
    //   249: aconst_null
    //   250: astore_2
    //   251: goto -113 -> 138
    //   254: astore_3
    //   255: goto -117 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	SQLiteMonitor
    //   5	22	1	i	int
    //   66	41	2	localBufferedReader	java.io.BufferedReader
    //   122	2	2	localIOException1	java.io.IOException
    //   131	23	2	localObject1	Object
    //   169	2	2	localIOException2	java.io.IOException
    //   176	24	2	localObject2	Object
    //   209	1	2	localObject3	Object
    //   218	1	2	localObject4	Object
    //   224	1	2	localObject5	Object
    //   241	10	2	localObject6	Object
    //   1	127	3	str1	String
    //   129	21	3	localIOException3	java.io.IOException
    //   178	8	3	localObject7	Object
    //   201	2	3	localIOException4	java.io.IOException
    //   211	17	3	localObject8	Object
    //   239	1	3	localIOException5	java.io.IOException
    //   248	1	3	localIOException6	java.io.IOException
    //   254	1	3	localIOException7	java.io.IOException
    //   55	189	4	localObject9	Object
    //   44	191	5	localObject10	Object
    //   76	157	6	localObject11	Object
    //   72	157	7	localObject12	Object
    //   68	158	8	localObject13	Object
    //   82	19	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   106	120	122	java/io/IOException
    //   6	46	129	java/io/IOException
    //   153	167	169	java/io/IOException
    //   6	46	176	finally
    //   185	199	201	java/io/IOException
    //   46	57	209	finally
    //   57	67	218	finally
    //   78	84	224	finally
    //   100	106	224	finally
    //   149	153	224	finally
    //   46	57	239	java/io/IOException
    //   57	67	248	java/io/IOException
    //   78	84	254	java/io/IOException
    //   100	106	254	java/io/IOException
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: invokespecial 176	com/tencent/qqperf/debug/SQLiteMonitor:a	()Ljava/lang/String;
    //   8: ifnull +50 -> 58
    //   11: aload_0
    //   12: invokespecial 176	com/tencent/qqperf/debug/SQLiteMonitor:a	()Ljava/lang/String;
    //   15: ldc 178
    //   17: invokevirtual 182	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull +36 -> 58
    //   25: aload_1
    //   26: iconst_0
    //   27: aaload
    //   28: ldc 184
    //   30: invokevirtual 188	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   33: ifeq +178 -> 211
    //   36: aload_0
    //   37: aload_0
    //   38: invokespecial 176	com/tencent/qqperf/debug/SQLiteMonitor:a	()Ljava/lang/String;
    //   41: ldc 178
    //   43: invokevirtual 182	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   46: iconst_0
    //   47: aaload
    //   48: ldc 184
    //   50: ldc 190
    //   52: invokevirtual 194	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   55: putfield 113	com/tencent/qqperf/debug/SQLiteMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   58: aload_0
    //   59: invokestatic 200	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   62: putfield 111	com/tencent/qqperf/debug/SQLiteMonitor:jdField_c_of_type_JavaIoFile	Ljava/io/File;
    //   65: aload_0
    //   66: new 138	java/io/File
    //   69: dup
    //   70: new 55	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   77: aload_0
    //   78: getfield 111	com/tencent/qqperf/debug/SQLiteMonitor:jdField_c_of_type_JavaIoFile	Ljava/io/File;
    //   81: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: ldc 205
    //   86: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: getfield 113	com/tencent/qqperf/debug/SQLiteMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   93: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 207
    //   98: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: putfield 109	com/tencent/qqperf/debug/SQLiteMonitor:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   110: aload_0
    //   111: getfield 109	com/tencent/qqperf/debug/SQLiteMonitor:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   114: invokevirtual 210	java/io/File:exists	()Z
    //   117: ifne +11 -> 128
    //   120: aload_0
    //   121: getfield 109	com/tencent/qqperf/debug/SQLiteMonitor:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   124: invokevirtual 213	java/io/File:mkdirs	()Z
    //   127: pop
    //   128: aload_0
    //   129: new 138	java/io/File
    //   132: dup
    //   133: aload_0
    //   134: getfield 109	com/tencent/qqperf/debug/SQLiteMonitor:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   137: ldc 215
    //   139: invokespecial 218	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   142: putfield 220	com/tencent/qqperf/debug/SQLiteMonitor:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   145: aload_3
    //   146: astore_1
    //   147: aload_0
    //   148: getfield 220	com/tencent/qqperf/debug/SQLiteMonitor:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   151: invokevirtual 210	java/io/File:exists	()Z
    //   154: ifne +48 -> 202
    //   157: aload_0
    //   158: getfield 220	com/tencent/qqperf/debug/SQLiteMonitor:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   161: invokevirtual 223	java/io/File:createNewFile	()Z
    //   164: ifne +65 -> 229
    //   167: aload_3
    //   168: astore_1
    //   169: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +30 -> 202
    //   175: ldc 53
    //   177: iconst_2
    //   178: iconst_2
    //   179: anewarray 225	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload_0
    //   185: getfield 220	com/tencent/qqperf/debug/SQLiteMonitor:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   188: invokevirtual 226	java/io/File:toString	()Ljava/lang/String;
    //   191: aastore
    //   192: dup
    //   193: iconst_1
    //   194: ldc 228
    //   196: aastore
    //   197: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   200: aload_3
    //   201: astore_1
    //   202: aload_1
    //   203: ifnull +7 -> 210
    //   206: aload_1
    //   207: invokevirtual 234	java/io/BufferedWriter:close	()V
    //   210: return
    //   211: aload_0
    //   212: aload_0
    //   213: invokespecial 176	com/tencent/qqperf/debug/SQLiteMonitor:a	()Ljava/lang/String;
    //   216: ldc 178
    //   218: invokevirtual 182	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   221: iconst_0
    //   222: aaload
    //   223: putfield 113	com/tencent/qqperf/debug/SQLiteMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   226: goto -168 -> 58
    //   229: new 233	java/io/BufferedWriter
    //   232: dup
    //   233: new 236	java/io/FileWriter
    //   236: dup
    //   237: aload_0
    //   238: getfield 220	com/tencent/qqperf/debug/SQLiteMonitor:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   241: invokespecial 237	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   244: invokespecial 240	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   247: astore_1
    //   248: aload_1
    //   249: ldc 242
    //   251: invokevirtual 245	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   254: goto -52 -> 202
    //   257: astore_1
    //   258: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq -51 -> 210
    //   264: ldc 53
    //   266: iconst_2
    //   267: aload_1
    //   268: iconst_0
    //   269: anewarray 225	java/lang/Object
    //   272: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   275: return
    //   276: astore_1
    //   277: aload_2
    //   278: astore_1
    //   279: aload_1
    //   280: ifnull -70 -> 210
    //   283: aload_1
    //   284: invokevirtual 234	java/io/BufferedWriter:close	()V
    //   287: return
    //   288: astore_1
    //   289: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq -82 -> 210
    //   295: ldc 53
    //   297: iconst_2
    //   298: aload_1
    //   299: iconst_0
    //   300: anewarray 225	java/lang/Object
    //   303: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   306: return
    //   307: astore_2
    //   308: aconst_null
    //   309: astore_1
    //   310: aload_1
    //   311: ifnull +7 -> 318
    //   314: aload_1
    //   315: invokevirtual 234	java/io/BufferedWriter:close	()V
    //   318: aload_2
    //   319: athrow
    //   320: astore_1
    //   321: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   324: ifeq -6 -> 318
    //   327: ldc 53
    //   329: iconst_2
    //   330: aload_1
    //   331: iconst_0
    //   332: anewarray 225	java/lang/Object
    //   335: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   338: goto -20 -> 318
    //   341: astore_2
    //   342: goto -32 -> 310
    //   345: astore_2
    //   346: goto -67 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	SQLiteMonitor
    //   20	229	1	localObject1	Object
    //   257	11	1	localIOException1	java.io.IOException
    //   276	1	1	localIOException2	java.io.IOException
    //   278	6	1	localObject2	Object
    //   288	11	1	localIOException3	java.io.IOException
    //   309	6	1	localObject3	Object
    //   320	11	1	localIOException4	java.io.IOException
    //   1	277	2	localObject4	Object
    //   307	12	2	localObject5	Object
    //   341	1	2	localObject6	Object
    //   345	1	2	localIOException5	java.io.IOException
    //   3	198	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   206	210	257	java/io/IOException
    //   147	167	276	java/io/IOException
    //   169	200	276	java/io/IOException
    //   229	248	276	java/io/IOException
    //   283	287	288	java/io/IOException
    //   147	167	307	finally
    //   169	200	307	finally
    //   229	248	307	finally
    //   314	318	320	java/io/IOException
    //   248	254	341	finally
    //   248	254	345	java/io/IOException
  }
  
  @SuppressLint({"NewApi"})
  private void c()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_JavaLangClass.getDeclaredMethod("openDatabase", new Class[] { String.class, SQLiteDatabase.CursorFactory.class, Integer.TYPE, DatabaseErrorHandler.class });
      localObject = JavaMethodHook.a((Member)localObject, new SQLiteMonitor.1(this));
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
    }
  }
  
  private void d()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_JavaLangClass.getDeclaredMethod("enableWriteAheadLogging", null);
      localObject = JavaMethodHook.a((Member)localObject, new SQLiteMonitor.2(this));
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
    }
  }
  
  private void e()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_JavaLangClass.getDeclaredMethod("endTransaction", null);
      localObject = JavaMethodHook.a((Member)localObject, new SQLiteMonitor.3(this));
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
    }
  }
  
  private void f()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_JavaLangClass.getDeclaredMethod("beginTransaction", null);
      localObject = JavaMethodHook.a((Member)localObject, new SQLiteMonitor.4(this));
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
    }
  }
  
  private void g()
  {
    try
    {
      Object localObject = this.jdField_b_of_type_JavaLangClass.getDeclaredMethod("executeInsert", null);
      localObject = JavaMethodHook.a((Member)localObject, new SQLiteMonitor.5(this));
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
    }
  }
  
  private void h()
  {
    try
    {
      Object localObject = this.jdField_b_of_type_JavaLangClass.getDeclaredMethod("executeUpdateDelete", null);
      localObject = JavaMethodHook.a((Member)localObject, new SQLiteMonitor.6(this));
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
    }
  }
  
  private void i()
  {
    try
    {
      Object localObject = this.jdField_b_of_type_JavaLangClass.getDeclaredMethod("execute", null);
      localObject = JavaMethodHook.a((Member)localObject, new SQLiteMonitor.7(this));
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
    }
  }
  
  private void j()
  {
    try
    {
      Object localObject = this.jdField_c_of_type_JavaLangClass.getDeclaredMethod("fillWindow", new Class[] { Integer.TYPE });
      localObject = JavaMethodHook.a((Member)localObject, new SQLiteMonitor.8(this));
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = a();
    if (!this.jdField_b_of_type_Boolean)
    {
      if (JavaMethodHook.a()) {
        this.jdField_a_of_type_Boolean = true;
      }
      while (!QLog.isColorLevel()) {
        try
        {
          this.jdField_a_of_type_JavaLangClass = Class.forName("android.database.sqlite.SQLiteDatabase");
          this.jdField_b_of_type_JavaLangClass = Class.forName("android.database.sqlite.SQLiteStatement");
          this.jdField_c_of_type_JavaLangClass = Class.forName("android.database.sqlite.SQLiteCursor");
          b();
          c();
          e();
          f();
          d();
          h();
          g();
          i();
          j();
          this.jdField_b_of_type_Boolean = true;
          return;
        }
        catch (Exception localException)
        {
          while (!QLog.isColorLevel()) {}
          QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
          return;
        }
      }
      QLog.e("SQLiteMonitor", 2, "load libhook.so error!");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.debug.SQLiteMonitor
 * JD-Core Version:    0.7.0.1
 */