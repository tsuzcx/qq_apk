package cooperation.qzone.video;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import com.google.zxing.common.BitMatrix;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.module.statistics.SpeedStatistics;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationProfileCustomCover;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.PushReportController;
import com.tencent.mobileqq.statistics.PushReportController.PushReportItem;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMModuleLeak;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import com.tencent.upload.network.base.ConnectionImpl;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.QZoneVideoCommonUtils.VideoSupport;
import cooperation.qzone.QZoneVideoDownloadActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.ServerListProvider;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.plugin.QZonePluginUtils;
import cooperation.qzone.push.QZoneNotificationAdapter;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.report.lp.LpReportInfo_dc01245;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.SystemUtil;
import cooperation.qzone.webviewwrapper.EcWebviewWrapper;
import cooperation.qzone.webviewwrapper.IWebviewOnClassLoaded;
import cooperation.qzone.webviewwrapper.IWebviewWrapper;
import cooperation.qzone.webviewwrapper.LiveVideoFeedVipIconListner;
import cooperation.qzone.webviewwrapper.WebviewWrapper;
import cooperation.vip.manager.QZoneVipInfoManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QzoneLiveVideoInterface
{
  public static final String BUSINESS_ID_QZONE_LIVE = "qzone_live";
  public static final String IS_QZONE_LIVE_LAUNCH = "is_qzone_live_launch";
  public static final int MSG_WNS_HTTP_GET_DATA = 203;
  public static final String QZONE_LIVE_PROCESS_ID = "qzone_live_process_id";
  public static final int RET_CODE_COMPRESS_SUCCESS = 2;
  public static final String TAG = "QzoneLiveVideoInterface";
  private static HashMap<String, String> friNickNameMap = new HashMap();
  private static volatile IWebviewWrapper gLiveWebviewInstance = null;
  private static String version = "0";
  
  public static void addFriend(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    Activity localActivity = paramActivity;
    paramActivity = localActivity;
    if ((localActivity instanceof BasePluginActivity)) {
      paramActivity = ((BasePluginActivity)localActivity).getOutActivity();
    }
    if (paramActivity != null)
    {
      paramString1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramActivity, 1, paramString1, "", paramInt2, paramInt3, paramString3, null, null, paramString2, null);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(paramActivity, paramString1, paramInt1);
    }
  }
  
  public static void addLiveVideoComment(Intent paramIntent, Handler paramHandler)
  {
    paramIntent = paramIntent.getExtras();
    RemoteHandleManager.getInstance().sendData("cmd.uploadCommentVideo", paramIntent, true);
    paramIntent = new QzoneLiveVideoInterface.1(paramHandler);
    RemoteHandleManager.getInstance().addWebEventListener(paramIntent);
  }
  
  public static boolean checkAVCameraUsed(Context paramContext)
  {
    return QavCameraUsage.a(paramContext, false);
  }
  
  public static void collectPerformance(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    StatisticCollector.getInstance(getContext()).collectPerformance(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3);
  }
  
  public static void doAppJump(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public static void doCgiReport(String paramString) {}
  
  public static void ecLiveShareToQQ(Activity paramActivity, Bundle paramBundle)
  {
    Activity localActivity = paramActivity;
    if ((paramActivity instanceof BasePluginActivity)) {
      localActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    paramActivity = new Intent(localActivity, ForwardRecentActivity.class);
    paramActivity.putExtra("forward_type", 2);
    paramActivity.putExtra("req_type", 1);
    paramActivity.putExtra("req_share_id", Long.parseLong("101735437"));
    paramActivity.putExtras(paramBundle);
    localActivity.startActivity(paramActivity);
  }
  
  public static void ecReportToDc03266(Bundle paramBundle)
  {
    PushReportController.PushReportItem localPushReportItem = new PushReportController.PushReportItem();
    localPushReportItem.d = paramBundle.getString("sop_type");
    localPushReportItem.e = paramBundle.getString("sop_name");
    localPushReportItem.f = paramBundle.getString("type");
    localPushReportItem.g = paramBundle.getString("push_id");
    localPushReportItem.h = paramBundle.getString("feed_id");
    localPushReportItem.i = paramBundle.getString("content_id");
    localPushReportItem.j = paramBundle.getString("content_title");
    localPushReportItem.k = paramBundle.getString("content_url");
    localPushReportItem.l = paramBundle.getString("content_type");
    localPushReportItem.m = paramBundle.getString("content_author");
    localPushReportItem.n = paramBundle.getString("d1");
    localPushReportItem.o = paramBundle.getString("d2");
    localPushReportItem.p = paramBundle.getString("d3");
    localPushReportItem.q = paramBundle.getString("d4");
    PushReportController.a(null, localPushReportItem);
  }
  
  public static void forwardOpenQzoneVip(Activity paramActivity, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    paramString2 = QZoneHelper.UserInfo.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    paramString2.qzone_uin = localStringBuilder.toString();
    if ((paramActivity instanceof BasePluginActivity))
    {
      QZoneHelper.forwardOpenQzoneVip(((BasePluginActivity)paramActivity).getOutActivity(), paramString2, paramString1, paramLong, "", -1);
      return;
    }
    QZoneHelper.forwardOpenQzoneVip(paramActivity, paramString2, paramString1, paramLong, "", -1);
  }
  
  public static void forwardToBrowser(Activity paramActivity, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("_ext_launch_activity_when_finish")))
    {
      if ((paramActivity instanceof BasePluginActivity))
      {
        QZoneHelper.forwardToQzoneBrowser(((BasePluginActivity)paramActivity).getOutActivity(), QZoneHelper.UserInfo.getInstance(), paramString1, paramInt, paramBundle, paramString2);
        return;
      }
      QZoneHelper.forwardToQzoneBrowser(paramActivity, QZoneHelper.UserInfo.getInstance(), paramString1, paramInt, paramBundle, paramString2);
      return;
    }
    if ((paramBundle != null) && (paramBundle.getBoolean("needTranslucentBrowser")))
    {
      if ((paramActivity instanceof BasePluginActivity))
      {
        QZoneHelper.startTranslucentBrowserActivityForResult(((BasePluginActivity)paramActivity).getOutActivity(), paramString1, paramInt, paramBundle, paramString2);
        return;
      }
      QZoneHelper.startTranslucentBrowserActivityForResult(paramActivity, paramString1, paramInt, paramBundle, paramString2);
      return;
    }
    if ((paramActivity instanceof BasePluginActivity))
    {
      QZoneHelper.forwardToBrowser(((BasePluginActivity)paramActivity).getOutActivity(), paramString1, paramInt, paramBundle, paramString2);
      return;
    }
    QZoneHelper.forwardToBrowser(paramActivity, paramString1, paramInt, paramBundle, paramString2);
  }
  
  public static void forwardToFeedActionPanel(Activity paramActivity, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString6, int paramInt8, int paramInt9, boolean paramBoolean1, String paramString7, boolean paramBoolean2)
  {
    paramString2 = QZoneHelper.UserInfo.getInstance();
    paramString2.qzone_uin = paramString1;
    if ((paramActivity instanceof BasePluginActivity))
    {
      QZoneHelper.forwardToFeedActionPanel(((BasePluginActivity)paramActivity).getOutActivity(), paramString2, paramInt1, "", "", "", "", 0, true, 0, 1, 0, 0, 0, "", 40, 0, paramBoolean1, paramString7, paramBoolean2);
      return;
    }
    QZoneHelper.forwardToFeedActionPanel(paramActivity, paramString2, paramInt1, "", "", "", "", 0, true, 0, 1, 0, 0, 0, "", 40, 0, paramBoolean1, paramString7, paramBoolean2);
  }
  
  public static void forwardToFriendFeed(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("newflag", true);
    localIntent.putExtras(paramBundle);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    localIntent.addFlags(805306368);
    QZoneHelper.forwardToFriendFeed(paramActivity, paramString, localIntent, paramInt);
  }
  
  public static void forwardToMoodSelectLocation(Activity paramActivity, String paramString, int paramInt, Bundle paramBundle)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString;
    if ((paramActivity instanceof BasePluginActivity))
    {
      QZoneHelper.forwardToMoodSelectLocation(((BasePluginActivity)paramActivity).getOutActivity(), localUserInfo, paramInt, paramBundle);
      return;
    }
    QZoneHelper.forwardToMoodSelectLocation(paramActivity, localUserInfo, paramInt, paramBundle);
  }
  
  public static void forwardToUserHome(Activity paramActivity, long paramLong1, long paramLong2, int paramInt)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append("");
    localUserInfo.qzone_uin = ((StringBuilder)localObject).toString();
    if (paramLong2 > 0L)
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("action_js2qzone");
      ((Intent)localObject).putExtra("cmd", "QZonelive2Homepage");
      ((Intent)localObject).putExtra("visitUin", paramLong2);
      ((Intent)localObject).putExtra("requestCode", paramInt);
      if ((paramActivity instanceof BasePluginActivity))
      {
        QZoneHelper.forwardToQzoneTransluentActivity(((BasePluginActivity)paramActivity).getOutActivity(), localUserInfo, (Intent)localObject);
        return;
      }
      QZoneHelper.forwardToQzoneTransluentActivity(paramActivity, localUserInfo, (Intent)localObject);
      return;
    }
    QLog.w("QzoneLiveVideoInterface", 2, "startUserHomeActivity, invalid uin");
  }
  
  public static void forwardToUserProfileCard(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    AllInOne localAllInOne = new AllInOne(paramString, paramInt1);
    localAllInOne.profileEntryType = paramInt2;
    localAllInOne.sourceID = 3094;
    localAllInOne.subSourceId = 5;
    paramString = (Activity)paramContext;
    paramContext = paramString;
    if ((paramString instanceof BasePluginActivity)) {
      paramContext = ((BasePluginActivity)paramString).getOutActivity();
    }
    ProfileUtils.openProfileCard(paramContext, localAllInOne);
  }
  
  public static void forwardToVideoInteract(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    Activity localActivity = paramActivity;
    if ((paramActivity instanceof BasePluginActivity)) {
      localActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    paramActivity = new Intent(localActivity, QZoneVideoDownloadActivity.class);
    paramActivity.putExtra("encode_video_params", paramBundle);
    paramActivity.putExtra("video_refer", "video_interact");
    localActivity.startActivityForResult(paramActivity, paramInt);
  }
  
  public static Bitmap generateQrCode(String paramString, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = QRUtils.a(paramString, -1);
    int m = ((BitMatrix)localObject).a();
    paramString = new int[m * m];
    int i = 0;
    while (i < m)
    {
      int j = 0;
      while (j < m)
      {
        int k;
        if (((BitMatrix)localObject).a(j, i)) {
          k = -16777216;
        } else {
          k = 16777215;
        }
        paramString[(i * m + j)] = k;
        j += 1;
      }
      i += 1;
    }
    localObject = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).setPixels(paramString, 0, m, 0, 0, m, m);
    try
    {
      paramString = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError paramString)
    {
      label141:
      break label141;
    }
    System.gc();
    try
    {
      paramString = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
      if (paramString == null)
      {
        ((Bitmap)localObject).recycle();
        return null;
      }
      Canvas localCanvas = new Canvas(paramString);
      Paint localPaint = new Paint();
      localPaint.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, 600.0F, -657931, -1513240, Shader.TileMode.REPEAT));
      float f = paramInt1;
      localCanvas.drawRect(0.0F, 0.0F, f, f, localPaint);
      i = paramInt1 - paramInt2;
      localCanvas.drawBitmap((Bitmap)localObject, null, new Rect(paramInt2, paramInt2, i, i), null);
      if (paramBitmap != null)
      {
        paramInt1 = (paramInt1 - paramInt3) / 2;
        localPaint = new Paint();
        localPaint.setAntiAlias(true);
        paramInt2 = paramInt1 + paramInt3;
        localCanvas.drawBitmap(paramBitmap, null, new Rect(paramInt1, paramInt1, paramInt2, paramInt2), localPaint);
      }
      ((Bitmap)localObject).recycle();
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("getQrCode cost time:");
        paramBitmap.append(l2 - l1);
        QLog.d("QzoneLiveVideoInterface", 2, paramBitmap.toString());
      }
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("generateQrCode ");
        paramBitmap.append(paramString.getMessage());
        QLog.w("QzoneLiveVideoInterface", 2, paramBitmap.toString());
      }
      return null;
    }
  }
  
  public static Notification generationNotification(PendingIntent paramPendingIntent, Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    if ("oppo".equalsIgnoreCase(DeviceInfoUtil.w())) {
      return QZoneNotificationAdapter.getInstance().newNotificationForOppo(paramPendingIntent, paramContext, paramBitmap, paramString1, paramString2, 2130850272);
    }
    return QZoneNotificationAdapter.getInstance().buildNotification(paramPendingIntent, paramContext, paramBitmap, paramString1, paramString2, 2130850272);
  }
  
  public static int getAppId()
  {
    return AppSetting.d();
  }
  
  public static Application getApplication()
  {
    return BaseApplicationImpl.getApplication();
  }
  
  public static float getAveragePicDownloadSpeed()
  {
    return SpeedStatistics.getInstance().getAverageSpeed();
  }
  
  public static String getBuildNumber()
  {
    return "5770";
  }
  
  public static String getBuilderNumber()
  {
    return "100084";
  }
  
  public static String getCacheDir(String paramString)
  {
    return CacheManager.getCacheDir(paramString);
  }
  
  public static Context getContext()
  {
    return BaseApplicationImpl.getContext();
  }
  
  public static long getCpuFrequency()
  {
    return ((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).getCpuMaxFreq();
  }
  
  public static void getCurrentPoiInfo(Handler paramHandler)
  {
    QZLog.i("QzoneLiveVideoInterface.NewLbsInterface", 1, "[QZLIVE_LBS_MODULE]----getCurrentPoiInfo");
    QzoneLiveInitLocationProxy.getInstance("qzone_live").locate(paramHandler);
  }
  
  public static String getDeviceInfor()
  {
    return PlatformInfor.g().getDeviceInfor();
  }
  
  public static IWebviewWrapper getEcWebviewInstance(Context paramContext)
  {
    return new EcWebviewWrapper(getContext());
  }
  
  public static void getFriendListFromResultRecord(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("friendsList");
      Object localObject1 = localArrayList;
      if (localArrayList == null)
      {
        Object localObject2 = paramIntent.getParcelableArrayListExtra("result_set");
        localObject1 = localArrayList;
        if (localObject2 != null)
        {
          localObject1 = localArrayList;
          if (((ArrayList)localObject2).size() > 0)
          {
            localArrayList = new ArrayList();
            localObject2 = ((ArrayList)localObject2).iterator();
            for (;;)
            {
              localObject1 = localArrayList;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (ResultRecord)((Iterator)localObject2).next();
              if ((localObject1 != null) && (!TextUtils.isEmpty(((ResultRecord)localObject1).uin))) {
                localArrayList.add(((ResultRecord)localObject1).uin);
              }
            }
          }
        }
      }
      paramIntent.putStringArrayListExtra("friendsList", (ArrayList)localObject1);
    }
  }
  
  public static String getHtmlData(String paramString)
  {
    return WebSoUtils.f(paramString);
  }
  
  public static Drawable getHuangzuanIcon(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, String paramString2, LiveVideoFeedVipIconListner paramLiveVideoFeedVipIconListner)
  {
    Object localObject1 = getContext();
    long l1 = System.currentTimeMillis();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getHuangzuanIcon startTime =");
    ((StringBuilder)localObject2).append(l1);
    QZLog.i("QzoneLiveVideoInterface", 1, ((StringBuilder)localObject2).toString());
    try
    {
      Object localObject3 = QzonePluginProxyActivity.getQZonePluginClassLoader((Context)localObject1);
      localObject2 = ((ClassLoader)localObject3).loadClass("cooperation.vip.vipcomponent.ui.QzoneHuangzuanVipIconShow");
      localObject3 = ((ClassLoader)localObject3).loadClass("cooperation.vip.vipcomponent.util.VipResourcesListener");
      if (localObject2 == null)
      {
        QLog.e("QzoneLiveVideoInterface", 1, "*QzoneHuangzuanVipIconShow load class fail");
        return null;
      }
      if (localObject3 == null)
      {
        QLog.e("QzoneLiveVideoInterface", 1, "*VipResourcesListener load class fail");
        return null;
      }
      ClassLoader localClassLoader = ((Class)localObject2).getClassLoader();
      paramLiveVideoFeedVipIconListner = new QzoneLiveVideoInterface.3(paramLiveVideoFeedVipIconListner);
      paramLiveVideoFeedVipIconListner = Proxy.newProxyInstance(localClassLoader, new Class[] { localObject3 }, paramLiveVideoFeedVipIconListner);
      localObject1 = ((Class)localObject2).getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { localObject1 });
      paramString2 = ((Class)localObject2).getDeclaredMethod("getLayers", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, String.class, localObject3, Integer.TYPE }).invoke(localObject1, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt3), Integer.valueOf(80), paramString2, paramLiveVideoFeedVipIconListner, Integer.valueOf(0) });
      long l2 = System.currentTimeMillis();
      paramLiveVideoFeedVipIconListner = new StringBuilder();
      paramLiveVideoFeedVipIconListner.append("getHuangzuanIcon endTime  =");
      paramLiveVideoFeedVipIconListner.append(l2);
      paramLiveVideoFeedVipIconListner.append(" diff =");
      paramLiveVideoFeedVipIconListner.append(l2 - l1);
      QZLog.i("QzoneLiveVideoInterface", 1, paramLiveVideoFeedVipIconListner.toString());
      QzoneVideoBeaconReport.reportQzoneLiveEvent(paramString1, "qzone_livevideo_gethuangzuanicon", "sucess");
      if ((paramString2 != null) && ((paramString2 instanceof Drawable)))
      {
        paramString2 = (Drawable)paramString2;
        return paramString2;
      }
    }
    catch (Throwable paramString2)
    {
      QzoneVideoBeaconReport.reportQzoneLiveEvent(paramString1, "qzone_livevideo_gethuangzuanicon", "failed");
      QZLog.e("QzoneLiveVideoInterface", 1, paramString2, new Object[0]);
    }
    return null;
  }
  
  public static String getIMEI()
  {
    return PlatformInfor.g().getIMEI();
  }
  
  public static String getIMSI()
  {
    return DeviceInfoUtil.c();
  }
  
  public static int getIPStackType()
  {
    if (ConnectionImpl.isLibraryPrepared()) {
      return UploadEnv.getIpStack(2);
    }
    return -1;
  }
  
  public static int getIntConfig(String paramString1, String paramString2, int paramInt)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramInt);
  }
  
  public static String getLiveVideoDownLoadClassName()
  {
    if ("qzone_live_video_plugin_hack.apk".equals(QZonePluginUtils.getLoadQZoneLivePluginId())) {
      return "cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2";
    }
    return "cooperation.qzone.QZoneLiveVideoDownloadActivity";
  }
  
  public static String getMobileInfo()
  {
    return MobileInfoUtil.getMobileInfo();
  }
  
  public static int getMultiProcInt(String paramString, int paramInt)
  {
    return LocalMultiProcConfig.getInt(paramString, paramInt);
  }
  
  public static int getMultiProcInt4Uin(String paramString, int paramInt, long paramLong)
  {
    return LocalMultiProcConfig.getInt4Uin(paramString, paramInt, paramLong);
  }
  
  public static int getNetWorkType()
  {
    return HttpUtil.getNetWorkType();
  }
  
  public static int getNetworkType()
  {
    return NetworkState.getNetworkType();
  }
  
  public static String getNickname(String paramString)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Constants.PropertiesKey.nickName.toString());
    localStringBuilder.append(paramString);
    return localBaseApplicationImpl.getProperty(localStringBuilder.toString());
  }
  
  /* Error */
  public static String getNickname(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 39	cooperation/qzone/video/QzoneLiveVideoInterface:friNickNameMap	Ljava/util/HashMap;
    //   3: aload_1
    //   4: invokevirtual 852	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   7: ifne +464 -> 471
    //   10: invokestatic 567	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13: invokevirtual 858	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   16: astore 6
    //   18: new 258	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   25: astore 7
    //   27: aload 7
    //   29: ldc_w 860
    //   32: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 7
    //   38: aload_0
    //   39: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 6
    //   45: aload 7
    //   47: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 866	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   53: iconst_3
    //   54: anewarray 515	java/lang/String
    //   57: dup
    //   58: iconst_0
    //   59: ldc_w 867
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: ldc_w 869
    //   68: aastore
    //   69: dup
    //   70: iconst_2
    //   71: ldc_w 871
    //   74: aastore
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: invokevirtual 877	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   81: astore 6
    //   83: aload 6
    //   85: ifnull +323 -> 408
    //   88: aload 6
    //   90: astore_0
    //   91: aload 6
    //   93: invokeinterface 882 1 0
    //   98: ifeq +310 -> 408
    //   101: aload 6
    //   103: astore_0
    //   104: aload 6
    //   106: ldc_w 867
    //   109: invokeinterface 886 2 0
    //   114: istore_2
    //   115: aload 6
    //   117: astore_0
    //   118: aload 6
    //   120: ldc_w 869
    //   123: invokeinterface 886 2 0
    //   128: istore_3
    //   129: aload 6
    //   131: astore_0
    //   132: aload 6
    //   134: ldc_w 871
    //   137: invokeinterface 886 2 0
    //   142: istore 4
    //   144: aload 6
    //   146: astore_0
    //   147: aload 6
    //   149: iload_2
    //   150: invokeinterface 889 2 0
    //   155: astore 7
    //   157: aload 6
    //   159: astore_0
    //   160: aload 7
    //   162: invokestatic 647	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   165: ifeq +6 -> 171
    //   168: goto +210 -> 378
    //   171: aload 6
    //   173: astore_0
    //   174: new 515	java/lang/String
    //   177: dup
    //   178: aload 7
    //   180: invokevirtual 893	java/lang/String:getBytes	()[B
    //   183: ldc_w 895
    //   186: invokespecial 898	java/lang/String:<init>	([BLjava/lang/String;)V
    //   189: invokestatic 903	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   192: astore 9
    //   194: aload 6
    //   196: astore_0
    //   197: aload 6
    //   199: iload_3
    //   200: invokeinterface 889 2 0
    //   205: astore 7
    //   207: aload 6
    //   209: astore_0
    //   210: aload 7
    //   212: invokestatic 647	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: ifne +43 -> 258
    //   218: aload 6
    //   220: astore_0
    //   221: new 515	java/lang/String
    //   224: dup
    //   225: aload 7
    //   227: invokevirtual 893	java/lang/String:getBytes	()[B
    //   230: ldc_w 895
    //   233: invokespecial 898	java/lang/String:<init>	([BLjava/lang/String;)V
    //   236: invokestatic 903	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   239: astore 7
    //   241: aload 6
    //   243: astore_0
    //   244: getstatic 39	cooperation/qzone/video/QzoneLiveVideoInterface:friNickNameMap	Ljava/util/HashMap;
    //   247: aload 9
    //   249: aload 7
    //   251: invokevirtual 907	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   254: pop
    //   255: goto +123 -> 378
    //   258: aload 6
    //   260: astore_0
    //   261: aload 6
    //   263: iload 4
    //   265: invokeinterface 889 2 0
    //   270: astore 7
    //   272: aload 6
    //   274: astore_0
    //   275: aload 7
    //   277: invokestatic 647	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   280: ifne +98 -> 378
    //   283: aload 6
    //   285: astore_0
    //   286: new 515	java/lang/String
    //   289: dup
    //   290: aload 7
    //   292: invokevirtual 893	java/lang/String:getBytes	()[B
    //   295: ldc_w 895
    //   298: invokespecial 898	java/lang/String:<init>	([BLjava/lang/String;)V
    //   301: invokestatic 903	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   304: astore 8
    //   306: aload 8
    //   308: astore 7
    //   310: aload 6
    //   312: astore_0
    //   313: aload 8
    //   315: invokevirtual 910	java/lang/String:length	()I
    //   318: iconst_1
    //   319: if_icmple +45 -> 364
    //   322: aload 8
    //   324: astore 7
    //   326: aload 6
    //   328: astore_0
    //   329: aload 8
    //   331: aload 8
    //   333: invokevirtual 910	java/lang/String:length	()I
    //   336: iconst_1
    //   337: isub
    //   338: invokevirtual 914	java/lang/String:charAt	(I)C
    //   341: bipush 10
    //   343: if_icmpne +21 -> 364
    //   346: aload 6
    //   348: astore_0
    //   349: aload 8
    //   351: iconst_0
    //   352: aload 8
    //   354: invokevirtual 910	java/lang/String:length	()I
    //   357: iconst_1
    //   358: isub
    //   359: invokevirtual 918	java/lang/String:substring	(II)Ljava/lang/String;
    //   362: astore 7
    //   364: aload 6
    //   366: astore_0
    //   367: getstatic 39	cooperation/qzone/video/QzoneLiveVideoInterface:friNickNameMap	Ljava/util/HashMap;
    //   370: aload 9
    //   372: aload 7
    //   374: invokevirtual 907	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   377: pop
    //   378: aload 6
    //   380: astore_0
    //   381: aload 6
    //   383: invokeinterface 921 1 0
    //   388: istore 5
    //   390: iload 5
    //   392: ifne -248 -> 144
    //   395: goto +13 -> 408
    //   398: astore_0
    //   399: aload 6
    //   401: astore_1
    //   402: aload_0
    //   403: astore 6
    //   405: goto +28 -> 433
    //   408: aload 6
    //   410: ifnull +61 -> 471
    //   413: aload 6
    //   415: invokeinterface 924 1 0
    //   420: goto +51 -> 471
    //   423: astore_1
    //   424: aconst_null
    //   425: astore_0
    //   426: goto +33 -> 459
    //   429: astore 6
    //   431: aconst_null
    //   432: astore_1
    //   433: aload_1
    //   434: astore_0
    //   435: ldc 22
    //   437: iconst_2
    //   438: ldc_w 926
    //   441: aload 6
    //   443: invokestatic 929	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   446: aload_1
    //   447: ifnull +9 -> 456
    //   450: aload_1
    //   451: invokeinterface 924 1 0
    //   456: aconst_null
    //   457: areturn
    //   458: astore_1
    //   459: aload_0
    //   460: ifnull +9 -> 469
    //   463: aload_0
    //   464: invokeinterface 924 1 0
    //   469: aload_1
    //   470: athrow
    //   471: getstatic 39	cooperation/qzone/video/QzoneLiveVideoInterface:friNickNameMap	Ljava/util/HashMap;
    //   474: aload_1
    //   475: invokevirtual 933	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   478: checkcast 515	java/lang/String
    //   481: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	paramString1	String
    //   0	482	1	paramString2	String
    //   114	36	2	i	int
    //   128	72	3	j	int
    //   142	122	4	k	int
    //   388	3	5	bool	boolean
    //   16	398	6	localObject1	Object
    //   429	13	6	localException	java.lang.Exception
    //   25	348	7	localObject2	Object
    //   304	49	8	str1	String
    //   192	179	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   91	101	398	java/lang/Exception
    //   104	115	398	java/lang/Exception
    //   118	129	398	java/lang/Exception
    //   132	144	398	java/lang/Exception
    //   147	157	398	java/lang/Exception
    //   160	168	398	java/lang/Exception
    //   174	194	398	java/lang/Exception
    //   197	207	398	java/lang/Exception
    //   210	218	398	java/lang/Exception
    //   221	241	398	java/lang/Exception
    //   244	255	398	java/lang/Exception
    //   261	272	398	java/lang/Exception
    //   275	283	398	java/lang/Exception
    //   286	306	398	java/lang/Exception
    //   313	322	398	java/lang/Exception
    //   329	346	398	java/lang/Exception
    //   349	364	398	java/lang/Exception
    //   367	378	398	java/lang/Exception
    //   381	390	398	java/lang/Exception
    //   10	83	423	finally
    //   10	83	429	java/lang/Exception
    //   91	101	458	finally
    //   104	115	458	finally
    //   118	129	458	finally
    //   132	144	458	finally
    //   147	157	458	finally
    //   160	168	458	finally
    //   174	194	458	finally
    //   197	207	458	finally
    //   210	218	458	finally
    //   221	241	458	finally
    //   244	255	458	finally
    //   261	272	458	finally
    //   275	283	458	finally
    //   286	306	458	finally
    //   313	322	458	finally
    //   329	346	458	finally
    //   349	364	458	finally
    //   367	378	458	finally
    //   381	390	458	finally
    //   435	446	458	finally
  }
  
  public static int getNotchHeight(Activity paramActivity)
  {
    return SystemUtil.getNotchHeight(BaseApplicationImpl.getContext(), paramActivity);
  }
  
  public static String getPluginID()
  {
    return QZonePluginUtils.getLoadQZoneLivePluginId();
  }
  
  public static String getPluginId()
  {
    return QZonePluginUtils.getLoadQZoneLivePluginId();
  }
  
  public static String getPluginVersion()
  {
    if (QZonePluginUtils.getLoadQZoneLivePluginId().equals("qzone_live_video_plugin.apk")) {
      version = "2013 8.8.17";
    }
    return version;
  }
  
  public static String getQUA3()
  {
    return QUA.getQUA3();
  }
  
  public static int[] getRegion(Activity paramActivity, int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    double d = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    Double.isNaN(d);
    int i = (int)(d * 0.7D);
    return new int[] { i, paramInt2 * i / paramInt1 };
  }
  
  public static String getSDKPrivatePath(String paramString)
  {
    return VFSAssistantUtils.getSDKPrivatePath(paramString);
  }
  
  public static String getServerListCmdPrefix()
  {
    return ServerListProvider.getCmdPrefix();
  }
  
  public static SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString, paramInt);
  }
  
  public static String getStringConfig(String paramString1, String paramString2, String paramString3)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramString3);
  }
  
  public static long getSystemAvaialbeMemory()
  {
    return DeviceInfoUtil.a() / 1048576L;
  }
  
  public static String getVersion()
  {
    return AppSetting.h();
  }
  
  public static String getVersionForHabo()
  {
    return QUA.getVersionForHabo();
  }
  
  public static String getVideoPlayCacheDir()
  {
    return CacheManager.getVideoPlayCacheDir();
  }
  
  public static int getVipLevel()
  {
    return QZoneVipInfoManager.a().d();
  }
  
  public static int getVipType()
  {
    return QZoneVipInfoManager.a().b();
  }
  
  public static IWebviewWrapper getWebviewInstance(Context paramContext)
  {
    if (gLiveWebviewInstance == null) {
      try
      {
        if (gLiveWebviewInstance == null) {
          gLiveWebviewInstance = new WebviewWrapper(getContext());
        }
      }
      finally {}
    }
    return gLiveWebviewInstance;
  }
  
  public static boolean hasProxyParam(Uri paramUri)
  {
    return WebSoUtils.a(paramUri);
  }
  
  public static void impressionReport(String paramString) {}
  
  public static void init(long paramLong)
  {
    CacheManager.initiate(paramLong);
  }
  
  public static void initUpload() {}
  
  public static boolean isAnnualVip()
  {
    return QZoneVipInfoManager.a().e();
  }
  
  public static boolean isBestPerformanceDevice()
  {
    return QZoneHelper.isBestPerformanceDevice();
  }
  
  public static boolean isCPU64Bit()
  {
    return false;
  }
  
  public static boolean isDebugVersion()
  {
    return false;
  }
  
  public static boolean isFileExist(String paramString)
  {
    return FileUtils.fileExists(paramString);
  }
  
  public static boolean isMobile()
  {
    return NetworkState.isMobile();
  }
  
  public static boolean isNetSupport()
  {
    return NetworkState.isNetSupport();
  }
  
  public static boolean isServerListDebug()
  {
    return ServerListProvider.isDebugEnable();
  }
  
  public static boolean isServerListFileExits()
  {
    return ServerListProvider.isServerFileExits();
  }
  
  public static boolean isTestIpv6()
  {
    return false;
  }
  
  public static boolean isValidUrl(String paramString)
  {
    return HttpUtil.isValidUrl(paramString);
  }
  
  public static boolean isVideoInteractSupport()
  {
    QZoneVideoCommonUtils.VideoSupport localVideoSupport = QZoneVideoCommonUtils.getRecordSupport();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isVideoInteractSupport ");
      localStringBuilder.append(localVideoSupport.isAvailable());
      QLog.d("QzoneLiveVideoInterface", 2, localStringBuilder.toString());
    }
    return localVideoSupport.isAvailable();
  }
  
  public static boolean isWifiConn()
  {
    return NetworkState.isWifiConn();
  }
  
  public static void launchLiveVideo(String paramString1, String paramString2, String paramString3)
  {
    if (QzoneConfig.getInstance().getConfig("LiveSetting", "LiveVideoFloatLayerEntry", 1) == 1)
    {
      if (supportLaunchLiveVideo())
      {
        paramString2 = new StringBuilder();
        paramString2.append("mqzonev2://arouse/livevideo?room=&uin=&nickname=&source=qq&version=1&type=1&syncuin=");
        paramString2.append(paramString1);
        paramString2.append("&from=");
        paramString2.append(paramString3);
        paramString1 = Uri.parse(paramString2.toString());
        paramString2 = new Intent();
        paramString2.setData(paramString1);
        paramString2.setPackage("com.qzone");
        paramString2.setFlags(268435456);
        BaseApplicationImpl.getContext().startActivity(paramString2);
        return;
      }
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = QzoneConfig.getInstance().getConfig("LiveSetting", "LiveVideoDuliDownload", "https://act.qzone.qq.com/meteor/ekko/prod/57512bc9fbd5ebd076552787/index.html?_wv=1");
      }
      paramString2 = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
      QZoneHelper.openWebSecurityVerify(paramString2);
      paramString2.putExtra("url", paramString1);
      paramString2.putExtra("fromQZone", true);
      if (WebViewPluginFactory.a.containsKey("Qzone")) {
        paramString2.putExtra("insertPluginsArray", new String[] { "Qzone" });
      }
      paramString2.setData(Uri.parse(paramString1));
      paramString2.addFlags(268435456);
      QZoneHelper.addSource(paramString2);
      BaseApplicationImpl.getContext().startActivity(paramString2);
      return;
    }
    paramString1 = new Intent();
    paramString1.setClassName(BaseApplicationImpl.getContext(), getLiveVideoDownLoadClassName());
    paramString1.putExtra("mode", 1);
    paramString1.putExtra("from", paramString3);
    paramString1.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(paramString1);
  }
  
  public static boolean loadFilterSo(String paramString)
  {
    try
    {
      System.load(paramString);
      return true;
    }
    catch (Throwable paramString)
    {
      QLog.e("QzoneLiveVideoInterface", 1, "", paramString);
    }
    return false;
  }
  
  public static boolean loadNativeLibrary(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    return SoLoadUtil.a(paramContext, paramString, paramInt, paramBoolean);
  }
  
  public static Toast makeToast(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    return QQToast.makeText(BaseApplication.getContext(), paramInt1, paramCharSequence, paramInt2).create(paramInt3);
  }
  
  public static void onIORunningBackground() {}
  
  public static void openAIO(Activity paramActivity, String paramString)
  {
    Activity localActivity = paramActivity;
    if ((paramActivity instanceof BasePluginActivity)) {
      localActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    paramActivity = AIOUtils.a(new Intent(localActivity, SplashActivity.class), new int[] { 2 });
    paramActivity.putExtra("uin", paramString);
    paramActivity.putExtra("uintype", 0);
    paramActivity.addFlags(268435456);
    localActivity.startActivity(paramActivity);
  }
  
  public static void preInitWebview(IWebviewOnClassLoaded paramIWebviewOnClassLoaded)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QzoneLiveVideoInterface.2(paramIWebviewOnClassLoaded));
  }
  
  public static void preloadWebProcess()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("from", -1);
    localIntent.setAction("com.tencent.mobileqq.webprocess.preload_web_process");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    localIntent.putExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  public static void publishMood(String paramString, ArrayList<String> paramArrayList1, int paramInt1, int paramInt2, ArrayList<String> paramArrayList2, long paramLong, HashMap<String, String> paramHashMap)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.content", paramString);
    localBundle.putStringArrayList("param.images", paramArrayList1);
    localBundle.putInt("param.quality", paramInt1);
    localBundle.putInt("param.priv", paramInt2);
    localBundle.putStringArrayList("param.privList", paramArrayList2);
    localBundle.putLong("param.time", paramLong);
    localBundle.putSerializable("param.extMap", paramHashMap);
    RemoteHandleManager.getInstance().sendData("cmd.publishMood", localBundle, false);
  }
  
  public static void reportMta(String paramString, HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, paramString, true, 0L, 0L, paramHashMap, null);
  }
  
  public static void reportToDC01245(LpReportInfo_dc01245 paramLpReportInfo_dc01245, boolean paramBoolean1, boolean paramBoolean2)
  {
    LpReportManager.getInstance().reportToDC01245(paramLpReportInfo_dc01245, paramBoolean1, paramBoolean2);
  }
  
  public static void sendEventToWebview(String paramString, JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("*.qq.com");
    EventApiPlugin.a(paramString, paramJSONObject, localArrayList, null);
  }
  
  public static void sharePictureToQzone(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity != null) && (paramBundle != null))
    {
      String str3 = paramBundle.getString("title");
      String str4 = paramBundle.getString("summary");
      String str1 = paramBundle.getString("screenshot_path");
      String str2 = paramBundle.getString("uin");
      paramBundle = paramBundle.getString("nickname");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
        localUserInfo.qzone_uin = str2;
        localUserInfo.nickname = paramBundle;
        QZoneHelper.forwardToPublishMood(paramActivity, localUserInfo, str1, str3, str4, paramInt);
        return;
      }
      paramActivity = new StringBuilder();
      paramActivity.append("sharePictureToQzone failed ! picPath=");
      paramActivity.append(str1);
      paramActivity.append(" uin=");
      paramActivity.append(str2);
      QLog.i("QZLog", 1, paramActivity.toString());
      return;
    }
    QLog.i("QZLog", 1, "sharePictureToQzone failed !");
  }
  
  public static void shareToQQ(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Activity localActivity = paramActivity;
    if ((paramActivity instanceof BasePluginActivity)) {
      localActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    paramActivity = new Intent(localActivity, ForwardRecentActivity.class);
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString5)))
    {
      paramActivity.putExtra("forward_type", 1);
      paramActivity.putExtra("forward_thumb", paramString5);
      paramActivity.putExtra("key_flag_from_plugin", true);
    }
    else
    {
      paramActivity.putExtra("forward_type", 2);
      paramActivity.putExtra("req_type", 1);
      paramActivity.putExtra("req_share_id", Long.parseLong("1103584836"));
      paramActivity.putExtra("title", paramString1);
      paramActivity.putExtra("image_url_remote", paramString3);
      paramActivity.putExtra("desc", paramString2);
      paramActivity.putExtra("detail_url", paramString4);
    }
    localActivity.startActivity(paramActivity);
  }
  
  public static void shareToQzone(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    QZoneShareData localQZoneShareData = new QZoneShareData();
    localQZoneShareData.mTitle = paramString1;
    localQZoneShareData.mSummary = paramString2;
    localQZoneShareData.mImageUrls = new ArrayList();
    localQZoneShareData.mImageUrls.add(paramString3);
    localQZoneShareData.targetUrl = paramString4;
    localQZoneShareData.from = 0;
    localQZoneShareData.shareUin = paramString5;
    QZoneShareManager.shareToQzone(paramContext, paramString5, localQZoneShareData, null, paramInt);
  }
  
  public static void showToast(String paramString, int paramInt)
  {
    QQToast.makeText(BaseApplicationImpl.getContext(), paramInt, paramString, 1).show();
  }
  
  public static void showToastInQZone(CharSequence paramCharSequence)
  {
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("param.toastText", paramCharSequence);
    RemoteHandleManager.getInstance().sendData("cmd.showToast", localBundle, false);
  }
  
  public static void startAlbumListActivity(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = getRegion((Activity)paramContext, paramInt1, paramInt2);
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.putExtra("enter_from", 44);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationProfileCustomCover.a);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramContext.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.TARGET_PATH", paramString);
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", arrayOfInt[0]);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", arrayOfInt[1]);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt1);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt2);
    localIntent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", true);
    localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.qzone.cover.ui.activity");
    paramContext.startActivity(localIntent);
  }
  
  public static void startEcLiveFromFloat(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, Object... paramVarArgs)
  {
    int i = 1;
    boolean bool;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      bool = ((Boolean)paramVarArgs[0]).booleanValue();
    } else {
      bool = true;
    }
    if (paramBoolean)
    {
      if (bool) {
        i = 3;
      }
      WebAccelerator.a(paramContext, paramString3, paramString2, 2, i);
      return;
    }
    if (bool) {
      i = 3;
    } else {
      i = 1;
    }
    WebAccelerator.a(paramContext, paramString1, paramString2, paramString3, "", i);
  }
  
  public static void startInspect(Object paramObject, long paramLong)
  {
    MagnifierSDK.b().c().a(paramObject, String.format("%d", new Object[] { Long.valueOf(paramLong) }));
  }
  
  public static void startLiveVideoFloatService(Context paramContext, String paramString, Bundle paramBundle, ServiceConnection paramServiceConnection)
  {
    QZoneLiveVideoPluginScreenRecordProxyService.startLiveVideoFloatService(paramContext, paramString, paramBundle, paramServiceConnection);
  }
  
  public static void startPhotoCropActivity(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    int[] arrayOfInt = getRegion((Activity)paramContext, paramInt1, paramInt2);
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mobileqq", PhotoCropActivity.class.getName());
    localIntent.putExtra("fromWhereClick", 10);
    localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramContext.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("PhotoConst.TARGET_PATH", paramString2);
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", arrayOfInt[0]);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", arrayOfInt[1]);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt1);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt2);
    localIntent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", true);
    localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.qzone.cover.ui.activity");
    paramContext.startActivity(localIntent);
  }
  
  public static void startProfileActivy(Context paramContext, String paramString)
  {
    paramContext = new AllInOne(paramString, 1);
    paramContext.profileEntryType = 61;
    ProfileUtils.openProfileCard(BaseApplicationImpl.getContext().getBaseContext(), paramContext);
  }
  
  public static void startSelectMemberForResult(Context paramContext, Intent paramIntent, int paramInt)
  {
    new Intent().putExtras(paramIntent);
    if (paramContext != null) {
      ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult((Activity)paramContext, paramIntent, paramInt);
    }
  }
  
  public static void startWebSoRequest(String paramString, Handler paramHandler)
  {
    WebSoService.a().b(paramString, paramHandler);
  }
  
  public static void startWebSoRequestWithCheck(String paramString, Handler paramHandler)
  {
    WebSoService.a().a(paramString, paramHandler);
  }
  
  public static boolean supportLaunchLiveVideo()
  {
    boolean bool2 = false;
    try
    {
      localPackageInfo = BaseApplicationImpl.getContext().getPackageManager().getPackageInfo("com.qzone", 0);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      PackageInfo localPackageInfo;
      label19:
      boolean bool1;
      break label19;
    }
    localPackageInfo = null;
    bool1 = bool2;
    if (localPackageInfo != null)
    {
      bool1 = bool2;
      if (localPackageInfo.versionCode >= 91) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveVideoInterface
 * JD-Core Version:    0.7.0.1
 */