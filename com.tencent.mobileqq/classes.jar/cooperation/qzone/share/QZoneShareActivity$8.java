package cooperation.qzone.share;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;

class QZoneShareActivity$8
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QZoneShareActivity$8(QZoneShareActivity paramQZoneShareActivity, RelativeLayout paramRelativeLayout) {}
  
  public void onGlobalLayout()
  {
    int i = this.val$mConatainer.getHeight();
    if (QZoneShareActivity.access$1000(this.this$0) - i > 150) {
      this.this$0.desToolbar.setVisibility(0);
    }
    for (;;)
    {
      QZoneShareActivity.access$1002(this.this$0, i);
      return;
      if ((i - QZoneShareActivity.access$1000(this.this$0) > 150) && (!this.this$0.emoShow)) {
        this.this$0.desToolbar.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.8
 * JD-Core Version:    0.7.0.1
 */