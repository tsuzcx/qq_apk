package cooperation.qzone.stickynote;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.widget.ListView;
import cooperation.qzone.api.QZoneApiProxy.QZoneLoadCallback;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

class QzoneStickyNoteManager$1
  implements QZoneApiProxy.QZoneLoadCallback
{
  QzoneStickyNoteManager$1(QzoneStickyNoteManager paramQzoneStickyNoteManager, Activity paramActivity, QQAppInterface paramQQAppInterface, ListView paramListView, Card paramCard) {}
  
  public void onLoadOver(boolean paramBoolean)
  {
    if (paramBoolean) {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QzoneStickyNoteManager.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.stickynote.QzoneStickyNoteManager.1
 * JD-Core Version:    0.7.0.1
 */