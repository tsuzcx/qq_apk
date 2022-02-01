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
  
  public static void report(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt4)
  {
    QCircleReporter.getInstance().getReportHandler().post(new QCircleLpReportDc010001.1(paramInt1, paramInt2, paramInt3, paramString1, paramString2, paramString3, paramString4, paramInt4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc010001
 * JD-Core Version:    0.7.0.1
 */