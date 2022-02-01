package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.IQIMCameraCapture;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.QzoneLiveMainRuntime;
import com.tencent.common.app.QzoneMainRuntime;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo.MediaInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.simpleui.SimpleQZoneUIUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneHelperProxy;
import com.tencent.qzonehub.api.IQzonePluginProxyActivity;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QZoneVideoDownloadActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.QzonePluginProxyService;
import cooperation.qzone.QzonePluginPublishQueueProxyService;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import cooperation.qzone.QzoneVideoSoDownloadModule;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QZoneHelperProxyImpl
  implements IQZoneHelperProxy
{
  public static final String ACTION_LAUNCH_PUBLISH_QUEUE = "com.qzone.intent.action.LAUNCH_PUBLISH_QUEUE";
  public static final String ACTION_PRELOAD_QUN_ALBUM_FEEDS = "com.qzone.intent.action.PRELOAD_QUN_ALBUM_FEEDS";
  public static final String INTENT_QZONE_BOOT_SERVICE = "com.qzone.preview.service.PictureService";
  public static final String INTENT_QZONE_PUBLISHQUEUE_SERVICE = "com.qzone.publish.business.publishqueue.PublishQueueService";
  public static final String TAG = "QZoneHelperProxyImpl";
  
  public static final void addSource(Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent.putExtra("big_brother_source_key", "biz_src_jc_qzone");
    }
  }
  
  public static void forwardToOpenRecordPanel(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, Activity paramActivity, String paramString1, String paramString2)
  {
    paramString2 = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(paramString2, "com.qzone.publish.ui.activity.QZonePublishVoiceMoodActivity");
    paramString2.putExtra("key_entrance_is_voice_mood", false);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString1, paramString2, generateRequestCode(paramWebViewPlugin, paramPluginRuntime, 6));
  }
  
  public static void forwardToUploadPhoto(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    localIntent.putExtra("startup_sceneid", 6);
    paramString2 = parseUrlParams(paramString2);
    localIntent.putExtra("IsBack", true);
    if (paramString2.containsKey("albumid")) {
      localIntent.putExtra("UploadPhoto.key_album_id", paramString2.getString("albumid"));
    }
    if (paramString2.containsKey("albumtitle")) {
      localIntent.putExtra("UploadPhoto.key_album_name", paramString2.getString("albumtitle"));
    }
    localIntent.putExtra("photoactivity_key_type", 1);
    localIntent.putExtras(paramString2);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramString1, localIntent, generateRequestCode(paramWebViewPlugin, paramPluginRuntime, 1));
  }
  
  public static void forwardToWriteMood(Activity paramActivity, AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, boolean paramBoolean)
  {
    publishMood(paramAppRuntime, paramActivity, getPublishMoodInfo(paramString1, paramString2, paramInt1), paramString3, paramInt2, paramBoolean);
  }
  
  public static int generateRequestCode(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, int paramInt)
  {
    paramPluginRuntime = paramPluginRuntime.a(paramPluginRuntime.a());
    int i = paramInt;
    if ((paramPluginRuntime instanceof WebViewPluginContainer)) {
      i = ((WebViewPluginContainer)paramPluginRuntime).switchRequestCode(paramWebViewPlugin, (byte)paramInt);
    }
    return i;
  }
  
  private static PublishMoodInfo getPublishMoodInfo(String paramString1, String paramString2, int paramInt)
  {
    PublishMoodInfo localPublishMoodInfo = new PublishMoodInfo();
    ArrayList localArrayList = new ArrayList();
    PublishMoodInfo.MediaInfo localMediaInfo = new PublishMoodInfo.MediaInfo();
    localMediaInfo.mPath = paramString2;
    if (paramInt == 4) {
      localMediaInfo.mType = 2;
    } else {
      localMediaInfo.mType = 1;
    }
    localArrayList.add(localMediaInfo);
    localPublishMoodInfo.mText = paramString1;
    localPublishMoodInfo.mMediaInfo = localArrayList;
    return (PublishMoodInfo)((IMiniAppService)QRoute.api(IMiniAppService.class)).validMoodInfo(localPublishMoodInfo);
  }
  
  public static Bundle parseUrlParams(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString == null) {
      return localBundle;
    }
    int i = paramString.indexOf('?');
    if (i >= 0)
    {
      i += 1;
      if (i >= paramString.length()) {
        return localBundle;
      }
      paramString = paramString.substring(i);
      if (TextUtils.isEmpty(paramString)) {
        return localBundle;
      }
      paramString = paramString.split("&");
      if (paramString != null)
      {
        i = 0;
        while (i < paramString.length)
        {
          String[] arrayOfString = paramString[i].split("=");
          if ((arrayOfString != null) && (arrayOfString.length == 2)) {
            try
            {
              localBundle.putString(arrayOfString[0], URLDecoder.decode(arrayOfString[1], "UTF-8"));
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              localUnsupportedEncodingException.printStackTrace();
            }
          }
          i += 1;
        }
      }
    }
    return localBundle;
  }
  
  private static void publishMood(AppRuntime paramAppRuntime, Activity paramActivity, PublishMoodInfo paramPublishMoodInfo, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    if ((paramActivity != null) && (paramPublishMoodInfo != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("summary", paramPublishMoodInfo.mText);
      localBundle.putBoolean("key_need_save_draft", false);
      localBundle.putString("shareSource", paramIntent.getStringExtra("source"));
      localBundle.putStringArrayList("images", paramPublishMoodInfo.mAllImageAndVideo);
      localBundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", paramPublishMoodInfo.mMediaInfoHashMap);
      localBundle.putString("qq_camera_top_title", paramIntent.getStringExtra("qq_camera_top_title"));
      localBundle.putString("qq_camera_scheme", paramIntent.getStringExtra("qq_camera_scheme"));
      if (paramBoolean) {
        localBundle.putInt("key_max_photo_count", 1);
      }
      QZoneShareManager.publishToQzone((QQAppInterface)paramAppRuntime, paramActivity, localBundle, null, paramInt);
      return;
    }
    QLog.i("QZoneHelperProxyImpl", 2, "handle moodInfo is null");
  }
  
  private static void publishMood(AppRuntime paramAppRuntime, Activity paramActivity, PublishMoodInfo paramPublishMoodInfo, String paramString, int paramInt, boolean paramBoolean)
  {
    if ((paramActivity != null) && (paramPublishMoodInfo != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("summary", paramPublishMoodInfo.mText);
      localBundle.putBoolean("key_need_save_draft", false);
      localBundle.putString("shareSource", paramString);
      localBundle.putStringArrayList("images", paramPublishMoodInfo.mAllImageAndVideo);
      localBundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", paramPublishMoodInfo.mMediaInfoHashMap);
      if (paramBoolean) {
        localBundle.putInt("key_max_photo_count", 1);
      }
      QZoneShareManager.publishToQzone((QQAppInterface)paramAppRuntime, paramActivity, localBundle, null, paramInt);
      return;
    }
    QLog.i("QZoneHelperProxyImpl", 2, "handle moodInfo is null");
  }
  
  public void addQZoneStatis(Intent paramIntent, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      paramIntent.putExtra("refer", "mqqQunSpace");
      return;
    case 5: 
      paramIntent.putExtra("refer", "mqqChat");
      return;
    case 4: 
      paramIntent.putExtra("refer", "mqqNearby");
      return;
    case 3: 
      paramIntent.putExtra("refer", "mqqQuanzi");
      return;
    case 2: 
      paramIntent.putExtra("refer", "mqqAvatar");
      return;
    }
    paramIntent.putExtra("refer", "mqqSetProfile");
  }
  
  public void bindQzonePublishQueueService(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    if (paramAppRuntime == null) {
      return;
    }
    Intent localIntent = new Intent(paramAppRuntime.getApp(), QzonePluginPublishQueueProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.setAction("com.qzone.intent.action.LAUNCH_PUBLISH_QUEUE");
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = QzonePluginProxyActivity.getQZonePluginName();
    localPluginParams.e = "QQ空间";
    localPluginParams.jdField_a_of_type_JavaLangString = paramAppRuntime.getCurrentAccountUin();
    localPluginParams.f = "com.qzone.publish.business.publishqueue.PublishQueueService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, "start and bind QzonePublishQueueService");
    }
    IPluginManager.c(paramAppRuntime.getApp(), localPluginParams);
  }
  
  public void cleanAllQZconfig() {}
  
  public AppRuntime createQZoneLiveMainRuntime(Context paramContext, String paramString)
  {
    PerfTracer.traceStart("Runtime_load_live_main_runtime");
    if ((paramContext != null) && (paramString != null))
    {
      paramContext = new QzoneLiveMainRuntime();
      PerfTracer.traceEnd("Runtime_load_live_main_runtime");
      return paramContext;
    }
    return null;
  }
  
  public AppRuntime createQZoneMainRuntime(Context paramContext, String paramString)
  {
    PerfTracer.traceStart("Runtime_load_main_runtime");
    if ((paramContext != null) && (paramString != null))
    {
      paramContext = new QzoneMainRuntime();
      PerfTracer.traceEnd("Runtime_load_main_runtime");
      return paramContext;
    }
    return null;
  }
  
  public void createShortcut(AppRuntime paramAppRuntime, Intent paramIntent, String paramString, Bitmap paramBitmap)
  {
    QQUtils.a((QQAppInterface)paramAppRuntime, paramIntent, paramString, paramBitmap);
  }
  
  public void deleteAllH5Data(AppRuntime paramAppRuntime)
  {
    ((IPublicAccountJavascriptInterface)QRoute.api(IPublicAccountJavascriptInterface.class)).deleteAllH5Data((AppInterface)paramAppRuntime);
  }
  
  public void forwardH5QZone(String paramString, Context paramContext)
  {
    Object localObject2 = LocalMultiProcConfig.getString("qzh5_url", "");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://m.qzone.com/infocenter";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("?sid=");
    ((StringBuilder)localObject2).append(paramString);
    paramString = ((StringBuilder)localObject2).toString();
    if (paramContext == null) {
      return;
    }
    localObject1 = new Intent(paramContext, QQBrowserActivity.class);
    QZoneHelper.openWebSecurityVerify((Intent)localObject1);
    ((Intent)localObject1).putExtra("plugin_start_time", System.nanoTime());
    ((Intent)localObject1).putExtra("click_start_time", System.currentTimeMillis());
    ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
    ((Intent)localObject1).putExtra("source_name", MobileQQ.getContext().getString(2080702467));
    addSource((Intent)localObject1);
    paramContext.startActivity(((Intent)localObject1).putExtra("url", paramString));
  }
  
  public boolean forwardToQZoneFriendFeedActivity(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    if (paramContext != null) {}
    try
    {
      if (QQTheme.f())
      {
        if ((paramContext instanceof BaseActivity))
        {
          if (QZoneApiProxy.isInQZoneEnvironment()) {
            return false;
          }
          if (!QZoneApiProxy.needShowQzoneFrame((BaseActivity)paramContext, ((BaseActivity)paramContext).app)) {
            return false;
          }
        }
        Intent localIntent = paramIntent;
        if (paramIntent == null) {
          localIntent = new Intent();
        }
        paramIntent = paramContext;
        if ((paramContext instanceof BasePluginActivity)) {
          paramIntent = ((BasePluginActivity)paramContext).getOutActivity();
        }
        paramIntent.startActivity(getJumpQzoneTabIntent(paramIntent, localIntent));
        return true;
      }
      if ((paramBoolean) || (paramContext == null)) {
        break label151;
      }
      if ((paramContext instanceof BasePluginActivity)) {
        QzonePluginProxyActivity.setActivityNameToIntent(paramIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      }
      paramContext.startActivity(paramIntent);
      return true;
    }
    catch (Throwable paramIntent)
    {
      label119:
      break label119;
    }
    paramContext = new StringBuilder();
    paramContext.append("qzone start error");
    paramContext.append(paramIntent);
    QLog.e("QZoneHelperProxyImpl", 1, paramContext.toString());
    label151:
    return false;
  }
  
  public void forwardToQzoneVideoCaptureNew(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (CaptureUtil.a()) {
      paramActivity.startActivityForResult(((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).getLaunchIntent(paramActivity, paramBundle), paramInt);
    } else if (!paramActivity.isFinishing()) {
      DialogUtil.a(paramActivity, 230).setMessage(HardCodeUtil.a(2080702465)).setPositiveButton(2131694583, new QZoneHelperProxyImpl.2(this)).show();
    }
    paramActivity.overridePendingTransition(2080440321, 2080440320);
  }
  
  public void forwardToQzoneVideoCaptureNew(AppRuntime paramAppRuntime, Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, boolean paramBoolean3, boolean paramBoolean4, String paramString3, boolean paramBoolean5, String paramString4, String paramString5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, String paramString6, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, int paramInt2, boolean paramBoolean13, Bundle paramBundle)
  {
    paramAppRuntime = new Bundle();
    paramAppRuntime.putInt("edit_video_type", 10001);
    LocalMultiProcConfig.putBool("support_trim", paramBoolean1);
    paramAppRuntime.putBoolean("enable_edit_video", paramBoolean4);
    paramAppRuntime.putBoolean("enable_local_video", true);
    paramAppRuntime.putBoolean("is_qzone_vip", paramBoolean3);
    paramAppRuntime.putString("set_user_callback", "cooperation.qzone.video.VideoComponentCallback");
    paramAppRuntime.putBoolean("flow_camera_video_mode", true);
    paramAppRuntime.putBoolean("flow_camera_capture_mode", paramBoolean2);
    paramAppRuntime.putString("short_video_refer", paramString2);
    paramAppRuntime.putString("callback", paramString4);
    paramAppRuntime.putString("dongxiao_id", paramString5);
    paramAppRuntime.putString("topic_id", paramString3);
    paramAppRuntime.putBoolean("enter_ptu", paramBoolean5);
    paramAppRuntime.putBoolean("enable_input_text", paramBoolean6);
    paramAppRuntime.putBoolean("enable_priv_list", paramBoolean7);
    paramAppRuntime.putBoolean("enable_sync_qzone", paramBoolean8);
    paramAppRuntime.putBoolean("enable_origin_video", paramBoolean9);
    paramAppRuntime.putString("confirm_text", paramString6);
    paramAppRuntime.putBoolean("enable_edit_button", paramBoolean10);
    paramAppRuntime.putBoolean("enable_local_button", paramBoolean11);
    paramAppRuntime.putBoolean("is_glance_video", paramBoolean12);
    if (paramBoolean2)
    {
      paramAppRuntime.putString("qcamera_photo_filepath", PlusPanelUtils.a(AppConstants.SDCARD_IMG_CAMERA));
      paramAppRuntime.putInt("extra.busi_type", 3);
      paramAppRuntime.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
      paramAppRuntime.putBoolean("DirectBackToQzone", true);
      paramAppRuntime.putString("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
      paramAppRuntime.putString("pic_confirm_text", HardCodeUtil.a(2080702466));
    }
    paramAppRuntime.putInt("entry_source", paramInt2);
    paramAppRuntime.putBoolean("go_publish_activity", paramBoolean13);
    if (paramBundle != null) {
      paramAppRuntime.putAll(paramBundle);
    }
    if (CaptureUtil.a()) {
      ((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).launch(paramActivity, paramAppRuntime);
    } else {
      DialogUtil.a(paramActivity, 230).setMessage(HardCodeUtil.a(2080702465)).setPositiveButton(2131694583, new QZoneHelperProxyImpl.1(this)).show();
    }
    paramActivity.overridePendingTransition(2080440321, 2080440320);
  }
  
  public void forwardToWriteMood(Activity paramActivity, AppRuntime paramAppRuntime, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    publishMood(paramAppRuntime, paramActivity, getPublishMoodInfo(paramIntent.getStringExtra("summary"), paramIntent.getStringExtra("filePath"), paramIntent.getIntExtra("reqType", 1)), paramIntent, paramInt, paramBoolean);
  }
  
  public Intent getJumpQzoneTabIntent(Context paramContext, Intent paramIntent)
  {
    paramIntent.setClass(paramContext, SplashActivity.class);
    paramIntent.putExtra("fragment_id", 1);
    paramIntent.putExtra("tab_index", FrameControllerUtil.i);
    paramIntent.putExtra("open_qzone_tab_fragment", true);
    paramIntent.setFlags(335544320);
    return paramIntent;
  }
  
  public Intent getQQBrowserActivityIntent(Context paramContext)
  {
    if (BaseApplication.getContext() != null) {
      return new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    }
    return new Intent(paramContext, QQBrowserActivity.class);
  }
  
  public Intent getQZoneVideoDownloadActivityIntent(Context paramContext)
  {
    return new Intent(paramContext, QZoneVideoDownloadActivity.class);
  }
  
  public int getQzoneManagerInQQManagerFactory()
  {
    return QQManagerFactory.QZONE_MANAGER;
  }
  
  public Intent getQzoneVerticalVideoDownloadActivityIntent(Context paramContext)
  {
    return new Intent(paramContext, QzoneVerticalVideoDownloadActivity.class);
  }
  
  public QIPCModule getQzoneVideoSoDownloadModule()
  {
    return QzoneVideoSoDownloadModule.getInstance();
  }
  
  public int getSendSizeSpecNOR()
  {
    return 0;
  }
  
  public int getSendSizeSpecRAW()
  {
    return 3;
  }
  
  public Intent getShortcutIntent(Context paramContext)
  {
    return new Intent(paramContext, ShortcutGuideActivity.class);
  }
  
  public boolean getSimpleQZoneUISwitch()
  {
    return SimpleQZoneUIUtil.a();
  }
  
  public boolean isInQZoneEnvironment()
  {
    return QZoneApiProxy.isInQZoneEnvironment();
  }
  
  public void killQZoneProcess() {}
  
  public void launchPluginService(BaseApplication paramBaseApplication, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, String paramString, Intent paramIntent)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = QzonePluginProxyActivity.getQZonePluginName();
    localPluginParams.e = "QQ空间";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString;
    localPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = paramPreloadProcHitPluginSession;
    localPluginParams.f = "com.qzone.preview.service.PictureService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    IPluginManager.c(paramBaseApplication, localPluginParams);
  }
  
  public void preloadQunAlbum(AppRuntime paramAppRuntime, String paramString)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApp(), QzonePluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.setAction("com.qzone.intent.action.PRELOAD_QUN_ALBUM_FEEDS");
    localIntent.putExtra("qunid", paramString);
    localIntent.putExtra("qzone_uin", paramAppRuntime.getCurrentAccountUin());
    paramString = new IPluginManager.PluginParams(0);
    paramString.b = QzonePluginProxyActivity.getQZonePluginName();
    paramString.e = "QQ空间";
    paramString.jdField_a_of_type_JavaLangString = paramAppRuntime.getCurrentAccountUin();
    paramString.f = "com.qzone.preview.service.PictureService";
    paramString.jdField_a_of_type_AndroidContentIntent = localIntent;
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, "Start QZone QunAlbum Preload");
    }
    IPluginManager.c(paramAppRuntime.getApp(), paramString);
  }
  
  public void putQzoneSourceName(Intent paramIntent)
  {
    paramIntent.putExtra("source_name", MobileQQ.getContext().getString(2080702467));
  }
  
  public void putWebViewPluginPackageName(Intent paramIntent)
  {
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      paramIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
  }
  
  public void reportTroopAlbumExp()
  {
    LpReportInfo_pf00064.allReport(40, 3, 4);
  }
  
  public int sendRemoteHandleManagerData(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    return RemoteHandleManager.getInstance().sendData(paramString, paramBundle, paramBoolean);
  }
  
  public void startTranslucentBrowserActivityForResult(Context paramContext, String paramString1, int paramInt, Bundle paramBundle, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      ToastUtil.a().a(2080702464);
      paramContext = new StringBuilder();
      paramContext.append("browse url fail:");
      paramContext.append(paramString1);
      QLog.w("QZoneHelperProxyImpl", 1, paramContext.toString());
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = null;
    } else {
      paramString2 = paramString2.getBytes();
    }
    Intent localIntent = new Intent(MobileQQ.getContext(), QQTranslucentBrowserActivity.class);
    localIntent.putExtra("post_data", paramString2);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.putExtra("isTransparentTitle", true);
    localIntent.putExtra("hide_left_button", paramBoolean1);
    localIntent.setData(Uri.parse(paramString1));
    if (!paramBoolean2) {
      localIntent.putExtra("finish_animation_none", true);
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
      return;
    }
    localIntent.setFlags(268435456);
    MobileQQ.getContext().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QZoneHelperProxyImpl
 * JD-Core Version:    0.7.0.1
 */