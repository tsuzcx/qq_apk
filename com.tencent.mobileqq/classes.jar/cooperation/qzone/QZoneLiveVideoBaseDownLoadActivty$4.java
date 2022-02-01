package cooperation.qzone;

import android.view.View;
import android.view.View.OnClickListener;

class QZoneLiveVideoBaseDownLoadActivty$4
  implements View.OnClickListener
{
  QZoneLiveVideoBaseDownLoadActivty$4(QZoneLiveVideoBaseDownLoadActivty paramQZoneLiveVideoBaseDownLoadActivty) {}
  
  public void onClick(View paramView)
  {
    paramView = this.this$0;
    paramView.mIsCanceled = true;
    paramView.cancelInstall();
    this.this$0.doFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty.4
 * JD-Core Version:    0.7.0.1
 */