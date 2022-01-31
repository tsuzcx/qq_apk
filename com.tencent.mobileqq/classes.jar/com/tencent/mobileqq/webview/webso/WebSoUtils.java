package com.tencent.mobileqq.webview.webso;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import java.io.File;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class WebSoUtils
{
  public static final String a = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent/MobileQQ/webso/offline/";
  public static final String b = BaseApplication.getContext().getFilesDir() + "/webso/offline/";
  
  public static String a()
  {
    Object localObject = "Android Qzone/" + QUA.a();
    String str;
    switch (HttpUtil.a())
    {
    case 0: 
    default: 
      str = "";
    }
    for (;;)
    {
      localObject = new StringBuilder((String)localObject);
      ((StringBuilder)localObject).append(" ").append("QQ/").append("7.6.3").append(".").append("3560").append(str).append(" Pixel/").append(BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels);
      return ((StringBuilder)localObject).toString();
      str = " NetType/UNKNOWN";
      continue;
      str = " NetType/WIFI";
      continue;
      str = " NetType/2G";
      continue;
      str = " NetType/3G";
      continue;
      str = " NetType/4G";
    }
  }
  
  public static String a(Uri paramUri)
  {
    try
    {
      if (b(paramUri)) {}
      for (String str = paramUri.toString();; str = paramUri.getAuthority() + paramUri.getPath()) {
        return MD5Utils.d(str);
      }
      return paramUri.toString();
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoUtils", 2, "getUrlKey..uri", localThrowable);
      }
    }
  }
  
  public static String a(String paramString)
  {
    try
    {
      str = a(Uri.parse(paramString));
      return str;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        String str = paramString;
      } while (!QLog.isColorLevel());
      QLog.d("WebSoUtils", 2, "getUrlKey..url", localThrowable);
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = String.valueOf(System.currentTimeMillis());
    WebSoService.a().a(paramString1, str);
    return a(paramString2, str, null);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      localStringBuilder.append("<script> var _WebSoLocalTime=" + paramString2 + ";</script>");
      localStringBuilder.append("<script> var _WebSoNetTime=" + paramString3 + ";</script>");
      QLog.i("WebSoService", 1, "add _WebSoLocalTime=" + paramString2 + ", add _WebSoNetTime=" + paramString3);
      return localStringBuilder.toString();
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return "";
    }
    catch (OutOfMemoryError paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static void a(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    f(b(paramUri));
    f(c(paramUri));
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("wns_html_etags", 0).edit();
    String str = String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    paramUri = a(paramUri);
    localEditor.remove("eTag_" + str + paramUri);
    localEditor.remove("templateTag_" + str + paramUri);
    localEditor.remove("htmlSha1_" + str + paramUri);
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  public static boolean a(Uri paramUri)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramUri == null) {
      bool2 = bool1;
    }
    for (;;)
    {
      return bool2;
      try
      {
        String str = paramUri.getQueryParameter("_proxy");
        bool1 = bool2;
        if (str != null) {
          if (!"1".equals(str))
          {
            bool1 = bool2;
            if (!"true".equals(str)) {}
          }
          else
          {
            boolean bool3 = TextUtils.isEmpty(d(paramUri.toString()));
            bool1 = bool2;
            if (!bool3) {
              bool1 = true;
            }
          }
        }
        bool2 = bool1;
        if (bool1) {
          return bool1;
        }
      }
      catch (Exception paramUri) {}
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("_updateProxy");
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        boolean bool3 = "0".equals(paramString);
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 7
    //   18: aload_0
    //   19: ifnull +10 -> 29
    //   22: aload_1
    //   23: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +7 -> 33
    //   29: iconst_0
    //   30: istore_3
    //   31: iload_3
    //   32: ireturn
    //   33: new 22	java/io/File
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 294	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 6
    //   43: aload 6
    //   45: invokevirtual 297	java/io/File:exists	()Z
    //   48: ifeq +9 -> 57
    //   51: aload 6
    //   53: invokevirtual 300	java/io/File:delete	()Z
    //   56: pop
    //   57: aload 6
    //   59: invokevirtual 303	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: new 305	java/io/ByteArrayInputStream
    //   66: dup
    //   67: aload_0
    //   68: iconst_0
    //   69: aload_0
    //   70: arraylength
    //   71: invokespecial 308	java/io/ByteArrayInputStream:<init>	([BII)V
    //   74: astore_1
    //   75: new 310	java/io/BufferedOutputStream
    //   78: dup
    //   79: new 312	java/io/FileOutputStream
    //   82: dup
    //   83: aload 6
    //   85: invokespecial 315	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   88: sipush 4096
    //   91: invokespecial 318	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   94: astore 6
    //   96: aload 10
    //   98: astore_0
    //   99: aload 6
    //   101: astore 5
    //   103: aload_1
    //   104: astore 4
    //   106: aload 9
    //   108: astore 8
    //   110: invokestatic 324	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   113: sipush 4096
    //   116: invokevirtual 328	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   119: astore 9
    //   121: aload 9
    //   123: astore 7
    //   125: aload 9
    //   127: astore_0
    //   128: aload 6
    //   130: astore 5
    //   132: aload_1
    //   133: astore 4
    //   135: aload 9
    //   137: astore 8
    //   139: aload_1
    //   140: aload 9
    //   142: invokevirtual 334	java/io/InputStream:read	([B)I
    //   145: istore_2
    //   146: iload_2
    //   147: iconst_m1
    //   148: if_icmpeq +84 -> 232
    //   151: aload 9
    //   153: astore 7
    //   155: aload 9
    //   157: astore_0
    //   158: aload 6
    //   160: astore 5
    //   162: aload_1
    //   163: astore 4
    //   165: aload 9
    //   167: astore 8
    //   169: aload 6
    //   171: aload 9
    //   173: iconst_0
    //   174: iload_2
    //   175: invokevirtual 339	java/io/OutputStream:write	([BII)V
    //   178: goto -57 -> 121
    //   181: astore_0
    //   182: aload 7
    //   184: astore 8
    //   186: aload_0
    //   187: astore 7
    //   189: aload 8
    //   191: astore_0
    //   192: aload 6
    //   194: astore 5
    //   196: aload_1
    //   197: astore 4
    //   199: aload 7
    //   201: invokevirtual 340	java/io/IOException:printStackTrace	()V
    //   204: invokestatic 324	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   207: aload 8
    //   209: invokevirtual 344	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   212: aload_1
    //   213: ifnull +7 -> 220
    //   216: aload_1
    //   217: invokevirtual 347	java/io/InputStream:close	()V
    //   220: aload 6
    //   222: ifnull +8 -> 230
    //   225: aload 6
    //   227: invokevirtual 348	java/io/OutputStream:close	()V
    //   230: iconst_0
    //   231: ireturn
    //   232: aload 9
    //   234: astore 7
    //   236: aload 9
    //   238: astore_0
    //   239: aload 6
    //   241: astore 5
    //   243: aload_1
    //   244: astore 4
    //   246: aload 9
    //   248: astore 8
    //   250: aload 6
    //   252: invokevirtual 351	java/io/OutputStream:flush	()V
    //   255: iconst_1
    //   256: istore_3
    //   257: invokestatic 324	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   260: aload 9
    //   262: invokevirtual 344	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   265: aload_1
    //   266: ifnull +7 -> 273
    //   269: aload_1
    //   270: invokevirtual 347	java/io/InputStream:close	()V
    //   273: aload 6
    //   275: ifnull -244 -> 31
    //   278: aload 6
    //   280: invokevirtual 348	java/io/OutputStream:close	()V
    //   283: iconst_1
    //   284: ireturn
    //   285: astore_0
    //   286: aload_0
    //   287: invokevirtual 213	java/lang/Exception:printStackTrace	()V
    //   290: iconst_0
    //   291: ireturn
    //   292: astore_0
    //   293: aload_0
    //   294: invokevirtual 213	java/lang/Exception:printStackTrace	()V
    //   297: iconst_0
    //   298: ireturn
    //   299: astore 7
    //   301: aconst_null
    //   302: astore 6
    //   304: aconst_null
    //   305: astore_1
    //   306: aload 8
    //   308: astore_0
    //   309: aload 6
    //   311: astore 5
    //   313: aload_1
    //   314: astore 4
    //   316: aload 7
    //   318: invokevirtual 213	java/lang/Exception:printStackTrace	()V
    //   321: invokestatic 324	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   324: aload 8
    //   326: invokevirtual 344	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   329: aload_1
    //   330: ifnull +7 -> 337
    //   333: aload_1
    //   334: invokevirtual 347	java/io/InputStream:close	()V
    //   337: aload 6
    //   339: ifnull +8 -> 347
    //   342: aload 6
    //   344: invokevirtual 348	java/io/OutputStream:close	()V
    //   347: iconst_0
    //   348: ireturn
    //   349: astore_0
    //   350: aload_0
    //   351: invokevirtual 213	java/lang/Exception:printStackTrace	()V
    //   354: iconst_0
    //   355: ireturn
    //   356: astore 6
    //   358: aconst_null
    //   359: astore 5
    //   361: aconst_null
    //   362: astore_1
    //   363: aload 4
    //   365: astore_0
    //   366: invokestatic 324	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   369: aload_0
    //   370: invokevirtual 344	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   373: aload_1
    //   374: ifnull +7 -> 381
    //   377: aload_1
    //   378: invokevirtual 347	java/io/InputStream:close	()V
    //   381: aload 5
    //   383: ifnull +8 -> 391
    //   386: aload 5
    //   388: invokevirtual 348	java/io/OutputStream:close	()V
    //   391: aload 6
    //   393: athrow
    //   394: astore_0
    //   395: aload_0
    //   396: invokevirtual 213	java/lang/Exception:printStackTrace	()V
    //   399: goto -8 -> 391
    //   402: astore 6
    //   404: aconst_null
    //   405: astore 5
    //   407: aload 4
    //   409: astore_0
    //   410: goto -44 -> 366
    //   413: astore 6
    //   415: aload 4
    //   417: astore_1
    //   418: goto -52 -> 366
    //   421: astore 7
    //   423: aconst_null
    //   424: astore 6
    //   426: goto -120 -> 306
    //   429: astore 7
    //   431: goto -125 -> 306
    //   434: astore 7
    //   436: aconst_null
    //   437: astore 6
    //   439: aconst_null
    //   440: astore_1
    //   441: aload 5
    //   443: astore 8
    //   445: goto -256 -> 189
    //   448: astore 7
    //   450: aconst_null
    //   451: astore 6
    //   453: aload 5
    //   455: astore 8
    //   457: goto -268 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	paramArrayOfByte	byte[]
    //   0	460	1	paramString	String
    //   145	30	2	i	int
    //   30	227	3	bool	boolean
    //   7	409	4	str	String
    //   1	453	5	localObject1	Object
    //   41	302	6	localObject2	Object
    //   356	36	6	localObject3	Object
    //   402	1	6	localObject4	Object
    //   413	1	6	localObject5	Object
    //   424	28	6	localObject6	Object
    //   16	219	7	arrayOfByte1	byte[]
    //   299	18	7	localException1	Exception
    //   421	1	7	localException2	Exception
    //   429	1	7	localException3	Exception
    //   434	1	7	localIOException1	java.io.IOException
    //   448	1	7	localIOException2	java.io.IOException
    //   4	452	8	localObject7	Object
    //   13	248	9	arrayOfByte2	byte[]
    //   10	87	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   110	121	181	java/io/IOException
    //   139	146	181	java/io/IOException
    //   169	178	181	java/io/IOException
    //   250	255	181	java/io/IOException
    //   257	265	285	java/lang/Exception
    //   269	273	285	java/lang/Exception
    //   278	283	285	java/lang/Exception
    //   204	212	292	java/lang/Exception
    //   216	220	292	java/lang/Exception
    //   225	230	292	java/lang/Exception
    //   43	57	299	java/lang/Exception
    //   57	75	299	java/lang/Exception
    //   321	329	349	java/lang/Exception
    //   333	337	349	java/lang/Exception
    //   342	347	349	java/lang/Exception
    //   43	57	356	finally
    //   57	75	356	finally
    //   366	373	394	java/lang/Exception
    //   377	381	394	java/lang/Exception
    //   386	391	394	java/lang/Exception
    //   75	96	402	finally
    //   110	121	413	finally
    //   139	146	413	finally
    //   169	178	413	finally
    //   199	204	413	finally
    //   250	255	413	finally
    //   316	321	413	finally
    //   75	96	421	java/lang/Exception
    //   110	121	429	java/lang/Exception
    //   139	146	429	java/lang/Exception
    //   169	178	429	java/lang/Exception
    //   250	255	429	java/lang/Exception
    //   43	57	434	java/io/IOException
    //   57	75	434	java/io/IOException
    //   75	96	448	java/io/IOException
  }
  
  private static String b()
  {
    if (FileUtils.a()) {}
    for (Object localObject = a;; localObject = b)
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      String str = ((File)localObject).getAbsolutePath();
      localObject = str;
      if (!str.endsWith(File.separator)) {
        localObject = str + File.separator;
      }
      return localObject;
    }
  }
  
  public static String b(Uri paramUri)
  {
    paramUri = d(paramUri);
    if (TextUtils.isEmpty(paramUri)) {
      return "";
    }
    return paramUri + ".txt";
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = new File(b(Uri.parse(paramString)));
      if ((paramString == null) || (!paramString.exists())) {
        return null;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebSoUtils", 2, "getHtmlData", paramString);
        }
        paramString = null;
      }
      try
      {
        paramString = FileUtils.b(paramString);
        return paramString;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    paramString2 = a(paramString2, WebSoService.a().a(paramString1), String.valueOf(System.currentTimeMillis()));
    WebSoService.a().a(paramString1);
    return paramString2;
  }
  
  public static void b(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    a(paramUri);
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("wns_html_etags", 0).edit();
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    paramUri = a(paramUri);
    localEditor.putLong("webso_" + String.valueOf(l) + paramUri + "_503", System.currentTimeMillis());
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  private static boolean b(Uri paramUri)
  {
    boolean bool2 = false;
    String str = null;
    if (paramUri != null) {}
    try
    {
      str = paramUri.getQueryParameter("_proxyByURL");
      boolean bool1 = bool2;
      if (str != null) {
        if (!"1".equals(str))
        {
          boolean bool3 = "true".equals(str);
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramUri) {}
    return false;
  }
  
  public static boolean b(String paramString)
  {
    try
    {
      boolean bool = a(Uri.parse(paramString));
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static String c(Uri paramUri)
  {
    paramUri = d(paramUri);
    if (TextUtils.isEmpty(paramUri)) {
      return "";
    }
    return paramUri + "_template.txt";
  }
  
  public static String c(String paramString)
  {
    String str1 = b(paramString);
    if (TextUtils.isEmpty(str1)) {
      paramString = "";
    }
    Object localObject;
    String str2;
    do
    {
      return paramString;
      localObject = BaseApplicationImpl.getContext().getSharedPreferences("wns_html_etags", 0);
      str2 = a(paramString);
      long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      localObject = ((SharedPreferences)localObject).getString("htmlSha1_" + String.valueOf(l) + str2, "");
      str2 = SHA1Util.a(str1);
      if (!str2.equals(localObject)) {
        break;
      }
      paramString = str1;
    } while (!QLog.isColorLevel());
    QLog.d("WebSoUtils", 2, "getHtmlDataAndCheck success");
    return str1;
    if (QLog.isColorLevel()) {
      QLog.w("WebSoUtils", 2, "校验缓存etag 不一致，html-sha1 check fail. http rsp etag=" + (String)localObject + ",cache_sha1=" + str2);
    }
    try
    {
      a(Uri.parse(paramString));
      return "";
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebSoUtils", 2, "clean web so data exception=" + paramString.getMessage());
        }
        paramString.printStackTrace();
      }
    }
  }
  
  public static boolean c(String paramString)
  {
    boolean bool2 = false;
    try
    {
      String str1 = QzoneConfig.getInstance().getConfig("QzoneCover", "dynamicCoverPreviewUrl", "h5.qzone.qq.com/bgstore/dynamiccover");
      String str2 = QzoneConfig.getInstance().getConfig("QzoneCover", "dynamicCoverPreviewKeyword", "tplId=");
      boolean bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.contains(str1))
        {
          boolean bool3 = paramString.contains(str2);
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static String d(Uri paramUri)
  {
    if (paramUri == null) {
      return "";
    }
    String str = b();
    if (b(paramUri)) {}
    for (paramUri = paramUri.toString();; paramUri = paramUri.getAuthority() + paramUri.getPath())
    {
      paramUri = MD5Utils.d(paramUri + String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()));
      return str + paramUri;
    }
  }
  
  public static String d(String paramString)
  {
    Object localObject = QzoneConfig.getInstance().getConfig("QzUrlCache", "HttpProxyHost2Command", "{\".qzone.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"web.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenter.websoh5\",\"msfCommand\":\"mqqweb.gamecenter.websoh5\"},\"m.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenterV2.h5\",\"msfCommand\":\"mqqweb.gamecenterV2.h5\"},\"mc.vip.qq.com\":{\"command\":\"mqqweb.mcvip.websoh5\",\"msfCommand\":\"mqqweb.mcvip.websoh5\"},\"zb.vip.qq.com\":{\"command\":\"mqqweb.zb.webso\",\"msfCommand\":\"mqqweb.zb.webso\"},\"vv.video.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\"qzpb.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\".urlshare.cn\":{\"command\":\"qzoneh5.urlshare.webso\",\"msfCommand\":\"qzoneh5.urlshare.webso\"},\"now.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\"nearby.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\".weishi.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\".weishi.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"} }");
    try
    {
      localObject = new JSONObject((String)localObject);
      Iterator localIterator = ((JSONObject)localObject).keys();
      paramString = Uri.parse(paramString).getHost();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        if ((paramString.equals(str)) || ((str.startsWith(".")) && (paramString.endsWith(str))))
        {
          localObject = (JSONObject)((JSONObject)localObject).get(str);
          paramString = ((JSONObject)localObject).optString("command");
          localObject = ((JSONObject)localObject).optString("msfCommand");
          boolean bool = TextUtils.isEmpty(paramString);
          if (bool) {
            return localObject;
          }
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    return null;
  }
  
  public static boolean d(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new File(b(Uri.parse(paramString)));
        if (paramString != null) {
          continue;
        }
      }
      catch (Throwable paramString)
      {
        if (!QLog.isColorLevel()) {
          break label87;
        }
        QLog.d("WebSoUtils", 2, "getHtmlData", paramString);
        break label87;
        if ((!paramString.exists()) || (!paramString.canRead())) {
          continue;
        }
        long l = paramString.length();
        if (l <= 0L) {
          continue;
        }
        return true;
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("WebSoUtils", 2, "getHtmlData", paramString);
        return false;
      }
      return false;
      label87:
      paramString = null;
    }
  }
  
  public static String e(String paramString)
  {
    Object localObject = QzoneConfig.getInstance().getConfig("QzUrlCache", "HttpProxyHost2Command", "{\".qzone.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"web.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenter.websoh5\",\"msfCommand\":\"mqqweb.gamecenter.websoh5\"},\"m.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenterV2.h5\",\"msfCommand\":\"mqqweb.gamecenterV2.h5\"},\"mc.vip.qq.com\":{\"command\":\"mqqweb.mcvip.websoh5\",\"msfCommand\":\"mqqweb.mcvip.websoh5\"},\"zb.vip.qq.com\":{\"command\":\"mqqweb.zb.webso\",\"msfCommand\":\"mqqweb.zb.webso\"},\"vv.video.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\"qzpb.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\".urlshare.cn\":{\"command\":\"qzoneh5.urlshare.webso\",\"msfCommand\":\"qzoneh5.urlshare.webso\"},\"now.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\"nearby.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\".weishi.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\".weishi.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"} }");
    try
    {
      localObject = new JSONObject((String)localObject);
      Iterator localIterator = ((JSONObject)localObject).keys();
      paramString = Uri.parse(paramString).getHost();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        if ((paramString.equals(str)) || ((str.startsWith(".")) && (paramString.endsWith(str))))
        {
          paramString = (JSONObject)((JSONObject)localObject).get(str);
          localObject = paramString.optString("command");
          paramString = paramString.optString("msfCommand");
          boolean bool = TextUtils.isEmpty(paramString);
          if (bool) {
            paramString = (String)localObject;
          }
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    return null;
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long l;
    do
    {
      do
      {
        return false;
      } while (!a(paramString));
      Object localObject = Uri.parse(paramString);
      paramString = BaseApplicationImpl.getContext().getSharedPreferences("wns_html_etags", 0);
      l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      localObject = a((Uri)localObject);
      l = paramString.getLong("webso_" + String.valueOf(l) + (String)localObject + "_503", -1L);
    } while ((l == -1L) || (System.currentTimeMillis() - l >= 43200000L));
    if (QLog.isColorLevel()) {
      QLog.e("WebSoUtils", 2, "now hit webso time, so return true");
    }
    return true;
  }
  
  public static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return FileUtils.d(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoUtils
 * JD-Core Version:    0.7.0.1
 */