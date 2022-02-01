package cooperation.qqcircle.hippy;

import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;
import tvg;

class QCircleHippyFragment$2
  implements HippyQQEngine.HippyQQEngineListener
{
  QCircleHippyFragment$2(QCircleHippyFragment paramQCircleHippyFragment) {}
  
  public void onError(int paramInt, String paramString)
  {
    QCircleHippyFragment.access$000(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("QCircleHippyFragment", 2, "Hippy: initHippy error statusCode=" + paramInt + ", msg=" + paramString);
    }
    double d = 0.0D;
    if (QCircleHippyFragment.access$200(this.this$0) > 0L)
    {
      d = (float)(System.currentTimeMillis() - QCircleHippyFragment.access$200(this.this$0)) / 1000.0F;
      QCircleHippyFragment.access$202(this.this$0, 0L);
    }
    QCircleQualityReporter.reportQualityEvent("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("time_cost", String.valueOf(d)), QCircleReportHelper.newEntry("ret_code", String.valueOf(paramInt)), QCircleReportHelper.newEntry("attach_info", "errMsg:" + paramString + ",module name:" + QCircleHippyFragment.access$100(this.this$0)) }), false);
  }
  
  public void onSuccess()
  {
    this.this$0.mViolaUiDelegate.d();
    if (QLog.isColorLevel()) {
      QLog.d("QCircleHippyFragment", 2, "Hippy: initHippy success!");
    }
    double d = 0.0D;
    if (QCircleHippyFragment.access$200(this.this$0) > 0L)
    {
      d = (float)(System.currentTimeMillis() - QCircleHippyFragment.access$200(this.this$0)) / 1000.0F;
      QCircleHippyFragment.access$202(this.this$0, 0L);
    }
    QCircleQualityReporter.reportQualityEvent("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("time_cost", String.valueOf(d)), QCircleReportHelper.newEntry("ret_code", "0"), QCircleReportHelper.newEntry("attach_info", "module name:" + QCircleHippyFragment.access$100(this.this$0)) }), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.hippy.QCircleHippyFragment.2
 * JD-Core Version:    0.7.0.1
 */