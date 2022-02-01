package cooperation.qzone;

import NS_MOBILE_QQ.RES_ITEM_COVER;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.PendingIntent;
import android.content.ContentResolver;
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
import android.provider.MediaStore.Images.Media;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.SurfaceView;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShortcutUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.open.base.MD5;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch;
import com.tencent.qzonehub.api.IQZoneHelperProxy;
import com.tencent.qzonehub.api.IQzonePluginProxyActivity;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.util.URLUtil;
import com.tencent.util.pm.PackageUtil;
import common.config.service.QzoneAlphaConfig;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.model.PublishEventTag;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import cooperation.qzone.statistic.AccManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
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
import mqq.app.MobileQQ;
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
  public static final String CACHEMAMAGER_IMAGE_FILE_CACHE_NAME;
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
  public static final String REDPOCKET = "com.tencent.mobileqq.qwallet.hb.send.impl.SendHbActivity";
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
  public static int sQZoneHCCode;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("image");
    CACHEMAMAGER_IMAGE_FILE_CACHE_NAME = localStringBuilder.toString();
    sQZoneHCCode = 0;
    STR_TIPS_FLOAT_ITEM_NOT_ALLOW_TO_SHOW = HardCodeUtil.a(2131909490);
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
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).addQZoneStatis(paramIntent, paramInt);
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
  
  public static final void addSource(ActivityURIRequest paramActivityURIRequest)
  {
    if (paramActivityURIRequest != null) {
      paramActivityURIRequest.extra().putString("big_brother_source_key", "biz_src_jc_qzone");
    }
  }
  
  public static void bindQzonePublishQueueService(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).bindQzonePublishQueueService(paramAppRuntime, paramServiceConnection);
  }
  
  public static void bindQzoneVideoService(Context paramContext, String paramString, ServiceConnection paramServiceConnection)
  {
    ((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).bindService(paramContext, paramString, paramServiceConnection);
  }
  
  public static boolean canGifPlaySwitch()
  {
    return QzoneConfig.getInstance().getConfig("GifSetting", "GifPlaySwitch", 1) != 0;
  }
  
  public static void cancelQzoneAlive(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      if (checkQzoneEntranceProtectEnable()) {
        return;
      }
      Intent localIntent = new Intent(paramAppRuntime.getApp(), QzonePluginProxyService.class);
      localIntent.setAction("com.qzone.intent.action.CANCEL_QZONE_ALIVE");
      localIntent.putExtra("key_is_keep_alive", false);
      ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).launchPluginService(paramAppRuntime.getApp(), null, paramAppRuntime.getCurrentAccountUin(), localIntent);
    }
  }
  
  private static boolean checkIsFirstInit()
  {
    try
    {
      SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("sp_short_video", 4);
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
    return PackageUtil.d(paramContext, paramString);
  }
  
  public static boolean checkQzoneEntranceProtectEnable()
  {
    comboqzProtectEnable = LocalMultiProcConfig.getBool("comboqz_protect_enable", false);
    Object localObject;
    if (comboqzProtectEnable)
    {
      localObject = LocalMultiProcConfig.getString("comboqz_qua", "");
      if (!QUA.getQUA3().equals(localObject))
      {
        LocalMultiProcConfig.putBool("comboqz_protect_enable", false);
        return false;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QzoneEntranceProtectEnable:");
      ((StringBuilder)localObject).append(comboqzProtectEnable);
      QLog.d("QZoneHelper", 2, ((StringBuilder)localObject).toString());
    }
    return comboqzProtectEnable;
  }
  
  public static void clearCache(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (paramAppRuntime == null) {
      return;
    }
    Object localObject1 = paramAppRuntime.getApplication();
    Object localObject2 = paramAppRuntime.getAccount();
    Object localObject3 = new Intent(MobileQQ.getContext(), QzonePictureViewerProxyService.class);
    MobileQQ.getContext().stopService((Intent)localObject3);
    Utils.a(MobileQQ.getContext(), "com.tencent.mobileqq:picture");
    localObject3 = new Intent(MobileQQ.getContext(), QzonePluginProxyService.class);
    MobileQQ.getContext().stopService((Intent)localObject3);
    Utils.a(MobileQQ.getContext(), "com.tencent.mobileqq:qzone");
    Utils.a(MobileQQ.getContext(), "com.tencent.mobileqq:qzonevideo");
    CacheManager.clearFileCache((Context)localObject1);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      ((Context)localObject1).deleteDatabase(SecurityUtil.a((String)localObject2));
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Widget_");
      ((StringBuilder)localObject3).append((String)localObject2);
      LocalMultiProcConfig.putInt(((StringBuilder)localObject3).toString(), "WidgetID", -1);
    }
    ((Context)localObject1).deleteDatabase(SecurityUtil.a("0"));
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).cleanAllQZconfig();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((Context)localObject1).getFilesDir().getParent());
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("shared_prefs");
    localObject1 = ((StringBuilder)localObject2).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("qz_predownload_config.xml");
      deleteFile(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("QZ_Per_Config.xml");
      deleteFile(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("QZONE_UNREAD.xml");
      deleteFile(((StringBuilder)localObject2).toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("tencent");
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("MobileQQ");
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("trace");
    localObject1 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
    if (localObject1 != null) {
      deleteFile((String)localObject1);
    }
    if ((paramBoolean) && ((paramAppRuntime instanceof AppRuntime))) {
      ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).deleteAllH5Data(paramAppRuntime);
    }
  }
  
  public static void clearFeedsCache(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(MobileQQ.getContext(), QzonePictureViewerProxyService.class);
    MobileQQ.getContext().stopService(localIntent);
    Utils.a(MobileQQ.getContext(), "com.tencent.mobileqq:picture");
    localIntent = new Intent(MobileQQ.getContext(), QzonePluginProxyService.class);
    MobileQQ.getContext().stopService(localIntent);
    Utils.a(MobileQQ.getContext(), "com.tencent.mobileqq:qzone");
    Utils.a(MobileQQ.getContext(), "com.tencent.mobileqq:qzonevideo");
    if (!TextUtils.isEmpty(paramString)) {
      paramContext.deleteDatabase(SecurityUtil.a(paramString));
    }
  }
  
  public static void createAlbumShortCut(AppRuntime paramAppRuntime, String paramString1, String paramString2, Bitmap paramBitmap, long paramLong)
  {
    ThreadManager.post(new QZoneHelper.4(paramBitmap, paramAppRuntime, paramString1, paramLong, paramString2), 2, null, true);
  }
  
  private static void createAlbumShortcutWithBmp(Bitmap paramBitmap, @NonNull AppRuntime paramAppRuntime, String paramString1, long paramLong, String paramString2)
  {
    if (paramBitmap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneHelper", 2, "createAlbumShortcutWithBmp end, iconBmp is null");
      }
      return;
    }
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i < 26)
    {
      if (ShortcutUtils.a(paramAppRuntime.getApp(), new String[] { paramString1 }))
      {
        ToastUtil.a().a(2131886636);
        return;
      }
      localObject = getShortcutIntent(paramAppRuntime, paramString1, paramLong);
      ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).createShortcut(paramAppRuntime, (Intent)localObject, paramString2, paramBitmap);
      Thread.sleep(1000L);
      if (ShortcutUtils.a(paramAppRuntime.getApplication(), new String[] { paramString1 }))
      {
        ToastUtil.a().a(2131888253);
        return;
      }
      onCreateShortcutFailed(paramAppRuntime);
      return;
    }
    Object localObject = paramAppRuntime.getApp();
    ShortcutManager localShortcutManager = (ShortcutManager)((Context)localObject).getSystemService("shortcut");
    if (isShortcutCreated_O(paramString1, localShortcutManager))
    {
      ToastUtil.a().a(2131886636);
      return;
    }
    if (localShortcutManager.isRequestPinShortcutSupported())
    {
      paramBitmap = getAlbumShortcutInfo((Context)localObject, paramBitmap, paramString1, paramLong, paramString2, "android.intent.action.VIEW");
      paramString2 = new Intent("com.qzone.album.CreateAlbumShortcutSucceedReceiver");
      paramString2.putExtra("UploadPhoto.key_album_id", paramString1);
      bool = localShortcutManager.requestPinShortcut(paramBitmap, PendingIntent.getBroadcast((Context)localObject, 0, paramString2, 134217728).getIntentSender());
    }
    if (!bool) {
      onCreateShortcutFailed(paramAppRuntime);
    }
  }
  
  public static AppRuntime createPhotoPlusAppInterface(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        try
        {
          localObject = Class.forName("com.tencent.zebra.app.PhotoplusAppInterface");
          paramContext = (Context)localObject;
        }
        catch (Exception paramContext) {}catch (NoSuchMethodException paramContext) {}catch (InvocationTargetException paramContext) {}catch (InstantiationException paramContext) {}catch (IllegalAccessException paramContext) {}catch (IllegalArgumentException paramContext) {}
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Object localObject;
        continue;
      }
      try
      {
        localObject = ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).getPhotoPlusClassLoader(paramContext);
        paramContext = ((ClassLoader)localObject).loadClass("com.tencent.zebra.app.PhotoplusAppInterface");
        BasicClassTypeUtil.setClassLoader(true, (ClassLoader)localObject);
        if (paramContext == null)
        {
          QLog.e("QZLog", 1, "createPhotoPlusAppInterface load class fail");
          return null;
        }
        paramContext = paramContext.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if ((paramContext == null) || (!(paramContext instanceof AppRuntime))) {
          continue;
        }
        paramContext = (AppRuntime)paramContext;
        return paramContext;
      }
      catch (ClassNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    paramContext.printStackTrace();
    return null;
    paramContext.printStackTrace();
    return null;
    paramContext.printStackTrace();
    return null;
    paramContext.printStackTrace();
    return null;
    paramContext.printStackTrace();
    return null;
    paramContext.printStackTrace();
    return null;
    return null;
  }
  
  /* Error */
  public static AppRuntime createQZoneAppInterface(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 995
    //   3: invokestatic 1000	cooperation/qzone/util/PerfTracer:traceStart	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: ifnull +262 -> 269
    //   10: aload_1
    //   11: ifnonnull +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: ldc_w 970
    //   19: iconst_1
    //   20: ldc_w 1002
    //   23: invokestatic 975	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: ldc 60
    //   28: invokestatic 951	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: goto +31 -> 65
    //   37: ldc_w 953
    //   40: invokestatic 558	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   43: checkcast 953	com/tencent/qzonehub/api/IQzonePluginProxyActivity
    //   46: aload_0
    //   47: invokeinterface 1005 2 0
    //   52: astore_1
    //   53: aload_1
    //   54: ldc 60
    //   56: invokevirtual 962	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   59: astore_0
    //   60: iconst_1
    //   61: aload_1
    //   62: invokestatic 968	com/qq/jce/wup/BasicClassTypeUtil:setClassLoader	(ZLjava/lang/ClassLoader;)V
    //   65: aload_0
    //   66: ifnonnull +21 -> 87
    //   69: ldc_w 970
    //   72: iconst_1
    //   73: ldc_w 1007
    //   76: invokestatic 975	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: ldc_w 995
    //   82: invokestatic 1010	cooperation/qzone/util/PerfTracer:traceEnd	(Ljava/lang/String;)V
    //   85: aconst_null
    //   86: areturn
    //   87: aload_0
    //   88: invokevirtual 1013	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   91: astore_0
    //   92: aload_0
    //   93: ifnull +160 -> 253
    //   96: aload_0
    //   97: instanceof 620
    //   100: ifeq +153 -> 253
    //   103: ldc_w 970
    //   106: iconst_1
    //   107: ldc_w 1015
    //   110: invokestatic 975	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_0
    //   114: checkcast 620	mqq/app/AppRuntime
    //   117: astore_0
    //   118: ldc_w 995
    //   121: invokestatic 1010	cooperation/qzone/util/PerfTracer:traceEnd	(Ljava/lang/String;)V
    //   124: aload_0
    //   125: areturn
    //   126: astore_0
    //   127: goto +134 -> 261
    //   130: astore_0
    //   131: goto +27 -> 158
    //   134: astore_0
    //   135: goto +37 -> 172
    //   138: astore_0
    //   139: goto +47 -> 186
    //   142: astore_0
    //   143: goto +57 -> 200
    //   146: astore_0
    //   147: goto +67 -> 214
    //   150: astore_0
    //   151: goto +77 -> 228
    //   154: astore_0
    //   155: goto +87 -> 242
    //   158: ldc_w 428
    //   161: iconst_1
    //   162: ldc_w 1016
    //   165: aload_0
    //   166: invokestatic 1019	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   169: goto +84 -> 253
    //   172: ldc_w 428
    //   175: iconst_1
    //   176: ldc_w 1016
    //   179: aload_0
    //   180: invokestatic 1019	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   183: goto +70 -> 253
    //   186: ldc_w 428
    //   189: iconst_1
    //   190: ldc_w 1016
    //   193: aload_0
    //   194: invokestatic 1019	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: goto +56 -> 253
    //   200: ldc_w 428
    //   203: iconst_1
    //   204: ldc_w 1016
    //   207: aload_0
    //   208: invokestatic 1019	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   211: goto +42 -> 253
    //   214: ldc_w 428
    //   217: iconst_1
    //   218: ldc_w 1016
    //   221: aload_0
    //   222: invokestatic 1019	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   225: goto +28 -> 253
    //   228: ldc_w 428
    //   231: iconst_1
    //   232: ldc_w 1016
    //   235: aload_0
    //   236: invokestatic 1019	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   239: goto +14 -> 253
    //   242: ldc_w 428
    //   245: iconst_1
    //   246: ldc_w 1016
    //   249: aload_0
    //   250: invokestatic 1019	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   253: ldc_w 995
    //   256: invokestatic 1010	cooperation/qzone/util/PerfTracer:traceEnd	(Ljava/lang/String;)V
    //   259: aconst_null
    //   260: areturn
    //   261: ldc_w 995
    //   264: invokestatic 1010	cooperation/qzone/util/PerfTracer:traceEnd	(Ljava/lang/String;)V
    //   267: aload_0
    //   268: athrow
    //   269: aconst_null
    //   270: areturn
    //   271: astore_1
    //   272: goto -235 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	paramContext	Context
    //   0	275	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   16	26	126	finally
    //   26	32	126	finally
    //   37	65	126	finally
    //   69	79	126	finally
    //   87	92	126	finally
    //   96	118	126	finally
    //   158	169	126	finally
    //   172	183	126	finally
    //   186	197	126	finally
    //   200	211	126	finally
    //   214	225	126	finally
    //   228	239	126	finally
    //   242	253	126	finally
    //   16	26	130	java/lang/Exception
    //   26	32	130	java/lang/Exception
    //   37	65	130	java/lang/Exception
    //   69	79	130	java/lang/Exception
    //   87	92	130	java/lang/Exception
    //   96	118	130	java/lang/Exception
    //   16	26	134	java/lang/NoSuchMethodException
    //   26	32	134	java/lang/NoSuchMethodException
    //   37	65	134	java/lang/NoSuchMethodException
    //   69	79	134	java/lang/NoSuchMethodException
    //   87	92	134	java/lang/NoSuchMethodException
    //   96	118	134	java/lang/NoSuchMethodException
    //   16	26	138	java/lang/reflect/InvocationTargetException
    //   26	32	138	java/lang/reflect/InvocationTargetException
    //   37	65	138	java/lang/reflect/InvocationTargetException
    //   69	79	138	java/lang/reflect/InvocationTargetException
    //   87	92	138	java/lang/reflect/InvocationTargetException
    //   96	118	138	java/lang/reflect/InvocationTargetException
    //   16	26	142	java/lang/InstantiationException
    //   26	32	142	java/lang/InstantiationException
    //   37	65	142	java/lang/InstantiationException
    //   69	79	142	java/lang/InstantiationException
    //   87	92	142	java/lang/InstantiationException
    //   96	118	142	java/lang/InstantiationException
    //   16	26	146	java/lang/IllegalAccessException
    //   26	32	146	java/lang/IllegalAccessException
    //   37	65	146	java/lang/IllegalAccessException
    //   69	79	146	java/lang/IllegalAccessException
    //   87	92	146	java/lang/IllegalAccessException
    //   96	118	146	java/lang/IllegalAccessException
    //   16	26	150	java/lang/IllegalArgumentException
    //   26	32	150	java/lang/IllegalArgumentException
    //   37	65	150	java/lang/IllegalArgumentException
    //   69	79	150	java/lang/IllegalArgumentException
    //   87	92	150	java/lang/IllegalArgumentException
    //   96	118	150	java/lang/IllegalArgumentException
    //   16	26	154	java/lang/ClassNotFoundException
    //   37	65	154	java/lang/ClassNotFoundException
    //   69	79	154	java/lang/ClassNotFoundException
    //   87	92	154	java/lang/ClassNotFoundException
    //   96	118	154	java/lang/ClassNotFoundException
    //   26	32	271	java/lang/ClassNotFoundException
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
    }
    catch (Exception paramContext)
    {
      Class localClass;
      ClassLoader localClassLoader;
      paramContext.printStackTrace();
      return null;
    }
    catch (ClassNotFoundException paramContext)
    {
      label28:
      paramContext.printStackTrace();
    }
    try
    {
      localClass = Class.forName("com.qzone.personalize.floatobject.ui.FloatItemView");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label28;
    }
    localClassLoader = ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).getQZonePluginClassLoader(paramContext);
    localClass = localClassLoader.loadClass("com.qzone.personalize.floatobject.ui.FloatItemView");
    BasicClassTypeUtil.setClassLoader(true, localClassLoader);
    if (localClass == null)
    {
      QLog.e("QZLog", 1, "*createQZoneFloatObjectView load class fail");
      return null;
    }
    paramContext = localClass.getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
    localClass.getMethod("initObjects", new Class[] { String.class, Boolean.TYPE }).invoke(paramContext, new Object[] { paramString, Boolean.valueOf(true) });
    if ((paramContext != null) && ((paramContext instanceof SurfaceView)))
    {
      paramContext = (SurfaceView)paramContext;
      return paramContext;
    }
    return null;
  }
  
  public static AppRuntime createQZoneLiveMainRuntime(Context paramContext, String paramString)
  {
    return ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).createQZoneLiveMainRuntime(paramContext, paramString);
  }
  
  public static AppRuntime createQZoneMainRuntime(Context paramContext, String paramString)
  {
    return ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).createQZoneMainRuntime(paramContext, paramString);
  }
  
  /* Error */
  public static AppRuntime createQZonePictureAppInterface(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 995
    //   3: invokestatic 1000	cooperation/qzone/util/PerfTracer:traceStart	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: ifnull +201 -> 208
    //   10: aload_1
    //   11: ifnonnull +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: ldc 69
    //   18: invokestatic 951	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: goto +59 -> 83
    //   27: astore_0
    //   28: goto +172 -> 200
    //   31: astore_0
    //   32: goto +113 -> 145
    //   35: astore_0
    //   36: goto +116 -> 152
    //   39: astore_0
    //   40: goto +119 -> 159
    //   43: astore_0
    //   44: goto +122 -> 166
    //   47: astore_0
    //   48: goto +125 -> 173
    //   51: astore_0
    //   52: goto +128 -> 180
    //   55: ldc_w 953
    //   58: invokestatic 558	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   61: checkcast 953	com/tencent/qzonehub/api/IQzonePluginProxyActivity
    //   64: aload_0
    //   65: invokeinterface 1005 2 0
    //   70: astore_1
    //   71: aload_1
    //   72: ldc 69
    //   74: invokevirtual 962	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   77: astore_0
    //   78: iconst_1
    //   79: aload_1
    //   80: invokestatic 968	com/qq/jce/wup/BasicClassTypeUtil:setClassLoader	(ZLjava/lang/ClassLoader;)V
    //   83: aload_0
    //   84: ifnonnull +21 -> 105
    //   87: ldc_w 970
    //   90: iconst_1
    //   91: ldc_w 1064
    //   94: invokestatic 975	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: ldc_w 995
    //   100: invokestatic 1010	cooperation/qzone/util/PerfTracer:traceEnd	(Ljava/lang/String;)V
    //   103: aconst_null
    //   104: areturn
    //   105: aload_0
    //   106: iconst_0
    //   107: anewarray 947	java/lang/Class
    //   110: invokevirtual 979	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   113: iconst_0
    //   114: anewarray 4	java/lang/Object
    //   117: invokevirtual 985	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   120: astore_0
    //   121: aload_0
    //   122: ifnull +62 -> 184
    //   125: aload_0
    //   126: instanceof 620
    //   129: ifeq +55 -> 184
    //   132: aload_0
    //   133: checkcast 620	mqq/app/AppRuntime
    //   136: astore_0
    //   137: ldc_w 995
    //   140: invokestatic 1010	cooperation/qzone/util/PerfTracer:traceEnd	(Ljava/lang/String;)V
    //   143: aload_0
    //   144: areturn
    //   145: aload_0
    //   146: invokevirtual 678	java/lang/Exception:printStackTrace	()V
    //   149: goto +35 -> 184
    //   152: aload_0
    //   153: invokevirtual 986	java/lang/NoSuchMethodException:printStackTrace	()V
    //   156: goto +28 -> 184
    //   159: aload_0
    //   160: invokevirtual 987	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   163: goto +21 -> 184
    //   166: aload_0
    //   167: invokevirtual 988	java/lang/InstantiationException:printStackTrace	()V
    //   170: goto +14 -> 184
    //   173: aload_0
    //   174: invokevirtual 989	java/lang/IllegalAccessException:printStackTrace	()V
    //   177: goto +7 -> 184
    //   180: aload_0
    //   181: invokevirtual 990	java/lang/IllegalArgumentException:printStackTrace	()V
    //   184: ldc_w 995
    //   187: invokestatic 1010	cooperation/qzone/util/PerfTracer:traceEnd	(Ljava/lang/String;)V
    //   190: aconst_null
    //   191: areturn
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 991	java/lang/ClassNotFoundException:printStackTrace	()V
    //   197: goto -13 -> 184
    //   200: ldc_w 995
    //   203: invokestatic 1010	cooperation/qzone/util/PerfTracer:traceEnd	(Ljava/lang/String;)V
    //   206: aload_0
    //   207: athrow
    //   208: aconst_null
    //   209: areturn
    //   210: astore_1
    //   211: goto -156 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramContext	Context
    //   0	214	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   16	22	27	finally
    //   55	83	27	finally
    //   87	97	27	finally
    //   105	121	27	finally
    //   125	137	27	finally
    //   145	149	27	finally
    //   152	156	27	finally
    //   159	163	27	finally
    //   166	170	27	finally
    //   173	177	27	finally
    //   180	184	27	finally
    //   193	197	27	finally
    //   16	22	31	java/lang/Exception
    //   55	83	31	java/lang/Exception
    //   87	97	31	java/lang/Exception
    //   105	121	31	java/lang/Exception
    //   125	137	31	java/lang/Exception
    //   16	22	35	java/lang/NoSuchMethodException
    //   55	83	35	java/lang/NoSuchMethodException
    //   87	97	35	java/lang/NoSuchMethodException
    //   105	121	35	java/lang/NoSuchMethodException
    //   125	137	35	java/lang/NoSuchMethodException
    //   16	22	39	java/lang/reflect/InvocationTargetException
    //   55	83	39	java/lang/reflect/InvocationTargetException
    //   87	97	39	java/lang/reflect/InvocationTargetException
    //   105	121	39	java/lang/reflect/InvocationTargetException
    //   125	137	39	java/lang/reflect/InvocationTargetException
    //   16	22	43	java/lang/InstantiationException
    //   55	83	43	java/lang/InstantiationException
    //   87	97	43	java/lang/InstantiationException
    //   105	121	43	java/lang/InstantiationException
    //   125	137	43	java/lang/InstantiationException
    //   16	22	47	java/lang/IllegalAccessException
    //   55	83	47	java/lang/IllegalAccessException
    //   87	97	47	java/lang/IllegalAccessException
    //   105	121	47	java/lang/IllegalAccessException
    //   125	137	47	java/lang/IllegalAccessException
    //   16	22	51	java/lang/IllegalArgumentException
    //   55	83	51	java/lang/IllegalArgumentException
    //   87	97	51	java/lang/IllegalArgumentException
    //   105	121	51	java/lang/IllegalArgumentException
    //   125	137	51	java/lang/IllegalArgumentException
    //   55	83	192	java/lang/ClassNotFoundException
    //   87	97	192	java/lang/ClassNotFoundException
    //   105	121	192	java/lang/ClassNotFoundException
    //   125	137	192	java/lang/ClassNotFoundException
    //   16	22	210	java/lang/ClassNotFoundException
  }
  
  public static AppRuntime createQZoneVideoAppInterface(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (paramString == null) {
        return null;
      }
      for (;;)
      {
        try
        {
          try
          {
            paramString = Class.forName("com.qzone.video.service.QZoneVideoAppInterface");
            paramContext = paramString;
          }
          catch (Exception paramContext) {}catch (NoSuchMethodException paramContext) {}catch (InvocationTargetException paramContext) {}catch (InstantiationException paramContext) {}catch (IllegalAccessException paramContext) {}catch (IllegalArgumentException paramContext) {}
        }
        catch (ClassNotFoundException paramString)
        {
          continue;
        }
        try
        {
          paramContext = ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).getQZonePluginClassLoader(paramContext).loadClass("com.qzone.video.service.QZoneVideoAppInterface");
          if (paramContext == null)
          {
            QLog.e("QZLog", 1, "*createQZoneVideoAppInterface load class fail");
            return null;
          }
          paramContext = paramContext.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
          if ((paramContext == null) || (!(paramContext instanceof AppRuntime))) {
            continue;
          }
          paramContext = (AppRuntime)paramContext;
          return paramContext;
        }
        catch (ClassNotFoundException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      paramContext.printStackTrace();
      return null;
      paramContext.printStackTrace();
      return null;
      paramContext.printStackTrace();
      return null;
      paramContext.printStackTrace();
      return null;
      paramContext.printStackTrace();
      return null;
      paramContext.printStackTrace();
      return null;
    }
    return null;
  }
  
  public static AppRuntime createQzoneLiveAppInterface(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        try
        {
          localObject = Class.forName("com.qzone.live.app.QZoneLiveVideoAppInterface");
          paramContext = (Context)localObject;
        }
        catch (Exception paramContext) {}catch (NoSuchMethodException paramContext) {}catch (InvocationTargetException paramContext) {}catch (InstantiationException paramContext) {}catch (IllegalAccessException paramContext) {}catch (IllegalArgumentException paramContext) {}
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Object localObject;
        continue;
      }
      try
      {
        localObject = ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).getQzoneLiveClassLoader(paramContext);
        paramContext = ((ClassLoader)localObject).loadClass("com.qzone.live.app.QZoneLiveVideoAppInterface");
        BasicClassTypeUtil.setClassLoader(true, (ClassLoader)localObject);
        if (paramContext == null)
        {
          QLog.e("QZLog", 1, "createQzoneLiveAppInterface load class fail");
          return null;
        }
        paramContext = paramContext.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if ((paramContext == null) || (!(paramContext instanceof AppRuntime))) {
          continue;
        }
        paramContext = (AppRuntime)paramContext;
        return paramContext;
      }
      catch (ClassNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    paramContext.printStackTrace();
    return null;
    paramContext.printStackTrace();
    return null;
    paramContext.printStackTrace();
    return null;
    paramContext.printStackTrace();
    return null;
    paramContext.printStackTrace();
    return null;
    paramContext.printStackTrace();
    return null;
    return null;
  }
  
  public static AppRuntime createVerticalVideoAppInterface(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      try
      {
        localObject = Class.forName("com.qzone.verticalvideo.app.QZoneVerticalVideoAppInterface");
        paramContext = (Context)localObject;
      }
      catch (Exception paramContext)
      {
        break label99;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject;
      label21:
      break label21;
    }
    localObject = ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).getQzoneVerticalVideoClassLoader(paramContext);
    paramContext = ((ClassLoader)localObject).loadClass("com.qzone.verticalvideo.app.QZoneVerticalVideoAppInterface");
    BasicClassTypeUtil.setClassLoader(true, (ClassLoader)localObject);
    if (paramContext == null)
    {
      QLog.e("QZLog", 1, "createVerticalVideoAppInterface load class fail");
      return null;
    }
    paramContext = paramContext.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    if ((paramContext != null) && ((paramContext instanceof AppRuntime)))
    {
      paramContext = (AppRuntime)paramContext;
      return paramContext;
      label99:
      QLog.e("QZLog", 1, "createVerticalVideoAppInterface failed:", paramContext);
    }
    return null;
  }
  
  public static AppRuntime createWeishiFeedsAppInterface(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      try
      {
        localObject = Class.forName("com.qzone.verticalvideo.app.QZoneWeishiFeedsAppInterface");
        paramContext = (Context)localObject;
      }
      catch (Exception paramContext)
      {
        break label99;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject;
      label21:
      break label21;
    }
    localObject = ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).getQzoneWeishiFeedsClassLoader(paramContext);
    paramContext = ((ClassLoader)localObject).loadClass("com.qzone.verticalvideo.app.QZoneWeishiFeedsAppInterface");
    BasicClassTypeUtil.setClassLoader(true, (ClassLoader)localObject);
    if (paramContext == null)
    {
      QLog.e("QZLog", 1, "createWeishiFeedsAppInterface load class fail");
      return null;
    }
    paramContext = paramContext.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    if ((paramContext != null) && ((paramContext instanceof AppRuntime)))
    {
      paramContext = (AppRuntime)paramContext;
      return paramContext;
      label99:
      QLog.e("QZLog", 1, "createWeishiFeedsAppInterface failed:", paramContext);
    }
    return null;
  }
  
  public static boolean deleteFile(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          deleteFile(arrayOfFile[i]);
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  public static boolean deleteFile(String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramString != null)
    {
      bool1 = bool3;
      if (paramString.length() > 0) {
        try
        {
          bool3 = deleteFile(new File(paramString));
          bool1 = bool3;
          if (bool3)
          {
            bool2 = bool3;
            tryDelMediaStore(paramString);
            return bool3;
          }
        }
        catch (Exception paramString)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramString.getMessage());
            QLog.d("Tools.delete", 2, localStringBuilder.toString());
            bool1 = bool2;
          }
        }
      }
    }
    return bool1;
  }
  
  private static void deleteShortcut(Intent paramIntent, @NonNull AppRuntime paramAppRuntime, String paramString, Bitmap paramBitmap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString);
    localIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", paramBitmap);
    localIntent.putExtra("duplicate", false);
    localIntent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
    paramAppRuntime.getApp().sendOrderedBroadcast(localIntent, null);
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
  
  public static boolean enableQZoneContextBox(AppRuntime paramAppRuntime)
  {
    try
    {
      boolean bool = ((QZoneManager)paramAppRuntime.getManager(((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQzoneManagerInQQManagerFactory())).d();
      return bool;
    }
    catch (Throwable paramAppRuntime)
    {
      QZLog.e("enableQZoneContextBox", 2, paramAppRuntime, new Object[0]);
    }
    return false;
  }
  
  public static void forwardFromAIOToFeedDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt2);
  }
  
  public static void forwardFromQQSettingToPersonalAlbum(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    forwardToPersonalAlbum(paramActivity, paramUserInfo, paramLong, paramInt1, paramBoolean, paramInt2, 5);
  }
  
  public static void forwardFromSearchActivityToSharedFeedDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("jumpToDetailFromQQWhat", 0);
    localIntent.putExtra("startup_sceneid", 4);
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
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
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).forwardH5QZone(paramString, paramContext);
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, localUserInfo.qzone_uin, paramString1, paramInt3);
  }
  
  public static void forwardOpenQzoneVip(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_OPEN_VIP");
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", paramString1);
    localIntent.putExtra("uin", paramLong);
    if (!TextUtils.isEmpty(paramString2))
    {
      localIntent.putExtra("direct_go", false);
      localIntent.putExtra("key_open_qzone_vip_dialog_title", paramString2);
    }
    else
    {
      localIntent.putExtra("direct_go", true);
    }
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardOpenQzoneVip2(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, long paramLong, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_OPEN_VIP");
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", paramString1);
    localIntent.putExtra("provide_uin", paramLong);
    localIntent.putExtra("success_tips", paramString3);
    localIntent.putExtra("direct_go", paramBoolean ^ true);
    localIntent.putExtra("need_loading_dialog", true);
    localIntent.putExtra("key_open_qzone_vip_dialog_title", paramString2);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static boolean forwardQZoneApp(Context paramContext, int paramInt, long paramLong, String paramString)
  {
    Bundle localBundle;
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo("com.qzone", 0);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneHelper", 2, localNameNotFoundException.getMessage());
      }
      localBundle = null;
    }
    boolean bool = true;
    if (localBundle != null)
    {
      int i = localBundle.versionCode;
      if (i >= paramInt) {
        break label111;
      }
      if (i >= 80)
      {
        paramString = new Intent();
        paramString.setData(Uri.parse("mqzone://arouse/activefeed?source=qq&version=1"));
        paramString.setPackage("com.qzone");
        paramContext.startActivity(paramString);
        return true;
      }
    }
    bool = false;
    label111:
    if (bool)
    {
      localBundle = new Bundle();
      localBundle.putLong("qqid", paramLong);
      localBundle.putLong("uin", paramLong);
      localBundle.putBoolean("isbackmenu", false);
      localBundle.putString("selfUin", String.valueOf(paramLong));
      localBundle.putString("AccountInfoSync", "mobileqq.service");
      localBundle.putString("ClassNameSync", paramString);
      paramString = new Intent();
      paramString.setClassName("com.qzone", "com.qzone.QZoneSyncAccountActivity");
      paramString.putExtras(localBundle);
      paramString.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      paramContext.startActivity(paramString);
    }
    return bool;
  }
  
  public static void forwardToAggregate(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    QZLog.e("QZoneHelper", "forwardToAggregate() unexpired call request!");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramIntent, "com.qzone.commoncode.module.videostory.aggregate.VideoStoryAggregateActivity");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static void forwardToBrowser(Activity paramActivity, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    Intent localIntent = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(paramActivity);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.setData(Uri.parse(paramString1));
    openWebSecurityVerify(localIntent);
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = null;
    } else {
      paramString1 = paramString2.getBytes();
    }
    if (paramString1 != null) {
      localIntent.putExtra("post_data", paramString1);
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    addSource(localIntent);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void forwardToCategoryAlbum(Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("categoryBusiType", paramInt1);
      localIntent.putExtra("categoryId", paramString2);
      ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.album.business.albumlist.activity.QzonePhotoCategoryDetailsActivity");
      ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramString1, localIntent, paramInt2);
      return;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("forwardToCategoryAlbum fail type = ");
    paramActivity.append(paramInt1);
    paramActivity.append(" id=");
    paramActivity.append(paramString2);
    QLog.e("QZoneHelper", 1, paramActivity.toString());
  }
  
  public static void forwardToCmActionUrl(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jump forwardToCmActionUrl URL:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QZoneHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(paramContext);
    openWebSecurityVerify((Intent)localObject);
    ((Intent)localObject).putExtra("url", paramString);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName((Intent)localObject);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putQzoneSourceName((Intent)localObject);
    ((Intent)localObject).setData(Uri.parse(paramString));
    ((Intent)localObject).addFlags(268435456);
    addSource((Intent)localObject);
    paramContext.startActivity((Intent)localObject);
  }
  
  public static void forwardToCoverPhotoWall(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, CoverCacheData paramCoverCacheData, String paramString, int paramInt)
  {
    paramUserInfo = QZoneHelper.QZoneCoverConstants.getPhotoWallUrl(paramUserInfo.qzone_uin, paramString, "usersummary", true);
    paramCoverCacheData = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(paramActivity);
    openWebSecurityVerify(paramCoverCacheData);
    paramCoverCacheData.putExtra("url", paramUserInfo);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(paramCoverCacheData);
    paramCoverCacheData.setData(Uri.parse(paramUserInfo));
    addSource(paramCoverCacheData);
    paramActivity.startActivityForResult(paramCoverCacheData, paramInt);
  }
  
  public static void forwardToDLNAActivity(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = getQzoneActivityIntentForName(paramUserInfo, "com.qzone.album.business.dlna.activity.DLNAActivity");
    localIntent.putExtras(paramBundle);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  @Deprecated
  public static void forwardToDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("blog_url", paramString2);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("startup_sceneid", 4);
    boolean bool;
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.contains("blog"))) {
      bool = true;
    } else {
      bool = false;
    }
    localIntent.putExtra("qzone.isFavorBlog", bool);
    localIntent.putExtra("qzone.cellid", paramString1);
    localIntent.putExtra("qzone.sourceFrom", true);
    localIntent.putExtra("qzone.favorOwner", paramLong);
    QZoneLoginReportHelper.setLoginFromMyFav(localIntent);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    try
    {
      long l = Long.parseLong(paramString1);
      int i = Integer.valueOf(paramString2).intValue();
      if (paramBundle != null) {
        paramString1 = paramBundle;
      } else {
        paramString1 = new Bundle();
      }
      paramString1.putLong("targetuin", l);
      paramString1.putInt("appid", i);
      paramString1.putString("subid", paramString4);
      paramString1.putString("cellid", paramString3);
      paramString1.putBoolean("messagelist", true);
      if (paramBundle != null) {
        paramString1.putAll(paramBundle);
      }
      localIntent.putExtras(paramString1);
      ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramContext, paramUserInfo.qzone_uin, localIntent, paramInt, null, paramBoolean1);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.w("QZoneHelper", 2, "forwardToDetail error", paramContext);
    }
  }
  
  public static void forwardToExtendFeeds(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramString, paramIntent, paramInt, true);
  }
  
  public static void forwardToFamousUserHome(Context paramContext, QZoneHelper.UserInfo paramUserInfo, String paramString1, int paramInt1, int paramInt2, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, String paramString2, boolean paramBoolean)
  {
    paramString1 = getQZoneUserHomeActivityIntent(paramString1, paramInt2);
    if (paramBoolean) {
      paramString1.addFlags(268435456);
    }
    paramString1.putExtra("famous_space_webview_url", paramString2);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramString1, "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramContext, paramUserInfo.qzone_uin, paramString1, paramInt1, paramPreloadProcHitPluginSession);
  }
  
  public static void forwardToFeedActionPanel(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, int paramInt9)
  {
    if (paramInt6 == 0) {
      paramInt2 = -1;
    }
    if ((paramInt6 == 1) && (paramInt2 == 1)) {
      if (paramInt2 == 1) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
    }
    paramString1 = getFeedActionPanel(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt2, Integer.valueOf(0), null, paramInt1, "", false);
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramString1, "com.qzone.common.activities.FeedActionPanelActivity");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramString1, paramInt1);
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
    if ((paramInt6 == 1) && (paramInt2 == 1)) {
      if (paramInt2 == 1) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
    }
    paramString1 = getFeedActionPanel(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt2, Integer.valueOf(0), null, paramInt1, "", false);
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramString1, "com.qzone.common.activities.FeedActionPanelActivity");
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramString1, paramInt1, null, paramBoolean2);
  }
  
  public static void forwardToFeedDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("startup_sceneid", 4);
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    localIntent.putExtra("appid", paramInt1);
    localIntent.setFlags(67108864);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt2);
  }
  
  public static void forwardToFriendFeed(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramIntent, paramInt, paramOnDismissListener, true);
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
    if (!forwardToQZoneFriendFeedActivity(paramActivity, paramIntent, true)) {
      ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramString1, paramIntent, paramInt);
    }
  }
  
  public static void forwardToGroupAlbum(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN");
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    localIntent.putExtra("startup_sceneid", 6);
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("key_qun_code", paramString2);
    localIntent.putExtra("key_thumb_file_path", paramString3);
    localIntent.putExtra("key_big_photo_uuid", paramString4);
    localIntent.putExtra("key_msg_time", paramLong);
    localIntent.putExtra("refer", "mqqChat");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToGroupAlbum(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Long> paramArrayList, int paramInt, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN");
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToGroupFeed(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent();
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    localIntent.putExtra("startup_sceneid", 8);
    localIntent.putExtra("key_qun_id", paramString2);
    localIntent.putExtra("ken_qun_name", paramString3);
    localIntent.putExtra("refer", "group_profile");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.feed.ui.activity.QZoneQunFeedActivity");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramString1, localIntent, paramInt);
  }
  
  public static void forwardToMoodSelectLocation(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation");
    localIntent.putExtra("k_modal", true);
    localIntent.putExtra("k_hide_qzone_icon", true);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToMoodSelectLocation(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation");
    localIntent.putExtra("k_modal", true);
    localIntent.putExtra("k_hide_qzone_icon", true);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToMoodSelectLocation(Context paramContext, String paramString, int paramInt, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramContext, paramString, localIntent, paramInt);
  }
  
  public static void forwardToNuanProfile(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt)
  {
    try
    {
      Intent localIntent = new Intent();
      setUserInfoToIntent(localIntent, paramUserInfo);
      ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.feed.ui.activity.QZoneNuanProfileActivity");
      localIntent.putExtra("key_uin", Long.parseLong(paramString));
      ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.e("QZoneHelper", 2, "forwardToNuanProfile error!", paramActivity);
    }
  }
  
  public static void forwardToPermissionSetting(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    paramUserInfo = QzoneConfig.getInstance().getConfig("H5Url", "QzoneSettingMainPage", "https://h5.qzone.qq.com/qzone/setting?_wv=3&_proxy=1&uin={uin}").replace("{uin}", String.valueOf(paramUserInfo.qzone_uin)).replace("{host_uin}", paramUserInfo.qzone_uin).replace("{UIN}", String.valueOf(paramUserInfo.qzone_uin)).replace("{HOST_UIN}", paramUserInfo.qzone_uin);
    if (!URLUtil.b(paramUserInfo).containsKey("_wv")) {
      URLUtil.a(paramUserInfo, "_wv", "5");
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jump qzone setting URL:");
      ((StringBuilder)localObject).append(paramUserInfo);
      QLog.d("QZoneHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(paramActivity);
    openWebSecurityVerify((Intent)localObject);
    ((Intent)localObject).putExtra("url", paramUserInfo);
    ((Intent)localObject).putExtra("isFromQQ", true);
    ((Intent)localObject).putExtra("fromQZone", false);
    ((Intent)localObject).putExtra("injectrecommend", true);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName((Intent)localObject);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putQzoneSourceName((Intent)localObject);
    ((Intent)localObject).setData(Uri.parse(paramUserInfo));
    ((Intent)localObject).addFlags(268435456);
    addSource((Intent)localObject);
    paramActivity.startActivity((Intent)localObject);
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramLong, paramInt3, paramPreloadProcHitPluginSession);
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramLong, paramInt2);
  }
  
  public static void forwardToPersonalAlbumPhotoList(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo, int paramInt)
  {
    paramBaseBusinessAlbumInfo = getAlbumPhotoListIntent(paramUserInfo, paramBaseBusinessAlbumInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramBaseBusinessAlbumInfo, paramInt);
  }
  
  public static void forwardToPersonalAlbumPhotoListFromShortcut(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo, int paramInt)
  {
    paramBaseBusinessAlbumInfo = getAlbumPhotoListIntent(paramUserInfo, paramBaseBusinessAlbumInfo);
    paramBaseBusinessAlbumInfo.putExtra("UploadPhoto.key_from_album_shortcut", true);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramBaseBusinessAlbumInfo, paramInt);
  }
  
  public static void forwardToPersonalAlbumPhotoListV2(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo, int paramInt, String paramString)
  {
    paramBaseBusinessAlbumInfo = getAlbumPhotoListIntent(paramUserInfo, paramBaseBusinessAlbumInfo);
    paramBaseBusinessAlbumInfo.putExtra("mqqflag", 1);
    paramBaseBusinessAlbumInfo.putExtra("cell_operation.qq_url", paramString);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramBaseBusinessAlbumInfo, paramInt);
  }
  
  public static void forwardToPersonalAlbumSelect(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = getQzoneActivityIntentForName(paramUserInfo, "com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity");
    localIntent.putExtras(paramBundle);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToPersonalAlbumVideoList(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo, int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity");
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToPersonalPhotoList(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = getQzoneActivityIntentForName(paramUserInfo, "com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity");
    localIntent.putExtras(paramBundle);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToPictureSetting(Context paramContext, QZoneHelper.UserInfo paramUserInfo)
  {
    paramUserInfo = QzoneConfig.getInstance().getConfig("H5Url", "QzonePictureSettingPage", "https://h5.qzone.qq.com/image/setting/imageSetting?_wv=3&_proxy=1&uin={uin}").replace("{uin}", String.valueOf(paramUserInfo.qzone_uin)).replace("{host_uin}", paramUserInfo.qzone_uin).replace("{UIN}", String.valueOf(paramUserInfo.qzone_uin)).replace("{HOST_UIN}", paramUserInfo.qzone_uin);
    if (!URLUtil.b(paramUserInfo).containsKey("_wv")) {
      URLUtil.a(paramUserInfo, "_wv", "5");
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jump qzone setting URL:");
      ((StringBuilder)localObject).append(paramUserInfo);
      QLog.d("QZoneHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(paramContext);
    openWebSecurityVerify((Intent)localObject);
    ((Intent)localObject).putExtra("url", paramUserInfo);
    ((Intent)localObject).putExtra("isFromQQ", true);
    ((Intent)localObject).putExtra("fromQZone", false);
    ((Intent)localObject).putExtra("injectrecommend", true);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName((Intent)localObject);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putQzoneSourceName((Intent)localObject);
    ((Intent)localObject).setData(Uri.parse(paramUserInfo));
    ((Intent)localObject).addFlags(268435456);
    addSource((Intent)localObject);
    paramContext.startActivity((Intent)localObject);
  }
  
  public static void forwardToPictureViewer(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).sendRemoteHandleManagerData("cmd.cancelKillPictureProcess", null, false);
    Intent localIntent = getQzoneActivityIntentForName(paramUserInfo, "com.qzone.preview.QzonePictureViewer");
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("fromQZone", false);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt, null, false);
  }
  
  public static void forwardToPictureViewerForQzone(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).sendRemoteHandleManagerData("cmd.cancelKillPictureProcess", null, false);
    Intent localIntent = getQzoneActivityIntentForName(paramUserInfo, "com.qzone.preview.QzonePictureViewer");
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("fromQZone", true);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt, null, false);
  }
  
  public static void forwardToPreviewLocalView(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.video.activity.VideoViewActivity");
    localIntent.putExtra("video_type", paramInt);
    localIntent.putExtra("video_source_path", paramString);
    localIntent.putExtra("start_time", paramLong1);
    localIntent.putExtra("end_time", paramLong2);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, 0);
  }
  
  public static void forwardToPublishBox(Context paramContext, Bundle paramBundle, int paramInt)
  {
    paramBundle = new Intent();
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramBundle, "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity");
    paramBundle.putExtra("fromQZone", false);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramContext, "0", paramBundle, paramInt, null, false);
  }
  
  public static void forwardToPublishMood(Activity paramActivity, Bundle paramBundle, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    localIntent.putExtra("startup_sceneid", 5);
    localIntent.putExtra("key_file_path", paramString1);
    localIntent.putExtra("key_title", paramString2);
    localIntent.putExtra("key_desc", paramString3);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToPublishMood(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, int paramInt)
  {
    paramIntent = new Intent(paramIntent);
    setUserInfoToIntent(paramIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramIntent, paramInt);
  }
  
  public static void forwardToPublishMood(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_OPEN_SHARE");
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    localIntent.putExtra("startup_sceneid", 5);
    localIntent.putExtra("key_file_path", paramString);
    localIntent.putExtra("key_title", HardCodeUtil.a(2131909489));
    localIntent.putExtra("key_desc", "");
    localIntent.putExtra("key_need_save_draft", false);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToPublishMood(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_PUBLISH_QR_CODE");
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    localIntent.putExtra("startup_sceneid", 5);
    localIntent.putExtra("key_file_path", paramString1);
    localIntent.putExtra("key_title", paramString2);
    localIntent.putExtra("key_desc", paramString3);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramContext, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToQQPublicAccountPublishPage(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    Object localObject = MobileQQ.getMobileQQ().waitAppRuntime(null);
    if (localObject != null)
    {
      long l = ((AppRuntime)localObject).getLongAccountUin();
      localObject = paramIntent;
      if (paramIntent == null) {
        localObject = new Intent();
      }
      ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent((Intent)localObject, "com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity");
      ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, String.valueOf(l), (Intent)localObject, paramInt);
    }
  }
  
  public static void forwardToQZoneFlashNickNameSetting(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramString, localIntent, 0);
  }
  
  public static boolean forwardToQZoneFriendFeedActivity(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    return ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).forwardToQZoneFriendFeedActivity(paramContext, paramIntent, paramBoolean);
  }
  
  public static void forwardToQunAlbumDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    paramUserInfo = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunAlbumDetail", "https://h5.qzone.qq.com/groupphoto/inqq/detail/{QQ_URL}?_wv=3&_proxy=1").replace("{QQ_URL}", URLEncoder.encode(paramString1));
    paramString1 = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(paramActivity);
    paramString1.putExtra("url", paramUserInfo);
    paramString1.putExtra("fromQZone", true);
    paramString1.putExtra("injectrecommend", true);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(paramString1);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putQzoneSourceName(paramString1);
    paramString1.setData(Uri.parse(paramUserInfo));
    paramActivity.startActivityForResult(paramString1, paramInt);
  }
  
  public static void forwardToQunAlbumList(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    paramString1 = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunAlbum", "https://h5.qzone.qq.com/groupphoto/inqq/album/{QUN_ID}?_wv=3&_proxy=1").replace("{QUN_ID}", paramString1);
    paramUserInfo = paramString1;
    if (!TextUtils.isEmpty(paramString3))
    {
      paramUserInfo = new StringBuilder();
      paramUserInfo.append(paramString1);
      paramUserInfo.append("&source=");
      paramUserInfo.append(paramString3);
      paramUserInfo = paramUserInfo.toString();
    }
    paramString1 = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(paramActivity);
    openWebSecurityVerify(paramString1);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("forwardToQunAlbumList:");
      paramString2.append(paramUserInfo);
      QLog.d("QZoneHelper", 2, paramString2.toString());
    }
    paramString1.putExtra("url", paramUserInfo);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(paramString1);
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
    paramString1 = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(paramActivity);
    openWebSecurityVerify(paramString1);
    paramString1.putExtra("url", paramUserInfo);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(paramString1);
    paramString1.setData(Uri.parse(paramUserInfo));
    addSource(paramString1);
    paramActivity.startActivityForResult(paramString1, paramInt);
  }
  
  public static void forwardToQunFeed(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    paramUserInfo = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunFeed", "https://h5.qzone.qq.com/groupphoto/inqq/recent/{QUN_ID}/groupphoto?_wv=3&_proxy=1").replace("{QUN_ID}", paramString1);
    paramString1 = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(paramActivity);
    paramString1.putExtra("url", paramUserInfo);
    paramString1.putExtra("fromQZone", true);
    paramString1.putExtra("injectrecommend", true);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(paramString1);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putQzoneSourceName(paramString1);
    paramString1.setData(Uri.parse(paramUserInfo));
    if (QZoneLoginReportHelper.needAddLoginFromQunAlbum(paramString1, paramInt)) {
      QZoneLoginReportHelper.reportLoginFromQunAlbum();
    }
    paramActivity.startActivityForResult(paramString1, paramInt);
  }
  
  public static void forwardToQunPassiveFeed(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt)
  {
    paramUserInfo = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunPassiveFeed", "https://h5.qzone.qq.com/groupphoto/inqq/relatedme/{QUN_ID}/{UIN}?_wv=3&_proxy=1").replace("{QUN_ID}", paramString).replace("{UIN}", paramUserInfo.qzone_uin);
    paramString = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(paramActivity);
    paramString.putExtra("url", paramUserInfo);
    paramString.putExtra("fromQZone", true);
    paramString.putExtra("injectrecommend", true);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(paramString);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putQzoneSourceName(paramString);
    paramString.setData(Uri.parse(paramUserInfo));
    if (QZoneLoginReportHelper.needAddLoginFromQunAlbum(paramString, paramInt)) {
      QZoneLoginReportHelper.reportLoginFromQunAlbum();
    }
    paramActivity.startActivityForResult(paramString, paramInt);
  }
  
  public static void forwardToQzDynamicEditVideoActivity(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent();
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.album.ui.activity.QzDynamicVideoEditActivity");
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("extra_is_from_p2v_edit", true);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt, null, false);
  }
  
  public static void forwardToQzoneAlbum(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong1, long paramLong2, int paramInt2)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_QUOTE_FROM_AIO");
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt2);
  }
  
  public static void forwardToQzoneAlbum(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Long> paramArrayList3, ArrayList<Long> paramArrayList4, int paramInt2)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_QUOTE_FROM_AIO");
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt2);
  }
  
  public static void forwardToQzoneBrowser(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.cover.ui.activity.QZoneBrowserActivity");
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.setData(Uri.parse(paramString1));
    openWebSecurityVerify(localIntent);
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = null;
    } else {
      paramString1 = paramString2.getBytes();
    }
    if (paramString1 != null) {
      localIntent.putExtra("post_data", paramString1);
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static boolean forwardToQzoneDetailFromAIO(Activity paramActivity, String paramString1, String paramString2)
  {
    if ((!paramString1.startsWith("http://mobile.qzone.qq.com")) && (!paramString1.startsWith("https://mobile.qzone.qq.com"))) {
      return false;
    }
    paramString2 = Uri.parse(paramString1);
    if (paramString2 == null) {
      return false;
    }
    paramString2 = paramString2.getQueryParameter("jumptoqzone");
    if (!TextUtils.isEmpty(paramString2))
    {
      if (!paramString2.equals("1")) {
        return false;
      }
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "aio2qzonedetail", 1) == 1)
      {
        paramString2 = new Intent();
        setUserInfoToIntent(paramString2, QZoneHelper.UserInfo.getInstance());
        ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramString2, "com.qzone.detail.ui.activity.QzoneDetailActivity");
        paramString2.putExtra("startup_sceneid", 4);
        paramString2.putExtra("mqqflag", 1);
        paramString2.putExtra("cell_operation.qq_url", paramString1);
        paramString2.putExtra("jumpToDetailFromQQWhat", 2);
        paramString2.putExtra("refer", "mqqChat");
        QZoneLoginReportHelper.setLoginFromAIOFeedShare(paramString2);
        ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, QZoneHelper.UserInfo.getInstance().qzone_uin, paramString2, 0);
        if (QLog.isColorLevel())
        {
          paramActivity = new StringBuilder();
          paramActivity.append("forwardToQzoneDetailFromAIO success:url=");
          paramActivity.append(paramString1);
          QLog.i("QZoneHelper", 2, paramActivity.toString());
        }
      }
      return true;
    }
    return false;
  }
  
  public static void forwardToQzoneFeedsSearch(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, int paramInt)
  {
    paramIntent = new Intent(paramIntent);
    setUserInfoToIntent(paramIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramIntent, "com.qzone.homepage.ui.activity.QzoneSearchFeedActivity");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramIntent, paramInt);
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
    } else {
      paramIntent.putExtra("bNeedCallBack", false);
    }
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramIntent, "com.qzone.misc.web.QZoneTranslucentActivity");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramIntent, paramInt);
  }
  
  public static void forwardToQzoneTransluentActivity(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    setUserInfoToIntent(paramIntent, paramUserInfo);
    if (paramInt >= 0) {
      paramIntent.putExtra("bNeedCallBack", true);
    } else {
      paramIntent.putExtra("bNeedCallBack", false);
    }
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramIntent, "com.qzone.misc.web.QZoneTranslucentActivity");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramIntent, paramInt, null, paramBoolean);
  }
  
  public static void forwardToQzoneTransluentActivity2(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent)
  {
    setUserInfoToIntent(paramIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramIntent, "com.qzone.misc.web.QZoneTranslucentActivity2");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramIntent, 0);
  }
  
  public static void forwardToQzoneVideoCaptureNew(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).forwardToQzoneVideoCaptureNew(paramActivity, paramBundle, paramInt);
  }
  
  public static void forwardToQzoneVideoCaptureNew(AppRuntime paramAppRuntime, Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, boolean paramBoolean3, boolean paramBoolean4, String paramString3, boolean paramBoolean5, String paramString4, String paramString5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, String paramString6, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, int paramInt2, boolean paramBoolean13, Bundle paramBundle)
  {
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).forwardToQzoneVideoCaptureNew(paramAppRuntime, paramActivity, paramUserInfo, paramInt1, paramBoolean1, paramBoolean2, paramString1, paramString2, paramBoolean3, paramBoolean4, paramString3, paramBoolean5, paramString4, paramString5, paramBoolean6, paramBoolean7, paramBoolean8, paramBoolean9, paramString6, paramBoolean10, paramBoolean11, paramBoolean12, paramInt2, paramBoolean13, paramBundle);
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.video.activity.TrimVideoActivity");
    if (isRunningInQzoneProcess())
    {
      localIntent.setClassName(paramActivity, "com.qzone.video.activity.TrimVideoActivity");
      paramActivity.startActivity(localIntent);
      return;
    }
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt1);
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
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
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
  }
  
  public static void forwardToSharedFeedDetail(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("startup_sceneid", 4);
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    if (QZoneLoginReportHelper.needAddLoginFromAIOFeedShare(localIntent, paramString2)) {
      QZoneLoginReportHelper.setLoginFromAIOFeedShare(localIntent);
    }
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToShuoshuoDailyCalendar(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    paramUserInfo = new SimpleDateFormat("yyyyMM", Locale.getDefault()).format(new Date());
    paramUserInfo = QzoneConfig.getInstance().getConfig("H5Url", "QzoneShuoshuoDailyCalendar", "https://h5.qzone.qq.com/v2/shuoshuo-daily/calendar/{date}?_wv=16777216").replace("{date}", paramUserInfo).replace("{DATE}", paramUserInfo);
    if (!URLUtil.b(paramUserInfo).containsKey("_wv")) {
      URLUtil.a(paramUserInfo, "_wv", "1027");
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jump qzone ShuoshuoDailyCalendar URL:");
      ((StringBuilder)localObject).append(paramUserInfo);
      QLog.d("QZoneHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(paramActivity);
    openWebSecurityVerify((Intent)localObject);
    ((Intent)localObject).putExtra("url", paramUserInfo);
    ((Intent)localObject).putExtra("isFromQQ", false);
    ((Intent)localObject).putExtra("fromQZone", true);
    ((Intent)localObject).putExtra("injectrecommend", true);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName((Intent)localObject);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putQzoneSourceName((Intent)localObject);
    ((Intent)localObject).setData(Uri.parse(paramUserInfo));
    ((Intent)localObject).addFlags(268435456);
    addSource((Intent)localObject);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void forwardToSinglePermissionSetting(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity");
    localIntent.putExtra("qqid", paramLong);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, localIntent, paramInt);
  }
  
  public static void forwardToTroopAlbumViewPhoto(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    paramUserInfo = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunAlbumPhotoList", "https://h5.qzone.qq.com/groupphoto/inqq/photo/{QUN_ID}/{ALBUM_ID}?_wv=3&_proxy=1").replace("{QUN_ID}", paramString1).replace("{ALBUM_ID}", paramString2);
    paramString1 = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQQBrowserActivityIntent(paramActivity);
    openWebSecurityVerify(paramString1);
    paramString1.putExtra("url", paramUserInfo);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).putWebViewPluginPackageName(paramString1);
    paramString1.setData(Uri.parse(paramUserInfo));
    addSource(paramString1);
    paramActivity.startActivityForResult(paramString1, paramInt);
  }
  
  @Deprecated
  public static void forwardToTroopUploadPhoto(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, ArrayList<String> paramArrayList, int paramInt2, int paramInt3)
  {
    paramString1 = getQZoneUploadPhotoActivityIntent(null, 1, paramString1, paramString2, paramString3, paramString4, "mqqChat");
    setUserInfoToIntent(paramString1, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    if (paramString1 == null) {
      return;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 == 2) {
        paramInt1 = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getSendSizeSpecRAW();
      }
    }
    else {
      paramInt1 = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getSendSizeSpecNOR();
    }
    paramString1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    paramString1.putExtra("key_quality", paramInt1);
    paramString1.putExtra("key_album_upload_immediately", true);
    paramString1.putExtra("photoactivity_key_type", 1);
    paramString1.putExtra("up_way", paramInt3);
    paramString2 = String.valueOf(MessageUtils.a());
    paramIntent.putExtra("key_upload_client_key", paramString2);
    paramString1.putExtra("key_upload_client_key", paramString2);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramString1, paramInt2);
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, localUserInfo.qzone_uin, paramString1, paramInt3);
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, localUserInfo.qzone_uin, paramString1, paramInt3);
    if (1 == paramInt1) {
      ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).reportTroopAlbumExp();
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, localUserInfo.qzone_uin, paramString1, paramInt3);
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
    if ((isSupportWebViewCover()) && (parseAndSetQzoneCoverInfoToIntent(localIntent, paramArrayOfByte))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity");
    }
    else
    {
      setUserInfoToIntent(localIntent, paramUserInfo);
      ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    }
    if (QZoneLoginReportHelper.needAddLoginFromFriendProfile(localIntent, paramString, paramInt3)) {
      QZoneLoginReportHelper.setLoginFromFriendProfile(localIntent);
    }
    localIntent.putExtra("startup_sceneid", 2);
    addQZoneStatis(localIntent, paramInt1);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramContext, paramUserInfo.qzone_uin, localIntent, paramInt2, paramPreloadProcHitPluginSession);
  }
  
  public static void forwardToUserHomeByNearBy(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Parcelable paramParcelable)
  {
    paramString = getQZoneUserHomeActivityIntent(paramString, 6);
    setUserInfoToIntent(paramString, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramString, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramString.putExtra("key_has_talk", paramBoolean);
    paramString.putExtra("key_nearby_profile", paramParcelable);
    paramString.putExtra("startup_sceneid", 2);
    addQZoneStatis(paramString, paramInt1);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramUserInfo.qzone_uin, paramString, paramInt2);
  }
  
  public static void forwardToVideoEditActionPanel(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, int paramInt9, int paramInt10, boolean paramBoolean3)
  {
    forwardToVideoEditActionPanel(paramActivity, paramUserInfo, paramInt1, paramString1, paramString2, paramString3, paramString4, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramString5, paramInt8, paramBundle, paramBoolean1, paramBoolean2, paramInt9, paramInt10, paramBoolean3, null);
  }
  
  public static void forwardToVideoEditActionPanel(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, Bundle paramBundle1, boolean paramBoolean1, boolean paramBoolean2, int paramInt9, int paramInt10, boolean paramBoolean3, Bundle paramBundle2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodTabActivity");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramString1, localIntent, paramInt);
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
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramString1, localIntent, paramInt);
  }
  
  public static void forwardToWriteMood(Activity paramActivity, AppRuntime paramAppRuntime, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).forwardToWriteMood(paramActivity, paramAppRuntime, paramIntent, paramInt, paramBoolean);
  }
  
  @NonNull
  private static Intent getAlbumPhotoListIntent(QZoneHelper.UserInfo paramUserInfo, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity");
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
    Intent localIntent = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getShortcutIntent(paramContext);
    localIntent.setAction(paramString3);
    localIntent.putExtra("from", "shortcutFromQZonePhotolist");
    localIntent.putExtra("UploadPhoto.key_album_id", paramString1);
    localIntent.putExtra("UploadPhoto.key_album_owner_uin", paramLong);
    localIntent.setFlags(337641472);
    return new ShortcutInfo.Builder(paramContext, paramString1).setIcon(Icon.createWithBitmap(paramBitmap)).setShortLabel(paramString2).setIntent(localIntent).build();
  }
  
  public static int getDevicePerformanceLevel()
  {
    if (g_playGifParformanceLevel != 0) {
      return g_playGifParformanceLevel;
    }
    Object localObject = (IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class);
    int i = 3;
    if (!((IQzoneHardwareRestriction)localObject).meetHardwareRestriction(3, 2)) {
      if (((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(2, 1)) {
        i = 2;
      } else {
        i = 1;
      }
    }
    g_playGifParformanceLevel = i;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[jinqianli-performance] current mem level is ");
    ((StringBuilder)localObject).append(((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).getCurrentMemLevel());
    ((StringBuilder)localObject).append(", current cpu level is ");
    ((StringBuilder)localObject).append(((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).getCurrentCpuLevel());
    ((StringBuilder)localObject).append(", play gif parformance level is ");
    ((StringBuilder)localObject).append(g_playGifParformanceLevel);
    QLog.d("QZoneHelper", 2, ((StringBuilder)localObject).toString());
    return i;
  }
  
  public static int getDevicePerformanceLevelInfo()
  {
    if (g_listScrollParformanceLevel != 0) {
      return g_listScrollParformanceLevel;
    }
    Object localObject = (IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class);
    int i = 3;
    if (((IQzoneHardwareRestriction)localObject).equalHardwareRestriction(3, 3)) {
      i = 4;
    } else if (!((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).equalHardwareRestriction(2, 2)) {
      if (((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).equalHardwareRestriction(1, 1)) {
        i = 2;
      } else {
        i = 1;
      }
    }
    g_listScrollParformanceLevel = i;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[jinqianli-performance] current mem level is ");
    ((StringBuilder)localObject).append(((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).getCurrentMemLevel());
    ((StringBuilder)localObject).append(", current cpu level is ");
    ((StringBuilder)localObject).append(((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).getCurrentCpuLevel());
    ((StringBuilder)localObject).append(", play gif parformance level is ");
    ((StringBuilder)localObject).append(g_playGifParformanceLevel);
    QLog.d("QZoneHelper", 2, ((StringBuilder)localObject).toString());
    return i;
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
    for (;;)
    {
      try
      {
        try
        {
          localObject = Class.forName("com.qzone.misc.network.uploader.QZoneImageSizeStrategy");
          paramContext = (Context)localObject;
        }
        catch (Exception paramContext) {}
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Object localObject;
        continue;
      }
      try
      {
        localObject = ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).getQZonePluginClassLoader(paramContext);
        paramContext = ((ClassLoader)localObject).loadClass("com.qzone.misc.network.uploader.QZoneImageSizeStrategy");
        BasicClassTypeUtil.setClassLoader(true, (ClassLoader)localObject);
        if (paramContext == null)
        {
          QLog.e("QZLog", 1, "*QZoneImageSizeStrategy load class fail");
          return null;
        }
        paramContext = (IUploadConfig.UploadImageSize)paramContext.getMethod("getTargetSize", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }).invoke(null, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) });
        return paramContext;
      }
      catch (ClassNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    paramContext.printStackTrace();
    return null;
  }
  
  public static Intent getJumpQzoneTabIntent(Context paramContext, Intent paramIntent)
  {
    return ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getJumpQzoneTabIntent(paramContext, paramIntent);
  }
  
  public static int getMaxRecentUserNum()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "MaxNumInConverstation", 100);
  }
  
  public static String getQUA()
  {
    return QUA.getQUA3();
  }
  
  public static Intent getQZoneDetailActivity()
  {
    Intent localIntent = new Intent();
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
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
    }
    catch (NumberFormatException paramString)
    {
      QZLog.e("QZoneHelper", "getQZoneUserHomeActivityIntent", paramString);
    }
    localIntent.putExtra("qzone_entry", paramInt);
    localIntent.putExtra("hc_code", sQZoneHCCode);
    sQZoneHCCode = 0;
    putTimeRecord(localIntent);
    return localIntent;
  }
  
  public static Intent getQZoneVideoDownloadActivityIntent(Context paramContext)
  {
    return ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQZoneVideoDownloadActivityIntent(paramContext);
  }
  
  private static Intent getQzoneActivityIntentForName(QZoneHelper.UserInfo paramUserInfo, String paramString)
  {
    Intent localIntent = new Intent();
    setUserInfoToIntent(localIntent, paramUserInfo);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, paramString);
    return localIntent;
  }
  
  public static BaseBusinessAlbumInfo getQzoneAlbumInfo(String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append("_record_time");
    long l = LocalMultiProcConfig.getLong(MD5.b(((StringBuilder)localObject1).toString()), 0L);
    if (QzoneConfig.getInstance().getConfig("PhotoUpload", "C2CAioAlbumCacheExpireTime", 60) * 60 * 1000L + l < System.currentTimeMillis())
    {
      paramString1 = new StringBuilder();
      paramString1.append("getQzoneAlbumInfo cache expire. albumId=");
      paramString1.append(paramString2);
      paramString1.append(" recordTime=");
      paramString1.append(l);
      QZLog.i("QZoneHelper", 1, paramString1.toString());
      return null;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append("_album_id");
    localObject1 = MD5.b(((StringBuilder)localObject1).toString());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("_album_title");
    localObject2 = MD5.b(((StringBuilder)localObject2).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_exist");
    paramString1 = MD5.b(localStringBuilder.toString());
    paramString2 = LocalMultiProcConfig.getString((String)localObject1, "");
    localObject1 = LocalMultiProcConfig.getString((String)localObject2, "");
    boolean bool = LocalMultiProcConfig.getBool(paramString1, true);
    paramString1 = new BaseBusinessAlbumInfo(paramString2);
    paramString1.mTitle = ((String)localObject1);
    paramString1.isAlbumExist = bool;
    return paramString1;
  }
  
  @Deprecated
  public static Intent getQzoneFriendFeedActivity(Context paramContext)
  {
    paramContext = new Intent();
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramContext, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    return paramContext;
  }
  
  public static Intent getQzoneMyFeedActivity(Context paramContext)
  {
    paramContext = new Intent();
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramContext, "com.qzone.feed.ui.activity.QZoneMyFeedActivity");
    return paramContext;
  }
  
  private static Intent getQzonePersonalAlbumActivityIntent(Context paramContext, Long paramLong, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_left_tab_title", paramContext.getString(2131914536));
    localIntent.putExtra("key_rihgt_tab_title", paramContext.getString(2131914617));
    localIntent.putExtra("key_album_owner_uin", paramLong);
    localIntent.putExtra("key_selected_tab", paramInt);
    putTimeRecord(localIntent);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity");
    return localIntent;
  }
  
  public static String getQzonePluginSoUrl()
  {
    return QzoneConfig.getInstance().getConfig("LiveSetting", "LivePluginSOUrl", "https://d3g.qq.com/sngapp/app/update/20171124202406_7451/res1_qzlive_yt_base.so");
  }
  
  public static Intent getQzoneSpecialFeedActivity(Context paramContext)
  {
    paramContext = new Intent();
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(paramContext, "com.qzone.feed.ui.activity.QZoneSpecialActiveFeedsActivity");
    return paramContext;
  }
  
  public static Intent getQzoneVerticalVideoDownloadActivityIntent(Context paramContext)
  {
    return ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQzoneVerticalVideoDownloadActivityIntent(paramContext);
  }
  
  public static QIPCModule getQzoneVideoSoDownloadModule()
  {
    return ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getQzoneVideoSoDownloadModule();
  }
  
  public static BaseBusinessAlbumInfo getSelectedAlbumInfo(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("_album_id");
    localObject = MD5.b(((StringBuilder)localObject).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_album_title");
    paramString1 = MD5.b(localStringBuilder.toString());
    paramString2 = LocalMultiProcConfig.getString((String)localObject, "");
    paramString1 = LocalMultiProcConfig.getString(paramString1, "");
    paramString2 = new BaseBusinessAlbumInfo(paramString2);
    paramString2.mTitle = paramString1;
    return paramString2;
  }
  
  @NonNull
  private static Intent getShortcutIntent(@NonNull AppRuntime paramAppRuntime, String paramString, long paramLong)
  {
    paramAppRuntime = ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getShortcutIntent(paramAppRuntime.getApp());
    paramAppRuntime.setAction("intent.start.shortcut.guide");
    paramAppRuntime.putExtra("from", "shortcutFromQZonePhotolist");
    paramAppRuntime.putExtra("UploadPhoto.key_album_id", paramString);
    paramAppRuntime.putExtra("UploadPhoto.key_album_owner_uin", paramLong);
    paramAppRuntime.putExtra("UploadPhoto.key_from_album_shortcut", true);
    paramAppRuntime.addCategory("android.intent.category.LAUNCHER");
    paramAppRuntime.setFlags(337641472);
    return paramAppRuntime;
  }
  
  public static boolean getSimpleQZoneUISwitch()
  {
    return ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).getSimpleQZoneUISwitch();
  }
  
  public static int getUpdateCountIntervalWhenClickFeedTab()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "UpdateCountIntervalWhenClickFeedTab", 30) * 1000;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUpdateCountIntervalWhenClickFeedTab:");
      localStringBuilder.append(i);
      QLog.d("QZoneHelper.UndealCount", 2, localStringBuilder.toString());
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
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("QZoneSetting", "hideAioFeeds", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean hideAioQCircleFeeds()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("QZoneSetting", "qqcircle_show_entrance_on_aio_feed", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean hideQzoneStatusInConverstation()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("QZoneSetting", "hideFeedsInConverstation", 0) == 1) {
      bool = true;
    }
    return bool;
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
    long l1 = System.currentTimeMillis();
    int i = QzoneConfig.getInstance().getConfig("QzoneCover", "HtmlStandardCpuCore", 1);
    int j = QzoneConfig.getInstance().getConfig("QzoneCover", "HtmlStandardCpuFequency", 1100);
    int k = QzoneConfig.getInstance().getConfig("QzoneCover", "HtmlStandardRAMSize", 700);
    long l2 = DeviceInfoUtil.h() * DeviceInfoUtil.k();
    long l3 = i * j;
    boolean bool1;
    if ((l2 > 0L) && (l2 <= l3)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    l2 = DeviceInfoUtil.a();
    boolean bool2 = bool1;
    if (l2 > 0L) {
      if ((bool1) && (l2 > k * 1048576L)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
    l3 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isBestPerformanceDeviceImpl standardCpuCore=");
      localStringBuilder.append(i);
      localStringBuilder.append(",standardCpuFequency=");
      localStringBuilder.append(j);
      localStringBuilder.append(",standardRAMSize=");
      localStringBuilder.append(k);
      localStringBuilder.append(",cpu count=");
      localStringBuilder.append(DeviceInfoUtil.h());
      localStringBuilder.append(",cpu frequency=");
      localStringBuilder.append(DeviceInfoUtil.k());
      localStringBuilder.append(",total memory=");
      localStringBuilder.append(l2);
      localStringBuilder.append(",use time=");
      localStringBuilder.append(l3 - l1);
      QLog.d("QZoneHelper", 2, localStringBuilder.toString());
    }
    return bool2;
  }
  
  private static boolean isBuildModelInList(String paramString)
  {
    try
    {
      String str = Build.MODEL;
      if ((str != null) && (str.length() != 0))
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("buildModel is '");
          localStringBuilder.append(str);
          localStringBuilder.append("'");
          QLog.d("QZoneHelper", 2, localStringBuilder.toString());
        }
        if (paramString != null)
        {
          if (paramString.length() == 0) {
            return false;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(",");
          localStringBuilder.append(str);
          localStringBuilder.append(",");
          str = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(",");
          localStringBuilder.append(paramString);
          localStringBuilder.append(",");
          if (localStringBuilder.toString().contains(str))
          {
            QLog.i("QZoneHelper", 1, "命中禁止黑名单策略");
            return true;
          }
        }
      }
      else
      {
        QLog.i("QZoneHelper", 1, "buildModel is empty,not show float items.命中禁止策略");
        return true;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    return false;
  }
  
  public static boolean isFirstEnterFriendFeed()
  {
    return LocalMultiProcConfig.getBool("key_first_enter_friend_feed", true);
  }
  
  public static boolean isInFloatItemBlacklist()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "FloatModelBlacklist", "N5117,R8007,Coolpad 8720L,R7007,GN9000L,G620-L75,R2017,R6007,R831S,HM 1SC,Coolpad 8705,HUAWEI B199,Coolpad 9190L,HM 1SW,Coolpad 8730L,Coolpad 9190_T00,HS-E620M,HUAWEI G660-L075,Coolpad 5952,HUAWEI G730-L075,Coolpad 8729,HUAWEI C8817L,Bird LT01,Coolpad 5892,Coolpad 7620L,GN9004,HS-X8T,iPhone 6plus,K-Touch Tou ch 2,K-Touch Tou ch3,K-Touch Tou ch3w,Lenovo A560,Lenovo A890e,Lenovo B8080-HV,Lenovo S810t,LT18,MI 3C,N5110,Nokia_XL_4G,R2010,R8000,TCL-P688L,U558,ZTE Grand S II LTE,ZTE Q505T,ZTE Q802T,Coolpad Y60-C1,Coolpad 8702,BOWAY TL2000,Best sonny_LT986,BOWAY TL6000,Coolpad 5200S,Coolpad 5311,Coolpad 5315,DOOV T35,DOOV T60,HS-EG971,HS-EG978,HTC D516d,HUAWEI G6-L22,HUAWEI G620-L72,i6200S,KliTON,koobee M2,L-002,L823,L826,L827,Lingwin K1,LNV-Lenovo A505e,M7009,M811,MI 3W,R830S,ZTE Q801L,ZTE Q701C,YUSUN L63,TCL P631M,TCL J738M,T-smart L818,OUKI G5,OPSSON Q3,　　,MT2L03,VOTO VT898,AOLE,N5111,LA2-L,vtel X5,ETON T3,BOWAY TL500,T-smart L808,DOOV T90,CHM-TL00,thl L968,TCL J938M,2013022,HUAWEI G750-T01,vivo Y20T,vivo Y17T,vivo Y13T,vivo Y15T,vivo X3S W,U707T,R823T,R819T,N1T,Hol-T00,H8S,H30-U10,2014011,M351,HUAWEI G610-T11,vivo X3t,HUAWEI P6-T00,HUAWEI G700-U00,ETON I6,vivo Y11i T,HM NOTE 1TD");
    boolean bool2 = false;
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
    return new File(Environment.getExternalStorageDirectory().getPath(), "disable_preload").exists();
  }
  
  public static boolean isQzonePermissionPublic(long paramLong)
  {
    return LocalMultiProcConfig.getInt4Uin("isQzonePublic", 1, paramLong) > 0;
  }
  
  public static boolean isQzoneProcessExist()
  {
    Object localObject = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
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
    }
    return false;
  }
  
  public static boolean isRunningInQzoneProcess()
  {
    boolean bool2 = false;
    try
    {
      String str = MobileQQ.sMobileQQ.getQQProcessName();
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
      return ShortcutUtils.a(paramContext, new String[] { paramString });
    }
    return isShortcutCreated_O(paramString, (ShortcutManager)paramContext.getSystemService(ShortcutManager.class));
  }
  
  @RequiresApi(api=25)
  public static boolean isShortcutCreated_O(String paramString, ShortcutManager paramShortcutManager)
  {
    boolean bool2 = false;
    if (paramShortcutManager == null) {
      return false;
    }
    paramShortcutManager = paramShortcutManager.getPinnedShortcuts().iterator();
    do
    {
      bool1 = bool2;
      if (!paramShortcutManager.hasNext()) {
        break;
      }
    } while (!paramString.equals(((ShortcutInfo)paramShortcutManager.next()).getId()));
    boolean bool1 = true;
    return bool1;
  }
  
  private static boolean isSupportWebViewCover()
  {
    boolean bool = isBestPerformanceDevice();
    int i = 0;
    if (bool)
    {
      if (QzoneConfig.getInstance().getConfig("QzoneCover", "HtmlForceClose", 0) == 1) {
        i = 1;
      }
      return i ^ 0x1;
    }
    return false;
  }
  
  public static void killQZoneProcess()
  {
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).killQZoneProcess();
  }
  
  public static void launchQZone(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static void launchQZoneEncourageAdvActivity(Activity paramActivity, String paramString)
  {
    if (paramActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("gdt_adv_activity_factory_info", paramString);
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.preview.QZoneEncourageAdvActivity");
    if (isRunningInQzoneProcess())
    {
      localIntent.setClassName(paramActivity, "com.qzone.preview.QZoneEncourageAdvActivity");
      paramActivity.startActivity(localIntent);
      return;
    }
    paramString = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramString, localIntent, -1);
  }
  
  public static void launchVideoCoverPreviewActivity(Activity paramActivity, int paramInt1, String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt4, Bundle paramBundle, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (paramActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
    localIntent.putExtra("PhotoConst.VIDEO_TYPE", paramInt1);
    if (paramString1 == null) {
      paramString1 = "";
    }
    localIntent.putExtra("PhotoConst.QZONE_ALBUM_VIDEO_ID", paramString1);
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
    paramString1 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(localIntent, "com.qzone.cover.ui.activity.QzoneVideoCoverPreviewActivity");
    if (isRunningInQzoneProcess())
    {
      localIntent.setClassName(paramActivity, "com.qzone.cover.ui.activity.QzoneVideoCoverPreviewActivity");
      paramActivity.startActivity(localIntent);
      return;
    }
    ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(paramActivity, paramString1, localIntent, -1);
  }
  
  private static void onCreateShortcutFailed(@NonNull AppRuntime paramAppRuntime)
  {
    Intent localIntent = new Intent("com.qzone.album.CreateAlbumShortcutSucceedReceiver");
    localIntent.putExtra("AlbumCreateShortcutFailed", true);
    paramAppRuntime.getApp().sendBroadcast(localIntent);
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
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QZoneHelper.9(paramLong));
  }
  
  public static void openActivityAsync(boolean paramBoolean, QZoneHelper.StartActivity paramStartActivity)
  {
    if (!paramBoolean)
    {
      paramStartActivity.onStart(false, true);
      return;
    }
    ThreadManager.postImmediately(new QZoneHelper.6(paramStartActivity), null, true);
  }
  
  public static void openWebSecurityVerify(Intent paramIntent)
  {
    QzoneConfig.getInstance().getConfig("QZoneSetting", "openWebSecurityVerify", 1);
  }
  
  private static boolean parseAndSetQzoneCoverInfoToIntent(Intent paramIntent, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      Object localObject = new RES_ITEM_COVER();
      ((RES_ITEM_COVER)localObject).readFrom(paramArrayOfByte);
      paramArrayOfByte = ((RES_ITEM_COVER)localObject).strJumpQzone;
      int i;
      long l;
      if ((!TextUtils.isEmpty(paramArrayOfByte)) && (paramArrayOfByte.startsWith("mqzone://arouse/homepage")))
      {
        paramArrayOfByte = Uri.parse(paramArrayOfByte);
        String str1 = paramArrayOfByte.getQueryParameter("actiontype");
        localObject = paramArrayOfByte.getQueryParameter("actionurl");
        String str2 = paramArrayOfByte.getQueryParameter("uin");
        paramArrayOfByte = (byte[])localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            paramArrayOfByte = URLDecoder.decode((String)localObject, "UTF-8");
          }
          catch (UnsupportedEncodingException paramIntent)
          {
            QZLog.e("QZoneHelper", "parseAndSetQzoneCoverInfoToIntent", paramIntent);
            return false;
          }
        }
        try
        {
          i = Integer.parseInt(str1);
          l = Long.parseLong(str2);
        }
        catch (NumberFormatException paramIntent)
        {
          QZLog.e("QZoneHelper", "parseAndSetQzoneCoverInfoToIntent", paramIntent);
          return false;
        }
      }
      else
      {
        paramArrayOfByte = "";
        l = 0L;
        i = 0;
      }
      if (i == 35)
      {
        paramIntent.putExtra("qqid", l);
        paramIntent.putExtra("famous_space_webview_url", paramArrayOfByte);
        paramIntent.putExtra("click_time", System.currentTimeMillis());
        return true;
      }
    }
    return false;
  }
  
  public static void preloadInFriendProfileCard(AppRuntime paramAppRuntime, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    ThreadManager.post(new QZoneHelper.8(paramAppRuntime, paramPreloadProcHitPluginSession), 8, null, false);
  }
  
  public static void preloadQZoneForHaboReport(AppRuntime paramAppRuntime, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong)
  {
    AccManager.createStatistic(paramString1, paramInt1, paramString2, paramInt2);
  }
  
  public static void preloadQunAlbum(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime == null) {
      return;
    }
    if (isQzoneProcessExist()) {
      return;
    }
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).preloadQunAlbum(paramAppRuntime, paramString);
  }
  
  public static void preloadQzone(BaseApplication paramBaseApplication, String paramString1, String paramString2)
  {
    if (paramBaseApplication != null)
    {
      if (checkQzoneEntranceProtectEnable()) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preloadQzone from: ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("qzone_launch", 1, ((StringBuilder)localObject).toString());
      localObject = new Intent(paramBaseApplication, QzonePluginProxyService.class);
      try
      {
        ((Intent)localObject).putExtra("useSkinEngine", 1);
        if ("album_select".equals(paramString2)) {
          ((Intent)localObject).setAction("com.qzone.intent.action.PRELOAD_NOTHING");
        } else if ("FriendProfileCardActivity".equals(paramString2)) {
          ((Intent)localObject).setAction("com.qzone.intent.action.PRELOAD_USER_HOME");
        } else {
          ((Intent)localObject).setAction("com.qzone.intent.action.PRELOAD_FRIEND_FEEDS");
        }
        ((Intent)localObject).putExtra("cpuNum", DeviceInfoUtil.h());
        ((Intent)localObject).putExtra("key_can_set_layoutInfalter_factory", enableLayoutInflaterFactory());
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
      }
      if (DeviceOptSwitch.d)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Perf", 2, "disable preload qzone process");
        }
        DeviceOptSwitch.m = System.currentTimeMillis();
        return;
      }
      ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).launchPluginService(paramBaseApplication, null, paramString1, (Intent)localObject);
    }
  }
  
  public static void preloadQzone(AppRuntime paramAppRuntime, String paramString)
  {
    preloadQzone(paramAppRuntime, paramString, null, false);
  }
  
  public static void preloadQzone(AppRuntime paramAppRuntime, String paramString, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, boolean paramBoolean)
  {
    if (paramAppRuntime != null)
    {
      if (checkQzoneEntranceProtectEnable()) {
        return;
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).checkPreloadMiniApp();
      if ("MainAssistObserver".equals(paramString))
      {
        ReportController.b(paramAppRuntime, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 1, 0, "", "", "", "");
        StatisticHitRateCollector.a().a("actQZLoadHitRateRed", true);
      }
      else if ("Leba".equals(paramString))
      {
        ReportController.b(paramAppRuntime, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 1, 0, "", "", "", "");
        StatisticHitRateCollector.a().a("actQZLoadHitRateLeba", true);
      }
      else if ("FriendProfileCardActivity".equals(paramString))
      {
        StatisticHitRateCollector.a().a("actQZLoadHitRateProfile", true);
      }
      ThreadManager.postImmediately(new QZoneHelper.7(), null, false);
      try
      {
        SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("CrashControl_com.tencent.mobileqq:qzone", 4);
        if ((localSharedPreferences != null) && (!localSharedPreferences.getBoolean("allowpreload", true)))
        {
          long l1 = localSharedPreferences.getLong("starttime", 0L);
          int i = localSharedPreferences.getInt("controlwindow", 86400);
          long l2 = System.currentTimeMillis();
          if ((l1 > 0L) && (i > 0) && (l2 > l1) && (l2 - l1 > i * 1000))
          {
            localSharedPreferences.edit().putBoolean("allowpreload", true).commit();
          }
          else
          {
            QLog.d("QZoneHelper", 1, "preloadQzone is not allowed as crash frequently.");
            StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramAppRuntime.getCurrentAccountUin(), "actNoPreloadQzone", true, 0L, 0L, null, "");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("preloadQzone from: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("qzone_launch", 1, ((StringBuilder)localObject).toString());
        localObject = new Intent(paramAppRuntime.getApp(), QzonePluginProxyService.class);
        try
        {
          ((Intent)localObject).putExtra("useSkinEngine", 1);
          if ("FriendProfileCardActivity".equals(paramString)) {
            ((Intent)localObject).setAction("com.qzone.intent.action.PRELOAD_USER_HOME");
          } else if ("QCircle".equals(paramString)) {
            ((Intent)localObject).setAction("com.qzone.intent.action.PRELOAD_QCIRCLE_PUBLISH");
          } else {
            ((Intent)localObject).setAction("com.qzone.intent.action.PRELOAD_FRIEND_FEEDS");
          }
          ((Intent)localObject).putExtra("cpuNum", DeviceInfoUtil.h());
          ((Intent)localObject).putExtra("key_can_set_layoutInfalter_factory", enableLayoutInflaterFactory());
          ((Intent)localObject).putExtra("key_is_keep_alive", paramBoolean);
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        if (DeviceOptSwitch.d)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Perf", 2, "disable preload qzone process");
          }
          DeviceOptSwitch.m = System.currentTimeMillis();
          return;
        }
        ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).launchPluginService(paramAppRuntime.getApp(), paramPreloadProcHitPluginSession, paramAppRuntime.getCurrentAccountUin(), (Intent)localObject);
      }
    }
  }
  
  public static void preloadQzone(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    preloadQzone(paramAppRuntime, paramString, null, paramBoolean);
  }
  
  public static void prepareForQQPublicAccountPublishPage()
  {
    ThreadManager.post(new QZoneHelper.10(), 5, null, false);
  }
  
  public static void publishPictureMoodSilently(String paramString1, ArrayList<String> paramArrayList1, int paramInt1, LbsDataV2.PoiInfo paramPoiInfo, String paramString2, String paramString3, ArrayList<String> paramArrayList2, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, String paramString4, int paramInt2)
  {
    paramString2 = new Bundle();
    paramString2.putString("param.content", paramString1);
    paramString2.putStringArrayList("param.images", paramArrayList1);
    paramString2.putSerializable("param.extendInfo", paramHashMap2);
    if (!TextUtils.isEmpty(paramString3)) {
      try
      {
        paramString2.putInt("param.priv", Integer.parseInt(paramString3));
      }
      catch (Exception paramString1)
      {
        QZLog.e("QZoneHelper", "publishPictureMoodSilently... exception:", paramString1);
        paramString2.putInt("param.priv", 1);
      }
    }
    paramString2.putStringArrayList("param.privList", paramArrayList2);
    paramString2.putParcelable("param.poiInfo", paramPoiInfo);
    paramString2.putInt("param.syncWeibo", paramInt1);
    paramString2.putSerializable("param.storeExtendInfo", paramHashMap1);
    paramString2.putString("param.source", paramString4);
    paramString2.putInt("param.subtype", paramInt2);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).sendRemoteHandleManagerData("cmd.publishMixMood", paramString2, false);
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
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).sendRemoteHandleManagerData("cmd.publishMoodForAll", localBundle, false);
  }
  
  public static void publishPictureMoodSilently(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    String str;
    if ("source_from_quick_shoot".equals(paramString2))
    {
      str = "value.sourceFromQqQuickShoot";
    }
    else
    {
      str = paramString2;
      if ("forward_source_to_qzone".equals(paramString2)) {
        str = "value.personalSign";
      }
    }
    publishPictureMoodSilently(paramString1, paramArrayList, str, 2);
  }
  
  public static void publishPictureMoodSilently(String paramString1, ArrayList<String> paramArrayList, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.content", paramString1);
    localBundle.putStringArrayList("param.images", paramArrayList);
    localBundle.putString("param.source", paramString2);
    localBundle.putInt("param.subtype", paramInt);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).sendRemoteHandleManagerData("cmd.publishMood", localBundle, false);
  }
  
  public static void putTimeRecord(Intent paramIntent)
  {
    paramIntent.putExtra("key_time_record", System.currentTimeMillis());
  }
  
  public static void reportIfIsFromQZone(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.contains("mobile.qzone.qq.com")) {
      QZoneLoginReportHelper.reportLoginFromMQQSearchH5();
    }
  }
  
  public static void restartQzone()
  {
    killQZoneProcess();
    preloadQzone(MobileQQ.sMobileQQ.peekAppRuntime(), "QZoneDistributedAppCtrl");
  }
  
  public static void resumeQZoneFloatObjectView(Context paramContext, Object paramObject)
  {
    if (paramContext != null)
    {
      if (paramObject == null) {
        return;
      }
      for (;;)
      {
        try
        {
          try
          {
            localObject = Class.forName("com.qzone.personalize.floatobject.ui.FloatItemView");
            paramContext = (Context)localObject;
          }
          catch (Exception paramContext) {}
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          Object localObject;
          continue;
        }
        try
        {
          localObject = ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).getQZonePluginClassLoader(paramContext);
          paramContext = ((ClassLoader)localObject).loadClass("com.qzone.personalize.floatobject.ui.FloatItemView");
          BasicClassTypeUtil.setClassLoader(true, (ClassLoader)localObject);
          if (paramContext == null)
          {
            QLog.e("QZLog", 1, "*createQZoneFloatObjectView load class fail");
            return;
          }
          paramContext.getMethod("start", new Class[0]).invoke(paramObject, new Object[0]);
          return;
        }
        catch (ClassNotFoundException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      paramContext.printStackTrace();
      return;
    }
  }
  
  public static void saveQzoneAlbumInfo(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      if (paramString2 == null) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append("_album_id");
      localObject1 = MD5.b(((StringBuilder)localObject1).toString());
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append("_album_title");
      localObject2 = MD5.b(((StringBuilder)localObject2).toString());
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString1);
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(paramString2);
      ((StringBuilder)localObject3).append("_record_time");
      localObject3 = MD5.b(((StringBuilder)localObject3).toString());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("_exist");
      paramString1 = MD5.b(localStringBuilder.toString());
      LocalMultiProcConfig.putString((String)localObject1, paramString3);
      LocalMultiProcConfig.putString((String)localObject2, paramString4);
      LocalMultiProcConfig.putLong((String)localObject3, System.currentTimeMillis());
      LocalMultiProcConfig.putBool(paramString1, paramBoolean);
      paramString1 = new StringBuilder();
      paramString1.append("saveQzoneAlbumInfo: albumId=");
      paramString1.append(paramString3);
      paramString1.append(" albumTitle=");
      paramString1.append(paramString4);
      paramString1.append(" isAlbumExist=");
      paramString1.append(paramBoolean);
      QZLog.i("QZoneHelper", 1, paramString1.toString());
    }
  }
  
  public static void saveQzonePermission(boolean paramBoolean, long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void saveSelectedAlbumInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("_album_id");
    localObject = MD5.b(((StringBuilder)localObject).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_album_title");
    paramString1 = MD5.b(localStringBuilder.toString());
    LocalMultiProcConfig.putString((String)localObject, paramString3);
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
    DialogUtil.a(paramActivity, 230).setMessage(2131915121).setPositiveButton(2131914647, new QZoneHelper.1()).setNegativeButton(2131916598, paramOnClickListener).show();
  }
  
  public static void showQzoneVipOriginalVideoDialogForUpload(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    DialogUtil.a(paramActivity, 230).setMessage(2131915122).setPositiveButton(2131916598, paramOnClickListener).setNegativeButton(2131914647, new QZoneHelper.2()).show();
  }
  
  public static void startTranslucentBrowserActivityForResult(Context paramContext, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    startTranslucentBrowserActivityForResult(paramContext, paramString1, paramInt, paramBundle, paramString2, true, true);
  }
  
  public static void startTranslucentBrowserActivityForResult(Context paramContext, String paramString1, int paramInt, Bundle paramBundle, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).startTranslucentBrowserActivityForResult(paramContext, paramString1, paramInt, paramBundle, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public static void stopQZoneFloatObjectView(Context paramContext, Object paramObject)
  {
    if (paramContext != null)
    {
      if (paramObject == null) {
        return;
      }
      for (;;)
      {
        try
        {
          try
          {
            localObject = Class.forName("com.qzone.personalize.floatobject.ui.FloatItemView");
            paramContext = (Context)localObject;
          }
          catch (Exception paramContext) {}
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          Object localObject;
          continue;
        }
        try
        {
          localObject = ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).getQZonePluginClassLoader(paramContext);
          paramContext = ((ClassLoader)localObject).loadClass("com.qzone.personalize.floatobject.ui.FloatItemView");
          BasicClassTypeUtil.setClassLoader(true, (ClassLoader)localObject);
          if (paramContext == null)
          {
            QLog.e("QZLog", 1, "*createQZoneFloatObjectView load class fail");
            return;
          }
          paramContext.getMethod("stop", new Class[0]).invoke(paramObject, new Object[0]);
          return;
        }
        catch (ClassNotFoundException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      paramContext.printStackTrace();
      return;
    }
  }
  
  public static void stopQzonePublishQueueService(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext.stopService(new Intent(paramContext, QzonePluginPublishQueueProxyService.class));
  }
  
  public static void tryDelMediaStore(String paramString)
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[] { paramString });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void updateAlbumShortCut(@NonNull AppRuntime paramAppRuntime, String paramString1, String paramString2, Bitmap paramBitmap, long paramLong)
  {
    ThreadManager.post(new QZoneHelper.5(paramAppRuntime, paramString1, paramLong, paramString2, paramBitmap), 2, null, true);
  }
  
  private static void updateShortcut(Intent paramIntent, @NonNull AppRuntime paramAppRuntime, String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (!ShortcutUtils.a(paramAppRuntime.getApp(), new String[] { paramString1 })) {
      return;
    }
    deleteShortcut(paramIntent, paramAppRuntime, paramString2, paramBitmap);
    Thread.sleep(1000L);
    ((IQZoneHelperProxy)QRoute.api(IQZoneHelperProxy.class)).createShortcut(paramAppRuntime, paramIntent, paramString2, paramBitmap);
    Thread.sleep(1000L);
  }
  
  @RequiresApi(api=26)
  private static void updateShortcut_O(Bitmap paramBitmap, @NonNull AppRuntime paramAppRuntime, String paramString1, long paramLong, String paramString2)
  {
    paramAppRuntime = paramAppRuntime.getApp();
    ShortcutManager localShortcutManager = (ShortcutManager)paramAppRuntime.getSystemService(ShortcutManager.class);
    if (!isShortcutCreated_O(paramString1, localShortcutManager)) {
      return;
    }
    localShortcutManager.updateShortcuts(Arrays.asList(new ShortcutInfo[] { getAlbumShortcutInfo(paramAppRuntime, paramBitmap, paramString1, paramLong, paramString2, "update") }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper
 * JD-Core Version:    0.7.0.1
 */