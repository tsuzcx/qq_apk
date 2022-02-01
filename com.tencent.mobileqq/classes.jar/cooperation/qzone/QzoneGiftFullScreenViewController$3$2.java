package cooperation.qzone;

import android.view.View;
import com.tencent.image.URLDrawable;
import java.util.List;

class QzoneGiftFullScreenViewController$3$2
  implements Runnable
{
  QzoneGiftFullScreenViewController$3$2(QzoneGiftFullScreenViewController.3 param3) {}
  
  public void run()
  {
    URLDrawable.resume();
    ((View)this.this$1.this$0.magicfaceReceivePlay).setBackgroundColor(0);
    QzoneGiftFullScreenViewController.access$100(this.this$1.this$0);
    this.this$1.val$playListener.giftFullScreenPlayEnd();
    if (QzoneGiftFullScreenViewController.access$200(this.this$1.this$0).size() > 0)
    {
      QzoneGiftFullScreenViewController.MagicData localMagicData = (QzoneGiftFullScreenViewController.MagicData)QzoneGiftFullScreenViewController.access$200(this.this$1.this$0).get(0);
      this.this$1.this$0.playMaigcface(localMagicData.emotionId, localMagicData.maigcPath, localMagicData.isPassivePraise, localMagicData.playListener);
      QzoneGiftFullScreenViewController.access$200(this.this$1.this$0).remove(localMagicData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.3.2
 * JD-Core Version:    0.7.0.1
 */