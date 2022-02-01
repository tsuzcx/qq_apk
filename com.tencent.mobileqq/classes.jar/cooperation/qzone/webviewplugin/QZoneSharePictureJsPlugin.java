package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.open.base.BitmapUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener;
import com.tencent.qzonehub.api.impl.QZoneHelperProxyImpl;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.thread.BaseHandler;
import cooperation.qzone.util.AlbumLibDownloaderUtil;
import cooperation.qzone.util.GifCoder;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneSharePictureJsPlugin
  extends QzoneInternalWebViewPlugin
{
  private static final String ARG_ARRAY_IMAGES = "images";
  private static final String ARG_INT_FRAME_DELAY = "delay";
  private static final String ARG_NEED_PUBLISHED = "needPublish";
  private static final String ARG_STR_CONTENT = "content";
  private static final String ARG_SUPPORT_MULTI_PIECES_CALLBACK = "supportMultiPiecesCallback";
  private static final String ARG_USE_ORIGIN = "useSample";
  private static final String ARG_USE_PATH = "usePath";
  private static final String DISK_FULL_MSG = HardCodeUtil.a(2131909876);
  private static final String NAMESPACE = "Qzone";
  private static final int RESULT_CANCEL = 1;
  private static final int RESULT_FAILURE = -1;
  private static final int RESULT_OK = 0;
  private static final int SHARE_TO_QQ = 0;
  private static final int SHARE_TO_QZONE = 1;
  private static final int SHARE_TO_WECHAT = 2;
  private static final int SHARE_TO_WECHAT_MONMENT = 3;
  private static final String TAG = "QZoneSharePictureJsPlugin";
  public static final String TEMP_FILE_NAME_PREFIX = "tempfile_";
  static final Pattern pattern = Pattern.compile("@\\{uin:(\\d+),nick:(.+?)\\}");
  private String callback;
  WXShareHelper.WXShareListener wezoneWxShareListener = new QZoneSharePictureJsPlugin.9(this);
  IQzoneShareApi.WXShareListener wxShareListener = new QZoneSharePictureJsPlugin.8(this);
  
  /* Error */
  public static boolean appendFileContent(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 137	java/io/BufferedWriter
    //   7: dup
    //   8: new 139	java/io/OutputStreamWriter
    //   11: dup
    //   12: new 141	java/io/FileOutputStream
    //   15: dup
    //   16: aload_0
    //   17: iconst_1
    //   18: invokespecial 144	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   21: invokespecial 147	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   24: invokespecial 150	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   27: astore_0
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 153	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   33: ldc 155
    //   35: invokestatic 161	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   38: checkcast 155	com/tencent/qzonehub/api/IDataUtils
    //   41: aload_0
    //   42: invokeinterface 165 2 0
    //   47: pop
    //   48: iconst_1
    //   49: ireturn
    //   50: astore_1
    //   51: aload_0
    //   52: astore_2
    //   53: aload_1
    //   54: astore_0
    //   55: goto +44 -> 99
    //   58: astore_1
    //   59: goto +10 -> 69
    //   62: astore_0
    //   63: goto +36 -> 99
    //   66: astore_1
    //   67: aload_3
    //   68: astore_0
    //   69: aload_0
    //   70: astore_2
    //   71: ldc 46
    //   73: iconst_1
    //   74: aload_1
    //   75: iconst_0
    //   76: anewarray 167	java/lang/Object
    //   79: invokestatic 173	cooperation/qzone/util/QZLog:w	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   82: ldc 155
    //   84: invokestatic 161	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   87: checkcast 155	com/tencent/qzonehub/api/IDataUtils
    //   90: aload_0
    //   91: invokeinterface 165 2 0
    //   96: pop
    //   97: iconst_0
    //   98: ireturn
    //   99: ldc 155
    //   101: invokestatic 161	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   104: checkcast 155	com/tencent/qzonehub/api/IDataUtils
    //   107: aload_2
    //   108: invokeinterface 165 2 0
    //   113: pop
    //   114: aload_0
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramString1	String
    //   0	116	1	paramString2	String
    //   3	105	2	str	String
    //   1	67	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	33	50	finally
    //   28	33	58	java/lang/Exception
    //   4	28	62	finally
    //   71	82	62	finally
    //   4	28	66	java/lang/Exception
  }
  
  private void callJS(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("QZoneSharePictureJsPlugin", 1, "callback is null");
      return;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("retCode", paramInt);
      ((JSONObject)localObject).put("msg", paramString2);
      localObject = ((JSONObject)localObject).toString();
      if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null))
      {
        this.parentPlugin.mRuntime.a().callJs(paramString1, new String[] { localObject });
        paramString1 = new StringBuilder();
        paramString1.append("callJs ：retCode = ");
        paramString1.append(paramInt);
        paramString1.append(", msg = ");
        paramString1.append(paramString2);
        QLog.i("QZoneSharePictureJsPlugin", 1, paramString1.toString());
        return;
      }
    }
    catch (JSONException paramString1)
    {
      QLog.e("QZoneSharePictureJsPlugin", 1, paramString1.getMessage());
    }
  }
  
  private void callJS(String paramString1, int paramInt, String paramString2, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("QZoneSharePictureJsPlugin", 1, "callback is null");
      return;
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("retCode", paramInt);
      ((JSONObject)localObject).put("msg", paramString2);
      ((JSONObject)localObject).put("data", paramJSONObject);
      paramJSONObject = ((JSONObject)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("callJs ：callback＝");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", args length=");
      ((StringBuilder)localObject).append(paramJSONObject.length());
      QLog.i("QZoneSharePictureJsPlugin", 1, ((StringBuilder)localObject).toString());
      if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null))
      {
        this.parentPlugin.mRuntime.a().callJs(paramString1, new String[] { paramJSONObject });
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("callJs ：retCode = ");
        paramJSONObject.append(paramInt);
        paramJSONObject.append(", msg = ");
        paramJSONObject.append(paramString2);
        QLog.i("QZoneSharePictureJsPlugin", 1, paramJSONObject.toString());
        return;
      }
    }
    catch (OutOfMemoryError paramString2)
    {
      QLog.e("QZoneSharePictureJsPlugin", 1, "callJS OutOfMemoryError 内存不足", paramString2);
      if (QZLog.isDevelopLevel()) {
        ToastUtil.a().a(HardCodeUtil.a(2131909867));
      }
      try
      {
        paramString2 = new JSONObject();
        paramString2.put("retCode", -1);
        paramString2.put("msg", HardCodeUtil.a(2131909878));
        paramString2 = paramString2.toString();
        if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null))
        {
          this.parentPlugin.mRuntime.a().callJs(paramString1, new String[] { paramString2 });
          QLog.i("QZoneSharePictureJsPlugin", 1, "callJs ：retCode = -1 msg = 内存不足");
          return;
        }
      }
      catch (JSONException paramString1)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "JSONException", paramString1);
        return;
      }
    }
    catch (JSONException paramString1)
    {
      QLog.e("QZoneSharePictureJsPlugin", 1, "JSONException", paramString1);
    }
  }
  
  public static boolean checkIsValidTempFileName(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (paramString.length() > 50) {
      return false;
    }
    if (!paramString.startsWith("tempfile_")) {
      return false;
    }
    return Pattern.compile("[a-zA-Z0-9_]+").matcher(paramString).matches();
  }
  
  /* Error */
  public static byte[] compressToBytes(Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: new 307	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: sipush 8192
    //   7: invokespecial 310	java/io/ByteArrayOutputStream:<init>	(I)V
    //   10: astore_3
    //   11: aload_3
    //   12: astore_2
    //   13: aload_0
    //   14: invokevirtual 315	android/graphics/Bitmap:hasAlpha	()Z
    //   17: ifeq +18 -> 35
    //   20: aload_3
    //   21: astore_2
    //   22: aload_0
    //   23: getstatic 321	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   26: iload_1
    //   27: aload_3
    //   28: invokevirtual 325	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: goto +15 -> 47
    //   35: aload_3
    //   36: astore_2
    //   37: aload_0
    //   38: getstatic 328	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   41: iload_1
    //   42: aload_3
    //   43: invokevirtual 325	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   46: pop
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: invokevirtual 332	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   53: astore_0
    //   54: aload_3
    //   55: invokevirtual 335	java/io/ByteArrayOutputStream:flush	()V
    //   58: aload_3
    //   59: invokevirtual 338	java/io/ByteArrayOutputStream:close	()V
    //   62: aload_0
    //   63: areturn
    //   64: astore_2
    //   65: ldc 46
    //   67: iconst_1
    //   68: aload_2
    //   69: invokevirtual 339	java/lang/Exception:toString	()Ljava/lang/String;
    //   72: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_0
    //   76: areturn
    //   77: astore_0
    //   78: goto +80 -> 158
    //   81: astore_0
    //   82: goto +16 -> 98
    //   85: astore_0
    //   86: goto +37 -> 123
    //   89: astore_0
    //   90: aconst_null
    //   91: astore_2
    //   92: goto +66 -> 158
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: astore_2
    //   100: ldc 46
    //   102: iconst_1
    //   103: aload_0
    //   104: invokevirtual 340	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   107: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_3
    //   111: invokevirtual 335	java/io/ByteArrayOutputStream:flush	()V
    //   114: aload_3
    //   115: invokevirtual 338	java/io/ByteArrayOutputStream:close	()V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_3
    //   123: aload_3
    //   124: astore_2
    //   125: ldc 46
    //   127: iconst_1
    //   128: aload_0
    //   129: invokevirtual 339	java/lang/Exception:toString	()Ljava/lang/String;
    //   132: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_3
    //   136: invokevirtual 335	java/io/ByteArrayOutputStream:flush	()V
    //   139: aload_3
    //   140: invokevirtual 338	java/io/ByteArrayOutputStream:close	()V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_0
    //   146: ldc 46
    //   148: iconst_1
    //   149: aload_0
    //   150: invokevirtual 339	java/lang/Exception:toString	()Ljava/lang/String;
    //   153: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aconst_null
    //   157: areturn
    //   158: aload_2
    //   159: invokevirtual 335	java/io/ByteArrayOutputStream:flush	()V
    //   162: aload_2
    //   163: invokevirtual 338	java/io/ByteArrayOutputStream:close	()V
    //   166: goto +14 -> 180
    //   169: astore_2
    //   170: ldc 46
    //   172: iconst_1
    //   173: aload_2
    //   174: invokevirtual 339	java/lang/Exception:toString	()Ljava/lang/String;
    //   177: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload_0
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramBitmap	Bitmap
    //   0	182	1	paramInt	int
    //   12	37	2	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   64	5	2	localException1	Exception
    //   91	72	2	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   169	5	2	localException2	Exception
    //   10	130	3	localByteArrayOutputStream3	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   54	62	64	java/lang/Exception
    //   13	20	77	finally
    //   22	32	77	finally
    //   37	47	77	finally
    //   49	54	77	finally
    //   100	110	77	finally
    //   125	135	77	finally
    //   13	20	81	java/lang/OutOfMemoryError
    //   22	32	81	java/lang/OutOfMemoryError
    //   37	47	81	java/lang/OutOfMemoryError
    //   49	54	81	java/lang/OutOfMemoryError
    //   13	20	85	java/lang/Exception
    //   22	32	85	java/lang/Exception
    //   37	47	85	java/lang/Exception
    //   49	54	85	java/lang/Exception
    //   0	11	89	finally
    //   0	11	95	java/lang/OutOfMemoryError
    //   0	11	120	java/lang/Exception
    //   110	118	145	java/lang/Exception
    //   135	143	145	java/lang/Exception
    //   158	166	169	java/lang/Exception
  }
  
  public static byte[] compressToBytesForWX(String paramString)
  {
    Bitmap localBitmap = BitmapUtil.a(paramString, 120, 120, false);
    if (localBitmap == null) {
      return null;
    }
    paramString = compressToBytes(localBitmap, 90);
    double d = paramString.length;
    Double.isNaN(d);
    d /= 30720.0D;
    Object localObject;
    if (d > 1.0D)
    {
      paramString = new Matrix();
      float f = (float)(1.0D / Math.sqrt(d));
      paramString.postScale(f, f);
      localObject = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramString, true);
      paramString = compressToBytes((Bitmap)localObject, 90);
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("thumbBmp.size:");
        localStringBuilder.append(paramString.length / 1024);
        localStringBuilder.append(" thumbBmp.width:");
        localStringBuilder.append(((Bitmap)localObject).getWidth());
        localStringBuilder.append(" thumbBmp.height:");
        localStringBuilder.append(((Bitmap)localObject).getHeight());
        QLog.d("QZoneSharePictureJsPlugin", 4, localStringBuilder.toString());
      }
      ((Bitmap)localObject).recycle();
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bitmap.size:");
      ((StringBuilder)localObject).append(paramString.length / 1024);
      ((StringBuilder)localObject).append(" bitmap.width:");
      ((StringBuilder)localObject).append(localBitmap.getWidth());
      ((StringBuilder)localObject).append(" bitmap.height:");
      ((StringBuilder)localObject).append(localBitmap.getHeight());
      QLog.d("QZoneSharePictureJsPlugin", 4, ((StringBuilder)localObject).toString());
    }
    localBitmap.recycle();
    return paramString;
  }
  
  private String cutHeadIfNeeded(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = paramString;
    if (paramString.startsWith("data:image"))
    {
      int i = paramString.indexOf("base64,");
      str = paramString;
      if (i >= 0)
      {
        i += 7;
        str = paramString;
        if (i < paramString.length()) {
          str = paramString.substring(i);
        }
      }
    }
    return str;
  }
  
  private void doAppendTempFile(String paramString)
  {
    try
    {
      Object localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).optString("callback");
      if (TextUtils.isEmpty(paramString))
      {
        ToastUtil.a().a("callback is null");
        QLog.e("QZoneSharePictureJsPlugin", 1, "doAppendTempFile ,callback is null");
        return;
      }
      String str1 = ((JSONObject)localObject1).optString("path");
      if (TextUtils.isEmpty(str1))
      {
        callJS(paramString, -1, "path is empty");
        return;
      }
      if (!checkIsValidTempFileName(str1))
      {
        callJS(paramString, -1, "path is invalid");
        return;
      }
      localObject1 = ((JSONObject)localObject1).optString("data");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        callJS(paramString, -1, "data is empty");
        return;
      }
      String str2 = CacheManager.getWebviewOfflineFileCacheService().getPath(str1);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doAppendTempFile path=");
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append(",data len=");
      ((StringBuilder)localObject2).append(((String)localObject1).length());
      QLog.i("QZoneSharePictureJsPlugin", 1, ((StringBuilder)localObject2).toString());
      localObject2 = new File(str2);
      if (!((File)localObject2).exists())
      {
        callJS(paramString, -1, HardCodeUtil.a(2131909873));
        return;
      }
      if (!((File)localObject2).canWrite())
      {
        callJS(paramString, -1, HardCodeUtil.a(2131909875));
        return;
      }
      if (appendFileContent(str2, (String)localObject1)) {
        try
        {
          long l = ((File)localObject2).length();
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("path", str1);
          ((JSONObject)localObject1).put("len", l);
          callJS(paramString, 0, "", (JSONObject)localObject1);
          return;
        }
        catch (JSONException paramString)
        {
          QLog.e("QZoneSharePictureJsPlugin", 1, "JSONObject fail", paramString);
          return;
        }
      }
      callJS(paramString, -1, HardCodeUtil.a(2131909881));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QZoneSharePictureJsPlugin", 1, "JSONObject fail", paramString);
    }
  }
  
  private void doCreateTempFile(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("doCreateTempFile arg=");
    ((StringBuilder)localObject1).append(paramString);
    QLog.i("QZoneSharePictureJsPlugin", 1, ((StringBuilder)localObject1).toString());
    localObject1 = null;
    try
    {
      String str = new JSONObject(paramString).optString("callback");
      localObject1 = str;
      localObject2 = str;
      if (TextUtils.isEmpty(str))
      {
        localObject1 = str;
        ToastUtil.a().a("callback is null");
        localObject1 = str;
        localObject2 = new StringBuilder();
        localObject1 = str;
        ((StringBuilder)localObject2).append("doCreateTempFile arg=");
        localObject1 = str;
        ((StringBuilder)localObject2).append(paramString);
        localObject1 = str;
        ((StringBuilder)localObject2).append(",callback is null");
        localObject1 = str;
        QLog.e("QZoneSharePictureJsPlugin", 1, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("QZoneSharePictureJsPlugin", 1, "JSONObject fail", paramString);
      Object localObject2 = localObject1;
      paramString = CacheManager.getWebviewOfflineFileCacheService().getDir();
      if (TextUtils.isEmpty(paramString))
      {
        callJS((String)localObject2, -1, HardCodeUtil.a(2131909874));
        return;
      }
      try
      {
        localObject1 = new File(paramString);
        if ((!FileUtil.d(paramString)) && (!((File)localObject1).mkdirs()))
        {
          QLog.e("QZoneSharePictureJsPlugin", 1, DISK_FULL_MSG);
          callJS((String)localObject2, -1, DISK_FULL_MSG);
          return;
        }
        long l = Utils.a((File)localObject1);
        if (l < QzoneConfig.getInstance().getConfig("QzoneCover", "gif_cover_min_disk_size", 2097152))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("手机存储空间已满，请清理后重试。 spaceLen=");
          ((StringBuilder)localObject1).append(l);
          ((StringBuilder)localObject1).append(",dir=");
          ((StringBuilder)localObject1).append(paramString);
          QLog.e("QZoneSharePictureJsPlugin", 1, ((StringBuilder)localObject1).toString());
          callJS((String)localObject2, -1, DISK_FULL_MSG);
          return;
        }
        paramString = new StringBuilder();
        paramString.append("saxon spaceLen=");
        paramString.append(l);
        QLog.i("QZoneSharePictureJsPlugin", 1, paramString.toString());
      }
      catch (Exception paramString)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "检查临时目录失败", paramString);
      }
      int i = (int)(Math.random() * 1000000.0D % 10000.0D);
      paramString = new StringBuilder();
      paramString.append("tempfile_");
      paramString.append(System.currentTimeMillis());
      paramString.append("_");
      paramString.append(i);
      paramString = paramString.toString();
      localObject1 = CacheManager.getWebviewOfflineFileCacheService().getPath(paramString);
      try
      {
        if (new File((String)localObject1).createNewFile())
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("path", paramString);
          callJS((String)localObject2, 0, "", (JSONObject)localObject1);
          return;
        }
        callJS((String)localObject2, -1, HardCodeUtil.a(2131909895));
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "create file fail", paramString);
      }
    }
  }
  
  private void doDeleteTempFile(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("doDeleteTempFile arg=");
    ((StringBuilder)localObject1).append(paramString);
    QLog.i("QZoneSharePictureJsPlugin", 1, ((StringBuilder)localObject1).toString());
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject1).optString("callback");
        localObject1 = ((JSONObject)localObject1).optJSONArray("list");
        JSONObject localJSONObject = new JSONObject();
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).getString(i);
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              localJSONObject.put((String)localObject2, false);
              QLog.w("QZoneSharePictureJsPlugin", 1, "doDeleteTempFile fileName is empty");
              break label303;
            }
            if (!checkIsValidTempFileName((String)localObject2))
            {
              localJSONObject.put((String)localObject2, false);
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("doDeleteTempFile fileName is invalid, fileName=");
              ((StringBuilder)localObject3).append((String)localObject2);
              QLog.w("QZoneSharePictureJsPlugin", 1, ((StringBuilder)localObject3).toString());
              break label303;
            }
            Object localObject3 = CacheManager.getWebviewOfflineFileCacheService().getPath((String)localObject2);
            boolean bool = FileUtil.e((String)localObject3);
            localJSONObject.put((String)localObject2, bool);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("delete file ");
            ((StringBuilder)localObject2).append((String)localObject3);
            ((StringBuilder)localObject2).append(", ret=");
            ((StringBuilder)localObject2).append(bool);
            QZLog.i("QZoneSharePictureJsPlugin", ((StringBuilder)localObject2).toString());
            break label303;
          }
        }
        if (!TextUtils.isEmpty(paramString))
        {
          callJS(paramString, 0, "", localJSONObject);
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "JSONObject fail", paramString);
      }
      return;
      label303:
      i += 1;
    }
  }
  
  private void downloadGifSoAndGenerateGifImpl(String... paramVarArgs)
  {
    AlbumLibDownloaderUtil.getInstance().downloadGifEncoderSo(new QZoneSharePictureJsPlugin.10(this, paramVarArgs));
  }
  
  private void genGifCallback(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("total", paramInt2);
        localJSONObject.put("current", paramInt3);
        localJSONObject.put("base64Data", paramString3);
        localJSONObject.put("fileLength", paramInt4);
        callJS(paramString1, paramInt1, paramString2, localJSONObject);
        if (QLog.isDevelopLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("callback");
          paramString2.append(paramString1);
          paramString2.append(",total=");
          paramString2.append(paramInt2);
          paramString2.append(",current=");
          paramString2.append(paramInt3);
          paramString2.append(",fileLength=");
          paramString2.append(paramInt4);
          paramString2.append(",base64Data len=");
          paramString2.append(paramString3.length());
          QLog.i("QZoneSharePictureJsPlugin", 1, paramString2.toString());
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "genGifCallback fail.", paramString1);
      }
    }
  }
  
  private void handleGenerateGif(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    QLog.i("QZoneSharePictureJsPlugin", 1, "saxon handleGenerateGif start");
    if ((paramPluginRuntime != null) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
      paramVarArgs = paramVarArgs[0];
    }
    for (;;)
    {
      int m;
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs);
        paramVarArgs = ((JSONObject)localObject2).getJSONArray("images");
        if (paramVarArgs == null) {
          return;
        }
        i = ((JSONObject)localObject2).optInt("delay");
        if (i >= 0) {
          break label902;
        }
        i = 100;
        Object localObject1 = ((JSONObject)localObject2).optString("content");
        this.callback = ((JSONObject)localObject2).optString("callback");
        boolean bool2 = ((JSONObject)localObject2).optBoolean("needPublish", false);
        bool1 = ((JSONObject)localObject2).optBoolean("useSample", false);
        boolean bool4 = ((JSONObject)localObject2).optBoolean("usePath", false);
        boolean bool3 = ((JSONObject)localObject2).optBoolean("supportMultiPiecesCallback", false);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("QzoneWidgetAI.handleGenerateGif frameDelay is :");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(",jsonArrayImages len=");
        ((StringBuilder)localObject2).append(paramVarArgs.length());
        ((StringBuilder)localObject2).append(",content=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",usePath=");
        ((StringBuilder)localObject2).append(bool4);
        ((StringBuilder)localObject2).append(",supportMultiPiecesCallback=");
        ((StringBuilder)localObject2).append(bool3);
        QLog.i("QZoneSharePictureJsPlugin", 1, ((StringBuilder)localObject2).toString());
        Object localObject3 = new GifCoder();
        ((GifCoder)localObject3).setUseOrignalBitmap(false);
        ((GifCoder)localObject3).setEncoderDither(true);
        localObject2 = PhotoUtils.getCameraPath(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE), "IMG", ".gif");
        if (!new File((String)localObject2).getParentFile().exists()) {
          new File((String)localObject2).mkdirs();
        }
        long l1 = System.currentTimeMillis();
        if (bool1) {
          break label905;
        }
        bool1 = true;
        bool1 = ((GifCoder)localObject3).encodeGifFromBase64((String)localObject2, paramVarArgs, i, bool1, bool4);
        ((GifCoder)localObject3).closeEncoder();
        long l2 = System.currentTimeMillis();
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("encodeGif: duration=");
        paramVarArgs.append(l2 - l1);
        QLog.i("QZoneSharePictureJsPlugin", 4, paramVarArgs.toString());
        if (bool1) {
          break label911;
        }
        paramVarArgs = "gif合成失败";
        i = -1;
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("published", bool2);
        if (!bool2)
        {
          int n = QzoneConfig.getInstance().getConfig("QzoneCover", "gif_cover_callback_piece_size", 1048576);
          paramPluginRuntime = file2Base64(new File((String)localObject2));
          if (TextUtils.isEmpty(paramPluginRuntime))
          {
            callJS(this.callback, -2, "gif文件转base64失败", (JSONObject)localObject3);
            return;
          }
          if (!bool3)
          {
            QLog.i("QZoneSharePictureJsPlugin", 1, "saxon 不分片callback ");
            genGifCallback(this.callback, i, paramVarArgs, 1, 0, paramPluginRuntime, paramPluginRuntime.length());
            return;
          }
          if (paramPluginRuntime.length() <= n)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("saxon 不分片callback len=");
            ((StringBuilder)localObject1).append(paramPluginRuntime.length());
            QLog.i("QZoneSharePictureJsPlugin", 1, ((StringBuilder)localObject1).toString());
            genGifCallback(this.callback, i, paramVarArgs, 1, 0, paramPluginRuntime, paramPluginRuntime.length());
            return;
          }
          k = paramPluginRuntime.length() / n;
          if (paramPluginRuntime.length() % n != 0) {
            break label920;
          }
          j = 0;
          j = k + j;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("saxon 分片callback pcount＝");
          ((StringBuilder)localObject1).append(j);
          ((StringBuilder)localObject1).append(",filelen=");
          ((StringBuilder)localObject1).append(paramPluginRuntime.length());
          QLog.i("QZoneSharePictureJsPlugin", 1, ((StringBuilder)localObject1).toString());
          k = 0;
          m = j - 1;
          if (k < m)
          {
            localObject1 = this.callback;
            m = k + 1;
            genGifCallback((String)localObject1, i, paramVarArgs, j, k, paramPluginRuntime.substring(k * n, m * n), paramPluginRuntime.length());
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("saxon 分片callback ,i=");
            ((StringBuilder)localObject1).append(k);
            QLog.i("QZoneSharePictureJsPlugin", 1, ((StringBuilder)localObject1).toString());
            try
            {
              Thread.sleep(200L);
            }
            catch (InterruptedException localInterruptedException)
            {
              QLog.e("QZoneSharePictureJsPlugin", 1, "handleGenerateGif Thread.sleep(200) fail.", localInterruptedException);
            }
          }
          genGifCallback(this.callback, i, paramVarArgs, j, m, paramPluginRuntime.substring(n * m), paramPluginRuntime.length());
          paramPluginRuntime = new StringBuilder();
          paramPluginRuntime.append("saxon 分片callback last piece,i=");
          paramPluginRuntime.append(m);
          QLog.i("QZoneSharePictureJsPlugin", 1, paramPluginRuntime.toString());
          return;
        }
        callJS(this.callback, i, paramVarArgs, (JSONObject)localObject3);
        paramVarArgs = QZoneHelper.UserInfo.getInstance();
        QZoneHelper.forwardToPublishMood(paramPluginRuntime.d(), paramVarArgs, (String)localObject2, HardCodeUtil.a(2131909889), localInterruptedException, -1);
        return;
      }
      catch (Throwable paramPluginRuntime)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "handleGenerateGif fail, compressGIFTask exception.", paramPluginRuntime);
        return;
      }
      QLog.d("QZoneSharePictureJsPlugin", 1, "QzoneWidgetAI.handleGenerateGif args is empty");
      return;
      label902:
      continue;
      label905:
      boolean bool1 = false;
      continue;
      label911:
      paramVarArgs = "success";
      int i = 0;
      continue;
      label920:
      int j = 1;
      continue;
      int k = m;
    }
  }
  
  private void handleSharePicture(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((this.parentPlugin != null) && (paramPluginRuntime != null) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        String str = paramVarArgs.optString("type");
        Object localObject2 = paramVarArgs.optString("base64");
        this.callback = paramVarArgs.optString("callback");
        Object localObject1 = paramVarArgs.optString("shareFrom");
        localObject2 = cutHeadIfNeeded((String)localObject2);
        try
        {
          localObject2 = Base64.decode(((String)localObject2).getBytes(), 0);
          localObject2 = saveByteBufferToLocalFile((byte[])localObject2);
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            QLog.i("QZoneSharePictureJsPlugin", 1, "saveByteBufferToLocalFile catch exception");
            makeText(HardCodeUtil.a(2131909887));
            return;
          }
          Object localObject3;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("the filePath is ");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d("QZoneSharePictureJsPlugin", 1, ((StringBuilder)localObject3).toString());
          }
          if ((!TextUtils.isEmpty(str)) && (paramPluginRuntime != null) && (paramPluginRuntime.d() != null))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("share type is ");
            ((StringBuilder)localObject3).append(str);
            QLog.i("QZoneSharePictureJsPlugin", 1, ((StringBuilder)localObject3).toString());
            int i;
            try
            {
              i = Integer.parseInt(str);
            }
            catch (NumberFormatException localNumberFormatException)
            {
              QLog.w("QZoneSharePictureJsPlugin", 1, "parse string to integer catch a numberformatexcetion", localNumberFormatException);
              i = 0;
            }
            if (i != 0)
            {
              if (i != 1)
              {
                if (i != 2)
                {
                  if (i == 3) {
                    if (((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).isWXinstalled())
                    {
                      if (TextUtils.equals((CharSequence)localObject1, "wezone"))
                      {
                        WXShareHelper.a().a(this.wezoneWxShareListener);
                        WXShareHelper.a().a((String)localObject2, null, 1);
                      }
                      else
                      {
                        ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).addObserver(this.wxShareListener);
                        ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplicationImpl.getContext(), (String)localObject2, null, 1);
                      }
                    }
                    else if (paramPluginRuntime.a() != null) {
                      paramPluginRuntime.a().post(new QZoneSharePictureJsPlugin.6(this, paramPluginRuntime));
                    }
                  }
                }
                else if (((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).isWXinstalled())
                {
                  paramVarArgs = compressToBytesForWX((String)localObject2);
                  if (TextUtils.equals((CharSequence)localObject1, "wezone"))
                  {
                    WXShareHelper.a().a(this.wezoneWxShareListener);
                    WXShareHelper.a().a((String)localObject2, paramVarArgs, 0);
                  }
                  else
                  {
                    ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).addObserver(this.wxShareListener);
                    ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplicationImpl.getContext(), (String)localObject2, paramVarArgs, 0);
                  }
                }
                else if (paramPluginRuntime.a() != null)
                {
                  paramPluginRuntime.a().post(new QZoneSharePictureJsPlugin.5(this, paramPluginRuntime));
                }
              }
              else {
                writeMood(paramVarArgs, (String)localObject2, paramPluginRuntime);
              }
            }
            else
            {
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("forward_type", 1);
              ((Bundle)localObject1).putString("forward_filepath", (String)localObject2);
              ((Bundle)localObject1).putString("forward_thumb", (String)localObject2);
              ((Bundle)localObject1).putString("forward_extra", (String)localObject2);
              ((Bundle)localObject1).putBoolean("key_flag_from_plugin", true);
              ((Bundle)localObject1).putBoolean("forward_photo_shortvideo_is_edited", true);
              Intent localIntent = new Intent();
              localIntent.putExtras((Bundle)localObject1);
              i = QZoneHelperProxyImpl.generateRequestCode(this.parentPlugin, paramPluginRuntime, 21);
              localObject1 = ForwardRecentActivity.class;
              localObject2 = paramVarArgs.optString("extJson");
              boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
              paramVarArgs = (String[])localObject1;
              if (!bool) {
                try
                {
                  paramVarArgs = new JSONObject((String)localObject2);
                  int j = paramVarArgs.optInt("targetUinType");
                  localObject2 = paramVarArgs.optString("targetUin");
                  localObject3 = paramVarArgs.optString("targetNickname");
                  paramVarArgs = (String[])localObject1;
                  if (!TextUtils.isEmpty((CharSequence)localObject2))
                  {
                    localIntent.putExtra("uinType", j);
                    localIntent.putExtra("toUin", (String)localObject2);
                    localIntent.putExtra("nickName", (String)localObject3);
                    paramVarArgs = DirectForwardActivity.class;
                  }
                }
                catch (JSONException paramVarArgs)
                {
                  QLog.e("QZoneSharePictureJsPlugin", 1, "share to qq: parse extJson error!", paramVarArgs);
                  paramVarArgs = (String[])localObject1;
                }
              }
              ForwardBaseOption.a(paramPluginRuntime.d(), localIntent, paramVarArgs, i, -1, "");
            }
          }
          paramPluginRuntime = paramPluginRuntime.a(paramPluginRuntime.d());
          if ((paramPluginRuntime != null) && ((paramPluginRuntime instanceof WebUiUtils.WebShareInterface)))
          {
            paramPluginRuntime = ((Share)((WebUiUtils.WebShareInterface)paramPluginRuntime).getShare()).u();
            if ((paramPluginRuntime != null) && (paramPluginRuntime.isShowing())) {
              paramPluginRuntime.dismiss();
            }
          }
          QLog.i("QZoneSharePictureJsPlugin", 1, "WebView share picture call jsbridge successful!");
          return;
        }
        catch (Exception paramPluginRuntime)
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("Base64.decode Exception: ");
          paramVarArgs.append(paramPluginRuntime.toString());
          QLog.w("QZoneSharePictureJsPlugin", 1, paramVarArgs.toString());
          makeText(HardCodeUtil.a(2131909866));
          return;
        }
        if (paramPluginRuntime != null) {
          break label900;
        }
      }
      catch (Exception paramPluginRuntime)
      {
        QLog.w("QZoneSharePictureJsPlugin", 1, "handleSharePicture catch an exception in disPatchMethod", paramPluginRuntime);
        return;
      }
    }
    else
    {
      QLog.i("QZoneSharePictureJsPlugin", 1, "runtime is null");
      return;
    }
    label900:
    if (paramVarArgs == null)
    {
      QLog.i("QZoneSharePictureJsPlugin", 1, "args is null");
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length <= 0)) {
      QLog.i("QZoneSharePictureJsPlugin", 1, "args.length = 0");
    }
  }
  
  private void makeText(String paramString)
  {
    if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null)) {
      QQToast.makeText(this.parentPlugin.mRuntime.a().getContext(), paramString, 0).show();
    }
  }
  
  private void onShareWXResp(BaseResp paramBaseResp)
  {
    int i = paramBaseResp.errCode;
    if (i == 0)
    {
      i = 0;
      paramBaseResp = HardCodeUtil.a(2131909897);
      makeText(paramBaseResp);
    }
    else if (i == -2)
    {
      paramBaseResp = HardCodeUtil.a(2131909888);
      makeText(paramBaseResp);
      i = 1;
    }
    else
    {
      paramBaseResp = HardCodeUtil.a(2131909885);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("wx share fail:");
      localStringBuilder.append(i);
      QLog.e("QZoneSharePictureJsPlugin", 1, localStringBuilder.toString());
    }
    callJS(this.callback, i, paramBaseResp);
  }
  
  /* Error */
  private String saveByteBufferToLocalFile(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 233	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: getstatic 974	com/tencent/qzonehub/api/IQzoneShareApi:PHOTO_PATH	Ljava/lang/String;
    //   12: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_3
    //   17: invokestatic 534	java/lang/System:currentTimeMillis	()J
    //   20: invokestatic 978	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   23: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_3
    //   28: ldc_w 980
    //   31: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore_3
    //   40: aconst_null
    //   41: astore 4
    //   43: aconst_null
    //   44: astore 6
    //   46: iconst_1
    //   47: istore_2
    //   48: new 449	java/io/File
    //   51: dup
    //   52: getstatic 974	com/tencent/qzonehub/api/IQzoneShareApi:PHOTO_PATH	Ljava/lang/String;
    //   55: invokespecial 450	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 5
    //   60: aload 5
    //   62: invokevirtual 453	java/io/File:exists	()Z
    //   65: ifne +9 -> 74
    //   68: aload 5
    //   70: invokevirtual 490	java/io/File:mkdirs	()Z
    //   73: pop
    //   74: new 449	java/io/File
    //   77: dup
    //   78: aload_3
    //   79: invokespecial 450	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: astore_3
    //   83: aload_3
    //   84: invokevirtual 453	java/io/File:exists	()Z
    //   87: ifne +8 -> 95
    //   90: aload_3
    //   91: invokevirtual 539	java/io/File:createNewFile	()Z
    //   94: pop
    //   95: new 141	java/io/FileOutputStream
    //   98: dup
    //   99: aload_3
    //   100: invokespecial 983	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   103: astore 5
    //   105: aload 5
    //   107: astore 4
    //   109: aload 5
    //   111: aload_1
    //   112: invokevirtual 986	java/io/FileOutputStream:write	([B)V
    //   115: aload 5
    //   117: astore 4
    //   119: aload 5
    //   121: invokevirtual 987	java/io/FileOutputStream:flush	()V
    //   124: aload 5
    //   126: invokevirtual 988	java/io/FileOutputStream:close	()V
    //   129: goto +171 -> 300
    //   132: astore_1
    //   133: new 233	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   140: astore 4
    //   142: aload 4
    //   144: ldc_w 990
    //   147: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 4
    //   153: aload_1
    //   154: invokevirtual 993	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: ldc 46
    //   160: iconst_1
    //   161: aload 4
    //   163: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: goto +131 -> 300
    //   172: astore 4
    //   174: aload 5
    //   176: astore_1
    //   177: aload 4
    //   179: astore 5
    //   181: goto +20 -> 201
    //   184: astore 5
    //   186: aconst_null
    //   187: astore_1
    //   188: goto +13 -> 201
    //   191: astore_1
    //   192: goto +123 -> 315
    //   195: astore 5
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_1
    //   200: astore_3
    //   201: aload_1
    //   202: astore 4
    //   204: new 233	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   211: astore 7
    //   213: aload_1
    //   214: astore 4
    //   216: aload 7
    //   218: ldc_w 995
    //   221: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_1
    //   226: astore 4
    //   228: aload 7
    //   230: aload 5
    //   232: invokevirtual 993	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_1
    //   237: astore 4
    //   239: ldc 46
    //   241: iconst_1
    //   242: aload 7
    //   244: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload_1
    //   251: ifnull +47 -> 298
    //   254: aload_1
    //   255: invokevirtual 988	java/io/FileOutputStream:close	()V
    //   258: goto +40 -> 298
    //   261: astore_1
    //   262: new 233	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   269: astore 4
    //   271: aload 4
    //   273: ldc_w 990
    //   276: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 4
    //   282: aload_1
    //   283: invokevirtual 993	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: ldc 46
    //   289: iconst_1
    //   290: aload 4
    //   292: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: iconst_0
    //   299: istore_2
    //   300: aload 6
    //   302: astore_1
    //   303: iload_2
    //   304: ifeq +8 -> 312
    //   307: aload_3
    //   308: invokevirtual 998	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   311: astore_1
    //   312: aload_1
    //   313: areturn
    //   314: astore_1
    //   315: aload 4
    //   317: ifnull +48 -> 365
    //   320: aload 4
    //   322: invokevirtual 988	java/io/FileOutputStream:close	()V
    //   325: goto +40 -> 365
    //   328: astore_3
    //   329: new 233	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   336: astore 4
    //   338: aload 4
    //   340: ldc_w 990
    //   343: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 4
    //   349: aload_3
    //   350: invokevirtual 993	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: ldc 46
    //   356: iconst_1
    //   357: aload 4
    //   359: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: aload_1
    //   366: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	QZoneSharePictureJsPlugin
    //   0	367	1	paramArrayOfByte	byte[]
    //   47	257	2	i	int
    //   7	301	3	localObject1	Object
    //   328	22	3	localException	Exception
    //   41	121	4	localObject2	Object
    //   172	6	4	localIOException1	java.io.IOException
    //   202	156	4	localObject3	Object
    //   58	122	5	localObject4	Object
    //   184	1	5	localIOException2	java.io.IOException
    //   195	36	5	localIOException3	java.io.IOException
    //   44	257	6	localObject5	Object
    //   211	32	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   124	129	132	java/lang/Exception
    //   109	115	172	java/io/IOException
    //   119	124	172	java/io/IOException
    //   83	95	184	java/io/IOException
    //   95	105	184	java/io/IOException
    //   48	74	191	finally
    //   74	83	191	finally
    //   83	95	191	finally
    //   95	105	191	finally
    //   48	74	195	java/io/IOException
    //   74	83	195	java/io/IOException
    //   254	258	261	java/lang/Exception
    //   109	115	314	finally
    //   119	124	314	finally
    //   204	213	314	finally
    //   216	225	314	finally
    //   228	236	314	finally
    //   239	250	314	finally
    //   320	325	328	java/lang/Exception
  }
  
  private void showToast(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    new BaseHandler(Looper.getMainLooper()).post(new QZoneSharePictureJsPlugin.11(this, paramInt, paramString));
  }
  
  private void writeMood(JSONObject paramJSONObject, String paramString, WebViewPlugin.PluginRuntime paramPluginRuntime)
  {
    ThreadManager.getSubThreadHandler().post(new QZoneSharePictureJsPlugin.7(this, paramJSONObject, paramString, paramPluginRuntime));
  }
  
  /* Error */
  String file2Base64(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 1035	java/io/BufferedInputStream
    //   6: dup
    //   7: new 1037	java/io/FileInputStream
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 1038	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: invokespecial 1041	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: invokevirtual 1044	java/io/BufferedInputStream:available	()I
    //   25: newarray byte
    //   27: astore_3
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: aload_3
    //   32: invokevirtual 1048	java/io/BufferedInputStream:read	([B)I
    //   35: pop
    //   36: aload_2
    //   37: astore_1
    //   38: aload_3
    //   39: iconst_0
    //   40: invokestatic 1052	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   43: astore_3
    //   44: aload_3
    //   45: astore_1
    //   46: aload_2
    //   47: invokevirtual 1053	java/io/BufferedInputStream:close	()V
    //   50: aload_3
    //   51: areturn
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual 1056	java/io/IOException:printStackTrace	()V
    //   57: aload_1
    //   58: areturn
    //   59: astore_3
    //   60: goto +20 -> 80
    //   63: astore_3
    //   64: goto +44 -> 108
    //   67: astore_3
    //   68: goto +68 -> 136
    //   71: astore_1
    //   72: aconst_null
    //   73: astore_2
    //   74: goto +92 -> 166
    //   77: astore_3
    //   78: aconst_null
    //   79: astore_2
    //   80: aload_2
    //   81: astore_1
    //   82: ldc 46
    //   84: iconst_1
    //   85: ldc_w 470
    //   88: aload_3
    //   89: invokestatic 1058	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload_2
    //   93: ifnull +66 -> 159
    //   96: aload 4
    //   98: astore_1
    //   99: aload_2
    //   100: invokevirtual 1053	java/io/BufferedInputStream:close	()V
    //   103: aconst_null
    //   104: areturn
    //   105: astore_3
    //   106: aconst_null
    //   107: astore_2
    //   108: aload_2
    //   109: astore_1
    //   110: ldc 46
    //   112: iconst_1
    //   113: ldc_w 470
    //   116: aload_3
    //   117: invokestatic 1058	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload_2
    //   121: ifnull +38 -> 159
    //   124: aload 4
    //   126: astore_1
    //   127: aload_2
    //   128: invokevirtual 1053	java/io/BufferedInputStream:close	()V
    //   131: aconst_null
    //   132: areturn
    //   133: astore_3
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_2
    //   137: astore_1
    //   138: ldc 46
    //   140: iconst_1
    //   141: ldc_w 470
    //   144: aload_3
    //   145: invokestatic 1058	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload_2
    //   149: ifnull +10 -> 159
    //   152: aload 4
    //   154: astore_1
    //   155: aload_2
    //   156: invokevirtual 1053	java/io/BufferedInputStream:close	()V
    //   159: aconst_null
    //   160: areturn
    //   161: astore_3
    //   162: aload_1
    //   163: astore_2
    //   164: aload_3
    //   165: astore_1
    //   166: aload_2
    //   167: ifnull +15 -> 182
    //   170: aload_2
    //   171: invokevirtual 1053	java/io/BufferedInputStream:close	()V
    //   174: goto +8 -> 182
    //   177: astore_2
    //   178: aload_2
    //   179: invokevirtual 1056	java/io/IOException:printStackTrace	()V
    //   182: aload_1
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	QZoneSharePictureJsPlugin
    //   0	184	1	paramFile	File
    //   18	29	2	localBufferedInputStream	java.io.BufferedInputStream
    //   52	2	2	localIOException1	java.io.IOException
    //   73	98	2	localFile	File
    //   177	2	2	localIOException2	java.io.IOException
    //   27	24	3	localObject1	Object
    //   59	1	3	localOutOfMemoryError1	OutOfMemoryError
    //   63	1	3	localIOException3	java.io.IOException
    //   67	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   77	12	3	localOutOfMemoryError2	OutOfMemoryError
    //   105	12	3	localIOException4	java.io.IOException
    //   133	12	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   161	4	3	localObject2	Object
    //   1	152	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   46	50	52	java/io/IOException
    //   99	103	52	java/io/IOException
    //   127	131	52	java/io/IOException
    //   155	159	52	java/io/IOException
    //   21	28	59	java/lang/OutOfMemoryError
    //   30	36	59	java/lang/OutOfMemoryError
    //   38	44	59	java/lang/OutOfMemoryError
    //   21	28	63	java/io/IOException
    //   30	36	63	java/io/IOException
    //   38	44	63	java/io/IOException
    //   21	28	67	java/io/FileNotFoundException
    //   30	36	67	java/io/FileNotFoundException
    //   38	44	67	java/io/FileNotFoundException
    //   3	19	71	finally
    //   3	19	77	java/lang/OutOfMemoryError
    //   3	19	105	java/io/IOException
    //   3	19	133	java/io/FileNotFoundException
    //   21	28	161	finally
    //   30	36	161	finally
    //   38	44	161	finally
    //   82	92	161	finally
    //   110	120	161	finally
    //   138	148	161	finally
    //   170	174	177	java/io/IOException
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("Qzone")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if ("sharePicture".equalsIgnoreCase(paramString3))
      {
        handleSharePicture(this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if ("generateGif".equalsIgnoreCase(paramString3))
      {
        ThreadManager.executeOnFileThread(new QZoneSharePictureJsPlugin.1(this, paramVarArgs));
        return true;
      }
      if ("createTempFile".equalsIgnoreCase(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
        {
          ThreadManager.executeOnFileThread(new QZoneSharePictureJsPlugin.2(this, paramVarArgs));
          return true;
        }
        QLog.e("QZoneSharePictureJsPlugin", 1, "args invalid");
        return true;
      }
      if ("appendTempFile".equalsIgnoreCase(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
        {
          ThreadManager.executeOnFileThread(new QZoneSharePictureJsPlugin.3(this, paramVarArgs));
          return true;
        }
        QLog.e("QZoneSharePictureJsPlugin", 1, "args invalid");
        return true;
      }
      if ("deleteTempFile".equalsIgnoreCase(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
        {
          ThreadManager.executeOnFileThread(new QZoneSharePictureJsPlugin.4(this, paramVarArgs));
          return true;
        }
        QLog.e("QZoneSharePictureJsPlugin", 1, "args invalid");
        return true;
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if ((paramByte != 5) && (paramByte != 21)) {
      return;
    }
    if (paramInt == -1)
    {
      paramInt = 0;
      paramIntent = HardCodeUtil.a(2131909902);
    }
    else
    {
      paramInt = 1;
      paramIntent = HardCodeUtil.a(2131909870);
    }
    callJS(this.callback, paramInt, paramIntent);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.wxShareListener != null) {
      ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).removeObserver(this.wxShareListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin
 * JD-Core Version:    0.7.0.1
 */