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
  private static final String TAG = DeviceUpdate.class.getSimpleName();
  
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
      LogUtils.d(TAG, "checkConfigVersion Exception! e = " + paramString1);
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
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 22	com/tencent/ttpic/baseutils/device/DeviceUpdate:TAG	Ljava/lang/String;
    //   5: ldc 134
    //   7: invokestatic 90	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: new 30	java/net/URL
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 33	java/net/URL:<init>	(Ljava/lang/String;)V
    //   18: invokevirtual 37	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   21: checkcast 39	java/net/HttpURLConnection
    //   24: astore 5
    //   26: aload 5
    //   28: sipush 5000
    //   31: invokevirtual 43	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   34: aload 5
    //   36: ldc 99
    //   38: invokevirtual 102	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   41: new 136	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 137	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 141	java/io/File:exists	()Z
    //   54: ifeq +16 -> 70
    //   57: getstatic 22	com/tencent/ttpic/baseutils/device/DeviceUpdate:TAG	Ljava/lang/String;
    //   60: ldc 143
    //   62: invokestatic 90	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_0
    //   66: invokevirtual 146	java/io/File:delete	()Z
    //   69: pop
    //   70: getstatic 22	com/tencent/ttpic/baseutils/device/DeviceUpdate:TAG	Ljava/lang/String;
    //   73: ldc 148
    //   75: invokestatic 90	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload_0
    //   79: invokevirtual 151	java/io/File:createNewFile	()Z
    //   82: pop
    //   83: aload 5
    //   85: invokevirtual 114	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   88: astore_1
    //   89: new 153	java/io/FileOutputStream
    //   92: dup
    //   93: aload_0
    //   94: invokespecial 156	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   97: astore 4
    //   99: sipush 4096
    //   102: newarray byte
    //   104: astore_0
    //   105: aload_1
    //   106: aload_0
    //   107: invokevirtual 120	java/io/InputStream:read	([B)I
    //   110: istore_2
    //   111: iload_2
    //   112: iconst_m1
    //   113: if_icmpeq +58 -> 171
    //   116: aload 4
    //   118: aload_0
    //   119: iconst_0
    //   120: iload_2
    //   121: invokevirtual 161	java/io/OutputStream:write	([BII)V
    //   124: goto -19 -> 105
    //   127: astore_0
    //   128: aload 4
    //   130: astore_3
    //   131: getstatic 22	com/tencent/ttpic/baseutils/device/DeviceUpdate:TAG	Ljava/lang/String;
    //   134: ldc 163
    //   136: invokestatic 90	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   143: aload 5
    //   145: ifnull +8 -> 153
    //   148: aload 5
    //   150: invokevirtual 170	java/net/HttpURLConnection:disconnect	()V
    //   153: aload_1
    //   154: ifnull +7 -> 161
    //   157: aload_1
    //   158: invokevirtual 128	java/io/InputStream:close	()V
    //   161: aload_3
    //   162: ifnull +85 -> 247
    //   165: aload_3
    //   166: invokevirtual 171	java/io/OutputStream:close	()V
    //   169: iconst_0
    //   170: ireturn
    //   171: aload 4
    //   173: invokevirtual 174	java/io/OutputStream:flush	()V
    //   176: getstatic 22	com/tencent/ttpic/baseutils/device/DeviceUpdate:TAG	Ljava/lang/String;
    //   179: ldc 176
    //   181: invokestatic 90	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload 5
    //   186: ifnull +8 -> 194
    //   189: aload 5
    //   191: invokevirtual 170	java/net/HttpURLConnection:disconnect	()V
    //   194: aload_1
    //   195: ifnull +7 -> 202
    //   198: aload_1
    //   199: invokevirtual 128	java/io/InputStream:close	()V
    //   202: aload 4
    //   204: ifnull +88 -> 292
    //   207: aload 4
    //   209: invokevirtual 171	java/io/OutputStream:close	()V
    //   212: iconst_1
    //   213: ireturn
    //   214: aload 5
    //   216: ifnull +8 -> 224
    //   219: aload 5
    //   221: invokevirtual 170	java/net/HttpURLConnection:disconnect	()V
    //   224: aload_3
    //   225: ifnull +7 -> 232
    //   228: aload_3
    //   229: invokevirtual 128	java/io/InputStream:close	()V
    //   232: aload_1
    //   233: ifnull +7 -> 240
    //   236: aload_1
    //   237: invokevirtual 171	java/io/OutputStream:close	()V
    //   240: aload_0
    //   241: athrow
    //   242: astore_0
    //   243: aload_0
    //   244: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   247: iconst_0
    //   248: ireturn
    //   249: astore_0
    //   250: aconst_null
    //   251: astore 4
    //   253: aload_1
    //   254: astore_3
    //   255: aload 4
    //   257: astore_1
    //   258: goto -44 -> 214
    //   261: astore_0
    //   262: aload_1
    //   263: astore_3
    //   264: aload 4
    //   266: astore_1
    //   267: goto -53 -> 214
    //   270: astore_0
    //   271: aload_3
    //   272: astore 4
    //   274: aload_1
    //   275: astore_3
    //   276: aload 4
    //   278: astore_1
    //   279: goto -65 -> 214
    //   282: astore_0
    //   283: aconst_null
    //   284: astore_1
    //   285: goto -154 -> 131
    //   288: astore_0
    //   289: goto -158 -> 131
    //   292: iconst_1
    //   293: ireturn
    //   294: astore_0
    //   295: aconst_null
    //   296: astore_3
    //   297: aconst_null
    //   298: astore_1
    //   299: goto -85 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	paramString1	String
    //   0	302	1	paramString2	String
    //   110	11	2	i	int
    //   1	296	3	localObject1	Object
    //   97	180	4	localObject2	Object
    //   24	196	5	localHttpURLConnection	HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   99	105	127	java/lang/Exception
    //   105	111	127	java/lang/Exception
    //   116	124	127	java/lang/Exception
    //   171	184	127	java/lang/Exception
    //   10	70	242	java/io/IOException
    //   70	83	242	java/io/IOException
    //   148	153	242	java/io/IOException
    //   157	161	242	java/io/IOException
    //   165	169	242	java/io/IOException
    //   189	194	242	java/io/IOException
    //   198	202	242	java/io/IOException
    //   207	212	242	java/io/IOException
    //   219	224	242	java/io/IOException
    //   228	232	242	java/io/IOException
    //   236	240	242	java/io/IOException
    //   240	242	242	java/io/IOException
    //   89	99	249	finally
    //   99	105	261	finally
    //   105	111	261	finally
    //   116	124	261	finally
    //   171	184	261	finally
    //   131	143	270	finally
    //   83	89	282	java/lang/Exception
    //   89	99	288	java/lang/Exception
    //   83	89	294	finally
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
        localStringBuilder.append(URLEncoder.encode(str, "UTF-8")).append("=").append(URLEncoder.encode((String)paramHashMap.get(str), "UTF-8"));
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
    //   1: astore 4
    //   3: ldc 202
    //   5: astore_3
    //   6: new 249	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 250	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore 7
    //   16: aload_3
    //   17: astore_0
    //   18: aload 7
    //   20: ifnull +304 -> 324
    //   23: new 252	java/util/zip/ZipInputStream
    //   26: dup
    //   27: new 254	java/io/BufferedInputStream
    //   30: dup
    //   31: aload 7
    //   33: invokespecial 257	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: invokespecial 258	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore 8
    //   41: aconst_null
    //   42: astore 5
    //   44: aload 4
    //   46: astore_0
    //   47: aload 5
    //   49: astore 4
    //   51: aload 8
    //   53: invokevirtual 262	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   56: astore 5
    //   58: aload 5
    //   60: ifnull +471 -> 531
    //   63: aload 5
    //   65: invokevirtual 267	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   68: astore 5
    //   70: aload 5
    //   72: ldc_w 269
    //   75: invokevirtual 273	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   78: ifne -27 -> 51
    //   81: new 136	java/io/File
    //   84: dup
    //   85: new 71	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   92: aload_1
    //   93: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 5
    //   98: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokespecial 137	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: astore 9
    //   109: aload 9
    //   111: invokevirtual 276	java/io/File:getParent	()Ljava/lang/String;
    //   114: astore 5
    //   116: aload 5
    //   118: ifnull +591 -> 709
    //   121: new 136	java/io/File
    //   124: dup
    //   125: aload 5
    //   127: invokespecial 137	java/io/File:<init>	(Ljava/lang/String;)V
    //   130: astore 5
    //   132: aload 5
    //   134: invokevirtual 141	java/io/File:exists	()Z
    //   137: ifne +9 -> 146
    //   140: aload 5
    //   142: invokevirtual 279	java/io/File:mkdirs	()Z
    //   145: pop
    //   146: new 153	java/io/FileOutputStream
    //   149: dup
    //   150: aload 9
    //   152: invokespecial 156	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   155: astore 5
    //   157: new 281	java/io/BufferedOutputStream
    //   160: dup
    //   161: aload 5
    //   163: sipush 4096
    //   166: invokespecial 284	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   169: astore 6
    //   171: sipush 4096
    //   174: newarray byte
    //   176: astore_0
    //   177: aload 8
    //   179: aload_0
    //   180: iconst_0
    //   181: sipush 4096
    //   184: invokevirtual 287	java/util/zip/ZipInputStream:read	([BII)I
    //   187: istore_2
    //   188: iload_2
    //   189: iconst_m1
    //   190: if_icmpeq +62 -> 252
    //   193: aload 6
    //   195: aload_0
    //   196: iconst_0
    //   197: iload_2
    //   198: invokevirtual 288	java/io/BufferedOutputStream:write	([BII)V
    //   201: goto -24 -> 177
    //   204: astore_0
    //   205: aload 5
    //   207: astore 4
    //   209: aload_0
    //   210: astore 5
    //   212: aload 6
    //   214: astore_0
    //   215: aload 5
    //   217: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   220: aload_0
    //   221: ifnull +7 -> 228
    //   224: aload_0
    //   225: invokevirtual 289	java/io/BufferedOutputStream:close	()V
    //   228: aload 4
    //   230: ifnull +8 -> 238
    //   233: aload 4
    //   235: invokevirtual 290	java/io/FileOutputStream:close	()V
    //   238: goto -187 -> 51
    //   241: astore_0
    //   242: aload_0
    //   243: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   246: aconst_null
    //   247: astore 7
    //   249: goto -233 -> 16
    //   252: aload 6
    //   254: invokevirtual 291	java/io/BufferedOutputStream:flush	()V
    //   257: aload 9
    //   259: invokevirtual 294	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   262: astore_0
    //   263: aload 6
    //   265: ifnull +8 -> 273
    //   268: aload 6
    //   270: invokevirtual 289	java/io/BufferedOutputStream:close	()V
    //   273: aload 5
    //   275: ifnull +8 -> 283
    //   278: aload 5
    //   280: invokevirtual 290	java/io/FileOutputStream:close	()V
    //   283: aload_0
    //   284: astore_3
    //   285: aload 5
    //   287: astore 4
    //   289: aload 6
    //   291: astore_0
    //   292: goto -54 -> 238
    //   295: astore_3
    //   296: aload_3
    //   297: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   300: goto -17 -> 283
    //   303: astore_1
    //   304: aload_0
    //   305: astore_3
    //   306: aload_1
    //   307: astore_0
    //   308: aload_0
    //   309: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   312: aload 8
    //   314: invokevirtual 295	java/util/zip/ZipInputStream:close	()V
    //   317: aload 7
    //   319: invokevirtual 296	java/io/FileInputStream:close	()V
    //   322: aload_3
    //   323: astore_0
    //   324: aload_0
    //   325: areturn
    //   326: astore_3
    //   327: aload_3
    //   328: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   331: aload 5
    //   333: ifnull -50 -> 283
    //   336: aload 5
    //   338: invokevirtual 290	java/io/FileOutputStream:close	()V
    //   341: goto -58 -> 283
    //   344: astore_3
    //   345: aload_3
    //   346: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   349: goto -66 -> 283
    //   352: astore_0
    //   353: aload 8
    //   355: invokevirtual 295	java/util/zip/ZipInputStream:close	()V
    //   358: aload 7
    //   360: invokevirtual 296	java/io/FileInputStream:close	()V
    //   363: aload_0
    //   364: athrow
    //   365: astore_1
    //   366: aload 5
    //   368: ifnull +8 -> 376
    //   371: aload 5
    //   373: invokevirtual 290	java/io/FileOutputStream:close	()V
    //   376: aload_1
    //   377: athrow
    //   378: astore_3
    //   379: aload_3
    //   380: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   383: goto -7 -> 376
    //   386: astore 5
    //   388: aload 5
    //   390: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   393: goto -155 -> 238
    //   396: astore_0
    //   397: goto -89 -> 308
    //   400: astore 5
    //   402: aload 5
    //   404: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   407: aload 4
    //   409: ifnull -171 -> 238
    //   412: aload 4
    //   414: invokevirtual 290	java/io/FileOutputStream:close	()V
    //   417: goto -179 -> 238
    //   420: astore 5
    //   422: aload 5
    //   424: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   427: goto -189 -> 238
    //   430: astore_0
    //   431: aload 4
    //   433: ifnull +8 -> 441
    //   436: aload 4
    //   438: invokevirtual 290	java/io/FileOutputStream:close	()V
    //   441: aload_0
    //   442: athrow
    //   443: astore_1
    //   444: aload_1
    //   445: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   448: goto -7 -> 441
    //   451: astore_1
    //   452: aload 4
    //   454: astore 5
    //   456: aload_0
    //   457: ifnull +7 -> 464
    //   460: aload_0
    //   461: invokevirtual 289	java/io/BufferedOutputStream:close	()V
    //   464: aload 5
    //   466: ifnull +8 -> 474
    //   469: aload 5
    //   471: invokevirtual 290	java/io/FileOutputStream:close	()V
    //   474: aload_1
    //   475: athrow
    //   476: astore_0
    //   477: aload_0
    //   478: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   481: goto -7 -> 474
    //   484: astore_0
    //   485: aload_0
    //   486: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   489: aload 5
    //   491: ifnull -17 -> 474
    //   494: aload 5
    //   496: invokevirtual 290	java/io/FileOutputStream:close	()V
    //   499: goto -25 -> 474
    //   502: astore_0
    //   503: aload_0
    //   504: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   507: goto -33 -> 474
    //   510: astore_0
    //   511: aload 5
    //   513: ifnull +8 -> 521
    //   516: aload 5
    //   518: invokevirtual 290	java/io/FileOutputStream:close	()V
    //   521: aload_0
    //   522: athrow
    //   523: astore_1
    //   524: aload_1
    //   525: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   528: goto -7 -> 521
    //   531: aload 8
    //   533: invokevirtual 295	java/util/zip/ZipInputStream:close	()V
    //   536: aload 7
    //   538: invokevirtual 296	java/io/FileInputStream:close	()V
    //   541: aload_3
    //   542: areturn
    //   543: astore_0
    //   544: aload_0
    //   545: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   548: aload_3
    //   549: areturn
    //   550: astore_0
    //   551: aload_0
    //   552: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   555: aload 7
    //   557: invokevirtual 296	java/io/FileInputStream:close	()V
    //   560: aload_3
    //   561: areturn
    //   562: astore_0
    //   563: aload_0
    //   564: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   567: aload_3
    //   568: areturn
    //   569: astore_0
    //   570: aload 7
    //   572: invokevirtual 296	java/io/FileInputStream:close	()V
    //   575: aload_0
    //   576: athrow
    //   577: astore_1
    //   578: aload_1
    //   579: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   582: goto -7 -> 575
    //   585: astore_0
    //   586: aload_0
    //   587: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   590: aload_3
    //   591: areturn
    //   592: astore_0
    //   593: aload_0
    //   594: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   597: aload 7
    //   599: invokevirtual 296	java/io/FileInputStream:close	()V
    //   602: aload_3
    //   603: areturn
    //   604: astore_0
    //   605: aload_0
    //   606: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   609: aload_3
    //   610: areturn
    //   611: astore_0
    //   612: aload 7
    //   614: invokevirtual 296	java/io/FileInputStream:close	()V
    //   617: aload_0
    //   618: athrow
    //   619: astore_1
    //   620: aload_1
    //   621: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   624: goto -7 -> 617
    //   627: astore_1
    //   628: aload_1
    //   629: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   632: goto -269 -> 363
    //   635: astore_1
    //   636: aload_1
    //   637: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   640: aload 7
    //   642: invokevirtual 296	java/io/FileInputStream:close	()V
    //   645: goto -282 -> 363
    //   648: astore_1
    //   649: aload_1
    //   650: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   653: goto -290 -> 363
    //   656: astore_0
    //   657: aload 7
    //   659: invokevirtual 296	java/io/FileInputStream:close	()V
    //   662: aload_0
    //   663: athrow
    //   664: astore_1
    //   665: aload_1
    //   666: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   669: goto -7 -> 662
    //   672: astore_1
    //   673: goto -217 -> 456
    //   676: astore_1
    //   677: aload 6
    //   679: astore_0
    //   680: goto -224 -> 456
    //   683: astore_1
    //   684: aload 4
    //   686: astore 5
    //   688: goto -232 -> 456
    //   691: astore 5
    //   693: goto -478 -> 215
    //   696: astore 6
    //   698: aload 5
    //   700: astore 4
    //   702: aload 6
    //   704: astore 5
    //   706: goto -491 -> 215
    //   709: goto -471 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	712	0	paramString1	String
    //   0	712	1	paramString2	String
    //   187	11	2	i	int
    //   5	280	3	str1	String
    //   295	2	3	localException1	Exception
    //   305	18	3	str2	String
    //   326	2	3	localException2	Exception
    //   344	2	3	localException3	Exception
    //   378	232	3	localException4	Exception
    //   1	700	4	localObject1	Object
    //   42	330	5	localObject2	Object
    //   386	3	5	localException5	Exception
    //   400	3	5	localException6	Exception
    //   420	3	5	localException7	Exception
    //   454	233	5	localObject3	Object
    //   691	8	5	localException8	Exception
    //   704	1	5	localObject4	Object
    //   169	509	6	localBufferedOutputStream	java.io.BufferedOutputStream
    //   696	7	6	localException9	Exception
    //   14	644	7	localFileInputStream	java.io.FileInputStream
    //   39	493	8	localZipInputStream	java.util.zip.ZipInputStream
    //   107	151	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   171	177	204	java/lang/Exception
    //   177	188	204	java/lang/Exception
    //   193	201	204	java/lang/Exception
    //   252	263	204	java/lang/Exception
    //   6	16	241	java/io/FileNotFoundException
    //   278	283	295	java/lang/Exception
    //   296	300	303	java/lang/Exception
    //   345	349	303	java/lang/Exception
    //   376	378	303	java/lang/Exception
    //   379	383	303	java/lang/Exception
    //   268	273	326	java/lang/Exception
    //   336	341	344	java/lang/Exception
    //   51	58	352	finally
    //   63	116	352	finally
    //   121	146	352	finally
    //   233	238	352	finally
    //   278	283	352	finally
    //   296	300	352	finally
    //   308	312	352	finally
    //   336	341	352	finally
    //   345	349	352	finally
    //   371	376	352	finally
    //   376	378	352	finally
    //   379	383	352	finally
    //   388	393	352	finally
    //   412	417	352	finally
    //   422	427	352	finally
    //   436	441	352	finally
    //   441	443	352	finally
    //   444	448	352	finally
    //   469	474	352	finally
    //   474	476	352	finally
    //   477	481	352	finally
    //   494	499	352	finally
    //   503	507	352	finally
    //   516	521	352	finally
    //   521	523	352	finally
    //   524	528	352	finally
    //   268	273	365	finally
    //   327	331	365	finally
    //   371	376	378	java/lang/Exception
    //   233	238	386	java/lang/Exception
    //   51	58	396	java/lang/Exception
    //   63	116	396	java/lang/Exception
    //   121	146	396	java/lang/Exception
    //   388	393	396	java/lang/Exception
    //   422	427	396	java/lang/Exception
    //   441	443	396	java/lang/Exception
    //   444	448	396	java/lang/Exception
    //   474	476	396	java/lang/Exception
    //   477	481	396	java/lang/Exception
    //   503	507	396	java/lang/Exception
    //   521	523	396	java/lang/Exception
    //   524	528	396	java/lang/Exception
    //   224	228	400	java/lang/Exception
    //   412	417	420	java/lang/Exception
    //   224	228	430	finally
    //   402	407	430	finally
    //   436	441	443	java/lang/Exception
    //   146	157	451	finally
    //   469	474	476	java/lang/Exception
    //   460	464	484	java/lang/Exception
    //   494	499	502	java/lang/Exception
    //   460	464	510	finally
    //   485	489	510	finally
    //   516	521	523	java/lang/Exception
    //   536	541	543	java/io/IOException
    //   531	536	550	java/io/IOException
    //   555	560	562	java/io/IOException
    //   531	536	569	finally
    //   551	555	569	finally
    //   570	575	577	java/io/IOException
    //   317	322	585	java/io/IOException
    //   312	317	592	java/io/IOException
    //   597	602	604	java/io/IOException
    //   312	317	611	finally
    //   593	597	611	finally
    //   612	617	619	java/io/IOException
    //   358	363	627	java/io/IOException
    //   353	358	635	java/io/IOException
    //   640	645	648	java/io/IOException
    //   353	358	656	finally
    //   636	640	656	finally
    //   657	662	664	java/io/IOException
    //   157	171	672	finally
    //   171	177	676	finally
    //   177	188	676	finally
    //   193	201	676	finally
    //   252	263	676	finally
    //   215	220	683	finally
    //   146	157	691	java/lang/Exception
    //   157	171	696	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.device.DeviceUpdate
 * JD-Core Version:    0.7.0.1
 */