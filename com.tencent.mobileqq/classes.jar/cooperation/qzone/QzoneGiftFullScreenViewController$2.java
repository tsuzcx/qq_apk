package cooperation.qzone;

import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.DisplayUtils;

class QzoneGiftFullScreenViewController$2
  implements Runnable
{
  QzoneGiftFullScreenViewController$2(QzoneGiftFullScreenViewController paramQzoneGiftFullScreenViewController) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.magicfaceReceiveStop.getLayoutParams();
    localLayoutParams.rightMargin = ((int)DisplayUtils.a(QzoneGiftFullScreenViewController.access$000(this.this$0), 10.0F));
    this.this$0.magicfaceReceiveStop.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.2
 * JD-Core Version:    0.7.0.1
 */