package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;

public class EmojiFragment$TempGridItemLayoutDecoration
  extends RecyclerView.ItemDecoration
{
  public int a;
  public Context b;
  
  public EmojiFragment$TempGridItemLayoutDecoration(EmojiFragment paramEmojiFragment, Context paramContext, int paramInt)
  {
    this.b = paramContext;
    this.a = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = 0;
    paramView.measure(0, 0);
    int j = paramRecyclerView.getMeasuredWidth();
    int k = paramView.getMeasuredWidth();
    int m = this.a;
    j = (j - k * m) / (m + 1);
    if (QLog.isColorLevel())
    {
      paramState = new StringBuilder();
      paramState.append("getItemOffsets getMeasuredWidth: ");
      paramState.append(paramView.getMeasuredWidth());
      QLog.i("EmojiFragment", 2, paramState.toString());
    }
    k = paramRecyclerView.getChildAdapterPosition(paramView);
    m = this.a;
    int n = ((m - 1) * j + j + j) / m;
    if (k % m == 0)
    {
      paramRect.left = j;
      paramState = this.c;
      paramState.t = (n - j);
      paramRect.right = paramState.t;
    }
    else if (k % m == m - 1)
    {
      paramRect.right = j;
      paramRect.left = (n - j);
    }
    else
    {
      paramRect.left = (j - this.c.t);
      paramState = this.c;
      paramState.t = (n - (j - paramState.t));
      paramRect.right = this.c.t;
    }
    if (paramRecyclerView.getChildAdapterPosition(paramView) < this.a) {
      i = 1;
    }
    if (i == 0) {
      paramRect.top = ScreenUtil.dip2px(11.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.EmojiFragment.TempGridItemLayoutDecoration
 * JD-Core Version:    0.7.0.1
 */