package com.tencent.mobileqq.unifiedebug;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class UnifiedFileUtil
{
  private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
  private static JSONObject a(File paramFile)
  {
    boolean bool = paramFile.isDirectory();
    int k = 0;
    int i;
    if (bool) {
      i = 8;
    } else {
      i = 0;
    }
    int j;
    if (paramFile.canWrite()) {
      j = 4;
    } else {
      j = 0;
    }
    if (paramFile.canRead()) {
      k = 2;
    }
    bool = paramFile.canExecute();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("permission", Integer.toOctalString(i | 0x0 | j | k | bool));
    localJSONObject.put("lastModified", a.format(new Date(paramFile.lastModified())));
    return localJSONObject;
  }
  
  /* Error */
  public static void a(File paramFile, List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +495 -> 496
    //   4: aload_1
    //   5: ifnull +491 -> 496
    //   8: aload_1
    //   9: invokeinterface 74 1 0
    //   14: ifeq +4 -> 18
    //   17: return
    //   18: aconst_null
    //   19: astore 8
    //   21: aconst_null
    //   22: astore 7
    //   24: iconst_0
    //   25: istore 4
    //   27: iconst_0
    //   28: istore 5
    //   30: iconst_0
    //   31: istore_3
    //   32: new 76	java/io/FileOutputStream
    //   35: dup
    //   36: new 24	java/io/File
    //   39: dup
    //   40: aload_2
    //   41: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   47: astore 6
    //   49: new 82	java/util/zip/ZipOutputStream
    //   52: dup
    //   53: aload 6
    //   55: invokespecial 85	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   58: astore 7
    //   60: aload_1
    //   61: invokeinterface 89 1 0
    //   66: astore_1
    //   67: aload_1
    //   68: invokeinterface 94 1 0
    //   73: ifeq +37 -> 110
    //   76: aload 7
    //   78: new 24	java/io/File
    //   81: dup
    //   82: aload_0
    //   83: aload_1
    //   84: invokeinterface 98 1 0
    //   89: checkcast 100	java/lang/String
    //   92: invokespecial 103	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   95: aload_0
    //   96: invokevirtual 107	java/io/File:getPath	()Ljava/lang/String;
    //   99: invokevirtual 111	java/lang/String:length	()I
    //   102: iconst_1
    //   103: iadd
    //   104: invokestatic 114	com/tencent/mobileqq/unifiedebug/UnifiedFileUtil:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;I)V
    //   107: goto -40 -> 67
    //   110: aload 7
    //   112: invokevirtual 117	java/util/zip/ZipOutputStream:close	()V
    //   115: aload 6
    //   117: invokevirtual 118	java/io/FileOutputStream:close	()V
    //   120: return
    //   121: astore_0
    //   122: new 120	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   129: astore_1
    //   130: aload_1
    //   131: ldc 123
    //   133: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_1
    //   138: aload_0
    //   139: invokevirtual 130	java/io/IOException:getMessage	()Ljava/lang/String;
    //   142: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: ldc 132
    //   148: iconst_1
    //   149: aload_1
    //   150: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload_0
    //   157: invokevirtual 145	java/io/IOException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   160: astore_0
    //   161: iload_3
    //   162: aload_0
    //   163: arraylength
    //   164: if_icmpge +230 -> 394
    //   167: ldc 132
    //   169: iconst_1
    //   170: aload_0
    //   171: iload_3
    //   172: aaload
    //   173: invokevirtual 148	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   176: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: iload_3
    //   180: iconst_1
    //   181: iadd
    //   182: istore_3
    //   183: goto -22 -> 161
    //   186: astore_1
    //   187: aload 7
    //   189: astore_0
    //   190: goto +13 -> 203
    //   193: astore_2
    //   194: aload 7
    //   196: astore_1
    //   197: goto +18 -> 215
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_0
    //   203: aload 6
    //   205: astore_2
    //   206: aload_0
    //   207: astore 6
    //   209: goto +194 -> 403
    //   212: astore_2
    //   213: aconst_null
    //   214: astore_1
    //   215: aload 6
    //   217: astore_0
    //   218: goto +19 -> 237
    //   221: astore_1
    //   222: aconst_null
    //   223: astore 6
    //   225: aload 8
    //   227: astore_2
    //   228: goto +175 -> 403
    //   231: astore_2
    //   232: aconst_null
    //   233: astore_1
    //   234: aload 7
    //   236: astore_0
    //   237: new 120	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   244: astore 6
    //   246: aload 6
    //   248: ldc 123
    //   250: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 6
    //   256: aload_2
    //   257: invokevirtual 130	java/io/IOException:getMessage	()Ljava/lang/String;
    //   260: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: ldc 132
    //   266: iconst_1
    //   267: aload 6
    //   269: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_2
    //   276: invokevirtual 145	java/io/IOException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   279: astore_2
    //   280: iconst_0
    //   281: istore_3
    //   282: iload_3
    //   283: aload_2
    //   284: arraylength
    //   285: if_icmpge +22 -> 307
    //   288: ldc 132
    //   290: iconst_1
    //   291: aload_2
    //   292: iload_3
    //   293: aaload
    //   294: invokevirtual 148	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   297: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: iload_3
    //   301: iconst_1
    //   302: iadd
    //   303: istore_3
    //   304: goto -22 -> 282
    //   307: aload_1
    //   308: ifnull +10 -> 318
    //   311: aload_1
    //   312: invokevirtual 117	java/util/zip/ZipOutputStream:close	()V
    //   315: goto +3 -> 318
    //   318: aload_0
    //   319: ifnull +75 -> 394
    //   322: aload_0
    //   323: invokevirtual 118	java/io/FileOutputStream:close	()V
    //   326: return
    //   327: new 120	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   334: astore_0
    //   335: aload_0
    //   336: ldc 123
    //   338: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload_0
    //   343: aload_1
    //   344: invokevirtual 130	java/io/IOException:getMessage	()Ljava/lang/String;
    //   347: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: ldc 132
    //   353: iconst_1
    //   354: aload_0
    //   355: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload_1
    //   362: invokevirtual 145	java/io/IOException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   365: astore_0
    //   366: iload 4
    //   368: istore_3
    //   369: iload_3
    //   370: aload_0
    //   371: arraylength
    //   372: if_icmpge +22 -> 394
    //   375: ldc 132
    //   377: iconst_1
    //   378: aload_0
    //   379: iload_3
    //   380: aaload
    //   381: invokevirtual 148	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   384: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: iload_3
    //   388: iconst_1
    //   389: iadd
    //   390: istore_3
    //   391: goto -22 -> 369
    //   394: return
    //   395: astore_2
    //   396: aload_1
    //   397: astore 6
    //   399: aload_2
    //   400: astore_1
    //   401: aload_0
    //   402: astore_2
    //   403: aload 6
    //   405: ifnull +11 -> 416
    //   408: aload 6
    //   410: invokevirtual 117	java/util/zip/ZipOutputStream:close	()V
    //   413: goto +3 -> 416
    //   416: aload_2
    //   417: ifnull +77 -> 494
    //   420: aload_2
    //   421: invokevirtual 118	java/io/FileOutputStream:close	()V
    //   424: goto +70 -> 494
    //   427: new 120	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   434: astore_0
    //   435: aload_0
    //   436: ldc 123
    //   438: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload_0
    //   443: aload_2
    //   444: invokevirtual 130	java/io/IOException:getMessage	()Ljava/lang/String;
    //   447: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: ldc 132
    //   453: iconst_1
    //   454: aload_0
    //   455: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   461: aload_2
    //   462: invokevirtual 145	java/io/IOException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   465: astore_0
    //   466: iload 5
    //   468: istore_3
    //   469: iload_3
    //   470: aload_0
    //   471: arraylength
    //   472: if_icmpge +22 -> 494
    //   475: ldc 132
    //   477: iconst_1
    //   478: aload_0
    //   479: iload_3
    //   480: aaload
    //   481: invokevirtual 148	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   484: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: iload_3
    //   488: iconst_1
    //   489: iadd
    //   490: istore_3
    //   491: goto -22 -> 469
    //   494: aload_1
    //   495: athrow
    //   496: return
    //   497: astore_1
    //   498: goto -171 -> 327
    //   501: astore_2
    //   502: goto -75 -> 427
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	paramFile	File
    //   0	505	1	paramList	List<String>
    //   0	505	2	paramString	String
    //   31	460	3	i	int
    //   25	342	4	j	int
    //   28	439	5	k	int
    //   47	362	6	localObject1	Object
    //   22	213	7	localZipOutputStream	ZipOutputStream
    //   19	207	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   110	120	121	java/io/IOException
    //   60	67	186	finally
    //   67	107	186	finally
    //   60	67	193	java/io/IOException
    //   67	107	193	java/io/IOException
    //   49	60	200	finally
    //   49	60	212	java/io/IOException
    //   32	49	221	finally
    //   32	49	231	java/io/IOException
    //   237	280	395	finally
    //   282	300	395	finally
    //   311	315	497	java/io/IOException
    //   322	326	497	java/io/IOException
    //   408	413	501	java/io/IOException
    //   420	424	501	java/io/IOException
  }
  
  public static void a(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        File localFile = new File((String)paramList.next());
        if ((localFile.exists()) && (localFile.isFile())) {
          localFile.delete();
        }
      }
    }
  }
  
  /* Error */
  public static void a(List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 82	java/util/zip/ZipOutputStream
    //   8: dup
    //   9: new 76	java/io/FileOutputStream
    //   12: dup
    //   13: new 24	java/io/File
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   24: invokespecial 85	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore 7
    //   29: aload_0
    //   30: invokeinterface 89 1 0
    //   35: astore 9
    //   37: aload 9
    //   39: invokeinterface 94 1 0
    //   44: ifeq +232 -> 276
    //   47: aload 9
    //   49: invokeinterface 98 1 0
    //   54: checkcast 100	java/lang/String
    //   57: astore 10
    //   59: new 24	java/io/File
    //   62: dup
    //   63: aload 10
    //   65: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 154	java/io/File:exists	()Z
    //   73: ifeq -36 -> 37
    //   76: aload_0
    //   77: invokevirtual 164	java/io/File:length	()J
    //   80: lstore 5
    //   82: new 166	java/io/FileInputStream
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 167	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   90: astore_1
    //   91: aload 7
    //   93: new 169	java/util/zip/ZipEntry
    //   96: dup
    //   97: aload_0
    //   98: invokevirtual 172	java/io/File:getName	()Ljava/lang/String;
    //   101: invokespecial 173	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   104: invokevirtual 177	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   107: aload 7
    //   109: bipush 9
    //   111: invokevirtual 181	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   114: sipush 20480
    //   117: newarray byte
    //   119: astore_0
    //   120: lconst_0
    //   121: lstore_3
    //   122: aload_1
    //   123: aload_0
    //   124: iconst_0
    //   125: sipush 20480
    //   128: invokevirtual 185	java/io/FileInputStream:read	([BII)I
    //   131: istore_2
    //   132: iload_2
    //   133: iconst_m1
    //   134: if_icmpeq +29 -> 163
    //   137: aload 7
    //   139: aload_0
    //   140: iconst_0
    //   141: iload_2
    //   142: invokevirtual 189	java/util/zip/ZipOutputStream:write	([BII)V
    //   145: lload_3
    //   146: iload_2
    //   147: i2l
    //   148: ladd
    //   149: lstore_3
    //   150: lload_3
    //   151: lload 5
    //   153: lcmp
    //   154: iflt +6 -> 160
    //   157: goto +6 -> 163
    //   160: goto -38 -> 122
    //   163: aload_1
    //   164: invokevirtual 190	java/io/FileInputStream:close	()V
    //   167: aload 7
    //   169: invokevirtual 193	java/util/zip/ZipOutputStream:flush	()V
    //   172: aload 7
    //   174: invokevirtual 196	java/util/zip/ZipOutputStream:closeEntry	()V
    //   177: goto -140 -> 37
    //   180: astore_0
    //   181: goto +75 -> 256
    //   184: astore 8
    //   186: aload_1
    //   187: astore_0
    //   188: aload 8
    //   190: astore_1
    //   191: goto +12 -> 203
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_1
    //   197: goto +59 -> 256
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_0
    //   203: new 120	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   210: astore 8
    //   212: aload 8
    //   214: ldc 198
    //   216: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 8
    //   222: aload 10
    //   224: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: ldc 132
    //   230: iconst_1
    //   231: aload 8
    //   233: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: aload_1
    //   237: invokestatic 201	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   240: aload_0
    //   241: ifnull +7 -> 248
    //   244: aload_0
    //   245: invokevirtual 190	java/io/FileInputStream:close	()V
    //   248: aload 7
    //   250: invokevirtual 193	java/util/zip/ZipOutputStream:flush	()V
    //   253: goto -81 -> 172
    //   256: aload_1
    //   257: ifnull +7 -> 264
    //   260: aload_1
    //   261: invokevirtual 190	java/io/FileInputStream:close	()V
    //   264: aload 7
    //   266: invokevirtual 193	java/util/zip/ZipOutputStream:flush	()V
    //   269: aload 7
    //   271: invokevirtual 196	java/util/zip/ZipOutputStream:closeEntry	()V
    //   274: aload_0
    //   275: athrow
    //   276: aload 7
    //   278: invokevirtual 117	java/util/zip/ZipOutputStream:close	()V
    //   281: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   284: ifeq +60 -> 344
    //   287: goto +49 -> 336
    //   290: astore_0
    //   291: aload 7
    //   293: astore_1
    //   294: goto +72 -> 366
    //   297: astore_1
    //   298: aload 7
    //   300: astore_0
    //   301: goto +12 -> 313
    //   304: astore_0
    //   305: aconst_null
    //   306: astore_1
    //   307: goto +59 -> 366
    //   310: astore_1
    //   311: aconst_null
    //   312: astore_0
    //   313: ldc 132
    //   315: iconst_1
    //   316: ldc 206
    //   318: aload_1
    //   319: invokestatic 201	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   322: aload_0
    //   323: ifnull +7 -> 330
    //   326: aload_0
    //   327: invokevirtual 117	java/util/zip/ZipOutputStream:close	()V
    //   330: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   333: ifeq +11 -> 344
    //   336: ldc 132
    //   338: iconst_2
    //   339: ldc 208
    //   341: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +11 -> 358
    //   350: ldc 132
    //   352: iconst_2
    //   353: ldc 213
    //   355: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: return
    //   359: astore 7
    //   361: aload_0
    //   362: astore_1
    //   363: aload 7
    //   365: astore_0
    //   366: aload_1
    //   367: ifnull +7 -> 374
    //   370: aload_1
    //   371: invokevirtual 117	java/util/zip/ZipOutputStream:close	()V
    //   374: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq +11 -> 388
    //   380: ldc 132
    //   382: iconst_2
    //   383: ldc 208
    //   385: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: goto +5 -> 393
    //   391: aload_0
    //   392: athrow
    //   393: goto -2 -> 391
    //   396: astore_0
    //   397: goto -116 -> 281
    //   400: astore_0
    //   401: goto -71 -> 330
    //   404: astore_1
    //   405: goto -31 -> 374
    //   408: astore 8
    //   410: aload_0
    //   411: astore_1
    //   412: aload 8
    //   414: astore_0
    //   415: goto -159 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramList	List<String>
    //   0	418	1	paramString	String
    //   131	16	2	i	int
    //   121	30	3	l1	long
    //   80	72	5	l2	long
    //   27	272	7	localZipOutputStream	ZipOutputStream
    //   359	5	7	localObject1	Object
    //   184	5	8	localIOException	IOException
    //   210	22	8	localStringBuilder	StringBuilder
    //   408	5	8	localObject2	Object
    //   35	13	9	localIterator	Iterator
    //   57	166	10	str	String
    // Exception table:
    //   from	to	target	type
    //   91	120	180	finally
    //   122	132	180	finally
    //   137	145	180	finally
    //   91	120	184	java/io/IOException
    //   122	132	184	java/io/IOException
    //   137	145	184	java/io/IOException
    //   82	91	194	finally
    //   82	91	200	java/io/IOException
    //   29	37	290	finally
    //   37	82	290	finally
    //   163	172	290	finally
    //   172	177	290	finally
    //   244	248	290	finally
    //   248	253	290	finally
    //   260	264	290	finally
    //   264	276	290	finally
    //   29	37	297	java/io/IOException
    //   37	82	297	java/io/IOException
    //   163	172	297	java/io/IOException
    //   172	177	297	java/io/IOException
    //   244	248	297	java/io/IOException
    //   248	253	297	java/io/IOException
    //   260	264	297	java/io/IOException
    //   264	276	297	java/io/IOException
    //   5	29	304	finally
    //   5	29	310	java/io/IOException
    //   313	322	359	finally
    //   276	281	396	java/io/IOException
    //   326	330	400	java/io/IOException
    //   370	374	404	java/io/IOException
    //   203	240	408	finally
  }
  
  private static void a(ZipOutputStream paramZipOutputStream, File paramFile, int paramInt)
  {
    int j = 0;
    try
    {
      if (paramFile.exists())
      {
        if (paramFile.isFile())
        {
          paramZipOutputStream.putNextEntry(new ZipEntry(paramFile.getPath().substring(paramInt)));
          paramZipOutputStream.setLevel(9);
          long l3 = paramFile.length();
          localObject1 = new FileInputStream(paramFile);
          try
          {
            localObject2 = new byte[20480];
            long l1 = 0L;
            long l2;
            do
            {
              paramInt = ((FileInputStream)localObject1).read((byte[])localObject2, 0, 20480);
              if (paramInt == -1) {
                break;
              }
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("read ");
                localStringBuilder.append(paramInt);
                localStringBuilder.append(" from ");
                localStringBuilder.append(paramFile.getName());
                QLog.d("UnifiedFileUtil", 2, localStringBuilder.toString());
              }
              paramZipOutputStream.write((byte[])localObject2, 0, paramInt);
              l2 = l1 + paramInt;
              l1 = l2;
            } while (l2 < l3);
            return;
          }
          finally
          {
            ((FileInputStream)localObject1).close();
            paramZipOutputStream.closeEntry();
          }
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramFile.getPath().substring(paramInt));
        ((StringBuilder)localObject1).append("/");
        paramZipOutputStream.putNextEntry(new ZipEntry(((StringBuilder)localObject1).toString()));
        localObject1 = paramFile.listFiles();
        Object localObject2 = new JSONObject();
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          int k = localObject1.length;
          int i = 0;
          while (i < k)
          {
            localStringBuilder = localObject1[i];
            a(paramZipOutputStream, localStringBuilder, paramInt);
            ((JSONObject)localObject2).put(localStringBuilder.getName(), a(localStringBuilder));
            i += 1;
          }
        }
        ((JSONObject)localObject2).put(".", a(paramFile));
        localObject1 = "properties.json";
        if (new File(paramFile, "properties.json").exists())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("properties_");
          ((StringBuilder)localObject1).append(System.currentTimeMillis());
          ((StringBuilder)localObject1).append(".json");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFile.getPath().substring(paramInt));
        localStringBuilder.append("/");
        localStringBuilder.append((String)localObject1);
        paramZipOutputStream.putNextEntry(new ZipEntry(localStringBuilder.toString()));
        paramZipOutputStream.write(((JSONObject)localObject2).toString(4).getBytes("utf-8"));
        paramZipOutputStream.closeEntry();
        return;
      }
    }
    catch (JSONException paramZipOutputStream)
    {
      QLog.e("UnifiedFileUtil", 1, "zipFile: ", paramZipOutputStream);
      return;
    }
    catch (IOException paramZipOutputStream)
    {
      paramFile = new StringBuilder();
      paramFile.append("zipFile errror: ");
      paramFile.append(paramZipOutputStream.getMessage());
      QLog.e("UnifiedFileUtil", 1, paramFile.toString());
      paramZipOutputStream = paramZipOutputStream.getStackTrace();
      paramInt = j;
      while (paramInt < paramZipOutputStream.length)
      {
        QLog.e("UnifiedFileUtil", 1, paramZipOutputStream[paramInt].toString());
        paramInt += 1;
      }
    }
  }
  
  public static String[] a(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory())) {
      return paramString.list();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedFileUtil
 * JD-Core Version:    0.7.0.1
 */