import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.widget.ListView;

public class ndx
  implements Runnable
{
  public ndx(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void run()
  {
    if (this.a.a.getFirstVisiblePosition() != this.a.a.getHeaderViewsCount()) {
      this.a.a.setSelection(this.a.a.getHeaderViewsCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndx
 * JD-Core Version:    0.7.0.1
 */