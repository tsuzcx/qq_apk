package cooperation.qzone;

import android.os.Handler;
import awrn;

class QzoneGiftFullScreenViewController$3
  implements QzoneGiftFullScreenActionManager.MagicfaceActionListener
{
  QzoneGiftFullScreenViewController$3(QzoneGiftFullScreenViewController paramQzoneGiftFullScreenViewController, long paramLong, QzoneGiftFullScreenViewController.GiftFullScreenPlayListener paramGiftFullScreenPlayListener) {}
  
  public void magicfaceActionEnd(awrn paramawrn)
  {
    this.this$0.uiHandler.post(new QzoneGiftFullScreenViewController.3.2(this));
  }
  
  public void magicfaceActionStart(awrn paramawrn)
  {
    System.currentTimeMillis();
    long l = this.val$clickTime;
    boolean bool = this.this$0.magicfaceActionManager.getPreferencesReceiveSound();
    this.this$0.magicfaceActionManager.openSound(bool);
    this.this$0.uiHandler.post(new QzoneGiftFullScreenViewController.3.1(this, paramawrn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.3
 * JD-Core Version:    0.7.0.1
 */