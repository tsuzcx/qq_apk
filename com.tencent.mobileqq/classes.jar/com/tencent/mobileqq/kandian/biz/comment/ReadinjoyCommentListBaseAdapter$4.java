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

class ReadinjoyCommentListBaseAdapter$4
  implements ActionSheet.OnButtonClickListener
{
  ReadinjoyCommentListBaseAdapter$4(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, ActionSheet paramActionSheet, int[] paramArrayOfInt, Context paramContext, ReadInJoyCommentUtils.ReportCommentDialogClickListener paramReportCommentDialogClickListener) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if (paramInt >= 0)
    {
      paramView = this.jdField_a_of_type_ArrayOfInt;
      if (paramInt >= paramView.length) {
        return;
      }
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(paramView[paramInt]);
      QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_AndroidContentContext, 2131756189);
      localQQCustomDialog.setContentView(2131558954);
      localQQCustomDialog.setMessage(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131717794), new Object[] { paramView }));
      localQQCustomDialog.setTitle(2131717795);
      ViewGroup.LayoutParams localLayoutParams = localQQCustomDialog.getMessageTextView().getLayoutParams();
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
        localMarginLayoutParams.leftMargin = ViewUtils.a(12.0F);
        localMarginLayoutParams.rightMargin = ViewUtils.a(12.0F);
        localQQCustomDialog.getMessageTextView().setLayoutParams(localLayoutParams);
      }
      localQQCustomDialog.setTag(paramView);
      localQQCustomDialog.setPositiveButton(2131717797, new ReadinjoyCommentListBaseAdapter.4.1(this, paramView, paramInt + 1));
      localQQCustomDialog.setNegativeButton(2131717796, new ReadinjoyCommentListBaseAdapter.4.2(this));
      localQQCustomDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter.4
 * JD-Core Version:    0.7.0.1
 */