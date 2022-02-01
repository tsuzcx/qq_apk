package com.tencent.ttpic.baseutils.device;

import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DeviceUpdate
{
  private static final String CHARSET_UTF8 = "UTF-8";
  private static final int DEFAULT_TIMEOUT_MILLIS = 10000;
  private static final String TAG = "DeviceUpdate";
  
  private static HttpURLConnection buildConnection(String paramString, int paramInt)
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setConnectTimeout(paramInt);
    paramString.setReadTimeout(paramInt);
    return paramString;
  }
  
  public static String checkConfigVersion(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PackageName", paramString2);
    localHashMap.put("camCoreVersion", paramString3);
    localHashMap.put("AppId", paramString4);
    localHashMap.put("AppVersion", paramString5);
    try
    {
      paramString1 = post(paramString1, localHashMap);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = TAG;
      paramString3 = new StringBuilder();
      paramString3.append("checkConfigVersion Exception! e = ");
      paramString3.append(paramString1);
      LogUtils.d(paramString2, paramString3.toString());
    }
    return null;
  }
  
  public static String get(String paramString)
  {
    return get(paramString, 10000);
  }
  
  public static String get(String paramString, int paramInt)
  {
    paramString = buildConnection(paramString, paramInt);
    paramString.setRequestMethod("GET");
    return getResponse(paramString);
  }
  
  private static String getResponse(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection.getResponseCode() == 200)
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      StringBuilder localStringBuilder = new StringBuilder();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramHttpURLConnection.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localStringBuilder.append(new String(arrayOfByte, 0, i));
      }
      paramHttpURLConnection.close();
      return localStringBuilder.toString();
    }
    return null;
  }
  
  /* Error */
  public static boolean httpDownloadFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 65	com/tencent/ttpic/baseutils/device/DeviceUpdate:TAG	Ljava/lang/String;
    //   3: ldc 131
    //   5: invokestatic 87	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: new 24	java/net/URL
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 27	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 31	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   19: checkcast 33	java/net/HttpURLConnection
    //   22: astore 6
    //   24: aload 6
    //   26: sipush 5000
    //   29: invokevirtual 37	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   32: aload 6
    //   34: ldc 96
    //   36: invokevirtual 99	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   39: new 133	java/io/File
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore_1
    //   48: aload_1
    //   49: invokevirtual 138	java/io/File:exists	()Z
    //   52: ifeq +16 -> 68
    //   55: getstatic 65	com/tencent/ttpic/baseutils/device/DeviceUpdate:TAG	Ljava/lang/String;
    //   58: ldc 140
    //   60: invokestatic 87	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_1
    //   64: invokevirtual 143	java/io/File:delete	()Z
    //   67: pop
    //   68: getstatic 65	com/tencent/ttpic/baseutils/device/DeviceUpdate:TAG	Ljava/lang/String;
    //   71: ldc 145
    //   73: invokestatic 87	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_1
    //   77: invokevirtual 148	java/io/File:createNewFile	()Z
    //   80: pop
    //   81: aload 6
    //   83: invokevirtual 111	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   86: astore_0
    //   87: new 150	java/io/FileOutputStream
    //   90: dup
    //   91: aload_1
    //   92: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   95: astore 4
    //   97: aload_0
    //   98: astore_3
    //   99: aload 4
    //   101: astore_1
    //   102: sipush 4096
    //   105: newarray byte
    //   107: astore 5
    //   109: aload_0
    //   110: astore_3
    //   111: aload 4
    //   113: astore_1
    //   114: aload_0
    //   115: aload 5
    //   117: invokevirtual 117	java/io/InputStream:read	([B)I
    //   120: istore_2
    //   121: iload_2
    //   122: iconst_m1
    //   123: if_icmpeq +20 -> 143
    //   126: aload_0
    //   127: astore_3
    //   128: aload 4
    //   130: astore_1
    //   131: aload 4
    //   133: aload 5
    //   135: iconst_0
    //   136: iload_2
    //   137: invokevirtual 158	java/io/OutputStream:write	([BII)V
    //   140: goto -31 -> 109
    //   143: aload_0
    //   144: astore_3
    //   145: aload 4
    //   147: astore_1
    //   148: aload 4
    //   150: invokevirtual 161	java/io/OutputStream:flush	()V
    //   153: aload_0
    //   154: astore_3
    //   155: aload 4
    //   157: astore_1
    //   158: getstatic 65	com/tencent/ttpic/baseutils/device/DeviceUpdate:TAG	Ljava/lang/String;
    //   161: ldc 163
    //   163: invokestatic 87	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload 6
    //   168: ifnull +8 -> 176
    //   171: aload 6
    //   173: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   176: aload_0
    //   177: ifnull +7 -> 184
    //   180: aload_0
    //   181: invokevirtual 125	java/io/InputStream:close	()V
    //   184: aload 4
    //   186: invokevirtual 167	java/io/OutputStream:close	()V
    //   189: iconst_1
    //   190: ireturn
    //   191: astore 5
    //   193: goto +28 -> 221
    //   196: astore_1
    //   197: goto +10 -> 207
    //   200: astore_1
    //   201: goto +14 -> 215
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_0
    //   207: aconst_null
    //   208: astore_3
    //   209: goto +65 -> 274
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_0
    //   215: aconst_null
    //   216: astore 4
    //   218: aload_1
    //   219: astore 5
    //   221: aload_0
    //   222: astore_3
    //   223: aload 4
    //   225: astore_1
    //   226: getstatic 65	com/tencent/ttpic/baseutils/device/DeviceUpdate:TAG	Ljava/lang/String;
    //   229: ldc 169
    //   231: invokestatic 87	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload_0
    //   235: astore_3
    //   236: aload 4
    //   238: astore_1
    //   239: aload 5
    //   241: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   244: aload 6
    //   246: ifnull +8 -> 254
    //   249: aload 6
    //   251: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   254: aload_0
    //   255: ifnull +7 -> 262
    //   258: aload_0
    //   259: invokevirtual 125	java/io/InputStream:close	()V
    //   262: aload 4
    //   264: ifnull +43 -> 307
    //   267: aload 4
    //   269: invokevirtual 167	java/io/OutputStream:close	()V
    //   272: iconst_0
    //   273: ireturn
    //   274: aload 6
    //   276: ifnull +8 -> 284
    //   279: aload 6
    //   281: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   284: aload_0
    //   285: ifnull +7 -> 292
    //   288: aload_0
    //   289: invokevirtual 125	java/io/InputStream:close	()V
    //   292: aload_3
    //   293: ifnull +7 -> 300
    //   296: aload_3
    //   297: invokevirtual 167	java/io/OutputStream:close	()V
    //   300: aload_1
    //   301: athrow
    //   302: astore_0
    //   303: aload_0
    //   304: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   307: iconst_0
    //   308: ireturn
    //   309: astore 4
    //   311: aload_3
    //   312: astore_0
    //   313: aload_1
    //   314: astore_3
    //   315: aload 4
    //   317: astore_1
    //   318: goto -44 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	paramString1	String
    //   0	321	1	paramString2	String
    //   120	17	2	i	int
    //   98	217	3	str1	String
    //   95	173	4	localFileOutputStream	java.io.FileOutputStream
    //   309	7	4	localObject	Object
    //   107	27	5	arrayOfByte	byte[]
    //   191	1	5	localException	Exception
    //   219	21	5	str2	String
    //   22	258	6	localHttpURLConnection	HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   102	109	191	java/lang/Exception
    //   114	121	191	java/lang/Exception
    //   131	140	191	java/lang/Exception
    //   148	153	191	java/lang/Exception
    //   158	166	191	java/lang/Exception
    //   87	97	196	finally
    //   87	97	200	java/lang/Exception
    //   81	87	204	finally
    //   81	87	212	java/lang/Exception
    //   8	68	302	java/io/IOException
    //   68	81	302	java/io/IOException
    //   171	176	302	java/io/IOException
    //   180	184	302	java/io/IOException
    //   184	189	302	java/io/IOException
    //   249	254	302	java/io/IOException
    //   258	262	302	java/io/IOException
    //   267	272	302	java/io/IOException
    //   279	284	302	java/io/IOException
    //   288	292	302	java/io/IOException
    //   296	300	302	java/io/IOException
    //   300	302	302	java/io/IOException
    //   102	109	309	finally
    //   114	121	309	finally
    //   131	140	309	finally
    //   148	153	309	finally
    //   158	166	309	finally
    //   226	234	309	finally
    //   239	244	309	finally
  }
  
  public static String post(String paramString, HashMap<String, String> paramHashMap)
  {
    return post(paramString, paramHashMap, 10000);
  }
  
  public static String post(String paramString, HashMap<String, String> paramHashMap, int paramInt)
  {
    paramString = buildConnection(paramString, paramInt);
    paramString.setRequestMethod("POST");
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      OutputStream localOutputStream = paramString.getOutputStream();
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(localOutputStream, "UTF-8"));
      StringBuilder localStringBuilder = new StringBuilder("");
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        if (localStringBuilder.indexOf("=") > 0) {
          localStringBuilder.append("&");
        }
        String str = (String)localIterator.next();
        localStringBuilder.append(URLEncoder.encode(str, "UTF-8"));
        localStringBuilder.append("=");
        localStringBuilder.append(URLEncoder.encode((String)paramHashMap.get(str), "UTF-8"));
      }
      localBufferedWriter.write(localStringBuilder.toString());
      localBufferedWriter.flush();
      localBufferedWriter.close();
      localOutputStream.close();
    }
    return getResponse(paramString);
  }
  
  /* Error */
  public static String unZip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 246	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 247	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 8
    //   13: goto +11 -> 24
    //   16: astore_0
    //   17: aload_0
    //   18: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   21: aconst_null
    //   22: astore 8
    //   24: ldc 199
    //   26: astore_3
    //   27: aload 8
    //   29: ifnull +861 -> 890
    //   32: new 249	java/util/zip/ZipInputStream
    //   35: dup
    //   36: new 251	java/io/BufferedInputStream
    //   39: dup
    //   40: aload 8
    //   42: invokespecial 254	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: invokespecial 255	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore 9
    //   50: aconst_null
    //   51: astore_0
    //   52: aload_3
    //   53: astore 4
    //   55: aload 9
    //   57: invokevirtual 259	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   60: astore 6
    //   62: aload 6
    //   64: ifnull +660 -> 724
    //   67: aload_3
    //   68: astore 4
    //   70: aload 6
    //   72: invokevirtual 264	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   75: astore 6
    //   77: aload_3
    //   78: astore 4
    //   80: aload 6
    //   82: ldc_w 266
    //   85: invokevirtual 270	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   88: ifeq +6 -> 94
    //   91: goto -39 -> 52
    //   94: aload_3
    //   95: astore 4
    //   97: new 67	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   104: astore 7
    //   106: aload_3
    //   107: astore 4
    //   109: aload 7
    //   111: aload_1
    //   112: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_3
    //   117: astore 4
    //   119: aload 7
    //   121: aload 6
    //   123: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_3
    //   128: astore 4
    //   130: new 133	java/io/File
    //   133: dup
    //   134: aload 7
    //   136: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore 10
    //   144: aload_3
    //   145: astore 4
    //   147: aload 10
    //   149: invokevirtual 273	java/io/File:getParent	()Ljava/lang/String;
    //   152: astore 6
    //   154: aload 6
    //   156: ifnull -104 -> 52
    //   159: aload_3
    //   160: astore 4
    //   162: new 133	java/io/File
    //   165: dup
    //   166: aload 6
    //   168: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   171: astore 6
    //   173: aload_3
    //   174: astore 4
    //   176: aload 6
    //   178: invokevirtual 138	java/io/File:exists	()Z
    //   181: ifne +12 -> 193
    //   184: aload_3
    //   185: astore 4
    //   187: aload 6
    //   189: invokevirtual 276	java/io/File:mkdirs	()Z
    //   192: pop
    //   193: new 150	java/io/FileOutputStream
    //   196: dup
    //   197: aload 10
    //   199: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   202: astore 4
    //   204: new 278	java/io/BufferedOutputStream
    //   207: dup
    //   208: aload 4
    //   210: sipush 4096
    //   213: invokespecial 281	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   216: astore 5
    //   218: aload 5
    //   220: astore 6
    //   222: aload 4
    //   224: astore 7
    //   226: sipush 4096
    //   229: newarray byte
    //   231: astore_0
    //   232: aload 5
    //   234: astore 6
    //   236: aload 4
    //   238: astore 7
    //   240: aload 9
    //   242: aload_0
    //   243: iconst_0
    //   244: sipush 4096
    //   247: invokevirtual 284	java/util/zip/ZipInputStream:read	([BII)I
    //   250: istore_2
    //   251: iload_2
    //   252: iconst_m1
    //   253: if_icmpeq +22 -> 275
    //   256: aload 5
    //   258: astore 6
    //   260: aload 4
    //   262: astore 7
    //   264: aload 5
    //   266: aload_0
    //   267: iconst_0
    //   268: iload_2
    //   269: invokevirtual 285	java/io/BufferedOutputStream:write	([BII)V
    //   272: goto -40 -> 232
    //   275: aload 5
    //   277: astore 6
    //   279: aload 4
    //   281: astore 7
    //   283: aload 5
    //   285: invokevirtual 286	java/io/BufferedOutputStream:flush	()V
    //   288: aload 5
    //   290: astore 6
    //   292: aload 4
    //   294: astore 7
    //   296: aload 10
    //   298: invokevirtual 289	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   301: astore_0
    //   302: aload 5
    //   304: invokevirtual 290	java/io/BufferedOutputStream:close	()V
    //   307: aload 4
    //   309: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   312: aload 4
    //   314: astore 6
    //   316: aload_0
    //   317: astore 7
    //   319: goto +293 -> 612
    //   322: astore_3
    //   323: aload 5
    //   325: astore 6
    //   327: aload_3
    //   328: astore 5
    //   330: aload 4
    //   332: astore 7
    //   334: aload_0
    //   335: astore_3
    //   336: goto +183 -> 519
    //   339: astore_1
    //   340: goto +40 -> 380
    //   343: astore_3
    //   344: aload_3
    //   345: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   348: aload 4
    //   350: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   353: aload 4
    //   355: astore 6
    //   357: aload_0
    //   358: astore 7
    //   360: goto +252 -> 612
    //   363: astore_3
    //   364: aload 5
    //   366: astore 6
    //   368: aload_3
    //   369: astore 5
    //   371: aload 4
    //   373: astore 7
    //   375: aload_0
    //   376: astore_3
    //   377: goto +142 -> 519
    //   380: aload 4
    //   382: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   385: goto +11 -> 396
    //   388: astore_3
    //   389: aload_0
    //   390: astore 4
    //   392: aload_3
    //   393: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   396: aload_0
    //   397: astore 4
    //   399: aload_1
    //   400: athrow
    //   401: astore 6
    //   403: aload 5
    //   405: astore_0
    //   406: aload 6
    //   408: astore 5
    //   410: goto +33 -> 443
    //   413: astore_1
    //   414: goto +13 -> 427
    //   417: astore 5
    //   419: goto +24 -> 443
    //   422: astore_1
    //   423: aload 5
    //   425: astore 4
    //   427: aload_0
    //   428: astore 6
    //   430: goto +200 -> 630
    //   433: astore 6
    //   435: aload 5
    //   437: astore 4
    //   439: aload 6
    //   441: astore 5
    //   443: aload_0
    //   444: astore 6
    //   446: aload 4
    //   448: astore 7
    //   450: aload 5
    //   452: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   455: aload_0
    //   456: ifnull +111 -> 567
    //   459: aload_0
    //   460: invokevirtual 290	java/io/BufferedOutputStream:close	()V
    //   463: goto +104 -> 567
    //   466: astore_0
    //   467: goto +74 -> 541
    //   470: astore 5
    //   472: aload 5
    //   474: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   477: aload_0
    //   478: astore 5
    //   480: aload 4
    //   482: astore 6
    //   484: aload_3
    //   485: astore 7
    //   487: aload 4
    //   489: ifnull +123 -> 612
    //   492: aload 4
    //   494: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   497: aload_0
    //   498: astore 5
    //   500: aload 4
    //   502: astore 6
    //   504: aload_3
    //   505: astore 7
    //   507: goto +105 -> 612
    //   510: astore 5
    //   512: aload 4
    //   514: astore 7
    //   516: aload_0
    //   517: astore 6
    //   519: aload_3
    //   520: astore 4
    //   522: aload 5
    //   524: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   527: aload 6
    //   529: astore 5
    //   531: aload 7
    //   533: astore 6
    //   535: aload_3
    //   536: astore 7
    //   538: goto +74 -> 612
    //   541: aload 4
    //   543: ifnull +19 -> 562
    //   546: aload 4
    //   548: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   551: goto +11 -> 562
    //   554: astore_1
    //   555: aload_3
    //   556: astore 4
    //   558: aload_1
    //   559: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   562: aload_3
    //   563: astore 4
    //   565: aload_0
    //   566: athrow
    //   567: aload_0
    //   568: astore 5
    //   570: aload 4
    //   572: astore 6
    //   574: aload_3
    //   575: astore 7
    //   577: aload 4
    //   579: ifnull +33 -> 612
    //   582: aload 4
    //   584: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   587: aload_0
    //   588: astore 5
    //   590: aload 4
    //   592: astore 6
    //   594: aload_3
    //   595: astore 7
    //   597: goto +15 -> 612
    //   600: astore 5
    //   602: aload_0
    //   603: astore 6
    //   605: aload 4
    //   607: astore 7
    //   609: goto -90 -> 519
    //   612: aload 5
    //   614: astore_0
    //   615: aload 6
    //   617: astore 5
    //   619: aload 7
    //   621: astore_3
    //   622: goto -570 -> 52
    //   625: astore_1
    //   626: aload 7
    //   628: astore 4
    //   630: aload 6
    //   632: ifnull +70 -> 702
    //   635: aload 6
    //   637: invokevirtual 290	java/io/BufferedOutputStream:close	()V
    //   640: goto +62 -> 702
    //   643: astore_0
    //   644: goto +32 -> 676
    //   647: astore_0
    //   648: aload_0
    //   649: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   652: aload 4
    //   654: ifnull +65 -> 719
    //   657: aload 4
    //   659: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   662: goto +57 -> 719
    //   665: astore_0
    //   666: aload_3
    //   667: astore 4
    //   669: aload_0
    //   670: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   673: goto +46 -> 719
    //   676: aload 4
    //   678: ifnull +19 -> 697
    //   681: aload 4
    //   683: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   686: goto +11 -> 697
    //   689: astore_1
    //   690: aload_3
    //   691: astore 4
    //   693: aload_1
    //   694: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   697: aload_3
    //   698: astore 4
    //   700: aload_0
    //   701: athrow
    //   702: aload 4
    //   704: ifnull +15 -> 719
    //   707: aload 4
    //   709: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   712: goto +7 -> 719
    //   715: astore_0
    //   716: goto -50 -> 666
    //   719: aload_3
    //   720: astore 4
    //   722: aload_1
    //   723: athrow
    //   724: aload 9
    //   726: invokevirtual 292	java/util/zip/ZipInputStream:close	()V
    //   729: aload_3
    //   730: astore_0
    //   731: aload 8
    //   733: invokevirtual 293	java/io/FileInputStream:close	()V
    //   736: aload_3
    //   737: areturn
    //   738: astore_1
    //   739: aload_1
    //   740: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   743: aload_0
    //   744: areturn
    //   745: astore_0
    //   746: goto +17 -> 763
    //   749: astore_0
    //   750: aload_0
    //   751: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   754: aload_3
    //   755: astore_0
    //   756: aload 8
    //   758: invokevirtual 293	java/io/FileInputStream:close	()V
    //   761: aload_3
    //   762: areturn
    //   763: aload 8
    //   765: invokevirtual 293	java/io/FileInputStream:close	()V
    //   768: goto +8 -> 776
    //   771: astore_1
    //   772: aload_1
    //   773: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   776: aload_0
    //   777: athrow
    //   778: astore_0
    //   779: goto +59 -> 838
    //   782: astore_0
    //   783: aload_0
    //   784: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   787: aload 9
    //   789: invokevirtual 292	java/util/zip/ZipInputStream:close	()V
    //   792: aload 4
    //   794: astore_0
    //   795: aload 8
    //   797: invokevirtual 293	java/io/FileInputStream:close	()V
    //   800: aload 4
    //   802: areturn
    //   803: astore_0
    //   804: goto +19 -> 823
    //   807: astore_0
    //   808: aload_0
    //   809: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   812: aload 4
    //   814: astore_0
    //   815: aload 8
    //   817: invokevirtual 293	java/io/FileInputStream:close	()V
    //   820: aload 4
    //   822: areturn
    //   823: aload 8
    //   825: invokevirtual 293	java/io/FileInputStream:close	()V
    //   828: goto +8 -> 836
    //   831: astore_1
    //   832: aload_1
    //   833: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   836: aload_0
    //   837: athrow
    //   838: aload 9
    //   840: invokevirtual 292	java/util/zip/ZipInputStream:close	()V
    //   843: aload 8
    //   845: invokevirtual 293	java/io/FileInputStream:close	()V
    //   848: goto +25 -> 873
    //   851: astore_1
    //   852: aload_1
    //   853: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   856: goto +17 -> 873
    //   859: astore_0
    //   860: goto +15 -> 875
    //   863: astore_1
    //   864: aload_1
    //   865: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   868: aload 8
    //   870: invokevirtual 293	java/io/FileInputStream:close	()V
    //   873: aload_0
    //   874: athrow
    //   875: aload 8
    //   877: invokevirtual 293	java/io/FileInputStream:close	()V
    //   880: goto +8 -> 888
    //   883: astore_1
    //   884: aload_1
    //   885: invokestatic 173	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   888: aload_0
    //   889: athrow
    //   890: ldc 199
    //   892: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	893	0	paramString1	String
    //   0	893	1	paramString2	String
    //   250	19	2	i	int
    //   26	159	3	str1	String
    //   322	6	3	localException1	Exception
    //   335	1	3	str2	String
    //   343	2	3	localException2	Exception
    //   363	6	3	localException3	Exception
    //   376	1	3	str3	String
    //   388	207	3	localException4	Exception
    //   621	141	3	localObject1	Object
    //   53	768	4	localObject2	Object
    //   1	408	5	localObject3	Object
    //   417	19	5	localException5	Exception
    //   441	10	5	localObject4	Object
    //   470	3	5	localException6	Exception
    //   478	21	5	str4	String
    //   510	13	5	localException7	Exception
    //   529	60	5	localObject5	Object
    //   600	13	5	localException8	Exception
    //   617	1	5	localObject6	Object
    //   60	307	6	localObject7	Object
    //   401	6	6	localException9	Exception
    //   428	1	6	str5	String
    //   433	7	6	localException10	Exception
    //   444	192	6	localObject8	Object
    //   104	523	7	localObject9	Object
    //   11	865	8	localFileInputStream	java.io.FileInputStream
    //   48	791	9	localZipInputStream	java.util.zip.ZipInputStream
    //   142	155	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   3	13	16	java/io/FileNotFoundException
    //   307	312	322	java/lang/Exception
    //   302	307	339	finally
    //   344	348	339	finally
    //   302	307	343	java/lang/Exception
    //   348	353	363	java/lang/Exception
    //   380	385	388	java/lang/Exception
    //   226	232	401	java/lang/Exception
    //   240	251	401	java/lang/Exception
    //   264	272	401	java/lang/Exception
    //   283	288	401	java/lang/Exception
    //   296	302	401	java/lang/Exception
    //   204	218	413	finally
    //   204	218	417	java/lang/Exception
    //   193	204	422	finally
    //   193	204	433	java/lang/Exception
    //   459	463	466	finally
    //   472	477	466	finally
    //   459	463	470	java/lang/Exception
    //   492	497	510	java/lang/Exception
    //   546	551	554	java/lang/Exception
    //   582	587	600	java/lang/Exception
    //   226	232	625	finally
    //   240	251	625	finally
    //   264	272	625	finally
    //   283	288	625	finally
    //   296	302	625	finally
    //   450	455	625	finally
    //   635	640	643	finally
    //   648	652	643	finally
    //   635	640	647	java/lang/Exception
    //   657	662	665	java/lang/Exception
    //   681	686	689	java/lang/Exception
    //   707	712	715	java/lang/Exception
    //   731	736	738	java/io/IOException
    //   756	761	738	java/io/IOException
    //   795	800	738	java/io/IOException
    //   815	820	738	java/io/IOException
    //   724	729	745	finally
    //   750	754	745	finally
    //   724	729	749	java/io/IOException
    //   763	768	771	java/io/IOException
    //   55	62	778	finally
    //   70	77	778	finally
    //   80	91	778	finally
    //   97	106	778	finally
    //   109	116	778	finally
    //   119	127	778	finally
    //   130	144	778	finally
    //   147	154	778	finally
    //   162	173	778	finally
    //   176	184	778	finally
    //   187	193	778	finally
    //   307	312	778	finally
    //   348	353	778	finally
    //   380	385	778	finally
    //   392	396	778	finally
    //   399	401	778	finally
    //   492	497	778	finally
    //   522	527	778	finally
    //   546	551	778	finally
    //   558	562	778	finally
    //   565	567	778	finally
    //   582	587	778	finally
    //   657	662	778	finally
    //   669	673	778	finally
    //   681	686	778	finally
    //   693	697	778	finally
    //   700	702	778	finally
    //   707	712	778	finally
    //   722	724	778	finally
    //   783	787	778	finally
    //   55	62	782	java/lang/Exception
    //   70	77	782	java/lang/Exception
    //   80	91	782	java/lang/Exception
    //   97	106	782	java/lang/Exception
    //   109	116	782	java/lang/Exception
    //   119	127	782	java/lang/Exception
    //   130	144	782	java/lang/Exception
    //   147	154	782	java/lang/Exception
    //   162	173	782	java/lang/Exception
    //   176	184	782	java/lang/Exception
    //   187	193	782	java/lang/Exception
    //   392	396	782	java/lang/Exception
    //   399	401	782	java/lang/Exception
    //   522	527	782	java/lang/Exception
    //   558	562	782	java/lang/Exception
    //   565	567	782	java/lang/Exception
    //   669	673	782	java/lang/Exception
    //   693	697	782	java/lang/Exception
    //   700	702	782	java/lang/Exception
    //   722	724	782	java/lang/Exception
    //   787	792	803	finally
    //   808	812	803	finally
    //   787	792	807	java/io/IOException
    //   823	828	831	java/io/IOException
    //   843	848	851	java/io/IOException
    //   868	873	851	java/io/IOException
    //   838	843	859	finally
    //   864	868	859	finally
    //   838	843	863	java/io/IOException
    //   875	880	883	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.device.DeviceUpdate
 * JD-Core Version:    0.7.0.1
 */