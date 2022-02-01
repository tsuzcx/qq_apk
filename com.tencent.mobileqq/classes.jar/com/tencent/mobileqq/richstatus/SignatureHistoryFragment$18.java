package com.tencent.mobileqq.richstatus;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class SignatureHistoryFragment$18
  implements ActionSheet.OnButtonClickListener
{
  SignatureHistoryFragment$18(SignatureHistoryFragment paramSignatureHistoryFragment, CommentItem paramCommentItem, String paramString, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
      return;
      if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment.getActivity()))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment.getActivity(), 2131693237, 0).a();
      }
      else
      {
        SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment, this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem);
        if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem != null) && (!TextUtils.isEmpty(SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment))) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
        {
          if (SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment) == null) {
            SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment, new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment.getActivity().getTitleBarHeight()));
          }
          SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment).a(null);
          SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment).show();
          this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment.a.a(Long.valueOf(SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment)).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.id);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.18
 * JD-Core Version:    0.7.0.1
 */