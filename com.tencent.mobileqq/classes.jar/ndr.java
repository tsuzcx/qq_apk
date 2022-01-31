import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeAdapter;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;

public class ndr
  extends RecyclerView.AdapterDataObserver
{
  public ndr(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void onChanged()
  {
    if (this.a.a.getItemCount() > 0) {
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndr
 * JD-Core Version:    0.7.0.1
 */