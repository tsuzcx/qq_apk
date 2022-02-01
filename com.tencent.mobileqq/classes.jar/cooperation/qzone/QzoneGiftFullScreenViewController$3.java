package cooperation.qzone;

import android.os.Handler;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;

class QzoneGiftFullScreenViewController$3
  implements QzoneGiftFullScreenActionManager.MagicfaceActionListener
{
  QzoneGiftFullScreenViewController$3(QzoneGiftFullScreenViewController paramQzoneGiftFullScreenViewController, long paramLong, IQzoneGiftFullScreenViewController.GiftFullScreenPlayListener paramGiftFullScreenPlayListener) {}
  
  public void magicfaceActionEnd(ActionGlobalData paramActionGlobalData)
  {
    this.this$0.uiHandler.post(new QzoneGiftFullScreenViewController.3.2(this));
  }
  
  public void magicfaceActionStart(ActionGlobalData paramActionGlobalData)
  {
    System.currentTimeMillis();
    long l = this.val$clickTime;
    boolean bool = this.this$0.magicfaceActionManager.getPreferencesReceiveSound();
    this.this$0.magicfaceActionManager.openSound(bool);
    this.this$0.uiHandler.post(new QzoneGiftFullScreenViewController.3.1(this, paramActionGlobalData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.3
 * JD-Core Version:    0.7.0.1
 */