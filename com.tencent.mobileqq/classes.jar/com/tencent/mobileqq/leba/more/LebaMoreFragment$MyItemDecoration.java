package com.tencent.mobileqq.leba.more;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class LebaMoreFragment$MyItemDecoration
  extends RecyclerView.ItemDecoration
{
  LebaMoreAdapter a;
  int b = ViewUtils.dip2px(1.0F);
  
  public LebaMoreFragment$MyItemDecoration(Context paramContext, LebaMoreAdapter paramLebaMoreAdapter, boolean paramBoolean)
  {
    this.a = paramLebaMoreAdapter;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    if (this.a == null)
    {
      QLog.i("LebaMoreFragment", 1, "MyItemDecoration getItemOffsets mAdapter == null");
      return;
    }
    if (paramRecyclerView.getChildAdapterPosition(paramView) < 0) {
      return;
    }
    int i = this.b;
    paramRect.bottom = i;
    paramRect.right = i;
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.more.LebaMoreFragment.MyItemDecoration
 * JD-Core Version:    0.7.0.1
 */