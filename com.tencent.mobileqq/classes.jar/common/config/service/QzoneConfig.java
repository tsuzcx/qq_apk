package common.config.service;

import aafs;
import amtj;
import android.content.ContentResolver;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.os.Looper;
import android.text.TextUtils;
import bkdz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.provider.QZoneConfigProvider;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
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
  public static final String CDN_PIC_START = "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/";
  public static final String COVER_BANNER_SWITCH = "CoverBannerSwitch";
  public static final String CUSTOM_VIP_MALL = "CustomVipMall";
  public static final String CUSTOM_VIP_PREVIEW = "CustomVipPreview";
  public static final String DEAULT_CM_PAY_JUMP_URL = "https://h5.qzone.qq.com/v2/vip/show/previewDialog?_wv=16781315&_wwv=13&actionId={actionId}&type={type}";
  public static final int DEAULT_CM_PRAISE_TIME_OUT = 2000;
  public static final int DEAULT_CM_SHOW_STORE_BUTTON = 0;
  public static final String DEAULT_QZONE_CM_IDENTIFY_ICON_URL = "https://imgcache.qq.com/club/mobile/privilege/yellowupbig/light_{level}.png";
  public static final String DEAULT_QZONE_CM_IDENTIFY_JUMP_URL = "mqzone://arouse/yellowdiamond?subaid=lmx_kjlmxwx&viptype=2&switch=0";
  public static final String DEFAULTY_FOLLOW_FOLLOWERS_URL = "https://h5.qzone.qq.com/follow/feeds/{hostuin}/followfeeds?_wv=1027&_proxy=1";
  public static final float DEFAULT_ADJUST_PREDECODE_MEMORY_SIZE = 0.5F;
  public static final String DEFAULT_AIO_QZONE_LOVE_GRAY_TIPS_VALUE = "{'情侣空间':'https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=qqfrd&qzUseTransparentNavBar=1&_proxy=1'}";
  public static final String DEFAULT_ALBUM_FAKE_FEED_TAIL_CLICK_TIPS = "上传中，请稍候";
  public static final int DEFAULT_ALBUM_NEW_UPLOAD_SHOW = 1;
  public static final int DEFAULT_ALBUM_NEW_UPLOAD_SHOW_INTERVAL_MINUTES = 0;
  public static final String DEFAULT_APPLETS_CHATPIE_EMPTY_BACKGROUND_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20190329164016_N0Y2CuctLc.png";
  public static final String DEFAULT_APPLETS_CHATPIE_EMPTY_TIPS = "还没收到过小程序通知哦";
  public static final int DEFAULT_APPLETS_CHATPIE_SHOW_EMPTY_VIEW = 1;
  public static final String DEFAULT_APPLETS_NICKNAME = "小程序通知";
  public static final String DEFAULT_APPLETS_UIN = "1038354735";
  public static final String DEFAULT_ARK_SCENE_WHITE_LIST = "1007,1008,1014,1036,2061,2072,2075,2085,2105,2112,2114,2217,2218,4012,4016,4017";
  public static final String DEFAULT_BABY_ALBUM_LEFT_BG_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20191104215206_4WlIY1I3hn.png";
  public static final String DEFAULT_BABY_ALBUM_RIGHT_BG_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20191104215206_QWyT73sVVm.png";
  public static final int DEFAULT_CAN_OPEN_APP = 1;
  public static final int DEFAULT_CHECK_STORAGE_PERMISSION = 0;
  public static final long DEFAULT_CHOOSE_VIDEO_MAX_DURATION = 600000L;
  public static final long DEFAULT_CHOOSE_VIDEO_MAX_SIZE = 1610612736L;
  public static final String DEFAULT_CLOUD_PHOTO_DYNAMIC_ALBUM_URL = "https://h5.qzone.qq.com/dynamic/album/main?refer=h5maker&no_upload=1&tid={tid}&_wv=2098179";
  public static final String DEFAULT_CM_ACTION_URL = "https://h5.qzone.qq.com/lmshow/mall?_proxy=1";
  public static final String DEFAULT_CM_AIO_PET_NAMEPLATE_GUEST_URL = "https://cmshow.qq.com/apollo/html/pet/pet_hall.html?_wv=16777218&_cwv=9&_wwv=1&thunder_id=8&_bid=3094&pet={pet_id}&open=1&adtag=aioke";
  public static final String DEFAULT_CM_AIO_PET_NAMEPLATE_HOST_URL = "https://cmshow.qq.com/apollo/html/pet/pet_hall.html?_wv=16777218&_cwv=9&_wwv=1&thunder_id=8&_bid=3094&pet={pet_id}&open=1&adtag=aiozhu";
  public static final String DEFAULT_CM_AIO_SVIP_NAMEPLATE_URL = "https://h5.qzone.qq.com/limishow/mall?_wv=131072&_fv=0&_wwv=128&_wvx=10&traceDetail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMjEifQ%3D%3D";
  public static final int DEFAULT_CONVERSATION_REMAIN_REPORT_CONTROL = 60;
  public static final boolean DEFAULT_COVER_TEXTVIEW_PADDING = true;
  public static final int DEFAULT_DISAPPLEAR_WEISHI_ICON_ANIMATION_TIME = 300;
  public static final String DEFAULT_DOMAIN_WHITE_LIST = ".qlogo.cn;.tcb.qcloud.la;open.mp.qq.com;api-report.q.qq.com;rpt.gdt.qq.com;.gtimg.cn";
  public static int DEFAULT_DOWNLOAD_HTTP2 = 0;
  public static final int DEFAULT_DOWNLOAD_ON_RANGE_MODE = 1;
  public static final String DEFAULT_DROP_DOWN_DEFAULT_RECOMMEND_APPS = "[{\"appId\":\"1108291530\",\"appName\":\"游戏中心\",\"icon\":\"https://miniapp.gtimg.cn/public/appicon/78bccc3685c866d1b1e3ba5a43f77b88_200.jpg\",\"type\":3},{\"appId\":\"1108805017\",\"appName\":\"世界争霸\",\"icon\":\"https://miniapp.gtimg.cn/public/appicon/4be819263a88be6a827855456bc32c50_200.jpg\",\"type\":3},{\"appId\":\"1109508198\",\"appName\":\"胡莱三国\",\"icon\":\"https://miniapp.gtimg.cn/public/appicon/91628b538edf7291c30c2d81814a9e79_200.jpg\",\"type\":3},{\"appId\":\"1109836759\",\"appName\":\"火柴人神射手\",\"icon\":\"https://miniapp.gtimg.cn/public/appicon/6ba3fba6b84d3e940da0822c32a4f630_200.jpg\",\"type\":3},{\"appId\":\"1109694952\",\"appName\":\"天天电音\",\"icon\":\"https://miniapp.gtimg.cn/public/appicon/9adccd998e1d81772fb7db6b80e2e6f2_200.jpg\",\"type\":3}]";
  public static final String DEFAULT_DROP_DOWN_DEFAULT_RECOMMEND_MODULE_TITLE = "好友在玩";
  public static final String DEFAULT_DYNAMIC_ALBUM_URL = "https://h5.qzone.qq.com/dynamic/album/tpl?source=1&_ws=9&preview=1&_wv=2098179&_dynamicalbum=1&_proxy=1";
  public static final String DEFAULT_DYNAMIC_NATIVE_ALBUM_URL = "https://h5.qzone.qq.com/dynamic/album/preview?_wv=2098177&source=1&tid=youth";
  public static final int DEFAULT_EMBEEDDED_VIDEO_FPS_INTERVAL_TIME = 32;
  public static final int DEFAULT_ENABLE_EMBEDDED_LIVE = 1;
  public static final int DEFAULT_ENABLE_EMBEDDED_VIDEO = 1;
  public static final boolean DEFAULT_ENABLE_MOOD_LIST_EXTEND_FEEDS = true;
  public static final int DEFAULT_ENABLE_V6_ROUTE = 0;
  public static final int DEFAULT_ENABLE_V6_ROUTE_FOR_ALL = 7;
  public static final int DEFAULT_ENABLE_V6_TTT_REPORT = 0;
  public static final int DEFAULT_EXTEND_LIVE_SWITCH = 0;
  public static final float DEFAULT_FACE_DETECT_EYE_SCALE = 0.17F;
  public static final float DEFAULT_FACE_DETECT_SMILE_OPEN_SCALE = 0.05F;
  public static final float DEFAULT_FACE_DETECT_SMILE_SCALE = 0.07F;
  public static final int DEFAULT_FACE_SCAN_QZONE_PLUS_VERSION = 1;
  public static final int DEFAULT_FACE_SCAN_SUPPORT_LOW_VERSION = 12;
  public static final int DEFAULT_FACE_TIMES_TO_CLUSTER = 10;
  public static final boolean DEFAULT_FEED_DROPDOWN_USE_BOTTOM_SHEET = true;
  public static final String DEFAULT_FEED_LOVE_DIAMOND_URL = "https://h5.qzone.qq.com/lover/vipDialog?_wv=16777219&_proxy=1&qzUseTransparentNavBar=1&friendUin={friendUin}";
  public static final int DEFAULT_FEED_OPERATE_TIME = 1;
  public static final int DEFAULT_FEED_PSVADV_SHOW_POS = 1;
  public static final String DEFAULT_FEED_REDPOCKET_SHUOSHUO_DELETE_MSG = "仅能删除说说，不能撤回红包。未领红包，在24小时后退款。";
  public static final boolean DEFAULT_FEED_USE_OLD_POKE = false;
  public static final String DEFAULT_FEED_YELLOW_DIAMOND_URL = "https://h5.qzone.qq.com/vip/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32&source={aid}&qua={qua}&_proxy=1&trace_detail=%7B%22appid%22:%22FeedAN%22%7D";
  public static final String DEFAULT_FFMPEG_VIDEO_COMPRESS_PARAM = "-profile:v main -crf 29";
  public static final int DEFAULT_FIRST_TIME_ENTER_FRIEND_FEEDS_NEED_GET_MAINPAGE = 1;
  public static final String DEFAULT_FOLLOW_FANS_URL = "https://h5.qzone.qq.com/qzone/follow/{hostuin}/fans?_wv=1027&_proxy=1&loginuin={uin}";
  public static final int DEFAULT_GALLERY_RECOM_ALBUM_BACK_PRESS_FINISH = 0;
  public static final int DEFAULT_GALLERY_RECOM_ALBUM_FLING_CLOSE = 0;
  public static final int DEFAULT_GALLERY_RECOM_COUNT_LIMIT = 999;
  public static final long DEFAULT_GET_APPLETS_NOTIFICATION_SETTING_INTERVAL = 1L;
  public static final int DEFAULT_GET_PHOTO_BY_TIME_LINE_MAX_COUNT = 100;
  public static final int DEFAULT_GO_CONTENT_BOX_MINI_PROGRAM_APPID = 0;
  public static final String DEFAULT_HERO_VIDEO_HVC_HWDEC_MODE = "vivo NEX S|";
  public static final int DEFAULT_IMAGE_MANAGER_MEMORY_SIZE = 128;
  public static final int DEFAULT_IMAGE_MANAGER_USE_ARGB8888 = 1;
  public static final String DEFAULT_INVITE_OPEN_LOVE_ZONE_URL = "https://h5.qzone.qq.com/lover/router?_wv=3&_proxy=1";
  public static final int DEFAULT_IS_OPEN_PHOTO_SAVE = 1;
  public static final int DEFAULT_IS_OPEN_QRCODE_SCAN = 1;
  public static final String DEFAULT_IS_SHOW_ENTRANCE = "0";
  public static final int DEFAULT_JUMP_TO_WEISHI = 1;
  public static final int DEFAULT_KEY_CM_PRAISE = 1;
  public static final String DEFAULT_KEY_JUMP_TO_MORE_VIDEO_URL = "https://h5.qzone.qq.com/qzone/video?_wv=3&usewk=1&_proxy=1";
  public static final String DEFAULT_KEY_MARTET_TO_DOWNLOAD_WEISHI = "market://details?id=com.tencent.weishi";
  public static final int DEFAULT_KEY_SHOW_ENTRANCE_GUIDE = 1;
  public static final String DEFAULT_KEY_WEB_TO_DOWNLOAD_WEISHI = "https://android.myapp.com/myapp/detail.htm?apkName=com.tencent.weishi";
  public static final int DEFAULT_LIMIT_FACE_NUMS = 5;
  public static final String DEFAULT_LOVE_ALBUM_BG_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20191104215206_TMitj1NKy1.png";
  public static final String DEFAULT_MACHINELEARNING_DEFAULT_WHITE_LIST = String.valueOf(30);
  public static final int DEFAULT_MAKE_PHOTO_BLOG_FUNCTION_OPEN = 1;
  public static final int DEFAULT_MANUAL_LOAD_SWITCH_STATUS = 1;
  public static final long DEFAULT_MAX_P2V_VIDEO_DURING = 15000L;
  public static final int DEFAULT_MAX_RANGE_NUMBER = 4;
  public static final int DEFAULT_MINI_APP_BRING_TITLE_BAR_TO_FRONT = 1;
  public static final int DEFAULT_MINI_APP_ECSHOP_NUM_MSG_ENABLE = 1;
  public static final int DEFAULT_MINI_APP_FULL_SCREEN_SEARCH = 0;
  public static final int DEFAULT_MINI_APP_FULL_SCREEN_SEARCH_OPEN = 1;
  public static final int DEFAULT_MINI_APP_FULL_SCREEN_SHOW_CLOSE = 1;
  public static final int DEFAULT_MINI_APP_FULL_SCREEN_SHOW_NOTIFICATION = 1;
  public static final int DEFAULT_MINI_APP_FULL_SCREEN_SHOW_NOTIFICATION_OPEN = 1;
  public static final int DEFAULT_MINI_APP_FULL_SCREEN_SHOW_NOTIFICATION_RED_DOT = 1;
  public static final int DEFAULT_MINI_APP_FULL_SCREEN_SHOW_NOTIFICATION_RED_DOT_OPEN = 1;
  public static final int DEFAULT_MINI_APP_FULL_SCREEN_SHOW_SETTING = 0;
  public static final int DEFAULT_MINI_APP_FULL_SCREEN_SHOW_SETTING_OPEN = 1;
  public static final String DEFAULT_MINI_APP_FULL_SCREEN_TITLE = "QQ小程序";
  public static final int DEFAULT_MINI_APP_REFRESH_SHOW_ICON = 0;
  public static final String DEFAULT_MINI_APP_SEARCH_APPID = "1109875297";
  public static final int DEFAULT_MINI_APP_SHOW_FULL_SCREEN = 1;
  public static final int DEFAULT_MINI_APP_SHOW_MSG_RED_DOT = 0;
  public static final int DEFAULT_MINI_APP_SHOW_OLD_LAYOUT = 0;
  public static final int DEFAULT_MINI_APP_SHOW_RED_DOT = 0;
  public static final String DEFAULT_MINI_APP_STORE_ANIMATION_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20190731152341_sdxuDd8UqU.png";
  public static final String DEFAULT_MINI_APP_STORE_ENTRY_PATH = "pages/my/my.html";
  public static final String DEFAULT_MINI_APP_STORE_MY_PAGE = "mqqapi://miniapp/open?_atype=0&_mappid=1108291530&_mvid=&_path=pages%2Fmy%2Fmy.html%3Fmode%3Ddesktop&_vt=3&via=1001_4&_sig=58cc58ba25b0f133887e060a25a47b83e33b09f7b969152a5a1beb2ba08db125";
  public static final int DEFAULT_MINI_APP_TOP_MAX_NUM = 50;
  public static final String DEFAULT_MINI_GAME_BASELIB = "{\"key1\":\"https://d3g.qq.com/sngapp/app/update/20190708174635_6988/lib-1.4.7.zip\",\"key2\":\"\",\"key3\":\"1.4.7\",\"key4\": {\"file_length\": 6336933},\"key5\":2}";
  public static final int DEFAULT_MINI_GAME_PAY_BY_H5 = 0;
  public static final String DEFAULT_MINI_GAME_PAY_BY_H5_URL = "https://h5.qzone.qq.com/miniapp/act/midasPay?offerId={offerId}&prepayId={prepayId}&starCurrency={starCurrency}&setEnv={setEnv}&appid={appid}&zoneId={zoneId}&buyQuantity={buyQuantity}&isCanChange={isCanChange}&currencyType={currencyType}&platform={platform}&remark={remark}&numberVisible={numberVisible}&other={other}&acctType={acctType}&firstRefer={firstRefer}&firstVia={firstVia}&refer={refer}&via={via}&_proxy=1&_wv=17301504&_wwv=1";
  public static final String DEFAULT_MINI_GAME_PAY_BY_H5_URL_LANDSCAPE = "https://h5.qzone.qq.com/miniapp/act/midasPay?offerId={offerId}&prepayId={prepayId}&starCurrency={starCurrency}&setEnv={setEnv}&appid={appid}&zoneId={zoneId}&buyQuantity={buyQuantity}&isCanChange={isCanChange}&currencyType={currencyType}&platform={platform}&remark={remark}&numberVisible={numberVisible}&other={other}&acctType={acctType}&firstRefer={firstRefer}&firstVia={firstVia}&refer={refer}&via={via}&_proxy=1&_wv=17303552&_wwv=1";
  public static final String DEFAULT_ML_SO_DOWNLOAD_URL = "https://d3g.qq.com/sngapp/app/update/20171010175228_9573/libqzonemachinelearn.so";
  public static final String DEFAULT_ML_SO_MD5 = "f11baef39b2049ed2ae1bc2f8881b27a";
  public static final int DEFAULT_ML_WORKFLOW_RETRY_CNT = 4;
  public static final int DEFAULT_NAVIGATE_BACK_BY_APPINFO = 1;
  public static final int DEFAULT_NEW_STYLE_SHUOSHUO_NEW_CARD_SWITCH_OPEN = 0;
  public static final String DEFAULT_OPENDATA_DOMAIN_WHITE_LIST = ".qlogo.com;.qlogo.cn;.qq.com;.tcb.qcloud.la";
  public static final String DEFAULT_OPENURL_DOMAIN_WHITELIST = "tucao.qq.com,mobile.qzone.qq.com";
  public static final String DEFAULT_OPENURL_FILTER = "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb|http://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb";
  public static final int DEFAULT_OWNER_OPERATE_TIME = 3;
  public static final String DEFAULT_P2V_FUN_BLACK_LIST = "MI 3,GT-N7108,vivo Y51A,OPPO R6007,R6007,vivo Y31A,vivo Y31,vivo Y35A,CAM-AL00,CAM-UL00,CAM-TL00,M821,SM-A7000,MI 2SC,SM-G6000,Mi Note 2,M5 Note,Mi Note 2,F8332,m5 note,SM-C5000,OPPO A33m,OPPO A33,OPPO A37m,M15,MI 5C,OPPO A31,Pixel 3a,V1813BA,LIO-AL00,TAS-AL00,VOG-AL00";
  public static final int DEFAULT_P2V_FUN_ENABLE = 1;
  public static final boolean DEFAULT_P2V_NEED_ORIGINAL = true;
  public static final long DEFAULT_P2V_STORAGE_LIMIT = 62914560L;
  public static final int DEFAULT_P2V_SUPPORTED_CPU_FAMILY = 2;
  public static final int DEFAULT_PHOTOVIEW_LIST_SIZE_TO_FINISH = 409600;
  public static final int DEFAULT_PHOTOVIEW_PHOTO_BYTES = 3500;
  public static final int DEFAULT_PHOTOVIEW_VIDEO_BYTES = 8500;
  public static final String DEFAULT_PHOTO_BLOG_URL = "https://h5.qzone.qq.com/blog/editor2?_wv=4099&_proxy=1&source=shouzhang";
  public static final float DEFAULT_PHOTO_GROUP_LIST_IMAGE_CROP_SPACE_RATIO = 0.25F;
  public static final String DEFAULT_PICTURE_VIEWER_DANMAKU_BLACK_LIST = "";
  public static final int DEFAULT_PICTURE_VIEWER_DANMAKU_DEFAULT_SWITCH = 0;
  public static final String DEFAULT_PICTURE_VIEWER_DANMAKU_GARY_RANGE = "00-100";
  public static final int DEFAULT_PICTURE_VIEWER_DANMAKU_LOWEST_CPU_LEVEL = 1;
  public static final int DEFAULT_PICTURE_VIEWER_DANMAKU_LOWEST_MEMORY_LEVEL = 1;
  public static final int DEFAULT_POLY_PRELOAD_TIME = 200;
  public static final String DEFAULT_PRELOAD_BIG_PIC_ML_B_UPDATE = "";
  public static final int DEFAULT_PRELOAD_BIG_PIC_ML_ENABLE = 1;
  public static final float DEFAULT_PRELOAD_BIG_PIC_ML_THRESHOLD = 0.24F;
  public static final String DEFAULT_PRELOAD_BIG_PIC_ML_W_UPDATE = "";
  public static final String DEFAULT_PUBLIC_ACCOUNT_DISCOVER_PAGE_SCHEMA = "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4";
  public static String DEFAULT_QFLUTTER_URL;
  public static final int DEFAULT_QMUSIC_HLS_MAX_RETRY_TIMES = 3;
  private static final String DEFAULT_QQCIRCLE_AGGREAGTE_EMPTY_JUMP_TITLE = "发布第一个作品";
  private static final String DEFAULT_QQCIRCLE_AGGREAGTE_EMPTY_TEXT = "这片沃土空空如也\n等待你来开垦";
  private static final String DEFAULT_QQCIRCLE_AUTHENTICATION_ERROR_TEXT = "暂无权限\n去众推看看其他内容吧";
  private static final String DEFAULT_QQCIRCLE_AUTHENTICATION_ERROR_TOAST_TEXT = "暂无权限，去逛逛众推吧";
  private static final String DEFAULT_QQCIRCLE_DETAIL_ERROR_CONTENT_DELETED_TEXT = "害！来晚一步\n这个内容已下落不明";
  public static final String DEFAULT_QQCIRCLE_EEVEE_SYSTEM_OPEN = "1";
  private static final String DEFAULT_QQCIRCLE_HOMEPAGE_GUEST_LIST_EMPTY_JUMP_TITLE = "探索更多小世界";
  private static final String DEFAULT_QQCIRCLE_HOMEPAGE_GUEST_LIST_EMPTY_TEXT = "这个小世界尚未启动\n你的目光早已启程";
  private static final String DEFAULT_QQCIRCLE_HOMEPAGE_GUEST_PRODUCT_EMPTY_JUMP_TITLE = "探索更多小世界";
  private static final String DEFAULT_QQCIRCLE_HOMEPAGE_GUEST_PRODUCT_EMPTY_TEXT = "这个小世界尚未启动\n你的目光早已启程";
  private static final String DEFAULT_QQCIRCLE_HOMEPAGE_GUEST_PUSH_EMPTY_JUMP_TITLE = "探索更多小世界";
  private static final String DEFAULT_QQCIRCLE_HOMEPAGE_GUEST_PUSH_EMPTY_TEXT = "这个小世界尚未启动\n你的目光早已启程";
  private static final String DEFAULT_QQCIRCLE_HOMEPAGE_HOST_LIST_EMPTY_JUMP_TITLE = "发布第一个作品";
  private static final String DEFAULT_QQCIRCLE_HOMEPAGE_HOST_LIST_EMPTY_TEXT = "生活的每一个瞬间\n都值得被记录";
  private static final String DEFAULT_QQCIRCLE_HOMEPAGE_HOST_PRODUCT_EMPTY_JUMP_TITLE = "发布第一个作品";
  private static final String DEFAULT_QQCIRCLE_HOMEPAGE_HOST_PRODUCT_EMPTY_TEXT = "生活的每一个瞬间\n都值得被记录";
  private static final String DEFAULT_QQCIRCLE_HOMEPAGE_HOST_PUSH_EMPTY_JUMP_TITLE = "探索更多小世界";
  private static final String DEFAULT_QQCIRCLE_HOMEPAGE_HOST_PUSH_EMPTY_TEXT = "当你用心看这个世界\n这个世界也在用心回望你";
  private static final String DEFAULT_QQCIRCLE_HOMEPAGE_INMYBLACKLIST_JUMP_TITLE = "编辑黑名单";
  private static final String DEFAULT_QQCIRCLE_HOMEPAGE_INMYBLACKLIST_TEXT = "该用户在你的\n小世界黑名单中";
  private static final String DEFAULT_QQCIRCLE_MESSAGELIST_HOST_MESSAGE_EMPTY_JUMP_TITLE = "探索更多小世界";
  private static final String DEFAULT_QQCIRCLE_MESSAGELIST_HOST_MESSAGE_EMPTY_TEXT = "没有你的消息\n世界从此慢慢疏离";
  private static final String DEFAULT_QQCIRCLE_MESSAGELIST_HOST_PRIVATELETTER_EMPTY_JUMP_TITLE = "探索更多小世界";
  private static final String DEFAULT_QQCIRCLE_MESSAGELIST_HOST_PRIVATELETTER_EMPTY_TEXT = "没有你的消息\n世界从此慢慢疏离";
  private static final String DEFAULT_QQCIRCLE_NONET_ERROR_TEXT = "无法连接小世界\n检查一下网络再试吧";
  private static final String DEFAULT_QQCIRCLE_NONET_ERROR_TOAST_TEXT = "无法连接小世界, 检查网络后再试试";
  public static final String DEFAULT_QQCIRCLE_PERSONAL_DATA_EDIT_H5_URL = "https://h5.qzone.qq.com/v2/wezone/addtag?_wv=3&_wwv=1&_proxy=1&addfrom=edit";
  public static final String DEFAULT_QQCIRCLE_RECOMMEND_FOLLOW_H5_URL = "https://h5.qzone.qq.com/v2/wezone/recommend/invite/{uid}/{invite_id}?_wv=3&_proxy=1";
  private static final String DEFAULT_QQCIRCLE_SERVER_ERROR_TEXT = "网络开小差了\n稍后再试试吧";
  private static final String DEFAULT_QQCIRCLE_SERVER_ERROR_TOAST_TEXT = "网络开小差了，稍后再试试吧";
  public static final String DEFAULT_QQCIRCLE_SPLASH_ENABLE = "1";
  public static final String DEFAULT_QQCIRCLE_SPLASH_GUIDE_LOGO_RUL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/848-Trailer/image/trailer-local-logo.png";
  public static final String DEFAULT_QQCIRCLE_SPLASH_GUIDE_LOGO_TEXT_URL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/848-Trailer/image/trailer-local-text-2.png";
  public static final String DEFAULT_QQCIRCLE_SPLASH_GUIDE_VIDEO_DIR = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/848-Trailer/";
  public static final int DEFAULT_QQCIRCLE_SWITCH_DANMAKU = 1;
  public static final int DEFAULT_QQCIRCLE_SWITCH_PLAY_VIDEO_IN_WORKS_TAB = 1;
  public static final String DEFAULT_QQCIRCLE_TAG_MEDAL_IMAGE_URL_COLOUR = "https://sola.gtimg.cn/aoi/sola/20200819105021_dQGv8tIe5a.png";
  public static final String DEFAULT_QQCIRCLE_TAG_MEDAL_IMAGE_URL_GRAY = "https://sola.gtimg.cn/aoi/sola/20200819105021_x9nesSzJkY.png";
  public static final String DEFAULT_QQCIRCLE_USE_EEVEE_RED_POINT = "1";
  public static final int DEFAULT_QZONE_CONFIG_SECONDARY_KEY_SHOW_MAKEVIDEO_MAX_PIC_VIDEO_COUNT = 30;
  public static final String DEFAULT_QZONE_FACE_SCAN_BLACKLIST = "";
  public static final int DEFAULT_QZONE_FACE_SCAN_SWITCH = 1;
  public static final int DEFAULT_QZONE_MAIN_FORCE_SHUTDOWN_GIF_DECODE = 0;
  public static final String DEFAULT_QZONE_QUN_DETAIL = "https://h5.qzone.qq.com/groupphoto/inqq/detail/{qunid}/{albumid}/{lloc}?busi_param.2={lloc}&busi_param.7=1&busi_param.16=2&busi_param.21={uploadtime}&busi_param.34=5&refresh_type=7&index=0&_wv=1073800185&_proxy=1&qua={qua}";
  public static final String DEFAULT_RANGE_MODE_NETWORK_LEVEL = "1,2,3,6";
  public static final String DEFAULT_RANGE_MODE_PERF_LEVEL = "1,2,3";
  public static final long DEFAULT_RANGE_SIZE = 524288L;
  public static final int DEFAULT_RECENT_PHOTO_CAROUSEL_COUNT = 5;
  public static final int DEFAULT_RECOMMEND_ALBUM_GALLERY_BG_SWITCH = 20;
  public static final int DEFAULT_RECOMMEND_ALBUM_GALLERY_SWITCH = 0;
  public static final int DEFAULT_RECOMMEND_COUNT_NUM_LIMIT = 999;
  public static final String DEFAULT_SCF_GATEWAY_DEVICE_VER = "100";
  public static final String DEFAULT_SCF_GATEWAY_ID = "AKID1kzNj6bssaQhnsKi4b8qP3C413YfY1sbWTh9";
  public static final String DEFAULT_SCF_GATEWAY_QUERY_URL = "https://service-eu5361om-1251316161.ap-guangzhou.apigateway.myqcloud.com/release/deviceinfo/query?deviceinfo={deviceid}&videoinfo={profileid}";
  public static final String DEFAULT_SCF_GATEWAY_REPORT_URL = "https://service-eu5361om-1251316161.ap-guangzhou.apigateway.myqcloud.com/release/deviceinfo/report?deviceinfo={deviceid}&videoinfo={profileid}&status={status}";
  public static final String DEFAULT_SCF_GATEWAY_SECRET = "1t87nyIItAkWwVjgXxSl29QcgaeFw072U7kpo1ld";
  public static final boolean DEFAULT_SCF_GATEWAY_SIGN_ENABLE = true;
  public static final int DEFAULT_SCF_GATEWAY_STATUS = 1;
  public static final int DEFAULT_SCF_GATEWAY_STATUS_ENABLED = 1;
  public static final String DEFAULT_SEARCH_PAGE_URL = "https://h5.qzone.qq.com/v2/wezone/search?_wwv=8192&_wv=3&_proxy=1&show_right_cancel=1&move_web_view_top=1";
  public static final int DEFAULT_SECONDARY_SIM_QUERY = 2000;
  public static final int DEFAULT_SECONDARY_SIM_QUERY_DELAY = 2000;
  public static final int DEFAULT_SECONDARY_SIM_QUERY_STATUS = 0;
  public static final int DEFAULT_SECONDARY_SIM_QUERY_USING_MIG_SDK = 1;
  public static final int DEFAULT_SECONDARY_UPLOAD_PHOTO_PAGE_TIP = 1;
  public static final String DEFAULT_SECONDARY_VIDEO_HERO_PLAYER_LIBS_URL = "https://d3g.qq.com/sngapp/app/update/20161019162548_6237/libheroplayer_2.jar";
  public static final String DEFAULT_SELECT_TEMPLATE_DYNAMIC_ALBUM_URL = "https://h5.qzone.qq.com/dynamic/album/coverList?source=1&_ws=9&preview=1&_wv=2098179&_dynamicalbum=1&_proxy=1";
  public static final String DEFAULT_SELF_PRAISE_ANIMATION_RES_URL = "https://d3g.qq.com/sngapp/app/update/20190307193443_9744/selfPraise.zip";
  public static final int DEFAULT_SETTING_ME_MINI_GAME_ENABLE = 1;
  public static final String DEFAULT_SET_COOKIIE_HOST = "https://open.mp.qq.com";
  public static final String DEFAULT_SHARE_ALBUM_INVITE_TO_FEEDS_URL = "https://h5.qzone.qq.com/manyPeopleAlbum/invite/{albumUin}/{albumid}?uin={loginUin}&_proxy=1&_wv=3&_wvv=4";
  public static final int DEFAULT_SHARE_ALBUM_TO_WEIXIN_MINI_PROGRAM_NEED_SK_VALUE = 1;
  public static final int DEFAULT_SHARE_SINGLE_BIG_PICTURE_AS_WECHAT_MINI_PROGRAM = 1;
  public static final int DEFAULT_SHOW_FRIEND_FEEDS = 1;
  public static final int DEFAULT_SHOW_FRIEND_FEEDS_RESTRICTION_HEAP = 192;
  public static final int DEFAULT_SHOW_FRIEND_FEEDS_RESTRICTION_RAM = 3145728;
  public static final int DEFAULT_SHOW_TIME_LINE_IN_RECENT_PHOTO_TAB = 1;
  public static final int DEFAULT_SHOW_WEISHI_ICON_ANIMATION_TIME = 300;
  public static final int DEFAULT_SMART_BEAUTIFY_ANIMATION_GAP = 300;
  public static final String DEFAULT_SMART_BEAUTIFY_ANIMATON_RES_MD5 = "2710f0a3dfeb2881c3af1f7849f6e700";
  public static final String DEFAULT_SMART_BEAUTIFY_ANIMATON_RES_URL = "https://d3g.qq.com/sngapp/app/update/20181213192737_5845/animation.zip";
  public static final int DEFAULT_SMART_BEAUTIFY_IMAGE_CHECKED_STATUS = 1;
  public static final long DEFAULT_SMART_BEAUTIFY_IMAGE_CREATE_TIME_DIFF_MIN = 1L;
  public static final int DEFAULT_SMART_BEAUTIFY_IMAGE_NUM_MAX = 4;
  public static final int DEFAULT_SMART_BEAUTIFY_IMAGE_NUM_MIN = 3;
  public static final int DEFAULT_SMART_BEAUTIFY_IMAGE_RECOMM_DISABLE = 0;
  public static final int DEFAULT_SMART_BEAUTIFY_IMAGE_RECOMM_ENABLE = 1;
  public static final int DEFAULT_SMART_BEAUTIFY_IMAGE_SCAN_TAG_ENABLE = 1;
  public static final int DEFAULT_SMART_BEAUTIFY_MAX_EXPOSURE_TIMES = 2;
  public static final int DEFAULT_SMART_BEAUTIFY_MAX_WAIT_TIME = 5000;
  public static final String DEFAULT_SMART_DNSSERVICE = "182.254.116.117|182.254.118.11";
  public static final String DEFAULT_SUBPERSONAL_HOMEPAGE_URL = "https://h5.qzone.qq.com/v2/vip/live/profile?openid={openid}&puin={puin}&_wv=16777217";
  public static final String DEFAULT_SUBSCRIBE_PERSONAL_SHARE_FAN_GROUP_URL = "https://h5.qzone.qq.com/subscription/fansqun/{uin}?_proxy=1&_wv=3";
  public static final String DEFAULT_SWEET_MAIN_PAGE_JUMP_H5_URL = "https://h5.qzone.qq.com/mood/lover?_wv=1027&_proxy=1";
  public static final String DEFAULT_SWEET_MAIN_PAGE_JUMP_URL = "mqqapi://miniapp/open?_atype=0&_mappid=1108789561&_mvid=&_vt=3&referer=brandonlin&via=brandonlin&_sig=57b13f050e544ea7391452287c2f92c7ebf08e0d4bd1faef7d72c8c961ea80c9";
  public static final String DEFAULT_SWEET_MAIN_PAGE_JUMP_URL_FOR_GUEST = "mqqapi://miniapp/open?_atype=0&_mappid=1108789561&_mvid=&_path=%2Fpages%2Fhome_v2%2Floverindex%2Floverindex&_vt=3&referer=brandonlin&via=brandonlin&_sig=5769d092f16fddbe05f75e679074639954b1554710aee3060cedc8545b5c5f4b";
  public static final String DEFAULT_SWEET_SETTING_RED_DOT_ANIMATION_SRC = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/love_zone_setting_src/setting_me_love_zone_frame_ani.zip";
  public static final String DEFAULT_TENCENT_VIDEO_REQUEST_LEVEL_BLACKLIST_MODELS = "ALE-CL00;GT-N7108;N7108;A31c;ZTE A2019 Pro;Y51;A33";
  public static final int DEFAULT_TENCENT_VIDEO_REQUEST_LEVEL_BLACKLIST_OSVERSION = 20;
  public static final long DEFAULT_TIME_DELAY_TO_GET_GUIDE_QBOSS_ADV = 86400000L;
  public static String DEFAULT_TISSUE_BASELIB_URL = "{\"key1\":\"https://down.qq.com/miniapp/tissue_1.8.3.0.zip\",\"key2\":\"\",\"key3\":\"1.8.3.0\",\"key4\": {\"file_length\": 6831540},\"key5\":99}";
  public static final String DEFAULT_TRAVEL_ALBUM_LEFT_BG_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20191104215206_PfBsCode7B.png";
  public static final String DEFAULT_TRAVEL_ALBUM_RIGHT_BG_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20191104215206_8O4HN8FsAI.png";
  public static final int DEFAULT_TROOP_GRAY_TIPS_COOL_DOWN_HOURS = 24;
  public static final int DEFAULT_TROOP_GRAY_TIPS_MIN_PHOTO_COUNT = 9;
  public static final int DEFAULT_TTPIC_ENTRY_OFF = 0;
  public static final int DEFAULT_TTPIC_ENTRY_ON = 1;
  public static final String DEFAULT_UNION_VIP_FEED_URL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/bigVip/feedaz/lv{level}.zip";
  public static final String DEFAULT_UNION_VIP_HEAD_URL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/bigVip/headaz/lv{level}.zip";
  public static final String DEFAULT_UNION_VIP_HOME_URL = "https://h5.qzone.qq.com/bigVip/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32&source={aid}&_proxy=1";
  public static final String DEFAULT_UNION_VIP_PAY_URL = "https://h5.qzone.qq.com/vip/payBigDialog/{openUin}/{openMonth}?_wv=16781315&_wwv=13&_proxy=1&aid={aid}";
  public static final String DEFAULT_UNION_VIP_WIDGET_URL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/bigVip/widget/LV{level}.png";
  public static final int DEFAULT_UNREAD_FOLLOW_EXPOSURE_COUNT = 10;
  public static final String DEFAULT_UPLOAD_CHANGEROUTE_RETCODE = "104,115,11,2";
  public static final int DEFAULT_UPLOAD_ENABLE_DOWNLOAD_SO = 0;
  public static final String DEFAULT_UPLOAD_NETWORK_UNAVAILABLE_RETCODE = "113,101,100";
  public static final int DEFAULT_USE_QQ_EMOTICON_COMMENT = 0;
  public static final String DEFAULT_VALUE_WEBAUDIO_SO_INFO = "{\"url\":\"https://d3g.qq.com/sngapp/app/update/20200723130554_3898/libwebAudio.so\",\"md5\":\"c387d4ac69717660762353321313c6c4\",\"length\":13345220}";
  public static final String DEFAULT_VERTICAL_DOWNLOAD_PROGRESS_BACKGROUND_URL = "https://qzonestyle.gtimg.cn/aoi/sola/20180412205352_WOHxRvJEI2.png";
  public static final String DEFAULT_VERTICAL_DOWNLOAD_PROGRESS_BACKGROUND_URL_FROM_VS = "https://qzonestyle.gtimg.cn/aoi/sola/20190319155945_1kfosfdfO0.png";
  public static final int DEFAULT_VERTICAL_VIDEO_LAYER_DISABLE_UPLOAD_USER_ACTION = 0;
  public static final String DEFAULT_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_CANCEL_MSG = "再想想";
  public static final String DEFAULT_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_MSG = "去微视解锁更多精彩视频";
  public static final String DEFAULT_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_OK_MSG = "去下载";
  public static final String DEFAULT_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_TITLE = "下载微视APP";
  public static final int DEFAULT_VERTICAL_VIDEO_LAYER_LOW_MEMORY = 5;
  public static final String DEFAULT_VERTICAL_VIDEO_PLUGIN_SIZE_TEXT = "插件约1M";
  public static final String DEFAULT_VERTICAL_VIDEO_PLUGIN_UPDATE_TIPS = "升级插件，体验精彩小视频";
  public static final int DEFAULT_VIDEO_CACHE_SIZE_RATE_TIMEOUT = 3000;
  public static final int DEFAULT_VIDEO_ENABLE_ACTIVITY_DEFAULT_DETAIL_REPORT = 0;
  public static final int DEFAULT_VIDEO_ENABLE_LOCAL_HW_DETECTOR = 1;
  public static final int DEFAULT_VIDEO_ENABLE_LOCAL_HW_DETECTOR_GRAY_ENABLE = 1;
  public static final String DEFAULT_VIDEO_HOST_ENABLE_HTTPDNSSERVICE = "vwecam.tc.qq.com|vliveachy.tc.qq.com|vqzone.tc.qq.com";
  public static final String DEFAULT_VIDEO_HOST_ENABLE_HTTPDNSSERVICE_PREPENDIP = "vwecam.tc.qq.com|vliveachy.tc.qq.com|vqzone.tc.qq.com";
  public static final String DEFAULT_VIDEO_HWDEC_PROBE_BLACKLIST = "PAAM00;";
  public static final int DEFAULT_VIDEO_HWDEC_PROBE_SDK_INT_MAX = 28;
  public static final int DEFAULT_VIDEO_HWDEC_PROBE_SDK_INT_MIN = 21;
  public static final int DEFAULT_VIDEO_TAB_JUMP_TO_WEISHI = 1;
  public static final int DEFAULT_VIDEO_TAB_PRELOAD_NUMS = 10;
  public static final String DEFAULT_VIDEO_TVK_HOST = "vv6.video.qq.com";
  public static final String DEFAULT_WHITE_LIST_LOW = "vivo X5M|";
  public static final String DEFAULT_WHITE_LIST_MIDDLE = "VKY-AL00|BKL-AL20";
  public static final int DEFUALT_SECONDARY_KEY_QZONE_HOMEPAGE_SHAPON_CMD_VALUE = 1;
  public static final int DEFUALT_SHUOSHUO_NEWCARD_SHOW_VIEW = 0;
  public static final int DETAIL_COMMENT_SOFT_ORDER_DEFAULT = 1;
  public static final String DISAPPLEAR_WEISHI_ICON_ANIMATION_TIME = "ShowWeishiIconAnimationTime";
  public static final String DOWNLOAD_TO_DEFAULT_TAB = "downloadToDefaultTab";
  public static final int DYNAMIC_MAX_PHOTO_NUM = 60;
  public static final int DYNAMIC_MIN_PHOTO_NUM = 3;
  public static final String EXCEPTION_REPORT_RDM = "exception_report_rdm";
  public static final String FACATE_LOCAL_DATE = "Facate_Local_Date";
  public static final int FLOATING_SCREEN_ACTION_HIDE_WHEN_PLAY_CONFLICT = 2;
  public static final int FLOATING_SCREEN_ACTION_PAUSE_VIDEO_WHEN_PLAY_CONFLICT = 1;
  public static final String FLOAT_MODEL_BLACKLIST_DEFAULT_VALUE = "N5117,R8007,Coolpad 8720L,R7007,GN9000L,G620-L75,R2017,R6007,R831S,HM 1SC,Coolpad 8705,HUAWEI B199,Coolpad 9190L,HM 1SW,Coolpad 8730L,Coolpad 9190_T00,HS-E620M,HUAWEI G660-L075,Coolpad 5952,HUAWEI G730-L075,Coolpad 8729,HUAWEI C8817L,Bird LT01,Coolpad 5892,Coolpad 7620L,GN9004,HS-X8T,iPhone 6plus,K-Touch Tou ch 2,K-Touch Tou ch3,K-Touch Tou ch3w,Lenovo A560,Lenovo A890e,Lenovo B8080-HV,Lenovo S810t,LT18,MI 3C,N5110,Nokia_XL_4G,R2010,R8000,TCL-P688L,U558,ZTE Grand S II LTE,ZTE Q505T,ZTE Q802T,Coolpad Y60-C1,Coolpad 8702,BOWAY TL2000,Best sonny_LT986,BOWAY TL6000,Coolpad 5200S,Coolpad 5311,Coolpad 5315,DOOV T35,DOOV T60,HS-EG971,HS-EG978,HTC D516d,HUAWEI G6-L22,HUAWEI G620-L72,i6200S,KliTON,koobee M2,L-002,L823,L826,L827,Lingwin K1,LNV-Lenovo A505e,M7009,M811,MI 3W,R830S,ZTE Q801L,ZTE Q701C,YUSUN L63,TCL P631M,TCL J738M,T-smart L818,OUKI G5,OPSSON Q3,　　,MT2L03,VOTO VT898,AOLE,N5111,LA2-L,vtel X5,ETON T3,BOWAY TL500,T-smart L808,DOOV T90,CHM-TL00,thl L968,TCL J938M,2013022,HUAWEI G750-T01,vivo Y20T,vivo Y17T,vivo Y13T,vivo Y15T,vivo X3S W,U707T,R823T,R819T,N1T,Hol-T00,H8S,H30-U10,2014011,M351,HUAWEI G610-T11,vivo X3t,HUAWEI P6-T00,HUAWEI G700-U00,ETON I6,vivo Y11i T,HM NOTE 1TD";
  public static final String GAME_MEMORY_LIMIT = "gameMemoryLimit";
  public static final String GAME_MEMORY_SWITCH = "gameMemorySwitch";
  public static final String GDT_CGI_REPORT_HOST = "GdtCgiReportHost";
  public static final int HOMEPAGE_GUEST_DEFAULT_COVER_SHOW_DELAY_MS_VALUE = 3000;
  public static final String IS_PATCH_ENABLE = "isPatchEnable";
  public static final String IS_SHOW_SAFE_MODE = "isShowSafeMode";
  public static final String KEY_BUSINESSDATA = "key_businessfeeddata";
  public static final String KEY_MARTET_TO_DOWNLOAD_WEISHI = "DownloadWeishiFromMarket";
  public static final String KEY_SHOW_ENTRANCE_GUIDE = "showEntranceGuide";
  public static final String KEY_SHOW_TIME_LINE_FOR_GUEST_IN_RECENT_PHOTO_TAB = "showTimelineButtonForGuestInRecentPhotoTab";
  public static final String KEY_SHOW_TIME_LINE_FOR_HOST_IN_RECENT_PHOTO_TAB = "showTimelineButtonForHostInRecentPhotoTab";
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
  public static final String MAIN_KEY_BUBBLE_UNREAD = "K_QQ_VAS";
  @Deprecated
  public static final String MAIN_KEY_CLICKREPORT = "ReportSetting";
  public static final String MAIN_KEY_CLIENTREPORT = "ClientReport";
  public static final String MAIN_KEY_CONTENT_BOX_LAUNCH = "contentboxlaunch";
  public static final String MAIN_KEY_CONTENT_PUBLISH = "ContentPublish";
  public static final String MAIN_KEY_DANMUKU = "Danmuku";
  public static final String MAIN_KEY_DOWNLOAD_SETTING = "DownloadSetting";
  public static final String MAIN_KEY_EASTEREGG = "EasterEgg";
  public static final String MAIN_KEY_EXTRA_CONFIG = "ExtraConfig";
  public static final String MAIN_KEY_FACADE = "QzoneFacade";
  public static final String MAIN_KEY_FAKE_FEED_SOFT_PERIOD = "fake_feed_soft_period";
  public static final String MAIN_KEY_FEEDSPRE = "FeedsPre";
  public static final String MAIN_KEY_FEEDS_SEARCH = "FeedsSearch";
  public static final String MAIN_KEY_FEED_PIC_TEXT_CARD_VIEW = "FeedPicTextCardView";
  public static final String MAIN_KEY_FLOATING_SCREEN = "floating_screen";
  public static final String MAIN_KEY_FORBIDDEN_PAGE_FEED = "feedForbiddenPage";
  public static final String MAIN_KEY_GETUSERTIMELOGO = "QZoneGetUserTimeLogo";
  public static final String MAIN_KEY_GIFT = "Gift";
  public static final String MAIN_KEY_H5URL = "H5Url";
  public static final String MAIN_KEY_HOMEPAGE_BAR = "HomepageBar";
  public static final String MAIN_KEY_JUMPQZONE = "JumpQzone";
  public static final String MAIN_KEY_LIVE_VIDEO = "LiveSetting";
  public static final String MAIN_KEY_LOADING_PHOTO = "LoadingPhoto";
  public static final String MAIN_KEY_MEDIAFRAME = "MediaFrame";
  public static final String MAIN_KEY_MEMORY = "memmory_policy";
  public static final String MAIN_KEY_MINIAPP = "qqminiapp";
  public static final String MAIN_KEY_MINIAPP_QQ = "qqminiapp";
  public static final String MAIN_KEY_MINIGAME = "qqtriton";
  public static final String MAIN_KEY_MINI_APP = "qqminiapp";
  public static final String MAIN_KEY_MINI_VIDEO = "MiniVideo";
  public static final String MAIN_KEY_ML = "machinelearning";
  public static final String MAIN_KEY_NAVIGATOR_BAR = "NavigationBar";
  public static final String MAIN_KEY_OFFICIAL_ACCOUNT = "OfficialAccount";
  public static final String MAIN_KEY_OFFLINE_CACHE = "QzUrlCache";
  public static final String MAIN_KEY_OSKPLAYER = "OskPlayer";
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
  public static final String MAIN_KEY_PLATO = "Plato";
  public static final String MAIN_KEY_PM_MONITOR = "PerformanceMonitor";
  public static final String MAIN_KEY_POLY_PRAISE = "polymorphicPraise";
  public static final String MAIN_KEY_PUBLISH_MOOD = "PublishMood";
  public static final String MAIN_KEY_PUSH = "Push";
  public static final String MAIN_KEY_QQCIRCLE = "qqcircle";
  public static final String MAIN_KEY_QQ_EMOTICON_COMMENT = "QZoneCommentSetting";
  public static final String MAIN_KEY_QQ_LIVE = "qqLive";
  public static final String MAIN_KEY_QQ_STORY_VIDEO_SETTING = "qqstoryvideo";
  public static final String MAIN_KEY_QQ_SUBSCRIBE_SETTING = "qqsubscribe";
  public static final String MAIN_KEY_QUN_ALBUM_SETTING = "QunAlbumSetting";
  public static final String MAIN_KEY_QZONECOVER = "QzoneCover";
  public static final String MAIN_KEY_QZONE_EXTEND_LIVE = "K_QZKuolieEnterance";
  public static final String MAIN_KEY_QZONE_HOMEPAGE = "QzoneHomepage";
  public static final String MAIN_KEY_QZONE_KAPU = "QzoneKapu";
  public static final String MAIN_KEY_QZONE_SETTING = "QZoneSetting";
  public static final String MAIN_KEY_QZONE_TEXTCELL_SETTING = "QZoneTextCellSetting";
  public static final String MAIN_KEY_QZ_CUSTOM_FONT = "QzCustomFont";
  public static final String MAIN_KEY_RANK_COMMENT = "rank_comment";
  public static final String MAIN_KEY_REPORT = "qzoneReport";
  public static final String MAIN_KEY_SAFEMODE = "SafeModeSetting";
  public static final String MAIN_KEY_SCHEMA = "Schema";
  public static final String MAIN_KEY_SEARCH_MOOD = "QZSearch";
  public static final String MAIN_KEY_SECRET_SHUOSHUO = "ScretShuoShuo";
  public static final String MAIN_KEY_SELF_PRAISE_ANIMATION = "self_praise_animation";
  public static final String MAIN_KEY_SHARE_TO_WX = "share_to_wx";
  public static final String MAIN_KEY_SWEET_MINI_APP = "sweet_miniapp";
  public static final String MAIN_KEY_TRIM = "TrimVideo";
  public static final String MAIN_KEY_UGC_EMPTY_PAGE = "ugcEmptyPage";
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
  public static final String MAIN_KEY_WEBVIEW_SETTING = "WebviewSetting";
  public static final String MAIN_KEY_WEISHI_SETTING = "WeishiSetting";
  public static final String MAIN_KEY_WNSSETTINGS = "WNSSettting";
  public static final String MAIN_QZONE_LOG = "TraceLog";
  public static final int MAKE_VIDEO_ALBUM_MAX_PHOTO_NUM = 30;
  public static final int MANAGEMENT_MAX_PHOTO_NUM = 50;
  public static final int MANAGEMENT_MAX_VIDEO_NUM = 3;
  public static final String MAX_PENDING_REPORT_TASK_NUM = "max_pending_report_task_num";
  public static final String MAX_REPORT_TASK_PENDING_DAY = "max_report_task_pengding_day";
  public static final String MEMORY_LEVEL1_RESIZE_RATION = "memory_level1_resize_ration";
  public static final String MEMORY_LEVEL1_TRIM_RATION = "memory_level1_trim_ration";
  public static final String MEMORY_LEVEL2_RESIZE_RATION = "memory_level2_resize_ration";
  public static final String MEMORY_LEVEL2_TRIM_RATION = "memory_level2_trim_ration";
  public static final String MEMORY_LEVEL3_RESIZE_RATION = "memory_level3_resize_ration";
  public static final String MEMORY_LEVEL3_TRIM_RATION = "memory_level3_trim_ration";
  public static final String MINI_APPCONFIG_CACHE_TIME = "mini_appconfig_cache_time";
  public static final String MINI_APP_APPINFOENTITY_DELEATE_INTERVAL_TIME = "mini_app_appinfoentity_interval_time";
  public static final String MINI_APP_ARK_SCENE_WHITE_LIST = "ark_scene_white_list";
  public static final String MINI_APP_CAPSULE_CLOSE_DARK_URL = "closebuttondark";
  public static final String MINI_APP_CAPSULE_CLOSE_URL = "closebutton";
  public static final String MINI_APP_CHOOSE_ADDRESS_DEFAULT_URL = "https://i.qianbao.qq.com/profile/address/choose.html";
  public static final String MINI_APP_CRASH_PROTECT = "mini_app_crash_protect";
  public static final String MINI_APP_CRASH_PROTECT_TIME = "mini_app_crash_protect_time";
  public static final int MINI_APP_DESKTOP_OPENED_AUTO_HIDE = 2;
  public static final String MINI_APP_DOWNLOAD_HTTP_CONNECT_LIVE_TIME = "mini_app_download_http_connect_live_time";
  public static final String MINI_APP_DOWNLOAD_HTTP_THREADPOOL_SIZE = "mini_app_download_http_tp_size";
  public static final String MINI_APP_DOWNLOAD_PIPELINE_ENABLE = "mini_app_download_pipeline_enable";
  public static final int MINI_APP_DOWNLOAD_PIPELINE_ENABLE_DEFAULT = 0;
  public static final String MINI_APP_EMBEEDDED_VIDEO_FPS_INTERVAL_TIME = "mini_app_embeedded_video_fps_interval_time";
  public static final String MINI_APP_ENABLE_DB_APPINFO_CACHE = "mini_app_enable_db_appinfo_cache";
  public static final String MINI_APP_ENABLE_DB_CACHE = "mini_app_enable_db_cache";
  public static final String MINI_APP_ENABLE_EMBEDDED_LIVE = "enable_embedded_live";
  public static final String MINI_APP_ENABLE_EMBEDDED_VIDEO = "enable_embedded_video";
  public static final String MINI_APP_ENABLE_JSERROR_TIP = "mini_app_jserror_tip_enable";
  public static final String MINI_APP_ENABLE_WHITE_SCREEN_CHECK_AFTER_DOMREADY = "mini_app_enable_white_screen_check_after_domready";
  public static final String MINI_APP_EXTRA_PRELOAD = "mini_app_preload_extra";
  public static final int MINI_APP_EXTRA_PRELOAD_DEFAULT = 1;
  public static final String MINI_APP_FLUTTER_ENABLE = "mini_flutter_enable";
  public static final int MINI_APP_FLUTTER_ENABLE_DEFAULT = 0;
  public static final String MINI_APP_FLUTTER_PKG_PRELOAD_ENABLE = "mini_flutter_enable_pkg_preload";
  public static final String MINI_APP_FLUTTER_PRELAUNCH_CHECKIN_ENABLE = "mini_flutter_prelaunch_checkin_enable";
  public static final int MINI_APP_FLUTTER_PRELAUNCH_CHECKIN_ENABLE_DEFAULT = 1;
  public static final String MINI_APP_GET_PSKEY_DOMAIN = "qzone.qq.com";
  public static final String MINI_APP_GOOGLE_PLAY_AD_SWITCH = "mini_app_google_play_ad_switch";
  public static final String MINI_APP_GOOGLE_PLAY_DOWNLOAD_SWITCH = "mini_app_google_play_download_switch";
  public static final String MINI_APP_GOOGLE_PLAY_LOAD_SO_SWITCH = "mini_app_google_play_load_so_switch";
  public static final String MINI_APP_GOOGLE_PLAY_PAY_SWITCH = "mini_app_google_play_pay_switch";
  public static final String MINI_APP_HTTPS_IPDIRECT_ENABLE = "mini_app_https_ipdirect_enable";
  public static final String MINI_APP_INNER_BASELIB_RETRY_COUNT = "mini_app_inner_baselib_retry_count";
  public static final String MINI_APP_INTENT_INVALID_RESTART = "mini_app_intent_valid_restart";
  public static final String MINI_APP_KIINGCARD_DARK_LOTTIE = "kingcardGuideDarkLottie";
  public static final String MINI_APP_KIINGCARD_GUIDE_ICON = "kingcardGuideIcon";
  public static final String MINI_APP_KIINGCARD_GUIDE_TEXT = "kingcardGuideText";
  public static final String MINI_APP_KIINGCARD_LOTTIE = "kingcardGuideLottie";
  public static final String MINI_APP_KILL_WHEN_UI_DESTROY = "mini_app_kill_when_uidestroy";
  public static final String MINI_APP_KUOLIE_RECOMM_ENABLE = "mini_app_kuolie_recomm_enable";
  public static final String MINI_APP_MEMORY_ALERT_MODE = "mini_process_mem_alert_mode";
  public static final String MINI_APP_MEMORY_DETECT_ALERM = "mini_process_mem_detect_alerm";
  public static final String MINI_APP_MEMORY_DETECT_ENABLE = "mini_process_mem_detect_enable";
  public static final String MINI_APP_NAVIGATE_BACK_BY_APPINFO = "mini_app_navigate_back_by_appinfo";
  public static final String MINI_APP_OPEN_STORE_USE_APPID = "mini_app_open_store_use_appid";
  public static final String MINI_APP_OTHERENTITY_DELEATE_INTERVAL_TIME = "mini_app_otherentity_interval_time";
  public static final String MINI_APP_PRECACHE_PERIOD_MILLIS = "mini_app_precache_period_millis";
  public static final long MINI_APP_PRECACHE_PERIOD_MILLIS_DEFAULT = 43200000L;
  public static final String MINI_APP_PRECACHE_RESOURCE_MAX_COUNT = "mini_app_precache_resource_maxsize";
  public static final int MINI_APP_PRECACHE_RESOURCE_MAX_COUNT_DEFAULT = 3;
  public static final String MINI_APP_PRECACHE_SIZE_LIMIT = "mini_app_precache_size_limit";
  public static final int MINI_APP_PRECACHE_SIZE_LIMIT_DEFAULT = 262144;
  public static final String MINI_APP_PRELOAD_DELETE_TIME = "mini_app_preload_delete_time";
  public static final String MINI_APP_PRELOAD_INTERVAL_TIME = "mini_app_preload_interval_time";
  public static final String MINI_APP_PRELOAD_SWITCHER = "mini_app_preload_switcher";
  public static final String MINI_APP_PROCESS_BACKGROUND_DETECT_TIME = "mini_app_process_background_detect_time";
  public static final String MINI_APP_PROCESS_DETECT_TIME = "mini_app_process_detect_time";
  public static final String MINI_APP_PROCESS_FOREGROUND_DETECT_TIME = "mini_app_process_foreground_detect_time";
  public static final String MINI_APP_PROCESS_KILL_MODE = "mini_app_process_kill_mode";
  public static final String MINI_APP_PROCESS_MAX_COUNT = "mini_app_process_max";
  public static final String MINI_APP_PROCESS_PRELOAD_COUNT = "mini_app_process_preload_count";
  public static final String MINI_APP_PROCESS_PRELOAD_PRIORITY = "mini_process_preload_priority";
  public static final String MINI_APP_PROCESS_RECYCLE_TIME = "mini_app_process_recycle_time";
  public static final String MINI_APP_REDIRECT_TO_CONFIG = "mini_app_redirectto_config";
  public static final String MINI_APP_REPORT_COUNT_THRESHOLD = "mini_app_report_count_threshold";
  public static final String MINI_APP_REPORT_EVENT_CONFIG = "mini_app_report_event_config";
  public static final String MINI_APP_REPORT_FIRST_FRAME_FLUSH = "mini_app_report_first_frame_flush";
  public static final String MINI_APP_REPORT_MAX_TIME_COST = "mini_app_report_max_time_cost";
  public static final String MINI_APP_REPORT_TIME_THRESHOLD = "mini_app_report_time_threshold";
  public static final String MINI_APP_REPORT_WHITE_SCREEN_TIME_CHECK = "mini_app_report_white_screen_check";
  public static final String MINI_APP_SCHEME_APPID_WHITE_LIST = "mini_app_scheme_appid_white_list";
  public static final String MINI_APP_SCHEME_OUTSITE_BLACK_LIST = "mini_app_outsite_black_list";
  public static final String MINI_APP_SCREEN_DETECT = "mini_app_screen_detect";
  public static final int MINI_APP_SCREEN_DETECT_DEFAULT = 1;
  public static final int MINI_APP_SHOW_RED_DOT = 1;
  public static final String MINI_APP_START_INTERVAL_TIME = "mini_app_start_interval_time";
  public static final String MINI_APP_SUBPKG_PATH_INTERCEPT = "mini_app_subpkg_path_intercept";
  public static final String MINI_APP_SYSTEM_PERMISSION_CONFIG = "{\"chooseLocation\":\"android.permission.ACCESS_FINE_LOCATION\",\"openLocation\":\"android.permission.ACCESS_FINE_LOCATION\",\"getLocation\":\"android.permission.ACCESS_FINE_LOCATION\",\"chooseVideo\":\"android.permission.CAMERA\",\"chooseImage\":\"android.permission.CAMERA\",\"saveImageToPhotosAlbum\":\"android.permission.WRITE_EXTERNAL_STORAGE\",\"saveVideoToPhotosAlbum\":\"android.permission.WRITE_EXTERNAL_STORAGE\",\"startRecord\":\"android.permission.RECORD_AUDIO\",\"operateRecorder\":\"android.permission.RECORD_AUDIO\",\"joinVoIPChat\":\"android.permission.RECORD_AUDIO\",\"operateCamera\":\"android.permission.CAMERA\",\"updateCamera\":\"android.permission.CAMERA\",\"insertCamera\":\"android.permission.CAMERA\"}";
  public static final String MINI_APP_ShARE_TO_WX_SWITCHER = "mini_app_share_to_wx_switcher";
  public static final String MINI_APP_UPGRADE_URL = "mini_app_upgrade_url";
  public static final String MINI_APP_USE_DOWNLOAD_OPTIMIZE = "mini_app_use_download_optimize";
  public static final String MINI_APP_USE_SUPER_PLAYER = "useSuperPlayer";
  public static final int MINI_APP_USE_SUPER_PLAYER_DEFAULT = 0;
  public static final String MINI_APP_WANBAR_CACHED_FAKEURL = "mini_app_wanba_cached_fakeurl";
  public static final String MINI_APP_WHITE_SCREEN_SHOT_MAX_HEIGHT = "mini_app_white_screen_shot_max_height";
  public static final String MINI_APP_WHITE_SCREEN_SHOT_MAX_WIDTH = "mini_app_white_screen_shot_max_width";
  public static final String MINI_APP_XPROF_API_REPORT = "xprof_api_report";
  public static final String MINI_GAME_CAPSULE_SHOW_RESTART_BTN = "mini_game_capsule_show_restart_btn";
  public static final String MINI_GAME_FORCE_DOWNLOAD_IN_MAINPROCESS = "mini_game_force_download_in_mainprocess";
  public static final int MINI_GAME_FORCE_DOWNLOAD_IN_MAINPROCESS_DEFAULT = 0;
  public static final String MINI_GAME_JANK_TRACE_SAMPLING_RATE = "mini_game_jank_trace_sampling_rate";
  public static final int MINI_GAME_JANK_TRACE_SAMPLING_RATE_DEFAULT = 100;
  public static final String MINI_GAME_PAY_BY_H5 = "mini_game_pay_by_h5";
  public static final String MINI_GAME_PAY_BY_H5_URL = "mini_game_pay_by_h5_url";
  public static final String MINI_GAME_PAY_BY_H5_URL_LANDSCAPE = "mini_game_pay_by_h5_url_landscape";
  public static final String MINI_GAME_PROCESS_INFO_COUNT = "mini_game_process_info_count";
  public static final String MINI_GAME_PROCESS_MAX_COUNT = "mini_game_process_max";
  public static final String MINI_GAME_PROCESS_RECYCLE_TIME = "mini_game_process_recycle_time";
  public static final String MINI_GAME_PROCESS_REUSE = "mini_game_process_reuse";
  public static final String MINI_GAME_PROCESS_REUSE_BLACKLIST = "mini_game_process_reuse_blacklist";
  public static final String MINI_GAME_PUBLIC_ACCOUNT_GAME_STORE_BUTTON_URL = "publicAccountGameStoreButtonUrl";
  public static final String MINI_GAME_RETAIN_ALERT_VIEW_SCENE = "qqMiniappRetainAlterViewScene";
  public static final String MINI_GAME_RETAIN_CONFIRM_ANIMATION_IMAGE_URL = "mini_game_retain_confirm_animation_image_url";
  public static final String MINI_GAME_RETAIN_CONFIRM_EXPOSURE_TIMES_THRESHOLD = "retainConfirmTimesLimit";
  public static final String MINI_GAME_RETAIN_CONFIRM_INTERVAL = "retainConfirmInterval";
  public static final String MINI_RUNTIME_ALIVE_IDLIST_INTERNAL = "mini_runtime_alive_ids_internal";
  public static final String MINI_SDK_PRELAUNCH_ALL_ENABLE = "mini_sdk_prelaunch_all_enable";
  public static final int MINI_SDK_PRELAUNCH_ALL_ENABLE_DEFAULT = 1;
  public static final String MINI_SDK_PRELAUNCH_ENABLE = "mini_sdk_prelaunch_enable";
  public static final int MINI_SDK_PRELAUNCH_ENABLE_DEFAULT = 1;
  public static final int ML_EXPOSED_MEDIA_UPPER_BOUND_DEFAULT = 50;
  public static final int ML_IS_PHOTO_TAG_FILLUP_ENABLED_DEFAULT = 1;
  public static final String ML_PACKAGE_FILE_MD5_DEFAULT = "1c3abb74834be02cb9538208c335993f,61223fa4cd476a914e63eae129bd2122,275731f4dce59486d14985f483c6bd53,c83c2577ef2f12057b51fc6f60f2661d,be740b33fe101c1e6b4df43fae5169c4";
  public static final int ML_PHOTO_TAG_FILLUP_AVAILABLE_PAGE = 7;
  public static final int ML_PHOTO_TAG_FILLUP_CPU_USAGE_SHRESHOLD_DEFAULT = 50;
  public static final int ML_PHOTO_TAG_FILLUP_INTEVALTIME_DEFAULT = 1000;
  public static final String ML_PHOTO_TAG_FILLUP_PHOTO_COUNT_DEFAULT = "30|40|50";
  public static final String NEED_TO_CHANGE_FOR_RAPID_COMMENT = "needToChangeForRapidComment";
  public static final long NEW_EVENT_BUBLE_STAY_TIME_DEFAULT = 5000L;
  public static final int NOT_LOAD = 0;
  public static final int OFFLINE_DECODE_PHOTO_QUALITY_DEFAULT = 90;
  public static final int ONEKEY_BEAUTIFY_DEFAULT_IMAGE_SUPPORT_COUNT = 20;
  public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_DISABLE = 1;
  public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_ENABLE = 0;
  public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_IGNORE = 2;
  public static final int PRELOAD_HTML_PAGE_URL_MAX_COUNT_DEFAULT = 100;
  public static final String PRELOAD_SMALL_GAME_ALLOW_HOURS_DEFAULT = "1,2,3,4,5,6,7,8,9,10,14,15,16,17,18";
  public static final int PRELOAD_SMALL_GAME_HTML_ENABLE_DEFAULT = 0;
  public static final int PRELOAD_SMALL_GAME_INTERVAL_SECONDS_DEFAULT = 86400;
  private static final String PRINTCONFIG_TAG = "CMD_PRINT_WNS_CONFIG";
  public static final String PUBLIC_ACCOUNT_DISCOVER_ENTRY_ENABLE = "publicAcuntDiscoverEntryEnable";
  public static final String PUBLIC_ACCOUNT_DISCOVER_PAGE_SCHEMA = "publicAcuntDiscoverPageSchema";
  public static final int QCIRCLE_JUMP_TO_PUBLISH = 1;
  public static final int QCIRCLE_JUMP_TO_PUBLISH_DELAY_TIME = 2000;
  public static final int QCIRCLE_JUMP_TO_PUBLISH_FROM_QCIRCLE = 1;
  public static final int QCIRCLE_VIDEO_TIMEOUT_MAX_RETRY_COUNT = 1;
  public static final int QCIRCLE_VIDEO_URL_VALID_TIME_DEFAULT_VALUE = 21600000;
  public static final String QUEUE_PAUSEABLE = "queue_pausable";
  public static final String QUEUE_PAUSE_TIMEOUT = "queue_timeout";
  public static final String QZONE_ALBUM_COMMENTS_URL = "QZoneAlbumComments";
  public static final String QZONE_ALBUM_LOAD_MAP_SDK = "LoadMapSdk";
  public static final String QZONE_ALBUM_VISITORS_URL = "QZoneAlbumVisitors";
  public static final String QZONE_CALL_APP_URL_LIST_DEFAULT = "['https?://intent\\.music\\.163\\.com.+orpheus.*','^https?://([^/]+\\.)?thefatherofsalmon\\.com[/:].+','^https?://127\\.0\\.0\\.1[/:].+','^https?://0:0:0:0:0:0:0:1[/:].+','^https?://::1[/:].+']";
  public static final String QZONE_CONFIG_MAIN_KEY_TROOP_GRAY_TIPS = "aio_qzone_troop_gray_tips";
  public static final String QZONE_CONFIG_SECONDARY_KEY_IS_PHOTO_SAVE = "PhotoBrowserEnableSave";
  public static final String QZONE_CONFIG_SECONDARY_KEY_IS_QRCODE_SCAN = "PhotoBrowserEnableScanQRCode";
  public static final String QZONE_CONFIG_SECONDARY_KEY_LABEL_TEXT = "photocategorylabeltext";
  public static final String QZONE_CONFIG_SECONDARY_KEY_LOCAL_PHOTO_MARKER_SWITCH = "localPhotoMarkerSwitch";
  public static final String QZONE_CONFIG_SECONDARY_KEY_LOCAL_PHOTO_PRESCAN_NUMBER = "localPhotoPreScanNumber";
  public static final String QZONE_CONFIG_SECONDARY_KEY_LOCATION_TEXT = "photocategorylocationtext";
  public static final String QZONE_CONFIG_SECONDARY_KEY_NEED_GETPICMARKER = "uploadneedgetpicmarker";
  public static final String QZONE_CONFIG_SECONDARY_KEY_NEED_SHOWLBSLIST = "needshowlibslist";
  public static final String QZONE_CONFIG_SECONDARY_KEY_PORTRAIT_TEXT = "photocategoryportraittext";
  public static final String QZONE_CONFIG_SECONDARY_KEY_PRESCAN_NUMBER = "localPhotoMarkerPreScanNumber";
  public static final String QZONE_CONFIG_SECONDARY_KEY_SHOW_MAKEVIDEO_IN_ACTIONSHEET = "isShowMakeVideoInActionSheet";
  public static final String QZONE_CONFIG_SECONDARY_KEY_SHOW_MAKEVIDEO_IN_TOOLBAR = "isShowMakeVideoInToolBar";
  public static final String QZONE_CONFIG_SECONDARY_KEY_SHOW_MAKEVIDEO_MAX_PIC_VIDEO_COUNT = "makevideoMaxPicVideoCount";
  public static final String QZONE_CONFIG_SECONDARY_KEY_TROOP_GRAY_TIPS_COOL_DOWN = "troop_gray_tips_cool_down";
  public static final String QZONE_CONFIG_SECONDARY_KEY_TROOP_GRAY_TIPS_MIN_PHOTO_COUNT = "troop_gray_tips_min_photo_count";
  public static final int QZONE_Dynamic_Cover_ANIMATE_TIME_VALUE = 25;
  public static final String QZONE_Dynamic_Cover_URL_VALUE = "https://h5.qzone.qq.com/show/quickReplaceCover?_wv=131072&_fv=0";
  public static final String QZONE_EVENT_TAG_DEFAULT_PIC_URL = "QZoneEventTag_EventTagDefaultPicUrl";
  public static final String QZONE_EVENT_TAG_FEED_WRITE_MOOD_TEXT = "QZoneEventTag_EventTagFeedMoodText";
  public static final String QZONE_EVENT_TAG_MAIN_KEY = "QZoneEventTag";
  public static final String QZONE_EVENT_TAG_REQUEST_INPUT_TIME = "TagRequestInpuTime";
  public static final String QZONE_EVENT_TAG_REQUEST_TEXT_LENGTH = "TagRequestTextLenth";
  public static final String QZONE_FACADE_DYNAMIC_DEFAULT_BLACK_LIST = "GT-N7108";
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
  public static final String QZONE_SPECIAL_FOLLOW_COTAINER_MAIN_KEY = "QZoneSpecialFollowContainer";
  public static final String QZONE_UGC_PERMISSION_USERS_LIST_URL = "QZoneUgcPermissionUsersUrl";
  public static final String QZONE_VIDEO_AUTO_PLAY_KEY = "VideoAutoPlay";
  public static final String QZONE_VIDEO_LAYER_PASTER_VIDEO_ADV_REPLAY_TIME_STAMP_KEY = "PremovieAdvReplayTimeInterval";
  public static final String QZONE_VIDEO_LAYER_SHOW_ADV_TIPS_DURATION_SECONDARY_KEY = "VideoLayerShowAdvTipsDuration";
  public static final String QZONE_VIDEO_MAIN_KEY = "QZVideo";
  public static final String QZPB_IP_VIDEO_HOST = "video_host_qzpb";
  public static final String QZVV_IP_VIDEO_HOST = "video_host_qzvv";
  public static final String RECENT_PHOTO_BLOCK_PATHS_DEFAULT = "MagazineUnlock";
  public static final int RECENT_PHOTO_LIMIT_MIN_SIZE_DEFAULT = 20480;
  public static final int RECENT_PHOTO_LIMIT_MIN_WIDTH_DEFAULT = 100;
  public static final int RECENT_PHOTO_MAX_NUM_DEFAULT = 200;
  public static final int REPORT_ACTION_FLOW_SIZE_DEFAULT = 800;
  public static final String SCHEME_FOR_SWEET_MAIN_PAGE_JUMP = "mqzone://arouse/lovermainpage";
  public static final String SECONDART_KEY_ALBUM_RECOM_UPLOAD_BAR_COUNT_LIMIT_LEVEL = "AlbumRecomUploadLimitedLevel";
  public static final String SECONDART_KEY_PHOTOLIST_NEED_SHOW_ALL_SELECT = "PhotoListNeedShowAllSelect";
  public static final String SECONDARYUGC_EMPTY_DEFAULT_PAGE = "ugcEmptyDefaultPage";
  public static final String SECONDARYUGC_EMPTY_NO_NETWORK_PAGE = "ugcEmptyNoNetWorkPage";
  public static final String SECONDARYUGC_SHUOSHUO_EMPTY_VIEW = "shuoshuoEmptyView";
  public static final String SECONDARY_ACC_REPORT_COUNT = "AccReportCount";
  public static final String SECONDARY_ACC_REPORT_INTERVAL = "AccReportInterval";
  public static final String SECONDARY_ACC_REPORT_SAMPLES = "AccReportSamples";
  public static final String SECONDARY_ACTIVEMOODBTN_ENTER_PHOTOUPLOAD = "activeMoodBtnEnterPhotoUpload";
  public static final String SECONDARY_ACTIVITY_SWITCH_ACC_REPORT_SAMPLES = "ActivitySwitchAccReportSamples";
  public static final String SECONDARY_AD_FEED_EXPOSE_TIME = "ADFeedExposeTime";
  public static final String SECONDARY_AIO_CM_PAY_JUMP_URL = "aioCMShowPreviewPayUrl";
  public static final String SECONDARY_AIO_ENABLE_SHOW_QZONE_ALBUM = "AioEnableShowQzoneAlbum";
  public static final String SECONDARY_AIO_FRIEND_FEED_ITEM_BLOG_TITLE_MAX_LENGTH = "qzoneAioFriendFeedBlogTitleMaxLength";
  public static final String SECONDARY_AIO_FRIEND_FEED_ITEM_LOGO_WATERMARK_IMG_URL = "qzoneAioFriendFeedLogoWaterImgUrl";
  public static final String SECONDARY_AIO_FRIEND_FEED_ITEM_NICKNAME_MAX_LENGTH = "qzoneAioFriendFeedNicknameMaxLength";
  public static final String SECONDARY_AIO_FRIEND_FEED_ITEM_PIC_BLOG_TILTE_MAX_LENGTH = "qzoneAioFriendFeedPicBlogTitleMaxLength";
  public static final String SECONDARY_AIO_QZONE_LOVE_GRAY_TIPS_KEY = "aio_qzone_love_gray_tips";
  public static final String SECONDARY_AIO_SHOW_FEED_LIST = "AioShowFeedList";
  public static final String SECONDARY_ALBUM_BANNER_DP_PROCESS_GROUP_SIZE = "secondary_album_banner_dp_process_group_size";
  public static final String SECONDARY_ALBUM_HISTORY_GROUP_ACTIVITY_SUB_TITLE = "historyLocalPhotoActivitySubTitle";
  public static final String SECONDARY_ALBUM_HISTORY_GROUP_ACTIVITY_TITLE = "historyLocalPhotoActivityTitle";
  public static final String SECONDARY_ALBUM_LIKE_LIST = "AlbumLikeList";
  public static final String SECONDARY_ALBUM_LIST_MAX_COUNT = "albumListMaxCount";
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
  public static final String SECONDARY_ALBUM_PHOTO_HIGH_DEVICE_MAX_SCAN_PHOTO_NUM = "albumRecommendHighDeviceMaxScanPhotoNum";
  public static final String SECONDARY_ALBUM_PHOTO_IN_FEED_PAGE_ENBALE = "secondary_album_photo_in_feed_page_enable";
  public static final String SECONDARY_ALBUM_PHOTO_LOW_DEVICE_FIRST_GET_SMART_INFO_NUM = "albumRecommendLowDeviceFirstGetSmartInfoNum";
  public static final String SECONDARY_ALBUM_PHOTO_LOW_DEVICE_MAX_SCAN_PHOTO_NUM = "albumRecommendLowDeviceMaxScanPhotoNum";
  public static final String SECONDARY_ALBUM_PHOTO_MIDDLE_DEVICE_FIRST_GET_SMART_INFO_NUM = "albumRecommendMiddleDeviceFirstGetSmartInfoNum";
  public static final String SECONDARY_ALBUM_PHOTO_MIDDLE_DEVICE_MAX_SCAN_PHOTO_NUM = "albumRecommendMiddleDeviceMaxScanPhotoNum";
  public static final String SECONDARY_ALBUM_PHOTO_MIN_PHOTO_CNT_PER_GROUP = "secondary_album_photo_min_photo_cnt_per_group";
  public static final String SECONDARY_ALBUM_PHOTO_MIN_SCAN_PHOTO_NUM = "albumRecommendMinScanPhotoNum";
  public static final String SECONDARY_ALBUM_PHOTO_PRELOAD_MAX_BITMAP = "secondary_gif_edit_preload_max_bitmap";
  public static final String SECONDARY_ALBUM_PHOTO_REQ_ALL_GROUP_VERSION = "PhotoRecommendReqAllGroupVersion";
  public static final String SECONDARY_ALBUM_PHOTO_SCAN_MAX_SAME_TIME_PHOTO_NUM = "albumRecommendScanMaxSameTimePhotoNum";
  public static final String SECONDARY_ALBUM_PHOTO_SCAN_TIME_INTERVAL = "albumRecommendScanTimeInterval";
  public static final String SECONDARY_ALBUM_PHOTO_SHOW_END_HOUR = "secondary_album_photo_show_end_hour";
  public static final String SECONDARY_ALBUM_PHOTO_SHOW_START_HOUR = "secondary_album_photo_show_start_hour";
  public static final String SECONDARY_ALBUM_REC_FEED_EMPTY_PIC_URL = "AlbumRecFeedEmptyPicUrl";
  public static final String SECONDARY_ALBUM_REC_FEED_EXPOSE_PERIOD = "AlbumRecFeedExposePeriod";
  public static final String SECONDARY_ALBUM_SHARE_DYNAMIC_MAX_PHOTO_NUM = "AlbumShareDynamicMaxPhotoNum";
  public static final String SECONDARY_ALBUM_SHARE_DYNAMIC_URL = "AlbumShareDynamicUrl";
  public static final String SECONDARY_ALBUM_SHOW_MODE = "themePhotoDefaultMode";
  public static final String SECONDARY_ALBUM_UPLOAD_PLUS_ENTRY_TEXT = "AlbumUploadPlusEntryText";
  public static final String SECONDARY_ALBUM_VISITOR_LIST = "AlbumVisitorList";
  public static final String SECONDARY_ALBUM_WATER_PIC = "AlbumWaterPic";
  public static final String SECONDARY_ATUSER_INTERACTIVE_MAX = "FriendMaxSelectCountComment";
  public static final String SECONDARY_ATUSER_PUBLISH_UGC_MAX = "FriendMaxSelectCount";
  public static final String SECONDARY_AUDIO_MAX_BITRATE = "AudioMaxBitrate";
  public static final String SECONDARY_AUDIO_MAX_SAMPLE = "AudioMaxSample";
  public static final String SECONDARY_AUDIO_MIX_MUSIC_VOLUME = "audiomixmusicvolume";
  public static final float SECONDARY_AUDIO_MIX_MUSIC_VOLUME_DEFVALUE = 1.0F;
  public static final String SECONDARY_AUDIO_MIX_ORIGINAL_VOLUME = "audiomixoriginalaudiovolume";
  public static final float SECONDARY_AUDIO_MIX_ORIGINAL_VOLUME_DEFVALUE = 0.7F;
  public static final String SECONDARY_AVATAR_PREVIEW = "AvatarPreview";
  public static final String SECONDARY_AVATAR_SETTING = "AvatarSetting";
  public static final String SECONDARY_BANNER_PHOTO_GIF_RATE_DIF = "BannerPhotoGifRateDif";
  public static final String SECONDARY_BANNER_PHTO_GIF_VALID_CNT = "banner_phto_gif_valid_cnt";
  public static final String SECONDARY_BARRAGE_EFFECT_PREVIEW = "CommentBubblePreview";
  public static final String SECONDARY_BARRAGE_PREVIEW_URL = "BarragePreviewUrl";
  public static final String SECONDARY_BG_FM_BROCAST_MANAGER_URL = "BgFMBrocastManagerUrl";
  public static final String SECONDARY_BG_FM_MANAGER_URL = "BgFMManagerUrl";
  public static final String SECONDARY_BG_MUSIC_FOR_QZVIP_MANAGER_URL = "BgMusicForQZVIPManagerUrl";
  public static final String SECONDARY_BG_MUSIC_MANAGER_URL = "BgMusicManagerUrl";
  public static final String SECONDARY_BIRTHDAY_GIFT_STORE = "BirthdayGiftStore";
  public static final String SECONDARY_BITMAP_MEMORY_THRESHOLD = "BitmapMemoryThreshold";
  public static final String SECONDARY_BLOB_CACHE_ENABLE = "BlobCacheEnable";
  public static final String SECONDARY_BLOG_EDIT = "BlogEdit";
  public static final String SECONDARY_BOARD_URL = "presentBoard";
  public static final String SECONDARY_BUBBLE_UNREAD_SWITCH = "SK_QQ_VAS_ShowSwitchPersonalUnread";
  public static final String SECONDARY_BUY_FEED_URL = "BuyFeedUrl";
  public static final String SECONDARY_BUY_FONT_URL = "FloatingViewForFontPay";
  public static final String SECONDARY_C2C_AIO_ENABLE_SYNC_IMAGE_TO_QZONE = "C2CAioEnableSyncImageToQzone";
  public static final String SECONDARY_C2C_AIO_SYNC_DEFAULT_CHECKBOX_STATE = "C2CAioCheckBoxState";
  public static final String SECONDARY_C2C_AIO_SYNC_IMAGE_ALBUM_CACHE_EXPIRE_TIME = "C2CAioAlbumCacheExpireTime";
  public static final String SECONDARY_C2C_AIO_SYNC_IMAGE_ENABLE_CHECK_ALBUM_INFO = "C2CAioEnableCheckAlbumInfo";
  public static final String SECONDARY_C2C_AIO_SYNC_IMAGE_REMEMBER_STATE = "C2CAioRememberState";
  public static final String SECONDARY_C2C_PLUS_GIFT_JUMP_URL = "C2CPlusGiftJumpUrl";
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
  public static final String SECONDARY_CALL_WEISHI_TIME_LIMIT = "CallWeiShiTimes";
  public static final String SECONDARY_CALL_WEISHI_VERSION = "CallWeiShiVersion";
  public static final String SECONDARY_CALL_WEISHI_WNS = "CallWeiShiWns";
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
  public static final String SECONDARY_CM_PRAISE_TIME_OUT = "cmPraiseTimeOut";
  public static final String SECONDARY_CM_SHOW_STORE_BUTTON = "showCMShowStoreButton";
  public static final String SECONDARY_COMMENT_MAX_INPUT_CNT = "CommentMaxInputCnt";
  public static final String SECONDARY_COMMENT_REPLY_REPORT = "CommentReplyReport";
  public static final String SECONDARY_COMMENT_REPLY_REPORT_KEY = "CommentReplyReportKey";
  public static final String SECONDARY_COMMENT_SETTING = "SeeMyCommentPermissionSetting";
  public static final String SECONDARY_COMPRESS_QUALITY_LIMIT = "CompressQualityLimit";
  public static final String SECONDARY_COMPRESS_SIZE_LIMIT = "CompressSizeLimit";
  public static final String SECONDARY_COMPRESS_TO_WEBP = "CompressToWebp";
  public static final String SECONDARY_CONTENT_BOX_EMPTY_VIEW_BACKGROUND_URL = "content_box_empty_bg_url";
  public static final String SECONDARY_CONTEXTBOX_LOAD_NUM = "contentbox_load_num";
  public static final String SECONDARY_CONVERSATION_REMAIN_REPORT_CONTROL = "conversation_remain_report_control";
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
  public static final String SECONDARY_DETAIL_ACTIVITY_VIP_BANNER = "getDetailActivityVipBannerQboss";
  public static final int SECONDARY_DETAIL_ACTIVITY_VIP_BANNER_DEFUALT_VALUE = 1;
  public static final String SECONDARY_DETAIL_COMMENT_SOFT_ORDER = "DetailCommentSoftOrder";
  public static final String SECONDARY_DETAIL_GAME_DRAG_LABEL = "DetailGameDragLabel";
  public static final String SECONDARY_DETAIL_GAME_HARDWARE_CPU_LIMIT = "DetailGameCpuLimit";
  public static final String SECONDARY_DETAIL_GAME_HARDWARE_MEM_LIMIT = "DetailGameMemLimit";
  public static final String SECONDARY_DETAIL_GAME_LOADING_MSG = "DetailGameLoadingMsg";
  public static final String SECONDARY_DETAIL_GAME_LOAD_FAILED_MSG = "DetailGameLoadFailedMsg";
  public static final String SECONDARY_DETAIL_GAME_LOSE_SHARE_TEXT = "DetailGameLoseShareText";
  public static final String SECONDARY_DETAIL_GAME_SHARE_MSG = "DetailGameShareMsg";
  public static final String SECONDARY_DETAIL_GAME_START_IMG_URL = "DetailGameStartImgUrl";
  public static final String SECONDARY_DETAIL_MAXPICSHOW_NUM = "DetailMaxPicShowNum";
  public static final String SECONDARY_DISABLE_FORBID_COMMENT = "DisableForbidComment";
  public static final String SECONDARY_DISABLE_SHOW_VIP_INFO = "DisableVipInfoOnFriendFeed";
  public static final String SECONDARY_DOWNLOAD_ACCESS_PORT_LIST = "DownloadAccessPortList";
  public static final String SECONDARY_DOWNLOAD_BACKUP_IP = "DownloadBackupIP";
  public static final String SECONDARY_DOWNLOAD_BACKUP_IPV4 = "DownloadBackupIPV4";
  public static final String SECONDARY_DOWNLOAD_BACKUP_IP_A = "DownloadBackupIP_a";
  public static final String SECONDARY_DOWNLOAD_BACKUP_IP_B = "DownloadBackupIP_b";
  public static final String SECONDARY_DOWNLOAD_BACKUP_IP_VIDEO = "DownloadBackupIPVideo";
  public static final String SECONDARY_DOWNLOAD_CUSTOMDNS_ENABLE = "DownloadCustomDnsEnable";
  public static final String SECONDARY_DOWNLOAD_DIRECT_IP = "DownloadDirectIP";
  public static final String SECONDARY_DOWNLOAD_DIRECT_IPV4 = "DownloadDirectIPV4";
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
  public static final String SECONDARY_DOWNLOAD_PIC_QUEUE_MAX_PARALLEL_TASK_COUNT = "MaxParallelTaskCountForDownloadPicTask";
  public static final String SECONDARY_DOWNLOAD_QZONE_APP_URL = "DownloadQZoneAppUrl";
  public static final String SECONDARY_DOWNLOAD_QZONE_CLIENT = "DownloadQzoneClient";
  public static final String SECONDARY_DOWNLOAD_RETRY_TIMES = "RetryTimes";
  public static final String SECONDARY_DOWNLOAD_SWITCH_TIMES = "SwitchTimes";
  public static final String SECONDARY_DOWNLOAD_VIDEO_QUEUE_MAX_PARALLEL_TASK_COUNT = "MaxParallelTaskCountForDownloadVideoTask";
  public static final String SECONDARY_DOWNSONG_QQMUSIC = "DownloadSongInQQMusic";
  public static final String SECONDARY_DOWN_QQMUSIC_CLIENT = "DownloadQQMusicClient";
  public static final String SECONDARY_DRESS_UP_GROUP_URL = "DressUpGroupUrl";
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
  public static final String SECONDARY_DYNAMIC_MAX_PHOTO_NUM = "DynamicMaxPhotoNum";
  public static final String SECONDARY_DYNAMIC_MIN_PHOTO_NUM = "DynamicMinPhotoNum";
  public static final String SECONDARY_EASTER_EGG = "EasterEgg";
  public static final String SECONDARY_EGGPHOTO_LAYERTYPE = "EggPhotoLayerType";
  public static final String SECONDARY_EGG_IMAGE_FIRST_RED_LASTED_TIME = "RedDotAutoDisappearedTime";
  public static final String SECONDARY_EGG_IMAGE_RED_FREQUENCY = "RedDotAppearFrequency";
  public static final String SECONDARY_EMOJI_SHOULD_NOT_BREAK = "emojiShouldNotBreak";
  public static final String SECONDARY_ENABLE_ANIMATED_WEBP = "ENABLE_ANIMATED_WEBP";
  public static final String SECONDARY_ENABLE_COLOR = "EnableColor";
  public static final String SECONDARY_ENABLE_JUMP_DETAIL_TRANS_ANIMATE = "secondaryEnableJumpDetailTransanimate";
  public static final int SECONDARY_ENABLE_JUMP_DETAIL_TRANS_ANIMATE_DEFAULT = 1;
  public static final String SECONDARY_ENABLE_SHUOSHUO_SYNC_TO_FRIEND = "enableShuoshuoSyncToFriend";
  public static final String SECONDARY_ENABLE_SUPER_RESOLUTION = "enableSuperResolution";
  public static final String SECONDARY_ENABLE_TEMPLATESHUOSHUO = "enable_templateshuoshuo";
  public static final String SECONDARY_ENABLE_VOICE_SHUOSHUO_H5 = "secondary_enable_voice_shuoshuo_h5";
  public static final String SECONDARY_ENTER_LIVE_ROOM_AFTER_SECONDS = "EnterLiveRoomAfterSeconds";
  public static final String SECONDARY_EVENT_SUB_DESCRIPTION = "eventSubDescription";
  public static final String SECONDARY_EXCEPTION_REPORT_USESAMPLE = "exceptionReportUseSample";
  public static final String SECONDARY_EXCLUDE_PERMISION_PAGE = "ExcludePermisionPage";
  public static final String SECONDARY_EXIF_ENABLE = "ExifEnable";
  public static final String SECONDARY_EXIT_IF_FORGROUD = "ExitIfForgroud";
  public static final String SECONDARY_EXTEND_FEED_REFRESH_DIV = "extendFeedsRefreshDiv";
  public static final String SECONDARY_FACADESTORE_URL = "FacadeStore";
  public static final String SECONDARY_FACADE_JALPHA_ENABLE = "qzoneFacadeJalphaEnable";
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
  public static final String SECONDARY_FANS_GROUP_CONFIG_ENTRANCE = "showFansGroupConfigEntrance";
  public static final String SECONDARY_FANS_GROUP_CONFIG_ENTRANCE_URL = "showFansGroupConfigEntranceUrl";
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
  public static final String SECONDARY_FEED_DROPDOWN_USE_BOTTOM_SHEET = "feed_dropdown_use_bottom_sheet";
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
  public static final String SECONDARY_FEED_SHARE_DYNAMIC_URL = "FeedShareDynamicUrl";
  public static final String SECONDARY_FEED_SKIN_URL = "FeedSkinUrl";
  public static final String SECONDARY_FEED_TEXT_MAX_LINES = "FeedTextMaxLine";
  public static final String SECONDARY_FEED_UNREAD_FOLLOW_EXPOSURE_COUNT = "follow_guide_exposure_count";
  public static final String SECONDARY_FEED_USE_OLD_POKE = "feed_use_old_poke";
  public static final String SECONDARY_FEED_VISITOR = "FeedVisitor";
  public static final String SECONDARY_FEED_YELLOW_DIAMOND = "FeedYellowDiamond";
  public static final String SECONDARY_FIRST_TIME_ENTER_FRIEND_FEEDS_NEED_GET_MAINPAGE = "firstTimeEnterFriendFeedsNeedGetMainpage";
  public static final String SECONDARY_FLOATING_SCREEN_ACTION_WHEN_PLAY_CONFLICT = "floating_screen_action_when_play_conflict";
  public static final String SECONDARY_FLOAT_COMMENT_SOFT_ORDER = "FloatCommentSoftOrder";
  public static final String SECONDARY_FLOAT_MODEL_BLACKLIST = "FloatModelBlacklist";
  public static final String SECONDARY_FLOAT_PERFORMANCE_4CORE_CPU_RAM_SIZE = "FloatStandard4CoreCpuRamSize";
  public static final String SECONDARY_FLOAT_PERFORMANCE_CPU_CORE = "FloatStandardCpuCore";
  public static final String SECONDARY_FLOAT_PERFORMANCE_CPU_FEQUENCY = "FloatStandardCpuFequency";
  public static final String SECONDARY_FLOAT_PERFORMANCE_CPU_RAM_SIZE = "FloatStandardCpuRamSize";
  public static final String SECONDARY_FLOWER_VINE_URL = "FlowerVineURL";
  public static final String SECONDARY_FLUTTER_DISABLE_MODELS = "flutter_disable_models";
  public static final String SECONDARY_FLUTTER_ENABLE = "enableFlutter";
  public static final String SECONDARY_FLUTTER_ENABLE_API_LEVEL = "flutter_enable_api_level";
  public static final String SECONDARY_FLUTTER_MEMORY_HEAP_LIMIT = "flutter_memory_heap_limit";
  public static final String SECONDARY_FOLLOW_FANS_URL = "follow_fans_url";
  public static final String SECONDARY_FOLLOW_FOLLOWERS_URL = "follow_followers_url";
  public static final String SECONDARY_FONT_LIST_ATTACH_INFO = "DiyFontAttachinfo";
  public static final String SECONDARY_FONT_PREVIEW_FOR_SALE_URL = "FontPreviewUrlForSale";
  public static final String SECONDARY_FONT_PREVIEW_URL = "FontPreviewUrl";
  public static final String SECONDARY_FONT_STORE_URL = "FontStore";
  public static final String SECONDARY_FORBIDDEN_VIEW_FEED_DELETED_IMAGE_URL = "forbiddenViewFeedDeletedImageUrl";
  public static final String SECONDARY_FORBIDDEN_VIEW_FEED_EMPTY_IMAGE_URL = "forbiddenViewFeedEmptyImageUrl";
  public static final String SECONDARY_FORBIDDEN_VIEW_FEED_EMPTY_SMALL_IMAGE_URL = "forbiddenViewFeedEmptySmallImageUrl";
  public static final String SECONDARY_FORBIDDEN_VIEW_FEED_NO_NETWORK_IMAGE_URL = "forbiddenViewFeedNoNetworkImageUrl";
  public static final String SECONDARY_FORBIDDEN_VIEW_FEED_NO_PERMISSION_IMAGE_URL = "forbiddenViewVeedNoPermissionImageUrl";
  public static final String SECONDARY_FORBIDDEN_VIEW_FEED_NO_PERMISSION_SMALL_IMAGE_URL = "forbiddenViewVeedNoPermissionSmallImageUrl";
  public static final String SECONDARY_FORBIDDEN_VIEW_NUAN_FEED_EMPTY_SMALL_IMAGE_URL = "forbiddenViewNuanFeedEmptySmallImageUrl";
  public static final String SECONDARY_FORBIDDEN_VIEW_NUAN_FRIEND_EMPTY_SMALL_IMAGE_URL = "forbiddenViewNuanFriendEmptySmallImageUrl";
  public static final String SECONDARY_FORBID_SHOW_DELETE_VISITOR = "ForbidShowDeleteVisitor";
  public static final String SECONDARY_FRIENDFEED_CLICK_TO_TOP_LIMIT = "FriendFeedClickToTopLimit";
  public static final String SECONDARY_FRIENDFEED_CLICK_TO_TOP_SHOW_LIMIT = "FriendFeedClickToTopShowLimit";
  public static final String SECONDARY_FRIEND_ALBUM_RECOMMOND_TITLE = "secondary_friend_album_recommond_title";
  public static final String SECONDARY_FRIEND_FEEDS = "FriendFeeds";
  public static final String SECONDARY_FRIEND_GIF_RECOMMOND_TITLE = "secondary_friend_gif_recommond_title";
  public static final String SECONDARY_FriVideoBnr_MAX_TimeInterval_ON_Close = "frivideobnrtimeinterval";
  public static final String SECONDARY_GALLERY_RECOM_ALBUM_BACK_PRESS_FINISH = "GalleryRecomAlbumBackPressFinish";
  public static final String SECONDARY_GALLERY_RECOM_ALBUM_FLING_CLOSE = "GalleryRecomAlbumFlingClose";
  public static final String SECONDARY_GALLERY_RECOM_COUNT_LIMIT = "GalleryRecomAlbumCountLimit";
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
  public static final String SECONDARY_GIFT_PANEL = "GiftPanel";
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
  public static final String SECONDARY_GUEST_PANEL_FOOTER_BANNER_HIDE_TIME = "guestFooterBannerHideTime";
  public static final String SECONDARY_HAND_BLOG_EDIT = "HandBlogEdit";
  public static final String SECONDARY_HARDWARERESTRICTION_CPU_FRE_SUM = "hardwarerestriction_cpu_fre_sum";
  public static final String SECONDARY_HARDWARERESTRICTION_CPU_SIZE = "hardwarerestriction_cpu_size";
  public static final String SECONDARY_HARDWARERESTRICTION_RAM_SIZE = "hardwarerestriction_ram_size";
  public static final String SECONDARY_HARDWARERESTRICTION_RAM_SIZE_NEW = "hardwarerestriction_ram_size_new";
  public static final String SECONDARY_HBCLICK_VISITORREPORT_INTEVAL = "HBClickVisitorReportInteval";
  public static final String SECONDARY_HERO_VIDEO_AVAILABLE_CHECK = "videoHeroAvailableCheck";
  public static final String SECONDARY_HERO_VIDEO_AVAILABLE_DEFAULT = "99|default|default|default|default|default";
  public static final String SECONDARY_HERO_VIDEO_HVC_HWDEC_MODE = "videoHeroHvcHwDecMode";
  public static final String SECONDARY_HIDE_HIS_RECORD = "HideHisRecord";
  public static final String SECONDARY_HIDE_VISIT_MY = "HideSeeHis";
  public static final String SECONDARY_HIGH_PHONE_FRICITION = "HighPhoneFriction";
  public static final String SECONDARY_HOMEPAGE_BAR_FAMILY_ICON = "icon_url_family";
  public static final String SECONDARY_HOMEPAGE_BAR_MYFANS_ICON = "icon_url_myfans";
  public static final String SECONDARY_HOMEPAGE_BAR_MYFANS_VISIBLE = "bar_myfans_visible";
  public static final String SECONDARY_HOMEPAGE_BAR_MYFOLLOW_GUEST_VISIBLE = "bar_myfollow_guest_visible";
  public static final String SECONDARY_HOMEPAGE_BAR_MYFOLLOW_VISIBLE = "bar_myfollow_visible";
  public static final String SECONDARY_HOMEPAGE_BAR_WEISHI_ICON = "icon_url_weishi";
  public static final String SECONDARY_HOMEPAGE_BAR_WEISHI_SCHEMA = "schema_url_weishi";
  public static final String SECONDARY_HOMEPAGE_FREINDSHIP_THRESHOLD = "homepage_friendship_threshold";
  public static final String SECONDARY_HOMEPAGE_GUEST_DEFAULT_COVER_SHOW_DELAY_MS = "homepageGuestDefaultCoverShowDelayMs";
  public static final String SECONDARY_HOME_PAGE_ALBUM_TITLE = "AlbumBtnTitle";
  public static final String SECONDARY_HOOKREPORT_CONFIG = "HookReportConfig";
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
  public static final String SECONDARY_IGNORE_DOWNLOAD_APK_DOMAINS_DEFAULT = "douyin.com,huoshan.com,changba.com,toutiao.com,xiguaapp.cn,xiguashipin.cn,365yg.com,snssdk.com,ixigua.com,toutiaocdn.net,music.163.com,weibo.cn,autohome.com.cn";
  public static final String SECONDARY_IGNORE_LOCAL_JUDGE = "IgnoreLocalJudge";
  public static final String SECONDARY_IGNORE_WEBVIEW_SCHEME_URL = "QzoneUrlBanList";
  public static final String SECONDARY_IGNORE_WEBVIEW_SCHEME_URL_DEFAULT = "[{'domains':['^.*\\.douyin\\.com/.*'],'items':['^https?://d\\.douyin\\.com/.+']},{'domains':['^.*\\.huoshan\\.com/.*'],'items':['^https?://d\\.huoshan\\.com/.+']},{'domains':['^.*\\.toutiao\\.com/.*','^.*\\.xiguaapp\\.cn/.*','^.*\\.xiguashipin\\.cn/.*','^.*\\.365yg\\.com/.*','^.*\\.snssdk\\.com/.*','^.*\\.ixigua\\.com/.*','^.*\\.toutiaocdn\\.net/.*'],'items':['^https?://d\\.toutiao\\.com/.+','^https?://d\\.ixigua\\.com/.+']},{'domains':['^http.*'],'items':['^snssdk[0-9]+://.*','^changba://.*','^orpheus://.*']}]";
  public static final String SECONDARY_IMAGE_BIG_URL_SEGMENT = "imageBigUrlSegment";
  public static final String SECONDARY_IMAGE_CURRENT_URL_SEGMENT = "imageCurrentUrlSegment";
  public static final String SECONDARY_IMAGE_JAR_PROGRESS_TRACER = "imageJarProgressTracer";
  public static final String SECONDARY_IMAGE_UPLOAD_BAK_IP = "BackupIP_PICUP";
  public static final String SECONDARY_IMAGE_UPLOAD_HOST_IP = "PhotoURL_UP";
  public static final String SECONDARY_IMAGE_UPLOAD_OPT_IP = "OptimumIP_PICUP";
  public static final String SECONDARY_IMAGE_UPLOAD_OPT_IP_V6 = "OptimumIP_PICUPV6";
  public static final String SECONDARY_INPUT_EMO_ASS_SWITCH = "InputEmoAssSwitch";
  public static final String SECONDARY_IP_NO_PMTU_DISC = "ip_no_pmtu_disc";
  public static final String SECONDARY_IS_CAN_PRELOAD_PEAK = "isCanPreloadPeak";
  public static final int SECONDARY_IS_CAN_PRELOAD_PEAK_DEFAULT = 1;
  public static final String SECONDARY_IS_LIVEVIDEO_NEW_MODE = "LiveVideo_Size_New_Mode";
  public static final String SECONDARY_JSAPI_BLACK_LIST = "jsapiblacklist";
  public static final String SECONDARY_JSBRIDGE_ALLOW_HOSTS_LIST = "JsBridgeAllowHostsList";
  public static final String SECONDARY_JUMPQZONE_ENABLE = "JumpQZoneEnable";
  public static final String SECONDARY_JUMPQZONE_SCHEME_ENABLE = "JumpQZoneSchemeEnable";
  public static final String SECONDARY_JUMP_HYWS_SCHEME_ENABLE = "jump_hyws_scheme_enable";
  public static final int SECONDARY_JUMP_HYWS_SCHEME_ENABLE_DEFVALUE = 0;
  public static final String SECONDARY_JUMP_INSTALLAPP_SCHEME_ENABLE = "jump_installapp_scheme_enable";
  public static final int SECONDARY_JUMP_INSTALLAPP_SCHEME_ENABLE_DEFVALUE = 0;
  public static final String SECONDARY_JUMP_TO_NEW_PUBLIC_ACCOUNT = "JumpToNewServiceAccount";
  public static final int SECONDARY_JUMP_TO_NEW_PUBLIC_ACCOUNT_DEFAULT = 1;
  public static final String SECONDARY_JUMP_TO_PREVIEW_ALBUM_FACADE_CATE = "PreviewAlbumFacadeCate";
  public static final String SECONDARY_JUMP_TO_RECOMMEND_TAB = "DefaultSelectExplorePage";
  public static final int SECONDARY_JUMP_TO_RECOMMEND_TAB_DEFAULT = 0;
  public static final String SECONDARY_KAPU_HOST_FIREPOWER_GROWTH_URL = "kapuHostFirePowerGrowthUrl";
  public static final String SECONDARY_KAPU_HOST_MESSAGE = "qzoneKapuHostMessage";
  public static final String SECONDARY_KAPU_HOST_MESSAGE_URL = "kapuHostMessageUrl";
  public static final String SECONDARY_KAPU_MODEL_CHANGE = "qzoneKapuModelChange";
  public static final String SECONDARY_KAPU_SETTINGS = "kapuSettings";
  public static final String SECONDARY_KEY_ALBUM_DETAIL_RECOM_ALBUM_LIST_NUM_OF_COLUMN = "DetailRecomAlbumNumOfColumn";
  public static final int SECONDARY_KEY_ALBUM_DETAIL_RECOM_ALBUM_LIST_NUM_OF_COLUMN_DEFAULT = 2;
  public static final String SECONDARY_KEY_ALBUM_DETAIL_RECOM_DOWNNER_BOUND = "DetailRecomAlbumDownnerBound";
  public static final int SECONDARY_KEY_ALBUM_DETAIL_RECOM_DOWNNER_BOUND_DEFAULT = 2;
  public static final String SECONDARY_KEY_ALBUM_DETAIL_RECOM_UPPER_BOUND = "DetailRecomAlbumUpperBound";
  public static final int SECONDARY_KEY_ALBUM_DETAIL_RECOM_UPPER_BOUND_DEFAULT = 99;
  public static final String SECONDARY_KEY_ALBUM_FAKE_FEED_TAIL_CLICK_TIPS = "album_fake_feed_tail_click_tips";
  public static final String SECONDARY_KEY_ALBUM_GALLERY_BG_SWITCH = "AlbumGalleryRecomAlbumBgSwitch";
  public static final String SECONDARY_KEY_ALBUM_GALLERY_DOWNNER_BOUND = "AlbumGalleryRecomAlbumDownnerBound";
  public static final int SECONDARY_KEY_ALBUM_GALLERY_DOWNNER_BOUND_DEFAULT = 2;
  public static final String SECONDARY_KEY_ALBUM_GALLERY_RECOM_ALBUM_LIST_NUM_OF_COLUMN = "AlbumGalleryRecomAlbumNumOfColumn";
  public static final int SECONDARY_KEY_ALBUM_GALLERY_RECOM_ALBUM_LIST_NUM_OF_COLUMN_DEFAULT = 2;
  public static final String SECONDARY_KEY_ALBUM_GALLERY_SWITCH = "AlbumGalleryRecomAlbumSwitch";
  public static final String SECONDARY_KEY_ALBUM_GALLERY_UPPER_BOUND = "AlbumGalleryRecomAlbumUpperBound";
  public static final int SECONDARY_KEY_ALBUM_GALLERY_UPPER_BOUND_DEFAULT = -1;
  public static final String SECONDARY_KEY_ALBUM_IS_ABLE_TO_SCAN_RECOM_UPLOAD_PHOTO = "AlbumIsAbleToScanRecomUploadPhoto";
  public static final String SECONDARY_KEY_ALBUM_NEW_UPLOAD_SHOW = "albumNewUploadShow";
  public static final String SECONDARY_KEY_ALBUM_NEW_UPLOAD_SHOW_INTERVAL = "albumNewUploadShowInterval";
  public static final String SECONDARY_KEY_ALBUM_PHOTO_SEARCH_ENTRANCE_OPEN = "AlbumPhotoSearchEntranceOpen";
  public static final String SECONDARY_KEY_ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE = "AlbumRecomEventAlgoUserSample";
  public static final String SECONDARY_KEY_ALBUM_RECOM_EVENT_CLUSTERING_VAR = "AlbumRecomEventClusteringVariance";
  public static final String SECONDARY_KEY_ALBUM_RECOM_EVENT_CORE_PTS_NUM = "AlbumRecomEventNumOfCorePoints";
  public static final String SECONDARY_KEY_ALBUM_RECOM_ROLLBACK_TIME = "AlbumRecomRollbackTime";
  public static final String SECONDARY_KEY_ALBUM_RECOM_UPLOAD_BAR_PHOTO_COUNT = "AlbumRecomUploadBarPhotoCount";
  public static final String SECONDARY_KEY_ALBUM_RECOM_UPLOAD_DISTANCE_LIMIT = "AlbumRecomUploadDistanceLimit";
  public static final String SECONDARY_KEY_ALBUM_RECOM_UPLOAD_LIMITED_SCAN_TIME = "AlbumRecomUploadLimitedScanTime";
  public static final String SECONDARY_KEY_ALBUM_SCANNER_ENABLE = "AlbumScannerEnable";
  public static final String SECONDARY_KEY_ALBUM_SCANNER_NAME = "AlbumScannerName";
  public static final String SECONDARY_KEY_APPLETS_CHATPIE_EMPTY_BACKGROUND_URL = "miniappaioemptybackgroundurl";
  public static final String SECONDARY_KEY_APPLETS_CHATPIE_EMPTY_TIPS = "miniappaioemptytips";
  public static final String SECONDARY_KEY_APPLETS_CHATPIE_SHOW_EMPTY_VIEW = "miniappaioshowemptyview";
  public static final String SECONDARY_KEY_APPLETS_NICKNAME = "miniappNotificationNickName";
  public static final String SECONDARY_KEY_APPLETS_UIN = "miniappNotificationUin";
  public static final String SECONDARY_KEY_BABY_ALBUM_APPLY_FUNCTION_OPEN = "babyALbumApplyFunctionOpen";
  public static final String SECONDARY_KEY_BABY_ALBUM_INVITE_FUNCTION_OPEN = "babyALbumInviteFunctionOpen";
  public static final String SECONDARY_KEY_BACKGROUND_SIMILARITY_CHECK_GROUP_LIMIT = "BackgroundSimilarityCheckGroupLimit";
  public static final String SECONDARY_KEY_BACKGROUND_SIMILARITY_CHECK_TIME_LIMIT = "BackgroundSimilarityCheckTimeLimit";
  public static final String SECONDARY_KEY_BACK_AUTO_HIDE = "backAutoHide";
  public static final String SECONDARY_KEY_BANNER_SIMILARITY_CHECK_SIZE = "BannerSimilarityCheckSize";
  public static final String SECONDARY_KEY_BECOME_NUAN_FRIEND_TOAST_TEXT = "becomeNuanFriendToastText";
  public static final String SECONDARY_KEY_BLOG_SHARE_SHOW_EVERNOTE = "SK_BlogShareShowEvernote";
  public static final String SECONDARY_KEY_CAN_HOLD_SYSTEM_LOCK = "canHoldSystemLock";
  public static final String SECONDARY_KEY_CAN_OPEN_APP = "miniapp_able2show";
  public static final String SECONDARY_KEY_CAN_SET_LAYOUT_INFLATER_FACTORY = "enable_layout_factory";
  public static final String SECONDARY_KEY_CHOOSE_VIDEO_MAX_DURATION = "miniAppChooseVideoMaxDuration";
  public static final String SECONDARY_KEY_CHOOSE_VIDEO_MAX_SIZE = "miniAppChooseVideoMaxSize";
  public static final String SECONDARY_KEY_CHOUTI_MINI_GAME_ENABLE = "choutiminigameenable";
  public static final String SECONDARY_KEY_CHOUTI_MINI_GAME_ICON_URL = "choutiminigameiconurl";
  public static final String SECONDARY_KEY_CHOUTI_MINI_GAME_JUMP_URL = "choutiminigamejumpurl";
  public static final String SECONDARY_KEY_CHOUTI_MINI_GAME_NAME_TEXT = "choutiminigamenametext";
  public static final String SECONDARY_KEY_CLEAR_CACHE_VERSION = "Qzone_clearCacheVersion";
  public static final String SECONDARY_KEY_CLEAR_DESKTOP_EXPOSURE_REPORT_DATA = "clearDesktopExposureReportData";
  public static final String SECONDARY_KEY_CLINET_ONLINE_COLD_TIME = "ClientOnlineColdTime";
  public static final String SECONDARY_KEY_CLOSE_NATIVE_INBITMAP = "closeNativeAndInBitmap";
  public static final String SECONDARY_KEY_CM_ACTION_URL = "cmActionJumpUrl";
  public static final String SECONDARY_KEY_CM_AIO_PET_NAMEPLATE_GUEST_URL = "aioCMShowPetNameplateGuestUrl";
  public static final String SECONDARY_KEY_CM_AIO_PET_NAMEPLATE_HOST_URL = "aioCMShowPetNameplateHostUrl";
  public static final String SECONDARY_KEY_CM_AIO_SVIP_NAMEPLATE_GUEST_URL = "aioCMShowQZSVIPNameplateGuestUrl";
  public static final String SECONDARY_KEY_CM_AIO_SVIP_NAMEPLATE_HOST_URL = "aioCMShowQZSVIPNameplateHostUrl";
  public static final String SECONDARY_KEY_CM_PRAISE_ENABLE = "cmPraiseEnable";
  public static final String SECONDARY_KEY_DESKTOP_EXPOSURE_REPORT_ON_STOP = "desktopExposureReportOnStop";
  public static final String SECONDARY_KEY_DISCOVERY_TITLE = "discoverytitle";
  public static final String SECONDARY_KEY_DRAWER_PRELOAD_MODEL_LEVEL = "drawerPreloadModelLevel";
  public static final String SECONDARY_KEY_DRAWER_PRELOAD_SWITCH = "drawerPreloadSwitch";
  public static final String SECONDARY_KEY_DROP_DOWN_DEFAULT_RECOMMEND_APPS = "dropDownDefaultRecomendApps";
  public static final String SECONDARY_KEY_EC_LIVE_HOST = "qzone_eclive_livehost";
  public static final String SECONDARY_KEY_ENABLE_EXTEND_FEEDS = "enableExtendFeeds";
  public static final String SECONDARY_KEY_ENABLE_EXTEND_LIVE = "SK_QZKuoliePartyEnteranceConfig";
  public static final String SECONDARY_KEY_ENABLE_EXTEND_PARTY_URL = "SK_QZKuoliePartyUrl";
  public static final String SECONDARY_KEY_ENABLE_MOOD_LIST_EXTEND_FEEDS = "enableMoodListExtendFeeds";
  public static final String SECONDARY_KEY_FACE_SCAN_QZONE_PLUS_VERSION = "face_scan_qzone_plus_version";
  public static final String SECONDARY_KEY_FACE_SCAN_SUPPORT_LOW_VERSION = "face_scan_support_low_version";
  public static final String SECONDARY_KEY_FEED_OPERATE_TIME = "FeedOperateTime";
  public static final String SECONDARY_KEY_FEED_PIC_TEXT_CARD_VIEW_PHOTO_ARROW = "FeedPicTextCardView_PhotoArrow";
  public static final String SECONDARY_KEY_FEED_PIC_TEXT_CARD_VIEW_PHOTO_BABY = "FeedPicTextCardView_PhotoBaby";
  public static final String SECONDARY_KEY_FEED_PIC_TEXT_CARD_VIEW_PHOTO_LOVER = "FeedPicTextCardView_PhotoLover";
  public static final String SECONDARY_KEY_FEED_PIC_TEXT_CARD_VIEW_PHOTO_NORMAL = "FeedPicTextCardView_PhotoNormal";
  public static final String SECONDARY_KEY_FEED_PIC_TEXT_CARD_VIEW_PHOTO_TRAVEL = "FeedPicTextCardView_PhotoTravel";
  public static final String SECONDARY_KEY_FFMPEG_VIDEO_COMPRESS_PARAM = "miniFfmpegVideoCompressParam";
  public static final String SECONDARY_KEY_FRIENDFEED_TITLE = "friendfeedtitle";
  public static final String SECONDARY_KEY_GENERATE_GIF_BLACK_LIST = "GenerateGifBlackList";
  public static final String SECONDARY_KEY_GET_APPLETS_NOTIFICATION_SETTING_INTERVAL = "getappletsnotificationsettinginterval";
  public static final String SECONDARY_KEY_GIF_ANTISHAKE_MAX_FRAME_NUM = "GifAntishakeMaxFrameNum";
  public static final String SECONDARY_KEY_GIF_ANTISHAKE_MAX_FRAME_SHOOTTIME = "GifAntishakeMaxFrameShootTime";
  public static final String SECONDARY_KEY_GIF_ANTISHAKE_MAX_GROUP_SHOOTTIME = "GifAntishakeMaxGroupShootTime";
  public static final String SECONDARY_KEY_GIF_ANTISHAKE_MIN_SIMILARITY = "GifAntishakeMinSimilarity";
  public static final String SECONDARY_KEY_GIF_ANTISHAKE_NEED_TO_CHECK_SHOOT_TIME = "GifAntishakeNeedToCheckShootTime";
  public static final String SECONDARY_KEY_GIF_ANTISHAKE_NEED_TO_CHECK_SIMILARITY = "GifAntishakeNeedToCheckSimilarity";
  public static final String SECONDARY_KEY_GIF_ANTISHAKE_SWITCH = "GifAntishakeSwitch";
  public static final String SECONDARY_KEY_GIF_ANTISHAKE_USE_DHASH = "GifAntishakeUseDHash";
  public static final String SECONDARY_KEY_GIF_DOWNLOAD_AND_PLAY = "GifDownloadAndPlay";
  public static final String SECONDARY_KEY_GIF_DOWNLOAD_AND_PLAY_SDK_LEVEL = "GifDownloadAndPlaySdkLevel";
  public static final String SECONDARY_KEY_GO_CONTENT_BOX_MINI_PROGRAM = "gocontentboxminiprogram";
  public static final String SECONDARY_KEY_GUEST_MIN_CPU_FREQ = "LiveVideoGuestMinCpuFreq";
  public static final String SECONDARY_KEY_GUEST_MIN_CPU_NUMBER = "LiveVideoGuestCpuNumber";
  public static final String SECONDARY_KEY_GUEST_MIN_RAM = "LiveVideoGuestMinRam";
  public static final String SECONDARY_KEY_GUEST_MORE_POPUP_SETTING = "GuestMorePopupSetting";
  public static final String SECONDARY_KEY_GUEST_SDKDEF = "LiveVideoGuestSdkDef";
  public static final String SECONDARY_KEY_HEAD_MENU = "friendfeedheadmenu";
  public static final String SECONDARY_KEY_HIDE_AIO_FEEDS = "hideAioFeeds";
  public static final String SECONDARY_KEY_HIDE_AIO_STORY_FEED = "DisableReqAioStoryFeed";
  public static final String SECONDARY_KEY_HIDE_QZONE_STATUS_IN_CONVERSATION = "hideFeedsInConverstation";
  public static final String SECONDARY_KEY_HOST_MIN_CPU_FREQ = "LiveVideoMinCpuFreq";
  public static final String SECONDARY_KEY_HOST_MIN_PGC_CPU_NUMBER = "LiveVideoPgcCpuNumber";
  public static final String SECONDARY_KEY_HOST_MIN_RAM = "LiveVideoMinRam";
  public static final String SECONDARY_KEY_HOST_MIN_UGC_CPU_NUMBER = "LiveVideoUgcCpuNumber";
  public static final String SECONDARY_KEY_HOST_MODEL_BLACK_LIST = "LiveVideoModelBlackList";
  public static final String SECONDARY_KEY_HOST_MORE_POPUP_SETTING = "HostMorePopupSetting";
  public static final String SECONDARY_KEY_HOST_SDKDEF = "LiveVideoSdkDef";
  public static final String SECONDARY_KEY_ILIVE_NORITY_URL = "VASLiveTipsGroupSetting";
  public static final String SECONDARY_KEY_ILIVE_TIPS_LOOP_ENABLE = "iliveTopsLoopEnable";
  public static final String SECONDARY_KEY_IMAGE_DECODING_RES_REPORT_SAMPLE = "qzoneImageDecodingResReportSample";
  public static final String SECONDARY_KEY_INTERACTING_BAR_HOST_USE_ORIGINAL_LAYOUT = "InteractingBarHostUseOriginalLayout";
  public static final String SECONDARY_KEY_INTERACTING_BAR_USE_ORIGINAL_LAYOUT = "InteractingBarHostUseOriginalLayout";
  public static final String SECONDARY_KEY_IS_SHOW_ENTRANCE = "entrance";
  public static final String SECONDARY_KEY_JUMP_DULI_DETAIL = "open_duli_detail";
  public static final String SECONDARY_KEY_JUMP_DULI_DETAIL_FAIL_INTERVAL = "open_deuli_detial_fail_interval";
  public static final String SECONDARY_KEY_JUMP_DULI_DETAIL_TIMEOUT = "open_duli_detial_timeout";
  public static final String SECONDARY_KEY_JUMP_DULI_DETAIL_VERSION = "open_duli_detail_version";
  public static final String SECONDARY_KEY_JUMP_TO_MORE_VIDEO = "JumpToMoreVideo";
  public static final String SECONDARY_KEY_LBS_INTERFACE_SWITCH = "lbsInterfaceSwitch";
  public static final String SECONDARY_KEY_LBS_SPECIAL_LOGIC_MAX_RETRY_COUNT = "LbsSpecialLogicMaxRetryCount";
  public static final String SECONDARY_KEY_LBS_SPECIAL_LOGIC_ON = "LbsSpecialLogicOn";
  public static final String SECONDARY_KEY_LOCATE_INTERVAL = "QzoneLocateInterval";
  public static final String SECONDARY_KEY_LOCATE_PERMISSION_INTERVAL = "QzoneLocatePermissionInterval";
  public static final String SECONDARY_KEY_LOVE_ALBUM_APPLY_FUNCTION_OPEN = "loveALbumApplyFunctionOpen";
  public static final String SECONDARY_KEY_LOVE_ALBUM_INVITE_FUNCTION_OPEN = "loveALbumInviteFunctionOpen";
  public static final String SECONDARY_KEY_MANUAL_LOAD_SWITCH_STATUS = "ManualLoadSwitchStatus";
  public static final String SECONDARY_KEY_MAX_NUM_IN_CONVERSATION = "MaxNumInConverstation";
  public static final String SECONDARY_KEY_MAX_P2V_VIDEO_DURING = "MaxP2VVideoDuring";
  public static final String SECONDARY_KEY_MINIGAME_SHARE_RATE = "MiniGameShareRate";
  public static final String SECONDARY_KEY_MINIPROGRAM_VIDEO_CONTENTTYPE = "MiniProgramVideoContentType";
  public static final String SECONDARY_KEY_MINI_APP_AD_USE_TRANSCODING = "miniappadusetranscoding";
  public static final String SECONDARY_KEY_MINI_APP_BRING_TITLE_BAR_TO_FRONT = "miniappbringtitlebartofront";
  public static final String SECONDARY_KEY_MINI_APP_CHECK_STORAGE_PERMISSION = "miniappcheckstoragepermission";
  public static final String SECONDARY_KEY_MINI_APP_CHOOSE_ADDRESS_URL = "miniappChooseAddressUrl";
  public static final String SECONDARY_KEY_MINI_APP_ECSHOP_EXPO_TIME_LIMIT = "MiniAppEcShopExpoTimeLimit";
  public static final String SECONDARY_KEY_MINI_APP_ECSHOP_NUM_MSG_ENABLE = "MiniAppEcShopNumMsgEnable";
  public static final String SECONDARY_KEY_MINI_APP_ECSHOP_URL = "miniappecshopurl";
  public static final String SECONDARY_KEY_MINI_APP_FULL_SCREEN_SEARCH = "miniappfullscreenshowsearch";
  public static final String SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_CLOSE = "miniappfullscreenshowclose";
  public static final String SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_NOTIFICATION = "miniappfullscreenshownotificationbtn";
  public static final String SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_NOTIFICATION_RED_DOT = "miniappfullscreenshownotificationreddot";
  public static final String SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_SETTING = "miniappfullscreenshowsetting";
  public static final String SECONDARY_KEY_MINI_APP_FULL_SCREEN_TITLE = "miniappfullscreentitle";
  public static final String SECONDARY_KEY_MINI_APP_GET_PSKEY_DOMAIN = "miniappgetpskeydomain";
  public static final String SECONDARY_KEY_MINI_APP_MIDAS_PAY_AID = "miniappmidaspayaid";
  public static final String SECONDARY_KEY_MINI_APP_OLD_ENTRY_CLOSE_RED_DOT = "oldEntryCloseRedDot";
  public static final String SECONDARY_KEY_MINI_APP_REFRESH_SHOW_ICON = "miniapprefreshshowappicon";
  public static final String SECONDARY_KEY_MINI_APP_SEARCH_APPID = "miniappsearchappid";
  public static final String SECONDARY_KEY_MINI_APP_SHOW_FULL_SCREEN = "miniappshowfullscreen";
  public static final String SECONDARY_KEY_MINI_APP_SHOW_MSG_RED_DOT = "miniappshowmessagereddot";
  public static final String SECONDARY_KEY_MINI_APP_SHOW_RED_DOT = "miniappshowreddot";
  public static final String SECONDARY_KEY_MINI_APP_STORE_ENTRY_PATH = "miniappstoreentrypath";
  public static final String SECONDARY_KEY_MINI_APP_STORE_MY_PAGE = "miniappstoremypage";
  public static final String SECONDARY_KEY_MINI_APP_SYSTEM_PERMISSION_CONFIG = "miniappsustempermissionconfig";
  public static final String SECONDARY_KEY_MINI_APP_TOP_MAX_NUM = "miniappfullscreenminedatamaxnum";
  public static final String SECONDARY_KEY_MINI_APP_TRIGGER_FULL_SCREEN_HEIGHT = "miniapptriggerfullscreenheight";
  public static final String SECONDARY_KEY_MINI_APP_TRIGGER_REFRESH_MIN_DISTANCE = "pulldownRefreshMinDistance";
  public static final String SECONDARY_KEY_MINI_APP_USE_HTTPS_SEND_REQUEST = "miniappsendrequestbyhttps";
  public static final String SECONDARY_KEY_MINI_APP_USE_NATIVE_SEARCH = "SearchUseNative";
  public static final String SECONDARY_KEY_MINI_GAME_PUBLIC_ACCOUNT_ENABLE_WEB = "MiniGamePublicAccountEnableWeb";
  public static final String SECONDARY_KEY_MINI_GAME_PUBLIC_ACCOUNT_GAME_STORE_URL = "MiniGamePublicAccountGameStoreUrl";
  public static final String SECONDARY_KEY_MINI_GAME_PUBLIC_ACCOUNT_MSG_LIST_COUNT = "MiniGamePublicAccountMsgListCount";
  public static final String SECONDARY_KEY_MINI_GAME_PUBLIC_ACCOUNT_WEB_URL = "MiniGamePublicAccountWebUrl";
  public static final String SECONDARY_KEY_MINI_LOADING_AD_UNSUPPORT_VIA_LIST = "launch_adv_unsupport_via_list";
  public static final String SECONDARY_KEY_MIN_MEMEORY_CLASS_IN_ART = "MinMemoryClassInArt";
  public static final String SECONDARY_KEY_MODULE_JUMP_NATIVE = "module_jump_native";
  public static final String SECONDARY_KEY_MOODLIST_ENTRANCE_GRAY = "moodListEntranceViewNewStyleGray";
  public static final String SECONDARY_KEY_MULTI_ALBUM_APPLY_FUNCTION_OPEN = "multiALbumApplyFunctionOpen";
  public static final String SECONDARY_KEY_MULTI_ALBUM_INVITE_FUNCTION_OPEN = "multiALbumInviteFunctionOpen";
  public static final String SECONDARY_KEY_NEW_EVENT_BUBLE_STAY_TIME = "NewEventBubleStayTime";
  public static final String SECONDARY_KEY_NEW_STYLE_SHUOSHUO_NEW_CARD_SWITCH = "shuoshuoNewStyleNewCardSwitch";
  public static final String SECONDARY_KEY_NO_CACHE_IMAGE_EXPIRED_TIME = "NoCacheImageExpiredTime";
  public static final String SECONDARY_KEY_OFFICIAL_ACCOUNT_REPORT_AIO_LIST_EXPO_ENABLE = "OfficialAccountReportAioListExpoEnable";
  public static final String SECONDARY_KEY_OFFICIAL_ACCOUNT_REPORT_AIO_LIST_EXPO_INIT_TIME_LIMIT = "OfficialAccountReportAioListExpoInitTimeLimit";
  public static final String SECONDARY_KEY_OFFICIAL_ACCOUNT_REPORT_TIME_LIMIT = "OfficialAccountReportTimeLimit";
  public static final String SECONDARY_KEY_OFFLINE_CACHE_BUFFER_SIZE = "OfflineCacheBufferSize";
  public static final String SECONDARY_KEY_OFFLINE_CACHE_EXT_LIST = "OfflineCacheExt2MimeType";
  public static final String SECONDARY_KEY_OFFLINE_CACHE_SUPPORT_GZIP = "OfflineCacheSupportGZip";
  public static final String SECONDARY_KEY_OFFLINE_CACHE_SUPPORT_WEBP_AND_SHARPP = "OfflineCacheSupportWebpAndSharppImage";
  public static final String SECONDARY_KEY_OFFLINE_CACHE_WHITELIST = "OfflineCacheWhiteList";
  public static final String SECONDARY_KEY_OFFLINE_DECODE_PHOTO_QUALITY = "QzoneOfflineDecodePhotoQuality";
  public static final String SECONDARY_KEY_OFFLINE_ENABLE = "OfflineCacheEnable";
  public static final String SECONDARY_KEY_OPEN_COLOR_NOTE_MINI_APP_BY_APPINFO = "openColorNoteMiniAppByAppInfo";
  public static final String SECONDARY_KEY_OPEN_WEBSECURITYVERIFY = "openWebSecurityVerify";
  public static final String SECONDARY_KEY_OWNER_OPERATE_TIME = "OwnerOperateTime";
  public static final String SECONDARY_KEY_P2V_BLACK_LIST = "P2VFunBlackList";
  public static final String SECONDARY_KEY_P2V_FUN_ENABLE = "P2VFunEnable";
  public static final String SECONDARY_KEY_P2V_NEED_ORIGINAL = "P2VNeedOriginal";
  public static final String SECONDARY_KEY_P2V_STORAGE_LIMIT = "P2VStorageLimt";
  public static final String SECONDARY_KEY_P2V_SUPPORTED_CPU_FAMILY = "P2VSupportedCpuFamily";
  public static final String SECONDARY_KEY_PICK_GAMEMATE = "isEnablePickGameMates";
  public static final String SECONDARY_KEY_PLUGIN_TOKEN_AUTH_TIME = "pluginTokenAuthTime";
  public static final String SECONDARY_KEY_PLUS_DIFFERENCE = "plusdifference";
  public static final String SECONDARY_KEY_PROFILECARD_MINI_PLAYING_NAME = "ProfileCardMiniPlayingName";
  public static final String SECONDARY_KEY_PROFILECARD_MINI_PLAYING_NAME_GUEST = "ProfileCardMiniPlayingNameGuest";
  public static final String SECONDARY_KEY_PROFILECARD_MINI_PLAYING_NAME_GUEST_DEFAULT = "ProfileCardMiniPlayingNameGuestDefault";
  public static final String SECONDARY_KEY_PUBLIC_SPACE = "publicSpace";
  private static final String SECONDARY_KEY_QQCIRCLE_AGGREAGTE_EMPTY_JUMP_TITLE = "qqcircle_aggreagte_empty_jump_title";
  private static final String SECONDARY_KEY_QQCIRCLE_AGGREAGTE_EMPTY_TEXT = "qqcircle_aggreagte_empty_text";
  private static final String SECONDARY_KEY_QQCIRCLE_AUTHENTICATION_ERROR_TEXT = "qqcircle_authentication_error_text";
  private static final String SECONDARY_KEY_QQCIRCLE_AUTHENTICATION_ERROR_TOAST_TEXT = "qqcircle_authentication_error_toast_text";
  private static final String SECONDARY_KEY_QQCIRCLE_DETAIL_ERROR_CONTENT_DELETED_TEXT = "qqcircle_detail_error_content_deleted_text";
  private static final String SECONDARY_KEY_QQCIRCLE_HOMEBUTTON_STYLE = "qqcircle_homebutton_style";
  private static final String SECONDARY_KEY_QQCIRCLE_HOMEPAGE_GUEST_LIST_EMPTY_JUMP_TITLE = "qqcircle_homepage_guest_list_empty_jump_title";
  private static final String SECONDARY_KEY_QQCIRCLE_HOMEPAGE_GUEST_LIST_EMPTY_TEXT = "qqcircle_homepage_guest_list_empty_text";
  private static final String SECONDARY_KEY_QQCIRCLE_HOMEPAGE_GUEST_PRODUCT_EMPTY_JUMP_TITLE = "qqcircle_homepage_guest_product_empty_jump_title";
  private static final String SECONDARY_KEY_QQCIRCLE_HOMEPAGE_GUEST_PRODUCT_EMPTY_TEXT = "qqcircle_homepage_guest_product_empty_text";
  private static final String SECONDARY_KEY_QQCIRCLE_HOMEPAGE_GUEST_PUSH_EMPTY_JUMP_TITLE = "qqcircle_homepage_guest_push_empty_jump_title";
  private static final String SECONDARY_KEY_QQCIRCLE_HOMEPAGE_GUEST_PUSH_EMPTY_TEXT = "qqcircle_homepage_guest_push_empty_text";
  private static final String SECONDARY_KEY_QQCIRCLE_HOMEPAGE_HOST_LIST_EMPTY_JUMP_TITLE = "qqcircle_homepage_host_list_empty_jump_title";
  private static final String SECONDARY_KEY_QQCIRCLE_HOMEPAGE_HOST_LIST_EMPTY_TEXT = "qqcircle_homepage_host_list_empty_text";
  private static final String SECONDARY_KEY_QQCIRCLE_HOMEPAGE_HOST_PRODUCT_EMPTY_JUMP_TITLE = "qqcircle_homepage_host_product_empty_jump_title";
  private static final String SECONDARY_KEY_QQCIRCLE_HOMEPAGE_HOST_PRODUCT_EMPTY_TEXT = "qqcircle_homepage_host_product_empty_text";
  private static final String SECONDARY_KEY_QQCIRCLE_HOMEPAGE_HOST_PUSH_EMPTY_JUMP_TITLE = "qqcircle_homepage_host_push_empty_jump_title";
  private static final String SECONDARY_KEY_QQCIRCLE_HOMEPAGE_HOST_PUSH_EMPTY_TEXT = "当qqcircle_homepage_host_push_empty_text";
  private static final String SECONDARY_KEY_QQCIRCLE_HOMEPAGE_INMYBLACKLIST_JUMP_TITLE = "qqcircle_homepage_inmyblacklist_jump_title";
  private static final String SECONDARY_KEY_QQCIRCLE_HOMEPAGE_INMYBLACKLIST_TEXT = "qqcircle_homepage_inmyblacklist_text";
  private static final String SECONDARY_KEY_QQCIRCLE_MESSAGELIST_HOST_MESSAGE_EMPTY_JUMP_TITLE = "qqcircle_messagelist_host_message_empty_jump_title";
  private static final String SECONDARY_KEY_QQCIRCLE_MESSAGELIST_HOST_MESSAGE_EMPTY_TEXT = "qqcircle_messagelist_host_messag_empty_text";
  private static final String SECONDARY_KEY_QQCIRCLE_MESSAGELIST_HOST_PRIVATELETTER_EMPTY_JUMP_TITLE = "qqcircle_messagelist_host_privateletter_empty_jump_title";
  private static final String SECONDARY_KEY_QQCIRCLE_MESSAGELIST_HOST_PRIVATELETTER_EMPTY_TEXT = "qqcircle_messagelist_host_privateletter_empty_text";
  private static final String SECONDARY_KEY_QQCIRCLE_NONET_ERROR_TEXT = "qqcircle_nonet_error_text";
  private static final String SECONDARY_KEY_QQCIRCLE_NONET_ERROR_TOAST_TEXT = "qqcircle_nonet_error_toast_text";
  private static final String SECONDARY_KEY_QQCIRCLE_SERVER_ERROR_TEXT = "qqcircle_server_error_text";
  private static final String SECONDARY_KEY_QQCIRCLE_SERVER_ERROR_TOAST_TEXT = "qqcircle_server_error_toast_text";
  public static final String SECONDARY_KEY_QQ_AUTH_TIME = "qqAuthTime";
  public static final String SECONDARY_KEY_QZONEPLATO_JUMP_NATIVE = "qzoneplato_jump_native";
  public static final String SECONDARY_KEY_QZONEPLATO_SHAREHOST = "PlatoShareUrlPrefix";
  public static final String SECONDARY_KEY_QZONEVIDEO_HOST = "qzonelivevideo_livehost";
  public static final String SECONDARY_KEY_QZONE_GIF_NEED_RECYLE_BMP = "qzoneGifNeedRecycle";
  public static final String SECONDARY_KEY_QZONE_GIF_PREFER_NEW_DECODE_TASK = "qzoneGifPreferNewDecodeTask";
  public static final String SECONDARY_KEY_QZONE_GIF_SUPPORT_565 = "qzoneGifSupport565";
  public static final String SECONDARY_KEY_QZONE_HOMEPAGE_SHAPON_CMD = "HomepageEggWidgetIsGetCmd";
  public static final String SECONDARY_KEY_QZONE_LOCATION_CACHE_SAMPLE_RATE = "qzoneLocationCacheSampleRate";
  public static final String SECONDARY_KEY_QZONE_LOCATION_SAMPLE_RATE = "qzoneLocationSampleRate";
  public static final String SECONDARY_KEY_QZONE_MODULE_REPORT_SAMPLE = "qzoneModuleReportSample";
  public static final String SECONDARY_KEY_QZONE_SEARCH_RESULT_URL = "qzone_search_result_url";
  public static final String SECONDARY_KEY_REAL_TIME_LOG_MAX_CALL_NUM = "RealTimeLogMaxCallNum";
  public static final String SECONDARY_KEY_REAL_TIME_LOG_MAX_CONTENT_SIZE = "RealTimeLogMaxContentSize";
  public static final String SECONDARY_KEY_RECOMMEND_COUNT_NUM_LIMIT = "RecommendAlbumCountNumLimit";
  public static final String SECONDARY_KEY_SCF_GATEWAY_DEVICE_VER = "oskscfdevicever";
  public static final String SECONDARY_KEY_SCF_GATEWAY_ID = "oskscfgatewayid";
  public static final String SECONDARY_KEY_SCF_GATEWAY_QUERY_URL = "oskscfquerygateway";
  public static final String SECONDARY_KEY_SCF_GATEWAY_REPORT_URL = "oskscfreportgateway";
  public static final String SECONDARY_KEY_SCF_GATEWAY_SECRET = "oskscfgatewaysecret";
  public static final String SECONDARY_KEY_SCF_GATEWAY_SIGN_ENABLE = "oskscfgatewaysignenable";
  public static final String SECONDARY_KEY_SCF_GATEWAY_STATUS = "oskscfgatewaystatus";
  public static final String SECONDARY_KEY_SEARCH_MOOD_TIPS_FIRST_LINE = "search_mood_tips_first_line";
  public static final String SECONDARY_KEY_SEARCH_MOOD_TIPS_SECOND_LINE = "search_mood_tips_second_line";
  public static final String SECONDARY_KEY_SELF_PRAISE_ANIMATION_RES_URL = "self_praise_animation_res_url";
  public static final String SECONDARY_KEY_SELF_PRAISE_ANIMATION_SWITCH = "self_praise_animation_switch";
  public static final String SECONDARY_KEY_SETTING_ME_MINI_GAME_ENABLE = "settingMeMiniGameEnable";
  public static final String SECONDARY_KEY_SETTING_ME_MINI_GAME_ICON_URL = "settingMeMiniGameIconUrl";
  public static final String SECONDARY_KEY_SETTING_ME_MINI_GAME_JUMP_URL = "settingMeMiniGameJumpUrl";
  public static final String SECONDARY_KEY_SETTING_ME_MINI_GAME_NAME_TEXT = "settingMeMiniGameNameText";
  public static final String SECONDARY_KEY_SETTING_RED_DOT_ANIMATION_SRC = "love_zone_red_dot_frame_ani";
  public static final String SECONDARY_KEY_SHARE_ALBUM_TO_WEIXIN_MINI_PROGRAM_NEED_SK = "share_album_to_wx_miniprogram_need_sk";
  public static final String SECONDARY_KEY_SHARING_OWNERS_LIST_TITLE_BABY = "SharingOwnersListTitleBaby";
  public static final String SECONDARY_KEY_SHARING_OWNERS_LIST_TITLE_REGULAR = "SharingOwnersListTitleRegular";
  public static final String SECONDARY_KEY_SHARPP_GATE = "qzoneSharppGate";
  public static final String SECONDARY_KEY_SHARPP_LOAD_SO_RETRY_WAIT_TIME = "qzoneSharppLoadSoRetryWaitTime";
  public static final String SECONDARY_KEY_SHARPP_PLAN_B_SWITCH = "qzoneSharppPlanBSwitch";
  public static final String SECONDARY_KEY_SHOW_GLOBAL_SEARCH_BUBBLE = "showGlobalSearchBubble";
  public static final String SECONDARY_KEY_SHOW_PRICE = "showgiftprice";
  public static final String SECONDARY_KEY_SIMILARITY_PRE_CHECK_SWITCH = "SimilarityPreCheckSwitch";
  public static final String SECONDARY_KEY_SURPRISE_CLICK_HEIGHT = "surpriseClickHeight";
  public static final String SECONDARY_KEY_SURPRISE_CLICK_WIDTH = "surpriseClickWidth";
  public static final String SECONDARY_KEY_SURPRISE_TIME_INTERVAL = "surpriseTimeInterval";
  public static final String SECONDARY_KEY_SURPRISE_WAIT_TIME = "surpriseWaitTime";
  public static final String SECONDARY_KEY_SWEET_GUEST_PAGE = "sweet_guest_page";
  public static final String SECONDARY_KEY_SWEET_MAIN_PAGE_JUMP_URL = "sweet_mainpage";
  public static final String SECONDARY_KEY_SWEET_MAIN_PAGE_JUMP_URL_FOR_GUEST = "lover_h5_url";
  public static final String SECONDARY_KEY_SYNC_TO_QQSTORY = "keySyncToQQStory";
  public static final String SECONDARY_KEY_TIMECAPSULE_DEFAULT_EXPAND = "timecapsule_default_expand";
  public static final String SECONDARY_KEY_TRAVEL_ALBUM_APPLY_FUNCTION_OPEN = "travelALbumApplyFunctionOpen";
  public static final String SECONDARY_KEY_TRAVEL_ALBUM_INVITE_FUNCTION_OPEN = "travelALbumInviteFunctionOpen";
  public static final String SECONDARY_KEY_UPLOAD_SWITCH = "upload_switch";
  public static final String SECONDARY_KEY_USERHOME_MESSAGE_BOARD_URL = "user_home_message_board_url";
  public static final String SECONDARY_KEY_USERHOME_NEW_VISITOR_ANIMATION_SINGLE_FRAME_DURANTION = "user_home_new_visitor_single_frame_duration";
  public static final String SECONDARY_KEY_USERHOME_OPEN_MESSAGE_BOARD_DIRECTOR_RESOUCE_MD5 = "user_home_open_message_board_director_res_md5";
  public static final String SECONDARY_KEY_USERHOME_OPEN_MESSAGE_BOARD_DIRECTOR_RESOUCE_URL = "user_home_open_message_board_director_res_url";
  public static final String SECONDARY_KEY_USERHOME_OPEN_MESSAGE_BOARD_SETTING_URL = "user_home_open_message_board_setting_url";
  public static final String SECONDARY_KEY_USERHOME_SHOW_OPEN_MESSAGE_BOARD_DIRECTOR = "user_home_show_open_message_board_director";
  public static final String SECONDARY_KEY_VIDEO_ENABLE_LOCAL_HW_DETECTOR = "oskenablelocalhwdetector";
  public static final String SECONDARY_KEY_VIDEO_ENABLE_LOCAL_HW_DETECTOR_GRAY = "oskhwdetectorgray";
  public static final String SECONDARY_KEY_VIDEO_EXPOSE_REPORT_COUNT = "VideoExposeReportCount";
  public static final String SECONDARY_KEY_VIDEO_HWDEC_PROBE_BLACKLIST = "oskhwprobeblacklist";
  public static final String SECONDARY_KEY_VIDEO_HWDEC_PROBE_SDK_INT_MAX = "oskhwprobesdkintmax";
  public static final String SECONDARY_KEY_VIDEO_HWDEC_PROBE_SDK_INT_MIN = "oskhwprobesdkintmin";
  public static final String SECONDARY_KEY_VIDEO_TAB_JUMP_TO_WEISHI = "videoTabJumpToWeishi";
  public static final String SECONDARY_KEY_VIDEO_TAB_PRELOAD_NUMS = "videoTabPreloadNums";
  public static final String SECONDARY_KEY_VOICE_SHUOSHUO = "VoiceShuoshuoH5Url";
  public static final String SECONDARY_KEY_WEBAUDIO_SO_INFO = "webaudio_so_info";
  public static final String SECONDARY_KEY_WEBVIEW_SECURE = "isNeedSecureVerify";
  public static final String SECONDARY_KEY_WEBVIEW_SECURE_ALL_BUSINESS = "isNeedSecureVerifyAllBusiness";
  public static final String SECONDARY_KEY_WNS_CGI_ENABLE_OPTIMIZATION = "enableWnsCgiOptimization";
  public static final int SECONDARY_KEY_WNS_CGI_ENABLE_OPTIMIZATION_DEFAULT = 1;
  public static final String SECONDARY_KUOLIE_SYNC_BUTTON = "kuo_syns_button";
  public static final String SECONDARY_LARGE_FONT_SIZE = "LargeFontSize";
  public static final String SECONDARY_LATEST_WEBAPP_IP_COUNT = "LatestWebappIPCount";
  public static final String SECONDARY_LATEST_WEBAPP_IP_RECORD_SECONDS = "LatestWebappIPRecordSeconds";
  public static final String SECONDARY_LATEST_WEBAPP_TIMESTAMP_COUNT = "LatestWebappTimeStampCount";
  public static final String SECONDARY_LBS_PRLOAD = "LBSPreload";
  public static final String SECONDARY_LIKELIST_PAGE = "LikeListPage";
  public static final String SECONDARY_LIMIT_FACE_NUMS = "limitFaceNums";
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
  public static final String SECONDARY_LOCAL_PHOTO_ACTIVE_SCAN_TIME_INTERVAL = "localPhotoActiveScanTimeInterval";
  public static final String SECONDARY_LOCAL_PHOTO_HEAD_REQUEST_QBOSS = "localPhotoHeadRequestQboss";
  public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_DIALOG_BUTTON = "localPhotoNotificationDialogButton";
  public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_DIALOG_TEXT = "localPhotoNotificationDialogText";
  public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_DIALOG_TIME = "localPhotoNotificationDialogTime";
  public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_DIALOG_TITLE = "localPhotoNotificationDialogTitle";
  public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_DIALOG_URL = "localPhotoNotificationDialogUrl";
  public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_GUIDE_BUTTON = "localPhotoNotificationGuideButton";
  public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_GUIDE_TEXT = "localPhotoNotificationGuideText";
  public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_GUIDE_TIME = "localPhotoNotificationGuideTime";
  public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_GUIDE_TITLE = "localPhotoNotificationGuideTitle";
  public static final String SECONDARY_LOCAL_PHOTO_NOTIFICATION_GUIDE_URL = "localPhotoNotificationGuideUrl";
  public static final String SECONDARY_LOCAL_PHOTO_SWITCHER_URL = "LocalPhotoSwitcherUrl";
  public static final String SECONDARY_LOCAL_PHOTO_VIDEO_MEMORY_OPEN_RECOMM_IMG_URL = "qzoneLocalPhotoVideoMemoryEmptyImgUrl";
  public static final String SECONDARY_LOCAL_PHOTO_VIDEO_MEMORY_SWITCH = "qzoneLocalPhotoVideoMemorySwitch";
  public static final String SECONDARY_LOCAL_PHOTO_VIDEO_MEMORY_TAKE_MORE_PHOTO_IMG_URL = "qzoneLocalPhotoVideoMemoryTakeMorePhotoImgUrl";
  public static final String SECONDARY_LOCATE_MINPOI_INTERVAL = "LBSPOIListFrequency";
  public static final String SECONDARY_LOCATE_MIN_DISTANCE = "LBSIsEqualDistance";
  public static final String SECONDARY_LOG_UPLOAD_OPT_IP = "OptimumIP_MobileLog";
  public static final String SECONDARY_LOG_UPLOAD_OPT_IP_V6 = "OptimumIP_MobileLogV6";
  public static final String SECONDARY_LOVER_ICON_URL = "LoversSpace";
  public static final String SECONDARY_LOVER_ZONE_URL = "bar_loversspace_schema";
  public static final String SECONDARY_LOVESPACE_AIOGRAYTIPSLINKJUMPURL = "LoverBonusAIOGrayTipsLinkURL";
  public static final String SECONDARY_LOVESPACE_AIOGRAYTIPSLINKTEXT = "LoverBonusAIOGrayTipsLinkText";
  public static final String SECONDARY_LOVESPACE_AIOGRAYTIPSMAINTEXT = "LoverBonusAIOGrayTipsMainText";
  public static final String SECONDARY_LOW_CPU = "LowCpu";
  public static final String SECONDARY_LOW_PHONE_FRICITION = "LowPhoneFriction";
  public static final String SECONDARY_MACHINELEARNINF_REPORT_SAMPLE = "MachinelearningReportSamples";
  public static final String SECONDARY_MACHINELEARNINF_REPORT_SWITCH = "MachinelearningReportSwitch";
  public static final String SECONDARY_MACHINELEARNINF_REPORT_WHITE_LIST = "MachinelearningReportWhiteList";
  public static final String SECONDARY_MACHINELEARNINF_SMART_REPORT_CONFIG = "MachinelearningSmartReportConfig";
  public static final String SECONDARY_MACHINELEARNINF_SMART_REPORT_SWITCH = "MachinelearningSmartReportSwitch";
  public static final String SECONDARY_MAKE_PHOTO_BLOG_FUNCTION_SWITCH = "ShouZhangBlogSwitch";
  public static final String SECONDARY_MAKE_PHOTO_BLOG_URL = "PhotoBlogUrl";
  public static final String SECONDARY_MAKE_VIDEO_ALBUM_MAX_PHOTO_NUM = "MakeVideoAlbumMaxPhoto";
  public static final String SECONDARY_MANAGEMENT_MAX_PHOTO_NUM = "ManagementMaxPhotoNum";
  public static final String SECONDARY_MANAGEMENT_MAX_VIDEO_NUM = "ManagementMaxVideoNum";
  public static final String SECONDARY_MAX_DOWNLOADING_VIDEO_COUNT = "maxDownloadingVideoCount";
  public static final String SECONDARY_MAX_HOURS_PHOTO_CREATE_GIF = "maxHoursPhotoCreateGif";
  public static final String SECONDARY_MAX_RANGE_NUMBER = "MiniAppMaxRangeNumber";
  public static final String SECONDARY_MAX_RECENT_PHOTO_NUM = "MaxRecentPhotoNum";
  public static final String SECONDARY_MAX_SPEED = "ListMaxSpeed";
  public static final String SECONDARY_MAX_SYNC_TO_WEISHI_VIDEO_DURATION = "maxSyncToWeishiVideoDuration";
  public static final String SECONDARY_MEDAL_JUMP_URL = "MedalJumpUrl";
  public static final String SECONDARY_MEMOEY_CAN_ARCHIVE_INTERVAL = "memory_can_archive_interval";
  public static final String SECONDARY_MEMOEY_COVER_URL = "memory_cover_url";
  public static final String SECONDARY_MEMOEY_DIVIMAGE_URL = "memory_divimage_url";
  public static final String SECONDARY_MEMOEY_OPERATE_TIMES = "memory_operate_times";
  public static final String SECONDARY_MEMOEY_TEXT = "memory_defaul_text";
  public static final String SECONDARY_MEMOEY_TEXT_CONTENT = "memory_defaul_text_content";
  public static final String SECONDARY_MEMORY_COLD_TIME = "memory_cold_time";
  public static final String SECONDARY_MEMORY_SEAL = "MemorySeal";
  public static final String SECONDARY_MENTORSHIP_APNG_URL = "mentorship_apng_url";
  public static final String SECONDARY_MENTORSHIP_APNG_URL_DEFAULT = "https://qzonestyle.gtimg.cn/aoi/sola/20191111173708_UYRdOtYOfJ.png";
  public static final String SECONDARY_MENTORSHIP_NEWYEAR_APNG_URL = "mentorship_newyear_apng_url";
  public static final String SECONDARY_MENTORSHIP_NEWYEAR_APNG_URL_DEFAULT = "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_evBQGhifVq.png";
  public static final String SECONDARY_MENTORSHIP_SVIP_APNG_URL = "mentorship_svip_apng_url";
  public static final String SECONDARY_MENTORSHIP_SVIP_APNG_URL_DEFAULT = "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_NTF6EEcVWV.png";
  public static final String SECONDARY_MENTORSHIP_YELLOWVIP_APNG_URL = "mentorship_yellowvip_apng_url";
  public static final String SECONDARY_MENTORSHIP_YELLOWVIP_APNG_URL_DEFAULT = "https://qzonestyle.gtimg.cn/aoi/sola/20191127145904_DNAFqFLjOz.png";
  public static final String SECONDARY_MIDDLE_PHONE_FRICITION = "MiddlePhoneFriction";
  public static final String SECONDARY_MINI_AIO = "mini_aio";
  public static final String SECONDARY_MINI_APP_AD_GAME_START_LIMIT = "MiniAppGameStartLimit";
  public static final String SECONDARY_MINI_APP_AD_LAST_SHOW_LIMIT = "MiniAppLastShowLimit";
  public static final String SECONDARY_MINI_APP_AUTH_WHITELIST = "MiniAppAuthWhiteList";
  public static final String SECONDARY_MINI_APP_COOKIE_WHITELIST = "MiniAppCookieWhiteAppIdList";
  public static final String SECONDARY_MINI_APP_COVER_TEXTVIEW_PADDING = "miniappcovertextviewpadding";
  public static final String SECONDARY_MINI_APP_DEX_CONFIG = "sdk_dex_config";
  public static final String SECONDARY_MINI_APP_DOMAIN_WHITE_LIST = "defaultAllowedHostList";
  public static final String SECONDARY_MINI_APP_DOWNLOAD_HTTP2 = "MiniAppDownloadEnableHttp2";
  public static final String SECONDARY_MINI_APP_DOWNLOAD_ON_RANGE_MODE = "MiniAppDownloadOnRangeMode";
  public static final String SECONDARY_MINI_APP_ENABLE_INSTRUCTIONS = "MiniAppEnableInstructions";
  public static final String SECONDARY_MINI_APP_ENABLE_SCHEME_DEBUG = "enableSchemeDebug";
  public static final String SECONDARY_MINI_APP_FILE_STR = "MiniAppFileString";
  public static final String SECONDARY_MINI_APP_IPV6ONLY_DOMAIN_BLACK_LIST = "ipv6_domain_black_list";
  public static final String SECONDARY_MINI_APP_IPV6ONLY_DOMAIN_WHITE_LIST = "ipv6_domain_white_list";
  public static final String SECONDARY_MINI_APP_IPV6ONLY_FORWARDING_REFERER = "MiniAppIPv6OnlyForwardingReferer";
  public static final String SECONDARY_MINI_APP_IPV6ONLY_FORWARDING_URL = "ipv6_http_proxy_url";
  public static final String SECONDARY_MINI_APP_IPV6ONLY_FORWARDING_WNSCONFIG = "ipv6_proxy_enable";
  public static final String SECONDARY_MINI_APP_IPV6ONLY_FORWARDING_WSS_URL = "ipv6_websocket_proxy_url";
  public static final String SECONDARY_MINI_APP_MOOD_MAX_PHOTO_AND_VIDEO_COUNT = "MiniAppMoodMaxPhotoAndVideoCount";
  public static final String SECONDARY_MINI_APP_MOOD_MAX_SINGLE_PHOTO_SIZE = "MiniAppMoodMaxSinglePhotoSize";
  public static final String SECONDARY_MINI_APP_MOOD_MAX_SINGLE_VIDEO_DURATION = "MiniAppMoodMaxSingleVideoDuration";
  public static final String SECONDARY_MINI_APP_MOOD_MAX_SINGLE_VIDEO_SIZE = "MiniAppMoodMaxSingleVideoSize";
  public static final String SECONDARY_MINI_APP_MOOD_MAX_TEXT_COUNT = "MiniAppMoodMaxTextCount";
  public static final String SECONDARY_MINI_APP_MOOD_MAX_VIDEO_COUNT = "MiniAppMoodMaxVideoCount";
  public static final String SECONDARY_MINI_APP_MSF_TIMEOUT_VALUE = "MiniAppMsfTimeoutValue";
  public static final String SECONDARY_MINI_APP_NEWSDK_ENABLE = "newappsdkenable";
  public static final String SECONDARY_MINI_APP_OPENURL_DOMAIN_WHITELIST = "domainWhiteList";
  public static final String SECONDARY_MINI_APP_OPENURL_FILTER = "MiniAppOpenUrlFilter";
  public static final String SECONDARY_MINI_APP_PIC_URL = "mini_app_default_pic_url";
  public static final String SECONDARY_MINI_APP_PIC_URL_DEFAULT = "https://qzonestyle.gtimg.cn/aoi/sola/20190717211007_vRwUiJr9lM.png";
  public static final String SECONDARY_MINI_APP_PRELOAD_APP_STORE_FROM_QZONE_NAVIGATOR_BAR = "preloadAppStoreFromQzoneNavigatorBar";
  public static final String SECONDARY_MINI_APP_RDM_DOMAIN_WHITE_LIST = "MiniAppRMDDomainWhiteList";
  public static final String SECONDARY_MINI_APP_SET_COOKIIE_HOST = "MiniAppCookieWhiteHostList";
  public static final String SECONDARY_MINI_APP_STORE_ANIMATION_URL = "mini_app_store_animation_url";
  public static final String SECONDARY_MINI_APP_WEBVIEWCCOMPONENT_ERRORPAGE = "https://m.q.qq.com/webview/error?url={url}&appid={appid}";
  public static final String SECONDARY_MINI_APP_WIKI_SCENE_CONFIG_MAP = "configSceneMap";
  public static final String SECONDARY_MINI_ENABLE_HOT_RELOAD = "MiniEnableHotReload";
  public static final String SECONDARY_MINI_GAME_APILOG_BLACKLIST = "MiniGameAPILogBlackList";
  public static final String SECONDARY_MINI_GAME_APILOG_WHITELIST = "MiniGameAPILogWhiteList";
  public static final String SECONDARY_MINI_GAME_BACK_PRESS_HINT = "MiniGameBackPressHint";
  public static final String SECONDARY_MINI_GAME_BACK_PRESS_HINT_LIST = "MiniGameBackPressHintList";
  public static final String SECONDARY_MINI_GAME_BANNER_AD_MIN_WIDTH = "MiniGameBannerAdMinWidth";
  public static final String SECONDARY_MINI_GAME_BASELIB = "MiniGameBaseLib";
  public static final String SECONDARY_MINI_GAME_BLACK_DETECT_INTERVAL = "MiniGameBlackDetectInterval";
  public static final String SECONDARY_MINI_GAME_BLACK_LIST = "MiniGameBlackList";
  public static final String SECONDARY_MINI_GAME_CACHE_FREE_DIALOG_CONTENT = "MiniGameCacheFreeDialogContent";
  public static final String SECONDARY_MINI_GAME_CODE_CACHE_ENABLE = "MiniGameCodeCacheEnable";
  public static final String SECONDARY_MINI_GAME_DEFAULT_PAY_SHARE_IMG = "MiniGameDefaultPayShareImg";
  public static final String SECONDARY_MINI_GAME_DEFAULT_PAY_SHARE_TITLE = "MiniGameDefaultPayShareTitle";
  public static final String SECONDARY_MINI_GAME_DEFAULT_SHARE_IMG = "MiniGameDefaultShareImg";
  public static final String SECONDARY_MINI_GAME_DEX_ENABLE = "MiniGameDexEnable";
  public static final String SECONDARY_MINI_GAME_DOMAIN_NEED_CHECK_PORT = "MiniGameDomainNeedCheckPort";
  public static final String SECONDARY_MINI_GAME_DOMAIN_WHITELIST = "MiniGameDomainWhiteList";
  public static final String SECONDARY_MINI_GAME_DOWNLOADER_MODE = "MiniGameDownloaderMode";
  public static final String SECONDARY_MINI_GAME_DOWNLOADER_PRE_CONNECT_HOST = "MiniGameDownloaderPreConnectHost";
  public static final String SECONDARY_MINI_GAME_ENABLE_DOWNLOADER_PRE_CONNECT = "MiniGameDownloaderPreConnectEnable";
  public static final String SECONDARY_MINI_GAME_ENABLE_HTTP2 = "MiniGameEnableHttp2";
  public static final String SECONDARY_MINI_GAME_ENABLE_OPENGLES3 = "enableOpengles3";
  public static final String SECONDARY_MINI_GAME_ENGINE_VERSION = "MiniGameEngineVersion";
  public static final String SECONDARY_MINI_GAME_ERROR_DIALOG_BLACK = "MiniGameErrorDialogBlack";
  public static final String SECONDARY_MINI_GAME_ERROR_DIALOG_CONTENT = "MiniGameErrorDialogContent";
  public static final String SECONDARY_MINI_GAME_ERROR_DIALOG_ENABLE = "MiniGameErrorDialogEnable";
  public static final String SECONDARY_MINI_GAME_FAKE_FIRSTFRAME_URL = "MiniGameFakeFirstFrameUrl";
  public static final String SECONDARY_MINI_GAME_FRAME_NO_CHANGE_LIMIT = "MiniGameFrameNoChangeLimit";
  public static final String SECONDARY_MINI_GAME_GARY_RANGE = "MiniGameGaryRange";
  public static final String SECONDARY_MINI_GAME_JS_ERROR_DETECT_INTERVAL = "MiniGameJsErrorDetectInterval";
  public static final String SECONDARY_MINI_GAME_KILL_ALL_GAMES_WHEN_DESTROY = "MiniGameKillAllGamesWhenDestroy";
  public static final String SECONDARY_MINI_GAME_KILL_ALL_GAMES_WHEN_REUSE = "MiniGameKillAllGamesWhenReuse";
  public static final String SECONDARY_MINI_GAME_KILL_OTHER_GAMES_ON_START = "MiniGameKillOtherGamesOnStart";
  public static final String SECONDARY_MINI_GAME_LAUNCH_FAIL_DIALOG_CONTENT = "MiniGameLaunchFailDialogContent";
  public static final String SECONDARY_MINI_GAME_LOG_ENABLE = "MiniGameLogEnable";
  public static final String SECONDARY_MINI_GAME_MIN_SYS_VERSION = "MiniGameMinSysVersion";
  public static final String SECONDARY_MINI_GAME_NEWSDK_ENABLE = "newsdkenable";
  public static final String SECONDARY_MINI_GAME_NO_PRESENT_DURATION_LIMIT = "MiniGameNoPresentDurationLimit";
  public static final String SECONDARY_MINI_GAME_NO_PRESENT_TOUCH_LIMIT = "MiniGameNoPresentTouchLimit";
  public static final String SECONDARY_MINI_GAME_ONSHOW_REPORT_INTERVAL = "MiniGameOnShowReportInterval";
  public static final String SECONDARY_MINI_GAME_PAY_FOR_FRIEND_URL = "MiniGameDefaultPayForFriendUrl";
  public static final String SECONDARY_MINI_GAME_PERSISTENT_DEBUG_VERSION_ENABLE = "MiniGamePersistentDebugVersionEnable";
  public static final String SECONDARY_MINI_GAME_PRELOAD_BASELIB_ENABLE = "MiniGamePreloadBaseLibEnable";
  public static final String SECONDARY_MINI_GAME_PRESENT_DETECT_INTERVAL = "MiniGamePresentDetectInterval";
  public static final String SECONDARY_MINI_GAME_PRE_CONNECT_BLACK_APPID_LIST = "MiniGamePreConnectBlackAppIdList";
  public static final String SECONDARY_MINI_GAME_PRE_CONNECT_NUM = "MiniGamePreConnectNum";
  public static final String SECONDARY_MINI_GAME_RUNTIME_PRELOAD = "MiniGameRuntimePreload";
  public static final String SECONDARY_MINI_GAME_RUNTIME_PRELOAD_ON_FIRST_FRAME = "MiniGameRuntimePreloadOnFirstFrame";
  public static final String SECONDARY_MINI_GAME_STORAGE_EXCEED_DIALOG_ENABLE = "MiniGameStorageExceedDialogEnable";
  public static final String SECONDARY_MINI_GAME_STORAGE_EXCEED_LIMIT = "MiniGameStorageExceedLimit";
  public static final String SECONDARY_MINI_GAME_SUBPACK_RETRY_ON_COMPILE_COUNT = "MiniGameSubPackRetryOnCompileCount";
  public static final String SECONDARY_MINI_GAME_TRITON_BACKUP_URL = "MiniGameTritonBackupUrl";
  public static final String SECONDARY_MINI_LOADING_AD_APP_AUTO_DOWNLOAD = "launch_adv_app_auto_download";
  public static final String SECONDARY_MINI_LOADING_AD_DURATION_TIME = "launch_adv_duration";
  public static final String SECONDARY_MINI_LOADING_AD_EXTRA_PRELOAD_INTERVAL = "launch_adv_app_preload_interval";
  public static final String SECONDARY_MINI_LOADING_AD_PRELOAD_LIMIT = "launch_adv_app_preload_limit";
  public static final String SECONDARY_MINI_LOADING_AD_PRELOAD_LIMIT_FOR_UIN = "launch_adv_user_preload_limit";
  public static final String SECONDARY_MINI_LOADING_AD_SELECT_LIMIT = "launch_adv_app_select_limit";
  public static final String SECONDARY_MINI_LOADING_AD_SELECT_LIMIT_FOR_UIN = "launch_adv_user_select_limit";
  public static final String SECONDARY_MINI_LOADING_AD_SKIP_TIME = "launch_adv_skip_time";
  public static final String SECONDARY_MINI_NEW_SCREEN_INFO = "MiniGameScreenInfo";
  public static final String SECONDARY_MINI_NEW_TEXT_PARSER = "MiniGameTextParser";
  public static final String SECONDARY_MINI_OPENDATA_DOMAIN_WHITE_LIST = "opendatahosts";
  public static final String SECONDARY_MINI_RECORD_DURATION_INTERVAL = "MiniRecordDurationInterval";
  public static final String SECONDARY_MINI_REPORT_DELAY_CHECK_DB = "MiniReportDelayCheckDB";
  public static final String SECONDARY_MINI_REPORT_DELAY_WAITING = "MiniReportDelayWaiting";
  public static final String SECONDARY_MINI_SHOW_TIMEOUT = "MiniShowTimeout";
  public static final String SECONDARY_MINI_STROE_SCENE_WHITELIST = "miniStoreSceneWhiteList";
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
  public static final String SECONDARY_MONITORH5REPORT_SAMPLE = "MonitorH5ReportSamples";
  public static final String SECONDARY_MONITORH5REPORT_URL = "MonitorH5ReportURL";
  public static final String SECONDARY_MOODLIST_BANNER_SHOW_RATIO = "MoodListShowRatio";
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
  public static final String SECONDARY_MORE_BIRTHDAY_GIFT = "MoreBirthdayGift";
  public static final String SECONDARY_MSG_LIST_URL = "MsgListUrl";
  public static final String SECONDARY_MUSIC_COVER_PREVIEW = "MusicCoverPreview";
  public static final String SECONDARY_MUSIC_DETAIL_PAGE_FOR_QZVIP_MANAGER_URL = "BgMusicDetailForQzVipManagerUrl";
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
  public static final String SECONDARY_NEED_SYNC_TO_WEISHI = "ShowMoodSyncWeishiButton";
  public static final String SECONDARY_NEWTYPE_UPLOAD_MOBILE_LOG_HOST = "PhotoURL4";
  public static final String SECONDARY_NEW_ALBUM_CHOOSE_ORDER = "NewAlbumChooseOrder";
  public static final String SECONDARY_NEW_ALBUM_SHOW_SETTINGS = "NewAlbumShowSettings";
  public static final String SECONDARY_NEW_CARD_PREVIEW = "NewCardPreview";
  public static final String SECONDARY_NEW_CARD_PREVIEW_URL = "NewCardPreviewUrl";
  public static final String SECONDARY_NEW_CARD_STORE = "NewCardStore";
  public static final String SECONDARY_NEW_CARD_STORE_CARD_PIC_URL = "newCardStoreCardPicUrl";
  public static final String SECONDARY_NEW_ENTRY_RED_DOT_SWITCH = "AlbumNewEntryRedDotSwitch";
  public static final String SECONDARY_NICKNAME_FLASH = "NickNameFlash";
  public static final String SECONDARY_NOT_LOCATE_FROM_PROFLIE = "notlocate_from_profile";
  public static final String SECONDARY_NOT_SHOWKAPU_FROM_PROFLIE = "notshowkapu_from_profile";
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
  public static final String SECONDARY_OPEN_THEME_PANEL_WHEN_CREAT_ALBUM_SETTING = "openThemePanelWhenCreateAlbum";
  public static final String SECONDARY_OTHER_UPLOAD_BAK_IP = "BackupIP_OTHERUP";
  public static final String SECONDARY_OTHER_UPLOAD_HOST_IP = "OtherURL_UP";
  public static final String SECONDARY_OTHER_UPLOAD_OPT_IP = "OptimumIP_OTHERUP";
  public static final String SECONDARY_OTHER_UPLOAD_OPT_IP_V6 = "OptimumIP_OTHERUP_V6";
  public static final String SECONDARY_OUTBOX_MAX_RETRY_COUNT_PER_PERIOD = "ReConnCount";
  public static final String SECONDARY_OUTBOX_MAX_RETRY_TIMEOUT = "RetryTime";
  public static final String SECONDARY_OUTBOX_NEXT_INTERVAL = "RetryInterval";
  public static final String SECONDARY_PANORAMA_PHOTO_CHECK = "paranoramaOpenCheck";
  public static final String SECONDARY_PARTICLE_EFFECT = "particle_effect";
  public static final String SECONDARY_PARTICLE_EFFECT_BEST_PERFORM_BLACKLIST = "ParticleEffectBestPerformBlacklist";
  public static final String SECONDARY_PARTICLE_EFFECT_BEST_PERFORM_BLACKLIST_DEFUALT = "";
  public static final String SECONDARY_PARTICLE_EFFECT_BLACKLIST = "ParticleEffectBlacklist";
  public static final String SECONDARY_PARTICLE_EFFECT_BLACKLIST_DEFUALT = "";
  public static final int SECONDARY_PARTICLE_EFFECT_DEFAULT = 1;
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
  public static final String SECONDARY_PHOTOVIEW_BACK_TO_BACKGROUND = "backTobackground";
  public static final String SECONDARY_PHOTOVIEW_BACK_TO_BACKGROUND_PHOTO_BYTES = "backTobackgroundPhotoBytes";
  public static final String SECONDARY_PHOTOVIEW_BACK_TO_BACKGROUND_VIDEO_BYTES = "backTobackgroundVideoBytes";
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
  public static final String SECONDARY_PHOTO_BEAUTY_MODEL = "PhotoBeautyModel";
  public static final String SECONDARY_PHOTO_BEAUTY_PHONE_MODEL = "PhotoBeautyPhoneModel";
  public static final String SECONDARY_PHOTO_BEAUTY_PHONE_SIZE = "PhotoBeautyPhoneSize";
  public static final String SECONDARY_PHOTO_BUBBLE_EXPOSE_SCROLL_SHOWTIME = "ExposePhotoBubbleScrollShowTime";
  public static final String SECONDARY_PHOTO_BUBBLE_EXPOSE_SHOWTIME = "ExposePhotoBubbleShowTime";
  public static final String SECONDARY_PHOTO_BUBBLE_EXPOSE_TIMERANGE = "ExposePhotoBubbleTimeRange";
  public static final String SECONDARY_PHOTO_CATEGORY_LIST_HEADER_TIPS = "PhotoCategoryListHeaderTips";
  public static final String SECONDARY_PHOTO_CATEGORY_SCANNER_FRONT_BLACKLIST = "PhotoCategoryScannerFrontCamBlackList";
  public static final String SECONDARY_PHOTO_CATEGORY_SCANNER_FRONT_CAM = "PhotoCategoryScannerFrontCam";
  public static final String SECONDARY_PHOTO_CATEGORY_SCANNER_SWITCH = "PhotoCategoryScannerSwitch";
  public static final String SECONDARY_PHOTO_CREATE_BEAUTY_SO = "PhotoGuideCreateBeautySo";
  public static final String SECONDARY_PHOTO_CREATE_BEAUTY_SO_LENGTH = "PhotoGuideCreateBeautySoLength";
  public static final String SECONDARY_PHOTO_CREATE_BEAUTY_SO_MD5 = "PhotoGuideCreateBeautySoMD5";
  public static final String SECONDARY_PHOTO_CREATE_GIF_NEED_PEOPLE = "PhotoGuideCreateGifNeedPeople";
  public static final String SECONDARY_PHOTO_CREATE_GIF_SO = "PhotoGuideCreateGifSo";
  public static final String SECONDARY_PHOTO_CREATE_GIF_SO_64 = "PhotoGuideCreateGifSo64";
  public static final String SECONDARY_PHOTO_CREATE_GIF_SO_LENGTH = "PhotoGuideCreateGifSoLength";
  public static final String SECONDARY_PHOTO_CREATE_GIF_SO_LENGTH_64 = "PhotoGuideCreateGifSoLength64";
  public static final String SECONDARY_PHOTO_CREATE_GIF_SO_MD5 = "PhotoGuideCreateGifSoMD5";
  public static final String SECONDARY_PHOTO_CREATE_GIF_SO_MD5_64 = "PhotoGuideCreateGifSoMD564";
  public static final String SECONDARY_PHOTO_CREATE_OPENCV_SO_LENGTH = "PhotoGuideCreateOpenSoLength";
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
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_CHAT_CACHE_PHOTO_MIN_FILE_LENGTH = "PhotoGuideEventChatCacheMinFileLength";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_CHAT_CACHE_PHOTO_QQ_CACHE_ICON_URL = "PhotoGuideEventChatCachePhotoQQCacheIconUrl";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_CHAT_CACHE_PHOTO_QQ_CACHE_PATH = "PhotoGuideEventChatCachePhotoQQCachePath";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_CHAT_CACHE_PHOTO_SWITCH = "PhotoGuideEventCacheSwitch";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_CHAT_CACHE_PHOTO_WX_CACHE_ICON_URL = "PhotoGuideEventChatCachePhotoWXCacheIconUrl";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_CHAT_CACHE_PHOTO_WX_CACHE_PATH = "PhotoGuideEventChatCachePhotoWXCachePath";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_CHECK_INTERVAL_TIME = "PhotoGuideEventUploadCheckIntervalTime";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_FESTIVAL_ENABLE = "PhotoGuideEventFestivalEnable";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_GIF_ENABLE = "PhotoGuideEventGifEnable";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_IS_SHOW_SCENE_POINT = "PhotoGuideEventShowScenePoint";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_MIN_UNEXPOSURE_PHOTOS = "PhotoGuideEventUnexposureMinPhotos";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_MIN_UN_UPLOAD_NUM = "PhotoRecommendMinUnUploadNum";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_NNJR_ENABLE = "PhotoGuideEventNnjrEnable";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_NON_WIFI_MAX_PHOTOS = "PhotoGuideEventNonWifiMaxPhotos";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_NON_WIIF_MAX_DAYS = "PhotoGuideEventNonWifiMaxDays";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_START_HOUR = "PhotoGuideEventStartHour";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_WIFFI_MAX_DAYS = "PhotoGuideEventWiffMaxDay";
  public static final String SECONDARY_PHOTO_GUIDE_EVENT_WIFI_FIRST_EVENT_DAYS = "PhotoGuideEventWifiFirstEventDays";
  public static final String SECONDARY_PHOTO_GUIDE_VERSION_STRING = "PhotoGuideEventVersionString";
  public static final String SECONDARY_PHOTO_LIBC_SHARE_SO_LENGTH = "PhotoGuideLibCShareSoLength";
  public static final String SECONDARY_PHOTO_LIBC_SHARE_SO_LENGTH_64 = "PhotoGuideLibCShareSoLength64";
  public static final String SECONDARY_PHOTO_LIBC_SHARE_SO_MD5 = "PhotoGuideLibCShareSoMD5";
  public static final String SECONDARY_PHOTO_LIBC_SHARE_SO_MD5_64 = "PhotoGuideLibCShareSoMD564";
  public static final String SECONDARY_PHOTO_LIST_VISIBLE_STATISTIC = "photoListVisibleStatistic";
  public static final String SECONDARY_PHOTO_LIST_VISIBLE_TIME_LIMIT = "photoListVisibleTimeLimit";
  public static final String SECONDARY_PHOTO_NEED_CHECK_GIF_EVERY_TIME = "PhotoGuideNeedCheckGifEveryTime";
  public static final String SECONDARY_PHOTO_NEED_CREATE_GIF = "PhotoGuideNeedCreateGif";
  public static final String SECONDARY_PHOTO_PICTURE_MARKER_MODEL = "PhotoPictureMarkerModel";
  public static final String SECONDARY_PHOTO_PICTURE_MARKER_SO = "PhotoPictureMarkerSo";
  public static final String SECONDARY_PHOTO_QULATITY_SO = "PhotoGuidePictureQulatitySo";
  public static final String SECONDARY_PHOTO_QULATITY_SO_64 = "PhotoGuidePictureQulatitySo64";
  public static final String SECONDARY_PHOTO_QULATITY_SO_LENGTH = "PhotoGuidePictureQulatitySoLength";
  public static final String SECONDARY_PHOTO_QULATITY_SO_LENGTH_64 = "PhotoGuidePictureQulatitySoLength64";
  public static final String SECONDARY_PHOTO_QULATITY_SO_MD5 = "PhotoGuidePictureQulatitySoMD5";
  public static final String SECONDARY_PHOTO_QULATITY_SO_MD5_64 = "PhotoGuidePictureQulatitySoMD564";
  public static final String SECONDARY_PHOTO_QZONE_VISION_SO_LENGTH = "PhotoGuideQzoneVisionSoLength";
  public static final String SECONDARY_PHOTO_QZONE_VISION_SO_LENGTH_64 = "PhotoGuideQzoneVisionSoLength64";
  public static final String SECONDARY_PHOTO_QZONE_VISION_SO_MD5 = "PhotoGuideQzoneVisionSoMD5";
  public static final String SECONDARY_PHOTO_QZONE_VISION_SO_MD5_64 = "PhotoGuideQzoneVisionSoMD564";
  public static final String SECONDARY_PHOTO_RECYCLE = "PhotoRecycle";
  public static final String SECONDARY_PHOTO_SET_COVER = "photoBrowserSetCover";
  public static final String SECONDARY_PHOTO_TRAFFIC_THRESHOLD = "RemindUploadSizeIsLargeThreshold";
  public static final String SECONDARY_PHOTO_UPLOADRATE_SWITCH = "PhotoUpLoadRateSwitch";
  public static final String SECONDARY_PHOTO_UPLOAD_ALL_PIC_QUALITY = "MoodUploadQuality";
  public static final String SECONDARY_PHOTO_UPLOAD_AUTO_2G = "Auto2G";
  public static final String SECONDARY_PHOTO_UPLOAD_AUTO_3G = "Auto3G";
  public static final String SECONDARY_PHOTO_UPLOAD_AUTO_WIFI = "AutoWiFi";
  public static final String SECONDARY_PHOTO_UPLOAD_LOW_DEVICE = "LowDeviceWhite";
  public static final String SECONDARY_PHOTO_UPLOAD_MAX_NUM = "MaxNum";
  public static final String SECONDARY_PHOTO_UPLOAD_MIDDLE_DEVICE = "MiddleDeviceWhite";
  public static final String SECONDARY_PHOTO_UPLOAD_QCIRCLE_PIC_QUALITY = "MoodUploadQualityForPicQcircle";
  public static final String SECONDARY_PHOTO_UPLOAD_QCIRCLE_VIDEO_QUALITY = "MoodUploadQualityForVideoQcircle";
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
  public static final String SECONDARY_PICK_GAME_MATES = "PickGameMates";
  public static final String SECONDARY_PICTURE_VIEWER_DANMAKU_BLACK_LIST = "PictureViewerPhotoDanmakuBlackList";
  public static final String SECONDARY_PICTURE_VIEWER_DANMAKU_CPU_LEVEL = "PictureViewerPhotoDanmakuCpuLevel";
  public static final String SECONDARY_PICTURE_VIEWER_DANMAKU_DEFAULT_SWITCH = "PictureViewerPhotoDanmakuDefaultSwitch";
  public static final String SECONDARY_PICTURE_VIEWER_DANMAKU_GARY_RANGE = "PictureViewerPhotoDanmakuGaryRange";
  public static final String SECONDARY_PICTURE_VIEWER_DANMAKU_MEMORY_LEVEL = "PictureViewerPhotoDanmakuMemoryLevel";
  public static final String SECONDARY_PICTURE_VIEWER_DOUBLE_TAP_SCALE = "pictureViewerDoubleTapScale";
  public static final String SECONDARY_PICTURE_VIEWER_MAX_SCALE = "pictureViewerMaxScale";
  public static final String SECONDARY_PICTURE_VIEWER_NICK_MAX_LENGTH = "PictureViewerNickMaxLength";
  public static final String SECONDARY_PICTURE_VIEWER_PHOTO_LIST_LOADMORE_COUNT = "pictureViewerPhotoListLoadMoreCount";
  public static final String SECONDARY_PICTURE_VIEWER_PIC_INFO_URL = "PictureViewerPicInfoUrl";
  public static final String SECONDARY_PICTURE_VIEWER_SHOW_PIC_INFO = "PictureViewerShowPicInfo";
  public static final String SECONDARY_PICTURE_VIEWER_SHOW_SHARE_BUTTONS = "pictureViewerShowShareButtons";
  public static final String SECONDARY_PICTURE_VIEWER_TITLE_MAX_LENGTH_WITHOUT_PAGENUM = "PictureViewerTitleMaxLengthWithoutPageNum";
  public static final String SECONDARY_PICTURE_VIEWER_TITLE_MAX_LENGTH_WITH_PAGENUM = "PictureViewerTitleMaxLengthWithPageNum";
  public static final String SECONDARY_PIC_HEIGHT_RATE = "Pic_height_Rate";
  public static final String SECONDARY_PIC_MAX_SIZE_CM = "Pic_MaxSize_CM";
  public static final String SECONDARY_PIC_WIDTH_RATE = "Pic_Width_Rate";
  public static final String SECONDARY_PLATO_ALPHA_RANGE = "QzonePlatoAlphaRange";
  public static final String SECONDARY_PLATO_BLACKLIST = "QzonePlatoBlackList";
  public static final String SECONDARY_PLATO_BUNDLER = "QzonePlatoBundler";
  public static final String SECONDARY_PLATO_BUNDLER_MD5 = "QzonePlatoBundlerMD5";
  public static final String SECONDARY_PLATO_CHECK_BUNDLE_TIMEOUT = "QzonePlatoCheckBundleTimeout";
  public static final String SECONDARY_PLATO_DOWNLOAD_FONT_ANYWAY = "QzonePlatoDownloadFontAnyway";
  public static final String SECONDARY_PLATO_KEXINGHUA_MAIN = "QzonePlatoGexinghuaMain";
  public static final String SECONDARY_PLATO_MAX_CRASH_CNT = "QzonePlatoMaxCrashCount";
  public static final String SECONDARY_PLATO_MIN_API_LEEVEL = "QzonePlatoMinAPI";
  public static final String SECONDARY_PLATO_PAGE_ALPHA_RANGE = "QzonePlatoPageAlphaRange";
  public static final String SECONDARY_PLATO_SO = "QzonePlatoSo";
  public static final String SECONDARY_PLATO_SO_MD5 = "QzonePlatoSoMD5";
  public static final String SECONDARY_PLATO_TIMECOST_REPORT = "QzonePlatoTimeCostReport";
  public static final String SECONDARY_PLATO_WHITE_PAGE_TIMEOUT = "QzonePlatoWhitePageTimeout";
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
  public static final String SECONDARY_POLY_CPU_LEVEL = "hardwareRestrictionCpu";
  public static final String SECONDARY_POLY_MEM_LEVEL = "hardwareRestrictionMemory";
  public static final String SECONDARY_POLY_PRELOAD_TIME = "polymorphicPraisePreloadTime";
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
  public static final String SECONDARY_PUBLISH_QUEUE_MAX_PARALLEL_TASK_COUNT = "MaxParallelTaskCount";
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
  public static final String SECONDARY_QCIRCLE_ADD_TAG_URL = "QcircleAddTagUrl";
  public static final String SECONDARY_QCIRCLE_CERTIFY_TAG_URL = "QcircleCertifyTagUrl";
  public static final String SECONDARY_QCIRCLE_EDIT_VIDEO_TIME_OUT = "QcircleEditVideoTimeout";
  public static final String SECONDARY_QCIRCLE_PUBLISH_ENABLE_SYNC_QZONE = "QcirclePublishEnableSyncQzone";
  public static final String SECONDARY_QCIRCLE_PUBLISH_RECOMMEND_POI_COUNT = "qcirclePublishRecommendPOICount";
  public static final String SECONDARY_QCIRCLE_VIDEO_COMPRESS_PARAM_ALL = "QcircleVideoNewVideoCompressParamAll";
  public static final String SECONDARY_QCIRCLE_VIDEO_URL_VALID_TIME = "secondary_qcircle_video_url_valid_time";
  public static final String SECONDARY_QCIRCLR_ATUSER_MAX = "QCircleFriendMaxSelectCountComment";
  public static final String SECONDARY_QFLUTTER_URL = "tissue_qflutter_url";
  public static final String SECONDARY_QMUSIC_HLS_MAX_RETRY_TIMES = "QmusicHlsMaxRetryTimes";
  public static final String SECONDARY_QQCIRCLE_COMMENT_MAX_WORDS_LIMIT = "qqcircle_comment_max_words_limit";
  public static final String SECONDARY_QQCIRCLE_DEFAULT_SHOW_TAB_TYPE = "qqcircle_default_show_tab_type";
  public static final String SECONDARY_QQCIRCLE_DISABLE_PLUGIN = "qqcircle_disable_qcircle_plugin";
  public static final String SECONDARY_QQCIRCLE_EEVEE_SYSTEM_OPEN = "qqcircle_enable_eevee_polling";
  public static final String SECONDARY_QQCIRCLE_ENABLE = "qqcircle_enable";
  public static final String SECONDARY_QQCIRCLE_ENABLE_FLUTTER_SEARCH = "qqcircle_enable_flutter_search";
  public static final String SECONDARY_QQCIRCLE_ENABLE_FOLDER_CACHE = "qqcircle_enable_folder_cache";
  public static final String SECONDARY_QQCIRCLE_ENABLE_FOLDER_CACHE_LIFECYCLE = "qqcircle_enable_folder_cache_life_cycle";
  public static final String SECONDARY_QQCIRCLE_ENABLE_PLAY_NO_WIFI = "qqcircle_should_auto_play_when_wwan";
  public static final String SECONDARY_QQCIRCLE_ENABLE_REUSE_TAB_FRAGMENT = "qqcircle_enable_reuse_tab_fragment";
  public static final String SECONDARY_QQCIRCLE_ENABLE_TRANSITION_CLOSE_ANIM = "qqcircle_enable_transition_close_anim";
  public static final String SECONDARY_QQCIRCLE_ENTRANCE_ENABLE = "qqcircle_entrance_enable";
  public static final String SECONDARY_QQCIRCLE_FEED_MUTE = "qqcircle_feed_mute";
  public static final String SECONDARY_QQCIRCLE_FOLLOW_TAB_REDDOT_SHOW_INTERVAL = "qqcircle_follow_tab_reddot_show_interval";
  public static final String SECONDARY_QQCIRCLE_GENERATE_VIDEO_OVER_TIME_KEY = "qqcircleGenerateOverTime";
  public static final String SECONDARY_QQCIRCLE_GETPLUGIN_INFO_TIME = "qqcircle_getplugininfo_time";
  public static final String SECONDARY_QQCIRCLE_GET_FOLLOWUSER_INTERNAL = "qqcircle_getfollowuser_internal";
  public static final String SECONDARY_QQCIRCLE_JUMP_TO_PUBLISH = "qqcircleJumpToPublish";
  public static final String SECONDARY_QQCIRCLE_JUMP_TO_PUBLISH_DELAY_TIME = "secondary_qqcircle_jump_to_publish_delay_time";
  public static final String SECONDARY_QQCIRCLE_LABEL_MAX_COUNT = "qqcircle_label_max_count";
  public static final String SECONDARY_QQCIRCLE_MAX_CRASH_COUNT = "qqcricle_max_crash_count";
  public static final String SECONDARY_QQCIRCLE_MAX_PUSH_COUNT = "qqcircle_max_push_count";
  public static final String SECONDARY_QQCIRCLE_PERSONAL_DATA_EDIT_H5_URL = "qqcircle_personal_data_edit_h5_url";
  public static final String SECONDARY_QQCIRCLE_PUSH_NOT_ENOUGH_VALUE = "qqcircle_push_not_enough_value";
  public static final String SECONDARY_QQCIRCLE_QUALITY_REPORT_BUFFER_LENGTH = "quality_quality_report_buffer_length";
  public static final String SECONDARY_QQCIRCLE_QUALITY_REPORT_INTERVAL = "qqcircle_quality_report_interval";
  public static final String SECONDARY_QQCIRCLE_QUALITY_SAMPLE_SWITCH = "qqcircle_quality_sample_switch";
  public static final String SECONDARY_QQCIRCLE_RECOMMEND_FOLLOW_H5_URL = "qqcircle_recommend_follow_h5_url";
  public static final String SECONDARY_QQCIRCLE_REPORT_BUFFER_LENGTH = "qqcircle_report_buffer_length";
  public static final String SECONDARY_QQCIRCLE_REPORT_INTERVAL = "qqcircle_report_interval";
  public static final String SECONDARY_QQCIRCLE_SEARCH_PAGE_URL = "qqcircle_search_page_url";
  public static final String SECONDARY_QQCIRCLE_SHARE_QZONE_HEAD_ICON_FORCE_USE_HTTP = "qqcircle_share_qzone_head_icon_force_use_http";
  public static final String SECONDARY_QQCIRCLE_SHOW_BANNER_INTERVAL = "qqcircle_show_banner_interval";
  public static final String SECONDARY_QQCIRCLE_SHOW_ENTRANCE_ON_AIO_FEED = "qqcircle_show_entrance_on_aio_feed";
  public static final String SECONDARY_QQCIRCLE_SHOW_ENTRANCE_ON_GROUP_TOOLBAR = "qqcircle_show_entrance_on_group_toolbar";
  public static final String SECONDARY_QQCIRCLE_SHOW_ENTRANCE_ON_MESSAGE_TAB = "qqcircle_show_entrance_on_message_tab";
  public static final String SECONDARY_QQCIRCLE_SHOW_ENTRANCE_ON_MESSAGE_TIPS = "qqcircle_show_entrance_on_message_tab_tips";
  public static final String SECONDARY_QQCIRCLE_SHOW_ENTRANCE_ON_PROFILE_CARD = "qqcircle_show_entrance_on_profile_card";
  public static final String SECONDARY_QQCIRCLE_SHOW_ENTRANCE_ON_RECOMMEND_TAB = "qqcircle_show_entrance_on_recommend_tab";
  public static final String SECONDARY_QQCIRCLE_SHOW_ENTRANCE_SWTICH_BUTTON = "qqcircle_show_entrance_switch_button";
  public static final String SECONDARY_QQCIRCLE_SHOW_ENTRANE_ON_DRAWER_TAB = "qqcircle_show_entrance_on_drawer_tab";
  public static final String SECONDARY_QQCIRCLE_SHOW_GROUP_AIO_REDPOINT = "qqcircle_show_group_aio_redpoint";
  public static final String SECONDARY_QQCIRCLE_SHOW_INVITE_GUIDE_BUBBLE_ON_PROFILE_PAGE = "qqcircle_show_invite_guide_bubble_on_profile_page";
  public static final String SECONDARY_QQCIRCLE_SHOW_MOOD_SYNC = "qqcircle_show_mood_sync_circle";
  public static final String SECONDARY_QQCIRCLE_SHOW_PUBLISH_SAVE_GRID_SELECTED = "qqcircle_show_publish_save_grid_selected";
  public static final String SECONDARY_QQCIRCLE_SHOW_SHARE_QZONE = "qqcircle_show_share_qzone";
  public static final String SECONDARY_QQCIRCLE_SPLASH_ENABLE = "qqcircle_splash_enable";
  public static final String SECONDARY_QQCIRCLE_SPLASH_GUIDE_JUMP_DELAY_TIME = "qqcircle_splash_guide_jump_delay_time";
  public static final String SECONDARY_QQCIRCLE_SPLASH_GUIDE_LOGO_TEXT_URL = "qqcircle_splash_guide_logo_text_url";
  public static final String SECONDARY_QQCIRCLE_SPLASH_GUIDE_LOGO_URL = "qqcircle_splash_guide_logo_url";
  public static final String SECONDARY_QQCIRCLE_SPLASH_GUIDE_VIDEO_DIR = "qqcircle_splash_guide_video_dir";
  public static final String SECONDARY_QQCIRCLE_SWITCH_DANMAKU = "qqcircle_switch_danmaku";
  public static final String SECONDARY_QQCIRCLE_SWITCH_PLAY_VIDEO_IN_WORKS_TAB = "qqcircle_switch_play_video_in_works_tab";
  public static final String SECONDARY_QQCIRCLE_TAG_MEDAL_IMAGE_URL_COLOUR = "qqcricle_tag_medal_image_url_colour";
  public static final String SECONDARY_QQCIRCLE_TAG_MEDAL_IMAGE_URL_GRAY = "qqcricle_tag_medal_image_url_gray";
  public static final String SECONDARY_QQCIRCLE_TAG_TO_LAYER = "qqcircle_tag_to_layer";
  public static final String SECONDARY_QQCIRCLE_TASK_USE_HIPPY = "qqcircle_task_use_hippy";
  public static final String SECONDARY_QQCIRCLE_TIMEOUT_MAX_RETRY_COUNT = "qqcircleTimeOutMaxRetryCount";
  public static final String SECONDARY_QQCIRCLE_USE_ASSET_PLUGIN = "qqcircle_use_asset";
  public static final String SECONDARY_QQCIRCLE_USE_EEVEE_RED_POINT = "qqcircle_use_eevee_red_point";
  public static final String SECONDARY_QQCIRCLE_VERIFIED_SWITCH = "qqcircle_verified_switch";
  public static final String SECONDARY_QQREMIND_JUMP_URL = "https://h5.qianbao.qq.com/notice?_wv=1027&_wvx=10&_wwv=4";
  public static final int SECONDARY_QQREMIND_USE_H5 = 1;
  public static final String SECONDARY_QQ_REMIND_ALL_REMIND = "QQRemindAllRemind";
  public static final String SECONDARY_QQ_REMIND_ALL_REMIND_USE_H5 = "QQRemindAllRemindUseH5";
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
  public static final String SECONDARY_QUN_SHOW_PICTURE_INTENT_LIMIT = "QunShowPictureIntentLimit";
  public static final String SECONDARY_QUN_UPLOAD_VIDEO = "QunUploadVideo";
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
  public static final String SECONDARY_QZONESETTINGS_MAXUGCTEXT_VISIBLELINECOUNT = "maxUgcTextVisibleLineCount";
  public static final String SECONDARY_QZONESETTINGS_MOOD_SEND_MINTIMES = "QzoneMoodSendMinTime";
  public static final String SECONDARY_QZONESETTINGS_MULTISHAREMAXCOUNR = "multiShareMaxCount";
  public static final String SECONDARY_QZONESETTINGS_SHAREMAXSELECTCOUNT = "shareMaxSelectCount";
  public static final String SECONDARY_QZONESETTINGS_WHO_CAN_COMMENT_SETTING = "whoCanCommentMyQzone";
  public static final String SECONDARY_QZONE_2D_CMSHOW_DECORATE = "Qzone2DCmshowDecorate";
  public static final String SECONDARY_QZONE_2D_GUEST_CMSHOW_HOME = "Qzone2DGuestCmshowHome";
  public static final String SECONDARY_QZONE_2D_HOST_CMSHOW_HOME = "Qzone2DHostCmshowHome";
  public static final String SECONDARY_QZONE_3D_CMSHOW_DECORATE = "Qzone3DCmshowDecorate";
  public static final String SECONDARY_QZONE_3D_GUEST_CMSHOW_HOME = "Qzone3DGuestCmshowHome";
  public static final String SECONDARY_QZONE_3D_HOST_CMSHOW_HOME = "Qzone3DHostCmshowHome";
  public static final String SECONDARY_QZONE_ALBUM_DOMAIN_LIST = "qzoneAlbumDomainList";
  public static final String SECONDARY_QZONE_BANNER_SHOW_CAMERA_ICON = "qzone_banner_show_camera_icon";
  public static final int SECONDARY_QZONE_BANNER_SHOW_CAMERA_ICON_DEFVALUE = 1;
  public static final String SECONDARY_QZONE_BLOGLIST = "BlogListJumpUrl";
  public static final String SECONDARY_QZONE_BLOG_DETAIL = "BlogDetail";
  public static final String SECONDARY_QZONE_CALL_APP_URL_LIST = "QzoneCallAppUrlList";
  public static final String SECONDARY_QZONE_CM_IDENTIFY_ICON_URL = "qzoneCmIdentifyIconUrl";
  public static final String SECONDARY_QZONE_CM_IDENTIFY_JUMP_URL = "qzoneCmIdentifyJumpUrl";
  public static final String SECONDARY_QZONE_CREATE_SHORTCUT_BLACK_LIST = "QZoneAlbumOpenCreateShortcutBlackList";
  public static final String SECONDARY_QZONE_DESCRIPTIONSETTING = "DescriptionSetting";
  public static final String SECONDARY_QZONE_Dynamic_Cover_ANIMATE_TIME = "QzoneDynamicCoverAnimateTime";
  public static final String SECONDARY_QZONE_Dynamic_Cover_URL = "QzoneQuickReplaceCoverUrl";
  public static final String SECONDARY_QZONE_FACADE_DYNAMIC_BLACK_LIST = "qzonefacade_dynamic_black_list";
  public static final String SECONDARY_QZONE_FACE_SCAN_BLACKLIST = "qzone_face_scan_blacklist";
  public static final String SECONDARY_QZONE_FACE_SCAN_SWITCH = "qzone_face_scan_switch";
  public static final String SECONDARY_QZONE_FEED_PRELOAD = "EnableFeedPreload";
  public static final String SECONDARY_QZONE_GIFTDETAILPAGE = "GiftDetailPage";
  public static final String SECONDARY_QZONE_GIF_MINI_FRAME = "QzoneGifMiniFrame";
  public static final String SECONDARY_QZONE_GPS_COMPLEMENT = "QzoneGpsComplement";
  public static final String SECONDARY_QZONE_GPS_SWITCH = "QzoneGpsSwitch";
  public static final String SECONDARY_QZONE_GPS_TRACE = "QzoneGpsTrace";
  public static final String SECONDARY_QZONE_HTTPS_IP_DIRECT_ENABLE = "QzoneHttpsIpDirectEnable";
  public static final String SECONDARY_QZONE_JUMPAVATALISTPAGE = "Avatalistpage";
  public static final String SECONDARY_QZONE_LAUNCH_SLOW_TIME = "qzone_launch_slow_threshold";
  public static final String SECONDARY_QZONE_MAIN_FORCE_SHUTDOWN_GIF_DECODE = "QzoneMainForceShutdownGifDecode";
  public static final String SECONDARY_QZONE_MAIN_SHOW_FRIEND_FEEDS = "showfriendfeeds";
  public static final String SECONDARY_QZONE_MAIN_SHOW_FRIEND_FEEDS_RESTRICTION_HEAP = "showfriendfeeds_restriction_heap";
  public static final String SECONDARY_QZONE_MAIN_SHOW_FRIEND_FEEDS_RESTRICTION_RAM = "showfriendfeeds_restriction_ram";
  public static final String SECONDARY_QZONE_OPEN_ADD_SHORTCUT = "QZoneAlbumOpenAddShortcut";
  public static final String SECONDARY_QZONE_PET_ENABLE_FORANDROIDP = "qzoneEnablePetForAndroidP";
  public static final String SECONDARY_QZONE_PHONELABELSETTING = "PhoneLabelSetting";
  public static final String SECONDARY_QZONE_PICTURE_LIMIT_WIDTH = "QzonePictureLimitWidth";
  public static final String SECONDARY_QZONE_PICTURE_OPT_SCALE = "QzonePictureOptScale";
  public static final String SECONDARY_QZONE_PICTURE_PIECE_LOAD = "QzonePicturePieceLoad";
  public static final String SECONDARY_QZONE_PICUTRE_SETTING_PAGE = "QzonePictureSettingPage";
  public static final String SECONDARY_QZONE_REG_STRING_MATCHER_LRU_MAP_SIZE = "QzoneRegLruMapSize";
  public static final String SECONDARY_QZONE_SETTING_AUTO_SCROLL_TO_NEXT_VIDEO_DELAY_TIME = "AutoScrollToNextVideoDelayTime";
  public static final int SECONDARY_QZONE_SETTING_AUTO_SCROLL_TO_NEXT_VIDEO_DELAY_TIME_DEFAULT = 1000;
  public static final String SECONDARY_QZONE_SETTING_FEEDS_SINGLE_PICTURE_BIG_PICTURE_MODE_COEFFICIENT = "FeedsSinglePictureBigPictureModeCoefficent";
  public static final String SECONDARY_QZONE_SETTING_FEED_NICK_NAME_SPLASHCOUNT = "FeedNickNameSplashCount";
  public static final String SECONDARY_QZONE_SETTING_MAIN_PAGE = "QzoneSettingMainPage";
  public static final String SECONDARY_QZONE_SETTING_RES_FORBIDDEN_LIST = "ResForbiddenList";
  public static final String SECONDARY_QZONE_SETTING_SHARE_SINGLE_BIG_PICTURE_AS_WECHAT_MINI_PROGRAM = "ShareSingleBigPictureAsWeChatMiniProgram";
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
  public static final String SECONDARY_QZONE_SHOW_VISITOR = "QzoneShowVisitor";
  public static final String SECONDARY_QZONE_SHUOSHUO_CALENDAR_FRIEND_FEED = "QzoneShuoshuoCalendarFriendFeed";
  public static final String SECONDARY_QZONE_SHUOSHUO_CALENDAR_PLUS_ENTRY = "QzoneShuoshuoCalendarPlusEntry";
  public static final String SECONDARY_QZONE_SHUOSHUO_CALENDAR_SHUOSHUO_LIST = "QzoneShuoshuoCalendarShuoshuoList";
  public static final String SECONDARY_QZONE_SHUOSHUO_DAILY_CALENDAR = "QzoneShuoshuoDailyCalendar";
  public static final String SECONDARY_QZONE_SIMPLEUI = "qzonesimpleui";
  public static final String SECONDARY_QZONE_STARTUP_REPORT_CODE_TIME = "qzoneStartupReportCodeTime";
  public static final String SECONDARY_QZONE_SUPPORT_HEIF = "QzoneSupportHeif";
  public static final int SECONDARY_QZONE_SUPPORT_HEIF_DEFAULT = 1;
  public static final String SECONDARY_QZONE_UPDATE_SHORTCUT_BLACK_LIST = "QZoneAlbumUpdateAddShortcutBlackList";
  public static final String SECONDARY_QZONE_VIDEO_DECODE_TYPE_SW_ON_SIMPLE_UI = "SecondaryVideoDecodeTypeSWOnSimpleUI";
  public static final String SECONDARY_QZONE_VIDEO_MAX_TIME = "QzoneVideoMaxTime";
  public static final String SECONDARY_QZONE_VIDEO_MINI_FRAME = "QzoneVideoMiniFrame";
  public static final String SECONDARY_QZONE_VIP_PAYMENT = "FloatingViewForPay";
  public static final String SECONDARY_QZONE_VISIT_DOWNLOAD = "QzoneVisitDownload";
  public static final String SECONDARY_RANGE_MODE_NETWORK_LEVEL = "MiniAppRangeModeNetworkLevel";
  public static final String SECONDARY_RANGE_MODE_PERF_LEVEL = "MiniAppRangeModePerfLevel";
  public static final String SECONDARY_RANGE_SIZE = "MiniAppRangeSize";
  public static final String SECONDARY_RANK_COMMENT_DISPLAY_NUM_IN_PAGE = "rank_comment_displayNum_inPage";
  public static final String SECONDARY_RANK_COMMENT_LABEL_BG_COLOR = "rank_comment_label_bg_color";
  public static final String SECONDARY_RANK_COMMENT_LABEL_TEXT = "rank_comment_label_text";
  public static final String SECONDARY_RANK_COMMENT_PULL_NUM = "rank_comment_pull_num";
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
  public static final String SECONDARY_RECOMMAND_UPLOAD_FOR_FEEDS_BABY_ICON_URL = "recommandUploadForFeedsBabyIconUrl";
  public static final String SECONDARY_RECOMMAND_UPLOAD_FOR_FEEDS_BTN_COLOR_FOR_BABY = "recommandUploadForFeedsBtnColorForBaby";
  public static final String SECONDARY_RECOMMAND_UPLOAD_FOR_FEEDS_BTN_COLOR_FOR_OTHER = "recommandUploadForFeedsBtnColorForOther";
  public static final String SECONDARY_RECOMMAND_UPLOAD_FOR_FEEDS_MINIMAL_SHOW_COUNT = "recommandUploadForFeedsMinimalShowCount";
  public static final String SECONDARY_RECOMMAND_UPLOAD_FOR_FEEDS_MULTI_ICON_URL = "recommandUploadForFeedsMultiIconUrl";
  public static final String SECONDARY_RECOMMAND_UPLOAD_FOR_FEEDS_SCHEMA_BACKUP = "recommandUploadForFeedsSchemaBackup";
  public static final String SECONDARY_RECOMMAND_UPLOAD_FOR_FEEDS_TRAVEL_ICON_URL = "recommandUploadForFeedsTravelIconUrl";
  public static final String SECONDARY_RECOMMEND_BANNER_CHECK_DISPLAY_INTERVAL = "RecommendBannerCheckDisplayInterval";
  public static final int SECONDARY_RECOMMEND_BANNER_CHECK_DISPLAY_INTERVAL_DEFAULT = 3;
  public static final String SECONDARY_RECOMMEND_VIDEO_TIP = "RecommendVideoTip";
  public static final String SECONDARY_REDPOCKET_HEIGHT = "RedPocket_height";
  public static final String SECONDARY_REDPOCKET_PAYLIST = "RedPocketPayList";
  public static final String SECONDARY_REDPOCKET_PLUS_ENTRY_TEXT = "redpocketPlusEntryText";
  public static final String SECONDARY_REDPOCKET_REQUEST_TIME_OUT = "redpocketRequestTimeOut";
  public static final String SECONDARY_REDPOCKET_WIDTH = "RedPocket_Width";
  public static final String SECONDARY_REDPOCKT_INTOOLS = "secondRedPockedtIntools";
  public static final String SECONDARY_REFRESH_INTERVAL = "FriendFeedRefreshInternal";
  public static final String SECONDARY_REFRESH_INTERVAL2 = "FriendFeedRefreshInternal2";
  public static final String SECONDARY_REGULAR_HTTP2_GRAY_CONFIG = "http2GrayConfig";
  public static final String SECONDARY_REOPEN_QZONE = "ReopenQzone";
  public static final String SECONDARY_REPORT = "Report";
  public static final String SECONDARY_REPORT_BACKGROUDMONITOR = "report_backgroudmonitor";
  public static final String SECONDARY_REQUEST_AIO_FEEDS_AND_SIGNATURE_LEAST_INTERVAL_TIME = "aioFeedsAndSingnatureLeastIntervalTime";
  public static final String SECONDARY_REQUEST_AIO_FEEDS_DIV = "requestAIOFeedsDiv";
  public static final String SECONDARY_REQUEST_AIO_QCIRCLE_FEEDS_DIV = "requestAIOQCircleFeedsDiv";
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
  public static final String SECONDARY_SHAREWX_MULTIPIC = "wxshare_multipic";
  public static final String SECONDARY_SHARE_ALBUM_ALLOW_INVITE_TO_FEEDS = "ShareAlbumAllowInviteToFeeds";
  public static final String SECONDARY_SHARE_ALBUM_IGNORPERMISSION = "AlbumShareIgnorePermission";
  public static final String SECONDARY_SHARE_ALBUM_INVITE_TO_FEEDS_URL = "shareAlbumInviteToFeedsUrl";
  public static final String SECONDARY_SHARE_ALBUM_JOIN_TIME = "shareAlbumJoinTime";
  public static final String SECONDARY_SHARE_ALBUM_TO_MINIPROGRAM = "AlbumShareToMiniProgram";
  public static final String SECONDARY_SHARE_BATCH_PHOTO_TO_MINIPROGRAM = "ShareBatchPhotoToMiniProgram";
  public static final String SECONDARY_SHARE_STRUCT_LONG_MESSAGE = "canShareStructLongMessage";
  public static final String SECONDARY_SHARE_WHITE_LIST = "sharewhitelist";
  public static final String SECONDARY_SHORT_VIDEO_CAN_UPLOAD_DURATION_THRESHOLD = "VideoCanUploadDurationThreshold";
  public static final String SECONDARY_SHORT_VIDEO_CAN_UPLOAD_SIZE_THRESHOLD = "VideoCanUploadSizeThreshold";
  public static final String SECONDARY_SHORT_VIDEO_DURATION_THRESHOLD = "VideoDurationThreshold";
  public static final String SECONDARY_SHOULD_SHARE_PARTNER_SHOW_ADD_ICON = "ShouldSharePartnerShowAddIcon";
  public static final String SECONDARY_SHOW_DELICACY_PICTURE = "ShowMoreDelicacyPicture";
  public static final String SECONDARY_SHOW_ENTER_LIVE_SECONDS = "ShowEnterLiveSeconds";
  public static final String SECONDARY_SHOW_FEED_GAME_TAB = "ShowNavigatorGameTab";
  public static final String SECONDARY_SHOW_FEED_OPERATION_LAYER = "ShowFeedOpLayer";
  public static final String SECONDARY_SHOW_FLOAT_ENTRANCE = "ShowFloatEntrance";
  public static final String SECONDARY_SHOW_FLOAT_ENTRANCE_DEAFULT = "1";
  public static final String SECONDARY_SHOW_MAGIC_STICK = "ShowMagicStick";
  public static final String SECONDARY_SHOW_RECOMMEND_PAGE_ENTRY = "ShowRecommendPageEntry";
  public static final String SECONDARY_SHOW_SHOP_ENTRANCE = "ShowShopConfigEntrance";
  public static final String SECONDARY_SHOW_SHOP_ENTRANCE_DEFAULT = "0";
  public static final String SECONDARY_SHOW_SIGNIN_BANNER = "ShowSigninBanner";
  public static final String SECONDARY_SHUOSHUO_CAMERA_ICON = "secondary_shuoshuo_camera_icon";
  public static final String SECONDARY_SHUOSHUO_NEWCARD_SHOW_VIEW = "showNewCardHeadTitle";
  public static final String SECONDARY_SHUOSHUO_SHOW_WEBPICTURE = "ShuoshuoShowWebPicture";
  public static final String SECONDARY_SHUOSHUO_TOOLBAR_SHOW_DONGGANYINGJI = "shuoshuoShowDongganyingji";
  public static final String SECONDARY_SHUOSHUO_UPLOAD_VIDEO_MAX_COUNT = "ShuoShuoMaxSelectVideoNum";
  public static final String SECONDARY_SIGN_IN = "SignIn";
  public static final String SECONDARY_SIM_QUERY = "SimQueryTimeout";
  public static final String SECONDARY_SIM_QUERY_DELAY = "SimQueryDelay";
  public static final String SECONDARY_SIM_QUERY_STATUS = "SimQueryStatus";
  public static final String SECONDARY_SIM_QUERY_USING_MIG_SDK = "SimQueryUsingMigSDK";
  public static final String SECONDARY_SMALL_GAME_HTML_LOAD_MTA_REPORT_ENABLE = "SmallGameHtmlLoadMtaReportEnable";
  public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_ANIMATION_GAP = "qzoneSmartBeautifyImageAnimGAP";
  public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_ANIMATION_RES_MD5 = "qzoneSmartBeautifyImageAnimResMd5";
  public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_ANIMATION_RES_URL = "qzoneSmartBeautifyImageAnimResUrl";
  public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_CHECKED_STATUS = "qzoneSmartBeautifyImageCheckedStatus";
  public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_CREATE_TIME_DIFF_MIN = "qzoneSmartBeautifyImageCreateTimeDiffMin";
  public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_MAX_EXPOSURE_TIMES = "qzoneSmartBeautifyImageMaxExposureTimes";
  public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_MAX_WAIT_TIME = "qzoneSmartBeautifyImageMaxWaitTime";
  public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_NUM_MAX = "qzoneSmartBeautifyImageNumMax";
  public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_NUM_MIN = "qzoneSmartBeautifyImageNumMin";
  public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_RECOMM = "qzoneSmartBeautifyImageRecomm";
  public static final String SECONDARY_SMART_BEAUTIFY_IMAGE_SCAN_TAG = "qzoneSmartBeautifyImageScanTag";
  public static final String SECONDARY_SMART_DNSSERVICE = "SmartHttpDnsService";
  public static final String SECONDARY_SMART_REPORT_Data_Acquisition_CONFIG = "SmartReportDataAcquisitionConfig";
  public static final String SECONDARY_SOUND_EFFECT_SWITCH = "FeedsSoundEffectSwitch";
  public static final String SECONDARY_SPECIALPUSH_HIDE = "SpecialPushHide";
  public static final String SECONDARY_SPECIAL_CARD_FRIEND_MANAGER_PAGE = "SpecialFriendManage";
  public static final String SECONDARY_SQL_ENABLE_WAL = "enablewal";
  public static final String SECONDARY_STARTUP_FAILED_MSG = "qzone_startup_fail_msg";
  public static final String SECONDARY_STARTUP_FAILED_NEED_UPLOAD_LOG = "qzone_startup_failed_need_upload_log";
  public static final String SECONDARY_STARTUP_FAILED_TOAST_SHOW_LIMIT = "qzone_startup_failed_toast_show_limit";
  public static final String SECONDARY_START_SHOW_ENTER_LIVE_HINT = "StartShowEnterLiveHint";
  public static final String SECONDARY_STAR_VIP_MAIN_PAGE_URL = "StarVipUrl";
  public static final String SECONDARY_STAR_VIP_PAY_URL = "StarVipMainPageUrl";
  public static final String SECONDARY_SUBPERSONAL_HOMEPAGE_URL = "SubPersonalHomePageUrl";
  public static final String SECONDARY_SUB_SHOW_FEED_LIST = "SubShowFeedList";
  public static final String SECONDARY_SUPERCOVER_CPU_LEVEL = "SuperCoverCpuLevel";
  public static final String SECONDARY_SUPERCOVER_MEMORY_LEVEL = "SuperCoverMemoryLevel";
  public static final String SECONDARY_SUPERCOVER_PERFORMANCE_4CORE_CPU_RAM_SIZE = "SuperCoverStandard4CoreCpuRamSize";
  public static final String SECONDARY_SUPERCOVER_PERFORMANCE_CPU_CORE = "SuperCoverStandardCpuCore";
  public static final String SECONDARY_SUPERCOVER_PERFORMANCE_CPU_FEQUENCY = "SuperCoverStandardCpuFequency";
  public static final String SECONDARY_SUPERCOVER_PERFORMANCE_CPU_RAM_SIZE = "SuperCoverStandardCpuRamSize";
  public static final String SECONDARY_SUPER_FONT_LIST_ATTACH_INFO = "DiySuperFontAttachinfo";
  public static final String SECONDARY_SUPER_HIGH_PHONE_FRICITION = "SuperHighPhoneFriction";
  public static final String SECONDARY_SUPER_RESOLUTION_BENCHMARK_EXPIRE_TIME = "superResolutionBenchmarkExpireTime";
  public static final String SECONDARY_SUPER_RESOLUTION_CPU_SO_LENGTH = "superResolutionCpuSoLength";
  public static final String SECONDARY_SUPER_RESOLUTION_CPU_SO_LENGTH_64 = "superResolutionCpuSoLength_64";
  public static final String SECONDARY_SUPER_RESOLUTION_CPU_SO_MD5 = "superResolutionCpuSoMd5";
  public static final String SECONDARY_SUPER_RESOLUTION_CPU_SO_MD5_64 = "superResolutionCpuSoMd5_64";
  public static final String SECONDARY_SUPER_RESOLUTION_DEFAULT_MODEL_ID = "superResolutionDefaultModelId";
  public static final String SECONDARY_SUPER_RESOLUTION_ENABLE_HIGH_SCALE = "superResolutionEnableHighScale";
  public static final String SECONDARY_SUPER_RESOLUTION_ENABLE_PRE_INIT_LIBRARY = "superResolutionEnablePreInitLibrary";
  public static final String SECONDARY_SUPER_RESOLUTION_ENABLE_REPORT_NONE_SR_TIME = "enableReportNoneSrTime";
  public static final String SECONDARY_SUPER_RESOLUTION_GPU_MAX_SIZE = "superResolutionGpuMaxSize";
  public static final String SECONDARY_SUPER_RESOLUTION_GPU_RATIO_BOUNDARY = "superResolutionGpuRatioBoundary";
  public static final String SECONDARY_SUPER_RESOLUTION_GPU_SO_LENGTH = "superResolutionGpuSoLength";
  public static final String SECONDARY_SUPER_RESOLUTION_GPU_SO_LENGTH_64 = "superResolutionGpuSoLength_64";
  public static final String SECONDARY_SUPER_RESOLUTION_GPU_SO_MD5 = "superResolutionGpuSoMd5";
  public static final String SECONDARY_SUPER_RESOLUTION_GPU_SO_MD5_64 = "superResolutionGpuSoMd5_64";
  public static final String SECONDARY_SUPER_RESOLUTION_HIGH_SCALE_TIPS = "superResolutionHighScaleTips";
  public static final String SECONDARY_SUPER_RESOLUTION_MEMORY_THRESHOLD = "superResolutionMemoryThreshold";
  public static final String SECONDARY_SUPER_RESOLUTION_MODEL_CONFIG = "superResolutionModelConfig";
  public static final String SECONDARY_SUPER_RESOLUTION_NNPACK_SO_LENGTH = "superResolutionNnpackSoLength";
  public static final String SECONDARY_SUPER_RESOLUTION_NNPACK_SO_LENGTH_64 = "superResolutionNnpackSoLength_64";
  public static final String SECONDARY_SUPER_RESOLUTION_NNPACK_SO_MD5 = "superResolutionNnpackSoMd5";
  public static final String SECONDARY_SUPER_RESOLUTION_NNPACK_SO_MD5_64 = "superResolutionNnpackSoMd5_64";
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
  public static final String SECONDARY_TENCENT_VIDEO_REQUEST_LEVEL_BLACKLIST_MODELS = "hevcLevelBlacklistModels";
  public static final String SECONDARY_TENCENT_VIDEO_REQUEST_LEVEL_BLACKLIST_OSVERSION = "hevcLevelBlacklistOSVersion";
  public static final int SECONDARY_TENCENT_VIDEO_REQUEST_LEVEL_DEFAULT = 26;
  public static final String SECONDARY_TEXT_TO_BITMAP = "TextToBitmap";
  public static final String SECONDARY_THIRD_WEB_DOWNLOAD = "ThirdWebDownLoad";
  public static final String SECONDARY_THREAD_REGULATED_ENABEL = "threadRegulateEnable";
  public static final String SECONDARY_TIANTAI_CAN_PRE_OPEN_WEBVIEW = "CanPreOpenWebview";
  public static final String SECONDARY_TIANTAI_HIDE_WIDGET_DISTANCE = "TiantaiHideWidgetDistance";
  public static final String SECONDARY_TIANTAI_IMAGE_GUIDE_MARGIN_BOTTOM = "TiantaiImageGuideMarginBottom";
  public static final String SECONDARY_TIANTAI_IMAGE_SCROLL_MIN = "TiantaiImageScrollMin";
  public static final String SECONDARY_TIANTAI_PULL_SHOW_ALL_DISTANCE = "TiantaiPullShowAllDistance";
  public static final String SECONDARY_TIME_DELAY_TO_GET_GUIDE_QBOSS_ADV = "time_delay_to_get_guide_qboss_adv";
  public static final String SECONDARY_TISSUE_BASELIB_URL = "tissue_baselib_url";
  public static final String SECONDARY_TOUCHQZONE_BLOG = "TouchQzoneBlog";
  public static final String SECONDARY_TOUCHQZONE_GIFT = "TouchQzoneGift";
  public static final String SECONDARY_TOUCHQZONE_MOOD = "TouchQzoneMood";
  public static final String SECONDARY_TOUCHQZONE_MSGB = "TouchQzoneMsgb";
  public static final String SECONDARY_TOUCHQZONE_OTHER = "TouchQzoneOther";
  public static final String SECONDARY_TOUCHQZONE_PHOTO = "TouchQzonePhoto";
  public static final String SECONDARY_TOUCHQZONE_PROFILE = "TouchQzoneProfile";
  public static final String SECONDARY_TOUCHQZONE_SHARE = "TouchQzoneShare";
  public static final String SECONDARY_TRAVELING_BOTTOM_PHOTO = "TravelingBottomPhoto";
  public static final String SECONDARY_TRIGGER_TURN_TO_LOW_VIDEO = "secondary_trigger_turn_to_low_video";
  public static final int SECONDARY_TRIGGER_TURN_TO_LOW_VIDEO_DEFAULT = 3;
  public static final String SECONDARY_TROOP_KEYWORD_AIO_FRESH_FREQUENCY = "SK_QQ_VAS_KeywordAIORefreshFrequency";
  public static final String SECONDARY_TRUE_TYPE_VIEW_CACHE = "TrueTypeViewCache";
  public static final String SECONDARY_TTPIC = "ttpicPopupMenuSwitch";
  public static final String SECONDARY_TTPIC_DATOU = "ttpicOpenSticker";
  public static final String SECONDARY_TTPIC_LIMITED = "PituLimited";
  public static final String SECONDARY_TTPIC_SO_ZIP_URL = "TtpicSoZipUrl";
  public static final String SECONDARY_TTPIC_SO_ZIP_URL_DEFAULT = "https://qzonestyle.gtimg.cn/qzone/photo/v7/js/common/images/lib_ttpic_so.zip";
  public static final String SECONDARY_UGC_LIVEVIDEO_PRE_LOAD_ENTER_ROOM_IP_ENABLE = "UGCLiveVideoPreLoadEnterRoomIpEnable";
  public static final int SECONDARY_UGC_LIVEVIDEO_PRE_LOAD_ENTER_ROOM_IP_ENABLE_DEFAULT = 1;
  public static final String SECONDARY_UGC_PERMIT_SETTING = "UgcPermitSetting";
  public static final String SECONDARY_UNION_VIP_FEED_URL = "union_vip_feed_icon_url";
  public static final String SECONDARY_UNION_VIP_HEAD_URL = "union_vip_head_icon_url";
  public static final String SECONDARY_UNION_VIP_HOME_URL = "union_vip_home_url";
  public static final String SECONDARY_UNION_VIP_PAY_URL = "union_vip_pay_url";
  public static final String SECONDARY_UNION_VIP_WIDGET_URL = "union_vip_widget_url";
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
  public static final String SECONDARY_UPLOAD_ENABLE_V6_ROUTE = "UploadEnableV6Route";
  public static final String SECONDARY_UPLOAD_ENABLE_V6_ROUTE_FOR_ALL = "UploadEnableV6RouteForAll";
  public static final String SECONDARY_UPLOAD_ENABLE_V6_TTT_REPORT = "UploadEnableV6TTTreport";
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
  public static final String SECONDARY_UPLOAD_PHOTO_PAGE_TIP = "isShowuploadPhotoYellowDiamondPhto";
  public static final String SECONDARY_UPLOAD_PREUPLOAD_COUNT_2G = "PreloadCount2G";
  public static final String SECONDARY_UPLOAD_PREUPLOAD_COUNT_3G = "PreloadCount3G";
  public static final String SECONDARY_UPLOAD_PREUPLOAD_COUNT_WIFI = "PreloadCountWifi";
  public static final String SECONDARY_UPLOAD_RECORD_VIDEO_WITH_MIX_MODE = "UploadRecordVideoWithMixMode";
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
  public static final String SECONDARY_UPLOAD_VIDEO_PART_RETRY_COUNT = "VideoPartRetryCount";
  public static final String SECONDARY_URL_ANALYSIS = "UrlAnalysisSwitch";
  public static final String SECONDARY_USC_ALL_FUNCTION_MASK = "USCAllFunctionMask";
  public static final String SECONDARY_USC_BATCH_PRIORITY = "USCBatchPriority";
  public static final String SECONDARY_USC_BUSINESS_ALL_FUNCTION_MASK = "USCBusinessAllFunctionMask";
  public static final String SECONDARY_USC_CPU_CORES = "USCCPUCores";
  public static final String SECONDARY_USC_CPU_THRESHOLD = "USCCpuThreshold";
  public static final String SECONDARY_USC_EXIF_COMPATIBLE_VERSION = "USCExifCompatibleVersion";
  public static final String SECONDARY_USC_EXIF_CURRENT_VERSION = "USCExifCurrentVersion";
  public static final String SECONDARY_USC_EXIF_ENABLE = "USCExifEnable";
  public static final String SECONDARY_USC_FORBIDDEN_DIR = "USCForbiddenDir";
  public static final String SECONDARY_USC_HIGH_MEMORY_THRESHOLD = "USCHighMemoryThreshold";
  public static final String SECONDARY_USC_JAVA_VM_MEMORY_THRESHOLD = "USCJavaVMMemoryThreshold";
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
  public static final String SECONDARY_USE_QQ_EMOTICON_COMMENT = "UseQQEmoticonComment";
  public static final String SECONDARY_VERIFY_QQ_VIDEO = "VerifyQQVideo";
  public static final String SECONDARY_VERTICAL_DOWNLOAD_PROGRESS_BACKGROUND_URL = "VerticalDownloadProgressBackgroundUrl";
  public static final String SECONDARY_VERTICAL_DOWNLOAD_PROGRESS_BACKGROUND_URL_FROM_VS = "VerticalDownloadProgressBackgroundUrlFromVS";
  public static final String SECONDARY_VERTICAL_PLUGIN_DOWNLOAD_CANCELED_ON_CLOSE_BTN = "PluginDownloadCanceledOnCloseBtn";
  public static final String SECONDARY_VERTICAL_PLUGIN_DO_NOT_CHECK_QZONE_PLUGIN = "VerticalPluginDoNotCheckQZonePlugin";
  public static final String SECONDARY_VERTICAL_USE_QQ_MANAGER = "verticalUseQQPluginManager";
  public static final String SECONDARY_VERTICAL_VIDEO_LAYER_DISABLE_UPLOAD_USER_ACTION = "VerticalVideoLayerDisableUploadUserAction";
  public static final String SECONDARY_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_CANCEL_MSG = "VerticalVideoLayerGuideDialogCancelMsg";
  public static final String SECONDARY_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_MSG = "VerticalVideoLayerGuideDialogMsg";
  public static final String SECONDARY_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_OK_MSG = "VerticalVideoLayerGuideDialogOkMsg";
  public static final String SECONDARY_VERTICAL_VIDEO_LAYER_GUIDE_DIALOG_TITLE = "VerticalVideoLayerGuideDialogTitle";
  public static final String SECONDARY_VERTICAL_VIDEO_LAYER_GUIDE_SCHEME = "VerticalVideoLayerGuideScheme";
  public static final String SECONDARY_VERTICAL_VIDEO_LAYER_LOW_MEMORY = "VerticalVideoLayerLowMemory";
  public static final String SECONDARY_VERTICAL_VIDEO_PLUGIN_SIZE_TEXT = "VerticalVideoPluginSizeText";
  public static final String SECONDARY_VERTICAL_VIDEO_PLUGIN_UPDATE_TIPS = "VerticalVideoPluginUpdateTips";
  public static final String SECONDARY_VIDEOALBUM_ALBUM_SWITCH_ON_INTRO = "videoAlbumAlbumSwitchOnIntro";
  public static final String SECONDARY_VIDEOALBUM_ALBUM_SWITCH_Off_INTRO = "videoAlbumAlbumSwitchOffIntro";
  public static final String SECONDARY_VIDEOALBUM_ALBUM_SWITCH_TITLE = "videoAlbumAlbumSwitchTitle";
  public static final String SECONDARY_VIDEOALBUM_DEMO_COVER_URL = "videoAlbumDemoCoverUrl";
  public static final String SECONDARY_VIDEOALBUM_DEMO_MP4_URL = "videoAlbumDemoMp4Url";
  public static final String SECONDARY_VIDEOALBUM_VIDEO_SWITCH_OFF_INTRO = "videoAlbumVideoSwitchOffIntro";
  public static final String SECONDARY_VIDEOALBUM_VIDEO_SWITCH_ON_INTRO = "videoAlbumVideoSwitchOnIntro";
  public static final String SECONDARY_VIDEOALBUM_VIDEO_SWITCH_TITLE = "videoAlbumVideoSwitchTitle";
  public static final String SECONDARY_VIDEOEDIT_LOAD_VIDEO_FIALED_RETURN_CODE = "VideoLoadErrorReturnCode";
  public static final String SECONDARY_VIDEOEDIT_UPLOAD_MAX_SIZE_TIP_WITH_NO_WIFI = "UploadMaxSizeTipWithNoWifi";
  public static final String SECONDARY_VIDEOEDIT_VIDEOBGMUSIC_SELECTURL = "VideoBgMusicSelectUrl";
  public static final String SECONDARY_VIDEOEDIT_VIP_QUALITY_LIMIT_SIZE = "VipQualityLimitSize";
  public static final String SECONDARY_VIDEO_AUTO_PLAY_TIPS = "VideoAutoPlayTips";
  public static final String SECONDARY_VIDEO_CACHE_PROVIDER = "videoCacheProvider";
  public static final int SECONDARY_VIDEO_CACHE_PROVIDER_DEFAULT = 1;
  public static final String SECONDARY_VIDEO_CACHE_SIZE_RATE_TIMEOUT = "GetVideoCacheSizeTimeout";
  public static final String SECONDARY_VIDEO_CHANGE_VKEY_WAIT_TIMEOUT = "WaitVkeyTimeout";
  public static final String SECONDARY_VIDEO_CHECK_FEEDS = "checkVideoFeeds";
  public static final String SECONDARY_VIDEO_CHECK_RECOMMEND = "checkVideoRecommend";
  public static final String SECONDARY_VIDEO_COMPRESS_SW_TRIM_AVERAGE_SPEED = "videoCompressSwTrimAverageSpeed";
  public static final String SECONDARY_VIDEO_COMPRESS_TIMEOUT_RECORD = "videoCompressTimeoutRecord";
  public static final String SECONDARY_VIDEO_COMPRESS_TIMEOUT_TRIM = "videoCompressTimeoutTrim";
  public static final String SECONDARY_VIDEO_CONTENT_TYPE = "videoContentType";
  public static final String SECONDARY_VIDEO_COVER_DURATION = "VideoCoverDuration";
  public static final String SECONDARY_VIDEO_COVER_RECORD_DURATION = "VideoCoverRecordDuration";
  public static final String SECONDARY_VIDEO_DEFAULT_DATASOURCE_TYPE = "videoDefaultDataSourceType";
  public static final String SECONDARY_VIDEO_DEFINITION_MOBILE_CONN = "videodefinitionmobileconn";
  public static final String SECONDARY_VIDEO_DEFINITION_WIFI = "videodefinitionwifi";
  public static final String SECONDARY_VIDEO_DISPLAY_FOLLOW_BUTTON = "displayFollowButtonInVideoLayer";
  public static final String SECONDARY_VIDEO_ENABLE_ACTIVITY_DEFAULT_DETAIL_REPORT = "videoEnableActivityDefaultDetailReport";
  public static final String SECONDARY_VIDEO_ENABLE_CACHE = "videoEnableCache";
  public static final String SECONDARY_VIDEO_ENABLE_LOAD_LOCAL_DNS = "enblelocaldns";
  public static final String SECONDARY_VIDEO_ENABLE_NONE_WIFI_DOWNLOAD = "enbleNoneWifiDownload";
  public static final String SECONDARY_VIDEO_ENABLE_PROXY = "videoEnableProxy";
  public static final String SECONDARY_VIDEO_ENABLE_WEISHI_DIRECT_IP = "enableWeishiDirectIp";
  public static final String SECONDARY_VIDEO_FLOAT_CONTROLLER_TIMEOUT = "videoFloatControllerTimeout";
  public static final String SECONDARY_VIDEO_FOOTER = "videoFooter";
  public static final String SECONDARY_VIDEO_FORCE_HW_COMPRESS_LIST = "ForceHwCompressList";
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
  public static final String SECONDARY_VIDEO_LEVEL_TYPE = "secondary_video_level_type";
  public static final int SECONDARY_VIDEO_LEVEL_TYPE_DEFAULT = 10;
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
  public static final String SECONDARY_VIDEO_NEWPARAM_ALL = "VideoNewVideoCompressParamAll";
  public static final String SECONDARY_VIDEO_NEXT_PLAYID_TIME_STAMP = "ResumePlayReportMinTime";
  public static final String SECONDARY_VIDEO_NORMAL_PATH_TYPE = "videoNormalPathType";
  public static final String SECONDARY_VIDEO_ON_CLOUD_HOSTS = "videoOnCloudHosts";
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
  public static final String SECONDARY_VIDEO_SUPER_PLAYER_ENABLED = "videoSuperPlayerEnabled";
  public static final String SECONDARY_VIDEO_SUPER_PLAYER_INJECT_FULL_LOG = "videoSuperPlayerInjectFullLog";
  public static final String SECONDARY_VIDEO_SUPER_PLAYER_UIN_POSTFIX = "videoSuperPlayerUinPostfix";
  public static final String SECONDARY_VIDEO_SUPPORT_MULTITHREAD = "videoTrimSupportMultiThread";
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
  public static final String SECONDARY_VIDEO_TVK_HOST = "videoTvkHost";
  public static final String SECONDARY_VIDEO_UGC_SHOW_TOP_BAR = "VideoFloatUGCShowTopBar";
  public static final String SECONDARY_VIDEO_UPLOAD_BAK_IP = "BackupIP_VIDEOUP";
  public static final String SECONDARY_VIDEO_UPLOAD_HOST_IP = "VideoURL_UP";
  public static final String SECONDARY_VIDEO_UPLOAD_OPT_IP = "OptimumIP_VIDEOUP";
  public static final String SECONDARY_VIDEO_UPLOAD_OPT_IP_V6 = "OptimumIP_VIDEOUPV6";
  public static final String SECONDARY_VIDEO_UPLOAD_QUALITY_ORG_LIMIT = "FileSizeLimitForShowOrigVideo";
  public static final String SECONDARY_VIDEO_USE_WNS_CGI = "videoUseWnsCgi";
  public static final String SECONDARY_VIDEO_VKEY_TIMEOUT = "videoVkeyTimeOut";
  public static final String SECONDARY_VIDEO_WEISHI_PATH_TYPE = "videoWeishiPathType";
  public static final String SECONDARY_VIDEO_WEISHI_PRELOADTIMEOUTSECOND = "VideoWeishiPreloadTimeoutSecond";
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
  public static final String SECONDARY_VISITOR_PAGE_JUMPQZONE_SCHEME_ENABLE = "VisitorPageJumpQZoneSchemeEnable";
  public static final String SECONDARY_VISITOR_REDPOCKET = "QzoneVisitorRedPocket";
  public static final String SECONDARY_VISITOR_SETTING = "SeeMyVisitorPersimmonSetting";
  public static final String SECONDARY_VISITOR_TAB_REDPCOKET_WARN_POP_BG = "secondVisitorTabRedPocketPopBg";
  public static final String SECONDARY_VISITOR_WEEK_REPORT_URL = "qzonevisitorweekreport";
  public static final String SECONDARY_VISITOR_WIDGET = "PersonalQzoneVisitor";
  public static final String SECONDARY_VISITOR_WIDGET_AVATAR_EACH_AVATAR_TIME_DURATION = "VisitorWidgetAvatarEachAvatarTimeDuration";
  public static final String SECONDARY_VISITOR_WIDGET_AVATAR_NOTICE_MAX_COUNT = "VisitorWidgetAvatarNoticeMaxCount";
  public static final String SECONDARY_VISITOR_WIDGET_SHOW_AVATAR_MAX_COUNT = "VisitorWidgetShowAvatarMaxCount";
  public static final String SECONDARY_VISIT_GUEST_ALBUM_TIME = "visitGuestAlbumTime";
  public static final String SECONDARY_VOICE_MOOD_ALLOW_VOICE_FORWARD = "AllowVoiceForward";
  public static final String SECONDARY_VOICE_MOOD_ALLOW_VOICE_MOOD = "AllowVoiceMood";
  public static final String SECONDARY_VOICE_MOOD_ALLOW_VOICE_OP = "AllowVoiceOP";
  public static final String SECONDARY_VOICE_SHUOSHUO_ANIMATION = "VoiceShuoshuoAnimation";
  public static final String SECONDARY_VOICE_SHUOSHUO_ANIMATION_LENGTH = "VoiceShuoshuoAnimationLength";
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
  public static final String SECONDARY_WEISHI_CAN_PRELOAD_FEED = "weishiCanPreloadFeed";
  public static final String SECONDARY_WEISHI_CAN_PRELOAD_PLUGIN = "weishiCanPreloadPlugin";
  public static final String SECONDARY_WEISHI_MAXCACHE_COUNT = "weishiCacheCount";
  public static final String SECONDARY_WEISHI_TAB_PRELOAD = "weishiTabPreload";
  public static final String SECONDARY_WEISHI_VIDEO_LONGESTEDGE = "WeishiVideoLongestEdge";
  public static final String SECONDARY_WEISHI_VIDEO_MAX_BITRATE = "WeishiVideoMaxBitrate";
  public static final String SECONDARY_WEIXIN_DOWNLOAD = "WeiXinDownload";
  public static final String SECONDARY_WHISPER_EGG = "WhisperEgg";
  public static final String SECONDARY_WIDGET_DETAIL_URL = "WidgetDetail";
  public static final String SECONDARY_WIFI_OPERATOR_CRARRY = "WifiCarrierType";
  public static final String SECONDARY_WOO_MAIN_ICON_NORMAL_URL = "WooNormalMainIconUrl";
  public static final String SECONDARY_WOO_MAIN_ICON_SCROLL_HIDE = "WooNormalMainIconScrollHide";
  public static final String SECONDARY_WRITE_BLOG = "WriteBlog";
  public static final String SECONDARY_X5RN_DISABLE_ANDROID_VER = "X5RNDisableAndroidVer";
  public static final String SECONDARY_X5RN_MIN_VERSION = "X5RNMinVer";
  public static final String SECONDAY_MEMOEY_OPERATE_FREQUENCY = "memory_operate_frequency";
  public static final String SECOND_KEY_ADJUST_PREDECODE_MEMORY_SIZE = "adjustPredecodeMemorySize";
  public static final String SECOND_KEY_CLEAR_STEP = "memory_clear_step";
  public static final String SECOND_KEY_EVENTWIDGET_WEBSO_PRELOAD = "eventwidget_webso_preload";
  public static final String SECOND_KEY_IMAGE_MANAGER_MEMORY_RESTRICTION = "argb8888MemoryRestriction";
  public static final String SECOND_KEY_IMAGE_MANAGER_USE_ARGB8888 = "useArgb8888";
  public static final String SECOND_KEY_MEMORY_ENABLE_SWITCH = "memory_enable";
  public static final int SELF_PRAISE_ANIMATION_SWITCH_OPEN = 1;
  public static final String SENCODARY_KEY_STARTUP_ENABLE = "startup_monitor_enable";
  public static final String SENCODARY_KEY_STARTUP_FAIL_TIMEOUT = "startupFailTimeout";
  public static final int SHARE_ALBUM_TO_WEIXIN_MINI_PROGRAM_NEED_SK = 1;
  public static final int SHARE_ALBUM_TO_WEIXIN_MINI_PROGRAM_NOT_NEED_SK = 0;
  public static final String SHOW_WEISHI_ICON_ANIMATION_TIME = "ShowWeishiIconAnimationTime";
  public static final int SMALL_GAME_HTML_LOAD_MTA_REPORT_ENABLE_DEFAULT = 1;
  public static final int SMART_BEAUTIFY_IMAGE_STATUS_CHECKED = 1;
  public static final String SP_KEY_PRELOAD_SMALL_GAME_FINISH = "key_qzone_preload_small_game_finish_";
  public static final String SP_KEY_PRELOAD_SMALL_GAME_TIMESTAMP = "key_qzone_preload_small_game_timestamp_";
  private static final String TAG = "QzoneConfig";
  public static final String TTT_REALTIME_REPORT_LIST = "TTTRealTimeReportList";
  public static final String TTT_REPORT_SETTING = "QzoneTTTReportSetting";
  public static final String USE_NEW_COMMAND = "use_new_command";
  public static final String WEBSO_DEFAULT_COMMAND_SETTING = "{\".qzone.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"web.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenter.websoh5\",\"msfCommand\":\"mqqweb.gamecenter.websoh5\"},\"m.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenterV2.h5\",\"msfCommand\":\"mqqweb.gamecenterV2.h5\"},\"mc.vip.qq.com\":{\"command\":\"mqqweb.mcvip.websoh5\",\"msfCommand\":\"mqqweb.mcvip.websoh5\"},\"zb.vip.qq.com\":{\"command\":\"mqqweb.zb.webso\",\"msfCommand\":\"mqqweb.zb.webso\"},\"vv.video.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\"qzpb.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\"vv6.video.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\".urlshare.cn\":{\"command\":\"qzoneh5.urlshare.webso\",\"msfCommand\":\"qzoneh5.urlshare.webso\"},\"now.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\"nearby.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\"h5.gdt.qq.com\":{\"command\":\"nemoh5.gdt.lp\",\"msfCommand\":\"nemoh5.gdt.lp\"},\"club.vip.qq.com\":{\"command\":\"qzoneh5.club.wnshtml\",\"msfCommand\":\"qzoneh5.club.wnshtml\"},\".q.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"ilive.qq.com\":{\"command\":\"iliveh5.ilive.wnshtml\",\"msfCommand\":\"iliveh5.ilive.wnshtml\"},\".ilive.qq.com\":{\"command\":\"iliveh5.ilive.wnshtml\",\"msfCommand\":\"iliveh5.ilive.wnshtml\"},\"qvideo.qq.com\":{\"command\":\"qvideoh5.qvideo.wnshtml\",\"msfCommand\":\"qvideoh5.qvideo.wnshtml\"},\".qvideo.qq.com\":{\"command\":\"qvideoh5.qvideo.wnshtml\",\"msfCommand\":\"qvideoh5.qvideo.wnshtml\"} }";
  public static final String YINGYONGBAO_SWITCH_PREFIX = "YingyongbaoSwitchPrefix";
  public static QzoneConfig instance;
  private ConcurrentHashMap<String, ConcurrentHashMap<String, String>> configMap = new ConcurrentHashMap();
  private ContentObserver configUpdateObserver;
  private volatile int loadstatus = 0;
  private ArrayList<WeakReference<QzoneConfig.QzoneConfigChangeListener>> mCallback = new ArrayList();
  private bkdz mStringHelper;
  
  static
  {
    DEFAULT_QFLUTTER_URL = "{\"key1\":\"https://mqq-plugin.qq.com/a696131d7cde6ad2c9aae156ec1d3b5a\",\"key2\":\"\",\"key3\":\"0.0.6\",\"key4\": {\"file_length\": 7786698},\"key5\":80}";
  }
  
  private QzoneConfig()
  {
    init();
  }
  
  public static String getBecomeNuanFriendToastText()
  {
    return getInstance().getConfig("QZoneSetting", "becomeNuanFriendToastText", amtj.a(2131716874));
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
  
  public static int getQCircleMaxCrashCount()
  {
    int i = getInstance().getConfig("qqcircle", "qqcricle_max_crash_count", 2);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "SECONDARY_QQCIRCLE_DISABLE_PLUGIN:" + i);
      }
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return i;
  }
  
  public static String getQCircleSplashLogoTextUrl()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_splash_guide_logo_text_url", null);
  }
  
  public static String getQCircleSplashLogoUrl()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_splash_guide_logo_url", null);
  }
  
  public static String getQQCircleAggreagteEmptyJumpTitle()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_aggreagte_empty_jump_title", "发布第一个作品");
  }
  
  public static String getQQCircleAggreagteEmptyText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_aggreagte_empty_text", "这片沃土空空如也\n等待你来开垦");
  }
  
  public static String getQQCircleAuthenticationErrorText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_authentication_error_text", "暂无权限\n去众推看看其他内容吧");
  }
  
  public static String getQQCircleAuthenticationErrorToastText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_authentication_error_toast_text", "暂无权限，去逛逛众推吧");
  }
  
  public static int getQQCircleCommentMaxWordsLimit()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_comment_max_words_limit", 100);
  }
  
  public static int getQQCircleDefaultShowTabType()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_default_show_tab_type", 6);
  }
  
  public static String getQQCircleDetailErrorContentDeletedText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_detail_error_content_deleted_text", "害！来晚一步\n这个内容已下落不明");
  }
  
  public static boolean getQQCircleEnableFolderPageCache()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_enable_folder_cache", 1) > 0;
  }
  
  public static boolean getQQCircleEnablePlayVideoInWorksTab()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_switch_play_video_in_works_tab", 1) == 1;
  }
  
  public static boolean getQQCircleEnableReuseFragment()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_enable_reuse_tab_fragment", 1) == 1;
  }
  
  public static boolean getQQCircleEnableTransitionCloseAnim()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_enable_transition_close_anim", 1) > 0;
  }
  
  public static boolean getQQCircleFeedMute()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_feed_mute", 0) == 1;
  }
  
  public static boolean getQQCircleFlutterSearchSwitch()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_enable_flutter_search", 1) == 1;
  }
  
  public static int getQQCircleFolderPageCacheLifeCycle()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_enable_folder_cache_life_cycle", 180);
  }
  
  public static int getQQCircleFollowTabUpdateNotificationShowInterval()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_follow_tab_reddot_show_interval", 15);
  }
  
  public static long getQQCircleGetFollowUserInternal()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_getfollowuser_internal", 43200000L);
  }
  
  public static String getQQCircleHomepageGuestListEmptyJumpTitle()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_homepage_guest_list_empty_jump_title", "探索更多小世界");
  }
  
  public static String getQQCircleHomepageGuestListEmptyText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_homepage_guest_list_empty_text", "这个小世界尚未启动\n你的目光早已启程");
  }
  
  public static String getQQCircleHomepageGuestProductEmptyJumpTitle()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_homepage_guest_product_empty_jump_title", "探索更多小世界");
  }
  
  public static String getQQCircleHomepageGuestProductEmptyText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_homepage_guest_product_empty_text", "这个小世界尚未启动\n你的目光早已启程");
  }
  
  public static String getQQCircleHomepageGuestPushEmptyJumpTitle()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_homepage_guest_push_empty_jump_title", "探索更多小世界");
  }
  
  public static String getQQCircleHomepageGuestPushEmptyText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_homepage_guest_push_empty_text", "这个小世界尚未启动\n你的目光早已启程");
  }
  
  public static String getQQCircleHomepageHostListEmptyJumpTitle()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_homepage_host_list_empty_jump_title", "发布第一个作品");
  }
  
  public static String getQQCircleHomepageHostListEmptyText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_homepage_host_list_empty_text", "生活的每一个瞬间\n都值得被记录");
  }
  
  public static String getQQCircleHomepageHostProductEmptyJumpTitle()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_homepage_host_product_empty_jump_title", "发布第一个作品");
  }
  
  public static String getQQCircleHomepageHostProductEmptyText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_homepage_host_product_empty_text", "生活的每一个瞬间\n都值得被记录");
  }
  
  public static String getQQCircleHomepageHostPushEmptyJumpTitle()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_homepage_host_push_empty_jump_title", "探索更多小世界");
  }
  
  public static String getQQCircleHomepageHostPushEmptyText()
  {
    return getInstance().getConfig("qqcircle", "当qqcircle_homepage_host_push_empty_text", "当你用心看这个世界\n这个世界也在用心回望你");
  }
  
  public static String getQQCircleHomepageInMyBlackListJumpTitle()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_homepage_inmyblacklist_jump_title", "编辑黑名单");
  }
  
  public static String getQQCircleHomepageInMyBlackListText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_homepage_inmyblacklist_text", "该用户在你的\n小世界黑名单中");
  }
  
  public static boolean getQQCircleIsOpenDanmaku()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_switch_danmaku", 1) == 1;
  }
  
  public static boolean getQQCircleJumpToNewPublish()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircleJumpToPublish", 1);
    QZLog.d("QzoneConfig", 1, new Object[] { "getQQCircleJumpToNewPublish... open:", Integer.valueOf(i) });
    return i == 1;
  }
  
  public static long getQQCircleJumpToNewPublishDelayTime()
  {
    long l = getInstance().getConfig("qqcircle", "secondary_qqcircle_jump_to_publish_delay_time", 2000);
    QZLog.d("QzoneConfig", 1, new Object[] { "getQQCircleJumpToNewPublishDelayTime... delayTime:", Long.valueOf(l) });
    return l;
  }
  
  public static int getQQCircleMaxPushCount()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_max_push_count", 10);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "getQQCircleMaxPushCount:" + i);
      }
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return i;
  }
  
  public static String getQQCircleMessagelistHostMessageEmptyJumpTitle()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_messagelist_host_message_empty_jump_title", "探索更多小世界");
  }
  
  public static String getQQCircleMessagelistHostMessageEmptyText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_messagelist_host_messag_empty_text", "没有你的消息\n世界从此慢慢疏离");
  }
  
  public static String getQQCircleMessagelistHostPrivateLetterEmptyJumpTitle()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_messagelist_host_privateletter_empty_jump_title", "探索更多小世界");
  }
  
  public static String getQQCircleMessagelistHostPrivateLetterEmptyText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_messagelist_host_privateletter_empty_text", "没有你的消息\n世界从此慢慢疏离");
  }
  
  public static String getQQCircleNoNetErrorText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_nonet_error_text", "无法连接小世界\n检查一下网络再试吧");
  }
  
  public static String getQQCircleNoNetErrorToastText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_nonet_error_toast_text", "无法连接小世界, 检查网络后再试试");
  }
  
  public static String getQQCirclePersonalDataEditH5Url()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_personal_data_edit_h5_url", "https://h5.qzone.qq.com/v2/wezone/addtag?_wv=3&_wwv=1&_proxy=1&addfrom=edit");
  }
  
  public static int getQQCirclePluginIntervalTime()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_getplugininfo_time", 300000);
  }
  
  public static int getQQCirclePushNotEnoughValue()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_push_not_enough_value", 3);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "getQQCircleMaxPushCount:" + i);
      }
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return i;
  }
  
  public static int getQQCircleQualityReportBufferLength()
  {
    return getInstance().getConfig("qqcircle", "quality_quality_report_buffer_length", 5);
  }
  
  public static long getQQCircleQualityReportInterval()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_quality_report_interval", 60);
  }
  
  public static boolean getQQCircleQualitySampleSwitchOpen()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_quality_sample_switch", 1) == 1;
  }
  
  public static String getQQCircleRecommendFollowH5Url()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_recommend_follow_h5_url", "https://h5.qzone.qq.com/v2/wezone/recommend/invite/{uid}/{invite_id}?_wv=3&_proxy=1");
  }
  
  public static int getQQCircleReportBufferLength()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_report_buffer_length", 10);
  }
  
  public static long getQQCircleReportInterval()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_report_interval", 10);
  }
  
  public static String getQQCircleSearchPageUrl()
  {
    String str = getInstance().getConfig("qqcircle", "qqcircle_search_page_url", "https://h5.qzone.qq.com/v2/wezone/search?_wwv=8192&_wv=3&_proxy=1&show_right_cancel=1&move_web_view_top=1");
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "getQQCircleSearchPageUrl:" + str);
      }
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str;
  }
  
  public static String getQQCircleServerErrorText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_server_error_text", "网络开小差了\n稍后再试试吧");
  }
  
  public static String getQQCircleServerErrorToastText()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_server_error_toast_text", "网络开小差了，稍后再试试吧");
  }
  
  public static boolean getQQCircleShareQzoneHeadIconForceUseHttp()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_share_qzone_head_icon_force_use_http", 1) == 1;
  }
  
  public static long getQQCircleShowBannerInterval()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_show_banner_interval", 10);
  }
  
  public static int getQQCircleShowShareQzone()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_show_share_qzone", 0);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "getQQCircleShowShareQzone:" + i);
      }
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return i;
  }
  
  public static String getQQCircleSplashGuideVideoDir()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_splash_guide_video_dir", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/848-Trailer/");
  }
  
  public static boolean getQQCircleTagToLayer()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_tag_to_layer", 1) == 1;
  }
  
  public static boolean getQQCircleTaskUseHippySwitch()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_task_use_hippy", 1) == 1;
  }
  
  public static boolean getQQCircleUseCircleHomeButton()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_homebutton_style", 2) == 1;
  }
  
  public static boolean getQQCircleUsePhoneSecurityAuth()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_verified_switch", 1) == 1;
  }
  
  public static String getQQcircleTagMedalImageUrlColour()
  {
    return getInstance().getConfig("qqcircle", "qqcricle_tag_medal_image_url_colour", "https://sola.gtimg.cn/aoi/sola/20200819105021_dQGv8tIe5a.png");
  }
  
  public static String getQQcircleTagMedalImageUrlGray()
  {
    return getInstance().getConfig("qqcircle", "qqcricle_tag_medal_image_url_gray", "https://sola.gtimg.cn/aoi/sola/20200819105021_x9nesSzJkY.png");
  }
  
  public static int getQcircleJumpDelayTime()
  {
    return getInstance().getConfig("qqcircle", "qqcircle_splash_guide_jump_delay_time", 2000);
  }
  
  private void init()
  {
    registObserver();
    registBroadcast();
    this.mStringHelper = new bkdz();
  }
  
  private void initConfigUpdateObserver()
  {
    if (this.configUpdateObserver == null) {
      this.configUpdateObserver = new QzoneConfig.2(this, null);
    }
  }
  
  public static boolean isEeveeSysTemPolling()
  {
    String str = aafs.a("qqcircle", "qqcircle_enable_eevee_polling", "1");
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "isEeveeSysTemPolling:" + str);
      }
      return "1".equals(str);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static boolean isEnableOpenDuliDetail()
  {
    if (getInstance().getConfig("QZoneSetting", "open_duli_detail", 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if (QZLog.isColorLevel()) {
        QZLog.e("QzoneConfig", 1, new Object[] { "open_duli_detial:" + bool });
      }
      return bool;
    }
  }
  
  public static boolean isEnablePickGameMates()
  {
    if (getInstance().getConfig("QZoneSetting", "isEnablePickGameMates", 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if (QZLog.isColorLevel()) {
        QZLog.e("QzoneConfig", 1, new Object[] { "isEnablePickGameMates:" + bool });
      }
      return bool;
    }
  }
  
  public static boolean isNeedSecureVerify()
  {
    if (getInstance().getConfigSync("QZoneSetting", "isNeedSecureVerify", 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if (QZLog.isColorLevel()) {
        QZLog.e("QzoneConfig", 1, new Object[] { "isNeedSecureVerify:" + bool });
      }
      return bool;
    }
  }
  
  public static boolean isNeedSecureVerifyAllBusiness()
  {
    if (getInstance().getConfigSync("WebviewSetting", "isNeedSecureVerifyAllBusiness", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if (QZLog.isColorLevel()) {
        QZLog.e("QzoneConfig", 1, new Object[] { "isNeedSecureVerifyAllBusiness:" + bool });
      }
      return bool;
    }
  }
  
  public static boolean isQCirclePluginDisable()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_disable_qcircle_plugin", 0);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "SECONDARY_QQCIRCLE_DISABLE_PLUGIN:" + i);
      }
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isQQCircleAutoPlay()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      return false;
      if (AppNetConnInfo.isWifiConn()) {
        return true;
      }
    } while ((getInstance().getConfig("qqcircle", "qqcircle_should_auto_play_when_wwan", 1) != 1) || ((AppNetConnInfo.getMobileInfo() != 3) && (AppNetConnInfo.getMobileInfo() != 4)));
    return true;
  }
  
  public static boolean isQQCircleShowAIOFeedEntrance()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_aio_feed", 1);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "isQQCircleShowAIOFeedEntrance:" + i);
      }
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isQQCircleShowDrawTabEntrance()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_drawer_tab", 0);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "isQQCircleShowDrawTabEntrance:" + i);
      }
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isQQCircleShowInviteGuideBubbleOnProfilePage()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_show_invite_guide_bubble_on_profile_page", 0);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "isQQCircleShowInviteGuideBubbleOnProfilePage:" + i);
      }
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isQQCircleShowLebaBySwitchButton()
  {
    String str = getInstance().getConfig("qqcircle", "qqcircle_entrance_enable", "1");
    try
    {
      QLog.e("QzoneConfig", 1, "isQQCircleShowLebaBySwitchButton:" + str);
      return str.equals("1");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static boolean isQQCircleShowLebaEntrance()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_recommend_tab", 0);
    try
    {
      QLog.e("QzoneConfig", 1, "isQQCircleShowLebaEntrance:" + i);
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isQQCircleShowMessageEntrance()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_message_tab", 0);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "isQQCircleShowMessageEntrance:" + i);
      }
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isQQCircleShowMessageEntranceTips()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_message_tab_tips", 1);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "isQQCircleShowMessageEntranceTips:" + i);
      }
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isQQCircleShowMoodSyncEntrance()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_show_mood_sync_circle", 0);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "isQQCircleShowMoodSyncEntrance:" + i);
      }
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isQQCircleShowProfileCardEntrance()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_profile_card", 0);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "isQQCircleShowProfileCardEntrance:" + i);
      }
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isQQCircleShowPublishSaveGridSelected()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_show_publish_save_grid_selected", 1);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "isQQCircleShowPublishSaveGridSelected:" + i);
      }
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isQQCircleShowSwitchButton()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_show_entrance_switch_button", 1);
    try
    {
      QLog.e("QzoneConfig", 1, "isQQCircleShowLebaEntrance switchbutton:" + i);
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isQQCircleShowTroopToolBarEntrance()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_group_toolbar", 0);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "isQQCircleShowTroopToolBarEntrance:" + i);
      }
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isQQCircleShowTroopUnreadRedDot()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_show_group_aio_redpoint", 0);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "isQQCircleShowTroopUnreadDialog:" + i);
      }
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isQQCircleUseEeveeRedPoint()
  {
    return "1".equals(aafs.a("qqcircle", "qqcircle_use_eevee_red_point", "1"));
  }
  
  private void registBroadcast()
  {
    if ((BaseApplication.getContext() != null) && (BaseApplication.getContext().getContentResolver() != null))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      localIntentFilter.addAction("mqq.intent.action.LOGOUT");
      localIntentFilter.addAction("mqq.intent.action.LOGIN");
      BaseApplicationImpl.getApplication().registerReceiver(new QzoneConfig.3(this), localIntentFilter);
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
  
  public static boolean useQCircleAssetPluginAlways()
  {
    int i = getInstance().getConfig("qqcircle", "qqcircle_use_asset", 0);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 1, "isUseAssetPlugin always:" + i);
      }
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
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
    Object localObject;
    if ((paramString1 != null) && (paramString2 != null))
    {
      if ((this.mStringHelper != null) && (this.mStringHelper.a()))
      {
        paramString1 = this.mStringHelper.a(paramString1);
        localObject = this.mStringHelper.a(paramString2);
        paramString2 = paramString1;
      }
      for (paramString1 = (String)localObject;; paramString1 = (String)localObject)
      {
        ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.configMap.get(paramString2);
        localObject = localConcurrentHashMap;
        if (localConcurrentHashMap == null)
        {
          localObject = new ConcurrentHashMap();
          this.configMap.put(paramString2, localObject);
        }
        if (localObject == null) {
          break;
        }
        localObject = (String)((ConcurrentHashMap)localObject).get(paramString1);
        if ((localObject == null) && (2 != this.loadstatus) && (1 != this.loadstatus))
        {
          QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new QzoneConfig.1(this));
          QLog.d("QzoneConfig", 4, "key:" + paramString2 + ",secondaryKey:" + paramString1 + ",value:" + (String)localObject + " key: notready");
        }
        try
        {
          if ("qqcircle".equals(paramString2)) {
            QLog.e("QzoneConfig", 1, "key = " + paramString2 + " secondaryKey= " + paramString1 + " value= " + (String)localObject);
          }
          return localObject;
        }
        catch (Throwable paramString1)
        {
          QLog.e("QzoneConfig", 1, paramString1, new Object[0]);
          return localObject;
        }
        paramString1 = paramString1.toLowerCase();
        localObject = paramString2.toLowerCase();
        paramString2 = paramString1;
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
  
  public boolean getConfig(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = getConfig(paramString1, paramString2);
    if (paramString1 == null) {
      return paramBoolean;
    }
    try
    {
      boolean bool = Boolean.parseBoolean(paramString1);
      return bool;
    }
    catch (Exception paramString1) {}
    return paramBoolean;
  }
  
  public float getConfigSync(String paramString1, String paramString2, float paramFloat)
  {
    paramString1 = getConfigSync(paramString1, paramString2);
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
  
  public int getConfigSync(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = getConfigSync(paramString1, paramString2);
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
  
  public long getConfigSync(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = getConfigSync(paramString1, paramString2);
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
  
  public String getConfigSync(String paramString1, String paramString2)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      if ((this.mStringHelper != null) && (this.mStringHelper.a()))
      {
        paramString1 = this.mStringHelper.a(paramString1);
        localObject = this.mStringHelper.a(paramString2);
        paramString2 = paramString1;
        paramString1 = (String)localObject;
        localObject = (ConcurrentHashMap)this.configMap.get(paramString2);
        if (localObject != null) {
          break label161;
        }
        localObject = new ConcurrentHashMap();
        this.configMap.put(paramString2, localObject);
      }
    }
    label161:
    for (;;)
    {
      if (localObject != null)
      {
        String str2 = (String)((ConcurrentHashMap)localObject).get(paramString1);
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
          paramString2 = aafs.b(paramString2, paramString1);
          str1 = paramString2;
          if (!TextUtils.isEmpty(paramString2))
          {
            ((ConcurrentHashMap)localObject).put(paramString1, paramString2);
            str1 = paramString2;
          }
        }
        return str1;
        paramString1 = paramString1.toLowerCase();
        localObject = paramString2.toLowerCase();
        paramString2 = paramString1;
        paramString1 = (String)localObject;
        break;
      }
      return null;
    }
  }
  
  public String getConfigSync(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = getConfigSync(paramString1, paramString2);
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
        if (aafs.a(this.configMap))
        {
          this.loadstatus = 2;
          updateConfig();
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
      localQzoneConfigChangeListener.onConfigChange();
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
    //   10: getfield 7473	common/config/service/QzoneConfig:mCallback	Ljava/util/ArrayList;
    //   13: invokevirtual 7811	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 7816 1 0
    //   23: ifeq -17 -> 6
    //   26: aload_2
    //   27: invokeinterface 7820 1 0
    //   32: checkcast 7822	java/lang/ref/WeakReference
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull -20 -> 17
    //   40: aload_3
    //   41: invokevirtual 7825	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   44: checkcast 7827	common/config/service/QzoneConfig$QzoneConfigChangeListener
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull +11 -> 60
    //   52: aload_1
    //   53: aload_3
    //   54: invokevirtual 7831	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   57: ifeq -40 -> 17
    //   60: aload_2
    //   61: invokeinterface 7830 1 0
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
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    QLog.e("QzoneConfig", 1, "mainKey :" + paramString1 + "  secondKey : " + paramString2 + "  value: " + paramString3);
    Object localObject;
    if ((this.mStringHelper != null) && (this.mStringHelper.a()))
    {
      paramString1 = this.mStringHelper.a(paramString1);
      localObject = this.mStringHelper.a(paramString2);
      paramString2 = paramString1;
    }
    for (paramString1 = (String)localObject;; paramString1 = (String)localObject)
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.configMap.get(paramString2);
      localObject = localConcurrentHashMap;
      if (localConcurrentHashMap == null)
      {
        localObject = new ConcurrentHashMap();
        this.configMap.put(paramString2, localObject);
      }
      if (localObject != null) {
        ((ConcurrentHashMap)localObject).put(paramString1, paramString3);
      }
      updateConfig();
      return;
      paramString1 = paramString1.toLowerCase();
      localObject = paramString2.toLowerCase();
      paramString2 = paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     common.config.service.QzoneConfig
 * JD-Core Version:    0.7.0.1
 */