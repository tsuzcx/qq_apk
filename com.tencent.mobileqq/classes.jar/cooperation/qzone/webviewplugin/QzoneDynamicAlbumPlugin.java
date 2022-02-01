package cooperation.qzone.webviewplugin;

import amtj;
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
import android.text.TextUtils;
import autj;
import bgve;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.album.QzonePhotoInfo;
import cooperation.qzone.cache.QZoneFilePath;
import cooperation.qzone.model.DynamicPhotoData;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.util.QZLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
  Handler handler = new QzoneDynamicAlbumPlugin.5(this);
  private int hasSelectSize = 30;
  private boolean isChating;
  private boolean isFromAlbum;
  private boolean isFromAlbumSharePanel;
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
    //   0: iconst_0
    //   1: istore 5
    //   3: new 137	java/io/ByteArrayOutputStream
    //   6: dup
    //   7: invokespecial 138	java/io/ByteArrayOutputStream:<init>	()V
    //   10: astore 7
    //   12: aload 7
    //   14: astore 6
    //   16: aload_1
    //   17: getfield 143	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   20: iconst_1
    //   21: if_icmpgt +25 -> 46
    //   24: aload 7
    //   26: astore 6
    //   28: aload_1
    //   29: getfield 146	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   32: invokestatic 150	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:IsSupportImgType	(Ljava/lang/String;)Z
    //   35: ifeq +11 -> 46
    //   38: iload 5
    //   40: istore 4
    //   42: iload_3
    //   43: ifeq +141 -> 184
    //   46: aload 7
    //   48: astore 6
    //   50: aload_1
    //   51: getstatic 156	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   54: putfield 159	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   57: aload 7
    //   59: astore 6
    //   61: aload_1
    //   62: iconst_1
    //   63: putfield 162	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   66: aload 7
    //   68: astore 6
    //   70: aload_1
    //   71: iconst_1
    //   72: putfield 165	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   75: aload 7
    //   77: astore 6
    //   79: aload_0
    //   80: aconst_null
    //   81: aload_1
    //   82: invokestatic 171	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   85: astore 8
    //   87: aload 7
    //   89: astore 6
    //   91: ldc 50
    //   93: iconst_1
    //   94: new 173	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   101: ldc 176
    //   103: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_1
    //   107: getfield 183	android/graphics/BitmapFactory$Options:outWidth	I
    //   110: invokevirtual 186	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc 188
    //   115: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: getfield 191	android/graphics/BitmapFactory$Options:outHeight	I
    //   122: invokevirtual 186	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 201	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload 8
    //   133: astore_1
    //   134: iload_2
    //   135: ifeq +14 -> 149
    //   138: aload 7
    //   140: astore 6
    //   142: aload 8
    //   144: iload_2
    //   145: invokestatic 205	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:rotate	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   148: astore_1
    //   149: iload 5
    //   151: istore 4
    //   153: aload_1
    //   154: ifnull +30 -> 184
    //   157: aload 7
    //   159: astore 6
    //   161: aload_1
    //   162: getstatic 211	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   165: bipush 60
    //   167: aload 7
    //   169: invokevirtual 217	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   172: pop
    //   173: aload 7
    //   175: astore 6
    //   177: aload_1
    //   178: invokevirtual 220	android/graphics/Bitmap:recycle	()V
    //   181: iconst_1
    //   182: istore 4
    //   184: iload 4
    //   186: ifne +99 -> 285
    //   189: aload 7
    //   191: astore 6
    //   193: ldc 50
    //   195: iconst_1
    //   196: ldc 222
    //   198: invokestatic 201	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: aload 7
    //   203: astore 6
    //   205: sipush 4096
    //   208: newarray byte
    //   210: astore_1
    //   211: aload 7
    //   213: astore 6
    //   215: aload_0
    //   216: aload_1
    //   217: invokevirtual 228	java/io/InputStream:read	([B)I
    //   220: istore_2
    //   221: iload_2
    //   222: iconst_m1
    //   223: if_icmpeq +62 -> 285
    //   226: aload 7
    //   228: astore 6
    //   230: aload 7
    //   232: aload_1
    //   233: iconst_0
    //   234: iload_2
    //   235: invokevirtual 232	java/io/ByteArrayOutputStream:write	([BII)V
    //   238: goto -27 -> 211
    //   241: astore_0
    //   242: aload 7
    //   244: astore 6
    //   246: ldc 50
    //   248: iconst_1
    //   249: ldc 234
    //   251: aload_0
    //   252: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   255: aload 7
    //   257: invokestatic 244	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   260: pop
    //   261: aconst_null
    //   262: areturn
    //   263: astore 8
    //   265: aload 7
    //   267: astore 6
    //   269: ldc 50
    //   271: iconst_1
    //   272: ldc 246
    //   274: aload 8
    //   276: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   279: aconst_null
    //   280: astore 8
    //   282: goto -195 -> 87
    //   285: aload 7
    //   287: astore 6
    //   289: aload 7
    //   291: invokevirtual 250	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   294: iconst_2
    //   295: invokestatic 256	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   298: astore_0
    //   299: aload 7
    //   301: invokestatic 244	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   304: pop
    //   305: aload_0
    //   306: areturn
    //   307: astore_0
    //   308: aconst_null
    //   309: astore 7
    //   311: aload 7
    //   313: astore 6
    //   315: ldc 50
    //   317: iconst_1
    //   318: ldc 246
    //   320: aload_0
    //   321: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   324: aload 7
    //   326: invokestatic 244	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   329: pop
    //   330: aconst_null
    //   331: areturn
    //   332: astore_0
    //   333: aconst_null
    //   334: astore 6
    //   336: aload 6
    //   338: invokestatic 244	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   341: pop
    //   342: aload_0
    //   343: athrow
    //   344: astore_0
    //   345: goto -9 -> 336
    //   348: astore_0
    //   349: goto -38 -> 311
    //   352: astore_0
    //   353: aconst_null
    //   354: astore 7
    //   356: goto -114 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	paramInputStream	InputStream
    //   0	359	1	paramOptions	BitmapFactory.Options
    //   0	359	2	paramInt	int
    //   0	359	3	paramBoolean	boolean
    //   40	145	4	i	int
    //   1	149	5	j	int
    //   14	323	6	localByteArrayOutputStream1	ByteArrayOutputStream
    //   10	345	7	localByteArrayOutputStream2	ByteArrayOutputStream
    //   85	58	8	localBitmap	Bitmap
    //   263	12	8	localOutOfMemoryError	OutOfMemoryError
    //   280	1	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	24	241	java/lang/Exception
    //   28	38	241	java/lang/Exception
    //   50	57	241	java/lang/Exception
    //   61	66	241	java/lang/Exception
    //   70	75	241	java/lang/Exception
    //   79	87	241	java/lang/Exception
    //   91	131	241	java/lang/Exception
    //   142	149	241	java/lang/Exception
    //   161	173	241	java/lang/Exception
    //   177	181	241	java/lang/Exception
    //   193	201	241	java/lang/Exception
    //   205	211	241	java/lang/Exception
    //   215	221	241	java/lang/Exception
    //   230	238	241	java/lang/Exception
    //   269	279	241	java/lang/Exception
    //   289	299	241	java/lang/Exception
    //   79	87	263	java/lang/OutOfMemoryError
    //   3	12	307	java/lang/OutOfMemoryError
    //   3	12	332	finally
    //   16	24	344	finally
    //   28	38	344	finally
    //   50	57	344	finally
    //   61	66	344	finally
    //   70	75	344	finally
    //   79	87	344	finally
    //   91	131	344	finally
    //   142	149	344	finally
    //   161	173	344	finally
    //   177	181	344	finally
    //   193	201	344	finally
    //   205	211	344	finally
    //   215	221	344	finally
    //   230	238	344	finally
    //   246	255	344	finally
    //   269	279	344	finally
    //   289	299	344	finally
    //   315	324	344	finally
    //   16	24	348	java/lang/OutOfMemoryError
    //   28	38	348	java/lang/OutOfMemoryError
    //   50	57	348	java/lang/OutOfMemoryError
    //   61	66	348	java/lang/OutOfMemoryError
    //   70	75	348	java/lang/OutOfMemoryError
    //   91	131	348	java/lang/OutOfMemoryError
    //   142	149	348	java/lang/OutOfMemoryError
    //   161	173	348	java/lang/OutOfMemoryError
    //   177	181	348	java/lang/OutOfMemoryError
    //   193	201	348	java/lang/OutOfMemoryError
    //   205	211	348	java/lang/OutOfMemoryError
    //   215	221	348	java/lang/OutOfMemoryError
    //   230	238	348	java/lang/OutOfMemoryError
    //   269	279	348	java/lang/OutOfMemoryError
    //   289	299	348	java/lang/OutOfMemoryError
    //   3	12	352	java/lang/Exception
  }
  
  public static boolean IsSupportImgType(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((!paramString.equalsIgnoreCase("image/jpeg")) && (!paramString.equalsIgnoreCase("image/png")))
      {
        bool1 = bool2;
        if (!paramString.equalsIgnoreCase("image/gif")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static float[] appendGPSInfo(String paramString)
  {
    if (JpegExifReader.isCrashJpeg(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new ExifInterface(paramString);
        float[] arrayOfFloat = new float[2];
        boolean bool = paramString.getLatLong(arrayOfFloat);
        if (bool) {
          return arrayOfFloat;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  /* Error */
  public static boolean compressDynamicAlbumImage(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_1
    //   10: invokestatic 316	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +15 -> 28
    //   16: ldc_w 317
    //   19: iconst_2
    //   20: ldc_w 319
    //   23: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: iconst_0
    //   27: ireturn
    //   28: new 323	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 324	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 10
    //   38: aload 10
    //   40: invokevirtual 328	java/io/File:exists	()Z
    //   43: ifne +15 -> 58
    //   46: ldc_w 317
    //   49: iconst_2
    //   50: ldc_w 330
    //   53: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: iconst_0
    //   57: ireturn
    //   58: aload_1
    //   59: invokestatic 334	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:getImageDegree	(Ljava/lang/String;)I
    //   62: istore 5
    //   64: new 336	java/io/FileInputStream
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 337	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   72: astore 6
    //   74: aload 10
    //   76: invokestatic 343	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   79: aload_0
    //   80: iload_3
    //   81: iload 4
    //   83: invokestatic 347	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:getSizeOpt	(Landroid/net/Uri;Landroid/content/Context;II)Landroid/graphics/BitmapFactory$Options;
    //   86: astore_0
    //   87: new 323	java/io/File
    //   90: dup
    //   91: aload_2
    //   92: invokespecial 324	java/io/File:<init>	(Ljava/lang/String;)V
    //   95: astore_1
    //   96: getstatic 349	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:dirdynamicalbum	Ljava/io/File;
    //   99: invokevirtual 328	java/io/File:exists	()Z
    //   102: ifne +10 -> 112
    //   105: getstatic 349	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:dirdynamicalbum	Ljava/io/File;
    //   108: invokevirtual 352	java/io/File:mkdirs	()Z
    //   111: pop
    //   112: aload_1
    //   113: invokevirtual 328	java/io/File:exists	()Z
    //   116: ifne +8 -> 124
    //   119: aload_1
    //   120: invokevirtual 355	java/io/File:createNewFile	()Z
    //   123: pop
    //   124: new 357	java/io/FileOutputStream
    //   127: dup
    //   128: aload_1
    //   129: invokespecial 360	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   132: astore_1
    //   133: aload_0
    //   134: getfield 143	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   137: iconst_1
    //   138: if_icmpgt +13 -> 151
    //   141: aload_0
    //   142: getfield 146	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   145: invokestatic 150	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:IsSupportImgType	(Ljava/lang/String;)Z
    //   148: ifne +123 -> 271
    //   151: aload_0
    //   152: getstatic 156	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   155: putfield 159	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   158: aload_0
    //   159: iconst_1
    //   160: putfield 162	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   163: aload_0
    //   164: iconst_1
    //   165: putfield 165	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   168: aload 6
    //   170: aconst_null
    //   171: aload_0
    //   172: invokestatic 171	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   175: astore_0
    //   176: aload_0
    //   177: astore_2
    //   178: iload 5
    //   180: ifeq +10 -> 190
    //   183: aload_0
    //   184: iload 5
    //   186: invokestatic 205	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:rotate	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   189: astore_2
    //   190: aload_2
    //   191: ifnull +47 -> 238
    //   194: aload_2
    //   195: getstatic 211	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   198: bipush 60
    //   200: aload_1
    //   201: invokevirtual 217	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   204: pop
    //   205: aload_2
    //   206: invokevirtual 220	android/graphics/Bitmap:recycle	()V
    //   209: aload_1
    //   210: invokevirtual 365	java/io/OutputStream:close	()V
    //   213: aload 6
    //   215: invokevirtual 366	java/io/InputStream:close	()V
    //   218: aload_1
    //   219: ifnull +7 -> 226
    //   222: aload_1
    //   223: invokevirtual 365	java/io/OutputStream:close	()V
    //   226: aload 6
    //   228: ifnull +8 -> 236
    //   231: aload 6
    //   233: invokevirtual 366	java/io/InputStream:close	()V
    //   236: iconst_1
    //   237: ireturn
    //   238: ldc_w 317
    //   241: iconst_2
    //   242: ldc_w 368
    //   245: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: aload_1
    //   249: ifnull +7 -> 256
    //   252: aload_1
    //   253: invokevirtual 365	java/io/OutputStream:close	()V
    //   256: aload 6
    //   258: ifnull -232 -> 26
    //   261: aload 6
    //   263: invokevirtual 366	java/io/InputStream:close	()V
    //   266: iconst_0
    //   267: ireturn
    //   268: astore_0
    //   269: iconst_0
    //   270: ireturn
    //   271: sipush 1024
    //   274: newarray byte
    //   276: astore_0
    //   277: aload 6
    //   279: aload_0
    //   280: invokevirtual 228	java/io/InputStream:read	([B)I
    //   283: istore_3
    //   284: iload_3
    //   285: iconst_m1
    //   286: if_icmpeq -77 -> 209
    //   289: aload_1
    //   290: aload_0
    //   291: iconst_0
    //   292: iload_3
    //   293: invokevirtual 369	java/io/OutputStream:write	([BII)V
    //   296: goto -19 -> 277
    //   299: astore_2
    //   300: aload_1
    //   301: astore_0
    //   302: aload_2
    //   303: astore_1
    //   304: aload_1
    //   305: invokevirtual 372	java/lang/Exception:printStackTrace	()V
    //   308: ldc_w 317
    //   311: iconst_2
    //   312: new 173	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   319: ldc_w 374
    //   322: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_1
    //   326: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_0
    //   336: ifnull +7 -> 343
    //   339: aload_0
    //   340: invokevirtual 365	java/io/OutputStream:close	()V
    //   343: aload 6
    //   345: ifnull -319 -> 26
    //   348: aload 6
    //   350: invokevirtual 366	java/io/InputStream:close	()V
    //   353: iconst_0
    //   354: ireturn
    //   355: astore_0
    //   356: iconst_0
    //   357: ireturn
    //   358: astore_0
    //   359: aconst_null
    //   360: astore_1
    //   361: aload_1
    //   362: ifnull +7 -> 369
    //   365: aload_1
    //   366: invokevirtual 365	java/io/OutputStream:close	()V
    //   369: aload_0
    //   370: athrow
    //   371: astore_1
    //   372: aload 6
    //   374: astore_0
    //   375: aload_1
    //   376: invokevirtual 372	java/lang/Exception:printStackTrace	()V
    //   379: aload_0
    //   380: ifnull +7 -> 387
    //   383: aload_0
    //   384: invokevirtual 366	java/io/InputStream:close	()V
    //   387: ldc_w 317
    //   390: iconst_2
    //   391: ldc_w 379
    //   394: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: iconst_0
    //   398: ireturn
    //   399: astore_0
    //   400: aconst_null
    //   401: astore_1
    //   402: aload_1
    //   403: ifnull +7 -> 410
    //   406: aload_1
    //   407: invokevirtual 366	java/io/InputStream:close	()V
    //   410: aload_0
    //   411: athrow
    //   412: astore_0
    //   413: aload 7
    //   415: astore_0
    //   416: goto -240 -> 176
    //   419: astore_0
    //   420: goto -164 -> 256
    //   423: astore_0
    //   424: goto -198 -> 226
    //   427: astore_0
    //   428: goto -192 -> 236
    //   431: astore_0
    //   432: goto -89 -> 343
    //   435: astore_1
    //   436: goto -67 -> 369
    //   439: astore_0
    //   440: goto -53 -> 387
    //   443: astore_1
    //   444: goto -34 -> 410
    //   447: astore_0
    //   448: aload 6
    //   450: astore_1
    //   451: goto -49 -> 402
    //   454: astore_2
    //   455: aload_0
    //   456: astore_1
    //   457: aload_2
    //   458: astore_0
    //   459: goto -57 -> 402
    //   462: astore_1
    //   463: aload 9
    //   465: astore_0
    //   466: goto -91 -> 375
    //   469: astore_0
    //   470: goto -109 -> 361
    //   473: astore_2
    //   474: aload_0
    //   475: astore_1
    //   476: aload_2
    //   477: astore_0
    //   478: goto -117 -> 361
    //   481: astore_1
    //   482: aload 8
    //   484: astore_0
    //   485: goto -181 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	paramContext	Context
    //   0	488	1	paramString1	String
    //   0	488	2	paramString2	String
    //   0	488	3	paramInt1	int
    //   0	488	4	paramInt2	int
    //   62	123	5	i	int
    //   72	377	6	localFileInputStream	FileInputStream
    //   7	407	7	localObject1	Object
    //   1	482	8	localObject2	Object
    //   4	460	9	localObject3	Object
    //   36	39	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   261	266	268	java/io/IOException
    //   133	151	299	java/lang/Exception
    //   151	168	299	java/lang/Exception
    //   168	176	299	java/lang/Exception
    //   183	190	299	java/lang/Exception
    //   194	209	299	java/lang/Exception
    //   209	218	299	java/lang/Exception
    //   238	248	299	java/lang/Exception
    //   271	277	299	java/lang/Exception
    //   277	284	299	java/lang/Exception
    //   289	296	299	java/lang/Exception
    //   348	353	355	java/io/IOException
    //   96	112	358	finally
    //   112	124	358	finally
    //   124	133	358	finally
    //   74	96	371	java/lang/Exception
    //   222	226	371	java/lang/Exception
    //   252	256	371	java/lang/Exception
    //   339	343	371	java/lang/Exception
    //   365	369	371	java/lang/Exception
    //   369	371	371	java/lang/Exception
    //   64	74	399	finally
    //   168	176	412	java/lang/OutOfMemoryError
    //   252	256	419	java/io/IOException
    //   222	226	423	java/io/IOException
    //   231	236	427	java/io/IOException
    //   339	343	431	java/io/IOException
    //   365	369	435	java/io/IOException
    //   383	387	439	java/io/IOException
    //   406	410	443	java/io/IOException
    //   74	96	447	finally
    //   222	226	447	finally
    //   252	256	447	finally
    //   339	343	447	finally
    //   365	369	447	finally
    //   369	371	447	finally
    //   375	379	454	finally
    //   64	74	462	java/lang/Exception
    //   133	151	469	finally
    //   151	168	469	finally
    //   168	176	469	finally
    //   183	190	469	finally
    //   194	209	469	finally
    //   209	218	469	finally
    //   238	248	469	finally
    //   271	277	469	finally
    //   277	284	469	finally
    //   289	296	469	finally
    //   304	335	473	finally
    //   96	112	481	java/lang/Exception
    //   112	124	481	java/lang/Exception
    //   124	133	481	java/lang/Exception
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
    //   10: invokestatic 384	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:getSizeCrop	(Landroid/net/Uri;Landroid/content/Context;II)Landroid/graphics/BitmapFactory$Options;
    //   13: astore 6
    //   15: aload_0
    //   16: invokevirtual 390	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: aload_1
    //   20: invokevirtual 396	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   23: astore 5
    //   25: aload 5
    //   27: astore_0
    //   28: aload 5
    //   30: aload 6
    //   32: aload_1
    //   33: invokevirtual 399	android/net/Uri:getPath	()Ljava/lang/String;
    //   36: invokestatic 334	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:getImageDegree	(Ljava/lang/String;)I
    //   39: iload 4
    //   41: invokestatic 401	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:CompressImageFile	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;IZ)Ljava/lang/String;
    //   44: astore_1
    //   45: aload 5
    //   47: invokestatic 244	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   50: pop
    //   51: aload_1
    //   52: areturn
    //   53: astore_1
    //   54: aconst_null
    //   55: astore 5
    //   57: aload 5
    //   59: astore_0
    //   60: ldc 50
    //   62: iconst_1
    //   63: new 173	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 403
    //   73: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload 5
    //   88: invokestatic 244	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   91: pop
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore 5
    //   98: aload_0
    //   99: astore_1
    //   100: aload 5
    //   102: invokestatic 244	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   105: pop
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload_0
    //   110: astore 5
    //   112: goto -12 -> 100
    //   115: astore_1
    //   116: goto -59 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramContext	Context
    //   0	119	1	paramUri	Uri
    //   0	119	2	paramInt1	int
    //   0	119	3	paramInt2	int
    //   0	119	4	paramBoolean	boolean
    //   23	88	5	localObject	Object
    //   13	18	6	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   6	25	53	java/lang/Exception
    //   6	25	94	finally
    //   28	45	108	finally
    //   60	86	108	finally
    //   28	45	115	java/lang/Exception
  }
  
  private String convertToJSONInfo(String[] paramArrayOfString)
  {
    QzoneDynamicAlbumPlugin.Size localSize = getBitmapSize(paramArrayOfString[1]);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", "https://www.dynamicalbumlocalimage.com" + paramArrayOfString[1]);
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
    String str1 = paramString;
    if (paramString.startsWith("/")) {}
    try
    {
      str1 = "file:///" + Uri.encode(paramString.substring(1));
      paramString = Uri.parse(str1);
      return compressImageToBase64(BaseApplicationImpl.getContext(), paramString, paramInt1, paramInt2, paramBoolean);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QzoneDynamicAlbumPlugin", 1, "compressImage with some: URL encode failed");
        String str2 = paramString;
      }
    }
  }
  
  private void entryWriteMoodAsync(String paramString)
  {
    for (;;)
    {
      JSONObject localJSONObject;
      int k;
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        JSONArray localJSONArray = paramString.optJSONArray("photoList");
        Object localObject1 = paramString.optJSONObject("data");
        String str1 = paramString.getString("callback");
        localJSONObject = new JSONObject();
        ArrayList localArrayList = new ArrayList();
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          k = 0;
          paramString = null;
          if (k < localJSONArray.length())
          {
            localObject2 = localJSONArray.getJSONObject(k);
            localObject3 = ((JSONObject)localObject2).getString("photoUrl");
            if (localObject3 == null) {
              break label779;
            }
            paramString = ((JSONObject)localObject2).getString("albumId");
            str2 = ((JSONObject)localObject2).getString("photoId");
            int j = -1;
            i = 0;
            if (i < this.mSelectedCloudImageInfos.size())
            {
              if (!((QzonePhotoInfo)this.mSelectedCloudImageInfos.get(i)).mBigUrl.equals(localObject3)) {
                break label776;
              }
              j = i;
              break label782;
            }
            if ((this.isFromAlbum) && (j != -1))
            {
              paramString = new DynamicPhotoData((String)localObject3, ((JSONObject)localObject2).getString("title"), ((JSONObject)localObject2).getString("desc"), ((QzonePhotoInfo)this.mSelectedCloudImageInfos.get(j)).mAlbumId, ((QzonePhotoInfo)this.mSelectedCloudImageInfos.get(j)).mlloc);
              if (paramString == null) {
                break label789;
              }
              localArrayList.add(paramString);
              break label789;
            }
            if ((paramString != null) && (str2 != null))
            {
              paramString = new DynamicPhotoData((String)localObject3, ((JSONObject)localObject2).getString("title"), ((JSONObject)localObject2).getString("desc"), paramString, str2);
              continue;
            }
            paramString = new DynamicPhotoData((String)localObject3, ((JSONObject)localObject2).getString("title"), ((JSONObject)localObject2).getString("desc"));
            continue;
          }
        }
        paramString = ((JSONObject)localObject1).getString("mgz_name");
        Object localObject3 = ((JSONObject)localObject1).getString("mgz_desc");
        String str2 = ((JSONObject)localObject1).getString("tmplt_id");
        String str3 = ((JSONObject)localObject1).getString("music_id");
        String str4 = ((JSONObject)localObject1).getString("lrc_id");
        String str5 = ((JSONObject)localObject1).getString("climax_start");
        String str6 = ((JSONObject)localObject1).getString("climax_endure");
        i = ((JSONObject)localObject1).getInt("isDraft");
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putParcelableArrayList("DYNAMIC_ALBUM_PHOTOLIST", localArrayList);
        ((Bundle)localObject2).putString("mgz_name", paramString);
        ((Bundle)localObject2).putString("mgz_desc", (String)localObject3);
        ((Bundle)localObject2).putString("tmplt_id", str2);
        ((Bundle)localObject2).putString("music_id", str3);
        ((Bundle)localObject2).putString("lrc_id", str4);
        ((Bundle)localObject2).putString("climax_start", str5);
        ((Bundle)localObject2).putString("climax_endure", str6);
        ((Bundle)localObject2).putBoolean("EDIT_IMAGE", false);
        ((Bundle)localObject2).putBoolean("APPEND_IMAGE", false);
        ((Bundle)localObject2).putBoolean("SHOW_RECNET_IMAGE", false);
        ((Bundle)localObject2).putString("shareSource", amtj.a(2131710833));
        if (i == 1)
        {
          ((Bundle)localObject2).putBoolean("dynamic_album_is_from_draft", true);
          localObject3 = QZoneHelper.UserInfo.getInstance();
          ((QZoneHelper.UserInfo)localObject3).qzone_uin = this.parentPlugin.mRuntime.a().getAccount();
          localObject1 = "";
          paramString = (String)localObject1;
          if (localJSONArray != null)
          {
            paramString = (String)localObject1;
            if (localJSONArray.length() > 0) {
              paramString = localJSONArray.getJSONObject(0).getString("photoUrl");
            }
          }
          if ((localArrayList.size() > 0) && (!TextUtils.isEmpty(paramString)))
          {
            localObject1 = paramString;
            if (paramString.startsWith("https://www.dynamicalbumlocalimage.com")) {
              localObject1 = paramString.replace("https://www.dynamicalbumlocalimage.com", "");
            }
            QZoneHelper.forwardToPublishMood(this.parentPlugin.mRuntime.a(), (Bundle)localObject2, (QZoneHelper.UserInfo)localObject3, (String)localObject1, amtj.a(2131710832), null, this.REQUEST_PUBLISH_MOOD);
            QLog.d("QzoneDynamicAlbumPlugin", 4, "entryWriteMoodAsync SUCCESS!");
            localJSONObject.put("code", 0);
            localJSONObject.put("msg", "success");
            this.parentPlugin.callJs(str1, new String[] { localJSONObject.toString() });
          }
        }
        else
        {
          ((Bundle)localObject2).putBoolean("dynamic_album_is_from_draft", false);
          continue;
        }
        QLog.d("QzoneDynamicAlbumPlugin", 4, "entryWriteMoodAsync FAILE");
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      localJSONObject.put("code", -1);
      localJSONObject.put("msg", "fail");
      continue;
      label776:
      break label782;
      label779:
      continue;
      label782:
      i += 1;
      continue;
      label789:
      k += 1;
    }
  }
  
  private void forwardToQzonePhotoPicker(String paramString)
  {
    this.mJSONArgs = paramString;
    try
    {
      this.hasSelectSize = new JSONObject(paramString).optInt("selectedPhotoNum");
      QLog.d("p2vMakeBlog", 1, "hasSelectSize:" + this.hasSelectSize);
      paramString = QZoneHelper.UserInfo.getInstance();
      paramString.qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      Bundle localBundle = new Bundle();
      localBundle.putString("key_album_id", this.mJumpToAlbumID);
      localBundle.putLong("key_album_owner_uin", Long.parseLong(paramString.qzone_uin));
      localBundle.putInt("QZ_ALBUM_THEME", this.mJumpToAlbumTheme);
      localBundle.putInt("key_personal_album_enter_model", 1);
      localBundle.putInt("PhotoConst.from_h5", 1);
      localBundle.putBoolean("key_is_filter_video", true);
      localBundle.putBoolean("key_is_from_make_blog", true);
      localBundle.putInt("has_select_size", this.hasSelectSize);
      int i = QZoneWebViewPlugin.generateRequestCode(this.parentPlugin, this.parentPlugin.mRuntime, 8);
      QZoneHelper.forwardToPersonalPhotoList(this.parentPlugin.mRuntime.a(), paramString, localBundle, i);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("p2vMakeBlog", 1, "json error cmd:" + paramString);
      }
    }
  }
  
  public static QzoneDynamicAlbumPlugin.Size getBitmapSize(String paramString)
  {
    if (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeFile(paramString, localOptions);
      localOptions.inJustDecodeBounds = false;
      return new QzoneDynamicAlbumPlugin.Size(localOptions.outWidth, localOptions.outHeight);
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        QLog.e("QzoneDynamicAlbumPlugin", 1, "getBitmapSize: OutOfMemoryError" + paramString);
      }
    }
  }
  
  private void getBlogCloudPhoto(String paramString)
  {
    for (;;)
    {
      int i;
      Object localObject3;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new JSONObject(paramString).optString("callback");
          if ((this.mSelectedCloudImageInfos == null) || (this.mSelectedCloudImageInfos.size() <= 0)) {
            break label469;
          }
          localObject1 = new JSONArray();
          int j = this.mSelectedCloudImageInfos.size();
          i = 0;
          if (i >= j) {
            break;
          }
          localJSONObject = new JSONObject();
          Object localObject2 = (QzonePhotoInfo)this.mSelectedCloudImageInfos.get(i);
          localObject3 = ((QzonePhotoInfo)localObject2).mAlbumId;
          Object localObject4 = ((QzonePhotoInfo)localObject2).mlloc;
          String str = ((QzonePhotoInfo)localObject2).mBigUrl;
          int k = ((QzonePhotoInfo)localObject2).mBigHeight;
          int m = ((QzonePhotoInfo)localObject2).mBigWidth;
          long l1 = ((QzonePhotoInfo)localObject2).mShootTime;
          long l2 = ((QzonePhotoInfo)localObject2).mUploadTime;
          localJSONObject.put("albumid", localObject3);
          localJSONObject.put("lloc", localObject4);
          localJSONObject.put("url", str);
          localJSONObject.put("height", Integer.valueOf(k));
          localJSONObject.put("width", Integer.valueOf(m));
          localJSONObject.put("shoottime", Long.valueOf(l1));
          localJSONObject.put("uploadtime", Long.valueOf(l2));
          localObject2 = ((QzonePhotoInfo)localObject2).mShouzhang_extend_map;
          if (localObject2 == null) {
            break label337;
          }
          localObject2 = ((Map)localObject2).entrySet().iterator();
          localObject3 = new JSONStringer().object();
          if (((Iterator)localObject2).hasNext())
          {
            localObject4 = (Map.Entry)((Iterator)localObject2).next();
            ((JSONStringer)localObject3).key(String.valueOf(((Map.Entry)localObject4).getKey())).value(((Map.Entry)localObject4).getValue());
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      localJSONObject.put("shouzhang_extend_map", ((JSONStringer)localObject3).endObject());
      label337:
      ((JSONArray)localObject1).put(localJSONObject);
      i += 1;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("photoList", localObject1);
    localJSONObject.put("sorttype", this.mSortType);
    localJSONObject.put("albumtype", this.mJumpToAlbumTheme);
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("data", localJSONObject);
    QZLog.d("QzoneDynamicAlbumPlugin", 2, "json:" + ((JSONObject)localObject1).toString());
    this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
    return;
    label469:
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("code", -1);
    ((JSONObject)localObject1).put("msg", "fail");
    this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
  }
  
  private void getCloudDynamicAlbumImage(Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2 = paramBundle.getParcelableArrayList("param.DynamicCloudPhotolist");
    this.mJumpToAlbumID = paramBundle.getString("key_album_id");
    this.mJumpToAlbumTheme = paramBundle.getInt("QZ_ALBUM_THEME");
    this.mSortType = paramBundle.getInt("QZ_ALBUM_SORT_TYPE");
    this.mSelectedCloudImageInfos = ((List)localObject2);
    if (QLog.isColorLevel()) {
      QLog.i("p2vMakeBlog", 1, "mJumpToAlbumID:" + this.mJumpToAlbumID + " mJumpToAlbumTheme:" + this.mJumpToAlbumTheme + " mSortType:" + this.mSortType);
    }
    if (paramBoolean)
    {
      if (this.mSelectedCloudImageInfos.size() <= 0) {
        break label203;
      }
      localObject2 = ((QzonePhotoInfo)this.mSelectedCloudImageInfos.get(0)).mAlbumId;
      localObject1 = ((QzonePhotoInfo)this.mSelectedCloudImageInfos.get(0)).mlloc;
      paramBundle = ((QzonePhotoInfo)this.mSelectedCloudImageInfos.get(0)).mBigUrl;
    }
    for (;;)
    {
      RemoteHandleManager.getInstance().getSender().uploadFirstDynamicPhoto((String)localObject2, (String)localObject1, paramBundle, this.mSelectedCloudImageInfos.size());
      return;
      label203:
      Object localObject3 = null;
      localObject2 = null;
      paramBundle = (Bundle)localObject1;
      localObject1 = localObject3;
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
  
  public static double getCropRatio(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      paramInputStream.close();
      label27:
      i = localOptions.outWidth;
      j = localOptions.outHeight;
      double d1 = 0.0D;
      if ((paramInt1 != -1) && (paramInt2 != -1))
      {
        d1 = i / paramInt1;
        d2 = j / paramInt2;
        if (d1 > d2) {
          return d1;
        }
      }
    }
    catch (IOException paramInputStream)
    {
      int j;
      do
      {
        int i;
        double d2;
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
        return d2;
        if (paramInt1 != -1) {
          return i / paramInt1;
        }
      } while (paramInt2 == -1);
      return j / paramInt2;
    }
    catch (OutOfMemoryError paramInputStream)
    {
      break label27;
    }
  }
  
  private void getDynamicAlbumImage(List<String> paramList)
  {
    int i = 0;
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin getDynamicAlbumImage " + paramList.size() + " " + (String)paramList.get(0));
      }
      if (mSelectedImageSize != null) {}
    }
    else
    {
      return;
    }
    String[] arrayOfString = new String[paramList.size()];
    while (i < paramList.size()) {
      if (paramList.get(i) == null)
      {
        i += 1;
      }
      else
      {
        Object localObject = (String)paramList.get(i);
        int j = getImageDegree((String)localObject);
        QzoneDynamicAlbumPlugin.Size localSize = getBitmapSize((String)localObject);
        float[] arrayOfFloat = appendGPSInfo((String)localObject);
        double d = getRatio(localSize);
        if (((j == 90) || (j == 270)) && (localSize != null))
        {
          j = localSize.width;
          localSize.width = localSize.height;
          localSize.height = j;
        }
        localObject = new JSONObject();
        arrayOfString[i] = (PHOTO_TMPFILE_PATH_DYNAMIC_ALBUM + (new Date().getTime() + i));
        for (;;)
        {
          try
          {
            ((JSONObject)localObject).put("url", "https://www.dynamicalbumlocalimage.com" + arrayOfString[i]);
            if (localSize != null)
            {
              if (d <= 0.0D) {
                continue;
              }
              ((JSONObject)localObject).put("width", (int)(localSize.width / d));
              ((JSONObject)localObject).put("height", (int)(localSize.height / d));
            }
            if (arrayOfFloat != null)
            {
              ((JSONObject)localObject).put("poiX", arrayOfFloat[1]);
              ((JSONObject)localObject).put("poiY", arrayOfFloat[0]);
              ((JSONObject)localObject).put("poiName", "");
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            continue;
          }
          this.mSelectedImageInfos.add(((JSONObject)localObject).toString());
          break;
          ((JSONObject)localObject).put("width", localSize.width);
          ((JSONObject)localObject).put("height", localSize.height);
        }
      }
    }
    ThreadManager.post(new QzoneDynamicAlbumPlugin.7(this, paramList, arrayOfString), 5, null, true);
  }
  
  public static int[] getDynamicAlbumImageSize()
  {
    int[] arrayOfInt = new int[2];
    int i = QzoneConfig.getInstance().getConfig("MiniVideo", "MinCpu", 1150);
    long l1 = DeviceInfoUtil.getCpuFrequency();
    long l2 = QzoneConfig.getInstance().getConfig("MiniVideo", "MinRam", 700);
    long l3 = DeviceInfoUtil.getSystemTotalMemory() / 1048576L;
    long l4 = QzoneConfig.getInstance().getConfig("MiniVideo", "MinRuntimeRam", 150);
    long l5 = DeviceInfoUtil.getSystemAvaialbeMemory() / 1048576L;
    if (QLog.isColorLevel()) {
      QLog.i("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin freeSizeMB " + l5);
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
    if (QLog.isDevelopLevel()) {
      QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse start :" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return null;
        String str = paramString.replace("https://www.dynamicalbumlocalimage.com", "");
        try
        {
          str = URLDecoder.decode(str, "UTF-8");
          if (QLog.isDevelopLevel()) {
            QLog.i("QzoneDynamicAlbumPlugin", 4, "image filePath :" + str);
          }
          localFile = new File(str);
          if ((currentUrl != null) && (currentUrl.equals("https://h5.qzone.qq.com/dynamic/album/list?_ws&_wv=2098179&_wwv=4&_proxy=1")))
          {
            QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse -  getThumbnail:" + paramString);
            InputStream localInputStream = getThumbnail(str);
            if (localInputStream != null) {
              return new WebResourceResponse("image/*", "utf-8", localInputStream);
            }
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          File localFile;
          Object localObject;
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
            localObject = null;
          }
          if (!localFile.exists())
          {
            if (QLog.isDevelopLevel())
            {
              QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse local file not exists :" + (String)localObject);
              return null;
            }
          }
          else {
            try
            {
              localObject = new FileInputStream((String)localObject);
              if (QLog.isDevelopLevel()) {
                QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse ****************** :" + paramString);
              }
              return new WebResourceResponse("image/*", "utf-8", (InputStream)localObject);
            }
            catch (FileNotFoundException localFileNotFoundException)
            {
              localFileNotFoundException.printStackTrace();
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("QzoneDynamicAlbumPlugin", 2, "getImageResponse get local file fail:" + paramString);
    return null;
  }
  
  public static double getOptRatio(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      paramInputStream.close();
      i = localOptions.outWidth;
      j = localOptions.outHeight;
      if (i < j) {
        if ((j <= paramInt1) && (i <= paramInt2))
        {
          d3 = 0.0D;
          return d3;
        }
      }
    }
    catch (IOException paramInputStream)
    {
      double d3;
      for (;;)
      {
        paramInputStream.printStackTrace();
      }
      double d1;
      if (j > i) {
        d1 = j / paramInt1;
      }
      for (double d2 = i / paramInt2;; d2 = j / paramInt2)
      {
        d3 = d1;
        if (d1 > d2) {
          break;
        }
        return d2;
        d1 = i / paramInt1;
      }
    }
    catch (OutOfMemoryError paramInputStream)
    {
      for (;;)
      {
        continue;
        int k = i;
        int i = j;
        int j = k;
      }
    }
  }
  
  private void getPhotos(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if ((this.mSelectedImageInfos == null) || (this.mSelectedImageInfos.size() <= 0)) {
          break label174;
        }
        localObject1 = new JSONArray();
        localObject2 = this.mSelectedImageInfos.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((JSONArray)localObject1).put(new JSONObject((String)((Iterator)localObject2).next()));
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("photoList", localObject1);
    ((JSONObject)localObject2).put("totalNumPreSelected", this.mSelectedImageInfos.size());
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("code", 0);
    ((JSONObject)localObject1).put("msg", "success");
    ((JSONObject)localObject1).put("data", localObject2);
    this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
    return;
    label174:
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("code", -1);
    ((JSONObject)localObject1).put("msg", "fail");
    this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
  }
  
  public static double getRatio(QzoneDynamicAlbumPlugin.Size paramSize)
  {
    if (mSelectedImageSize == null) {
      mSelectedImageSize = getDynamicAlbumImageSize();
    }
    if (paramSize != null)
    {
      int i = paramSize.width;
      int j = paramSize.height;
      int k;
      if (i < j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        double d3;
        if ((k <= mSelectedImageSize[0]) && (j <= mSelectedImageSize[1]))
        {
          d3 = 0.0D;
          return d3;
        }
        double d1;
        if (k > j) {
          d1 = k / mSelectedImageSize[0];
        }
        for (double d2 = j / mSelectedImageSize[1];; d2 = k / mSelectedImageSize[1])
        {
          d3 = d1;
          if (d1 > d2) {
            break;
          }
          return d2;
          d1 = j / mSelectedImageSize[0];
        }
        k = i;
      }
    }
    return 0.0D;
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
      }
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public static BitmapFactory.Options getSizeCrop(Uri paramUri, Context paramContext, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    InputStream localInputStream = paramContext.getContentResolver().openInputStream(paramUri);
    double d = getCropRatio(localInputStream, paramInt1, paramInt2);
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
      paramUri.close();
      localOptions.inJustDecodeBounds = false;
      return localOptions;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        QLog.e("QzoneDynamicAlbumPlugin", 1, "getSizeCrop" + paramContext);
      }
    }
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
      QLog.e("QzoneDynamicAlbumPlugin", 1, "getThumbnail:outOfMemortError " + paramString);
    }
    return null;
  }
  
  private void isDraftPhotosValid(String paramString)
  {
    int j = 0;
    QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid - start");
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject1 = paramString.getJSONArray("photosPath");
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getString(i);
          if (!((String)localObject2).startsWith("https://www.dynamicalbumlocalimage.com")) {
            break label212;
          }
          localObject2 = new File(((String)localObject2).replace("https://www.dynamicalbumlocalimage.com", ""));
          QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid - isValid:true");
          if (((File)localObject2).exists()) {
            break label212;
          }
          i = j;
          paramString = paramString.getString("callback");
          localObject1 = new JSONObject();
          if (i != 0)
          {
            QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid SUCCESS!");
            ((JSONObject)localObject1).put("code", 0);
            ((JSONObject)localObject1).put("msg", "success");
            this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
            return;
          }
          QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid FAILE");
          ((JSONObject)localObject1).put("code", -1);
          ((JSONObject)localObject1).put("msg", "fail");
          continue;
        }
        i = 1;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      continue;
      label212:
      i += 1;
    }
  }
  
  private void pickDynamicAlbumImage(ArrayList<String> paramArrayList)
  {
    QLog.d("QzoneDynamicAlbumPlugin", 4, "pickDynamicAlbumImage start!");
    if (paramArrayList != null) {}
    for (int i = paramArrayList.size();; i = 0)
    {
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
      return;
    }
  }
  
  private void pickPhoto(String paramString)
  {
    try
    {
      this.toPickPhoto = true;
      this.mJSONArgs = paramString;
      int i = new JSONObject(paramString).optInt("maxSelectNum");
      paramString = new Intent(this.parentPlugin.mRuntime.a(), NewPhotoListActivity.class);
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("PhotoConst.MAXUM_SELECTED_NUM", i);
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_MODE", false);
      paramString.putExtra("PhotoConst.IS_FROM_DYNAMIC_ALBUM", true);
      paramString.putExtra("PhotoConst.IS_NO_PANORAMA", true);
      paramString.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Bundle)localObject).putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      ((Bundle)localObject).putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Bundle)localObject).putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      ((Bundle)localObject).putInt("uintype", 0);
      paramString.putExtras((Bundle)localObject);
      QZoneHelper.addSource(paramString);
      localObject = this.parentPlugin.mRuntime.a();
      if (localObject != null)
      {
        ((WebViewFragment)localObject).gotoSelectPicture(this.parentPlugin, paramString, this.REQUEST_PICK_PHOTO);
        return;
      }
      ((AbsBaseWebViewActivity)this.parentPlugin.mRuntime.a()).a(this.parentPlugin, paramString, this.REQUEST_PICK_PHOTO);
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
      autj.a(true, this.parentPlugin.mRuntime.a(), false);
      return;
    }
    autj.a(false, this.parentPlugin.mRuntime.a(), false);
    ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(null);
  }
  
  private void requestPlayMusic(String paramString)
  {
    try
    {
      QZLog.d("dynamic.Album", 2, "requestPlayMusic start:" + paramString + ";isChating:" + this.isChating);
      Object localObject = new JSONObject();
      if (this.isChating)
      {
        ((JSONObject)localObject).put("isCanPlayMusic", "false");
        this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      ((JSONObject)localObject).put("isCanPlayMusic", "true");
      this.parentPlugin.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      localObject = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
      if (localObject != null)
      {
        ((AudioManager)localObject).requestAudioFocus(null, 3, 1);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      QZLog.e("dynamic.Album", 2, new Object[] { "requestPlayMusic get jsonException, cmd:" + paramString });
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      QZLog.d("dynamic.Album", 2, "requestPlayMusic get an Exception, cmd:" + paramString);
      localException.printStackTrace();
    }
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
    QLog.d("QzoneDynamicAlbumPlugin", 2, "sendBlogCLoudPhotoToH5 | mJSONArgs:" + this.mJSONArgs);
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
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject1).getString("callback");
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = ((JSONObject)localObject1).optJSONArray("photoList");
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).get(i);
            if ((localObject2 == null) || (!(localObject2 instanceof String))) {
              break label252;
            }
            localObject2 = (String)localObject2;
            if (!((String)localObject2).startsWith("https://www.dynamicalbumlocalimage.com")) {
              break label252;
            }
            localObject2 = ((String)localObject2).replace("https://www.dynamicalbumlocalimage.com", "");
            Object localObject3 = getBitmapSize((String)localObject2);
            if (localObject3 == null) {
              return;
            }
            localObject2 = encodeBase64File((String)localObject2, ((QzoneDynamicAlbumPlugin.Size)localObject3).width, ((QzoneDynamicAlbumPlugin.Size)localObject3).height);
            if (!TextUtils.isEmpty((CharSequence)localObject2))
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
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label252:
      i += 1;
    }
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if ((paramLong == 8L) && (paramString.startsWith("https://www.dynamicalbumlocalimage.com")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin getImageResponse " + paramString);
      }
      return getImageResponse(paramString);
    }
    return super.handleEvent(paramString, paramLong);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    int i;
    Object localObject;
    int j;
    if ((paramLong == 8589934600L) && ((Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.REQUEST_PICK_PHOTO) || (Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.REQUEST_PUBLISH_MOOD)))
    {
      i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      localObject = (Intent)paramMap.get("data");
      j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if (i != this.REQUEST_PICK_PHOTO) {
        break label178;
      }
      if (j != -1) {
        break label169;
      }
      pickDynamicAlbumImage(((Intent)localObject).getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("qzone.qq.com/dynamic")))
      {
        return super.handleEvent(paramString, paramLong, paramMap);
        label169:
        sendPhotoData(null, 0);
        continue;
        label178:
        if ((i != this.REQUEST_PUBLISH_MOOD) || (j != -1)) {
          continue;
        }
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
          if ((this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null)) {
            this.parentPlugin.mRuntime.a().finish();
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
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
    for (;;)
    {
      return super.handleEvent(paramString, paramLong, paramMap);
      if (paramLong == 8589934597L) {
        this.isResume = false;
      } else if (paramLong == 8589934608L) {
        notifyVolumeChange("qbrowserVolumeChange", 2);
      } else if (paramLong == 8589934609L) {
        notifyVolumeChange("qbrowserVolumeChange", 1);
      } else if ((paramLong == 8589934601L) && (paramString.contains("qzone.qq.com/dynamic/album/preview"))) {
        RemoteHandleManager.getInstance().getSender().deletePrePostDynamicAlbum();
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (((!paramString2.equals("qzDynamicAlbum")) && (!paramString2.equals("Qzone"))) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {
      return false;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    for (paramJsBridgeListener = "" + paramJsBridgeListener.a;; paramJsBridgeListener = paramVarArgs[0])
    {
      QLog.d("QzoneDynamicAlbumPlugin", 4, "NAMESPACE = " + paramString2 + ";method = " + paramString3 + ";args = " + paramJsBridgeListener);
      if (!"deletePhotos".equals(paramString3)) {
        break;
      }
      deletePhotos(paramJsBridgeListener);
      return true;
    }
    if ("saveDynamicAlbum".equals(paramString3)) {
      return true;
    }
    if ("getPhotos".equals(paramString3))
    {
      QZLog.d("dynamic.Album", 4, "handleJsRequest - getPhotos - isFromAlbum:" + this.isFromAlbum);
      if (this.isFromAlbum) {
        getCloudPhotos(paramJsBridgeListener);
      }
      for (;;)
      {
        return true;
        getPhotos(paramJsBridgeListener);
      }
    }
    if ("getBlogCloudPhotoUrls".equals(paramString3))
    {
      getBlogCloudPhoto(paramJsBridgeListener);
      return true;
    }
    if ("getCloudPhotoUrl".equals(paramString3)) {
      getCloudPhotos(paramJsBridgeListener);
    }
    do
    {
      for (;;)
      {
        return false;
        if ("dynamicSendSuccess".equals(paramString3))
        {
          sendCloudDynmicPhotoSuccess();
        }
        else
        {
          if (!"isDraftPhotosValid".equals(paramString3)) {
            break;
          }
          isDraftPhotosValid(paramJsBridgeListener);
        }
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
    } while (!"setDynamicAlbumData".equals(paramString3));
    setDynamicAlbumData(paramJsBridgeListener);
    return true;
  }
  
  public void initRuntime(WebViewPlugin paramWebViewPlugin)
  {
    super.initRuntime(paramWebViewPlugin);
    if ((paramWebViewPlugin == null) || (paramWebViewPlugin.mRuntime == null) || (!(paramWebViewPlugin.mRuntime.a() instanceof QQBrowserActivity))) {
      return;
    }
    if (paramWebViewPlugin.mRuntime.a() != null) {}
    for (Object localObject = paramWebViewPlugin.mRuntime.a().mUrl;; localObject = "")
    {
      currentUrl = (String)localObject;
      if ((TextUtils.isEmpty(currentUrl)) || ((!currentUrl.contains("qzone.qq.com/dynamic")) && (!currentUrl.contains("blog")))) {
        break;
      }
      if (dirdynamicalbum == null) {
        dirdynamicalbum = new File(PHOTO_TMPFILE_PATH_DYNAMIC_ALBUM);
      }
      if (this.ispreSelloaded) {
        break;
      }
      this.ispreSelloaded = true;
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.process.stopping");
      ((IntentFilter)localObject).addAction("com.tencent.process.starting");
      ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
      ((IntentFilter)localObject).addAction("tencent.av.v2q.StopVideoChat");
      paramWebViewPlugin.mRuntime.a().registerReceiver(this.notifyReceiver, (IntentFilter)localObject);
      RemoteHandleManager.getInstance().addWebEventListener(this);
      paramWebViewPlugin.mRuntime.a().getHandler(QzoneDynamicAlbumPlugin.class).post(new QzoneDynamicAlbumPlugin.1(this));
      return;
    }
  }
  
  public void notifyVolumeChange(String paramString, int paramInt)
  {
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    int i = localAudioManager.getStreamMaxVolume(3);
    int j = localAudioManager.getStreamVolume(3);
    if (localAudioManager.getRingerMode() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (!TextUtils.isEmpty(paramString)) {
        paramString = new JSONObject();
      }
      try
      {
        paramString.put("type", paramInt);
        paramString.put("isMute", bool);
        paramString.put("maxVolume", i);
        paramString.put("currentVolume", j);
        this.parentPlugin.dispatchJsEvent("qbrowserVolumeChange", paramString, paramString);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == this.REQUEST_PICK_PHOTO)
    {
      this.toPickPhoto = false;
      if (paramInt == -1) {
        pickDynamicAlbumImage(paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
      }
    }
    while (paramByte != 8)
    {
      return;
      sendPhotoData(null, 0);
      return;
    }
    sendBlogCLoudPhotoToH5(paramIntent);
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
    autj.a(false, this.parentPlugin.mRuntime.a(), false);
    try
    {
      this.parentPlugin.mRuntime.a().unregisterReceiver(this.notifyReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneDynamicAlbumPlugin", 2, "unregiser fail");
    }
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    QZLog.d("dynamic.Album", 4, "onWebEvent: event - " + paramString);
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      if (paramString.equals("cmd.getDynamicPhoto"))
      {
        this.isFromAlbum = paramBundle.getBoolean("param.DynamicIsFromAlbum", false);
        boolean bool = paramBundle.getBoolean("param.DynamicIsFromMakeBlog", false);
        this.isFromAlbumSharePanel = paramBundle.getBoolean("param.DynamicIsFromAlbumSharePanel", false);
        QZLog.d("dynamic.Album", 4, "onWebEvent - getBoolean - isFromAlbum:" + this.isFromAlbum + " isFromMakeBlog:" + bool);
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
    } while (!paramString.equals("cmd.getDynamicCloudPhoto"));
    getCloudDynamicAlbumImage(paramBundle, false);
  }
  
  public void sendPhotoData(List<String> paramList, int paramInt)
  {
    String str;
    try
    {
      if (TextUtils.isEmpty(this.mJSONArgs)) {
        return;
      }
      str = new JSONObject(this.mJSONArgs).optString("callback");
      if (TextUtils.isEmpty(str)) {
        return;
      }
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label193;
      }
      localObject = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((JSONArray)localObject).put(new JSONObject((String)paramList.next()));
      }
      paramList = new JSONObject();
    }
    catch (JSONException paramList)
    {
      paramList.printStackTrace();
      return;
    }
    paramList.put("photoList", localObject);
    paramList.put("totalNumPreSelected", paramInt);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("code", 0);
    ((JSONObject)localObject).put("msg", "success");
    ((JSONObject)localObject).put("data", paramList);
    this.parentPlugin.callJs(str, new String[] { ((JSONObject)localObject).toString() });
    return;
    label193:
    paramList = new JSONObject();
    paramList.put("code", -1);
    paramList.put("msg", "fail");
    this.parentPlugin.callJs(str, new String[] { paramList.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin
 * JD-Core Version:    0.7.0.1
 */