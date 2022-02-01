package com.tencent.mobileqq.richstatus;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class SignatureHistoryFragment$22
  implements ActionSheet.OnButtonClickListener
{
  SignatureHistoryFragment$22(SignatureHistoryFragment paramSignatureHistoryFragment, CommentItem paramCommentItem, String paramString, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (!NetworkUtil.isNetSupport(this.d.getBaseActivity()))
      {
        QQToast.makeText(this.d.getBaseActivity(), 2131890731, 0).show();
      }
      else
      {
        SignatureHistoryFragment.a(this.d, this.a);
        if ((this.a != null) && (!TextUtils.isEmpty(SignatureHistoryFragment.c(this.d))) && (!TextUtils.isEmpty(this.b)))
        {
          if (SignatureHistoryFragment.e(this.d) == null)
          {
            paramView = this.d;
            SignatureHistoryFragment.a(paramView, new QQProgressDialog(paramView.getBaseActivity(), this.d.getBaseActivity().getTitleBarHeight()));
          }
          SignatureHistoryFragment.e(this.d).a(null);
          SignatureHistoryFragment.e(this.d).show();
          this.d.d.a(Long.valueOf(SignatureHistoryFragment.c(this.d)).longValue(), this.a.feedId, Long.valueOf(this.b).longValue(), this.a.id);
        }
      }
    }
    this.c.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.22
 * JD-Core Version:    0.7.0.1
 */