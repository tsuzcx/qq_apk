import android.support.v7.widget.RecyclerView.Adapter;
import com.tencent.biz.pubaccount.util.DiffUtil.DiffResult;
import com.tencent.biz.pubaccount.util.ListUpdateCallback;

public class mtz
  implements ListUpdateCallback
{
  public mtz(DiffUtil.DiffResult paramDiffResult, RecyclerView.Adapter paramAdapter) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.notifyItemRangeRemoved(paramInt1, paramInt2);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.notifyItemMoved(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mtz
 * JD-Core Version:    0.7.0.1
 */