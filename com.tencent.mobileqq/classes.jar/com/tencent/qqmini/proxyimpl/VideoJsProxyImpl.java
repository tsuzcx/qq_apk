package com.tencent.qqmini.proxyimpl;

import alud;
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
import azjy;
import bdfa;
import bdnn;
import bgnk;
import bgnt;
import bgor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.VideoJsProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoJsProxy.Bridge;
import com.tencent.qqmini.sdk.log.QMLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xrg;
import xtc;

public class VideoJsProxyImpl
  extends VideoJsProxy
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
  private long chooseVideoMaxDuration = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxDuration", 600000L);
  private long chooseVideoMaxSize = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxSize", 1610612736L);
  private xtc ffmpeg;
  private Activity mActivity;
  private BroadcastReceiver mAvatarReceiver = new VideoJsProxyImpl.3(this);
  private boolean mAvatarReceiverRegistered;
  private int mCallBackId = -1;
  private String sourceTypeAlbum = "album";
  private String sourceTypeCamera = "camera";
  private boolean waitForResult;
  
  static
  {
    executor = Executors.newSingleThreadExecutor();
  }
  
  public VideoJsProxyImpl()
  {
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
      this.ffmpeg = xtc.a(BaseApplicationImpl.getApplication());
    }
    showLoading(alud.a(2131716690));
    long l1 = System.currentTimeMillis();
    long l2 = paramLocalMediaInfo.mDuration;
    QLog.i("VideoJsPlugin", 2, "execCommand: " + paramString1 + " " + l1);
    try
    {
      String[] arrayOfString = paramString1.split(" ");
      this.ffmpeg.a(arrayOfString, new VideoJsProxyImpl.6(this, l1, paramString1, paramLocalMediaInfo, paramInt, paramString2, l2));
      return;
    }
    catch (Exception paramString2)
    {
      QLog.w("VideoJsPlugin", 1, "execCommand: failed " + paramString1, paramString2);
      hideLoading();
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
    return ShortVideoUtils.d() + "QQMiniApp" + System.currentTimeMillis() + "_.mp4";
  }
  
  private Bitmap getThumbnailBitmap(String paramString)
  {
    Bitmap localBitmap = null;
    if (!TextUtils.isEmpty(paramString)) {
      localBitmap = ShortVideoUtils.a(null, bgnt.a().a(paramString));
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
    bgnk.a().a(new VideoJsProxyImpl.8(this, localFile, paramBoolean1));
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
    bdfa.anim(paramActivity, false, true);
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
      localJSONObject.put("__plugin_ready__", new File(azjy.a(MobileQQ.getContext())).exists());
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
    if (this.mBridge != null) {
      this.mBridge.responseCancel(paramInt, paramString, paramJSONObject);
    }
  }
  
  private void handleNativeResponseFail(int paramInt, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (this.mBridge != null) {
      this.mBridge.responseFail(paramInt, paramString1, paramJSONObject, paramString2);
    }
  }
  
  private void handleNativeResponseOk(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.mBridge != null) {
      this.mBridge.responseOk(paramInt, paramString, paramJSONObject);
    }
  }
  
  /* Error */
  private void handleVideoResult(File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 329	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 16
    //   5: if_icmpge +4 -> 9
    //   8: return
    //   9: new 600	java/io/FileInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 603	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore 6
    //   19: new 331	android/media/MediaExtractor
    //   22: dup
    //   23: invokespecial 604	android/media/MediaExtractor:<init>	()V
    //   26: astore 5
    //   28: aload 6
    //   30: astore 8
    //   32: aload 5
    //   34: astore 7
    //   36: aload 5
    //   38: aload 6
    //   40: invokevirtual 608	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   43: invokevirtual 612	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   46: aload 6
    //   48: astore 8
    //   50: aload 5
    //   52: astore 7
    //   54: aload 5
    //   56: invokestatic 614	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:getAndSelectVideoTrackIndex	(Landroid/media/MediaExtractor;)I
    //   59: istore_3
    //   60: iload_3
    //   61: iconst_m1
    //   62: if_icmple +458 -> 520
    //   65: aload 6
    //   67: astore 8
    //   69: aload 5
    //   71: astore 7
    //   73: aload 5
    //   75: iload_3
    //   76: invokevirtual 350	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   79: astore 9
    //   81: aload 6
    //   83: astore 8
    //   85: aload 5
    //   87: astore 7
    //   89: new 292	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   92: dup
    //   93: invokespecial 615	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   96: astore 4
    //   98: iconst_0
    //   99: istore_3
    //   100: aload 6
    //   102: astore 8
    //   104: aload 5
    //   106: astore 7
    //   108: aload 9
    //   110: ldc_w 617
    //   113: invokevirtual 620	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   116: ifeq +409 -> 525
    //   119: aload 6
    //   121: astore 8
    //   123: aload 5
    //   125: astore 7
    //   127: aload 9
    //   129: ldc_w 617
    //   132: invokevirtual 624	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   135: istore_3
    //   136: goto +389 -> 525
    //   139: aload 6
    //   141: astore 8
    //   143: aload 5
    //   145: astore 7
    //   147: aload 4
    //   149: aload 9
    //   151: ldc_w 539
    //   154: invokevirtual 624	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   157: putfield 547	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   160: aload 6
    //   162: astore 8
    //   164: aload 5
    //   166: astore 7
    //   168: aload 4
    //   170: aload 9
    //   172: ldc_w 544
    //   175: invokevirtual 624	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   178: putfield 542	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   181: aload 6
    //   183: astore 8
    //   185: aload 5
    //   187: astore 7
    //   189: aload 4
    //   191: aload 9
    //   193: ldc_w 626
    //   196: invokevirtual 630	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   199: l2d
    //   200: ldc2_w 631
    //   203: ddiv
    //   204: invokestatic 635	java/lang/Math:round	(D)J
    //   207: putfield 295	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   210: aload 6
    //   212: astore 8
    //   214: aload 5
    //   216: astore 7
    //   218: aload 4
    //   220: aload_1
    //   221: invokevirtual 638	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   224: putfield 641	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   227: aload 6
    //   229: astore 8
    //   231: aload 5
    //   233: astore 7
    //   235: aload 4
    //   237: aload_1
    //   238: invokevirtual 644	java/io/File:length	()J
    //   241: putfield 647	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   244: aload 4
    //   246: astore_1
    //   247: aload 6
    //   249: ifnull +8 -> 257
    //   252: aload 6
    //   254: invokevirtual 650	java/io/FileInputStream:close	()V
    //   257: aload_1
    //   258: astore 4
    //   260: aload 5
    //   262: ifnull +11 -> 273
    //   265: aload 5
    //   267: invokevirtual 653	android/media/MediaExtractor:release	()V
    //   270: aload_1
    //   271: astore 4
    //   273: aload 4
    //   275: ifnonnull +150 -> 425
    //   278: aload_0
    //   279: aload_0
    //   280: getfield 80	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:mCallBackId	I
    //   283: ldc_w 569
    //   286: aconst_null
    //   287: ldc_w 577
    //   290: invokespecial 581	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:handleNativeResponseFail	(ILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   293: return
    //   294: aload 6
    //   296: astore 8
    //   298: aload 5
    //   300: astore 7
    //   302: aload 4
    //   304: aload 9
    //   306: ldc_w 544
    //   309: invokevirtual 624	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   312: putfield 547	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   315: aload 6
    //   317: astore 8
    //   319: aload 5
    //   321: astore 7
    //   323: aload 4
    //   325: aload 9
    //   327: ldc_w 539
    //   330: invokevirtual 624	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   333: putfield 542	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   336: goto -155 -> 181
    //   339: astore 7
    //   341: aload 4
    //   343: astore_1
    //   344: aload 7
    //   346: astore 4
    //   348: aload 6
    //   350: astore 8
    //   352: aload 5
    //   354: astore 7
    //   356: ldc 14
    //   358: iconst_1
    //   359: ldc_w 655
    //   362: aload 4
    //   364: invokestatic 322	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   367: aload 6
    //   369: ifnull +8 -> 377
    //   372: aload 6
    //   374: invokevirtual 650	java/io/FileInputStream:close	()V
    //   377: aload_1
    //   378: astore 4
    //   380: aload 5
    //   382: ifnull -109 -> 273
    //   385: aload 5
    //   387: invokevirtual 653	android/media/MediaExtractor:release	()V
    //   390: aload_1
    //   391: astore 4
    //   393: goto -120 -> 273
    //   396: astore_1
    //   397: aconst_null
    //   398: astore 6
    //   400: aconst_null
    //   401: astore 7
    //   403: aload 6
    //   405: ifnull +8 -> 413
    //   408: aload 6
    //   410: invokevirtual 650	java/io/FileInputStream:close	()V
    //   413: aload 7
    //   415: ifnull +8 -> 423
    //   418: aload 7
    //   420: invokevirtual 653	android/media/MediaExtractor:release	()V
    //   423: aload_1
    //   424: athrow
    //   425: iload_2
    //   426: ifeq +11 -> 437
    //   429: aload_0
    //   430: aload 4
    //   432: iconst_1
    //   433: invokespecial 199	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:startCompress	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Z)V
    //   436: return
    //   437: aload_0
    //   438: invokestatic 391	bgnt:a	()Lbgnt;
    //   441: aload 4
    //   443: getfield 641	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   446: invokevirtual 657	bgnt:e	(Ljava/lang/String;)Ljava/lang/String;
    //   449: aload 4
    //   451: getfield 647	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   454: aload 4
    //   456: invokespecial 205	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:respGetVideo	(Ljava/lang/String;JLcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   459: return
    //   460: astore 4
    //   462: goto -205 -> 257
    //   465: astore 4
    //   467: goto -90 -> 377
    //   470: astore 4
    //   472: goto -59 -> 413
    //   475: astore_1
    //   476: aconst_null
    //   477: astore 7
    //   479: goto -76 -> 403
    //   482: astore_1
    //   483: aload 8
    //   485: astore 6
    //   487: goto -84 -> 403
    //   490: astore 4
    //   492: aconst_null
    //   493: astore 6
    //   495: aconst_null
    //   496: astore 5
    //   498: aconst_null
    //   499: astore_1
    //   500: goto -152 -> 348
    //   503: astore 4
    //   505: aconst_null
    //   506: astore 5
    //   508: aconst_null
    //   509: astore_1
    //   510: goto -162 -> 348
    //   513: astore 4
    //   515: aconst_null
    //   516: astore_1
    //   517: goto -169 -> 348
    //   520: aconst_null
    //   521: astore_1
    //   522: goto -275 -> 247
    //   525: iload_3
    //   526: bipush 90
    //   528: if_icmpeq -389 -> 139
    //   531: iload_3
    //   532: sipush 270
    //   535: if_icmpne -241 -> 294
    //   538: goto -399 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	541	0	this	VideoJsProxyImpl
    //   0	541	1	paramFile	File
    //   0	541	2	paramBoolean	boolean
    //   59	477	3	i	int
    //   96	359	4	localObject1	Object
    //   460	1	4	localIOException1	java.io.IOException
    //   465	1	4	localIOException2	java.io.IOException
    //   470	1	4	localIOException3	java.io.IOException
    //   490	1	4	localIOException4	java.io.IOException
    //   503	1	4	localIOException5	java.io.IOException
    //   513	1	4	localIOException6	java.io.IOException
    //   26	481	5	localMediaExtractor1	MediaExtractor
    //   17	477	6	localObject2	Object
    //   34	288	7	localMediaExtractor2	MediaExtractor
    //   339	6	7	localIOException7	java.io.IOException
    //   354	124	7	localMediaExtractor3	MediaExtractor
    //   30	454	8	localObject3	Object
    //   79	247	9	localMediaFormat	MediaFormat
    // Exception table:
    //   from	to	target	type
    //   108	119	339	java/io/IOException
    //   127	136	339	java/io/IOException
    //   147	160	339	java/io/IOException
    //   168	181	339	java/io/IOException
    //   189	210	339	java/io/IOException
    //   218	227	339	java/io/IOException
    //   235	244	339	java/io/IOException
    //   302	315	339	java/io/IOException
    //   323	336	339	java/io/IOException
    //   9	19	396	finally
    //   252	257	460	java/io/IOException
    //   372	377	465	java/io/IOException
    //   408	413	470	java/io/IOException
    //   19	28	475	finally
    //   36	46	482	finally
    //   54	60	482	finally
    //   73	81	482	finally
    //   89	98	482	finally
    //   108	119	482	finally
    //   127	136	482	finally
    //   147	160	482	finally
    //   168	181	482	finally
    //   189	210	482	finally
    //   218	227	482	finally
    //   235	244	482	finally
    //   302	315	482	finally
    //   323	336	482	finally
    //   356	367	482	finally
    //   9	19	490	java/io/IOException
    //   19	28	503	java/io/IOException
    //   36	46	513	java/io/IOException
    //   54	60	513	java/io/IOException
    //   73	81	513	java/io/IOException
    //   89	98	513	java/io/IOException
  }
  
  private void hideLoading()
  {
    QMLog.i("VideoJsPlugin", "hideLoading");
    if (this.mBridge != null) {
      this.mBridge.hideLoading();
    }
  }
  
  private static void loadFFmpeg()
  {
    if (isFFmpegReady) {
      return;
    }
    int i = VideoEnvironment.a("AVCodec", MobileQQ.sMobileQQ.getApplicationContext());
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
    executor.execute(new VideoJsProxyImpl.1());
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
    ThreadManager.getFileThreadHandler().post(new VideoJsProxyImpl.4(this, paramString, paramLocalMediaInfo, paramLong, i));
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
    //   15: ldc_w 732
    //   18: invokestatic 734	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: iload_3
    //   22: ireturn
    //   23: aload_2
    //   24: ifnonnull +14 -> 38
    //   27: ldc 14
    //   29: iconst_2
    //   30: ldc_w 736
    //   33: invokestatic 734	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: iconst_0
    //   37: ireturn
    //   38: invokestatic 391	bgnt:a	()Lbgnt;
    //   41: ldc_w 738
    //   44: invokevirtual 741	bgnt:b	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 6
    //   49: new 254	java/io/File
    //   52: dup
    //   53: aload 6
    //   55: invokespecial 561	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 11
    //   60: aload 11
    //   62: invokevirtual 564	java/io/File:exists	()Z
    //   65: ifeq +9 -> 74
    //   68: aload 11
    //   70: invokevirtual 744	java/io/File:delete	()Z
    //   73: pop
    //   74: new 746	java/io/FileOutputStream
    //   77: dup
    //   78: aload 11
    //   80: invokespecial 747	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: astore 7
    //   85: new 749	java/io/BufferedOutputStream
    //   88: dup
    //   89: aload 7
    //   91: sipush 4096
    //   94: invokespecial 752	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   97: astore 10
    //   99: aload 10
    //   101: astore 9
    //   103: aload 7
    //   105: astore 8
    //   107: iload 5
    //   109: istore 4
    //   111: aload_1
    //   112: getstatic 758	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   115: bipush 100
    //   117: aload 10
    //   119: invokevirtual 763	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   122: istore_3
    //   123: aload 10
    //   125: astore 9
    //   127: aload 7
    //   129: astore 8
    //   131: iload_3
    //   132: istore 4
    //   134: aload 10
    //   136: invokevirtual 766	java/io/BufferedOutputStream:flush	()V
    //   139: aload 10
    //   141: astore 9
    //   143: aload 7
    //   145: astore 8
    //   147: iload_3
    //   148: istore 4
    //   150: aload 11
    //   152: invokevirtual 638	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   155: astore_1
    //   156: aload 10
    //   158: astore 9
    //   160: aload 7
    //   162: astore 8
    //   164: aload_2
    //   165: invokestatic 391	bgnt:a	()Lbgnt;
    //   168: aload_1
    //   169: invokevirtual 657	bgnt:e	(Ljava/lang/String;)Ljava/lang/String;
    //   172: putfield 519	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbnailPath	Ljava/lang/String;
    //   175: aload 7
    //   177: ifnull +8 -> 185
    //   180: aload 7
    //   182: invokevirtual 767	java/io/FileOutputStream:close	()V
    //   185: aload_1
    //   186: astore 6
    //   188: iload_3
    //   189: istore 4
    //   191: aload 10
    //   193: ifnull +14 -> 207
    //   196: aload 10
    //   198: invokevirtual 768	java/io/BufferedOutputStream:close	()V
    //   201: iload_3
    //   202: istore 4
    //   204: aload_1
    //   205: astore 6
    //   207: iload 4
    //   209: istore_3
    //   210: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq -192 -> 21
    //   216: ldc 14
    //   218: iconst_2
    //   219: new 217	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 770
    //   229: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload 6
    //   234: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 303	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: iload 4
    //   245: ireturn
    //   246: astore_2
    //   247: aload_2
    //   248: invokevirtual 771	java/io/IOException:printStackTrace	()V
    //   251: goto -66 -> 185
    //   254: astore_2
    //   255: aload_2
    //   256: invokevirtual 771	java/io/IOException:printStackTrace	()V
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
    //   294: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +21 -> 318
    //   300: aload_2
    //   301: astore 9
    //   303: aload 7
    //   305: astore 8
    //   307: ldc 14
    //   309: iconst_2
    //   310: ldc_w 773
    //   313: aload 6
    //   315: invokestatic 322	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   318: aload 7
    //   320: ifnull +8 -> 328
    //   323: aload 7
    //   325: invokevirtual 767	java/io/FileOutputStream:close	()V
    //   328: aload_1
    //   329: astore 6
    //   331: iload_3
    //   332: istore 4
    //   334: aload_2
    //   335: ifnull -128 -> 207
    //   338: aload_2
    //   339: invokevirtual 768	java/io/BufferedOutputStream:close	()V
    //   342: aload_1
    //   343: astore 6
    //   345: iload_3
    //   346: istore 4
    //   348: goto -141 -> 207
    //   351: astore_2
    //   352: aload_2
    //   353: invokevirtual 771	java/io/IOException:printStackTrace	()V
    //   356: aload_1
    //   357: astore 6
    //   359: iload_3
    //   360: istore 4
    //   362: goto -155 -> 207
    //   365: astore 6
    //   367: aload 6
    //   369: invokevirtual 771	java/io/IOException:printStackTrace	()V
    //   372: goto -44 -> 328
    //   375: astore_1
    //   376: aconst_null
    //   377: astore 9
    //   379: aconst_null
    //   380: astore 7
    //   382: aload 7
    //   384: ifnull +8 -> 392
    //   387: aload 7
    //   389: invokevirtual 767	java/io/FileOutputStream:close	()V
    //   392: aload 9
    //   394: ifnull +8 -> 402
    //   397: aload 9
    //   399: invokevirtual 768	java/io/BufferedOutputStream:close	()V
    //   402: aload_1
    //   403: athrow
    //   404: astore_2
    //   405: aload_2
    //   406: invokevirtual 771	java/io/IOException:printStackTrace	()V
    //   409: goto -17 -> 392
    //   412: astore_2
    //   413: aload_2
    //   414: invokevirtual 771	java/io/IOException:printStackTrace	()V
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
    //   0	478	0	this	VideoJsProxyImpl
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
  
  private void showLoading(String paramString)
  {
    QMLog.i("VideoJsPlugin", "showLoading " + paramString);
    if (this.mBridge != null) {
      this.mBridge.showLoading(paramString);
    }
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
            copyExecutor.execute(new VideoJsProxyImpl.5(this, paramLocalMediaInfo, (String)localObject, paramBoolean));
          }
        }
        else
        {
          localObject = paramLocalMediaInfo.path.substring(i + 1);
          continue;
        }
        str = bgnt.a().b((String)localObject);
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
  
  private void updateLoading(String paramString)
  {
    QMLog.i("VideoJsPlugin", "updateLoading " + paramString);
    if (this.mBridge != null) {
      this.mBridge.updateLoading(paramString);
    }
  }
  
  public void chooseVideo(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    handleNativeRequest(paramActivity, paramString1, paramString2, paramInt);
  }
  
  public void create() {}
  
  public void destroy()
  {
    unregisterAvatarReceiver();
    super.destroy();
  }
  
  public String handleNativeRequest(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    i = 0;
    QLog.d("VideoJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt);
    loadFFmpeg();
    this.mCallBackId = paramInt;
    try
    {
      paramString2 = new JSONObject(paramString2);
      if (!"chooseVideo".equals(paramString1)) {
        break label374;
      }
      registerAvatarReceiver(paramActivity);
      localJSONArray = paramString2.optJSONArray("sourceType");
      bool1 = paramString2.optBoolean("compressed");
      bool2 = paramString2.optString("camera").equals("front");
      if (localJSONArray.length() == 0)
      {
        handleNativeResponseFail(paramInt, paramString1, null, "fail sourceType error");
        return "";
      }
    }
    catch (JSONException paramActivity)
    {
      for (;;)
      {
        JSONArray localJSONArray;
        boolean bool1;
        boolean bool2;
        Object localObject;
        paramActivity.printStackTrace();
        handleNativeResponseFail(paramInt, paramString1, null, "");
        continue;
        goToPic(paramActivity, i, bool1);
        continue;
        if ("saveVideoToPhotosAlbum".equals(paramString1))
        {
          paramString2 = paramString2.optString("filePath");
          if (bdnn.a(paramString2))
          {
            handleNativeResponseFail(paramInt, paramString1, null, "fail file not exists");
          }
          else if (xrg.a(paramActivity, bgnt.a().a(paramString2), getSaveVideoFilePath()))
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
    if (i < localJSONArray.length())
    {
      localObject = localJSONArray.opt(i);
      if ((!localObject.equals(this.sourceTypeAlbum)) && (!localObject.equals(this.sourceTypeCamera)))
      {
        QLog.e("VideoJsPlugin", 1, "API_CHOOSE_VIDEO sourceType error. " + localJSONArray.opt(i));
        handleNativeResponseFail(paramInt, paramString1, null, "fail sourceType error");
        return "";
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoJsPlugin", 2, "sourceType: " + localJSONArray + " length: " + localJSONArray.length());
      }
      i = paramString2.optInt("maxDuration");
      if (localJSONArray.length() == 2) {
        bgor.a(new VideoJsProxyImpl.2(this, paramActivity, i, bool1, bool2));
      }
      for (;;)
      {
        return "";
        if (!"camera".equals(localJSONArray.optString(0))) {
          break;
        }
        goToCamera(paramActivity, i, bool1, bool2);
      }
    }
  }
  
  public void saveVideoToPhotosAlbum(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    handleNativeRequest(paramActivity, paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl
 * JD-Core Version:    0.7.0.1
 */