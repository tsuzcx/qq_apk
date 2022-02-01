package cooperation.qzone.stickynote;

import android.app.Activity;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;

class QzoneStickyNoteManager$1$1$1$1
  implements Runnable
{
  QzoneStickyNoteManager$1$1$1$1(QzoneStickyNoteManager.1.1.1 param1) {}
  
  public void run()
  {
    Activity localActivity = (Activity)this.this$3.this$2.this$1.val$activityRef.get();
    ListView localListView = (ListView)this.this$3.this$2.this$1.val$listViewRef.get();
    this.this$3.this$2.this$1.this$0.attach(this.this$3.this$2.this$1.val$app, localActivity, localListView, this.this$3.this$2.this$1.val$card);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.stickynote.QzoneStickyNoteManager.1.1.1.1
 * JD-Core Version:    0.7.0.1
 */