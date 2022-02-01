package cooperation.qqcircle.report;

import android.content.Context;
import android.widget.Toast;
import com.tencent.biz.richframework.delegate.impl.RFApplication;

final class QCircleLpReportDc05507$2
  implements Runnable
{
  QCircleLpReportDc05507$2(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Context localContext = RFApplication.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleLpReportDc05507report invalid pageId,actionType:");
    localStringBuilder.append(this.val$actiontype);
    localStringBuilder.append(",subActionType:");
    localStringBuilder.append(this.val$subactiontype);
    Toast.makeText(localContext, localStringBuilder.toString(), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05507.2
 * JD-Core Version:    0.7.0.1
 */