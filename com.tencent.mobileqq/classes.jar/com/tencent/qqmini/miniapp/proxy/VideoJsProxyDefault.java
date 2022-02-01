package com.tencent.qqmini.miniapp.proxy;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmini.miniapp.util.VideoCompress.Option;
import com.tencent.qqmini.miniapp.util.VideoCompress.TargetEncoding;
import com.tencent.qqmini.miniapp.util.VideoCompressProxy;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ShortVideoUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy.Bridge;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.LocalMediaInfo;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ProxyService(proxy=VideoJsProxy.class)
public class VideoJsProxyDefault
  extends VideoJsProxy
{
  public static final String API_CHOOSE_VIDEO = "chooseVideo";
  private static final String SOURCE_TYPE_ALBUM = "album";
  private static final String SOURCE_TYPE_CAMERA = "camera";
  public static final String TAG = "VideoJsProxyImpl";
  private static final ExecutorService copyExecutor = Executors.newFixedThreadPool(5);
  private IMiniAppContext mMiniAppContext;
  private VideoCompressProxy mVideoCompressService;
  
  public VideoJsProxyDefault()
  {
    Log.i("VideoJsProxyImpl", "construct");
    this.mVideoCompressService = new VideoCompressProxyDefault();
  }
  
  private File createVideoFile(Context paramContext)
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
      QMLog.e("VideoJsProxyImpl", "createVideoFile: ", paramContext);
    }
    return null;
  }
  
  private void execVideoCompress(LocalMediaInfo paramLocalMediaInfo, String paramString, VideoCompress.Option paramOption, VideoJsProxyDefault.BridgeInfo paramBridgeInfo)
  {
    showLoading("正在压缩");
    long l = System.currentTimeMillis();
    this.mVideoCompressService.setMedia(paramLocalMediaInfo).setOption(paramOption).setOutputPath(paramString).listen(new VideoJsProxyDefault.5(this, l, paramOption, paramLocalMediaInfo, paramString, paramBridgeInfo)).execute();
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
          boolean bool = QMLog.isColorLevel();
          if (bool)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("format for track ");
            localStringBuilder.append(i);
            localStringBuilder.append(" is ");
            localStringBuilder.append(paramMediaExtractor.getTrackFormat(i).getString("mime"));
            QMLog.d("VideoJsProxyImpl", localStringBuilder.toString());
          }
          if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/"))
          {
            paramMediaExtractor.selectTrack(i);
            return i;
          }
          i += 1;
        }
      }
    }
    catch (Exception paramMediaExtractor)
    {
      label110:
      break label110;
    }
    return -1;
  }
  
  private String getSaveVideoFilePath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ShortVideoUtil.getCameraPath());
    localStringBuilder.append("QQMiniApp");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("_.mp4");
    return localStringBuilder.toString();
  }
  
  private Bitmap getThumbnailBitmap(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return ShortVideoUtil.getVideoThumbnail(null, ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString));
    }
    return null;
  }
  
  private void goToCamera(Activity paramActivity, long paramLong, boolean paramBoolean1, boolean paramBoolean2, VideoJsProxyDefault.BridgeInfo paramBridgeInfo)
  {
    boolean bool = hasFrontCamera(paramActivity);
    if ((paramBoolean2) && (!bool))
    {
      this.mBridge.responseFail(paramBridgeInfo.callbackId, paramBridgeInfo.eventName, null, "front camera not supported");
      return;
    }
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    if (localIntent.resolveActivity(paramActivity.getPackageManager()) == null)
    {
      this.mBridge.responseFail(paramBridgeInfo.callbackId, paramBridgeInfo.eventName, null, "当前系统不支持");
      return;
    }
    File localFile = createVideoFile(paramActivity.getApplicationContext());
    if (localFile == null)
    {
      this.mBridge.responseFail(paramBridgeInfo.callbackId, paramBridgeInfo.eventName, null, "createVideoFile error");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("videoFile=");
    ((StringBuilder)localObject).append(localFile.getAbsolutePath());
    QMLog.i("VideoJsProxyImpl", ((StringBuilder)localObject).toString());
    localObject = FileUtils.getUriForFile(paramActivity, localFile);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("videoUri=");
    localStringBuilder.append(localObject);
    QMLog.i("VideoJsProxyImpl", localStringBuilder.toString());
    localIntent.putExtra("output", (Parcelable)localObject);
    long l;
    if (paramLong >= 1L)
    {
      l = paramLong;
      if (paramLong <= 60000L) {}
    }
    else
    {
      l = 60000L;
    }
    localIntent.putExtra("android.intent.extra.durationLimit", l);
    if (paramBoolean2) {
      localIntent.putExtra("android.intent.extras.CAMERA_FACING", 1);
    }
    ActivityResultManager.g().addActivityResultListener(new VideoJsProxyDefault.3(this, paramBridgeInfo, localFile, paramBoolean1));
    paramActivity.startActivityForResult(localIntent, 4);
  }
  
  private void goToPic(Activity paramActivity, int paramInt, boolean paramBoolean, VideoJsProxyDefault.BridgeInfo paramBridgeInfo)
  {
    Intent localIntent = new Intent("android.intent.action.PICK");
    localIntent.setDataAndType(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "video/*");
    ActivityResultManager.g().addActivityResultListener(new VideoJsProxyDefault.2(this, paramBridgeInfo, paramActivity, paramBoolean));
    paramActivity.startActivityForResult(localIntent, 2);
  }
  
  private void handleJsCallBack(String paramString, long paramLong, LocalMediaInfo paramLocalMediaInfo, VideoJsProxyDefault.BridgeInfo paramBridgeInfo)
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
      this.mBridge.responseOk(paramBridgeInfo.callbackId, "chooseVideo", localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      this.mBridge.responseFail(paramBridgeInfo.callbackId, "chooseVideo", null, "");
    }
  }
  
  /* Error */
  private void handleVideoResult(File paramFile, boolean paramBoolean, VideoJsProxyDefault.BridgeInfo paramBridgeInfo)
  {
    // Byte code:
    //   0: getstatic 216	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 16
    //   5: if_icmpge +4 -> 9
    //   8: return
    //   9: new 127	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   16: astore 9
    //   18: aload 9
    //   20: ldc_w 474
    //   23: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 9
    //   29: aload_1
    //   30: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   33: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: ldc 20
    //   39: aload 9
    //   41: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 344	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: new 476	java/io/FileInputStream
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 479	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore 9
    //   57: new 218	android/media/MediaExtractor
    //   60: dup
    //   61: invokespecial 480	android/media/MediaExtractor:<init>	()V
    //   64: astore 10
    //   66: aload 9
    //   68: astore 11
    //   70: aload 10
    //   72: astore 12
    //   74: aload 10
    //   76: aload 9
    //   78: invokevirtual 484	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   81: invokevirtual 488	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   84: aload 9
    //   86: astore 11
    //   88: aload 10
    //   90: astore 12
    //   92: aload 10
    //   94: invokestatic 490	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault:getAndSelectVideoTrackIndex	(Landroid/media/MediaExtractor;)I
    //   97: istore 6
    //   99: iload 6
    //   101: iconst_m1
    //   102: if_icmple +293 -> 395
    //   105: aload 9
    //   107: astore 11
    //   109: aload 10
    //   111: astore 12
    //   113: aload 10
    //   115: iload 6
    //   117: invokevirtual 237	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   120: astore 13
    //   122: aload 9
    //   124: astore 11
    //   126: aload 10
    //   128: astore 12
    //   130: new 426	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo
    //   133: dup
    //   134: invokespecial 491	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:<init>	()V
    //   137: astore 15
    //   139: iconst_0
    //   140: istore 6
    //   142: aload 9
    //   144: astore 11
    //   146: aload 10
    //   148: astore 12
    //   150: aload 13
    //   152: ldc_w 493
    //   155: invokevirtual 496	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   158: ifeq +21 -> 179
    //   161: aload 9
    //   163: astore 11
    //   165: aload 10
    //   167: astore 12
    //   169: aload 13
    //   171: ldc_w 493
    //   174: invokevirtual 500	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   177: istore 6
    //   179: iload 6
    //   181: bipush 90
    //   183: if_icmpeq +59 -> 242
    //   186: iload 6
    //   188: sipush 270
    //   191: if_icmpne +6 -> 197
    //   194: goto +48 -> 242
    //   197: aload 9
    //   199: astore 11
    //   201: aload 10
    //   203: astore 12
    //   205: aload 15
    //   207: aload 13
    //   209: ldc_w 458
    //   212: invokevirtual 500	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   215: putfield 461	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:mediaWidth	I
    //   218: aload 9
    //   220: astore 11
    //   222: aload 10
    //   224: astore 12
    //   226: aload 15
    //   228: aload 13
    //   230: ldc_w 453
    //   233: invokevirtual 500	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   236: putfield 456	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:mediaHeight	I
    //   239: goto +45 -> 284
    //   242: aload 9
    //   244: astore 11
    //   246: aload 10
    //   248: astore 12
    //   250: aload 15
    //   252: aload 13
    //   254: ldc_w 453
    //   257: invokevirtual 500	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   260: putfield 461	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:mediaWidth	I
    //   263: aload 9
    //   265: astore 11
    //   267: aload 10
    //   269: astore 12
    //   271: aload 15
    //   273: aload 13
    //   275: ldc_w 458
    //   278: invokevirtual 500	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   281: putfield 456	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:mediaHeight	I
    //   284: aload 9
    //   286: astore 11
    //   288: aload 10
    //   290: astore 12
    //   292: aload 13
    //   294: ldc_w 502
    //   297: invokevirtual 506	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   300: lstore 7
    //   302: lload 7
    //   304: l2d
    //   305: dstore 4
    //   307: dload 4
    //   309: invokestatic 512	java/lang/Double:isNaN	(D)Z
    //   312: pop
    //   313: dload 4
    //   315: ldc2_w 513
    //   318: ddiv
    //   319: dstore 4
    //   321: aload 9
    //   323: astore 11
    //   325: aload 10
    //   327: astore 12
    //   329: aload 15
    //   331: dload 4
    //   333: invokestatic 517	java/lang/Math:round	(D)J
    //   336: putfield 435	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:mDuration	J
    //   339: aload 9
    //   341: astore 11
    //   343: aload 10
    //   345: astore 12
    //   347: aload 15
    //   349: aload_1
    //   350: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   353: putfield 520	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:path	Ljava/lang/String;
    //   356: aload 9
    //   358: astore 11
    //   360: aload 10
    //   362: astore 12
    //   364: aload 15
    //   366: aload_1
    //   367: invokevirtual 523	java/io/File:length	()J
    //   370: putfield 526	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:fileSize	J
    //   373: aload 15
    //   375: astore_1
    //   376: goto +21 -> 397
    //   379: astore 13
    //   381: aload 9
    //   383: astore 14
    //   385: aload 10
    //   387: astore 9
    //   389: aload 15
    //   391: astore_1
    //   392: goto +69 -> 461
    //   395: aconst_null
    //   396: astore_1
    //   397: aload 9
    //   399: invokevirtual 529	java/io/FileInputStream:close	()V
    //   402: aload 10
    //   404: astore 9
    //   406: goto +94 -> 500
    //   409: astore 13
    //   411: aconst_null
    //   412: astore_1
    //   413: aload 9
    //   415: astore 14
    //   417: aload 10
    //   419: astore 9
    //   421: goto +40 -> 461
    //   424: astore_1
    //   425: aconst_null
    //   426: astore 12
    //   428: goto +159 -> 587
    //   431: astore 13
    //   433: aload 9
    //   435: astore 14
    //   437: goto +19 -> 456
    //   440: astore_1
    //   441: aconst_null
    //   442: astore 9
    //   444: aload 9
    //   446: astore 12
    //   448: goto +139 -> 587
    //   451: astore 13
    //   453: aconst_null
    //   454: astore 14
    //   456: aconst_null
    //   457: astore 9
    //   459: aconst_null
    //   460: astore_1
    //   461: aload 14
    //   463: astore 11
    //   465: aload 9
    //   467: astore 12
    //   469: ldc 20
    //   471: ldc_w 531
    //   474: aload 13
    //   476: invokestatic 534	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   479: aload 14
    //   481: ifnull +11 -> 492
    //   484: aload 14
    //   486: invokevirtual 529	java/io/FileInputStream:close	()V
    //   489: goto +3 -> 492
    //   492: aload_1
    //   493: astore 10
    //   495: aload 9
    //   497: ifnull +11 -> 508
    //   500: aload 9
    //   502: invokevirtual 537	android/media/MediaExtractor:release	()V
    //   505: aload_1
    //   506: astore 10
    //   508: aload 10
    //   510: ifnonnull +23 -> 533
    //   513: aload_0
    //   514: getfield 88	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault:mBridge	Lcom/tencent/qqmini/sdk/launcher/core/proxy/VideoJsProxy$Bridge;
    //   517: aload_3
    //   518: getfield 301	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault$BridgeInfo:callbackId	I
    //   521: ldc 11
    //   523: aconst_null
    //   524: ldc_w 470
    //   527: invokeinterface 312 5 0
    //   532: return
    //   533: iload_2
    //   534: ifeq +12 -> 546
    //   537: aload_0
    //   538: aload 10
    //   540: iconst_1
    //   541: aload_3
    //   542: invokespecial 109	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault:startCompress	(Lcom/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo;ZLcom/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault$BridgeInfo;)V
    //   545: return
    //   546: aload_0
    //   547: aload_0
    //   548: getfield 99	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   551: ldc_w 279
    //   554: invokeinterface 285 2 0
    //   559: checkcast 279	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   562: aload 10
    //   564: getfield 520	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:path	Ljava/lang/String;
    //   567: invokevirtual 540	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getWxFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   570: aload 10
    //   572: getfield 526	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:fileSize	J
    //   575: aload 10
    //   577: aload_3
    //   578: invokespecial 103	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault:respGetVideo	(Ljava/lang/String;JLcom/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo;Lcom/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault$BridgeInfo;)V
    //   581: return
    //   582: astore_1
    //   583: aload 11
    //   585: astore 9
    //   587: aload 9
    //   589: ifnull +11 -> 600
    //   592: aload 9
    //   594: invokevirtual 529	java/io/FileInputStream:close	()V
    //   597: goto +3 -> 600
    //   600: aload 12
    //   602: ifnull +8 -> 610
    //   605: aload 12
    //   607: invokevirtual 537	android/media/MediaExtractor:release	()V
    //   610: aload_1
    //   611: athrow
    //   612: astore 9
    //   614: aload 10
    //   616: astore 9
    //   618: goto -118 -> 500
    //   621: astore 10
    //   623: goto -131 -> 492
    //   626: astore_3
    //   627: goto -27 -> 600
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	630	0	this	VideoJsProxyDefault
    //   0	630	1	paramFile	File
    //   0	630	2	paramBoolean	boolean
    //   0	630	3	paramBridgeInfo	VideoJsProxyDefault.BridgeInfo
    //   305	27	4	d	double
    //   97	95	6	i	int
    //   300	3	7	l	long
    //   16	577	9	localObject1	Object
    //   612	1	9	localIOException1	java.io.IOException
    //   616	1	9	localObject2	Object
    //   64	551	10	localObject3	Object
    //   621	1	10	localIOException2	java.io.IOException
    //   68	516	11	localObject4	Object
    //   72	534	12	localObject5	Object
    //   120	173	13	localMediaFormat	MediaFormat
    //   379	1	13	localIOException3	java.io.IOException
    //   409	1	13	localIOException4	java.io.IOException
    //   431	1	13	localIOException5	java.io.IOException
    //   451	24	13	localIOException6	java.io.IOException
    //   383	102	14	localObject6	Object
    //   137	253	15	localLocalMediaInfo	LocalMediaInfo
    // Exception table:
    //   from	to	target	type
    //   150	161	379	java/io/IOException
    //   169	179	379	java/io/IOException
    //   205	218	379	java/io/IOException
    //   226	239	379	java/io/IOException
    //   250	263	379	java/io/IOException
    //   271	284	379	java/io/IOException
    //   292	302	379	java/io/IOException
    //   329	339	379	java/io/IOException
    //   347	356	379	java/io/IOException
    //   364	373	379	java/io/IOException
    //   74	84	409	java/io/IOException
    //   92	99	409	java/io/IOException
    //   113	122	409	java/io/IOException
    //   130	139	409	java/io/IOException
    //   57	66	424	finally
    //   57	66	431	java/io/IOException
    //   47	57	440	finally
    //   47	57	451	java/io/IOException
    //   74	84	582	finally
    //   92	99	582	finally
    //   113	122	582	finally
    //   130	139	582	finally
    //   150	161	582	finally
    //   169	179	582	finally
    //   205	218	582	finally
    //   226	239	582	finally
    //   250	263	582	finally
    //   271	284	582	finally
    //   292	302	582	finally
    //   329	339	582	finally
    //   347	356	582	finally
    //   364	373	582	finally
    //   469	479	582	finally
    //   397	402	612	java/io/IOException
    //   484	489	621	java/io/IOException
    //   592	597	626	java/io/IOException
  }
  
  private boolean hasFrontCamera(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
  }
  
  private void hideLoading()
  {
    this.mBridge.hideLoading();
  }
  
  private void respGetVideo(String paramString, long paramLong, LocalMediaInfo paramLocalMediaInfo, VideoJsProxyDefault.BridgeInfo paramBridgeInfo)
  {
    if (paramLocalMediaInfo == null)
    {
      this.mBridge.responseCancel(paramBridgeInfo.callbackId, "chooseVideo", null);
      return;
    }
    if (!TextUtils.isEmpty(paramLocalMediaInfo.thumbnailPath))
    {
      handleJsCallBack(paramString, paramLong, paramLocalMediaInfo, paramBridgeInfo);
      return;
    }
    ThreadManager.executeOnDiskIOThreadPool(new VideoJsProxyDefault.6(this, paramString, paramLocalMediaInfo, paramLong, paramBridgeInfo));
  }
  
  /* Error */
  private boolean saveThumbnail(Bitmap paramBitmap, LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 5
    //   5: iconst_0
    //   6: istore 4
    //   8: aload_1
    //   9: ifnonnull +13 -> 22
    //   12: ldc 20
    //   14: ldc_w 565
    //   17: invokestatic 567	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_2
    //   23: ifnonnull +13 -> 36
    //   26: ldc 20
    //   28: ldc_w 569
    //   31: invokestatic 567	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: iconst_0
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 99	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   40: ldc_w 279
    //   43: invokeinterface 285 2 0
    //   48: checkcast 279	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   51: ldc_w 571
    //   54: invokevirtual 574	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 6
    //   59: new 164	java/io/File
    //   62: dup
    //   63: aload 6
    //   65: invokespecial 575	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore 10
    //   70: aload 10
    //   72: invokevirtual 578	java/io/File:exists	()Z
    //   75: ifeq +9 -> 84
    //   78: aload 10
    //   80: invokevirtual 581	java/io/File:delete	()Z
    //   83: pop
    //   84: aconst_null
    //   85: astore 9
    //   87: new 583	java/io/FileOutputStream
    //   90: dup
    //   91: aload 10
    //   93: invokespecial 584	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   96: astore 8
    //   98: new 586	java/io/BufferedOutputStream
    //   101: dup
    //   102: aload 8
    //   104: sipush 4096
    //   107: invokespecial 589	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   110: astore 9
    //   112: aload 6
    //   114: astore 7
    //   116: aload_1
    //   117: getstatic 595	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   120: bipush 100
    //   122: aload 9
    //   124: invokevirtual 601	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   127: istore_3
    //   128: iload_3
    //   129: istore 4
    //   131: aload 6
    //   133: astore 7
    //   135: aload 9
    //   137: invokevirtual 604	java/io/BufferedOutputStream:flush	()V
    //   140: iload_3
    //   141: istore 4
    //   143: aload 6
    //   145: astore 7
    //   147: aload 10
    //   149: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   152: astore_1
    //   153: iload_3
    //   154: istore 4
    //   156: aload_1
    //   157: astore 7
    //   159: aload_2
    //   160: aload_0
    //   161: getfield 99	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   164: ldc_w 279
    //   167: invokeinterface 285 2 0
    //   172: checkcast 279	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   175: aload_1
    //   176: invokevirtual 540	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getWxFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   179: putfield 429	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:thumbnailPath	Ljava/lang/String;
    //   182: aload 8
    //   184: invokevirtual 605	java/io/FileOutputStream:close	()V
    //   187: goto +8 -> 195
    //   190: astore_2
    //   191: aload_2
    //   192: invokevirtual 606	java/io/IOException:printStackTrace	()V
    //   195: iload_3
    //   196: istore 4
    //   198: aload_1
    //   199: astore_2
    //   200: aload 9
    //   202: invokevirtual 607	java/io/BufferedOutputStream:close	()V
    //   205: iload_3
    //   206: istore 4
    //   208: aload_1
    //   209: astore_2
    //   210: goto +138 -> 348
    //   213: astore_1
    //   214: aload_1
    //   215: invokevirtual 606	java/io/IOException:printStackTrace	()V
    //   218: goto +130 -> 348
    //   221: astore_2
    //   222: aload 8
    //   224: astore 6
    //   226: aload 9
    //   228: astore_1
    //   229: goto +167 -> 396
    //   232: astore_2
    //   233: iload 4
    //   235: istore_3
    //   236: aload 7
    //   238: astore_1
    //   239: aload 9
    //   241: astore 7
    //   243: goto +20 -> 263
    //   246: astore_2
    //   247: aconst_null
    //   248: astore_1
    //   249: aload 8
    //   251: astore 6
    //   253: goto +143 -> 396
    //   256: astore_2
    //   257: aconst_null
    //   258: astore 7
    //   260: aload 6
    //   262: astore_1
    //   263: goto +27 -> 290
    //   266: astore_2
    //   267: aconst_null
    //   268: astore 6
    //   270: aload 6
    //   272: astore_1
    //   273: goto +123 -> 396
    //   276: astore_2
    //   277: aconst_null
    //   278: astore 7
    //   280: aload 9
    //   282: astore 8
    //   284: aload 6
    //   286: astore_1
    //   287: iload 5
    //   289: istore_3
    //   290: invokestatic 226	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   293: ifeq +12 -> 305
    //   296: ldc 20
    //   298: ldc_w 609
    //   301: aload_2
    //   302: invokestatic 534	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   305: aload 8
    //   307: ifnull +16 -> 323
    //   310: aload 8
    //   312: invokevirtual 605	java/io/FileOutputStream:close	()V
    //   315: goto +8 -> 323
    //   318: astore_2
    //   319: aload_2
    //   320: invokevirtual 606	java/io/IOException:printStackTrace	()V
    //   323: iload_3
    //   324: istore 4
    //   326: aload_1
    //   327: astore_2
    //   328: aload 7
    //   330: ifnull +18 -> 348
    //   333: iload_3
    //   334: istore 4
    //   336: aload_1
    //   337: astore_2
    //   338: aload 7
    //   340: invokevirtual 607	java/io/BufferedOutputStream:close	()V
    //   343: aload_1
    //   344: astore_2
    //   345: iload_3
    //   346: istore 4
    //   348: invokestatic 226	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   351: ifeq +34 -> 385
    //   354: new 127	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   361: astore_1
    //   362: aload_1
    //   363: ldc_w 611
    //   366: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload_1
    //   371: aload_2
    //   372: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: ldc 20
    //   378: aload_1
    //   379: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 344	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: iload 4
    //   387: ireturn
    //   388: astore_2
    //   389: aload 8
    //   391: astore 6
    //   393: aload 7
    //   395: astore_1
    //   396: aload 6
    //   398: ifnull +18 -> 416
    //   401: aload 6
    //   403: invokevirtual 605	java/io/FileOutputStream:close	()V
    //   406: goto +10 -> 416
    //   409: astore 6
    //   411: aload 6
    //   413: invokevirtual 606	java/io/IOException:printStackTrace	()V
    //   416: aload_1
    //   417: ifnull +15 -> 432
    //   420: aload_1
    //   421: invokevirtual 607	java/io/BufferedOutputStream:close	()V
    //   424: goto +8 -> 432
    //   427: astore_1
    //   428: aload_1
    //   429: invokevirtual 606	java/io/IOException:printStackTrace	()V
    //   432: aload_2
    //   433: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	VideoJsProxyDefault
    //   0	434	1	paramBitmap	Bitmap
    //   0	434	2	paramLocalMediaInfo	LocalMediaInfo
    //   1	345	3	bool1	boolean
    //   6	380	4	bool2	boolean
    //   3	285	5	bool3	boolean
    //   57	345	6	localObject1	Object
    //   409	3	6	localIOException	java.io.IOException
    //   114	280	7	localObject2	Object
    //   96	294	8	localObject3	Object
    //   85	196	9	localBufferedOutputStream	java.io.BufferedOutputStream
    //   68	80	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   182	187	190	java/io/IOException
    //   200	205	213	java/io/IOException
    //   338	343	213	java/io/IOException
    //   116	128	221	finally
    //   135	140	221	finally
    //   147	153	221	finally
    //   159	182	221	finally
    //   116	128	232	java/lang/Exception
    //   135	140	232	java/lang/Exception
    //   147	153	232	java/lang/Exception
    //   159	182	232	java/lang/Exception
    //   98	112	246	finally
    //   98	112	256	java/lang/Exception
    //   87	98	266	finally
    //   87	98	276	java/lang/Exception
    //   310	315	318	java/io/IOException
    //   290	305	388	finally
    //   401	406	409	java/io/IOException
    //   420	424	427	java/io/IOException
  }
  
  private void showLoading(String paramString)
  {
    this.mBridge.showLoading(paramString);
  }
  
  private void startCompress(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean, VideoJsProxyDefault.BridgeInfo paramBridgeInfo)
  {
    int i;
    try
    {
      i = paramLocalMediaInfo.path.lastIndexOf(".");
      if (i < 0) {
        localObject1 = "";
      } else {
        localObject1 = paramLocalMediaInfo.path.substring(i + 1);
      }
    }
    catch (Exception paramLocalMediaInfo)
    {
      Object localObject2;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startCompress=e=");
      ((StringBuilder)localObject1).append(paramLocalMediaInfo.getMessage());
      QMLog.e("VideoJsProxyImpl", ((StringBuilder)localObject1).toString());
      this.mBridge.responseFail(paramBridgeInfo.callbackId, paramBridgeInfo.eventName, null, paramLocalMediaInfo.getMessage());
      return;
    }
    if (paramLocalMediaInfo.path.contains(" "))
    {
      copyExecutor.execute(new VideoJsProxyDefault.4(this, paramLocalMediaInfo, (String)localObject1, paramBridgeInfo, paramBoolean));
      return;
    }
    localObject1 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath((String)localObject1);
    localObject2 = new File((String)localObject1);
    if (((File)localObject2).exists()) {
      ((File)localObject2).delete();
    }
    if (paramLocalMediaInfo.mediaWidth <= 3000) {
      if (paramLocalMediaInfo.mediaHeight > 3000) {
        break label270;
      }
    }
    for (;;)
    {
      localObject2 = new VideoCompress.Option();
      ((VideoCompress.Option)localObject2).crf = 29;
      ((VideoCompress.Option)localObject2).targetEncoding = VideoCompress.TargetEncoding.x264;
      ((VideoCompress.Option)localObject2).targetFrameRate = 20;
      if (paramBoolean) {
        ((VideoCompress.Option)localObject2).scale = i;
      }
      execVideoCompress(paramLocalMediaInfo, (String)localObject1, (VideoCompress.Option)localObject2, paramBridgeInfo);
      return;
      break;
      i = 2;
      continue;
      label270:
      i = 4;
    }
  }
  
  private void updateLoading(String paramString)
  {
    this.mBridge.updateLoading(paramString);
  }
  
  public void chooseVideo(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Log.i("VideoJsProxyImpl", "chooseVideo");
    for (;;)
    {
      int i;
      try
      {
        localJSONObject = new JSONObject(paramString2);
        paramString2 = localJSONObject.optJSONArray("sourceType");
        bool1 = localJSONObject.optBoolean("compressed");
        bool2 = localJSONObject.optString("camera").equals("front");
        localBridgeInfo = new VideoJsProxyDefault.BridgeInfo();
        localBridgeInfo.callbackId = paramInt;
        localBridgeInfo.eventName = paramString1;
        i = paramString2.length();
        if (i != 0) {
          break label349;
        }
        this.mBridge.responseFail(paramInt, paramString1, null, "fail sourceType error");
        return;
      }
      catch (Throwable paramActivity)
      {
        JSONObject localJSONObject;
        boolean bool1;
        boolean bool2;
        VideoJsProxyDefault.BridgeInfo localBridgeInfo;
        Object localObject;
        paramActivity.printStackTrace();
        this.mBridge.responseFail(paramInt, paramString1, null, paramActivity.getMessage());
        return;
      }
      if (i < paramString2.length())
      {
        localObject = paramString2.opt(i);
        if ((!localObject.equals("album")) && (!localObject.equals("camera")))
        {
          paramActivity = new StringBuilder();
          paramActivity.append("API_CHOOSE_VIDEO sourceType error. ");
          paramActivity.append(paramString2.opt(i));
          QMLog.e("VideoJsProxyImpl", paramActivity.toString());
          this.mBridge.responseFail(paramInt, paramString1, null, "fail sourceType error");
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sourceType: ");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(" length: ");
        ((StringBuilder)localObject).append(paramString2.length());
        QMLog.d("VideoJsPlugin", ((StringBuilder)localObject).toString());
        i = localJSONObject.optInt("maxDuration");
        if (paramString2.length() == 2)
        {
          AppBrandTask.runTaskOnUiThread(new VideoJsProxyDefault.1(this, paramActivity, i, bool1, bool2, localBridgeInfo));
          return;
        }
        if ("camera".equals(paramString2.optString(0)))
        {
          goToCamera(paramActivity, i, bool1, bool2, localBridgeInfo);
          return;
        }
        goToPic(paramActivity, i, bool1, localBridgeInfo);
        return;
        label349:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public void create(IMiniAppContext paramIMiniAppContext)
  {
    Log.i("VideoJsProxyImpl", "create");
  }
  
  public void destroy()
  {
    Log.i("VideoJsProxyImpl", "destroy");
    super.destroy();
  }
  
  public String getPath(Context paramContext, Uri paramUri)
  {
    paramContext = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
    if (paramContext != null)
    {
      int i = paramContext.getColumnIndexOrThrow("_data");
      paramContext.moveToFirst();
      return paramContext.getString(i);
    }
    return null;
  }
  
  public void saveVideoToPhotosAlbum(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Log.i("VideoJsProxyImpl", "saveVideoToPhotosAlbum");
    try
    {
      paramString2 = new JSONObject(paramString2).optString("filePath");
      if (StringUtil.isEmpty(paramString2))
      {
        this.mBridge.responseFail(paramInt, paramString1, null, "fail file not exists");
        return;
      }
      if (FileUtils.saveVideoToAlbum(paramActivity, ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString2), getSaveVideoFilePath()))
      {
        this.mBridge.responseOk(paramInt, paramString1, null);
        return;
      }
      this.mBridge.responseFail(paramInt, paramString1, null, "fail filePath invalid");
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
      this.mBridge.responseFail(paramInt, paramString1, null, paramActivity.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault
 * JD-Core Version:    0.7.0.1
 */