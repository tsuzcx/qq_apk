package cooperation.qzone.video;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class QzoneVideoBeaconReport
{
  public static final String BEACON_SOURCE = "qzone_album_beacon_source";
  public static final String DEFULALT_REFER = "unfinedsource";
  public static final String EVENT_ALBUM_ADD = "qzone_album_add";
  public static final String EVENT_ALBUM_ADD_ALBUM = "qzone_album_add_album";
  public static final String EVENT_ALBUM_ADD_ALBUM_SELECT = "qzone_album_add_album_select";
  public static final String EVENT_ALBUM_ADD_ALBUM_UPLOAD = "qzone_album_add_album_upload";
  public static final String EVENT_ALBUM_ADD_ALBUM_UPLOAD_SUCCESS = "qzone_album_add_album_upload_success";
  public static final String EVENT_ALBUM_BANNER = "qzone_album_banner";
  public static final String EVENT_ALBUM_BANNER_ADD = "qzone_album_banner_add";
  public static final String EVENT_ALBUM_BANNER_ADD_ALBUM = "qzone_album_banner_add_album";
  public static final String EVENT_ALBUM_BANNER_ADD_SELECT = "qzone_album_banner_add_select";
  public static final String EVENT_ALBUM_BANNER_ADD_UPLOAD = "qzone_album_banner_add_upload";
  public static final String EVENT_ALBUM_BANNER_ALBUM = "qzone_album_banner_album";
  public static final String EVENT_ALBUM_BANNER_ALBUM_PHOTO = "qzone_album_banner_album_photo";
  public static final String EVENT_ALBUM_BANNER_ALBUM_SELECT = "qzone_album_banner_album_select";
  public static final String EVENT_ALBUM_BANNER_ALBUM_UPLOAD = "qzone_album_banner_album_upload";
  public static final String EVENT_ALBUM_BANNER_GUIDE = "qzone_album_banner_guide";
  public static final String EVENT_ALBUM_BANNER_GUIDE_UPLOAD = "qzone_album_banner_guide_upload";
  public static final String EVENT_ALBUM_GUIDE = "qzone_album_guide";
  public static final String EVENT_ALBUM_GUIDE_UPLOAD = "qzone_album_guide_upload";
  public static final String EVENT_ALBUM_LIST = "qzone_album_list";
  public static final String EVENT_ALBUM_LIST_ADD = "qzone_album_list_add";
  public static final String EVENT_ALBUM_LIST_ADD_ALBUM = "qzone_album_list_add_album";
  public static final String EVENT_ALBUM_LIST_ADD_SELECT = "qzone_album_list_add_select";
  public static final String EVENT_ALBUM_LIST_ADD_UPLOAD = "qzone_album_list_add_upload";
  public static final String EVENT_ALBUM_LIST_ALBUM = "qzone_album_list_album";
  public static final String EVENT_ALBUM_LIST_ALBUM_PHOTO = "qzone_album_list_album_photo";
  public static final String EVENT_ALBUM_LIST_ALBUM_SELECT = "qzone_album_list_album_select";
  public static final String EVENT_ALBUM_LIST_ALBUM_UPLOAD = "qzone_album_list_album_upload";
  public static final String EVENT_ALBUM_LIST_GUIDE = "qzone_album_list_guide";
  public static final String EVENT_ALBUM_LIST_GUIDE_UPLOAD = "qzone_album_list_guide_upload";
  public static final String EVENT_ALBUM_OTHER = "qzone_album_other";
  public static final String EVENT_ALBUM_OTHER_ADD = "qzone_album_other_add";
  public static final String EVENT_ALBUM_OTHER_ADD_ALBUM = "qzone_album_other_add_album";
  public static final String EVENT_ALBUM_OTHER_ADD_SELECT = "qzone_album_other_add_select";
  public static final String EVENT_ALBUM_OTHER_ADD_UPLOAD = "qzone_album_other_add_upload";
  public static final String EVENT_ALBUM_OTHER_ALBUM = "qzone_album_other_album";
  public static final String EVENT_ALBUM_OTHER_ALBUM_PHOTO = "qzone_album_other_album_photo";
  public static final String EVENT_ALBUM_OTHER_ALBUM_SELECT = "qzone_album_other_album_select";
  public static final String EVENT_ALBUM_OTHER_ALBUM_UPLOAD = "qzone_album_other_album_upload";
  public static final String EVENT_ALBUM_OTHER_GUIDE = "qzone_album_other_guide";
  public static final String EVENT_ALBUM_OTHER_GUIDE_UPLOAD = "qzone_album_other_guide_upload";
  public static final String EVENT_BANNER_CLICK_GIF = "qzone_album_banner_click_gif";
  public static final String EVENT_BANNER_EXPLODE_GIF = "qzone_album_banner_explode_gif";
  public static final String EVENT_BANNER_EXPLODE_PHOTO = "qzone_album_banner_photo_explode";
  public static final String EVENT_LIVEVIDEO_GETHUANGZUAN_ICON = "qzone_livevideo_gethuangzuanicon";
  public static final String EVENT_LIVE_VIDEO_ENTRY = "live_video_entry";
  public static final String EVENT_LIVE_VIDEO_FF_USE = "live_video_ff_use";
  public static final String EVENT_LIVE_VIDEO_FF_USED = "live_video_ff_used";
  public static final String EVENT_PHOTO_GUIDE_CARD_DETAIL_CLICK_CANCEL_SELECTED = "photo_guide_card_detail_click_cancel_selected";
  public static final String EVENT_PHOTO_GUIDE_CARD_DETAIL_CLICK_RETURN_BTN = "photo_guide_card_detail_click_return_btn";
  public static final String EVENT_PHOTO_GUIDE_CARD_DETAIL_CLICK_UPLOAD_BTN = "photo_guide_card_detail_click_upload_btn";
  public static final String EVENT_PHOTO_GUIDE_CARD_DETAIL_EXPLORE = "photo_guide_card_detail_explore";
  public static final String EVENT_PHOTO_GUIDE_FRIEND_FEED_ENTRY_CLICK = "photo_guide_friend_feed_entry_click";
  public static final String EVENT_PHOTO_GUIDE_FRIEND_FEED_ENTRY_EXPLORE = "photo_guide_friend_feed_entry_explore";
  public static final String EVENT_PHOTO_GUIDE_PHOTO_LIST_ENTRY_CLICK = "photo_guide_photo_list_entry_click";
  public static final String EVENT_PHOTO_GUIDE_PHOTO_LIST_ENTRY_EXPLORE = "photo_guide_photo_list_entry_explore";
  public static final String EVENT_PHOTO_GUIDE_UPLOAD_PHOTOS_CLICK_CARD = "photo_guide_upload_photos_click_card";
  public static final String EVENT_PHOTO_GUIDE_UPLOAD_PHOTOS_CLICK_CLOSE_BTN = "photo_guide_upload_photos_click_close_btn";
  public static final String EVENT_PHOTO_GUIDE_UPLOAD_PHOTOS_CLICK_UPLOAD_BTN = "photo_guide_upload_photos_click_upload_btn";
  public static final String EVENT_PHOTO_GUIDE_UPLOAD_PHOTOS_EXPLORE = "photo_guide_upload_photos_explore";
  public static final String EVENT_PLAY_ACTIVITY_DEFAULT = "qzone_play_activity_default";
  public static final String EVENT_PLAY_ACTIVITY_DEFAULT_COUNT = "qzone_play_activity_default_count";
  public static final String EVENT_PLAY_ACTIVITY_VERTICAL_PRELOAD = "qzone_play_activity_vertical_preload";
  public static final String EVENT_PLAY_ACTIVITY_VERTICAL_VIDEOLAYER = "qzone_play_activity_vertical_videolayer";
  public static final String EVENT_PLAY_ACTIVITY_VERTICAL_VIDEOLAYER_COUNT = "qzone_play_activity_vertical_videolayer_count";
  public static final String EVENT_PLAY_H265_VIDEO = "qzone_play_h265_video";
  public static final String EVENT_PLAY_HARDWARE_DECODER_NAME = "qzone_play_hardware_decoder_name";
  public static final String EVENT_PLAY_LOCAL_VIDEO = "play_local_video";
  public static final String EVENT_PLAY_PLAYER_TYPE = "qzone_play_player_type";
  public static final String EVENT_PLAY_PROXY_INTERNAL_ERROR_V2 = "qzone_play_proxy_internal_error_v2";
  public static final String EVENT_QZ_PLAY_H265_CHOOSE_STREAM = "qzone_play_choose_h265_stream";
  public static final String EVENT_QZ_PLAY_H265_DEC_STATUS = "qzone_play_h265_dec_status";
  public static final String EVENT_QZ_PLAY_H265_PROBE_RESULT = "qzone_play_h265_probe_result";
  public static final String EVENT_QZ_PLAY_SCF_QUERY_RESULT = "qzone_play_scf_query_result";
  public static final String EVENT_QZ_PLAY_SCF_QUERY_TIME = "qzone_play_scf_query_time";
  public static final String EVENT_QZ_PLAY_SCF_REPORT_RESULT = "qzone_play_scf_report_result";
  public static final String EVENT_QZ_PLAY_SCF_REPORT_TIME = "qzone_play_scf_report_time";
  public static final String EVENT_QZ_PLAY_STREAM_ENC_H264 = "qzone_play_stream_enc_h264";
  public static final String EVENT_QZ_PLAY_STREAM_ENC_H265 = "qzone_play_stream_enc_h265";
  public static final String EVENT_QZ_PLAY_STREAM_ENC_UNKNOWN = "qzone_play_stream_enc_unknown";
  public static final String EVENT_QZ_PLAY_STREAM_H265 = "qzone_play_stream_h265";
  public static final String EVENT_QZ_PLAY_STREAM_HLS = "qzone_play_stream_hls";
  public static final String EVENT_QZ_PLAY_STREAM_NOSTREAM = "qzone_play_stream_nostream";
  public static final String EVENT_QZ_PLAY_STREAM_OTHER = "qzone_play_stream_other";
  public static final String EVENT_QZ_PLAY_STREAM_RESOLUTION = "qzone_play_stream_resolution";
  public static final String EVENT_QZ_PLAY_STREAM_UNKNOWN = "qzone_play_stream_unknown";
  public static final String EVENT_SHUOSHUO_GIF_ICON = "qzone_shuoshuo_gif_icon";
  public static final String EVENT_SHUOSHUO_PAGE_EXPLODE = "qzone_shuoshuo_page_explode";
  public static final String EVENT_SHUOSHUO_PAGE_GIF_ICON_EXPLODE = "qzone_shuoshuo_gificon_explode";
  public static final String EVENT_SHUOSHUO_PAGE_GIF_ICON_PUBLISH = "qzone_shuoshuo_gificon_publish";
  public static final String EVENT_SHUOSHUO_PAGE_GUIDE_PAGE_PUBLISH = "qzone_shuoshuo_guidepage_publish";
  public static final String EVENT_SHUOSHUO_PAGE_PUBLISH_CLICK = "qzone_shuoshuo_publish_click";
  public static final String EVENT_SHUOSHUO_PAGE_PUBLISH_GIF = "qzone_shuoshuo_publish_gif";
  public static final String EVENT_TRIM_VIDEO_COST_HW = "qzone_trim_video_cost_hw";
  public static final String EVENT_TRIM_VIDEO_COST_SW = "qzone_trim_video_cost_sw";
  public static final String EVENT_TRIM_VIDEO_SPEED_HW = "qzone_trim_video_speed_hw";
  public static final String EVENT_TRIM_VIDEO_SPEED_SW = "qzone_trim_video_speed_sw";
  public static final String EVENT_UNIKINGCARD_SIMINFO = "qzone_unikingcard_get_siminfo";
  public static final String EVENT_VERTICALVIDEO_PRELOAD_FEEDS = "qzone_verticalvideo_preload_feeds";
  public static final String EVENT_VERTICAL_VIDEO_ENTRY = "vertical_video_entry";
  public static final String EVENT_VIDEO_ENTRANCE = "qzone_video_entrance";
  public static final String EVENT_VIDEO_PUBLISH = "qzone_video_publishactivity";
  public static final String EVENT_VIDEO_PUBLISHQUEUE = "qzone_video_uploadhqueue";
  public static final String EVENT_VIDEO_RECORD = "qzone_video_record";
  public static final String EVENT_VIDEO_TRIM = "qzone_video_trim";
  public static final String EVENT_VIDEO_UPLOAD = "qzone_video_uploadstart";
  public static final String EVEVT_VIDEO_TRIMRECORD = "qzone_video_recordtrim";
  public static final String KEY_ENCODE_HW_SUCCESS = "record_hw_success";
  public static final String KEY_ENCODE_SUCCESS = "record_success";
  public static final String KEY_ENCODE_SW_SUCCESS = "record_sw_success";
  public static final String KEY_PLAY_LOCAL_VIDEO_SUCCESS = "play_local_video_success";
  public static final String KEY_VIDEO_TRIM_HW_SUCCESS = "trim_hw_success";
  public static final String KEY_VIDEO_TRIM_HW_SUPPORT = "trim_hw_support";
  public static final String KEY_VIDEO_TRIM_RETRY_NUM = "trim_retry_num";
  public static final String KEY_VIDEO_TRIM_RETRY_RES = "trim_retry_res";
  public static final String KEY_VIDEO_TRIM_SUCCESS = "trim_success";
  public static final String KEY_VIDEO_TRIM_SW_SUCCESS = "trim_sw_success";
  public static final String RESULTCODE_ENCODE_ERROR = "1";
  public static final String RESULTCODE_ENCODE_HW_ERROR = "1";
  public static final String RESULTCODE_ENCODE_HW_SUCCESS = "0";
  public static final String RESULTCODE_ENCODE_SUCCESS = "0";
  public static final String RESULTCODE_ENCODE_SW_ERROR = "1";
  public static final String RESULTCODE_ENCODE_SW_SUCCESS = "0";
  public static final String RESULTCODE_ENTRANCE_ALBUMLIST = "1";
  public static final String RESULTCODE_ENTRANCE_DRAFT = "4";
  public static final String RESULTCODE_ENTRANCE_FRIENDFEED = "0";
  public static final String RESULTCODE_ENTRANCE_MYVIDEO = "2";
  public static final String RESULTCODE_ENTRANCE_PHOTOPLUS = "5";
  public static final String RESULTCODE_ENTRANCE_SCHEME = "3";
  public static final String RESULTCODE_FIRST = "0";
  public static final String RESULTCODE_GETBEGINFRAME_FAILED = "5";
  public static final String RESULTCODE_GETDCIM_ERROR = "15";
  public static final String RESULTCODE_GETFIRSTFRAME_FAILED = "3";
  public static final String RESULTCODE_INIT_TRIM_ENGINE_ERROR = "2";
  public static final String RESULTCODE_INIT_TRIM_ENGINE_PATH_ERROR = "3";
  public static final String RESULTCODE_LIVE_VIDEO_CALLING = "7";
  public static final String RESULTCODE_LIVE_VIDEO_CAMERA_USING = "8";
  public static final String RESULTCODE_LIVE_VIDEO_CANCEL_DOWNLOAD = "9";
  public static final String RESULTCODE_LIVE_VIDEO_CLICK = "0";
  public static final String RESULTCODE_LIVE_VIDEO_NO_NETWORK = "2";
  public static final String RESULTCODE_LIVE_VIDEO_PARAM_ERR = "6";
  public static final String RESULTCODE_LIVE_VIDEO_PTU_SO = "3";
  public static final String RESULTCODE_LIVE_VIDEO_SDK_NO_REPORT = "1";
  public static final String RESULTCODE_LIVE_VIDEO_STL_SO = "4";
  public static final String RESULTCODE_LIVE_VIDEO_UPGRADING = "5";
  public static final String RESULTCODE_LOAD_LOCAL_VIDEO_TIMEOUT = "1";
  public static final String RESULTCODE_LOAD_SO_FAILED = "-1";
  public static final String RESULTCODE_LOWMEMORY = "9";
  public static final String RESULTCODE_NOENOUGHSTORAGE = "8";
  public static final String RESULTCODE_NOFILESIZE = "7";
  public static final String RESULTCODE_NOT_FIRST = "1";
  public static final String RESULTCODE_NOT_USED = "1";
  public static final String RESULTCODE_PLAY_LOCAL_VIDEO_FAILED = "4";
  public static final String RESULTCODE_PLAY_LOCAL_VIDEO_SUCCESS = "0";
  public static final String RESULTCODE_RECORD_AUDIOINIT_FAILED = "5";
  public static final String RESULTCODE_RECORD_AUDIOOPEN_FAILED = "6";
  public static final String RESULTCODE_RECORD_AUDIOSTART_FAILED = "7";
  public static final String RESULTCODE_RECORD_CAMERAPARAM_FAILED = "3";
  public static final String RESULTCODE_RECORD_CAMERA_DISABLED = "4";
  public static final String RESULTCODE_RECORD_CREATECAMERA_FAILED = "2";
  public static final String RESULTCODE_RECORD_ENCODE_GETDCIM_FAILED = "10";
  public static final String RESULTCODE_RECORD_ENCODE_NOFILE = "9";
  public static final String RESULTCODE_RECORD_INITTMM_FAILED = "0";
  public static final String RESULTCODE_RECORD_PREVIEWDATA_ERROR = "8";
  public static final String RESULTCODE_RECORD_SDCARD_REMOVED = "1";
  public static final String RESULTCODE_SAVETHUMBNAIL_FAILED = "4";
  public static final String RESULTCODE_SDCARD_NOTMOUNT = "6";
  public static final String RESULTCODE_THUMBNAILUTILS_INIT_FAILED = "2";
  public static final String RESULTCODE_TRIMTIME_ERROR = "14";
  public static final String RESULTCODE_TRIM_CANCEL = "18";
  public static final String RESULTCODE_TRIM_DIRECT_UPLOAD = "25";
  public static final String RESULTCODE_TRIM_ERROR = "17";
  public static final String RESULTCODE_TRIM_HW_CANCEL = "22";
  public static final String RESULTCODE_TRIM_HW_ERROR = "21";
  public static final String RESULTCODE_TRIM_HW_NOTSUPPORT = "19";
  public static final String RESULTCODE_TRIM_HW_SUCCESS = "20";
  public static final String RESULTCODE_TRIM_HW_SUPPORT = "18";
  public static final String RESULTCODE_TRIM_LOWMEMORY = "22";
  public static final String RESULTCODE_TRIM_SERVICE_CONNECT_FAILED = "24";
  public static final String RESULTCODE_TRIM_SERVICE_DISCONNECT = "23";
  public static final String RESULTCODE_TRIM_SUCCESS = "16";
  public static final String RESULTCODE_TRIM_SW_CANCEL = "22";
  public static final String RESULTCODE_TRIM_SW_ERROR = "21";
  public static final String RESULTCODE_TRIM_SW_SUCCESS = "20";
  public static final String RESULTCODE_UPLOAD_VIDEO_CANCLE = "-1";
  public static final String RESULTCODE_UPLOAD_VIDEO_FAIL = "-2";
  public static final String RESULTCODE_UPLOAD_VIDEO_SUCCESS = "0";
  public static final String RESULTCODE_USED = "0";
  public static final String RESULTCODE_VERTICAL_VIDEO_CANCEL_DOWNLOAD = "9";
  public static final String RESULTCODE_VIDEOFILE_ISNULL = "12";
  public static final String RESULTCODE_VIDEOFILE_NOTEXIST = "13";
  public static final String RESULTCODE_VIDEOFORMAT_NOTSUPPORT = "10";
  public static final String RESULTCODE_VIDEOVIEW_LOAD_FAILED = "1";
  public static final String RESULTCODE_VIDEOVIEW_LOAD_TIMEOUT = "11";
  public static final String RESULTCODE_VIDEO_PUBLISH_OTHER = "2";
  public static final String RESULTCODE_VIDEO_PUBLISH_RECORD = "0";
  public static final String RESULTCODE_VIDEO_PUBLISH_TRIM = "1";
  public static final String RESULTCODE_VIDEO_RECORD_OPEN = "0";
  public static final String RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED = "1004";
  public static final String RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR = "1005";
  public static final String RESULTCODE_VIDEO_TRIIMRECORD_INSTALLERROR = "1006";
  public static final String RESULTCODE_VIDEO_TRIIMRECORD_PARAMERROR = "1002";
  public static final String RESULTCODE_VIDEO_TRIIMRECORD_VIDEOCHATTING = "1003";
  public static final String RESULTCODE_VIDEO_TRIIM_OPEN = "1";
  public static final String RESULTCODE_VIDEO_TRIMRECORD_FAIL = "1000";
  public static final String RESULTCODE_VIDEO_TRIMRECORD_UNSUPPORT = "1001";
  
  public static void reportAlbumEvent(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, new HashMap(), null);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("event:");
      paramString1.append(paramString2);
      QLog.d("QzoneVideoBeaconReport", 2, paramString1.toString());
    }
  }
  
  public static void reportAlbumEvent(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    String str = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      str = "unfinedsource";
    }
    localHashMap.put("refer", str);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("event:");
      paramString1.append(paramString2);
      paramString1.append(" refer = ");
      paramString1.append(str);
      QLog.d("QzoneVideoBeaconReport", 2, paramString1.toString());
    }
  }
  
  public static void reportAlbumEvent(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    String str = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      str = "unfinedsource";
    }
    paramString3 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString3 = "0";
    }
    localHashMap.put("refer", str);
    localHashMap.put("type", paramString3);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("event:");
      paramString1.append(paramString2);
      paramString1.append(" refer = ");
      paramString1.append(str);
      paramString1.append("type =");
      paramString1.append(paramString3);
      QLog.d("QzoneVideoBeaconReport", 2, paramString1.toString());
    }
  }
  
  public static void reportQzoneLiveEvent(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    String str = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      str = "unfinedsource";
    }
    localHashMap.put("event_result", str);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("event:");
      paramString1.append(paramString2);
      paramString1.append(" refer = ");
      paramString1.append(str);
      QLog.d("QzoneVideoBeaconReport", 2, paramString1.toString());
    }
  }
  
  public static void reportVideoEvent(String paramString1, String paramString2, long paramLong)
  {
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString1, paramString2, true, paramLong, 0L, new HashMap(), null);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("event:");
      paramString1.append(paramString2);
      paramString1.append(" duration:");
      paramString1.append(paramLong);
      QLog.d("QzoneVideoBeaconReport", 2, paramString1.toString());
    }
  }
  
  public static void reportVideoEvent(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", paramString3);
    localHashMap.put("reserve", paramString4);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("event:");
      paramString1.append(paramString2);
      paramString1.append(" resultCode:");
      paramString1.append(paramString3);
      paramString1.append(" reserve:");
      paramString1.append(paramString4);
      QLog.d("QzoneVideoBeaconReport", 2, paramString1.toString());
    }
  }
  
  public static void reportVideoEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString3, paramString4);
    localHashMap.put("reserve", paramString5);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("event:");
      paramString1.append(paramString2);
      paramString1.append(" key:");
      paramString1.append(paramString3);
      paramString1.append(" value:");
      paramString1.append(paramString4);
      paramString1.append(", reserve:");
      paramString1.append(paramString5);
      QLog.d("QzoneVideoBeaconReport", 2, paramString1.toString());
    }
  }
  
  public static void reportVideoEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramHashMap);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("event:");
      paramString1.append(paramString2);
      QLog.d("QzoneVideoBeaconReport", 2, paramString1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVideoBeaconReport
 * JD-Core Version:    0.7.0.1
 */