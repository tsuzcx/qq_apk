import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;

public class nds
  extends RecyclerView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  public nds(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    if (paramInt == 0)
    {
      if ((paramRecyclerView.findLastCompletelyVisibleItemPosition() == paramRecyclerView.getItemCount() - 1) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.a.c();
      }
      return;
    }
    MsgTabStoryNodeListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nds
 * JD-Core Version:    0.7.0.1
 */