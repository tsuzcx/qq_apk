package com.tencent.mobileqq.richstatus;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vas.signature.SignatureEditManager;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class SignatureHistoryFragment$7
  implements ActionSheet.OnButtonClickListener
{
  SignatureHistoryFragment$7(SignatureHistoryFragment paramSignatureHistoryFragment, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramView = new StringBuilder();
      paramView.append("");
      paramView.append(this.a);
      VasWebviewUtil.a("signature_history", "sheet", "", 0, 0, 0, "", "", paramView.toString(), "", "", "", "", 0, 0, 0, 0);
      if (SignatureHistoryFragment.c(this.d).equals(SignatureHistoryFragment.h(this.d))) {
        paramInt = 49;
      } else {
        paramInt = 50;
      }
      SignatureEditManager.a(this.d.getBaseActivity(), this.d.getBaseActivity().app, 0, "signature_history", -1, this.b, this.c, null, paramInt);
    }
    if (SignatureHistoryFragment.i(this.d) != null) {
      SignatureHistoryFragment.i(this.d).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.7
 * JD-Core Version:    0.7.0.1
 */