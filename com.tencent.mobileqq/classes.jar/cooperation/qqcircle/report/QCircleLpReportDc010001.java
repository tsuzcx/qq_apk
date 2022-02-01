package cooperation.qqcircle.report;

import android.os.Handler;

public class QCircleLpReportDc010001
{
  public static final String KEY_ACTIONTYPE = "actiontype";
  public static final String KEY_APP_ID = "app_id";
  public static final String KEY_BUSIMSGID = "busiMsgId";
  public static final String KEY_EEVEEMSGID = "eeveeMsgId";
  public static final String KEY_MAINTYPE = "mainType";
  public static final String KEY_RESERVES = "thr_action";
  public static final String KEY_SCENE = "scene";
  public static final String KEY_SUBACTIONTYPE = "subactiontype";
  public static final String KEY_SUBTYPE = "subType";
  private static final String TAG = "QCircleLpReportDc010001";
  
  private static int getDcId()
  {
    return 10001;
  }
  
  public static void report(QCircleLpReportDc010001.DataBuilder paramDataBuilder)
  {
    QCircleReporter.getInstance().getReportHandler().post(new QCircleLpReportDc010001.1(paramDataBuilder));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc010001
 * JD-Core Version:    0.7.0.1
 */