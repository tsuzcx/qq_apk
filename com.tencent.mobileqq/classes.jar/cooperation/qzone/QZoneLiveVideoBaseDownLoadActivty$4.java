package cooperation.qzone;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QZoneLiveVideoBaseDownLoadActivty$4
  implements View.OnClickListener
{
  QZoneLiveVideoBaseDownLoadActivty$4(QZoneLiveVideoBaseDownLoadActivty paramQZoneLiveVideoBaseDownLoadActivty) {}
  
  public void onClick(View paramView)
  {
    this.this$0.mIsCanceled = true;
    this.this$0.cancelInstall();
    this.this$0.doFinish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty.4
 * JD-Core Version:    0.7.0.1
 */