package com.tencent.mobileqq.guild.channel;

import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseDragTouchCallBack<T>
  extends ItemTouchHelper.Callback
{
  protected RecyclerView a;
  protected List<T> b = new ArrayList();
  
  public BaseDragTouchCallBack(RecyclerView paramRecyclerView, List<T> paramList)
  {
    this.b = paramList;
    this.a = paramRecyclerView;
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if ((paramViewHolder != null) && (paramViewHolder.itemView != null) && (Build.VERSION.SDK_INT >= 21)) {}
    for (;;)
    {
      try
      {
        paramViewHolder.itemView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        paramViewHolder = paramViewHolder.itemView;
        if (!paramBoolean) {
          break label61;
        }
        f = 20.0F;
        paramViewHolder.setTranslationZ(f);
        return;
      }
      catch (Exception paramViewHolder)
      {
        QLog.i("BaseDragTouchCallBack", 1, "setItemShadow", paramViewHolder);
      }
      return;
      label61:
      float f = 0.0F;
    }
  }
  
  public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    super.clearView(paramRecyclerView, paramViewHolder);
    QLog.i("BaseDragTouchCallBack", 1, "clearView");
    a(paramViewHolder, false);
  }
  
  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return makeMovementFlags(3, 0);
  }
  
  public boolean isLongPressDragEnabled()
  {
    return true;
  }
  
  public boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    int i = paramViewHolder1.getAdapterPosition();
    int m = paramViewHolder2.getAdapterPosition();
    if (QLog.isColorLevel()) {
      QLog.d("BaseDragTouchCallBack", 2, new Object[] { "onMove fromPosition:", Integer.valueOf(i), " toPosition:", Integer.valueOf(m) });
    }
    if (i == m) {
      return false;
    }
    if (i < m)
    {
      int k;
      for (j = i; j < m; j = k)
      {
        paramRecyclerView = this.b;
        k = j + 1;
        Collections.swap(paramRecyclerView, j, k);
      }
    }
    int j = i;
    while (j > m)
    {
      Collections.swap(this.b, j, j - 1);
      j -= 1;
    }
    this.a.getAdapter().notifyItemMoved(i, m);
    return true;
  }
  
  public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSelectedChanged");
    localStringBuilder.append(paramInt);
    QLog.i("BaseDragTouchCallBack", 1, localStringBuilder.toString());
    if (paramInt == 0)
    {
      paramViewHolder = this.a;
      if ((paramViewHolder instanceof OverScrollRecyclerView)) {
        ((OverScrollRecyclerView)paramViewHolder).c();
      }
    }
    else if (paramInt == 2)
    {
      a(paramViewHolder, true);
      paramViewHolder = this.a;
      if ((paramViewHolder instanceof OverScrollRecyclerView)) {
        ((OverScrollRecyclerView)paramViewHolder).b();
      }
    }
  }
  
  public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.BaseDragTouchCallBack
 * JD-Core Version:    0.7.0.1
 */