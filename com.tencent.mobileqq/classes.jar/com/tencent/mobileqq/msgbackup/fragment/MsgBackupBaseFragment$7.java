package com.tencent.mobileqq.msgbackup.fragment;

import android.widget.TextView;

class MsgBackupBaseFragment$7
  implements Runnable
{
  MsgBackupBaseFragment$7(MsgBackupBaseFragment paramMsgBackupBaseFragment, TextView paramTextView, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.7
 * JD-Core Version:    0.7.0.1
 */