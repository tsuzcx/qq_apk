import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeAdapter;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;

public class nfb
  extends RecyclerView.AdapterDataObserver
{
  public nfb(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void onChanged()
  {
    if (this.a.a.getItemCount() > 0) {
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfb
 * JD-Core Version:    0.7.0.1
 */