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
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.share.WXShareFromQZHelper;
import cooperation.qzone.share.WXShareFromQZHelper.WXShareListener;
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
  private static final String DISK_FULL_MSG = HardCodeUtil.a(2131712301);
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
  WXShareFromQZHelper.WXShareListener wxShareListener = new QZoneSharePictureJsPlugin.8(this);
  
  /* Error */
  public static boolean appendFileContent(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 137	java/io/BufferedWriter
    //   5: dup
    //   6: new 139	java/io/OutputStreamWriter
    //   9: dup
    //   10: new 141	java/io/FileOutputStream
    //   13: dup
    //   14: aload_0
    //   15: iconst_1
    //   16: invokespecial 144	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   19: invokespecial 147	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   22: invokespecial 150	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   25: astore_0
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 153	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   31: ldc 155
    //   33: invokestatic 161	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   36: checkcast 155	com/tencent/qzonehub/api/IDataUtils
    //   39: aload_0
    //   40: invokeinterface 165 2 0
    //   45: pop
    //   46: iconst_1
    //   47: ireturn
    //   48: astore_1
    //   49: aconst_null
    //   50: astore_0
    //   51: ldc 46
    //   53: iconst_1
    //   54: aload_1
    //   55: iconst_0
    //   56: anewarray 167	java/lang/Object
    //   59: invokestatic 173	cooperation/qzone/util/QZLog:w	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   62: ldc 155
    //   64: invokestatic 161	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   67: checkcast 155	com/tencent/qzonehub/api/IDataUtils
    //   70: aload_0
    //   71: invokeinterface 165 2 0
    //   76: pop
    //   77: iconst_0
    //   78: ireturn
    //   79: astore_0
    //   80: aload_2
    //   81: astore_1
    //   82: ldc 155
    //   84: invokestatic 161	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   87: checkcast 155	com/tencent/qzonehub/api/IDataUtils
    //   90: aload_1
    //   91: invokeinterface 165 2 0
    //   96: pop
    //   97: aload_0
    //   98: athrow
    //   99: astore_1
    //   100: aload_0
    //   101: astore_2
    //   102: aload_1
    //   103: astore_0
    //   104: aload_2
    //   105: astore_1
    //   106: goto -24 -> 82
    //   109: astore_2
    //   110: aload_0
    //   111: astore_1
    //   112: aload_2
    //   113: astore_0
    //   114: goto -32 -> 82
    //   117: astore_1
    //   118: goto -67 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramString1	String
    //   0	121	1	paramString2	String
    //   1	104	2	str	String
    //   109	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	48	java/lang/Exception
    //   2	26	79	finally
    //   26	31	99	finally
    //   51	62	109	finally
    //   26	31	117	java/lang/Exception
  }
  
  private void callJS(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("QZoneSharePictureJsPlugin", 1, "callback is null");
    }
    for (;;)
    {
      return;
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("retCode", paramInt);
        ((JSONObject)localObject).put("msg", paramString2);
        localObject = ((JSONObject)localObject).toString();
        if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null))
        {
          this.parentPlugin.mRuntime.a().callJs(paramString1, new String[] { localObject });
          QLog.i("QZoneSharePictureJsPlugin", 1, "callJs ：retCode = " + paramInt + ", msg = " + paramString2);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, paramString1.getMessage());
      }
    }
  }
  
  private void callJS(String paramString1, int paramInt, String paramString2, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("QZoneSharePictureJsPlugin", 1, "callback is null");
    }
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("retCode", paramInt);
        localJSONObject.put("msg", paramString2);
        localJSONObject.put("data", paramJSONObject);
        paramJSONObject = localJSONObject.toString();
        QLog.i("QZoneSharePictureJsPlugin", 1, "callJs ：callback＝" + paramString1 + ", args length=" + paramJSONObject.length());
        if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null))
        {
          this.parentPlugin.mRuntime.a().callJs(paramString1, new String[] { paramJSONObject });
          QLog.i("QZoneSharePictureJsPlugin", 1, "callJs ：retCode = " + paramInt + ", msg = " + paramString2);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "JSONException", paramString1);
        return;
      }
      catch (OutOfMemoryError paramString2)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "callJS OutOfMemoryError 内存不足", paramString2);
        if (QZLog.isDevelopLevel()) {
          ToastUtil.a().a(HardCodeUtil.a(2131712291));
        }
        try
        {
          paramString2 = new JSONObject();
          paramString2.put("retCode", -1);
          paramString2.put("msg", HardCodeUtil.a(2131712303));
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
        }
      }
    }
  }
  
  public static boolean checkIsValidTempFileName(String paramString)
  {
    if (paramString == null) {}
    while ((paramString.length() > 50) || (!paramString.startsWith("tempfile_"))) {
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
    //   17: ifeq +32 -> 49
    //   20: aload_3
    //   21: astore_2
    //   22: aload_0
    //   23: getstatic 321	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   26: iload_1
    //   27: aload_3
    //   28: invokevirtual 325	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_3
    //   33: astore_2
    //   34: aload_3
    //   35: invokevirtual 329	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: astore_0
    //   39: aload_3
    //   40: invokevirtual 332	java/io/ByteArrayOutputStream:flush	()V
    //   43: aload_3
    //   44: invokevirtual 335	java/io/ByteArrayOutputStream:close	()V
    //   47: aload_0
    //   48: areturn
    //   49: aload_3
    //   50: astore_2
    //   51: aload_0
    //   52: getstatic 338	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   55: iload_1
    //   56: aload_3
    //   57: invokevirtual 325	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   60: pop
    //   61: goto -29 -> 32
    //   64: astore_0
    //   65: aload_3
    //   66: astore_2
    //   67: ldc 46
    //   69: iconst_1
    //   70: aload_0
    //   71: invokevirtual 339	java/lang/Exception:toString	()Ljava/lang/String;
    //   74: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_3
    //   78: invokevirtual 332	java/io/ByteArrayOutputStream:flush	()V
    //   81: aload_3
    //   82: invokevirtual 335	java/io/ByteArrayOutputStream:close	()V
    //   85: aconst_null
    //   86: areturn
    //   87: astore_0
    //   88: ldc 46
    //   90: iconst_1
    //   91: aload_0
    //   92: invokevirtual 339	java/lang/Exception:toString	()Ljava/lang/String;
    //   95: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_2
    //   101: ldc 46
    //   103: iconst_1
    //   104: aload_2
    //   105: invokevirtual 339	java/lang/Exception:toString	()Ljava/lang/String;
    //   108: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_0
    //   112: areturn
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_3
    //   116: aload_3
    //   117: astore_2
    //   118: ldc 46
    //   120: iconst_1
    //   121: aload_0
    //   122: invokevirtual 340	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   125: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload_3
    //   129: invokevirtual 332	java/io/ByteArrayOutputStream:flush	()V
    //   132: aload_3
    //   133: invokevirtual 335	java/io/ByteArrayOutputStream:close	()V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_0
    //   139: ldc 46
    //   141: iconst_1
    //   142: aload_0
    //   143: invokevirtual 339	java/lang/Exception:toString	()Ljava/lang/String;
    //   146: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aconst_null
    //   150: areturn
    //   151: astore_0
    //   152: aconst_null
    //   153: astore_2
    //   154: aload_2
    //   155: invokevirtual 332	java/io/ByteArrayOutputStream:flush	()V
    //   158: aload_2
    //   159: invokevirtual 335	java/io/ByteArrayOutputStream:close	()V
    //   162: aload_0
    //   163: athrow
    //   164: astore_2
    //   165: ldc 46
    //   167: iconst_1
    //   168: aload_2
    //   169: invokevirtual 339	java/lang/Exception:toString	()Ljava/lang/String;
    //   172: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: goto -13 -> 162
    //   178: astore_0
    //   179: goto -25 -> 154
    //   182: astore_0
    //   183: goto -67 -> 116
    //   186: astore_0
    //   187: aconst_null
    //   188: astore_3
    //   189: goto -124 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramBitmap	Bitmap
    //   0	192	1	paramInt	int
    //   12	55	2	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   100	5	2	localException1	Exception
    //   117	42	2	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   164	5	2	localException2	Exception
    //   10	179	3	localByteArrayOutputStream3	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   13	20	64	java/lang/Exception
    //   22	32	64	java/lang/Exception
    //   34	39	64	java/lang/Exception
    //   51	61	64	java/lang/Exception
    //   77	85	87	java/lang/Exception
    //   39	47	100	java/lang/Exception
    //   0	11	113	java/lang/OutOfMemoryError
    //   128	136	138	java/lang/Exception
    //   0	11	151	finally
    //   154	162	164	java/lang/Exception
    //   13	20	178	finally
    //   22	32	178	finally
    //   34	39	178	finally
    //   51	61	178	finally
    //   67	77	178	finally
    //   118	128	178	finally
    //   13	20	182	java/lang/OutOfMemoryError
    //   22	32	182	java/lang/OutOfMemoryError
    //   34	39	182	java/lang/OutOfMemoryError
    //   51	61	182	java/lang/OutOfMemoryError
    //   0	11	186	java/lang/Exception
  }
  
  public static byte[] compressToBytesForWX(String paramString)
  {
    Bitmap localBitmap1 = BitmapUtil.a(paramString, 120, 120, false);
    if (localBitmap1 == null) {
      return null;
    }
    paramString = compressToBytes(localBitmap1, 90);
    double d = paramString.length / 30720.0D;
    if (d > 1.0D)
    {
      paramString = new Matrix();
      float f = (float)(1.0D / Math.sqrt(d));
      paramString.postScale(f, f);
      Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, localBitmap1.getWidth(), localBitmap1.getHeight(), paramString, true);
      paramString = compressToBytes(localBitmap2, 90);
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneSharePictureJsPlugin", 4, "thumbBmp.size:" + paramString.length / 1024 + " thumbBmp.width:" + localBitmap2.getWidth() + " thumbBmp.height:" + localBitmap2.getHeight());
      }
      localBitmap2.recycle();
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneSharePictureJsPlugin", 4, "bitmap.size:" + paramString.length / 1024 + " bitmap.width:" + localBitmap1.getWidth() + " bitmap.height:" + localBitmap1.getHeight());
      }
      localBitmap1.recycle();
      return paramString;
    }
  }
  
  private String cutHeadIfNeeded(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    int i;
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString;
        } while (!paramString.startsWith("data:image"));
        i = paramString.indexOf("base64,");
        str = paramString;
      } while (i < 0);
      str = paramString;
    } while ("base64,".length() + i >= paramString.length());
    return paramString.substring("base64,".length() + i);
  }
  
  private void doAppendTempFile(String paramString)
  {
    String str1;
    try
    {
      localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("callback");
      if (TextUtils.isEmpty(paramString))
      {
        ToastUtil.a().a("callback is null");
        QLog.e("QZoneSharePictureJsPlugin", 1, "doAppendTempFile ,callback is null");
        return;
      }
      str1 = ((JSONObject)localObject).optString("path");
      if (TextUtils.isEmpty(str1))
      {
        callJS(paramString, -1, "path is empty");
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("QZoneSharePictureJsPlugin", 1, "JSONObject fail", paramString);
      return;
    }
    if (!checkIsValidTempFileName(str1))
    {
      callJS(paramString, -1, "path is invalid");
      return;
    }
    Object localObject = ((JSONObject)localObject).optString("data");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      callJS(paramString, -1, "data is empty");
      return;
    }
    String str2 = CacheManager.getWebviewOfflineFileCacheService().getPath(str1);
    QLog.i("QZoneSharePictureJsPlugin", 1, "doAppendTempFile path=" + str2 + ",data len=" + ((String)localObject).length());
    File localFile = new File(str2);
    if (!localFile.exists())
    {
      callJS(paramString, -1, HardCodeUtil.a(2131712297));
      return;
    }
    if (!localFile.canWrite())
    {
      callJS(paramString, -1, HardCodeUtil.a(2131712300));
      return;
    }
    if (appendFileContent(str2, (String)localObject)) {
      try
      {
        long l = localFile.length();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("path", str1);
        ((JSONObject)localObject).put("len", l);
        callJS(paramString, 0, "", (JSONObject)localObject);
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "JSONObject fail", paramString);
        return;
      }
    }
    callJS(paramString, -1, HardCodeUtil.a(2131712306));
  }
  
  private void doCreateTempFile(String paramString)
  {
    QLog.i("QZoneSharePictureJsPlugin", 1, "doCreateTempFile arg=" + paramString);
    try
    {
      localObject1 = new JSONObject(paramString).optString("callback");
      localObject2 = localObject1;
      QLog.e("QZoneSharePictureJsPlugin", 1, "JSONObject fail", paramString);
    }
    catch (JSONException paramString)
    {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label113;
        }
        ToastUtil.a().a("callback is null");
        QLog.e("QZoneSharePictureJsPlugin", 1, "doCreateTempFile arg=" + paramString + ",callback is null");
        return;
      }
      catch (JSONException paramString)
      {
        Object localObject1;
        Object localObject2;
        break label99;
      }
      paramString = paramString;
      localObject1 = null;
    }
    label99:
    localObject2 = localObject1;
    label113:
    paramString = CacheManager.getWebviewOfflineFileCacheService().getDir();
    if (TextUtils.isEmpty(paramString))
    {
      callJS(localObject2, -1, HardCodeUtil.a(2131712299));
      return;
    }
    try
    {
      localObject1 = new File(paramString);
      if ((!FileUtil.a(paramString)) && (!((File)localObject1).mkdirs()))
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, DISK_FULL_MSG);
        callJS(localObject2, -1, DISK_FULL_MSG);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("QZoneSharePictureJsPlugin", 1, "检查临时目录失败", paramString);
      for (;;)
      {
        int i = (int)(Math.random() * 1000000.0D % 10000.0D);
        paramString = "tempfile_" + System.currentTimeMillis() + "_" + i;
        localObject1 = CacheManager.getWebviewOfflineFileCacheService().getPath(paramString);
        try
        {
          if (!new File((String)localObject1).createNewFile()) {
            break;
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("path", paramString);
          callJS(localObject2, 0, "", (JSONObject)localObject1);
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("QZoneSharePictureJsPlugin", 1, "create file fail", paramString);
          return;
        }
        long l = Utils.a((File)localObject1);
        if (l < QzoneConfig.getInstance().getConfig("QzoneCover", "gif_cover_min_disk_size", 2097152))
        {
          QLog.e("QZoneSharePictureJsPlugin", 1, "手机存储空间已满，请清理后重试。 spaceLen=" + l + ",dir=" + paramString);
          callJS(localObject2, -1, DISK_FULL_MSG);
          return;
        }
        QLog.i("QZoneSharePictureJsPlugin", 1, "saxon spaceLen=" + l);
      }
      callJS(localObject2, -1, HardCodeUtil.a(2131712320));
      return;
    }
  }
  
  private void doDeleteTempFile(String paramString)
  {
    int i = 0;
    QLog.i("QZoneSharePictureJsPlugin", 1, "doDeleteTempFile arg=" + paramString);
    for (;;)
    {
      JSONObject localJSONObject;
      String str1;
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optString("callback");
        localObject = ((JSONObject)localObject).optJSONArray("list");
        localJSONObject = new JSONObject();
        if ((localObject == null) || (((JSONArray)localObject).length() <= 0) || (i >= ((JSONArray)localObject).length())) {
          break label248;
        }
        str1 = ((JSONArray)localObject).getString(i);
        if (TextUtils.isEmpty(str1))
        {
          localJSONObject.put(str1, false);
          QLog.w("QZoneSharePictureJsPlugin", 1, "doDeleteTempFile fileName is empty");
        }
        else if (!checkIsValidTempFileName(str1))
        {
          localJSONObject.put(str1, false);
          QLog.w("QZoneSharePictureJsPlugin", 1, "doDeleteTempFile fileName is invalid, fileName=" + str1);
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "JSONObject fail", paramString);
        return;
      }
      String str2 = CacheManager.getWebviewOfflineFileCacheService().getPath(str1);
      boolean bool = FileUtil.c(str2);
      localJSONObject.put(str1, bool);
      QZLog.i("QZoneSharePictureJsPlugin", "delete file " + str2 + ", ret=" + bool);
      label248:
      if (!TextUtils.isEmpty(paramString))
      {
        callJS(paramString, 0, "", localJSONObject);
        return;
        i += 1;
      }
    }
  }
  
  private void downloadGifSoAndGenerateGifImpl(String... paramVarArgs)
  {
    AlbumLibDownloaderUtil.getInstance().downloadGifEncoderSo(new QZoneSharePictureJsPlugin.10(this, paramVarArgs));
  }
  
  private void genGifCallback(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {}
    for (;;)
    {
      return;
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
          QLog.i("QZoneSharePictureJsPlugin", 1, "callback" + paramString1 + ",total=" + paramInt2 + ",current=" + paramInt3 + ",fileLength=" + paramInt4 + ",base64Data len=" + paramString3.length());
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
    if ((paramPluginRuntime == null) || (paramVarArgs == null) || (paramVarArgs.length < 1))
    {
      QLog.d("QZoneSharePictureJsPlugin", 1, "QzoneWidgetAI.handleGenerateGif args is empty");
      return;
    }
    paramVarArgs = paramVarArgs[0];
    Object localObject1;
    int j;
    int i;
    boolean bool3;
    Object localObject2;
    int k;
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramVarArgs);
        paramVarArgs = ((JSONObject)localObject1).getJSONArray("images");
        if (paramVarArgs == null) {
          break;
        }
        j = ((JSONObject)localObject1).optInt("delay");
        i = j;
        if (j < 0) {
          i = 100;
        }
        String str = ((JSONObject)localObject1).optString("content");
        this.callback = ((JSONObject)localObject1).optString("callback");
        boolean bool2 = ((JSONObject)localObject1).optBoolean("needPublish", false);
        bool1 = ((JSONObject)localObject1).optBoolean("useSample", false);
        boolean bool4 = ((JSONObject)localObject1).optBoolean("usePath", false);
        bool3 = ((JSONObject)localObject1).optBoolean("supportMultiPiecesCallback", false);
        QLog.i("QZoneSharePictureJsPlugin", 1, "QzoneWidgetAI.handleGenerateGif frameDelay is :" + i + ",jsonArrayImages len=" + paramVarArgs.length() + ",content=" + str + ",usePath=" + bool4 + ",supportMultiPiecesCallback=" + bool3);
        localObject2 = new GifCoder();
        ((GifCoder)localObject2).setUseOrignalBitmap(false);
        ((GifCoder)localObject2).setEncoderDither(true);
        localObject1 = PhotoUtils.getCameraPath(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE), "IMG", ".gif");
        if (!new File((String)localObject1).getParentFile().exists()) {
          new File((String)localObject1).mkdirs();
        }
        long l1 = System.currentTimeMillis();
        if (!bool1)
        {
          bool1 = true;
          bool1 = ((GifCoder)localObject2).encodeGifFromBase64((String)localObject1, paramVarArgs, i, bool1, bool4);
          ((GifCoder)localObject2).closeEncoder();
          long l2 = System.currentTimeMillis();
          QLog.i("QZoneSharePictureJsPlugin", 4, "encodeGif: duration=" + (l2 - l1));
          i = 0;
          paramVarArgs = "success";
          if (!bool1)
          {
            i = -1;
            paramVarArgs = "gif合成失败";
          }
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("published", bool2);
          if (bool2) {
            break label791;
          }
          k = QzoneConfig.getInstance().getConfig("QzoneCover", "gif_cover_callback_piece_size", 1048576);
          paramPluginRuntime = file2Base64(new File((String)localObject1));
          if (!TextUtils.isEmpty(paramPluginRuntime)) {
            break label463;
          }
          callJS(this.callback, -2, "gif文件转base64失败", (JSONObject)localObject2);
          return;
        }
      }
      catch (Throwable paramPluginRuntime)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "handleGenerateGif fail, compressGIFTask exception.", paramPluginRuntime);
        return;
      }
      boolean bool1 = false;
    }
    label463:
    if (!bool3)
    {
      QLog.i("QZoneSharePictureJsPlugin", 1, "saxon 不分片callback ");
      genGifCallback(this.callback, i, paramVarArgs, 1, 0, paramPluginRuntime, paramPluginRuntime.length());
      return;
    }
    if (paramPluginRuntime.length() <= k)
    {
      QLog.i("QZoneSharePictureJsPlugin", 1, "saxon 不分片callback len=" + paramPluginRuntime.length());
      genGifCallback(this.callback, i, paramVarArgs, 1, 0, paramPluginRuntime, paramPluginRuntime.length());
      return;
    }
    int m = paramPluginRuntime.length() / k;
    if (paramPluginRuntime.length() % k == 0) {
      j = 0;
    }
    for (;;)
    {
      m += j;
      QLog.i("QZoneSharePictureJsPlugin", 1, "saxon 分片callback pcount＝" + m + ",filelen=" + paramPluginRuntime.length());
      j = 0;
      label623:
      if (j < m - 1)
      {
        genGifCallback(this.callback, i, paramVarArgs, m, j, paramPluginRuntime.substring(j * k, (j + 1) * k), paramPluginRuntime.length());
        QLog.i("QZoneSharePictureJsPlugin", 1, "saxon 分片callback ,i=" + j);
        try
        {
          Thread.sleep(200L);
          j += 1;
          break label623;
          j = 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            QLog.e("QZoneSharePictureJsPlugin", 1, "handleGenerateGif Thread.sleep(200) fail.", localInterruptedException);
          }
        }
      }
    }
    genGifCallback(this.callback, i, paramVarArgs, m, m - 1, paramPluginRuntime.substring((m - 1) * k), paramPluginRuntime.length());
    QLog.i("QZoneSharePictureJsPlugin", 1, "saxon 分片callback last piece,i=" + (m - 1));
    return;
    label791:
    callJS(this.callback, i, paramVarArgs, (JSONObject)localObject2);
    paramVarArgs = QZoneHelper.UserInfo.getInstance();
    QZoneHelper.forwardToPublishMood(paramPluginRuntime.a(), paramVarArgs, (String)localObject1, HardCodeUtil.a(2131712314), localInterruptedException, -1);
  }
  
  private void handleSharePicture(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    int i = 0;
    Object localObject2;
    Object localObject3;
    label221:
    int j;
    if ((this.parentPlugin != null) && (paramPluginRuntime != null) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      String str;
      try
      {
        localObject2 = new JSONObject(paramVarArgs[0]);
        if (localObject2 == null) {
          break label308;
        }
        str = ((JSONObject)localObject2).optString("type");
        localObject3 = ((JSONObject)localObject2).optString("base64");
        this.callback = ((JSONObject)localObject2).optString("callback");
        paramVarArgs = ((JSONObject)localObject2).optString("shareFrom");
        localObject3 = cutHeadIfNeeded((String)localObject3);
        try
        {
          localObject3 = Base64.decode(((String)localObject3).getBytes(), 0);
          localObject3 = saveByteBufferToLocalFile((byte[])localObject3);
          if (TextUtils.isEmpty((CharSequence)localObject3))
          {
            QLog.i("QZoneSharePictureJsPlugin", 1, "saveByteBufferToLocalFile catch exception");
            makeText(HardCodeUtil.a(2131712312));
            return;
          }
        }
        catch (Exception paramPluginRuntime)
        {
          QLog.w("QZoneSharePictureJsPlugin", 1, "Base64.decode Exception: " + paramPluginRuntime.toString());
          makeText(HardCodeUtil.a(2131712290));
          return;
        }
        if (!QLog.isColorLevel()) {
          break label221;
        }
      }
      catch (Exception paramPluginRuntime)
      {
        QLog.w("QZoneSharePictureJsPlugin", 1, "handleSharePicture catch an exception in disPatchMethod", paramPluginRuntime);
        return;
      }
      QLog.d("QZoneSharePictureJsPlugin", 1, "the filePath is " + (String)localObject3);
      if ((!TextUtils.isEmpty(str)) && (paramPluginRuntime != null) && (paramPluginRuntime.a() != null)) {
        QLog.i("QZoneSharePictureJsPlugin", 1, "share type is " + str);
      }
      try
      {
        j = Integer.parseInt(str);
        i = j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          label308:
          QLog.w("QZoneSharePictureJsPlugin", 1, "parse string to integer catch a numberformatexcetion", localNumberFormatException);
        }
        paramVarArgs = new Bundle();
        paramVarArgs.putInt("forward_type", 1);
        paramVarArgs.putString("forward_filepath", (String)localObject3);
        paramVarArgs.putString("forward_thumb", (String)localObject3);
        paramVarArgs.putString("forward_extra", (String)localObject3);
        paramVarArgs.putBoolean("key_flag_from_plugin", true);
        paramVarArgs.putBoolean("forward_photo_shortvideo_is_edited", true);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtras(paramVarArgs);
        i = QZoneHelper.generateRequestCode(this.parentPlugin, paramPluginRuntime, 21);
        paramVarArgs = ForwardRecentActivity.class;
        localObject2 = ((JSONObject)localObject2).optString("extJson");
        bool = TextUtils.isEmpty((CharSequence)localObject2);
        if (bool) {
          break label873;
        }
      }
      switch (i)
      {
      default: 
        paramPluginRuntime = paramPluginRuntime.a(paramPluginRuntime.a());
        if ((paramPluginRuntime != null) && ((paramPluginRuntime instanceof WebUiUtils.WebShareInterface)))
        {
          paramPluginRuntime = ((Share)((WebUiUtils.WebShareInterface)paramPluginRuntime).getShare()).a();
          if ((paramPluginRuntime != null) && (paramPluginRuntime.isShowing())) {
            paramPluginRuntime.dismiss();
          }
        }
        QLog.i("QZoneSharePictureJsPlugin", 1, "WebView share picture call jsbridge successful!");
        return;
      }
    }
    for (;;)
    {
      Object localObject1;
      try
      {
        boolean bool;
        localObject3 = new JSONObject((String)localObject2);
        j = ((JSONObject)localObject3).optInt("targetUinType");
        localObject2 = ((JSONObject)localObject3).optString("targetUin");
        localObject3 = ((JSONObject)localObject3).optString("targetNickname");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ((Intent)localObject1).putExtra("uinType", j);
          ((Intent)localObject1).putExtra("toUin", (String)localObject2);
          ((Intent)localObject1).putExtra("nickName", (String)localObject3);
          paramVarArgs = DirectForwardActivity.class;
        }
        ForwardBaseOption.a(paramPluginRuntime.a(), (Intent)localObject1, paramVarArgs, i, -1, "");
      }
      catch (JSONException paramVarArgs)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "share to qq: parse extJson error!", paramVarArgs);
        break label873;
      }
      writeMood((JSONObject)localObject2, (String)localObject3, paramPluginRuntime);
      break;
      if (WXShareFromQZHelper.getInstance().isWXinstalled())
      {
        localObject1 = compressToBytesForWX((String)localObject3);
        if (TextUtils.equals(paramVarArgs, "wezone"))
        {
          WXShareHelper.a().a(this.wezoneWxShareListener);
          WXShareHelper.a().a((String)localObject3, (byte[])localObject1, 0);
          break;
        }
        WXShareFromQZHelper.getInstance().addObserver(this.wxShareListener);
        WXShareFromQZHelper.getInstance().shareImage(BaseApplicationImpl.getContext(), (String)localObject3, (byte[])localObject1, 0);
        break;
      }
      if (paramPluginRuntime.a() == null) {
        break;
      }
      paramPluginRuntime.a().post(new QZoneSharePictureJsPlugin.5(this, paramPluginRuntime));
      break;
      if (WXShareFromQZHelper.getInstance().isWXinstalled())
      {
        if (TextUtils.equals(paramVarArgs, "wezone"))
        {
          WXShareHelper.a().a(this.wezoneWxShareListener);
          WXShareHelper.a().a((String)localObject3, null, 1);
          break;
        }
        WXShareFromQZHelper.getInstance().addObserver(this.wxShareListener);
        WXShareFromQZHelper.getInstance().shareImage(BaseApplicationImpl.getContext(), (String)localObject3, null, 1);
        break;
      }
      if (paramPluginRuntime.a() == null) {
        break;
      }
      paramPluginRuntime.a().post(new QZoneSharePictureJsPlugin.6(this, paramPluginRuntime));
      break;
      if (paramPluginRuntime == null)
      {
        QLog.i("QZoneSharePictureJsPlugin", 1, "runtime is null");
        return;
      }
      if (paramVarArgs == null)
      {
        QLog.i("QZoneSharePictureJsPlugin", 1, "args is null");
        return;
      }
      if ((paramVarArgs != null) && (paramVarArgs.length <= 0)) {
        QLog.i("QZoneSharePictureJsPlugin", 1, "args.length = 0");
      }
      return;
      label873:
      paramVarArgs = ForwardRecentActivity.class;
    }
  }
  
  private void makeText(String paramString)
  {
    if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null)) {
      QQToast.a(this.parentPlugin.mRuntime.a().getContext(), paramString, 0).a();
    }
  }
  
  private void onShareWXResp(BaseResp paramBaseResp)
  {
    int i = 1;
    int j = paramBaseResp.errCode;
    if (j == 0)
    {
      i = 0;
      paramBaseResp = HardCodeUtil.a(2131712322);
      makeText(paramBaseResp);
    }
    for (;;)
    {
      callJS(this.callback, i, paramBaseResp);
      return;
      if (j == -2)
      {
        paramBaseResp = HardCodeUtil.a(2131712313);
        makeText(paramBaseResp);
      }
      else
      {
        paramBaseResp = HardCodeUtil.a(2131712310);
        QLog.e("QZoneSharePictureJsPlugin", 1, "wx share fail:" + j);
        i = j;
      }
    }
  }
  
  /* Error */
  private String saveByteBufferToLocalFile(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 233	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   10: getstatic 968	cooperation/qzone/share/WXShareFromQZHelper:PHOTO_PATH	Ljava/lang/String;
    //   13: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokestatic 499	java/lang/System:currentTimeMillis	()J
    //   19: invokestatic 972	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   22: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc_w 974
    //   28: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore_3
    //   35: new 445	java/io/File
    //   38: dup
    //   39: getstatic 968	cooperation/qzone/share/WXShareFromQZHelper:PHOTO_PATH	Ljava/lang/String;
    //   42: invokespecial 446	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore 4
    //   47: aload 4
    //   49: invokevirtual 449	java/io/File:exists	()Z
    //   52: ifne +9 -> 61
    //   55: aload 4
    //   57: invokevirtual 484	java/io/File:mkdirs	()Z
    //   60: pop
    //   61: new 445	java/io/File
    //   64: dup
    //   65: aload_3
    //   66: invokespecial 446	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore 4
    //   71: aload 4
    //   73: invokevirtual 449	java/io/File:exists	()Z
    //   76: ifne +9 -> 85
    //   79: aload 4
    //   81: invokevirtual 507	java/io/File:createNewFile	()Z
    //   84: pop
    //   85: new 141	java/io/FileOutputStream
    //   88: dup
    //   89: aload 4
    //   91: invokespecial 977	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   94: astore 6
    //   96: aload 6
    //   98: astore_3
    //   99: aload 6
    //   101: aload_1
    //   102: invokevirtual 980	java/io/FileOutputStream:write	([B)V
    //   105: aload 6
    //   107: astore_3
    //   108: aload 6
    //   110: invokevirtual 981	java/io/FileOutputStream:flush	()V
    //   113: aload 6
    //   115: ifnull +205 -> 320
    //   118: aload 6
    //   120: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   123: iconst_1
    //   124: istore_2
    //   125: aload 7
    //   127: astore_1
    //   128: iload_2
    //   129: ifeq +9 -> 138
    //   132: aload 4
    //   134: invokevirtual 985	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   137: astore_1
    //   138: aload_1
    //   139: areturn
    //   140: astore_1
    //   141: ldc 46
    //   143: iconst_1
    //   144: new 233	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 987
    //   154: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 990	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: iconst_1
    //   168: istore_2
    //   169: goto -44 -> 125
    //   172: astore 5
    //   174: aconst_null
    //   175: astore 4
    //   177: aconst_null
    //   178: astore_1
    //   179: aload_1
    //   180: astore_3
    //   181: ldc 46
    //   183: iconst_1
    //   184: new 233	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   191: ldc_w 992
    //   194: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 5
    //   199: invokevirtual 990	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aload_1
    //   209: ifnull +106 -> 315
    //   212: aload_1
    //   213: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   216: iconst_0
    //   217: istore_2
    //   218: goto -93 -> 125
    //   221: astore_1
    //   222: ldc 46
    //   224: iconst_1
    //   225: new 233	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 987
    //   235: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_1
    //   239: invokevirtual 990	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: iconst_0
    //   249: istore_2
    //   250: goto -125 -> 125
    //   253: astore_1
    //   254: aconst_null
    //   255: astore_3
    //   256: aload_3
    //   257: ifnull +7 -> 264
    //   260: aload_3
    //   261: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   264: aload_1
    //   265: athrow
    //   266: astore_3
    //   267: ldc 46
    //   269: iconst_1
    //   270: new 233	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 987
    //   280: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_3
    //   284: invokevirtual 990	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: goto -29 -> 264
    //   296: astore_1
    //   297: goto -41 -> 256
    //   300: astore 5
    //   302: aconst_null
    //   303: astore_1
    //   304: goto -125 -> 179
    //   307: astore 5
    //   309: aload 6
    //   311: astore_1
    //   312: goto -133 -> 179
    //   315: iconst_0
    //   316: istore_2
    //   317: goto -192 -> 125
    //   320: iconst_1
    //   321: istore_2
    //   322: goto -197 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	this	QZoneSharePictureJsPlugin
    //   0	325	1	paramArrayOfByte	byte[]
    //   124	198	2	i	int
    //   34	227	3	localObject1	Object
    //   266	18	3	localException	Exception
    //   45	131	4	localFile	File
    //   172	26	5	localIOException1	java.io.IOException
    //   300	1	5	localIOException2	java.io.IOException
    //   307	1	5	localIOException3	java.io.IOException
    //   94	216	6	localFileOutputStream	java.io.FileOutputStream
    //   1	125	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   118	123	140	java/lang/Exception
    //   35	61	172	java/io/IOException
    //   61	71	172	java/io/IOException
    //   212	216	221	java/lang/Exception
    //   35	61	253	finally
    //   61	71	253	finally
    //   71	85	253	finally
    //   85	96	253	finally
    //   260	264	266	java/lang/Exception
    //   99	105	296	finally
    //   108	113	296	finally
    //   181	208	296	finally
    //   71	85	300	java/io/IOException
    //   85	96	300	java/io/IOException
    //   99	105	307	java/io/IOException
    //   108	113	307	java/io/IOException
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
    //   3: new 1029	java/io/BufferedInputStream
    //   6: dup
    //   7: new 1031	java/io/FileInputStream
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 1032	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: invokespecial 1035	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: invokevirtual 1038	java/io/BufferedInputStream:available	()I
    //   25: newarray byte
    //   27: astore_3
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: aload_3
    //   32: invokevirtual 1042	java/io/BufferedInputStream:read	([B)I
    //   35: pop
    //   36: aload_2
    //   37: astore_1
    //   38: aload_3
    //   39: iconst_0
    //   40: invokestatic 1046	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   43: astore_3
    //   44: aload_3
    //   45: astore_1
    //   46: aload_2
    //   47: ifnull +9 -> 56
    //   50: aload_2
    //   51: invokevirtual 1047	java/io/BufferedInputStream:close	()V
    //   54: aload_3
    //   55: astore_1
    //   56: aload_1
    //   57: areturn
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 1050	java/io/IOException:printStackTrace	()V
    //   63: aload_3
    //   64: areturn
    //   65: astore_3
    //   66: aconst_null
    //   67: astore_2
    //   68: aload_2
    //   69: astore_1
    //   70: ldc 46
    //   72: iconst_1
    //   73: ldc_w 466
    //   76: aload_3
    //   77: invokestatic 1052	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   80: aload 4
    //   82: astore_1
    //   83: aload_2
    //   84: ifnull -28 -> 56
    //   87: aload_2
    //   88: invokevirtual 1047	java/io/BufferedInputStream:close	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 1050	java/io/IOException:printStackTrace	()V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_3
    //   101: aconst_null
    //   102: astore_2
    //   103: aload_2
    //   104: astore_1
    //   105: ldc 46
    //   107: iconst_1
    //   108: ldc_w 466
    //   111: aload_3
    //   112: invokestatic 1052	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload 4
    //   117: astore_1
    //   118: aload_2
    //   119: ifnull -63 -> 56
    //   122: aload_2
    //   123: invokevirtual 1047	java/io/BufferedInputStream:close	()V
    //   126: aconst_null
    //   127: areturn
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 1050	java/io/IOException:printStackTrace	()V
    //   133: aconst_null
    //   134: areturn
    //   135: astore_3
    //   136: aconst_null
    //   137: astore_2
    //   138: aload_2
    //   139: astore_1
    //   140: ldc 46
    //   142: iconst_1
    //   143: ldc_w 466
    //   146: aload_3
    //   147: invokestatic 1052	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   150: aload 4
    //   152: astore_1
    //   153: aload_2
    //   154: ifnull -98 -> 56
    //   157: aload_2
    //   158: invokevirtual 1047	java/io/BufferedInputStream:close	()V
    //   161: aconst_null
    //   162: areturn
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 1050	java/io/IOException:printStackTrace	()V
    //   168: aconst_null
    //   169: areturn
    //   170: astore_2
    //   171: aconst_null
    //   172: astore_1
    //   173: aload_1
    //   174: ifnull +7 -> 181
    //   177: aload_1
    //   178: invokevirtual 1047	java/io/BufferedInputStream:close	()V
    //   181: aload_2
    //   182: athrow
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 1050	java/io/IOException:printStackTrace	()V
    //   188: goto -7 -> 181
    //   191: astore_2
    //   192: goto -19 -> 173
    //   195: astore_3
    //   196: goto -58 -> 138
    //   199: astore_3
    //   200: goto -97 -> 103
    //   203: astore_3
    //   204: goto -136 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	QZoneSharePictureJsPlugin
    //   0	207	1	paramFile	File
    //   18	140	2	localBufferedInputStream	java.io.BufferedInputStream
    //   170	12	2	localObject1	Object
    //   191	1	2	localObject2	Object
    //   27	37	3	localObject3	Object
    //   65	12	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   100	12	3	localIOException1	java.io.IOException
    //   135	12	3	localOutOfMemoryError1	OutOfMemoryError
    //   195	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   199	1	3	localIOException2	java.io.IOException
    //   203	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	150	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   50	54	58	java/io/IOException
    //   3	19	65	java/io/FileNotFoundException
    //   87	91	93	java/io/IOException
    //   3	19	100	java/io/IOException
    //   122	126	128	java/io/IOException
    //   3	19	135	java/lang/OutOfMemoryError
    //   157	161	163	java/io/IOException
    //   3	19	170	finally
    //   177	181	183	java/io/IOException
    //   21	28	191	finally
    //   30	36	191	finally
    //   38	44	191	finally
    //   70	80	191	finally
    //   105	115	191	finally
    //   140	150	191	finally
    //   21	28	195	java/lang/OutOfMemoryError
    //   30	36	195	java/lang/OutOfMemoryError
    //   38	44	195	java/lang/OutOfMemoryError
    //   21	28	199	java/io/IOException
    //   30	36	199	java/io/IOException
    //   38	44	199	java/io/IOException
    //   21	28	203	java/io/FileNotFoundException
    //   30	36	203	java/io/FileNotFoundException
    //   38	44	203	java/io/FileNotFoundException
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {
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
      if ((paramVarArgs == null) || (paramVarArgs.length < 1))
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "args invalid");
        return true;
      }
      ThreadManager.executeOnFileThread(new QZoneSharePictureJsPlugin.2(this, paramVarArgs));
      return true;
    }
    if ("appendTempFile".equalsIgnoreCase(paramString3))
    {
      if ((paramVarArgs == null) || (paramVarArgs.length < 1))
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "args invalid");
        return true;
      }
      ThreadManager.executeOnFileThread(new QZoneSharePictureJsPlugin.3(this, paramVarArgs));
      return true;
    }
    if ("deleteTempFile".equalsIgnoreCase(paramString3))
    {
      if ((paramVarArgs == null) || (paramVarArgs.length < 1))
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "args invalid");
        return true;
      }
      ThreadManager.executeOnFileThread(new QZoneSharePictureJsPlugin.4(this, paramVarArgs));
      return true;
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    switch (paramByte)
    {
    default: 
      return;
    }
    if (paramInt == -1) {
      paramInt = 0;
    }
    for (paramIntent = HardCodeUtil.a(2131712328);; paramIntent = HardCodeUtil.a(2131712294))
    {
      callJS(this.callback, paramInt, paramIntent);
      return;
      paramInt = 1;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.wxShareListener != null) {
      WXShareFromQZHelper.getInstance().removeObserver(this.wxShareListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin
 * JD-Core Version:    0.7.0.1
 */