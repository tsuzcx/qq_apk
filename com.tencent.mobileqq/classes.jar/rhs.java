import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.RecyclerViewWithHeaderFooterFix;

public class rhs
  extends bfzx<RecyclerView.Adapter>
{
  public rhs(RecyclerViewWithHeaderFooterFix paramRecyclerViewWithHeaderFooterFix, RecyclerView.Adapter paramAdapter)
  {
    super(paramAdapter);
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    this.a.a(paramViewHolder, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rhs
 * JD-Core Version:    0.7.0.1
 */