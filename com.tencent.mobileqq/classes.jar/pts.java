import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;

public class pts
  extends RecyclerView.OnScrollListener
{
  public pts(ReadInJoyDynamicChannelBaseFragment paramReadInJoyDynamicChannelBaseFragment, StaggeredGridLayoutManager paramStaggeredGridLayoutManager) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0) {
      this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager.invalidateSpanAssignments();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pts
 * JD-Core Version:    0.7.0.1
 */