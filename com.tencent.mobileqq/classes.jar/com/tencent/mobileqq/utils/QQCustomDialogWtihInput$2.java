package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.SoftReference;

class QQCustomDialogWtihInput$2
  implements View.OnClickListener
{
  QQCustomDialogWtihInput$2(QQCustomDialogWtihInput paramQQCustomDialogWtihInput, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick timeGap:" + (System.currentTimeMillis() - QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput)) + " MANUFACTURER:" + Build.MANUFACTURER + " MODEL:" + Build.MODEL);
    }
    if ((System.currentTimeMillis() - QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput) < 800L) && (QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput))) {
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick skip");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput).getText().toString();
      if (localObject != null) {
        if ((QQEmojiUtil.containsEmoji((String)localObject)) || (QQSysFaceUtil.containsExpression((String)localObject)))
        {
          localObject = (Context)QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput).get();
          if (localObject != null)
          {
            localObject = new QQToast((Context)localObject);
            ((QQToast)localObject).d(2000);
            ((QQToast)localObject).c(2131719977);
            ((QQToast)localObject).a();
          }
        }
        else if ((QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput) == null) && (24 < ((String)localObject).getBytes().length))
        {
          localObject = (Context)QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput).get();
          if (localObject != null)
          {
            localObject = new QQToast((Context)localObject);
            ((QQToast)localObject).d(2000);
            ((QQToast)localObject).c(2131719978);
            ((QQToast)localObject).a();
          }
        }
        else
        {
          if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
            this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput, 1);
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput.dismiss();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInput.2
 * JD-Core Version:    0.7.0.1
 */