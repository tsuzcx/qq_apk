import android.database.DataSetObserver;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.widget.ListView;

public class ndt
  extends DataSetObserver
{
  public ndt(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void onChanged()
  {
    if (this.a.c == 0) {
      this.a.a.post(new ndu(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndt
 * JD-Core Version:    0.7.0.1
 */