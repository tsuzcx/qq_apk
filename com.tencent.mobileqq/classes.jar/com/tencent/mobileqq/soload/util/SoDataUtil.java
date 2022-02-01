package com.tencent.mobileqq.soload.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

public class SoDataUtil
{
  private static final Map<String, SharedPreferences> a = new HashMap();
  private static Boolean b = null;
  
  public static long a()
  {
    return a("dynamic_so_load").getLong("key_last_rsp_time", 0L);
  }
  
  public static SharedPreferences a(String paramString)
  {
    SharedPreferences localSharedPreferences2 = (SharedPreferences)a.get(paramString);
    SharedPreferences localSharedPreferences1 = localSharedPreferences2;
    if (localSharedPreferences2 == null)
    {
      localSharedPreferences1 = MobileQQ.sMobileQQ.getSharedPreferences(paramString, 4);
      a.put(paramString, localSharedPreferences1);
    }
    return localSharedPreferences1;
  }
  
  public static String a(LoadParam.LoadItem paramLoadItem)
  {
    try
    {
      SharedPreferences localSharedPreferences = a("dynamic_so_load");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_last_succ_");
      localStringBuilder.append(paramLoadItem.name);
      localStringBuilder.append(d());
      paramLoadItem = localSharedPreferences.getString(localStringBuilder.toString(), "");
      return paramLoadItem;
    }
    catch (Throwable paramLoadItem)
    {
      paramLoadItem.printStackTrace();
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
  
  public static void a(LoadParam.LoadItem paramLoadItem, String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = a("dynamic_so_load").edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_last_succ_");
      localStringBuilder.append(paramLoadItem.name);
      localStringBuilder.append(d());
      localEditor.putString(localStringBuilder.toString(), paramString).apply();
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
    //   5: aconst_null
    //   6: astore 7
    //   8: new 123	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_1
    //   18: invokevirtual 130	java/io/File:exists	()Z
    //   21: ifne +26 -> 47
    //   24: aload_1
    //   25: invokevirtual 134	java/io/File:getParentFile	()Ljava/io/File;
    //   28: invokevirtual 130	java/io/File:exists	()Z
    //   31: ifne +11 -> 42
    //   34: aload_1
    //   35: invokevirtual 134	java/io/File:getParentFile	()Ljava/io/File;
    //   38: invokevirtual 137	java/io/File:mkdirs	()Z
    //   41: pop
    //   42: aload_1
    //   43: invokevirtual 140	java/io/File:createNewFile	()Z
    //   46: pop
    //   47: new 142	java/io/FileOutputStream
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 145	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   55: astore_2
    //   56: new 147	java/io/ByteArrayOutputStream
    //   59: dup
    //   60: invokespecial 148	java/io/ByteArrayOutputStream:<init>	()V
    //   63: astore_1
    //   64: aload 4
    //   66: astore_3
    //   67: aload_1
    //   68: astore 4
    //   70: aload_2
    //   71: astore 6
    //   73: new 150	java/io/ObjectOutputStream
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 153	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   81: astore 5
    //   83: aload 5
    //   85: aload_0
    //   86: invokevirtual 157	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   89: aload 5
    //   91: invokevirtual 160	java/io/ObjectOutputStream:flush	()V
    //   94: aload_1
    //   95: aload_2
    //   96: invokevirtual 163	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   99: aload 5
    //   101: invokevirtual 166	java/io/ObjectOutputStream:close	()V
    //   104: aload_1
    //   105: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   108: aload_2
    //   109: invokevirtual 168	java/io/FileOutputStream:close	()V
    //   112: return
    //   113: astore 4
    //   115: aload 5
    //   117: astore_3
    //   118: aload_1
    //   119: astore_0
    //   120: aload 4
    //   122: astore_1
    //   123: goto +111 -> 234
    //   126: astore_3
    //   127: aload_1
    //   128: astore_0
    //   129: aload_3
    //   130: astore_1
    //   131: goto +48 -> 179
    //   134: astore_3
    //   135: aload 7
    //   137: astore 5
    //   139: aload_1
    //   140: astore_0
    //   141: aload_3
    //   142: astore_1
    //   143: goto +36 -> 179
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_0
    //   149: goto +85 -> 234
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_0
    //   155: aload 7
    //   157: astore 5
    //   159: goto +20 -> 179
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: astore_0
    //   167: goto +67 -> 234
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_2
    //   173: aload_2
    //   174: astore_0
    //   175: aload 7
    //   177: astore 5
    //   179: aload 5
    //   181: astore_3
    //   182: aload_0
    //   183: astore 4
    //   185: aload_2
    //   186: astore 6
    //   188: aload_1
    //   189: invokevirtual 90	java/lang/Throwable:printStackTrace	()V
    //   192: aload 5
    //   194: ifnull +11 -> 205
    //   197: aload 5
    //   199: invokevirtual 166	java/io/ObjectOutputStream:close	()V
    //   202: goto +3 -> 205
    //   205: aload_0
    //   206: ifnull +7 -> 213
    //   209: aload_0
    //   210: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   213: aload_2
    //   214: ifnull +12 -> 226
    //   217: aload_2
    //   218: invokevirtual 168	java/io/FileOutputStream:close	()V
    //   221: return
    //   222: aload_0
    //   223: invokevirtual 169	java/io/IOException:printStackTrace	()V
    //   226: return
    //   227: astore_1
    //   228: aload 6
    //   230: astore_2
    //   231: aload 4
    //   233: astore_0
    //   234: aload_3
    //   235: ifnull +10 -> 245
    //   238: aload_3
    //   239: invokevirtual 166	java/io/ObjectOutputStream:close	()V
    //   242: goto +3 -> 245
    //   245: aload_0
    //   246: ifnull +7 -> 253
    //   249: aload_0
    //   250: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   253: aload_2
    //   254: ifnull +14 -> 268
    //   257: aload_2
    //   258: invokevirtual 168	java/io/FileOutputStream:close	()V
    //   261: goto +7 -> 268
    //   264: aload_0
    //   265: invokevirtual 169	java/io/IOException:printStackTrace	()V
    //   268: aload_1
    //   269: athrow
    //   270: astore_0
    //   271: goto -49 -> 222
    //   274: astore_0
    //   275: goto -11 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramObject	Object
    //   0	278	1	paramString	String
    //   55	203	2	localObject1	Object
    //   4	114	3	localObject2	Object
    //   126	4	3	localThrowable1	Throwable
    //   134	8	3	localThrowable2	Throwable
    //   181	58	3	localObject3	Object
    //   1	68	4	str	String
    //   113	8	4	localObject4	Object
    //   183	49	4	localObject5	Object
    //   81	117	5	localObject6	Object
    //   71	158	6	localObject7	Object
    //   6	170	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   83	99	113	finally
    //   83	99	126	java/lang/Throwable
    //   73	83	134	java/lang/Throwable
    //   56	64	146	finally
    //   56	64	152	java/lang/Throwable
    //   8	42	162	finally
    //   42	47	162	finally
    //   47	56	162	finally
    //   8	42	170	java/lang/Throwable
    //   42	47	170	java/lang/Throwable
    //   47	56	170	java/lang/Throwable
    //   73	83	227	finally
    //   188	192	227	finally
    //   99	112	270	java/io/IOException
    //   197	202	270	java/io/IOException
    //   209	213	270	java/io/IOException
    //   217	221	270	java/io/IOException
    //   238	242	274	java/io/IOException
    //   249	253	274	java/io/IOException
    //   257	261	274	java/io/IOException
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return true;
    }
    if ((paramString1 != null) && (paramString2 == null)) {
      return false;
    }
    if ((paramString1 == null) && (paramString2 != null)) {
      return false;
    }
    return paramString1.equals(paramString2);
  }
  
  public static String b(String paramString)
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
  
  public static void b()
  {
    SharedPreferences localSharedPreferences = a("dynamic_so_load");
    long l = NetConnInfoCenter.getServerTimeMillis();
    localSharedPreferences.edit().putLong("key_last_rsp_time", l).apply();
  }
  
  /* Error */
  public static Object c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: new 123	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokevirtual 130	java/io/File:exists	()Z
    //   19: ifne +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: new 207	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 208	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore_0
    //   33: new 147	java/io/ByteArrayOutputStream
    //   36: dup
    //   37: invokespecial 148	java/io/ByteArrayOutputStream:<init>	()V
    //   40: astore 4
    //   42: sipush 1024
    //   45: newarray byte
    //   47: astore_2
    //   48: aload_0
    //   49: aload_2
    //   50: invokevirtual 212	java/io/FileInputStream:read	([B)I
    //   53: istore_1
    //   54: iload_1
    //   55: iconst_m1
    //   56: if_icmpeq +14 -> 70
    //   59: aload 4
    //   61: aload_2
    //   62: iconst_0
    //   63: iload_1
    //   64: invokevirtual 216	java/io/ByteArrayOutputStream:write	([BII)V
    //   67: goto -19 -> 48
    //   70: new 218	java/io/ByteArrayInputStream
    //   73: dup
    //   74: aload 4
    //   76: invokevirtual 222	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   79: invokespecial 225	java/io/ByteArrayInputStream:<init>	([B)V
    //   82: astore_2
    //   83: new 227	java/io/ObjectInputStream
    //   86: dup
    //   87: aload_2
    //   88: invokespecial 230	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   91: astore_3
    //   92: aload_3
    //   93: invokevirtual 234	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   96: astore 5
    //   98: aload_3
    //   99: invokevirtual 235	java/io/ObjectInputStream:close	()V
    //   102: aload_2
    //   103: invokevirtual 236	java/io/ByteArrayInputStream:close	()V
    //   106: aload 4
    //   108: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   111: aload_0
    //   112: invokevirtual 237	java/io/FileInputStream:close	()V
    //   115: aload 5
    //   117: areturn
    //   118: astore_0
    //   119: aload_0
    //   120: invokevirtual 169	java/io/IOException:printStackTrace	()V
    //   123: aload 5
    //   125: areturn
    //   126: astore 5
    //   128: aload_0
    //   129: astore 6
    //   131: aload_2
    //   132: astore 7
    //   134: aload 5
    //   136: astore_0
    //   137: aload_3
    //   138: astore 5
    //   140: aload 6
    //   142: astore_2
    //   143: aload 7
    //   145: astore_3
    //   146: goto +329 -> 475
    //   149: astore 6
    //   151: aload_0
    //   152: astore 5
    //   154: aload_2
    //   155: astore 7
    //   157: aload 6
    //   159: astore_0
    //   160: aload 4
    //   162: astore 6
    //   164: aload_0
    //   165: astore 4
    //   167: aload_3
    //   168: astore_0
    //   169: aload 5
    //   171: astore_2
    //   172: aload 7
    //   174: astore_3
    //   175: goto +219 -> 394
    //   178: astore 5
    //   180: aload_0
    //   181: astore 6
    //   183: aload_2
    //   184: astore 7
    //   186: aload 5
    //   188: astore_0
    //   189: aload_3
    //   190: astore 5
    //   192: aload 6
    //   194: astore_2
    //   195: aload 7
    //   197: astore_3
    //   198: goto +270 -> 468
    //   201: astore 5
    //   203: aload_0
    //   204: astore_3
    //   205: aload_2
    //   206: astore 6
    //   208: aload 5
    //   210: astore_0
    //   211: aload 7
    //   213: astore 5
    //   215: aload_3
    //   216: astore_2
    //   217: aload 6
    //   219: astore_3
    //   220: goto +255 -> 475
    //   223: astore 6
    //   225: aload_0
    //   226: astore_3
    //   227: aload_2
    //   228: astore 5
    //   230: aload 6
    //   232: astore_0
    //   233: aconst_null
    //   234: astore_2
    //   235: aload 4
    //   237: astore 6
    //   239: aload_0
    //   240: astore 4
    //   242: aload_2
    //   243: astore_0
    //   244: aload_3
    //   245: astore_2
    //   246: aload 5
    //   248: astore_3
    //   249: goto +145 -> 394
    //   252: astore 7
    //   254: aload_0
    //   255: astore_3
    //   256: aload_2
    //   257: astore 6
    //   259: aload 7
    //   261: astore_0
    //   262: aload_3
    //   263: astore_2
    //   264: aload 6
    //   266: astore_3
    //   267: goto +201 -> 468
    //   270: astore 6
    //   272: aload_0
    //   273: astore_2
    //   274: aconst_null
    //   275: astore_3
    //   276: aload 7
    //   278: astore 5
    //   280: aload 6
    //   282: astore_0
    //   283: goto +192 -> 475
    //   286: astore 5
    //   288: aload_0
    //   289: astore_2
    //   290: aconst_null
    //   291: astore_3
    //   292: aload_3
    //   293: astore_0
    //   294: aload 4
    //   296: astore 6
    //   298: aload 5
    //   300: astore 4
    //   302: goto +92 -> 394
    //   305: astore 6
    //   307: aload_0
    //   308: astore_2
    //   309: aconst_null
    //   310: astore_3
    //   311: aload 6
    //   313: astore_0
    //   314: goto +154 -> 468
    //   317: astore 6
    //   319: aload_0
    //   320: astore_2
    //   321: aconst_null
    //   322: astore_3
    //   323: aload_3
    //   324: astore 4
    //   326: aload 7
    //   328: astore 5
    //   330: aload 6
    //   332: astore_0
    //   333: goto +142 -> 475
    //   336: astore 4
    //   338: aload_0
    //   339: astore_2
    //   340: aconst_null
    //   341: astore_3
    //   342: aload_3
    //   343: astore 6
    //   345: aload 6
    //   347: astore_0
    //   348: goto +46 -> 394
    //   351: astore 6
    //   353: aload_0
    //   354: astore_2
    //   355: aconst_null
    //   356: astore_3
    //   357: aload_3
    //   358: astore 4
    //   360: aload 6
    //   362: astore_0
    //   363: goto +105 -> 468
    //   366: astore_0
    //   367: aconst_null
    //   368: astore_3
    //   369: aload_3
    //   370: astore 4
    //   372: aload 4
    //   374: astore_2
    //   375: aload 7
    //   377: astore 5
    //   379: goto +96 -> 475
    //   382: astore 4
    //   384: aconst_null
    //   385: astore_3
    //   386: aload_3
    //   387: astore 6
    //   389: aload 6
    //   391: astore_0
    //   392: aload_0
    //   393: astore_2
    //   394: aload 4
    //   396: invokevirtual 238	java/lang/OutOfMemoryError:printStackTrace	()V
    //   399: aload_0
    //   400: ifnull +10 -> 410
    //   403: aload_0
    //   404: invokevirtual 235	java/io/ObjectInputStream:close	()V
    //   407: goto +3 -> 410
    //   410: aload_3
    //   411: ifnull +7 -> 418
    //   414: aload_3
    //   415: invokevirtual 236	java/io/ByteArrayInputStream:close	()V
    //   418: aload 6
    //   420: ifnull +8 -> 428
    //   423: aload 6
    //   425: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   428: aload_2
    //   429: ifnull +13 -> 442
    //   432: aload_2
    //   433: invokevirtual 237	java/io/FileInputStream:close	()V
    //   436: aconst_null
    //   437: areturn
    //   438: aload_0
    //   439: invokevirtual 169	java/io/IOException:printStackTrace	()V
    //   442: aconst_null
    //   443: areturn
    //   444: astore 7
    //   446: aload_0
    //   447: astore 5
    //   449: aload 6
    //   451: astore 4
    //   453: aload 7
    //   455: astore_0
    //   456: goto +19 -> 475
    //   459: astore_0
    //   460: aconst_null
    //   461: astore_3
    //   462: aload_3
    //   463: astore 4
    //   465: aload 4
    //   467: astore_2
    //   468: aload_0
    //   469: invokevirtual 239	java/lang/Exception:printStackTrace	()V
    //   472: aload_0
    //   473: athrow
    //   474: astore_0
    //   475: aload 5
    //   477: ifnull +11 -> 488
    //   480: aload 5
    //   482: invokevirtual 235	java/io/ObjectInputStream:close	()V
    //   485: goto +3 -> 488
    //   488: aload_3
    //   489: ifnull +7 -> 496
    //   492: aload_3
    //   493: invokevirtual 236	java/io/ByteArrayInputStream:close	()V
    //   496: aload 4
    //   498: ifnull +8 -> 506
    //   501: aload 4
    //   503: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   506: aload_2
    //   507: ifnull +14 -> 521
    //   510: aload_2
    //   511: invokevirtual 237	java/io/FileInputStream:close	()V
    //   514: goto +7 -> 521
    //   517: aload_2
    //   518: invokevirtual 169	java/io/IOException:printStackTrace	()V
    //   521: goto +5 -> 526
    //   524: aload_0
    //   525: athrow
    //   526: goto -2 -> 524
    //   529: astore_0
    //   530: goto -92 -> 438
    //   533: astore_2
    //   534: goto -17 -> 517
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	paramString	String
    //   53	11	1	i	int
    //   47	471	2	localObject1	Object
    //   533	1	2	localIOException	java.io.IOException
    //   91	402	3	localObject2	Object
    //   40	285	4	localObject3	Object
    //   336	1	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   358	15	4	localObject4	Object
    //   382	13	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   451	51	4	localObject5	Object
    //   4	120	5	localObject6	Object
    //   126	9	5	localObject7	Object
    //   138	32	5	localObject8	Object
    //   178	9	5	localException1	java.lang.Exception
    //   190	1	5	localObject9	Object
    //   201	8	5	localObject10	Object
    //   213	66	5	localObject11	Object
    //   286	13	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   328	153	5	localObject12	Object
    //   129	12	6	str	String
    //   149	9	6	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   162	56	6	localObject13	Object
    //   223	8	6	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   237	28	6	localObject14	Object
    //   270	11	6	localObject15	Object
    //   296	1	6	localObject16	Object
    //   305	7	6	localException2	java.lang.Exception
    //   317	14	6	localObject17	Object
    //   343	3	6	localObject18	Object
    //   351	10	6	localException3	java.lang.Exception
    //   387	63	6	localObject19	Object
    //   1	211	7	localObject20	Object
    //   252	124	7	localException4	java.lang.Exception
    //   444	10	7	localObject21	Object
    // Exception table:
    //   from	to	target	type
    //   98	115	118	java/io/IOException
    //   92	98	126	finally
    //   92	98	149	java/lang/OutOfMemoryError
    //   92	98	178	java/lang/Exception
    //   83	92	201	finally
    //   83	92	223	java/lang/OutOfMemoryError
    //   83	92	252	java/lang/Exception
    //   42	48	270	finally
    //   48	54	270	finally
    //   59	67	270	finally
    //   70	83	270	finally
    //   42	48	286	java/lang/OutOfMemoryError
    //   48	54	286	java/lang/OutOfMemoryError
    //   59	67	286	java/lang/OutOfMemoryError
    //   70	83	286	java/lang/OutOfMemoryError
    //   42	48	305	java/lang/Exception
    //   48	54	305	java/lang/Exception
    //   59	67	305	java/lang/Exception
    //   70	83	305	java/lang/Exception
    //   33	42	317	finally
    //   33	42	336	java/lang/OutOfMemoryError
    //   33	42	351	java/lang/Exception
    //   6	22	366	finally
    //   24	33	366	finally
    //   6	22	382	java/lang/OutOfMemoryError
    //   24	33	382	java/lang/OutOfMemoryError
    //   394	399	444	finally
    //   6	22	459	java/lang/Exception
    //   24	33	459	java/lang/Exception
    //   468	474	474	finally
    //   403	407	529	java/io/IOException
    //   414	418	529	java/io/IOException
    //   423	428	529	java/io/IOException
    //   432	436	529	java/io/IOException
    //   480	485	533	java/io/IOException
    //   492	496	533	java/io/IOException
    //   501	506	533	java/io/IOException
    //   510	514	533	java/io/IOException
  }
  
  public static boolean c()
  {
    if (b == null) {
      if (Build.VERSION.SDK_INT < 21) {
        b = Boolean.valueOf(false);
      } else if (Build.VERSION.SDK_INT >= 23) {
        b = Boolean.valueOf(Process.is64Bit());
      } else {
        b = Boolean.valueOf(false);
      }
    }
    return b.booleanValue();
  }
  
  public static int d(String paramString)
  {
    try
    {
      boolean bool = new File(paramString).exists();
      if (bool) {
        return 2;
      }
      return 1;
    }
    catch (Throwable paramString)
    {
      QLog.e("getFileExistStatus", 1, paramString, new Object[0]);
    }
    return 3;
  }
  
  private static String d()
  {
    if (c()) {
      return "_arm64_path";
    }
    return "_arm32_path";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.util.SoDataUtil
 * JD-Core Version:    0.7.0.1
 */