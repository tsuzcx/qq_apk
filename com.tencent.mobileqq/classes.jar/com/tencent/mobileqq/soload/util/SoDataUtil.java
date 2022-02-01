package com.tencent.mobileqq.soload.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

public class SoDataUtil
{
  private static Boolean jdField_a_of_type_JavaLangBoolean = null;
  private static final Map<String, SharedPreferences> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static long a()
  {
    return a("dynamic_so_load").getLong("key_last_rsp_time", 0L);
  }
  
  public static SharedPreferences a(String paramString)
  {
    SharedPreferences localSharedPreferences2 = (SharedPreferences)jdField_a_of_type_JavaUtilMap.get(paramString);
    SharedPreferences localSharedPreferences1 = localSharedPreferences2;
    if (localSharedPreferences2 == null)
    {
      localSharedPreferences1 = MobileQQ.sMobileQQ.getSharedPreferences(paramString, 4);
      jdField_a_of_type_JavaUtilMap.put(paramString, localSharedPreferences1);
    }
    return localSharedPreferences1;
  }
  
  /* Error */
  public static Object a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 64	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual 71	java/io/File:exists	()Z
    //   16: istore_2
    //   17: iload_2
    //   18: ifne +63 -> 81
    //   21: iconst_0
    //   22: ifeq +11 -> 33
    //   25: new 73	java/lang/NullPointerException
    //   28: dup
    //   29: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   32: athrow
    //   33: iconst_0
    //   34: ifeq +11 -> 45
    //   37: new 73	java/lang/NullPointerException
    //   40: dup
    //   41: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   44: athrow
    //   45: iconst_0
    //   46: ifeq +11 -> 57
    //   49: new 73	java/lang/NullPointerException
    //   52: dup
    //   53: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   56: athrow
    //   57: aload 8
    //   59: astore_3
    //   60: iconst_0
    //   61: ifeq +11 -> 72
    //   64: new 73	java/lang/NullPointerException
    //   67: dup
    //   68: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   71: athrow
    //   72: aload_3
    //   73: areturn
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   79: aconst_null
    //   80: areturn
    //   81: new 79	java/io/FileInputStream
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore 4
    //   91: new 84	java/io/ByteArrayOutputStream
    //   94: dup
    //   95: invokespecial 85	java/io/ByteArrayOutputStream:<init>	()V
    //   98: astore 5
    //   100: sipush 1024
    //   103: newarray byte
    //   105: astore_0
    //   106: aload 4
    //   108: aload_0
    //   109: invokevirtual 89	java/io/FileInputStream:read	([B)I
    //   112: istore_1
    //   113: iload_1
    //   114: iconst_m1
    //   115: if_icmpeq +102 -> 217
    //   118: aload 5
    //   120: aload_0
    //   121: iconst_0
    //   122: iload_1
    //   123: invokevirtual 93	java/io/ByteArrayOutputStream:write	([BII)V
    //   126: goto -20 -> 106
    //   129: astore 6
    //   131: aconst_null
    //   132: astore 7
    //   134: aload 5
    //   136: astore_3
    //   137: aconst_null
    //   138: astore 8
    //   140: aload 4
    //   142: astore_0
    //   143: aload 7
    //   145: astore 5
    //   147: aload 8
    //   149: astore 4
    //   151: aload 6
    //   153: invokevirtual 94	java/lang/Exception:printStackTrace	()V
    //   156: aload 6
    //   158: athrow
    //   159: astore 8
    //   161: aload 5
    //   163: astore 6
    //   165: aload_3
    //   166: astore 5
    //   168: aload_0
    //   169: astore 7
    //   171: aload 6
    //   173: astore_3
    //   174: aload 8
    //   176: astore_0
    //   177: aload_3
    //   178: ifnull +7 -> 185
    //   181: aload_3
    //   182: invokevirtual 99	java/io/ObjectInputStream:close	()V
    //   185: aload 4
    //   187: ifnull +8 -> 195
    //   190: aload 4
    //   192: invokevirtual 102	java/io/ByteArrayInputStream:close	()V
    //   195: aload 5
    //   197: ifnull +8 -> 205
    //   200: aload 5
    //   202: invokevirtual 103	java/io/ByteArrayOutputStream:close	()V
    //   205: aload 7
    //   207: ifnull +8 -> 215
    //   210: aload 7
    //   212: invokevirtual 104	java/io/FileInputStream:close	()V
    //   215: aload_0
    //   216: athrow
    //   217: new 101	java/io/ByteArrayInputStream
    //   220: dup
    //   221: aload 5
    //   223: invokevirtual 108	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   226: invokespecial 111	java/io/ByteArrayInputStream:<init>	([B)V
    //   229: astore 6
    //   231: new 96	java/io/ObjectInputStream
    //   234: dup
    //   235: aload 6
    //   237: invokespecial 114	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   240: astore_3
    //   241: aload_3
    //   242: invokevirtual 118	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   245: astore_0
    //   246: aload_3
    //   247: ifnull +7 -> 254
    //   250: aload_3
    //   251: invokevirtual 99	java/io/ObjectInputStream:close	()V
    //   254: aload 6
    //   256: ifnull +8 -> 264
    //   259: aload 6
    //   261: invokevirtual 102	java/io/ByteArrayInputStream:close	()V
    //   264: aload 5
    //   266: ifnull +8 -> 274
    //   269: aload 5
    //   271: invokevirtual 103	java/io/ByteArrayOutputStream:close	()V
    //   274: aload_0
    //   275: astore_3
    //   276: aload 4
    //   278: ifnull -206 -> 72
    //   281: aload 4
    //   283: invokevirtual 104	java/io/FileInputStream:close	()V
    //   286: aload_0
    //   287: areturn
    //   288: astore_3
    //   289: aload_3
    //   290: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   293: aload_0
    //   294: areturn
    //   295: astore_3
    //   296: aconst_null
    //   297: astore 7
    //   299: aconst_null
    //   300: astore 5
    //   302: aconst_null
    //   303: astore 4
    //   305: aconst_null
    //   306: astore_0
    //   307: aload_3
    //   308: invokevirtual 119	java/lang/OutOfMemoryError:printStackTrace	()V
    //   311: aload_0
    //   312: ifnull +7 -> 319
    //   315: aload_0
    //   316: invokevirtual 99	java/io/ObjectInputStream:close	()V
    //   319: aload 4
    //   321: ifnull +8 -> 329
    //   324: aload 4
    //   326: invokevirtual 102	java/io/ByteArrayInputStream:close	()V
    //   329: aload 5
    //   331: ifnull +8 -> 339
    //   334: aload 5
    //   336: invokevirtual 103	java/io/ByteArrayOutputStream:close	()V
    //   339: aload 8
    //   341: astore_3
    //   342: aload 7
    //   344: ifnull -272 -> 72
    //   347: aload 7
    //   349: invokevirtual 104	java/io/FileInputStream:close	()V
    //   352: aconst_null
    //   353: areturn
    //   354: astore_0
    //   355: aload_0
    //   356: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   359: aconst_null
    //   360: areturn
    //   361: astore_3
    //   362: aload_3
    //   363: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   366: goto -151 -> 215
    //   369: astore_0
    //   370: aconst_null
    //   371: astore 7
    //   373: aconst_null
    //   374: astore 5
    //   376: aconst_null
    //   377: astore 4
    //   379: aconst_null
    //   380: astore_3
    //   381: goto -204 -> 177
    //   384: astore_0
    //   385: aconst_null
    //   386: astore 5
    //   388: aconst_null
    //   389: astore 6
    //   391: aconst_null
    //   392: astore_3
    //   393: aload 4
    //   395: astore 7
    //   397: aload 6
    //   399: astore 4
    //   401: goto -224 -> 177
    //   404: astore_0
    //   405: aconst_null
    //   406: astore 6
    //   408: aconst_null
    //   409: astore_3
    //   410: aload 4
    //   412: astore 7
    //   414: aload 6
    //   416: astore 4
    //   418: goto -241 -> 177
    //   421: astore_0
    //   422: aconst_null
    //   423: astore_3
    //   424: aload 4
    //   426: astore 7
    //   428: aload 6
    //   430: astore 4
    //   432: goto -255 -> 177
    //   435: astore_0
    //   436: aload 4
    //   438: astore 7
    //   440: aload 6
    //   442: astore 4
    //   444: goto -267 -> 177
    //   447: astore 6
    //   449: aload_0
    //   450: astore_3
    //   451: aload 6
    //   453: astore_0
    //   454: goto -277 -> 177
    //   457: astore_3
    //   458: aconst_null
    //   459: astore 5
    //   461: aconst_null
    //   462: astore 6
    //   464: aconst_null
    //   465: astore_0
    //   466: aload 4
    //   468: astore 7
    //   470: aload 6
    //   472: astore 4
    //   474: goto -167 -> 307
    //   477: astore_3
    //   478: aconst_null
    //   479: astore 6
    //   481: aconst_null
    //   482: astore_0
    //   483: aload 4
    //   485: astore 7
    //   487: aload 6
    //   489: astore 4
    //   491: goto -184 -> 307
    //   494: astore_3
    //   495: aconst_null
    //   496: astore_0
    //   497: aload 4
    //   499: astore 7
    //   501: aload 6
    //   503: astore 4
    //   505: goto -198 -> 307
    //   508: astore 7
    //   510: aload_3
    //   511: astore_0
    //   512: aload 7
    //   514: astore_3
    //   515: aload 4
    //   517: astore 7
    //   519: aload 6
    //   521: astore 4
    //   523: goto -216 -> 307
    //   526: astore 6
    //   528: aconst_null
    //   529: astore_3
    //   530: aconst_null
    //   531: astore 4
    //   533: aconst_null
    //   534: astore 5
    //   536: aconst_null
    //   537: astore_0
    //   538: goto -387 -> 151
    //   541: astore 6
    //   543: aconst_null
    //   544: astore 7
    //   546: aconst_null
    //   547: astore 5
    //   549: aload 4
    //   551: astore_0
    //   552: aconst_null
    //   553: astore_3
    //   554: aload 7
    //   556: astore 4
    //   558: goto -407 -> 151
    //   561: astore 7
    //   563: aload 4
    //   565: astore_0
    //   566: aload 5
    //   568: astore_3
    //   569: aload 6
    //   571: astore 4
    //   573: aconst_null
    //   574: astore 5
    //   576: aload 7
    //   578: astore 6
    //   580: goto -429 -> 151
    //   583: astore 9
    //   585: aload 5
    //   587: astore 7
    //   589: aload 6
    //   591: astore 5
    //   593: aload_3
    //   594: astore 8
    //   596: aload 4
    //   598: astore_0
    //   599: aload 9
    //   601: astore 6
    //   603: aload 7
    //   605: astore_3
    //   606: aload 5
    //   608: astore 4
    //   610: aload 8
    //   612: astore 5
    //   614: goto -463 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	paramString	String
    //   112	11	1	i	int
    //   16	2	2	bool	boolean
    //   59	217	3	localObject1	Object
    //   288	2	3	localIOException1	java.io.IOException
    //   295	13	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   341	1	3	localObject2	Object
    //   361	2	3	localIOException2	java.io.IOException
    //   380	71	3	str	String
    //   457	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   477	1	3	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   494	17	3	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   514	92	3	localObject3	Object
    //   89	520	4	localObject4	Object
    //   98	515	5	localObject5	Object
    //   129	28	6	localException1	java.lang.Exception
    //   163	278	6	localObject6	Object
    //   447	5	6	localObject7	Object
    //   462	58	6	localObject8	Object
    //   526	1	6	localException2	java.lang.Exception
    //   541	29	6	localException3	java.lang.Exception
    //   578	24	6	localObject9	Object
    //   132	368	7	localObject10	Object
    //   508	5	7	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   517	38	7	localObject11	Object
    //   561	16	7	localException4	java.lang.Exception
    //   587	17	7	localObject12	Object
    //   1	147	8	localObject13	Object
    //   159	181	8	localObject14	Object
    //   594	17	8	localObject15	Object
    //   583	17	9	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   25	33	74	java/io/IOException
    //   37	45	74	java/io/IOException
    //   49	57	74	java/io/IOException
    //   64	72	74	java/io/IOException
    //   100	106	129	java/lang/Exception
    //   106	113	129	java/lang/Exception
    //   118	126	129	java/lang/Exception
    //   217	231	129	java/lang/Exception
    //   151	159	159	finally
    //   250	254	288	java/io/IOException
    //   259	264	288	java/io/IOException
    //   269	274	288	java/io/IOException
    //   281	286	288	java/io/IOException
    //   3	17	295	java/lang/OutOfMemoryError
    //   81	91	295	java/lang/OutOfMemoryError
    //   315	319	354	java/io/IOException
    //   324	329	354	java/io/IOException
    //   334	339	354	java/io/IOException
    //   347	352	354	java/io/IOException
    //   181	185	361	java/io/IOException
    //   190	195	361	java/io/IOException
    //   200	205	361	java/io/IOException
    //   210	215	361	java/io/IOException
    //   3	17	369	finally
    //   81	91	369	finally
    //   91	100	384	finally
    //   100	106	404	finally
    //   106	113	404	finally
    //   118	126	404	finally
    //   217	231	404	finally
    //   231	241	421	finally
    //   241	246	435	finally
    //   307	311	447	finally
    //   91	100	457	java/lang/OutOfMemoryError
    //   100	106	477	java/lang/OutOfMemoryError
    //   106	113	477	java/lang/OutOfMemoryError
    //   118	126	477	java/lang/OutOfMemoryError
    //   217	231	477	java/lang/OutOfMemoryError
    //   231	241	494	java/lang/OutOfMemoryError
    //   241	246	508	java/lang/OutOfMemoryError
    //   3	17	526	java/lang/Exception
    //   81	91	526	java/lang/Exception
    //   91	100	541	java/lang/Exception
    //   231	241	561	java/lang/Exception
    //   241	246	583	java/lang/Exception
  }
  
  private static String a()
  {
    if (a()) {
      return "_arm64_path";
    }
    return "_arm32_path";
  }
  
  public static String a(LoadParam.LoadItem paramLoadItem)
  {
    try
    {
      paramLoadItem = a("dynamic_so_load").getString("key_last_succ_" + paramLoadItem.name + a(), "");
      return paramLoadItem;
    }
    catch (Throwable paramLoadItem)
    {
      paramLoadItem.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append(paramThrowable.toString());
      if (paramThrowable.getStackTrace() != null)
      {
        paramThrowable = paramThrowable.getStackTrace();
        int i = 0;
        while ((i < paramThrowable.length) && (i < 16))
        {
          localStringBuilder.append("\n ");
          localStringBuilder.append(paramThrowable[i].toString());
          i += 1;
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static void a()
  {
    SharedPreferences localSharedPreferences = a("dynamic_so_load");
    long l = NetConnInfoCenter.getServerTimeMillis();
    localSharedPreferences.edit().putLong("key_last_rsp_time", l).apply();
  }
  
  public static void a(LoadParam.LoadItem paramLoadItem, String paramString)
  {
    try
    {
      a("dynamic_so_load").edit().putString("key_last_succ_" + paramLoadItem.name + a(), paramString).apply();
      return;
    }
    catch (Throwable paramLoadItem)
    {
      paramLoadItem.printStackTrace();
    }
  }
  
  /* Error */
  public static void a(Object paramObject, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 64	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 71	java/io/File:exists	()Z
    //   18: ifne +26 -> 44
    //   21: aload_1
    //   22: invokevirtual 212	java/io/File:getParentFile	()Ljava/io/File;
    //   25: invokevirtual 71	java/io/File:exists	()Z
    //   28: ifne +11 -> 39
    //   31: aload_1
    //   32: invokevirtual 212	java/io/File:getParentFile	()Ljava/io/File;
    //   35: invokevirtual 215	java/io/File:mkdirs	()Z
    //   38: pop
    //   39: aload_1
    //   40: invokevirtual 218	java/io/File:createNewFile	()Z
    //   43: pop
    //   44: new 220	java/io/FileOutputStream
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 221	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   52: astore_1
    //   53: new 84	java/io/ByteArrayOutputStream
    //   56: dup
    //   57: invokespecial 85	java/io/ByteArrayOutputStream:<init>	()V
    //   60: astore_3
    //   61: new 223	java/io/ObjectOutputStream
    //   64: dup
    //   65: aload_3
    //   66: invokespecial 226	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   69: astore_2
    //   70: aload_2
    //   71: aload_0
    //   72: invokevirtual 230	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   75: aload_2
    //   76: invokevirtual 233	java/io/ObjectOutputStream:flush	()V
    //   79: aload_3
    //   80: aload_1
    //   81: invokevirtual 236	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   84: aload_2
    //   85: ifnull +7 -> 92
    //   88: aload_2
    //   89: invokevirtual 237	java/io/ObjectOutputStream:close	()V
    //   92: aload_3
    //   93: ifnull +7 -> 100
    //   96: aload_3
    //   97: invokevirtual 103	java/io/ByteArrayOutputStream:close	()V
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 238	java/io/FileOutputStream:close	()V
    //   108: return
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   114: return
    //   115: astore 4
    //   117: aconst_null
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_2
    //   121: aload_3
    //   122: astore_1
    //   123: aload 4
    //   125: astore_3
    //   126: aload_3
    //   127: invokevirtual 156	java/lang/Throwable:printStackTrace	()V
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 237	java/io/ObjectOutputStream:close	()V
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 103	java/io/ByteArrayOutputStream:close	()V
    //   146: aload_1
    //   147: ifnull -39 -> 108
    //   150: aload_1
    //   151: invokevirtual 238	java/io/FileOutputStream:close	()V
    //   154: return
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   160: return
    //   161: astore_0
    //   162: aconst_null
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_2
    //   166: aload 4
    //   168: astore_1
    //   169: aload_2
    //   170: ifnull +7 -> 177
    //   173: aload_2
    //   174: invokevirtual 237	java/io/ObjectOutputStream:close	()V
    //   177: aload_3
    //   178: ifnull +7 -> 185
    //   181: aload_3
    //   182: invokevirtual 103	java/io/ByteArrayOutputStream:close	()V
    //   185: aload_1
    //   186: ifnull +7 -> 193
    //   189: aload_1
    //   190: invokevirtual 238	java/io/FileOutputStream:close	()V
    //   193: aload_0
    //   194: athrow
    //   195: astore_1
    //   196: aload_1
    //   197: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   200: goto -7 -> 193
    //   203: astore_0
    //   204: aconst_null
    //   205: astore_3
    //   206: aconst_null
    //   207: astore_2
    //   208: goto -39 -> 169
    //   211: astore_0
    //   212: aconst_null
    //   213: astore_2
    //   214: goto -45 -> 169
    //   217: astore_0
    //   218: goto -49 -> 169
    //   221: astore 4
    //   223: aload_0
    //   224: astore_3
    //   225: aload 4
    //   227: astore_0
    //   228: goto -59 -> 169
    //   231: astore_3
    //   232: aconst_null
    //   233: astore_2
    //   234: aconst_null
    //   235: astore_0
    //   236: goto -110 -> 126
    //   239: astore 4
    //   241: aload_3
    //   242: astore_0
    //   243: aconst_null
    //   244: astore_2
    //   245: aload 4
    //   247: astore_3
    //   248: goto -122 -> 126
    //   251: astore 4
    //   253: aload_3
    //   254: astore_0
    //   255: aload 4
    //   257: astore_3
    //   258: goto -132 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramObject	Object
    //   0	261	1	paramString	String
    //   69	176	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   4	221	3	localObject1	Object
    //   231	11	3	localThrowable1	Throwable
    //   247	11	3	localThrowable2	Throwable
    //   1	1	4	localObject2	Object
    //   115	52	4	localThrowable3	Throwable
    //   221	5	4	localObject3	Object
    //   239	7	4	localThrowable4	Throwable
    //   251	5	4	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   88	92	109	java/io/IOException
    //   96	100	109	java/io/IOException
    //   104	108	109	java/io/IOException
    //   5	39	115	java/lang/Throwable
    //   39	44	115	java/lang/Throwable
    //   44	53	115	java/lang/Throwable
    //   134	138	155	java/io/IOException
    //   142	146	155	java/io/IOException
    //   150	154	155	java/io/IOException
    //   5	39	161	finally
    //   39	44	161	finally
    //   44	53	161	finally
    //   173	177	195	java/io/IOException
    //   181	185	195	java/io/IOException
    //   189	193	195	java/io/IOException
    //   53	61	203	finally
    //   61	70	211	finally
    //   70	84	217	finally
    //   126	130	221	finally
    //   53	61	231	java/lang/Throwable
    //   61	70	239	java/lang/Throwable
    //   70	84	251	java/lang/Throwable
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_JavaLangBoolean == null)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        break label28;
      }
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    }
    for (;;)
    {
      return jdField_a_of_type_JavaLangBoolean.booleanValue();
      label28:
      if (Build.VERSION.SDK_INT >= 23) {
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(Process.is64Bit());
      } else {
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramString1 == null) && (paramString2 == null)) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        if (paramString1 == null) {
          break;
        }
        bool1 = bool2;
      } while (paramString2 == null);
      if (paramString1 != null) {
        break;
      }
      bool1 = bool2;
    } while (paramString2 != null);
    return paramString1.equals(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.util.SoDataUtil
 * JD-Core Version:    0.7.0.1
 */