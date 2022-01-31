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

public abstract class qrn
  extends RecyclerView.ItemDecoration
{
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private final SparseArray<qro> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public qrn()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
  }
  
  public static final qro a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public static final qro a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    qro localqro = new qro();
    localqro.e = paramInt5;
    paramInt5 = (paramInt3 - 1) * paramInt4 / paramInt3;
    int i = paramInt4 - paramInt5;
    localqro.c = paramInt4;
    if (paramInt1 % paramInt3 == 0) {
      localqro.b = paramInt5;
    }
    while (paramInt1 / paramInt3 == paramInt2 / paramInt3)
    {
      localqro.d = paramInt4;
      return localqro;
      if ((paramInt1 + 1) % paramInt3 == 0)
      {
        localqro.a = paramInt5;
      }
      else
      {
        localqro.a = i;
        localqro.b = i;
      }
    }
    localqro.d = 0;
    return localqro;
  }
  
  @Nullable
  public abstract qro a(int paramInt, @NotNull RecyclerView paramRecyclerView);
  
  public void getItemOffsets(@NotNull Rect paramRect, @NotNull View paramView, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    paramView.setTag(Integer.valueOf(i));
    paramView = a(i, paramRecyclerView);
    if (paramView != null) {
      paramRect.set(paramView.a, paramView.c, paramView.b, paramView.d);
    }
    for (paramRect = paramView;; paramRect = new qro())
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
      qro localqro = (qro)this.jdField_a_of_type_AndroidUtilSparseArray.get(k);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(localqro.e);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramState.getLayoutParams();
      k = paramState.getBottom() + localLayoutParams.bottomMargin;
      int m = paramState.getLeft() - localLayoutParams.leftMargin;
      int n = paramState.getRight() + localLayoutParams.rightMargin;
      int i1 = paramState.getTop() - localLayoutParams.topMargin;
      paramCanvas.drawRect(m - localqro.a, k, localqro.b + n, localqro.d + k, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(m - localqro.a, i1 - localqro.c, localqro.b + n, i1, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(m - localqro.a, i1, m, k, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(n, i1, localqro.b + n, k, this.jdField_a_of_type_AndroidGraphicsPaint);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qrn
 * JD-Core Version:    0.7.0.1
 */