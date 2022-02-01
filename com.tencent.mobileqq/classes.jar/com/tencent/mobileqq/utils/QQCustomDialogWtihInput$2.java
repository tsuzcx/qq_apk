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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setPositiveButton onClick timeGap:");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput));
      ((StringBuilder)localObject).append(" MANUFACTURER:");
      ((StringBuilder)localObject).append(Build.MANUFACTURER);
      ((StringBuilder)localObject).append(" MODEL:");
      ((StringBuilder)localObject).append(Build.MODEL);
      QLog.d("QQCustomDialogWtihInput", 2, ((StringBuilder)localObject).toString());
    }
    if ((System.currentTimeMillis() - QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput) < 800L) && (QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick skip");
      }
    }
    else
    {
      localObject = QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput).getText().toString();
      if (localObject != null) {
        if ((!QQEmojiUtil.containsEmoji((String)localObject)) && (!QQSysFaceUtil.containsExpression((String)localObject)))
        {
          if ((QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput) == null) && (24 < ((String)localObject).getBytes().length))
          {
            localObject = (Context)QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput).get();
            if (localObject != null)
            {
              localObject = new QQToast((Context)localObject);
              ((QQToast)localObject).d(2000);
              ((QQToast)localObject).c(2131719710);
              ((QQToast)localObject).a();
            }
          }
          else
          {
            localObject = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
            if (localObject != null) {
              ((DialogInterface.OnClickListener)localObject).onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput, 1);
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput.dismiss();
          }
        }
        else
        {
          localObject = (Context)QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput).get();
          if (localObject != null)
          {
            localObject = new QQToast((Context)localObject);
            ((QQToast)localObject).d(2000);
            ((QQToast)localObject).c(2131719709);
            ((QQToast)localObject).a();
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInput.2
 * JD-Core Version:    0.7.0.1
 */