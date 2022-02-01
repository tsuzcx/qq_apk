package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import amtj;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import bbws;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.sdk.BridgeInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ypi;

public class VideoJsPlugin
  extends BaseJsPlugin
{
  public static final String ACTION_GET_VIDEO_INFO = "get_video_info";
  public static final String SP_VIDEO_PATH = "miniapp_video_path";
  private static final String TAG = "VideoJsPlugin";
  private static final boolean USE_NATIVE_CAMERA_FLAG = true;
  private static final ExecutorService copyExecutor = Executors.newFixedThreadPool(5);
  private static final ExecutorService executor;
  private static AtomicBoolean isDownloadFFmpeg = new AtomicBoolean(false);
  private static volatile boolean isFFmpegReady;
  private static final Pattern timePattern = Pattern.compile("(?<=time=)[\\d:.]*");
  private String FFMPEG_ADDITIONAL_PARAM = QzoneConfig.getInstance().getConfig("qqminiapp", "miniFfmpegVideoCompressParam", "-profile:v main -crf 29");
  private ConcurrentHashMap<Integer, BridgeInfo> bridgeMap;
  private long chooseVideoMaxDuration = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxDuration", 600000L);
  private long chooseVideoMaxSize = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxSize", 1610612736L);
  private Set<String> eventMap = new HashSet();
  private FFmpeg ffmpeg;
  private Activity mActivity;
  private BroadcastReceiver mAvatarReceiver = new VideoJsPlugin.3(this);
  private boolean mAvatarReceiverRegistered;
  private int mCallBackId = -1;
  private String sourceTypeAlbum = "album";
  private String sourceTypeCamera = "camera";
  private boolean waitForResult;
  
  static
  {
    executor = Executors.newSingleThreadExecutor();
  }
  
  public VideoJsPlugin()
  {
    this.eventMap.add("chooseVideo");
    this.eventMap.add("saveVideoToPhotosAlbum");
    loadFFmpeg();
  }
  
  private File createVideoFile(Context paramContext)
  {
    try
    {
      paramContext = File.createTempFile("MP4_" + System.currentTimeMillis() + "_", ".mp4", paramContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QLog.e("VideoJsPlugin", 1, "createVideoFile: ", paramContext);
    }
    return null;
  }
  
  private void execCommand(String paramString1, String paramString2, LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    if (this.ffmpeg == null) {
      this.ffmpeg = FFmpeg.getInstance(BaseApplicationImpl.getApplication());
    }
    AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.g().getCurrentAppBrandRuntime();
    if (localAppBrandRuntime != null) {
      showLoading(localAppBrandRuntime, amtj.a(2131715310));
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramLocalMediaInfo.mDuration;
    QLog.i("VideoJsPlugin", 2, "execCommand: " + paramString1 + " " + l1);
    try
    {
      String[] arrayOfString = paramString1.split(" ");
      this.ffmpeg.execute(arrayOfString, new VideoJsPlugin.6(this, l1, paramString1, paramLocalMediaInfo, paramInt, paramString2, l2, localAppBrandRuntime));
      return;
    }
    catch (Exception paramString2)
    {
      do
      {
        QLog.w("VideoJsPlugin", 1, "execCommand: failed " + paramString1, paramString2);
      } while (localAppBrandRuntime == null);
      hideLoading(localAppBrandRuntime);
    }
  }
  
  public static int getAndSelectVideoTrackIndex(MediaExtractor paramMediaExtractor)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        int i = 0;
        while (i < paramMediaExtractor.getTrackCount())
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoJsPlugin", 2, "format for track " + i + " is " + paramMediaExtractor.getTrackFormat(i).getString("mime"));
          }
          if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/"))
          {
            paramMediaExtractor.selectTrack(i);
            return i;
          }
          i += 1;
        }
      }
      return -1;
    }
    catch (Exception paramMediaExtractor) {}
  }
  
  private String getSaveVideoFilePath()
  {
    return ShortVideoUtils.getCameraPath() + "QQMiniApp" + System.currentTimeMillis() + "_.mp4";
  }
  
  private Bitmap getThumbnailBitmap(String paramString)
  {
    Bitmap localBitmap = null;
    if (!TextUtils.isEmpty(paramString)) {
      localBitmap = ShortVideoUtils.getVideoThumbnail(null, MiniAppFileManager.getInstance().getAbsolutePath(paramString));
    }
    return localBitmap;
  }
  
  private void goToCamera(Activity paramActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    goToNativeCamera(paramActivity, paramInt, paramBoolean1, paramBoolean2);
  }
  
  private void goToNativeCamera(Activity paramActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    Intent localIntent;
    File localFile;
    do
    {
      do
      {
        return;
        localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
      } while (localIntent.resolveActivity(paramActivity.getPackageManager()) == null);
      localFile = createVideoFile(paramActivity);
    } while (localFile == null);
    MiniAppController.getInstance().setActivityResultListener(new VideoJsPlugin.11(this, localFile, paramBoolean1));
    localIntent.putExtra("output", FileProvider7Helper.getUriForFile(paramActivity, localFile));
    int i;
    if (paramInt >= 1)
    {
      i = paramInt;
      if (paramInt <= 60000) {}
    }
    else
    {
      i = 60000;
    }
    localIntent.putExtra("android.intent.extra.durationLimit", i);
    if (paramBoolean2) {
      localIntent.putExtra("android.intent.extras.CAMERA_FACING", 1);
    }
    localIntent.putExtra("big_brother_source_key", "biz_src_miniapp");
    paramActivity.startActivityForResult(localIntent, 2);
  }
  
  private void goToPic(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    this.waitForResult = true;
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 4);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localIntent.putExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME", "get_video_info");
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", this.chooseVideoMaxDuration);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", this.chooseVideoMaxSize);
    if (paramBoolean) {
      localIntent.putExtra("PhotoConst.DEST_OTHER_FLAG", "compress");
    }
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
    paramActivity.startActivity(localIntent);
    AlbumUtil.anim(paramActivity, false, true);
  }
  
  private void handleJsCallBack(String paramString, long paramLong, LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tempFilePath", paramString);
      localJSONObject.put("thumbTempFilePath", paramLocalMediaInfo.thumbnailPath);
      localJSONObject.put("duration", Math.round((float)(paramLocalMediaInfo.mDuration / 1000L)));
      localJSONObject.put("size", paramLong);
      localJSONObject.put("height", paramLocalMediaInfo.mediaHeight);
      localJSONObject.put("width", paramLocalMediaInfo.mediaWidth);
      localJSONObject.put("__plugin_ready__", new File(bbws.a(MobileQQ.getContext())).exists());
      handleNativeResponseOk(paramInt, "chooseVideo", localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      handleNativeResponseFail(paramInt, "chooseVideo", null, "");
    }
  }
  
  private void handleNativeResponseCancel(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.bridgeMap != null)
    {
      BridgeInfo localBridgeInfo = (BridgeInfo)this.bridgeMap.remove(Integer.valueOf(paramInt));
      if ((localBridgeInfo != null) && (this.jsPluginEngine != null)) {
        this.jsPluginEngine.callbackJsEventCancel(localBridgeInfo.getWebView(), paramString, paramJSONObject, localBridgeInfo.callbackId);
      }
    }
  }
  
  private void handleNativeResponseFail(int paramInt, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (this.bridgeMap != null)
    {
      BridgeInfo localBridgeInfo = (BridgeInfo)this.bridgeMap.remove(Integer.valueOf(paramInt));
      if ((localBridgeInfo != null) && (this.jsPluginEngine != null)) {
        this.jsPluginEngine.callbackJsEventFail(localBridgeInfo.getWebView(), paramString1, paramJSONObject, paramString2, localBridgeInfo.callbackId);
      }
    }
  }
  
  private void handleNativeResponseOk(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.bridgeMap != null)
    {
      BridgeInfo localBridgeInfo = (BridgeInfo)this.bridgeMap.remove(Integer.valueOf(paramInt));
      if ((localBridgeInfo != null) && (this.jsPluginEngine != null)) {
        this.jsPluginEngine.callbackJsEventOK(localBridgeInfo.getWebView(), paramString, paramJSONObject, localBridgeInfo.callbackId);
      }
    }
  }
  
  /* Error */
  private void handleVideoResult(File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 363	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 16
    //   5: if_icmpge +4 -> 9
    //   8: return
    //   9: new 662	java/io/FileInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 665	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore 6
    //   19: new 365	android/media/MediaExtractor
    //   22: dup
    //   23: invokespecial 666	android/media/MediaExtractor:<init>	()V
    //   26: astore 5
    //   28: aload 6
    //   30: astore 8
    //   32: aload 5
    //   34: astore 7
    //   36: aload 5
    //   38: aload 6
    //   40: invokevirtual 670	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   43: invokevirtual 674	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   46: aload 6
    //   48: astore 8
    //   50: aload 5
    //   52: astore 7
    //   54: aload 5
    //   56: invokestatic 676	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VideoJsPlugin:getAndSelectVideoTrackIndex	(Landroid/media/MediaExtractor;)I
    //   59: istore_3
    //   60: iload_3
    //   61: iconst_m1
    //   62: if_icmple +457 -> 519
    //   65: aload 6
    //   67: astore 8
    //   69: aload 5
    //   71: astore 7
    //   73: aload 5
    //   75: iload_3
    //   76: invokevirtual 384	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   79: astore 9
    //   81: aload 6
    //   83: astore 8
    //   85: aload 5
    //   87: astore 7
    //   89: new 325	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   92: dup
    //   93: invokespecial 677	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   96: astore 4
    //   98: iconst_0
    //   99: istore_3
    //   100: aload 6
    //   102: astore 8
    //   104: aload 5
    //   106: astore 7
    //   108: aload 9
    //   110: ldc_w 679
    //   113: invokevirtual 682	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   116: ifeq +408 -> 524
    //   119: aload 6
    //   121: astore 8
    //   123: aload 5
    //   125: astore 7
    //   127: aload 9
    //   129: ldc_w 679
    //   132: invokevirtual 686	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   135: istore_3
    //   136: goto +388 -> 524
    //   139: aload 6
    //   141: astore 8
    //   143: aload 5
    //   145: astore 7
    //   147: aload 4
    //   149: aload 9
    //   151: ldc_w 578
    //   154: invokevirtual 686	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   157: putfield 586	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   160: aload 6
    //   162: astore 8
    //   164: aload 5
    //   166: astore 7
    //   168: aload 4
    //   170: aload 9
    //   172: ldc_w 583
    //   175: invokevirtual 686	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   178: putfield 581	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   181: aload 6
    //   183: astore 8
    //   185: aload 5
    //   187: astore 7
    //   189: aload 4
    //   191: aload 9
    //   193: ldc_w 688
    //   196: invokevirtual 692	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   199: l2d
    //   200: ldc2_w 693
    //   203: ddiv
    //   204: invokestatic 697	java/lang/Math:round	(D)J
    //   207: putfield 328	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   210: aload 6
    //   212: astore 8
    //   214: aload 5
    //   216: astore 7
    //   218: aload 4
    //   220: aload_1
    //   221: invokevirtual 699	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   224: putfield 702	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   227: aload 6
    //   229: astore 8
    //   231: aload 5
    //   233: astore 7
    //   235: aload 4
    //   237: aload_1
    //   238: invokevirtual 705	java/io/File:length	()J
    //   241: putfield 708	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   244: aload 4
    //   246: astore_1
    //   247: aload 6
    //   249: ifnull +8 -> 257
    //   252: aload 6
    //   254: invokevirtual 711	java/io/FileInputStream:close	()V
    //   257: aload_1
    //   258: astore 4
    //   260: aload 5
    //   262: ifnull +11 -> 273
    //   265: aload 5
    //   267: invokevirtual 714	android/media/MediaExtractor:release	()V
    //   270: aload_1
    //   271: astore 4
    //   273: aload 4
    //   275: ifnonnull +149 -> 424
    //   278: aload_0
    //   279: aload_0
    //   280: getfield 86	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VideoJsPlugin:mCallBackId	I
    //   283: ldc 141
    //   285: aconst_null
    //   286: ldc_w 614
    //   289: invokespecial 618	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VideoJsPlugin:handleNativeResponseFail	(ILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   292: return
    //   293: aload 6
    //   295: astore 8
    //   297: aload 5
    //   299: astore 7
    //   301: aload 4
    //   303: aload 9
    //   305: ldc_w 583
    //   308: invokevirtual 686	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   311: putfield 586	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   314: aload 6
    //   316: astore 8
    //   318: aload 5
    //   320: astore 7
    //   322: aload 4
    //   324: aload 9
    //   326: ldc_w 578
    //   329: invokevirtual 686	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   332: putfield 581	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   335: goto -154 -> 181
    //   338: astore 7
    //   340: aload 4
    //   342: astore_1
    //   343: aload 7
    //   345: astore 4
    //   347: aload 6
    //   349: astore 8
    //   351: aload 5
    //   353: astore 7
    //   355: ldc 14
    //   357: iconst_1
    //   358: ldc_w 716
    //   361: aload 4
    //   363: invokestatic 356	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   366: aload 6
    //   368: ifnull +8 -> 376
    //   371: aload 6
    //   373: invokevirtual 711	java/io/FileInputStream:close	()V
    //   376: aload_1
    //   377: astore 4
    //   379: aload 5
    //   381: ifnull -108 -> 273
    //   384: aload 5
    //   386: invokevirtual 714	android/media/MediaExtractor:release	()V
    //   389: aload_1
    //   390: astore 4
    //   392: goto -119 -> 273
    //   395: astore_1
    //   396: aconst_null
    //   397: astore 6
    //   399: aconst_null
    //   400: astore 7
    //   402: aload 6
    //   404: ifnull +8 -> 412
    //   407: aload 6
    //   409: invokevirtual 711	java/io/FileInputStream:close	()V
    //   412: aload 7
    //   414: ifnull +8 -> 422
    //   417: aload 7
    //   419: invokevirtual 714	android/media/MediaExtractor:release	()V
    //   422: aload_1
    //   423: athrow
    //   424: iload_2
    //   425: ifeq +11 -> 436
    //   428: aload_0
    //   429: aload 4
    //   431: iconst_1
    //   432: invokespecial 222	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VideoJsPlugin:startCompress	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Z)V
    //   435: return
    //   436: aload_0
    //   437: invokestatic 426	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   440: aload 4
    //   442: getfield 702	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   445: invokevirtual 719	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getWxFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   448: aload 4
    //   450: getfield 708	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   453: aload 4
    //   455: invokespecial 228	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VideoJsPlugin:respGetVideo	(Ljava/lang/String;JLcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   458: return
    //   459: astore 4
    //   461: goto -204 -> 257
    //   464: astore 4
    //   466: goto -90 -> 376
    //   469: astore 4
    //   471: goto -59 -> 412
    //   474: astore_1
    //   475: aconst_null
    //   476: astore 7
    //   478: goto -76 -> 402
    //   481: astore_1
    //   482: aload 8
    //   484: astore 6
    //   486: goto -84 -> 402
    //   489: astore 4
    //   491: aconst_null
    //   492: astore 6
    //   494: aconst_null
    //   495: astore 5
    //   497: aconst_null
    //   498: astore_1
    //   499: goto -152 -> 347
    //   502: astore 4
    //   504: aconst_null
    //   505: astore 5
    //   507: aconst_null
    //   508: astore_1
    //   509: goto -162 -> 347
    //   512: astore 4
    //   514: aconst_null
    //   515: astore_1
    //   516: goto -169 -> 347
    //   519: aconst_null
    //   520: astore_1
    //   521: goto -274 -> 247
    //   524: iload_3
    //   525: bipush 90
    //   527: if_icmpeq -388 -> 139
    //   530: iload_3
    //   531: sipush 270
    //   534: if_icmpne -241 -> 293
    //   537: goto -398 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	540	0	this	VideoJsPlugin
    //   0	540	1	paramFile	File
    //   0	540	2	paramBoolean	boolean
    //   59	476	3	i	int
    //   96	358	4	localObject1	Object
    //   459	1	4	localIOException1	java.io.IOException
    //   464	1	4	localIOException2	java.io.IOException
    //   469	1	4	localIOException3	java.io.IOException
    //   489	1	4	localIOException4	java.io.IOException
    //   502	1	4	localIOException5	java.io.IOException
    //   512	1	4	localIOException6	java.io.IOException
    //   26	480	5	localMediaExtractor1	MediaExtractor
    //   17	476	6	localObject2	Object
    //   34	287	7	localMediaExtractor2	MediaExtractor
    //   338	6	7	localIOException7	java.io.IOException
    //   353	124	7	localMediaExtractor3	MediaExtractor
    //   30	453	8	localObject3	Object
    //   79	246	9	localMediaFormat	MediaFormat
    // Exception table:
    //   from	to	target	type
    //   108	119	338	java/io/IOException
    //   127	136	338	java/io/IOException
    //   147	160	338	java/io/IOException
    //   168	181	338	java/io/IOException
    //   189	210	338	java/io/IOException
    //   218	227	338	java/io/IOException
    //   235	244	338	java/io/IOException
    //   301	314	338	java/io/IOException
    //   322	335	338	java/io/IOException
    //   9	19	395	finally
    //   252	257	459	java/io/IOException
    //   371	376	464	java/io/IOException
    //   407	412	469	java/io/IOException
    //   19	28	474	finally
    //   36	46	481	finally
    //   54	60	481	finally
    //   73	81	481	finally
    //   89	98	481	finally
    //   108	119	481	finally
    //   127	136	481	finally
    //   147	160	481	finally
    //   168	181	481	finally
    //   189	210	481	finally
    //   218	227	481	finally
    //   235	244	481	finally
    //   301	314	481	finally
    //   322	335	481	finally
    //   355	366	481	finally
    //   9	19	489	java/io/IOException
    //   19	28	502	java/io/IOException
    //   36	46	512	java/io/IOException
    //   54	60	512	java/io/IOException
    //   73	81	512	java/io/IOException
    //   89	98	512	java/io/IOException
  }
  
  private void hideLoading(AppBrandRuntime paramAppBrandRuntime)
  {
    AppBrandTask.runTaskOnUiThread(new VideoJsPlugin.9(this, paramAppBrandRuntime));
  }
  
  private static void loadFFmpeg()
  {
    if (isFFmpegReady) {
      return;
    }
    int i = VideoEnvironment.loadAVCodecSo("AVCodec", MobileQQ.sMobileQQ.getApplicationContext());
    QLog.i("VideoJsPlugin", 1, "loadFFmpeg: " + i);
    if (i == 0)
    {
      QLog.i("VideoJsPlugin", 1, "loadFFmpeg: is already load");
      isFFmpegReady = true;
      return;
    }
    if (!isDownloadFFmpeg.compareAndSet(false, true))
    {
      QLog.i("VideoJsPlugin", 1, "loadFFmpeg: is downloading already");
      return;
    }
    executor.execute(new VideoJsPlugin.1());
  }
  
  private void registerAvatarReceiver(Activity paramActivity)
  {
    if (!this.mAvatarReceiverRegistered)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoJsPlugin", 2, "registerAvatarReceiver");
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("get_video_info");
      paramActivity.registerReceiver(this.mAvatarReceiver, localIntentFilter);
      this.mAvatarReceiverRegistered = true;
    }
  }
  
  private void respGetVideo(String paramString, long paramLong, LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null)
    {
      handleNativeResponseCancel(this.mCallBackId, "chooseVideo", null);
      return;
    }
    if (!TextUtils.isEmpty(paramLocalMediaInfo.thumbnailPath))
    {
      handleJsCallBack(paramString, paramLong, paramLocalMediaInfo, this.mCallBackId);
      return;
    }
    int i = this.mCallBackId;
    ThreadManager.getFileThreadHandler().post(new VideoJsPlugin.4(this, paramString, paramLocalMediaInfo, paramLong, i));
  }
  
  /* Error */
  private boolean saveThumbnail(Bitmap paramBitmap, LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: iconst_0
    //   7: istore_3
    //   8: aload_1
    //   9: ifnonnull +14 -> 23
    //   12: ldc 14
    //   14: iconst_2
    //   15: ldc_w 796
    //   18: invokestatic 798	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: iload_3
    //   22: ireturn
    //   23: aload_2
    //   24: ifnonnull +14 -> 38
    //   27: ldc 14
    //   29: iconst_2
    //   30: ldc_w 800
    //   33: invokestatic 798	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: iconst_0
    //   37: ireturn
    //   38: invokestatic 426	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   41: ldc_w 802
    //   44: invokevirtual 805	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 6
    //   49: new 277	java/io/File
    //   52: dup
    //   53: aload 6
    //   55: invokespecial 600	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 11
    //   60: aload 11
    //   62: invokevirtual 603	java/io/File:exists	()Z
    //   65: ifeq +9 -> 74
    //   68: aload 11
    //   70: invokevirtual 808	java/io/File:delete	()Z
    //   73: pop
    //   74: new 810	java/io/FileOutputStream
    //   77: dup
    //   78: aload 11
    //   80: invokespecial 811	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: astore 7
    //   85: new 813	java/io/BufferedOutputStream
    //   88: dup
    //   89: aload 7
    //   91: sipush 4096
    //   94: invokespecial 816	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   97: astore 10
    //   99: aload 10
    //   101: astore 9
    //   103: aload 7
    //   105: astore 8
    //   107: iload 5
    //   109: istore 4
    //   111: aload_1
    //   112: getstatic 822	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   115: bipush 100
    //   117: aload 10
    //   119: invokevirtual 827	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   122: istore_3
    //   123: aload 10
    //   125: astore 9
    //   127: aload 7
    //   129: astore 8
    //   131: iload_3
    //   132: istore 4
    //   134: aload 10
    //   136: invokevirtual 830	java/io/BufferedOutputStream:flush	()V
    //   139: aload 10
    //   141: astore 9
    //   143: aload 7
    //   145: astore 8
    //   147: iload_3
    //   148: istore 4
    //   150: aload 11
    //   152: invokevirtual 699	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   155: astore_1
    //   156: aload 10
    //   158: astore 9
    //   160: aload 7
    //   162: astore 8
    //   164: aload_2
    //   165: invokestatic 426	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   168: aload_1
    //   169: invokevirtual 719	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getWxFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   172: putfield 558	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbnailPath	Ljava/lang/String;
    //   175: aload 7
    //   177: ifnull +8 -> 185
    //   180: aload 7
    //   182: invokevirtual 831	java/io/FileOutputStream:close	()V
    //   185: aload_1
    //   186: astore 6
    //   188: iload_3
    //   189: istore 4
    //   191: aload 10
    //   193: ifnull +14 -> 207
    //   196: aload 10
    //   198: invokevirtual 832	java/io/BufferedOutputStream:close	()V
    //   201: iload_3
    //   202: istore 4
    //   204: aload_1
    //   205: astore 6
    //   207: iload 4
    //   209: istore_3
    //   210: invokestatic 373	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq -192 -> 21
    //   216: ldc 14
    //   218: iconst_2
    //   219: new 240	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 834
    //   229: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload 6
    //   234: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 336	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: iload 4
    //   245: ireturn
    //   246: astore_2
    //   247: aload_2
    //   248: invokevirtual 835	java/io/IOException:printStackTrace	()V
    //   251: goto -66 -> 185
    //   254: astore_2
    //   255: aload_2
    //   256: invokevirtual 835	java/io/IOException:printStackTrace	()V
    //   259: aload_1
    //   260: astore 6
    //   262: iload_3
    //   263: istore 4
    //   265: goto -58 -> 207
    //   268: astore_1
    //   269: aconst_null
    //   270: astore_2
    //   271: aconst_null
    //   272: astore 7
    //   274: aload 6
    //   276: astore 8
    //   278: aload_1
    //   279: astore 6
    //   281: iload 4
    //   283: istore_3
    //   284: aload 8
    //   286: astore_1
    //   287: aload_2
    //   288: astore 9
    //   290: aload 7
    //   292: astore 8
    //   294: invokestatic 373	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +21 -> 318
    //   300: aload_2
    //   301: astore 9
    //   303: aload 7
    //   305: astore 8
    //   307: ldc 14
    //   309: iconst_2
    //   310: ldc_w 837
    //   313: aload 6
    //   315: invokestatic 356	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   318: aload 7
    //   320: ifnull +8 -> 328
    //   323: aload 7
    //   325: invokevirtual 831	java/io/FileOutputStream:close	()V
    //   328: aload_1
    //   329: astore 6
    //   331: iload_3
    //   332: istore 4
    //   334: aload_2
    //   335: ifnull -128 -> 207
    //   338: aload_2
    //   339: invokevirtual 832	java/io/BufferedOutputStream:close	()V
    //   342: aload_1
    //   343: astore 6
    //   345: iload_3
    //   346: istore 4
    //   348: goto -141 -> 207
    //   351: astore_2
    //   352: aload_2
    //   353: invokevirtual 835	java/io/IOException:printStackTrace	()V
    //   356: aload_1
    //   357: astore 6
    //   359: iload_3
    //   360: istore 4
    //   362: goto -155 -> 207
    //   365: astore 6
    //   367: aload 6
    //   369: invokevirtual 835	java/io/IOException:printStackTrace	()V
    //   372: goto -44 -> 328
    //   375: astore_1
    //   376: aconst_null
    //   377: astore 9
    //   379: aconst_null
    //   380: astore 7
    //   382: aload 7
    //   384: ifnull +8 -> 392
    //   387: aload 7
    //   389: invokevirtual 831	java/io/FileOutputStream:close	()V
    //   392: aload 9
    //   394: ifnull +8 -> 402
    //   397: aload 9
    //   399: invokevirtual 832	java/io/BufferedOutputStream:close	()V
    //   402: aload_1
    //   403: athrow
    //   404: astore_2
    //   405: aload_2
    //   406: invokevirtual 835	java/io/IOException:printStackTrace	()V
    //   409: goto -17 -> 392
    //   412: astore_2
    //   413: aload_2
    //   414: invokevirtual 835	java/io/IOException:printStackTrace	()V
    //   417: goto -15 -> 402
    //   420: astore_1
    //   421: aconst_null
    //   422: astore 9
    //   424: goto -42 -> 382
    //   427: astore_1
    //   428: aload 8
    //   430: astore 7
    //   432: goto -50 -> 382
    //   435: astore_2
    //   436: aconst_null
    //   437: astore 8
    //   439: aload 6
    //   441: astore_1
    //   442: iload 4
    //   444: istore_3
    //   445: aload_2
    //   446: astore 6
    //   448: aload 8
    //   450: astore_2
    //   451: goto -164 -> 287
    //   454: astore_2
    //   455: aload 6
    //   457: astore_1
    //   458: iload 4
    //   460: istore_3
    //   461: aload_2
    //   462: astore 6
    //   464: aload 10
    //   466: astore_2
    //   467: goto -180 -> 287
    //   470: astore 6
    //   472: aload 10
    //   474: astore_2
    //   475: goto -188 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	VideoJsPlugin
    //   0	478	1	paramBitmap	Bitmap
    //   0	478	2	paramLocalMediaInfo	LocalMediaInfo
    //   7	454	3	bool1	boolean
    //   1	458	4	bool2	boolean
    //   4	104	5	bool3	boolean
    //   47	311	6	localObject1	Object
    //   365	75	6	localIOException	java.io.IOException
    //   446	17	6	localLocalMediaInfo	LocalMediaInfo
    //   470	1	6	localException	Exception
    //   83	348	7	localObject2	Object
    //   105	344	8	localObject3	Object
    //   101	322	9	localObject4	Object
    //   97	376	10	localBufferedOutputStream	java.io.BufferedOutputStream
    //   58	93	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   180	185	246	java/io/IOException
    //   196	201	254	java/io/IOException
    //   74	85	268	java/lang/Exception
    //   338	342	351	java/io/IOException
    //   323	328	365	java/io/IOException
    //   74	85	375	finally
    //   387	392	404	java/io/IOException
    //   397	402	412	java/io/IOException
    //   85	99	420	finally
    //   111	123	427	finally
    //   134	139	427	finally
    //   150	156	427	finally
    //   164	175	427	finally
    //   294	300	427	finally
    //   307	318	427	finally
    //   85	99	435	java/lang/Exception
    //   111	123	454	java/lang/Exception
    //   134	139	454	java/lang/Exception
    //   150	156	454	java/lang/Exception
    //   164	175	470	java/lang/Exception
  }
  
  private void showLoading(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppBrandTask.runTaskOnUiThread(new VideoJsPlugin.7(this, paramAppBrandRuntime, paramString));
  }
  
  private void startCompress(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      Object localObject;
      String str;
      try
      {
        i = paramLocalMediaInfo.path.lastIndexOf(".");
        if (i < 0)
        {
          localObject = "";
          if (paramLocalMediaInfo.path.contains(" ")) {
            copyExecutor.execute(new VideoJsPlugin.5(this, paramLocalMediaInfo, (String)localObject, paramBoolean));
          }
        }
        else
        {
          localObject = paramLocalMediaInfo.path.substring(i + 1);
          continue;
        }
        str = MiniAppFileManager.getInstance().getTmpPath((String)localObject);
        localObject = new File(str);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        QLog.i("VideoJsPlugin", 2, "startCompress: " + paramLocalMediaInfo.orientation);
        if (paramLocalMediaInfo.mediaWidth > 3000) {
          break label314;
        }
        if (paramLocalMediaInfo.mediaHeight <= 3000) {
          break label270;
        }
      }
      catch (Exception paramLocalMediaInfo)
      {
        int j;
        QLog.e("VideoJsPlugin", 1, "startCompress=e=" + paramLocalMediaInfo.getMessage());
        return;
      }
      j = paramLocalMediaInfo.mediaHeight / i;
      if (paramBoolean)
      {
        localObject = "-i " + paramLocalMediaInfo.path + " -r 20 -y -vf scale=-1:" + j + " " + this.FFMPEG_ADDITIONAL_PARAM + " " + str;
        execCommand((String)localObject, str, paramLocalMediaInfo, i);
        return;
        label270:
        i = 2;
      }
      else
      {
        localObject = "-i " + paramLocalMediaInfo.path + " -r 20 -y -c:v libx264 -preset ultrafast " + str;
        continue;
        label314:
        i = 4;
      }
    }
  }
  
  private void unregisterAvatarReceiver()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "unregisterAvatarReceiver");
    }
    try
    {
      if (this.mActivity != null) {
        this.mActivity.unregisterReceiver(this.mAvatarReceiver);
      }
      this.mAvatarReceiverRegistered = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("VideoJsPlugin", 1, "unregisterReceiver exception.", localThrowable);
      }
    }
  }
  
  private void updateLoading(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppBrandTask.runTaskOnUiThread(new VideoJsPlugin.8(this, paramAppBrandRuntime, paramString));
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    i = 0;
    QLog.d("VideoJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    loadFFmpeg();
    paramJsRuntime = new BridgeInfo(paramJsRuntime, paramInt);
    if (this.bridgeMap != null) {
      this.bridgeMap.put(Integer.valueOf(paramInt), paramJsRuntime);
    }
    this.mCallBackId = paramInt;
    try
    {
      paramString2 = new JSONObject(paramString2);
      if (!"chooseVideo".equals(paramString1)) {
        break label423;
      }
      registerAvatarReceiver(this.jsPluginEngine.getActivityContext());
      paramJsRuntime = paramString2.optJSONArray("sourceType");
      bool1 = paramString2.optBoolean("compressed");
      bool2 = paramString2.optString("camera").equals("front");
      if (paramJsRuntime.length() == 0)
      {
        handleNativeResponseFail(paramInt, paramString1, null, "fail sourceType error");
        return "";
      }
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        boolean bool1;
        boolean bool2;
        Object localObject;
        paramString2.printStackTrace();
        handleNativeResponseFail(paramInt, paramString1, null, "");
        continue;
        goToPic(this.jsPluginEngine.getActivityContext(), i, bool1);
        continue;
        if ("saveVideoToPhotosAlbum".equals(paramString1))
        {
          paramString2 = paramString2.optString("filePath");
          if (StringUtil.isEmpty(paramString2))
          {
            handleNativeResponseFail(paramInt, paramString1, null, "fail file not exists");
          }
          else
          {
            paramString2 = MiniAppFileManager.getInstance().getAbsolutePath(paramString2);
            if (ypi.a(this.jsPluginEngine.getActivityContext(), paramString2, getSaveVideoFilePath()))
            {
              handleNativeResponseOk(paramInt, paramString1, null);
            }
            else
            {
              handleNativeResponseFail(paramInt, paramString1, null, "fail filePath invalid");
              continue;
              i += 1;
            }
          }
        }
      }
    }
    if (i < paramJsRuntime.length())
    {
      localObject = paramJsRuntime.opt(i);
      if ((!localObject.equals(this.sourceTypeAlbum)) && (!localObject.equals(this.sourceTypeCamera)))
      {
        QLog.e("VideoJsPlugin", 1, "API_CHOOSE_VIDEO sourceType error. " + paramJsRuntime.opt(i));
        handleNativeResponseFail(paramInt, paramString1, null, "fail sourceType error");
        return "";
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoJsPlugin", 2, "sourceType: " + paramJsRuntime + " length: " + paramJsRuntime.length());
      }
      i = paramString2.optInt("maxDuration");
      if (paramJsRuntime.length() == 2) {
        AppBrandTask.runTaskOnUiThread(new VideoJsPlugin.2(this, i, bool1, bool2));
      }
      for (;;)
      {
        return "";
        if (!"camera".equals(paramJsRuntime.optString(0))) {
          break;
        }
        goToCamera(this.jsPluginEngine.getActivityContext(), i, bool1, bool2);
      }
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    this.bridgeMap = new ConcurrentHashMap();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.bridgeMap != null) {
      this.bridgeMap.clear();
    }
    unregisterAvatarReceiver();
  }
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VideoJsPlugin
 * JD-Core Version:    0.7.0.1
 */