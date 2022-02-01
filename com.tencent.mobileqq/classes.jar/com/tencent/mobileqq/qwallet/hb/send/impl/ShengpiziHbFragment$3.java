package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class ShengpiziHbFragment$3
  implements View.OnClickListener
{
  ShengpiziHbFragment$3(ShengpiziHbFragment paramShengpiziHbFragment, TextView paramTextView) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment.jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidWidgetTextView.getText();
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment.jdField_a_of_type_JavaLangString = ((TextView)paramView).getText().toString();
      paramView = new StringBuilder();
      paramView.append("choice: ");
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment.jdField_a_of_type_JavaLangString);
      QLog.i("ShengPiZiHbFragment", 2, paramView.toString());
      ShengpiziHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment).setText(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplShengpiziHbFragment.jdField_a_of_type_AndroidViewView.post(new ShengpiziHbFragment.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ShengpiziHbFragment.3
 * JD-Core Version:    0.7.0.1
 */