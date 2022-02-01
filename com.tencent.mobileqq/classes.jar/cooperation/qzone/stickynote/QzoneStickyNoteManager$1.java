package cooperation.qzone.stickynote;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import cooperation.qzone.api.QZoneApiProxy;
import java.lang.ref.WeakReference;

class QzoneStickyNoteManager$1
  implements Runnable
{
  QzoneStickyNoteManager$1(QzoneStickyNoteManager paramQzoneStickyNoteManager, QQAppInterface paramQQAppInterface, WeakReference paramWeakReference1, WeakReference paramWeakReference2, Card paramCard) {}
  
  public void run()
  {
    QZoneApiProxy.needLoadQZoneEnv(new QzoneStickyNoteManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.stickynote.QzoneStickyNoteManager.1
 * JD-Core Version:    0.7.0.1
 */