package cooperation.qzone;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;

class QzoneGiftFullScreenViewController$3$1
  implements Runnable
{
  QzoneGiftFullScreenViewController$3$1(QzoneGiftFullScreenViewController.3 param3, ActionGlobalData paramActionGlobalData) {}
  
  public void run()
  {
    URLDrawable.pause();
    ((View)this.this$1.this$0.magicfaceReceivePlay).setBackgroundColor(this.val$actionGlobalData.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.3.1
 * JD-Core Version:    0.7.0.1
 */