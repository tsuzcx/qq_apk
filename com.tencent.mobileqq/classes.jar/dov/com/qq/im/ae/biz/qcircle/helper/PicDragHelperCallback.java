package dov.com.qq.im.ae.biz.qcircle.helper;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.View;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback;
import dov.com.qq.im.ae.biz.qcircle.adapter.PicPreviewMoveAdapter;
import dov.com.qq.im.ae.biz.qcircle.adapter.PicPreviewMoveAdapter.PicAddViewHolder;
import java.util.ArrayList;

public class PicDragHelperCallback
  extends ItemTouchHelper.Callback
{
  private float jdField_a_of_type_Float = 1.2F;
  private int jdField_a_of_type_Int = -1;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private View jdField_a_of_type_AndroidViewView;
  private PicPreviewMoveAdapter jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter;
  private PicDragHelperCallback.DragListener jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback$DragListener;
  private PicDragHelperCallback.ScaleProperty jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback$ScaleProperty = new PicDragHelperCallback.ScaleProperty("scale");
  private boolean jdField_a_of_type_Boolean = false;
  private float b = 1.0F;
  private float c = 0.86F;
  private float d = 0.3F;
  private float e = this.jdField_a_of_type_Float;
  
  public PicDragHelperCallback(@NonNull PicPreviewMoveAdapter paramPicPreviewMoveAdapter, View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter = paramPicPreviewMoveAdapter;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  private void a(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof ObjectAnimator))
    {
      ((ObjectAnimator)localObject).cancel();
      paramView.setTag(null);
    }
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2, long paramLong)
  {
    if ((paramView.getTag() instanceof ObjectAnimator)) {
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, this.jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback$ScaleProperty, new float[] { paramFloat1, paramFloat2 });
    localObjectAnimator.setDuration(paramLong);
    localObjectAnimator.start();
    paramView.setTag(localObjectAnimator);
  }
  
  private boolean a(View paramView)
  {
    paramView = paramView.getTag();
    return ((paramView instanceof ObjectAnimator)) && (((ObjectAnimator)paramView).isRunning());
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.e = this.jdField_a_of_type_Float;
  }
  
  public void a(PicDragHelperCallback.DragListener paramDragListener)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback$DragListener = paramDragListener;
  }
  
  public void b(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    a(paramViewHolder.itemView);
    a(paramViewHolder.itemView, this.jdField_a_of_type_Float, 1.0F, 150L);
    paramViewHolder.itemView.setAlpha(1.0F);
    super.clearView(paramRecyclerView, paramViewHolder);
  }
  
  public long getAnimationDuration(RecyclerView paramRecyclerView, int paramInt, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return 0L;
    }
    return super.getAnimationDuration(paramRecyclerView, paramInt, paramFloat1, paramFloat2);
  }
  
  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof PicPreviewMoveAdapter.PicAddViewHolder)) {
      return 0;
    }
    return makeMovementFlags(15, 0);
  }
  
  public boolean isItemViewSwipeEnabled()
  {
    return false;
  }
  
  public boolean isLongPressDragEnabled()
  {
    return true;
  }
  
  public void onChildDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (a(paramViewHolder.itemView)))
    {
      super.onChildDraw(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, paramBoolean);
      return;
    }
    int i = this.jdField_a_of_type_AndroidViewView.getWidth();
    int j = this.jdField_a_of_type_AndroidViewView.getHeight();
    Object localObject = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationInWindow((int[])localObject);
    int k = localObject[0];
    int m = localObject[1];
    int i3 = paramViewHolder.itemView.getWidth();
    int i2 = paramViewHolder.itemView.getHeight();
    localObject = new int[2];
    paramViewHolder.itemView.getLocationInWindow((int[])localObject);
    int i1 = localObject[0];
    int n = localObject[1];
    i3 = (int)(i3 * this.e);
    i2 = (int)(i2 * this.e);
    i1 = i3 / 2 + i1;
    n = i2 / 2 + n;
    boolean bool1;
    if ((n > m) && (n < j + m) && (i1 > k) && (i1 < i + k))
    {
      bool1 = true;
      if (bool1 != this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null)
        {
          if (!bool1) {
            break label328;
          }
          this.e = this.c;
          a(paramViewHolder.itemView);
          a(paramViewHolder.itemView, this.jdField_a_of_type_Float, this.c, 150L);
          paramViewHolder.itemView.setAlpha(this.d);
        }
        label266:
        if (this.jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback$DragListener != null)
        {
          localObject = this.jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback$DragListener;
          if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null) {
            break label377;
          }
        }
      }
    }
    label328:
    label377:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((PicDragHelperCallback.DragListener)localObject).a(bool1, bool2);
      this.jdField_a_of_type_Boolean = bool1;
      super.onChildDraw(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, paramBoolean);
      return;
      bool1 = false;
      break;
      this.e = this.jdField_a_of_type_Float;
      a(paramViewHolder.itemView);
      a(paramViewHolder.itemView, this.c, this.jdField_a_of_type_Float, 150L);
      paramViewHolder.itemView.setAlpha(this.b);
      break label266;
    }
  }
  
  public boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if (paramViewHolder1.getItemViewType() != paramViewHolder2.getItemViewType()) {}
    do
    {
      do
      {
        return false;
      } while ((paramViewHolder2 instanceof PicPreviewMoveAdapter.PicAddViewHolder));
      paramRecyclerView = this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter.a();
    } while ((paramRecyclerView == null) || (paramRecyclerView.size() < 2));
    int i = paramViewHolder1.getAdapterPosition();
    int j = paramViewHolder2.getAdapterPosition();
    this.jdField_a_of_type_Int = j;
    paramRecyclerView.add(j, paramRecyclerView.remove(i));
    this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter.notifyItemMoved(i, j);
    return true;
  }
  
  public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramInt != 0)
    {
      a(paramViewHolder.itemView);
      a(paramViewHolder.itemView, 1.0F, this.jdField_a_of_type_Float, 200L);
      paramViewHolder.itemView.setAlpha(this.b);
      if (this.jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback$DragListener != null) {
        this.jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback$DragListener.a();
      }
      this.jdField_a_of_type_Int = paramViewHolder.getAdapterPosition();
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
      Log.d("jiabin", "onSelectedChanged delPos:" + this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      super.onSelectedChanged(paramViewHolder, paramInt);
      return;
      if (this.jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback$DragListener != null) {
        this.jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback$DragListener.a(this.jdField_a_of_type_Boolean);
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null))
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView.setVisibility(4);
        this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = null;
    }
  }
  
  public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.helper.PicDragHelperCallback
 * JD-Core Version:    0.7.0.1
 */