package cooperation.qqcircle.hippy;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;
import thu;

class QCircleHippyFragment$1
  implements View.OnClickListener
{
  QCircleHippyFragment$1(QCircleHippyFragment paramQCircleHippyFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.mViolaUiDelegate.d();
    QCircleHippyFragment.access$000(this.this$0);
    QCircleQualityReporter.reportQualityEvent("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("ret_code", "-1"), QCircleReportHelper.newEntry("attach_info", "network error,module name:" + QCircleHippyFragment.access$100(this.this$0)) }), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.hippy.QCircleHippyFragment.1
 * JD-Core Version:    0.7.0.1
 */