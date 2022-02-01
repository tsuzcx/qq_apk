package com.tencent.mobileqq.richstatus;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.vas.signature.SignatureEditManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
      VasWebviewUtil.reportCommercialDrainage("signature_history", "sheet", "", 0, 0, 0, "", "", "" + this.jdField_a_of_type_Int, "", "", "", "", 0, 0, 0, 0);
      SignatureEditManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment.getActivity().app, 0, "signature_history", -1, this.b, this.c, null);
    }
    if (SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment) != null) {
      SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.7
 * JD-Core Version:    0.7.0.1
 */