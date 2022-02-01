package cooperation.qzone;

import NS_MOBILE_QQ.RES_ITEM_COVER;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.SurfaceView;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QzoneLiveMainRuntime;
import com.tencent.common.app.QzoneMainRuntime;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo.MediaInfo;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.qzone.QZoneTitleTabManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.ShortcutUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.util.URLUtil;
import com.tencent.util.pm.PackageUtil;
import common.config.service.QzoneAlphaConfig;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.model.PublishEventTag;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import cooperation.qzone.statistic.AccManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVideoPluginProxyService;
import dov.com.qq.im.QIMCameraCaptureActivity;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneHelper
{
  public static final String ACTION_CANCEL_QZONE_ALVIE = "com.qzone.intent.action.CANCEL_QZONE_ALIVE";
  public static final String ACTION_CHECK_QZONE_VIP_INFO = "aciton_check_qzone_vip_info";
  public static final String ACTION_INVITE_LOVE_ZONE_STATE = "actionInviteLoveZoneState";
  public static final String ACTION_LAUNCH_BY_WEB_MUSIC = "com.qzone.intent.action.LAUNCH_BY_WEB_MUSIC";
  public static final String ACTION_LAUNCH_PUBLISH_QUEUE = "com.qzone.intent.action.LAUNCH_PUBLISH_QUEUE";
  public static final String ACTION_PRELOAD_FRIEND_FEEDS = "com.qzone.intent.action.PRELOAD_FRIEND_FEEDS";
  public static final String ACTION_PRELOAD_NOTHING = "com.qzone.intent.action.PRELOAD_NOTHING";
  public static final String ACTION_PRELOAD_QCIRCLE_PUBLISH = "com.qzone.intent.action.PRELOAD_QCIRCLE_PUBLISH";
  public static final String ACTION_PRELOAD_QUN_ALBUM_FEEDS = "com.qzone.intent.action.PRELOAD_QUN_ALBUM_FEEDS";
  public static final String ACTION_PRELOAD_USER_HOME = "com.qzone.intent.action.PRELOAD_USER_HOME";
  public static final String ACTION_SHORT_CUT = "intent.start.shortcut.guide";
  public static final String ACTION_SHOW_FOLLOW_ACTION_SHEET = "showFollowActionSheet";
  public static final String ACTION_UNREAD_COUNT = "com.tencent.qq.unreadcount";
  public static final String ACTION_UPDATE_IS_SPEICAL_FOLLOW = "updateIsSpecialFollow";
  public static final String BROADCAST_SYNC_QUN_UNREAD_MESSAGE = "com.tencent.qq.syncQunMsg";
  public static final String CACHEMAMAGER_IMAGE_FILE_CACHE_NAME = "file" + File.separator + "image";
  public static final String CIPHERTEXT = "ciphertext";
  private static final String CLS_PHOTOPLUS_APPINTERFACE = "com.tencent.zebra.app.PhotoplusAppInterface";
  private static final String CLS_QZONEAPPINTERFACE = "com.qzone.app.QZoneAppInterface";
  private static final String CLS_QZONELIVE_APPINTERFACE = "com.qzone.live.app.QZoneLiveVideoAppInterface";
  private static final String CLS_QZONEMAININTERFACE = "com.tencent.common.app.QzoneMainRuntime";
  private static final String CLS_QZONEPICTURE_APPINTERFACE = "com.qzone.preview.QZonePictureAppInterface";
  private static final String CLS_QZONEVIDEOAPPINTERFACE = "com.qzone.video.service.QZoneVideoAppInterface";
  private static final String CLS_QZONE_VERTICAL_VIDEO_APPINTERFACE = "com.qzone.verticalvideo.app.QZoneVerticalVideoAppInterface";
  private static final String CLS_QZONE_WEISHI_FEEDS_APPINTERFACE = "com.qzone.verticalvideo.app.QZoneWeishiFeedsAppInterface";
  public static final String CMD_PREFIX_PUBLIC = "SQQzoneSvc.";
  public static final String COVER_PHOTO_WALL = "com.qzone.cover.ui.activity.QzoneCoverPhotoWallActivity";
  public static final String COVER_STORE = "com.qzone.cover.ui.activity.QZoneCoverStoreActivity";
  public static final String DETAIL = "com.qzone.detail.ui.activity.QzoneDetailActivity";
  public static final String DLNA_ACTVITY = "com.qzone.album.business.dlna.activity.DLNAActivity";
  public static final String FAMOUS_SPACE_ACTION_URL_CONFIG_NAME = "QzoneFamousSpaceSp";
  public static final String FAMOUS_SPACE_CANCEL_FOLLOW_ACTION = "FamouseSpaceCancelFollowAction";
  public static final String FAMOUS_SPACE_JS_CALL_NATIVE_ACTION = "JsCallNativeAction";
  public static final String FAMOUS_SPACE_USER_HOME_AND_FRIEND_FEED_PAGE = "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity";
  public static final String FRIEND_FEED = "com.qzone.feed.ui.activity.QZoneFriendFeedActivity";
  public static final String FROM_USER_HOME = "com.qzone.homepage.from_user_home";
  public static final String GROUP_FEED = "com.qzone.feed.ui.activity.QZoneQunFeedActivity";
  public static final String HOME_PAGE_SPACE_JS_CALL_REFLUSH_NAVIGATION_BAR = "JsCallReflushNavigationBar";
  public static final String INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI = "key_select_poi";
  public static final String INTENT_ACTION_CREATE_ALBUM_SHORTCUT = "com.qzone.album.CreateAlbumShortcutSucceedReceiver";
  public static final String INTENT_ENTRY_TYPE = "qzone_entry";
  public static final String INTENT_EXTINFO = "extinfo";
  public static final String INTENT_EXTINFO_JUMP_TO_DYNAMIC_SETTING = "jump_to_dynamic_setting";
  public static final String INTENT_FAMOUS_SPACE_WEBVIEW_URL = "famous_space_webview_url";
  public static final String INTENT_GO_FIRST_FEED = "go_first_feed";
  public static final String INTENT_HOME_PAGE_AUTO_SHOW_TIME_LINE = "autoShowTimeLine";
  public static final String INTENT_QZONE_BOOT_SERVICE = "com.qzone.preview.service.PictureService";
  public static final String INTENT_QZONE_PUBLISHQUEUE_SERVICE = "com.qzone.publish.business.publishqueue.PublishQueueService";
  public static final String INTENT_REDPOCKET = "redpocket";
  public static final String INTENT_SHOW_FAMOUS_SPACE_ACTIVITY_PAGE_TYPE = "famous_space_page_type";
  public static final String INTENT_UIN = "qqid";
  public static final String IS_FROM_MINI_APP = "is_from_mini_app";
  public static final String KEY_CAN_SET_LAYOUT_INFLATER_FACTORY = "key_can_set_layoutInfalter_factory";
  public static final String KEY_FAMOUS_SPACE_CONCERN = "isconcern";
  public static final String KEY_FAMOUS_SPACE_NAVIGATION_BAR_INFO = "navigationBar";
  public static final String KEY_FAMOUS_SPACE_UIN = "uin";
  public static final String KEY_FROM_H5_COVER_USER_HOME = "key_from_h5_cover_user_home";
  public static final String KEY_FROM_NATIVE_USER_HOME = "key_from_native_user_home";
  public static final String KEY_HAS_TALK = "key_has_talk";
  public static final String KEY_HIDE_QZONE_ICON = "k_hide_qzone_icon";
  public static final String KEY_IS_KEEP_ALIVE = "key_is_keep_alive";
  private static final String KEY_IS_QZONE_PUBLIC = "isQzonePublic";
  public static final String KEY_JUMP_FROM = "key_jump_from";
  public static final String KEY_LOVE_ZONE_INVITE_STATE = "loveZoneInviteState";
  public static final String KEY_MODAL = "k_modal";
  public static final String KEY_NEARBY_PROFILE = "key_nearby_profile";
  public static final String KEY_NEARBY_QZONE_TO_AIO = "key_nearby_qzone_to_aio";
  public static final String KEY_NICKNAME = "nickName";
  public static final String KEY_NOT_SHOW_SPECIAL_TOAST = "noSpecialCareToast";
  public static final String KEY_PAYKEY = "payKey";
  public static final String KEY_QZONE_NICKNAME = "nickname";
  public static final String KEY_QZONE_SID = "sid";
  public static final String KEY_QZONE_UIN = "qzone_uin";
  public static final String KEY_QZONE_VIP_OPEN_BACK_NEED_CHECK_VIPINFO = "key_qzone_vip_open_back_need_check_vipinfo";
  private static final String KEY_TOTAL_RETRIED_TIMES_PREFIX = "total_retried_times_";
  public static final String KEY_UIN = "uin";
  public static final String KEY_VIDEO_PLUGIN_SUPPORT_TRIM = "videoPluginSupportTrim";
  private static final int MAX_TOTAL_RETRY_TIMES = 3;
  public static final String MOOD_SELECT_LOCATION = "com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation";
  public static final String NEARBY_QZONE_TO_AIO = "nearby_qzone_to_aio";
  public static final String NUAN_PROFILE = "com.qzone.feed.ui.activity.QZoneNuanProfileActivity";
  public static final String OPEN_VIP = "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity";
  public static final String PACKAGENAME_FLASHPLAYER = "com.adobe.flashplayer";
  public static final String PACKAGENAME_QQMUSIC = "com.tencent.qqmusic";
  public static final String PACKAGENAME_QZONE = "com.qzone";
  public static final int PERFORMANCE_LEVEL_HIGH = 3;
  public static final int PERFORMANCE_LEVEL_LOW = 1;
  public static final int PERFORMANCE_LEVEL_MIDDLE = 2;
  public static final int PERFORMANCE_LEVEL_SUPER_HIGH = 4;
  public static final String PERMISSION_SETTING = "com.qzone.setting.QZoneSettingManager";
  public static final String PERSONAL_ALBUM = "com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity";
  public static final String PERSONAL_ALBUM_SELECT = "com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity";
  public static final String PERSONAL_PHOTO_LIST = "com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity";
  public static final String PICTURE_VIEWER = "com.qzone.preview.QzonePictureViewer";
  public static final String PUBLISH_BOX = "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity";
  public static final String PUBLISH_MOOD = "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity";
  public static final String PUBLISH_MOOD_TAB = "com.qzone.publish.ui.activity.QZonePublishMoodTabActivity";
  public static final String PUBLISH_OPERATION_MOOD = "com.qzone.publish.ui.activity.QZonePublishOperationMoodActivity";
  public static final String PUBLISH_QUEUE = "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity";
  public static final String PUBLISH_VOICE_MOOD = "com.qzone.publish.ui.activity.QZonePublishVoiceMoodActivity";
  public static final String QQ_PUBLIC_ACCOUNT_PUBLISH_PAGE = "com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity";
  public static final String QZONE_ALBUM_SHORTCUT_ACTION_TYPE = "isGoCreateAlbumShortcut";
  public static final int QZONE_ALBUM_SHORTCUT_ACTION_TYPE_CREATE = 1;
  public static final int QZONE_ALBUM_SHORTCUT_ACTION_TYPE_UPDATE = 2;
  public static final int QZONE_ALBUM_SHORTCUT_ACTION_TYPE_UPDATE_WITH_REDPOT = 3;
  public static final String QZONE_ALBUM_SHORTCUT_CREATE_FAILED = "AlbumCreateShortcutFailed";
  public static final String QZONE_APP_DEFAULT_ACTIVITY = "com.qzonex.app.tab.QZoneTabActivity";
  public static final String QZONE_CATEGORY_ALBUM_ACTIVITY = "com.qzone.album.business.albumlist.activity.QzonePhotoCategoryDetailsActivity";
  public static final String QZONE_FEEDACTIONPANELACTIVITY = "com.qzone.common.activities.FeedActionPanelActivity";
  public static final String QZONE_KEY_PUBLISH_MOOD_CAMERA_FLAG = "qzone_key_publish_mood_camera_flag";
  public static final String QZONE_KEY_SKIP_FROM_WIDGET = "qzone_key_skip_from_widget";
  public static final String QZONE_PRELOAD_FROM_AIO_MINI_PROFILE = "aio_mini_profile";
  public static final String QZONE_PRELOAD_FROM_ALBUM_SELECT = "album_select";
  public static final String QZONE_PRELOAD_FROM_FRIEND_PROFILE = "FriendProfileCardActivity";
  public static final String QZONE_PRELOAD_FROM_LEBA_CLICK = "Leba";
  public static final String QZONE_PRELOAD_FROM_LEBA_REDDOT = "MainAssistObserver";
  public static final String QZONE_PRELOAD_FROM_MSG_NOTIFICATION = "MsgNotification";
  public static final String QZONE_PRELOAD_FROM_QCIRCLE = "QCircle";
  public static final String QZONE_PRELOAD_FROM_QQ_PUBLIC_ACCOUNT = "QQPublicAccount";
  public static final String QZONE_PRELOAD_FROM_QZoneDistributedAppCtrl = "QZoneDistributedAppCtrl";
  public static final String QZONE_PRELOAD_FROM_TROOP_CHAT_PIE = "troop_chat_pie";
  public static final String QZONE_SEARCH_FEED_ACTIVITY = "com.qzone.homepage.ui.activity.QzoneSearchFeedActivity";
  public static final String QZONE_SHARE_ACTIVITY = "com.qzone.business.share.QZoneShareActionActivity";
  public static final String QZONE_SINGLE_PERMISSION_M_INTENT_UIN = "qqid";
  public static final String QZONE_TRANSLUCENT_ACTIVITY = "com.qzone.misc.web.QZoneTranslucentActivity";
  public static final String QZONE_TRANSLUCENT_ACTIVITY2 = "com.qzone.misc.web.QZoneTranslucentActivity2";
  public static final String QZONE_VIDEO_CAPTRUE = "com.qzone.video.activity.RecordActivity";
  public static final String QZONE_VIDEO_PREVIEW = "com.qzone.video.activity.PreviewVideoActivity";
  public static final String QZONE_VIDEO_RECCOMMEND_FLOAT = "com.qzone.commoncode.module.videorecommend.ui.QzoneVideoRecommendActivity";
  public static final String QZONE_VIDEO_TRIM = "com.qzone.video.activity.TrimVideoActivity";
  public static final String QZONE_VIP_OPENSUCCESS_CALLBACK = "requestQzoneOpenVip";
  public static final String QZONE_VIP_OPENSUCCESS_CALLBACK_URL = "pay://requestQzoneOpenVip";
  public static final String QZONE_VIP_OPEN_SUCC_STR = "qzone_vip_open_succ_str";
  public static final String QZ_COVER_FROM_QZone = "qzone";
  public static final String QZ_COVER_FROM_QZoneHomePage = "userhome";
  public static final String QZ_COVER_FROM_UserSummary = "usersummary";
  public static final String Q_CIRCLE_PUBLISH_PAGE = "com.tencent.qcircle.QCirclePublishFeedActivity";
  public static final String REDPOCKET = "com.tencent.mobileqq.activity.qwallet.SendHbActivity";
  public static final String SCHEME_OPEN_HOME_PAGE = "mqzone://arouse/homepage";
  public static final String SECONDARY_AIO_QZDETAIL = "aio2qzonedetail";
  public static final String SEND_REDPOCKET_GIFT_JS_CALL_NATIVE_ACTION = "com.qzone.intent.action.SendRedPocketGiftJsCallNative";
  public static final String SHORT_CUT_FROM_QZONE_PHOTO_LIST = "shortcutFromQZonePhotolist";
  public static final String SINGLE_PERMISSION_SETTING = "com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity";
  public static final String SP_IS_FIRST_INIT_KEY = "is_first_init_key";
  public static final String SP_SHORT_VIDEO = "sp_short_video";
  public static final String STICKY_NOTE_DETAIL_ACTIVITY = "com.qzone.detail.ui.activity.StickyNoteDetailActivity";
  public static final String STR_TIPS_FLOAT_ITEM_NOT_ALLOW_TO_SHOW;
  public static final String TAG = "QZoneHelper";
  public static final String UPLOAD_PHOTO = "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity";
  public static final String USER_HOME = "com.qzone.homepage.ui.activity.QZoneUserHomeActivity";
  public static final String VIDEO_COVER_PREVIEW_ACTVITY = "com.qzone.cover.ui.activity.QzoneVideoCoverPreviewActivity";
  public static final String VIDEO_STORY_AGGREGATE = "com.qzone.commoncode.module.videostory.aggregate.VideoStoryAggregateActivity";
  public static final String bNEEDCALLBACK = "bNeedCallBack";
  public static boolean comboqzProtectEnable = false;
  private static boolean gIsBestPerformanceDevice = false;
  private static boolean gIsInitPerformanceDeviceState = false;
  private static volatile String g_floatBlacklist;
  private static volatile boolean g_isInFloatBlacklist = false;
  private static volatile boolean g_isInFrontCameraBlacklist = false;
  private static volatile boolean g_isInParticleEffectBestPerformBlacklist = false;
  private static volatile boolean g_isInParticleEffectBlacklist = false;
  private static volatile int g_listScrollParformanceLevel = 0;
  private static volatile String g_particleEffectBestPerformBlacklist;
  private static volatile String g_particleEffectBlacklist;
  private static volatile int g_playGifParformanceLevel = 0;
  private static volatile String g_scanFrontCameraBlacklist;
  private static final int sDEFAULT_CORES = 1;
  private static final int sDEFAULT_CPU_FREQUENCE = 1100;
  private static final int sDEFAULT_MEMORY = 700;
  public static int sQZoneHCCode = 0;
  
  static
  {
    STR_TIPS_FLOAT_ITEM_NOT_ALLOW_TO_SHOW = HardCodeUtil.a(2131711886);
    comboqzProtectEnable = false;
    gIsBestPerformanceDevice = false;
    gIsInitPerformanceDeviceState = false;
    g_playGifParformanceLevel = 0;
    g_listScrollParformanceLevel = 0;
    g_floatBlacklist = null;
    g_isInFloatBlacklist = false;
    g_particleEffectBlacklist = null;
    g_isInParticleEffectBlacklist = false;
    g_particleEffectBestPerformBlacklist = null;
    g_isInParticleEffectBestPerformBlacklist = false;
    g_scanFrontCameraBlacklist = null;
  }
  
  public static void addQZoneStatis(Intent paramIntent, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramIntent.putExtra("refer", "mqqSetProfile");
      return;
    case 2: 
      paramIntent.putExtra("refer", "mqqAvatar");
      return;
    case 3: 
      paramIntent.putExtra("refer", "mqqQuanzi");
      return;
    case 4: 
      paramIntent.putExtra("refer", "mqqNearby");
      return;
    case 5: 
      paramIntent.putExtra("refer", "mqqChat");
      return;
    }
    paramIntent.putExtra("refer", "mqqQunSpace");
  }
  
  public static final void addSource(Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent.putExtra("big_brother_source_key", "biz_src_jc_qzone");
    }
  }
  
  public static final void addSource(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putString("big_brother_source_key", "biz_src_jc_qzone");
    }
  }
  
  public static void bindQzonePublishQueueService(QQAppInterface paramQQAppInterface, ServiceConnection paramServiceConnection)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.getApp(), QzonePluginPublishQueueProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.setAction("com.qzone.intent.action.LAUNCH_PUBLISH_QUEUE");
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = QzonePluginProxyActivity.getQZonePluginName();
    localPluginParams.e = "QQ空间";
    localPluginParams.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    localPluginParams.f = "com.qzone.publish.business.publishqueue.PublishQueueService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, "start and bind QzonePublishQueueService");
    }
    IPluginManager.c(paramQQAppInterface.getApp(), localPluginParams);
  }
  
  public static void bindQzoneVideoService(Context paramContext, String paramString, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramContext, QzoneVideoPluginProxyService.class);
    localIntent.putExtra("qzone_uin", paramString);
    QzoneVideoPluginProxyService.bindService(paramContext, paramString, localIntent, paramServiceConnection);
  }
  
  public static boolean canGifPlaySwitch()
  {
    return QzoneConfig.getInstance().getConfig("GifSetting", "GifPlaySwitch", 1) != 0;
  }
  
  public static void cancelQzoneAlive(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (checkQzoneEntranceProtectEnable())) {
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.getApp(), QzonePluginProxyService.class);
    localIntent.setAction("com.qzone.intent.action.CANCEL_QZONE_ALIVE");
    localIntent.putExtra("key_is_keep_alive", false);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = QzonePluginProxyActivity.getQZonePluginName();
    localPluginParams.e = "QQ空间";
    localPluginParams.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    localPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = null;
    localPluginParams.f = "com.qzone.preview.service.PictureService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    localPluginParams.jdField_a_of_type_Boolean = true;
    IPluginManager.c(paramQQAppInterface.getApp(), localPluginParams);
  }
  
  private static boolean checkIsFirstInit()
  {
    try
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_short_video", 4);
      if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("is_first_init_key", true)))
      {
        localSharedPreferences.edit().putBoolean("is_first_init_key", false).commit();
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public static boolean checkPackageInstalled(Context paramContext, String paramString)
  {
    return PackageUtil.a(paramContext, paramString);
  }
  
  public static boolean checkQzoneEntranceProtectEnable()
  {
    comboqzProtectEnable = LocalMultiProcConfig.getBool("comboqz_protect_enable", false);
    if (comboqzProtectEnable)
    {
      String str = LocalMultiProcConfig.getString("comboqz_qua", "");
      if (!QUA.getQUA3().equals(str))
      {
        LocalMultiProcConfig.putBool("comboqz_protect_enable", false);
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "QzoneEntranceProtectEnable:" + comboqzProtectEnable);
    }
    return comboqzProtectEnable;
  }
  
  public static void clearCache(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (paramAppRuntime == null) {}
    do
    {
      return;
      Object localObject = paramAppRuntime.getApplication();
      String str = paramAppRuntime.getAccount();
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePictureViewerProxyService.class);
      BaseApplicationImpl.getContext().stopService(localIntent);
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:picture");
      localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
      BaseApplicationImpl.getContext().stopService(localIntent);
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzone");
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzonevideo");
      CacheManager.clearFileCache((Context)localObject);
      if (!TextUtils.isEmpty(str))
      {
        ((Context)localObject).deleteDatabase(SecurityUtil.a(str));
        LocalMultiProcConfig.putInt("Widget_" + str, "WidgetID", -1);
      }
      ((Context)localObject).deleteDatabase(SecurityUtil.a("0"));
      QZConfigProviderUtil.a();
      localObject = ((Context)localObject).getFilesDir().getParent() + File.separator + "shared_prefs";
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        FileUtil.c((String)localObject + File.separator + "qz_predownload_config.xml");
        FileUtil.c((String)localObject + File.separator + "QZ_Per_Config.xml");
        FileUtil.c((String)localObject + File.separator + "QZONE_UNREAD.xml");
      }
      localObject = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "MobileQQ" + File.separator + "trace");
      if (localObject != null) {
        FileUtil.c((String)localObject);
      }
    } while ((!paramBoolean) || (!(paramAppRuntime instanceof QQAppInterface)));
    ((IPublicAccountJavascriptInterface)QRoute.api(IPublicAccountJavascriptInterface.class)).deleteAllH5Data((QQAppInterface)paramAppRuntime);
  }
  
  public static void clearFeedsCache(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    do
    {
      return;
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePictureViewerProxyService.class);
      BaseApplicationImpl.getContext().stopService(localIntent);
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:picture");
      localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
      BaseApplicationImpl.getContext().stopService(localIntent);
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzone");
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzonevideo");
    } while (TextUtils.isEmpty(paramString));
    paramContext.deleteDatabase(SecurityUtil.a(paramString));
  }
  
  public static void createAlbumShortCut(@NonNull QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Bitmap paramBitmap, long paramLong)
  {
    ThreadManager.post(new QZoneHelper.4(paramBitmap, paramQQAppInterface, paramString1, paramLong, paramString2), 2, null, true);
  }
  
  private static void createAlbumShortcutWithBmp(Bitmap paramBitmap, @NonNull QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2)
  {
    if (paramBitmap == null) {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneHelper", 2, "createAlbumShortcutWithBmp end, iconBmp is null");
      }
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT < 26)
      {
        if (QQUtils.a(paramQQAppInterface.getApp(), new String[] { paramString1 }))
        {
          ToastUtil.a().a(2131690078);
          return;
        }
        QQUtils.a(paramQQAppInterface, getShortcutIntent(paramQQAppInterface, paramString1, paramLong), paramString2, paramBitmap);
        Thread.sleep(1000L);
        if (ShortcutUtils.a(paramQQAppInterface.getApplication(), new String[] { paramString1 }))
        {
          ToastUtil.a().a(2131691380);
          return;
        }
        onCreateShortcutFailed(paramQQAppInterface);
        return;
      }
      BaseApplication localBaseApplication = paramQQAppInterface.getApp();
      ShortcutManager localShortcutManager = (ShortcutManager)localBaseApplication.getSystemService("shortcut");
      if (isShortcutCreated_O(paramString1, localShortcutManager))
      {
        ToastUtil.a().a(2131690078);
        return;
      }
      if (localShortcutManager.isRequestPinShortcutSupported())
      {
        paramBitmap = getAlbumShortcutInfo(localBaseApplication, paramBitmap, paramString1, paramLong, paramString2, "android.intent.action.VIEW");
        paramString2 = new Intent("com.qzone.album.CreateAlbumShortcutSucceedReceiver");
        paramString2.putExtra("UploadPhoto.key_album_id", paramString1);
      }
      for (boolean bool = localShortcutManager.requestPinShortcut(paramBitmap, PendingIntent.getBroadcast(localBaseApplication, 0, paramString2, 134217728).getIntentSender()); !bool; bool = false)
      {
        onCreateShortcutFailed(paramQQAppInterface);
        return;
      }
    }
  }
  
  public static AppRuntime createPhotoPlusAppInterface(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (paramBaseApplicationImpl == null) {
      return null;
    }
    try
    {
      Class localClass = Class.forName("com.tencent.zebra.app.PhotoplusAppInterface");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          QLog.e("QZLog", 1, "createPhotoPlusAppInterface load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          ClassLoader localClassLoader;
          paramBaseApplicationImpl.printStackTrace();
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassLoader = QzonePluginProxyActivity.getPhotoPlusClassLoader(paramBaseApplicationImpl);
        paramBaseApplicationImpl = localClassLoader.loadClass("com.tencent.zebra.app.PhotoplusAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl != null) {}
  }
  
  public static AppRuntime createQZoneAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    PerfTracer.traceStart("Runtime_load_runtime");
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      QLog.e("QZLog", 1, "*createQZoneAppInterface  begin");
      try
      {
        paramString = Class.forName("com.qzone.app.QZoneAppInterface");
        paramBaseApplicationImpl = paramString;
      }
      catch (ClassNotFoundException paramString)
      {
        for (;;)
        {
          paramString = QzonePluginProxyActivity.getQZonePluginClassLoader(paramBaseApplicationImpl);
          paramBaseApplicationImpl = paramString.loadClass("com.qzone.app.QZoneAppInterface");
          BasicClassTypeUtil.setClassLoader(true, paramString);
        }
      }
      if (paramBaseApplicationImpl == null)
      {
        QLog.e("QZLog", 1, "*createQZoneAppInterface load class fail");
        return null;
      }
    }
    catch (ClassNotFoundException paramBaseApplicationImpl)
    {
      QLog.e("QZoneHelper", 1, "createQZoneAppInterface", paramBaseApplicationImpl);
      for (;;)
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.newInstance();
        if ((paramBaseApplicationImpl != null) && ((paramBaseApplicationImpl instanceof AppRuntime)))
        {
          QLog.e("QZLog", 1, "*createQZoneAppInterface  suscees");
          paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
          return paramBaseApplicationImpl;
        }
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        QLog.e("QZoneHelper", 1, "createQZoneAppInterface", paramBaseApplicationImpl);
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        QLog.e("QZoneHelper", 1, "createQZoneAppInterface", paramBaseApplicationImpl);
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        QLog.e("QZoneHelper", 1, "createQZoneAppInterface", paramBaseApplicationImpl);
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        QLog.e("QZoneHelper", 1, "createQZoneAppInterface", paramBaseApplicationImpl);
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        QLog.e("QZoneHelper", 1, "createQZoneAppInterface", paramBaseApplicationImpl);
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        QLog.e("QZoneHelper", 1, "createQZoneAppInterface", paramBaseApplicationImpl);
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    finally
    {
      PerfTracer.traceEnd("Runtime_load_runtime");
    }
  }
  
  public static SurfaceView createQZoneFloatObjectView(Context paramContext, String paramString)
  {
    try
    {
      if (isInFloatItemBlacklist())
      {
        ToastUtil.a().a(STR_TIPS_FLOAT_ITEM_NOT_ALLOW_TO_SHOW, 1);
        return null;
      }
      try
      {
        Class localClass1 = Class.forName("com.qzone.personalize.floatobject.ui.FloatItemView");
        if (localClass1 == null)
        {
          QLog.e("QZLog", 1, "*createQZoneFloatObjectView load class fail");
          return null;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Class localClass2;
        for (;;)
        {
          ClassLoader localClassLoader = QzonePluginProxyActivity.getQZonePluginClassLoader(paramContext);
          localClass2 = localClassLoader.loadClass("com.qzone.personalize.floatobject.ui.FloatItemView");
          BasicClassTypeUtil.setClassLoader(true, localClassLoader);
        }
        paramContext = localClass2.getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        localClass2.getMethod("initObjects", new Class[] { String.class, Boolean.TYPE }).invoke(paramContext, new Object[] { paramString, Boolean.valueOf(true) });
        if (paramContext == null) {
          break label155;
        }
      }
      if ((paramContext instanceof SurfaceView))
      {
        paramContext = (SurfaceView)paramContext;
        return paramContext;
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        label155:
        paramContext.printStackTrace();
      }
    }
  }
  
  public static AppRuntime createQZoneLiveMainRuntime(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    PerfTracer.traceStart("Runtime_load_live_main_runtime");
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    paramBaseApplicationImpl = new QzoneLiveMainRuntime();
    PerfTracer.traceEnd("Runtime_load_live_main_runtime");
    return paramBaseApplicationImpl;
  }
  
  public static AppRuntime createQZoneMainRuntime(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    PerfTracer.traceStart("Runtime_load_main_runtime");
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    paramBaseApplicationImpl = new QzoneMainRuntime();
    PerfTracer.traceEnd("Runtime_load_main_runtime");
    return paramBaseApplicationImpl;
  }
  
  public static AppRuntime createQZonePictureAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    PerfTracer.traceStart("Runtime_load_runtime");
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.qzone.preview.QZonePictureAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString = paramString;
        paramString = QzonePluginProxyActivity.getQZonePluginClassLoader(paramBaseApplicationImpl);
        paramBaseApplicationImpl = paramString.loadClass("com.qzone.preview.QZonePictureAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
      for (;;)
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if ((paramBaseApplicationImpl != null) && ((paramBaseApplicationImpl instanceof AppRuntime)))
        {
          paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
          return paramBaseApplicationImpl;
        }
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    finally
    {
      PerfTracer.traceEnd("Runtime_load_runtime");
    }
    if (paramBaseApplicationImpl != null) {}
  }
  
  public static AppRuntime createQZoneVideoAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.qzone.video.service.QZoneVideoAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        try
        {
          QLog.e("QZLog", 1, "*createQZoneVideoAppInterface load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
        paramString = paramString;
        paramBaseApplicationImpl = QzonePluginProxyActivity.getQZonePluginClassLoader(paramBaseApplicationImpl).loadClass("com.qzone.video.service.QZoneVideoAppInterface");
        continue;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime))) {
          break label87;
        }
        paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
      }
      return null;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl != null) {}
  }
  
  public static AppRuntime createQzoneLiveAppInterface(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (paramBaseApplicationImpl == null) {
      return null;
    }
    try
    {
      Class localClass = Class.forName("com.qzone.live.app.QZoneLiveVideoAppInterface");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          QLog.e("QZLog", 1, "createQzoneLiveAppInterface load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          ClassLoader localClassLoader;
          paramBaseApplicationImpl.printStackTrace();
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassLoader = QzonePluginProxyActivity.getQzoneLiveClassLoader(paramBaseApplicationImpl);
        paramBaseApplicationImpl = localClassLoader.loadClass("com.qzone.live.app.QZoneLiveVideoAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl != null) {}
  }
  
  public static AppRuntime createVerticalVideoAppInterface(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (paramBaseApplicationImpl == null) {
      return null;
    }
    try
    {
      Class localClass = Class.forName("com.qzone.verticalvideo.app.QZoneVerticalVideoAppInterface");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassLoader = QzonePluginProxyActivity.getQzoneVerticalVideoClassLoader(paramBaseApplicationImpl);
        paramBaseApplicationImpl = localClassLoader.loadClass("com.qzone.verticalvideo.app.QZoneVerticalVideoAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      QLog.e("QZLog", 1, "createVerticalVideoAppInterface failed:", paramBaseApplicationImpl);
      return null;
    }
    if (paramBaseApplicationImpl == null)
    {
      QLog.e("QZLog", 1, "createVerticalVideoAppInterface load class fail");
      return null;
    }
    do
    {
      ClassLoader localClassLoader;
      paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
    paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
    return paramBaseApplicationImpl;
  }
  
  public static AppRuntime createWeishiFeedsAppInterface(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (paramBaseApplicationImpl == null) {
      return null;
    }
    try
    {
      Class localClass = Class.forName("com.qzone.verticalvideo.app.QZoneWeishiFeedsAppInterface");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassLoader = QzonePluginProxyActivity.getQzoneWeishiFeedsClassLoader(paramBaseApplicationImpl);
        paramBaseApplicationImpl = localClassLoader.loadClass("com.qzone.verticalvideo.app.QZoneWeishiFeedsAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      QLog.e("QZLog", 1, "createWeishiFeedsAppInterface failed:", paramBaseApplicationImpl);
      return null;
    }
    if (paramBaseApplicationImpl == null)
    {
      QLog.e("QZLog", 1, "createWeishiFeedsAppInterface load class fail");
      return null;
    }
    do
    {
      ClassLoader localClassLoader;
      paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
    paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
    return paramBaseApplicationImpl;
  }
  
  private static void deleteShortcut(Intent paramIntent, @NonNull QQAppInterface paramQQAppInterface, String paramString, Bitmap paramBitmap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString);
    localIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", paramBitmap);
    localIntent.putExtra("duplicate", false);
    localIntent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
    paramQQAppInterface.getApp().sendOrderedBroadcast(localIntent, null);
  }
  
  public static boolean disableAioStoryFeedReq()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "DisableReqAioStoryFeed", 1) == 1;
  }
  
  public static boolean enableLayoutInflaterFactory()
  {
    return QzoneConfig.getInstance().getConfigSync("QZoneSetting", "enable_layout_factory", 1) == 1;
  }
  
  public static long enableQZoneContentBoxMiniProgram()
  {
    return QzoneAlphaConfig.a().a("contentboxlaunch", "gocontentboxminiprogram", 0);
  }
  
  public static boolean enableQZoneContextBox(QQAppInterface paramQQAppInterface)
  {
    try
    {
      boolean bool = ((QZoneManager)paramQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER)).b();
      return bool;
    }
    catch (Throwable paramQQAppInterface)
    {
      QZLog.e("QZoneMsgManager.enableQZoneContextBox", 2, paramQQAppInterface, new Object[0]);
    }
    return false;
  }
  
  public static void forwardFromAIOToFeedDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("jumpToDetailFromQQWhat", 1);
    localIntent.putExtra("startup_sceneid", 4);
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    localIntent.putExtra("appid", paramInt1);
    localIntent.setFlags(67108864);
    if (QZoneLoginReportHelper.needAddLoginFromAIOFeedCard(localIntent, paramString2)) {
      QZoneLoginReportHelper.setLoginFromAIOFeedCard(localIntent);
    }
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt2);
  }
  
  public static void forwardFromQQSettingToPersonalAlbum(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    forwardToPersonalAlbum(paramActivity, paramUserInfo, paramLong, paramInt1, paramBoolean, paramInt2, 5);
  }
  
  public static void forwardFromSearchActivityToSharedFeedDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("jumpToDetailFromQQWhat", 0);
    localIntent.putExtra("startup_sceneid", 4);
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardFromSearchToFriendFeed(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    QZoneLoginReportHelper.setLoginFromSearch(paramIntent);
    forwardToFriendFeed(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static void forwardFromSearchToPersonalAlbum(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    forwardToPersonalAlbum(paramActivity, paramUserInfo, paramLong, paramInt1, paramBoolean, paramInt2, 12);
  }
  
  public static void forwardH5QZone(String paramString, Context paramContext)
  {
    String str = LocalMultiProcConfig.getString("qzh5_url", "");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "https://m.qzone.com/infocenter";
    }
    paramString = (String)localObject + "?sid=" + paramString;
    if (paramContext == null) {
      return;
    }
    localObject = new Intent(paramContext, QQBrowserActivity.class);
    openWebSecurityVerify((Intent)localObject);
    ((Intent)localObject).putExtra("plugin_start_time", System.nanoTime());
    ((Intent)localObject).putExtra("click_start_time", System.currentTimeMillis());
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    ((Intent)localObject).putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717706));
    addSource((Intent)localObject);
    paramContext.startActivity(((Intent)localObject).putExtra("url", paramString));
  }
  
  public static void forwardMiniToTroopUploadPhoto(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, String paramString3, String paramString4, int paramInt3, int paramInt4)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString1;
    paramString1 = getQZoneUploadPhotoActivityIntent(null, paramInt1, String.valueOf(paramLong), paramString2, paramString3, paramString4, "mqqChat");
    paramString1.putExtra("photoactivity_key_type", paramInt2);
    paramString1.putExtra("is_from_mini_app", true);
    paramString1.putExtra("up_way", paramInt4);
    paramString1.setFlags(402653184);
    setUserInfoToIntent(paramString1, localUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, localUserInfo.qzone_uin, paramString1, paramInt3);
  }
  
  public static void forwardOpenQzoneVip(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_OPEN_VIP");
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", paramString1);
    localIntent.putExtra("uin", paramLong);
    if (!TextUtils.isEmpty(paramString2))
    {
      localIntent.putExtra("direct_go", false);
      localIntent.putExtra("key_open_qzone_vip_dialog_title", paramString2);
    }
    for (;;)
    {
      QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
      return;
      localIntent.putExtra("direct_go", true);
    }
  }
  
  public static void forwardOpenQzoneVip2(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, long paramLong, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_OPEN_VIP");
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", paramString1);
    localIntent.putExtra("provide_uin", paramLong);
    localIntent.putExtra("success_tips", paramString3);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localIntent.putExtra("direct_go", paramBoolean);
      localIntent.putExtra("need_loading_dialog", true);
      localIntent.putExtra("key_open_qzone_vip_dialog_title", paramString2);
      QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
      return;
    }
  }
  
  public static boolean forwardQZoneApp(Context paramContext, int paramInt, long paramLong, String paramString)
  {
    boolean bool = true;
    try
    {
      Object localObject1 = paramContext.getPackageManager().getPackageInfo("com.qzone", 0);
      if (localObject1 != null)
      {
        i = ((PackageInfo)localObject1).versionCode;
        if (i >= paramInt)
        {
          if (bool)
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putLong("qqid", paramLong);
            ((Bundle)localObject1).putLong("uin", paramLong);
            ((Bundle)localObject1).putBoolean("isbackmenu", false);
            ((Bundle)localObject1).putString("selfUin", String.valueOf(paramLong));
            ((Bundle)localObject1).putString("AccountInfoSync", "mobileqq.service");
            ((Bundle)localObject1).putString("ClassNameSync", paramString);
            paramString = new Intent();
            paramString.setClassName("com.qzone", "com.qzone.QZoneSyncAccountActivity");
            paramString.putExtras((Bundle)localObject1);
            paramString.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
            paramContext.startActivity(paramString);
          }
          return bool;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel()) {
          QLog.d("QZoneHelper", 2, localNameNotFoundException.getMessage());
        }
        Object localObject2 = null;
        continue;
        if (i >= 80)
        {
          paramString = new Intent();
          paramString.setData(Uri.parse("mqzone://arouse/activefeed?source=qq&version=1"));
          paramString.setPackage("com.qzone");
          paramContext.startActivity(paramString);
          return true;
        }
        bool = false;
      }
    }
  }
  
  public static void forwardToAggregate(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    QZLog.e("QZoneHelper", "forwardToAggregate() unexpired call request!");
    QzonePluginProxyActivity.setActivityNameToIntent(paramIntent, "com.qzone.commoncode.module.videostory.aggregate.VideoStoryAggregateActivity");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static void forwardToBrowser(Activity paramActivity, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.setData(Uri.parse(paramString1));
    openWebSecurityVerify(localIntent);
    if (TextUtils.isEmpty(paramString2)) {}
    for (paramString1 = null;; paramString1 = paramString2.getBytes())
    {
      if (paramString1 != null) {
        localIntent.putExtra("post_data", paramString1);
      }
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      addSource(localIntent);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
  }
  
  public static void forwardToCategoryAlbum(Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("categoryBusiType", paramInt1);
      localIntent.putExtra("categoryId", paramString2);
      QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.album.business.albumlist.activity.QzonePhotoCategoryDetailsActivity");
      QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString1, localIntent, paramInt2);
      return;
    }
    QLog.e("QZoneHelper", 1, "forwardToCategoryAlbum fail type = " + paramInt1 + " id=" + paramString2);
  }
  
  public static void forwardToCmActionUrl(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "jump forwardToCmActionUrl URL:" + paramString);
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    openWebSecurityVerify(localIntent);
    localIntent.putExtra("url", paramString);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717706));
    localIntent.setData(Uri.parse(paramString));
    localIntent.addFlags(268435456);
    addSource(localIntent);
    paramContext.startActivity(localIntent);
  }
  
  public static void forwardToCoverPhotoWall(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, CoverCacheData paramCoverCacheData, String paramString, int paramInt)
  {
    paramUserInfo = QZoneHelper.QZoneCoverConstants.getPhotoWallUrl(paramUserInfo.qzone_uin, paramString, "usersummary", true);
    paramCoverCacheData = new Intent(paramActivity, QQBrowserActivity.class);
    openWebSecurityVerify(paramCoverCacheData);
    paramCoverCacheData.putExtra("url", paramUserInfo);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      paramCoverCacheData.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramCoverCacheData.setData(Uri.parse(paramUserInfo));
    addSource(paramCoverCacheData);
    paramActivity.startActivityForResult(paramCoverCacheData, paramInt);
  }
  
  public static void forwardToDLNAActivity(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = getQzoneActivityIntentForName(paramUserInfo, "com.qzone.album.business.dlna.activity.DLNAActivity");
    localIntent.putExtras(paramBundle);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  @Deprecated
  public static void forwardToDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("blog_url", paramString2);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("startup_sceneid", 4);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString2))
    {
      bool1 = bool2;
      if (paramString2.contains("blog")) {
        bool1 = true;
      }
    }
    localIntent.putExtra("qzone.isFavorBlog", bool1);
    localIntent.putExtra("qzone.cellid", paramString1);
    localIntent.putExtra("qzone.sourceFrom", true);
    localIntent.putExtra("qzone.favorOwner", paramLong);
    QZoneLoginReportHelper.setLoginFromMyFav(localIntent);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, Bundle paramBundle)
  {
    forwardToDetail(paramActivity, paramUserInfo, paramString1, paramString2, paramString3, paramString4, paramInt, paramBundle, true, false);
  }
  
  public static void forwardToDetail(Context paramContext, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    localIntent.putExtra("startup_sceneid", 4);
    if (paramBoolean2) {
      localIntent.addFlags(268435456);
    }
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    try
    {
      long l = Long.parseLong(paramString1);
      int i = Integer.valueOf(paramString2).intValue();
      if (paramBundle != null) {}
      for (paramString1 = paramBundle;; paramString1 = new Bundle())
      {
        paramString1.putLong("targetuin", l);
        paramString1.putInt("appid", i);
        paramString1.putString("subid", paramString4);
        paramString1.putString("cellid", paramString3);
        paramString1.putBoolean("messagelist", true);
        if (paramBundle != null) {
          paramString1.putAll(paramBundle);
        }
        localIntent.putExtras(paramString1);
        QzonePluginProxyActivity.launchPluingActivityForResult(paramContext, paramUserInfo.qzone_uin, localIntent, paramInt, null, paramBoolean1);
        return;
      }
      return;
    }
    catch (Exception paramContext)
    {
      QLog.w("QZoneHelper", 2, "forwardToDetail error", paramContext);
    }
  }
  
  public static void forwardToExtendFeeds(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString, paramIntent, paramInt, true);
  }
  
  public static void forwardToFamousUserHome(Context paramContext, QZoneHelper.UserInfo paramUserInfo, String paramString1, int paramInt1, int paramInt2, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, String paramString2, boolean paramBoolean)
  {
    paramString1 = getQZoneUserHomeActivityIntent(paramString1, paramInt2);
    if (paramBoolean) {
      paramString1.addFlags(268435456);
    }
    paramString1.putExtra("famous_space_webview_url", paramString2);
    QzonePluginProxyActivity.setActivityNameToIntent(paramString1, "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramContext, paramUserInfo.qzone_uin, paramString1, paramInt1, paramPreloadProcHitPluginSession);
  }
  
  public static void forwardToFeedActionPanel(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, int paramInt9)
  {
    if (paramInt6 == 0) {
      paramInt2 = -1;
    }
    for (;;)
    {
      paramInt7 = paramInt2;
      if (paramInt6 == 1)
      {
        paramInt7 = paramInt2;
        if (paramInt2 == 1) {
          if (paramInt2 != 1) {
            break label170;
          }
        }
      }
      label170:
      for (paramInt7 = 1;; paramInt7 = 0)
      {
        paramString1 = getFeedActionPanel(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt7, Integer.valueOf(0), null, paramInt1, "", false);
        setUserInfoToIntent(paramString1, paramUserInfo);
        paramString1.putExtra("showaticon", paramInt3);
        paramString1.putExtra("showemotionicon", paramInt4);
        paramString1.putExtra("showxuantuicon", paramInt5);
        paramString1.putExtra("needtransemoj", 1);
        paramString1.putExtra("sendbtntext", paramString5);
        paramString1.putExtra("inputmax", paramInt8);
        if (paramInt9 != 0)
        {
          paramString1.putExtra("extraIsQun", true);
          paramString1.putExtra("extraIsQunID", String.valueOf(paramInt9));
        }
        QzonePluginProxyActivity.setActivityNameToIntent(paramString1, "com.qzone.common.activities.FeedActionPanelActivity");
        QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramString1, paramInt1);
        return;
      }
    }
  }
  
  public static void forwardToFeedActionPanel(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, int paramInt9, boolean paramBoolean2)
  {
    forwardToFeedActionPanel(paramActivity, paramUserInfo, paramInt1, paramString1, paramString2, paramString3, paramString4, paramInt2, paramBoolean1, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramString5, paramInt8, paramInt9, paramBoolean2, "", false);
  }
  
  public static void forwardToFeedActionPanel(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, int paramInt9, boolean paramBoolean2, String paramString6, boolean paramBoolean3)
  {
    forwardToFeedActionPanel(paramActivity, paramUserInfo, paramInt1, paramString1, paramString2, paramString3, paramString4, paramInt2, paramBoolean1, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramString5, paramInt8, paramInt9, paramBoolean2, paramString6, paramBoolean3, null);
  }
  
  public static void forwardToFeedActionPanel(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, int paramInt9, boolean paramBoolean2, String paramString6, boolean paramBoolean3, Bundle paramBundle)
  {
    if (paramInt6 == 0) {
      paramInt2 = -1;
    }
    for (;;)
    {
      paramInt7 = paramInt2;
      if (paramInt6 == 1)
      {
        paramInt7 = paramInt2;
        if (paramInt2 == 1) {
          if (paramInt2 != 1) {
            break label322;
          }
        }
      }
      label322:
      for (paramInt7 = 1;; paramInt7 = 0)
      {
        paramString1 = getFeedActionPanel(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt7, Integer.valueOf(0), null, paramInt1, "", false);
        setUserInfoToIntent(paramString1, paramUserInfo);
        paramString1.putExtra("showaticon", paramInt3);
        paramString1.putExtra("showemotionicon", paramInt4);
        paramString1.putExtra("showxuantuicon", paramInt5);
        paramString1.putExtra("needtransemoj", 1);
        paramString1.putExtra("sendbtntext", paramString5);
        paramString1.putExtra("inputmax", paramInt8);
        paramString1.putExtra("is_share", paramBoolean1);
        if (paramInt9 != 0)
        {
          paramString1.putExtra("extraIsQun", true);
          paramString1.putExtra("extraIsQunID", String.valueOf(paramInt9));
        }
        if (!TextUtils.isEmpty(paramString6)) {
          paramString1.putExtra("extraCacheKey", paramString6);
        }
        paramString1.putExtra("is_live_mode", paramBoolean3);
        QzonePluginProxyActivity.setActivityNameToIntent(paramString1, "com.qzone.common.activities.FeedActionPanelActivity");
        if (paramBundle != null)
        {
          paramString1.putExtra("disableAutoClose", paramBundle.getBoolean("disableAutoClose"));
          paramString1.putExtra("catchHeightChange", paramBundle.getBoolean("catchHeightChange"));
          paramString1.putExtra("catchClosePanel", paramBundle.getBoolean("catchClosePanel"));
          paramString1.putExtra("input_text_allow_empty", paramBundle.getBoolean("input_text_allow_empty"));
          paramString1.putExtra("isFromDIY", paramBundle.getBoolean("isFromDIY"));
          paramString1.putExtra("extra_key_font_id", paramBundle.getInt("extra_key_font_id", -1));
        }
        paramString1.putExtra("extra_key_from_scene", 4);
        QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramString1, paramInt1, null, paramBoolean2);
        return;
      }
    }
  }
  
  public static void forwardToFeedDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("startup_sceneid", 4);
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    localIntent.putExtra("appid", paramInt1);
    localIntent.setFlags(67108864);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt2);
  }
  
  public static void forwardToFriendFeed(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramIntent, paramInt, paramOnDismissListener, true);
  }
  
  public static void forwardToFriendFeed(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    forwardToFriendFeed(paramActivity, paramString, paramIntent, null, paramInt);
  }
  
  public static void forwardToFriendFeed(Activity paramActivity, String paramString1, Intent paramIntent, String paramString2, int paramInt)
  {
    QLog.d("qzone_launch", 4, "forwardToFriendFeed click");
    paramIntent.putExtra("startup_sceneid", 1);
    if (paramString2 != null) {
      paramIntent.putExtra("key_push_trans_channel", paramString2);
    }
    QZoneTitleTabManager.a(paramIntent);
    if (!forwardToQZoneFriendFeedActivity(paramActivity, paramIntent, true)) {
      QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString1, paramIntent, paramInt);
    }
  }
  
  public static void forwardToGroupAlbum(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN");
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    localIntent.putExtra("startup_sceneid", 6);
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("key_qun_code", paramString2);
    localIntent.putExtra("key_thumb_file_path", paramString3);
    localIntent.putExtra("key_big_photo_uuid", paramString4);
    localIntent.putExtra("key_msg_time", paramLong);
    localIntent.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToGroupAlbum(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Long> paramArrayList, int paramInt, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN");
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    localIntent.putExtra("startup_sceneid", 6);
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("key_qun_code", paramString2);
    localIntent.putExtra("key_thumb_file_paths", paramArrayList1);
    localIntent.putExtra("key_big_photo_uuids", paramArrayList2);
    localIntent.putExtra("key_msg_times", paramArrayList);
    localIntent.setFlags(402653184);
    localIntent.putExtra("refer", "mqqChat");
    if (paramString3 != null) {
      localIntent.putExtra("UploadPhoto.key_album_id", paramString3);
    }
    if (paramString4 != null) {
      localIntent.putExtra("UploadPhoto.key_album_name", paramString4);
    }
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToGroupFeed(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    localIntent.putExtra("startup_sceneid", 8);
    localIntent.putExtra("key_qun_id", paramString2);
    localIntent.putExtra("ken_qun_name", paramString3);
    localIntent.putExtra("refer", "group_profile");
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.feed.ui.activity.QZoneQunFeedActivity");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString1, localIntent, paramInt);
  }
  
  public static void forwardToMoodSelectLocation(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation");
    localIntent.putExtra("k_modal", true);
    localIntent.putExtra("k_hide_qzone_icon", true);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToMoodSelectLocation(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation");
    localIntent.putExtra("k_modal", true);
    localIntent.putExtra("k_hide_qzone_icon", true);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToMoodSelectLocation(Context paramContext, String paramString, int paramInt, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramContext, paramString, localIntent, paramInt);
  }
  
  public static void forwardToNuanProfile(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt)
  {
    try
    {
      Intent localIntent = new Intent();
      setUserInfoToIntent(localIntent, paramUserInfo);
      QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.feed.ui.activity.QZoneNuanProfileActivity");
      localIntent.putExtra("key_uin", Long.parseLong(paramString));
      QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.e("QZoneHelper", 2, "forwardToNuanProfile error!", paramActivity);
    }
  }
  
  public static void forwardToOpenRecordPanel(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, Activity paramActivity, String paramString1, String paramString2)
  {
    paramString2 = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(paramString2, "com.qzone.publish.ui.activity.QZonePublishVoiceMoodActivity");
    paramString2.putExtra("key_entrance_is_voice_mood", false);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString1, paramString2, generateRequestCode(paramWebViewPlugin, paramPluginRuntime, 6));
  }
  
  public static void forwardToPermissionSetting(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    paramUserInfo = QzoneConfig.getInstance().getConfig("H5Url", "QzoneSettingMainPage", "https://h5.qzone.qq.com/qzone/setting?_wv=3&_proxy=1&uin={uin}").replace("{uin}", String.valueOf(paramUserInfo.qzone_uin)).replace("{host_uin}", paramUserInfo.qzone_uin).replace("{UIN}", String.valueOf(paramUserInfo.qzone_uin)).replace("{HOST_UIN}", paramUserInfo.qzone_uin);
    if (!URLUtil.b(paramUserInfo).containsKey("_wv")) {
      URLUtil.a(paramUserInfo, "_wv", "5");
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "jump qzone setting URL:" + paramUserInfo);
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    openWebSecurityVerify(localIntent);
    localIntent.putExtra("url", paramUserInfo);
    localIntent.putExtra("isFromQQ", true);
    localIntent.putExtra("fromQZone", false);
    localIntent.putExtra("injectrecommend", true);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717706));
    localIntent.setData(Uri.parse(paramUserInfo));
    localIntent.addFlags(268435456);
    addSource(localIntent);
    paramActivity.startActivity(localIntent);
  }
  
  public static void forwardToPersonalAlbum(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    forwardToPersonalAlbum(paramActivity, paramUserInfo, paramLong, paramInt1, paramInt2, paramInt3, null);
  }
  
  public static void forwardToPersonalAlbum(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, int paramInt2, int paramInt3, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    paramLong = getQzonePersonalAlbumActivityIntent(paramActivity, paramLong, paramInt1);
    setUserInfoToIntent(paramLong, paramUserInfo);
    addQZoneStatis(paramLong, paramInt2);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramLong, paramInt3, paramPreloadProcHitPluginSession);
  }
  
  public static void forwardToPersonalAlbum(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    forwardToPersonalAlbum(paramActivity, paramUserInfo, paramLong, paramInt1, paramBoolean, paramInt2, -1);
  }
  
  public static void forwardToPersonalAlbum(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    LocalMultiProcConfig.putBool("key_photo_guide_is_red", paramBoolean);
    paramLong = getQzonePersonalAlbumActivityIntent(paramActivity, paramLong, paramInt1);
    setUserInfoToIntent(paramLong, paramUserInfo);
    paramLong.putExtra("startup_sceneid", 3);
    paramLong.putExtra("key_need_show_album_recent_photo", true);
    paramLong.putExtra("refer", "mqqSetting");
    paramLong.putExtra("key_redTouch", paramBoolean);
    QZoneLoginReportHelper.handleLoginToMyAlbum(paramLong, paramInt3);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramLong, paramInt2);
  }
  
  public static void forwardToPersonalAlbumPhotoList(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo, int paramInt)
  {
    paramBaseBusinessAlbumInfo = getAlbumPhotoListIntent(paramUserInfo, paramBaseBusinessAlbumInfo);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramBaseBusinessAlbumInfo, paramInt);
  }
  
  public static void forwardToPersonalAlbumPhotoListFromShortcut(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo, int paramInt)
  {
    paramBaseBusinessAlbumInfo = getAlbumPhotoListIntent(paramUserInfo, paramBaseBusinessAlbumInfo);
    paramBaseBusinessAlbumInfo.putExtra("UploadPhoto.key_from_album_shortcut", true);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramBaseBusinessAlbumInfo, paramInt);
  }
  
  public static void forwardToPersonalAlbumPhotoListV2(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo, int paramInt, String paramString)
  {
    paramBaseBusinessAlbumInfo = getAlbumPhotoListIntent(paramUserInfo, paramBaseBusinessAlbumInfo);
    paramBaseBusinessAlbumInfo.putExtra("mqqflag", 1);
    paramBaseBusinessAlbumInfo.putExtra("cell_operation.qq_url", paramString);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramBaseBusinessAlbumInfo, paramInt);
  }
  
  public static void forwardToPersonalAlbumSelect(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = getQzoneActivityIntentForName(paramUserInfo, "com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity");
    localIntent.putExtras(paramBundle);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToPersonalAlbumVideoList(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo, int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity");
    localIntent.putExtra("key_album_id", paramBaseBusinessAlbumInfo.mAlbumId);
    localIntent.putExtra("key_album_name", paramBaseBusinessAlbumInfo.mTitle);
    localIntent.putExtra("key_album_owner_uin", paramBaseBusinessAlbumInfo.mUin);
    localIntent.putExtra("key_is_individual_album", paramBaseBusinessAlbumInfo.isIndividualityAlbum);
    localIntent.putExtra("key_album_anonymity", paramBaseBusinessAlbumInfo.mAnonymity);
    localIntent.putExtra("QZ_ALBUM_THEME", paramBaseBusinessAlbumInfo.mAlbumType);
    localIntent.putExtra("key_personal_album_enter_model", 2);
    localIntent.putExtra("key_album_refer", paramString);
    if (isRunningInQzoneProcess())
    {
      localIntent.setClassName(paramActivity, "com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity");
      paramActivity.startActivity(localIntent);
      return;
    }
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToPersonalPhotoList(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = getQzoneActivityIntentForName(paramUserInfo, "com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity");
    localIntent.putExtras(paramBundle);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToPictureSetting(Context paramContext, QZoneHelper.UserInfo paramUserInfo)
  {
    paramUserInfo = QzoneConfig.getInstance().getConfig("H5Url", "QzonePictureSettingPage", "https://h5.qzone.qq.com/image/setting/imageSetting?_wv=3&_proxy=1&uin={uin}").replace("{uin}", String.valueOf(paramUserInfo.qzone_uin)).replace("{host_uin}", paramUserInfo.qzone_uin).replace("{UIN}", String.valueOf(paramUserInfo.qzone_uin)).replace("{HOST_UIN}", paramUserInfo.qzone_uin);
    if (!URLUtil.b(paramUserInfo).containsKey("_wv")) {
      URLUtil.a(paramUserInfo, "_wv", "5");
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "jump qzone setting URL:" + paramUserInfo);
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    openWebSecurityVerify(localIntent);
    localIntent.putExtra("url", paramUserInfo);
    localIntent.putExtra("isFromQQ", true);
    localIntent.putExtra("fromQZone", false);
    localIntent.putExtra("injectrecommend", true);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717706));
    localIntent.setData(Uri.parse(paramUserInfo));
    localIntent.addFlags(268435456);
    addSource(localIntent);
    paramContext.startActivity(localIntent);
  }
  
  public static void forwardToPictureViewer(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    RemoteHandleManager.getInstance().sendData("cmd.cancelKillPictureProcess", null, false);
    Intent localIntent = getQzoneActivityIntentForName(paramUserInfo, "com.qzone.preview.QzonePictureViewer");
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("fromQZone", false);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt, null, false);
  }
  
  public static void forwardToPictureViewerForQzone(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    RemoteHandleManager.getInstance().sendData("cmd.cancelKillPictureProcess", null, false);
    Intent localIntent = getQzoneActivityIntentForName(paramUserInfo, "com.qzone.preview.QzonePictureViewer");
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("fromQZone", true);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt, null, false);
  }
  
  public static void forwardToPreviewLocalView(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.video.activity.VideoViewActivity");
    localIntent.putExtra("video_type", paramInt);
    localIntent.putExtra("video_source_path", paramString);
    localIntent.putExtra("start_time", paramLong1);
    localIntent.putExtra("end_time", paramLong2);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, 0);
  }
  
  public static void forwardToPublishBox(Context paramContext, Bundle paramBundle, int paramInt)
  {
    paramBundle = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(paramBundle, "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity");
    paramBundle.putExtra("fromQZone", false);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramContext, "0", paramBundle, paramInt, null, false);
  }
  
  public static void forwardToPublishMood(Activity paramActivity, Bundle paramBundle, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    localIntent.putExtra("startup_sceneid", 5);
    localIntent.putExtra("key_file_path", paramString1);
    localIntent.putExtra("key_title", paramString2);
    localIntent.putExtra("key_desc", paramString3);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToPublishMood(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, int paramInt)
  {
    paramIntent = new Intent(paramIntent);
    setUserInfoToIntent(paramIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(paramIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramIntent, paramInt);
  }
  
  public static void forwardToPublishMood(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_OPEN_SHARE");
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    localIntent.putExtra("startup_sceneid", 5);
    localIntent.putExtra("key_file_path", paramString);
    localIntent.putExtra("key_title", HardCodeUtil.a(2131711885));
    localIntent.putExtra("key_desc", "");
    localIntent.putExtra("key_need_save_draft", false);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToPublishMood(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_PUBLISH_QR_CODE");
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    localIntent.putExtra("startup_sceneid", 5);
    localIntent.putExtra("key_file_path", paramString1);
    localIntent.putExtra("key_title", paramString2);
    localIntent.putExtra("key_desc", paramString3);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToPublishQueue(Context paramContext, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    forwardToPublishQueue(paramContext, paramUserInfo, null, paramInt);
  }
  
  public static void forwardToPublishQueue(Context paramContext, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramContext, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToQQPublicAccountPublishPage(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      long l = ((AppRuntime)localObject).getLongAccountUin();
      localObject = paramIntent;
      if (paramIntent == null) {
        localObject = new Intent();
      }
      QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject, "com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity");
      QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, String.valueOf(l), (Intent)localObject, paramInt);
    }
  }
  
  public static void forwardToQZoneFlashNickNameSetting(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString, localIntent, 0);
  }
  
  public static boolean forwardToQZoneFriendFeedActivity(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    if (paramContext != null) {}
    try
    {
      if (QQTheme.e())
      {
        if ((paramContext instanceof FragmentActivity))
        {
          if (QZoneApiProxy.isInQZoneEnvironment()) {
            return false;
          }
          if (!QZoneApiProxy.needShowQzoneFrame((FragmentActivity)paramContext, ((FragmentActivity)paramContext).app)) {
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
      if ((!paramBoolean) && (paramContext != null))
      {
        if ((paramContext instanceof BasePluginActivity)) {
          QzonePluginProxyActivity.setActivityNameToIntent(paramIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
        }
        paramContext.startActivity(paramIntent);
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QZoneHelper", 1, "qzone start error" + paramContext);
    }
    return false;
  }
  
  public static void forwardToQunAlbumDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    paramUserInfo = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunAlbumDetail", "https://h5.qzone.qq.com/groupphoto/inqq/detail/{QQ_URL}?_wv=3&_proxy=1").replace("{QQ_URL}", URLEncoder.encode(paramString1));
    paramString1 = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
    paramString1.putExtra("url", paramUserInfo);
    paramString1.putExtra("fromQZone", true);
    paramString1.putExtra("injectrecommend", true);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      paramString1.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString1.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717706));
    paramString1.setData(Uri.parse(paramUserInfo));
    paramActivity.startActivityForResult(paramString1, paramInt);
  }
  
  public static void forwardToQunAlbumList(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    paramString1 = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunAlbum", "https://h5.qzone.qq.com/groupphoto/inqq/album/{QUN_ID}?_wv=3&_proxy=1").replace("{QUN_ID}", paramString1);
    paramUserInfo = paramString1;
    if (!TextUtils.isEmpty(paramString3)) {
      paramUserInfo = paramString1 + "&source=" + paramString3;
    }
    paramString1 = new Intent(paramActivity, QQBrowserActivity.class);
    openWebSecurityVerify(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "forwardToQunAlbumList:" + paramUserInfo);
    }
    paramString1.putExtra("url", paramUserInfo);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      paramString1.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString1.setData(Uri.parse(paramUserInfo));
    addSource(paramString1);
    paramActivity.startActivityForResult(paramString1, paramInt2);
  }
  
  public static void forwardToQunAlbumListSelect(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramUserInfo = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunAlbumSelect", "https://h5.qzone.qq.com/groupphoto/inqq/album/{QUN_ID}/select?_wv=3&_proxy=1").replace("{QUN_ID}", paramString1);
    paramString1 = new Intent(paramActivity, QQBrowserActivity.class);
    openWebSecurityVerify(paramString1);
    paramString1.putExtra("url", paramUserInfo);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      paramString1.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString1.setData(Uri.parse(paramUserInfo));
    addSource(paramString1);
    paramActivity.startActivityForResult(paramString1, paramInt);
  }
  
  public static void forwardToQunFeed(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    paramUserInfo = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunFeed", "https://h5.qzone.qq.com/groupphoto/inqq/recent/{QUN_ID}/groupphoto?_wv=3&_proxy=1").replace("{QUN_ID}", paramString1);
    paramString1 = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
    paramString1.putExtra("url", paramUserInfo);
    paramString1.putExtra("fromQZone", true);
    paramString1.putExtra("injectrecommend", true);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      paramString1.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString1.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717706));
    paramString1.setData(Uri.parse(paramUserInfo));
    if (QZoneLoginReportHelper.needAddLoginFromQunAlbum(paramString1, paramInt)) {
      QZoneLoginReportHelper.reportLoginFromQunAlbum();
    }
    paramActivity.startActivityForResult(paramString1, paramInt);
  }
  
  public static void forwardToQunPassiveFeed(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt)
  {
    paramUserInfo = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunPassiveFeed", "https://h5.qzone.qq.com/groupphoto/inqq/relatedme/{QUN_ID}/{UIN}?_wv=3&_proxy=1").replace("{QUN_ID}", paramString).replace("{UIN}", paramUserInfo.qzone_uin);
    paramString = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
    paramString.putExtra("url", paramUserInfo);
    paramString.putExtra("fromQZone", true);
    paramString.putExtra("injectrecommend", true);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      paramString.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717706));
    paramString.setData(Uri.parse(paramUserInfo));
    if (QZoneLoginReportHelper.needAddLoginFromQunAlbum(paramString, paramInt)) {
      QZoneLoginReportHelper.reportLoginFromQunAlbum();
    }
    paramActivity.startActivityForResult(paramString, paramInt);
  }
  
  public static void forwardToQzDynamicEditVideoActivity(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.album.ui.activity.QzDynamicVideoEditActivity");
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("extra_is_from_p2v_edit", true);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt, null, false);
  }
  
  public static void forwardToQzoneAlbum(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong1, long paramLong2, int paramInt2)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_QUOTE_FROM_AIO");
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    localIntent.putExtra("startup_sceneid", 6);
    if (paramBoolean)
    {
      localIntent.putExtra("key_qun_id", paramString1);
      localIntent.putExtra("key_qun_code", paramString2);
      localIntent.putExtra("key_big_photo_file_id", paramLong2);
    }
    localIntent.putExtra("key_quote_src_type", paramInt1);
    localIntent.putExtra("key_thumb_file_path", paramString3);
    localIntent.putExtra("key_big_photo_uuid", paramString4);
    localIntent.putExtra("key_msg_time", paramLong1);
    localIntent.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt2);
  }
  
  public static void forwardToQzoneAlbum(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Long> paramArrayList3, ArrayList<Long> paramArrayList4, int paramInt2)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_QUOTE_FROM_AIO");
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    localIntent.putExtra("startup_sceneid", 6);
    if (paramBoolean)
    {
      localIntent.putExtra("key_qun_id", paramString1);
      localIntent.putExtra("key_qun_code", paramString2);
      localIntent.putExtra("key_big_photo_fileids", paramArrayList4);
    }
    localIntent.putExtra("key_quote_src_type", paramInt1);
    localIntent.putExtra("key_thumb_file_paths", paramArrayList1);
    localIntent.putExtra("key_big_photo_uuids", paramArrayList2);
    localIntent.putExtra("key_msg_times", paramArrayList3);
    localIntent.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt2);
  }
  
  public static void forwardToQzoneBrowser(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.cover.ui.activity.QZoneBrowserActivity");
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.setData(Uri.parse(paramString1));
    openWebSecurityVerify(localIntent);
    if (TextUtils.isEmpty(paramString2)) {}
    for (paramString1 = null;; paramString1 = paramString2.getBytes())
    {
      if (paramString1 != null) {
        localIntent.putExtra("post_data", paramString1);
      }
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
      return;
    }
  }
  
  public static boolean forwardToQzoneDetailFromAIO(Activity paramActivity, String paramString1, String paramString2)
  {
    if ((!paramString1.startsWith("http://mobile.qzone.qq.com")) && (!paramString1.startsWith("https://mobile.qzone.qq.com"))) {}
    do
    {
      do
      {
        return false;
        paramString2 = Uri.parse(paramString1);
      } while (paramString2 == null);
      paramString2 = paramString2.getQueryParameter("jumptoqzone");
    } while ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals("1")));
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "aio2qzonedetail", 1) == 1)
    {
      paramString2 = new Intent();
      setUserInfoToIntent(paramString2, QZoneHelper.UserInfo.getInstance());
      QzonePluginProxyActivity.setActivityNameToIntent(paramString2, "com.qzone.detail.ui.activity.QzoneDetailActivity");
      paramString2.putExtra("startup_sceneid", 4);
      paramString2.putExtra("mqqflag", 1);
      paramString2.putExtra("cell_operation.qq_url", paramString1);
      paramString2.putExtra("jumpToDetailFromQQWhat", 2);
      paramString2.putExtra("refer", "mqqChat");
      QZoneLoginReportHelper.setLoginFromAIOFeedShare(paramString2);
      QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, QZoneHelper.UserInfo.getInstance().qzone_uin, paramString2, 0);
      if (QLog.isColorLevel()) {
        QLog.i("QZoneHelper", 2, "forwardToQzoneDetailFromAIO success:url=" + paramString1);
      }
    }
    return true;
  }
  
  public static void forwardToQzoneFeedsSearch(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, int paramInt)
  {
    paramIntent = new Intent(paramIntent);
    setUserInfoToIntent(paramIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(paramIntent, "com.qzone.homepage.ui.activity.QzoneSearchFeedActivity");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramIntent, paramInt);
  }
  
  public static void forwardToQzoneTransluentActivity(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent)
  {
    forwardToQzoneTransluentActivity(paramActivity, paramUserInfo, paramIntent, -1);
  }
  
  public static void forwardToQzoneTransluentActivity(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, int paramInt)
  {
    setUserInfoToIntent(paramIntent, paramUserInfo);
    if (paramInt >= 0) {
      paramIntent.putExtra("bNeedCallBack", true);
    }
    for (;;)
    {
      QzonePluginProxyActivity.setActivityNameToIntent(paramIntent, "com.qzone.misc.web.QZoneTranslucentActivity");
      QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramIntent, paramInt);
      return;
      paramIntent.putExtra("bNeedCallBack", false);
    }
  }
  
  public static void forwardToQzoneTransluentActivity(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    setUserInfoToIntent(paramIntent, paramUserInfo);
    if (paramInt >= 0) {
      paramIntent.putExtra("bNeedCallBack", true);
    }
    for (;;)
    {
      QzonePluginProxyActivity.setActivityNameToIntent(paramIntent, "com.qzone.misc.web.QZoneTranslucentActivity");
      QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramIntent, paramInt, null, paramBoolean);
      return;
      paramIntent.putExtra("bNeedCallBack", false);
    }
  }
  
  public static void forwardToQzoneTransluentActivity2(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent)
  {
    setUserInfoToIntent(paramIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(paramIntent, "com.qzone.misc.web.QZoneTranslucentActivity2");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramIntent, 0);
  }
  
  public static void forwardToQzoneVideoCaptureNew(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (CaptureUtil.a()) {
      paramActivity.startActivityForResult(QIMCameraCaptureActivity.a(paramActivity, paramBundle), paramInt);
    }
    for (;;)
    {
      paramActivity.overridePendingTransition(2130772321, 2130772317);
      return;
      if (!paramActivity.isFinishing()) {
        DialogUtil.a(paramActivity, 230).setMessage(HardCodeUtil.a(2131711888)).setPositiveButton(2131694615, new QZoneHelper.6()).show();
      }
    }
  }
  
  public static void forwardToQzoneVideoCaptureNew(QQAppInterface paramQQAppInterface, Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, boolean paramBoolean3, boolean paramBoolean4, String paramString3, boolean paramBoolean5, String paramString4, String paramString5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, String paramString6, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, int paramInt2, boolean paramBoolean13, Bundle paramBundle)
  {
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("edit_video_type", 10001);
    LocalMultiProcConfig.putBool("support_trim", paramBoolean1);
    paramQQAppInterface.putInt("from_type", 1);
    paramQQAppInterface.putBoolean("enable_front", true);
    paramQQAppInterface.putBoolean("enable_edit_video", paramBoolean4);
    paramQQAppInterface.putBoolean("enable_local_video", true);
    paramQQAppInterface.putBoolean("is_qzone_vip", paramBoolean3);
    paramQQAppInterface.putString("set_user_callback", "cooperation.qzone.video.VideoComponentCallback");
    paramQQAppInterface.putBoolean("flow_camera_video_mode", true);
    paramQQAppInterface.putBoolean("flow_camera_capture_mode", paramBoolean2);
    paramQQAppInterface.putString("short_video_refer", paramString2);
    paramQQAppInterface.putString("callback", paramString4);
    paramQQAppInterface.putString("dongxiao_id", paramString5);
    paramQQAppInterface.putString("topic_id", paramString3);
    paramQQAppInterface.putBoolean("enter_ptu", paramBoolean5);
    paramQQAppInterface.putBoolean("enable_input_text", paramBoolean6);
    paramQQAppInterface.putBoolean("enable_priv_list", paramBoolean7);
    paramQQAppInterface.putBoolean("enable_sync_qzone", paramBoolean8);
    paramQQAppInterface.putBoolean("enable_origin_video", paramBoolean9);
    paramQQAppInterface.putString("confirm_text", paramString6);
    paramQQAppInterface.putBoolean("enable_edit_button", paramBoolean10);
    paramQQAppInterface.putBoolean("enable_local_button", paramBoolean11);
    paramQQAppInterface.putBoolean("is_glance_video", paramBoolean12);
    if (paramBoolean12)
    {
      paramQQAppInterface.putInt("video_min_frame_count", 5);
      paramQQAppInterface.putLong("activity_start_time", SystemClock.elapsedRealtime());
      if (paramBoolean2)
      {
        paramUserInfo = PlusPanelUtils.a(AppConstants.SDCARD_IMG_CAMERA);
        paramQQAppInterface.putBoolean("support_photo_merge", true);
        paramQQAppInterface.putString("qcamera_photo_filepath", paramUserInfo);
        paramQQAppInterface.putInt("extra.busi_type", 3);
        paramQQAppInterface.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        paramQQAppInterface.putBoolean("DirectBackToQzone", true);
        paramQQAppInterface.putString("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
        paramQQAppInterface.putString("pic_confirm_text", HardCodeUtil.a(2131711890));
      }
      paramQQAppInterface.putInt("entry_source", paramInt2);
      paramQQAppInterface.putBoolean("go_publish_activity", paramBoolean13);
      if (paramBundle != null) {
        paramQQAppInterface.putAll(paramBundle);
      }
      if (!CaptureUtil.a()) {
        break label398;
      }
      QIMCameraCaptureActivity.a(paramActivity, paramQQAppInterface);
    }
    for (;;)
    {
      paramActivity.overridePendingTransition(2130772321, 2130772317);
      return;
      if (((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(0, 1)) {
        break;
      }
      paramQQAppInterface.putInt("video_min_frame_count", 8);
      break;
      label398:
      DialogUtil.a(paramActivity, 230).setMessage(HardCodeUtil.a(2131711888)).setPositiveButton(2131694615, new QZoneHelper.7()).show();
    }
  }
  
  public static void forwardToQzoneVideoTrim(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("need_select_video", true);
    localIntent.putExtra("file_send_path", paramString1);
    localIntent.putExtra("PhotoConst.VIDEO_SIZE", paramLong);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", paramInt2);
    if (paramActivity.getIntent() != null) {
      localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", paramActivity.getIntent().getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("refer", paramString2);
    }
    localIntent.putExtra("video_refer", paramString3);
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.video.activity.TrimVideoActivity");
    if (isRunningInQzoneProcess())
    {
      localIntent.setClassName(paramActivity, "com.qzone.video.activity.TrimVideoActivity");
      paramActivity.startActivity(localIntent);
      return;
    }
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt1);
  }
  
  public static void forwardToRedPocket(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, long paramLong, String paramString2, String paramString3, int paramInt)
  {
    Object localObject = paramActivity;
    if (paramActivity == null) {
      localObject = BaseApplication.getContext();
    }
    paramActivity = new ActivityURIRequest((Context)localObject, "/qwallet/redpacket/sendhb");
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("skey", paramString1);
      ((JSONObject)localObject).put("skey_type", 2);
      ((JSONObject)localObject).put("recv_uin", paramLong);
      ((JSONObject)localObject).put("recv_name", paramString2);
      ((JSONObject)localObject).put("bus_type", 1);
      ((JSONObject)localObject).put("channel", 128);
      ((JSONObject)localObject).put("feedsid", paramString3);
      paramActivity.extra().putString("userId", paramUserInfo.qzone_uin);
      paramActivity.extra().putString("userName", paramUserInfo.nickname);
      paramActivity.extra().putString("app_info", "appid#0|bargainor_id#1000030201|channel#qzonefeeds");
      paramActivity.extra().putInt("come_from", 2);
      paramActivity.extra().putString("extra_data", ((JSONObject)localObject).toString());
      paramActivity.extra().putInt("startup_sceneid", 4);
      paramActivity.extra().putBoolean("qzone.sourceFrom", true);
      paramActivity.setFlags(536870912);
      paramActivity.setRequestCode(paramInt);
      QRoute.startUri(paramActivity, new QZoneHelper.3());
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static void forwardToSharedFeedDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("startup_sceneid", 4);
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    if (QZoneLoginReportHelper.needAddLoginFromAIOFeedShare(localIntent, paramString2)) {
      QZoneLoginReportHelper.setLoginFromAIOFeedShare(localIntent);
    }
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToShuoshuoDailyCalendar(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    paramUserInfo = new SimpleDateFormat("yyyyMM", Locale.getDefault()).format(new Date());
    paramUserInfo = QzoneConfig.getInstance().getConfig("H5Url", "QzoneShuoshuoDailyCalendar", "https://h5.qzone.qq.com/v2/shuoshuo-daily/calendar/{date}?_wv=16777216").replace("{date}", paramUserInfo).replace("{DATE}", paramUserInfo);
    if (!URLUtil.b(paramUserInfo).containsKey("_wv")) {
      URLUtil.a(paramUserInfo, "_wv", "1027");
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "jump qzone ShuoshuoDailyCalendar URL:" + paramUserInfo);
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    openWebSecurityVerify(localIntent);
    localIntent.putExtra("url", paramUserInfo);
    localIntent.putExtra("isFromQQ", false);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717706));
    localIntent.setData(Uri.parse(paramUserInfo));
    localIntent.addFlags(268435456);
    addSource(localIntent);
    paramActivity.startActivity(localIntent);
  }
  
  public static void forwardToSinglePermissionSetting(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity");
    localIntent.putExtra("qqid", paramLong);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToTroopAlbumViewPhoto(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    paramUserInfo = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunAlbumPhotoList", "https://h5.qzone.qq.com/groupphoto/inqq/photo/{QUN_ID}/{ALBUM_ID}?_wv=3&_proxy=1").replace("{QUN_ID}", paramString1).replace("{ALBUM_ID}", paramString2);
    paramString1 = new Intent(paramActivity, QQBrowserActivity.class);
    openWebSecurityVerify(paramString1);
    paramString1.putExtra("url", paramUserInfo);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      paramString1.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString1.setData(Uri.parse(paramUserInfo));
    addSource(paramString1);
    paramActivity.startActivityForResult(paramString1, paramInt);
  }
  
  @Deprecated
  public static void forwardToTroopUploadPhoto(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, ArrayList<String> paramArrayList, int paramInt2, int paramInt3)
  {
    paramString1 = getQZoneUploadPhotoActivityIntent(null, 1, paramString1, paramString2, paramString3, paramString4, "mqqChat");
    setUserInfoToIntent(paramString1, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    if (paramString1 == null) {
      return;
    }
    int i = paramInt1;
    switch (paramInt1)
    {
    default: 
      i = paramInt1;
    }
    for (;;)
    {
      paramString1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      paramString1.putExtra("key_quality", i);
      paramString1.putExtra("key_album_upload_immediately", true);
      paramString1.putExtra("photoactivity_key_type", 1);
      paramString1.putExtra("up_way", paramInt3);
      paramString2 = String.valueOf(MessageUtils.a());
      paramIntent.putExtra("key_upload_client_key", paramString2);
      paramString1.putExtra("key_upload_client_key", paramString2);
      QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramString1, paramInt2);
      return;
      i = 0;
      continue;
      i = 3;
    }
  }
  
  public static void forwardToTroopUploadPhoto(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, String paramString3, String paramString4, int paramInt3, int paramInt4)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString1;
    paramString1 = getQZoneUploadPhotoActivityIntent(null, paramInt1, String.valueOf(paramLong), paramString2, paramString3, paramString4, "mqqChat");
    paramString1.putExtra("photoactivity_key_type", paramInt2);
    paramString1.putExtra("up_way", paramInt4);
    paramString1.setFlags(67108864);
    setUserInfoToIntent(paramString1, localUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, localUserInfo.qzone_uin, paramString1, paramInt3);
  }
  
  public static void forwardToTroopUploadPhoto(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, String paramString3, String paramString4, ArrayList<String> paramArrayList, int paramInt3, int paramInt4, int paramInt5)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString1;
    paramString1 = getQZoneUploadPhotoActivityIntent(null, paramInt1, String.valueOf(paramLong), paramString2, paramString3, paramString4, "mqqChat");
    paramString1.putStringArrayListExtra("images", paramArrayList);
    paramString1.putExtra("photoactivity_key_type", paramInt2);
    paramString1.putExtra("key_quality", paramInt5);
    paramString1.putExtra("up_way", paramInt4);
    paramString1.setFlags(67108864);
    setUserInfoToIntent(paramString1, localUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, localUserInfo.qzone_uin, paramString1, paramInt3);
    if (1 == paramInt1) {
      LpReportInfo_pf00064.allReport(40, 3, 4);
    }
  }
  
  public static void forwardToUploadPhoto(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, ArrayList<String> paramArrayList, String paramString2, int paramInt3)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString1;
    paramString1 = getQZoneUploadPhotoActivityIntent(null, paramInt1, null, null, null, null, "mqqChat");
    paramString1.putExtra("photoactivity_key_type", paramInt2);
    paramString1.putStringArrayListExtra("images", paramArrayList);
    paramString1.putExtra("key_begin_send_show_toast", paramString2);
    paramString1.setFlags(67108864);
    setUserInfoToIntent(paramString1, localUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, localUserInfo.qzone_uin, paramString1, paramInt3);
  }
  
  public static void forwardToUploadPhoto(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
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
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString1, localIntent, generateRequestCode(paramWebViewPlugin, paramPluginRuntime, 1));
  }
  
  public static void forwardToUserHome(Context paramContext, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    forwardToUserHome(paramContext, paramUserInfo, paramString, paramInt1, paramInt2, paramInt3, null, null, false);
  }
  
  public static void forwardToUserHome(Context paramContext, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt1, int paramInt2, int paramInt3, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Intent localIntent = getQZoneUserHomeActivityIntent(paramString, paramInt3);
    if (paramBoolean) {
      localIntent.addFlags(268435456);
    }
    int i;
    if ((isSupportWebViewCover()) && (parseAndSetQzoneCoverInfoToIntent(localIntent, paramArrayOfByte)))
    {
      i = 1;
      if (i == 0) {
        break label106;
      }
      QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity");
    }
    for (;;)
    {
      if (QZoneLoginReportHelper.needAddLoginFromFriendProfile(localIntent, paramString, paramInt3)) {
        QZoneLoginReportHelper.setLoginFromFriendProfile(localIntent);
      }
      localIntent.putExtra("startup_sceneid", 2);
      addQZoneStatis(localIntent, paramInt1);
      QzonePluginProxyActivity.launchPluingActivityForResult(paramContext, paramUserInfo.qzone_uin, localIntent, paramInt2, paramPreloadProcHitPluginSession);
      return;
      i = 0;
      break;
      label106:
      setUserInfoToIntent(localIntent, paramUserInfo);
      QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    }
  }
  
  public static void forwardToUserHomeByNearBy(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, ProfileActivity.AllInOne paramAllInOne)
  {
    paramString = getQZoneUserHomeActivityIntent(paramString, 6);
    setUserInfoToIntent(paramString, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(paramString, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramString.putExtra("key_has_talk", paramBoolean);
    paramString.putExtra("key_nearby_profile", paramAllInOne);
    paramString.putExtra("startup_sceneid", 2);
    addQZoneStatis(paramString, paramInt1);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramString, paramInt2);
  }
  
  public static void forwardToVideoEditActionPanel(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, int paramInt9, int paramInt10, boolean paramBoolean3)
  {
    forwardToVideoEditActionPanel(paramActivity, paramUserInfo, paramInt1, paramString1, paramString2, paramString3, paramString4, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramString5, paramInt8, paramBundle, paramBoolean1, paramBoolean2, paramInt9, paramInt10, paramBoolean3, null);
  }
  
  public static void forwardToVideoEditActionPanel(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, Bundle paramBundle1, boolean paramBoolean1, boolean paramBoolean2, int paramInt9, int paramInt10, boolean paramBoolean3, Bundle paramBundle2)
  {
    if (paramInt6 == 0) {
      paramInt2 = -1;
    }
    for (;;)
    {
      paramString1 = getFeedActionPanel(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt2, Integer.valueOf(0), null, paramInt1, "", false);
      setUserInfoToIntent(paramString1, paramUserInfo);
      paramString1.putExtra("showaticon", paramInt3);
      paramString1.putExtra("showemotionicon", paramInt4);
      paramString1.putExtra("showxuantuicon", paramInt5);
      paramString1.putExtra("showfonticon", 1);
      paramString1.putExtra("show_super_font", false);
      if (paramBoolean3) {}
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        paramString1.putExtra("needtransemoj", paramInt2);
        paramString1.putExtra("sendbtntext", paramString5);
        paramString1.putExtra("inputmax", paramInt8);
        paramString1.putExtra("extra_key_bundle_priv", paramBundle1);
        paramString1.putExtra("video_edit_mode", true);
        paramString1.putExtra("is_topic", paramBoolean1);
        paramString1.putExtra("extraIsTopicSyncQzone", paramBoolean2);
        paramString1.putExtra("extra_key_font_id", paramInt9);
        paramString1.putExtra("extra_key_super_font_id", paramInt10);
        if (paramBundle2 != null) {
          paramString1.putExtras(paramBundle2);
        }
        QzonePluginProxyActivity.setActivityNameToIntent(paramString1, "com.qzone.common.activities.FeedActionPanelActivity");
        QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramString1, paramInt1, null, true);
        return;
      }
    }
  }
  
  public static void forwardToWriteEventShuoShuo(Activity paramActivity, String paramString1, String paramString2, ArrayList<String> paramArrayList, ArrayList<ResultRecord> paramArrayList1, PublishEventTag paramPublishEventTag, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("qzone_uin", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("summary", paramString2);
    }
    paramString2 = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        String str = (String)paramArrayList.next();
        if (!TextUtils.isEmpty(str)) {
          paramString2.add(str);
        }
      } while (paramString2.size() < 9);
    }
    if (paramString2.size() > 0) {
      localIntent.putStringArrayListExtra("images", paramString2);
    }
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
      localIntent.putParcelableArrayListExtra("at_friend", paramArrayList1);
    }
    if (paramPublishEventTag != null) {
      localIntent.putExtra("event_tag", paramPublishEventTag);
    }
    localIntent.putExtra("isEmbedInTabActivity", true);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodTabActivity");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString1, localIntent, paramInt);
  }
  
  public static void forwardToWriteMood(Activity paramActivity, QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    publishMood(paramQQAppInterface, paramActivity, getPublishMoodInfo(paramIntent.getStringExtra("summary"), paramIntent.getStringExtra("filePath"), paramIntent.getIntExtra("reqType", 1)), paramIntent, paramInt, paramBoolean);
  }
  
  public static void forwardToWriteMood(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, boolean paramBoolean)
  {
    publishMood(paramQQAppInterface, paramActivity, getPublishMoodInfo(paramString1, paramString2, paramInt1), paramString3, paramInt2, paramBoolean);
  }
  
  public static void forwardToWriteMood(Activity paramActivity, String paramString, int paramInt)
  {
    forwardToWriteMood(paramActivity, paramString, null, null, null, null, paramInt);
  }
  
  public static void forwardToWriteMood(Activity paramActivity, String paramString1, String paramString2, ArrayList<String> paramArrayList, ArrayList<ResultRecord> paramArrayList1, PublishEventTag paramPublishEventTag, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("qzone_uin", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("summary", paramString2);
    }
    paramString2 = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        String str = (String)paramArrayList.next();
        if (!TextUtils.isEmpty(str)) {
          paramString2.add(str);
        }
      } while (paramString2.size() < 9);
    }
    if (paramString2.size() > 0) {
      localIntent.putStringArrayListExtra("images", paramString2);
    }
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
      localIntent.putParcelableArrayListExtra("at_friend", paramArrayList1);
    }
    if (paramPublishEventTag != null) {
      localIntent.putExtra("event_tag", paramPublishEventTag);
    }
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString1, localIntent, paramInt);
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
  
  @NonNull
  private static Intent getAlbumPhotoListIntent(QZoneHelper.UserInfo paramUserInfo, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity");
    localIntent.putExtra("key_album_id", paramBaseBusinessAlbumInfo.mAlbumId);
    localIntent.putExtra("key_photo_sort_type", paramBaseBusinessAlbumInfo.sortType);
    localIntent.putExtra("key_album_name", paramBaseBusinessAlbumInfo.mTitle);
    localIntent.putExtra("key_album_owner_uin", paramBaseBusinessAlbumInfo.mUin);
    localIntent.putExtra("key_is_individual_album", paramBaseBusinessAlbumInfo.isIndividualityAlbum);
    localIntent.putExtra("key_personal_album_enter_model", 0);
    return localIntent;
  }
  
  @NonNull
  @RequiresApi(api=26)
  private static ShortcutInfo getAlbumShortcutInfo(Context paramContext, Bitmap paramBitmap, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramContext, ShortcutGuideActivity.class);
    localIntent.setAction(paramString3);
    localIntent.putExtra("from", "shortcutFromQZonePhotolist");
    localIntent.putExtra("UploadPhoto.key_album_id", paramString1);
    localIntent.putExtra("UploadPhoto.key_album_owner_uin", paramLong);
    localIntent.setFlags(337641472);
    return new ShortcutInfo.Builder(paramContext, paramString1).setIcon(Icon.createWithBitmap(paramBitmap)).setShortLabel(paramString2).setIntent(localIntent).build();
  }
  
  public static int getDevicePerformanceLevel()
  {
    int i = 3;
    if (g_playGifParformanceLevel != 0) {
      return g_playGifParformanceLevel;
    }
    if (((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(3, 2)) {}
    for (;;)
    {
      g_playGifParformanceLevel = i;
      QLog.d("QZoneHelper", 2, "[jinqianli-performance] current mem level is " + ((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).getCurrentMemLevel() + ", current cpu level is " + ((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).getCurrentCpuLevel() + ", play gif parformance level is " + g_playGifParformanceLevel);
      return i;
      if (((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(2, 1)) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
  
  public static int getDevicePerformanceLevelInfo()
  {
    int i = 3;
    if (g_listScrollParformanceLevel != 0) {
      return g_listScrollParformanceLevel;
    }
    if (((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).equalHardwareRestriction(3, 3)) {
      i = 4;
    }
    for (;;)
    {
      g_listScrollParformanceLevel = i;
      QLog.d("QZoneHelper", 2, "[jinqianli-performance] current mem level is " + ((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).getCurrentMemLevel() + ", current cpu level is " + ((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).getCurrentCpuLevel() + ", play gif parformance level is " + g_playGifParformanceLevel);
      return i;
      if (!((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).equalHardwareRestriction(2, 2)) {
        if (((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).equalHardwareRestriction(1, 1)) {
          i = 2;
        } else {
          i = 1;
        }
      }
    }
  }
  
  public static Intent getFeedActionPanel(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, Serializable paramSerializable, Parcelable paramParcelable, int paramInt2, String paramString5, boolean paramBoolean)
  {
    paramContext = new Intent();
    paramContext.putExtra("autoSaveStorageKey", paramString5);
    paramContext.putExtra("extraRequestCode", paramInt2);
    paramContext.putExtra("showkeyicon", paramInt1);
    if (paramString3 != null) {
      paramContext.putExtra("extraCommentID", paramString3);
    }
    if (paramString4 != null) {
      paramContext.putExtra("extraReplyID", paramString4);
    }
    if (paramSerializable != null) {
      paramContext.putExtra("extraIntentKey", paramSerializable);
    }
    if (paramString2 != null) {
      paramContext.putExtra("feedTextAutoFillKey", paramString2);
    }
    if (paramParcelable != null) {
      paramContext.putExtra("extraIntentKeyParcelable", paramParcelable);
    }
    if (paramString1 != null) {
      paramContext.putExtra("feedTextHintKey", paramString1);
    }
    paramContext.putExtra("extraIsSystemTransparentBar", 1);
    return paramContext;
  }
  
  public static IUploadConfig.UploadImageSize getImageTargetSize(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      Class localClass = Class.forName("com.qzone.misc.network.uploader.QZoneImageSizeStrategy");
      paramContext = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          QLog.e("QZLog", 1, "*QZoneImageSizeStrategy load class fail");
          return null;
        }
        catch (ClassNotFoundException paramContext)
        {
          ClassLoader localClassLoader;
          paramContext.printStackTrace();
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassLoader = QzonePluginProxyActivity.getQZonePluginClassLoader(paramContext);
        paramContext = localClassLoader.loadClass("com.qzone.misc.network.uploader.QZoneImageSizeStrategy");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      return null;
      paramContext = (IUploadConfig.UploadImageSize)paramContext.getMethod("getTargetSize", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }).invoke(null, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    if (paramContext != null) {}
  }
  
  public static Intent getJumpQzoneTabIntent(Context paramContext, Intent paramIntent)
  {
    paramIntent.setClass(paramContext, SplashActivity.class);
    paramIntent.putExtra("fragment_id", 1);
    paramIntent.putExtra("tab_index", FrameControllerUtil.i);
    paramIntent.putExtra("open_qzone_tab_fragment", true);
    paramIntent.setFlags(335544320);
    return paramIntent;
  }
  
  public static int getMaxRecentUserNum()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "MaxNumInConverstation", 100);
  }
  
  private static PublishMoodInfo getPublishMoodInfo(String paramString1, String paramString2, int paramInt)
  {
    PublishMoodInfo localPublishMoodInfo = new PublishMoodInfo();
    ArrayList localArrayList = new ArrayList();
    PublishMoodInfo.MediaInfo localMediaInfo = new PublishMoodInfo.MediaInfo();
    localMediaInfo.mPath = paramString2;
    if (paramInt == 4) {}
    for (localMediaInfo.mType = 2;; localMediaInfo.mType = 1)
    {
      localArrayList.add(localMediaInfo);
      localPublishMoodInfo.mText = paramString1;
      localPublishMoodInfo.mMediaInfo = localArrayList;
      return (PublishMoodInfo)((IMiniAppService)QRoute.api(IMiniAppService.class)).validMoodInfo(localPublishMoodInfo);
    }
  }
  
  public static String getQUA()
  {
    return QUA.getQUA3();
  }
  
  public static Intent getQZoneDetailActivity()
  {
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    return localIntent;
  }
  
  private static Intent getQZoneUploadPhotoActivityIntent(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString1 = new Intent(paramString1);
    paramString1.putExtra("QZoneUploadPhotoActivity.key_state_type_src", paramInt);
    paramString1.putExtra("key_qun_id", paramString2);
    paramString1.putExtra("ken_qun_name", paramString3);
    paramString1.putExtra("UploadPhoto.key_album_id", paramString4);
    paramString1.putExtra("UploadPhoto.key_album_name", paramString5);
    paramString1.putExtra("key_need_load_photo_from_intent", false);
    paramString1.putExtra("refer", paramString6);
    paramString1.putExtra("IsBack", true);
    return paramString1;
  }
  
  public static Intent getQZoneUserHomeActivityIntent(String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("qqid", Long.parseLong(paramString));
      localIntent.putExtra("qzone_entry", paramInt);
      localIntent.putExtra("hc_code", sQZoneHCCode);
      sQZoneHCCode = 0;
      putTimeRecord(localIntent);
      return localIntent;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        QZLog.e("QZoneHelper", "getQZoneUserHomeActivityIntent", paramString);
      }
    }
  }
  
  private static Intent getQzoneActivityIntentForName(QZoneHelper.UserInfo paramUserInfo, String paramString)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, paramString);
    return localIntent;
  }
  
  public static BaseBusinessAlbumInfo getQzoneAlbumInfo(String paramString1, String paramString2)
  {
    long l = LocalMultiProcConfig.getLong(MD5.toMD5(paramString1 + "_" + paramString2 + "_record_time"), 0L);
    if (QzoneConfig.getInstance().getConfig("PhotoUpload", "C2CAioAlbumCacheExpireTime", 60) * 60 * 1000L + l < System.currentTimeMillis())
    {
      QZLog.i("QZoneHelper", 1, "getQzoneAlbumInfo cache expire. albumId=" + paramString2 + " recordTime=" + l);
      return null;
    }
    String str2 = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_id");
    String str1 = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_title");
    paramString1 = MD5.toMD5(paramString1 + "_" + paramString2 + "_exist");
    paramString2 = LocalMultiProcConfig.getString(str2, "");
    str1 = LocalMultiProcConfig.getString(str1, "");
    boolean bool = LocalMultiProcConfig.getBool(paramString1, true);
    paramString1 = new BaseBusinessAlbumInfo(paramString2);
    paramString1.mTitle = str1;
    paramString1.isAlbumExist = bool;
    return paramString1;
  }
  
  @Deprecated
  public static Intent getQzoneFriendFeedActivity(Context paramContext)
  {
    paramContext = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(paramContext, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    return paramContext;
  }
  
  public static Intent getQzoneMyFeedActivity(Context paramContext)
  {
    paramContext = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(paramContext, "com.qzone.feed.ui.activity.QZoneMyFeedActivity");
    return paramContext;
  }
  
  private static Intent getQzonePersonalAlbumActivityIntent(Context paramContext, Long paramLong, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_left_tab_title", paramContext.getString(2131717404));
    localIntent.putExtra("key_rihgt_tab_title", paramContext.getString(2131717485));
    localIntent.putExtra("key_album_owner_uin", paramLong);
    localIntent.putExtra("key_selected_tab", paramInt);
    putTimeRecord(localIntent);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity");
    return localIntent;
  }
  
  public static String getQzonePluginSoUrl()
  {
    return QzoneConfig.getInstance().getConfig("LiveSetting", "LivePluginSOUrl", "https://d3g.qq.com/sngapp/app/update/20171124202406_7451/res1_qzlive_yt_base.so");
  }
  
  public static Intent getQzoneSpecialFeedActivity(Context paramContext)
  {
    paramContext = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(paramContext, "com.qzone.feed.ui.activity.QZoneSpecialActiveFeedsActivity");
    return paramContext;
  }
  
  public static BaseBusinessAlbumInfo getSelectedAlbumInfo(String paramString1, String paramString2)
  {
    String str = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_id");
    paramString1 = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_title");
    paramString2 = LocalMultiProcConfig.getString(str, "");
    paramString1 = LocalMultiProcConfig.getString(paramString1, "");
    paramString2 = new BaseBusinessAlbumInfo(paramString2);
    paramString2.mTitle = paramString1;
    return paramString2;
  }
  
  @NonNull
  private static Intent getShortcutIntent(@NonNull QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    Intent localIntent = new Intent("intent.start.shortcut.guide");
    localIntent.setClassName(paramQQAppInterface.getApp(), ShortcutGuideActivity.class.getName());
    localIntent.putExtra("from", "shortcutFromQZonePhotolist");
    localIntent.putExtra("UploadPhoto.key_album_id", paramString);
    localIntent.putExtra("UploadPhoto.key_album_owner_uin", paramLong);
    localIntent.putExtra("UploadPhoto.key_from_album_shortcut", true);
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.setFlags(337641472);
    return localIntent;
  }
  
  public static int getUpdateCountIntervalWhenClickFeedTab()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "UpdateCountIntervalWhenClickFeedTab", 30) * 1000;
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper.UndealCount", 2, "getUpdateCountIntervalWhenClickFeedTab:" + i);
    }
    return i;
  }
  
  public static int getVideoCanCompressLimitMs()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
  }
  
  public static long getVideoCanUploadLimitMs()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "VideoCanUploadDurationThreshold", 601000);
  }
  
  public static long getVideoCanUploadSize()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "VideoCanUploadSizeThreshold", 1610612736L);
  }
  
  public static int getVideoCoverLimitMs()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "VideoDurationThreshold", 60000);
  }
  
  public static void goQZoneAlbumPhotoList(Activity paramActivity, String paramString1, long paramLong, String paramString2)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString2;
    paramString2 = new BaseBusinessAlbumInfo();
    paramString2.mAlbumId = paramString1;
    paramString2.mUin = paramLong;
    paramString2.mAlbumType = 0;
    paramString2.isIndividualityAlbum = true;
    forwardToPersonalAlbumPhotoListFromShortcut(paramActivity, localUserInfo, paramString2, -1);
  }
  
  public static boolean hasEnterPictureViewer()
  {
    return LocalMultiProcConfig.getBool("key_has_enter_picture_viewer", false);
  }
  
  public static boolean hideAioFeeds()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "hideAioFeeds", 0) == 1;
  }
  
  public static boolean hideAioQCircleFeeds()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "qqcircle_show_entrance_on_aio_feed", 0) == 1;
  }
  
  public static boolean hideQzoneStatusInConverstation()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "hideFeedsInConverstation", 0) == 1;
  }
  
  public static boolean isBestPerformanceDevice()
  {
    if (!gIsInitPerformanceDeviceState)
    {
      gIsBestPerformanceDevice = ((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(1, 1);
      gIsInitPerformanceDeviceState = true;
    }
    return gIsBestPerformanceDevice;
  }
  
  private static boolean isBestPerformanceDeviceImpl()
  {
    boolean bool2 = true;
    long l1 = System.currentTimeMillis();
    int i = QzoneConfig.getInstance().getConfig("QzoneCover", "HtmlStandardCpuCore", 1);
    int j = QzoneConfig.getInstance().getConfig("QzoneCover", "HtmlStandardCpuFequency", 1100);
    int k = QzoneConfig.getInstance().getConfig("QzoneCover", "HtmlStandardRAMSize", 700);
    long l2 = DeviceInfoUtil.b() * DeviceInfoUtil.b();
    long l3 = i * j;
    boolean bool1;
    if (l2 > 0L) {
      if (l2 > l3) {
        bool1 = true;
      }
    }
    for (;;)
    {
      l2 = DeviceInfoUtil.a();
      if (l2 > 0L) {
        if ((bool1) && (l2 > 1048576L * k)) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        l3 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("QZoneHelper", 2, "isBestPerformanceDeviceImpl standardCpuCore=" + i + ",standardCpuFequency=" + j + ",standardRAMSize=" + k + ",cpu count=" + DeviceInfoUtil.b() + ",cpu frequency=" + DeviceInfoUtil.b() + ",total memory=" + l2 + ",use time=" + (l3 - l1));
        }
        return bool1;
        bool1 = false;
        break;
        bool1 = false;
      }
      bool1 = true;
    }
  }
  
  private static boolean isBuildModelInList(String paramString)
  {
    try
    {
      String str = Build.MODEL;
      if ((str == null) || (str.length() == 0))
      {
        QLog.i("QZoneHelper", 1, "buildModel is empty,not show float items.命中禁止策略");
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QZoneHelper", 2, "buildModel is '" + str + "'");
      }
      if ((paramString == null) || (paramString.length() == 0)) {
        break label161;
      }
      str = "," + str + ",";
      if (("," + paramString + ",").contains(str))
      {
        QLog.i("QZoneHelper", 1, "命中禁止黑名单策略");
        return true;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    return false;
    label161:
    return false;
  }
  
  public static boolean isFirstEnterFriendFeed()
  {
    return LocalMultiProcConfig.getBool("key_first_enter_friend_feed", true);
  }
  
  public static boolean isInFloatItemBlacklist()
  {
    boolean bool2 = false;
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "FloatModelBlacklist", "N5117,R8007,Coolpad 8720L,R7007,GN9000L,G620-L75,R2017,R6007,R831S,HM 1SC,Coolpad 8705,HUAWEI B199,Coolpad 9190L,HM 1SW,Coolpad 8730L,Coolpad 9190_T00,HS-E620M,HUAWEI G660-L075,Coolpad 5952,HUAWEI G730-L075,Coolpad 8729,HUAWEI C8817L,Bird LT01,Coolpad 5892,Coolpad 7620L,GN9004,HS-X8T,iPhone 6plus,K-Touch Tou ch 2,K-Touch Tou ch3,K-Touch Tou ch3w,Lenovo A560,Lenovo A890e,Lenovo B8080-HV,Lenovo S810t,LT18,MI 3C,N5110,Nokia_XL_4G,R2010,R8000,TCL-P688L,U558,ZTE Grand S II LTE,ZTE Q505T,ZTE Q802T,Coolpad Y60-C1,Coolpad 8702,BOWAY TL2000,Best sonny_LT986,BOWAY TL6000,Coolpad 5200S,Coolpad 5311,Coolpad 5315,DOOV T35,DOOV T60,HS-EG971,HS-EG978,HTC D516d,HUAWEI G6-L22,HUAWEI G620-L72,i6200S,KliTON,koobee M2,L-002,L823,L826,L827,Lingwin K1,LNV-Lenovo A505e,M7009,M811,MI 3W,R830S,ZTE Q801L,ZTE Q701C,YUSUN L63,TCL P631M,TCL J738M,T-smart L818,OUKI G5,OPSSON Q3,　　,MT2L03,VOTO VT898,AOLE,N5111,LA2-L,vtel X5,ETON T3,BOWAY TL500,T-smart L808,DOOV T90,CHM-TL00,thl L968,TCL J938M,2013022,HUAWEI G750-T01,vivo Y20T,vivo Y17T,vivo Y13T,vivo Y15T,vivo X3S W,U707T,R823T,R819T,N1T,Hol-T00,H8S,H30-U10,2014011,M351,HUAWEI G610-T11,vivo X3t,HUAWEI P6-T00,HUAWEI G700-U00,ETON I6,vivo Y11i T,HM NOTE 1TD");
    if (str == null) {
      return false;
    }
    if (!str.equals(g_floatBlacklist))
    {
      boolean bool1;
      if (Build.VERSION.SDK_INT != 18)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT != 17) {}
      }
      else
      {
        bool1 = bool2;
        if (isBuildModelInList(str)) {
          bool1 = true;
        }
      }
      g_isInFloatBlacklist = bool1;
      g_floatBlacklist = str;
    }
    return g_isInFloatBlacklist;
  }
  
  public static boolean isInParticleEffectBestPerformBlacklist()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "ParticleEffectBestPerformBlacklist", "");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if (!str.equals(g_particleEffectBestPerformBlacklist))
    {
      g_isInParticleEffectBestPerformBlacklist = isBuildModelInList(str);
      g_particleEffectBestPerformBlacklist = str;
    }
    return g_isInParticleEffectBestPerformBlacklist;
  }
  
  public static boolean isInParticleEffectBlacklist()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "ParticleEffectBlacklist", "");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if (!str.equals(g_particleEffectBlacklist))
    {
      g_isInParticleEffectBlacklist = isBuildModelInList(str);
      g_particleEffectBlacklist = str;
    }
    return g_isInParticleEffectBlacklist;
  }
  
  public static boolean isInQzoneFacadeDynamicBlackList()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzonefacade_dynamic_black_list", "GT-N7108");
    if (str == null) {
      return false;
    }
    return isBuildModelInList(str);
  }
  
  public static boolean isInQzoneShowBreezeBlackList()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneShow_breeze_black_list", "");
    if (str == null) {
      return false;
    }
    return isBuildModelInList(str);
  }
  
  private static boolean isPreload2QTADisable()
  {
    File localFile = new File(Environment.getExternalStorageDirectory().getPath(), "disable_preload");
    return (localFile != null) && (localFile.exists());
  }
  
  public static boolean isQzonePermissionPublic(long paramLong)
  {
    return LocalMultiProcConfig.getInt4Uin("isQzonePublic", 1, paramLong) > 0;
  }
  
  public static boolean isQzoneProcessExist()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if ("com.tencent.mobileqq:qzone".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneHelper", 2, "QzoneProcess is exist");
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean isRunningInQzoneProcess()
  {
    boolean bool2 = false;
    try
    {
      String str = BaseApplicationImpl.getApplication().getQQProcessName();
      boolean bool1 = bool2;
      if (str != null)
      {
        boolean bool3 = str.endsWith(":qzone");
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static boolean isScanFrontCameraBlacklist()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "PhotoCategoryScannerFrontCamBlackList", "N1T");
    if (str == null) {
      return false;
    }
    if (!str.equals(g_scanFrontCameraBlacklist))
    {
      g_isInFrontCameraBlacklist = isBuildModelInList(str);
      g_scanFrontCameraBlacklist = str;
    }
    return g_isInFrontCameraBlacklist;
  }
  
  public static boolean isShortcutCreated(String paramString, @NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return QQUtils.a(paramContext, new String[] { paramString });
    }
    return isShortcutCreated_O(paramString, (ShortcutManager)paramContext.getSystemService(ShortcutManager.class));
  }
  
  @RequiresApi(api=25)
  public static boolean isShortcutCreated_O(String paramString, ShortcutManager paramShortcutManager)
  {
    if (paramShortcutManager == null) {
      return false;
    }
    paramShortcutManager = paramShortcutManager.getPinnedShortcuts().iterator();
    do
    {
      if (!paramShortcutManager.hasNext()) {
        break;
      }
    } while (!paramString.equals(((ShortcutInfo)paramShortcutManager.next()).getId()));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean isSupportWebViewCover()
  {
    if (isBestPerformanceDevice())
    {
      if (QzoneConfig.getInstance().getConfig("QzoneCover", "HtmlForceClose", 0) == 1) {}
      for (int i = 1; i == 0; i = 0) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  public static void launchQZone(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static void launchQZoneEncourageAdvActivity(Activity paramActivity, String paramString)
  {
    if (paramActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("gdt_adv_activity_factory_info", paramString);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.preview.QZoneEncourageAdvActivity");
    if (isRunningInQzoneProcess())
    {
      localIntent.setClassName(paramActivity, "com.qzone.preview.QZoneEncourageAdvActivity");
      paramActivity.startActivity(localIntent);
      return;
    }
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, BaseApplicationImpl.getApplication().getRuntime().getAccount(), localIntent, -1);
  }
  
  public static void launchVideoCoverPreviewActivity(Activity paramActivity, int paramInt1, String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt4, Bundle paramBundle, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (paramActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
    localIntent.putExtra("PhotoConst.VIDEO_TYPE", paramInt1);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localIntent.putExtra("PhotoConst.QZONE_ALBUM_VIDEO_ID", str);
    localIntent.putExtra("file_send_path", paramString2);
    localIntent.putExtra("thumbnail_path", paramString3);
    localIntent.putExtra("thumbnail_height", paramInt3);
    localIntent.putExtra("thumbnail_width", paramInt2);
    localIntent.putExtra("need_process", paramBoolean);
    localIntent.putExtra("start_time", paramLong2);
    localIntent.putExtra("end_time", paramLong3);
    localIntent.putExtra("total_duration", paramLong1);
    localIntent.putExtra("file_send_duration", paramLong3 - paramLong2);
    localIntent.putExtra("sv_total_frame_count", paramInt4);
    localIntent.putExtra("PhotoConst.VIDEO_SIZE", paramLong4);
    localIntent.putExtra("COVER_STRING_TYPE", paramString7);
    if (paramBundle != null) {
      localIntent.putExtra("encode_video_params", paramBundle);
    }
    localIntent.putExtra("defaultText", paramString4);
    if (!TextUtils.isEmpty(paramString5)) {
      localIntent.putExtra("refer", paramString5);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      localIntent.putExtra("video_refer", paramString6);
    }
    paramString1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.cover.ui.activity.QzoneVideoCoverPreviewActivity");
    if (isRunningInQzoneProcess())
    {
      localIntent.setClassName(paramActivity, "com.qzone.cover.ui.activity.QzoneVideoCoverPreviewActivity");
      paramActivity.startActivity(localIntent);
      return;
    }
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString1, localIntent, -1);
  }
  
  private static void onCreateShortcutFailed(@NonNull QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent("com.qzone.album.CreateAlbumShortcutSucceedReceiver");
    localIntent.putExtra("AlbumCreateShortcutFailed", true);
    paramQQAppInterface.getApp().sendBroadcast(localIntent);
  }
  
  public static void onMQzoneSchema(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("cmd", "Schema");
    localIntent.putExtra("schema", paramString);
    forwardToQzoneTransluentActivity((Activity)paramContext, QZoneHelper.UserInfo.getInstance(), localIntent);
  }
  
  public static void onQQClearLocalCache(long paramLong)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QZoneHelper.11(paramLong));
  }
  
  public static void openActivityAsync(boolean paramBoolean, QZoneHelper.StartActivity paramStartActivity)
  {
    if (!paramBoolean)
    {
      paramStartActivity.onStart(false, true);
      return;
    }
    ThreadManager.postImmediately(new QZoneHelper.8(paramStartActivity), null, true);
  }
  
  public static void openWebSecurityVerify(Intent paramIntent)
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "openWebSecurityVerify", 1) == 1) {}
  }
  
  private static boolean parseAndSetQzoneCoverInfoToIntent(Intent paramIntent, byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    long l;
    String str1;
    String str2;
    if (paramArrayOfByte != null)
    {
      bool1 = bool2;
      if (paramArrayOfByte.length > 0)
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        localObject = new RES_ITEM_COVER();
        ((RES_ITEM_COVER)localObject).readFrom(paramArrayOfByte);
        localObject = ((RES_ITEM_COVER)localObject).strJumpQzone;
        paramArrayOfByte = "";
        l = 0L;
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).startsWith("mqzone://arouse/homepage"))) {
          break label207;
        }
        paramArrayOfByte = Uri.parse((String)localObject);
        str1 = paramArrayOfByte.getQueryParameter("actiontype");
        localObject = paramArrayOfByte.getQueryParameter("actionurl");
        str2 = paramArrayOfByte.getQueryParameter("uin");
        paramArrayOfByte = (byte[])localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
    }
    label207:
    for (;;)
    {
      try
      {
        paramArrayOfByte = URLDecoder.decode((String)localObject, "UTF-8");
        int i = 0;
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        try
        {
          i = Integer.parseInt(str1);
          l = Long.parseLong(str2);
          bool1 = bool2;
          if (i == 35)
          {
            paramIntent.putExtra("qqid", l);
            paramIntent.putExtra("famous_space_webview_url", paramArrayOfByte);
            paramIntent.putExtra("click_time", System.currentTimeMillis());
            bool1 = true;
          }
          return bool1;
        }
        catch (NumberFormatException paramIntent)
        {
          QZLog.e("QZoneHelper", "parseAndSetQzoneCoverInfoToIntent", paramIntent);
          return false;
        }
        paramIntent = paramIntent;
        QZLog.e("QZoneHelper", "parseAndSetQzoneCoverInfoToIntent", paramIntent);
        return false;
      }
    }
  }
  
  public static Bundle parseUrlParams(String paramString)
  {
    int i = 0;
    Bundle localBundle = new Bundle();
    if (paramString == null) {
      return localBundle;
    }
    int j = paramString.indexOf('?');
    if ((j < 0) || (j + 1 >= paramString.length())) {
      return localBundle;
    }
    paramString = paramString.substring(j + 1);
    if (TextUtils.isEmpty(paramString)) {
      return localBundle;
    }
    paramString = paramString.split("&");
    for (;;)
    {
      if ((paramString != null) && (i < paramString.length))
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {}
        try
        {
          localBundle.putString(arrayOfString[0], URLDecoder.decode(arrayOfString[1], "UTF-8"));
          i += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
      }
    }
    return localBundle;
  }
  
  public static void preloadInFriendProfileCard(QQAppInterface paramQQAppInterface, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    ThreadManager.post(new QZoneHelper.10(paramQQAppInterface, paramPreloadProcHitPluginSession), 8, null, false);
  }
  
  public static void preloadQZoneForHaboReport(AppRuntime paramAppRuntime, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong)
  {
    AccManager.createStatistic(paramString1, paramInt1, paramString2, paramInt2);
  }
  
  public static void preloadQunAlbum(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    while (isQzoneProcessExist()) {
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.getApp(), QzonePluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.setAction("com.qzone.intent.action.PRELOAD_QUN_ALBUM_FEEDS");
    localIntent.putExtra("qunid", paramString);
    localIntent.putExtra("qzone_uin", paramQQAppInterface.getCurrentAccountUin());
    paramString = new IPluginManager.PluginParams(0);
    paramString.b = QzonePluginProxyActivity.getQZonePluginName();
    paramString.e = "QQ空间";
    paramString.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    paramString.f = "com.qzone.preview.service.PictureService";
    paramString.jdField_a_of_type_AndroidContentIntent = localIntent;
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, "Start QZone QunAlbum Preload");
    }
    IPluginManager.c(paramQQAppInterface.getApp(), paramString);
  }
  
  public static void preloadQzone(QQAppInterface paramQQAppInterface, String paramString)
  {
    preloadQzone(paramQQAppInterface, paramString, null, false);
  }
  
  public static void preloadQzone(QQAppInterface paramQQAppInterface, String paramString, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (checkQzoneEntranceProtectEnable())) {
      return;
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).checkPreloadMiniApp();
    if ("MainAssistObserver".equals(paramString))
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 1, 0, "", "", "", "");
      StatisticHitRateCollector.a().a("actQZLoadHitRateRed", true);
    }
    for (;;)
    {
      ThreadManager.postImmediately(new QZoneHelper.9(paramQQAppInterface), null, false);
      try
      {
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("CrashControl_com.tencent.mobileqq:qzone", 4);
        if ((localObject != null) && (!((SharedPreferences)localObject).getBoolean("allowpreload", true)))
        {
          long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
          int i = ((SharedPreferences)localObject).getInt("controlwindow", 86400);
          long l2 = System.currentTimeMillis();
          if ((l1 > 0L) && (i > 0) && (l2 > l1) && (l2 - l1 > i * 1000)) {
            ((SharedPreferences)localObject).edit().putBoolean("allowpreload", true).commit();
          }
        }
        else
        {
          label213:
          QLog.d("qzone_launch", 1, "preloadQzone from: " + paramString);
          localObject = new Intent(paramQQAppInterface.getApp(), QzonePluginProxyService.class);
        }
      }
      catch (Exception localException)
      {
        try
        {
          Object localObject;
          ((Intent)localObject).putExtra("useSkinEngine", 1);
          if ("FriendProfileCardActivity".equals(paramString)) {
            ((Intent)localObject).setAction("com.qzone.intent.action.PRELOAD_USER_HOME");
          }
          for (;;)
          {
            ((Intent)localObject).putExtra("cpuNum", DeviceInfoUtil.b());
            ((Intent)localObject).putExtra("key_can_set_layoutInfalter_factory", enableLayoutInflaterFactory());
            ((Intent)localObject).putExtra("key_is_keep_alive", paramBoolean);
            if (!DeviceOptSwitch.c) {
              break label508;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Perf", 2, "disable preload qzone process");
            }
            DeviceOptSwitch.b = System.currentTimeMillis();
            return;
            if ("Leba".equals(paramString))
            {
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 1, 0, "", "", "", "");
              StatisticHitRateCollector.a().a("actQZLoadHitRateLeba", true);
              break;
            }
            if (!"FriendProfileCardActivity".equals(paramString)) {
              break;
            }
            StatisticHitRateCollector.a().a("actQZLoadHitRateProfile", true);
            break;
            QLog.d("QZoneHelper", 1, "preloadQzone is not allowed as crash frequently.");
            StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "actNoPreloadQzone", true, 0L, 0L, null, "");
            return;
            localException = localException;
            localException.printStackTrace();
            break label213;
            if (!"QCircle".equals(paramString)) {
              break label497;
            }
            localException.setAction("com.qzone.intent.action.PRELOAD_QCIRCLE_PUBLISH");
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            continue;
            label497:
            localException.setAction("com.qzone.intent.action.PRELOAD_FRIEND_FEEDS");
          }
          label508:
          paramString = new IPluginManager.PluginParams(0);
          paramString.b = QzonePluginProxyActivity.getQZonePluginName();
          paramString.e = "QQ空间";
          paramString.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
          paramString.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = paramPreloadProcHitPluginSession;
          paramString.f = "com.qzone.preview.service.PictureService";
          paramString.jdField_a_of_type_AndroidContentIntent = localException;
          paramString.jdField_a_of_type_Boolean = true;
          IPluginManager.c(paramQQAppInterface.getApp(), paramString);
        }
      }
    }
  }
  
  public static void preloadQzone(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    preloadQzone(paramQQAppInterface, paramString, null, paramBoolean);
  }
  
  public static void preloadQzone(BaseApplication paramBaseApplication, String paramString1, String paramString2)
  {
    if ((paramBaseApplication == null) || (checkQzoneEntranceProtectEnable())) {
      return;
    }
    QLog.d("qzone_launch", 1, "preloadQzone from: " + paramString2);
    Intent localIntent = new Intent(paramBaseApplication, QzonePluginProxyService.class);
    try
    {
      localIntent.putExtra("useSkinEngine", 1);
      if ("album_select".equals(paramString2)) {
        localIntent.setAction("com.qzone.intent.action.PRELOAD_NOTHING");
      }
      for (;;)
      {
        localIntent.putExtra("cpuNum", DeviceInfoUtil.b());
        localIntent.putExtra("key_can_set_layoutInfalter_factory", enableLayoutInflaterFactory());
        if (!DeviceOptSwitch.c) {
          break label164;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Perf", 2, "disable preload qzone process");
        }
        DeviceOptSwitch.b = System.currentTimeMillis();
        return;
        if (!"FriendProfileCardActivity".equals(paramString2)) {
          break;
        }
        localIntent.setAction("com.qzone.intent.action.PRELOAD_USER_HOME");
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
        continue;
        localIntent.setAction("com.qzone.intent.action.PRELOAD_FRIEND_FEEDS");
      }
      label164:
      paramString2 = new IPluginManager.PluginParams(0);
      paramString2.b = QzonePluginProxyActivity.getQZonePluginName();
      paramString2.e = "QQ空间";
      paramString2.jdField_a_of_type_JavaLangString = paramString1;
      paramString2.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = null;
      paramString2.f = "com.qzone.preview.service.PictureService";
      paramString2.jdField_a_of_type_AndroidContentIntent = localIntent;
      IPluginManager.c(paramBaseApplication, paramString2);
    }
  }
  
  public static void prepareForQQPublicAccountPublishPage()
  {
    ThreadManager.post(new QZoneHelper.12(), 5, null, false);
  }
  
  private static void publishMood(QQAppInterface paramQQAppInterface, Activity paramActivity, PublishMoodInfo paramPublishMoodInfo, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramPublishMoodInfo == null))
    {
      QLog.i("QZoneHelper", 2, "handle moodInfo is null");
      return;
    }
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
    QZoneShareManager.publishToQzone(paramQQAppInterface, paramActivity, localBundle, null, paramInt);
  }
  
  private static void publishMood(QQAppInterface paramQQAppInterface, Activity paramActivity, PublishMoodInfo paramPublishMoodInfo, String paramString, int paramInt, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramPublishMoodInfo == null))
    {
      QLog.i("QZoneHelper", 2, "handle moodInfo is null");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("summary", paramPublishMoodInfo.mText);
    localBundle.putBoolean("key_need_save_draft", false);
    localBundle.putString("shareSource", paramString);
    localBundle.putStringArrayList("images", paramPublishMoodInfo.mAllImageAndVideo);
    localBundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", paramPublishMoodInfo.mMediaInfoHashMap);
    if (paramBoolean) {
      localBundle.putInt("key_max_photo_count", 1);
    }
    QZoneShareManager.publishToQzone(paramQQAppInterface, paramActivity, localBundle, null, paramInt);
  }
  
  public static void publishPictureMoodSilently(String paramString1, ArrayList<String> paramArrayList1, int paramInt1, LbsDataV2.PoiInfo paramPoiInfo, String paramString2, String paramString3, ArrayList<String> paramArrayList2, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, String paramString4, int paramInt2)
  {
    paramString2 = new Bundle();
    paramString2.putString("param.content", paramString1);
    paramString2.putStringArrayList("param.images", paramArrayList1);
    paramString2.putSerializable("param.extendInfo", paramHashMap2);
    if (!TextUtils.isEmpty(paramString3)) {}
    try
    {
      paramString2.putInt("param.priv", Integer.parseInt(paramString3));
      paramString2.putStringArrayList("param.privList", paramArrayList2);
      paramString2.putParcelable("param.poiInfo", paramPoiInfo);
      paramString2.putInt("param.syncWeibo", paramInt1);
      paramString2.putSerializable("param.storeExtendInfo", paramHashMap1);
      paramString2.putString("param.source", paramString4);
      paramString2.putInt("param.subtype", paramInt2);
      RemoteHandleManager.getInstance().sendData("cmd.publishMixMood", paramString2, false);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QZLog.e("QZoneHelper", "publishPictureMoodSilently... exception:", paramString1);
        paramString2.putInt("param.priv", 1);
      }
    }
  }
  
  public static void publishPictureMoodSilently(String paramString1, ArrayList<String> paramArrayList1, int paramInt1, ArrayList<String> paramArrayList2, int paramInt2, int paramInt3, String paramString2, boolean paramBoolean, int paramInt4, String paramString3)
  {
    publishPictureMoodSilently(paramString1, paramArrayList1, paramInt1, paramArrayList2, paramInt2, paramInt3, paramString2, paramBoolean, false, paramInt4, paramString3);
  }
  
  public static void publishPictureMoodSilently(String paramString1, ArrayList<String> paramArrayList1, int paramInt1, ArrayList<String> paramArrayList2, int paramInt2, int paramInt3, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.content", paramString1);
    localBundle.putStringArrayList("param.images", paramArrayList1);
    localBundle.putInt("param.priv", paramInt1);
    localBundle.putStringArrayList("param.privList", paramArrayList2);
    localBundle.putInt("extra_key_font_id", paramInt2);
    localBundle.putInt("extra_key_font_format_type", paramInt3);
    localBundle.putString("extra_key_font_url", paramString2);
    localBundle.putInt("extra_key_super_font_id", paramInt4);
    localBundle.putString("extra_key_super_font_info", paramString3);
    localBundle.putBoolean("set_timer_delete", paramBoolean1);
    localBundle.putBoolean("param.isSyncToQQStory", paramBoolean2);
    RemoteHandleManager.getInstance().sendData("cmd.publishMoodForAll", localBundle, false);
  }
  
  public static void publishPictureMoodSilently(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    String str;
    if ("source_from_quick_shoot".equals(paramString2)) {
      str = "value.sourceFromQqQuickShoot";
    }
    for (;;)
    {
      publishPictureMoodSilently(paramString1, paramArrayList, str, 2);
      return;
      str = paramString2;
      if ("forward_source_to_qzone".equals(paramString2)) {
        str = "value.personalSign";
      }
    }
  }
  
  public static void publishPictureMoodSilently(String paramString1, ArrayList<String> paramArrayList, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.content", paramString1);
    localBundle.putStringArrayList("param.images", paramArrayList);
    localBundle.putString("param.source", paramString2);
    localBundle.putInt("param.subtype", paramInt);
    RemoteHandleManager.getInstance().sendData("cmd.publishMood", localBundle, false);
  }
  
  public static void putTimeRecord(Intent paramIntent)
  {
    paramIntent.putExtra("key_time_record", System.currentTimeMillis());
  }
  
  public static void reportIfIsFromQZone(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.contains("mobile.qzone.qq.com")) {
      return;
    }
    QZoneLoginReportHelper.reportLoginFromMQQSearchH5();
  }
  
  public static void resumeQZoneFloatObjectView(Context paramContext, Object paramObject)
  {
    if ((paramContext == null) || (paramObject == null)) {
      return;
    }
    try
    {
      Class localClass = Class.forName("com.qzone.personalize.floatobject.ui.FloatItemView");
      paramContext = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        ClassLoader localClassLoader = QzonePluginProxyActivity.getQZonePluginClassLoader(paramContext);
        paramContext = localClassLoader.loadClass("com.qzone.personalize.floatobject.ui.FloatItemView");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    if (paramContext == null) {
      try
      {
        QLog.e("QZLog", 1, "*createQZoneFloatObjectView load class fail");
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    paramContext.getMethod("start", new Class[0]).invoke(paramObject, new Object[0]);
  }
  
  public static void saveQzoneAlbumInfo(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString3)) || (paramString2 == null)) {
      return;
    }
    String str1 = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_id");
    String str2 = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_title");
    String str3 = MD5.toMD5(paramString1 + "_" + paramString2 + "_record_time");
    paramString1 = MD5.toMD5(paramString1 + "_" + paramString2 + "_exist");
    LocalMultiProcConfig.putString(str1, paramString3);
    LocalMultiProcConfig.putString(str2, paramString4);
    LocalMultiProcConfig.putLong(str3, System.currentTimeMillis());
    LocalMultiProcConfig.putBool(paramString1, paramBoolean);
    QZLog.i("QZoneHelper", 1, "saveQzoneAlbumInfo: albumId=" + paramString3 + " albumTitle=" + paramString4 + " isAlbumExist=" + paramBoolean);
  }
  
  public static void saveQzonePermission(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      LocalMultiProcConfig.putInt4Uin("isQzonePublic", i, paramLong);
      return;
    }
  }
  
  public static void saveSelectedAlbumInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_id");
    paramString1 = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_title");
    LocalMultiProcConfig.putString(str, paramString3);
    LocalMultiProcConfig.putString(paramString1, paramString4);
  }
  
  public static void sendBroadcastQunMsgUnreadCount(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.qq.syncQunMsg");
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.tencent.qq.unreadcount", paramInt);
    localIntent.putExtras(localBundle);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void setUserInfoToIntent(Intent paramIntent, QZoneHelper.UserInfo paramUserInfo)
  {
    paramIntent.putExtra("qzone_uin", paramUserInfo.qzone_uin);
    paramIntent.putExtra("nickname", paramUserInfo.nickname);
  }
  
  public static void showQzoneVipOriginalVideoDialog(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    DialogUtil.a(paramActivity, 230).setMessage(2131717987).setPositiveButton(2131717515, new QZoneHelper.1()).setNegativeButton(2131719344, paramOnClickListener).show();
  }
  
  public static void showQzoneVipOriginalVideoDialogForUpload(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    DialogUtil.a(paramActivity, 230).setMessage(2131717988).setPositiveButton(2131719344, paramOnClickListener).setNegativeButton(2131717515, new QZoneHelper.2()).show();
  }
  
  public static void startTranslucentBrowserActivityForResult(Context paramContext, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    startTranslucentBrowserActivityForResult(paramContext, paramString1, paramInt, paramBundle, paramString2, true, true);
  }
  
  public static void startTranslucentBrowserActivityForResult(Context paramContext, String paramString1, int paramInt, Bundle paramBundle, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      ToastUtil.a().a(2131691162);
      QLog.w("QZoneHelper", 1, "browse url fail:" + paramString1);
    }
    Intent localIntent;
    do
    {
      return;
      if (TextUtils.isEmpty(paramString2)) {}
      for (paramString2 = null;; paramString2 = paramString2.getBytes())
      {
        localIntent = new Intent(BaseApplicationImpl.getContext(), QQTranslucentBrowserActivity.class);
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
        if (!(paramContext instanceof Activity)) {
          break;
        }
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
        return;
      }
    } while (localIntent == null);
    localIntent.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public static void stopQZoneFloatObjectView(Context paramContext, Object paramObject)
  {
    if ((paramContext == null) || (paramObject == null)) {
      return;
    }
    try
    {
      Class localClass = Class.forName("com.qzone.personalize.floatobject.ui.FloatItemView");
      paramContext = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        ClassLoader localClassLoader = QzonePluginProxyActivity.getQZonePluginClassLoader(paramContext);
        paramContext = localClassLoader.loadClass("com.qzone.personalize.floatobject.ui.FloatItemView");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    if (paramContext == null) {
      try
      {
        QLog.e("QZLog", 1, "*createQZoneFloatObjectView load class fail");
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    paramContext.getMethod("stop", new Class[0]).invoke(paramObject, new Object[0]);
  }
  
  public static void stopQzonePublishQueueService(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext.stopService(new Intent(paramContext, QzonePluginPublishQueueProxyService.class));
  }
  
  public static void updateAlbumShortCut(@NonNull QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Bitmap paramBitmap, long paramLong)
  {
    ThreadManager.post(new QZoneHelper.5(paramQQAppInterface, paramString1, paramLong, paramString2, paramBitmap), 2, null, true);
  }
  
  private static void updateShortcut(Intent paramIntent, @NonNull QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (!QQUtils.a(paramQQAppInterface.getApp(), new String[] { paramString1 })) {
      return;
    }
    deleteShortcut(paramIntent, paramQQAppInterface, paramString2, paramBitmap);
    Thread.sleep(1000L);
    QQUtils.a(paramQQAppInterface, paramIntent, paramString2, paramBitmap);
    Thread.sleep(1000L);
  }
  
  @RequiresApi(api=26)
  private static void updateShortcut_O(Bitmap paramBitmap, @NonNull QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2)
  {
    paramQQAppInterface = paramQQAppInterface.getApp();
    ShortcutManager localShortcutManager = (ShortcutManager)paramQQAppInterface.getSystemService(ShortcutManager.class);
    if (!isShortcutCreated_O(paramString1, localShortcutManager)) {
      return;
    }
    localShortcutManager.updateShortcuts(Arrays.asList(new ShortcutInfo[] { getAlbumShortcutInfo(paramQQAppInterface, paramBitmap, paramString1, paramLong, paramString2, "update") }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper
 * JD-Core Version:    0.7.0.1
 */