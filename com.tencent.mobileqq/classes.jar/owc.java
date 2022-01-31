import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.tencent.biz.qqstory.view.xrecyclerview.RecyclerViewHeaderViewAdapter;
import com.tencent.biz.qqstory.view.xrecyclerview.RecyclerViewHeaderViewAdapter.ContentDataObserver;
import java.util.List;

public class owc
  extends RecyclerView.AdapterDataObserver
{
  public owc(RecyclerViewHeaderViewAdapter paramRecyclerViewHeaderViewAdapter) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (RecyclerViewHeaderViewAdapter.a(this.a) != null) {
      RecyclerViewHeaderViewAdapter.a(this.a).a(RecyclerViewHeaderViewAdapter.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(RecyclerViewHeaderViewAdapter.a(this.a).size() + paramInt1, paramInt2);
    if (RecyclerViewHeaderViewAdapter.a(this.a) != null) {
      RecyclerViewHeaderViewAdapter.a(this.a).a(RecyclerViewHeaderViewAdapter.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(RecyclerViewHeaderViewAdapter.a(this.a).size() + paramInt1, paramInt2);
    if (RecyclerViewHeaderViewAdapter.a(this.a) != null) {
      RecyclerViewHeaderViewAdapter.a(this.a).a(RecyclerViewHeaderViewAdapter.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(RecyclerViewHeaderViewAdapter.a(this.a).size() + paramInt1, RecyclerViewHeaderViewAdapter.a(this.a).size() + paramInt2);
    if (RecyclerViewHeaderViewAdapter.a(this.a) != null) {
      RecyclerViewHeaderViewAdapter.a(this.a).a(RecyclerViewHeaderViewAdapter.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(RecyclerViewHeaderViewAdapter.a(this.a).size() + paramInt1, paramInt2);
    if (RecyclerViewHeaderViewAdapter.a(this.a) != null) {
      RecyclerViewHeaderViewAdapter.a(this.a).a(RecyclerViewHeaderViewAdapter.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owc
 * JD-Core Version:    0.7.0.1
 */