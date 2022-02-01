package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.widget.ActionSheet.OnDismissListener;

class SignatureHistoryFragment$8
  implements ActionSheet.OnDismissListener
{
  SignatureHistoryFragment$8(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void onDismiss()
  {
    SignatureHistoryFragment.a(this.a, null);
    VasWebviewUtil.a("signature_history", "sheet", "", 0, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.8
 * JD-Core Version:    0.7.0.1
 */