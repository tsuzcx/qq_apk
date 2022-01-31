import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;

public class oju
  extends RecyclerView.ItemDecoration
{
  private int jdField_a_of_type_Int;
  
  public oju(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    if (((StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams()).getSpanIndex() % 2 == 0)
    {
      paramRect.left = (this.jdField_a_of_type_Int * 2);
      paramRect.right = this.jdField_a_of_type_Int;
      return;
    }
    paramRect.left = (this.jdField_a_of_type_Int / 2);
    paramRect.right = this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oju
 * JD-Core Version:    0.7.0.1
 */