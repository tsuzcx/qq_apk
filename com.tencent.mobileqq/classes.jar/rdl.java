import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.util.SparseArray;
import android.view.View;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class rdl
  extends RecyclerView.ItemDecoration
{
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private final SparseArray<rdm> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public rdl()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
  }
  
  public static final rdm a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public static final rdm a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    rdm localrdm = new rdm();
    localrdm.e = paramInt5;
    paramInt5 = (paramInt3 - 1) * paramInt4 / paramInt3;
    int i = paramInt4 - paramInt5;
    localrdm.c = paramInt4;
    if (paramInt1 % paramInt3 == 0) {
      localrdm.b = paramInt5;
    }
    while (paramInt1 / paramInt3 == paramInt2 / paramInt3)
    {
      localrdm.d = paramInt4;
      return localrdm;
      if ((paramInt1 + 1) % paramInt3 == 0)
      {
        localrdm.a = paramInt5;
      }
      else
      {
        localrdm.a = i;
        localrdm.b = i;
      }
    }
    localrdm.d = 0;
    return localrdm;
  }
  
  @Nullable
  public abstract rdm a(int paramInt, @NotNull RecyclerView paramRecyclerView);
  
  public void getItemOffsets(@NotNull Rect paramRect, @NotNull View paramView, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    paramView.setTag(Integer.valueOf(i));
    paramView = a(i, paramRecyclerView);
    if (paramView != null) {
      paramRect.set(paramView.a, paramView.c, paramView.b, paramView.d);
    }
    for (paramRect = paramView;; paramRect = new rdm())
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramRect);
      return;
    }
  }
  
  public void onDraw(@NotNull Canvas paramCanvas, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramState = paramRecyclerView.getChildAt(i);
      int k = ((Integer)paramState.getTag()).intValue();
      rdm localrdm = (rdm)this.jdField_a_of_type_AndroidUtilSparseArray.get(k);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(localrdm.e);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramState.getLayoutParams();
      k = paramState.getBottom() + localLayoutParams.bottomMargin;
      int m = paramState.getLeft() - localLayoutParams.leftMargin;
      int n = paramState.getRight() + localLayoutParams.rightMargin;
      int i1 = paramState.getTop() - localLayoutParams.topMargin;
      paramCanvas.drawRect(m - localrdm.a, k, localrdm.b + n, localrdm.d + k, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(m - localrdm.a, i1 - localrdm.c, localrdm.b + n, i1, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(m - localrdm.a, i1, m, k, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(n, i1, localrdm.b + n, k, this.jdField_a_of_type_AndroidGraphicsPaint);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rdl
 * JD-Core Version:    0.7.0.1
 */