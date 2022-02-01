package cooperation.qzone.webviewplugin;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.AudioManager;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.DeviceApiPlugin;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.album.QzonePhotoInfo;
import cooperation.qzone.cache.QZoneFilePath;
import cooperation.qzone.model.Size;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.util.QZLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class QzoneDynamicAlbumPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  private static final String ACTION_PLUGIN_BG = "com.tencent.process.stopping";
  private static final String ACTION_PLUGIN_FG = "com.tencent.process.starting";
  public static final String DYNAMIC_ALBUM_LOCAL_IMAGE = "https://www.dynamicalbumlocalimage.com";
  private static final String DynamicCoverListUrl = "qzone.qq.com/dynamic/album/coverList";
  private static final String DynamicPreviewUrl = "qzone.qq.com/dynamic/album/preview";
  private static final String DynamicURL = "qzone.qq.com/dynamic";
  private static final String EVENT_PUBLISH_DYNAMIC_MOOD = "publishDynamicMood";
  public static final String KEY_CALLBACK = "callback";
  private static final int MSG_PICK_PHOTO_COMPRESS_FINISH = 2;
  private static final String MSG_VOLUME_CHANGE = "qbrowserVolumeChange";
  private static final String MY_DYNAMIC_ALBUM_URL = "https://h5.qzone.qq.com/dynamic/album/list?_ws&_wv=2098179&_wwv=4&_proxy=1";
  public static final String NAMESPACE = "qzDynamicAlbum";
  public static final String NAMESPACE2 = "Qzone";
  public static final String PHOTO_TMPFILE_PATH_DYNAMIC_ALBUM = QZoneFilePath.CACHE_DYNAMIC_ALBUM;
  private static final String TAG = "QzoneDynamicAlbumPlugin";
  private static String currentUrl;
  static File dirdynamicalbum;
  private static int[] mSelectedImageSize;
  private int REQUEST_PICK_CLOUD_PHOTO = 1;
  private byte REQUEST_PICK_PHOTO = 111;
  private int REQUEST_PUBLISH_MOOD = 274;
  Handler handler = new QzoneDynamicAlbumPlugin.5(this, Looper.getMainLooper());
  private int hasSelectSize = 30;
  private boolean isChating;
  private boolean isFromAlbum = false;
  private boolean isFromAlbumSharePanel = false;
  private boolean isResume;
  private boolean ispreSelloaded;
  private String mJSONArgs;
  String mJumpToAlbumID = "";
  int mJumpToAlbumTheme = 0;
  private List<QzonePhotoInfo> mSelectedCloudImageInfos = new ArrayList();
  private List<String> mSelectedImageInfos = new ArrayList();
  int mSortType = 0;
  private boolean musicPlaying;
  private BroadcastReceiver notifyReceiver = new QzoneDynamicAlbumPlugin.2(this);
  private boolean toPickPhoto;
  
  /* Error */
  private static String CompressImageFile(InputStream paramInputStream, BitmapFactory.Options paramOptions, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 149	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 150	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: astore 4
    //   13: aload_1
    //   14: getfield 155	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   17: iconst_1
    //   18: if_icmpgt +21 -> 39
    //   21: aload 5
    //   23: astore 4
    //   25: aload_1
    //   26: getfield 158	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   29: invokestatic 162	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:IsSupportImgType	(Ljava/lang/String;)Z
    //   32: ifeq +7 -> 39
    //   35: iload_3
    //   36: ifeq +385 -> 421
    //   39: aload 5
    //   41: astore 4
    //   43: aload_1
    //   44: getstatic 168	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   47: putfield 171	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   50: aload 5
    //   52: astore 4
    //   54: aload_1
    //   55: iconst_1
    //   56: putfield 174	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   59: aload 5
    //   61: astore 4
    //   63: aload_1
    //   64: iconst_1
    //   65: putfield 177	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   68: aload 5
    //   70: astore 4
    //   72: aload_0
    //   73: aconst_null
    //   74: aload_1
    //   75: invokestatic 183	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   78: astore 6
    //   80: goto +22 -> 102
    //   83: astore 6
    //   85: aload 5
    //   87: astore 4
    //   89: ldc 50
    //   91: iconst_1
    //   92: ldc 185
    //   94: aload 6
    //   96: invokestatic 191	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: aconst_null
    //   100: astore 6
    //   102: aload 5
    //   104: astore 4
    //   106: new 193	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   113: astore 7
    //   115: aload 5
    //   117: astore 4
    //   119: aload 7
    //   121: ldc 196
    //   123: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 5
    //   129: astore 4
    //   131: aload 7
    //   133: aload_1
    //   134: getfield 203	android/graphics/BitmapFactory$Options:outWidth	I
    //   137: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 5
    //   143: astore 4
    //   145: aload 7
    //   147: ldc 208
    //   149: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 5
    //   155: astore 4
    //   157: aload 7
    //   159: aload_1
    //   160: getfield 211	android/graphics/BitmapFactory$Options:outHeight	I
    //   163: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 5
    //   169: astore 4
    //   171: ldc 50
    //   173: iconst_1
    //   174: aload 7
    //   176: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 219	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload 6
    //   184: astore_1
    //   185: iload_2
    //   186: ifeq +14 -> 200
    //   189: aload 5
    //   191: astore 4
    //   193: aload 6
    //   195: iload_2
    //   196: invokestatic 223	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:rotate	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   199: astore_1
    //   200: aload_1
    //   201: ifnull +220 -> 421
    //   204: aload 5
    //   206: astore 4
    //   208: aload_1
    //   209: getstatic 229	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   212: bipush 60
    //   214: aload 5
    //   216: invokevirtual 235	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   219: pop
    //   220: aload 5
    //   222: astore 4
    //   224: aload_1
    //   225: invokevirtual 238	android/graphics/Bitmap:recycle	()V
    //   228: iconst_1
    //   229: istore_2
    //   230: goto +3 -> 233
    //   233: iload_2
    //   234: ifne +55 -> 289
    //   237: aload 5
    //   239: astore 4
    //   241: ldc 50
    //   243: iconst_1
    //   244: ldc 240
    //   246: invokestatic 219	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload 5
    //   251: astore 4
    //   253: sipush 4096
    //   256: newarray byte
    //   258: astore_1
    //   259: aload 5
    //   261: astore 4
    //   263: aload_0
    //   264: aload_1
    //   265: invokevirtual 246	java/io/InputStream:read	([B)I
    //   268: istore_2
    //   269: iload_2
    //   270: iconst_m1
    //   271: if_icmpeq +18 -> 289
    //   274: aload 5
    //   276: astore 4
    //   278: aload 5
    //   280: aload_1
    //   281: iconst_0
    //   282: iload_2
    //   283: invokevirtual 250	java/io/ByteArrayOutputStream:write	([BII)V
    //   286: goto -27 -> 259
    //   289: aload 5
    //   291: astore 4
    //   293: aload 5
    //   295: invokevirtual 254	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   298: iconst_2
    //   299: invokestatic 260	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   302: astore_0
    //   303: ldc_w 262
    //   306: invokestatic 268	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   309: checkcast 262	com/tencent/qzonehub/api/IDataUtils
    //   312: aload 5
    //   314: invokeinterface 272 2 0
    //   319: pop
    //   320: aload_0
    //   321: areturn
    //   322: astore_0
    //   323: goto +73 -> 396
    //   326: astore_1
    //   327: aload 5
    //   329: astore_0
    //   330: goto +20 -> 350
    //   333: astore_1
    //   334: aload 5
    //   336: astore_0
    //   337: goto +28 -> 365
    //   340: astore_0
    //   341: aconst_null
    //   342: astore 4
    //   344: goto +52 -> 396
    //   347: astore_1
    //   348: aconst_null
    //   349: astore_0
    //   350: aload_0
    //   351: astore 4
    //   353: ldc 50
    //   355: iconst_1
    //   356: ldc 185
    //   358: aload_1
    //   359: invokestatic 191	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   362: goto +16 -> 378
    //   365: aload_0
    //   366: astore 4
    //   368: ldc 50
    //   370: iconst_1
    //   371: ldc_w 274
    //   374: aload_1
    //   375: invokestatic 191	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   378: ldc_w 262
    //   381: invokestatic 268	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   384: checkcast 262	com/tencent/qzonehub/api/IDataUtils
    //   387: aload_0
    //   388: invokeinterface 272 2 0
    //   393: pop
    //   394: aconst_null
    //   395: areturn
    //   396: ldc_w 262
    //   399: invokestatic 268	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   402: checkcast 262	com/tencent/qzonehub/api/IDataUtils
    //   405: aload 4
    //   407: invokeinterface 272 2 0
    //   412: pop
    //   413: goto +5 -> 418
    //   416: aload_0
    //   417: athrow
    //   418: goto -2 -> 416
    //   421: iconst_0
    //   422: istore_2
    //   423: goto -190 -> 233
    //   426: astore_1
    //   427: aconst_null
    //   428: astore_0
    //   429: goto -64 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	paramInputStream	InputStream
    //   0	432	1	paramOptions	BitmapFactory.Options
    //   0	432	2	paramInt	int
    //   0	432	3	paramBoolean	boolean
    //   11	395	4	localObject	Object
    //   7	328	5	localByteArrayOutputStream	ByteArrayOutputStream
    //   78	1	6	localBitmap1	Bitmap
    //   83	12	6	localOutOfMemoryError	OutOfMemoryError
    //   100	94	6	localBitmap2	Bitmap
    //   113	62	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   72	80	83	java/lang/OutOfMemoryError
    //   13	21	322	finally
    //   25	35	322	finally
    //   43	50	322	finally
    //   54	59	322	finally
    //   63	68	322	finally
    //   72	80	322	finally
    //   89	99	322	finally
    //   106	115	322	finally
    //   119	127	322	finally
    //   131	141	322	finally
    //   145	153	322	finally
    //   157	167	322	finally
    //   171	182	322	finally
    //   193	200	322	finally
    //   208	220	322	finally
    //   224	228	322	finally
    //   241	249	322	finally
    //   253	259	322	finally
    //   263	269	322	finally
    //   278	286	322	finally
    //   293	303	322	finally
    //   353	362	322	finally
    //   368	378	322	finally
    //   13	21	326	java/lang/OutOfMemoryError
    //   25	35	326	java/lang/OutOfMemoryError
    //   43	50	326	java/lang/OutOfMemoryError
    //   54	59	326	java/lang/OutOfMemoryError
    //   63	68	326	java/lang/OutOfMemoryError
    //   89	99	326	java/lang/OutOfMemoryError
    //   106	115	326	java/lang/OutOfMemoryError
    //   119	127	326	java/lang/OutOfMemoryError
    //   131	141	326	java/lang/OutOfMemoryError
    //   145	153	326	java/lang/OutOfMemoryError
    //   157	167	326	java/lang/OutOfMemoryError
    //   171	182	326	java/lang/OutOfMemoryError
    //   193	200	326	java/lang/OutOfMemoryError
    //   208	220	326	java/lang/OutOfMemoryError
    //   224	228	326	java/lang/OutOfMemoryError
    //   241	249	326	java/lang/OutOfMemoryError
    //   253	259	326	java/lang/OutOfMemoryError
    //   263	269	326	java/lang/OutOfMemoryError
    //   278	286	326	java/lang/OutOfMemoryError
    //   293	303	326	java/lang/OutOfMemoryError
    //   13	21	333	java/lang/Exception
    //   25	35	333	java/lang/Exception
    //   43	50	333	java/lang/Exception
    //   54	59	333	java/lang/Exception
    //   63	68	333	java/lang/Exception
    //   72	80	333	java/lang/Exception
    //   89	99	333	java/lang/Exception
    //   106	115	333	java/lang/Exception
    //   119	127	333	java/lang/Exception
    //   131	141	333	java/lang/Exception
    //   145	153	333	java/lang/Exception
    //   157	167	333	java/lang/Exception
    //   171	182	333	java/lang/Exception
    //   193	200	333	java/lang/Exception
    //   208	220	333	java/lang/Exception
    //   224	228	333	java/lang/Exception
    //   241	249	333	java/lang/Exception
    //   253	259	333	java/lang/Exception
    //   263	269	333	java/lang/Exception
    //   278	286	333	java/lang/Exception
    //   293	303	333	java/lang/Exception
    //   0	9	340	finally
    //   0	9	347	java/lang/OutOfMemoryError
    //   0	9	426	java/lang/Exception
  }
  
  public static boolean IsSupportImgType(String paramString)
  {
    return (paramString != null) && ((paramString.equalsIgnoreCase("image/jpeg")) || (paramString.equalsIgnoreCase("image/png")) || (paramString.equalsIgnoreCase("image/gif")));
  }
  
  public static float[] appendGPSInfo(String paramString)
  {
    if (JpegExifReader.isCrashJpeg(paramString)) {
      return null;
    }
    try
    {
      paramString = new ExifInterface(paramString);
      float[] arrayOfFloat = new float[2];
      boolean bool = paramString.getLatLong(arrayOfFloat);
      if (bool) {
        return arrayOfFloat;
      }
      return null;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  /* Error */
  public static boolean compressDynamicAlbumImage(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 332	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +15 -> 19
    //   7: ldc_w 333
    //   10: iconst_2
    //   11: ldc_w 335
    //   14: invokestatic 337	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: iconst_0
    //   18: ireturn
    //   19: new 339	java/io/File
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 340	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore 12
    //   29: aload 12
    //   31: invokevirtual 344	java/io/File:exists	()Z
    //   34: ifne +15 -> 49
    //   37: ldc_w 333
    //   40: iconst_2
    //   41: ldc_w 346
    //   44: invokestatic 337	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: iconst_0
    //   48: ireturn
    //   49: aload_1
    //   50: invokestatic 350	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:getImageDegree	(Ljava/lang/String;)I
    //   53: istore 5
    //   55: aconst_null
    //   56: astore 10
    //   58: aconst_null
    //   59: astore 9
    //   61: aconst_null
    //   62: astore 6
    //   64: aconst_null
    //   65: astore 11
    //   67: aconst_null
    //   68: astore 8
    //   70: new 352	java/io/FileInputStream
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 353	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   78: astore 7
    //   80: aload 12
    //   82: invokestatic 359	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   85: aload_0
    //   86: iload_3
    //   87: iload 4
    //   89: invokestatic 363	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:getSizeOpt	(Landroid/net/Uri;Landroid/content/Context;II)Landroid/graphics/BitmapFactory$Options;
    //   92: astore 6
    //   94: new 339	java/io/File
    //   97: dup
    //   98: aload_2
    //   99: invokespecial 340	java/io/File:<init>	(Ljava/lang/String;)V
    //   102: astore_1
    //   103: aload 10
    //   105: astore_0
    //   106: getstatic 365	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:dirdynamicalbum	Ljava/io/File;
    //   109: invokevirtual 344	java/io/File:exists	()Z
    //   112: ifne +13 -> 125
    //   115: aload 10
    //   117: astore_0
    //   118: getstatic 365	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:dirdynamicalbum	Ljava/io/File;
    //   121: invokevirtual 368	java/io/File:mkdirs	()Z
    //   124: pop
    //   125: aload 10
    //   127: astore_0
    //   128: aload_1
    //   129: invokevirtual 344	java/io/File:exists	()Z
    //   132: ifne +11 -> 143
    //   135: aload 10
    //   137: astore_0
    //   138: aload_1
    //   139: invokevirtual 371	java/io/File:createNewFile	()Z
    //   142: pop
    //   143: aload 10
    //   145: astore_0
    //   146: new 373	java/io/FileOutputStream
    //   149: dup
    //   150: aload_1
    //   151: invokespecial 376	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   154: astore_1
    //   155: aload 6
    //   157: getfield 155	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   160: iconst_1
    //   161: if_icmpgt +45 -> 206
    //   164: aload 6
    //   166: getfield 158	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   169: invokestatic 162	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:IsSupportImgType	(Ljava/lang/String;)Z
    //   172: ifne +6 -> 178
    //   175: goto +31 -> 206
    //   178: sipush 1024
    //   181: newarray byte
    //   183: astore_0
    //   184: aload 7
    //   186: aload_0
    //   187: invokevirtual 246	java/io/InputStream:read	([B)I
    //   190: istore_3
    //   191: iload_3
    //   192: iconst_m1
    //   193: if_icmpeq +75 -> 268
    //   196: aload_1
    //   197: aload_0
    //   198: iconst_0
    //   199: iload_3
    //   200: invokevirtual 379	java/io/OutputStream:write	([BII)V
    //   203: goto -19 -> 184
    //   206: aload 6
    //   208: getstatic 168	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   211: putfield 171	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   214: aload 6
    //   216: iconst_1
    //   217: putfield 174	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   220: aload 6
    //   222: iconst_1
    //   223: putfield 177	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   226: aload 7
    //   228: aconst_null
    //   229: aload 6
    //   231: invokestatic 183	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   234: astore_0
    //   235: aload_0
    //   236: astore_2
    //   237: iload 5
    //   239: ifeq +10 -> 249
    //   242: aload_0
    //   243: iload 5
    //   245: invokestatic 223	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:rotate	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   248: astore_2
    //   249: aload_2
    //   250: ifnull +38 -> 288
    //   253: aload_2
    //   254: getstatic 229	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   257: bipush 60
    //   259: aload_1
    //   260: invokevirtual 235	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   263: pop
    //   264: aload_2
    //   265: invokevirtual 238	android/graphics/Bitmap:recycle	()V
    //   268: aload_1
    //   269: invokevirtual 382	java/io/OutputStream:close	()V
    //   272: aload 7
    //   274: invokevirtual 383	java/io/InputStream:close	()V
    //   277: aload_1
    //   278: invokevirtual 382	java/io/OutputStream:close	()V
    //   281: aload 7
    //   283: invokevirtual 383	java/io/InputStream:close	()V
    //   286: iconst_1
    //   287: ireturn
    //   288: ldc_w 333
    //   291: iconst_2
    //   292: ldc_w 385
    //   295: invokestatic 337	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: aload_1
    //   299: invokevirtual 382	java/io/OutputStream:close	()V
    //   302: aload 7
    //   304: invokevirtual 383	java/io/InputStream:close	()V
    //   307: iconst_0
    //   308: ireturn
    //   309: astore_0
    //   310: goto +85 -> 395
    //   313: astore_2
    //   314: goto +15 -> 329
    //   317: astore_2
    //   318: aload_0
    //   319: astore_1
    //   320: aload_2
    //   321: astore_0
    //   322: goto +73 -> 395
    //   325: astore_2
    //   326: aload 9
    //   328: astore_1
    //   329: aload_1
    //   330: astore_0
    //   331: aload_2
    //   332: invokevirtual 388	java/lang/Exception:printStackTrace	()V
    //   335: aload_1
    //   336: astore_0
    //   337: new 193	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   344: astore 6
    //   346: aload_1
    //   347: astore_0
    //   348: aload 6
    //   350: ldc_w 390
    //   353: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload_1
    //   358: astore_0
    //   359: aload 6
    //   361: aload_2
    //   362: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_1
    //   367: astore_0
    //   368: ldc_w 333
    //   371: iconst_2
    //   372: aload 6
    //   374: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 337	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: aload_1
    //   381: ifnull +7 -> 388
    //   384: aload_1
    //   385: invokevirtual 382	java/io/OutputStream:close	()V
    //   388: aload 7
    //   390: invokevirtual 383	java/io/InputStream:close	()V
    //   393: iconst_0
    //   394: ireturn
    //   395: aload_1
    //   396: ifnull +7 -> 403
    //   399: aload_1
    //   400: invokevirtual 382	java/io/OutputStream:close	()V
    //   403: aload_0
    //   404: athrow
    //   405: astore_0
    //   406: goto +49 -> 455
    //   409: astore_1
    //   410: aload 7
    //   412: astore_0
    //   413: goto +15 -> 428
    //   416: astore_0
    //   417: aload 6
    //   419: astore 7
    //   421: goto +34 -> 455
    //   424: astore_1
    //   425: aload 11
    //   427: astore_0
    //   428: aload_0
    //   429: astore 6
    //   431: aload_1
    //   432: invokevirtual 388	java/lang/Exception:printStackTrace	()V
    //   435: aload_0
    //   436: ifnull +7 -> 443
    //   439: aload_0
    //   440: invokevirtual 383	java/io/InputStream:close	()V
    //   443: ldc_w 333
    //   446: iconst_2
    //   447: ldc_w 395
    //   450: invokestatic 337	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: iconst_0
    //   454: ireturn
    //   455: aload 7
    //   457: ifnull +8 -> 465
    //   460: aload 7
    //   462: invokevirtual 383	java/io/InputStream:close	()V
    //   465: goto +5 -> 470
    //   468: aload_0
    //   469: athrow
    //   470: goto -2 -> 468
    //   473: astore_0
    //   474: aload 8
    //   476: astore_0
    //   477: goto -242 -> 235
    //   480: astore_0
    //   481: goto -200 -> 281
    //   484: astore_0
    //   485: iconst_1
    //   486: ireturn
    //   487: astore_0
    //   488: goto -186 -> 302
    //   491: astore_0
    //   492: iconst_0
    //   493: ireturn
    //   494: astore_0
    //   495: goto -107 -> 388
    //   498: astore_0
    //   499: iconst_0
    //   500: ireturn
    //   501: astore_1
    //   502: goto -99 -> 403
    //   505: astore_0
    //   506: goto -63 -> 443
    //   509: astore_1
    //   510: goto -45 -> 465
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	paramContext	Context
    //   0	513	1	paramString1	String
    //   0	513	2	paramString2	String
    //   0	513	3	paramInt1	int
    //   0	513	4	paramInt2	int
    //   53	191	5	i	int
    //   62	368	6	localObject1	Object
    //   78	383	7	localObject2	Object
    //   68	407	8	localObject3	Object
    //   59	268	9	localObject4	Object
    //   56	88	10	localObject5	Object
    //   65	361	11	localObject6	Object
    //   27	54	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   155	175	309	finally
    //   178	184	309	finally
    //   184	191	309	finally
    //   196	203	309	finally
    //   206	226	309	finally
    //   226	235	309	finally
    //   242	249	309	finally
    //   253	268	309	finally
    //   268	277	309	finally
    //   288	298	309	finally
    //   155	175	313	java/lang/Exception
    //   178	184	313	java/lang/Exception
    //   184	191	313	java/lang/Exception
    //   196	203	313	java/lang/Exception
    //   206	226	313	java/lang/Exception
    //   226	235	313	java/lang/Exception
    //   242	249	313	java/lang/Exception
    //   253	268	313	java/lang/Exception
    //   268	277	313	java/lang/Exception
    //   288	298	313	java/lang/Exception
    //   106	115	317	finally
    //   118	125	317	finally
    //   128	135	317	finally
    //   138	143	317	finally
    //   146	155	317	finally
    //   331	335	317	finally
    //   337	346	317	finally
    //   348	357	317	finally
    //   359	366	317	finally
    //   368	380	317	finally
    //   106	115	325	java/lang/Exception
    //   118	125	325	java/lang/Exception
    //   128	135	325	java/lang/Exception
    //   138	143	325	java/lang/Exception
    //   146	155	325	java/lang/Exception
    //   80	103	405	finally
    //   277	281	405	finally
    //   298	302	405	finally
    //   384	388	405	finally
    //   399	403	405	finally
    //   403	405	405	finally
    //   80	103	409	java/lang/Exception
    //   277	281	409	java/lang/Exception
    //   298	302	409	java/lang/Exception
    //   384	388	409	java/lang/Exception
    //   399	403	409	java/lang/Exception
    //   403	405	409	java/lang/Exception
    //   70	80	416	finally
    //   431	435	416	finally
    //   70	80	424	java/lang/Exception
    //   226	235	473	java/lang/OutOfMemoryError
    //   277	281	480	java/io/IOException
    //   281	286	484	java/io/IOException
    //   298	302	487	java/io/IOException
    //   302	307	491	java/io/IOException
    //   384	388	494	java/io/IOException
    //   388	393	498	java/io/IOException
    //   399	403	501	java/io/IOException
    //   439	443	505	java/io/IOException
    //   460	465	509	java/io/IOException
  }
  
  /* Error */
  public static String compressImageToBase64(Context paramContext, Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_1
    //   7: aload_0
    //   8: iload_2
    //   9: iload_3
    //   10: invokestatic 400	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:getSizeCrop	(Landroid/net/Uri;Landroid/content/Context;II)Landroid/graphics/BitmapFactory$Options;
    //   13: astore 6
    //   15: aload_0
    //   16: invokevirtual 406	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: aload_1
    //   20: invokevirtual 412	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   23: astore 5
    //   25: aload 5
    //   27: astore_0
    //   28: aload 5
    //   30: aload 6
    //   32: aload_1
    //   33: invokevirtual 415	android/net/Uri:getPath	()Ljava/lang/String;
    //   36: invokestatic 350	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:getImageDegree	(Ljava/lang/String;)I
    //   39: iload 4
    //   41: invokestatic 417	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:CompressImageFile	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;IZ)Ljava/lang/String;
    //   44: astore_1
    //   45: ldc_w 262
    //   48: invokestatic 268	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   51: checkcast 262	com/tencent/qzonehub/api/IDataUtils
    //   54: aload 5
    //   56: invokeinterface 272 2 0
    //   61: pop
    //   62: aload_1
    //   63: areturn
    //   64: astore_0
    //   65: aload 5
    //   67: astore_1
    //   68: aload_0
    //   69: astore 5
    //   71: goto +13 -> 84
    //   74: astore_1
    //   75: aconst_null
    //   76: astore_0
    //   77: goto +71 -> 148
    //   80: astore 5
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_1
    //   85: astore_0
    //   86: new 193	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   93: astore 6
    //   95: aload_1
    //   96: astore_0
    //   97: aload 6
    //   99: ldc_w 419
    //   102: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_1
    //   107: astore_0
    //   108: aload 6
    //   110: aload 5
    //   112: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_1
    //   117: astore_0
    //   118: ldc 50
    //   120: iconst_1
    //   121: aload 6
    //   123: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 337	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: ldc_w 262
    //   132: invokestatic 268	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   135: checkcast 262	com/tencent/qzonehub/api/IDataUtils
    //   138: aload_1
    //   139: invokeinterface 272 2 0
    //   144: pop
    //   145: aconst_null
    //   146: areturn
    //   147: astore_1
    //   148: ldc_w 262
    //   151: invokestatic 268	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   154: checkcast 262	com/tencent/qzonehub/api/IDataUtils
    //   157: aload_0
    //   158: invokeinterface 272 2 0
    //   163: pop
    //   164: aload_1
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramContext	Context
    //   0	166	1	paramUri	Uri
    //   0	166	2	paramInt1	int
    //   0	166	3	paramInt2	int
    //   0	166	4	paramBoolean	boolean
    //   23	47	5	localObject1	Object
    //   80	31	5	localException	Exception
    //   13	109	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	45	64	java/lang/Exception
    //   6	25	74	finally
    //   6	25	80	java/lang/Exception
    //   28	45	147	finally
    //   86	95	147	finally
    //   97	106	147	finally
    //   108	116	147	finally
    //   118	129	147	finally
  }
  
  private String convertToJSONInfo(String[] paramArrayOfString)
  {
    Size localSize = getBitmapSize(paramArrayOfString[1]);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://www.dynamicalbumlocalimage.com");
      localStringBuilder.append(paramArrayOfString[1]);
      localJSONObject.put("url", localStringBuilder.toString());
      if (localSize != null)
      {
        localJSONObject.put("width", localSize.width);
        localJSONObject.put("height", localSize.height);
      }
      paramArrayOfString = appendGPSInfo(paramArrayOfString[0]);
      if (paramArrayOfString != null)
      {
        localJSONObject.put("poiX", paramArrayOfString[1]);
        localJSONObject.put("poiY", paramArrayOfString[0]);
        localJSONObject.put("poiName", "");
      }
      paramArrayOfString = localJSONObject.toString();
      return paramArrayOfString;
    }
    catch (JSONException paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
    return "";
  }
  
  private void deletePhotos(String paramString)
  {
    try
    {
      Object localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).optJSONArray("photoList");
      ((JSONObject)localObject1).getString("callback");
      localObject1 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject2 = paramString.get(i);
        if ((localObject2 != null) && ((localObject2 instanceof String)))
        {
          localObject2 = (String)localObject2;
          ((ArrayList)localObject1).add(localObject2);
          if (((String)localObject2).startsWith("https://www.dynamicalbumlocalimage.com")) {
            localArrayList.add(((String)localObject2).replace("https://www.dynamicalbumlocalimage.com", ""));
          }
        }
        i += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String encodeBase64File(String paramString, int paramInt1, int paramInt2)
  {
    return encodeBase64File(paramString, paramInt1, paramInt2, false);
  }
  
  public static String encodeBase64File(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = paramString;
    if (paramString.startsWith("/")) {}
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file:///");
      ((StringBuilder)localObject).append(Uri.encode(paramString.substring(1)));
      localObject = ((StringBuilder)localObject).toString();
    }
    catch (Exception localException)
    {
      label55:
      break label55;
    }
    QLog.e("QzoneDynamicAlbumPlugin", 1, "compressImage with some: URL encode failed");
    localObject = paramString;
    paramString = Uri.parse((String)localObject);
    return compressImageToBase64(BaseApplicationImpl.getContext(), paramString, paramInt1, paramInt2, paramBoolean);
  }
  
  /* Error */
  private void entryWriteMoodAsync(String paramString)
  {
    // Byte code:
    //   0: ldc_w 525
    //   3: astore 9
    //   5: new 427	org/json/JSONObject
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 462	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: ldc_w 464
    //   18: invokevirtual 468	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   21: astore 7
    //   23: aload_1
    //   24: ldc_w 527
    //   27: invokevirtual 531	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   30: astore 17
    //   32: aload_1
    //   33: ldc 31
    //   35: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 10
    //   40: new 427	org/json/JSONObject
    //   43: dup
    //   44: invokespecial 428	org/json/JSONObject:<init>	()V
    //   47: astore 8
    //   49: new 106	java/util/ArrayList
    //   52: dup
    //   53: invokespecial 107	java/util/ArrayList:<init>	()V
    //   56: astore 16
    //   58: ldc_w 533
    //   61: astore 6
    //   63: aload 9
    //   65: astore 15
    //   67: aload 10
    //   69: astore 12
    //   71: aload 7
    //   73: astore 13
    //   75: aload 8
    //   77: astore_1
    //   78: aload 6
    //   80: astore 14
    //   82: aload 7
    //   84: ifnull +309 -> 393
    //   87: aload 9
    //   89: astore 15
    //   91: aload 10
    //   93: astore 12
    //   95: aload 7
    //   97: astore 13
    //   99: aload 8
    //   101: astore_1
    //   102: aload 6
    //   104: astore 14
    //   106: aload 7
    //   108: invokevirtual 478	org/json/JSONArray:length	()I
    //   111: ifle +282 -> 393
    //   114: aconst_null
    //   115: astore 11
    //   117: iconst_0
    //   118: istore_3
    //   119: aload 9
    //   121: astore 15
    //   123: aload 10
    //   125: astore 12
    //   127: aload 7
    //   129: astore 13
    //   131: aload 8
    //   133: astore_1
    //   134: aload 6
    //   136: astore 14
    //   138: iload_3
    //   139: aload 7
    //   141: invokevirtual 478	org/json/JSONArray:length	()I
    //   144: if_icmpge +249 -> 393
    //   147: aload 7
    //   149: iload_3
    //   150: invokevirtual 537	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   153: astore_1
    //   154: aload_1
    //   155: aload 6
    //   157: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   160: astore 12
    //   162: aload 12
    //   164: ifnull +697 -> 861
    //   167: aload_1
    //   168: ldc_w 539
    //   171: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   174: astore 11
    //   176: aload_1
    //   177: ldc_w 541
    //   180: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   183: astore 13
    //   185: iconst_0
    //   186: istore_2
    //   187: iconst_m1
    //   188: istore 4
    //   190: iload_2
    //   191: aload_0
    //   192: getfield 111	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:mSelectedCloudImageInfos	Ljava/util/List;
    //   195: invokeinterface 546 1 0
    //   200: if_icmpge +33 -> 233
    //   203: aload_0
    //   204: getfield 111	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:mSelectedCloudImageInfos	Ljava/util/List;
    //   207: iload_2
    //   208: invokeinterface 547 2 0
    //   213: checkcast 549	cooperation/qzone/album/QzonePhotoInfo
    //   216: getfield 552	cooperation/qzone/album/QzonePhotoInfo:mBigUrl	Ljava/lang/String;
    //   219: aload 12
    //   221: invokevirtual 555	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   224: ifeq +630 -> 854
    //   227: iload_2
    //   228: istore 4
    //   230: goto +624 -> 854
    //   233: aload_0
    //   234: getfield 102	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:isFromAlbum	Z
    //   237: istore 5
    //   239: iload 5
    //   241: ifeq +70 -> 311
    //   244: iload 4
    //   246: iconst_m1
    //   247: if_icmpeq +64 -> 311
    //   250: new 557	cooperation/qzone/model/DynamicPhotoData
    //   253: dup
    //   254: aload 12
    //   256: aload_1
    //   257: ldc_w 559
    //   260: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   263: aload_1
    //   264: ldc_w 561
    //   267: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   270: aload_0
    //   271: getfield 111	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:mSelectedCloudImageInfos	Ljava/util/List;
    //   274: iload 4
    //   276: invokeinterface 547 2 0
    //   281: checkcast 549	cooperation/qzone/album/QzonePhotoInfo
    //   284: getfield 564	cooperation/qzone/album/QzonePhotoInfo:mAlbumId	Ljava/lang/String;
    //   287: aload_0
    //   288: getfield 111	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:mSelectedCloudImageInfos	Ljava/util/List;
    //   291: iload 4
    //   293: invokeinterface 547 2 0
    //   298: checkcast 549	cooperation/qzone/album/QzonePhotoInfo
    //   301: getfield 567	cooperation/qzone/album/QzonePhotoInfo:mlloc	Ljava/lang/String;
    //   304: invokespecial 570	cooperation/qzone/model/DynamicPhotoData:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   307: astore_1
    //   308: goto +71 -> 379
    //   311: aload 11
    //   313: ifnull +39 -> 352
    //   316: aload 13
    //   318: ifnull +34 -> 352
    //   321: new 557	cooperation/qzone/model/DynamicPhotoData
    //   324: dup
    //   325: aload 12
    //   327: aload_1
    //   328: ldc_w 559
    //   331: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   334: aload_1
    //   335: ldc_w 561
    //   338: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   341: aload 11
    //   343: aload 13
    //   345: invokespecial 570	cooperation/qzone/model/DynamicPhotoData:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   348: astore_1
    //   349: goto +30 -> 379
    //   352: new 557	cooperation/qzone/model/DynamicPhotoData
    //   355: dup
    //   356: aload 12
    //   358: aload_1
    //   359: ldc_w 559
    //   362: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   365: aload_1
    //   366: ldc_w 561
    //   369: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   372: invokespecial 573	cooperation/qzone/model/DynamicPhotoData:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   375: astore_1
    //   376: goto +3 -> 379
    //   379: aload_1
    //   380: ifnull +487 -> 867
    //   383: aload 16
    //   385: aload_1
    //   386: invokevirtual 485	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   389: pop
    //   390: goto +477 -> 867
    //   393: aload 17
    //   395: ldc_w 575
    //   398: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   401: astore 6
    //   403: aload 17
    //   405: ldc_w 577
    //   408: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   411: astore 8
    //   413: aload 17
    //   415: ldc_w 579
    //   418: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   421: astore 9
    //   423: aload 17
    //   425: ldc_w 581
    //   428: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   431: astore 10
    //   433: aload 17
    //   435: ldc_w 583
    //   438: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   441: astore 11
    //   443: aload 17
    //   445: ldc_w 585
    //   448: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   451: astore 18
    //   453: aload 17
    //   455: aload 15
    //   457: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   460: astore 19
    //   462: aload 17
    //   464: ldc_w 587
    //   467: invokevirtual 590	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   470: istore_2
    //   471: new 592	android/os/Bundle
    //   474: dup
    //   475: invokespecial 593	android/os/Bundle:<init>	()V
    //   478: astore 7
    //   480: aload 7
    //   482: ldc_w 595
    //   485: aload 16
    //   487: invokevirtual 599	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   490: aload 7
    //   492: ldc_w 575
    //   495: aload 6
    //   497: invokevirtual 603	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: aload 7
    //   502: ldc_w 577
    //   505: aload 8
    //   507: invokevirtual 603	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload 7
    //   512: ldc_w 579
    //   515: aload 9
    //   517: invokevirtual 603	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: aload 7
    //   522: ldc_w 581
    //   525: aload 10
    //   527: invokevirtual 603	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: aload 7
    //   532: ldc_w 583
    //   535: aload 11
    //   537: invokevirtual 603	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: aload 7
    //   542: ldc_w 585
    //   545: aload 18
    //   547: invokevirtual 603	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: aload 7
    //   552: aload 15
    //   554: aload 19
    //   556: invokevirtual 603	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: aload 7
    //   561: ldc_w 605
    //   564: iconst_0
    //   565: invokevirtual 609	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   568: aload 7
    //   570: ldc_w 611
    //   573: iconst_0
    //   574: invokevirtual 609	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   577: aload 7
    //   579: ldc_w 613
    //   582: iconst_0
    //   583: invokevirtual 609	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   586: aload 7
    //   588: ldc_w 615
    //   591: ldc_w 616
    //   594: invokestatic 621	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   597: invokevirtual 603	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   600: iload_2
    //   601: iconst_1
    //   602: if_icmpne +15 -> 617
    //   605: aload 7
    //   607: ldc_w 623
    //   610: iconst_1
    //   611: invokevirtual 609	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   614: goto +12 -> 626
    //   617: aload 7
    //   619: ldc_w 623
    //   622: iconst_0
    //   623: invokevirtual 609	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   626: invokestatic 629	cooperation/qzone/QZoneHelper$UserInfo:getInstance	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   629: astore 8
    //   631: aload 8
    //   633: aload_0
    //   634: getfield 633	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:parentPlugin	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   637: getfield 639	com/tencent/mobileqq/webview/swift/WebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   640: invokevirtual 644	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   643: invokevirtual 649	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   646: putfield 652	cooperation/qzone/QZoneHelper$UserInfo:qzone_uin	Ljava/lang/String;
    //   649: aload 13
    //   651: ifnull +226 -> 877
    //   654: aload 13
    //   656: invokevirtual 478	org/json/JSONArray:length	()I
    //   659: ifle +218 -> 877
    //   662: aload 13
    //   664: iconst_0
    //   665: invokevirtual 537	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   668: aload 14
    //   670: invokevirtual 472	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   673: astore 6
    //   675: goto +3 -> 678
    //   678: aload 16
    //   680: invokevirtual 653	java/util/ArrayList:size	()I
    //   683: ifle +102 -> 785
    //   686: aload 6
    //   688: invokestatic 332	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   691: ifne +94 -> 785
    //   694: aload 6
    //   696: ldc 16
    //   698: invokevirtual 488	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   701: ifeq +183 -> 884
    //   704: aload 6
    //   706: ldc 16
    //   708: ldc 135
    //   710: invokevirtual 492	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   713: astore 6
    //   715: goto +3 -> 718
    //   718: aload_0
    //   719: getfield 633	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:parentPlugin	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   722: getfield 639	com/tencent/mobileqq/webview/swift/WebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   725: invokevirtual 656	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   728: aload 7
    //   730: aload 8
    //   732: aload 6
    //   734: ldc_w 657
    //   737: invokestatic 621	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   740: aconst_null
    //   741: aload_0
    //   742: getfield 98	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:REQUEST_PUBLISH_MOOD	I
    //   745: invokestatic 663	cooperation/qzone/QZoneHelper:forwardToPublishMood	(Landroid/app/Activity;Landroid/os/Bundle;Lcooperation/qzone/QZoneHelper$UserInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   748: ldc 50
    //   750: iconst_4
    //   751: ldc_w 665
    //   754: invokestatic 668	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   757: aload_1
    //   758: astore 6
    //   760: aload 6
    //   762: ldc_w 670
    //   765: iconst_0
    //   766: invokevirtual 443	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   769: pop
    //   770: aload 6
    //   772: ldc_w 672
    //   775: ldc_w 674
    //   778: invokevirtual 434	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   781: pop
    //   782: goto +37 -> 819
    //   785: aload_1
    //   786: astore 6
    //   788: ldc 50
    //   790: iconst_4
    //   791: ldc_w 676
    //   794: invokestatic 668	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   797: aload 6
    //   799: ldc_w 670
    //   802: iconst_m1
    //   803: invokevirtual 443	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   806: pop
    //   807: aload 6
    //   809: ldc_w 672
    //   812: ldc_w 678
    //   815: invokevirtual 434	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   818: pop
    //   819: aload_0
    //   820: getfield 633	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:parentPlugin	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   823: aload 12
    //   825: iconst_1
    //   826: anewarray 278	java/lang/String
    //   829: dup
    //   830: iconst_0
    //   831: aload_1
    //   832: invokevirtual 459	org/json/JSONObject:toString	()Ljava/lang/String;
    //   835: aastore
    //   836: invokevirtual 682	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   839: return
    //   840: astore_1
    //   841: goto +8 -> 849
    //   844: astore_1
    //   845: goto +4 -> 849
    //   848: astore_1
    //   849: aload_1
    //   850: invokevirtual 460	org/json/JSONException:printStackTrace	()V
    //   853: return
    //   854: iload_2
    //   855: iconst_1
    //   856: iadd
    //   857: istore_2
    //   858: goto -668 -> 190
    //   861: aload 11
    //   863: astore_1
    //   864: goto -485 -> 379
    //   867: iload_3
    //   868: iconst_1
    //   869: iadd
    //   870: istore_3
    //   871: aload_1
    //   872: astore 11
    //   874: goto -755 -> 119
    //   877: ldc 135
    //   879: astore 6
    //   881: goto -203 -> 678
    //   884: goto -166 -> 718
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	887	0	this	QzoneDynamicAlbumPlugin
    //   0	887	1	paramString	String
    //   186	672	2	i	int
    //   118	753	3	j	int
    //   188	104	4	k	int
    //   237	3	5	bool	boolean
    //   61	819	6	str1	String
    //   21	708	7	localObject1	Object
    //   47	684	8	localObject2	Object
    //   3	513	9	str2	String
    //   38	488	10	str3	String
    //   115	758	11	str4	String
    //   69	755	12	str5	String
    //   73	590	13	localObject3	Object
    //   80	589	14	str6	String
    //   65	488	15	str7	String
    //   56	623	16	localArrayList	ArrayList
    //   30	433	17	localJSONObject	JSONObject
    //   451	95	18	str8	String
    //   460	95	19	str9	String
    // Exception table:
    //   from	to	target	type
    //   631	649	840	org/json/JSONException
    //   654	675	840	org/json/JSONException
    //   678	715	840	org/json/JSONException
    //   718	757	840	org/json/JSONException
    //   760	782	840	org/json/JSONException
    //   788	819	840	org/json/JSONException
    //   819	839	840	org/json/JSONException
    //   453	600	844	org/json/JSONException
    //   605	614	844	org/json/JSONException
    //   617	626	844	org/json/JSONException
    //   626	631	844	org/json/JSONException
    //   5	58	848	org/json/JSONException
    //   106	114	848	org/json/JSONException
    //   138	162	848	org/json/JSONException
    //   167	185	848	org/json/JSONException
    //   190	203	848	org/json/JSONException
    //   203	227	848	org/json/JSONException
    //   233	239	848	org/json/JSONException
    //   250	308	848	org/json/JSONException
    //   321	349	848	org/json/JSONException
    //   352	376	848	org/json/JSONException
    //   383	390	848	org/json/JSONException
    //   393	453	848	org/json/JSONException
  }
  
  private void forwardToQzonePhotoPicker(String paramString)
  {
    this.mJSONArgs = paramString;
    try
    {
      this.hasSelectSize = new JSONObject(paramString).optInt("selectedPhotoNum");
    }
    catch (JSONException localJSONException)
    {
      label26:
      Object localObject;
      int i;
      break label26;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("json error cmd:");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("p2vMakeBlog", 1, ((StringBuilder)localObject).toString());
    paramString = new StringBuilder();
    paramString.append("hasSelectSize:");
    paramString.append(this.hasSelectSize);
    QLog.d("p2vMakeBlog", 1, paramString.toString());
    paramString = QZoneHelper.UserInfo.getInstance();
    paramString.qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localObject = new Bundle();
    ((Bundle)localObject).putString("key_album_id", this.mJumpToAlbumID);
    ((Bundle)localObject).putLong("key_album_owner_uin", Long.parseLong(paramString.qzone_uin));
    ((Bundle)localObject).putInt("QZ_ALBUM_THEME", this.mJumpToAlbumTheme);
    ((Bundle)localObject).putInt("key_personal_album_enter_model", 1);
    ((Bundle)localObject).putInt("PhotoConst.from_h5", 1);
    ((Bundle)localObject).putBoolean("key_is_filter_video", true);
    ((Bundle)localObject).putBoolean("key_is_from_make_blog", true);
    ((Bundle)localObject).putInt("has_select_size", this.hasSelectSize);
    i = QZoneWebViewPlugin.generateRequestCode(this.parentPlugin, this.parentPlugin.mRuntime, 8);
    QZoneHelper.forwardToPersonalPhotoList(this.parentPlugin.mRuntime.a(), paramString, (Bundle)localObject, i);
  }
  
  public static Size getBitmapSize(String paramString)
  {
    if (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeFile(paramString, localOptions);
    }
    catch (OutOfMemoryError paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBitmapSize: OutOfMemoryError");
      localStringBuilder.append(paramString);
      QLog.e("QzoneDynamicAlbumPlugin", 1, localStringBuilder.toString());
    }
    localOptions.inJustDecodeBounds = false;
    return new Size(localOptions.outWidth, localOptions.outHeight);
  }
  
  private void getBlogCloudPhoto(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString).optString("callback");
        if ((this.mSelectedCloudImageInfos != null) && (this.mSelectedCloudImageInfos.size() > 0))
        {
          localObject1 = new JSONArray();
          int i = this.mSelectedCloudImageInfos.size();
          int j = 0;
          while (j < i)
          {
            localObject2 = new JSONObject();
            Object localObject3 = (QzonePhotoInfo)this.mSelectedCloudImageInfos.get(j);
            Object localObject4 = ((QzonePhotoInfo)localObject3).mAlbumId;
            Object localObject5 = ((QzonePhotoInfo)localObject3).mlloc;
            String str = ((QzonePhotoInfo)localObject3).mBigUrl;
            int k = ((QzonePhotoInfo)localObject3).mBigHeight;
            int m = ((QzonePhotoInfo)localObject3).mBigWidth;
            long l1 = ((QzonePhotoInfo)localObject3).mShootTime;
            long l2 = ((QzonePhotoInfo)localObject3).mUploadTime;
            ((JSONObject)localObject2).put("albumid", localObject4);
            ((JSONObject)localObject2).put("lloc", localObject5);
            ((JSONObject)localObject2).put("url", str);
            ((JSONObject)localObject2).put("height", Integer.valueOf(k));
            ((JSONObject)localObject2).put("width", Integer.valueOf(m));
            ((JSONObject)localObject2).put("shoottime", Long.valueOf(l1));
            ((JSONObject)localObject2).put("uploadtime", Long.valueOf(l2));
            localObject3 = ((QzonePhotoInfo)localObject3).mShouzhang_extend_map;
            if (localObject3 != null)
            {
              localObject3 = ((Map)localObject3).entrySet().iterator();
              localObject4 = new JSONStringer().object();
              while (((Iterator)localObject3).hasNext())
              {
                localObject5 = (Map.Entry)((Iterator)localObject3).next();
                ((JSONStringer)localObject4).key(String.valueOf(((Map.Entry)localObject5).getKey())).value(((Map.Entry)localObject5).getValue());
              }
              ((JSONObject)localObject2).put("shouzhang_extend_map", ((JSONStringer)localObject4).endObject());
            }
            ((JSONArray)localObject1).put(localObject2);
            j += 1;
          }
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("photoList", localObject1);
          ((JSONObject)localObject2).put("sorttype", this.mSortType);
          ((JSONObject)localObject2).put("albumtype", this.mJumpToAlbumTheme);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("data", localObject2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("json:");
          ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
          QZLog.d("QzoneDynamicAlbumPlugin", 2, ((StringBuilder)localObject2).toString());
          this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
          return;
        }
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("code", -1);
        ((JSONObject)localObject1).put("msg", "fail");
        this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void getCloudDynamicAlbumImage(Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = paramBundle.getParcelableArrayList("param.DynamicCloudPhotolist");
    this.mJumpToAlbumID = paramBundle.getString("key_album_id");
    this.mJumpToAlbumTheme = paramBundle.getInt("QZ_ALBUM_THEME");
    this.mSortType = paramBundle.getInt("QZ_ALBUM_SORT_TYPE");
    this.mSelectedCloudImageInfos = ((List)localObject);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("mJumpToAlbumID:");
      paramBundle.append(this.mJumpToAlbumID);
      paramBundle.append(" mJumpToAlbumTheme:");
      paramBundle.append(this.mJumpToAlbumTheme);
      paramBundle.append(" mSortType:");
      paramBundle.append(this.mSortType);
      QLog.i("p2vMakeBlog", 1, paramBundle.toString());
    }
    if (paramBoolean)
    {
      int i = this.mSelectedCloudImageInfos.size();
      Bundle localBundle = null;
      String str;
      if (i > 0)
      {
        str = ((QzonePhotoInfo)this.mSelectedCloudImageInfos.get(0)).mAlbumId;
        paramBundle = ((QzonePhotoInfo)this.mSelectedCloudImageInfos.get(0)).mlloc;
        localObject = ((QzonePhotoInfo)this.mSelectedCloudImageInfos.get(0)).mBigUrl;
        localBundle = paramBundle;
      }
      else
      {
        str = null;
        paramBundle = str;
        localObject = paramBundle;
      }
      RemoteHandleManager.getInstance().getSender().uploadFirstDynamicPhoto(str, localBundle, (String)localObject, this.mSelectedCloudImageInfos.size());
    }
  }
  
  private void getCloudPhotos(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if ((this.mSelectedCloudImageInfos != null) && (this.mSelectedCloudImageInfos.size() > 0))
        {
          localObject = new JSONArray();
          int j = this.mSelectedCloudImageInfos.size();
          int i = 0;
          while (i < j)
          {
            localJSONObject = new JSONObject();
            QzonePhotoInfo localQzonePhotoInfo = (QzonePhotoInfo)this.mSelectedCloudImageInfos.get(i);
            String str1 = localQzonePhotoInfo.mAlbumId;
            String str2 = localQzonePhotoInfo.mlloc;
            String str3 = localQzonePhotoInfo.mBigUrl;
            int k = localQzonePhotoInfo.mBigHeight;
            int m = localQzonePhotoInfo.mBigWidth;
            localJSONObject.put("albumid", str1);
            localJSONObject.put("lloc", str2);
            localJSONObject.put("url", str3);
            localJSONObject.put("height", Integer.valueOf(k));
            localJSONObject.put("width", Integer.valueOf(m));
            ((JSONArray)localObject).put(localJSONObject);
            i += 1;
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("photoList", localObject);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("data", localJSONObject);
          this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
          return;
        }
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("code", -1);
        ((JSONObject)localObject).put("msg", "fail");
        this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public static double getCropRatio(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 152	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 748	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore 11
    //   9: aload 11
    //   11: iconst_1
    //   12: putfield 751	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   15: aload_0
    //   16: aconst_null
    //   17: aload 11
    //   19: invokestatic 183	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   22: pop
    //   23: aload_0
    //   24: invokevirtual 383	java/io/InputStream:close	()V
    //   27: goto +11 -> 38
    //   30: goto +8 -> 38
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 903	java/io/IOException:printStackTrace	()V
    //   38: aload 11
    //   40: getfield 203	android/graphics/BitmapFactory$Options:outWidth	I
    //   43: istore 9
    //   45: aload 11
    //   47: getfield 211	android/graphics/BitmapFactory$Options:outHeight	I
    //   50: istore 10
    //   52: iload_1
    //   53: iconst_m1
    //   54: if_icmpeq +74 -> 128
    //   57: iload_2
    //   58: iconst_m1
    //   59: if_icmpeq +69 -> 128
    //   62: iload 9
    //   64: i2d
    //   65: dstore_3
    //   66: iload_1
    //   67: i2d
    //   68: dstore 5
    //   70: dload_3
    //   71: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   74: pop
    //   75: dload 5
    //   77: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   80: pop
    //   81: dload_3
    //   82: dload 5
    //   84: ddiv
    //   85: dstore 5
    //   87: iload 10
    //   89: i2d
    //   90: dstore_3
    //   91: iload_2
    //   92: i2d
    //   93: dstore 7
    //   95: dload_3
    //   96: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   99: pop
    //   100: dload 7
    //   102: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   105: pop
    //   106: dload_3
    //   107: dload 7
    //   109: ddiv
    //   110: dstore 7
    //   112: dload 7
    //   114: dstore_3
    //   115: dload 5
    //   117: dload 7
    //   119: dcmpl
    //   120: ifle +6 -> 126
    //   123: dload 5
    //   125: dstore_3
    //   126: dload_3
    //   127: dreturn
    //   128: iload_1
    //   129: iconst_m1
    //   130: if_icmpeq +27 -> 157
    //   133: iload 9
    //   135: i2d
    //   136: dstore_3
    //   137: iload_1
    //   138: i2d
    //   139: dstore 5
    //   141: dload_3
    //   142: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   145: pop
    //   146: dload 5
    //   148: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   151: pop
    //   152: dload_3
    //   153: dload 5
    //   155: ddiv
    //   156: dreturn
    //   157: iload_2
    //   158: iconst_m1
    //   159: if_icmpeq +27 -> 186
    //   162: iload 10
    //   164: i2d
    //   165: dstore_3
    //   166: iload_2
    //   167: i2d
    //   168: dstore 5
    //   170: dload_3
    //   171: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   174: pop
    //   175: dload 5
    //   177: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   180: pop
    //   181: dload_3
    //   182: dload 5
    //   184: ddiv
    //   185: dreturn
    //   186: dconst_0
    //   187: dreturn
    //   188: astore_0
    //   189: goto -159 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramInputStream	InputStream
    //   0	192	1	paramInt1	int
    //   0	192	2	paramInt2	int
    //   65	117	3	d1	double
    //   68	115	5	d2	double
    //   93	25	7	d3	double
    //   43	91	9	i	int
    //   50	113	10	j	int
    //   7	39	11	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   15	27	33	java/io/IOException
    //   15	27	188	java/lang/OutOfMemoryError
  }
  
  private void getDynamicAlbumImage(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("DynamicQzoneDynamicAlbumPlugin getDynamicAlbumImage ");
        ((StringBuilder)localObject1).append(paramList.size());
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append((String)paramList.get(0));
        QLog.i("QZLog", 2, ((StringBuilder)localObject1).toString());
      }
      if (mSelectedImageSize == null) {
        return;
      }
      Object localObject1 = new String[paramList.size()];
      int i = 0;
      while (i < paramList.size())
      {
        if (paramList.get(i) != null)
        {
          Object localObject2 = (String)paramList.get(i);
          int j = getImageDegree((String)localObject2);
          Size localSize = getBitmapSize((String)localObject2);
          float[] arrayOfFloat = appendGPSInfo((String)localObject2);
          double d1 = getRatio(localSize);
          if (((j == 90) || (j == 270)) && (localSize != null))
          {
            j = localSize.width;
            localSize.width = localSize.height;
            localSize.height = j;
          }
          localObject2 = new JSONObject();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(PHOTO_TMPFILE_PATH_DYNAMIC_ALBUM);
          localStringBuilder.append(new Date().getTime() + i);
          localObject1[i] = localStringBuilder.toString();
          try
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("https://www.dynamicalbumlocalimage.com");
            localStringBuilder.append(localObject1[i]);
            ((JSONObject)localObject2).put("url", localStringBuilder.toString());
            if (localSize != null) {
              if (d1 > 0.0D)
              {
                j = localSize.width;
                double d2 = j;
                Double.isNaN(d2);
                j = (int)(d2 / d1);
                ((JSONObject)localObject2).put("width", j);
                j = localSize.height;
                d2 = j;
                Double.isNaN(d2);
                j = (int)(d2 / d1);
                ((JSONObject)localObject2).put("height", j);
              }
              else
              {
                ((JSONObject)localObject2).put("width", localSize.width);
                ((JSONObject)localObject2).put("height", localSize.height);
              }
            }
            if (arrayOfFloat != null)
            {
              ((JSONObject)localObject2).put("poiX", arrayOfFloat[1]);
              ((JSONObject)localObject2).put("poiY", arrayOfFloat[0]);
              ((JSONObject)localObject2).put("poiName", "");
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          this.mSelectedImageInfos.add(((JSONObject)localObject2).toString());
        }
        i += 1;
      }
      ThreadManager.post(new QzoneDynamicAlbumPlugin.7(this, paramList, (String[])localObject1), 5, null, true);
    }
  }
  
  public static int[] getDynamicAlbumImageSize()
  {
    int[] arrayOfInt = new int[2];
    int i = QzoneConfig.getInstance().getConfig("MiniVideo", "MinCpu", 1150);
    long l1 = DeviceInfoUtil.b();
    long l2 = QzoneConfig.getInstance().getConfig("MiniVideo", "MinRam", 700);
    long l3 = DeviceInfoUtil.a() / 1048576L;
    long l4 = QzoneConfig.getInstance().getConfig("MiniVideo", "MinRuntimeRam", 150);
    long l5 = DeviceInfoUtil.e() / 1048576L;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DynamicQzoneDynamicAlbumPlugin freeSizeMB ");
      localStringBuilder.append(l5);
      QLog.i("QZLog", 2, localStringBuilder.toString());
    }
    if ((Long.valueOf(l1).longValue() >= i) && (l3 >= l2) && (l5 >= l4))
    {
      arrayOfInt[0] = 1600;
      arrayOfInt[1] = 1600;
      return arrayOfInt;
    }
    arrayOfInt[0] = 640;
    arrayOfInt[1] = 640;
    return arrayOfInt;
  }
  
  public static int getImageDegree(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = JpegExifReader.getRotationDegree(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  @TargetApi(11)
  public static WebResourceResponse getImageResponse(String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getImageResponse start :");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("QzoneDynamicAlbumPlugin", 4, ((StringBuilder)localObject1).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1 = paramString.replace("https://www.dynamicalbumlocalimage.com", "");
    Object localObject2;
    try
    {
      localObject1 = URLDecoder.decode((String)localObject1, "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      localObject2 = null;
    }
    if (QLog.isDevelopLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("image filePath :");
      ((StringBuilder)localObject3).append((String)localObject2);
      QLog.i("QzoneDynamicAlbumPlugin", 4, ((StringBuilder)localObject3).toString());
    }
    Object localObject3 = new File((String)localObject2);
    Object localObject4 = currentUrl;
    if ((localObject4 != null) && (((String)localObject4).equals("https://h5.qzone.qq.com/dynamic/album/list?_ws&_wv=2098179&_wwv=4&_proxy=1")))
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("getImageResponse -  getThumbnail:");
      ((StringBuilder)localObject4).append(paramString);
      QLog.i("QzoneDynamicAlbumPlugin", 4, ((StringBuilder)localObject4).toString());
      localObject4 = getThumbnail((String)localObject2);
      if (localObject4 != null) {
        return new WebResourceResponse("image/*", "utf-8", (InputStream)localObject4);
      }
    }
    if (!((File)localObject3).exists())
    {
      if (QLog.isDevelopLevel())
      {
        paramString = new StringBuilder();
        paramString.append("getImageResponse local file not exists :");
        paramString.append((String)localObject2);
        QLog.i("QzoneDynamicAlbumPlugin", 4, paramString.toString());
      }
      return null;
    }
    try
    {
      localObject2 = new FileInputStream((String)localObject2);
      if (QLog.isDevelopLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getImageResponse ****************** :");
        ((StringBuilder)localObject3).append(paramString);
        QLog.i("QzoneDynamicAlbumPlugin", 4, ((StringBuilder)localObject3).toString());
      }
      return new WebResourceResponse("image/*", "utf-8", (InputStream)localObject2);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getImageResponse get local file fail:");
        localStringBuilder.append(paramString);
        QLog.i("QzoneDynamicAlbumPlugin", 2, localStringBuilder.toString());
      }
    }
    return null;
  }
  
  /* Error */
  public static double getOptRatio(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 152	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 748	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore 13
    //   9: aload 13
    //   11: iconst_1
    //   12: putfield 751	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   15: aload_0
    //   16: aconst_null
    //   17: aload 13
    //   19: invokestatic 183	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   22: pop
    //   23: aload_0
    //   24: invokevirtual 383	java/io/InputStream:close	()V
    //   27: goto +11 -> 38
    //   30: goto +8 -> 38
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 903	java/io/IOException:printStackTrace	()V
    //   38: aload 13
    //   40: getfield 203	android/graphics/BitmapFactory$Options:outWidth	I
    //   43: istore 11
    //   45: aload 13
    //   47: getfield 211	android/graphics/BitmapFactory$Options:outHeight	I
    //   50: istore 9
    //   52: iload 9
    //   54: istore 12
    //   56: iload 11
    //   58: istore 10
    //   60: iload 11
    //   62: iload 9
    //   64: if_icmpge +11 -> 75
    //   67: iload 9
    //   69: istore 10
    //   71: iload 11
    //   73: istore 12
    //   75: iload 10
    //   77: iload_1
    //   78: if_icmpgt +11 -> 89
    //   81: iload 12
    //   83: iload_2
    //   84: if_icmpgt +5 -> 89
    //   87: dconst_0
    //   88: dreturn
    //   89: iload 10
    //   91: iload 12
    //   93: if_icmple +51 -> 144
    //   96: iload 10
    //   98: i2d
    //   99: dstore_3
    //   100: iload_1
    //   101: i2d
    //   102: dstore 5
    //   104: dload_3
    //   105: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   108: pop
    //   109: dload 5
    //   111: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   114: pop
    //   115: dload_3
    //   116: dload 5
    //   118: ddiv
    //   119: dstore_3
    //   120: iload 12
    //   122: i2d
    //   123: dstore 7
    //   125: iload_2
    //   126: i2d
    //   127: dstore 5
    //   129: dload 7
    //   131: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   134: pop
    //   135: dload 5
    //   137: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   140: pop
    //   141: goto +48 -> 189
    //   144: iload 12
    //   146: i2d
    //   147: dstore_3
    //   148: iload_1
    //   149: i2d
    //   150: dstore 5
    //   152: dload_3
    //   153: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   156: pop
    //   157: dload 5
    //   159: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   162: pop
    //   163: dload_3
    //   164: dload 5
    //   166: ddiv
    //   167: dstore_3
    //   168: iload 10
    //   170: i2d
    //   171: dstore 7
    //   173: iload_2
    //   174: i2d
    //   175: dstore 5
    //   177: dload 7
    //   179: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   182: pop
    //   183: dload 5
    //   185: invokestatic 909	java/lang/Double:isNaN	(D)Z
    //   188: pop
    //   189: dload 7
    //   191: dload 5
    //   193: ddiv
    //   194: dstore 7
    //   196: dload 7
    //   198: dstore 5
    //   200: dload_3
    //   201: dload 7
    //   203: dcmpl
    //   204: ifle +6 -> 210
    //   207: dload_3
    //   208: dstore 5
    //   210: dload 5
    //   212: dreturn
    //   213: astore_0
    //   214: goto -184 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramInputStream	InputStream
    //   0	217	1	paramInt1	int
    //   0	217	2	paramInt2	int
    //   99	109	3	d1	double
    //   102	109	5	d2	double
    //   123	79	7	d3	double
    //   50	18	9	i	int
    //   58	111	10	j	int
    //   43	29	11	k	int
    //   54	91	12	m	int
    //   7	39	13	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   15	27	33	java/io/IOException
    //   15	27	213	java/lang/OutOfMemoryError
  }
  
  private void getPhotos(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject1 = this.mSelectedImageInfos;
        if ((localObject1 != null) && (this.mSelectedImageInfos.size() > 0))
        {
          localObject1 = new JSONArray();
          Object localObject2 = this.mSelectedImageInfos.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((JSONArray)localObject1).put(new JSONObject((String)((Iterator)localObject2).next()));
          }
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("photoList", localObject1);
          ((JSONObject)localObject2).put("totalNumPreSelected", this.mSelectedImageInfos.size());
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("code", 0);
          ((JSONObject)localObject1).put("msg", "success");
          ((JSONObject)localObject1).put("data", localObject2);
          this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
          return;
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("code", -1);
        ((JSONObject)localObject1).put("msg", "fail");
        this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static double getRatio(Size paramSize)
  {
    if (mSelectedImageSize == null) {
      mSelectedImageSize = getDynamicAlbumImageSize();
    }
    double d1 = 0.0D;
    if (paramSize != null)
    {
      int j = paramSize.width;
      int i = paramSize.height;
      int k;
      if (j < i)
      {
        k = i;
      }
      else
      {
        k = j;
        j = i;
      }
      paramSize = mSelectedImageSize;
      if ((k <= paramSize[0]) && (j <= paramSize[1])) {
        return 0.0D;
      }
      double d2;
      double d3;
      if (k > j)
      {
        d1 = k;
        paramSize = mSelectedImageSize;
        d2 = paramSize[0];
        Double.isNaN(d1);
        Double.isNaN(d2);
        d2 = d1 / d2;
        d1 = j;
        d3 = paramSize[1];
        Double.isNaN(d1);
        Double.isNaN(d3);
        d1 /= d3;
      }
      else
      {
        d1 = j;
        paramSize = mSelectedImageSize;
        d2 = paramSize[0];
        Double.isNaN(d1);
        Double.isNaN(d2);
        d2 = d1 / d2;
        d1 = k;
        d3 = paramSize[1];
        Double.isNaN(d1);
        Double.isNaN(d3);
        d1 /= d3;
      }
      if (d2 > d1) {
        return d2;
      }
    }
    return d1;
  }
  
  private void getSelectNum(Bundle paramBundle)
  {
    try
    {
      int i = paramBundle.getInt("param.DynamicMin");
      int j = paramBundle.getInt("param.DynamicMax");
      paramBundle = paramBundle.getString("param.DynamicCmd");
      if (!TextUtils.isEmpty(paramBundle))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("code", 0);
        localJSONObject.put("msg", "success");
        localJSONObject.put("maxNum", j);
        localJSONObject.put("minNum", i);
        this.parentPlugin.callJs(paramBundle, new String[] { localJSONObject.toString() });
        return;
      }
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public static BitmapFactory.Options getSizeCrop(Uri paramUri, Context paramContext, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    Object localObject = paramContext.getContentResolver().openInputStream(paramUri);
    double d = getCropRatio((InputStream)localObject, paramInt1, paramInt2);
    paramInt2 = (int)d;
    paramInt1 = paramInt2;
    if (d > paramInt2) {
      paramInt1 = paramInt2 + 1;
    }
    localOptions.inSampleSize = paramInt1;
    localOptions.inJustDecodeBounds = true;
    ((InputStream)localObject).close();
    paramUri = paramContext.getContentResolver().openInputStream(paramUri);
    try
    {
      BitmapFactory.decodeStream(paramUri, null, localOptions);
    }
    catch (OutOfMemoryError paramContext)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSizeCrop");
      ((StringBuilder)localObject).append(paramContext);
      QLog.e("QzoneDynamicAlbumPlugin", 1, ((StringBuilder)localObject).toString());
    }
    paramUri.close();
    localOptions.inJustDecodeBounds = false;
    return localOptions;
  }
  
  public static BitmapFactory.Options getSizeOpt(Uri paramUri, Context paramContext, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    InputStream localInputStream = paramContext.getContentResolver().openInputStream(paramUri);
    double d = getOptRatio(localInputStream, paramInt1, paramInt2);
    paramInt2 = (int)d;
    paramInt1 = paramInt2;
    if (d > paramInt2) {
      paramInt1 = paramInt2 + 1;
    }
    localOptions.inSampleSize = paramInt1;
    localOptions.inJustDecodeBounds = true;
    localInputStream.close();
    paramUri = paramContext.getContentResolver().openInputStream(paramUri);
    try
    {
      BitmapFactory.decodeStream(paramUri, null, localOptions);
      label80:
      paramUri.close();
      localOptions.inJustDecodeBounds = false;
      return localOptions;
    }
    catch (OutOfMemoryError paramContext)
    {
      break label80;
    }
  }
  
  private static InputStream getThumbnail(String paramString)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    float f = Math.min(((BitmapFactory.Options)localObject).outWidth / 400, ((BitmapFactory.Options)localObject).outHeight / 300);
    int i = 1;
    while (i < f) {
      i *= 2;
    }
    ((BitmapFactory.Options)localObject).inSampleSize = i;
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      localObject = new ByteArrayOutputStream();
      paramString.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      paramString = new ByteArrayInputStream(((ByteArrayOutputStream)localObject).toByteArray());
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getThumbnail:outOfMemortError ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("QzoneDynamicAlbumPlugin", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private void isDraftPhotosValid(String paramString)
  {
    QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid - start");
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject1 = paramString.getJSONArray("photosPath");
        i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          break label206;
        }
        Object localObject2 = ((JSONArray)localObject1).getString(i);
        if (((String)localObject2).startsWith("https://www.dynamicalbumlocalimage.com"))
        {
          localObject2 = new File(((String)localObject2).replace("https://www.dynamicalbumlocalimage.com", ""));
          QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid - isValid:true");
          if (!((File)localObject2).exists())
          {
            i = 0;
            paramString = paramString.getString("callback");
            localObject1 = new JSONObject();
            if (i != 0)
            {
              QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid SUCCESS!");
              ((JSONObject)localObject1).put("code", 0);
              ((JSONObject)localObject1).put("msg", "success");
            }
            else
            {
              QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid FAILE");
              ((JSONObject)localObject1).put("code", -1);
              ((JSONObject)localObject1).put("msg", "fail");
            }
            this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
            return;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      i += 1;
      continue;
      label206:
      int i = 1;
    }
  }
  
  private void pickDynamicAlbumImage(ArrayList<String> paramArrayList)
  {
    QLog.d("QzoneDynamicAlbumPlugin", 4, "pickDynamicAlbumImage start!");
    int i;
    if (paramArrayList != null) {
      i = paramArrayList.size();
    } else {
      i = 0;
    }
    new ArrayList();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (mSelectedImageSize == null) {
        mSelectedImageSize = getDynamicAlbumImageSize();
      }
      if (dirdynamicalbum == null) {
        dirdynamicalbum = new File(PHOTO_TMPFILE_PATH_DYNAMIC_ALBUM);
      }
      ThreadManager.post(new QzoneDynamicAlbumPlugin.6(this, paramArrayList, i), 5, null, true);
    }
  }
  
  private void pickPhoto(String paramString)
  {
    try
    {
      this.toPickPhoto = true;
      this.mJSONArgs = paramString;
      int i = new JSONObject(paramString).optInt("maxSelectNum");
      paramString = new ActivityURIRequest(this.parentPlugin.mRuntime.a(), "/base/album/photolist");
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("PhotoConst.MAXUM_SELECTED_NUM", i);
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_MODE", false);
      paramString.extra().putBoolean("PhotoConst.IS_FROM_DYNAMIC_ALBUM", true);
      paramString.extra().putBoolean("PhotoConst.IS_NO_PANORAMA", true);
      paramString.extra().putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Bundle)localObject).putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      ((Bundle)localObject).putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Bundle)localObject).putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      ((Bundle)localObject).putInt("uintype", 0);
      paramString.extra().putAll((Bundle)localObject);
      QZoneHelper.addSource(paramString);
      localObject = this.parentPlugin.mRuntime.a();
      if (localObject != null)
      {
        WebViewUtil.a(this.parentPlugin, paramString, this.REQUEST_PICK_PHOTO, (WebViewProvider)localObject);
        return;
      }
      ((AbsBaseWebViewActivity)this.parentPlugin.mRuntime.a()).gotoSelectPicture(this.parentPlugin, paramString, this.REQUEST_PICK_PHOTO);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void play(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      DeviceApiPlugin.a(true, this.parentPlugin.mRuntime.a(), false);
      return;
    }
    DeviceApiPlugin.a(false, this.parentPlugin.mRuntime.a(), false);
    ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(null);
  }
  
  private void requestPlayMusic(String paramString)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestPlayMusic start:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(";isChating:");
      ((StringBuilder)localObject).append(this.isChating);
      QZLog.d("dynamic.Album", 2, ((StringBuilder)localObject).toString());
      localObject = new JSONObject();
      boolean bool = this.isChating;
      if (bool)
      {
        ((JSONObject)localObject).put("isCanPlayMusic", "false");
        this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      ((JSONObject)localObject).put("isCanPlayMusic", "true");
      this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      localObject = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
      if (localObject == null) {
        return;
      }
      ((AudioManager)localObject).requestAudioFocus(null, 3, 1);
      return;
    }
    catch (Exception localException) {}catch (JSONException localJSONException)
    {
      break label204;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestPlayMusic get an Exception, cmd:");
    localStringBuilder.append(paramString);
    QZLog.d("dynamic.Album", 2, localStringBuilder.toString());
    localJSONException.printStackTrace();
    return;
    label204:
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestPlayMusic get jsonException, cmd:");
    localStringBuilder.append(paramString);
    QZLog.e("dynamic.Album", 2, new Object[] { localStringBuilder.toString() });
    localJSONException.printStackTrace();
  }
  
  public static Bitmap rotate(Bitmap paramBitmap, int paramInt)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = paramBitmap;
      if (paramBitmap != localBitmap)
      {
        paramBitmap.recycle();
        localObject = localBitmap;
      }
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return paramBitmap;
  }
  
  private void sendBlogCLoudPhotoToH5(Intent paramIntent)
  {
    getCloudDynamicAlbumImage(paramIntent.getExtras(), false);
    if (TextUtils.isEmpty(this.mJSONArgs)) {
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("sendBlogCLoudPhotoToH5 | mJSONArgs:");
    paramIntent.append(this.mJSONArgs);
    QLog.d("QzoneDynamicAlbumPlugin", 2, paramIntent.toString());
    getBlogCloudPhoto(this.mJSONArgs);
  }
  
  private void sendCloudDynmicPhotoSuccess()
  {
    RemoteHandleManager.getInstance().getSender().sendCloudDynmicPhotoSuccess((ArrayList)this.mSelectedCloudImageInfos);
    this.mSelectedCloudImageInfos.clear();
  }
  
  private void setDynamicAlbumData(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString).optJSONObject("songInfo");
      paramString = ((JSONObject)localObject).getString("music_id");
      String str1 = ((JSONObject)localObject).getString("lrc_id");
      String str2 = ((JSONObject)localObject).getString("climax_start");
      localObject = ((JSONObject)localObject).getString("climax_endure");
      RemoteHandleManager.getInstance().getSender().updateDynamicAlbumInfo(paramString, str1, str2, (String)localObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void toBase64(String paramString)
  {
    try
    {
      Object localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).getString("callback");
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = ((JSONObject)localObject1).optJSONArray("photoList");
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).get(i);
          if ((localObject2 != null) && ((localObject2 instanceof String)))
          {
            localObject2 = (String)localObject2;
            if (((String)localObject2).startsWith("https://www.dynamicalbumlocalimage.com"))
            {
              localObject2 = ((String)localObject2).replace("https://www.dynamicalbumlocalimage.com", "");
              Object localObject3 = getBitmapSize((String)localObject2);
              if (localObject3 == null) {
                return;
              }
              localObject2 = encodeBase64File((String)localObject2, ((Size)localObject3).width, ((Size)localObject3).height);
              boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
              if (!bool)
              {
                localObject3 = new JSONObject();
                ((JSONObject)localObject3).put("code", 0);
                ((JSONObject)localObject3).put("msg", "success");
                ((JSONObject)localObject3).put("data", localObject2);
                this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject3).toString() });
              }
              else
              {
                localObject2 = new JSONObject();
                ((JSONObject)localObject2).put("code", -1);
                ((JSONObject)localObject2).put("msg", "fail");
                this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
              }
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if ((paramLong == 8L) && (paramString.startsWith("https://www.dynamicalbumlocalimage.com")))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("DynamicQzoneDynamicAlbumPlugin getImageResponse ");
        localStringBuilder.append(paramString);
        QLog.i("QZLog", 2, localStringBuilder.toString());
      }
      return getImageResponse(paramString);
    }
    return super.handleEvent(paramString, paramLong);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934600L) && ((Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.REQUEST_PICK_PHOTO) || (Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.REQUEST_PUBLISH_MOOD)))
    {
      int i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      Object localObject = (Intent)paramMap.get("data");
      int j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if (i == this.REQUEST_PICK_PHOTO)
      {
        if (j == -1) {
          pickDynamicAlbumImage(((Intent)localObject).getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
        } else {
          sendPhotoData(null, 0);
        }
      }
      else if ((i == this.REQUEST_PUBLISH_MOOD) && (j == -1))
      {
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("isPublishDynamicMood", true);
          JSONObject localJSONObject = new JSONObject();
          JSONArray localJSONArray = new JSONArray();
          localJSONArray.put("*.qzone.qq.com");
          localJSONObject.put("echo", false);
          localJSONObject.put("broadcast", true);
          localJSONObject.put("domains", localJSONArray);
          dispatchEvent("publishDynamicMood", (JSONObject)localObject, localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        if ((this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null)) {
          this.parentPlugin.mRuntime.a().finish();
        }
      }
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("qzone.qq.com/dynamic")))
    {
      if (paramString.contains("qzone.qq.com/dynamic/album/coverList")) {
        RemoteHandleManager.getInstance().getSender().enableFirstDynamicPreUpload();
      }
      if (paramLong == 2L)
      {
        this.isResume = true;
        if (this.toPickPhoto)
        {
          this.toPickPhoto = false;
          sendPhotoData(null, 0);
        }
      }
      else if (paramLong == 8589934597L)
      {
        this.isResume = false;
      }
      else if (paramLong == 8589934608L)
      {
        notifyVolumeChange("qbrowserVolumeChange", 2);
      }
      else if (paramLong == 8589934609L)
      {
        notifyVolumeChange("qbrowserVolumeChange", 1);
      }
      else if ((paramLong == 8589934601L) && (paramString.contains("qzone.qq.com/dynamic/album/preview")))
      {
        RemoteHandleManager.getInstance().getSender().deletePrePostDynamicAlbum();
      }
      return super.handleEvent(paramString, paramLong, paramMap);
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (((paramString2.equals("qzDynamicAlbum")) || (paramString2.equals("Qzone"))) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if ((paramVarArgs != null) && (paramVarArgs.length != 0))
      {
        paramJsBridgeListener = paramVarArgs[0];
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append("");
        paramString1.append(paramJsBridgeListener.a);
        paramJsBridgeListener = paramString1.toString();
      }
      paramString1 = new StringBuilder();
      paramString1.append("NAMESPACE = ");
      paramString1.append(paramString2);
      paramString1.append(";method = ");
      paramString1.append(paramString3);
      paramString1.append(";args = ");
      paramString1.append(paramJsBridgeListener);
      QLog.d("QzoneDynamicAlbumPlugin", 4, paramString1.toString());
      if ("deletePhotos".equals(paramString3))
      {
        deletePhotos(paramJsBridgeListener);
        return true;
      }
      if ("saveDynamicAlbum".equals(paramString3)) {
        return true;
      }
      if ("getPhotos".equals(paramString3))
      {
        paramString1 = new StringBuilder();
        paramString1.append("handleJsRequest - getPhotos - isFromAlbum:");
        paramString1.append(this.isFromAlbum);
        QZLog.d("dynamic.Album", 4, paramString1.toString());
        if (this.isFromAlbum)
        {
          getCloudPhotos(paramJsBridgeListener);
          return true;
        }
        getPhotos(paramJsBridgeListener);
        return true;
      }
      if ("getBlogCloudPhotoUrls".equals(paramString3))
      {
        getBlogCloudPhoto(paramJsBridgeListener);
        return true;
      }
      if ("getCloudPhotoUrl".equals(paramString3))
      {
        getCloudPhotos(paramJsBridgeListener);
        return false;
      }
      if ("dynamicSendSuccess".equals(paramString3))
      {
        sendCloudDynmicPhotoSuccess();
        return false;
      }
      if ("isDraftPhotosValid".equals(paramString3))
      {
        isDraftPhotosValid(paramJsBridgeListener);
        return false;
      }
      if ("getSelectNum".equals(paramString3))
      {
        this.parentPlugin.mRuntime.a().getHandler(QzoneDynamicAlbumPlugin.class).post(new QzoneDynamicAlbumPlugin.3(this, paramJsBridgeListener));
        return true;
      }
      if ("entryWriteMoodAsync".equals(paramString3))
      {
        entryWriteMoodAsync(paramJsBridgeListener);
        return true;
      }
      if ("blogOpenQzoneImagePicker".equals(paramString3))
      {
        forwardToQzonePhotoPicker(paramJsBridgeListener);
        return true;
      }
      if ("toBase64".equals(paramString3))
      {
        toBase64(paramJsBridgeListener);
        return true;
      }
      if ("openImagePicker".equals(paramString3))
      {
        pickPhoto(paramJsBridgeListener);
        return true;
      }
      if ("cancel".equals(paramString3))
      {
        this.parentPlugin.mRuntime.a().getHandler(QzoneDynamicAlbumPlugin.class).post(new QzoneDynamicAlbumPlugin.4(this));
        return true;
      }
      if ("requestPlayMusic".equals(paramString3))
      {
        requestPlayMusic(paramJsBridgeListener);
        return true;
      }
      if ("startPlay".equals(paramString3))
      {
        play(true);
        return true;
      }
      if ("endPlay".equals(paramString3))
      {
        play(false);
        return true;
      }
      if ("setDynamicAlbumData".equals(paramString3))
      {
        setDynamicAlbumData(paramJsBridgeListener);
        return true;
      }
    }
    return false;
  }
  
  public void initRuntime(WebViewPlugin paramWebViewPlugin)
  {
    super.initRuntime(paramWebViewPlugin);
    if ((paramWebViewPlugin != null) && (paramWebViewPlugin.mRuntime != null))
    {
      if (!(paramWebViewPlugin.mRuntime.a() instanceof QQBrowserActivity)) {
        return;
      }
      Object localObject;
      if (paramWebViewPlugin.mRuntime.a() != null) {
        localObject = paramWebViewPlugin.mRuntime.a().getCurrentUrl();
      } else {
        localObject = "";
      }
      currentUrl = (String)localObject;
      if (!TextUtils.isEmpty(currentUrl))
      {
        if ((!currentUrl.contains("qzone.qq.com/dynamic")) && (!currentUrl.contains("blog"))) {
          return;
        }
        if (dirdynamicalbum == null) {
          dirdynamicalbum = new File(PHOTO_TMPFILE_PATH_DYNAMIC_ALBUM);
        }
        if (!this.ispreSelloaded)
        {
          this.ispreSelloaded = true;
          localObject = new IntentFilter();
          ((IntentFilter)localObject).addAction("com.tencent.process.stopping");
          ((IntentFilter)localObject).addAction("com.tencent.process.starting");
          ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
          ((IntentFilter)localObject).addAction("tencent.av.v2q.StopVideoChat");
          paramWebViewPlugin.mRuntime.a().registerReceiver(this.notifyReceiver, (IntentFilter)localObject);
          RemoteHandleManager.getInstance().addWebEventListener(this);
          paramWebViewPlugin.mRuntime.a().getHandler(QzoneDynamicAlbumPlugin.class).post(new QzoneDynamicAlbumPlugin.1(this));
        }
      }
    }
  }
  
  public void notifyVolumeChange(String paramString, int paramInt)
  {
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    int i = localAudioManager.getStreamMaxVolume(3);
    int j = localAudioManager.getStreamVolume(3);
    boolean bool;
    if (localAudioManager.getRingerMode() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("type", paramInt);
        paramString.put("isMute", bool);
        paramString.put("maxVolume", i);
        paramString.put("currentVolume", j);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      this.parentPlugin.dispatchJsEvent("qbrowserVolumeChange", paramString, paramString);
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == this.REQUEST_PICK_PHOTO)
    {
      this.toPickPhoto = false;
      if (paramInt == -1)
      {
        pickDynamicAlbumImage(paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
        return;
      }
      sendPhotoData(null, 0);
      return;
    }
    if (paramByte == 8) {
      sendBlogCLoudPhotoToH5(paramIntent);
    }
  }
  
  public void onAudioSessionActive()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    this.parentPlugin.dispatchJsEvent("com.tencent.qq.qzone.playInterruptBegin", localJSONObject1, localJSONObject2);
  }
  
  public void onAudioSessionDeactive()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    this.parentPlugin.dispatchJsEvent("com.tencent.qq.qzone.playWillBeInterruptEnd", localJSONObject1, localJSONObject2);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    RemoteHandleManager.getInstance().removeWebEventListener(this);
    RemoteHandleManager.getInstance().getSender().onDynamicPageDestroy();
    DeviceApiPlugin.a(false, this.parentPlugin.mRuntime.a(), false);
    try
    {
      this.parentPlugin.mRuntime.a().unregisterReceiver(this.notifyReceiver);
      return;
    }
    catch (Exception localException)
    {
      label53:
      break label53;
    }
    QLog.e("QzoneDynamicAlbumPlugin", 2, "unregiser fail");
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWebEvent: event - ");
    localStringBuilder.append(paramString);
    QZLog.d("dynamic.Album", 4, localStringBuilder.toString());
    if (paramBundle != null)
    {
      if (!paramBundle.containsKey("data")) {
        return;
      }
      paramBundle = paramBundle.getBundle("data");
      if (paramString.equals("cmd.getDynamicPhoto"))
      {
        this.isFromAlbum = paramBundle.getBoolean("param.DynamicIsFromAlbum", false);
        boolean bool = paramBundle.getBoolean("param.DynamicIsFromMakeBlog", false);
        this.isFromAlbumSharePanel = paramBundle.getBoolean("param.DynamicIsFromAlbumSharePanel", false);
        paramString = new StringBuilder();
        paramString.append("onWebEvent - getBoolean - isFromAlbum:");
        paramString.append(this.isFromAlbum);
        paramString.append(" isFromMakeBlog:");
        paramString.append(bool);
        QZLog.d("dynamic.Album", 4, paramString.toString());
        if (this.isFromAlbum)
        {
          if (bool)
          {
            getCloudDynamicAlbumImage(paramBundle, false);
            return;
          }
          getCloudDynamicAlbumImage(paramBundle, true);
          return;
        }
        getDynamicAlbumImage(paramBundle.getStringArrayList("param.DynamicPhotolist"));
        return;
      }
      if (paramString.equals("cmd.getDynamicSelnum"))
      {
        getSelectNum(paramBundle);
        return;
      }
      if (paramString.equals("cmd.getDynamicCloudPhoto")) {
        getCloudDynamicAlbumImage(paramBundle, false);
      }
    }
  }
  
  public void sendPhotoData(List<String> paramList, int paramInt)
  {
    try
    {
      if (TextUtils.isEmpty(this.mJSONArgs)) {
        return;
      }
      String str = new JSONObject(this.mJSONArgs).optString("callback");
      boolean bool = TextUtils.isEmpty(str);
      if (!bool)
      {
        if ((paramList != null) && (paramList.size() > 0))
        {
          Object localObject = new JSONArray();
          paramList = paramList.iterator();
          while (paramList.hasNext()) {
            ((JSONArray)localObject).put(new JSONObject((String)paramList.next()));
          }
          paramList = new JSONObject();
          paramList.put("photoList", localObject);
          paramList.put("totalNumPreSelected", paramInt);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("code", 0);
          ((JSONObject)localObject).put("msg", "success");
          ((JSONObject)localObject).put("data", paramList);
          this.parentPlugin.callJs(str, new String[] { ((JSONObject)localObject).toString() });
          return;
        }
        paramList = new JSONObject();
        paramList.put("code", -1);
        paramList.put("msg", "fail");
        this.parentPlugin.callJs(str, new String[] { paramList.toString() });
        return;
      }
    }
    catch (JSONException paramList)
    {
      paramList.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin
 * JD-Core Version:    0.7.0.1
 */