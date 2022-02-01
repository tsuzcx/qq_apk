package com.tencent.mobileqq.webview.webso;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class WebSoUtils
{
  public static final String a;
  public static AtomicBoolean a;
  public static String b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append("tencent/MobileQQ/webso/offline/");
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    b = null;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = null;
  }
  
  private static int a()
  {
    try
    {
      int i = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
      return i;
    }
    catch (Throwable localThrowable)
    {
      label15:
      break label15;
    }
    return 0;
  }
  
  public static long a()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
  }
  
  public static String a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Android Qzone/");
    ((StringBuilder)localObject1).append(VasUtil.a().websoGetQUA());
    Object localObject2 = ((StringBuilder)localObject1).toString();
    int i = HttpUtil.getNetWorkType();
    if (i != -1)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              localObject1 = "";
            } else {
              localObject1 = " NetType/4G";
            }
          }
          else {
            localObject1 = " NetType/3G";
          }
        }
        else {
          localObject1 = " NetType/2G";
        }
      }
      else {
        localObject1 = " NetType/WIFI";
      }
    }
    else {
      localObject1 = " NetType/UNKNOWN";
    }
    i = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
    localObject2 = new StringBuilder((String)localObject2);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append("QQ/");
    ((StringBuilder)localObject2).append("8.7.0");
    ((StringBuilder)localObject2).append(".");
    ((StringBuilder)localObject2).append("5295");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" Pixel/");
    ((StringBuilder)localObject2).append(a());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" StatusBarHeight/");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
    int j = 0;
    try
    {
      boolean bool = ((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
      j = bool;
    }
    catch (Exception localException)
    {
      label227:
      break label227;
    }
    if (j != 0) {
      ((StringBuilder)localObject2).append("StudyMode/1");
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  public static String a(Uri paramUri)
  {
    try
    {
      if (b(paramUri))
      {
        localObject = paramUri.toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramUri.getAuthority());
        ((StringBuilder)localObject).append(paramUri.getPath());
        localObject = ((StringBuilder)localObject).toString();
      }
      Object localObject = MD5Utils.toMD5((String)localObject);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoUtils", 2, "getUrlKey..uri", localThrowable);
      }
    }
    return paramUri.toString();
  }
  
  public static String a(InputStream paramInputStream)
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuilder.append(str);
    }
    paramInputStream.close();
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    try
    {
      String str = a(Uri.parse(paramString));
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoUtils", 2, "getUrlKey..url", localThrowable);
      }
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
    a("addTag");
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        paramString1 = new StringBuilder();
        paramString1.append("<script> var _WebSoLocalTime=");
        paramString1.append(paramString2);
        paramString1.append(";</script>");
        localStringBuilder.append(paramString1.toString());
        paramString1 = new StringBuilder();
        paramString1.append("<script> var _WebSoNetTime=");
        paramString1.append(paramString3);
        paramString1.append(";</script>");
        localStringBuilder.append(paramString1.toString());
        paramString1 = new StringBuilder();
        paramString1.append("add _WebSoLocalTime=");
        paramString1.append(paramString2);
        paramString1.append(", add _WebSoNetTime=");
        paramString1.append(paramString3);
        QLog.i("WebSoService", 1, paramString1.toString());
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        return "";
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return "";
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    try
    {
      FileUtils.deleteFilesInDirectory(b());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WebSoUtils", 1, localException, new Object[0]);
    }
  }
  
  public static void a(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    f(b(paramUri));
    f(c(paramUri));
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("wns_html_etags", 0).edit();
    String str = String.valueOf(a());
    paramUri = a(paramUri);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("eTag_");
    localStringBuilder.append(str);
    localStringBuilder.append(paramUri);
    localEditor.remove(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("templateTag_");
    localStringBuilder.append(str);
    localStringBuilder.append(paramUri);
    localEditor.remove(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("htmlSha1_");
    localStringBuilder.append(str);
    localStringBuilder.append(paramUri);
    localEditor.remove(localStringBuilder.toString());
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebSo", 1, paramString);
    }
  }
  
  public static boolean a(Uri paramUri)
  {
    boolean bool2 = false;
    if (paramUri == null) {
      return false;
    }
    try
    {
      String str = paramUri.getQueryParameter("_proxy");
      boolean bool1;
      if (!"1".equals(str))
      {
        bool1 = bool2;
        if (!"true".equals(str)) {}
      }
      else
      {
        boolean bool3 = TextUtils.isEmpty(e(paramUri.toString()));
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramUri) {}
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
    //   0: ldc_w 350
    //   3: invokestatic 241	com/tencent/mobileqq/webview/webso/WebSoUtils:a	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: ifnull +397 -> 404
    //   10: aload_1
    //   11: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: new 352	java/io/File
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 353	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore 9
    //   29: aconst_null
    //   30: astore 4
    //   32: aconst_null
    //   33: astore 6
    //   35: aconst_null
    //   36: astore 7
    //   38: aconst_null
    //   39: astore_3
    //   40: aconst_null
    //   41: astore 5
    //   43: aconst_null
    //   44: astore 8
    //   46: aload 9
    //   48: invokevirtual 356	java/io/File:exists	()Z
    //   51: ifeq +9 -> 60
    //   54: aload 9
    //   56: invokevirtual 359	java/io/File:delete	()Z
    //   59: pop
    //   60: aload 9
    //   62: invokevirtual 362	java/io/File:createNewFile	()Z
    //   65: pop
    //   66: new 364	java/io/ByteArrayInputStream
    //   69: dup
    //   70: aload_0
    //   71: iconst_0
    //   72: aload_0
    //   73: arraylength
    //   74: invokespecial 367	java/io/ByteArrayInputStream:<init>	([BII)V
    //   77: astore_1
    //   78: new 369	java/io/BufferedOutputStream
    //   81: dup
    //   82: new 371	java/io/FileOutputStream
    //   85: dup
    //   86: aload 9
    //   88: invokespecial 374	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   91: sipush 4096
    //   94: invokespecial 377	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   97: astore_0
    //   98: aload 8
    //   100: astore_3
    //   101: aload 6
    //   103: astore 5
    //   105: invokestatic 383	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   108: sipush 4096
    //   111: invokevirtual 387	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   114: astore 6
    //   116: aload 6
    //   118: astore_3
    //   119: aload 6
    //   121: astore 4
    //   123: aload 6
    //   125: astore 5
    //   127: aload_1
    //   128: aload 6
    //   130: invokevirtual 393	java/io/InputStream:read	([B)I
    //   133: istore_2
    //   134: iload_2
    //   135: iconst_m1
    //   136: if_icmpeq +25 -> 161
    //   139: aload 6
    //   141: astore_3
    //   142: aload 6
    //   144: astore 4
    //   146: aload 6
    //   148: astore 5
    //   150: aload_0
    //   151: aload 6
    //   153: iconst_0
    //   154: iload_2
    //   155: invokevirtual 398	java/io/OutputStream:write	([BII)V
    //   158: goto -42 -> 116
    //   161: aload 6
    //   163: astore_3
    //   164: aload 6
    //   166: astore 4
    //   168: aload 6
    //   170: astore 5
    //   172: aload_0
    //   173: invokevirtual 401	java/io/OutputStream:flush	()V
    //   176: invokestatic 383	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   179: aload 6
    //   181: invokevirtual 405	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   184: aload_1
    //   185: invokevirtual 406	java/io/InputStream:close	()V
    //   188: aload_0
    //   189: invokevirtual 407	java/io/OutputStream:close	()V
    //   192: iconst_1
    //   193: ireturn
    //   194: astore 5
    //   196: aload_1
    //   197: astore 4
    //   199: aload 5
    //   201: astore_1
    //   202: aload_3
    //   203: astore 5
    //   205: goto +163 -> 368
    //   208: astore 6
    //   210: aload 4
    //   212: astore 7
    //   214: goto +55 -> 269
    //   217: astore 6
    //   219: aload 5
    //   221: astore 7
    //   223: goto +95 -> 318
    //   226: astore_3
    //   227: aconst_null
    //   228: astore_0
    //   229: aload_1
    //   230: astore 4
    //   232: aload_3
    //   233: astore_1
    //   234: goto +134 -> 368
    //   237: astore 6
    //   239: aconst_null
    //   240: astore_0
    //   241: goto +28 -> 269
    //   244: astore 6
    //   246: aconst_null
    //   247: astore_0
    //   248: aload_3
    //   249: astore 7
    //   251: goto +67 -> 318
    //   254: astore_1
    //   255: aconst_null
    //   256: astore_0
    //   257: aload_0
    //   258: astore 4
    //   260: goto +108 -> 368
    //   263: astore 6
    //   265: aconst_null
    //   266: astore_0
    //   267: aload_0
    //   268: astore_1
    //   269: aload_0
    //   270: astore_3
    //   271: aload_1
    //   272: astore 4
    //   274: aload 7
    //   276: astore 5
    //   278: aload 6
    //   280: invokevirtual 267	java/lang/Exception:printStackTrace	()V
    //   283: invokestatic 383	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   286: aload 7
    //   288: invokevirtual 405	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   291: aload_1
    //   292: ifnull +7 -> 299
    //   295: aload_1
    //   296: invokevirtual 406	java/io/InputStream:close	()V
    //   299: aload_0
    //   300: ifnull +63 -> 363
    //   303: aload_0
    //   304: invokevirtual 407	java/io/OutputStream:close	()V
    //   307: iconst_0
    //   308: ireturn
    //   309: astore 6
    //   311: aconst_null
    //   312: astore_0
    //   313: aload_0
    //   314: astore_1
    //   315: aload_3
    //   316: astore 7
    //   318: aload_0
    //   319: astore_3
    //   320: aload_1
    //   321: astore 4
    //   323: aload 7
    //   325: astore 5
    //   327: aload 6
    //   329: invokevirtual 408	java/io/IOException:printStackTrace	()V
    //   332: invokestatic 383	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   335: aload 7
    //   337: invokevirtual 405	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   340: aload_1
    //   341: ifnull +7 -> 348
    //   344: aload_1
    //   345: invokevirtual 406	java/io/InputStream:close	()V
    //   348: aload_0
    //   349: ifnull +14 -> 363
    //   352: aload_0
    //   353: invokevirtual 407	java/io/OutputStream:close	()V
    //   356: iconst_0
    //   357: ireturn
    //   358: astore_0
    //   359: aload_0
    //   360: invokevirtual 267	java/lang/Exception:printStackTrace	()V
    //   363: iconst_0
    //   364: ireturn
    //   365: astore_1
    //   366: aload_3
    //   367: astore_0
    //   368: invokestatic 383	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   371: aload 5
    //   373: invokevirtual 405	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   376: aload 4
    //   378: ifnull +8 -> 386
    //   381: aload 4
    //   383: invokevirtual 406	java/io/InputStream:close	()V
    //   386: aload_0
    //   387: ifnull +15 -> 402
    //   390: aload_0
    //   391: invokevirtual 407	java/io/OutputStream:close	()V
    //   394: goto +8 -> 402
    //   397: astore_0
    //   398: aload_0
    //   399: invokevirtual 267	java/lang/Exception:printStackTrace	()V
    //   402: aload_1
    //   403: athrow
    //   404: iconst_0
    //   405: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	paramArrayOfByte	byte[]
    //   0	406	1	paramString	String
    //   133	22	2	i	int
    //   39	164	3	localObject1	Object
    //   226	23	3	localObject2	Object
    //   270	97	3	arrayOfByte1	byte[]
    //   30	352	4	localObject3	Object
    //   41	130	5	arrayOfByte2	byte[]
    //   194	6	5	localObject4	Object
    //   203	169	5	localObject5	Object
    //   33	147	6	arrayOfByte3	byte[]
    //   208	1	6	localException1	Exception
    //   217	1	6	localIOException1	java.io.IOException
    //   237	1	6	localException2	Exception
    //   244	1	6	localIOException2	java.io.IOException
    //   263	16	6	localException3	Exception
    //   309	19	6	localIOException3	java.io.IOException
    //   36	300	7	localObject6	Object
    //   44	55	8	localObject7	Object
    //   27	60	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   105	116	194	finally
    //   127	134	194	finally
    //   150	158	194	finally
    //   172	176	194	finally
    //   105	116	208	java/lang/Exception
    //   127	134	208	java/lang/Exception
    //   150	158	208	java/lang/Exception
    //   172	176	208	java/lang/Exception
    //   105	116	217	java/io/IOException
    //   127	134	217	java/io/IOException
    //   150	158	217	java/io/IOException
    //   172	176	217	java/io/IOException
    //   78	98	226	finally
    //   78	98	237	java/lang/Exception
    //   78	98	244	java/io/IOException
    //   46	60	254	finally
    //   60	78	254	finally
    //   46	60	263	java/lang/Exception
    //   60	78	263	java/lang/Exception
    //   46	60	309	java/io/IOException
    //   60	78	309	java/io/IOException
    //   176	192	358	java/lang/Exception
    //   283	291	358	java/lang/Exception
    //   295	299	358	java/lang/Exception
    //   303	307	358	java/lang/Exception
    //   332	340	358	java/lang/Exception
    //   344	348	358	java/lang/Exception
    //   352	356	358	java/lang/Exception
    //   278	283	365	finally
    //   327	332	365	finally
    //   368	376	397	java/lang/Exception
    //   381	386	397	java/lang/Exception
    //   390	394	397	java/lang/Exception
  }
  
  private static String b()
  {
    Object localObject = new File(VasConstant.d);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    String str = ((File)localObject).getAbsolutePath();
    localObject = str;
    if (!str.endsWith(File.separator))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(File.separator);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String b(Uri paramUri)
  {
    paramUri = d(paramUri);
    if (TextUtils.isEmpty(paramUri)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramUri);
    localStringBuilder.append(".txt");
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return "error";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append(a(paramString));
    localStringBuilder.append(".screenshot");
    return localStringBuilder.toString();
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
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("wns_html_etags", 0).edit();
    long l = a();
    paramUri = a(paramUri);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("webso_");
    localStringBuilder.append(String.valueOf(l));
    localStringBuilder.append(paramUri);
    localStringBuilder.append("_503");
    localEditor.putLong(localStringBuilder.toString(), System.currentTimeMillis());
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  private static boolean b(Uri paramUri)
  {
    String str = null;
    boolean bool2 = false;
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
    catch (Exception paramString)
    {
      label10:
      break label10;
    }
    return false;
  }
  
  private static String c()
  {
    try
    {
      String str = AppConstants.SDCARD_PATH;
      return str;
    }
    catch (Throwable localThrowable)
    {
      label6:
      break label6;
    }
    return "";
  }
  
  public static String c(Uri paramUri)
  {
    paramUri = d(paramUri);
    if (TextUtils.isEmpty(paramUri)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramUri);
    localStringBuilder.append("_template.txt");
    return localStringBuilder.toString();
  }
  
  public static String c(String paramString)
  {
    a("getHtmlData");
    try
    {
      paramString = new File(b(Uri.parse(paramString)));
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoUtils", 2, "getHtmlData", paramString);
      }
      paramString = null;
    }
    if (paramString != null)
    {
      if (!paramString.exists()) {
        return null;
      }
      try
      {
        paramString = FileUtils.readFileToString(paramString);
        return paramString;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
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
    if (b(paramUri))
    {
      paramUri = paramUri.toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramUri.getAuthority());
      ((StringBuilder)localObject).append(paramUri.getPath());
      paramUri = ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramUri);
    ((StringBuilder)localObject).append(String.valueOf(a()));
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      paramUri = MD5Utils.toMD5((String)localObject);
    }
    catch (Throwable localThrowable)
    {
      paramUri = (Uri)localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("WebSoUtils", 2, "getFileBasePath..uri", localThrowable);
        paramUri = (Uri)localObject;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(paramUri);
    return ((StringBuilder)localObject).toString();
  }
  
  public static String d(String paramString)
  {
    Object localObject1 = c(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return "";
    }
    Object localObject2 = BaseApplication.getContext().getSharedPreferences("wns_html_etags", 0);
    String str = a(paramString);
    long l = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("htmlSha1_");
    localStringBuilder.append(String.valueOf(l));
    localStringBuilder.append(str);
    localObject2 = ((SharedPreferences)localObject2).getString(localStringBuilder.toString(), "");
    str = SHA1Util.a((String)localObject1);
    if (str.equals(localObject2))
    {
      a("getHtmlDataAndCheck success");
      return localObject1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("校验缓存etag 不一致，html-sha1 check fail. http rsp etag=");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(",cache_sha1=");
    ((StringBuilder)localObject1).append(str);
    a(((StringBuilder)localObject1).toString());
    try
    {
      a(Uri.parse(paramString));
      return "";
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("clean web so data exception=");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        QLog.d("WebSoUtils", 2, ((StringBuilder)localObject1).toString());
      }
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static boolean d(String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = new File(b(Uri.parse(paramString)));
    }
    catch (Exception paramString)
    {
      break label81;
    }
    catch (Throwable localThrowable)
    {
      paramString = localObject;
      if (!QLog.isColorLevel()) {
        break label99;
      }
    }
    QLog.d("WebSoUtils", 2, "getHtmlData", localThrowable);
    paramString = localObject;
    label81:
    label99:
    while (paramString != null)
    {
      if (!paramString.exists()) {
        return false;
      }
      if (!paramString.canRead()) {
        return false;
      }
      long l = paramString.length();
      if (l > 0L)
      {
        return true;
        if (QLog.isColorLevel()) {
          QLog.w("WebSoUtils", 2, "getHtmlData", paramString);
        }
      }
      return false;
    }
    return false;
  }
  
  public static String e(String paramString)
  {
    Object localObject = QzoneConfig.getInstance().getConfig("QzUrlCache", "HttpProxyHost2Command", "{\".qzone.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"web.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenter.websoh5\",\"msfCommand\":\"mqqweb.gamecenter.websoh5\"},\"m.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenterV2.h5\",\"msfCommand\":\"mqqweb.gamecenterV2.h5\"},\"mc.vip.qq.com\":{\"command\":\"mqqweb.mcvip.websoh5\",\"msfCommand\":\"mqqweb.mcvip.websoh5\"},\"zb.vip.qq.com\":{\"command\":\"mqqweb.zb.webso\",\"msfCommand\":\"mqqweb.zb.webso\"},\"vv.video.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\"qzpb.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\"vv6.video.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\".urlshare.cn\":{\"command\":\"qzoneh5.urlshare.webso\",\"msfCommand\":\"qzoneh5.urlshare.webso\"},\"now.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\"nearby.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\"h5.gdt.qq.com\":{\"command\":\"nemoh5.gdt.lp\",\"msfCommand\":\"nemoh5.gdt.lp\"},\"club.vip.qq.com\":{\"command\":\"qzoneh5.club.wnshtml\",\"msfCommand\":\"qzoneh5.club.wnshtml\"},\".q.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"qun.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"ilive.qq.com\":{\"command\":\"iliveh5.ilive.wnshtml\",\"msfCommand\":\"iliveh5.ilive.wnshtml\"},\".ilive.qq.com\":{\"command\":\"iliveh5.ilive.wnshtml\",\"msfCommand\":\"iliveh5.ilive.wnshtml\"},\"qvideo.qq.com\":{\"command\":\"qvideoh5.qvideo.wnshtml\",\"msfCommand\":\"qvideoh5.qvideo.wnshtml\"},\".qvideo.qq.com\":{\"command\":\"qvideoh5.qvideo.wnshtml\",\"msfCommand\":\"qvideoh5.qvideo.wnshtml\"} }");
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
      return null;
    }
    catch (Exception paramString)
    {
      QLog.e("WebSoUtils", 1, "getWnsCommand error:", paramString);
    }
    return null;
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!a(paramString)) {
      return false;
    }
    Object localObject = Uri.parse(paramString);
    paramString = BaseApplication.getContext().getSharedPreferences("wns_html_etags", 0);
    long l = a();
    localObject = a((Uri)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("webso_");
    localStringBuilder.append(String.valueOf(l));
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_503");
    l = paramString.getLong(localStringBuilder.toString(), -1L);
    if ((l != -1L) && (System.currentTimeMillis() - l < 43200000L))
    {
      if (QLog.isColorLevel()) {
        QLog.e("WebSoUtils", 2, "now hit webso time, so return true");
      }
      return true;
    }
    return false;
  }
  
  public static String f(String paramString)
  {
    Object localObject = QzoneConfig.getInstance().getConfig("QzUrlCache", "HttpProxyHost2Command", "{\".qzone.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"web.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenter.websoh5\",\"msfCommand\":\"mqqweb.gamecenter.websoh5\"},\"m.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenterV2.h5\",\"msfCommand\":\"mqqweb.gamecenterV2.h5\"},\"mc.vip.qq.com\":{\"command\":\"mqqweb.mcvip.websoh5\",\"msfCommand\":\"mqqweb.mcvip.websoh5\"},\"zb.vip.qq.com\":{\"command\":\"mqqweb.zb.webso\",\"msfCommand\":\"mqqweb.zb.webso\"},\"vv.video.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\"qzpb.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\"vv6.video.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\".urlshare.cn\":{\"command\":\"qzoneh5.urlshare.webso\",\"msfCommand\":\"qzoneh5.urlshare.webso\"},\"now.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\"nearby.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\"h5.gdt.qq.com\":{\"command\":\"nemoh5.gdt.lp\",\"msfCommand\":\"nemoh5.gdt.lp\"},\"club.vip.qq.com\":{\"command\":\"qzoneh5.club.wnshtml\",\"msfCommand\":\"qzoneh5.club.wnshtml\"},\".q.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"qun.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"ilive.qq.com\":{\"command\":\"iliveh5.ilive.wnshtml\",\"msfCommand\":\"iliveh5.ilive.wnshtml\"},\".ilive.qq.com\":{\"command\":\"iliveh5.ilive.wnshtml\",\"msfCommand\":\"iliveh5.ilive.wnshtml\"},\"qvideo.qq.com\":{\"command\":\"qvideoh5.qvideo.wnshtml\",\"msfCommand\":\"qvideoh5.qvideo.wnshtml\"},\".qvideo.qq.com\":{\"command\":\"qvideoh5.qvideo.wnshtml\",\"msfCommand\":\"qvideoh5.qvideo.wnshtml\"} }");
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
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return FileUtils.deleteFile(paramString);
  }
  
  public static String g(String paramString)
  {
    a("removeTag");
    return paramString.replaceFirst("<script>.*_WebSoLocalTime.*_WebSoNetTime.*;</script>", "");
  }
  
  public static String h(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("WebSoRequest", 1, "cmd is EMPTY OR NULL !!!");
      return null;
    }
    paramString = paramString.split("\\.");
    if ((paramString != null) && (paramString.length > 0)) {
      return paramString[(paramString.length - 1)];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoUtils
 * JD-Core Version:    0.7.0.1
 */