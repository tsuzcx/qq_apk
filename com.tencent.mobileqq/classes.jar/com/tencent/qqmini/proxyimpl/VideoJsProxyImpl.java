package com.tencent.qqmini.proxyimpl;

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
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.FileFFmpegUtils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy.Bridge;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import common.config.service.QzoneConfig;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ProxyService(proxy=VideoJsProxy.class)
public class VideoJsProxyImpl
  extends VideoJsProxy
{
  private static final ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("(?<=time=)[\\d:.]*");
  private static final ExecutorService jdField_b_of_type_JavaUtilConcurrentExecutorService;
  private static volatile boolean jdField_b_of_type_Boolean;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxDuration", 600000L);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new VideoJsProxyImpl.3(this);
  private FFmpeg jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg;
  private IMiniAppContext jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext;
  private String jdField_a_of_type_JavaLangString = "album";
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxSize", 1610612736L);
  private String jdField_b_of_type_JavaLangString = "camera";
  private String c = QzoneConfig.getInstance().getConfig("qqminiapp", "miniFfmpegVideoCompressParam", "-profile:v main -crf 29");
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
    jdField_b_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(5);
  }
  
  public VideoJsProxyImpl()
  {
    a();
  }
  
  public static int a(MediaExtractor paramMediaExtractor)
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
  
  private Bitmap a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return ShortVideoUtils.getVideoThumbnail(null, ((IMiniAppFileManager)this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(paramString));
    }
    return null;
  }
  
  private File a(Context paramContext)
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
  
  private String a()
  {
    return ShortVideoUtils.getCameraPath() + "QQMiniApp" + System.currentTimeMillis() + "_.mp4";
  }
  
  private static void a()
  {
    if (jdField_b_of_type_Boolean) {
      return;
    }
    int i = VideoEnvironment.loadAVCodecSo();
    QLog.i("VideoJsPlugin", 1, "loadFFmpeg: " + i);
    if (i == 0)
    {
      QLog.i("VideoJsPlugin", 1, "loadFFmpeg: is already load");
      jdField_b_of_type_Boolean = true;
      return;
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      QLog.i("VideoJsPlugin", 1, "loadFFmpeg: is downloading already");
      return;
    }
    jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new VideoJsProxyImpl.1());
  }
  
  private void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.mBridge != null) {
      this.mBridge.responseOk(paramInt, paramString, paramJSONObject);
    }
  }
  
  private void a(int paramInt, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (this.mBridge != null) {
      this.mBridge.responseFail(paramInt, paramString1, paramJSONObject, paramString2);
    }
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      b(paramActivity);
    }
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localActivity == null) || (localActivity == paramActivity));
    b(paramActivity);
  }
  
  private void a(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 4);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localIntent.putExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME", "get_video_info");
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", this.jdField_a_of_type_Long);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", this.jdField_b_of_type_Long);
    if (paramBoolean) {
      localIntent.putExtra("PhotoConst.DEST_OTHER_FLAG", "compress");
    }
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
    paramActivity.startActivity(localIntent);
    AlbumUtil.anim(paramActivity, false, true);
  }
  
  private void a(Activity paramActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    b(paramActivity, paramInt, paramBoolean1, paramBoolean2);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    for (int i = 2;; i = 4) {
      for (;;)
      {
        String str;
        try
        {
          int j = paramLocalMediaInfo.path.lastIndexOf(".");
          if (j < 0)
          {
            localObject = "";
            if (paramLocalMediaInfo.path.contains(" ")) {
              jdField_b_of_type_JavaUtilConcurrentExecutorService.execute(new VideoJsProxyImpl.5(this, paramLocalMediaInfo, (String)localObject, paramBoolean));
            }
          }
          else
          {
            localObject = paramLocalMediaInfo.path.substring(j + 1);
            continue;
          }
          str = ((IMiniAppFileManager)this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getManager(IMiniAppFileManager.class)).getTmpPath((String)localObject);
          localObject = new File(str);
          if (((File)localObject).exists()) {
            ((File)localObject).delete();
          }
          QLog.i("VideoJsPlugin", 2, "startCompress: " + paramLocalMediaInfo.orientation);
          if ((paramLocalMediaInfo.mediaWidth > 3000) || (paramLocalMediaInfo.mediaHeight > 3000)) {
            break;
          }
          j = paramLocalMediaInfo.mediaHeight / i;
          if (paramBoolean)
          {
            localObject = "-i " + paramLocalMediaInfo.path + " -r 20 -y -vf scale=-1:" + j + " " + this.c + " " + str;
            a((String)localObject, str, paramLocalMediaInfo, i);
            return;
          }
        }
        catch (Exception paramLocalMediaInfo)
        {
          QLog.e("VideoJsPlugin", 1, "startCompress=e=" + paramLocalMediaInfo.getMessage());
          return;
        }
        Object localObject = "-i " + paramLocalMediaInfo.path + " -r 20 -y -c:v libx264 -preset ultrafast " + str;
      }
    }
  }
  
  /* Error */
  private void a(File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 121	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 16
    //   5: if_icmpge +4 -> 9
    //   8: return
    //   9: new 476	java/io/FileInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 479	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore 6
    //   19: new 123	android/media/MediaExtractor
    //   22: dup
    //   23: invokespecial 480	android/media/MediaExtractor:<init>	()V
    //   26: astore 5
    //   28: aload 6
    //   30: astore 8
    //   32: aload 5
    //   34: astore 7
    //   36: aload 5
    //   38: aload 6
    //   40: invokevirtual 484	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   43: invokevirtual 488	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   46: aload 6
    //   48: astore 8
    //   50: aload 5
    //   52: astore 7
    //   54: aload 5
    //   56: invokestatic 490	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(Landroid/media/MediaExtractor;)I
    //   59: istore_3
    //   60: iload_3
    //   61: iconst_m1
    //   62: if_icmple +471 -> 533
    //   65: aload 6
    //   67: astore 8
    //   69: aload 5
    //   71: astore 7
    //   73: aload 5
    //   75: iload_3
    //   76: invokevirtual 153	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   79: astore 9
    //   81: aload 6
    //   83: astore 8
    //   85: aload 5
    //   87: astore 7
    //   89: new 379	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   92: dup
    //   93: invokespecial 491	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   96: astore 4
    //   98: iconst_0
    //   99: istore_3
    //   100: aload 6
    //   102: astore 8
    //   104: aload 5
    //   106: astore 7
    //   108: aload 9
    //   110: ldc_w 493
    //   113: invokevirtual 496	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   116: ifeq +422 -> 538
    //   119: aload 6
    //   121: astore 8
    //   123: aload 5
    //   125: astore 7
    //   127: aload 9
    //   129: ldc_w 493
    //   132: invokevirtual 499	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   135: istore_3
    //   136: goto +402 -> 538
    //   139: aload 6
    //   141: astore 8
    //   143: aload 5
    //   145: astore 7
    //   147: aload 4
    //   149: aload 9
    //   151: ldc_w 501
    //   154: invokevirtual 499	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   157: putfield 424	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   160: aload 6
    //   162: astore 8
    //   164: aload 5
    //   166: astore 7
    //   168: aload 4
    //   170: aload 9
    //   172: ldc_w 503
    //   175: invokevirtual 499	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   178: putfield 427	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   181: aload 6
    //   183: astore 8
    //   185: aload 5
    //   187: astore 7
    //   189: aload 4
    //   191: aload 9
    //   193: ldc_w 505
    //   196: invokevirtual 509	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   199: l2d
    //   200: ldc2_w 510
    //   203: ddiv
    //   204: invokestatic 517	java/lang/Math:round	(D)J
    //   207: putfield 520	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   210: aload 6
    //   212: astore 8
    //   214: aload 5
    //   216: astore 7
    //   218: aload 4
    //   220: aload_1
    //   221: invokevirtual 522	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   224: putfield 382	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   227: aload 6
    //   229: astore 8
    //   231: aload 5
    //   233: astore 7
    //   235: aload 4
    //   237: aload_1
    //   238: invokevirtual 525	java/io/File:length	()J
    //   241: putfield 528	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   244: aload 4
    //   246: astore_1
    //   247: aload 6
    //   249: ifnull +8 -> 257
    //   252: aload 6
    //   254: invokevirtual 531	java/io/FileInputStream:close	()V
    //   257: aload_1
    //   258: astore 4
    //   260: aload 5
    //   262: ifnull +11 -> 273
    //   265: aload 5
    //   267: invokevirtual 534	android/media/MediaExtractor:release	()V
    //   270: aload_1
    //   271: astore 4
    //   273: aload 4
    //   275: ifnonnull +150 -> 425
    //   278: aload_0
    //   279: aload_0
    //   280: getfield 61	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:jdField_a_of_type_Int	I
    //   283: ldc_w 536
    //   286: aconst_null
    //   287: ldc_w 390
    //   290: invokespecial 538	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(ILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   293: return
    //   294: aload 6
    //   296: astore 8
    //   298: aload 5
    //   300: astore 7
    //   302: aload 4
    //   304: aload 9
    //   306: ldc_w 503
    //   309: invokevirtual 499	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   312: putfield 424	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   315: aload 6
    //   317: astore 8
    //   319: aload 5
    //   321: astore 7
    //   323: aload 4
    //   325: aload 9
    //   327: ldc_w 501
    //   330: invokevirtual 499	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   333: putfield 427	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
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
    //   356: ldc 135
    //   358: iconst_1
    //   359: ldc_w 540
    //   362: aload 4
    //   364: invokestatic 543	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   367: aload 6
    //   369: ifnull +8 -> 377
    //   372: aload 6
    //   374: invokevirtual 531	java/io/FileInputStream:close	()V
    //   377: aload_1
    //   378: astore 4
    //   380: aload 5
    //   382: ifnull -109 -> 273
    //   385: aload 5
    //   387: invokevirtual 534	android/media/MediaExtractor:release	()V
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
    //   410: invokevirtual 531	java/io/FileInputStream:close	()V
    //   413: aload 7
    //   415: ifnull +8 -> 423
    //   418: aload 7
    //   420: invokevirtual 534	android/media/MediaExtractor:release	()V
    //   423: aload_1
    //   424: athrow
    //   425: iload_2
    //   426: ifeq +11 -> 437
    //   429: aload_0
    //   430: aload 4
    //   432: iconst_1
    //   433: invokespecial 457	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Z)V
    //   436: return
    //   437: aload_0
    //   438: aload_0
    //   439: getfield 194	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   442: ldc 196
    //   444: invokeinterface 202 2 0
    //   449: checkcast 196	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   452: aload 4
    //   454: getfield 382	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   457: invokeinterface 546 2 0
    //   462: aload 4
    //   464: getfield 528	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   467: aload 4
    //   469: invokespecial 468	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(Ljava/lang/String;JLcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   472: return
    //   473: astore 4
    //   475: goto -218 -> 257
    //   478: astore 4
    //   480: goto -103 -> 377
    //   483: astore 4
    //   485: goto -72 -> 413
    //   488: astore_1
    //   489: aconst_null
    //   490: astore 7
    //   492: goto -89 -> 403
    //   495: astore_1
    //   496: aload 8
    //   498: astore 6
    //   500: goto -97 -> 403
    //   503: astore 4
    //   505: aconst_null
    //   506: astore 6
    //   508: aconst_null
    //   509: astore 5
    //   511: aconst_null
    //   512: astore_1
    //   513: goto -165 -> 348
    //   516: astore 4
    //   518: aconst_null
    //   519: astore 5
    //   521: aconst_null
    //   522: astore_1
    //   523: goto -175 -> 348
    //   526: astore 4
    //   528: aconst_null
    //   529: astore_1
    //   530: goto -182 -> 348
    //   533: aconst_null
    //   534: astore_1
    //   535: goto -288 -> 247
    //   538: iload_3
    //   539: bipush 90
    //   541: if_icmpeq -402 -> 139
    //   544: iload_3
    //   545: sipush 270
    //   548: if_icmpne -254 -> 294
    //   551: goto -412 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	554	0	this	VideoJsProxyImpl
    //   0	554	1	paramFile	File
    //   0	554	2	paramBoolean	boolean
    //   59	490	3	i	int
    //   96	372	4	localObject1	Object
    //   473	1	4	localIOException1	java.io.IOException
    //   478	1	4	localIOException2	java.io.IOException
    //   483	1	4	localIOException3	java.io.IOException
    //   503	1	4	localIOException4	java.io.IOException
    //   516	1	4	localIOException5	java.io.IOException
    //   526	1	4	localIOException6	java.io.IOException
    //   26	494	5	localMediaExtractor1	MediaExtractor
    //   17	490	6	localObject2	Object
    //   34	288	7	localMediaExtractor2	MediaExtractor
    //   339	6	7	localIOException7	java.io.IOException
    //   354	137	7	localMediaExtractor3	MediaExtractor
    //   30	467	8	localObject3	Object
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
    //   252	257	473	java/io/IOException
    //   372	377	478	java/io/IOException
    //   408	413	483	java/io/IOException
    //   19	28	488	finally
    //   36	46	495	finally
    //   54	60	495	finally
    //   73	81	495	finally
    //   89	98	495	finally
    //   108	119	495	finally
    //   127	136	495	finally
    //   147	160	495	finally
    //   168	181	495	finally
    //   189	210	495	finally
    //   218	227	495	finally
    //   235	244	495	finally
    //   302	315	495	finally
    //   323	336	495	finally
    //   356	367	495	finally
    //   9	19	503	java/io/IOException
    //   19	28	516	java/io/IOException
    //   36	46	526	java/io/IOException
    //   54	60	526	java/io/IOException
    //   73	81	526	java/io/IOException
    //   89	98	526	java/io/IOException
  }
  
  private void a(String paramString)
  {
    QLog.i("VideoJsPlugin", 1, "showLoading " + paramString);
    if (this.mBridge != null) {
      this.mBridge.showLoading(paramString);
    }
  }
  
  private void a(String paramString, long paramLong, LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null)
    {
      b(this.jdField_a_of_type_Int, "chooseVideo", null);
      return;
    }
    if (!TextUtils.isEmpty(paramLocalMediaInfo.thumbnailPath))
    {
      a(paramString, paramLong, paramLocalMediaInfo, this.jdField_a_of_type_Int);
      return;
    }
    int i = this.jdField_a_of_type_Int;
    ThreadManager.getFileThreadHandler().post(new VideoJsProxyImpl.4(this, paramString, paramLocalMediaInfo, paramLong, i));
  }
  
  private void a(String paramString, long paramLong, LocalMediaInfo paramLocalMediaInfo, int paramInt)
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
      localJSONObject.put("__plugin_ready__", new File(FileFFmpegUtils.a(MobileQQ.getContext())).exists());
      a(paramInt, "chooseVideo", localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      a(paramInt, "chooseVideo", null, "");
    }
  }
  
  private void a(String paramString1, String paramString2, LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg = FFmpeg.getInstance(BaseApplicationImpl.getApplication());
    }
    a(HardCodeUtil.a(2131716124));
    long l1 = System.currentTimeMillis();
    long l2 = paramLocalMediaInfo.mDuration;
    QLog.i("VideoJsPlugin", 2, "execCommand: " + paramString1 + " " + l1);
    try
    {
      String[] arrayOfString = paramString1.split(" ");
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.execute(arrayOfString, new VideoJsProxyImpl.6(this, l1, paramString1, paramLocalMediaInfo, paramInt, paramString2, l2));
      return;
    }
    catch (Exception paramString2)
    {
      QLog.w("VideoJsPlugin", 1, "execCommand: failed " + paramString1, paramString2);
      c();
    }
  }
  
  /* Error */
  private boolean a(Bitmap paramBitmap, LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_1
    //   6: ifnonnull +18 -> 24
    //   9: ldc 135
    //   11: iconst_2
    //   12: ldc_w 657
    //   15: invokestatic 659	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: iload_3
    //   19: istore 4
    //   21: iload 4
    //   23: ireturn
    //   24: aload_2
    //   25: ifnonnull +14 -> 39
    //   28: ldc 135
    //   30: iconst_2
    //   31: ldc_w 661
    //   34: invokestatic 659	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: iconst_0
    //   38: ireturn
    //   39: aload_0
    //   40: getfield 194	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   43: ldc 196
    //   45: invokeinterface 202 2 0
    //   50: checkcast 196	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   53: ldc_w 663
    //   56: invokeinterface 407 2 0
    //   61: astore 5
    //   63: new 243	java/io/File
    //   66: dup
    //   67: aload 5
    //   69: invokespecial 410	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore 10
    //   74: aload 10
    //   76: invokevirtual 413	java/io/File:exists	()Z
    //   79: ifeq +9 -> 88
    //   82: aload 10
    //   84: invokevirtual 416	java/io/File:delete	()Z
    //   87: pop
    //   88: new 665	java/io/FileOutputStream
    //   91: dup
    //   92: aload 10
    //   94: invokespecial 666	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   97: astore 6
    //   99: new 668	java/io/BufferedOutputStream
    //   102: dup
    //   103: aload 6
    //   105: sipush 4096
    //   108: invokespecial 671	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   111: astore 9
    //   113: aload 9
    //   115: astore 8
    //   117: aload 6
    //   119: astore 7
    //   121: aload_1
    //   122: getstatic 677	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   125: bipush 100
    //   127: aload 9
    //   129: invokevirtual 682	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   132: istore_3
    //   133: aload 9
    //   135: astore 8
    //   137: aload 6
    //   139: astore 7
    //   141: aload 9
    //   143: invokevirtual 685	java/io/BufferedOutputStream:flush	()V
    //   146: aload 9
    //   148: astore 8
    //   150: aload 6
    //   152: astore 7
    //   154: aload 10
    //   156: invokevirtual 522	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   159: astore_1
    //   160: aload 9
    //   162: astore 8
    //   164: aload 6
    //   166: astore 7
    //   168: aload_2
    //   169: aload_0
    //   170: getfield 194	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   173: ldc 196
    //   175: invokeinterface 202 2 0
    //   180: checkcast 196	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   183: aload_1
    //   184: invokeinterface 546 2 0
    //   189: putfield 554	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbnailPath	Ljava/lang/String;
    //   192: aload 6
    //   194: ifnull +8 -> 202
    //   197: aload 6
    //   199: invokevirtual 686	java/io/FileOutputStream:close	()V
    //   202: aload 9
    //   204: ifnull +275 -> 479
    //   207: aload 9
    //   209: invokevirtual 687	java/io/BufferedOutputStream:close	()V
    //   212: aload_1
    //   213: astore_2
    //   214: iload_3
    //   215: istore 4
    //   217: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq -199 -> 21
    //   223: ldc 135
    //   225: iconst_2
    //   226: new 137	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   233: ldc_w 689
    //   236: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_2
    //   240: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 274	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: iload_3
    //   250: ireturn
    //   251: astore_2
    //   252: aload_2
    //   253: invokevirtual 690	java/io/IOException:printStackTrace	()V
    //   256: goto -54 -> 202
    //   259: astore_2
    //   260: aload_2
    //   261: invokevirtual 690	java/io/IOException:printStackTrace	()V
    //   264: aload_1
    //   265: astore_2
    //   266: goto -52 -> 214
    //   269: astore_2
    //   270: aconst_null
    //   271: astore 7
    //   273: aconst_null
    //   274: astore 6
    //   276: aload 5
    //   278: astore_1
    //   279: aload 7
    //   281: astore 5
    //   283: aload 5
    //   285: astore 8
    //   287: aload 6
    //   289: astore 7
    //   291: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +21 -> 315
    //   297: aload 5
    //   299: astore 8
    //   301: aload 6
    //   303: astore 7
    //   305: ldc 135
    //   307: iconst_2
    //   308: ldc_w 692
    //   311: aload_2
    //   312: invokestatic 543	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   315: aload 6
    //   317: ifnull +8 -> 325
    //   320: aload 6
    //   322: invokevirtual 686	java/io/FileOutputStream:close	()V
    //   325: aload_1
    //   326: astore_2
    //   327: iload 4
    //   329: istore_3
    //   330: aload 5
    //   332: ifnull -118 -> 214
    //   335: aload 5
    //   337: invokevirtual 687	java/io/BufferedOutputStream:close	()V
    //   340: aload_1
    //   341: astore_2
    //   342: iload 4
    //   344: istore_3
    //   345: goto -131 -> 214
    //   348: astore_2
    //   349: aload_2
    //   350: invokevirtual 690	java/io/IOException:printStackTrace	()V
    //   353: aload_1
    //   354: astore_2
    //   355: iload 4
    //   357: istore_3
    //   358: goto -144 -> 214
    //   361: astore_2
    //   362: aload_2
    //   363: invokevirtual 690	java/io/IOException:printStackTrace	()V
    //   366: goto -41 -> 325
    //   369: astore_1
    //   370: aconst_null
    //   371: astore 8
    //   373: aconst_null
    //   374: astore 6
    //   376: aload 6
    //   378: ifnull +8 -> 386
    //   381: aload 6
    //   383: invokevirtual 686	java/io/FileOutputStream:close	()V
    //   386: aload 8
    //   388: ifnull +8 -> 396
    //   391: aload 8
    //   393: invokevirtual 687	java/io/BufferedOutputStream:close	()V
    //   396: aload_1
    //   397: athrow
    //   398: astore_2
    //   399: aload_2
    //   400: invokevirtual 690	java/io/IOException:printStackTrace	()V
    //   403: goto -17 -> 386
    //   406: astore_2
    //   407: aload_2
    //   408: invokevirtual 690	java/io/IOException:printStackTrace	()V
    //   411: goto -15 -> 396
    //   414: astore_1
    //   415: aconst_null
    //   416: astore 8
    //   418: goto -42 -> 376
    //   421: astore_1
    //   422: aload 7
    //   424: astore 6
    //   426: goto -50 -> 376
    //   429: astore_2
    //   430: aconst_null
    //   431: astore 7
    //   433: aload 5
    //   435: astore_1
    //   436: aload 7
    //   438: astore 5
    //   440: goto -157 -> 283
    //   443: astore_2
    //   444: aload 5
    //   446: astore_1
    //   447: aload 9
    //   449: astore 5
    //   451: goto -168 -> 283
    //   454: astore_2
    //   455: aload 5
    //   457: astore_1
    //   458: iload_3
    //   459: istore 4
    //   461: aload 9
    //   463: astore 5
    //   465: goto -182 -> 283
    //   468: astore_2
    //   469: iload_3
    //   470: istore 4
    //   472: aload 9
    //   474: astore 5
    //   476: goto -193 -> 283
    //   479: aload_1
    //   480: astore_2
    //   481: goto -267 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	this	VideoJsProxyImpl
    //   0	484	1	paramBitmap	Bitmap
    //   0	484	2	paramLocalMediaInfo	LocalMediaInfo
    //   4	466	3	bool1	boolean
    //   1	470	4	bool2	boolean
    //   61	414	5	localObject1	Object
    //   97	328	6	localObject2	Object
    //   119	318	7	localObject3	Object
    //   115	302	8	localObject4	Object
    //   111	362	9	localBufferedOutputStream	java.io.BufferedOutputStream
    //   72	83	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   197	202	251	java/io/IOException
    //   207	212	259	java/io/IOException
    //   88	99	269	java/lang/Exception
    //   335	340	348	java/io/IOException
    //   320	325	361	java/io/IOException
    //   88	99	369	finally
    //   381	386	398	java/io/IOException
    //   391	396	406	java/io/IOException
    //   99	113	414	finally
    //   121	133	421	finally
    //   141	146	421	finally
    //   154	160	421	finally
    //   168	192	421	finally
    //   291	297	421	finally
    //   305	315	421	finally
    //   99	113	429	java/lang/Exception
    //   121	133	443	java/lang/Exception
    //   141	146	454	java/lang/Exception
    //   154	160	454	java/lang/Exception
    //   168	192	468	java/lang/Exception
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "unregisterAvatarReceiver");
    }
    try
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoJsPlugin", 1, "unregisterReceiver exception.", localThrowable);
    }
  }
  
  private void b(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.mBridge != null) {
      this.mBridge.responseCancel(paramInt, paramString, paramJSONObject);
    }
  }
  
  private void b(Activity paramActivity)
  {
    QLog.d("VideoJsPlugin", 2, "registerAvatarReceiver");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("get_video_info");
    paramActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void b(Activity paramActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
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
      localFile = a(paramActivity);
    } while (localFile == null);
    IActivityResultManager localIActivityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
    localIActivityResultManager.addActivityResultListener(new VideoJsProxyImpl.8(this, localFile, localIActivityResultManager, paramBoolean1));
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
  
  private void c()
  {
    QLog.i("VideoJsPlugin", 1, "hideLoading");
    if (this.mBridge != null) {
      this.mBridge.hideLoading();
    }
  }
  
  public String a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    i = 0;
    QLog.d("VideoJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt);
    a();
    this.jdField_a_of_type_Int = paramInt;
    try
    {
      paramString2 = new JSONObject(paramString2);
      if (!"chooseVideo".equals(paramString1)) {
        break label374;
      }
      a(paramActivity);
      localJSONArray = paramString2.optJSONArray("sourceType");
      bool1 = paramString2.optBoolean("compressed");
      bool2 = paramString2.optString("camera").equals("front");
      if (localJSONArray.length() == 0)
      {
        a(paramInt, paramString1, null, "fail sourceType error");
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
        a(paramInt, paramString1, null, "");
        continue;
        a(paramActivity, i, bool1);
        continue;
        if ("saveVideoToPhotosAlbum".equals(paramString1))
        {
          paramString2 = paramString2.optString("filePath");
          if (StringUtil.a(paramString2))
          {
            a(paramInt, paramString1, null, "fail file not exists");
          }
          else if (FileUtils.a(paramActivity, ((IMiniAppFileManager)this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(paramString2), a()))
          {
            a(paramInt, paramString1, null);
          }
          else
          {
            a(paramInt, paramString1, null, "fail filePath invalid");
            continue;
            i += 1;
          }
        }
      }
    }
    if (i < localJSONArray.length())
    {
      localObject = localJSONArray.opt(i);
      if ((!localObject.equals(this.jdField_a_of_type_JavaLangString)) && (!localObject.equals(this.jdField_b_of_type_JavaLangString)))
      {
        QLog.e("VideoJsPlugin", 1, "API_CHOOSE_VIDEO sourceType error. " + localJSONArray.opt(i));
        a(paramInt, paramString1, null, "fail sourceType error");
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
        AppBrandTask.runTaskOnUiThread(new VideoJsProxyImpl.2(this, paramActivity, i, bool1, bool2));
      }
      for (;;)
      {
        return "";
        if (!"camera".equals(localJSONArray.optString(0))) {
          break;
        }
        a(paramActivity, i, bool1, bool2);
      }
    }
  }
  
  public void chooseVideo(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    a(paramActivity, paramString1, paramString2, paramInt);
  }
  
  public void create(IMiniAppContext paramIMiniAppContext)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = paramIMiniAppContext;
  }
  
  public void destroy()
  {
    b();
    super.destroy();
  }
  
  public void saveVideoToPhotosAlbum(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    a(paramActivity, paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl
 * JD-Core Version:    0.7.0.1
 */