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
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxDuration", 600000L);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new MediaChooseJsProxyImpl.1(this);
  private IMiniAppContext jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private long b = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxSize", 1610612736L);
  
  private int a(JSONObject paramJSONObject)
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
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aload_1
    //   8: areturn
    //   9: new 109	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload_0
    //   20: getfield 99	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   23: ldc 114
    //   25: invokeinterface 120 2 0
    //   30: checkcast 114	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   33: ldc 122
    //   35: invokeinterface 125 2 0
    //   40: astore 11
    //   42: new 109	java/io/File
    //   45: dup
    //   46: aload 11
    //   48: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore 12
    //   53: aconst_null
    //   54: astore 8
    //   56: aconst_null
    //   57: astore 9
    //   59: aconst_null
    //   60: astore 7
    //   62: aload 8
    //   64: astore_3
    //   65: aload 9
    //   67: astore 5
    //   69: new 127	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   76: astore 6
    //   78: aload 8
    //   80: astore_3
    //   81: aload 9
    //   83: astore 5
    //   85: aload 6
    //   87: ldc 130
    //   89: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 8
    //   95: astore_3
    //   96: aload 9
    //   98: astore 5
    //   100: aload 6
    //   102: aload 4
    //   104: invokevirtual 138	java/io/File:length	()J
    //   107: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 8
    //   113: astore_3
    //   114: aload 9
    //   116: astore 5
    //   118: ldc 143
    //   120: iconst_1
    //   121: aload 6
    //   123: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: aload 8
    //   131: astore_3
    //   132: aload 9
    //   134: astore 5
    //   136: new 155	android/graphics/BitmapFactory$Options
    //   139: dup
    //   140: invokespecial 156	android/graphics/BitmapFactory$Options:<init>	()V
    //   143: astore 4
    //   145: aload 8
    //   147: astore_3
    //   148: aload 9
    //   150: astore 5
    //   152: aload 4
    //   154: iconst_2
    //   155: putfield 159	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   158: aload 8
    //   160: astore_3
    //   161: aload 9
    //   163: astore 5
    //   165: aload_1
    //   166: aload 4
    //   168: invokestatic 165	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   171: astore 10
    //   173: aload 7
    //   175: astore 4
    //   177: aload 10
    //   179: ifnull +179 -> 358
    //   182: aload 8
    //   184: astore_3
    //   185: aload 9
    //   187: astore 5
    //   189: aload_1
    //   190: invokestatic 171	com/tencent/mobileqq/mini/util/ImageUtil:getExifOrientation	(Ljava/lang/String;)I
    //   193: istore_2
    //   194: aload 8
    //   196: astore_3
    //   197: aload 9
    //   199: astore 5
    //   201: new 127	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   208: astore 4
    //   210: aload 8
    //   212: astore_3
    //   213: aload 9
    //   215: astore 5
    //   217: aload 4
    //   219: ldc 173
    //   221: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 8
    //   227: astore_3
    //   228: aload 9
    //   230: astore 5
    //   232: aload 4
    //   234: iload_2
    //   235: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 8
    //   241: astore_3
    //   242: aload 9
    //   244: astore 5
    //   246: ldc 143
    //   248: iconst_1
    //   249: aload 4
    //   251: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload 10
    //   259: astore 6
    //   261: iload_2
    //   262: ifeq +30 -> 292
    //   265: aload 8
    //   267: astore_3
    //   268: aload 9
    //   270: astore 5
    //   272: iload_2
    //   273: aload 10
    //   275: invokestatic 180	com/tencent/mobileqq/mini/util/ImageUtil:rotaingImageView	(ILandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   278: astore 6
    //   280: aload 8
    //   282: astore_3
    //   283: aload 9
    //   285: astore 5
    //   287: aload 10
    //   289: invokevirtual 185	android/graphics/Bitmap:recycle	()V
    //   292: aload 7
    //   294: astore 4
    //   296: aload 6
    //   298: ifnull +60 -> 358
    //   301: aload 8
    //   303: astore_3
    //   304: aload 9
    //   306: astore 5
    //   308: new 187	java/io/FileOutputStream
    //   311: dup
    //   312: aload 12
    //   314: invokespecial 190	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   317: astore 4
    //   319: aload 6
    //   321: getstatic 196	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   324: bipush 50
    //   326: aload 4
    //   328: invokevirtual 200	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   331: pop
    //   332: aload 4
    //   334: invokevirtual 203	java/io/FileOutputStream:flush	()V
    //   337: goto +21 -> 358
    //   340: astore_1
    //   341: aload 4
    //   343: astore_3
    //   344: goto +125 -> 469
    //   347: astore_3
    //   348: aload 4
    //   350: astore 5
    //   352: aload_3
    //   353: astore 4
    //   355: goto +89 -> 444
    //   358: aload 4
    //   360: astore_3
    //   361: aload 4
    //   363: astore 5
    //   365: new 127	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   372: astore 6
    //   374: aload 4
    //   376: astore_3
    //   377: aload 4
    //   379: astore 5
    //   381: aload 6
    //   383: ldc 205
    //   385: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 4
    //   391: astore_3
    //   392: aload 4
    //   394: astore 5
    //   396: aload 6
    //   398: aload 12
    //   400: invokevirtual 138	java/io/File:length	()J
    //   403: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 4
    //   409: astore_3
    //   410: aload 4
    //   412: astore 5
    //   414: ldc 143
    //   416: iconst_1
    //   417: aload 6
    //   419: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: aload 4
    //   427: ifnull +8 -> 435
    //   430: aload 4
    //   432: invokevirtual 208	java/io/FileOutputStream:close	()V
    //   435: aload 11
    //   437: areturn
    //   438: astore_1
    //   439: goto +30 -> 469
    //   442: astore 4
    //   444: aload 5
    //   446: astore_3
    //   447: ldc 143
    //   449: iconst_1
    //   450: ldc 210
    //   452: aload 4
    //   454: invokestatic 214	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   457: aload 5
    //   459: ifnull +8 -> 467
    //   462: aload 5
    //   464: invokevirtual 208	java/io/FileOutputStream:close	()V
    //   467: aload_1
    //   468: areturn
    //   469: aload_3
    //   470: ifnull +7 -> 477
    //   473: aload_3
    //   474: invokevirtual 208	java/io/FileOutputStream:close	()V
    //   477: aload_1
    //   478: athrow
    //   479: astore_1
    //   480: aload 11
    //   482: areturn
    //   483: astore_3
    //   484: aload_1
    //   485: areturn
    //   486: astore_3
    //   487: goto -10 -> 477
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	this	MediaChooseJsProxyImpl
    //   0	490	1	paramString	String
    //   193	80	2	i	int
    //   64	280	3	localObject1	Object
    //   347	6	3	localThrowable1	Throwable
    //   360	114	3	localObject2	Object
    //   483	1	3	localException1	Exception
    //   486	1	3	localException2	Exception
    //   17	414	4	localObject3	Object
    //   442	11	4	localThrowable2	Throwable
    //   67	396	5	localObject4	Object
    //   76	342	6	localObject5	Object
    //   60	233	7	localObject6	Object
    //   54	248	8	localObject7	Object
    //   57	248	9	localObject8	Object
    //   171	117	10	localBitmap	Bitmap
    //   40	441	11	str	String
    //   51	348	12	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   319	337	340	finally
    //   319	337	347	java/lang/Throwable
    //   69	78	438	finally
    //   85	93	438	finally
    //   100	111	438	finally
    //   118	129	438	finally
    //   136	145	438	finally
    //   152	158	438	finally
    //   165	173	438	finally
    //   189	194	438	finally
    //   201	210	438	finally
    //   217	225	438	finally
    //   232	239	438	finally
    //   246	257	438	finally
    //   272	280	438	finally
    //   287	292	438	finally
    //   308	319	438	finally
    //   365	374	438	finally
    //   381	389	438	finally
    //   396	407	438	finally
    //   414	425	438	finally
    //   447	457	438	finally
    //   69	78	442	java/lang/Throwable
    //   85	93	442	java/lang/Throwable
    //   100	111	442	java/lang/Throwable
    //   118	129	442	java/lang/Throwable
    //   136	145	442	java/lang/Throwable
    //   152	158	442	java/lang/Throwable
    //   165	173	442	java/lang/Throwable
    //   189	194	442	java/lang/Throwable
    //   201	210	442	java/lang/Throwable
    //   217	225	442	java/lang/Throwable
    //   232	239	442	java/lang/Throwable
    //   246	257	442	java/lang/Throwable
    //   272	280	442	java/lang/Throwable
    //   287	292	442	java/lang/Throwable
    //   308	319	442	java/lang/Throwable
    //   365	374	442	java/lang/Throwable
    //   381	389	442	java/lang/Throwable
    //   396	407	442	java/lang/Throwable
    //   414	425	442	java/lang/Throwable
    //   430	435	479	java/lang/Exception
    //   462	467	483	java/lang/Exception
    //   473	477	486	java/lang/Exception
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaChooseJsProxyImpl", 2, "unregisterAvatarReceiver");
    }
    try
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
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
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
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
    this.jdField_a_of_type_Boolean = true;
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramActivity, "/base/album/photolist");
    localActivityURIRequest.extra().putInt("enter_from", 4);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationMiniApp.a);
    localActivityURIRequest.extra().putString("KEY_ALBUM_LIST_CLASS_NAME", AlbumListCustomizationMiniApp.a);
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
    localActivityURIRequest.extra().putLong("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", this.b);
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
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showLoading ");
    localStringBuilder.append(paramString);
    QLog.i("MediaChooseJsProxyImpl", 1, localStringBuilder.toString());
    if (this.mBridge != null) {
      this.mBridge.showLoading(paramString);
    }
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
    //   12: ldc 143
    //   14: iconst_2
    //   15: ldc_w 486
    //   18: invokestatic 489	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_2
    //   24: ifnonnull +14 -> 38
    //   27: ldc 143
    //   29: iconst_2
    //   30: ldc_w 491
    //   33: invokestatic 489	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: iconst_0
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 99	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   42: ldc 114
    //   44: invokeinterface 120 2 0
    //   49: checkcast 114	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   52: ldc_w 493
    //   55: invokeinterface 125 2 0
    //   60: astore 6
    //   62: new 109	java/io/File
    //   65: dup
    //   66: aload 6
    //   68: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore 10
    //   73: aload 10
    //   75: invokevirtual 496	java/io/File:exists	()Z
    //   78: ifeq +9 -> 87
    //   81: aload 10
    //   83: invokevirtual 499	java/io/File:delete	()Z
    //   86: pop
    //   87: aconst_null
    //   88: astore 9
    //   90: new 187	java/io/FileOutputStream
    //   93: dup
    //   94: aload 10
    //   96: invokespecial 190	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   99: astore 8
    //   101: new 501	java/io/BufferedOutputStream
    //   104: dup
    //   105: aload 8
    //   107: sipush 4096
    //   110: invokespecial 504	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   113: astore 9
    //   115: aload 6
    //   117: astore 7
    //   119: aload_1
    //   120: getstatic 196	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   123: bipush 100
    //   125: aload 9
    //   127: invokevirtual 200	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   130: istore_3
    //   131: iload_3
    //   132: istore 4
    //   134: aload 6
    //   136: astore 7
    //   138: aload 9
    //   140: invokevirtual 505	java/io/BufferedOutputStream:flush	()V
    //   143: iload_3
    //   144: istore 4
    //   146: aload 6
    //   148: astore 7
    //   150: aload 10
    //   152: invokevirtual 508	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   155: astore_1
    //   156: iload_3
    //   157: istore 4
    //   159: aload_1
    //   160: astore 7
    //   162: aload_2
    //   163: aload_0
    //   164: getfield 99	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   167: ldc 114
    //   169: invokeinterface 120 2 0
    //   174: checkcast 114	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   177: aload_1
    //   178: invokeinterface 511 2 0
    //   183: putfield 516	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbnailPath	Ljava/lang/String;
    //   186: aload 8
    //   188: invokevirtual 208	java/io/FileOutputStream:close	()V
    //   191: goto +8 -> 199
    //   194: astore_2
    //   195: aload_2
    //   196: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   199: iload_3
    //   200: istore 4
    //   202: aload_1
    //   203: astore_2
    //   204: aload 9
    //   206: invokevirtual 520	java/io/BufferedOutputStream:close	()V
    //   209: iload_3
    //   210: istore 4
    //   212: aload_1
    //   213: astore_2
    //   214: goto +139 -> 353
    //   217: astore_1
    //   218: aload_1
    //   219: invokevirtual 519	java/io/IOException:printStackTrace	()V
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
    //   294: invokestatic 218	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +13 -> 310
    //   300: ldc 143
    //   302: iconst_2
    //   303: ldc_w 522
    //   306: aload_2
    //   307: invokestatic 524	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   310: aload 8
    //   312: ifnull +16 -> 328
    //   315: aload 8
    //   317: invokevirtual 208	java/io/FileOutputStream:close	()V
    //   320: goto +8 -> 328
    //   323: astore_2
    //   324: aload_2
    //   325: invokevirtual 519	java/io/IOException:printStackTrace	()V
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
    //   345: invokevirtual 520	java/io/BufferedOutputStream:close	()V
    //   348: aload_1
    //   349: astore_2
    //   350: iload_3
    //   351: istore 4
    //   353: invokestatic 218	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +35 -> 391
    //   359: new 127	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   366: astore_1
    //   367: aload_1
    //   368: ldc_w 526
    //   371: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload_1
    //   376: aload_2
    //   377: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: ldc 143
    //   383: iconst_2
    //   384: aload_1
    //   385: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 478	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   409: invokevirtual 208	java/io/FileOutputStream:close	()V
    //   412: goto +10 -> 422
    //   415: astore 6
    //   417: aload 6
    //   419: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   422: aload_1
    //   423: ifnull +15 -> 438
    //   426: aload_1
    //   427: invokevirtual 520	java/io/BufferedOutputStream:close	()V
    //   430: goto +8 -> 438
    //   433: astore_1
    //   434: aload_1
    //   435: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   438: aload_2
    //   439: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	MediaChooseJsProxyImpl
    //   0	440	1	paramBitmap	Bitmap
    //   0	440	2	paramLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    //   1	350	3	bool1	boolean
    //   6	386	4	bool2	boolean
    //   3	289	5	bool3	boolean
    //   60	348	6	localObject1	Object
    //   415	3	6	localIOException	java.io.IOException
    //   117	283	7	localObject2	Object
    //   99	297	8	localObject3	Object
    //   88	197	9	localBufferedOutputStream	java.io.BufferedOutputStream
    //   71	80	10	localFile	java.io.File
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
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("get_media_info");
    paramActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public void chooseMedia(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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
          j = a(localJSONObject);
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
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = paramIMiniAppContext;
  }
  
  public void destroy()
  {
    a();
    super.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaChooseJsProxyImpl
 * JD-Core Version:    0.7.0.1
 */