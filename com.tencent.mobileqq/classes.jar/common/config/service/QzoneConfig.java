package common.config.service;

import alsg;
import alsh;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.common.config.provider.QZoneConfigProvider;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QzoneConfig
{
  public static final String ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT = "00:00";
  public static final float ALBUM_RECOM_EVENT_CLUSTERING_VAR_DEFAULT = 0.015F;
  public static final int ALBUM_RECOM_EVENT_CORE_PTS_NUM = 3;
  public static final String AUTO_RECOVERY_QZONE_COUNT = "atuoRecoveryQzoneCount";
  public static final String AVATAR_TIMEOUT = "avatar_timeout";
  public static final String ArchiveMemory_URL = "ArchiveMemoryUrl";
  public static final String BANNER_USE_WEBSO = "bannerUserWebso";
  public static final String CAN_REPORT_TASK_RUN_AT_FRONT = "can_report_task_run_at_front";
  public static final String CDN_PIC_START = "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/";
  public static final String COVER_BANNER_SWITCH = "CoverBannerSwitch";
  public static final String CUSTOM_VIP_MALL = "CustomVipMall";
  public static final String CUSTOM_VIP_PREVIEW = "CustomVipPreview";
  public static final String DEFAULTY_FOLLOW_FOLLOWERS_URL = "https://h5.qzone.qq.com/follow/feeds/{hostuin}/followfeeds?_wv=1027&_proxy=1";
  public static final String DEFAULT_CLOUD_PHOTO_DYNAMIC_ALBUM_URL = "https://h5.qzone.qq.com/dynamic/album/main?refer=h5maker&no_upload=1&tid={tid}&_wv=2098179";
  public static final int DEFAULT_DISAPPLEAR_WEISHI_ICON_ANIMATION_TIME = 300;
  public static final String DEFAULT_DYNAMIC_ALBUM_URL = "https://h5.qzone.qq.com/dynamic/album/tpl?source=1&_ws=9&preview=1&_wv=2098179&_dynamicalbum=1&_proxy=1";
  public static final String DEFAULT_DYNAMIC_NATIVE_ALBUM_URL = "https://h5.qzone.qq.com/dynamic/album/preview?_wv=2098177&source=1&tid=youth";
  public static final float DEFAULT_FACE_DETECT_EYE_SCALE = 0.17F;
  public static final float DEFAULT_FACE_DETECT_SMILE_OPEN_SCALE = 0.05F;
  public static final float DEFAULT_FACE_DETECT_SMILE_SCALE = 0.07F;
  public static final int DEFAULT_FACE_SCAN_SUPPORT_LOW_VERSION = 0;
  public static final int DEFAULT_FACE_TIMES_TO_CLUSTER = 10;
  public static final String DEFAULT_FEED_LOVE_DIAMOND_URL = "https://h5.qzone.qq.com/lover/vipDialog?_wv=16777219&_proxy=1&qzUseTransparentNavBar=1&friendUin={friendUin}";
  public static final int DEFAULT_FEED_PSVADV_SHOW_POS = 1;
  public static final String DEFAULT_FEED_REDPOCKET_SHUOSHUO_DELETE_MSG = "仅能删除说说，不能撤回红包。未领红包，在24小时后退款。";
  public static final String DEFAULT_FEED_YELLOW_DIAMOND_URL = "https://h5.qzone.qq.com/vip/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32&source={aid}&qua={qua}&_proxy=1";
  public static final int DEFAULT_FIRST_TIME_ENTER_FRIEND_FEEDS_NEED_GET_MAINPAGE = 1;
  public static final String DEFAULT_FOLLOW_FANS_URL = "https://h5.qzone.qq.com/qzone/follow/{hostuin}/fans?_wv=1027&_proxy=1&loginuin={uin}";
  public static final int DEFAULT_GET_PHOTO_BY_TIME_LINE_MAX_COUNT = 100;
  public static final String DEFAULT_INVITE_OPEN_LOVE_ZONE_URL = "https://h5.qzone.qq.com/lover/router?_wv=3&_proxy=1";
  public static final String DEFAULT_KEY_JUMP_TO_MORE_VIDEO_URL = "https://h5.qzone.qq.com/qzone/video?_wv=3&usewk=1&_proxy=1";
  public static final String DEFAULT_KEY_MARTET_TO_DOWNLOAD_WEISHI = "market://details?id=com.tencent.weishi";
  public static final String DEFAULT_KEY_WEB_TO_DOWNLOAD_WEISHI = "http://android.myapp.com/myapp/detail.htm?apkName=com.tencent.weishi";
  public static final String DEFAULT_MACHINELEARNING_DEFAULT_WHITE_LIST = String.valueOf(30);
  public static final int DEFAULT_MANUAL_LOAD_SWITCH_STATUS = 1;
  public static final long DEFAULT_MAX_P2V_VIDEO_DURING = 15000L;
  public static final String DEFAULT_ML_SO_DOWNLOAD_URL = "http://d3g.qq.com/sngapp/app/update/20171010175228_9573/libqzonemachinelearn.so";
  public static final String DEFAULT_ML_SO_MD5 = "f11baef39b2049ed2ae1bc2f8881b27a";
  public static final int DEFAULT_ML_WORKFLOW_RETRY_CNT = 4;
  public static final int DEFAULT_OPEN_WIDGET_AI = 1;
  public static final String DEFAULT_P2V_FUN_BLACK_LIST = "MI 3,GT-N7108,vivo Y51A,OPPO R6007,vivo Y31A,CAM-AL00,CAM-UL00,CAM-TL00,M821";
  public static final int DEFAULT_P2V_FUN_ENABLE = 1;
  public static final long DEFAULT_P2V_STORAGE_LIMIT = 62914560L;
  public static final int DEFAULT_P2V_SUPPORTED_CPU_FAMILY = 2;
  public static final float DEFAULT_PHOTO_GROUP_LIST_IMAGE_CROP_SPACE_RATIO = 0.25F;
  public static final String DEFAULT_PICTURE_VIEWER_DANMAKU_BLACK_LIST = "";
  public static final int DEFAULT_PICTURE_VIEWER_DANMAKU_DEFAULT_SWITCH = 0;
  public static final String DEFAULT_PICTURE_VIEWER_DANMAKU_GARY_RANGE = "00-30";
  public static final int DEFAULT_PICTURE_VIEWER_DANMAKU_LOWEST_CPU_LEVEL = 1;
  public static final int DEFAULT_PICTURE_VIEWER_DANMAKU_LOWEST_MEMORY_LEVEL = 1;
  public static final String DEFAULT_PRELOAD_BIG_PIC_ML_B_UPDATE = "";
  public static final int DEFAULT_PRELOAD_BIG_PIC_ML_ENABLE = 1;
  public static final float DEFAULT_PRELOAD_BIG_PIC_ML_THRESHOLD = 0.24F;
  public static final String DEFAULT_PRELOAD_BIG_PIC_ML_W_UPDATE = "";
  public static final int DEFAULT_QMUSIC_HLS_MAX_RETRY_TIMES = 3;
  public static final String DEFAULT_QZONE_FACE_SCAN_BLACKLIST = "";
  public static final int DEFAULT_QZONE_FACE_SCAN_SWITCH = 1;
  public static final int DEFAULT_RECENT_PHOTO_CAROUSEL_COUNT = 5;
  public static final int DEFAULT_RECOMMEND_COUNT_NUM_LIMIT = 999;
  public static final int DEFAULT_SECONDARY_SIM_QUERY = 2000;
  public static final int DEFAULT_SECONDARY_SIM_QUERY_DELAY = 2000;
  public static final int DEFAULT_SECONDARY_SIM_QUERY_STATUS = 0;
  public static final String DEFAULT_SECONDARY_VIDEO_HERO_PLAYER_LIBS_URL = "http://d3g.qq.com/sngapp/app/update/20161019162548_6237/libheroplayer_2.jar";
  public static final String DEFAULT_SELECT_TEMPLATE_DYNAMIC_ALBUM_URL = "https://h5.qzone.qq.com/dynamic/album/coverList?source=1&_ws=9&preview=1&_wv=2098179&_dynamicalbum=1&_proxy=1";
  public static final String DEFAULT_SHARE_ALBUM_INVITE_TO_FEEDS_URL = "https://h5.qzone.qq.com/manyPeopleAlbum/invite/{albumUin}/{albumid}?uin={loginUin}&_proxy=1&_wv=3&_wvv=4";
  public static final int DEFAULT_SHOW_WEISHI_ICON_ANIMATION_TIME = 300;
  public static final String DEFAULT_SMART_DNSSERVICE = "182.254.116.117|182.254.118.11";
  public static final long DEFAULT_TIME_DELAY_TO_GET_GUIDE_QBOSS_ADV = 86400000L;
  public static final int DEFAULT_TTPIC_ENTRY_OFF = 0;
  public static final int DEFAULT_TTPIC_ENTRY_ON = 1;
  public static final String DEFAULT_UPLOAD_CHANGEROUTE_RETCODE = "104,115,11,2";
  public static final int DEFAULT_UPLOAD_ENABLE_DOWNLOAD_SO = 0;
  public static final String DEFAULT_UPLOAD_NETWORK_UNAVAILABLE_RETCODE = "113,101,100";
  public static final int DEFAULT_USE_QQ_EMOTICON_COMMENT = 0;
  public static final String DEFAULT_VERTICAL_DOWNLOAD_PROGRESS_BACKGROUND_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20180412205352_WOHxRvJEI2.png";
  public static final String DEFAULT_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_CANCEL_MSG = "再想想";
  public static final String DEFAULT_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_MSG = "去微视解锁更多精彩视频";
  public static final String DEFAULT_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_OK_MSG = "去下载";
  public static final String DEFAULT_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_TITLE = "下载微视APP";
  public static final String DEFAULT_VERTICAL_VIDEO_PLUGIN_SIZE_TEXT = "插件约1M";
  public static final String DEFAULT_VERTICAL_VIDEO_PLUGIN_UPDATE_TIPS = "升级插件，体验精彩小视频";
  public static final int DEFAULT_VIDEO_ENABLE_ACTIVITY_DEFAULT_DETAIL_REPORT = 0;
  public static final String DEFAULT_VIDEO_HOST_ENABLE_HTTPDNSSERVICE = "vwecam.tc.qq.com|vliveachy.tc.qq.com|vqzone.tc.qq.com";
  public static final String DEFAULT_VIDEO_HOST_ENABLE_HTTPDNSSERVICE_PREPENDIP = "vwecam.tc.qq.com|vliveachy.tc.qq.com|vqzone.tc.qq.com";
  public static final int DETAIL_COMMENT_SOFT_ORDER_DEFAULT = 1;
  public static final String DISAPPLEAR_WEISHI_ICON_ANIMATION_TIME = "ShowWeishiIconAnimationTime";
  public static final String DOWNLOAD_TO_DEFAULT_TAB = "downloadToDefaultTab";
  public static final String EXCEPTION_REPORT_RDM = "exception_report_rdm";
  public static final String FACATE_LOCAL_DATE = "Facate_Local_Date";
  public static final String FLOAT_MODEL_BLACKLIST_DEFAULT_VALUE = "N5117,R8007,Coolpad 8720L,R7007,GN9000L,G620-L75,R2017,R6007,R831S,HM 1SC,Coolpad 8705,HUAWEI B199,Coolpad 9190L,HM 1SW,Coolpad 8730L,Coolpad 9190_T00,HS-E620M,HUAWEI G660-L075,Coolpad 5952,HUAWEI G730-L075,Coolpad 8729,HUAWEI C8817L,Bird LT01,Coolpad 5892,Coolpad 7620L,GN9004,HS-X8T,iPhone 6plus,K-Touch Tou ch 2,K-Touch Tou ch3,K-Touch Tou ch3w,Lenovo A560,Lenovo A890e,Lenovo B8080-HV,Lenovo S810t,LT18,MI 3C,N5110,Nokia_XL_4G,R2010,R8000,TCL-P688L,U558,ZTE Grand S II LTE,ZTE Q505T,ZTE Q802T,Coolpad Y60-C1,Coolpad 8702,BOWAY TL2000,Best sonny_LT986,BOWAY TL6000,Coolpad 5200S,Coolpad 5311,Coolpad 5315,DOOV T35,DOOV T60,HS-EG971,HS-EG978,HTC D516d,HUAWEI G6-L22,HUAWEI G620-L72,i6200S,KliTON,koobee M2,L-002,L823,L826,L827,Lingwin K1,LNV-Lenovo A505e,M7009,M811,MI 3W,R830S,ZTE Q801L,ZTE Q701C,YUSUN L63,TCL P631M,TCL J738M,T-smart L818,OUKI G5,OPSSON Q3,　　,MT2L03,VOTO VT898,AOLE,N5111,LA2-L,vtel X5,ETON T3,BOWAY TL500,T-smart L808,DOOV T90,CHM-TL00,thl L968,TCL J938M,2013022,HUAWEI G750-T01,vivo Y20T,vivo Y17T,vivo Y13T,vivo Y15T,vivo X3S W,U707T,R823T,R819T,N1T,Hol-T00,H8S,H30-U10,2014011,M351,HUAWEI G610-T11,vivo X3t,HUAWEI P6-T00,HUAWEI G700-U00,ETON I6,vivo Y11i T,HM NOTE 1TD";
  public static final String GDT_CGI_REPORT_HOST = "GdtCgiReportHost";
  public static final int HOMEPAGE_GUEST_DEFAULT_COVER_SHOW_DELAY_MS_VALUE = 3000;
  public static final String IS_PATCH_ENABLE = "isPatchEnable";
  public static final String IS_SHOW_SAFE_MODE = "isShowSafeMode";
  public static final String KEY_BUSINESSDATA = "key_businessfeeddata";
  public static final String KEY_MARTET_TO_DOWNLOAD_WEISHI = "DownloadWeishiFromMarket";
  public static final String KEY_WEB_TO_DOWNLOAD_WEISHI = "DownloadWeishiFromURL";
  public static final int LOADING = 1;
  public static final String LOADING_PHOTO_URL_SETTINGKEY = "QZONE_FLASH_URL";
  public static final String LOADING_PHOTO_URL_SETTINGKEY_BEGINTIME = "QZONE_FLASH_BEGINTIME";
  public static final String LOADING_PHOTO_URL_SETTINGKEY_ENDTIME = "QZONE_FLASH_ENDTIME";
  public static final int LOAD_FAIL = 3;
  public static final int LOAD_SUCC = 2;
  public static final String MAIN_GIF_SETTING = "GifSetting";
  public static final String MAIN_KEY_ARCHIVE_MEMORY = "archiveMemory";
  public static final String MAIN_KEY_BIZ = "BizFeeds";
  @Deprecated
  public static final String MAIN_KEY_CLICKREPORT = "ReportSetting";
  public static final String MAIN_KEY_CLIENTREPORT = "ClientReport";
  public static final String MAIN_KEY_CONTENT_PUBLISH = "ContentPublish";
  public static final String MAIN_KEY_DANMUKU = "Danmuku";
  public static final String MAIN_KEY_DOWNLOAD_SETTING = "DownloadSetting";
  public static final String MAIN_KEY_EASTEREGG = "EasterEgg";
  public static final String MAIN_KEY_EXTRA_CONFIG = "ExtraConfig";
  public static final String MAIN_KEY_FACADE = "QzoneFacade";
  public static final String MAIN_KEY_FEEDSPRE = "FeedsPre";
  public static final String MAIN_KEY_FEEDS_SEARCH = "FeedsSearch";
  public static final String MAIN_KEY_FEED_PIC_TEXT_CARD_VIEW = "FeedPicTextCardView";
  public static final String MAIN_KEY_GETUSERTIMELOGO = "QZoneGetUserTimeLogo";
  public static final String MAIN_KEY_GIFT = "Gift";
  public static final String MAIN_KEY_H5URL = "H5Url";
  public static final String MAIN_KEY_HOMEPAGE_BAR = "HomepageBar";
  public static final String MAIN_KEY_JUMPQZONE = "JumpQzone";
  public static final String MAIN_KEY_LIVE_VIDEO = "LiveSetting";
  public static final String MAIN_KEY_LOADING_PHOTO = "LoadingPhoto";
  public static final String MAIN_KEY_MEDIAFRAME = "MediaFrame";
  public static final String MAIN_KEY_MINI_VIDEO = "MiniVideo";
  public static final String MAIN_KEY_ML = "machinelearning";
  public static final String MAIN_KEY_NAVIGATOR_BAR = "NavigationBar";
  public static final String MAIN_KEY_OFFLINE_CACHE = "QzUrlCache";
  public static final String MAIN_KEY_OUTBOX = "OutBox";
  public static final String MAIN_KEY_PATCH = "Patch";
  public static final String MAIN_KEY_PERFORMANCE = "QZonePerformance";
  public static final String MAIN_KEY_PHOTOVIEW = "PhotoView";
  public static final String MAIN_KEY_PHOTO_AB_SVRLIST = "PhotoABSvrList";
  public static final String MAIN_KEY_PHOTO_ALBUM = "PhotoAlbum";
  public static final String MAIN_KEY_PHOTO_DOMAIN_IP = "PhotoDomainIP";
  public static final String MAIN_KEY_PHOTO_DOWNLOAD = "PhotoDownload";
  public static final String MAIN_KEY_PHOTO_EDITOR = "PhotoEditor";
  public static final String MAIN_KEY_PHOTO_SVRLIST = "PhotoSvrList";
  public static final String MAIN_KEY_PHOTO_UPLOAD = "PhotoUpload";
  public static final String MAIN_KEY_PM_MONITOR = "PerformanceMonitor";
  public static final String MAIN_KEY_PUBLISH_MOOD = "PublishMood";
  public static final String MAIN_KEY_PUSH = "Push";
  public static final String MAIN_KEY_QQ_EMOTICON_COMMENT = "QZoneCommentSetting";
  public static final String MAIN_KEY_QUN_ALBUM_SETTING = "QunAlbumSetting";
  public static final String MAIN_KEY_QZONECOVER = "QzoneCover";
  public static final String MAIN_KEY_QZONE_HOMEPAGE = "QzoneHomepage";
  public static final String MAIN_KEY_QZONE_SETTING = "QZoneSetting";
  public static final String MAIN_KEY_QZ_CUSTOM_FONT = "QzCustomFont";
  public static final String MAIN_KEY_REPORT = "qzoneReport";
  public static final String MAIN_KEY_SAFEMODE = "SafeModeSetting";
  public static final String MAIN_KEY_SCHEMA = "Schema";
  public static final String MAIN_KEY_SECRET_SHUOSHUO = "ScretShuoShuo";
  public static final String MAIN_KEY_TRIM = "TrimVideo";
  public static final String MAIN_KEY_UNPUBLISH_SHUO_SHUO = "UnpublishShuoShuo";
  public static final String MAIN_KEY_UPLOAD = "QzoneUploadSetting";
  public static final String MAIN_KEY_VERTICAL_VIDEO_LAYER = "VerticalVideoLayer";
  public static final String MAIN_KEY_VIDEOEDIT = "VideoEdit";
  public static final String MAIN_KEY_VIDEO_FLOAT = "QZVideo";
  public static final String MAIN_KEY_VIDEO_RECOMMEND_FLOAT = "videoRecommendFloat";
  public static final String MAIN_KEY_VIDEO_SRVLIST = "VideoSrvList";
  public static final String MAIN_KEY_VIDEO_SVRLIST = "VideoSvrList";
  public static final String MAIN_KEY_VOICE_MOOD = "VoiceMood";
  public static final String MAIN_KEY_WEBSO = "QzUrlCache";
  public static final String MAIN_KEY_WIDGET_AI = "WidgetAI";
  public static final String MAIN_KEY_WNSSETTINGS = "WNSSettting";
  public static final String MAIN_QZONE_LOG = "TraceLog";
  public static final String MAX_PENDING_REPORT_TASK_NUM = "max_pending_report_task_num";
  public static final String MAX_REPORT_TASK_PENDING_DAY = "max_report_task_pengding_day";
  public static final int ML_EXPOSED_MEDIA_UPPER_BOUND_DEFAULT = 50;
  public static final int ML_IS_PHOTO_TAG_FILLUP_ENABLED_DEFAULT = 1;
  public static final String ML_PACKAGE_FILE_MD5_DEFAULT = "1c3abb74834be02cb9538208c335993f,61223fa4cd476a914e63eae129bd2122,275731f4dce59486d14985f483c6bd53,c83c2577ef2f12057b51fc6f60f2661d,be740b33fe101c1e6b4df43fae5169c4";
  public static final int ML_PHOTO_TAG_FILLUP_AVAILABLE_PAGE = 7;
  public static final int ML_PHOTO_TAG_FILLUP_CPU_USAGE_SHRESHOLD_DEFAULT = 50;
  public static final int ML_PHOTO_TAG_FILLUP_INTEVALTIME_DEFAULT = 1000;
  public static final String ML_PHOTO_TAG_FILLUP_PHOTO_COUNT_DEFAULT = "30|40|50";
  public static final String NEED_TO_CHANGE_FOR_RAPID_COMMENT = "needToChangeForRapidComment";
  public static final int NOT_LOAD = 0;
  public static final int OFFLINE_DECODE_PHOTO_QUALITY_DEFAULT = 90;
  public static final int ONEKEY_BEAUTIFY_DEFAULT_IMAGE_SUPPORT_COUNT = 20;
  public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_DISABLE = 1;
  public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_ENABLE = 0;
  public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_IGNORE = 2;
  public static final int PRELOAD_HTML_PAGE_URL_MAX_COUNT_DEFAULT = 100;
  public static final String PRELOAD_SMALL_GAME_ALLOW_HOURS_DEFAULT = "1,2,3,4,5,6,7,8,9,10,14,15,16,17,18";
  public static final int PRELOAD_SMALL_GAME_HTML_ENABLE_DEFAULT = 1;
  public static final int PRELOAD_SMALL_GAME_INTERVAL_SECONDS_DEFAULT = 86400;
  private static final String PRINTCONFIG_TAG = "CMD_PRINT_WNS_CONFIG";
  public static final String QUEUE_PAUSEABLE = "queue_pausable";
  public static final String QUEUE_PAUSE_TIMEOUT = "queue_timeout";
  public static final String QZONE_ALBUM_COMMENTS_URL = "QZoneAlbumComments";
  public static final String QZONE_ALBUM_LOAD_MAP_SDK = "LoadMapSdk";
  public static final String QZONE_ALBUM_VISITORS_URL = "QZoneAlbumVisitors";
  public static final String QZONE_CALL_APP_URL_LIST_DEFAULT = "['https?://intent\\.music\\.163\\.com.+orpheus.*']";
  public static final String QZONE_CONFIG_SECONDARY_KEY_LABEL_TEXT = "photocategorylabeltext";
  public static final String QZONE_CONFIG_SECONDARY_KEY_LOCAL_PHOTO_MARKER_SWITCH = "localPhotoMarkerSwitch";
  public static final String QZONE_CONFIG_SECONDARY_KEY_LOCAL_PHOTO_PRESCAN_NUMBER = "localPhotoPreScanNumber";
  public static final String QZONE_CONFIG_SECONDARY_KEY_LOCATION_TEXT = "photocategorylocationtext";
  public static final String QZONE_CONFIG_SECONDARY_KEY_NEED_GETPICMARKER = "uploadneedgetpicmarker";
  public static final String QZONE_CONFIG_SECONDARY_KEY_NEED_SHOWLBSLIST = "needshowlibslist";
  public static final String QZONE_CONFIG_SECONDARY_KEY_PORTRAIT_TEXT = "photocategoryportraittext";
  public static final String QZONE_CONFIG_SECONDARY_KEY_PRESCAN_NUMBER = "localPhotoMarkerPreScanNumber";
  public static final String QZONE_EVENT_TAG_DEFAULT_PIC_URL = "QZoneEventTag_EventTagDefaultPicUrl";
  public static final String QZONE_EVENT_TAG_FEED_WRITE_MOOD_TEXT = "QZoneEventTag_EventTagFeedMoodText";
  public static final String QZONE_EVENT_TAG_MAIN_KEY = "QZoneEventTag";
  public static final String QZONE_EVENT_TAG_REQUEST_INPUT_TIME = "TagRequestInpuTime";
  public static final String QZONE_EVENT_TAG_REQUEST_TEXT_LENGTH = "TagRequestTextLenth";
  public static final String QZONE_FAMOUS_VIDEO_QZONE_DOWNLOAD = "QzoneFamousVideoDownload";
  public static final String QZONE_HISTORY_EVENT_TAG_CACHE_NUM = "QZoneEventTag_HistoryEventTagCacheNum";
  public static final String QZONE_IMAGE_MANAGER_GIF_PRE_DOWNLOAD = "QzoneImageManager_GifPreDownload";
  public static final String QZONE_IMAGE_MANAGER_HABO_REPORT_SAMPLE_RANGE = "QzoneImageManager_HaboReportSampleRange";
  public static final String QZONE_IMAGE_MANAGER_MAIN_KEY = "QzoneImageManager";
  public static final String QZONE_IMAGE_MANAGER_OPEN_GET_IMAGE_SUCCESS_RECORDER = "QzoneImageManager_OpenGetImageSuccessRecorder";
  public static final String QZONE_MOOD_EVENT_TAG_H5_URL = "qzoneMoodEventTagH5Url";
  public static final String QZONE_MOOD_EVENT_TAG_JUMP_PAGE = "QzoneSetting";
  public static final String QZONE_MOOD_EVENT_TAG_USE_H5 = "QzoneMoodEventTagUseH5";
  public static final String QZONE_RECOMMEND_EVENT_TAG_DESC_TRUNCATE_END_NUM = "QZoneEventTag_RecommendEventTagDescTruncateEndNum";
  public static final int QZONE_REG_STRING_MATCHER_LRU_MAP_SIZE_DEFAULT = 50;
  public static final String QZONE_SHOW_BREEZE_DEFAULT_BLACK_LIST = "";
  public static final String QZONE_UGC_PERMISSION_USERS_LIST_URL = "QZoneUgcPermissionUsersUrl";
  public static final String QZONE_VIDEO_LAYER_PASTER_VIDEO_ADV_REPLAY_TIME_STAMP_KEY = "PremovieAdvReplayTimeInterval";
  public static final String QZONE_VIDEO_LAYER_SHOW_ADV_TIPS_DURATION_SECONDARY_KEY = "VideoLayerShowAdvTipsDuration";
  public static final String QZONE_VIDEO_MAIN_KEY = "QZVideo";
  public static final String QZPB_IP_VIDEO_HOST = "video_host_qzpb";
  public static final String QZVV_IP_VIDEO_HOST = "video_host_qzvv";
  public static final String RECENT_PHOTO_BLOCK_PATHS_DEFAULT = "MagazineUnlock";
  public static final int RECENT_PHOTO_LIMIT_MIN_SIZE_DEFAULT = 20480;
  public static final int RECENT_PHOTO_LIMIT_MIN_WIDTH_DEFAULT = 100;
  public static final int RECENT_PHOTO_MAX_NUM_DEFAULT = 200;
  public static final String SECONDART_KEY_ALBUM_RECOM_UPLOAD_BAR_COUNT_LIMIT_LEVEL = "AlbumRecomUploadLimitedLevel";
  public static final String SECONDARY_ACC_REPORT_COUNT = "AccReportCount";
  public static final String SECONDARY_ACC_REPORT_INTERVAL = "AccReportInterval";
  public static final String SECONDARY_ACC_REPORT_SAMPLES = "AccReportSamples";
  public static final String SECONDARY_ACTIVEMOODBTN_ENTER_PHOTOUPLOAD = "activeMoodBtnEnterPhotoUpload";
  public static final String SECONDARY_ACTIVITY_SWITCH_ACC_REPORT_SAMPLES = "ActivitySwitchAccReportSamples";
  public static final String SECONDARY_AD_FEED_EXPOSE_TIME = "ADFeedExposeTime";
  public static final String SECONDARY_AIO_FRIEND_FEED_ITEM_BLOG_TITLE_MAX_LENGTH = "qzoneAioFriendFeedBlogTitleMaxLength";
  public static final String SECONDARY_AIO_FRIEND_FEED_ITEM_LOGO_WATERMARK_IMG_URL = "qzoneAioFriendFeedLogoWaterImgUrl";
  public static final String SECONDARY_AIO_FRIEND_FEED_ITEM_NICKNAME_MAX_LENGTH = "qzoneAioFriendFeedNicknameMaxLength";
  public static final String SECONDARY_AIO_FRIEND_FEED_ITEM_PIC_BLOG_TILTE_MAX_LENGTH = "qzoneAioFriendFeedPicBlogTitleMaxLength";
  public static final String SECONDARY_ALBUM_BANNER_DP_PROCESS_GROUP_SIZE = "secondary_album_banner_dp_process_group_size";
  public static final String SECONDARY_ALBUM_HISTORY_GROUP_ACTIVITY_SUB_TITLE = "historyLocalPhotoActivitySubTitle";
  public static final String SECONDARY_ALBUM_HISTORY_GROUP_ACTIVITY_TITLE = "historyLocalPhotoActivityTitle";
  public static final String SECONDARY_ALBUM_LIKE_LIST = "AlbumLikeList";
  public static final String SECONDARY_ALBUM_PHOTO_CHECK_MAX_DAYS = "secondary_album_photo_check_max_days";
  public static final String SECONDARY_ALBUM_PHOTO_CHECK_TIME_DISTANCE = "secondary_album_photo_group_check_time_distance";
  public static final String SECONDARY_ALBUM_PHOTO_ENBALE = "secondary_album_photo_enbale";
  public static final String SECONDARY_ALBUM_PHOTO_GROUP_BANNER = "secondary_album_photo_group_banner";
  public static final String SECONDARY_ALBUM_PHOTO_GROUP_BANNER_PLAY_PHOTO = "secondary_album_photo_group_banner_play_photo";
  public static final String SECONDARY_ALBUM_PHOTO_GROUP_BANNER_VIDEO = "secondary_album_photo_group_banner_video";
  public static final String SECONDARY_ALBUM_PHOTO_GROUP_CITY_TIME_LIMIT = "secondary_album_photo_group_city_time_limit";
  public static final String SECONDARY_ALBUM_PHOTO_GROUP_INTERVAL_HOUR = "secondary_album_photo_group_interval_hour";
  public static final String SECONDARY_ALBUM_PHOTO_GROUP_MAX_UPLOAD_PHOTO_NUM_HIGH = "secondary_album_photo_group_max_photo_num_high";
  public static final String SECONDARY_ALBUM_PHOTO_GROUP_MAX_UPLOAD_PHOTO_NUM_LOW = "secondary_album_photo_group_max_photo_num_low";
  public static final String SECONDARY_ALBUM_PHOTO_GROUP_MAX_UPLOAD_PHOTO_NUM_MIDDLE = "secondary_album_photo_group_max_photo_num_middle";
  public static final String SECONDARY_ALBUM_PHOTO_GROUP_MIN_PHOTOS_TO_VIDEO = "secondary_album_photo_group_min_photoS_to_video";
  public static final String SECONDARY_ALBUM_PHOTO_GROUP_TODAY_IN_LAST_YEAR_SHOW_TIME = "secondary_album_photo_group_today_in_last_year_show_time";
  public static final String SECONDARY_ALBUM_PHOTO_GROUP_VALID_DISTANCE = "secondary_album_photo_group_valid_distance";
  public static final String SECONDARY_ALBUM_PHOTO_HIGH_DEVICE_FIRST_GET_SMART_INFO_NUM = "albumRecommendHighDeviceFirstGetSmartInfoNum";
  public static final String SECONDARY_ALBUM_PHOTO_LOW_DEVICE_FIRST_GET_SMART_INFO_NUM = "albumRecommendLowDeviceFirstGetSmartInfoNum";
  public static final String SECONDARY_ALBUM_PHOTO_MIDDLE_DEVICE_FIRST_GET_SMART_INFO_NUM = "albumRecommendMiddleDeviceFirstGetSmartInfoNum";
  public static final String SECONDARY_ALBUM_PHOTO_MIN_PHOTO_CNT_PER_GROUP = "secondary_album_photo_min_photo_cnt_per_group";
  public static final String SECONDARY_ALBUM_PHOTO_PRELOAD_MAX_BITMAP = "secondary_gif_edit_preload_max_bitmap";
  public static final String SECONDARY_ALBUM_PHOTO_REQ_ALL_GROUP_VERSION = "PhotoRecommendReqAllGroupVersion";
  public static final String SECONDARY_ALBUM_PHOTO_SHOW_END_HOUR = "secondary_album_photo_show_end_hour";
  public static final String SECONDARY_ALBUM_PHOTO_SHOW_START_HOUR = "secondary_album_photo_show_start_hour";
  public static final String SECONDARY_ALBUM_SHOW_MODE = "themePhotoDefaultMode";
  public static final String SECONDARY_ALBUM_UPLOAD_PLUS_ENTRY_TEXT = "AlbumUploadPlusEntryText";
  public static final String SECONDARY_ALBUM_VISITOR_LIST = "AlbumVisitorList";
  public static final String SECONDARY_ALBUM_WATER_PIC = "AlbumWaterPic";
  public static final String SECONDARY_ATUSER_INTERACTIVE_MAX = "FriendMaxSelectCountComment";
  public static final String SECONDARY_ATUSER_PUBLISH_UGC_MAX = "FriendMaxSelectCount";
  public static final String SECONDARY_AUDIO_MAX_BITRATE = "AudioMaxBitrate";
  public static final String SECONDARY_AUDIO_MAX_SAMPLE = "AudioMaxSample";
  public static final String SECONDARY_AVATAR_PREVIEW = "AvatarPreview";
  public static final String SECONDARY_AVATAR_SETTING = "AvatarSetting";
  public static final String SECONDARY_BANNER_PHOTO_GIF_RATE_DIF = "BannerPhotoGifRateDif";
  public static final String SECONDARY_BANNER_PHTO_GIF_VALID_CNT = "banner_phto_gif_valid_cnt";
  public static final String SECONDARY_BARRAGE_EFFECT_PREVIEW = "CommentBubblePreview";
  public static final String SECONDARY_BG_FM_BROCAST_MANAGER_URL = "BgFMBrocastManagerUrl";
  public static final String SECONDARY_BG_FM_MANAGER_URL = "BgFMManagerUrl";
  public static final String SECONDARY_BG_MUSIC_MANAGER_URL = "BgMusicManagerUrl";
  public static final String SECONDARY_BITMAP_MEMORY_THRESHOLD = "BitmapMemoryThreshold";
  public static final String SECONDARY_BLOB_CACHE_ENABLE = "BlobCacheEnable";
  public static final String SECONDARY_BLOG_EDIT = "BlogEdit";
  public static final String SECONDARY_BUY_FEED_URL = "BuyFeedUrl";
  public static final String SECONDARY_BUY_FONT_URL = "FloatingViewForFontPay";
  public static final String SECONDARY_CALL_MUSIC_WNS = "CallMusicWNS";
  public static final String SECONDARY_CALL_MUSIC_WNS_COREANDMEM = "CallMusicWNSCoreAndMem";
  public static final String SECONDARY_CALL_QZONE_WNS = "CallQZoneWNS";
  public static final String SECONDARY_CALL_QZONE_WNS_FROM_LIVE_PUSH_VERSION = "CallQZoneWNSFromLivePushVersion";
  public static final String SECONDARY_CALL_QZONE_WNS_FROM_PUSH = "CallQZoneWNSFromPush";
  public static final String SECONDARY_CALL_QZONE_WNS_FROM_PUSH_CTRLFLAG = "CallQZoneWNSFromPushCtrlFlag";
  public static final String SECONDARY_CALL_QZONE_WNS_FROM_PUSH_CTRLFLAG2 = "CallQZoneWNSFromPushCtrlFlag2";
  public static final String SECONDARY_CALL_QZONE_WNS_FROM_PUSH_FAILCNT = "CallQZoneWNSFromPushFailCnt";
  public static final String SECONDARY_CALL_QZONE_WNS_FROM_PUSH_REPORT = "CallQZoneWNSFromPushReport";
  public static final String SECONDARY_CALL_QZONE_WNS_FROM_PUSH_TIMEOUT = "CallQZoneWNSFromPushTimeout";
  public static final String SECONDARY_CALL_QZONE_WNS_FROM_PUSH_TIMEOUTCNT = "CallQZoneWNSFromPushTimeoutCnt";
  public static final String SECONDARY_CALL_QZONE_WNS_FROM_PUSH_VERSION = "CallQZoneWNSFromPushVersion";
  public static final String SECONDARY_CAN_QUICK_OPEN_CAMERA = "CanQuickOpenCamera";
  public static final String SECONDARY_CAN_QUICK_OPEN_CAMERA_ANIM = "CanQuickOpenCameraAnim";
  public static final String SECONDARY_CARD_LIST = "CardList";
  public static final String SECONDARY_CARD_PREVIEW = "CardPreview";
  public static final String SECONDARY_CARD_STORE = "CardStore";
  public static final String SECONDARY_CATEGORY_MY_TRACKS_DISPLAY = "CategoryMyTracksDisplay";
  public static final String SECONDARY_CATEGORY_MY_TRACKS_URL = "CategoryMyTracksUrl";
  public static final String SECONDARY_CHANGE_COVER_URL = "ChangeCover";
  public static final String SECONDARY_CHECK_LIVE_M3U8_INTERVAL = "CheckLiveM3U8Interval";
  public static final String SECONDARY_CHECK_LIVE_M3U8_REPLAY_DIFF = "CheckLiveM3U8RePlayDiff";
  public static final String SECONDARY_CHECK_LIVE_M3U8_TIMES_TO_SHOW_LEAVE = "CheckLiveM3U8TimesToShowLeave";
  public static final String SECONDARY_CHECK_M3U8_TIMES_LIMIT = "CheckM3U8TimesLimit";
  public static final String SECONDARY_CIRCLE_PLAY_SECOND_FAKEFEED_VALIDTIME = "CirclePlaySecondFakeFeedValidTime";
  public static final String SECONDARY_CLICKREPORT_COUNT = "TraceReportCount";
  public static final String SECONDARY_CLICKREPORT_IMEDIATELY = "LpReportImediagely";
  public static final String SECONDARY_CLICKREPORT_INTERVAL = "TraceReportInterval";
  public static final String SECONDARY_CLICKREPORT_SAMPLE = "TraceReportSamples";
  public static final String SECONDARY_CLICKREPORT_URL = "TraceReportURL";
  public static final String SECONDARY_CLIENT_COMPRESS = "ClientCompress";
  public static final String SECONDARY_CLOUD_PHOTO_DYNAMIC_ALBUM_URL = "cloudPhotoDynamicAlbumUrl";
  public static final String SECONDARY_COMMENT_REPLY_REPORT = "CommentReplyReport";
  public static final String SECONDARY_COMMENT_REPLY_REPORT_KEY = "CommentReplyReportKey";
  public static final String SECONDARY_COMMENT_SETTING = "SeeMyCommentPermissionSetting";
  public static final String SECONDARY_COMPRESS_QUALITY_LIMIT = "CompressQualityLimit";
  public static final String SECONDARY_COMPRESS_SIZE_LIMIT = "CompressSizeLimit";
  public static final String SECONDARY_COMPRESS_TO_WEBP = "CompressToWebp";
  public static final String SECONDARY_COPY_FILE_SIZE_THRESHOLD = "CopyFileSizeThreshold";
  public static final String SECONDARY_COVER_DIAMOND_REDPCOKET_ICON = "secondCoverDiamondRedPocketIcon";
  public static final String SECONDARY_COVER_LIST = "CoverList";
  public static final String SECONDARY_COVER_PREVIEW = "CoverPreview";
  public static final String SECONDARY_COVER_REDPCOKET_ICON = "secondCoverRedPocketIcon";
  public static final String SECONDARY_COVER_REDPCOKET_WARN_POP_BG = "secondCoverRedPocketPopBg";
  public static final String SECONDARY_COVER_STORE = "CoverStore";
  public static final String SECONDARY_CREATE_GET_PHOTO_QULATITY_INTERVAL_TIME = "CreatePhotoQulityIntervalTime";
  public static final String SECONDARY_CREATE_GIF_HIGH_DEVICE_MEMORY = "createGifHighDeviceMaxMemory";
  public static final String SECONDARY_CREATE_GIF_HIGH_DEVICE_SIZE = "createGifHighDeviceSize";
  public static final String SECONDARY_CREATE_GIF_LOW_DEVICE_MEMORY = "createGifLowDeviceMaxMemory";
  public static final String SECONDARY_CREATE_GIF_LOW_DEVICE_SIZE = "createGifLowDeviceSize";
  public static final String SECONDARY_CREATE_GIF_MAX_NUM = "AutoCreateGifMaxNum";
  public static final String SECONDARY_CREATE_GIF_MIDDLE_DEVICE_MEMORY = "createGifMiddleDeviceMaxMemory";
  public static final String SECONDARY_CREATE_GIF_MIDDLE_DEVICE_SIZE = "createGifMiddleDeviceSize";
  public static final String SECONDARY_CREATE_GIF_PHOTO_CUT_FRAMES_NUMBER = "CreateGifPhotoCutFramesNumber";
  public static final String SECONDARY_CREATE_GIF_PHOTO_FRAMES_LIMIT = "CreateGifPhotoFrameTimesLimit";
  public static final String SECONDARY_CREATE_GIF_PHOTO_FRAME_TIME1 = "localPhotoCreateGifPhotoFrameTime1";
  public static final String SECONDARY_CREATE_GIF_PHOTO_FRAME_TIME2 = "localPhotoCreateGifPhotoFrameTime2";
  public static final String SECONDARY_CREATE_GIF_PHOTO_GIF_FILE_MAX_SIZE = "CreateGifGifFileMaxSize";
  public static final String SECONDARY_CREATE_GIF_PHOTO_GIF_SIZE = "localPhotoCreateGifPhotoGifSize";
  public static final String SECONDARY_CREATE_GIF_PHOTO_INTERVAL_TIME = "CreateGifPhotoIntervalTime";
  public static final String SECONDARY_CREATE_GIF_PHOTO_MAX_NUM = "localPhotoCreateGifPhotoMaxNum";
  public static final String SECONDARY_CREATE_GIF_PHOTO_MIN_NUM = "localPhotoCreateGifPhotoMinNum";
  public static final String SECONDARY_CREATE_GIF_SIZE_FOR_LONG_EDGE = "CreateGifGifSizeForLongEdge";
  public static final String SECONDARY_CROP_GIF_EDGEBOTTOM = "GifEdgeBottom";
  public static final String SECONDARY_CROP_GIF_EDGELEFT = "GifEdgeLeft";
  public static final String SECONDARY_CROP_GIF_EDGERIGHT = "GifEdgeRight";
  public static final String SECONDARY_CROP_GIF_EDGETOP = "GifEdgeTop";
  public static final String SECONDARY_CUSTOM_FONT_SHOW = "DiyFontShow";
  public static final String SECONDARY_DB_OPTIMIZE_SYNC = "DbOptiSync";
  public static final String SECONDARY_DELAY_QUIT_POC = "delayQuitPOC";
  public static final String SECONDARY_DETAIL_COMMENT_SOFT_ORDER = "DetailCommentSoftOrder";
  public static final String SECONDARY_DETAIL_MAXPICSHOW_NUM = "DetailMaxPicShowNum";
  public static final String SECONDARY_DISABLE_FORBID_COMMENT = "DisableForbidComment";
  public static final String SECONDARY_DISABLE_SHOW_VIP_INFO = "DisableVipInfoOnFriendFeed";
  public static final String SECONDARY_DOWNLOAD_ACCESS_PORT_LIST = "DownloadAccessPortList";
  public static final String SECONDARY_DOWNLOAD_BACKUP_IP = "DownloadBackupIP";
  public static final String SECONDARY_DOWNLOAD_BACKUP_IP_A = "DownloadBackupIP_a";
  public static final String SECONDARY_DOWNLOAD_BACKUP_IP_B = "DownloadBackupIP_b";
  public static final String SECONDARY_DOWNLOAD_BACKUP_IP_VIDEO = "DownloadBackupIPVideo";
  public static final String SECONDARY_DOWNLOAD_CUSTOMDNS_ENABLE = "DownloadCustomDnsEnable";
  public static final String SECONDARY_DOWNLOAD_DIRECT_IP = "DownloadDirectIP";
  public static final String SECONDARY_DOWNLOAD_DIRECT_IP_A = "DownloadDirectIP_a";
  public static final String SECONDARY_DOWNLOAD_DIRECT_IP_B = "DownloadDirectIP_b";
  public static final String SECONDARY_DOWNLOAD_DIRECT_IP_VIDEO = "DownloadDirectIPVideo";
  public static final String SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP = "photo_backupIplist";
  public static final String SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP_A = "photo_backupIplist_a";
  public static final String SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP_B = "photo_backupIplist_b";
  public static final String SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP_VIDEO = "video_backupIplist";
  public static final String SECONDARY_DOWNLOAD_EXTRA_DIRECT_IP_VIDEO = "video_masterIplist";
  public static final String SECONDARY_DOWNLOAD_EXTRA_MASTER_IP = "photo_masterIplist";
  public static final String SECONDARY_DOWNLOAD_EXTRA_MASTER_IP_A = "photo_masterIplist_a";
  public static final String SECONDARY_DOWNLOAD_EXTRA_MASTER_IP_B = "photo_masterIplist_b";
  public static final String SECONDARY_DOWNLOAD_FONT_ANYWAY = "DownloadFontAnyway";
  public static final String SECONDARY_DOWNLOAD_IPVALIDTIME = "DownloadIPValidTime";
  public static final String SECONDARY_DOWNLOAD_KP_DOMAIN_LIST = "KpDomainList";
  public static final String SECONDARY_DOWNLOAD_LINK_REPORT_CACHE_COUNT = "DownloadLinkReportCacheCount";
  public static final String SECONDARY_DOWNLOAD_LINK_REPORT_DOMAIN_LIST = "DownloadReportDomainList";
  public static final String SECONDARY_DOWNLOAD_LINK_REPORT_ENABLE = "DownloadLinkReportEnable";
  public static final String SECONDARY_DOWNLOAD_LINK_REPORT_SAMPLE = "DownloadLinkReportSample";
  public static final String SECONDARY_DOWNLOAD_OPTIMUMIP_QZPB_IP_VIDEO = "qzpb.qq.com";
  public static final String SECONDARY_DOWNLOAD_OPTIMUMIP_QZVV_IP_VIDEO = "optimumip_qzvv";
  public static final String SECONDARY_DOWNLOAD_QZONE_APP_URL = "DownloadQZoneAppUrl";
  public static final String SECONDARY_DOWNLOAD_QZONE_CLIENT = "DownloadQzoneClient";
  public static final String SECONDARY_DOWNLOAD_RETRY_TIMES = "RetryTimes";
  public static final String SECONDARY_DOWNLOAD_SWITCH_TIMES = "SwitchTimes";
  public static final String SECONDARY_DOWNSONG_QQMUSIC = "DownloadSongInQQMusic";
  public static final String SECONDARY_DOWN_QQMUSIC_CLIENT = "DownloadQQMusicClient";
  public static final String SECONDARY_DROPFRAME_DROPCOUNT = "DropFrame_DropCount";
  public static final String SECONDARY_DROPFRAME_INTERVAL = "DropFrame_Interval";
  public static final String SECONDARY_DROPFRAME_STACK_EVENTSAMPLERATIO = "Dropframe_Stack_EventSampleRatio";
  public static final String SECONDARY_DROPFRAME_STACK_THRESHOLD = "DropFrame_Stack_Threshold";
  public static final String SECONDARY_DROPFRAME_STACK_USERSAMPLERATIO = "DropFrame_Stack_UserSampleRatio";
  public static final String SECONDARY_DYNAMIC_ALBUM_PHOTO_SELECT_NUM = "setDynamicAlbumSelectLimit";
  public static final String SECONDARY_DYNAMIC_ALBUM_URL = "dynamicAlbumUrl";
  public static final String SECONDARY_DYNAMIC_CLOSE_DYNAMIC = "closedynamicAlbum";
  public static final String SECONDARY_DYNAMIC_COVER_PREVIEW_DEFAULT = "h5.qzone.qq.com/bgstore/dynamiccover";
  public static final String SECONDARY_DYNAMIC_COVER_PREVIEW_URL = "dynamicCoverPreviewUrl";
  public static final String SECONDARY_DYNAMIC_COVER_PREVIEW_URL_KEYWORD = "dynamicCoverPreviewKeyword";
  public static final String SECONDARY_DYNAMIC_COVER_PREVIEW_URL_KEYWORD_DEFAULT = "tplId=";
  public static final String SECONDARY_EASTER_EGG = "EasterEgg";
  public static final String SECONDARY_EGGPHOTO_LAYERTYPE = "EggPhotoLayerType";
  public static final String SECONDARY_EGG_IMAGE_FIRST_RED_LASTED_TIME = "RedDotAutoDisappearedTime";
  public static final String SECONDARY_EGG_IMAGE_RED_FREQUENCY = "RedDotAppearFrequency";
  public static final String SECONDARY_ENABLE_COLOR = "EnableColor";
  public static final String SECONDARY_ENABLE_SUPER_RESOLUTION = "enableSuperResolution";
  public static final String SECONDARY_ENABLE_TEMPLATESHUOSHUO = "enable_templateshuoshuo";
  public static final String SECONDARY_ENABLE_VOICE_SHUOSHUO_H5 = "secondary_enable_voice_shuoshuo_h5";
  public static final String SECONDARY_ENTER_LIVE_ROOM_AFTER_SECONDS = "EnterLiveRoomAfterSeconds";
  public static final String SECONDARY_EXCEPTION_REPORT_USESAMPLE = "exceptionReportUseSample";
  public static final String SECONDARY_EXCLUDE_PERMISION_PAGE = "ExcludePermisionPage";
  public static final String SECONDARY_EXIF_ENABLE = "ExifEnable";
  public static final String SECONDARY_EXIT_IF_FORGROUD = "ExitIfForgroud";
  public static final String SECONDARY_FACADESTORE_URL = "FacadeStore";
  public static final String SECONDARY_FACADE_STORE = "FacadeStore";
  public static final String SECONDARY_FACE_DETECT_EYE_SCALE = "face_detect_eye_scale";
  public static final String SECONDARY_FACE_DETECT_SMILE_OPEN_SCALE = "face_detect_smile_open_scale";
  public static final String SECONDARY_FACE_DETECT_SMILE_SCALE = "face_detect_smile_scale";
  public static final String SECONDARY_FACE_TIMES_TO_CLUSTER = "face_times_to_cluster";
  public static final String SECONDARY_FAKE_FEED_INVALID_TIME = "FakeFeedInvalidTime";
  public static final String SECONDARY_FAKE_FEED_RETRY_TIMEOUT = "FakeFeedRetryTime";
  public static final String SECONDARY_FAMOUS_HOME_PAGE = "FamousHomePage";
  public static final String SECONDARY_FAMOUS_HOME_SHARE_FACE_URL = "FamousHomeShareFaceUrl";
  public static final String SECONDARY_FAMOUS_HOME_SHARE_H5 = "FamousHomeShareH5";
  public static final String SECONDARY_FAMOUS_HOME_SHARE_QRCODE = "FamousHomeShareQRCODE";
  public static final String SECONDARY_FAMOUS_HOME_SHARE_SCHEMA = "FamousHomeShareSchema";
  public static final String SECONDARY_FAMOUS_WHITE_LIST = "famousWhiteList";
  public static final String SECONDARY_FEEDSPRE_RESTRICT_FLAG = "RestrictFlag";
  public static final String SECONDARY_FEEDS_SHOW_MOOD_ENTRY = "FeedsShowMoodEntry";
  public static final String SECONDARY_FEEDS_SHOW_PHOTO_BUBBLE = "FeedsShowPhotoBubble";
  public static final String SECONDARY_FEEDTEXT_MAXLINE = "FeedTextMaxLine";
  public static final String SECONDARY_FEEDTEXT_MAX_PACK = "FeedSummaryMaxMaxLine";
  public static final String SECONDARY_FEEDTEXT_MIN_PACK = "FeedSummaryMinMaxLine";
  public static final String SECONDARY_FEEDTEXT_PACK_OR_UNPACK = "FeedSummaryExpandDirect";
  public static final String SECONDARY_FEEDTEXT_PACK_SHOW_LINE = "FeedSummaryShowNumUnExpand";
  public static final String SECONDARY_FEED_ACTION_REPORT_SESSION_SIZE = "FeedActionReportSessionSize";
  public static final String SECONDARY_FEED_AVATAR_ICON = "secondFeedAvatarIcon";
  public static final String SECONDARY_FEED_DETAIL_RECOMM_VIDEO_COUNT = "feedDetailRecommVideoCount";
  public static final String SECONDARY_FEED_FAKE_REDPOCKET_PIC = "secondFeedFakeRedPocketPic";
  public static final String SECONDARY_FEED_FAKE_REDPOCKET_PIC_HEIGHT = "secondFeedFakeRedPocketPicHeight";
  public static final String SECONDARY_FEED_FAKE_REDPOCKET_PIC_WIDTH = "secondFeedFakeRedPocketPicWidth";
  public static final String SECONDARY_FEED_GIF_ANGLE_DIFF_SENSOR_TYPE = "GifAngleDiffSensorType";
  public static final String SECONDARY_FEED_GIF_ANGLE_LOOP_TYPE = "GifAngleLoopType";
  public static final String SECONDARY_FEED_GIF_ANGLE_TO_FACTOR = "GifAngleToFactor";
  public static final String SECONDARY_FEED_GIF_MAX_FACTOR = "GifMaxFactor";
  public static final String SECONDARY_FEED_GIF_PERFORMANCE_DEVICES_LIST = "GifPerformanceDevicesList";
  public static final String SECONDARY_FEED_GIF_PERFORMANCE_LEVEL_HIGH_CPU_FEQUENCY = "GifPerformanceLevelHighCpuFequency";
  public static final String SECONDARY_FEED_GIF_PERFORMANCE_LEVEL_HIGH_RAM_SIZE = "GifPerformanceLevelHighRamSize";
  public static final String SECONDARY_FEED_GIF_PERFORMANCE_LEVEL_MIDDLE_CPU_FEQUENCY = "GifPerformanceLevelMiddleCpuFequency";
  public static final String SECONDARY_FEED_GIF_PERFORMANCE_LEVEL_MIDDLE_RAM_SIZE = "GifPerformanceLevelMiddleRamSize";
  public static final String SECONDARY_FEED_GIF_PLAY_SWITCH = "GifPlaySwitch";
  public static final String SECONDARY_FEED_GIF_SENSOR_CONTROL = "GifSensorControl";
  public static final String SECONDARY_FEED_GIF_SENSOR_MODEL = "GifChooseModel";
  public static final String SECONDARY_FEED_GIF_SENSOR_MODEL2_MAX_FACTOR = "GifModel2MaxFactor";
  public static final String SECONDARY_FEED_GIF_SENSOR_MODEL_MAX_COUNT = "GifSensorModelMaxCount";
  public static final String SECONDARY_FEED_LOVE_DIAMOND = "FeedLoveDiamond";
  public static final String SECONDARY_FEED_PSVADV_SHOW_POS = "PsvAdvIndex";
  public static final String SECONDARY_FEED_REDPOCKET_SHUOSHUO_DELETE_MSG = "RedPocketShuoShuoDeleteMsg";
  public static final String SECONDARY_FEED_SKIN_URL = "FeedSkinUrl";
  public static final String SECONDARY_FEED_TEXT_MAX_LINES = "FeedTextMaxLine";
  public static final String SECONDARY_FEED_VISITOR = "FeedVisitor";
  public static final String SECONDARY_FEED_YELLOW_DIAMOND = "FeedYellowDiamond";
  public static final String SECONDARY_FIRST_TIME_ENTER_FRIEND_FEEDS_NEED_GET_MAINPAGE = "firstTimeEnterFriendFeedsNeedGetMainpage";
  public static final String SECONDARY_FLOAT_COMMENT_SOFT_ORDER = "FloatCommentSoftOrder";
  public static final String SECONDARY_FLOAT_MODEL_BLACKLIST = "FloatModelBlacklist";
  public static final String SECONDARY_FLOAT_PERFORMANCE_4CORE_CPU_RAM_SIZE = "FloatStandard4CoreCpuRamSize";
  public static final String SECONDARY_FLOAT_PERFORMANCE_CPU_CORE = "FloatStandardCpuCore";
  public static final String SECONDARY_FLOAT_PERFORMANCE_CPU_FEQUENCY = "FloatStandardCpuFequency";
  public static final String SECONDARY_FLOAT_PERFORMANCE_CPU_RAM_SIZE = "FloatStandardCpuRamSize";
  public static final String SECONDARY_FLOWER_VINE_URL = "FlowerVineURL";
  public static final String SECONDARY_FOLLOW_FANS_URL = "follow_fans_url";
  public static final String SECONDARY_FOLLOW_FOLLOWERS_URL = "follow_followers_url";
  public static final String SECONDARY_FONT_LIST_ATTACH_INFO = "DiyFontAttachinfo";
  public static final String SECONDARY_FONT_PREVIEW_URL = "FontPreviewUrl";
  public static final String SECONDARY_FONT_STORE_URL = "FontStore";
  public static final String SECONDARY_FORBID_SHOW_DELETE_VISITOR = "ForbidShowDeleteVisitor";
  public static final String SECONDARY_FRIENDFEED_CLICK_TO_TOP_LIMIT = "FriendFeedClickToTopLimit";
  public static final String SECONDARY_FRIENDFEED_CLICK_TO_TOP_SHOW_LIMIT = "FriendFeedClickToTopShowLimit";
  public static final String SECONDARY_FRIEND_ALBUM_RECOMMOND_TITLE = "secondary_friend_album_recommond_title";
  public static final String SECONDARY_FRIEND_GIF_RECOMMOND_TITLE = "secondary_friend_gif_recommond_title";
  public static final String SECONDARY_FriVideoBnr_MAX_TimeInterval_ON_Close = "frivideobnrtimeinterval";
  public static final String SECONDARY_GAMEBAR = "GameBar";
  public static final String SECONDARY_GETUSERTIMELOGO_INTERVAL = "GetUserTimeLogoInterval";
  public static final String SECONDARY_GET_AVATARURL = "AvatarURL";
  public static final String SECONDARY_GET_EMOTIONURL = "EmotionURL";
  public static final String SECONDARY_GET_LIVE_SIMPLE_INFO_INTERVAL = "GetLiveSimpleInfoInterval";
  public static final String SECONDARY_GET_PHOTO_BY_TIME_LINE_MAX_COUNT = "GetPhotoByTimeLineMaxCount";
  public static final String SECONDARY_GET_REPLAY_CHECK_INTERVAL = "GetReplayCheckInterval";
  public static final String SECONDARY_GET_REPLAY_CHECK_MAX_TIMES = "GetReplayCheckMaxTimes";
  public static final String SECONDARY_GIFT_BACK = "ReturnGiftList";
  public static final String SECONDARY_GIFT_DETAIL = "GiftDetail";
  public static final String SECONDARY_GIFT_RECEIVER_COUNT = "MaxReceiverCount";
  public static final String SECONDARY_GIF_COVER_CALLBACK_PIECE_SIZE = "gif_cover_callback_piece_size";
  public static final int SECONDARY_GIF_COVER_CALLBACK_PIECE_SIZE_DEFAULT = 1048576;
  public static final String SECONDARY_GIF_COVER_MIN_DISK_SIZE = "gif_cover_min_disk_size";
  public static final int SECONDARY_GIF_COVER_MIN_DISK_SIZE_DEFAULT = 2097152;
  public static final String SECONDARY_GIF_DELAY = "secondary_gif_delay";
  public static final String SECONDARY_GIF_LIST_AUTO_PLAY_GIF_MIN_CPU_MHZ = "secondary_gif_list_auto_play_gif_min_cpu_mhz";
  public static final String SECONDARY_GIF_LIST_AUTO_PLAY_GIF_MIN_RAM_MEGA = "secondary_gif_list_auto_play_gif_min_ram_mega";
  public static final String SECONDARY_GIF_LIST_ENTRY_SHOW_MIN_CPU_MHZ = "secondary_gif_list_entry_show_min_cpu_mhz";
  public static final String SECONDARY_GIF_LIST_ENTRY_SHOW_MIN_RAM_MEGA = "secondary_gif_list_entry_show_min_ram_mega";
  public static final String SECONDARY_GIF_LIST_INCLUDE_LOCAL_GIF = "secondary_gif_list_include_local_gif";
  public static final String SECONDARY_GIF_LIST_INCLUDE_SYNTHESIZED_GIF = "secondary_gif_list_include_synthesized_gif";
  public static final String SECONDARY_GIF_LIST_INCLUDE_VIDEO = "secondary_gif_list_include_video";
  public static final String SECONDARY_GIF_LIST_MAX_PHOTO_GROUP_COUNT = "secondary_gif_list_max_photo_group_count";
  public static final String SECONDARY_GIF_LIST_MAX_SCAN_SYNTHESIZED_PHOTO_TIME_IN_HOUR = "secondary_gif_list_max_scan_synthesized_photo_time_in_hour";
  public static final String SECONDARY_GIF_LIST_MAX_SCAN_VIDEO_TIME_IN_HOUR = "secondary_gif_list_max_scan_video_time_in_hour";
  public static final String SECONDARY_GIF_LIST_MAX_VIDEO_COUNT = "secondary_gif_list_max_video_count";
  public static final String SECONDARY_GIF_LIST_MAX_VIDEO_DURATION_IN_MS = "secondary_gif_list_max_video_duration_in_ms";
  public static final String SECONDARY_GIF_LIST_SHOULD_CLEAR_VIDEO_DB = "secondary_gif_list_should_clear_video_db";
  public static final String SECONDARY_GIF_LIST_TITLE_TEXT = "secondary_gif_list_title_text";
  public static final String SECONDARY_GIF_MAX_SPEED = "secondary_gif_max_speed";
  public static final String SECONDARY_GIF_MIN_MULTIPLE_SPEED = "secondary_gif_min_multiple_speed";
  public static final String SECONDARY_GIF_SIZE_LIMIT = "secondary_gif_size_limit";
  public static final String SECONDARY_GIF_UPLOAD_LIMIT_2G = "GifUploadLimt2G";
  public static final String SECONDARY_GIF_UPLOAD_LIMIT_3G = "GifUploadLimt3G";
  public static final String SECONDARY_GIF_UPLOAD_LIMIT_4G = "GifUploadLimt4G";
  public static final String SECONDARY_GIF_UPLOAD_LIMIT_WIFI = "GifUploadLimtWifi";
  public static final String SECONDARY_GLANCE_VIDEO_MAX_TIME = "GlanceVideoMaxTime";
  public static final String SECONDARY_GPS_CACHE_TIME = "CoordinateCacheTime";
  public static final String SECONDARY_GPS_LOCATE_MAX_TIMEOUT = "GPSLocateMaxTimeout";
  public static final String SECONDARY_GPS_PRELOCATE_MAX_TIMEOUT = "GPSPrelocateMaxTimeout";
  public static final String SECONDARY_HARDWARERESTRICTION_CPU_SIZE = "hardwarerestriction_cpu_size";
  public static final String SECONDARY_HARDWARERESTRICTION_RAM_SIZE = "hardwarerestriction_ram_size";
  public static final String SECONDARY_HBCLICK_VISITORREPORT_INTEVAL = "HBClickVisitorReportInteval";
  public static final String SECONDARY_HERO_VIDEO_AVAILABLE_CHECK = "videoHeroAvailableCheck";
  public static final String SECONDARY_HERO_VIDEO_AVAILABLE_DEFAULT = "99|default|default|default|default|default";
  public static final String SECONDARY_HIDE_HIS_RECORD = "HideHisRecord";
  public static final String SECONDARY_HIDE_VISIT_MY = "HideSeeHis";
  public static final String SECONDARY_HOMEPAGE_BAR_MYFANS_ICON = "icon_url_myfans";
  public static final String SECONDARY_HOMEPAGE_BAR_MYFANS_VISIBLE = "bar_myfans_visible";
  public static final String SECONDARY_HOMEPAGE_BAR_MYFOLLOW_GUEST_VISIBLE = "bar_myfollow_guest_visible";
  public static final String SECONDARY_HOMEPAGE_BAR_MYFOLLOW_VISIBLE = "bar_myfollow_visible";
  public static final String SECONDARY_HOMEPAGE_BAR_WEISHI_ICON = "icon_url_weishi";
  public static final String SECONDARY_HOMEPAGE_BAR_WEISHI_SCHEMA = "schema_url_weishi";
  public static final String SECONDARY_HOMEPAGE_GUEST_DEFAULT_COVER_SHOW_DELAY_MS = "homepageGuestDefaultCoverShowDelayMs";
  public static final String SECONDARY_HOME_PAGE_ALBUM_TITLE = "AlbumBtnTitle";
  public static final String SECONDARY_HOOKREPORT_CONFIG = "HookReportConfig";
  public static final String SECONDARY_HOT_GIF = "HotGif";
  public static final String SECONDARY_HTML_FORCE_CLOSE = "HtmlForceClose";
  public static final String SECONDARY_HTML_STANDARD_CPU_CORE = "HtmlStandardCpuCore";
  public static final String SECONDARY_HTML_STANDARD_CPU_FEQUENCY = "HtmlStandardCpuFequency";
  public static final String SECONDARY_HTML_STANDARD_RAM_SIZE = "HtmlStandardRAMSize";
  public static final String SECONDARY_HTTP2_CONNECT_LIVE_TIME = "http2ConnectLiveTime";
  public static final String SECONDARY_HTTP2_DOMAIN_LIST = "http2DomainList";
  public static final String SECONDARY_HTTP2_THREAD_POOL_SIZE = "http2ThreadPoolSize";
  public static final String SECONDARY_HTTP2_WIFI_THREAD_POOL_SIZE = "http2WifiThreadPoolSize";
  public static final String SECONDARY_HTTP_CONNECT_LIVE_TIME = "httpConnectLiveTime";
  public static final String SECONDARY_HTTP_THREAD_POOL_SIZE = "httpThreadPoolSize";
  public static final String SECONDARY_IGNORE_DOWNLOAD_APK_DOMAINS = "QzoneApkBanDomainList";
  public static final String SECONDARY_IGNORE_DOWNLOAD_APK_DOMAINS_DEFAULT = "douyin.com,huoshan.com,changba.com,toutiao.com,xiguaapp.cn,xiguashipin.cn,365yg.com,snssdk.com,ixigua.com,toutiaocdn.net,music.163.com";
  public static final String SECONDARY_IGNORE_LOCAL_JUDGE = "IgnoreLocalJudge";
  public static final String SECONDARY_IGNORE_WEBVIEW_SCHEME_URL = "QzoneUrlBanList";
  public static final String SECONDARY_IGNORE_WEBVIEW_SCHEME_URL_DEFAULT = "[{'domains':['^.*\\.douyin\\.com/.*'],'items':['^https?://d\\.douyin\\.com/.+']},{'domains':['^.*\\.huoshan\\.com/.*'],'items':['^https?://d\\.huoshan\\.com/.+']},{'domains':['^.*\\.toutiao\\.com/.*','^.*\\.xiguaapp\\.cn/.*','^.*\\.xiguashipin\\.cn/.*','^.*\\.365yg\\.com/.*','^.*\\.snssdk\\.com/.*','^.*\\.ixigua\\.com/.*','^.*\\.toutiaocdn\\.net/.*'],'items':['^https?://d\\.toutiao\\.com/.+','^https?://d\\.ixigua\\.com/.+']},{'domains':['^http.*'],'items':['^snssdk[0-9]+://.*','^changba://.*','^orpheus://.*']}]";
  public static final String SECONDARY_IMAGE_BIG_URL_SEGMENT = "imageBigUrlSegment";
  public static final String SECONDARY_IMAGE_CURRENT_URL_SEGMENT = "imageCurrentUrlSegment";
  public static final String SECONDARY_IMAGE_JAR_PROGRESS_TRACER = "imageJarProgressTracer";
  public static final String SECONDARY_IMAGE_UPLOAD_BACKUP_IP = "BackupIP1";
  public static final String SECONDARY_IMAGE_UPLOAD_BAK_IP = "BackupIP_PICUP";
  public static final String SECONDARY_IMAGE_UPLOAD_HOST = "PhotoURL1";
  public static final String SECONDARY_IMAGE_UPLOAD_HOST_IP = "PhotoURL_UP";
  public static final String SECONDARY_IMAGE_UPLOAD_IP = "OptimumIP1";
  public static final String SECONDARY_IMAGE_UPLOAD_OPT_IP = "OptimumIP_PICUP";
  public static final String SECONDARY_IP_NO_PMTU_DISC = "ip_no_pmtu_disc";
  public static final String SECONDARY_IS_CAN_PRELOAD_PEAK = "isCanPreloadPeak";
  public static final int SECONDARY_IS_CAN_PRELOAD_PEAK_DEFAULT = 1;
  public static final String SECONDARY_IS_LIVEVIDEO_NEW_MODE = "LiveVideo_Size_New_Mode";
  public static final String SECONDARY_JSAPI_BLACK_LIST = "jsapiblacklist";
  public static final String SECONDARY_JSBRIDGE_ALLOW_HOSTS_LIST = "JsBridgeAllowHostsList";
  public static final String SECONDARY_JUMPQZONE_ENABLE = "JumpQZoneEnable";
  public static final String SECONDARY_JUMPQZONE_SCHEME_ENABLE = "JumpQZoneSchemeEnable";
  public static final String SECONDARY_JUMP_TO_PREVIEW_ALBUM_FACADE_CATE = "PreviewAlbumFacadeCate";
  public static final String SECONDARY_KEY_ALBUM_DETAIL_RECOM_ALBUM_LIST_NUM_OF_COLUMN = "DetailRecomAlbumNumOfColumn";
  public static final int SECONDARY_KEY_ALBUM_DETAIL_RECOM_ALBUM_LIST_NUM_OF_COLUMN_DEFAULT = 2;
  public static final String SECONDARY_KEY_ALBUM_DETAIL_RECOM_DOWNNER_BOUND = "DetailRecomAlbumDownnerBound";
  public static final int SECONDARY_KEY_ALBUM_DETAIL_RECOM_DOWNNER_BOUND_DEFAULT = 2;
  public static final String SECONDARY_KEY_ALBUM_DETAIL_RECOM_UPPER_BOUND = "DetailRecomAlbumUpperBound";
  public static final int SECONDARY_KEY_ALBUM_DETAIL_RECOM_UPPER_BOUND_DEFAULT = 2;
  public static final String SECONDARY_KEY_ALBUM_GALLERY_DOWNNER_BOUND = "AlbumGalleryRecomAlbumDownnerBound";
  public static final int SECONDARY_KEY_ALBUM_GALLERY_DOWNNER_BOUND_DEFAULT = 2;
  public static final String SECONDARY_KEY_ALBUM_GALLERY_RECOM_ALBUM_LIST_NUM_OF_COLUMN = "AlbumGalleryRecomAlbumNumOfColumn";
  public static final int SECONDARY_KEY_ALBUM_GALLERY_RECOM_ALBUM_LIST_NUM_OF_COLUMN_DEFAULT = 2;
  public static final String SECONDARY_KEY_ALBUM_GALLERY_UPPER_BOUND = "AlbumGalleryRecomAlbumUpperBound";
  public static final int SECONDARY_KEY_ALBUM_GALLERY_UPPER_BOUND_DEFAULT = -1;
  public static final String SECONDARY_KEY_ALBUM_IS_ABLE_TO_SCAN_RECOM_UPLOAD_PHOTO = "AlbumIsAbleToScanRecomUploadPhoto";
  public static final String SECONDARY_KEY_ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE = "AlbumRecomEventAlgoUserSample";
  public static final String SECONDARY_KEY_ALBUM_RECOM_EVENT_CLUSTERING_VAR = "AlbumRecomEventClusteringVariance";
  public static final String SECONDARY_KEY_ALBUM_RECOM_EVENT_CORE_PTS_NUM = "AlbumRecomEventNumOfCorePoints";
  public static final String SECONDARY_KEY_ALBUM_RECOM_UPLOAD_BAR_PHOTO_COUNT = "AlbumRecomUploadBarPhotoCount";
  public static final String SECONDARY_KEY_ALBUM_RECOM_UPLOAD_DISTANCE_LIMIT = "AlbumRecomUploadDistanceLimit";
  public static final String SECONDARY_KEY_ALBUM_RECOM_UPLOAD_LIMITED_SCAN_TIME = "AlbumRecomUploadLimitedScanTime";
  public static final String SECONDARY_KEY_ALBUM_SCANNER_ENABLE = "AlbumScannerEnable";
  public static final String SECONDARY_KEY_ALBUM_SCANNER_NAME = "AlbumScannerName";
  public static final String SECONDARY_KEY_BABY_ALBUM_APPLY_FUNCTION_OPEN = "babyALbumApplyFunctionOpen";
  public static final String SECONDARY_KEY_BABY_ALBUM_INVITE_FUNCTION_OPEN = "babyALbumInviteFunctionOpen";
  public static final String SECONDARY_KEY_BACKGROUND_SIMILARITY_CHECK_GROUP_LIMIT = "BackgroundSimilarityCheckGroupLimit";
  public static final String SECONDARY_KEY_BACKGROUND_SIMILARITY_CHECK_TIME_LIMIT = "BackgroundSimilarityCheckTimeLimit";
  public static final String SECONDARY_KEY_BANNER_SIMILARITY_CHECK_SIZE = "BannerSimilarityCheckSize";
  public static final String SECONDARY_KEY_BLOG_SHARE_SHOW_EVERNOTE = "SK_BlogShareShowEvernote";
  public static final String SECONDARY_KEY_CAN_HOLD_SYSTEM_LOCK = "canHoldSystemLock";
  public static final String SECONDARY_KEY_CLEAR_CACHE_VERSION = "Qzone_clearCacheVersion";
  public static final String SECONDARY_KEY_CLINET_ONLINE_COLD_TIME = "ClientOnlineColdTime";
  public static final String SECONDARY_KEY_CLOSE_NATIVE_INBITMAP = "closeNativeAndInBitmap";
  public static final String SECONDARY_KEY_FACE_SCAN_SUPPORT_LOW_VERSION = "face_scan_support_low_version";
  public static final String SECONDARY_KEY_FEED_PIC_TEXT_CARD_VIEW_PHOTO_ARROW = "FeedPicTextCardView_PhotoArrow";
  public static final String SECONDARY_KEY_FEED_PIC_TEXT_CARD_VIEW_PHOTO_BABY = "FeedPicTextCardView_PhotoBaby";
  public static final String SECONDARY_KEY_FEED_PIC_TEXT_CARD_VIEW_PHOTO_LOVER = "FeedPicTextCardView_PhotoLover";
  public static final String SECONDARY_KEY_FEED_PIC_TEXT_CARD_VIEW_PHOTO_NORMAL = "FeedPicTextCardView_PhotoNormal";
  public static final String SECONDARY_KEY_FEED_PIC_TEXT_CARD_VIEW_PHOTO_TRAVEL = "FeedPicTextCardView_PhotoTravel";
  public static final String SECONDARY_KEY_FRIENDFEED_TITLE = "friendfeedtitle";
  public static final String SECONDARY_KEY_GENERATE_GIF_BLACK_LIST = "GenerateGifBlackList";
  public static final String SECONDARY_KEY_GIF_ANTISHAKE_MAX_FRAME_NUM = "GifAntishakeMaxFrameNum";
  public static final String SECONDARY_KEY_GIF_ANTISHAKE_MAX_FRAME_SHOOTTIME = "GifAntishakeMaxFrameShootTime";
  public static final String SECONDARY_KEY_GIF_ANTISHAKE_MAX_GROUP_SHOOTTIME = "GifAntishakeMaxGroupShootTime";
  public static final String SECONDARY_KEY_GIF_ANTISHAKE_MIN_SIMILARITY = "GifAntishakeMinSimilarity";
  public static final String SECONDARY_KEY_GIF_ANTISHAKE_NEED_TO_CHECK_SHOOT_TIME = "GifAntishakeNeedToCheckShootTime";
  public static final String SECONDARY_KEY_GIF_ANTISHAKE_NEED_TO_CHECK_SIMILARITY = "GifAntishakeNeedToCheckSimilarity";
  public static final String SECONDARY_KEY_GIF_ANTISHAKE_SWITCH = "GifAntishakeSwitch";
  public static final String SECONDARY_KEY_GIF_DOWNLOAD_AND_PLAY = "GifDownloadAndPlay";
  public static final String SECONDARY_KEY_GIF_DOWNLOAD_AND_PLAY_SDK_LEVEL = "GifDownloadAndPlaySdkLevel";
  public static final String SECONDARY_KEY_GUEST_MIN_CPU_FREQ = "LiveVideoGuestMinCpuFreq";
  public static final String SECONDARY_KEY_GUEST_MIN_CPU_NUMBER = "LiveVideoGuestCpuNumber";
  public static final String SECONDARY_KEY_GUEST_MIN_RAM = "LiveVideoGuestMinRam";
  public static final String SECONDARY_KEY_GUEST_MORE_POPUP_SETTING = "GuestMorePopupSetting";
  public static final String SECONDARY_KEY_GUEST_SDKDEF = "LiveVideoGuestSdkDef";
  public static final String SECONDARY_KEY_HEAD_MENU = "friendfeedheadmenu";
  public static final String SECONDARY_KEY_HIDE_AIO_FEEDS = "hideAioFeeds";
  public static final String SECONDARY_KEY_HOST_MIN_CPU_FREQ = "LiveVideoMinCpuFreq";
  public static final String SECONDARY_KEY_HOST_MIN_PGC_CPU_NUMBER = "LiveVideoPgcCpuNumber";
  public static final String SECONDARY_KEY_HOST_MIN_RAM = "LiveVideoMinRam";
  public static final String SECONDARY_KEY_HOST_MIN_UGC_CPU_NUMBER = "LiveVideoUgcCpuNumber";
  public static final String SECONDARY_KEY_HOST_MORE_POPUP_SETTING = "HostMorePopupSetting";
  public static final String SECONDARY_KEY_HOST_SDKDEF = "LiveVideoSdkDef";
  public static final String SECONDARY_KEY_IMAGE_DECODING_RES_REPORT_SAMPLE = "qzoneImageDecodingResReportSample";
  public static final String SECONDARY_KEY_INTERACTING_BAR_HOST_USE_ORIGINAL_LAYOUT = "InteractingBarHostUseOriginalLayout";
  public static final String SECONDARY_KEY_INTERACTING_BAR_USE_ORIGINAL_LAYOUT = "InteractingBarHostUseOriginalLayout";
  public static final String SECONDARY_KEY_JUMP_TO_MORE_VIDEO = "JumpToMoreVideo";
  public static final String SECONDARY_KEY_LBS_SPECIAL_LOGIC_MAX_RETRY_COUNT = "LbsSpecialLogicMaxRetryCount";
  public static final String SECONDARY_KEY_LBS_SPECIAL_LOGIC_ON = "LbsSpecialLogicOn";
  public static final String SECONDARY_KEY_LOCATE_INTERVAL = "QzoneLocateInterval";
  public static final String SECONDARY_KEY_LOVE_ALBUM_APPLY_FUNCTION_OPEN = "loveALbumApplyFunctionOpen";
  public static final String SECONDARY_KEY_LOVE_ALBUM_INVITE_FUNCTION_OPEN = "loveALbumInviteFunctionOpen";
  public static final String SECONDARY_KEY_MANUAL_LOAD_SWITCH_STATUS = "ManualLoadSwitchStatus";
  public static final String SECONDARY_KEY_MAX_P2V_VIDEO_DURING = "MaxP2VVideoDuring";
  public static final String SECONDARY_KEY_MIN_MEMEORY_CLASS_IN_ART = "MinMemoryClassInArt";
  public static final String SECONDARY_KEY_MODULE_JUMP_NATIVE = "module_jump_native";
  public static final String SECONDARY_KEY_MULTI_ALBUM_APPLY_FUNCTION_OPEN = "multiALbumApplyFunctionOpen";
  public static final String SECONDARY_KEY_MULTI_ALBUM_INVITE_FUNCTION_OPEN = "multiALbumInviteFunctionOpen";
  public static final String SECONDARY_KEY_NO_CACHE_IMAGE_EXPIRED_TIME = "NoCacheImageExpiredTime";
  public static final String SECONDARY_KEY_OFFLINE_CACHE_BUFFER_SIZE = "OfflineCacheBufferSize";
  public static final String SECONDARY_KEY_OFFLINE_CACHE_EXT_LIST = "OfflineCacheExt2MimeType";
  public static final String SECONDARY_KEY_OFFLINE_CACHE_SUPPORT_GZIP = "OfflineCacheSupportGZip";
  public static final String SECONDARY_KEY_OFFLINE_CACHE_SUPPORT_WEBP_AND_SHARPP = "OfflineCacheSupportWebpAndSharppImage";
  public static final String SECONDARY_KEY_OFFLINE_CACHE_WHITELIST = "OfflineCacheWhiteList";
  public static final String SECONDARY_KEY_OFFLINE_DECODE_PHOTO_QUALITY = "QzoneOfflineDecodePhotoQuality";
  public static final String SECONDARY_KEY_OFFLINE_ENABLE = "OfflineCacheEnable";
  public static final String SECONDARY_KEY_OPEN_WEBSECURITYVERIFY = "openWebSecurityVerify";
  public static final String SECONDARY_KEY_P2V_BLACK_LIST = "P2VFunBlackList";
  public static final String SECONDARY_KEY_P2V_FUN_ENABLE = "P2VFunEnable";
  public static final String SECONDARY_KEY_P2V_STORAGE_LIMIT = "P2VStorageLimt";
  public static final String SECONDARY_KEY_P2V_SUPPORTED_CPU_FAMILY = "P2VSupportedCpuFamily";
  public static final String SECONDARY_KEY_PLUS_DIFFERENCE = "plusdifference";
  public static final String SECONDARY_KEY_PUBLIC_SPACE = "publicSpace";
  public static final String SECONDARY_KEY_QZONEVIDEO_HOST = "qzonelivevideo_livehost";
  public static final String SECONDARY_KEY_QZONE_GIF_NEED_RECYLE_BMP = "qzoneGifNeedRecycle";
  public static final String SECONDARY_KEY_QZONE_GIF_PREFER_NEW_DECODE_TASK = "qzoneGifPreferNewDecodeTask";
  public static final String SECONDARY_KEY_QZONE_GIF_SUPPORT_565 = "qzoneGifSupport565";
  public static final String SECONDARY_KEY_QZONE_MODULE_REPORT_SAMPLE = "qzoneModuleReportSample";
  public static final String SECONDARY_KEY_QZONE_SEARCH_RESULT_URL = "qzone_search_result_url";
  public static final String SECONDARY_KEY_RECOMMEND_COUNT_NUM_LIMIT = "RecommendAlbumCountNumLimit";
  public static final String SECONDARY_KEY_SHARING_OWNERS_LIST_TITLE_BABY = "SharingOwnersListTitleBaby";
  public static final String SECONDARY_KEY_SHARING_OWNERS_LIST_TITLE_REGULAR = "SharingOwnersListTitleRegular";
  public static final String SECONDARY_KEY_SHARPP_GATE = "qzoneSharppGate";
  public static final String SECONDARY_KEY_SHARPP_LOAD_SO_RETRY_WAIT_TIME = "qzoneSharppLoadSoRetryWaitTime";
  public static final String SECONDARY_KEY_SHARPP_PLAN_B_SWITCH = "qzoneSharppPlanBSwitch";
  public static final String SECONDARY_KEY_SHOW_GLOBAL_SEARCH_BUBBLE = "showGlobalSearchBubble";
  public static final String SECONDARY_KEY_SIMILARITY_PRE_CHECK_SWITCH = "SimilarityPreCheckSwitch";
  public static final String SECONDARY_KEY_SURPRISE_CLICK_HEIGHT = "surpriseClickHeight";
  public static final String SECONDARY_KEY_SURPRISE_CLICK_WIDTH = "surpriseClickWidth";
  public static final String SECONDARY_KEY_SURPRISE_TIME_INTERVAL = "surpriseTimeInterval";
  public static final String SECONDARY_KEY_SURPRISE_WAIT_TIME = "surpriseWaitTime";
  public static final String SECONDARY_KEY_SYNC_TO_QQSTORY = "keySyncToQQStory";
  public static final String SECONDARY_KEY_TRAVEL_ALBUM_APPLY_FUNCTION_OPEN = "travelALbumApplyFunctionOpen";
  public static final String SECONDARY_KEY_TRAVEL_ALBUM_INVITE_FUNCTION_OPEN = "travelALbumInviteFunctionOpen";
  public static final String SECONDARY_KEY_UPLOAD_SWITCH = "upload_switch";
  public static final String SECONDARY_KEY_USERHOME_MESSAGE_BOARD_URL = "user_home_message_board_url";
  public static final String SECONDARY_KEY_USERHOME_NEW_VISITOR_ANIMATION_SINGLE_FRAME_DURANTION = "user_home_new_visitor_single_frame_duration";
  public static final String SECONDARY_KEY_USERHOME_OPEN_MESSAGE_BOARD_DIRECTOR_RESOUCE_MD5 = "user_home_open_message_board_director_res_md5";
  public static final String SECONDARY_KEY_USERHOME_OPEN_MESSAGE_BOARD_DIRECTOR_RESOUCE_URL = "user_home_open_message_board_director_res_url";
  public static final String SECONDARY_KEY_USERHOME_OPEN_MESSAGE_BOARD_SETTING_URL = "user_home_open_message_board_setting_url";
  public static final String SECONDARY_KEY_USERHOME_SHOW_OPEN_MESSAGE_BOARD_DIRECTOR = "user_home_show_open_message_board_director";
  public static final String SECONDARY_KEY_VIDEO_EXPOSE_REPORT_COUNT = "VideoExposeReportCount";
  public static final String SECONDARY_KEY_VOICE_SHUOSHUO = "VoiceShuoshuoH5Url";
  public static final String SECONDARY_KEY_WNS_CGI_ENABLE_OPTIMIZATION = "enableWnsCgiOptimization";
  public static final int SECONDARY_KEY_WNS_CGI_ENABLE_OPTIMIZATION_DEFAULT = 1;
  public static final String SECONDARY_LARGE_FONT_SIZE = "LargeFontSize";
  public static final String SECONDARY_LATEST_WEBAPP_IP_COUNT = "LatestWebappIPCount";
  public static final String SECONDARY_LATEST_WEBAPP_IP_RECORD_SECONDS = "LatestWebappIPRecordSeconds";
  public static final String SECONDARY_LATEST_WEBAPP_TIMESTAMP_COUNT = "LatestWebappTimeStampCount";
  public static final String SECONDARY_LBS_PRLOAD = "LBSPreload";
  public static final String SECONDARY_LIKELIST_PAGE = "LikeListPage";
  public static final String SECONDARY_LINK_REPORT_CMD_LIST = "LinkReportCmds";
  public static final String SECONDARY_LIVEPLUGIN_SOURL = "LivePluginSOUrl";
  public static final String SECONDARY_LIVEPLUGIN_SOVersion = "LivePluginSOVersion";
  public static final String SECONDARY_LIVEVIDEO_DULI_DOWNLOAD = "LiveVideoDuliDownload";
  public static final int SECONDARY_LIVEVIDEO_ENTRY_JUMP_DULI = 1;
  public static final int SECONDARY_LIVEVIDEO_ENTRY_JUMP_DULI_OTH = 2;
  public static final int SECONDARY_LIVEVIDEO_ENTRY_OFF = 0;
  public static final String SECONDARY_LIVEVIDEO_FLOATLAYER_ENTRY = "LiveVideoFloatLayerEntry";
  public static final String SECONDARY_LIVEVIDEO_PLUS_ENTRY = "LiveVideoPlusEntry";
  public static final String SECONDARY_LIVEVIDEO_PRE_ENTER_ROOM_ENABLE = "LiveVideoPreEnterRoomEnable";
  public static final int SECONDARY_LIVEVIDEO_PRE_ENTER_ROOM_ENABLE_DEFAULT = 0;
  public static final String SECONDARY_LIVEVIDEO_PRE_LOAD_ENTER_ROOM_IP_ACTION = "LiveVideoPreLoadEnterRoomIpAction";
  public static final int SECONDARY_LIVEVIDEO_PRE_LOAD_ENTER_ROOM_IP_ACTION_DEFAULT = 2;
  public static final String SECONDARY_LIVE_CAN_PRELOAD = "liveCanPreload";
  public static final String SECONDARY_LIVE_FEED_AUTO_PLAY_DELAY_TIMES = "LiveFeedAutoPlayDelayTimes";
  public static final String SECONDARY_LIVE_PLUGIN_AUDIO_MD5 = "livePluginAudioMd5";
  public static final String SECONDARY_LIVE_PLUGIN_AUDIO_URL = "livePluginAudioUrl";
  public static final String SECONDARY_LIVE_PLUGIN_DOWNLOAD_AVAILABLE_SPACE = "livePluginDownloadAvailableSpace";
  public static final String SECONDARY_LIVE_PLUGIN_FILTER_BUNDLE_MD5 = "livePluginFilterBundleMd5";
  public static final String SECONDARY_LIVE_PLUGIN_FILTER_BUNDLE_URL = "livePluginFilterBundleUrl";
  public static final String SECONDARY_LIVE_PLUGIN_PITU_SEG_AND_HAND_DETECT_MD5 = "livePluginSegAndHandMd5";
  public static final String SECONDARY_LIVE_PLUGIN_PITU_SEG_AND_HAND_DETECT_URL = "livePluginSegAndHandUrl";
  public static final String SECONDARY_LIVE_PLUGIN_PTU_DM_MD5 = "livePluginPtuAlgoMd5";
  public static final String SECONDARY_LIVE_PLUGIN_PTU_DM_URL = "livePluginPtuAlgoUrl";
  public static final String SECONDARY_LIVE_UGC_PERMISSION_PAGE = "liveUgcPermissionPage";
  public static final String SECONDARY_LIVE_USE_QQ_PLUGIN_MANAGER = "useQQPluginManager";
  public static final String SECONDARY_LOADING_PHOTO_BEGIN_TIME = "BeginTime";
  public static final String SECONDARY_LOADING_PHOTO_END_TIME = "EndTime";
  public static final String SECONDARY_LOADING_PHOTO_URL = "URL";
  public static final String SECONDARY_LOAD_NEW_UPLOAD_MODULE = "LoadNewUploadModule";
  public static final String SECONDARY_LOCALPHOTO_CHECK_EXIF_MODE = "localPhotoCheckExifMode";
  public static final String SECONDARY_LOCALVIDEOPALYDATA_COUNT_LIMIT = "localVideoPlayDataCountLimit";
  public static final String SECONDARY_LOCAL_PHOTO_HEAD_REQUEST_QBOSS = "localPhotoHeadRequestQboss";
  public static final String SECONDARY_LOCAL_PHOTO_SWITCHER_URL = "LocalPhotoSwitcherUrl";
  public static final String SECONDARY_LOCATE_MINPOI_INTERVAL = "LBSPOIListFrequency";
  public static final String SECONDARY_LOCATE_MIN_DISTANCE = "LBSIsEqualDistance";
  public static final String SECONDARY_LOG_UPLOAD_OPT_IP = "OptimumIP_MobileLog";
  public static final String SECONDARY_LOVER_ICON_URL = "LoversSpace";
  public static final String SECONDARY_LOVER_ZONE_URL = "bar_loversspace_schema";
  public static final String SECONDARY_LOW_CPU = "LowCpu";
  public static final String SECONDARY_MACHINELEARNINF_REPORT_SAMPLE = "MachinelearningReportSamples";
  public static final String SECONDARY_MACHINELEARNINF_REPORT_SWITCH = "MachinelearningReportSwitch";
  public static final String SECONDARY_MACHINELEARNINF_REPORT_WHITE_LIST = "MachinelearningReportWhiteList";
  public static final String SECONDARY_MACHINELEARNINF_SMART_REPORT_CONFIG = "MachinelearningSmartReportConfig";
  public static final String SECONDARY_MACHINELEARNINF_SMART_REPORT_SWITCH = "MachinelearningSmartReportSwitch";
  public static final String SECONDARY_MAX_DOWNLOADING_VIDEO_COUNT = "maxDownloadingVideoCount";
  public static final String SECONDARY_MAX_HOURS_PHOTO_CREATE_GIF = "maxHoursPhotoCreateGif";
  public static final String SECONDARY_MAX_RECENT_PHOTO_NUM = "MaxRecentPhotoNum";
  public static final String SECONDARY_MEDAL_JUMP_URL = "MedalJumpUrl";
  public static final String SECONDARY_MEMOEY_CAN_ARCHIVE_INTERVAL = "memory_can_archive_interval";
  public static final String SECONDARY_MEMOEY_OPERATE_TIMES = "memory_operate_times";
  public static final String SECONDARY_MEMORY_COLD_TIME = "memory_cold_time";
  public static final String SECONDARY_MEMORY_SEAL = "MemorySeal";
  public static final String SECONDARY_MIN_AVAILABLE_RAM = "MinAvailableRam";
  public static final String SECONDARY_MIN_CPU = "MinCpu";
  public static final String SECONDARY_MIN_RAM = "MinRam";
  public static final String SECONDARY_MIN_RUNTIME_RAM = "MinRuntimeRam";
  public static final String SECONDARY_MIN_SDK = "MinSdkVersion";
  public static final String SECONDARY_MIN_SDK_TRIM_HW = "MinSdkVersionHw";
  public static final String SECONDARY_ML_EXPOSED_MEDIA_UPPER_BOUND = "MachineLearningExposedMediaUpperBound";
  public static final String SECONDARY_ML_IS_PHOTO_TAG_FILLUP_AVAILABLE_PAGE = "MachineLearningIsPhotoTagFillUpAvailable";
  public static final String SECONDARY_ML_IS_PHOTO_TAG_FILLUP_ENABLED = "MachineLearningIsPhotoTagFillUpEnabled";
  public static final String SECONDARY_ML_IS_PHOTO_TAG_FILLUP_INTERVALTIME = "MachineLearningIsPhotoTagFillUpIntervalTime";
  public static final String SECONDARY_ML_IS_PHOTO_TAG_FILLUP_PHOTO_COUNT = "MachineLearningIsPhotoTagFillUpPhotoCount";
  public static final String SECONDARY_ML_PACKAGE_FILE_MD5 = "MachineLearningPackageFilesMD5";
  public static final String SECONDARY_ML_PHOTO_TAG_FILLUP_CPU_USAGE_INTERVAL = "MachineLearningIsPhotoTagFillUpCpuUsageShreshold";
  public static final int SECONDARY_ML_PHOTO_TAG_FILLUP_CPU_USAGE_INTERVAL_DEFAULT = 5000;
  public static final String SECONDARY_ML_PHOTO_TAG_FILLUP_CPU_USAGE_SHRESHOLD = "MachineLearningIsPhotoTagFillUpCpuUsageShreshold";
  public static final String SECONDARY_ML_REPORT_CAMERA_SETTING = "MachineLearningIsPhotoTagFillUpCpuUsageShreshold";
  public static final int SECONDARY_ML_REPORT_CAMERA_SETTING_DEFAULT = 0;
  public static final String SECONDARY_ML_SHUOSHUO_SWITCH = "machineLearningShuoshuoSwitch";
  public static final String SECONDARY_ML_SO_MD5 = "machinelearningsomd5";
  public static final String SECONDARY_ML_SO_URL = "machinelearningso";
  public static final String SECONDARY_ML_WORKFLOW_RETRY_CNT = "MachineLearningWorkflowRetryCnt";
  public static final String SECONDARY_MOBILE_LOG_UPLOAD_BACKUP_IP = "BackupIP_MobileLog";
  public static final String SECONDARY_MOBILE_LOG_UPLOAD_IP = "OptimumIP_MobileLog";
  public static final String SECONDARY_MONITORH5REPORT_SAMPLE = "MonitorH5ReportSamples";
  public static final String SECONDARY_MONITORH5REPORT_URL = "MonitorH5ReportURL";
  public static final String SECONDARY_MOOD_EDIT = "MoodEdit";
  public static final String SECONDARY_MOOD_PHOTO_MAX_NUM = "MoodPhotoMaxNum";
  public static final String SECONDARY_MOOD_RECENT_GIF_MAX_SIZE = "MoodRecentGifMaxSize";
  public static final String SECONDARY_MOOD_RECENT_NEW_PHOTO_TIME = "MoodRecentNewPhotoTime";
  public static final String SECONDARY_MOOD_RECENT_PHOTO_COUNT = "MoodRecentPhotoCount";
  public static final String SECONDARY_MOOD_RECENT_PHOTO_NUM = "MoodRecentPhotoNum";
  public static final String SECONDARY_MOOD_RECENT_PHOTO_TIME = "MoodRecentPhotoTime";
  public static final String SECONDARY_MOOD_RECENT_PHOTO_TIME_FOR_ONE = "MoodRecentPhotoTimeForOne";
  public static final String SECONDARY_MOOD_RECENT_VIDEO_SIZE = "MoodRecentVideoSize";
  public static final String SECONDARY_MOOD_RECENT_VIDEO_TIME = "MoodRecentVideoTime";
  public static final String SECONDARY_MOOD_SCHEDULE_DELETE_VIDEO = "MoodScheduleDeleteVideo";
  public static final String SECONDARY_MOOD_WEB_PICTURE_ADD_MORE = "MoodWebPictureAddMore";
  public static final String SECONDARY_MSG_LIST_URL = "MsgListUrl";
  public static final String SECONDARY_MUSIC_PLAY_DETAIL_URL = "MusicPlayDetailUrl";
  public static final String SECONDARY_NAMEPLATE_URL = "NameplateMainPageAddr";
  public static final String SECONDARY_NAME_PLAYER_PREVIEW = "PlayerPreview";
  public static final String SECONDARY_NAME_PLAYER_PREVIEW_DEFAULT = "https://h5.qzone.qq.com/playerStore/index?_wv=1027&router=home&_proxy=1&appid=113&itemid={itemid}";
  public static final String SECONDARY_NAME_PLAYER_STORE = "PlayerStore";
  public static final String SECONDARY_NAME_PLAYER_STORE_DEFAULT = "https://h5.qzone.qq.com/playerStore/index?_wv=1027&router=home&_proxy=1&appid=113";
  public static final String SECONDARY_NAME_RESUME_FRAGMENT = "resumedFragement";
  public static final String SECONDARY_NATIVE_HOOK = "NativeHook";
  public static final String SECONDARY_NATIVE_HOOK_SDK = "NativeHookSDK";
  public static final String SECONDARY_NAVIGATORBAR_ITEMATTRIBUTE = "ItemAttribute";
  public static final String SECONDARY_NAVIGATORBAR_ITEMCOUNT = "ItemCount";
  public static final String SECONDARY_NAVIGATORBAR_ITEMDOWNURLPREFIX = "ItemDownURLPrefix";
  public static final String SECONDARY_NAVIGATORBAR_ITEMORDER = "ItemOrder";
  public static final String SECONDARY_NAVIGATOR_ITEM_WEIGHT_FOR_THREE_OR_MORE = "navigatorItemWeightForThreeOrMore";
  public static final String SECONDARY_NAVIGATOR_ITEM_WEIGHT_FOR_TWO_OR_LESS = "navigatorItemWeightForTwoOrLess";
  public static final String SECONDARY_NEED_DECODE = "RichTextNeedDecode";
  public static final String SECONDARY_NEED_DRAWABLE_RECYCLED = "NeedDrawableRecycled";
  public static final String SECONDARY_NEED_LOCAL_BLACK_LIST = "NeedLocalBlackList";
  public static final String SECONDARY_NEED_SYNC_TO_WEIBO = "ShowMoodSyncWeiboButton";
  public static final String SECONDARY_NEWTYPE_UPLOAD_BACKUP_HOST = "PhotoURL3";
  public static final String SECONDARY_NEWTYPE_UPLOAD_BACKUP_IP = "BackupIP2";
  public static final String SECONDARY_NEWTYPE_UPLOAD_HOST = "PhotoURL2";
  public static final String SECONDARY_NEWTYPE_UPLOAD_IP = "OptimumIP2";
  public static final String SECONDARY_NEWTYPE_UPLOAD_MOBILE_LOG_HOST = "PhotoURL4";
  public static final String SECONDARY_NEW_ALBUM_CHOOSE_ORDER = "NewAlbumChooseOrder";
  public static final String SECONDARY_NEW_ALBUM_SHOW_SETTINGS = "NewAlbumShowSettings";
  public static final String SECONDARY_NEW_ENTRY_RED_DOT_SWITCH = "AlbumNewEntryRedDotSwitch";
  public static final String SECONDARY_NICKNAME_FLASH = "NickNameFlash";
  public static final String SECONDARY_ONEKEY_BEAUTIFY_MAX_IMAGE_SUPPORT_COUNT = "onekeyBeautifyMaxImageSupportCount";
  public static final String SECONDARY_ONLINE_LOACL_SAVE_FREQUENCY = "OnlineLocalSaveFrequency";
  public static final String SECONDARY_ONLINE_REPORT_FAILURE_TIMES = "OnlineReportFailureTimes";
  public static final String SECONDARY_ONLINE_REPORT_FREQUENCY = "OnlineReportFrequency";
  public static final String SECONDARY_ONLINE_REPORT_INTEVAL = "OnlineReportInterval";
  public static final String SECONDARY_OPEN_ABTEST = "PluginOpenABTest";
  public static final String SECONDARY_OPEN_ABTEST_PLAN_A = "PluginOpenABTestPlanA";
  public static final String SECONDARY_OPEN_ABTEST_PLAN_B = "PluginOpenABTestPlanB";
  public static final String SECONDARY_OPEN_ABTEST_PLAN_C = "PluginOpenABTestPlanC";
  public static final String SECONDARY_OPEN_ABTEST_PLAN_D = "PluginOpenABTestPlanD";
  public static final String SECONDARY_OPEN_COLORLOG = "open_colorlog";
  public static final String SECONDARY_OPEN_ORIGINAL_UPLOAD = "OpenOriginalUpload";
  public static final String SECONDARY_OPEN_PUBLISH_SECRET_SHUOSHUO_H5_TAB = "OpenPublishSecretShuoshuoH5Tab";
  public static final String SECONDARY_OTHER_UPLOAD_BAK_IP = "BackupIP_OTHERUP";
  public static final String SECONDARY_OTHER_UPLOAD_HOST_IP = "OtherURL_UP";
  public static final String SECONDARY_OTHER_UPLOAD_OPT_IP = "OptimumIP_OTHERUP";
  public static final String SECONDARY_OUTBOX_MAX_RETRY_COUNT_PER_PERIOD = "ReConnCount";
  public static final String SECONDARY_OUTBOX_MAX_RETRY_TIMEOUT = "RetryTime";
  public static final String SECONDARY_OUTBOX_NEXT_INTERVAL = "RetryInterval";
  public static final String SECONDARY_PASSIVEFEED_ALERT_BUBBLE = "passiveBannerSwitch";
  public static final String SECONDARY_PASSIVEFEED_TAB_NAME = "passiveText";
  public static final String SECONDARY_PASSIVE_PRAISSE_PAGE = "PassivePraisePreview";
  public static final String SECONDARY_PASTER_BLACK_LIST = "PasterBlackList";
  public static final String SECONDARY_PASTER_ENABLE_PERFORMANCE_TEST = "PasterEnablePerformanceTest";
  public static final String SECONDARY_PASTER_STANDARD_CPU_CORE = "PasterStandardCpuCore";
  public static final String SECONDARY_PASTER_STANDARD_CPU_FREQUENCY = "PasterStandardCpuFrequency";
  public static final String SECONDARY_PASTER_STANDARD_RAM_SIZE = "PasterStandardRamSize";
  public static final String SECONDARY_PASTER_WHITE_LIST = "PasterWhiteList";
  public static final String SECONDARY_PATCH_PRELOAD_INTERVAL_TIME = "PatchPreloadInterval";
  public static final String SECONDARY_PERMISSION_PAGE = "SeeMyQzonePermissionSetting";
  public static final String SECONDARY_PERMMIT_PRE_DOWNLOAD_VIDEO = "PermitPreDownload";
  public static final String SECONDARY_PERSONALIZE_MAINPAGE = "PersonalizeMainPage";
  public static final String SECONDARY_PHOTOGUIDE_EXPOSEGUIDETIMESFORONEDAY = "ExposePhotoGuideTimes";
  public static final String SECONDARY_PHOTOGUIDE_EXPOSEPHOTOMINCOUNT = "ExposePhotoMinCount";
  public static final String SECONDARY_PHOTOGUIDE_EXPOSEPHOTOTIMERANGE = "ExposePhotoTimeRange";
  public static final String SECONDARY_PHOTOGUIDE_GUIDESELECTPHOTO = "GuideSelectPhoto";
  public static final String SECONDARY_PHOTOGUIDE_GUIDESHOWOPEN = "GuideShowOpen";
  public static final String SECONDARY_PHOTOGUIDE_GUIDE_PHOTO_CHANGE_STRATEGY = "PhotoUploadPhotoChangeStrategy";
  public static final String SECONDARY_PHOTOGUIDE_GUIDE_PHOTO_MAX_SIZE = "PhotoUploadPhotoMaxSize";
  public static final String SECONDARY_PHOTOGUIDE_GUIDE_PHOTO_MIN_SIZE = "PhotoUploadPhotoMinSize";
  public static final String SECONDARY_PHOTOGUIDE_QQ_EXPOSEPHOTOTIMERANGE = "PhotoUploadGuideScanTimeInterval";
  public static final String SECONDARY_PHOTOGUIDE_QQ_REDPOINTTIMEINTERVAL = "PhotoUploadRedPointTimeInterval";
  public static final String SECONDARY_PHOTOGUIDE_SENDRED_JUMPTOQZONE = "GuideSelectPhotoSendRedJumpToQzone";
  public static final String SECONDARY_PHOTOVIEW_CAN_SHOW_DELETE_BUTTON = "showDeleteButton";
  public static final String SECONDARY_PHOTOVIEW_CAN_SHOW_FACE_BUTTON = "showFaceButton";
  public static final String SECONDARY_PHOTOVIEW_CAN_SHOW_OCR_BUTTON = "PhotoViewShowOcrButton";
  public static final String SECONDARY_PHOTOVIEW_CAN_SHOW_PITU_BUTTON = "PhotoViewShowPituButton";
  public static final String SECONDARY_PHOTOVIEW_GETPHOTOLEVEL = "LevelFlag";
  public static final String SECONDARY_PHOTOVIEW_GROUPDISTANCEMAX = "GroupDistanceMax";
  public static final String SECONDARY_PHOTOVIEW_GROUPMERGECOUNT = "GroupMergeCount";
  public static final String SECONDARY_PHOTOVIEW_GROUPOLDDATE = "GroupOldDate";
  public static final String SECONDARY_PHOTOVIEW_GROUPTIMEMAX = "GroupTimeMax";
  public static final String SECONDARY_PHOTOVIEW_GROUPTIMEMIN = "GroupTimeMin";
  public static final String SECONDARY_PHOTOVIEW_ONE_DETAIL_LEVEL = "DetailLevelFlag";
  public static final String SECONDARY_PHOTOVIEW_ONE_FEEDS_LEVEL = "FeedsLevelFlag";
  public static final String SECONDARY_PHOTOVIEW_PreloadQuanCount = "PreloadQuanCount";
  public static final String SECONDARY_PHOTOVIEW_RECENTPHOTOTIPSCOUNT = "RecentPhotoTipsCount";
  public static final String SECONDARY_PHOTOVIEW_RESTRICT_BEGIN = "RestrictBeginTime";
  public static final String SECONDARY_PHOTOVIEW_RESTRICT_END = "RestrictEndTime";
  public static final String SECONDARY_PHOTOVIEW_RESTRICT_FLAG = "RestrictFlag";
  public static final String SECONDARY_PHOTOVIEW_SHOWOPDELAY = "ShowOPDelay";
  public static final String SECONDARY_PHOTOVIEW_SHOW_LOADING_DELAY = "DelayShowLoading";
  public static final String SECONDARY_PHOTO_3G_QUALITY = "3GQuality";
  public static final String SECONDARY_PHOTO_ALBUM_GIF_LIST_HEADER_TIPS = "PhotoAlbumGifListHeaderTips";
  public static final String SECONDARY_PHOTO_ALBUM_PHOTO_NUM_TIPS = "PhotoAlbumPhotoNumTips";
  public static final String SECONDARY_PHOTO_ALBUM_PHOTO_NUM_TIPS_FLAG = "PhotoAlbumPhotoNumTipsFlag";
  public static final String SECONDARY_PHOTO_ANALYSE = "PhotoAnalyse";
  public static final String SECONDARY_PHOTO_BANNAER_OPTI_SWITCHER = "secondary_photo_bannaer_opti_switcher";
  public static final String SECONDARY_PHOTO_BANNER_GRAY_MAX_DAYS = "secondary_photo_banner_gray_max_days";
  public static final String SECONDARY_PHOTO_BUBBLE_EXPOSE_SCROLL_SHOWTIME = "ExposePhotoBubbleScrollShowTime";
  public static final String SECONDARY_PHOTO_BUBBLE_EXPOSE_SHOWTIME = "ExposePhotoBubbleShowTime";
  public static final String SECONDARY_PHOTO_BUBBLE_EXPOSE_TIMERANGE = "ExposePhotoBubbleTimeRange";
  public static final String SECONDARY_PHOTO_CATEGORY_LIST_HEADER_TIPS = "PhotoCategoryListHeaderTips";
  public static final String SECONDARY_PHOTO_CATEGORY_SCANNER_FRONT_BLACKLIST = "PhotoCategoryScannerFrontCamBlackList";
  public static final String SECONDARY_PHOTO_CATEGORY_SCANNER_FRONT_CAM = "PhotoCategoryScannerFrontCam";
  public static final String SECONDARY_PHOTO_CATEGORY_SCANNER_SWITCH = "PhotoCategoryScannerSwitch";
  public static final String SECONDARY_PHOTO_CREATE_GIF_NEED_PEOPLE = "PhotoGuideCreateGifNeedPeople";
  public static final String SECONDARY_PHOTO_CREATE_GIF_SO = "PhotoGuideCreateGifSo";
  public static final String SECONDARY_PHOTO_CREATE_GIF_SO_LENGTH = "PhotoGuideCreateGifSoLength";
  public static final String SECONDARY_PHOTO_CREATE_GIF_SO_MD5 = "PhotoGuideCreateGifSoMD5";
  public static final String SECONDARY_PHOTO_DOMAIN_IP_IP_LIST = "IPList";
  public static final String SECONDARY_PHOTO_DOWNLOAD_HIGH_SPEED = "HighSpeed";
  public static final String SECONDARY_PHOTO_DOWNLOAD_KEEP_ALIVE = "KeepAlive";
  public static final String SECONDARY_PHOTO_DOWNLOAD_KEEP_ALIVE_PROXY = "KeepAliveProxy";
  public static final String SECONDARY_PHOTO_DOWNLOAD_LOW_SPEED = "LowSpeed";
  public static final String SECONDARY_PHOTO_DOWNLOAD_MAXNUM = "MaxNum";
  public static final String SECONDARY_PHOTO_DOWNLOAD_MINBYTES = "MinBytes";
  public static final String SECONDARY_PHOTO_ENABLE_WATERMARK_CAMERA = "EnableWatermarkCamera";
  public static final String SECONDARY_PHOTO_GROUP_CARD_LIST_USE_THEME_COLOR = "PhotoGroupCardListUseThemeColor";
  public static final String SECONDARY_PHOTO_GROUP_LIST_IMAGE_CROP_SPACE_RATIO = "photoGroupListImageCropSpaceRatio";
  public static final String SECONDARY_PHOTO_GROUP_PRIORITY = "photoGroupsProrityValue";
  public static final String SECONDARY_PHOTO_GUIDE_ENABLE_PHOTO_MARKER = "PhotoGuideEventEnableMarker";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_CHECK_INTERVAL_TIME = "PhotoGuideEventUploadCheckIntervalTime";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_ENABLE = "PhotoGuideEventEnable";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_IS_SHOW_SCENE_POINT = "PhotoGuideEventShowScenePoint";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_MIN_UNEXPOSURE_PHOTOS = "PhotoGuideEventUnexposureMinPhotos";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_MIN_UN_UPLOAD_NUM = "PhotoRecommendMinUnUploadNum";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_NON_WIFI_MAX_PHOTOS = "PhotoGuideEventNonWifiMaxPhotos";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_NON_WIIF_MAX_DAYS = "PhotoGuideEventNonWifiMaxDays";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_START_HOUR = "PhotoGuideEventStartHour";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_WIFFI_MAX_DAYS = "PhotoGuideEventWiffMaxDay";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_WIFI_FIRST_EVENT_DAYS = "PhotoGuideEventWifiFirstEventDays";
  public static final String SECONDARY_PHOTO_GUIDE_VERSION_STRING = "PhotoGuideEventVersionString";
  public static final String SECONDARY_PHOTO_LIBC_SHARE_SO_LENGTH = "PhotoGuideLibCShareSoLength";
  public static final String SECONDARY_PHOTO_LIBC_SHARE_SO_MD5 = "PhotoGuideLibCShareSoMD5";
  public static final String SECONDARY_PHOTO_NEED_CHECK_GIF_EVERY_TIME = "PhotoGuideNeedCheckGifEveryTime";
  public static final String SECONDARY_PHOTO_NEED_CREATE_GIF = "PhotoGuideNeedCreateGif";
  public static final String SECONDARY_PHOTO_PICTURE_MARKER_MODEL = "PhotoPictureMarkerModel";
  public static final String SECONDARY_PHOTO_PICTURE_MARKER_SO = "PhotoPictureMarkerSo";
  public static final String SECONDARY_PHOTO_QULATITY_SO = "PhotoGuidePictureQulatitySo";
  public static final String SECONDARY_PHOTO_QULATITY_SO_MD5 = "PhotoGuidePictureQulatitySoMD5";
  public static final String SECONDARY_PHOTO_QZONE_VISION_SO_LENGTH = "PhotoGuideQzoneVisionSoLength";
  public static final String SECONDARY_PHOTO_QZONE_VISION_SO_MD5 = "PhotoGuideQzoneVisionSoMD5";
  public static final String SECONDARY_PHOTO_RECYCLE = "PhotoRecycle";
  public static final String SECONDARY_PHOTO_TRAFFIC_THRESHOLD = "RemindUploadSizeIsLargeThreshold";
  public static final String SECONDARY_PHOTO_UPLOADRATE_SWITCH = "PhotoUpLoadRateSwitch";
  public static final String SECONDARY_PHOTO_UPLOAD_ALL_PIC_QUALITY = "MoodUploadQuality";
  public static final String SECONDARY_PHOTO_UPLOAD_AUTO_2G = "Auto2G";
  public static final String SECONDARY_PHOTO_UPLOAD_AUTO_3G = "Auto3G";
  public static final String SECONDARY_PHOTO_UPLOAD_AUTO_WIFI = "AutoWiFi";
  public static final String SECONDARY_PHOTO_UPLOAD_DESCRIPTION = "Description";
  public static final String SECONDARY_PHOTO_UPLOAD_MAX_NUM = "MaxNum";
  public static final String SECONDARY_PHOTO_UPLOAD_QUALITY = "UploadQuality";
  public static final String SECONDARY_PHOTO_UPLOAD_QUALITY_HIGH = "QualityHigh";
  public static final String SECONDARY_PHOTO_UPLOAD_QUALITY_HIGH_WEBP = "WebPQualityHigh";
  public static final String SECONDARY_PHOTO_UPLOAD_QUALITY_LOW = "QualityLow";
  public static final String SECONDARY_PHOTO_UPLOAD_QUALITY_LOW_WEBP = "WebPQualityLow";
  public static final String SECONDARY_PHOTO_UPLOAD_QUALITY_MID = "QualityMid";
  public static final String SECONDARY_PHOTO_UPLOAD_RESOLUTION_HIGH = "ResolutionHigh";
  public static final String SECONDARY_PHOTO_UPLOAD_RESOLUTION_LOW = "ResolutionLow";
  public static final String SECONDARY_PHOTO_UPLOAD_TIER_1_CPU = "Tier1CPU";
  public static final String SECONDARY_PHOTO_UPLOAD_TIER_1_MAX_NUM = "Tier1MaxNum";
  public static final String SECONDARY_PHOTO_UPLOAD_TIER_1_RAM = "Tier1RAM";
  public static final String SECONDARY_PHOTO_UPLOAD_TIER_2_CPU = "Tier2CPU";
  public static final String SECONDARY_PHOTO_UPLOAD_TIER_2_MAX_NUM = "Tier2MaxNum";
  public static final String SECONDARY_PHOTO_UPLOAD_TIER_2_RAM = "Tier2RAM";
  public static final String SECONDARY_PHOTO_UPLOAD_TIER_3_CPU = "Tier3CPU";
  public static final String SECONDARY_PHOTO_UPLOAD_TIER_3_MAX_NUM = "Tier3MaxNum";
  public static final String SECONDARY_PHOTO_UPLOAD_TIER_3_RAM = "Tier3RAM";
  public static final String SECONDARY_PHOTO_USE_LOCAL_QUALITY = "UseLocalQuality";
  public static final String SECONDARY_PHOTO_USE_LOCAL_QUALITY_FOR_SHUOSHUO = "UseLocalQualityForShuoShuo";
  public static final String SECONDARY_PHOTO_WALL_URL = "PhotoWallUrl";
  public static final String SECONDARY_PHOTO_WIFI_QUALITY = "WIFIQuality";
  public static final String SECONDARY_PICTURE_VIEWER_DANMAKU_BLACK_LIST = "PictureViewerPhotoDanmakuBlackList";
  public static final String SECONDARY_PICTURE_VIEWER_DANMAKU_CPU_LEVEL = "PictureViewerPhotoDanmakuCpuLevel";
  public static final String SECONDARY_PICTURE_VIEWER_DANMAKU_DEFAULT_SWITCH = "PictureViewerPhotoDanmakuDefaultSwitch";
  public static final String SECONDARY_PICTURE_VIEWER_DANMAKU_GARY_RANGE = "PictureViewerPhotoDanmakuGaryRange";
  public static final String SECONDARY_PICTURE_VIEWER_DANMAKU_MEMORY_LEVEL = "PictureViewerPhotoDanmakuMemoryLevel";
  public static final String SECONDARY_PICTURE_VIEWER_DOUBLE_TAP_SCALE = "pictureViewerDoubleTapScale";
  public static final String SECONDARY_PICTURE_VIEWER_MAX_SCALE = "pictureViewerMaxScale";
  public static final String SECONDARY_PICTURE_VIEWER_NICK_MAX_LENGTH = "PictureViewerNickMaxLength";
  public static final String SECONDARY_PICTURE_VIEWER_PIC_INFO_URL = "PictureViewerPicInfoUrl";
  public static final String SECONDARY_PICTURE_VIEWER_SHOW_PIC_INFO = "PictureViewerShowPicInfo";
  public static final String SECONDARY_PICTURE_VIEWER_SHOW_SHARE_BUTTONS = "pictureViewerShowShareButtons";
  public static final String SECONDARY_PICTURE_VIEWER_TITLE_MAX_LENGTH_WITHOUT_PAGENUM = "PictureViewerTitleMaxLengthWithoutPageNum";
  public static final String SECONDARY_PICTURE_VIEWER_TITLE_MAX_LENGTH_WITH_PAGENUM = "PictureViewerTitleMaxLengthWithPageNum";
  public static final String SECONDARY_PIC_HEIGHT_RATE = "Pic_height_Rate";
  public static final String SECONDARY_PIC_MAX_SIZE_CM = "Pic_MaxSize_CM";
  public static final String SECONDARY_PIC_WIDTH_RATE = "Pic_Width_Rate";
  public static final String SECONDARY_PLUGIN_DOWNLOADER_CREATE = "PluginDownloaderCreate";
  public static final String SECONDARY_PLUGIN_DOWNLOADSO_TIMEOUT = "PluginDownloadSoTimeout";
  public static final String SECONDARY_PLUGIN_DOWNLOAD_CANCELED_ON_CLOSE_BTN = "PluginDownloadCanceledOnCloseBtn";
  public static final String SECONDARY_PLUGIN_DOWNLOAD_CANCELED_ON_QZONE_STOP = "PluginDownloadCanceledOnQzoneStop";
  public static final String SECONDARY_PLUGIN_DOWNLOAD_DELAY = "PluginDownloadDelay";
  public static final String SECONDARY_PLUGIN_DOWNLOAD_ONLY_WIFI = "PluginDownloadOnlyWifi";
  public static final String SECONDARY_PLUGIN_ERROR_HANDLE_COUNT = "PluginErrorHandleCount";
  public static final String SECONDARY_PLUGIN_INSTALL_TIMEOUT = "PluginInstallTimeout";
  public static final String SECONDARY_PLUGIN_PERMISSION_ERROR_HANDLE = "PluginPermissionErrorHandle";
  public static final String SECONDARY_PLUGIN_RETRY_DOWNLOADSO_TIMES = "PluginRetryDownloadSoTimes";
  public static final String SECONDARY_PLUGIN_RETRY_DOWNLOAD_TIMES = "PluginRetryDownloadTimes";
  public static final String SECONDARY_PLUS_ENTRY_ICON_URL_CHECKIN = "plusEntryIconCheckin";
  public static final String SECONDARY_PLUS_ENTRY_ICON_URL_LIVEVIDEO = "plusEntryIconLiveVideo";
  public static final String SECONDARY_PLUS_ENTRY_ICON_URL_MOOD = "plusEntryIconMood";
  public static final String SECONDARY_PLUS_ENTRY_ICON_URL_PHOTO_STICKER = "plusEntryIconPhotoSticker";
  public static final String SECONDARY_PLUS_ENTRY_ICON_URL_PICTURE = "plusEntryIconPicture";
  public static final String SECONDARY_PLUS_ENTRY_ICON_URL_REDBAG = "plusEntryIconRedBag";
  public static final String SECONDARY_PLUS_ENTRY_ICON_URL_VIDEO = "plusEntryIconVideo";
  public static final String SECONDARY_PM_MONITOR_DURATION = "Duration";
  public static final String SECONDARY_PM_MONITOR_INTERVAL = "Interval";
  public static final String SECONDARY_PM_MONITOR_RATE = "Rate";
  public static final String SECONDARY_POI_CACHE_DISTANCE = "POICacheDistance";
  public static final String SECONDARY_POI_CACHE_TIME = "POICacheTime";
  public static final String SECONDARY_PRELOAD_ACTIVEFEEDS = "PreLoadActiveFeeds";
  public static final String SECONDARY_PRELOAD_BIG_PIC_ML_B_UPDATE = "mlPreloadBigPicBUpdate";
  public static final String SECONDARY_PRELOAD_BIG_PIC_ML_ENABLE = "mlPreloadBigPicEnable";
  public static final String SECONDARY_PRELOAD_BIG_PIC_ML_THRESHOLD = "mlPreloadBigPicThreshold";
  public static final String SECONDARY_PRELOAD_BIG_PIC_ML_W_UPDATE = "mlPreloadBigPicWUpdate";
  public static final String SECONDARY_PRELOAD_CUSTOM_RESOURCES_INTERVAL_SECONDS = "PreloadCustomResourcesIntervals";
  public static final String SECONDARY_PRELOAD_FACADE = "preLoadFacade";
  public static final String SECONDARY_PRELOAD_GROUPFEEDS = "PreLoadGroupFeeds";
  public static final String SECONDARY_PRELOAD_HTML_PAGE_URL_MAX_COUNT = "PreloadHtmlPageUrlMaxCount";
  public static final String SECONDARY_PRELOAD_PEAK_DURATION = "preloadPeakDuration";
  public static final long SECONDARY_PRELOAD_PEAK_DURATION_DEFAULT = 180000L;
  public static final String SECONDARY_PRELOAD_QZONE_PROCESS_ENABLE = "PreloadQzoneProcessEnable";
  public static final String SECONDARY_PRELOAD_QZONE_PROCESS_RAM_THRESHOLD = "PreloadQzoneProcessRamThreshold";
  public static final String SECONDARY_PRELOAD_SMALL_GAME_ALLOW_HOURS = "PreloadSmallGameAllowHourTimes";
  public static final String SECONDARY_PRELOAD_SMALL_GAME_HTML_ENABLE = "PreloadSmallGameHtmlEnable";
  public static final String SECONDARY_PRELOAD_SMALL_GAME_INTERVAL_SECONDS = "PreloadSmallGameIntervals";
  public static final String SECONDARY_PUBLISH_MOOD_GIF_AUTO_PLAY_MIN_RAM_MEGA = "secondary_publish_mood_gif_auto_play_min_ram_mega";
  public static final String SECONDARY_PUBLISH_MOOD_UI_GIF_ICON_ANIM_RES = "publisMoodUiGifIconAnimRes";
  public static final String SECONDARY_PUBLISH_QUEUE_LEAVE_WIFI_CHECK_SIZE = "LeaveWifiCheckSize";
  public static final String SECONDARY_PUBLISH_QUEUE_RECONNECTION_DAYS = "ReconnectionDays";
  public static final String SECONDARY_PUBLISH_QUEUE_RECONNECTION_TIMES = "ReconnectionTimes";
  public static final String SECONDARY_PUBLISH_QUEUE_SAFETY_STRIKE_CODE = "SafetyStrikeCode";
  public static final String SECONDARY_PUBLISH_QUEUE_SAFETY_STRIKE_MESSAGE = "SafetyStrikeMessage";
  public static final String SECONDARY_PUBLISH_SECRET_SHUOSHUO_H5_URL = "PublishSecretShuoshuoH5Url";
  public static final String SECONDARY_PULL_QBOSS_DIALOG_TIME = "detailDialogShowTime";
  public static final String SECONDARY_PUSHBANNER_ACTIVEMAXCOUN = "FeedBannerActiveMaxCount";
  public static final String SECONDARY_PUSHBANNER_DURATION = "FeedBannerDuration";
  public static final String SECONDARY_PUSH_DEDUPLICATION = "PushDeduplication";
  public static final String SECONDARY_PUSH_MERGEMESSAGE = "MergeMessage";
  public static final String SECONDARY_P_CAMERA_DATOU_URL = "PCameraDatou";
  public static final String SECONDARY_P_CAMERA_WANTU_URL = "PCameraWantu";
  public static final String SECONDARY_QBOSS_APPID_CUSTOM_RESOURCES_INFO = "PreloadCustomResourcesQbossAppid";
  public static final String SECONDARY_QMUSIC_HLS_MAX_RETRY_TIMES = "QmusicHlsMaxRetryTimes";
  public static final String SECONDARY_QUICK_CAMERA_ANIM_REQ_DELAY = "QuickCameraAnimReqDelay";
  public static final String SECONDARY_QUN_AIO_DEFAULT_CHECKBOX_STATE = "QunAioCheckBoxState";
  public static final String SECONDARY_QUN_AIO_REMEMBER_UPLOAD = "QunAioRememberUpload";
  public static final String SECONDARY_QUN_AIO_THRESHOLD_NUM = "QunAiOthresholdNum";
  public static final String SECONDARY_QUN_ALBUM_DETAIL_URL = "QunAlbumDetail";
  public static final String SECONDARY_QUN_ALBUM_PHOTO_URL = "QunAlbumPhotoList";
  public static final String SECONDARY_QUN_ALBUM_SELECT_URL = "QunAlbumSelect";
  public static final String SECONDARY_QUN_ALBUM_URL = "QunAlbum";
  public static final String SECONDARY_QUN_FEED_URL = "QunFeed";
  public static final String SECONDARY_QUN_PASSIVE_FEED_URL = "QunPassiveFeed";
  public static final String SECONDARY_QUOTE_MAX_NUM = "quoteMaxNum";
  public static final String SECONDARY_QZFACADE_VISIBLE = "QZFacade_visible";
  public static final String SECONDARY_QZONEAPP_BLACKLIST = "BlackListVersion";
  public static final String SECONDARY_QZONECOVER_UPLOADQUALITY = "UploadQuality";
  public static final String SECONDARY_QZONECOVER_UPLOADRESOLUTION = "UploadResolution";
  public static final String SECONDARY_QZONESETTINGS_AIO_FEEDS_MAX_RETRY_COUNT = "NewestFeedsRetryNum";
  public static final String SECONDARY_QZONESETTINGS_AIO_FEEDS_MAX_UIN_NUM = "NewestFeedsUinNum";
  public static final String SECONDARY_QZONESETTINGS_AIO_FEEDS_MIN_REFRESH_TIME = "NewestFeedsMinRefreshTimeCell";
  public static final String SECONDARY_QZONESETTINGS_AIO_FEEDS_MIN_TIME = "NewestFeedsMinTimeCell";
  public static final String SECONDARY_QZONESETTINGS_MAXCOMMENT_BUBBLE_TEXTCOUNT = "maxCommentBubbleTextCount";
  public static final String SECONDARY_QZONESETTINGS_MAXUGCTEXTCOUNT = "maxUgcTextCount";
  public static final String SECONDARY_QZONESETTINGS_MOOD_SEND_MINTIMES = "QzoneMoodSendMinTime";
  public static final String SECONDARY_QZONESETTINGS_MULTISHAREMAXCOUNR = "multiShareMaxCount";
  public static final String SECONDARY_QZONESETTINGS_SHAREMAXSELECTCOUNT = "shareMaxSelectCount";
  public static final String SECONDARY_QZONESETTINGS_WHO_CAN_COMMENT_SETTING = "whoCanCommentMyQzone";
  public static final String SECONDARY_QZONE_ALBUM_DOMAIN_LIST = "qzoneAlbumDomainList";
  public static final String SECONDARY_QZONE_BLOGLIST = "BlogListJumpUrl";
  public static final String SECONDARY_QZONE_CALL_APP_URL_LIST = "QzoneCallAppUrlList";
  public static final String SECONDARY_QZONE_DESCRIPTIONSETTING = "DescriptionSetting";
  public static final String SECONDARY_QZONE_FACE_SCAN_BLACKLIST = "qzone_face_scan_blacklist";
  public static final String SECONDARY_QZONE_FACE_SCAN_SWITCH = "qzone_face_scan_switch";
  public static final String SECONDARY_QZONE_FEED_PRELOAD = "EnableFeedPreload";
  public static final String SECONDARY_QZONE_GIFTDETAILPAGE = "GiftDetailPage";
  public static final String SECONDARY_QZONE_GIF_MINI_FRAME = "QzoneGifMiniFrame";
  public static final String SECONDARY_QZONE_GPS_COMPLEMENT = "QzoneGpsComplement";
  public static final String SECONDARY_QZONE_GPS_SWITCH = "QzoneGpsSwitch";
  public static final String SECONDARY_QZONE_GPS_TRACE = "QzoneGpsTrace";
  public static final String SECONDARY_QZONE_JUMPAVATALISTPAGE = "Avatalistpage";
  public static final String SECONDARY_QZONE_LAUNCH_SLOW_TIME = "qzone_launch_slow_threshold";
  public static final String SECONDARY_QZONE_PHONELABELSETTING = "PhoneLabelSetting";
  public static final String SECONDARY_QZONE_PICUTRE_SETTING_PAGE = "QzonePictureSettingPage";
  public static final String SECONDARY_QZONE_REG_STRING_MATCHER_LRU_MAP_SIZE = "QzoneRegLruMapSize";
  public static final String SECONDARY_QZONE_SETTING_AUTO_SCROLL_TO_NEXT_VIDEO_DELAY_TIME = "AutoScrollToNextVideoDelayTime";
  public static final int SECONDARY_QZONE_SETTING_AUTO_SCROLL_TO_NEXT_VIDEO_DELAY_TIME_DEFAULT = 1000;
  public static final String SECONDARY_QZONE_SETTING_FEEDS_SINGLE_PICTURE_BIG_PICTURE_MODE_COEFFICIENT = "FeedsSinglePictureBigPictureModeCoefficent";
  public static final String SECONDARY_QZONE_SETTING_FEED_NICK_NAME_SPLASHCOUNT = "FeedNickNameSplashCount";
  public static final String SECONDARY_QZONE_SETTING_MAIN_PAGE = "QzoneSettingMainPage";
  public static final String SECONDARY_QZONE_SETTING_RES_FORBIDDEN_LIST = "ResForbiddenList";
  public static final String SECONDARY_QZONE_SETTING_VIDEO_IDLE_SCROLL_Y_MIN_DISTANCE = "VideoIdleScrollYMinDistance";
  public static final String SECONDARY_QZONE_SETTING_VIDEO_RECOMMEND_AUTO_ROTATION_ENABLE = "VideoRecommendAutoRotationEnable";
  public static final int SECONDARY_QZONE_SETTING_VIDEO_RECOMMEND_AUTO_ROTATION_ENABLE_DEFAULT = 0;
  public static final String SECONDARY_QZONE_SETTING_VIDEO_RECOMMEND_CLEAR_REPORT_LIST = "VideoRecommendClearReportList";
  public static final int SECONDARY_QZONE_SETTING_VIDEO_RECOMMEND_CLEAR_REPORT_LIST_DEFAULT = 1;
  public static final String SECONDARY_QZONE_SETTING_VIDEO_RECOMMEND_NEED_CHECK_APP_ENTER_BACKGROUND = "VideoRecommendNeedCheckAppEnterBackground";
  public static final int SECONDARY_QZONE_SETTING_VIDEO_RECOMMEND_NEED_CHECK_APP_ENTER_BACKGROUND_DEFAULT = 0;
  public static final String SECONDARY_QZONE_SHOW_BREEZE_BLACK_LIST = "qzoneShow_breeze_black_list";
  public static final String SECONDARY_QZONE_SHOW_ICON_DISPLAY = "enableQzoneShowIconAtHomePage";
  public static final int SECONDARY_QZONE_SHOW_ICON_DISPLAY_DEFAULT = 1;
  public static final String SECONDARY_QZONE_STARTUP_REPORT_CODE_TIME = "qzoneStartupReportCodeTime";
  public static final String SECONDARY_QZONE_VIDEO_MAX_TIME = "QzoneVideoMaxTime";
  public static final String SECONDARY_QZONE_VIDEO_MINI_FRAME = "QzoneVideoMiniFrame";
  public static final String SECONDARY_QZONE_VIP_PAYMENT = "FloatingViewForPay";
  public static final String SECONDARY_QZONE_VISIT_DOWNLOAD = "QzoneVisitDownload";
  public static final String SECONDARY_REACT_BUNDLE_SERVER = "ReactBundleServerUrl";
  public static final String SECONDARY_REACT_ENABLE_PRELOAD = "ReactEnablePreload";
  public static final String SECONDARY_REACT_ENABLE_V8 = "ReactEnableV8";
  public static final String SECONDARY_REACT_MAX_CRASH_TIMES = "RNMessageMaxCrashTimes";
  public static final String SECONDARY_REACT_PSKEY_SWITCH = "ReactPsKeySwitch";
  public static final String SECONDARY_REACT_SWITCH = "SwitchReact";
  public static final String SECONDARY_RECENT_PHOTO_BLOCK_PATHS = "RecentPhotoBlockPaths";
  public static final String SECONDARY_RECENT_PHOTO_CAMERA = "RecentPhotoCamera";
  public static final int SECONDARY_RECENT_PHOTO_CAMERA_DEFAULT = 1;
  public static final String SECONDARY_RECENT_PHOTO_CAROUSEL_COUNT = "recentPhotoCarouselCount";
  public static final String SECONDARY_RECENT_PHOTO_LIMIT_SIZE = "RecentPhotoLimitSize";
  public static final String SECONDARY_RECENT_PHOTO_LIMIT_WIDTH = "RecentPhotoLimitWidth";
  public static final String SECONDARY_RECOMMEND_VIDEO_TIP = "RecommendVideoTip";
  public static final String SECONDARY_REDPOCKET_HEIGHT = "RedPocket_height";
  public static final String SECONDARY_REDPOCKET_PAYLIST = "RedPocketPayList";
  public static final String SECONDARY_REDPOCKET_PLUS_ENTRY_TEXT = "redpocketPlusEntryText";
  public static final String SECONDARY_REDPOCKET_REQUEST_TIME_OUT = "redpocketRequestTimeOut";
  public static final String SECONDARY_REDPOCKET_WIDTH = "RedPocket_Width";
  public static final String SECONDARY_REDPOCKT_INTOOLS = "secondRedPockedtIntools";
  public static final String SECONDARY_REFRESH_INTERVAL = "FriendFeedRefreshInternal";
  public static final String SECONDARY_REGULAR_HTTP2_GRAY_CONFIG = "http2GrayConfig";
  public static final String SECONDARY_REPORT = "Report";
  public static final String SECONDARY_REPORT_BACKGROUDMONITOR = "report_backgroudmonitor";
  public static final String SECONDARY_REQUEST_AIO_FEEDS_AND_SIGNATURE_LEAST_INTERVAL_TIME = "aioFeedsAndSingnatureLeastIntervalTime";
  public static final String SECONDARY_REQUEST_AIO_FEEDS_DIV = "requestAIOFeedsDiv";
  public static final String SECONDARY_REQUEST_BULLETS = "RequestBullets";
  public static final String SECONDARY_REQUIRED_CPU_FEATURES = "RequiredCpuFeatures";
  public static final String SECONDARY_RETRY_MAXNUM = "RetryMaxNum";
  public static final String SECONDARY_RETRY_RETCODE = "retry_retCode";
  public static final String SECONDARY_SAFEMODE_CRASH_CLEAR_ITEMS = "CrashClearItems";
  public static final String SECONDARY_SAFEMODE_CRASH_MAX = "CrashMax";
  public static final String SECONDARY_SAFEMODE_START_DURATION = "StartDuration";
  public static final String SECONDARY_SCHEMA_BLACK_LIST = "schemablacklist";
  public static final String SECONDARY_SECRET_FEED_DETAIL_H5_URL = "OpenSecretFeedDetailH5Url";
  public static final String SECONDARY_SECRET_FEED_LIST_H5_URL = "OpenSecretFeedListH5Url";
  public static final String SECONDARY_SELECT_TEMPLATE_DYNAMIC_ALBUM_URL = "selectTemplateDynamicAlbumUrl";
  public static final String SECONDARY_SEND_BIRTHDAY_GIFT = "SendBirthdayGift";
  public static final String SECONDARY_SERVER_PORT_LIST = "UploadPort";
  public static final String SECONDARY_SHARE_ALBUM_ALLOW_INVITE_TO_FEEDS = "ShareAlbumAllowInviteToFeeds";
  public static final String SECONDARY_SHARE_ALBUM_INVITE_TO_FEEDS_URL = "shareAlbumInviteToFeedsUrl";
  public static final String SECONDARY_SHARE_ALBUM_TO_MINIPROGRAM = "AlbumShareToMiniProgram";
  public static final String SECONDARY_SHARE_WHITE_LIST = "sharewhitelist";
  public static final String SECONDARY_SHORT_VIDEO_CAN_UPLOAD_DURATION_THRESHOLD = "VideoCanUploadDurationThreshold";
  public static final String SECONDARY_SHORT_VIDEO_CAN_UPLOAD_SIZE_THRESHOLD = "VideoCanUploadSizeThreshold";
  public static final String SECONDARY_SHORT_VIDEO_DURATION_THRESHOLD = "VideoDurationThreshold";
  public static final String SECONDARY_SHOULD_SHARE_PARTNER_SHOW_ADD_ICON = "ShouldSharePartnerShowAddIcon";
  public static final String SECONDARY_SHOW_DELICACY_PICTURE = "ShowMoreDelicacyPicture";
  public static final String SECONDARY_SHOW_ENTER_LIVE_SECONDS = "ShowEnterLiveSeconds";
  public static final String SECONDARY_SHOW_FEED_GAME_TAB = "ShowNavigatorGameTab";
  public static final String SECONDARY_SHOW_FEED_OPERATION_LAYER = "ShowFeedOpLayer";
  public static final String SECONDARY_SHOW_MAGIC_STICK = "ShowMagicStick";
  public static final String SECONDARY_SHOW_RECOMMEND_PAGE_ENTRY = "ShowRecommendPageEntry";
  public static final String SECONDARY_SHOW_SIGNIN_BANNER = "ShowSigninBanner";
  public static final String SECONDARY_SHUOSHUO_CAMERA_ICON = "secondary_shuoshuo_camera_icon";
  public static final String SECONDARY_SHUOSHUO_SHOW_WEBPICTURE = "ShuoshuoShowWebPicture";
  public static final String SECONDARY_SHUOSHUO_TOOLBAR_SHOW_DONGGANYINGJI = "shuoshuoShowDongganyingji";
  public static final String SECONDARY_SHUOSHUO_UPLOAD_VIDEO_MAX_COUNT = "ShuoShuoMaxSelectVideoNum";
  public static final String SECONDARY_SIGN_IN = "SignIn";
  public static final String SECONDARY_SIM_QUERY = "SimQueryTimeout";
  public static final String SECONDARY_SIM_QUERY_DELAY = "SimQueryDelay";
  public static final String SECONDARY_SIM_QUERY_STATUS = "SimQueryStatus";
  public static final String SECONDARY_SMALL_GAME_HTML_LOAD_MTA_REPORT_ENABLE = "SmallGameHtmlLoadMtaReportEnable";
  public static final String SECONDARY_SMART_DNSSERVICE = "SmartHttpDnsService";
  public static final String SECONDARY_SMART_REPORT_Data_Acquisition_CONFIG = "SmartReportDataAcquisitionConfig";
  public static final String SECONDARY_SPECIALPUSH_HIDE = "SpecialPushHide";
  public static final String SECONDARY_SPECIAL_CARD_FRIEND_MANAGER_PAGE = "SpecialFriendManage";
  public static final String SECONDARY_STARTUP_FAILED_MSG = "qzone_startup_fail_msg";
  public static final String SECONDARY_STARTUP_FAILED_NEED_UPLOAD_LOG = "qzone_startup_failed_need_upload_log";
  public static final String SECONDARY_STARTUP_FAILED_TOAST_SHOW_LIMIT = "qzone_startup_failed_toast_show_limit";
  public static final String SECONDARY_START_SHOW_ENTER_LIVE_HINT = "StartShowEnterLiveHint";
  public static final String SECONDARY_STAR_VIP_MAIN_PAGE_URL = "StarVipUrl";
  public static final String SECONDARY_STAR_VIP_PAY_URL = "StarVipMainPageUrl";
  public static final String SECONDARY_SUPERCOVER_CPU_LEVEL = "SuperCoverCpuLevel";
  public static final String SECONDARY_SUPERCOVER_MEMORY_LEVEL = "SuperCoverMemoryLevel";
  public static final String SECONDARY_SUPERCOVER_PERFORMANCE_4CORE_CPU_RAM_SIZE = "SuperCoverStandard4CoreCpuRamSize";
  public static final String SECONDARY_SUPERCOVER_PERFORMANCE_CPU_CORE = "SuperCoverStandardCpuCore";
  public static final String SECONDARY_SUPERCOVER_PERFORMANCE_CPU_FEQUENCY = "SuperCoverStandardCpuFequency";
  public static final String SECONDARY_SUPERCOVER_PERFORMANCE_CPU_RAM_SIZE = "SuperCoverStandardCpuRamSize";
  public static final String SECONDARY_SUPER_FONT_LIST_ATTACH_INFO = "DiySuperFontAttachinfo";
  public static final String SECONDARY_SUPER_RESOLUTION_BENCHMARK_EXPIRE_TIME = "superResolutionBenchmarkExpireTime";
  public static final String SECONDARY_SUPER_RESOLUTION_CPU_SO_LENGTH = "superResolutionCpuSoLength";
  public static final String SECONDARY_SUPER_RESOLUTION_CPU_SO_MD5 = "superResolutionCpuSoMd5";
  public static final String SECONDARY_SUPER_RESOLUTION_DEFAULT_MODEL_ID = "superResolutionDefaultModelId";
  public static final String SECONDARY_SUPER_RESOLUTION_ENABLE_HIGH_SCALE = "superResolutionEnableHighScale";
  public static final String SECONDARY_SUPER_RESOLUTION_ENABLE_PRE_INIT_LIBRARY = "superResolutionEnablePreInitLibrary";
  public static final String SECONDARY_SUPER_RESOLUTION_ENABLE_REPORT_NONE_SR_TIME = "enableReportNoneSrTime";
  public static final String SECONDARY_SUPER_RESOLUTION_GPU_MAX_SIZE = "superResolutionGpuMaxSize";
  public static final String SECONDARY_SUPER_RESOLUTION_GPU_RATIO_BOUNDARY = "superResolutionGpuRatioBoundary";
  public static final String SECONDARY_SUPER_RESOLUTION_GPU_SO_LENGTH = "superResolutionGpuSoLength";
  public static final String SECONDARY_SUPER_RESOLUTION_GPU_SO_MD5 = "superResolutionGpuSoMd5";
  public static final String SECONDARY_SUPER_RESOLUTION_HIGH_SCALE_TIPS = "superResolutionHighScaleTips";
  public static final String SECONDARY_SUPER_RESOLUTION_MEMORY_THRESHOLD = "superResolutionMemoryThreshold";
  public static final String SECONDARY_SUPER_RESOLUTION_MODEL_CONFIG = "superResolutionModelConfig";
  public static final String SECONDARY_SUPER_RESOLUTION_NNPACK_SO_LENGTH = "superResolutionNnpackSoLength";
  public static final String SECONDARY_SUPER_RESOLUTION_NNPACK_SO_MD5 = "superResolutionNnpackSoMd5";
  public static final String SECONDARY_SUPER_RESOLUTION_QA_PARAMETER_REX = "superResolutionQAParameterRex";
  public static final String SECONDARY_SUPER_RESOLUTION_RUN_BENCHMARK_CPU_THRESHOLD = "runBenchmarkCpuThreshold";
  public static final String SECONDARY_SUPER_RESOLUTION_SCALE_THRESHOLD = "superResolutionScaleThreshold";
  public static final String SECONDARY_SUPER_RESOLUTION_SR_PARAMETER_REX = "superResolutionSRParameterRex";
  public static final String SECONDARY_SUPPORTED_CPU_FAMILY = "SupportedCpuFamily";
  public static final String SECONDARY_SUPPORT_CLIP_MAX_TIME = "SupportClipMaxTime";
  public static final String SECONDARY_SUPPORT_EDIT_VIDEO = "SupportEditVideo";
  public static final String SECONDARY_SUPPORT_MIX_MUSIC_MAX_SIZE = "SupportMixMusicMaxSize";
  public static final String SECONDARY_SUPPORT_PHOTO_MERGE = "SupportPhotoMerge";
  public static final String SECONDARY_SUPPORT_RECORD = "SupportMiniVideo";
  public static final String SECONDARY_SUPPORT_TRIM = "SupportTrimVideo";
  public static final String SECONDARY_SUPPORT_TRIM_HW = "SupportTrimVideoHW";
  public static final String SECONDARY_SUPPORT_VIDEO_CHECKBOX = "SupportVideoCheckbox";
  public static final String SECONDARY_TAKE_PHOTO_USING_QQ_CAMERA = "takePhotoUsingQqCamera";
  public static final String SECONDARY_TCSDKREPORT_URL = "TcSDKReportURL";
  public static final String SECONDARY_TENCENT_VIDEO_REQUEST_LEVEL = "tencentVideoRequestLevel";
  public static final int SECONDARY_TENCENT_VIDEO_REQUEST_LEVEL_DEFAULT = 16;
  public static final String SECONDARY_TEXT_TO_BITMAP = "TextToBitmap";
  public static final String SECONDARY_THIRD_WEB_DOWNLOAD = "ThirdWebDownLoad";
  public static final String SECONDARY_THREAD_REGULATED_ENABEL = "threadRegulateEnable";
  public static final String SECONDARY_TIANTAI_CAN_PRE_OPEN_WEBVIEW = "CanPreOpenWebview";
  public static final String SECONDARY_TIANTAI_HIDE_WIDGET_DISTANCE = "TiantaiHideWidgetDistance";
  public static final String SECONDARY_TIANTAI_IMAGE_GUIDE_MARGIN_BOTTOM = "TiantaiImageGuideMarginBottom";
  public static final String SECONDARY_TIANTAI_IMAGE_SCROLL_MIN = "TiantaiImageScrollMin";
  public static final String SECONDARY_TIANTAI_PULL_SHOW_ALL_DISTANCE = "TiantaiPullShowAllDistance";
  public static final String SECONDARY_TIME_DELAY_TO_GET_GUIDE_QBOSS_ADV = "time_delay_to_get_guide_qboss_adv";
  public static final String SECONDARY_TOUCHQZONE_BLOG = "TouchQzoneBlog";
  public static final String SECONDARY_TOUCHQZONE_GIFT = "TouchQzoneGift";
  public static final String SECONDARY_TOUCHQZONE_MOOD = "TouchQzoneMood";
  public static final String SECONDARY_TOUCHQZONE_MSGB = "TouchQzoneMsgb";
  public static final String SECONDARY_TOUCHQZONE_OTHER = "TouchQzoneOther";
  public static final String SECONDARY_TOUCHQZONE_PHOTO = "TouchQzonePhoto";
  public static final String SECONDARY_TOUCHQZONE_PROFILE = "TouchQzoneProfile";
  public static final String SECONDARY_TOUCHQZONE_SHARE = "TouchQzoneShare";
  public static final String SECONDARY_TRAVELING_BOTTOM_PHOTO = "TravelingBottomPhoto";
  public static final String SECONDARY_TRUE_TYPE_VIEW_CACHE = "TrueTypeViewCache";
  public static final String SECONDARY_TTPIC = "ttpicPopupMenuSwitch";
  public static final String SECONDARY_TTPIC_DATOU = "ttpicOpenSticker";
  public static final String SECONDARY_TTPIC_LIMITED = "PituLimited";
  public static final String SECONDARY_TTPIC_SO_ZIP_URL = "TtpicSoZipUrl";
  public static final String SECONDARY_TTPIC_SO_ZIP_URL_DEFAULT = "http://qzonestyle.gtimg.cn/qzone/photo/v7/js/common/images/lib_ttpic_so.zip";
  public static final String SECONDARY_UGC_LIVEVIDEO_PRE_LOAD_ENTER_ROOM_IP_ENABLE = "UGCLiveVideoPreLoadEnterRoomIpEnable";
  public static final int SECONDARY_UGC_LIVEVIDEO_PRE_LOAD_ENTER_ROOM_IP_ENABLE_DEFAULT = 1;
  public static final String SECONDARY_UGC_PERMIT_SETTING = "UgcPermitSetting";
  public static final String SECONDARY_UNPUBLISH_SHUO_SHUO_H5_URL = "UnpublishShuoShuoH5Url";
  public static final String SECONDARY_UPDATE_COUNT_INTERVAL_WHENACTIVEAPP = "UpdateCountIntervalWhenActiveApp";
  public static final String SECONDARY_UPDATE_COUNT_INTERVAL_WHENCLICKFEEDTAB = "UpdateCountIntervalWhenClickFeedTab";
  public static final String SECONDARY_UPLOAD_ALBUM_MAX_PHOTO_COUNT = "AlbumMaxPhotoCount";
  public static final String SECONDARY_UPLOAD_AVCODEC_DOWNLOAD_TIMEOUT = "UploadAvcodecDownloadTimeOut";
  public static final String SECONDARY_UPLOAD_BATCH_CONTROL_COUNT_2G = "BatchControlCount2G";
  public static final String SECONDARY_UPLOAD_BATCH_CONTROL_COUNT_3G = "BatchControlCount3G";
  public static final String SECONDARY_UPLOAD_BATCH_CONTROL_COUNT_WIFI = "BatchControlCountWifi";
  public static final String SECONDARY_UPLOAD_CHANGEROUTE_RETCODE = "UploadChangeRouteRetCode";
  public static final String SECONDARY_UPLOAD_CHECK_FACE_NUM = "uploadCheckFaceNum";
  public static final String SECONDARY_UPLOAD_CONNECT_TIMEOUT = "ConnectTimeout";
  public static final String SECONDARY_UPLOAD_COVER_STRATEGY = "UploadCoverStrategy";
  public static final String SECONDARY_UPLOAD_DATA_TIMEOUT = "DataTimeout";
  public static final String SECONDARY_UPLOAD_ENABLE_DOWNLOAD_SO = "UploadEnableDownloadSo";
  public static final String SECONDARY_UPLOAD_EXCEPTION_REPORT_SAMPLE = "ReportLogSample";
  public static final String SECONDARY_UPLOAD_FACE_FUNTION = "uploadFaceFuntion";
  public static final String SECONDARY_UPLOAD_FILE_CONCURRENT_2G = "FileConcurrent2G";
  public static final String SECONDARY_UPLOAD_FILE_CONCURRENT_3G = "FileConcurrent3G";
  public static final String SECONDARY_UPLOAD_FILE_CONCURRENT_WIFI = "FileConcurrentWifi";
  public static final String SECONDARY_UPLOAD_LP_REPORT_NOW = "UploadLPReportNow";
  public static final String SECONDARY_UPLOAD_LP_REPORT_SAMPLE = "UploadReportNeedSmaple";
  public static final String SECONDARY_UPLOAD_MAX_CONCURRENT_NUM = "MaxConcurrentNum";
  public static final String SECONDARY_UPLOAD_MD5 = "QzoneUploadSoMD5";
  public static final String SECONDARY_UPLOAD_MOOD_PREUPLOAD = "MoodPreloadNetConfig";
  public static final String SECONDARY_UPLOAD_NETWORK_UNAVAILABLE_RETCODE = "UploadNetworkUnavailableRetCode";
  public static final String SECONDARY_UPLOAD_PREUPLOAD_COUNT_2G = "PreloadCount2G";
  public static final String SECONDARY_UPLOAD_PREUPLOAD_COUNT_3G = "PreloadCount3G";
  public static final String SECONDARY_UPLOAD_PREUPLOAD_COUNT_WIFI = "PreloadCountWifi";
  public static final String SECONDARY_UPLOAD_SHOW_POPWINDOW_TIMES = "uploadShowPopwindowTimes";
  public static final String SECONDARY_UPLOAD_SO = "QzoneUploadSo";
  public static final String SECONDARY_UPLOAD_SOCKET_COUNT_2G = "SocketCount2G";
  public static final String SECONDARY_UPLOAD_SOCKET_COUNT_3G = "SocketCount3G";
  public static final String SECONDARY_UPLOAD_SOCKET_COUNT_WIFI = "SocketCountWifi";
  public static final String SECONDARY_UPLOAD_TIMEOUT_RETRY_COUNT = "TimeoutRetryCount";
  public static final String SECONDARY_UPLOAD_VERSION = "UseUploadV2";
  public static final String SECONDARY_UPLOAD_VIDEO_FILE_RETRY_COUNT = "VideoFileRetryCount";
  public static final String SECONDARY_UPLOAD_VIDEO_FILE_SIZE_LIMIT = "FileSizeLimit";
  public static final String SECONDARY_UPLOAD_VIDEO_FILE_SIZE_LIMIT_FOR_NON_VIP = "FileSizeLimitForNonVip";
  public static final String SECONDARY_UPLOAD_VIDEO_MAX_COUNT = "MaxSelectVideoNum";
  public static final String SECONDARY_UPLOAD_VIDEO_PART_CONCURRENT_COUNT = "VideoPartConcurrentCount";
  public static final String SECONDARY_UPLOAD_VIDEO_PART_RETRY_COUNT = "VideoPartRetryCount";
  public static final String SECONDARY_UPLOAD_VIDEO_PART_SIZE = "VideoPartSize";
  public static final String SECONDARY_UPLOAD_VIDEO_PART_SIZE_2G = "VideoPartSizeFor2G";
  public static final String SECONDARY_UPLOAD_VIDEO_PART_SIZE_3G = "VideoPartSizeFor3G";
  public static final String SECONDARY_URL_ANALYSIS = "UrlAnalysisSwitch";
  public static final String SECONDARY_USC_ALL_FUNCTION_MASK = "USCAllFunctionMask";
  public static final String SECONDARY_USC_BATCH_PRIORITY = "USCBatchPriority";
  public static final String SECONDARY_USC_CPU_CORES = "USCCPUCores";
  public static final String SECONDARY_USC_CPU_THRESHOLD = "USCCpuThreshold";
  public static final String SECONDARY_USC_EXIF_COMPATIBLE_VERSION = "USCExifCompatibleVersion";
  public static final String SECONDARY_USC_EXIF_CURRENT_VERSION = "USCExifCurrentVersion";
  public static final String SECONDARY_USC_EXIF_ENABLE = "USCExifEnable";
  public static final String SECONDARY_USC_FORBIDDEN_DIR = "USCForbiddenDir";
  public static final String SECONDARY_USC_HIGH_MEMORY_THRESHOLD = "USCHighMemoryThreshold";
  public static final String SECONDARY_USC_LOW_MEMORY_THRESHOLD = "USCLowMemoryThreshold";
  public static final String SECONDARY_USC_MEMORY_THRESHOLD = "USCMemoryThreshold";
  public static final String SECONDARY_USC_NEED_DECODE_MASK = "USCNeedDecodeMask";
  public static final String SECONDARY_USC_PHOTO_MAX_SIZE = "USCPhotoMaxSize";
  public static final String SECONDARY_USC_PHOTO_MIN_SIZE = "USCPhotoMinSize";
  public static final String SECONDARY_USC_SCAN_ALL_ENABLE = "USCScanAllEnable";
  public static final String SECONDARY_USC_SCAN_MIME_TYPE = "USCScanMimeType";
  public static final String SECONDARY_USC_SCREEN_OFF_ENABLE = "USCScreenOffEnable";
  public static final String SECONDARY_USC_UPDATE_MASK_CACHE_THRESHOLD = "USCUpdateMaskCacheThreshold";
  public static final String SECONDARY_USC_WATCHDOG_CPU_RATE = "USCWatchdogCpuRate";
  public static final String SECONDARY_USC_WATCHDOG_INTERVAL_TIME = "USCWatchDogIntervalTime";
  public static final String SECONDARY_USC_WATCHDOG_MEMRORY_RATE = "USCWatchDogMemoryRate";
  public static final String SECONDARY_USC_WATCHDOG_READ_CPU_ERROR_LIMIT = "USCReadCpuLimit";
  public static final String SECONDARY_USC_WATCHDOG_READ_CPU_ERROR_RETURN = "USCReadCpuErrorReturn";
  public static final String SECONDARY_USERHOME_BAR_CAMPUS_ZONE_SCHEMA = "bar_campuszone_schema";
  public static final String SECONDARY_USERHOME_BAR_FAMOUS_ZONE_SCHEMA = "bar_famouszone_schema";
  public static final String SECONDARY_USERHOME_BAR_FAMOUS_ZONE_SHOW = "bar_famouszone_visible";
  public static final String SECONDARY_USERHOME_BAR_ICON_URL = "bar_iconurl";
  public static final String SECONDARY_USERHOME_BAR_LOVER_ZONE_ICON_URL = "bar_loversspace_iconurl";
  public static final String SECONDARY_USERHOME_BAR_LOVER_ZONE_NAME = "bar_loversspace_name";
  public static final String SECONDARY_USERHOME_BAR_LOVER_ZONE_SHOW = "bar_loversspace_visible";
  public static final String SECONDARY_USERHOME_BAR_MUSIC_BAR_SHOW = "bar_music_visiable";
  public static final String SECONDARY_USERHOME_BAR_NAME = "bar_name";
  public static final String SECONDARY_USERHOME_BAR_PERSONALIZE_COUNTID = "bar_personalize_countid";
  public static final String SECONDARY_USERHOME_BAR_PERSONALIZE_ICON_URL = "bar_personalize_iconurl";
  public static final String SECONDARY_USERHOME_BAR_PERSONALIZE_NAME = "bar_personalize_name";
  public static final String SECONDARY_USERHOME_BAR_PERSONALIZE_SCHEMA = "bar_personalize_schema";
  public static final String SECONDARY_USERHOME_BAR_PERSONALIZE_SHOW = "bar_personalize_visiable";
  public static final String SECONDARY_USERHOME_BAR_SCHEMA = "bar_schema";
  public static final String SECONDARY_USERHOME_BAR_SHOW = "bar_visiable";
  public static final String SECONDARY_USERHOME_BAR_YELLOW_DIAMOND_ICON_URL = "bar_vip_iconurl";
  public static final String SECONDARY_USERHOME_BAR_YELLOW_DIAMOND_NAME = "bar_vip_name";
  public static final String SECONDARY_USERHOME_BAR_YELLOW_DIAMOND_SHOW = "bar_vip_visible";
  public static final String SECONDARY_USERHOME_BAR_YELLOW_DIAMOND_URL = "bar_vip_jumpurl";
  public static final String SECONDARY_USERHOME_DYNAMIC_SETTING_URL = "QZoneUserHomeDynamicSettingUrl";
  public static final String SECONDARY_USERHOME_FRIEND_SETTING = "FriendSetting";
  public static final String SECONDARY_USERHOME_MORE_MENU_COVER_SETTING_SHOW = "more_menu_famouszone_cover_setting_visible";
  public static final String SECONDARY_USERHOME_MORE_MENU_FRIEND_FEED_SETTING_SHOW = "more_menu_famouszone_friend_feed_setting_visible";
  public static final String SECONDARY_USERHOME_MORE_MENU_SHARE_BACKGROUND_URL = "more_menu_share_background_url";
  public static final String SECONDARY_USERHOME_MORE_MENU_SHARE_DESCRIPTION = "more_menu_share_description";
  public static final String SECONDARY_USE_JPEG_EXIF_READER = "useJpegExifReader";
  public static final String SECONDARY_USE_MORE_FRENQUENCY_PHOTO_TO_CREATE_GROUP_NAME = "second_use_more_frequency_photo_to_create_group_name";
  public static final String SECONDARY_USE_MORE_FRENQUENCY_PHOTO_TO_DIVING_GROUP_NUM = "second_group_diving_num_get_more_frequency_photo";
  public static final String SECONDARY_USE_QQ_CAMERA_COMPRESSION = "UseQQCameraCompression";
  public static final int SECONDARY_USE_QQ_CAMERA_COMPRESSION_DEFAULT = 2;
  public static final String SECONDARY_USE_QQ_CAMERA_CONFIG = "UseQQCameraConfig";
  public static final String SECONDARY_USE_QQ_CAMERA_CONFIG_DEFAULT = "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1500#4000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;4000#6500#3#9#55|1|dynamic=0";
  public static final String SECONDARY_USE_QQ_EMOTICON_COMMENT = "UseQQEmoticonComment";
  public static final String SECONDARY_VERIFY_QQ_VIDEO = "VerifyQQVideo";
  public static final String SECONDARY_VERTICAL_DOWNLOAD_PROGRESS_BACKGROUND_URL = "VerticalDownloadProgressBackgroundUrl";
  public static final String SECONDARY_VERTICAL_PLUGIN_DOWNLOAD_CANCELED_ON_CLOSE_BTN = "PluginDownloadCanceledOnCloseBtn";
  public static final String SECONDARY_VERTICAL_USE_QQ_MANAGER = "verticalUseQQPluginManager";
  public static final String SECONDARY_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_CANCEL_MSG = "VerticalVideoLayerGuideDialogCancelMsg";
  public static final String SECONDARY_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_MSG = "VerticalVideoLayerGuideDialogMsg";
  public static final String SECONDARY_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_OK_MSG = "VerticalVideoLayerGuideDialogOkMsg";
  public static final String SECONDARY_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_TITLE = "VerticalVideoLayerGuideDialogTitle";
  public static final String SECONDARY_VERTICAL_VIDEO_LAYER_GUIDE_SCHEME = "VerticalVideoLayerGuideScheme";
  public static final String SECONDARY_VERTICAL_VIDEO_PLUGIN_SIZE_TEXT = "VerticalVideoPluginSizeText";
  public static final String SECONDARY_VERTICAL_VIDEO_PLUGIN_UPDATE_TIPS = "VerticalVideoPluginUpdateTips";
  public static final String SECONDARY_VIDEOEDIT_LOAD_VIDEO_FIALED_RETURN_CODE = "VideoLoadErrorReturnCode";
  public static final String SECONDARY_VIDEOEDIT_UPLOAD_MAX_SIZE_TIP_WITH_NO_WIFI = "UploadMaxSizeTipWithNoWifi";
  public static final String SECONDARY_VIDEOEDIT_VIDEOBGMUSIC_SELECTURL = "VideoBgMusicSelectUrl";
  public static final String SECONDARY_VIDEOEDIT_VIP_QUALITY_LIMIT_SIZE = "VipQualityLimitSize";
  public static final String SECONDARY_VIDEO_AUTO_PLAY_TIPS = "VideoAutoPlayTips";
  public static final String SECONDARY_VIDEO_CACHE_PROVIDER = "videoCacheProvider";
  public static final int SECONDARY_VIDEO_CACHE_PROVIDER_DEFAULT = 1;
  public static final String SECONDARY_VIDEO_CHANGE_VKEY_WAIT_TIMEOUT = "WaitVkeyTimeout";
  public static final String SECONDARY_VIDEO_CHECK_FEEDS = "checkVideoFeeds";
  public static final String SECONDARY_VIDEO_CHECK_RECOMMEND = "checkVideoRecommend";
  public static final String SECONDARY_VIDEO_COMPRESS_SW_TRIM_AVERAGE_SPEED = "videoCompressSwTrimAverageSpeed";
  public static final String SECONDARY_VIDEO_COMPRESS_TIMEOUT_RECORD = "videoCompressTimeoutRecord";
  public static final String SECONDARY_VIDEO_COMPRESS_TIMEOUT_TRIM = "videoCompressTimeoutTrim";
  public static final String SECONDARY_VIDEO_CONTENT_TYPE = "videoContentType";
  public static final String SECONDARY_VIDEO_COVER_DURATION = "VideoCoverDuration";
  public static final String SECONDARY_VIDEO_COVER_RECORD_DURATION = "VideoCoverRecordDuration";
  public static final String SECONDARY_VIDEO_DEFINITION_MOBILE_CONN = "videodefinitionmobileconn";
  public static final String SECONDARY_VIDEO_DEFINITION_WIFI = "videodefinitionwifi";
  public static final String SECONDARY_VIDEO_DISPLAY_FOLLOW_BUTTON = "displayFollowButtonInVideoLayer";
  public static final String SECONDARY_VIDEO_ENABLE_ACTIVITY_DEFAULT_DETAIL_REPORT = "videoEnableActivityDefaultDetailReport";
  public static final String SECONDARY_VIDEO_ENABLE_CACHE = "videoEnableCache";
  public static final String SECONDARY_VIDEO_ENABLE_PROXY = "videoEnableProxy";
  public static final String SECONDARY_VIDEO_FLOAT_CONTROLLER_TIMEOUT = "videoFloatControllerTimeout";
  public static final String SECONDARY_VIDEO_FOOTER = "videoFooter";
  public static final String SECONDARY_VIDEO_FRAME_RATE = "FrameRate";
  public static final String SECONDARY_VIDEO_HEIGHT_RATE = "Video_height_Rate";
  public static final String SECONDARY_VIDEO_HEIGHT_RATE_DETAIL = "Video_height_Rate_Detail";
  public static final String SECONDARY_VIDEO_HERO_PLAYER_LIBS_URL = "videoheroplayerlibsurl";
  public static final String SECONDARY_VIDEO_HOST_ENABLE_HTTPDNSSERVICE = "videoHostEnableHttpDnsService";
  public static final String SECONDARY_VIDEO_HOST_ENABLE_HTTPDNSSERVICE_PREPENDIP = "videoHostEnableHttpDnsServicePrependIp";
  public static final String SECONDARY_VIDEO_HW_BITRATE_MODE = "HwVideoBitrateMode";
  public static final String SECONDARY_VIDEO_HW_COMPRESS_ANDROID_VERSION = "HwCompressWhiteListAndroidVersion";
  public static final String SECONDARY_VIDEO_HW_COMPRESS_BLACKLIST = "HwCompressBlackList";
  public static final String SECONDARY_VIDEO_HW_FRAME_RATE = "HwFrameRate";
  public static final String SECONDARY_VIDEO_HW_LEVEL = "HwVideoLevel";
  public static final String SECONDARY_VIDEO_HW_LONGEST_EDGE = "HwVideoLongestEdge";
  public static final String SECONDARY_VIDEO_HW_MAX_BITRATE = "HwVideoMaxBitrate";
  public static final String SECONDARY_VIDEO_HW_PROFILE = "HwVideoProfile";
  public static final String SECONDARY_VIDEO_IFRAME_INTERVAL = "iFrameInterval";
  public static final String SECONDARY_VIDEO_ILLEGAL_CACHE_DURATION = "IllegalVideoCheckDataCacheDuration";
  public static final String SECONDARY_VIDEO_LEVEL = "VideoLevel";
  public static final String SECONDARY_VIDEO_LIST_BANNER_REQUEST_DURATION = "VideoListBannerReqDuration";
  public static final String SECONDARY_VIDEO_LIST_BANNER_REQUEST_QBOSS = "VideoListBannerRequestQboss";
  public static final String SECONDARY_VIDEO_LIST_BANNER_VISIBLE = "VideoListBannerVisible";
  public static final String SECONDARY_VIDEO_LIST_URL = "LiveList";
  public static final String SECONDARY_VIDEO_LITTLE_WINDOW_SETTING = "VideoFloatLittleWindows";
  public static final int SECONDARY_VIDEO_LITTLE_WINDOW_SETTING_DEFAULT = 0;
  public static final String SECONDARY_VIDEO_LONGEST_EDGE = "VideoLongestEdge";
  public static final String SECONDARY_VIDEO_LOW_SPEED_RATES = "videoLowSpeedRates";
  public static final String SECONDARY_VIDEO_LOW_SPEED_SECONDS = "videoLowSpeedSeconds";
  public static final int SECONDARY_VIDEO_LUGC_SHOW_TOP_BAR_DEFAULT = 0;
  public static final String SECONDARY_VIDEO_MAX_BITRATE = "VideoMaxBitrate";
  public static final String SECONDARY_VIDEO_MAX_CACHE_SIZE = "maxCacheSize";
  public static final String SECONDARY_VIDEO_MAX_SIZE_CM = "Video_MaxSize_CM";
  public static final String SECONDARY_VIDEO_NATIVE_LOG = "VideoNativeLog";
  public static final String SECONDARY_VIDEO_NEWPARAM = "VideoNewVideoCompressParam";
  public static final String SECONDARY_VIDEO_NEXT_PLAYID_TIME_STAMP = "ResumePlayReportMinTime";
  public static final String SECONDARY_VIDEO_NORMAL_PATH_TYPE = "videoNormalPathType";
  public static final String SECONDARY_VIDEO_OTHER_CONFIG = "OtherConfig";
  public static final String SECONDARY_VIDEO_PLAY_FLRST_SEGMENT = "videoplayfirstsegment";
  public static final String SECONDARY_VIDEO_PLUS_ENTRY_TEXT = "VideoPlusEntryText";
  public static final String SECONDARY_VIDEO_PRELOAD_DURATION = "preLoadDuration";
  public static final String SECONDARY_VIDEO_PRELOAD_MAX_SIZE = "maxPreLoadSize";
  public static final String SECONDARY_VIDEO_PRESET = "VideoPreset";
  public static final String SECONDARY_VIDEO_PRESET_FOR_LOW_CPU = "VideoPresetForLowCpu";
  public static final String SECONDARY_VIDEO_PRESET_LOW = "VideoPresetLow";
  public static final String SECONDARY_VIDEO_PROFILE = "VideoProfile";
  public static final String SECONDARY_VIDEO_PUBLISH_ON_ERROR_SIZE = "videoPublishOnErrorSize";
  public static final String SECONDARY_VIDEO_REQUEST_SAFE_URL_FEEDS = "requestSafeUrlFeeds";
  public static final String SECONDARY_VIDEO_REQUEST_SAFE_URL_NEED_CHECK_HOST = "videorequestsafeurlcheckhost";
  public static final String SECONDARY_VIDEO_REQUEST_SAFE_URL_RECOMMEND = "requestSafeUrlRecommend";
  public static final String SECONDARY_VIDEO_REQUEST_SAFE_URL_REMOVE_TIME = "requestSafeUrlRemoveTime";
  public static final String SECONDARY_VIDEO_REQUEST_SAFE_URL_RESPONSE_RECOMMEND = "requestSafeUrlResponseRecommend";
  public static final String SECONDARY_VIDEO_RETRY_DOWN_HIGH = "videoRetryDownHigh";
  public static final String SECONDARY_VIDEO_RETRY_DOWN_LOW = "videoRetryDownLow";
  public static final String SECONDARY_VIDEO_RETRY_DOWN_MEDIUM = "videoRetryDownMedium";
  public static final String SECONDARY_VIDEO_SAFE_URL_TIMEOUT = "videoSafeUrlTimeOut";
  public static final String SECONDARY_VIDEO_SCALE_RATIO_FOR_PGC = "pgcVideoDisplayScaleRatio";
  public static final String SECONDARY_VIDEO_SCALE_RATIO_FOR_UGC = "ugcVideoDisplayScaleRatio";
  public static final String SECONDARY_VIDEO_SUPPORT_WINDOW_PLAY = "videoSupportWindowPlay";
  public static final String SECONDARY_VIDEO_SV_INTERACT_MAX_RECORD_TIME = "videoSVInteractMaxRecordTime";
  public static final String SECONDARY_VIDEO_TASK_RETRY_FOR_BUILD_FAILED = "videoTaskRetryForBuildFailed";
  public static final String SECONDARY_VIDEO_TASK_RETRY_FOR_CONNECT_FAILED = "videoTaskRetryForConnectFailed";
  public static final String SECONDARY_VIDEO_TASK_RETRY_FOR_DISCONNECT = "videoTaskRetryForDisconnect";
  public static final String SECONDARY_VIDEO_TASK_RETRY_FOR_TIMEOUT = "videoTaskRetryForTimeout";
  public static final String SECONDARY_VIDEO_TC_PATH_TYPE = "videoTcPathType";
  public static final String SECONDARY_VIDEO_TIME_NO_TRIM_THRESHOLD = "videoTimeNoTrimThreshold";
  public static final String SECONDARY_VIDEO_TO_GIF_FIRST_N_SECOND = "VideoToGifFirstNSecond";
  public static final String SECONDARY_VIDEO_TO_GIF_FPS = "VideoToGifFps";
  public static final String SECONDARY_VIDEO_TO_GIF_MAX_FRAME = "VideoToGifMaxFrame";
  public static final String SECONDARY_VIDEO_TO_GIF_SIZE = "VideoToGifSize";
  public static final String SECONDARY_VIDEO_TO_GIF_SIZE_FOR_LONG_EDGE = "VideoToGifSizeForLongEdge";
  public static final String SECONDARY_VIDEO_TO_GIF_TIME_PER_FRAME = "VideoToGifTimePerFrame";
  public static final String SECONDARY_VIDEO_TRIM_ENABLE_HW = "videoTrimEnableHw";
  public static final String SECONDARY_VIDEO_TRIM_MEDIUM_AVAIL_RAM = "videoTrimMediumAvailRam";
  public static final String SECONDARY_VIDEO_TRIM_MIN_AVAIL_RAM = "videoTrimMinAvailRam";
  public static final String SECONDARY_VIDEO_TRIM_SUPERFAST_AVAIL_RAM = "videoTrimSuperfastAvailRam";
  public static final String SECONDARY_VIDEO_TRIM_ULTRAFAST_AVAIL_RAM = "videoTrimUltrafastAvailRam";
  public static final String SECONDARY_VIDEO_TUNE = "VideoTune";
  public static final String SECONDARY_VIDEO_UGC_SHOW_TOP_BAR = "VideoFloatUGCShowTopBar";
  public static final String SECONDARY_VIDEO_UPLOAD_BAK_IP = "BackupIP_VIDEOUP";
  public static final String SECONDARY_VIDEO_UPLOAD_HOST_IP = "VideoURL_UP";
  public static final String SECONDARY_VIDEO_UPLOAD_OPT_IP = "OptimumIP_VIDEOUP";
  public static final String SECONDARY_VIDEO_UPLOAD_QUALITY_ORG_LIMIT = "FileSizeLimitForShowOrigVideo";
  public static final String SECONDARY_VIDEO_USE_WNS_CGI = "videoUseWnsCgi";
  public static final String SECONDARY_VIDEO_VKEY_TIMEOUT = "videoVkeyTimeOut";
  public static final String SECONDARY_VIDEO_WIDTH_RATE = "Video_Width_Rate";
  public static final String SECONDARY_VIDEO_WINDOW_MANAGER_ENABLE = "videoWindowManagerEnable";
  public static final String SECONDARY_VIDEO_WINDOW_PLAY_CLOSE_AREA_PERCENT = "videoWindowPlayCloseAreaPercent";
  public static final String SECONDARY_VIP_PAY = "VipPay";
  public static final String SECONDARY_VIP_PK = "VipPK";
  public static final String SECONDARY_VIP_PROFILE = "VipProfile";
  public static final String SECONDARY_VISITORREPORT_COUNT = "VisitorReportCount";
  public static final String SECONDARY_VISITORREPORT_INTEVAL = "VisitorReportInteval";
  public static final String SECONDARY_VISITORREPORT_STOPTIME = "VisitorReportStopSeconds";
  public static final String SECONDARY_VISITOR_NOTIFY_SETTING = "VisitNotifySetting";
  public static final String SECONDARY_VISITOR_OTHER = "QzoneVisitor";
  public static final String SECONDARY_VISITOR_REDPOCKET = "QzoneVisitorRedPocket";
  public static final String SECONDARY_VISITOR_SETTING = "SeeMyVisitorPersimmonSetting";
  public static final String SECONDARY_VISITOR_TAB_REDPCOKET_WARN_POP_BG = "secondVisitorTabRedPocketPopBg";
  public static final String SECONDARY_VISITOR_WEEK_REPORT_URL = "qzonevisitorweekreport";
  public static final String SECONDARY_VISITOR_WIDGET = "PersonalQzoneVisitor";
  public static final String SECONDARY_VISITOR_WIDGET_AVATAR_EACH_AVATAR_TIME_DURATION = "VisitorWidgetAvatarEachAvatarTimeDuration";
  public static final String SECONDARY_VISITOR_WIDGET_AVATAR_NOTICE_MAX_COUNT = "VisitorWidgetAvatarNoticeMaxCount";
  public static final String SECONDARY_VISITOR_WIDGET_SHOW_AVATAR_MAX_COUNT = "VisitorWidgetShowAvatarMaxCount";
  public static final String SECONDARY_VOICE_MOOD_ALLOW_VOICE_FORWARD = "AllowVoiceForward";
  public static final String SECONDARY_VOICE_MOOD_ALLOW_VOICE_MOOD = "AllowVoiceMood";
  public static final String SECONDARY_VOICE_MOOD_ALLOW_VOICE_OP = "AllowVoiceOP";
  public static final String SECONDARY_VOICE_SHUOSHUO_ANIMATION = "VoiceShuoshuoAnimation";
  public static final String SECONDARY_VOICE_SHUOSHUO_ANIMATION_MD5 = "VoiceShuoshuoAnimationMD5";
  public static final String SECONDARY_VOICE_SHUOSHUO_H5 = "secondary_voice_shuoshuo_h5";
  public static final String SECONDARY_VOICE_SHUOSHUO_ICON = "secondary_voice_shuoshuo_icon";
  public static final String SECONDARY_WEATHER_CACHE_TIME = "WeatherCacheTime";
  public static final String SECONDARY_WEBSO_COMMAND = "HttpProxyHost2Command";
  public static final String SECONDARY_WEBSO_REPORT_BATCH_COUNT = "QzhwStatUploadBatchCount";
  public static final String SECONDARY_WEBSO_REPORT_BATCH_INTERVAL = "QzhwStatUploadBatchInterval";
  public static final String SECONDARY_WEBSO_REPORT_DEFAULT_SAMPLING = "QzhwStatDefaultSampling";
  public static final String SECONDARY_WEBSO_REPORT_URL = "QzhwStatCgiURL";
  public static final String SECONDARY_WEBSO_REPORT_URL_DEFAULT = "https://h5.qzone.qq.com/report/native";
  public static final String SECONDARY_WEIXIN_DOWNLOAD = "WeiXinDownload";
  public static final String SECONDARY_WHISPER_EGG = "WhisperEgg";
  public static final String SECONDARY_WIDGET_AI_OPEN = "OpenWidgetAI";
  public static final String SECONDARY_WIDGET_DETAIL_URL = "WidgetDetail";
  public static final String SECONDARY_WIFI_OPERATOR_CRARRY = "WifiCarrierType";
  public static final String SECONDARY_WRITE_BLOG = "WriteBlog";
  public static final String SECONDARY_X5RN_DISABLE_ANDROID_VER = "X5RNDisableAndroidVer";
  public static final String SECONDARY_X5RN_MIN_VERSION = "X5RNMinVer";
  public static final String SECONDAY_MEMOEY_OPERATE_FREQUENCY = "memory_operate_frequency";
  public static final String SENCODARY_KEY_STARTUP_ENABLE = "startup_monitor_enable";
  public static final String SENCODARY_KEY_STARTUP_FAIL_TIMEOUT = "startupFailTimeout";
  public static final String SHOW_WEISHI_ICON_ANIMATION_TIME = "ShowWeishiIconAnimationTime";
  public static final int SMALL_GAME_HTML_LOAD_MTA_REPORT_ENABLE_DEFAULT = 1;
  public static final String SP_KEY_PRELOAD_SMALL_GAME_FINISH = "key_qzone_preload_small_game_finish_";
  public static final String SP_KEY_PRELOAD_SMALL_GAME_TIMESTAMP = "key_qzone_preload_small_game_timestamp_";
  private static final String TAG = "QzoneConfig";
  public static final String TTT_REALTIME_REPORT_LIST = "TTTRealTimeReportList";
  public static final String TTT_REPORT_SETTING = "QzoneTTTReportSetting";
  public static final String USE_NEW_COMMAND = "use_new_command";
  public static final String WEBSO_DEFAULT_COMMAND_SETTING = "{\".qzone.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"web.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenter.websoh5\",\"msfCommand\":\"mqqweb.gamecenter.websoh5\"},\"m.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenterV2.h5\",\"msfCommand\":\"mqqweb.gamecenterV2.h5\"},\"mc.vip.qq.com\":{\"command\":\"mqqweb.mcvip.websoh5\",\"msfCommand\":\"mqqweb.mcvip.websoh5\"},\"zb.vip.qq.com\":{\"command\":\"mqqweb.zb.webso\",\"msfCommand\":\"mqqweb.zb.webso\"},\"vv.video.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\"qzpb.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\".urlshare.cn\":{\"command\":\"qzoneh5.urlshare.webso\",\"msfCommand\":\"qzoneh5.urlshare.webso\"},\"now.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\"nearby.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\".weishi.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\".weishi.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"} }";
  public static final String YINGYONGBAO_SWITCH_PREFIX = "YingyongbaoSwitchPrefix";
  public static QzoneConfig instance;
  private ConcurrentHashMap configMap = new ConcurrentHashMap();
  private ContentObserver configUpdateObserver;
  private volatile int loadstatus = 0;
  private ArrayList mCallback = new ArrayList();
  
  private QzoneConfig()
  {
    init();
  }
  
  public static QzoneConfig getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new QzoneConfig();
      }
      return instance;
    }
    finally {}
  }
  
  private void init()
  {
    registObserver();
  }
  
  private void initConfigUpdateObserver()
  {
    if (this.configUpdateObserver == null) {
      this.configUpdateObserver = new alsh(this, null);
    }
  }
  
  private void registObserver()
  {
    if ((BaseApplication.getContext() != null) && (BaseApplication.getContext().getContentResolver() != null)) {}
    try
    {
      initConfigUpdateObserver();
      BaseApplication.getContext().getContentResolver().registerContentObserver(QZoneConfigProvider.c, true, this.configUpdateObserver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QzoneConfig", 2, "registObserver 异常", localException);
    }
  }
  
  private void updateConfig()
  {
    getInstance().notifyConfigChange();
  }
  
  public void addListener(QzoneConfig.QzoneConfigChangeListener paramQzoneConfigChangeListener)
  {
    if (paramQzoneConfigChangeListener == null) {}
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = this.mCallback.iterator();
        Object localObject;
        do
        {
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label77;
            }
            localObject = (WeakReference)localIterator.next();
            if (localObject != null)
            {
              localObject = (QzoneConfig.QzoneConfigChangeListener)((WeakReference)localObject).get();
              if (localObject != null) {
                break;
              }
              localIterator.remove();
            }
          }
        } while (!paramQzoneConfigChangeListener.equals(localObject));
      }
      finally {}
      continue;
      label77:
      this.mCallback.add(new WeakReference(paramQzoneConfigChangeListener));
    }
  }
  
  public void clearConfigs()
  {
    this.configMap.clear();
    this.loadstatus = 0;
  }
  
  public void deleteConfigs(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      paramString = (ConcurrentHashMap)this.configMap.get(paramString);
    } while ((paramString == null) || (paramString.size() <= 0));
    paramString.clear();
  }
  
  public float getConfig(String paramString1, String paramString2, float paramFloat)
  {
    paramString1 = getConfig(paramString1, paramString2);
    if (paramString1 == null) {
      return paramFloat;
    }
    try
    {
      float f = Float.valueOf(paramString1).floatValue();
      return f;
    }
    catch (Exception paramString1) {}
    return paramFloat;
  }
  
  public int getConfig(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = getConfig(paramString1, paramString2);
    if (paramString1 == null) {
      return paramInt;
    }
    try
    {
      int i = Integer.valueOf(paramString1).intValue();
      return i;
    }
    catch (Exception paramString1) {}
    return paramInt;
  }
  
  public long getConfig(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = getConfig(paramString1, paramString2);
    if (paramString1 == null) {
      return paramLong;
    }
    try
    {
      long l = Long.valueOf(paramString1).longValue();
      return l;
    }
    catch (Exception paramString1) {}
    return paramLong;
  }
  
  public String getConfig(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      String str1 = paramString1.toLowerCase();
      String str2 = paramString2.toLowerCase();
      paramString2 = (ConcurrentHashMap)this.configMap.get(str1);
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        paramString1 = new ConcurrentHashMap();
        this.configMap.put(str1, paramString1);
      }
      if (paramString1 != null)
      {
        paramString1 = (String)paramString1.get(str2);
        if ((paramString1 == null) && (2 != this.loadstatus) && (1 != this.loadstatus))
        {
          QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new alsg(this));
          QLog.d("QzoneConfig", 4, "key: notready");
        }
        return paramString1;
      }
    }
    return null;
  }
  
  public String getConfig(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = getConfig(paramString1, paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return paramString3;
    }
    return paramString1;
  }
  
  public Rect getGifDisplayConfig()
  {
    return new Rect(getConfig("GifSetting", "GifEdgeLeft", 1), getConfig("GifSetting", "GifEdgeTop", 1), getConfig("GifSetting", "GifEdgeRight", 1), getConfig("GifSetting", "GifEdgeBottom", 2));
  }
  
  public void loadAllConfigs()
  {
    if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
      throw new IllegalStateException("不要在UI线程中调用此方法");
    }
    if ((1 != this.loadstatus) && (2 != this.loadstatus))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneConfig", 2, "loadAllConfigs :" + this.loadstatus);
      }
      this.loadstatus = 1;
      try
      {
        if (QZConfigProviderUtil.a(this.configMap))
        {
          this.loadstatus = 2;
          return;
        }
        this.loadstatus = 3;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QzoneConfig", 2, "loadAllConfigs 异常", localException);
        }
        this.loadstatus = 3;
      }
    }
  }
  
  public void notifyConfigChange()
  {
    int j;
    int i;
    try
    {
      WeakReference[] arrayOfWeakReference = new WeakReference[this.mCallback.size()];
      arrayOfWeakReference = (WeakReference[])this.mCallback.toArray(arrayOfWeakReference);
      j = arrayOfWeakReference.length;
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      if (!QLog.isColorLevel()) {
        break label74;
      }
      QLog.e("QzoneConfig", 1, "notifyConfigChange error", localThrowable);
    }
    QzoneConfig.QzoneConfigChangeListener localQzoneConfigChangeListener = (QzoneConfig.QzoneConfigChangeListener)localQzoneConfigChangeListener.get();
    if (localQzoneConfigChangeListener != null) {
      localQzoneConfigChangeListener.a();
    }
    label74:
    label95:
    for (;;)
    {
      return;
      for (;;)
      {
        if (i >= j) {
          break label95;
        }
        localQzoneConfigChangeListener = localThrowable[i];
        if (localQzoneConfigChangeListener != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public void printWNSConfig(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      loadAllConfigs();
      Object localObject;
      if (TextUtils.isEmpty(paramString1))
      {
        QLog.i("CMD_PRINT_WNS_CONFIG", 1, "打印全部配置");
        paramString1 = this.configMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          QLog.i("CMD_PRINT_WNS_CONFIG", 1, "mainKey = " + paramString2);
          paramString2 = (Map)this.configMap.get(paramString2);
          localObject = paramString2.keySet();
          QLog.i("CMD_PRINT_WNS_CONFIG", 1, "当前的的rawSet个数:" + ((Set)localObject).size());
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            QLog.i("CMD_PRINT_WNS_CONFIG", 1, str + " = " + (String)paramString2.get(str));
          }
        }
      }
      QLog.i("CMD_PRINT_WNS_CONFIG", 1, "打印对应mainkey:" + paramString1 + "的配置");
      paramString1 = (Map)this.configMap.get(paramString1);
      paramString2 = paramString1.keySet();
      QLog.i("CMD_PRINT_WNS_CONFIG", 1, "当前的的rawSet个数:" + paramString2.size());
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        localObject = (String)paramString2.next();
        QLog.i("CMD_PRINT_WNS_CONFIG", 1, (String)localObject + " = " + (String)paramString1.get(localObject));
      }
    }
    QLog.i("CMD_PRINT_WNS_CONFIG", 1, "打印对应mainkey:" + paramString1 + ",对应secondKey:" + paramString2 + "的配置");
    paramString1 = getConfig(paramString1, paramString2);
    QLog.i("CMD_PRINT_WNS_CONFIG", 1, paramString2 + " = " + paramString1);
    QLog.i("CMD_PRINT_WNS_CONFIG", 1, "结束打印WNS配置");
  }
  
  /* Error */
  public void removeListener(QzoneConfig.QzoneConfigChangeListener paramQzoneConfigChangeListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 4400	common/config/service/QzoneConfig:mCallback	Ljava/util/ArrayList;
    //   13: invokevirtual 4480	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 4485 1 0
    //   23: ifeq -17 -> 6
    //   26: aload_2
    //   27: invokeinterface 4489 1 0
    //   32: checkcast 4491	java/lang/ref/WeakReference
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull -20 -> 17
    //   40: aload_3
    //   41: invokevirtual 4494	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   44: checkcast 4496	common/config/service/QzoneConfig$QzoneConfigChangeListener
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull +11 -> 60
    //   52: aload_1
    //   53: aload_3
    //   54: invokevirtual 4503	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   57: ifeq -40 -> 17
    //   60: aload_2
    //   61: invokeinterface 4499 1 0
    //   66: goto -49 -> 17
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	QzoneConfig
    //   0	74	1	paramQzoneConfigChangeListener	QzoneConfig.QzoneConfigChangeListener
    //   16	45	2	localIterator	Iterator
    //   35	19	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	17	69	finally
    //   17	36	69	finally
    //   40	48	69	finally
    //   52	60	69	finally
    //   60	66	69	finally
  }
  
  public void updateOneConfig(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {}
    String str2;
    do
    {
      return;
      String str1 = paramString1.toLowerCase();
      str2 = paramString2.toLowerCase();
      paramString2 = (ConcurrentHashMap)this.configMap.get(str1);
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        paramString1 = new ConcurrentHashMap();
        this.configMap.put(str1, paramString1);
      }
    } while (paramString1 == null);
    paramString1.put(str2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     common.config.service.QzoneConfig
 * JD-Core Version:    0.7.0.1
 */