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
import com.tencent.mobileqq.utils.QQTheme;
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
  public static String b = null;
  public static AtomicBoolean c = null;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(f());
    localStringBuilder.append("tencent/MobileQQ/webso/offline/");
    a = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
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
  
  public static String a(String paramString1, String paramString2)
  {
    String str = String.valueOf(System.currentTimeMillis());
    WebSoService.a().a(paramString1, str);
    return a(paramString2, str, null);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    m("addTag");
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
      FileUtils.deleteFilesInDirectory(d());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WebSoUtils", 1, localException, new Object[0]);
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
        boolean bool3 = TextUtils.isEmpty(j(paramUri.toString()));
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
    //   0: ldc 174
    //   2: invokestatic 94	com/tencent/mobileqq/webview/webso/WebSoUtils:m	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: ifnull +397 -> 403
    //   9: aload_1
    //   10: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: new 176	java/io/File
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 177	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 9
    //   28: aconst_null
    //   29: astore 4
    //   31: aconst_null
    //   32: astore 6
    //   34: aconst_null
    //   35: astore 7
    //   37: aconst_null
    //   38: astore_3
    //   39: aconst_null
    //   40: astore 5
    //   42: aconst_null
    //   43: astore 8
    //   45: aload 9
    //   47: invokevirtual 181	java/io/File:exists	()Z
    //   50: ifeq +9 -> 59
    //   53: aload 9
    //   55: invokevirtual 184	java/io/File:delete	()Z
    //   58: pop
    //   59: aload 9
    //   61: invokevirtual 187	java/io/File:createNewFile	()Z
    //   64: pop
    //   65: new 189	java/io/ByteArrayInputStream
    //   68: dup
    //   69: aload_0
    //   70: iconst_0
    //   71: aload_0
    //   72: arraylength
    //   73: invokespecial 192	java/io/ByteArrayInputStream:<init>	([BII)V
    //   76: astore_1
    //   77: new 194	java/io/BufferedOutputStream
    //   80: dup
    //   81: new 196	java/io/FileOutputStream
    //   84: dup
    //   85: aload 9
    //   87: invokespecial 199	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   90: sipush 4096
    //   93: invokespecial 202	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   96: astore_0
    //   97: aload 8
    //   99: astore_3
    //   100: aload 6
    //   102: astore 5
    //   104: invokestatic 208	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   107: sipush 4096
    //   110: invokevirtual 212	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   113: astore 6
    //   115: aload 6
    //   117: astore_3
    //   118: aload 6
    //   120: astore 4
    //   122: aload 6
    //   124: astore 5
    //   126: aload_1
    //   127: aload 6
    //   129: invokevirtual 218	java/io/InputStream:read	([B)I
    //   132: istore_2
    //   133: iload_2
    //   134: iconst_m1
    //   135: if_icmpeq +25 -> 160
    //   138: aload 6
    //   140: astore_3
    //   141: aload 6
    //   143: astore 4
    //   145: aload 6
    //   147: astore 5
    //   149: aload_0
    //   150: aload 6
    //   152: iconst_0
    //   153: iload_2
    //   154: invokevirtual 223	java/io/OutputStream:write	([BII)V
    //   157: goto -42 -> 115
    //   160: aload 6
    //   162: astore_3
    //   163: aload 6
    //   165: astore 4
    //   167: aload 6
    //   169: astore 5
    //   171: aload_0
    //   172: invokevirtual 226	java/io/OutputStream:flush	()V
    //   175: invokestatic 208	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   178: aload 6
    //   180: invokevirtual 230	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   183: aload_1
    //   184: invokevirtual 231	java/io/InputStream:close	()V
    //   187: aload_0
    //   188: invokevirtual 232	java/io/OutputStream:close	()V
    //   191: iconst_1
    //   192: ireturn
    //   193: astore 5
    //   195: aload_1
    //   196: astore 4
    //   198: aload 5
    //   200: astore_1
    //   201: aload_3
    //   202: astore 5
    //   204: goto +163 -> 367
    //   207: astore 6
    //   209: aload 4
    //   211: astore 7
    //   213: goto +55 -> 268
    //   216: astore 6
    //   218: aload 5
    //   220: astore 7
    //   222: goto +95 -> 317
    //   225: astore_3
    //   226: aconst_null
    //   227: astore_0
    //   228: aload_1
    //   229: astore 4
    //   231: aload_3
    //   232: astore_1
    //   233: goto +134 -> 367
    //   236: astore 6
    //   238: aconst_null
    //   239: astore_0
    //   240: goto +28 -> 268
    //   243: astore 6
    //   245: aconst_null
    //   246: astore_0
    //   247: aload_3
    //   248: astore 7
    //   250: goto +67 -> 317
    //   253: astore_1
    //   254: aconst_null
    //   255: astore_0
    //   256: aload_0
    //   257: astore 4
    //   259: goto +108 -> 367
    //   262: astore 6
    //   264: aconst_null
    //   265: astore_0
    //   266: aload_0
    //   267: astore_1
    //   268: aload_0
    //   269: astore_3
    //   270: aload_1
    //   271: astore 4
    //   273: aload 7
    //   275: astore 5
    //   277: aload 6
    //   279: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   282: invokestatic 208	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   285: aload 7
    //   287: invokevirtual 230	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   290: aload_1
    //   291: ifnull +7 -> 298
    //   294: aload_1
    //   295: invokevirtual 231	java/io/InputStream:close	()V
    //   298: aload_0
    //   299: ifnull +63 -> 362
    //   302: aload_0
    //   303: invokevirtual 232	java/io/OutputStream:close	()V
    //   306: iconst_0
    //   307: ireturn
    //   308: astore 6
    //   310: aconst_null
    //   311: astore_0
    //   312: aload_0
    //   313: astore_1
    //   314: aload_3
    //   315: astore 7
    //   317: aload_0
    //   318: astore_3
    //   319: aload_1
    //   320: astore 4
    //   322: aload 7
    //   324: astore 5
    //   326: aload 6
    //   328: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   331: invokestatic 208	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   334: aload 7
    //   336: invokevirtual 230	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   339: aload_1
    //   340: ifnull +7 -> 347
    //   343: aload_1
    //   344: invokevirtual 231	java/io/InputStream:close	()V
    //   347: aload_0
    //   348: ifnull +14 -> 362
    //   351: aload_0
    //   352: invokevirtual 232	java/io/OutputStream:close	()V
    //   355: iconst_0
    //   356: ireturn
    //   357: astore_0
    //   358: aload_0
    //   359: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   362: iconst_0
    //   363: ireturn
    //   364: astore_1
    //   365: aload_3
    //   366: astore_0
    //   367: invokestatic 208	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   370: aload 5
    //   372: invokevirtual 230	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   375: aload 4
    //   377: ifnull +8 -> 385
    //   380: aload 4
    //   382: invokevirtual 231	java/io/InputStream:close	()V
    //   385: aload_0
    //   386: ifnull +15 -> 401
    //   389: aload_0
    //   390: invokevirtual 232	java/io/OutputStream:close	()V
    //   393: goto +8 -> 401
    //   396: astore_0
    //   397: aload_0
    //   398: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   401: aload_1
    //   402: athrow
    //   403: iconst_0
    //   404: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	paramArrayOfByte	byte[]
    //   0	405	1	paramString	String
    //   132	22	2	i	int
    //   38	164	3	localObject1	Object
    //   225	23	3	localObject2	Object
    //   269	97	3	arrayOfByte1	byte[]
    //   29	352	4	localObject3	Object
    //   40	130	5	arrayOfByte2	byte[]
    //   193	6	5	localObject4	Object
    //   202	169	5	localObject5	Object
    //   32	147	6	arrayOfByte3	byte[]
    //   207	1	6	localException1	Exception
    //   216	1	6	localIOException1	java.io.IOException
    //   236	1	6	localException2	Exception
    //   243	1	6	localIOException2	java.io.IOException
    //   262	16	6	localException3	Exception
    //   308	19	6	localIOException3	java.io.IOException
    //   35	300	7	localObject6	Object
    //   43	55	8	localObject7	Object
    //   26	60	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   104	115	193	finally
    //   126	133	193	finally
    //   149	157	193	finally
    //   171	175	193	finally
    //   104	115	207	java/lang/Exception
    //   126	133	207	java/lang/Exception
    //   149	157	207	java/lang/Exception
    //   171	175	207	java/lang/Exception
    //   104	115	216	java/io/IOException
    //   126	133	216	java/io/IOException
    //   149	157	216	java/io/IOException
    //   171	175	216	java/io/IOException
    //   77	97	225	finally
    //   77	97	236	java/lang/Exception
    //   77	97	243	java/io/IOException
    //   45	59	253	finally
    //   59	77	253	finally
    //   45	59	262	java/lang/Exception
    //   59	77	262	java/lang/Exception
    //   45	59	308	java/io/IOException
    //   59	77	308	java/io/IOException
    //   175	191	357	java/lang/Exception
    //   282	290	357	java/lang/Exception
    //   294	298	357	java/lang/Exception
    //   302	306	357	java/lang/Exception
    //   331	339	357	java/lang/Exception
    //   343	347	357	java/lang/Exception
    //   351	355	357	java/lang/Exception
    //   277	282	364	finally
    //   326	331	364	finally
    //   367	375	396	java/lang/Exception
    //   380	385	396	java/lang/Exception
    //   389	393	396	java/lang/Exception
  }
  
  public static String b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Android Qzone/");
    ((StringBuilder)localObject1).append(VasUtil.b().websoGetQUA());
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
    ((StringBuilder)localObject2).append("8.8.17");
    ((StringBuilder)localObject2).append(".");
    ((StringBuilder)localObject2).append("5770");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" Pixel/");
    ((StringBuilder)localObject2).append(e());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" StatusBarHeight/");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" QQTheme/");
    ((StringBuilder)localObject1).append(QQTheme.getCurrentThemeId());
    ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
    int j = 0;
    try
    {
      boolean bool = ((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
      j = bool;
    }
    catch (Exception localException)
    {
      label272:
      break label272;
    }
    if (j != 0) {
      ((StringBuilder)localObject2).append("StudyMode/1");
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  public static String b(Uri paramUri)
  {
    try
    {
      if (h(paramUri))
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
  
  public static String b(String paramString1, String paramString2)
  {
    paramString2 = a(paramString2, WebSoService.a().a(paramString1), String.valueOf(System.currentTimeMillis()));
    WebSoService.a().b(paramString1);
    return paramString2;
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
  
  public static long c()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
  }
  
  public static String c(Uri paramUri)
  {
    paramUri = e(paramUri);
    if (TextUtils.isEmpty(paramUri)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramUri);
    localStringBuilder.append(".txt");
    return localStringBuilder.toString();
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
  
  private static String d()
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
  
  public static String d(Uri paramUri)
  {
    paramUri = e(paramUri);
    if (TextUtils.isEmpty(paramUri)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramUri);
    localStringBuilder.append("_template.txt");
    return localStringBuilder.toString();
  }
  
  public static String d(String paramString)
  {
    try
    {
      String str = b(Uri.parse(paramString));
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
  
  private static int e()
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
  
  public static String e(Uri paramUri)
  {
    if (paramUri == null) {
      return "";
    }
    String str = d();
    if (h(paramUri))
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
    ((StringBuilder)localObject).append(String.valueOf(c()));
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
  
  public static String e(String paramString)
  {
    if (paramString == null) {
      return "error";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d());
    localStringBuilder.append(d(paramString));
    localStringBuilder.append(".screenshot");
    return localStringBuilder.toString();
  }
  
  private static String f()
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
  
  public static String f(String paramString)
  {
    m("getHtmlData");
    try
    {
      paramString = new File(c(Uri.parse(paramString)));
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
  
  public static void f(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    o(c(paramUri));
    o(d(paramUri));
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("wns_html_etags", 0).edit();
    String str = String.valueOf(c());
    paramUri = b(paramUri);
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
  
  public static void g(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    f(paramUri);
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("wns_html_etags", 0).edit();
    long l = c();
    paramUri = b(paramUri);
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
  
  public static boolean g(String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = new File(c(Uri.parse(paramString)));
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
  
  public static String h(String paramString)
  {
    Object localObject1 = f(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return "";
    }
    Object localObject2 = BaseApplication.getContext().getSharedPreferences("wns_html_etags", 0);
    String str = d(paramString);
    long l = c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("htmlSha1_");
    localStringBuilder.append(String.valueOf(l));
    localStringBuilder.append(str);
    localObject2 = ((SharedPreferences)localObject2).getString(localStringBuilder.toString(), "");
    str = SHA1Util.a((String)localObject1);
    if (str.equals(localObject2))
    {
      m("getHtmlDataAndCheck success");
      return localObject1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("校验缓存etag 不一致，html-sha1 check fail. http rsp etag=");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(",cache_sha1=");
    ((StringBuilder)localObject1).append(str);
    m(((StringBuilder)localObject1).toString());
    try
    {
      f(Uri.parse(paramString));
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
  
  private static boolean h(Uri paramUri)
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
  
  public static boolean i(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!a(paramString)) {
      return false;
    }
    Object localObject = Uri.parse(paramString);
    paramString = BaseApplication.getContext().getSharedPreferences("wns_html_etags", 0);
    long l = c();
    localObject = b((Uri)localObject);
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
  
  public static String j(String paramString)
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
  
  public static String k(String paramString)
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
  
  public static String l(String paramString)
  {
    m("removeTag");
    return paramString.replaceFirst("<script>.*_WebSoLocalTime.*_WebSoNetTime.*;</script>", "");
  }
  
  public static void m(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebSo", 1, paramString);
    }
  }
  
  public static String n(String paramString)
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
  
  private static boolean o(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return FileUtils.deleteFile(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoUtils
 * JD-Core Version:    0.7.0.1
 */