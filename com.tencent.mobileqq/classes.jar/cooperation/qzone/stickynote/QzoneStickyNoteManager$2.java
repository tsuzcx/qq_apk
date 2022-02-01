package cooperation.qzone.stickynote;

import com.tencent.mobileqq.data.Card;
import com.tencent.widget.ListView;

class QzoneStickyNoteManager$2
  implements Runnable
{
  QzoneStickyNoteManager$2(QzoneStickyNoteManager paramQzoneStickyNoteManager, ListView paramListView, Card paramCard) {}
  
  public void run()
  {
    QzoneStickyNoteManager.access$102(this.this$0, QzoneStickyNoteManager.access$200(this.this$0, this.val$listView));
    QzoneStickyNoteManager.access$300(this.this$0, this.this$0.getAdapter());
    QzoneStickyNoteManager.access$402(this.this$0, true);
    QzoneStickyNoteManager.access$500(this.this$0);
    this.this$0.updateFriendProfileCard(this.val$card);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.stickynote.QzoneStickyNoteManager.2
 * JD-Core Version:    0.7.0.1
 */