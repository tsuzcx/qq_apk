package com.tencent.mobileqq.winkpublish.preview.helper;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.winkpublish.preview.adapter.QCirclePicPreviewMoveAdapter;
import com.tencent.mobileqq.winkpublish.preview.adapter.QCirclePicPreviewMoveAdapter.PicAddViewHolder;
import com.tencent.mobileqq.winkpublish.preview.itemtouchhelper.ItemTouchHelper.Callback;
import java.util.ArrayList;

public class PicDragHelperCallback
  extends ItemTouchHelper.Callback
{
  private QCirclePicPreviewMoveAdapter a;
  private View b;
  private PicDragHelperCallback.DragListener c;
  private boolean d;
  private int e;
  private RecyclerView.ViewHolder f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private PicDragHelperCallback.ScaleProperty l;
  
  private void a(View paramView, float paramFloat1, float paramFloat2, long paramLong)
  {
    if ((paramView.getTag() instanceof ObjectAnimator)) {
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, this.l, new float[] { paramFloat1, paramFloat2 });
    localObjectAnimator.setDuration(paramLong);
    localObjectAnimator.start();
    paramView.setTag(localObjectAnimator);
  }
  
  private boolean a(View paramView)
  {
    paramView = paramView.getTag();
    return ((paramView instanceof ObjectAnimator)) && (((ObjectAnimator)paramView).isRunning());
  }
  
  private void b(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof ObjectAnimator))
    {
      ((ObjectAnimator)localObject).cancel();
      paramView.setTag(null);
    }
  }
  
  public int a(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof QCirclePicPreviewMoveAdapter.PicAddViewHolder)) {
      return 0;
    }
    return b(15, 0);
  }
  
  public long a(RecyclerView paramRecyclerView, int paramInt, float paramFloat1, float paramFloat2)
  {
    if (this.d) {
      return 0L;
    }
    return super.a(paramRecyclerView, paramInt, paramFloat1, paramFloat2);
  }
  
  public void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    if ((this.b != null) && (!a(paramViewHolder.itemView)))
    {
      int m = this.b.getWidth();
      int n = this.b.getHeight();
      Object localObject = new int[2];
      this.b.getLocationInWindow((int[])localObject);
      boolean bool2 = false;
      int i1 = localObject[0];
      int i2 = localObject[1];
      int i6 = paramViewHolder.itemView.getWidth();
      int i5 = paramViewHolder.itemView.getHeight();
      localObject = new int[2];
      paramViewHolder.itemView.getLocationInWindow((int[])localObject);
      int i4 = localObject[0];
      int i3 = localObject[1];
      float f1 = i6;
      float f2 = this.k;
      i6 = (int)(f1 * f2);
      i5 = (int)(i5 * f2);
      i4 += i6 / 2;
      i3 += i5 / 2;
      boolean bool1;
      if ((i3 > i2) && (i3 < i2 + n) && (i4 > i1) && (i4 < i1 + m)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool1 != this.d)
      {
        if (this.f != null) {
          if (bool1)
          {
            this.k = this.i;
            b(paramViewHolder.itemView);
            a(paramViewHolder.itemView, this.g, this.i, 150L);
            paramViewHolder.itemView.setAlpha(this.j);
          }
          else
          {
            this.k = this.g;
            b(paramViewHolder.itemView);
            a(paramViewHolder.itemView, this.i, this.g, 150L);
            paramViewHolder.itemView.setAlpha(this.h);
          }
        }
        localObject = this.c;
        if (localObject != null)
        {
          if (this.f == null) {
            bool2 = true;
          }
          ((PicDragHelperCallback.DragListener)localObject).a(bool1, bool2);
        }
      }
      this.d = bool1;
      super.a(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, paramBoolean);
      return;
    }
    super.a(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if (paramViewHolder1.getItemViewType() != paramViewHolder2.getItemViewType()) {
      return false;
    }
    if ((paramViewHolder2 instanceof QCirclePicPreviewMoveAdapter.PicAddViewHolder)) {
      return false;
    }
    paramRecyclerView = this.a.a();
    if (paramRecyclerView != null)
    {
      if (paramRecyclerView.size() < 2) {
        return false;
      }
      int m = paramViewHolder1.getAdapterPosition();
      int n = paramViewHolder2.getAdapterPosition();
      this.e = n;
      paramRecyclerView.add(n, paramRecyclerView.remove(m));
      this.a.notifyItemMoved(m, n);
      return true;
    }
    return false;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject;
    if (paramInt != 0)
    {
      b(paramViewHolder.itemView);
      a(paramViewHolder.itemView, 1.0F, this.g, 200L);
      paramViewHolder.itemView.setAlpha(this.h);
      localObject = this.c;
      if (localObject != null) {
        ((PicDragHelperCallback.DragListener)localObject).a();
      }
      this.e = paramViewHolder.getAdapterPosition();
      this.f = paramViewHolder;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelectedChanged delPos:");
      ((StringBuilder)localObject).append(this.e);
      Log.d("jiabin", ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = this.c;
      if (localObject != null) {
        ((PicDragHelperCallback.DragListener)localObject).a(this.d);
      }
      if ((this.d) && (this.e >= 0))
      {
        localObject = this.f;
        if (localObject != null)
        {
          ((RecyclerView.ViewHolder)localObject).itemView.setVisibility(4);
          this.a.a(this.e);
          this.d = false;
        }
      }
      this.e = -1;
      this.f = null;
    }
    super.b(paramViewHolder, paramInt);
  }
  
  public void b(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    b(paramViewHolder.itemView);
    a(paramViewHolder.itemView, this.g, 1.0F, 150L);
    paramViewHolder.itemView.setAlpha(1.0F);
    super.b(paramRecyclerView, paramViewHolder);
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.preview.helper.PicDragHelperCallback
 * JD-Core Version:    0.7.0.1
 */