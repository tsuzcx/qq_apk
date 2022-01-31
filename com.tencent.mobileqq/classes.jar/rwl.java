import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;

public class rwl
  extends RecyclerView.ItemDecoration
{
  private final int a = aciy.a(4.0F, BaseApplicationImpl.getApplication().getResources());
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    paramView = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int i = paramView.getSpanIndex();
    if (paramView.isFullSpan())
    {
      paramRect.left = 0;
      paramRect.right = 0;
    }
    for (;;)
    {
      paramRect.bottom = this.a;
      return;
      if (i % 2 == 0)
      {
        paramRect.left = 0;
        paramRect.right = (this.a / 2);
      }
      else
      {
        paramRect.left = (this.a / 2);
        paramRect.right = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rwl
 * JD-Core Version:    0.7.0.1
 */