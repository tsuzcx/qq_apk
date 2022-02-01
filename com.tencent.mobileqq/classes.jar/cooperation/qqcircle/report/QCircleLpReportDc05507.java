package cooperation.qqcircle.report;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;

public class QCircleLpReportDc05507
{
  public static final String KEY_ACTIONTYPE = "actiontype";
  public static final String KEY_ACTTIME = "acttime";
  public static final String KEY_AUTHOR_UIN = "author_uin";
  public static final String KEY_CLEAR = "clear";
  public static final String KEY_CUBAGE = "cubage";
  public static final String KEY_ERROR_CODE = "errorcode";
  public static final String KEY_EXT_1 = "ext1";
  public static final String KEY_EXT_10 = "ext10";
  public static final String KEY_EXT_2 = "ext2";
  public static final String KEY_EXT_3 = "ext3";
  public static final String KEY_EXT_4 = "ext4";
  public static final String KEY_EXT_5 = "ext5";
  public static final String KEY_EXT_6 = "ext6";
  public static final String KEY_EXT_7 = "ext7";
  public static final String KEY_EXT_8 = "ext8";
  public static final String KEY_EXT_9 = "ext9";
  public static final String KEY_FEEDID = "feedid";
  public static final String KEY_FEEDTYPE1 = "feedtype1";
  public static final String KEY_FEEDTYPE2 = "feedtype2";
  public static final String KEY_FEEDTYPE3 = "feedtype3";
  public static final String KEY_FEED_TAG = "feed_tag";
  public static final String KEY_FEED_URL = "feeds_url";
  public static final String KEY_FFPAGE_ID = "ffpage_id";
  public static final String KEY_FPAGE_ID = "fpage_id";
  public static final String KEY_HEIGHT = "height";
  public static final String KEY_IS_AUTO_PLAY = "is_auto_play";
  public static final String KEY_ITEM_DETAIL = "item_detail";
  public static final String KEY_LLOC = "lloc";
  public static final String KEY_LUOMA_TRANSFER = "luoma_transfe";
  public static final String KEY_PAGE_ID = "page_id";
  public static final String KEY_PIC_INFO = "pic_info";
  public static final String KEY_PLAY_ID = "play_id";
  public static final String KEY_PLAY_SCENE = "play_scene";
  public static final String KEY_PLAY_URL = "play_url";
  public static final String KEY_POSITION_ID = "position_id";
  public static final String KEY_REQUESTID = "requestid";
  public static final String KEY_RULE_ID = "rule_id";
  public static final String KEY_SUBACTIONTYPE = "subactiontype";
  public static final String KEY_TIANJI_TRANSFER = "tianji_transfer";
  public static final String KEY_TOUIN = "touin";
  public static final String KEY_VID = "vid";
  public static final String KEY_VIDEO_PLAY_TIME = "video_play_time";
  public static final String KEY_VIDEO_SOLO_TIME = "video_solo_time";
  public static final String KEY_VIDEO_TAG = "video_tag";
  public static final String KEY_VIDEO_TOTAL_TIME = "video_total_time";
  public static final String KEY_VIDEO_TYPE = "video_type";
  public static final String KEY_WIDTH = "width";
  private static final String TAG = "QCircleLpReportDc05507";
  
  private static int getDcId()
  {
    return 5507;
  }
  
  private static boolean needReportNow(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 1) || (paramInt1 == 2);
  }
  
  public static void report(QCircleLpReportDc05507.DataBuilder paramDataBuilder)
  {
    if (paramDataBuilder == null)
    {
      RFLog.e("QCircleReportBean_QCircleLpReportDc05507", RFLog.USR, "report invalid builder is null!");
      return;
    }
    if (QCircleLpReportDc05507.DataBuilder.access$000(paramDataBuilder) <= 0)
    {
      RFLog.e("QCircleReportBean_QCircleLpReportDc05507", RFLog.USR, "report invalid pageId," + QCircleLpReportDc05507.DataBuilder.access$000(paramDataBuilder) + ",actionType:" + QCircleLpReportDc05507.DataBuilder.access$100(paramDataBuilder) + ",subActionType:" + QCircleLpReportDc05507.DataBuilder.access$200(paramDataBuilder));
      showErrorToast(QCircleLpReportDc05507.DataBuilder.access$100(paramDataBuilder), QCircleLpReportDc05507.DataBuilder.access$200(paramDataBuilder));
    }
    QCircleReporter.getInstance().getReportHandler().post(new QCircleLpReportDc05507.1(paramDataBuilder));
  }
  
  private static void showErrorToast(int paramInt1, int paramInt2)
  {
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
      ThreadManagerV2.getUIHandlerV2().post(new QCircleLpReportDc05507.2(paramInt1, paramInt2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05507
 * JD-Core Version:    0.7.0.1
 */