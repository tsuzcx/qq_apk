import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.RecyclerViewWithHeaderFooterFix;
import java.util.List;

public class rxn
  extends RecyclerView.RecycledViewPool
{
  public rxn(RecyclerViewWithHeaderFooterFix paramRecyclerViewWithHeaderFooterFix) {}
  
  public RecyclerView.ViewHolder getRecycledView(int paramInt)
  {
    Object localObject = this.a.getAdapter();
    RecyclerView.ViewHolder localViewHolder = super.getRecycledView(paramInt);
    if ((localViewHolder != null) && ((localObject instanceof biau)))
    {
      localObject = (biau)localObject;
      if (((biau)localObject).d(paramInt))
      {
        if (!RecyclerViewWithHeaderFooterFix.a(this.a).contains(localViewHolder.itemView))
        {
          putRecycledView(localViewHolder);
          return null;
        }
      }
      else if ((((biau)localObject).c(paramInt)) && (!RecyclerViewWithHeaderFooterFix.b(this.a).contains(localViewHolder.itemView)))
      {
        putRecycledView(localViewHolder);
        return null;
      }
    }
    return localViewHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rxn
 * JD-Core Version:    0.7.0.1
 */