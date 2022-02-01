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
  private static int jdField_b_of_type_Int;
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
    if (Runtime.getRuntime().maxMemory() / 10L < jdField_a_of_type_Int * 2048)
    {
      jdField_a_of_type_Int = (int)(Runtime.getRuntime().maxMemory() / 10L / 2048L);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Magnifier SQLMonitor Change WRITELEN to:");
        localStringBuilder.append(jdField_a_of_type_Int);
        QLog.i("SQLiteMonitor", 2, localStringBuilder.toString());
      }
    }
  }
  
  /* Error */
  private String a()
  {
    // Byte code:
    //   0: invokestatic 131	android/os/Process:myPid	()I
    //   3: istore_1
    //   4: aconst_null
    //   5: astore 9
    //   7: aconst_null
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 7
    //   13: new 50	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: ldc 133
    //   24: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: iload_1
    //   30: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_2
    //   35: ldc 135
    //   37: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: new 137	java/io/FileInputStream
    //   44: dup
    //   45: new 139	java/io/File
    //   48: dup
    //   49: aload_2
    //   50: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: invokespecial 145	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: astore_2
    //   60: new 147	java/io/InputStreamReader
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 150	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   68: astore_3
    //   69: new 152	java/io/BufferedReader
    //   72: dup
    //   73: aload_3
    //   74: invokespecial 155	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   77: astore 8
    //   79: aload_2
    //   80: astore 6
    //   82: aload_3
    //   83: astore 5
    //   85: aload 8
    //   87: astore 4
    //   89: aload 8
    //   91: invokevirtual 158	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   94: astore 10
    //   96: aload 7
    //   98: astore 4
    //   100: aload 10
    //   102: ifnull +24 -> 126
    //   105: aload_2
    //   106: astore 6
    //   108: aload_3
    //   109: astore 5
    //   111: aload 8
    //   113: astore 4
    //   115: aload 10
    //   117: invokevirtual 163	java/lang/String:trim	()Ljava/lang/String;
    //   120: astore 7
    //   122: aload 7
    //   124: astore 4
    //   126: aload 4
    //   128: astore 5
    //   130: aload 8
    //   132: invokevirtual 166	java/io/BufferedReader:close	()V
    //   135: aload 4
    //   137: astore 5
    //   139: aload_3
    //   140: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   143: aload 4
    //   145: astore 5
    //   147: aload_2
    //   148: invokevirtual 168	java/io/FileInputStream:close	()V
    //   151: aload 4
    //   153: areturn
    //   154: astore_2
    //   155: aload_2
    //   156: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   159: aload 5
    //   161: areturn
    //   162: astore 4
    //   164: aload_2
    //   165: astore 7
    //   167: aload 8
    //   169: astore_2
    //   170: aload 4
    //   172: astore 8
    //   174: goto +65 -> 239
    //   177: astore 6
    //   179: aload_2
    //   180: astore 4
    //   182: aload 6
    //   184: astore_2
    //   185: goto +112 -> 297
    //   188: astore 8
    //   190: aconst_null
    //   191: astore 4
    //   193: aload_2
    //   194: astore 7
    //   196: aload 4
    //   198: astore_2
    //   199: goto +40 -> 239
    //   202: astore_3
    //   203: aload_2
    //   204: astore 4
    //   206: aload_3
    //   207: astore_2
    //   208: aconst_null
    //   209: astore_3
    //   210: goto +87 -> 297
    //   213: astore 8
    //   215: aload_2
    //   216: astore 7
    //   218: goto +17 -> 235
    //   221: astore_2
    //   222: aconst_null
    //   223: astore_3
    //   224: aload_3
    //   225: astore 4
    //   227: goto +70 -> 297
    //   230: astore 8
    //   232: aconst_null
    //   233: astore 7
    //   235: aconst_null
    //   236: astore_3
    //   237: aconst_null
    //   238: astore_2
    //   239: aload 7
    //   241: astore 6
    //   243: aload_3
    //   244: astore 5
    //   246: aload_2
    //   247: astore 4
    //   249: aload 8
    //   251: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   254: aload 9
    //   256: astore 5
    //   258: aload_2
    //   259: invokevirtual 166	java/io/BufferedReader:close	()V
    //   262: aload 9
    //   264: astore 5
    //   266: aload_3
    //   267: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   270: aload 9
    //   272: astore 5
    //   274: aload 7
    //   276: invokevirtual 168	java/io/FileInputStream:close	()V
    //   279: aconst_null
    //   280: areturn
    //   281: astore_2
    //   282: aload 4
    //   284: astore 7
    //   286: aload 6
    //   288: astore 4
    //   290: aload 5
    //   292: astore_3
    //   293: aload 7
    //   295: astore 5
    //   297: aload 5
    //   299: invokevirtual 166	java/io/BufferedReader:close	()V
    //   302: aload_3
    //   303: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   306: aload 4
    //   308: invokevirtual 168	java/io/FileInputStream:close	()V
    //   311: goto +8 -> 319
    //   314: astore_3
    //   315: aload_3
    //   316: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   319: aload_2
    //   320: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	SQLiteMonitor
    //   3	27	1	i	int
    //   20	128	2	localObject1	Object
    //   154	11	2	localIOException1	java.io.IOException
    //   169	47	2	localObject2	Object
    //   221	1	2	localObject3	Object
    //   238	21	2	localObject4	Object
    //   281	39	2	localObject5	Object
    //   68	72	3	localInputStreamReader	java.io.InputStreamReader
    //   202	5	3	localObject6	Object
    //   209	94	3	localObject7	Object
    //   314	2	3	localIOException2	java.io.IOException
    //   87	65	4	localObject8	Object
    //   162	9	4	localIOException3	java.io.IOException
    //   180	127	4	localObject9	Object
    //   8	290	5	localObject10	Object
    //   80	27	6	localObject11	Object
    //   177	6	6	localObject12	Object
    //   241	46	6	localObject13	Object
    //   11	283	7	localObject14	Object
    //   77	96	8	localObject15	Object
    //   188	1	8	localIOException4	java.io.IOException
    //   213	1	8	localIOException5	java.io.IOException
    //   230	20	8	localIOException6	java.io.IOException
    //   5	266	9	localObject16	Object
    //   94	22	10	str	String
    // Exception table:
    //   from	to	target	type
    //   130	135	154	java/io/IOException
    //   139	143	154	java/io/IOException
    //   147	151	154	java/io/IOException
    //   258	262	154	java/io/IOException
    //   266	270	154	java/io/IOException
    //   274	279	154	java/io/IOException
    //   89	96	162	java/io/IOException
    //   115	122	162	java/io/IOException
    //   69	79	177	finally
    //   69	79	188	java/io/IOException
    //   60	69	202	finally
    //   60	69	213	java/io/IOException
    //   13	60	221	finally
    //   13	60	230	java/io/IOException
    //   89	96	281	finally
    //   115	122	281	finally
    //   249	254	281	finally
    //   297	311	314	java/io/IOException
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 173	com/tencent/qqperf/debug/SQLiteMonitor:a	()Ljava/lang/String;
    //   4: ifnull +68 -> 72
    //   7: aload_0
    //   8: invokespecial 173	com/tencent/qqperf/debug/SQLiteMonitor:a	()Ljava/lang/String;
    //   11: ldc 175
    //   13: invokevirtual 179	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +54 -> 72
    //   21: aload_1
    //   22: iconst_0
    //   23: aaload
    //   24: ldc 181
    //   26: invokevirtual 185	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   29: ifeq +28 -> 57
    //   32: aload_0
    //   33: aload_0
    //   34: invokespecial 173	com/tencent/qqperf/debug/SQLiteMonitor:a	()Ljava/lang/String;
    //   37: ldc 175
    //   39: invokevirtual 179	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   42: iconst_0
    //   43: aaload
    //   44: ldc 181
    //   46: ldc 187
    //   48: invokevirtual 191	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   51: putfield 110	com/tencent/qqperf/debug/SQLiteMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   54: goto +18 -> 72
    //   57: aload_0
    //   58: aload_0
    //   59: invokespecial 173	com/tencent/qqperf/debug/SQLiteMonitor:a	()Ljava/lang/String;
    //   62: ldc 175
    //   64: invokevirtual 179	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   67: iconst_0
    //   68: aaload
    //   69: putfield 110	com/tencent/qqperf/debug/SQLiteMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   72: aload_0
    //   73: invokestatic 197	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   76: putfield 108	com/tencent/qqperf/debug/SQLiteMonitor:jdField_c_of_type_JavaIoFile	Ljava/io/File;
    //   79: new 50	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   86: astore_1
    //   87: aload_1
    //   88: aload_0
    //   89: getfield 108	com/tencent/qqperf/debug/SQLiteMonitor:jdField_c_of_type_JavaIoFile	Ljava/io/File;
    //   92: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_1
    //   97: ldc 202
    //   99: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_1
    //   104: aload_0
    //   105: getfield 110	com/tencent/qqperf/debug/SQLiteMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   108: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_1
    //   113: ldc 204
    //   115: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_0
    //   120: new 139	java/io/File
    //   123: dup
    //   124: aload_1
    //   125: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   131: putfield 106	com/tencent/qqperf/debug/SQLiteMonitor:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   134: aload_0
    //   135: getfield 106	com/tencent/qqperf/debug/SQLiteMonitor:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   138: invokevirtual 207	java/io/File:exists	()Z
    //   141: ifne +11 -> 152
    //   144: aload_0
    //   145: getfield 106	com/tencent/qqperf/debug/SQLiteMonitor:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   148: invokevirtual 210	java/io/File:mkdirs	()Z
    //   151: pop
    //   152: aload_0
    //   153: new 139	java/io/File
    //   156: dup
    //   157: aload_0
    //   158: getfield 106	com/tencent/qqperf/debug/SQLiteMonitor:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   161: ldc 212
    //   163: invokespecial 215	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   166: putfield 217	com/tencent/qqperf/debug/SQLiteMonitor:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   169: aconst_null
    //   170: astore_3
    //   171: aconst_null
    //   172: astore_2
    //   173: aconst_null
    //   174: astore 4
    //   176: aload 4
    //   178: astore_1
    //   179: aload_0
    //   180: getfield 217	com/tencent/qqperf/debug/SQLiteMonitor:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   183: invokevirtual 207	java/io/File:exists	()Z
    //   186: ifne +88 -> 274
    //   189: aload_0
    //   190: getfield 217	com/tencent/qqperf/debug/SQLiteMonitor:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   193: invokevirtual 220	java/io/File:createNewFile	()Z
    //   196: ifne +43 -> 239
    //   199: aload 4
    //   201: astore_1
    //   202: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +69 -> 274
    //   208: ldc 64
    //   210: iconst_2
    //   211: iconst_2
    //   212: anewarray 222	java/lang/Object
    //   215: dup
    //   216: iconst_0
    //   217: aload_0
    //   218: getfield 217	com/tencent/qqperf/debug/SQLiteMonitor:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   221: invokevirtual 223	java/io/File:toString	()Ljava/lang/String;
    //   224: aastore
    //   225: dup
    //   226: iconst_1
    //   227: ldc 225
    //   229: aastore
    //   230: invokestatic 228	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   233: aload 4
    //   235: astore_1
    //   236: goto +38 -> 274
    //   239: new 230	java/io/BufferedWriter
    //   242: dup
    //   243: new 232	java/io/FileWriter
    //   246: dup
    //   247: aload_0
    //   248: getfield 217	com/tencent/qqperf/debug/SQLiteMonitor:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   251: invokespecial 233	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   254: invokespecial 236	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   257: astore_1
    //   258: aload_1
    //   259: ldc 238
    //   261: invokevirtual 241	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   264: goto +10 -> 274
    //   267: astore_2
    //   268: goto +37 -> 305
    //   271: goto +65 -> 336
    //   274: aload_1
    //   275: ifnull +88 -> 363
    //   278: aload_1
    //   279: invokevirtual 242	java/io/BufferedWriter:close	()V
    //   282: return
    //   283: astore_1
    //   284: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq +76 -> 363
    //   290: ldc 64
    //   292: iconst_2
    //   293: aload_1
    //   294: iconst_0
    //   295: anewarray 222	java/lang/Object
    //   298: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   301: return
    //   302: astore_2
    //   303: aload_3
    //   304: astore_1
    //   305: aload_1
    //   306: ifnull +28 -> 334
    //   309: aload_1
    //   310: invokevirtual 242	java/io/BufferedWriter:close	()V
    //   313: goto +21 -> 334
    //   316: astore_1
    //   317: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +14 -> 334
    //   323: ldc 64
    //   325: iconst_2
    //   326: aload_1
    //   327: iconst_0
    //   328: anewarray 222	java/lang/Object
    //   331: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   334: aload_2
    //   335: athrow
    //   336: aload_1
    //   337: ifnull +26 -> 363
    //   340: aload_1
    //   341: invokevirtual 242	java/io/BufferedWriter:close	()V
    //   344: return
    //   345: astore_1
    //   346: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +14 -> 363
    //   352: ldc 64
    //   354: iconst_2
    //   355: aload_1
    //   356: iconst_0
    //   357: anewarray 222	java/lang/Object
    //   360: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   363: return
    //   364: astore_1
    //   365: aload_2
    //   366: astore_1
    //   367: goto -31 -> 336
    //   370: astore_2
    //   371: goto -100 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	SQLiteMonitor
    //   16	263	1	localObject1	Object
    //   283	11	1	localIOException1	java.io.IOException
    //   304	6	1	localObject2	Object
    //   316	25	1	localIOException2	java.io.IOException
    //   345	11	1	localIOException3	java.io.IOException
    //   364	1	1	localIOException4	java.io.IOException
    //   366	1	1	localObject3	Object
    //   172	1	2	localObject4	Object
    //   267	1	2	localObject5	Object
    //   302	64	2	localObject6	Object
    //   370	1	2	localIOException5	java.io.IOException
    //   170	134	3	localObject7	Object
    //   174	60	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   258	264	267	finally
    //   278	282	283	java/io/IOException
    //   179	199	302	finally
    //   202	233	302	finally
    //   239	258	302	finally
    //   309	313	316	java/io/IOException
    //   340	344	345	java/io/IOException
    //   179	199	364	java/io/IOException
    //   202	233	364	java/io/IOException
    //   239	258	364	java/io/IOException
    //   258	264	370	java/io/IOException
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
      if (QLog.isColorLevel()) {
        QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
      }
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
      if (QLog.isColorLevel()) {
        QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
      }
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
      if (QLog.isColorLevel()) {
        QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
      }
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
      if (QLog.isColorLevel()) {
        QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
      }
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
      if (QLog.isColorLevel()) {
        QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
      }
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
      if (QLog.isColorLevel()) {
        QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
      }
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
      if (QLog.isColorLevel()) {
        QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
      }
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
      if (QLog.isColorLevel()) {
        QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
      }
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = a();
    if (!this.jdField_b_of_type_Boolean)
    {
      if (JavaMethodHook.a())
      {
        this.jdField_a_of_type_Boolean = true;
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
          if (QLog.isColorLevel()) {
            QLog.e("SQLiteMonitor", 2, localException, new Object[0]);
          }
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("SQLiteMonitor", 2, "load libhook.so error!");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.debug.SQLiteMonitor
 * JD-Core Version:    0.7.0.1
 */