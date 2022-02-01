package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bridge.ReportControllerServiceHolder;
import com.tencent.mobileqq.bridge.statistics.service.ILocalMultiProcConfigService;
import com.tencent.mobileqq.bridge.statistics.service.IStatisticsCollectorService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class StatisticCollector
{
  public static final String ADD_FRIEND_SOURCE = "addFriendSource";
  public static final String AE_CAMERA_ARK_VIDEO_UPLOAD_STATISTIC_TAG = "ae_camera_ark_video_upload_statistic_tag";
  public static final String AIO_EMOTICON_MONITOR = "AIOEmoticonMonitor";
  public static final String ALBUM_QUERY_MEDIA = "album_query_media";
  public static final String ALL_C2C_PTT_UPLOAD_STATISTIC_TAG = "actAllC2CPttUp";
  private static final String APP_STATISTIC_TAG = "AndroidQQUseApp";
  public static final String BASE_DYNAMIC_AVATAR_UPLOAD_STATISTIC_TAG = "actBaseDynamicAvatarUpload";
  public static final String BDH_SWITCH_CHNL = "actSwitchChnl";
  public static final String BUSINESS_CARD_PIC_UPLOAD_STATISTIC_TAG = "actBusinessCardPicUpload";
  public static final String C2B_UPLOAD_FILE_TAG = "C2BUploadFile";
  public static final String C2C_PICDOWN_STATISTIC_TAG = "actC2CPicDownloadV1";
  public static final String C2C_PICUP_STATISTIC_TAG = "actC2CPicUploadV1";
  public static final String C2C_PICUP_STATISTIC_TAG_V2 = "actC2CPicUploadV2";
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
  public static final String CUSTOM_PHOTO_SEND = "sv_custom_photo_send";
  private static final String DAILY_USE_TAG = "mqq_dailyUse";
  public static final String DANMAKU_REQUEST_MONITOR = "DanmakuRequestMonitor";
  private static final long DAY = 86400000L;
  public static final String DBFIX_DEVICE_INFO_REPORT = "dbfixDeviceInfoReport";
  public static final String DBFIX_INTEGRITY_CHECK_INFO_REPORT = "dbfixIntegrityCheckInfoReport";
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
  public static final String EXTEND_FRIEND_SOUND_UPLOAD_TAG = "actExtendFriendSoundUpload";
  public static final String FACEREGISTER_PIC_MSG_UPLOAD_STATISTIC_TAG = "facePicUploadProcess";
  private static final String FBG_STATISTIC_TAG = "AndroidQQRunTime";
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
  public static final String ICON_CLICK_LAUNCH_TO_UNREAD_REFRESH = "launchFromIconClickToUnreadRefresh";
  public static final String ILLEGAL_GRAYTIP_ID = "illegalGraytipId";
  public static final String IMG_PROVIDERSERVICE_GET_TOPACTIVITY = "ImageProviderService_getTopActivity_event";
  public static final long INIT_DELAY_TIME = 3000L;
  public static final String INNER_DNS_BAD_IP = "actDnsBadIp";
  public static final String INNER_DNS_REQ = "actDnsReq";
  public static final String KANDIAN_UGC_PIC_UPLOAD_TAG = "KandianUGCPicUpload";
  public static final String KANDIAN_UGC_VIDEO_UPLOAD_TAG = "KandianUGCVideoUpload";
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
  public static final String QZONE_EXTEND_STARTUP_COST_WARM_NORMAL = "QzoneExtendStartupCost_Warm_Normal";
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
  public static final String QZONE_STARTUP_COST_WARM_NORMAL = "QzoneStartupCost_Warm_Normal";
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
  public static final String REG_FAIL_CODE = "prxyRegFailCode";
  public static final String REG_LOOKUP_CODER_NULL = "prxyLookupCoderNull";
  public static final String REG_NEED_PULL_GROUP = "prxyRegNeedPullGroup";
  public static final String REG_REGISTER_B = "prxyRegisterB";
  public static final String REG_REGISTER_M = "prxyRegisterM";
  public static final String REG_REGISTER_T = "prxyRegisterT";
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
  public static final String STATISTIC_KEY_FOR_UPLOAD_PIC = "PicStatisticsManagerUploadPic";
  public static final String STORY_PIC_UPLOAD_STATISTIC_TAG = "actStoryPicUpload";
  public static final String STORY_VIDEO_UPLOAD_STATISTIC_TAG = "actStoryVideoUpload";
  public static final String STREAM_VIDEO_PLAY = "actStreamingVideoPlay";
  public static final String STUDY_ROOM_PIC_UPLOAD_TAG = "studyRoomPicUpload";
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
  public static final String TROOP_MEMBER_SEARCH_BUILD_INDEX_COST = "tMSearchBuiltIndexCost";
  public static final String TROOP_MEMBER_SEARCH_UPDATE_REQ = "tMSearchUpdateReq";
  public static final String TROOP_PIC_DOWNLOAD_STATISTIC_TAG = "actGroupPicDownloadV1";
  public static final String TROOP_PIC_UPLOAD_STATISTIC_TAG = "actGroupPicUploadV1";
  public static final String TROOP_PIC_UPLOAD_STATISTIC_TAG_V2 = "actGroupPicUploadV2";
  public static final String TROOP_PTT_DOWNLOAD_STATISTIC_TAG = "actGrpPttDown";
  public static final String TROOP_PTT_UPLOAD_STATISTIC_TAG = "actGrpPttUp";
  public static final String TROOP_SENDGRPTMP_STATISTIC_TAG = "dim.actSendGrpTmpMsg";
  public static final String TROOP_SMAILLPIC_DOWNLOAD_STATISTIC_TAG = "actGroupPicSmallDownV1";
  public static final String TROOP_TXT_STATISTIC_TAG = "actSendGroupProcess";
  public static final String VIDEO_MESSAGE_TIME = "actVideoMessageTime";
  public static final String WECHAT_NS_LOAD_FAIL = "actWechatNsLoadFail";
  public static final String WPA_MSG_UPLOAD_STATISTIC_TAG = "dim.actSendWpaMsg";
  private static boolean bReportingDailyUser = false;
  static Context ctx;
  private static final Random random = new Random();
  private static volatile StatisticCollector self;
  private static final int timezoneMillDelta = 28800000;
  private StatisticCollector.ProductInfo[] appReports = { new StatisticCollector.ProductInfo("com.tencent.mtt", "qqBrowser"), new StatisticCollector.ProductInfo("com.tencent.android.qqdownloader", "qqMarket"), new StatisticCollector.ProductInfo("com.tencent.qqgame", "qqGame"), new StatisticCollector.ProductInfo("com.tencent.qqmusic", "qqMusic"), new StatisticCollector.ProductInfo("com.tencent.news", "qqNews"), new StatisticCollector.ProductInfo("com.qq.reader", "qqReader"), new StatisticCollector.ProductInfo("com.tencent.qqlive", "qqVideo"), new StatisticCollector.ProductInfo("com.tencent.wblog", "qqMicroblog"), new StatisticCollector.ProductInfo("com.tencent.qqphonebook", "qqPhonebook") };
  
  protected StatisticCollector(Context paramContext)
  {
    ctx = paramContext;
  }
  
  private StatisticCollector(Context paramContext, long paramLong)
  {
    ctx = paramContext;
    QQBeaconReport.a();
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
    for (;;)
    {
      Object localObject = this.appReports;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i].packageName;
      if (paramString.toLowerCase().contains((CharSequence)localObject)) {
        return this.appReports[i].reportKeyWord;
      }
      i += 1;
    }
    return null;
  }
  
  private static Map<String, String> getDeviceStatistics()
  {
    HashMap localHashMap = new HashMap(16);
    localHashMap.put("param_MODEL", DeviceInfoUtil.f());
    localHashMap.put("param_manu", DeviceInfoUtil.w());
    localHashMap.put("param_OS", DeviceInfoUtil.g());
    localHashMap.put("param_Resolution", MsfSdkUtils.getResolutionString(ctx));
    localHashMap.put("param_IMEI", DeviceInfoUtil.b());
    localHashMap.put("param_IMSI", DeviceInfoUtil.c());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(NetworkUtil.getNetworkType(ctx));
    localHashMap.put("param_NetworkType", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(AppSetting.d());
    localHashMap.put("param_ProductVersion", ((StringBuilder)localObject).toString());
    localHashMap.put("param_CPU", DeviceInfoUtil.m());
    localHashMap.put("param_totalmemory", MsfSdkUtils.getTotalMemory());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf(DeviceInfoUtil.r() / 1024L));
    ((StringBuilder)localObject).append("kB");
    localHashMap.put("param_availmemory", ((StringBuilder)localObject).toString());
    localObject = DeviceInfoUtil.p();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(localObject[0]));
    localStringBuilder.append("MB");
    localHashMap.put("param_totalrom", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(localObject[1]));
    localStringBuilder.append("MB");
    localHashMap.put("param_availrom", localStringBuilder.toString());
    localObject = DeviceInfoUtil.q();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(localObject[0]));
    localStringBuilder.append("MB");
    localHashMap.put("param_totalsd", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(localObject[1]));
    localStringBuilder.append("MB");
    localHashMap.put("param_availsd", localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(DeviceInfoUtil.n());
    localHashMap.put("param_Camera", ((StringBuilder)localObject).toString());
    return localHashMap;
  }
  
  public static StatisticCollector getInstance(Context paramContext)
  {
    return getInstance(paramContext, 3000L);
  }
  
  public static StatisticCollector getInstance(Context paramContext, long paramLong)
  {
    paramContext = ReportControllerServiceHolder.e();
    if (self == null) {
      try
      {
        if (self == null) {
          if ((paramContext != null) && (paramContext.a())) {
            self = new StatisticCollector(MobileQQ.sMobileQQ, paramLong);
          } else {
            self = new StatisticCollector.EmptyStatisticCollector(MobileQQ.sMobileQQ);
          }
        }
      }
      finally {}
    }
    if (self != null)
    {
      if (paramContext != null) {}
      try
      {
        if ((paramContext.a()) && ((self instanceof StatisticCollector.EmptyStatisticCollector))) {
          self = new StatisticCollector(MobileQQ.sMobileQQ, paramLong);
        }
      }
      finally {}
    }
    return self;
  }
  
  public static int getQzonePatchTag()
  {
    ILocalMultiProcConfigService localILocalMultiProcConfigService = ReportControllerServiceHolder.d();
    int i = 0;
    if (localILocalMultiProcConfigService != null) {
      i = localILocalMultiProcConfigService.b("version_patchlib_load", 0);
    }
    return i;
  }
  
  public static boolean getSqliteSwitchBySample(int paramInt)
  {
    if (paramInt != 3) {
      return false;
    }
    return ((ICommonFunctionPublishConfigService)QRoute.api(ICommonFunctionPublishConfigService.class)).isWalEnable();
  }
  
  private boolean isMultimediaEvent(String paramString)
  {
    IStatisticsCollectorService localIStatisticsCollectorService = ReportControllerServiceHolder.e();
    return (localIStatisticsCollectorService != null) && (localIStatisticsCollectorService.a(paramString));
  }
  
  public static void report(String paramString)
  {
    getInstance(BaseApplication.getContext()).collectPerformance(null, paramString, true, 0L, 0L, null, null);
  }
  
  public static void setQzonePatchTag(int paramInt)
  {
    Object localObject = ReportControllerServiceHolder.d();
    if (localObject != null) {
      ((ILocalMultiProcConfigService)localObject).a("version_patchlib_load", paramInt);
    }
    if (paramInt > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setQzonePatchTag");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("PatchLibLoader", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public static boolean sqlite3Optimizereport()
  {
    return false;
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
    paramString4 = ReportControllerServiceHolder.e();
    if ((paramString4 != null) && (!paramString4.a())) {
      return;
    }
    if (paramString4 != null) {
      paramString4.a(paramString3, paramHashMap);
    }
    paramString4 = paramString2;
    if (paramString2 == null) {
      paramString4 = "10000";
    }
    if (paramString4 != null) {
      paramString4.length();
    }
    if (paramHashMap == null)
    {
      paramString2 = new HashMap();
    }
    else
    {
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
    if (paramString2 != null)
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("");
      paramHashMap.append(AppSetting.d());
      paramString2.put("param_ProductVersion", paramHashMap.toString());
    }
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("event report: ");
      paramHashMap.append(paramString3);
      paramHashMap.append(" ");
      paramHashMap.append(paramBoolean1);
      paramHashMap.append(" time:");
      paramHashMap.append(paramLong1);
      paramHashMap.append(" size:");
      paramHashMap.append(paramLong2);
      QLog.d("StatisticCollector", 2, paramHashMap.toString());
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
      paramString1.setAppId(AppSetting.d());
      paramString1.setTimeout(30000L);
      ThreadManager.post(new StatisticCollector.1(this, paramString1), 5, null, true);
      return;
    }
    catch (Exception paramString1) {}
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
  
  @Deprecated
  public void reportActionCount(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    if ((paramAppRuntime != null) && (paramString1 != null))
    {
      if (paramString2 == null) {
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("|");
      paramString1.append(paramInt);
      paramString1 = paramString1.toString();
      paramString2 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString2.putExtra("sendType", 2);
      paramString2.putExtra("tag", "mqq_tab");
      paramString2.putExtra("content", paramString1);
      paramAppRuntime.startServlet(paramString2);
    }
  }
  
  @Deprecated
  public void reportActionCount(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    if ((paramAppRuntime != null) && (paramString1 != null))
    {
      if (paramString2 == null) {
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("|");
      paramString1.append(paramString3);
      paramString1 = paramString1.toString();
      paramString2 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString2.putExtra("sendType", 2);
      paramString2.putExtra("tag", "mqq_tab");
      paramString2.putExtra("content", paramString1);
      paramAppRuntime.startServlet(paramString2);
    }
  }
  
  @Deprecated
  public void reportActionCount(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((paramAppRuntime != null) && (paramString1 != null) && (paramString2 != null))
    {
      if (paramString3 == null) {
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
      paramString8.append(paramAppRuntime.getAccount());
      paramString8.append('|');
      paramString8.append(paramString1);
      paramString8.append('|');
      paramString8.append(paramString2);
      paramString8.append('|');
      paramString8.append(paramString3);
      paramString8.append('|');
      paramString8.append(paramInt1);
      paramString8.append('|');
      paramString8.append(paramInt2);
      paramString8.append('|');
      paramString8.append(str);
      paramString8.append('|');
      paramString8.append(paramString4);
      paramString8.append('|');
      paramString8.append(paramString5);
      paramString8.append('|');
      paramString8.append(paramString6);
      paramString8.append('|');
      paramString8.append(paramString7);
      paramString8.append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "CliOper");
      paramString1.putExtra("content", paramString8.toString());
      paramAppRuntime.startServlet(paramString1);
    }
  }
  
  @Deprecated
  public void reportActionCountCliOper(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAppRuntime != null) && (paramString1 != null) && (paramString3 != null))
    {
      if (paramString4 == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(paramString1);
      localStringBuilder.append('|');
      localStringBuilder.append(paramString2);
      localStringBuilder.append('|');
      localStringBuilder.append(paramString3);
      localStringBuilder.append('|');
      localStringBuilder.append(paramString4);
      localStringBuilder.append('|');
      localStringBuilder.append(paramInt1);
      localStringBuilder.append('|');
      localStringBuilder.append(paramInt2);
      localStringBuilder.append('|');
      localStringBuilder.append(paramInt3);
      localStringBuilder.append('|');
      localStringBuilder.append('|');
      localStringBuilder.append('|');
      localStringBuilder.append('|');
      localStringBuilder.append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("tag=CliOper,content=");
        paramAppRuntime.append(localStringBuilder.toString());
        QLog.d("StatisticCollector", 2, paramAppRuntime.toString());
      }
    }
  }
  
  @Deprecated
  public void reportActionCountCliOper(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramAppRuntime != null) && (paramString1 != null) && (paramString3 != null))
    {
      if (paramString4 == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(paramString1);
      localStringBuilder.append('|');
      localStringBuilder.append(paramString2);
      localStringBuilder.append('|');
      localStringBuilder.append(paramString3);
      localStringBuilder.append('|');
      localStringBuilder.append(paramString4);
      localStringBuilder.append('|');
      localStringBuilder.append(paramInt1);
      localStringBuilder.append('|');
      localStringBuilder.append(paramInt2);
      localStringBuilder.append('|');
      localStringBuilder.append(paramInt3);
      localStringBuilder.append('|');
      localStringBuilder.append(paramInt4);
      localStringBuilder.append('|');
      localStringBuilder.append('|');
      localStringBuilder.append('|');
      localStringBuilder.append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("tag=CliOper,content=");
        paramAppRuntime.append(localStringBuilder.toString());
        QLog.d("StatisticCollector", 2, paramAppRuntime.toString());
      }
    }
  }
  
  @Deprecated
  public void reportActionCountMsgOper(AppRuntime paramAppRuntime, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "MsgOper");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("tag=MsgOper,content=");
      paramAppRuntime.append(paramString);
      QLog.d("StatisticCollector", 2, paramAppRuntime.toString());
    }
  }
  
  @Deprecated
  public void reportActionCountPCliOper(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAppRuntime != null) && (paramString1 != null) && (paramString4 != null))
    {
      if (paramString5 == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(paramString3);
      localStringBuilder.append('|');
      localStringBuilder.append(paramString1);
      localStringBuilder.append('|');
      localStringBuilder.append("");
      localStringBuilder.append('|');
      localStringBuilder.append(paramString4);
      localStringBuilder.append('|');
      localStringBuilder.append(paramString5);
      localStringBuilder.append('|');
      localStringBuilder.append(paramInt1);
      localStringBuilder.append('|');
      localStringBuilder.append(paramInt2);
      localStringBuilder.append('|');
      localStringBuilder.append(paramInt3);
      localStringBuilder.append('|');
      localStringBuilder.append(paramString2);
      localStringBuilder.append('|');
      localStringBuilder.append('|');
      localStringBuilder.append('|');
      localStringBuilder.append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "P_CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("tag=P_CliOper,content=");
        paramAppRuntime.append(localStringBuilder.toString());
        QLog.d("StatisticCollector", 2, paramAppRuntime.toString());
      }
    }
  }
  
  @Deprecated
  public void reportActionCountRes(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((paramAppRuntime != null) && (paramString1 != null) && (paramString3 != null))
    {
      if (paramString4 == null) {
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
      paramString8.append(paramString1);
      paramString8.append('|');
      paramString8.append(paramString2);
      paramString8.append('|');
      paramString8.append(paramString3);
      paramString8.append('|');
      paramString8.append(paramString4);
      paramString8.append('|');
      paramString8.append(paramInt1);
      paramString8.append('|');
      paramString8.append(paramInt2);
      paramString8.append('|');
      paramString8.append(paramInt3);
      paramString8.append('|');
      paramString8.append(str);
      paramString8.append('|');
      paramString8.append(paramString5);
      paramString8.append('|');
      paramString8.append(paramString6);
      paramString8.append('|');
      paramString8.append(paramString7);
      paramString8.append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "CliOper");
      paramString1.putExtra("content", paramString8.toString());
      paramAppRuntime.startServlet(paramString1);
    }
  }
  
  public void reportButtonClick(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    reportToAds(paramAppRuntime, paramString2, paramInt);
  }
  
  @Deprecated
  public void reportCustomSet(AppRuntime paramAppRuntime, String paramString, Map<String, Integer> paramMap)
  {
    if ((paramAppRuntime != null) && (paramString != null))
    {
      if (paramMap == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(128);
      Object localObject = paramMap.keySet();
      paramString = new ArrayList(paramMap.size());
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localStringBuilder.append(str);
        localStringBuilder.append("|");
        localStringBuilder.append(paramMap.get(str));
        localStringBuilder.append("|");
        paramString.add(localStringBuilder.toString());
        localStringBuilder.delete(0, localStringBuilder.length());
      }
      paramMap = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramMap.putExtra("sendType", 6);
      paramMap.putExtra("tag", "custom_set");
      paramMap.putExtra("content", paramString);
      paramAppRuntime.startServlet(paramMap);
    }
  }
  
  public void reportDailyUser(AppRuntime paramAppRuntime)
  {
    if (bReportingDailyUser) {
      return;
    }
    if (paramAppRuntime != null)
    {
      if (!paramAppRuntime.isLogin()) {
        return;
      }
      Object localObject = ctx.getSharedPreferences("mobileQQ", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("next_reportTime_");
      localStringBuilder.append(paramAppRuntime.getAccount());
      long l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
      long l2 = (NetConnInfoCenter.getServerTimeMillis() + 28800000L) / 86400000L;
      if (l2 >= l1)
      {
        bReportingDailyUser = true;
        localObject = ((SharedPreferences)localObject).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("next_reportTime_");
        localStringBuilder.append(paramAppRuntime.getAccount());
        ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), 1L + l2).commit();
        localObject = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
        ((NewIntent)localObject).putExtra("sendType", 2);
        ((NewIntent)localObject).putExtra("tag", "mqq_dailyUse");
        ((NewIntent)localObject).putExtra("content", "");
        paramAppRuntime.startServlet((NewIntent)localObject);
        if (QLog.isColorLevel())
        {
          paramAppRuntime = new StringBuilder();
          paramAppRuntime.append("Report Daily Use,Next Report Day:");
          paramAppRuntime.append(l2);
          paramAppRuntime.append(1);
          QLog.d("QQInitHandler", 2, paramAppRuntime.toString());
        }
        bReportingDailyUser = false;
      }
    }
  }
  
  public void reportDeviceStatistic(String paramString)
  {
    Map localMap = getDeviceStatistics();
    if (paramString != null)
    {
      if (localMap == null) {
        return;
      }
      paramString = localMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        if ((String)localMap.get(str) == null) {
          localMap.put(str, "");
        }
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("report End_Info:");
        paramString.append(localMap.toString());
        QLog.d("StatisticCollector", 2, paramString.toString());
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
        paramString.setAppId(AppSetting.d());
        paramString.setTimeout(30000L);
        MsfServiceSdk.get().sendMsg(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  @Deprecated
  public void reportOnOff(AppRuntime paramAppRuntime, String paramString, Map<String, Integer> paramMap)
  {
    if ((paramAppRuntime != null) && (paramString != null))
    {
      if (paramMap == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(128);
      Object localObject = paramMap.keySet();
      paramString = new ArrayList(paramMap.size());
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localStringBuilder.append(str);
        localStringBuilder.append("|");
        localStringBuilder.append(paramMap.get(str));
        localStringBuilder.append("|");
        paramString.add(localStringBuilder.toString());
        localStringBuilder.delete(0, localStringBuilder.length());
      }
      paramMap = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramMap.putExtra("sendType", 6);
      paramMap.putExtra("tag", "on_off");
      paramMap.putExtra("content", paramString);
      paramAppRuntime.startServlet(paramMap);
    }
  }
  
  public void reportToAds(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null)
    {
      if (paramString == null) {
        return;
      }
      reportToAds(paramAppRuntime, paramString, 1, "", "", "");
    }
  }
  
  public void reportToAds(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if (paramAppRuntime != null)
    {
      if (paramString == null) {
        return;
      }
      reportToAds(paramAppRuntime, paramString, paramInt, "", "", "");
    }
  }
  
  public void reportToAds(AppRuntime paramAppRuntime, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (paramAppRuntime != null)
    {
      if (paramString1 == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("|");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString4);
      paramString1 = localStringBuilder.toString();
      paramString2 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString2.putExtra("sendType", 2);
      paramString2.putExtra("tag", "appPlug");
      paramString2.putExtra("content", paramString1);
      paramAppRuntime.startServlet(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("reportToAds", 2, paramString1);
      }
    }
  }
  
  public void reportToAds(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if (paramAppRuntime != null)
    {
      if (paramString1 == null) {
        return;
      }
      reportToAds(paramAppRuntime, paramString1, 1, "", "", paramString2);
    }
  }
  
  @Deprecated
  public void reportToPCliOper(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "P_CliOper");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("tag=P_CliOper,content=");
      paramAppRuntime.append(paramString);
      QLog.d("StatisticCollector", 2, paramAppRuntime.toString());
    }
  }
  
  public void setContact(String paramString)
  {
    try
    {
      QQBeaconReport.c(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticCollector
 * JD-Core Version:    0.7.0.1
 */