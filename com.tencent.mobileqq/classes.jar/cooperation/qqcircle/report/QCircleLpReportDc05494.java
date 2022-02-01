package cooperation.qqcircle.report;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
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
  
  public static void report(QCircleTaskReportInfo paramQCircleTaskReportInfo)
  {
    QCircleReporter.getInstance().getReportHandler().post(new QCircleLpReportDc05494.1(paramQCircleTaskReportInfo));
  }
  
  public static void report(ArrayList<QCircleTaskReportInfo> paramArrayList)
  {
    if (paramArrayList == null)
    {
      QLog.e("QCircleReportHelper_QCircleLpReportDc05494", 2, "taskReportInfos == null");
      return;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      report((QCircleTaskReportInfo)paramArrayList.get(i));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05494
 * JD-Core Version:    0.7.0.1
 */