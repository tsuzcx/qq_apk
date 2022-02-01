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
  public Context a;
  
  public EmojiFragment$TempGridItemLayoutDecoration(EmojiFragment paramEmojiFragment, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = 0;
    paramView.measure(0, 0);
    int j = paramRecyclerView.getMeasuredWidth();
    int k = paramView.getMeasuredWidth();
    int m = this.jdField_a_of_type_Int;
    j = (j - k * m) / (m + 1);
    if (QLog.isColorLevel())
    {
      paramState = new StringBuilder();
      paramState.append("getItemOffsets getMeasuredWidth: ");
      paramState.append(paramView.getMeasuredWidth());
      QLog.i("EmojiFragment", 2, paramState.toString());
    }
    k = paramRecyclerView.getChildAdapterPosition(paramView);
    m = this.jdField_a_of_type_Int;
    int n = ((m - 1) * j + j + j) / m;
    if (k % m == 0)
    {
      paramRect.left = j;
      paramState = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment;
      paramState.d = (n - j);
      paramRect.right = paramState.d;
    }
    else if (k % m == m - 1)
    {
      paramRect.right = j;
      paramRect.left = (n - j);
    }
    else
    {
      paramRect.left = (j - this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment.d);
      paramState = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment;
      paramState.d = (n - (j - paramState.d));
      paramRect.right = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment.d;
    }
    if (paramRecyclerView.getChildAdapterPosition(paramView) < this.jdField_a_of_type_Int) {
      i = 1;
    }
    if (i == 0) {
      paramRect.top = ScreenUtil.dip2px(11.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.EmojiFragment.TempGridItemLayoutDecoration
 * JD-Core Version:    0.7.0.1
 */