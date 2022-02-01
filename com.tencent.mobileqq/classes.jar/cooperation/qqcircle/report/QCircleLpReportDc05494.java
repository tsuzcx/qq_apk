package cooperation.qqcircle.report;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import java.util.ArrayList;

public class QCircleLpReportDc05494
{
  public static final String KEY_AUTHOR_UIN = "author_uin";
  public static final String KEY_CITY_NAME = "city_name";
  public static final String KEY_COUNTRY_NAME = "country_name";
  public static final String KEY_DEVICE_MAKER = "device_maker";
  public static final String KEY_DEVICE_MODEL = "device_model";
  public static final String KEY_EXT_1 = "ext1";
  public static final String KEY_EXT_2 = "ext2";
  public static final String KEY_EXT_3 = "ext3";
  public static final String KEY_EXT_4 = "ext4";
  public static final String KEY_EXT_5 = "ext5";
  public static final String KEY_EXT_6 = "ext6";
  public static final String KEY_EXT_7 = "ext7";
  public static final String KEY_EXT_8 = "ext8";
  public static final String KEY_FEEDID = "feedid";
  public static final String KEY_FEED_TAG = "feed_tag";
  public static final String KEY_HEIGHT = "height";
  public static final String KEY_IP = "ip";
  public static final String KEY_IS_VIDEO = "is_video";
  public static final String KEY_LLOC = "lloc";
  public static final String KEY_ORIG_HEIGHT = "orig_height";
  public static final String KEY_ORIG_PHOTOCUBAGE = "orig_photocubage";
  public static final String KEY_ORIG_WIDTH = "orig_width";
  public static final String KEY_PHOTOCUBAGE = "photocubage";
  public static final String KEY_PHOTO_TAG = "photo_tag";
  public static final String KEY_PICTURE_FORMAT = "picture_format";
  public static final String KEY_PLACE = "place";
  public static final String KEY_PLACE_NAME = "place_name";
  public static final String KEY_PROV_NAME = "prov_name";
  public static final String KEY_SHOOTING_TIME = "shooting_time";
  public static final String KEY_SHOOT_MODEL = "shoot_model";
  public static final String KEY_SHOOT_PLACE = "shoot_place";
  public static final String KEY_SHOOT_PRODUCT = "shoot_product";
  public static final String KEY_TOTAL_UPLOAD_NUM = "total_upload_num";
  public static final String KEY_TOUIN = "touin";
  public static final String KEY_TXTINFO = "txtinfo";
  public static final String KEY_UP_PLACE = "up_place";
  public static final String KEY_UP_SOURCE = "up_source";
  public static final String KEY_UP_TYPE = "up_type";
  public static final String KEY_VID = "vid";
  public static final String KEY_WIDTH = "width";
  private static final String TAG = "QCircleLpReportDc05494";
  
  private static int getDcId()
  {
    return 5494;
  }
  
  private static int getScene()
  {
    return 36;
  }
  
  public static void report(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, int paramInt4, String paramString5, long paramLong2, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString10, String paramString11, long paramLong3, String paramString12)
  {
    QCircleReporter.getInstance().getReportHandler().post(new QCircleLpReportDc05494.1(paramInt1, paramInt2, paramInt3, paramString1, paramString2, paramString3, paramLong1, paramString4, paramInt4, paramString5, paramLong2, paramString6, paramString7, paramString8, paramString9, paramInt5, paramInt6, paramInt7, paramInt8, paramString10, paramString11, paramLong3, paramString12));
  }
  
  public static void report(ArrayList<QCircleTaskReportInfo> paramArrayList)
  {
    if (paramArrayList == null)
    {
      RFLog.e("QCircleReportHelper_QCircleLpReportDc05494", RFLog.CLR, "taskReportInfos == null");
      return;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      QCircleTaskReportInfo localQCircleTaskReportInfo = (QCircleTaskReportInfo)paramArrayList.get(i);
      report(localQCircleTaskReportInfo.up_source, localQCircleTaskReportInfo.up_type, localQCircleTaskReportInfo.is_video, localQCircleTaskReportInfo.txtinfo, localQCircleTaskReportInfo.lloc, localQCircleTaskReportInfo.vid, localQCircleTaskReportInfo.client_compress_pic_size, localQCircleTaskReportInfo.feedid, localQCircleTaskReportInfo.total_upload_num, localQCircleTaskReportInfo.shooting_time, localQCircleTaskReportInfo.edited_pic_size, localQCircleTaskReportInfo.place, localQCircleTaskReportInfo.up_place, localQCircleTaskReportInfo.shoot_product, localQCircleTaskReportInfo.shoot_model, localQCircleTaskReportInfo.client_compress_pic_width, localQCircleTaskReportInfo.client_compress_pic_height, localQCircleTaskReportInfo.edited_pic_width, localQCircleTaskReportInfo.edited_pic_height, localQCircleTaskReportInfo.picture_format, localQCircleTaskReportInfo.feed_tag, localQCircleTaskReportInfo.author_uin, localQCircleTaskReportInfo.shoot_place);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05494
 * JD-Core Version:    0.7.0.1
 */