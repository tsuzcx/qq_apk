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
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationMiniApp;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationMiniApp;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationMiniApp;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegFileUtils;
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
  private static final Pattern a = Pattern.compile("(?<=time=)[\\d:.]*");
  private static final ExecutorService b = Executors.newSingleThreadExecutor();
  private static final ExecutorService c = Executors.newFixedThreadPool(5);
  private static volatile boolean j;
  private static AtomicBoolean k = new AtomicBoolean(false);
  private WeakReference<Activity> d;
  private int e = -1;
  private String f = "album";
  private String g = "camera";
  private IMiniAppContext h;
  private boolean i = false;
  private long l = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxDuration", 600000L);
  private long m = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxSize", 1610612736L);
  private String n = QzoneConfig.getInstance().getConfig("qqminiapp", "miniFfmpegVideoCompressParam", "-profile:v main -crf 29");
  private BroadcastReceiver o = new VideoJsProxyImpl.3(this);
  private FFmpeg p;
  
  public VideoJsProxyImpl()
  {
    c();
  }
  
  public static int a(MediaExtractor paramMediaExtractor)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        int i1 = 0;
        while (i1 < paramMediaExtractor.getTrackCount())
        {
          boolean bool = QLog.isColorLevel();
          if (bool)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("format for track ");
            localStringBuilder.append(i1);
            localStringBuilder.append(" is ");
            localStringBuilder.append(paramMediaExtractor.getTrackFormat(i1).getString("mime"));
            QLog.d("VideoJsPlugin", 2, localStringBuilder.toString());
          }
          if (paramMediaExtractor.getTrackFormat(i1).getString("mime").startsWith("video/"))
          {
            paramMediaExtractor.selectTrack(i1);
            return i1;
          }
          i1 += 1;
        }
      }
    }
    catch (Exception paramMediaExtractor)
    {
      label111:
      break label111;
    }
    return -1;
  }
  
  private Bitmap a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return ShortVideoUtils.getVideoThumbnail(null, ((IMiniAppFileManager)this.h.getManager(IMiniAppFileManager.class)).getAbsolutePath(paramString));
    }
    return null;
  }
  
  private File a(Context paramContext)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MP4_");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("_");
      paramContext = File.createTempFile(localStringBuilder.toString(), ".mp4", paramContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QLog.e("VideoJsPlugin", 1, "createVideoFile: ", paramContext);
    }
    return null;
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
    Object localObject = this.d;
    if (localObject == null)
    {
      b(paramActivity);
      return;
    }
    localObject = (Activity)((WeakReference)localObject).get();
    if ((localObject != null) && (localObject != paramActivity)) {
      b(paramActivity);
    }
  }
  
  private void a(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    this.i = true;
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramActivity, "/base/album/photolist");
    localActivityURIRequest.extra().putInt("enter_from", 4);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationMiniApp.a);
    localActivityURIRequest.extra().putString("KEY_ALBUM_LIST_CLASS_NAME", AlbumListCustomizationMiniApp.j);
    localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationMiniApp.a);
    localActivityURIRequest.extra().putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localActivityURIRequest.extra().putString("PhotoConst.DEST_BROADCAST_ACTION_NAME", "get_video_info");
    localActivityURIRequest.extra().putBoolean("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
    localActivityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localActivityURIRequest.extra().putLong("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", this.l);
    localActivityURIRequest.extra().putLong("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", this.m);
    if (paramBoolean) {
      localActivityURIRequest.extra().putString("PhotoConst.DEST_OTHER_FLAG", "compress");
    }
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_PREVIEW_VIDEO", false);
    QRoute.startUri(localActivityURIRequest);
    AlbumUtil.anim(paramActivity, false, true);
  }
  
  private void a(Activity paramActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    b(paramActivity, paramInt, paramBoolean1, paramBoolean2);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        i1 = paramLocalMediaInfo.path.lastIndexOf(".");
        if (i1 < 0) {
          localObject = "";
        } else {
          localObject = paramLocalMediaInfo.path.substring(i1 + 1);
        }
        if (paramLocalMediaInfo.path.contains(" "))
        {
          c.execute(new VideoJsProxyImpl.5(this, paramLocalMediaInfo, (String)localObject, paramBoolean));
          return;
        }
        String str = ((IMiniAppFileManager)this.h.getManager(IMiniAppFileManager.class)).getTmpPath((String)localObject);
        localObject = new File(str);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startCompress: ");
        ((StringBuilder)localObject).append(paramLocalMediaInfo.orientation);
        localObject = ((StringBuilder)localObject).toString();
        i1 = 2;
        QLog.i("VideoJsPlugin", 2, (String)localObject);
        if ((paramLocalMediaInfo.mediaWidth <= 3000) && (paramLocalMediaInfo.mediaHeight <= 3000))
        {
          int i2 = paramLocalMediaInfo.mediaHeight / i1;
          if (paramBoolean)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("-i ");
            ((StringBuilder)localObject).append(paramLocalMediaInfo.path);
            ((StringBuilder)localObject).append(" -r 20 -y -vf scale=-1:");
            ((StringBuilder)localObject).append(i2);
            ((StringBuilder)localObject).append(" ");
            ((StringBuilder)localObject).append(this.n);
            ((StringBuilder)localObject).append(" ");
            ((StringBuilder)localObject).append(str);
            localObject = ((StringBuilder)localObject).toString();
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("-i ");
            ((StringBuilder)localObject).append(paramLocalMediaInfo.path);
            ((StringBuilder)localObject).append(" -r 20 -y -c:v libx264 -preset ultrafast ");
            ((StringBuilder)localObject).append(str);
            localObject = ((StringBuilder)localObject).toString();
          }
          a((String)localObject, str, paramLocalMediaInfo, i1);
          return;
        }
      }
      catch (Exception paramLocalMediaInfo)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startCompress=e=");
        ((StringBuilder)localObject).append(paramLocalMediaInfo.getMessage());
        QLog.e("VideoJsPlugin", 1, ((StringBuilder)localObject).toString());
        return;
      }
      int i1 = 4;
    }
  }
  
  /* Error */
  private void a(File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 134	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 16
    //   5: if_icmpge +4 -> 9
    //   8: return
    //   9: new 479	java/io/FileInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 482	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore 8
    //   19: new 136	android/media/MediaExtractor
    //   22: dup
    //   23: invokespecial 483	android/media/MediaExtractor:<init>	()V
    //   26: astore 9
    //   28: aload 8
    //   30: astore 10
    //   32: aload 9
    //   34: astore 11
    //   36: aload 9
    //   38: aload 8
    //   40: invokevirtual 487	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   43: invokevirtual 491	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   46: aload 8
    //   48: astore 10
    //   50: aload 9
    //   52: astore 11
    //   54: aload 9
    //   56: invokestatic 493	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(Landroid/media/MediaExtractor;)I
    //   59: istore 5
    //   61: iload 5
    //   63: iconst_m1
    //   64: if_icmple +292 -> 356
    //   67: aload 8
    //   69: astore 10
    //   71: aload 9
    //   73: astore 11
    //   75: aload 9
    //   77: iload 5
    //   79: invokevirtual 164	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   82: astore 12
    //   84: aload 8
    //   86: astore 10
    //   88: aload 9
    //   90: astore 11
    //   92: new 376	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   95: dup
    //   96: invokespecial 494	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   99: astore 13
    //   101: iconst_0
    //   102: istore 5
    //   104: aload 8
    //   106: astore 10
    //   108: aload 9
    //   110: astore 11
    //   112: aload 12
    //   114: ldc_w 496
    //   117: invokevirtual 499	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   120: ifeq +21 -> 141
    //   123: aload 8
    //   125: astore 10
    //   127: aload 9
    //   129: astore 11
    //   131: aload 12
    //   133: ldc_w 496
    //   136: invokevirtual 502	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   139: istore 5
    //   141: iload 5
    //   143: bipush 90
    //   145: if_icmpeq +59 -> 204
    //   148: iload 5
    //   150: sipush 270
    //   153: if_icmpne +6 -> 159
    //   156: goto +48 -> 204
    //   159: aload 8
    //   161: astore 10
    //   163: aload 9
    //   165: astore 11
    //   167: aload 13
    //   169: aload 12
    //   171: ldc_w 504
    //   174: invokevirtual 502	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   177: putfield 429	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   180: aload 8
    //   182: astore 10
    //   184: aload 9
    //   186: astore 11
    //   188: aload 13
    //   190: aload 12
    //   192: ldc_w 506
    //   195: invokevirtual 502	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   198: putfield 432	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   201: goto +45 -> 246
    //   204: aload 8
    //   206: astore 10
    //   208: aload 9
    //   210: astore 11
    //   212: aload 13
    //   214: aload 12
    //   216: ldc_w 506
    //   219: invokevirtual 502	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   222: putfield 429	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   225: aload 8
    //   227: astore 10
    //   229: aload 9
    //   231: astore 11
    //   233: aload 13
    //   235: aload 12
    //   237: ldc_w 504
    //   240: invokevirtual 502	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   243: putfield 432	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   246: aload 8
    //   248: astore 10
    //   250: aload 9
    //   252: astore 11
    //   254: aload 12
    //   256: ldc_w 508
    //   259: invokevirtual 512	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   262: lstore 6
    //   264: lload 6
    //   266: l2d
    //   267: dstore_3
    //   268: dload_3
    //   269: invokestatic 518	java/lang/Double:isNaN	(D)Z
    //   272: pop
    //   273: dload_3
    //   274: ldc2_w 519
    //   277: ddiv
    //   278: dstore_3
    //   279: aload 8
    //   281: astore 10
    //   283: aload 9
    //   285: astore 11
    //   287: aload 13
    //   289: dload_3
    //   290: invokestatic 526	java/lang/Math:round	(D)J
    //   293: putfield 529	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   296: aload 8
    //   298: astore 10
    //   300: aload 9
    //   302: astore 11
    //   304: aload 13
    //   306: aload_1
    //   307: invokevirtual 531	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   310: putfield 379	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   313: aload 8
    //   315: astore 10
    //   317: aload 9
    //   319: astore 11
    //   321: aload 13
    //   323: aload_1
    //   324: invokevirtual 534	java/io/File:length	()J
    //   327: putfield 537	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   330: aload 13
    //   332: astore_1
    //   333: goto +25 -> 358
    //   336: astore 10
    //   338: aload 8
    //   340: astore 12
    //   342: aload 9
    //   344: astore 8
    //   346: aload 13
    //   348: astore_1
    //   349: aload 10
    //   351: astore 9
    //   353: goto +81 -> 434
    //   356: aconst_null
    //   357: astore_1
    //   358: aload 8
    //   360: invokevirtual 540	java/io/FileInputStream:close	()V
    //   363: aload 9
    //   365: astore 8
    //   367: aload 8
    //   369: invokevirtual 543	android/media/MediaExtractor:release	()V
    //   372: aload_1
    //   373: astore 9
    //   375: goto +102 -> 477
    //   378: astore 10
    //   380: aconst_null
    //   381: astore_1
    //   382: aload 8
    //   384: astore 12
    //   386: aload 9
    //   388: astore 8
    //   390: aload 10
    //   392: astore 9
    //   394: goto +40 -> 434
    //   397: astore_1
    //   398: aconst_null
    //   399: astore 11
    //   401: goto +150 -> 551
    //   404: astore 9
    //   406: aload 8
    //   408: astore 12
    //   410: goto +19 -> 429
    //   413: astore_1
    //   414: aconst_null
    //   415: astore 8
    //   417: aload 8
    //   419: astore 11
    //   421: goto +130 -> 551
    //   424: astore 9
    //   426: aconst_null
    //   427: astore 12
    //   429: aconst_null
    //   430: astore 8
    //   432: aconst_null
    //   433: astore_1
    //   434: aload 12
    //   436: astore 10
    //   438: aload 8
    //   440: astore 11
    //   442: ldc 174
    //   444: iconst_1
    //   445: ldc_w 545
    //   448: aload 9
    //   450: invokestatic 548	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   453: aload 12
    //   455: ifnull +11 -> 466
    //   458: aload 12
    //   460: invokevirtual 540	java/io/FileInputStream:close	()V
    //   463: goto +3 -> 466
    //   466: aload_1
    //   467: astore 9
    //   469: aload 8
    //   471: ifnull +6 -> 477
    //   474: goto -107 -> 367
    //   477: aload 9
    //   479: ifnonnull +19 -> 498
    //   482: aload_0
    //   483: aload_0
    //   484: getfield 74	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:e	I
    //   487: ldc_w 550
    //   490: aconst_null
    //   491: ldc_w 387
    //   494: invokespecial 552	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(ILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   497: return
    //   498: iload_2
    //   499: ifeq +11 -> 510
    //   502: aload_0
    //   503: aload 9
    //   505: iconst_1
    //   506: invokespecial 460	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Z)V
    //   509: return
    //   510: aload_0
    //   511: aload_0
    //   512: getfield 202	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:h	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   515: ldc 204
    //   517: invokeinterface 210 2 0
    //   522: checkcast 204	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   525: aload 9
    //   527: getfield 379	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   530: invokeinterface 555 2 0
    //   535: aload 9
    //   537: getfield 537	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   540: aload 9
    //   542: invokespecial 471	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(Ljava/lang/String;JLcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   545: return
    //   546: astore_1
    //   547: aload 10
    //   549: astore 8
    //   551: aload 8
    //   553: ifnull +11 -> 564
    //   556: aload 8
    //   558: invokevirtual 540	java/io/FileInputStream:close	()V
    //   561: goto +3 -> 564
    //   564: aload 11
    //   566: ifnull +8 -> 574
    //   569: aload 11
    //   571: invokevirtual 543	android/media/MediaExtractor:release	()V
    //   574: goto +5 -> 579
    //   577: aload_1
    //   578: athrow
    //   579: goto -2 -> 577
    //   582: astore 8
    //   584: aload 9
    //   586: astore 8
    //   588: goto -221 -> 367
    //   591: astore 9
    //   593: goto -127 -> 466
    //   596: astore 8
    //   598: goto -34 -> 564
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	601	0	this	VideoJsProxyImpl
    //   0	601	1	paramFile	File
    //   0	601	2	paramBoolean	boolean
    //   267	23	3	d1	double
    //   59	95	5	i1	int
    //   262	3	6	l1	long
    //   17	540	8	localObject1	Object
    //   582	1	8	localIOException1	java.io.IOException
    //   586	1	8	localObject2	Object
    //   596	1	8	localIOException2	java.io.IOException
    //   26	367	9	localObject3	Object
    //   404	1	9	localIOException3	java.io.IOException
    //   424	25	9	localIOException4	java.io.IOException
    //   467	118	9	localFile	File
    //   591	1	9	localIOException5	java.io.IOException
    //   30	286	10	localObject4	Object
    //   336	14	10	localIOException6	java.io.IOException
    //   378	13	10	localIOException7	java.io.IOException
    //   436	112	10	localObject5	Object
    //   34	536	11	localObject6	Object
    //   82	377	12	localObject7	Object
    //   99	248	13	localLocalMediaInfo	LocalMediaInfo
    // Exception table:
    //   from	to	target	type
    //   112	123	336	java/io/IOException
    //   131	141	336	java/io/IOException
    //   167	180	336	java/io/IOException
    //   188	201	336	java/io/IOException
    //   212	225	336	java/io/IOException
    //   233	246	336	java/io/IOException
    //   254	264	336	java/io/IOException
    //   287	296	336	java/io/IOException
    //   304	313	336	java/io/IOException
    //   321	330	336	java/io/IOException
    //   36	46	378	java/io/IOException
    //   54	61	378	java/io/IOException
    //   75	84	378	java/io/IOException
    //   92	101	378	java/io/IOException
    //   19	28	397	finally
    //   19	28	404	java/io/IOException
    //   9	19	413	finally
    //   9	19	424	java/io/IOException
    //   36	46	546	finally
    //   54	61	546	finally
    //   75	84	546	finally
    //   92	101	546	finally
    //   112	123	546	finally
    //   131	141	546	finally
    //   167	180	546	finally
    //   188	201	546	finally
    //   212	225	546	finally
    //   233	246	546	finally
    //   254	264	546	finally
    //   287	296	546	finally
    //   304	313	546	finally
    //   321	330	546	finally
    //   442	453	546	finally
    //   358	363	582	java/io/IOException
    //   458	463	591	java/io/IOException
    //   556	561	596	java/io/IOException
  }
  
  private void a(String paramString, long paramLong, LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null)
    {
      b(this.e, "chooseVideo", null);
      return;
    }
    if (!TextUtils.isEmpty(paramLocalMediaInfo.thumbnailPath))
    {
      a(paramString, paramLong, paramLocalMediaInfo, this.e);
      return;
    }
    int i1 = this.e;
    ThreadManager.getFileThreadHandler().post(new VideoJsProxyImpl.4(this, paramString, paramLocalMediaInfo, paramLong, i1));
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
      localJSONObject.put("__plugin_ready__", new File(FFmpegFileUtils.getFFmpeg(MobileQQ.getContext())).exists());
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
    if (this.p == null) {
      this.p = FFmpeg.getInstance(BaseApplicationImpl.getApplication());
    }
    b(HardCodeUtil.a(2131913498));
    long l1 = System.currentTimeMillis();
    long l2 = paramLocalMediaInfo.mDuration;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("execCommand: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(l1);
    QLog.i("VideoJsPlugin", 2, ((StringBuilder)localObject).toString());
    try
    {
      localObject = paramString1.split(" ");
      this.p.execute((String[])localObject, new VideoJsProxyImpl.6(this, l1, paramString1, paramLocalMediaInfo, paramInt, paramString2, l2));
      return;
    }
    catch (Exception paramString2)
    {
      paramLocalMediaInfo = new StringBuilder();
      paramLocalMediaInfo.append("execCommand: failed ");
      paramLocalMediaInfo.append(paramString1);
      QLog.w("VideoJsPlugin", 1, paramLocalMediaInfo.toString(), paramString2);
      f();
    }
  }
  
  /* Error */
  private boolean a(Bitmap paramBitmap, LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 5
    //   5: iconst_0
    //   6: istore 4
    //   8: aload_1
    //   9: ifnonnull +14 -> 23
    //   12: ldc 174
    //   14: iconst_2
    //   15: ldc_w 664
    //   18: invokestatic 666	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_2
    //   24: ifnonnull +14 -> 38
    //   27: ldc 174
    //   29: iconst_2
    //   30: ldc_w 668
    //   33: invokestatic 666	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: iconst_0
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 202	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:h	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   42: ldc 204
    //   44: invokeinterface 210 2 0
    //   49: checkcast 204	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   52: ldc_w 670
    //   55: invokeinterface 410 2 0
    //   60: astore 6
    //   62: new 250	java/io/File
    //   65: dup
    //   66: aload 6
    //   68: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore 10
    //   73: aload 10
    //   75: invokevirtual 416	java/io/File:exists	()Z
    //   78: ifeq +9 -> 87
    //   81: aload 10
    //   83: invokevirtual 419	java/io/File:delete	()Z
    //   86: pop
    //   87: aconst_null
    //   88: astore 9
    //   90: new 672	java/io/FileOutputStream
    //   93: dup
    //   94: aload 10
    //   96: invokespecial 673	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   99: astore 8
    //   101: new 675	java/io/BufferedOutputStream
    //   104: dup
    //   105: aload 8
    //   107: sipush 4096
    //   110: invokespecial 678	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   113: astore 9
    //   115: aload 6
    //   117: astore 7
    //   119: aload_1
    //   120: getstatic 684	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   123: bipush 100
    //   125: aload 9
    //   127: invokevirtual 689	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   130: istore_3
    //   131: iload_3
    //   132: istore 4
    //   134: aload 6
    //   136: astore 7
    //   138: aload 9
    //   140: invokevirtual 692	java/io/BufferedOutputStream:flush	()V
    //   143: iload_3
    //   144: istore 4
    //   146: aload 6
    //   148: astore 7
    //   150: aload 10
    //   152: invokevirtual 531	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   155: astore_1
    //   156: iload_3
    //   157: istore 4
    //   159: aload_1
    //   160: astore 7
    //   162: aload_2
    //   163: aload_0
    //   164: getfield 202	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:h	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   167: ldc 204
    //   169: invokeinterface 210 2 0
    //   174: checkcast 204	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   177: aload_1
    //   178: invokeinterface 555 2 0
    //   183: putfield 558	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbnailPath	Ljava/lang/String;
    //   186: aload 8
    //   188: invokevirtual 693	java/io/FileOutputStream:close	()V
    //   191: goto +8 -> 199
    //   194: astore_2
    //   195: aload_2
    //   196: invokevirtual 694	java/io/IOException:printStackTrace	()V
    //   199: iload_3
    //   200: istore 4
    //   202: aload_1
    //   203: astore_2
    //   204: aload 9
    //   206: invokevirtual 695	java/io/BufferedOutputStream:close	()V
    //   209: iload_3
    //   210: istore 4
    //   212: aload_1
    //   213: astore_2
    //   214: goto +139 -> 353
    //   217: astore_1
    //   218: aload_1
    //   219: invokevirtual 694	java/io/IOException:printStackTrace	()V
    //   222: goto +131 -> 353
    //   225: astore_2
    //   226: aload 8
    //   228: astore 6
    //   230: aload 9
    //   232: astore_1
    //   233: goto +169 -> 402
    //   236: astore_2
    //   237: iload 4
    //   239: istore_3
    //   240: aload 7
    //   242: astore_1
    //   243: aload 9
    //   245: astore 7
    //   247: goto +20 -> 267
    //   250: astore_2
    //   251: aconst_null
    //   252: astore_1
    //   253: aload 8
    //   255: astore 6
    //   257: goto +145 -> 402
    //   260: astore_2
    //   261: aconst_null
    //   262: astore 7
    //   264: aload 6
    //   266: astore_1
    //   267: goto +27 -> 294
    //   270: astore_2
    //   271: aconst_null
    //   272: astore 6
    //   274: aload 6
    //   276: astore_1
    //   277: goto +125 -> 402
    //   280: astore_2
    //   281: aconst_null
    //   282: astore 7
    //   284: aload 9
    //   286: astore 8
    //   288: aload 6
    //   290: astore_1
    //   291: iload 5
    //   293: istore_3
    //   294: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +13 -> 310
    //   300: ldc 174
    //   302: iconst_2
    //   303: ldc_w 697
    //   306: aload_2
    //   307: invokestatic 548	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   310: aload 8
    //   312: ifnull +16 -> 328
    //   315: aload 8
    //   317: invokevirtual 693	java/io/FileOutputStream:close	()V
    //   320: goto +8 -> 328
    //   323: astore_2
    //   324: aload_2
    //   325: invokevirtual 694	java/io/IOException:printStackTrace	()V
    //   328: iload_3
    //   329: istore 4
    //   331: aload_1
    //   332: astore_2
    //   333: aload 7
    //   335: ifnull +18 -> 353
    //   338: iload_3
    //   339: istore 4
    //   341: aload_1
    //   342: astore_2
    //   343: aload 7
    //   345: invokevirtual 695	java/io/BufferedOutputStream:close	()V
    //   348: aload_1
    //   349: astore_2
    //   350: iload_3
    //   351: istore 4
    //   353: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +35 -> 391
    //   359: new 148	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   366: astore_1
    //   367: aload_1
    //   368: ldc_w 699
    //   371: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload_1
    //   376: aload_2
    //   377: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: ldc 174
    //   383: iconst_2
    //   384: aload_1
    //   385: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 426	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: iload 4
    //   393: ireturn
    //   394: astore_2
    //   395: aload 8
    //   397: astore 6
    //   399: aload 7
    //   401: astore_1
    //   402: aload 6
    //   404: ifnull +18 -> 422
    //   407: aload 6
    //   409: invokevirtual 693	java/io/FileOutputStream:close	()V
    //   412: goto +10 -> 422
    //   415: astore 6
    //   417: aload 6
    //   419: invokevirtual 694	java/io/IOException:printStackTrace	()V
    //   422: aload_1
    //   423: ifnull +15 -> 438
    //   426: aload_1
    //   427: invokevirtual 695	java/io/BufferedOutputStream:close	()V
    //   430: goto +8 -> 438
    //   433: astore_1
    //   434: aload_1
    //   435: invokevirtual 694	java/io/IOException:printStackTrace	()V
    //   438: aload_2
    //   439: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	VideoJsProxyImpl
    //   0	440	1	paramBitmap	Bitmap
    //   0	440	2	paramLocalMediaInfo	LocalMediaInfo
    //   1	350	3	bool1	boolean
    //   6	386	4	bool2	boolean
    //   3	289	5	bool3	boolean
    //   60	348	6	localObject1	Object
    //   415	3	6	localIOException	java.io.IOException
    //   117	283	7	localObject2	Object
    //   99	297	8	localObject3	Object
    //   88	197	9	localBufferedOutputStream	java.io.BufferedOutputStream
    //   71	80	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   186	191	194	java/io/IOException
    //   204	209	217	java/io/IOException
    //   343	348	217	java/io/IOException
    //   119	131	225	finally
    //   138	143	225	finally
    //   150	156	225	finally
    //   162	186	225	finally
    //   119	131	236	java/lang/Exception
    //   138	143	236	java/lang/Exception
    //   150	156	236	java/lang/Exception
    //   162	186	236	java/lang/Exception
    //   101	115	250	finally
    //   101	115	260	java/lang/Exception
    //   90	101	270	finally
    //   90	101	280	java/lang/Exception
    //   315	320	323	java/io/IOException
    //   294	310	394	finally
    //   407	412	415	java/io/IOException
    //   426	430	433	java/io/IOException
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
    this.d = new WeakReference(paramActivity);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("get_video_info");
    paramActivity.registerReceiver(this.o, localIntentFilter);
  }
  
  private void b(Activity paramActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return;
    }
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    if (localIntent.resolveActivity(paramActivity.getPackageManager()) == null) {
      return;
    }
    File localFile = a(paramActivity);
    if (localFile == null) {
      return;
    }
    IActivityResultManager localIActivityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
    localIActivityResultManager.addActivityResultListener(new VideoJsProxyImpl.8(this, localFile, localIActivityResultManager, paramBoolean1));
    localIntent.putExtra("output", FileProvider7Helper.getUriForFile(paramActivity, localFile));
    int i1;
    if (paramInt >= 1)
    {
      i1 = paramInt;
      if (paramInt <= 60000) {}
    }
    else
    {
      i1 = 60000;
    }
    localIntent.putExtra("android.intent.extra.durationLimit", i1);
    if (paramBoolean2) {
      localIntent.putExtra("android.intent.extras.CAMERA_FACING", 1);
    }
    localIntent.putExtra("big_brother_source_key", "biz_src_miniapp");
    paramActivity.startActivityForResult(localIntent, 2);
  }
  
  private void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showLoading ");
    localStringBuilder.append(paramString);
    QLog.i("VideoJsPlugin", 1, localStringBuilder.toString());
    if (this.mBridge != null) {
      this.mBridge.showLoading(paramString);
    }
  }
  
  private static void c()
  {
    if (j) {
      return;
    }
    int i1 = VideoEnvironment.loadAVCodecSo();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadFFmpeg: ");
    localStringBuilder.append(i1);
    QLog.i("VideoJsPlugin", 1, localStringBuilder.toString());
    if (i1 == 0)
    {
      QLog.i("VideoJsPlugin", 1, "loadFFmpeg: is already load");
      j = true;
      return;
    }
    if (!k.compareAndSet(false, true))
    {
      QLog.i("VideoJsPlugin", 1, "loadFFmpeg: is downloading already");
      return;
    }
    b.execute(new VideoJsProxyImpl.1());
  }
  
  private String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ShortVideoUtils.getCameraPath());
    localStringBuilder.append("QQMiniApp");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("_.mp4");
    return localStringBuilder.toString();
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "unregisterAvatarReceiver");
    }
    try
    {
      if (this.d != null)
      {
        ((Activity)this.d.get()).unregisterReceiver(this.o);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoJsPlugin", 1, "unregisterReceiver exception.", localThrowable);
    }
  }
  
  private void f()
  {
    QLog.i("VideoJsPlugin", 1, "hideLoading");
    if (this.mBridge != null) {
      this.mBridge.hideLoading();
    }
  }
  
  public String a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handleNativeRequest event=");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(",jsonParams=");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append(",callbackId=");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.d("VideoJsPlugin", 2, ((StringBuilder)localObject1).toString());
    c();
    this.e = paramInt;
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramString2);
        if ("chooseVideo".equals(paramString1))
        {
          a(paramActivity);
          paramString2 = ((JSONObject)localObject1).optJSONArray("sourceType");
          boolean bool1 = ((JSONObject)localObject1).optBoolean("compressed");
          boolean bool2 = ((JSONObject)localObject1).optString("camera").equals("front");
          i1 = paramString2.length();
          if (i1 != 0) {
            break label517;
          }
          a(paramInt, paramString1, null, "fail sourceType error");
          return "";
          Object localObject2;
          if (i1 < paramString2.length())
          {
            localObject2 = paramString2.opt(i1);
            if ((localObject2.equals(this.f)) || (localObject2.equals(this.g))) {
              break label523;
            }
            paramActivity = new StringBuilder();
            paramActivity.append("API_CHOOSE_VIDEO sourceType error. ");
            paramActivity.append(paramString2.opt(i1));
            QLog.e("VideoJsPlugin", 1, paramActivity.toString());
            a(paramInt, paramString1, null, "fail sourceType error");
            return "";
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("sourceType: ");
            ((StringBuilder)localObject2).append(paramString2);
            ((StringBuilder)localObject2).append(" length: ");
            ((StringBuilder)localObject2).append(paramString2.length());
            QLog.d("VideoJsPlugin", 2, ((StringBuilder)localObject2).toString());
          }
          i1 = ((JSONObject)localObject1).optInt("maxDuration");
          if (paramString2.length() == 2)
          {
            AppBrandTask.runTaskOnUiThread(new VideoJsProxyImpl.2(this, paramActivity, i1, bool1, bool2));
            return "";
          }
          if ("camera".equals(paramString2.optString(0)))
          {
            a(paramActivity, i1, bool1, bool2);
            return "";
          }
          a(paramActivity, i1, bool1);
          return "";
        }
        if ("saveVideoToPhotosAlbum".equals(paramString1))
        {
          paramString2 = ((JSONObject)localObject1).optString("filePath");
          if (StringUtil.isEmpty(paramString2))
          {
            a(paramInt, paramString1, null, "fail file not exists");
            return "";
          }
          if (FileUtils.a(paramActivity, ((IMiniAppFileManager)this.h.getManager(IMiniAppFileManager.class)).getAbsolutePath(paramString2), d()))
          {
            a(paramInt, paramString1, null);
            return "";
          }
          a(paramInt, paramString1, null, "fail filePath invalid");
          return "";
        }
      }
      catch (JSONException paramActivity)
      {
        paramActivity.printStackTrace();
        a(paramInt, paramString1, null, "");
      }
      return "";
      label517:
      int i1 = 0;
      continue;
      label523:
      i1 += 1;
    }
  }
  
  public void chooseVideo(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    a(paramActivity, paramString1, paramString2, paramInt);
  }
  
  public void create(IMiniAppContext paramIMiniAppContext)
  {
    this.h = paramIMiniAppContext;
  }
  
  public void destroy()
  {
    e();
    super.destroy();
  }
  
  public void saveVideoToPhotosAlbum(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    a(paramActivity, paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl
 * JD-Core Version:    0.7.0.1
 */