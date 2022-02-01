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
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramView = new StringBuilder();
      paramView.append("");
      paramView.append(this.jdField_a_of_type_Int);
      VasWebviewUtil.a("signature_history", "sheet", "", 0, 0, 0, "", "", paramView.toString(), "", "", "", "", 0, 0, 0, 0);
      if (SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment).equals(SignatureHistoryFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment))) {
        paramInt = 49;
      } else {
        paramInt = 50;
      }
      SignatureEditManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment.getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment.getBaseActivity().app, 0, "signature_history", -1, this.b, this.c, null, paramInt);
    }
    if (SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment) != null) {
      SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.7
 * JD-Core Version:    0.7.0.1
 */