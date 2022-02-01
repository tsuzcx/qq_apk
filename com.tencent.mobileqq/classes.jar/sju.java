import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;

public class sju
  extends LinearLayoutManager
{
  private VideoFeedsRecyclerView a;
  
  public sju(Context paramContext, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
    this.a = paramVideoFeedsRecyclerView;
  }
  
  private boolean a(View paramView)
  {
    if (paramView == null) {}
    int i;
    int j;
    do
    {
      return false;
      i = this.a.getChildViewHolder(paramView).getLayoutPosition();
      j = this.a.b();
    } while ((j < 0) || ((i != j + 1) && (i != j - 1)));
    return true;
  }
  
  public int getExtraLayoutSpace(RecyclerView.State paramState)
  {
    return super.getExtraLayoutSpace(paramState) + 200;
  }
  
  public void removeAndRecycleView(View paramView, RecyclerView.Recycler paramRecycler)
  {
    if (!a(paramView)) {
      super.removeAndRecycleView(paramView, paramRecycler);
    }
  }
  
  public void removeAndRecycleViewAt(int paramInt, RecyclerView.Recycler paramRecycler)
  {
    if (!a(getChildAt(paramInt))) {
      super.removeAndRecycleViewAt(paramInt, paramRecycler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sju
 * JD-Core Version:    0.7.0.1
 */