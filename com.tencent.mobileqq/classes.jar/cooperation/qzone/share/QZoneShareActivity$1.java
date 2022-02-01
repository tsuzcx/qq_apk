package cooperation.qzone.share;

import com.tencent.widget.immersive.ImmersiveUtils;

class QZoneShareActivity$1
  implements Runnable
{
  QZoneShareActivity$1(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    if (ImmersiveUtils.correctStatusBarHeight(this.this$0.getWindow())) {
      this.this$0.recreate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.1
 * JD-Core Version:    0.7.0.1
 */