package com.tencent.mobileqq.kandian.biz.comment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class ReadInJoyCommentUtils$4
  implements ActionSheet.OnButtonClickListener
{
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    if (paramInt >= 0)
    {
      paramView = this.b;
      if (paramInt >= paramView.length) {
        return;
      }
      paramView = this.c.getString(paramView[paramInt]);
      QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.c, 2131953338);
      localQQCustomDialog.setContentView(2131624587);
      localQQCustomDialog.setMessage(String.format(this.c.getString(2131915269), new Object[] { paramView }));
      localQQCustomDialog.setTitle(2131915270);
      ViewGroup.LayoutParams localLayoutParams = localQQCustomDialog.getMessageTextView().getLayoutParams();
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
        localMarginLayoutParams.leftMargin = ViewUtils.dip2px(12.0F);
        localMarginLayoutParams.rightMargin = ViewUtils.dip2px(12.0F);
        localQQCustomDialog.getMessageTextView().setLayoutParams(localLayoutParams);
      }
      localQQCustomDialog.setTag(paramView);
      localQQCustomDialog.setPositiveButton(2131915272, new ReadInJoyCommentUtils.4.1(this, paramView, paramInt + 1));
      localQQCustomDialog.setNegativeButton(2131915271, new ReadInJoyCommentUtils.4.2(this));
      localQQCustomDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.4
 * JD-Core Version:    0.7.0.1
 */