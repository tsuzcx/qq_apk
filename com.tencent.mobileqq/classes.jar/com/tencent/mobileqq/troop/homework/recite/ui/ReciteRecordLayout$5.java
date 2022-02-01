package com.tencent.mobileqq.troop.homework.recite.ui;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class ReciteRecordLayout$5
  extends CountDownTimer
{
  ReciteRecordLayout$5(ReciteRecordLayout paramReciteRecordLayout, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    this.a.jdField_a_of_type_Boolean = false;
    if (this.a.b())
    {
      this.a.a();
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
      {
        QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(2131697441).setNegativeButton(2131697477, new ReciteRecordLayout.5.2(this)).setPositiveButton(2131697469, new ReciteRecordLayout.5.1(this));
        localQQCustomDialog.setCancelable(false);
        localQQCustomDialog.show();
      }
    }
  }
  
  public void onTick(long paramLong)
  {
    int i = (int)(paramLong / 1000L);
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "onTick remainSecond = " + i);
    }
    if (i == 5) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131697433);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout.5
 * JD-Core Version:    0.7.0.1
 */