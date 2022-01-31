package com.tencent.mobileqq.richstatus;

import android.widget.RelativeLayout;
import com.tencent.widget.XListView;

class SignatureHistoryFragment$17
  implements Runnable
{
  SignatureHistoryFragment$17(SignatureHistoryFragment paramSignatureHistoryFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentWidgetXListView.smoothScrollBy(this.jdField_a_of_type_Int - (this.b - this.c), 100);
    if (this.jdField_a_of_type_Boolean) {
      SignatureHistoryFragment.a(this.this$0).addOnLayoutChangeListener(this.this$0.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.17
 * JD-Core Version:    0.7.0.1
 */