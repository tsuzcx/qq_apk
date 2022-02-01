package cooperation.qzone;

import common.config.service.QzoneConfig;

public class QZoneHelper$QZoneCoverConstants
{
  public static final String ACTION_COVER_IMG_CROP_END = "action.com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity.cover_img_crop_end";
  public static final String ACTION_SET_COVER_SUCCESS = "action.com.qzone.cover.set_cover_success";
  public static final String CONFIG_PARAM_COVER_SET_JIGSAW = "cover_setjigsaw";
  public static final String COVER_LIST_URL = "https://h5.qzone.qq.com/bgstore/list/{cateid}?_wv=2098179&from={from}&qua={qua}&router=list&cate_id={cateid}&_proxy=1";
  private static final String COVER_PREVIEW_URL = "https://h5.qzone.qq.com/bgstore/detail/{coverid}?_wv=2098179&from={from}&page={page}&qua={qua}&router=detail&coverid={coverid}&uin={uin}&hostUin={hostUin}&_proxy=1";
  public static final String COVER_STORE_ACTIVITY_FULL_NAME = "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity";
  private static final String COVER_STORE_URL = "https://h5.qzone.qq.com/bgcover/index?_wv=2098179&qua={qua}&_proxy=1";
  public static final int FROME_COVER_FEED = 4;
  public static final int FROME_FEED = 1;
  public static final int FROME_FEED_BANNER = 5;
  public static final int FROME_FEED_FRIEND = 9;
  public static final int FROME_FEED_SELF = 8;
  public static final int FROME_PROFILE_CARD = 3;
  public static final int FROME_PROFILE_CARD_BANNER = 7;
  public static final int FROME_USERHOME = 2;
  public static final int FROME_USERHOME_BANNER = 6;
  public static final String INTENT_PARAM_CURRENT_COVER = "current_cover";
  public static final String INTENT_PARAM_DIRECT_SELECTPHOTO = "direct_select_photo";
  public static final String INTENT_PARAM_FROM = "key_from";
  public static final String INTENT_PARAM_JIGSAW_OPEN = "jigsaw_open";
  public static final String INTENT_PARAM_PHOTOWALL_MODE = "photowall_mode";
  public static final String INTENT_PARAM_PHOTOWALL_UPDATED = "photowall_updated";
  public static final String INTENT_PARAM_SET_SOURCE = "set_source";
  public static final String INTENT_PARAM_SHOW_WIDGET_SET = "showWidgetSet";
  public static final String INTENT_PARAM_UIN = "cover_uin";
  public static final String KEY_HIGH_RESOLUTION = "HigeResolutionCover";
  public static final String KEY_LOW_RESOLUTION = "LowResolutionCover";
  private static final String MUSIC_COVER_PREVIEW_URL = "https://h5.qzone.qq.com/musicCover/preview?id={coverid}&_wv=2098179&from={from}&page={page}&qua={qua}&router=detail&coverid={coverid}&uin={uin}&hostUin={hostUin}&_proxy=1";
  private static final String PHOTO_WALL_URL = "https://h5.qzone.qq.com/bgstore/photoWall?_wv=2098179&uin={uin}&hostUin={hostUin}&from={from}&page=1&qua={qua}&router=photoWall&_proxy=1";
  public static final String PRELOAD_COVER_UIN = "preload_cover_uin";
  public static final String PRELOAD_COVER_URL = "preload_cover_url";
  public static final int REQUEST_CODE_COVER_VIDEO_PRIVIEW = 10;
  public static final int REQUEST_CODE_CUSTOM_LOCAL = 2;
  public static final int REQUEST_CODE_CUSTOM_QZONE = 3;
  public static final int REQUEST_CODE_OPEN_VIP = 4;
  public static final int REQUEST_CODE_PHOTOWALL = 1;
  public static final int REQUEST_CODE_SET_COVER = 7;
  public static final int REQUEST_CODE_SET_LOCAL_COVER = 8;
  public static final int REQUEST_CODE_SET_NAVI_DECO = 9;
  public static final int REQUEST_CODE_WIDGET_ENABLE = 6;
  public static final int REQUEST_CODE_WIDGET_ID = 5;
  public static final int SET_SOURCE_PROFILECARD = 1;
  public static final int SET_SOURCE_QZONE = 0;
  public static final int SYNC_FLAG_BOTH = 1;
  
  public static String getCoverListUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return QzoneConfig.getInstance().getConfig("H5Url", "CoverList", "https://h5.qzone.qq.com/bgstore/list/{cateid}?_wv=2098179&from={from}&qua={qua}&router=list&cate_id={cateid}&_proxy=1").replace("{uin}", paramString3).replace("{hostUin}", paramString5).replace("{qua}", QUA.getQUA3()).replace("{pb}", "").replace("{clicktime}", String.valueOf(System.currentTimeMillis())).replace("{from}", paramString1).replace("{page}", paramString2).replace("{cateid}", paramString4);
  }
  
  public static String getCoverPreviewUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return QzoneConfig.getInstance().getConfig("H5Url", "CoverPreview", "https://h5.qzone.qq.com/bgstore/detail/{coverid}?_wv=2098179&from={from}&page={page}&qua={qua}&router=detail&coverid={coverid}&uin={uin}&hostUin={hostUin}&_proxy=1").replace("{qua}", QUA.getQUA3()).replace("{pb}", "").replace("{from}", paramString1).replace("{page}", paramString2).replace("{coverid}", paramString3).replace("{uin}", paramString4).replace("{hostUin}", paramString5);
  }
  
  public static String getCoverStoreUrl(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return QzoneConfig.getInstance().getConfig("H5Url", "CoverStore", "https://h5.qzone.qq.com/bgcover/index?_wv=2098179&qua={qua}&_proxy=1").replace("{uin}", paramString3).replace("{hostUin}", paramString4).replace("{qua}", QUA.getQUA3()).replace("{pb}", "").replace("{clicktime}", String.valueOf(System.currentTimeMillis())).replace("{from}", paramString1).replace("{page}", paramString2);
  }
  
  public static String getMusicCoverPreviewUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return QzoneConfig.getInstance().getConfig("H5Url", "MusicCoverPreview", "https://h5.qzone.qq.com/musicCover/preview?id={coverid}&_wv=2098179&from={from}&page={page}&qua={qua}&router=detail&coverid={coverid}&uin={uin}&hostUin={hostUin}&_proxy=1").replace("{qua}", QUA.getQUA3()).replace("{pb}", "").replace("{from}", paramString1).replace("{page}", paramString2).replace("{coverid}", paramString3).replace("{uin}", paramString4).replace("{hostUin}", paramString5);
  }
  
  public static String getPhotoWallUrl(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramString1 = QzoneConfig.getInstance().getConfig("H5Url", "PhotoWallUrl", "https://h5.qzone.qq.com/bgstore/photoWall?_wv=2098179&uin={uin}&hostUin={hostUin}&from={from}&page=1&qua={qua}&router=photoWall&_proxy=1").replace("{uin}", paramString1).replace("{hostUin}", paramString2).replace("{qua}", QUA.getQUA3());
    paramString2 = new StringBuilder().append("");
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return paramString1.replace("{isPhotoWall}", i).replace("{clicktime}", String.valueOf(System.currentTimeMillis())).replace("{from}", paramString3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.QZoneCoverConstants
 * JD-Core Version:    0.7.0.1
 */