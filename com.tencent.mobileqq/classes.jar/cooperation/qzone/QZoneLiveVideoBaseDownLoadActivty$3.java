package cooperation.qzone;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;

class QZoneLiveVideoBaseDownLoadActivty$3
  implements View.OnClickListener
{
  QZoneLiveVideoBaseDownLoadActivty$3(QZoneLiveVideoBaseDownLoadActivty paramQZoneLiveVideoBaseDownLoadActivty) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.mInstalling)
    {
      if (1 == this.this$0.mMode) {
        LpReportInfo_dc00321.report(8, 129, 0, false, false, null);
      }
      this.this$0.updateTextProgress(false, false);
      this.this$0.installPlugin();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty.3
 * JD-Core Version:    0.7.0.1
 */