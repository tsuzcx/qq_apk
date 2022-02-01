package cooperation.qzone;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QzoneVerticalVideoDownloadActivity$4
  implements View.OnClickListener
{
  QzoneVerticalVideoDownloadActivity$4(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    QzoneVerticalVideoDownloadActivity.access$502(this.this$0, true);
    QzoneVerticalVideoDownloadActivity.access$600(this.this$0);
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneVerticalVideoDownloadActivity.4
 * JD-Core Version:    0.7.0.1
 */