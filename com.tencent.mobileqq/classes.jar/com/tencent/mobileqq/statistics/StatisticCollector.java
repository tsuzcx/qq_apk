package com.tencent.mobileqq.statistics;

import acln;
import acxs;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import aoae;
import aoam;
import bcwd;
import bhkp;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.richframework.network.cache.Cache;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.feedback.anr.ANRReport;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class StatisticCollector
{
  public static final String ADD_FRIEND_SOURCE = "addFriendSource";
  public static final String AIO_EMOTICON_MONITOR = "AIOEmoticonMonitor";
  public static final String ALBUM_QUERY_MEDIA = "album_query_media";
  public static final String ALL_C2C_PTT_UPLOAD_STATISTIC_TAG = "actAllC2CPttUp";
  private static final long ALL_CAPABILITY_SIZE = 15360L;
  private static final String APP_STATISTIC_TAG = "AndroidQQUseApp";
  public static final String BASE_DYNAMIC_AVATAR_UPLOAD_STATISTIC_TAG = "actBaseDynamicAvatarUpload";
  public static final String BDH_SWITCH_CHNL = "actSwitchChnl";
  public static final String BUSINESS_CARD_PIC_UPLOAD_STATISTIC_TAG = "actBusinessCardPicUpload";
  public static final String C2B_UPLOAD_FILE_TAG = "C2BUploadFile";
  public static final String C2C_PICDOWN_STATISTIC_TAG = "actC2CPicDownloadV1";
  public static final String C2C_PICUP_STATISTIC_TAG = "actC2CPicUploadV1";
  public static final String C2C_PICUP_STATISTIC_TAG_V2 = "actC2CPicUploadV2";
  public static final String C2C_PIC_MSG_UPLOAD_STATISTIC_TAG = "actSendC2CPictureProcess";
  public static final String C2C_PTT_UPLOAD_STATISTIC_TAG = "actC2CPttUpload";
  public static final String C2C_PUSHTALK_PTT_DOWNLOAD_STATISTIC_TAG = "actC2CPttDownload";
  public static final String C2C_SHORTVIDEO_DOWNLOAD_THUMB = "actShortVideoDownloadThumb";
  public static final String C2C_SHORTVIDEO_DOWNLOAD_VIDEO = "actShortVideoDownloadVideo";
  public static final String C2C_SHORTVIDEO_UPLOAD = "actShortVideoUpload";
  public static final String C2C_SHORTVIDEO_UPLOAD_BDH = "actShortVideoUploadBDH";
  public static final String C2C_SMAILLPICDOWN_STATISTIC_TAG = "actC2CPicSmallDownV1";
  public static final String C2C_STREAM_PTT_DOWN_STATISTIC_TAG = "actC2CStreamPttDownload";
  public static final String C2C_STREAM_PTT_UP_STATISTIC_TAG = "actC2CStreamPttUpload";
  public static final String C2C_TXT_STATISTIC_TAG = "actSendC2CProcess";
  public static final String CALL_PITU_CAMERA = "call_pitu_camera";
  public static final String CALL_QZONE_FRIENDFEED = "callqzonefromfriendfeed";
  public static final String CALL_QZONE_PUSH = "callqzonefrompushv2";
  public static final String CALL_REQUEST_FOCUS = "sv_call_request_focus";
  public static final String CALL_WEISHI_FROM_QZONE = "callweishifromfriendfeed";
  public static final String CAMERA2_SUPPORT_LEVEL = "acCamera2Support";
  public static final String CAMERA_START_TIME_COST = "cameraStartTimeCost";
  public static final String CAPTURE_CUSTOM_HUMMING_DISTANCE = "sv_capture_custom_humming_distance";
  public static final String CAPTURE_CUSTOM_MISMATCH = "sv_capture_custom_mismatch";
  public static final String CAPTURE_PHOTO_SEND = "sv_capture_photo_send";
  public static final String CMSHOW_3D_FACE_UPLOAD = "cmshow3DFace";
  public static final String CRASH_INFO_DIR_PATH = "/data/data/com.tencent.mobileqq/files/";
  public static final String CRASH_INFO_FILE_NAME = "CrashInfoSummary.txt";
  public static final int CRASH_MAX_RECORD_COUNT = 10;
  public static final String CUSTOM_PHOTO_SEND = "sv_custom_photo_send";
  private static final String DAILY_USE_TAG = "mqq_dailyUse";
  public static final String DANMAKU_REQUEST_MONITOR = "DanmakuRequestMonitor";
  private static final long DAY = 86400000L;
  public static final String DB_OP_RESULT = "DatabaseOperatorResult_";
  public static final String DEFAULT_OBSERVER_COST = "actDefaultObserverCost";
  private static final String DEFAULT_SAMPLE = "250|5|5|1|50|5|5|25|25|25|5|10|10";
  private static final String DEVICE_STATISTIC_TAG = "End_Info";
  public static final String DG_PKSHARE_PIC_HIT = "DGPKSharePicHit";
  public static final String DISCUSSION_PIC_DOWNLOAD_STATISTIC_TAG = "actDiscussPicDown";
  public static final String DISCUSSION_PIC_UPLOAD_STATISTIC_TAG = "actDiscussPicUpload";
  public static final String DISCUSSION_PIC_UPLOAD_STATISTIC_TAG_V2 = "actDiscussPicUploadV2";
  public static final String DISCUSSION_PTT_DOWNLOAD_STATISTIC_TAG = "actDisscusPttDown";
  public static final String DISCUSSION_PTT_UPLOAD_STATISTIC_TAG = "actDisscusPttUp";
  public static final String DISCUSSION_SMALLPIC_DOWNLOAD_STATISTIC_TAG = "actDiscussPicSmallDown";
  public static final String DISCUSSION_TXT_STATISTIC_TAG = "actSendDiscussProcess";
  public static final String DYNAMIC_ADJUSTMENT_ON_DESTROY = "dynamic_adjustment_on_destroy";
  public static final String DYNAMIC_ADJUSTMENT_ON_TRIGGERING = "dynamic_adjustment_on_triggering";
  public static final String EMOTICON_OPERATE_MONITOR = "EmoticonOperateMonitor";
  public static final String EMOTION_SOUND_DOWNLOAD = "NewAudioEmoticonVoiceDownload";
  public static final String EMOTION_SOUND_PLAY = "NewAudioEmoticonVoicePlay";
  public static final String EMO_SEARCH_CATCH_USE_MONITOR = "emo_search_catch_use_monitor";
  public static final String EMO_SEARCH_MONITOR = "emo_search_monitor";
  public static final String ENTER_SHORTVIDEO = "sv_enter_shortvideo";
  public static final String ENTER_SYSTEM_CAMERA = "sv_enter_system_camera";
  public static final String EVENT_CAMERA_NUM_LESS_TWO = "event_camera_num_less_two";
  public static final String EXPOSURE_FlowCamera = "exposure_flowCamera";
  public static final String EXPOSURE_NewFlowCamera = "exposure_newFlowCamera";
  public static final String EXPOSURE_OLD_EditPic = "exposure_old_editPic";
  public static final String EXPOSURE_OLD_EditVideo = "exposure_old_editVideo";
  public static final String EXPOSURE_OLD_EditWebVideo = "exposure_old_editWebVideo";
  public static final String EXTEND_FRIEND_SOUND_UPLOAD_TAG = "actExtendFriendSoundUpload";
  public static final String FACEREGISTER_PIC_MSG_UPLOAD_STATISTIC_TAG = "facePicUploadProcess";
  private static final String FBG_STATISTIC_TAG = "AndroidQQRunTime";
  public static int FDCountLastChecked = 0;
  public static long FDMillisLastChecked = 0L;
  public static final String FORWARD_VIDEO_BROKEN = "actForwardVideoBroken";
  public static final String FRESH_NEWS_PIC_UPLOAD_STATISTIC_TAG = "actFreshNewsPicUpload";
  public static final String FRIENDLIST_FAILED_DETAIL = "QQFriendListReqFailedStatistics";
  public static final String FRIENDLIST_RESULT = "QQFriendListReqGetEvent";
  public static final String FRIEND_AVATAR_UPLOAD_STATISTICS_TAG = "actFriendAvatarUpload";
  public static final String FRIEND_SQLITE_OPERATE = "actFriendSqliteOpt";
  public static final String GROUP_SHORTVIDEO_DOWNLOAD_THUMB = "actShortVideoDiscussgroupDownloadThumb";
  public static final String GROUP_SHORTVIDEO_DOWNLOAD_VIDEO = "actShortVideoDiscussgroupDownloadVideo";
  public static final String GROUP_SHORTVIDEO_REDIRECT = "actShortVideoRedirect";
  public static final String GROUP_SHORTVIDEO_UPLOAD = "actShortVideoDiscussgroupUpload";
  public static final String GROUP_SHORTVIDEO_UPLOAD_BDH = "actShortVideoDiscussgroupUploadBDH";
  public static final String H5_UPLOAD_PIC_HIT = "h5UploadPicHit";
  public static boolean HASMODIFY = false;
  public static final String HONG_BAO_STAR_PHOTO_UPLOAD_STATISTIC_TAG = "actHongbaoStarPhotoUpload";
  public static final String HTTPS_DOWNLOAD_FAILED = "actHttpsDownloadFail";
  public static final String HTTPS_SNI_SUPPORT = "actHttpsSniSupport";
  public static final String ILLEGAL_GRAYTIP_ID = "illegalGraytipId";
  public static final String IMG_PROVIDERSERVICE_GET_TOPACTIVITY = "ImageProviderService_getTopActivity_event";
  public static final String INNER_DNS_BAD_IP = "actDnsBadIp";
  public static final String INNER_DNS_REQ = "actDnsReq";
  public static final String KANDIAN_UGC_PIC_UPLOAD_TAG = "KandianUGCPicUpload";
  public static final String KANDIAN_UGC_VIDEO_UPLOAD_TAG = "KandianUGCVideoUpload";
  public static final String KEY_BEACON_TEST_ENV_SWITCH = "beacon_test_env_switch";
  public static final String KEY_IS_NATIVE_CRASH_HAPPENED = "KEY_IS_NATIVE_CRASH_HAPPENED";
  public static final String KEY_VERSION_PATCHLIB_LOAD = "version_patchlib_load";
  public static final String LTEXT_AUTO_PULL_RESULT = "ltextAutoPullResult";
  public static final String LTEXT_EMPTY_RESID = "ltextEmptyResid";
  public static final String LTEXT_MANUAL_PULL_RESULT = "ltextManualPullResult";
  public static final String LTEXT_NEW_RECEIVE_RESULT = "ltextNewReceiveResult";
  public static final String LTEXT_NEW_SEND_RESULT = "ltextNewSendResult";
  public static final String LTEXT_OLD_RECEIVE_RESULT = "ltextOldReceiveResult";
  public static final String LTEXT_OLD_SEND_RESULT = "ltextOldSendResult";
  public static final String MESSAGE_EVENT = "actMessageEvent";
  public static final String MINI_APP_ARK_SHARE_PICTURE_UPLOAD = "miniAppArkShareUploadPicHit";
  public static final String MINI_APP_USER_LOG_UPLOAD = "miniAppUserLog";
  public static final String MIX_MSG_CLIENT_AUTO_PULL_REPORT_TAG = "MixedMsgClientAutoPull";
  public static final String MIX_MSG_CLIENT_MANU_PULL_REPORT_TAG = "MixedMsgClientManualPull";
  public static final String MIX_MSG_FORWARD_REPORT_TAG = "MixedMsgForward";
  public static final String MIX_MSG_RECEIVED_REPORT_TAG = "MixedMsgReceived";
  public static final String MODEL_COMPATIBILITY = "sv_model_compatibility";
  public static final String MSG_CACHE_ERROR_SCENE = "msgCacheErrorScene";
  public static final String MSG_CACHE_STRATEGY_TAG = "msg_cache_strategy_tag";
  public static final String MSG_CACHE_STRATEGY_TAG_DEBUG = "msg_cache_strategy_tag_debug";
  public static final String MSG_CACHE_STRATEGY_TAG_GRAY = "msg_cache_strategy_tag_gray";
  public static final String MSG_NOTIFICATION_STATS_TAG = "msgNotificationStatsTag";
  public static final String MSG_SEND_COST_PER_PHASE = "msgSendCostPerPhase";
  public static final String MULTIMSG_DOWNLOAD_STATISTIC_TAG = "actMultiMsgDownload";
  public static final String MULTIMSG_UPLOAD_STATISTIC_TAG = "actMultiMsgUpload";
  public static final String MULTI_MSG_NICK_TIMEOUT = "multiMsgNickTimeOut";
  public static final String MULTI_MSG_NICK_TIMEOUT_REAL = "multiMsgNickTimeoutR";
  public static final String MULTI_MSG_RECEIVE = "multiMsgReceive";
  public static final String MULTI_MSG_SEND = "multiMsgSend";
  public static final String NEARBY_DYNAMIC_AVATAR_UPLOAD_STATISTIC_TAG = "actNearbyDynamicAvatarUpload";
  public static final String NEARBY_PEOPLE_PIC_DOWNLOAD_STATISTIC_TAG = "actNearbyPeoplePicDownload";
  public static final String NEARBY_PEOPLE_PIC_UPLOAD_STATISTIC_TAG = "actNearbyPeoplePicUpload";
  public static final String NEARBY_PIC_BROWSER_STATISTIC_TAG = "actNearbyPicBrowser";
  public static boolean NEEDCOUNTTRANS = false;
  public static final String NETCHANGE_NOTIFY_WAIT_QUEUE = "netchangeNotifyWaitQueue";
  public static final String ON_AUTO_FOCUS = "sv_on_auto_focus";
  public static final String PAJASDK_PIC_MSG_UPLOAD_STATISTIC_TAG = "PAJSSDKPicUploadProcess";
  public static final String PA_IIMAGE_COLLECTION_IMAGE_HIT = "eventPAAlbumCacheHitStatics";
  public static final String PA_IIMAGE_COLLECTION_IMAGE_TIME = "eventPAAlbumPreDownPhotoTime";
  public static final String PA_IIMAGE_COLLECTION_PROTO_HIT = "eventPAAlbumRequestAlbumHitStatics";
  public static final String PA_IIMAGE_COLLECTION_PROTO_TIME = "eventPAAlbumRequestAlbumTime";
  public static final String PA_LONGMSG_DOWNLOAD = "actLongMessageDownload";
  public static final String PA_LONGMSG_TIME_DOWNLOAD = "actLongMessageTimeDownload";
  public static final String PA_LONGMSG_TIME_SSO = "actLongMessageTimeSSO";
  public static final String PA_OLD_LONGMSG_DOWNLOAD = "actOldLongMessageDownload";
  public static final String PA_OLD_LONGMSG_TIME_DOWNLOAD = "actOldLongMessageTimeDownload";
  public static final String PA_OLD_LONGMSG_TIME_SSO = "actOldLongMessageTimeSSO";
  public static final String PERSONALITY_LABEL_PHOTO_UPLOAD_STATISTIC_TAG = "actPersonalityLabelPhotoUpload";
  public static final String PHOTO_SEND_FROM_ALBUM = "sv_photo_send_from_album";
  public static final String PHOTO_SEND_FROM_ALBUM_IN_MINUTE = "photo_send_from_album_in_minute";
  public static final String PHOTO_SEND_FROM_SHORTVIDEO = "photo_send_from_shortvideo";
  public static final String PHOTO_SHORT_FROM_SHORTVIDEO = "photo_shot_from_shortvideo";
  public static final String PHOTO_TAKEN_BY_CAPTURE = "sv_photo_taken_by_capture";
  public static final String PHOTO_TAKEN_BY_CUSTOM = "sv_photo_taken_by_custom";
  public static final String PIC_DOWNLOADV2_CARD_PICTURE = "actPicDownloadV2.Card.Picture";
  public static final String PIC_SHARE_TO_WX_UPLOAD = "actPicShareToWXUpload";
  public static final String PIC_UPLOADV2_CARD_PICTRUE = "actPicUploadV2.Card.Picture";
  public static final String PLUGIN_GETUNREAD_TAG = "actPluginUnread";
  public static final String POKE_STRENGTH_NULL_POINT = "pokeStrengthNullPoint";
  public static final String PREDICTION_DATA = "actPredictionData";
  private static final String PREF_STATISTICS_NEXT_REPORT_TIME = "next_reportTime";
  public static final String PROFILE_COVER_PIC_UPLOAD_STATISTIC_TAG = "actProfileCoverPicUpload";
  public static final String PROFILE_INTRO_PTT_DOWNLOAD_TAG = "actIntroPttDownload";
  public static final String PROFILE_INTRO_PTT_UPLOAD_TAG = "actIntroPttUpload";
  public static final String PTT_DOWNLOAD_STREAM_2_OFFLINE_STATISTIC_TAG = "actPttDownloadStream2Offline";
  public static final String PTT_LONG_PRESS_FATE_STATISTIC_TAG = "actPttLongPressFate2";
  public static final String PTT_NO_RANGE_FAILED_TAG = "actPttNoRangeFailed";
  public static final String PTT_PLAY_BLUETOOTH_STATISTIC_TAG = "actPttPlayBluetooth";
  public static final String PTT_PROCESS_FRAME_COST_TAG = "actPttProcessFrameCost";
  public static final String PTT_SHOW_DOWNLOADING_STATISTIC_TAG = "actPttShowDownloading";
  public static final String PTT_SLICE_TO_TEXT = "pttSliceToText";
  public static final String PTT_SO_UPDATE_STATISTIC_TAG = "actPttSoUpdate";
  public static final String PTT_STT_FRIST_SHOW_TIME_COST = "PttSttFristShowTimeCost";
  public static final String PTT_STT_PART_TIME_INTERVAL = "PttShardSttReveivePartTimeInterval";
  public static final String PTT_STT_RESULT_ERROR = "PttSttResultError";
  public static final String PTT_STT_RESULT_MONITOR = "PttSttResultMonitor";
  public static final String PTT_USER_WAITING_STATISTIC_TAG = "actPttUserWaiting";
  public static final String PTV_GUIDE_TAG = "ptvGuideReportTag";
  public static final String PTV_TEACH_GUIDE_TAG = "ptvTeachGuideReportTag";
  public static final String QASSISTANT_JUMP_MONITOR = "qAudioAssistantJumpMonitor";
  public static final String QQCOMIC_PIC_UPLOAD_STATISTIC_TAG = "actQqComicPicUpload";
  public static final String QQLS_REPORT_TAG = "qqlsReprotTag";
  public static final String QQLS_SETTING_REPORT_TAG = "qqlsSettingReprotTag";
  public static final String QQ_FILTER_DOWNLOAD = "acQQFilterDownload";
  public static final String QQ_FILTER_USER_INFO = "acQQFilterDownloadCount";
  public static final String QQ_FILTER_VIEW = "acQQfilterView";
  public static final String QQ_VOICE_SEARCH = "QQVoiceSearch";
  public static final String QZONE_APP_START_TO_CLICK_ENTRY = "AppStartToClcikEntry";
  public static final String QZONE_AROUSE_THIRDAPP = "qzonearousethirdapp";
  public static final String QZONE_CHOOSE_PHOTO_BACK_TO_MOOD = "qzoneChoosePhotoBackToMood";
  public static final String QZONE_CHOOSE_PHOTO_CAMERA_TAG = "qzoneChoosePhotoCamera";
  public static final String QZONE_CLICK_ENTREY_TO_APP_START = "clickEntryToAppStart";
  public static final String QZONE_CONFIGDB_ERROR = "qzoneconfigdberror";
  public static final String QZONE_CPU_MEMINFO = "updateCpuandMemInfo";
  public static final String QZONE_DB_ENCRYPT_ERROR = "qzonedbencrypt";
  public static final String QZONE_EXTEND_STARTUP_COST_COLD_FIRST = "QzoneExtendStartupCost_Cold_First";
  public static final String QZONE_EXTEND_STARTUP_COST_COLD_NORMAL = "QzoneExtendStartupCost_Cold_Normal";
  public static final String QZONE_EXTEND_STARTUP_COST_WARM_FIRST = "QzoneExtendStartupCost_Warm_First";
  public static final String QZONE_EXTEND_STARTUP_COST_Warm_Normal = "QzoneExtendStartupCost_Warm_Normal";
  public static final String QZONE_EXTEND_START_UP_TIME_REPORT_TAG = "qzoneExtendStartUpCost";
  public static final String QZONE_GETUNREAD_TAG = "actQzoneUnread";
  public static final String QZONE_LIVE_DOWNLOADSO_REPORT = "actQZLiveDownloadSoReport";
  public static final String QZONE_MOOD_SCHEDULE_DELETE_VIDEO_TAG = "qzoneMoodScheduleDeleteVideo";
  public static final String QZONE_NETWORKED_MODULE_DOWNLOAD_RES_REPORT_TAG = "qzoneModuleDowndloadRes";
  public static final String QZONE_NETWORKED_MODULE_LOAD_RES_REPORT_TAG = "qzoneModuleLoadRes";
  public static final String QZONE_ODEX_CHECK_ACTION = "qzoneOdexCheck";
  public static final String QZONE_PLUGIN_INSTALL = "qzonePrePluginInstall";
  public static final String QZONE_PLUGIN_PATCH = "actQzonePluginPatch";
  public static final String QZONE_PUSH_DATA_REPORT = "actQZPushDataReport";
  public static final String QZONE_PUSH_STATE = "qzonepushstate";
  public static final String QZONE_RECOVERSY_TAG = "qzoneRecovery";
  public static final String QZONE_RESOURCE_PRELOAD_TIME_TAG = "qzoneResourePreload";
  public static final String QZONE_SHARE_TIMECOST = "qzonesharetimecost";
  public static final String QZONE_SMART_REPORT = "qzonesmartreport";
  public static final String QZONE_SOURCE_DATA_REPORT = "actQZSourceDataReport";
  public static final String QZONE_STARTUP_COST_COLD_FIRST = "QzoneStartupCost_Cold_First";
  public static final String QZONE_STARTUP_COST_COLD_NORMAL = "QzoneStartupCost_Cold_Normal";
  public static final String QZONE_STARTUP_COST_WARM_FIRST = "QzoneStartupCost_Warm_First";
  public static final String QZONE_STARTUP_COST_Warm_Normal = "QzoneStartupCost_Warm_Normal";
  public static final String QZONE_START_UP_TIME_REPORT_TAG = "qzoneStartUpCost";
  public static final String QZONE_UNREAD_DATA_REPORT = "actQZUnreadDataReport";
  public static final String QZONE_UPLOAD_REPORT_TRY_AGAIN = "qzoneUploadReportTryAgain";
  public static final String QZONE_VIDEO_TAB_BANNER_TAG = "qzoneVideoTabBanner";
  public static final String READINJOY_ARTICLE_OPEN = "actReadInJoyArticleOpen";
  public static final String READINJOY_BIU_COAST_TIME = "actMultiBiuResult";
  public static final String READINJOY_FLING_LTOR = "actReadInJoyFlingLToR";
  public static final String READINJOY_IP_CONNECT = "actReadInJoyIpConnect";
  public static final String READINJOY_RELEASE_WEB_SERVICE = "actReadInJoyReleaseWebService";
  public static final String READINJOY_SHORTEN_URL = "actReadInJoyShortenUrl";
  public static final String READINJOY_TOOL_PRELOAD = "actReadInJoyToolPreload";
  public static final String READINJOY_UGC_PICTURE = "actReadInJoyUGCPicture";
  public static final String READINJOY_UGC_VIDEO = "actReadInJoyUGCVideo";
  public static final String REG_DIFF_GROUP_NUM = "prxyRegDiffGroupNum";
  public static final String REG_FAIL_CODE = "prxyRegFailCode";
  public static final String REG_LOOKUP_CODER_NULL = "prxyLookupCoderNull";
  public static final String REG_NEED_PULL_GROUP = "prxyRegNeedPullGroup";
  public static final String REG_REGISTER_B = "prxyRegisterB";
  public static final String REG_REGISTER_M = "prxyRegisterM";
  public static final String REG_REGISTER_T = "prxyRegisterT";
  public static final int REPORT_MAX_SIZE = 5;
  public static final String REPORT_TAG_SP_ABNORMAL = "evSpError";
  public static final String REVOKE_MSG_ERROR_TAG = "revokeMsgErrorTag";
  public static final String RICH_TEXT_ILLEGAL_WORD_DECT_TIME = "RichTextIllegalWordTime";
  public static final String SCENES_REC_EMO_MONITOR = "scenes_rec_emo_monitor";
  public static final String SCRIBBLE_UPLOAD_STATIC_TAG = "scribble_upload";
  public static final String SDK_DOWNLOAD_HIJACKED = "actSDKDownloadHijacked";
  public static final String SDK_PREDOWNLOAD = "actSDKPredownload";
  public static final String SEND_MSG_TOO_LARGE_ERROR_TAG = "sendMsgTooLargeErrorTag";
  public static final String SEND_PHOTO_IDLE_COST = "actSendPhotoIdleCost";
  public static final String SEND_QUALITY_PIC_LIMIT = "sendQualityPicLimit";
  public static final String SET_PHOTO_CLIP_SIZE = "actSetPhotoClipSize";
  public static final String SET_PREVIEW_SIZE_WAY = "actSetPreviewSizeWay";
  public static final String SHOOT_PHOTO_CLIP = "actShootPhotoClip";
  public static final String SHORTVIDEO_FORWARD = "actShortVideoForward";
  public static final String SHORTVIDEO_FORWARD_BDH = "actShortVideoForwardBDH";
  public static final String SHORT_VIDEO_PTU_SO_DOWNLOAD = "actShortVideoPtuSoDownload";
  public static final String SHORT_VIDEO_SO_DOWNLOAD = "actShortVideoSoDownload";
  public static final String SNAPCHAT_PIC_UPLOAD_STATISTIC_TAG = "actSnapChatPicUpload";
  public static final String SP_KEY_FACEFEATURE_EXT_SO_MD5 = "facefeature_ext_so_md5";
  public static final String SP_NAME = "StatisticCollector";
  public static final String SP_QQ_BEACON = "sp_qq_beacon";
  public static final String SQLITE_DATABASE_CORRUPT = "actSqliteDatabaseCorrupt";
  public static final String SQLITE_OPERATE_COST = "actSqliteOptCost";
  public static final String SQLITE_OPERATE_DETAIL_COST = "actSqliteOptDetailCost";
  public static final String SQL_COST_TAG = "SQLCost";
  public static final int SQL_SAMPLE_AIO = 1;
  public static final int SQL_SAMPLE_DELETE = 6;
  public static final int SQL_SAMPLE_FRIEND_DELETE = 10;
  public static final int SQL_SAMPLE_FRIEND_INSERT = 8;
  public static final int SQL_SAMPLE_FRIEND_QUERY = 7;
  public static final int SQL_SAMPLE_FRIEND_TRANS = 11;
  public static final int SQL_SAMPLE_FRIEND_UPDATE = 9;
  public static final int SQL_SAMPLE_INSERT = 4;
  public static final int SQL_SAMPLE_MAIN_THREAD = 2;
  public static final int SQL_SAMPLE_TRANS = 0;
  public static final int SQL_SAMPLE_TROOP_QUERY = 12;
  public static final int SQL_SAMPLE_UPDATE = 5;
  public static final int SQL_SAMPLE_WAL_SWITCH = 3;
  public static final String STORY_PIC_UPLOAD_STATISTIC_TAG = "actStoryPicUpload";
  public static final String STORY_VIDEO_UPLOAD_STATISTIC_TAG = "actStoryVideoUpload";
  public static final String STREAM_VIDEO_PLAY = "actStreamingVideoPlay";
  public static final String SUCCESS_RATE_FOR_IMAX_CLICK_EXPORSURE = "imaxClickExporsureSucessRate";
  public static final String SUCCESS_RATE_FOR_IMAX_EXPORSURE = "imaxExporsureSucessRate";
  public static final String SUCCESS_RATE_FOR_POKE_EFFECT = "pokeEffectSucessRate";
  public static final String SYSTEM_PHOTO_SEND = "sv_system_photo_send";
  public static final String TAG = "StatisticCollector";
  public static final String TAG_LAUNCH_TIME = "actLoginT";
  public static final String TAG_MEMORY = "actMemory";
  public static final String TAG_QQ_INIT_TIME = "actQQInit";
  public static final String TAG_QZONE_PRELOAD_FINISHED = "qzonePreloadFinished";
  public static final String TAG_SYNC_MESSAGE_FIRST = "actSyncMsgFirst";
  public static final String TAG_SYNC_MESSAGE_SECOND = "actSyncMsgSecond";
  private static final String TEST_APP_KEY = "LOGDEBUGKEY00001";
  public static final String TROOP_MEMBER_SEARCH_BUILD_INDEX_COST = "tMSearchBuiltIndexCost";
  public static final String TROOP_MEMBER_SEARCH_UPDATE_REQ = "tMSearchUpdateReq";
  public static final String TROOP_PIC_DOWNLOAD_STATISTIC_TAG = "actGroupPicDownloadV1";
  public static final String TROOP_PIC_MSG_UPLOAD_STATISTIC_TAG = "actSendGroupPictureProcess";
  public static final String TROOP_PIC_UPLOAD_STATISTIC_TAG = "actGroupPicUploadV1";
  public static final String TROOP_PIC_UPLOAD_STATISTIC_TAG_V2 = "actGroupPicUploadV2";
  public static final String TROOP_PTT_DOWNLOAD_STATISTIC_TAG = "actGrpPttDown";
  public static final String TROOP_PTT_MSG_UPLOAD_STATISTIC_TAG = "dim.actSendGroupPttMsg";
  public static final String TROOP_PTT_UPLOAD_STATISTIC_TAG = "actGrpPttUp";
  public static final String TROOP_SENDGRPTMP_STATISTIC_TAG = "dim.actSendGrpTmpMsg";
  public static final String TROOP_SMAILLPIC_DOWNLOAD_STATISTIC_TAG = "actGroupPicSmallDownV1";
  public static final String TROOP_TXT_STATISTIC_TAG = "actSendGroupProcess";
  public static final String VIDEO_MESSAGE_TIME = "actVideoMessageTime";
  public static final String WECHAT_NS_LOAD_FAIL = "actWechatNsLoadFail";
  public static final String WPA_MSG_UPLOAD_STATISTIC_TAG = "dim.actSendWpaMsg";
  private static boolean bReportingDailyUser = false;
  private static Context ctx;
  private static final long initDelayTime = 3000L;
  public static boolean isPatchLibLoadSuccess = false;
  private static final Random random = new Random();
  public static volatile boolean sCatchedNotExit = false;
  private static String sCrashStack;
  private static String sCrashType;
  public static StatisticCollector.StatisticCallback sFdDetectCallback;
  private static volatile boolean sHasCrashed = false;
  private static volatile boolean sIsFinalizeTimeoutException = false;
  public static volatile long sRdmInitTime = 0L;
  private static volatile StatisticCollector self;
  private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
  private static final int timezoneMillDelta = 28800000;
  private StatisticCollector.ProductInfo[] APP_REPORTS = { new StatisticCollector.ProductInfo("com.tencent.mtt", "qqBrowser"), new StatisticCollector.ProductInfo("com.tencent.android.qqdownloader", "qqMarket"), new StatisticCollector.ProductInfo("com.tencent.qqgame", "qqGame"), new StatisticCollector.ProductInfo("com.tencent.qqmusic", "qqMusic"), new StatisticCollector.ProductInfo("com.tencent.news", "qqNews"), new StatisticCollector.ProductInfo("com.qq.reader", "qqReader"), new StatisticCollector.ProductInfo("com.tencent.qqlive", "qqVideo"), new StatisticCollector.ProductInfo("com.tencent.wblog", "qqMicroblog"), new StatisticCollector.ProductInfo("com.tencent.qqphonebook", "qqPhonebook") };
  private String activityExtraInfo;
  private int allCapability;
  StatisticCollector.CrashControl crashControl = new StatisticCollector.CrashControl();
  private StringBuilder dpcExtraInfo = new StringBuilder("DPC info:\n");
  private LinkedList<StatisticCollector.ContextLog> listContextLog = new LinkedList();
  String mCurUin = "999";
  private HashMap<String, String> mapEvent = new HashMap(4);
  boolean shouldStopMsf = false;
  private Stack<String> stack = new Stack();
  private StringBuilder threadInfo = new StringBuilder("Thread info:\n");
  
  protected StatisticCollector(Context paramContext)
  {
    ctx = paramContext;
  }
  
  private StatisticCollector(Context paramContext, long paramLong)
  {
    ctx = paramContext;
    UserAction.setUserID("10000");
    UserAction.initUserAction(ctx, false, paramLong);
    UserAction.setChannelID(AppSetting.c());
    setBeaconTestEnvIfNeed(paramContext);
  }
  
  public static boolean SQLite3OptimizeReport()
  {
    if ("8.4.10".startsWith("7.1.")) {}
    return false;
  }
  
  public static void appendReceiverInfo(Context paramContext, StringBuilder paramStringBuilder)
  {
    Object localObject1 = bhkp.a("android.app.ActivityThread", "currentActivityThread", new Object[0], new Class[0]);
    paramContext = paramContext.getPackageName();
    paramContext = (Map)bhkp.a("android.app.LoadedApk", ((WeakReference)((Map)bhkp.a("android.app.ActivityThread", localObject1, "mPackages")).get(paramContext)).get(), "mReceivers");
    localObject1 = paramContext.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      Iterator localIterator = ((Map)paramContext.get(localObject2)).keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = localIterator.next();
        paramStringBuilder.append("\n");
        localObject3 = (BroadcastReceiver)localObject3;
        paramStringBuilder.append(localObject3.getClass().getName() + ":" + localObject3);
        paramStringBuilder.append(" in ");
        paramStringBuilder.append(localObject2.getClass().getName() + ":" + localObject2);
      }
    }
  }
  
  private void clearProtocolCaches()
  {
    CacheHelper.fileCache().clear();
  }
  
  public static void fillFailCode(Map<String, String> paramMap, int paramInt)
  {
    paramMap.put("param_FailCode", String.valueOf(paramInt));
  }
  
  private String findKeywordFromPackageName(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = 0;
    if (i < this.APP_REPORTS.length)
    {
      String str = this.APP_REPORTS[i].packageName;
      if (!paramString.toLowerCase().contains(str)) {}
    }
    for (paramString = this.APP_REPORTS[i].reportKeyWord;; paramString = null)
    {
      return paramString;
      i += 1;
      break;
    }
  }
  
  private static Map<String, String> getDeviceStatistics()
  {
    HashMap localHashMap = new HashMap(16);
    localHashMap.put("param_MODEL", DeviceInfoUtil.getDeviceModel());
    localHashMap.put("param_manu", DeviceInfoUtil.getManufacturer());
    localHashMap.put("param_OS", DeviceInfoUtil.getDeviceOSVersion());
    localHashMap.put("param_Resolution", MsfSdkUtils.getResolutionString(ctx));
    localHashMap.put("param_IMEI", DeviceInfoUtil.getIMEI());
    localHashMap.put("param_IMSI", DeviceInfoUtil.getIMSI());
    localHashMap.put("param_NetworkType", "" + NetworkUtil.getNetworkType(ctx));
    localHashMap.put("param_ProductVersion", "" + AppSetting.a());
    localHashMap.put("param_CPU", DeviceInfoUtil.getCpuType());
    localHashMap.put("param_totalmemory", MsfSdkUtils.getTotalMemory());
    localHashMap.put("param_availmemory", String.valueOf(DeviceInfoUtil.getSystemAvaialbeMemory() / 1024L) + "kB");
    long[] arrayOfLong = DeviceInfoUtil.getRomMemroy();
    localHashMap.put("param_totalrom", String.valueOf(arrayOfLong[0]) + "MB");
    localHashMap.put("param_availrom", String.valueOf(arrayOfLong[1]) + "MB");
    arrayOfLong = DeviceInfoUtil.getSDCardMemory();
    localHashMap.put("param_totalsd", String.valueOf(arrayOfLong[0]) + "MB");
    localHashMap.put("param_availsd", String.valueOf(arrayOfLong[1]) + "MB");
    localHashMap.put("param_Camera", "" + DeviceInfoUtil.getCameraCount());
    return localHashMap;
  }
  
  @TargetApi(21)
  private static String getFdInfoString()
  {
    int i1 = 0;
    int m = 0;
    int i2 = 0;
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int j = i1;
    int k = i2;
    for (;;)
    {
      try
      {
        Object localObject1 = new File("/proc/self/fd");
        j = i1;
        int n = m;
        k = i2;
        if (((File)localObject1).exists())
        {
          j = i1;
          n = m;
          k = i2;
          if (((File)localObject1).isDirectory())
          {
            j = i1;
            k = i2;
            if (Build.VERSION.SDK_INT < 21) {
              break label345;
            }
            m = 1;
            j = i1;
            k = i2;
            File[] arrayOfFile = ((File)localObject1).listFiles();
            j = i1;
            k = i2;
            i2 = arrayOfFile.length;
            i1 = 0;
            n = i;
            if (i1 < i2)
            {
              localObject1 = arrayOfFile[i1];
              if (m != 0) {
                k = i;
              }
              try
              {
                localObject1 = Os.readlink(((File)localObject1).getPath());
                k = i;
                localStringBuilder.append((String)localObject1 + "\n");
                i += 1;
              }
              catch (Throwable localThrowable1)
              {
                j = i;
                k = i;
                QLog.e("StatisticCollector", 1, "readlink failed", localThrowable1);
              }
              k = i;
              localObject1 = ((File)localObject1).getCanonicalPath();
              continue;
            }
          }
        }
        localStringBuilder.append("Total FD Count = " + k);
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2 = localThrowable2;
        try
        {
          QLog.e("StatisticCollector", 1, "get fd info failed !!!", localThrowable2);
          localStringBuilder.append("Total FD Count = " + j);
          return localStringBuilder.toString();
        }
        finally
        {
          for (;;)
          {
            k = j;
          }
        }
        localStringBuilder.append("Total FD Count = " + n);
        return localStringBuilder.toString();
      }
      finally {}
      return localStringBuilder.toString();
      i1 += 1;
      continue;
      label345:
      m = 0;
    }
  }
  
  public static StatisticCollector getInstance(Context paramContext)
  {
    return getInstance(paramContext, 3000L);
  }
  
  public static StatisticCollector getInstance(Context paramContext, long paramLong)
  {
    if (self == null) {}
    for (;;)
    {
      try
      {
        if (self == null)
        {
          if (aoae.a()) {
            self = new StatisticCollector(BaseApplicationImpl.getApplication(), paramLong);
          }
        }
        else if (self == null) {}
      }
      finally {}
      try
      {
        if ((aoae.a()) && ((self instanceof StatisticCollector.EmptyStatisticCollector))) {
          self = new StatisticCollector(BaseApplicationImpl.getApplication(), paramLong);
        }
        return self;
      }
      finally {}
      self = new StatisticCollector.EmptyStatisticCollector(BaseApplicationImpl.getApplication());
    }
  }
  
  public static int getQzonePatchTag()
  {
    return LocalMultiProcConfig.getInt("version_patchlib_load", 0);
  }
  
  public static boolean getSqliteSwitchBySample(int paramInt)
  {
    boolean bool2;
    if (paramInt != 3)
    {
      bool2 = false;
      return bool2;
    }
    String[] arrayOfString2 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SqlSampleCfg.name(), "250|5|5|1|50|5|5|25|25|25|5|10|10").split("\\|");
    String[] arrayOfString1 = arrayOfString2;
    if (arrayOfString2.length < 13) {
      arrayOfString1 = "250|5|5|1|50|5|5|25|25|25|5|10|10".split("\\|");
    }
    if (paramInt > arrayOfString1.length - 1) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.valueOf(arrayOfString1[paramInt]).intValue();
        if (paramInt <= 0) {
          break label162;
        }
        if (random.nextInt(paramInt) == paramInt - 1)
        {
          bool1 = true;
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("StatisticCollector", 2, new Object[] { "getSqliteSwitchBySample value: ", Integer.valueOf(paramInt), " switch: ", Boolean.valueOf(bool1) });
          return bool1;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StatisticCollector", 2, "getSqliteSwitchBySample error", localException);
        }
        return false;
      }
      boolean bool1 = false;
      continue;
      label162:
      bool1 = false;
    }
  }
  
  private boolean isMultimediaEvent(String paramString)
  {
    if ("actC2CPicUploadV1".equals(paramString)) {}
    while (("actC2CPicUploadV2".equals(paramString)) || ("actGroupPicUploadV2".equals(paramString)) || ("actDiscussPicUploadV2".equals(paramString)) || ("actC2CPicDownloadV1".equals(paramString)) || ("actC2CPicSmallDownV1".equals(paramString)) || ("actGroupPicUploadV1".equals(paramString)) || ("actGroupPicDownloadV1".equals(paramString)) || ("actGroupPicSmallDownV1".equals(paramString)) || ("actDiscussPicUpload".equals(paramString)) || ("actDiscussPicDown".equals(paramString)) || ("actDiscussPicSmallDown".equals(paramString)) || ("actGrpPttUp".equals(paramString)) || ("actGrpPttDown".equals(paramString)) || ("actDisscusPttUp".equals(paramString)) || ("actDisscusPttDown".equals(paramString)) || ("actC2CStreamPttUpload".equals(paramString)) || ("actC2CStreamPttDownload".equals(paramString)) || ("actC2CPttDownload".equals(paramString)) || ("actC2CPttUpload".equals(paramString)) || ("actFileDown".equals(paramString)) || ("actFileUp".equals(paramString)) || ("actFileOf2Of".equals(paramString)) || ("actFileOf2Wy".equals(paramString)) || ("actFileWy2Of".equals(paramString)) || ("actFileWyUp".equals(paramString)) || ("actFileWyDown".equals(paramString)) || ("actFileUpDetail".equals(paramString)) || ("actFileDownDetail".equals(paramString)) || ("actFAFileDown".equals(paramString)) || ("actFAFileUp".equals(paramString)) || ("actShortVideoUpload".equals(paramString)) || ("actShortVideoUploadBDH".equals(paramString)) || ("actShortVideoDiscussgroupUploadBDH".equals(paramString)) || ("actShortVideoForwardBDH".equals(paramString)) || ("actShortVideoDownloadVideo".equals(paramString)) || ("actShortVideoDownloadThumb".equals(paramString)) || ("actShortVideoDiscussgroupUpload".equals(paramString)) || ("actShortVideoDiscussgroupDownloadVideo".equals(paramString)) || ("actShortVideoDiscussgroupDownloadThumb".equals(paramString)) || ("PicStatisticsManagerUploadPic".equals(paramString))) {
      return true;
    }
    return false;
  }
  
  private static boolean isNotExitSafeMode(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((1 != BaseApplicationImpl.sProcessId) || (System.currentTimeMillis() - sRdmInitTime > 600000L)) {}
    Object localObject1;
    do
    {
      return false;
      localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("pref_safemode_not_exit", 4);
    } while ((!((SharedPreferences)localObject1).getBoolean("key_not_exit_enable", false)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)));
    for (;;)
    {
      int i;
      int m;
      try
      {
        Object localObject2 = ((SharedPreferences)localObject1).getString("key_not_exit_crash_type", null);
        localObject1 = ((SharedPreferences)localObject1).getString("key_not_exit_crash_stack", null);
        if ((localObject2 == null) || (TextUtils.isEmpty(paramString1))) {
          break label314;
        }
        localObject2 = ((String)localObject2).split("\\|");
        k = localObject2.length;
        j = 0;
        i = 0;
        if (j >= k) {
          break label326;
        }
        Object localObject3 = localObject2[j];
        if (!paramString1.equals(localObject3)) {
          break label319;
        }
        QLog.e("StatisticCollector", 1, new Object[] { "crashType = ", paramString1, ",crash = ", localObject3 });
        i = 1;
      }
      catch (Throwable paramString1)
      {
        int k;
        int n;
        QLog.e("StatisticCollector", 1, "isNotExitSafeMode has some error", paramString1);
        return false;
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(paramString2)))
      {
        paramString1 = ((String)localObject1).split("\\|");
        n = paramString1.length;
        k = 0;
        i = 0;
        m = i;
        if (k < n)
        {
          localObject1 = paramString1[k];
          if (paramString2.contains((CharSequence)localObject1))
          {
            QLog.e("StatisticCollector", 1, new Object[] { "crashStack = ", paramString2, ",crash = ", localObject1 });
            i = 1;
          }
          k += 1;
          continue;
        }
      }
      else
      {
        m = 0;
      }
      if ((m != 0) && (j != 0)) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
      label314:
      int j = 0;
      continue;
      label319:
      j += 1;
      continue;
      label326:
      j = i;
    }
  }
  
  private static boolean isOppoPhoneAndSDK27()
  {
    if (Build.VERSION.SDK_INT == 27) {}
    for (int i = 1; (i != 0) && (Build.MODEL.contains("OPPO R11")); i = 0) {
      return true;
    }
    return false;
  }
  
  private void logEvent(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.mapEvent.remove(paramString1);
    paramString2 = paramString2 + " time:" + System.currentTimeMillis() + "\n";
    this.mapEvent.put(paramString1, paramString2);
  }
  
  public static void report(String paramString)
  {
    getInstance(BaseApplication.getContext()).collectPerformance(null, paramString, true, 0L, 0L, null, null);
  }
  
  private void setBeaconTestEnvIfNeed(Context paramContext) {}
  
  public static void setQzonePatchTag(int paramInt)
  {
    LocalMultiProcConfig.putInt("version_patchlib_load", paramInt);
    if (paramInt > 0) {
      QLog.i("PatchLibLoader", 1, "setQzonePatchTag" + paramInt);
    }
  }
  
  private void stopServiceOnCrash(Context paramContext, String paramString)
  {
    QLog.d("StatisticCollector", 1, "stopServiceOnCrash");
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null)) {
      QLog.d("StatisticCollector", 1, "stopServiceOnCrash,context == null");
    }
    for (;;)
    {
      return;
      Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(200);
      if ((localObject == null) || (((List)localObject).size() <= 0))
      {
        QLog.d("StatisticCollector", 1, "stopServiceOnCrash,list == null");
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)((Iterator)localObject).next();
        if (paramString.equals(localRunningServiceInfo.process))
        {
          Intent localIntent = new Intent();
          localIntent.setComponent(localRunningServiceInfo.service);
          QLog.d("StatisticCollector", 1, "Stop service: " + localRunningServiceInfo.service + ", clientCount: " + localRunningServiceInfo.clientCount + ", clientPackage: " + localRunningServiceInfo.clientPackage + ", crashCount: " + localRunningServiceInfo.crashCount);
          paramContext.stopService(localIntent);
        }
      }
    }
  }
  
  public void addContextLog(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {}
    for (;;)
    {
      return;
      paramString1 = new StatisticCollector.ContextLog(System.currentTimeMillis(), paramString1, paramString2);
      this.listContextLog.add(paramString1);
      int i = this.allCapability;
      for (this.allCapability = (paramString1.size + i); (this.allCapability > 15360L) && (this.listContextLog.size() > 1); this.allCapability -= paramString1.size) {
        paramString1 = (StatisticCollector.ContextLog)this.listContextLog.removeLast();
      }
    }
  }
  
  public void collectPerformance(String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString4)
  {
    collectPerformance(paramString1, paramString2, paramString3, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString4, false, false);
  }
  
  public void collectPerformance(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString4, boolean paramBoolean2)
  {
    collectPerformance(paramString1, paramString2, paramString3, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString4, paramBoolean2, false);
  }
  
  public void collectPerformance(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString4, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!aoae.a()) {
      return;
    }
    acxs.a(paramString3, paramHashMap);
    if (paramString2 == null) {
      paramString2 = "10000";
    }
    for (;;)
    {
      paramString4 = paramString2;
      if (paramString2 != null)
      {
        paramString4 = paramString2;
        if (paramString2.length() < 1) {
          paramString4 = "10000";
        }
      }
      UserAction.setUserID(paramString4);
      if (paramHashMap == null)
      {
        paramString2 = new HashMap();
        if (paramString2 != null) {
          paramString2.put("param_ProductVersion", "" + AppSetting.a());
        }
        if (QLog.isColorLevel()) {
          QLog.d("StatisticCollector", 2, "event report: " + paramString3 + " " + paramBoolean1 + " time:" + paramLong1 + " size:" + paramLong2);
        }
        if ((paramBoolean1) && ((!paramString2.containsKey("param_FailCode")) || ("".equals(paramString2.get("param_FailCode"))))) {
          paramString2.put("param_FailCode", String.valueOf(0));
        }
        paramHashMap = new RdmReq();
        paramHashMap.eventName = paramString3;
        paramHashMap.elapse = paramLong1;
        paramHashMap.size = paramLong2;
        paramHashMap.isSucceed = paramBoolean1;
        paramHashMap.isRealTime = paramBoolean2;
        paramHashMap.appKey = paramString1;
        paramHashMap.isImmediatelyUpload = paramBoolean3;
        if (isMultimediaEvent(paramString3))
        {
          paramHashMap.isMerge = false;
          paramHashMap.isRealTime = true;
        }
        paramHashMap.params = paramString2;
        try
        {
          paramString1 = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramHashMap);
          paramString1.setAppId(AppSetting.a());
          paramString1.setTimeout(30000L);
          ThreadManager.post(new StatisticCollector.6(this, paramString1), 5, null, true);
          return;
        }
        catch (Exception paramString1)
        {
          return;
        }
      }
      paramString2 = new HashSet();
      paramString2.addAll(paramHashMap.keySet());
      paramString4 = paramString2.iterator();
      for (;;)
      {
        paramString2 = paramHashMap;
        if (!paramString4.hasNext()) {
          break;
        }
        paramString2 = (String)paramString4.next();
        if ((String)paramHashMap.get(paramString2) == null) {
          paramHashMap.put(paramString2, "");
        }
      }
    }
  }
  
  public void collectPerformance(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    collectPerformance("", paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3, false, false);
  }
  
  public void collectPerformance(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2)
  {
    collectPerformance("", paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString3, paramBoolean2, false);
  }
  
  public void collectPerformance(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2, boolean paramBoolean3)
  {
    collectPerformance("", paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString3, paramBoolean2, paramBoolean3);
  }
  
  /* Error */
  public void dumpThreadInfo(StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 1027	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 1204	java/lang/StringBuilder:<init>	()V
    //   7: ldc_w 1817
    //   10: invokevirtual 1201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: invokestatic 1822	android/os/Process:myPid	()I
    //   16: invokevirtual 1310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc_w 1824
    //   22: invokevirtual 1201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 1219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 11
    //   30: aload_1
    //   31: ldc_w 1826
    //   34: invokevirtual 1201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 1828
    //   40: invokevirtual 1201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aconst_null
    //   45: astore 8
    //   47: aconst_null
    //   48: astore 9
    //   50: aconst_null
    //   51: astore 5
    //   53: invokestatic 1537	java/lang/System:currentTimeMillis	()J
    //   56: lstore_3
    //   57: aload 8
    //   59: astore 7
    //   61: aload 9
    //   63: astore 6
    //   65: new 1368	java/io/File
    //   68: dup
    //   69: aload 11
    //   71: invokespecial 1371	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: invokevirtual 1832	java/io/File:list	()[Ljava/lang/String;
    //   77: astore 10
    //   79: aload 8
    //   81: astore 7
    //   83: aload 9
    //   85: astore 6
    //   87: new 1038	java/util/HashMap
    //   90: dup
    //   91: invokespecial 1716	java/util/HashMap:<init>	()V
    //   94: astore 8
    //   96: iconst_0
    //   97: istore_2
    //   98: aload 5
    //   100: astore 7
    //   102: aload 5
    //   104: astore 6
    //   106: iload_2
    //   107: aload 10
    //   109: arraylength
    //   110: if_icmpge +120 -> 230
    //   113: aload 5
    //   115: astore 7
    //   117: aload 5
    //   119: astore 6
    //   121: new 1368	java/io/File
    //   124: dup
    //   125: new 1027	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 1204	java/lang/StringBuilder:<init>	()V
    //   132: aload 11
    //   134: invokevirtual 1201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 1834
    //   140: invokevirtual 1201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 10
    //   145: iload_2
    //   146: aaload
    //   147: invokevirtual 1201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc_w 1836
    //   153: invokevirtual 1201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 1219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokespecial 1371	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: astore 9
    //   164: aload 5
    //   166: astore 7
    //   168: aload 5
    //   170: astore 6
    //   172: invokestatic 1537	java/lang/System:currentTimeMillis	()J
    //   175: lload_3
    //   176: lsub
    //   177: ldc2_w 1837
    //   180: lcmp
    //   181: ifle +188 -> 369
    //   184: aload 5
    //   186: astore 7
    //   188: aload 5
    //   190: astore 6
    //   192: invokestatic 1482	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +35 -> 230
    //   198: aload 5
    //   200: astore 7
    //   202: aload 5
    //   204: astore 6
    //   206: ldc_w 771
    //   209: iconst_2
    //   210: iconst_2
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: ldc_w 1840
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload_1
    //   223: invokevirtual 1219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: aastore
    //   227: invokestatic 1498	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   230: aload 5
    //   232: astore 7
    //   234: aload 5
    //   236: astore 6
    //   238: aload 8
    //   240: invokevirtual 1843	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   243: invokeinterface 1187 1 0
    //   248: astore 8
    //   250: aload 5
    //   252: astore 7
    //   254: aload 5
    //   256: astore 6
    //   258: aload 8
    //   260: invokeinterface 1192 1 0
    //   265: ifeq +274 -> 539
    //   268: aload 5
    //   270: astore 7
    //   272: aload 5
    //   274: astore 6
    //   276: aload 8
    //   278: invokeinterface 1195 1 0
    //   283: checkcast 1845	java/util/Map$Entry
    //   286: astore 9
    //   288: aload 5
    //   290: astore 7
    //   292: aload 5
    //   294: astore 6
    //   296: aload_1
    //   297: aload 9
    //   299: invokeinterface 1848 1 0
    //   304: checkcast 1077	java/lang/String
    //   307: invokevirtual 1201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc_w 1850
    //   313: invokevirtual 1201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload 9
    //   318: invokeinterface 1853 1 0
    //   323: invokevirtual 1216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   326: ldc_w 1855
    //   329: invokevirtual 1201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: ldc_w 1857
    //   335: invokevirtual 1201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: goto -89 -> 250
    //   342: astore_1
    //   343: aload 7
    //   345: astore 6
    //   347: ldc_w 771
    //   350: iconst_2
    //   351: ldc_w 1859
    //   354: aload_1
    //   355: invokestatic 1405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   358: aload 7
    //   360: ifnull +8 -> 368
    //   363: aload 7
    //   365: invokevirtual 1864	java/io/BufferedReader:close	()V
    //   368: return
    //   369: aload 5
    //   371: astore 7
    //   373: aload 5
    //   375: astore 6
    //   377: aload 9
    //   379: invokevirtual 1374	java/io/File:exists	()Z
    //   382: ifeq +364 -> 746
    //   385: aload 5
    //   387: astore 7
    //   389: aload 5
    //   391: astore 6
    //   393: new 1861	java/io/BufferedReader
    //   396: dup
    //   397: new 1866	java/io/FileReader
    //   400: dup
    //   401: aload 9
    //   403: invokespecial 1869	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   406: bipush 64
    //   408: invokespecial 1872	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   411: astore 5
    //   413: aload 5
    //   415: invokevirtual 1875	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   418: astore 6
    //   420: aload 6
    //   422: ifnull +327 -> 749
    //   425: aload 6
    //   427: ldc_w 1877
    //   430: invokevirtual 1081	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   433: ifeq -20 -> 413
    //   436: aload 6
    //   438: ldc_w 1213
    //   441: invokevirtual 1467	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   444: iconst_1
    //   445: aaload
    //   446: invokevirtual 1880	java/lang/String:trim	()Ljava/lang/String;
    //   449: astore 6
    //   451: aload 8
    //   453: aload 6
    //   455: invokevirtual 1728	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   458: ifeq +49 -> 507
    //   461: aload 8
    //   463: aload 6
    //   465: aload 8
    //   467: aload 6
    //   469: invokevirtual 1729	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   472: checkcast 1469	java/lang/Integer
    //   475: invokevirtual 1475	java/lang/Integer:intValue	()I
    //   478: iconst_1
    //   479: iadd
    //   480: invokestatic 1487	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   483: invokevirtual 1601	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   486: pop
    //   487: aload 5
    //   489: ifnull +47 -> 536
    //   492: aload 5
    //   494: invokevirtual 1864	java/io/BufferedReader:close	()V
    //   497: aconst_null
    //   498: astore 5
    //   500: iload_2
    //   501: iconst_1
    //   502: iadd
    //   503: istore_2
    //   504: goto -406 -> 98
    //   507: aload 8
    //   509: aload 6
    //   511: iconst_1
    //   512: invokestatic 1487	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   515: invokevirtual 1601	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   518: pop
    //   519: goto -32 -> 487
    //   522: astore 6
    //   524: ldc_w 771
    //   527: iconst_2
    //   528: ldc_w 1859
    //   531: aload 6
    //   533: invokestatic 1405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   536: goto -36 -> 500
    //   539: aload 5
    //   541: astore 7
    //   543: aload 5
    //   545: astore 6
    //   547: aload_1
    //   548: ldc_w 1882
    //   551: invokevirtual 1201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: aload 10
    //   556: arraylength
    //   557: invokevirtual 1310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 5
    //   563: astore 7
    //   565: aload 5
    //   567: astore 6
    //   569: invokestatic 1887	com/tencent/mobileqq/app/ThreadLog:needRecordJob	()Z
    //   572: ifeq +36 -> 608
    //   575: aload 5
    //   577: astore 7
    //   579: aload 5
    //   581: astore 6
    //   583: aload 10
    //   585: arraylength
    //   586: sipush 200
    //   589: if_icmple +19 -> 608
    //   592: aload 5
    //   594: astore 7
    //   596: aload 5
    //   598: astore 6
    //   600: aload_1
    //   601: invokestatic 1890	com/tencent/mobileqq/app/ThreadManager:reportCurrentState	()Ljava/lang/String;
    //   604: invokevirtual 1201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload 5
    //   610: astore 7
    //   612: aload 5
    //   614: astore 6
    //   616: invokestatic 1482	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   619: ifeq +52 -> 671
    //   622: aload 5
    //   624: astore 7
    //   626: aload 5
    //   628: astore 6
    //   630: ldc_w 771
    //   633: iconst_2
    //   634: iconst_4
    //   635: anewarray 4	java/lang/Object
    //   638: dup
    //   639: iconst_0
    //   640: ldc_w 1892
    //   643: aastore
    //   644: dup
    //   645: iconst_1
    //   646: invokestatic 1537	java/lang/System:currentTimeMillis	()J
    //   649: lload_3
    //   650: lsub
    //   651: invokestatic 1897	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   654: aastore
    //   655: dup
    //   656: iconst_2
    //   657: ldc_w 1899
    //   660: aastore
    //   661: dup
    //   662: iconst_3
    //   663: aload_1
    //   664: invokevirtual 1219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: aastore
    //   668: invokestatic 1498	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   671: aload 5
    //   673: ifnull -305 -> 368
    //   676: aload 5
    //   678: invokevirtual 1864	java/io/BufferedReader:close	()V
    //   681: return
    //   682: astore_1
    //   683: ldc_w 771
    //   686: iconst_2
    //   687: ldc_w 1859
    //   690: aload_1
    //   691: invokestatic 1405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   694: return
    //   695: astore_1
    //   696: ldc_w 771
    //   699: iconst_2
    //   700: ldc_w 1859
    //   703: aload_1
    //   704: invokestatic 1405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   707: return
    //   708: astore_1
    //   709: aload 6
    //   711: ifnull +8 -> 719
    //   714: aload 6
    //   716: invokevirtual 1864	java/io/BufferedReader:close	()V
    //   719: aload_1
    //   720: athrow
    //   721: astore 5
    //   723: ldc_w 771
    //   726: iconst_2
    //   727: ldc_w 1859
    //   730: aload 5
    //   732: invokestatic 1405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   735: goto -16 -> 719
    //   738: astore_1
    //   739: aload 5
    //   741: astore 6
    //   743: goto -34 -> 709
    //   746: goto -246 -> 500
    //   749: aconst_null
    //   750: astore 6
    //   752: goto -301 -> 451
    //   755: astore_1
    //   756: aload 5
    //   758: astore 7
    //   760: goto -417 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	763	0	this	StatisticCollector
    //   0	763	1	paramStringBuilder	StringBuilder
    //   97	407	2	i	int
    //   56	594	3	l	long
    //   51	626	5	localBufferedReader	java.io.BufferedReader
    //   721	36	5	localIOException1	java.io.IOException
    //   63	447	6	localObject1	Object
    //   522	10	6	localIOException2	java.io.IOException
    //   545	206	6	localObject2	Object
    //   59	700	7	localObject3	Object
    //   45	463	8	localObject4	Object
    //   48	354	9	localObject5	Object
    //   77	507	10	arrayOfString	String[]
    //   28	105	11	str	String
    // Exception table:
    //   from	to	target	type
    //   65	79	342	java/lang/Exception
    //   87	96	342	java/lang/Exception
    //   106	113	342	java/lang/Exception
    //   121	164	342	java/lang/Exception
    //   172	184	342	java/lang/Exception
    //   192	198	342	java/lang/Exception
    //   206	230	342	java/lang/Exception
    //   238	250	342	java/lang/Exception
    //   258	268	342	java/lang/Exception
    //   276	288	342	java/lang/Exception
    //   296	339	342	java/lang/Exception
    //   377	385	342	java/lang/Exception
    //   393	413	342	java/lang/Exception
    //   547	561	342	java/lang/Exception
    //   569	575	342	java/lang/Exception
    //   583	592	342	java/lang/Exception
    //   600	608	342	java/lang/Exception
    //   616	622	342	java/lang/Exception
    //   630	671	342	java/lang/Exception
    //   492	497	522	java/io/IOException
    //   676	681	682	java/io/IOException
    //   363	368	695	java/io/IOException
    //   65	79	708	finally
    //   87	96	708	finally
    //   106	113	708	finally
    //   121	164	708	finally
    //   172	184	708	finally
    //   192	198	708	finally
    //   206	230	708	finally
    //   238	250	708	finally
    //   258	268	708	finally
    //   276	288	708	finally
    //   296	339	708	finally
    //   347	358	708	finally
    //   377	385	708	finally
    //   393	413	708	finally
    //   547	561	708	finally
    //   569	575	708	finally
    //   583	592	708	finally
    //   600	608	708	finally
    //   616	622	708	finally
    //   630	671	708	finally
    //   714	719	721	java/io/IOException
    //   413	420	738	finally
    //   425	451	738	finally
    //   451	487	738	finally
    //   492	497	738	finally
    //   507	519	738	finally
    //   524	536	738	finally
    //   413	420	755	java/lang/Exception
    //   425	451	755	java/lang/Exception
    //   451	487	755	java/lang/Exception
    //   492	497	755	java/lang/Exception
    //   507	519	755	java/lang/Exception
    //   524	536	755	java/lang/Exception
  }
  
  void initCrashControl()
  {
    String str = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.crash_control.name(), null);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      Object localObject = new JSONObject(str);
      this.crashControl.controlSwitch = ((JSONObject)localObject).getBoolean("control_switch");
      this.crashControl.controlLevel = ((JSONObject)localObject).getInt("control_level");
      this.crashControl.controlWindow = ((JSONObject)localObject).getInt("control_window");
      this.crashControl.controlFreq = ((JSONObject)localObject).getInt("control_freq");
      localObject = this.dpcExtraInfo.append("initCrashControl");
      ((StringBuilder)localObject).append(",controlJson=").append(str);
      ((StringBuilder)localObject).append(",switch=").append(this.crashControl.controlSwitch);
      ((StringBuilder)localObject).append(",level=").append(this.crashControl.controlLevel);
      ((StringBuilder)localObject).append(",window=").append(this.crashControl.controlWindow);
      ((StringBuilder)localObject).append(",Freq=").append(this.crashControl.controlFreq);
      this.dpcExtraInfo.append("\n");
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.crashControl.reset();
        QLog.d("StatisticCollector", 1, "initCrashControl parse json throws an exception, so reset.");
      }
    }
  }
  
  public void logOnCreate(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      this.stack.push(paramContext);
      logEvent("onCreate", paramContext);
    }
  }
  
  public void logOnDestroy(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      this.stack.remove(paramContext);
      logEvent("onDestroy", paramContext);
    }
  }
  
  public void logOnPause(Context paramContext)
  {
    if (paramContext != null) {
      logEvent("onPause", paramContext.toString());
    }
  }
  
  public void logOnResume(Context paramContext)
  {
    if (paramContext != null) {
      logEvent("onResume", paramContext.toString());
    }
  }
  
  @Deprecated
  public void reportActionCount(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    paramString1 = paramString2 + "|" + paramInt;
    paramString2 = new NewIntent(paramAppRuntime.getApplication(), bcwd.class);
    paramString2.putExtra("sendType", 2);
    paramString2.putExtra("tag", "mqq_tab");
    paramString2.putExtra("content", paramString1);
    paramAppRuntime.startServlet(paramString2);
  }
  
  @Deprecated
  public void reportActionCount(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    paramString1 = paramString2 + "|" + paramString3;
    paramString2 = new NewIntent(paramAppRuntime.getApplication(), bcwd.class);
    paramString2.putExtra("sendType", 2);
    paramString2.putExtra("tag", "mqq_tab");
    paramString2.putExtra("content", paramString1);
    paramAppRuntime.startServlet(paramString2);
  }
  
  @Deprecated
  public void reportActionCount(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    String str = paramString4;
    if (paramString4 == null) {
      str = "0";
    }
    paramString4 = paramString5;
    if (paramString5 == null) {
      paramString4 = "";
    }
    paramString5 = paramString6;
    if (paramString6 == null) {
      paramString5 = "";
    }
    paramString6 = paramString7;
    if (paramString7 == null) {
      paramString6 = "";
    }
    paramString7 = paramString8;
    if (paramString8 == null) {
      paramString7 = "";
    }
    paramString8 = new StringBuilder(128);
    paramString8.append(paramAppRuntime.getAccount()).append('|').append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(str).append('|').append(paramString4).append('|').append(paramString5).append('|').append(paramString6).append('|').append(paramString7).append('|');
    paramString1 = new NewIntent(paramAppRuntime.getApplication(), bcwd.class);
    paramString1.putExtra("sendType", 2);
    paramString1.putExtra("tag", "CliOper");
    paramString1.putExtra("content", paramString8.toString());
    paramAppRuntime.startServlet(paramString1);
  }
  
  @Deprecated
  public void reportActionCountCliOper(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString3 == null) || (paramString4 == null)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3);
      localStringBuilder.append('|').append('|').append('|').append('|').append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), bcwd.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticCollector", 2, "tag=CliOper,content=" + localStringBuilder.toString());
  }
  
  @Deprecated
  public void reportActionCountCliOper(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString3 == null) || (paramString4 == null)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3).append('|').append(paramInt4).append('|').append('|').append('|').append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), bcwd.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticCollector", 2, "tag=CliOper,content=" + localStringBuilder.toString());
  }
  
  @Deprecated
  public void reportActionCountMsgOper(AppRuntime paramAppRuntime, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), bcwd.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "MsgOper");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "tag=MsgOper,content=" + paramString);
    }
  }
  
  @Deprecated
  public void reportActionCountPCliOper(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString4 == null) || (paramString5 == null)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(paramString3).append('|').append(paramString1).append('|').append("").append('|').append(paramString4).append('|').append(paramString5).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3);
      localStringBuilder.append('|').append(paramString2).append('|').append('|').append('|').append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), bcwd.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "P_CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticCollector", 2, "tag=P_CliOper,content=" + localStringBuilder.toString());
  }
  
  @Deprecated
  public void reportActionCountRes(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString3 == null) || (paramString4 == null)) {
      return;
    }
    String str = paramString5;
    if (paramString5 == null) {
      str = "";
    }
    paramString5 = paramString6;
    if (paramString6 == null) {
      paramString5 = "";
    }
    paramString6 = paramString7;
    if (paramString7 == null) {
      paramString6 = "";
    }
    paramString7 = paramString8;
    if (paramString8 == null) {
      paramString7 = "";
    }
    paramString8 = new StringBuilder(128);
    paramString8.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3).append('|').append(str).append('|').append(paramString5).append('|').append(paramString6).append('|').append(paramString7).append('|');
    paramString1 = new NewIntent(paramAppRuntime.getApplication(), bcwd.class);
    paramString1.putExtra("sendType", 2);
    paramString1.putExtra("tag", "CliOper");
    paramString1.putExtra("content", paramString8.toString());
    paramAppRuntime.startServlet(paramString1);
  }
  
  public void reportAppStatistic(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime == null) || (paramString == null)) {}
    do
    {
      return;
      paramString = findKeywordFromPackageName(paramString);
    } while (paramString == null);
    paramString = paramString + '|';
    paramString = paramString + "1|";
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), bcwd.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "AndroidQQUseApp");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public void reportButtonClick(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    reportToAds(paramAppRuntime, paramString2, paramInt);
  }
  
  @Deprecated
  public void reportCustomSet(AppRuntime paramAppRuntime, String paramString, Map<String, Integer> paramMap)
  {
    if ((paramAppRuntime == null) || (paramString == null) || (paramMap == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    Object localObject = paramMap.keySet();
    paramString = new ArrayList(paramMap.size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append(str).append("|").append(paramMap.get(str)).append("|");
      paramString.add(localStringBuilder.toString());
      localStringBuilder.delete(0, localStringBuilder.length());
    }
    paramMap = new NewIntent(paramAppRuntime.getApplication(), bcwd.class);
    paramMap.putExtra("sendType", 6);
    paramMap.putExtra("tag", "custom_set");
    paramMap.putExtra("content", paramString);
    paramAppRuntime.startServlet(paramMap);
  }
  
  public void reportDailyUser(AppRuntime paramAppRuntime)
  {
    if (bReportingDailyUser) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return;
      } while ((paramAppRuntime == null) || (!paramAppRuntime.isLogin()));
      localObject = ctx.getSharedPreferences("mobileQQ", 0);
      l1 = ((SharedPreferences)localObject).getLong("next_reportTime_" + paramAppRuntime.getAccount(), 0L);
      l2 = (NetConnInfoCenter.getServerTimeMillis() + 28800000L) / 86400000L;
    } while (l2 < l1);
    bReportingDailyUser = true;
    ((SharedPreferences)localObject).edit().putLong("next_reportTime_" + paramAppRuntime.getAccount(), 1L + l2).commit();
    Object localObject = new NewIntent(paramAppRuntime.getApplication(), bcwd.class);
    ((NewIntent)localObject).putExtra("sendType", 2);
    ((NewIntent)localObject).putExtra("tag", "mqq_dailyUse");
    ((NewIntent)localObject).putExtra("content", "");
    paramAppRuntime.startServlet((NewIntent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "Report Daily Use,Next Report Day:" + l2 + 1);
    }
    bReportingDailyUser = false;
  }
  
  public void reportDeviceStatistic(String paramString)
  {
    Map localMap = getDeviceStatistics();
    if ((paramString == null) || (localMap == null)) {
      return;
    }
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((String)localMap.get(str) == null) {
        localMap.put(str, "");
      }
    }
    UserAction.setUserID(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "report End_Info:" + localMap.toString());
    }
    paramString = new RdmReq();
    paramString.eventName = "End_Info";
    paramString.elapse = -1L;
    paramString.size = 0L;
    paramString.isSucceed = true;
    paramString.isRealTime = true;
    paramString.isMerge = false;
    paramString.params = localMap;
    try
    {
      paramString = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramString);
      paramString.setAppId(AppSetting.a());
      paramString.setTimeout(30000L);
      MsfServiceSdk.get().sendMsg(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  @Deprecated
  public void reportOnOff(AppRuntime paramAppRuntime, String paramString, Map<String, Integer> paramMap)
  {
    if ((paramAppRuntime == null) || (paramString == null) || (paramMap == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    Object localObject = paramMap.keySet();
    paramString = new ArrayList(paramMap.size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append(str).append("|").append(paramMap.get(str)).append("|");
      paramString.add(localStringBuilder.toString());
      localStringBuilder.delete(0, localStringBuilder.length());
    }
    paramMap = new NewIntent(paramAppRuntime.getApplication(), bcwd.class);
    paramMap.putExtra("sendType", 6);
    paramMap.putExtra("tag", "on_off");
    paramMap.putExtra("content", paramString);
    paramAppRuntime.startServlet(paramMap);
  }
  
  public void reportToAds(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime == null) || (paramString == null)) {
      return;
    }
    reportToAds(paramAppRuntime, paramString, 1, "", "", "");
  }
  
  public void reportToAds(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramString == null)) {
      return;
    }
    reportToAds(paramAppRuntime, paramString, paramInt, "", "", "");
  }
  
  public void reportToAds(AppRuntime paramAppRuntime, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if ((paramAppRuntime == null) || (paramString1 == null)) {}
    do
    {
      return;
      paramString1 = paramString1 + "|" + paramString2 + "|" + paramString3 + "|" + paramInt + "|" + paramString4;
      paramString2 = new NewIntent(paramAppRuntime.getApplication(), bcwd.class);
      paramString2.putExtra("sendType", 2);
      paramString2.putExtra("tag", "appPlug");
      paramString2.putExtra("content", paramString1);
      paramAppRuntime.startServlet(paramString2);
    } while (!QLog.isColorLevel());
    QLog.d("reportToAds", 2, paramString1);
  }
  
  public void reportToAds(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if ((paramAppRuntime == null) || (paramString1 == null)) {
      return;
    }
    reportToAds(paramAppRuntime, paramString1, 1, "", "", paramString2);
  }
  
  @Deprecated
  public void reportToPCliOper(AppRuntime paramAppRuntime, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), bcwd.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "P_CliOper");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "tag=P_CliOper,content=" + paramString);
    }
  }
  
  public void setContact(String paramString)
  {
    this.mCurUin = paramString;
    try
    {
      UserAction.setUserID(paramString);
      CrashReport.setUserId(ctx, paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setEnableCrashRecord(String paramString)
  {
    boolean bool = false;
    this.mCurUin = paramString;
    CrashReport.setLogAble(false, false);
    Object localObject = new CrashStrategyBean();
    ((CrashStrategyBean)localObject).setUploadSpotCrash(false);
    ((CrashStrategyBean)localObject).setMaxStackFrame(6);
    QLog.d("StatisticCollector", 1, "initCrashReport process=" + BaseApplicationImpl.processName + ", pid=" + Process.myPid());
    if (BaseApplicationImpl.processName.endsWith(":qzone")) {
      ThreadManager.executeOnSubThread(new StatisticCollector.1(this));
    }
    if (BaseApplicationImpl.sProcessId == 1) {
      bool = true;
    }
    CrashReport.initCrashReport(ctx, new StatisticCollector.2(this), null, bool, (CrashStrategyBean)localObject, 30000L);
    try
    {
      localObject = ctx.getDir("tombs", 0).getAbsolutePath();
      QLog.d("StatisticCollector", 1, "initNativeCrashReport process=" + BaseApplicationImpl.processName + ", pid=" + Process.myPid());
      CrashReport.initNativeCrashReport(ctx, (String)localObject, false, null, null, 0L);
      CrashReport.filterSysLog(true, true);
      QLog.d("StatisticCollector", 1, "CrashReport init finished.");
      ANRReport.stopANRMonitor();
      CrashReport.setUserId(ctx, paramString);
      CrashReport.putUserData(ctx, "TbsSdkVersion", String.valueOf(WebView.getTbsSDKVersion(ctx)));
      CrashReport.putUserData(ctx, "X5CoreVersion", String.valueOf(QbSdk.getTbsVersion(ctx)));
      CrashReport.putUserData(ctx, "PatchInstallStatus", String.valueOf(acln.jdField_a_of_type_Int));
      if (!TextUtils.isEmpty(acln.jdField_a_of_type_JavaLangString)) {
        CrashReport.putUserData(ctx, "PatchNameInstalled", acln.jdField_a_of_type_JavaLangString);
      }
      CrashReport.putUserData(ctx, "Revision", AppSetting.g());
      CrashReport.putUserData(ctx, "Version.buildNum", "8.4.10.4875");
      CrashReport.putUserData(ctx, "AboutSubVersionLog", AppSetting.b());
      CrashReport.putUserData(ctx, "appid", String.valueOf(AppSetting.a()));
      CrashReport.putUserData(ctx, "topActivity", aoam.a());
      this.threadInfo.append("Current process id=").append(Process.myPid()).append(", Name=").append(BaseApplicationImpl.processName).append("\n");
      sRdmInitTime = System.currentTimeMillis();
      if (1 == BaseApplicationImpl.sProcessId)
      {
        ThreadManager.getSubThreadHandler().postDelayed(new StatisticCollector.3(this, paramString), 3000L);
        ThreadManager.getSubThreadHandler().postDelayed(new StatisticCollector.4(this), 180000L);
        ThreadManager.getSubThreadHandler().postDelayed(new StatisticCollector.5(this), 600000L);
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        QLog.e("StatisticCollector", 1, "initNativeCrashReport error", localUnsatisfiedLinkError);
      }
    }
  }
  
  void updateLocalCrashData()
  {
    if (!this.crashControl.controlSwitch) {
      QLog.d("StatisticCollector", 1, "updateLocalCrashData crash control is off..");
    }
    Object localObject;
    do
    {
      return;
      localObject = BaseApplicationImpl.getApplication().startComponentInfo;
      if ((this.crashControl.controlLevel == 2) && ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).contains("QQBroadcastReceiver"))))
      {
        QLog.d("StatisticCollector", 1, "updateLocalCrashData controllevel is 2 but not QQBroadcastReceiver start QQ.");
        return;
      }
      localObject = ctx.getSharedPreferences("crashcontrol", 0);
    } while (localObject == null);
    long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
    int i = ((SharedPreferences)localObject).getInt("crashcount", 0);
    long l2 = System.currentTimeMillis();
    this.dpcExtraInfo.append("updateLocalCrashData startTime=").append(simpleDateFormat.format(new Date(l1))).append(",currenttime=").append(simpleDateFormat.format(new Date(l2))).append(",crashCount=").append(i).append(",mCurUin=").append(this.mCurUin).append("\n");
    if ((l1 <= 0L) || (l2 <= l1) || (i < 0) || (l2 - l1 > this.crashControl.controlWindow * 1000))
    {
      i = 1;
      l1 = l2;
    }
    for (;;)
    {
      if (i > this.crashControl.controlFreq)
      {
        this.shouldStopMsf = true;
        if (isOppoPhoneAndSDK27()) {
          ((SharedPreferences)localObject).edit().putBoolean("crashFrequentLast", true).commit();
        }
      }
      this.dpcExtraInfo.append("updateLocalCrashData shouldStopMsf=").append(this.shouldStopMsf).append("\n");
      ((SharedPreferences)localObject).edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("shouldStopMsf", this.shouldStopMsf).commit();
      return;
      i += 1;
    }
  }
  
  void updateNotRestartData(String paramString1, String paramString2)
  {
    for (;;)
    {
      long l1;
      int j;
      boolean bool3;
      boolean bool2;
      int i;
      long l2;
      try
      {
        SharedPreferences localSharedPreferences = ctx.getSharedPreferences("not_restart_control_file", 4);
        if ((localSharedPreferences == null) || (paramString1 == null) || (paramString2 == null)) {
          break;
        }
        l1 = localSharedPreferences.getLong("starttime", 0L);
        int k = localSharedPreferences.getInt("crashcount", 0);
        j = localSharedPreferences.getInt("key_not_restart_max_crash", 2147483647);
        bool3 = localSharedPreferences.getBoolean("key_not_restart_enable", false);
        String str1 = localSharedPreferences.getString("key_not_restart_crash_type", "notValid");
        String str2 = localSharedPreferences.getString("key_not_restart_crash_stack", "notValid");
        if (paramString1.isEmpty())
        {
          bool1 = false;
          if (paramString2.isEmpty())
          {
            bool2 = false;
            break label311;
            if (i == 0) {
              break;
            }
            l2 = System.currentTimeMillis();
            if ((l1 <= 0L) || (l2 <= l1) || (k < 0)) {
              break label331;
            }
            if (l2 - l1 <= 86400000L) {
              continue;
            }
            break label331;
            QLog.e("StatisticCollector", 1, "crashCount = " + i + ",allowAutoRestart = " + bool1);
            localSharedPreferences.edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("allowAutoRestart", bool1).commit();
          }
        }
        else
        {
          bool1 = paramString1.equalsIgnoreCase(str1);
          continue;
        }
        bool2 = paramString2.contains(str2);
        break label311;
        i = 0;
        continue;
        i = k + 1;
      }
      catch (Throwable paramString1)
      {
        QLog.e("StatisticCollector", 1, "updateNotRestartData error", paramString1);
        return;
      }
      boolean bool1 = true;
      continue;
      label311:
      if ((bool3) && (bool1) && (bool2))
      {
        i = 1;
        continue;
        label331:
        i = 1;
        l1 = l2;
        if (i > j) {
          bool1 = false;
        }
      }
    }
  }
  
  void updatePreloadCrashData(String paramString)
  {
    boolean bool1 = true;
    if (!this.crashControl.controlSwitch) {
      QLog.d("StatisticCollector", 1, "updatePreloadCrashData crash control is off..");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = ctx.getSharedPreferences("CrashControl_" + paramString, 4);
    } while (localSharedPreferences == null);
    long l1 = localSharedPreferences.getLong("starttime", 0L);
    int i = localSharedPreferences.getInt("crashcount", 0);
    boolean bool2 = localSharedPreferences.getBoolean("allowpreload", true);
    long l2 = System.currentTimeMillis();
    this.dpcExtraInfo.append("updatePreloadCrashData process=").append(paramString).append(",startTime=").append(simpleDateFormat.format(new Date(l1))).append(",currenttime=").append(simpleDateFormat.format(new Date(l2))).append(",crashCount=").append(i).append(",allowPreload=").append(bool2).append(",mCurUin=").append(this.mCurUin).append("\n");
    if ((l1 <= 0L) || (l2 <= l1) || (i < 0) || (l2 - l1 > this.crashControl.controlWindow * 1000))
    {
      i = 1;
      l1 = l2;
    }
    for (;;)
    {
      if (i > this.crashControl.controlFreq) {
        bool1 = false;
      }
      this.dpcExtraInfo.append("updatePreloadCrashData update allowPreload=").append(bool1).append("\n");
      localSharedPreferences.edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("allowpreload", bool1).putInt("controlwindow", this.crashControl.controlWindow).commit();
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticCollector
 * JD-Core Version:    0.7.0.1
 */