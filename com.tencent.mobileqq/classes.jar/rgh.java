import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.RecyclerViewWithHeaderFooterFix;

public class rgh
  extends RecyclerViewWithHeaderFooterFix
{
  public rgh(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    this.a.a(paramViewHolder, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rgh
 * JD-Core Version:    0.7.0.1
 */