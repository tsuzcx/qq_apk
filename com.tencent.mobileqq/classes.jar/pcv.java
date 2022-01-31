import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class pcv
  extends RecyclerView.ItemDecoration
{
  private int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean = true;
  private int b;
  private int c;
  private int d;
  
  public pcv(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = paramInt1;
    this.d = paramInt2;
    this.jdField_a_of_type_Int = paramInt3;
    this.c = paramInt4;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (this.jdField_a_of_type_Boolean)
    {
      paramRect.top = this.jdField_a_of_type_Int;
      paramRect.bottom = this.c;
      if (i == 0) {
        paramRect.left = this.b;
      }
      if (i == paramState.getItemCount() - 1) {
        paramRect.right = this.d;
      }
    }
    do
    {
      return;
      paramRect.left = this.b;
      paramRect.right = this.d;
      if (i == 0) {
        paramRect.top = this.jdField_a_of_type_Int;
      }
    } while (i != paramState.getItemCount() - 1);
    paramRect.bottom = this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcv
 * JD-Core Version:    0.7.0.1
 */