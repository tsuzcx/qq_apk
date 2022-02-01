import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.RecyclerViewWithHeaderFooterFix;
import java.util.List;

public class smn
  extends RecyclerView.RecycledViewPool
{
  public smn(RecyclerViewWithHeaderFooterFix paramRecyclerViewWithHeaderFooterFix) {}
  
  public RecyclerView.ViewHolder getRecycledView(int paramInt)
  {
    Object localObject = this.a.getAdapter();
    RecyclerView.ViewHolder localViewHolder = super.getRecycledView(paramInt);
    if ((localViewHolder != null) && ((localObject instanceof bltq)))
    {
      localObject = (bltq)localObject;
      if (((bltq)localObject).d(paramInt))
      {
        if (!RecyclerViewWithHeaderFooterFix.a(this.a).contains(localViewHolder.itemView))
        {
          putRecycledView(localViewHolder);
          return null;
        }
      }
      else if ((((bltq)localObject).c(paramInt)) && (!RecyclerViewWithHeaderFooterFix.b(this.a).contains(localViewHolder.itemView)))
      {
        putRecycledView(localViewHolder);
        return null;
      }
    }
    return localViewHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smn
 * JD-Core Version:    0.7.0.1
 */