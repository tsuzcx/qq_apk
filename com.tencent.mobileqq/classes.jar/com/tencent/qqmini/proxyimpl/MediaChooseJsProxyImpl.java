package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.IQIMCameraCapture;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationMiniApp;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationMiniApp;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationMiniApp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy.Bridge;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

@ProxyService(proxy=MediaChooseJsProxy.class)
public class MediaChooseJsProxyImpl
  extends MediaChooseJsProxy
{
  private WeakReference<Activity> a;
  private IMiniAppContext b;
  private int c = -1;
  private long d = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxDuration", 600000L);
  private long e = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxSize", 1610612736L);
  private boolean f = false;
  private BroadcastReceiver g = new MediaChooseJsProxyImpl.1(this);
  
  private long a(JSONObject paramJSONObject)
  {
    int k = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppChooseMediaMaxDuration", 60);
    int j = paramJSONObject.optInt("maxDuration", QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppChooseMediaDefaultDuration", 10));
    int i = j;
    if (j < 3) {
      i = 3;
    }
    j = i;
    if (i > k) {
      j = k;
    }
    return j;
  }
  
  private Bitmap a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return ShortVideoUtils.getVideoThumbnail(null, paramString);
    }
    return null;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaChooseJsProxyImpl", 2, "unregisterAvatarReceiver");
    }
    try
    {
      if (this.a != null)
      {
        ((Activity)this.a.get()).unregisterReceiver(this.g);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MediaChooseJsProxyImpl", 1, "unregisterReceiver exception.", localThrowable);
    }
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
    Object localObject = this.a;
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
  
  private void a(Activity paramActivity, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = true;
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramActivity, "/base/album/photolist");
    localActivityURIRequest.extra().putInt("enter_from", 4);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationMiniApp.a);
    localActivityURIRequest.extra().putString("KEY_ALBUM_LIST_CLASS_NAME", AlbumListCustomizationMiniApp.j);
    localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationMiniApp.a);
    if (paramInt2 == 0) {
      localActivityURIRequest.extra().putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    } else if (paramInt2 == 1) {
      localActivityURIRequest.extra().putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    } else if (paramInt2 == 2) {
      localActivityURIRequest.extra().putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    }
    localActivityURIRequest.extra().putString("PhotoConst.DEST_BROADCAST_ACTION_NAME", "get_media_info");
    localActivityURIRequest.extra().putBoolean("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
    localActivityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", paramInt3);
    localActivityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", paramInt3);
    localActivityURIRequest.extra().putLong("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", this.e);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", false);
    localActivityURIRequest.extra().putBoolean("from_miniapp_enable_bottombar", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
    if (paramInt1 == 0) {
      localActivityURIRequest.extra().putBoolean("PhotoConst.original_button", true);
    }
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_PREVIEW_VIDEO", true);
    localActivityURIRequest.extra().putInt("from_miniapp_cur_sizetype", paramInt1);
    QRoute.startUri(localActivityURIRequest);
    AlbumUtil.anim(paramActivity, false, true);
  }
  
  private void a(Activity paramActivity, long paramLong, boolean paramBoolean, int paramInt)
  {
    Object localObject = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
    ((IActivityResultManager)localObject).addActivityResultListener(new MediaChooseJsProxyImpl.3(this, (IActivityResultManager)localObject));
    localObject = new Bundle();
    ((Bundle)localObject).putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    ((Bundle)localObject).putBoolean("PeakConstants.ARG_ALBUM", false);
    ((Bundle)localObject).putInt("edit_video_type", 10020);
    ((Bundle)localObject).putInt("key_camera_photo_edit_type", 3);
    ((Bundle)localObject).putInt("key_camera_video_edit_type", 5);
    ((Bundle)localObject).putBoolean("extra_directly_back", true);
    ((Bundle)localObject).putString("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", "com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity");
    ((Bundle)localObject).putBoolean("enable_edit_video", true);
    ((Bundle)localObject).putBoolean("enable_input_text", false);
    ((Bundle)localObject).putBoolean("enable_priv_list", false);
    ((Bundle)localObject).putInt("entry_source", 5);
    ((Bundle)localObject).putBoolean("support_record", true);
    ((Bundle)localObject).putBoolean("enable_local_video", false);
    ((Bundle)localObject).putBoolean("enable_local_button", false);
    ((Bundle)localObject).putBoolean("go_publish_activity", false);
    ((Bundle)localObject).putBoolean("enterPtu", false);
    ((Bundle)localObject).putBoolean("support_pic", true);
    ((Bundle)localObject).putBoolean("key_disable_face_detect", true);
    ((Bundle)localObject).putBoolean("key_need_check_sensitive", false);
    if (paramInt == 0) {
      ((Bundle)localObject).putInt("ability_flag", 1);
    } else if (paramInt == 1) {
      ((Bundle)localObject).putInt("ability_flag", 2);
    } else if (paramInt == 2) {
      ((Bundle)localObject).putInt("ability_flag", 3);
    }
    ((Bundle)localObject).putInt("ARG_CAPTURE_MAX_DURATION", (int)paramLong * 1000);
    if (paramBoolean) {
      ((Bundle)localObject).putInt("PeakConstants.ARG_FORCE_CAMERA", 1);
    } else {
      ((Bundle)localObject).putInt("PeakConstants.ARG_FORCE_CAMERA", 2);
    }
    ((Bundle)localObject).putBoolean("need_show_banner", false);
    Intent localIntent = new Intent(paramActivity, ((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).getQIMCameraCaptureActivityClass());
    localIntent.putExtras((Bundle)localObject);
    localIntent.putExtra("need_show_banner", false);
    paramActivity.startActivityForResult(localIntent, 10020);
  }
  
  /* Error */
  private boolean a(Bitmap paramBitmap, com.tencent.mobileqq.activity.photo.LocalMediaInfo paramLocalMediaInfo)
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
    //   12: ldc 100
    //   14: iconst_2
    //   15: ldc_w 369
    //   18: invokestatic 372	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_2
    //   24: ifnonnull +14 -> 38
    //   27: ldc 100
    //   29: iconst_2
    //   30: ldc_w 374
    //   33: invokestatic 372	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: iconst_0
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 376	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:b	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   42: ldc_w 378
    //   45: invokeinterface 384 2 0
    //   50: checkcast 378	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   53: ldc_w 386
    //   56: invokeinterface 390 2 0
    //   61: astore 6
    //   63: new 392	java/io/File
    //   66: dup
    //   67: aload 6
    //   69: invokespecial 394	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore 10
    //   74: aload 10
    //   76: invokevirtual 397	java/io/File:exists	()Z
    //   79: ifeq +9 -> 88
    //   82: aload 10
    //   84: invokevirtual 400	java/io/File:delete	()Z
    //   87: pop
    //   88: aconst_null
    //   89: astore 9
    //   91: new 402	java/io/FileOutputStream
    //   94: dup
    //   95: aload 10
    //   97: invokespecial 405	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   100: astore 8
    //   102: new 407	java/io/BufferedOutputStream
    //   105: dup
    //   106: aload 8
    //   108: sipush 4096
    //   111: invokespecial 410	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   114: astore 9
    //   116: aload 6
    //   118: astore 7
    //   120: aload_1
    //   121: getstatic 416	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   124: bipush 100
    //   126: aload 9
    //   128: invokevirtual 422	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   131: istore_3
    //   132: iload_3
    //   133: istore 4
    //   135: aload 6
    //   137: astore 7
    //   139: aload 9
    //   141: invokevirtual 425	java/io/BufferedOutputStream:flush	()V
    //   144: iload_3
    //   145: istore 4
    //   147: aload 6
    //   149: astore 7
    //   151: aload 10
    //   153: invokevirtual 429	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   156: astore_1
    //   157: iload_3
    //   158: istore 4
    //   160: aload_1
    //   161: astore 7
    //   163: aload_2
    //   164: aload_0
    //   165: getfield 376	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:b	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   168: ldc_w 378
    //   171: invokeinterface 384 2 0
    //   176: checkcast 378	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   179: aload_1
    //   180: invokeinterface 432 2 0
    //   185: putfield 437	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbnailPath	Ljava/lang/String;
    //   188: aload 8
    //   190: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   193: goto +8 -> 201
    //   196: astore_2
    //   197: aload_2
    //   198: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   201: iload_3
    //   202: istore 4
    //   204: aload_1
    //   205: astore_2
    //   206: aload 9
    //   208: invokevirtual 444	java/io/BufferedOutputStream:close	()V
    //   211: iload_3
    //   212: istore 4
    //   214: aload_1
    //   215: astore_2
    //   216: goto +139 -> 355
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   224: goto +131 -> 355
    //   227: astore_2
    //   228: aload 8
    //   230: astore 6
    //   232: aload 9
    //   234: astore_1
    //   235: goto +169 -> 404
    //   238: astore_2
    //   239: iload 4
    //   241: istore_3
    //   242: aload 7
    //   244: astore_1
    //   245: aload 9
    //   247: astore 7
    //   249: goto +20 -> 269
    //   252: astore_2
    //   253: aconst_null
    //   254: astore_1
    //   255: aload 8
    //   257: astore 6
    //   259: goto +145 -> 404
    //   262: astore_2
    //   263: aconst_null
    //   264: astore 7
    //   266: aload 6
    //   268: astore_1
    //   269: goto +27 -> 296
    //   272: astore_2
    //   273: aconst_null
    //   274: astore 6
    //   276: aload 6
    //   278: astore_1
    //   279: goto +125 -> 404
    //   282: astore_2
    //   283: aconst_null
    //   284: astore 7
    //   286: aload 9
    //   288: astore 8
    //   290: aload 6
    //   292: astore_1
    //   293: iload 5
    //   295: istore_3
    //   296: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +13 -> 312
    //   302: ldc 100
    //   304: iconst_2
    //   305: ldc_w 446
    //   308: aload_2
    //   309: invokestatic 448	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   312: aload 8
    //   314: ifnull +16 -> 330
    //   317: aload 8
    //   319: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   322: goto +8 -> 330
    //   325: astore_2
    //   326: aload_2
    //   327: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   330: iload_3
    //   331: istore 4
    //   333: aload_1
    //   334: astore_2
    //   335: aload 7
    //   337: ifnull +18 -> 355
    //   340: iload_3
    //   341: istore 4
    //   343: aload_1
    //   344: astore_2
    //   345: aload 7
    //   347: invokevirtual 444	java/io/BufferedOutputStream:close	()V
    //   350: aload_1
    //   351: astore_2
    //   352: iload_3
    //   353: istore 4
    //   355: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +35 -> 393
    //   361: new 450	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 451	java/lang/StringBuilder:<init>	()V
    //   368: astore_1
    //   369: aload_1
    //   370: ldc_w 453
    //   373: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload_1
    //   378: aload_2
    //   379: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: ldc 100
    //   385: iconst_2
    //   386: aload_1
    //   387: invokevirtual 460	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 463	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: iload 4
    //   395: ireturn
    //   396: astore_2
    //   397: aload 8
    //   399: astore 6
    //   401: aload 7
    //   403: astore_1
    //   404: aload 6
    //   406: ifnull +18 -> 424
    //   409: aload 6
    //   411: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   414: goto +10 -> 424
    //   417: astore 6
    //   419: aload 6
    //   421: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   424: aload_1
    //   425: ifnull +15 -> 440
    //   428: aload_1
    //   429: invokevirtual 444	java/io/BufferedOutputStream:close	()V
    //   432: goto +8 -> 440
    //   435: astore_1
    //   436: aload_1
    //   437: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   440: aload_2
    //   441: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	442	0	this	MediaChooseJsProxyImpl
    //   0	442	1	paramBitmap	Bitmap
    //   0	442	2	paramLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    //   1	352	3	bool1	boolean
    //   6	388	4	bool2	boolean
    //   3	291	5	bool3	boolean
    //   61	349	6	localObject1	Object
    //   417	3	6	localIOException	java.io.IOException
    //   118	284	7	localObject2	Object
    //   100	298	8	localObject3	Object
    //   89	198	9	localBufferedOutputStream	java.io.BufferedOutputStream
    //   72	80	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   188	193	196	java/io/IOException
    //   206	211	219	java/io/IOException
    //   345	350	219	java/io/IOException
    //   120	132	227	finally
    //   139	144	227	finally
    //   151	157	227	finally
    //   163	188	227	finally
    //   120	132	238	java/lang/Exception
    //   139	144	238	java/lang/Exception
    //   151	157	238	java/lang/Exception
    //   163	188	238	java/lang/Exception
    //   102	116	252	finally
    //   102	116	262	java/lang/Exception
    //   91	102	272	finally
    //   91	102	282	java/lang/Exception
    //   317	322	325	java/io/IOException
    //   296	312	396	finally
    //   409	414	417	java/io/IOException
    //   428	432	435	java/io/IOException
  }
  
  private int b(JSONObject paramJSONObject)
  {
    int k = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppChooseMediaMaxCount", 15);
    int j = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppChooseMediaDefaultCount", 15);
    int m = paramJSONObject.optInt("count", j);
    int i = m;
    if (m < 0) {
      i = j;
    }
    j = i;
    if (i > k) {
      j = k;
    }
    return j;
  }
  
  /* Error */
  private String b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aload_1
    //   8: areturn
    //   9: new 392	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 394	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload_0
    //   20: getfield 376	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:b	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   23: ldc_w 378
    //   26: invokeinterface 384 2 0
    //   31: checkcast 378	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   34: ldc_w 481
    //   37: invokeinterface 390 2 0
    //   42: astore 11
    //   44: new 392	java/io/File
    //   47: dup
    //   48: aload 11
    //   50: invokespecial 394	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 12
    //   55: aconst_null
    //   56: astore 8
    //   58: aconst_null
    //   59: astore 9
    //   61: aconst_null
    //   62: astore 7
    //   64: aload 8
    //   66: astore_3
    //   67: aload 9
    //   69: astore 5
    //   71: new 450	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 451	java/lang/StringBuilder:<init>	()V
    //   78: astore 6
    //   80: aload 8
    //   82: astore_3
    //   83: aload 9
    //   85: astore 5
    //   87: aload 6
    //   89: ldc_w 483
    //   92: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 8
    //   98: astore_3
    //   99: aload 9
    //   101: astore 5
    //   103: aload 6
    //   105: aload 4
    //   107: invokevirtual 486	java/io/File:length	()J
    //   110: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 8
    //   116: astore_3
    //   117: aload 9
    //   119: astore 5
    //   121: ldc 100
    //   123: iconst_1
    //   124: aload 6
    //   126: invokevirtual 460	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload 8
    //   134: astore_3
    //   135: aload 9
    //   137: astore 5
    //   139: new 491	android/graphics/BitmapFactory$Options
    //   142: dup
    //   143: invokespecial 492	android/graphics/BitmapFactory$Options:<init>	()V
    //   146: astore 4
    //   148: aload 8
    //   150: astore_3
    //   151: aload 9
    //   153: astore 5
    //   155: aload 4
    //   157: iconst_2
    //   158: putfield 495	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   161: aload 8
    //   163: astore_3
    //   164: aload 9
    //   166: astore 5
    //   168: aload_1
    //   169: aload 4
    //   171: invokestatic 501	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   174: astore 10
    //   176: aload 7
    //   178: astore 4
    //   180: aload 10
    //   182: ifnull +180 -> 362
    //   185: aload 8
    //   187: astore_3
    //   188: aload 9
    //   190: astore 5
    //   192: aload_1
    //   193: invokestatic 507	com/tencent/mobileqq/mini/util/ImageUtil:getExifOrientation	(Ljava/lang/String;)I
    //   196: istore_2
    //   197: aload 8
    //   199: astore_3
    //   200: aload 9
    //   202: astore 5
    //   204: new 450	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 451	java/lang/StringBuilder:<init>	()V
    //   211: astore 4
    //   213: aload 8
    //   215: astore_3
    //   216: aload 9
    //   218: astore 5
    //   220: aload 4
    //   222: ldc_w 509
    //   225: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 8
    //   231: astore_3
    //   232: aload 9
    //   234: astore 5
    //   236: aload 4
    //   238: iload_2
    //   239: invokevirtual 512	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 8
    //   245: astore_3
    //   246: aload 9
    //   248: astore 5
    //   250: ldc 100
    //   252: iconst_1
    //   253: aload 4
    //   255: invokevirtual 460	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload 10
    //   263: astore 6
    //   265: iload_2
    //   266: ifeq +30 -> 296
    //   269: aload 8
    //   271: astore_3
    //   272: aload 9
    //   274: astore 5
    //   276: iload_2
    //   277: aload 10
    //   279: invokestatic 516	com/tencent/mobileqq/mini/util/ImageUtil:rotaingImageView	(ILandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   282: astore 6
    //   284: aload 8
    //   286: astore_3
    //   287: aload 9
    //   289: astore 5
    //   291: aload 10
    //   293: invokevirtual 519	android/graphics/Bitmap:recycle	()V
    //   296: aload 7
    //   298: astore 4
    //   300: aload 6
    //   302: ifnull +60 -> 362
    //   305: aload 8
    //   307: astore_3
    //   308: aload 9
    //   310: astore 5
    //   312: new 402	java/io/FileOutputStream
    //   315: dup
    //   316: aload 12
    //   318: invokespecial 405	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   321: astore 4
    //   323: aload 6
    //   325: getstatic 416	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   328: bipush 50
    //   330: aload 4
    //   332: invokevirtual 422	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   335: pop
    //   336: aload 4
    //   338: invokevirtual 520	java/io/FileOutputStream:flush	()V
    //   341: goto +21 -> 362
    //   344: astore_1
    //   345: aload 4
    //   347: astore_3
    //   348: goto +127 -> 475
    //   351: astore_3
    //   352: aload 4
    //   354: astore 5
    //   356: aload_3
    //   357: astore 4
    //   359: goto +90 -> 449
    //   362: aload 4
    //   364: astore_3
    //   365: aload 4
    //   367: astore 5
    //   369: new 450	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 451	java/lang/StringBuilder:<init>	()V
    //   376: astore 6
    //   378: aload 4
    //   380: astore_3
    //   381: aload 4
    //   383: astore 5
    //   385: aload 6
    //   387: ldc_w 522
    //   390: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload 4
    //   396: astore_3
    //   397: aload 4
    //   399: astore 5
    //   401: aload 6
    //   403: aload 12
    //   405: invokevirtual 486	java/io/File:length	()J
    //   408: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload 4
    //   414: astore_3
    //   415: aload 4
    //   417: astore 5
    //   419: ldc 100
    //   421: iconst_1
    //   422: aload 6
    //   424: invokevirtual 460	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: aload 4
    //   432: ifnull +8 -> 440
    //   435: aload 4
    //   437: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   440: aload 11
    //   442: areturn
    //   443: astore_1
    //   444: goto +31 -> 475
    //   447: astore 4
    //   449: aload 5
    //   451: astore_3
    //   452: ldc 100
    //   454: iconst_1
    //   455: ldc_w 524
    //   458: aload 4
    //   460: invokestatic 124	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   463: aload 5
    //   465: ifnull +8 -> 473
    //   468: aload 5
    //   470: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   473: aload_1
    //   474: areturn
    //   475: aload_3
    //   476: ifnull +7 -> 483
    //   479: aload_3
    //   480: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   483: aload_1
    //   484: athrow
    //   485: astore_1
    //   486: aload 11
    //   488: areturn
    //   489: astore_3
    //   490: aload_1
    //   491: areturn
    //   492: astore_3
    //   493: goto -10 -> 483
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	496	0	this	MediaChooseJsProxyImpl
    //   0	496	1	paramString	String
    //   196	81	2	i	int
    //   66	282	3	localObject1	Object
    //   351	6	3	localThrowable1	Throwable
    //   364	116	3	localObject2	Object
    //   489	1	3	localException1	Exception
    //   492	1	3	localException2	Exception
    //   17	419	4	localObject3	Object
    //   447	12	4	localThrowable2	Throwable
    //   69	400	5	localObject4	Object
    //   78	345	6	localObject5	Object
    //   62	235	7	localObject6	Object
    //   56	250	8	localObject7	Object
    //   59	250	9	localObject8	Object
    //   174	118	10	localBitmap	Bitmap
    //   42	445	11	str	String
    //   53	351	12	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   323	341	344	finally
    //   323	341	351	java/lang/Throwable
    //   71	80	443	finally
    //   87	96	443	finally
    //   103	114	443	finally
    //   121	132	443	finally
    //   139	148	443	finally
    //   155	161	443	finally
    //   168	176	443	finally
    //   192	197	443	finally
    //   204	213	443	finally
    //   220	229	443	finally
    //   236	243	443	finally
    //   250	261	443	finally
    //   276	284	443	finally
    //   291	296	443	finally
    //   312	323	443	finally
    //   369	378	443	finally
    //   385	394	443	finally
    //   401	412	443	finally
    //   419	430	443	finally
    //   452	463	443	finally
    //   71	80	447	java/lang/Throwable
    //   87	96	447	java/lang/Throwable
    //   103	114	447	java/lang/Throwable
    //   121	132	447	java/lang/Throwable
    //   139	148	447	java/lang/Throwable
    //   155	161	447	java/lang/Throwable
    //   168	176	447	java/lang/Throwable
    //   192	197	447	java/lang/Throwable
    //   204	213	447	java/lang/Throwable
    //   220	229	447	java/lang/Throwable
    //   236	243	447	java/lang/Throwable
    //   250	261	447	java/lang/Throwable
    //   276	284	447	java/lang/Throwable
    //   291	296	447	java/lang/Throwable
    //   312	323	447	java/lang/Throwable
    //   369	378	447	java/lang/Throwable
    //   385	394	447	java/lang/Throwable
    //   401	412	447	java/lang/Throwable
    //   419	430	447	java/lang/Throwable
    //   435	440	485	java/lang/Exception
    //   468	473	489	java/lang/Exception
    //   479	483	492	java/lang/Exception
  }
  
  private void b()
  {
    QLog.i("MediaChooseJsProxyImpl", 1, "hideLoading");
    if (this.mBridge != null) {
      this.mBridge.hideLoading();
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
    QLog.d("MediaChooseJsProxyImpl", 2, "registerAvatarReceiver");
    this.a = new WeakReference(paramActivity);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("get_media_info");
    paramActivity.registerReceiver(this.g, localIntentFilter);
  }
  
  private void c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showLoading ");
    localStringBuilder.append(paramString);
    QLog.i("MediaChooseJsProxyImpl", 1, localStringBuilder.toString());
    if (this.mBridge != null) {
      this.mBridge.showLoading(paramString);
    }
  }
  
  public void chooseMedia(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    this.c = paramInt;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        if ("chooseMedia".equals(paramString1))
        {
          Object localObject = localJSONObject.optJSONArray("sourceType");
          JSONArray localJSONArray2 = localJSONObject.optJSONArray("mediaType");
          JSONArray localJSONArray1 = localJSONObject.optJSONArray("sizeType");
          boolean bool = localJSONObject.optString("camera").equals("front");
          int k = 1;
          if (localObject != null)
          {
            if (((JSONArray)localObject).length() != 0) {
              break label717;
            }
            continue;
            paramString2 = (String)localObject;
            if (i >= ((JSONArray)localObject).length()) {
              continue;
            }
            paramString2 = ((JSONArray)localObject).opt(i);
            if ((paramString2.equals("album")) || (paramString2.equals("camera"))) {
              break label723;
            }
            paramActivity = new StringBuilder();
            paramActivity.append("API_CHOOSE_MEDIA sourceType error. ");
            paramActivity.append(((JSONArray)localObject).opt(i));
            QLog.e("MediaChooseJsProxyImpl", 1, paramActivity.toString());
            a(paramInt, paramString1, null, "fail sourceType error");
            return;
          }
          paramString2 = new JSONArray();
          paramString2.put("album");
          paramString2.put("camera");
          if (localJSONArray2 == null) {
            break label747;
          }
          if (localJSONArray2.length() != 0) {
            break label732;
          }
          break label747;
          j = localJSONArray2.length();
          if (i < j)
          {
            localObject = localJSONArray2.opt(i);
            if ((localObject.equals("image")) || (localObject.equals("video"))) {
              break label738;
            }
            paramActivity = new StringBuilder();
            paramActivity.append("API_CHOOSE_MEDIA mediaType error. ");
            paramActivity.append(localObject);
            QLog.e("MediaChooseJsProxyImpl", 1, paramActivity.toString());
            a(paramInt, paramString1, null, "fail mediaType error");
            return;
          }
          if (localJSONArray2.length() == 2) {
            break label747;
          }
          localObject = localJSONArray2.opt(0);
          if (localObject.equals("image"))
          {
            i = 1;
          }
          else
          {
            if (!localObject.equals("video")) {
              break label747;
            }
            i = 2;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("chooseMedia sourceType: ");
            ((StringBuilder)localObject).append(paramString2);
            ((StringBuilder)localObject).append(" length: ");
            ((StringBuilder)localObject).append(paramString2.length());
            QLog.d("MediaChooseJsProxyImpl", 2, ((StringBuilder)localObject).toString());
          }
          if (localJSONArray1 == null) {
            break label768;
          }
          if (localJSONArray1.length() != 0) {
            break label753;
          }
          break label768;
          int m = localJSONArray1.length();
          if (j < m)
          {
            localObject = localJSONArray1.opt(j);
            if ((localObject.equals("compressed")) || (localObject.equals("original"))) {
              break label759;
            }
            paramActivity = new StringBuilder();
            paramActivity.append("API_CHOOSE_MEDIA sizeType error. ");
            paramActivity.append(localObject);
            QLog.e("MediaChooseJsProxyImpl", 1, paramActivity.toString());
            paramActivity = new StringBuilder();
            paramActivity.append("fail sizeType error:");
            paramActivity.append(localObject);
            a(paramInt, paramString1, null, paramActivity.toString());
            return;
          }
          if (localJSONArray1.length() == 2) {
            break label768;
          }
          paramString1 = localJSONArray1.opt(0);
          if (paramString1.equals("compressed"))
          {
            paramInt = 2;
          }
          else
          {
            if (!paramString1.equals("original")) {
              break label768;
            }
            paramInt = k;
          }
          long l = a(localJSONObject);
          j = b(localJSONObject);
          if (paramString2.length() == 2)
          {
            AppBrandTask.runTaskOnUiThread(new MediaChooseJsProxyImpl.2(this, paramActivity, l, bool, i, paramInt, j));
            return;
          }
          if ("camera".equals(paramString2.optString(0)))
          {
            a(paramActivity, l, bool, i);
            return;
          }
          if ("album".equals(paramString2.optString(0)))
          {
            a(paramActivity);
            a(paramActivity, l, paramInt, i, j);
          }
        }
        return;
      }
      catch (Exception paramActivity)
      {
        return;
      }
      label717:
      int i = 0;
      continue;
      label723:
      i += 1;
      continue;
      label732:
      i = 0;
      continue;
      label738:
      i += 1;
      continue;
      label747:
      i = 0;
      continue;
      label753:
      int j = 0;
      continue;
      label759:
      j += 1;
      continue;
      label768:
      paramInt = 0;
    }
  }
  
  public void create(IMiniAppContext paramIMiniAppContext)
  {
    this.b = paramIMiniAppContext;
  }
  
  public void destroy()
  {
    a();
    super.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaChooseJsProxyImpl
 * JD-Core Version:    0.7.0.1
 */