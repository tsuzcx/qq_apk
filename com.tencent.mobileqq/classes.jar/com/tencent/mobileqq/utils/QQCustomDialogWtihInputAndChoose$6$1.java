package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.widget.MyLinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

class QQCustomDialogWtihInputAndChoose$6$1
  implements Runnable
{
  QQCustomDialogWtihInputAndChoose$6$1(QQCustomDialogWtihInputAndChoose.6 param6) {}
  
  public void run()
  {
    int j = 0;
    int k = this.a.this$0.a(this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetMyLinearLayout);
    int m = this.a.this$0.a(this.a.this$0.jdField_a_of_type_AndroidWidgetRelativeLayout);
    int n = this.a.this$0.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    Object localObject1 = this.a.this$0.getWindow().getAttributes();
    int i;
    Object localObject2;
    if (k - n > 0)
    {
      i = this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetMyLinearLayout.getHeight() / 2;
      ((WindowManager.LayoutParams)localObject1).y = (-i);
      this.a.this$0.getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
      if ((this.a.this$0.c) && (this.a.this$0.jdField_a_of_type_AndroidWidgetEditText.getText() != null) && (TextUtils.isEmpty(this.a.this$0.jdField_a_of_type_AndroidWidgetEditText.getText().toString())))
      {
        localObject1 = (LinearLayout)this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetMyLinearLayout.findViewById(2131370455);
        if ((localObject1 != null) && (((LinearLayout)localObject1).getChildCount() > 0))
        {
          localObject1 = ((LinearLayout)localObject1).getChildAt(0);
          localObject2 = (TextView)((View)localObject1).findViewById(2131370454);
          if (((TextView)localObject2).getText() != null) {
            this.a.this$0.a(((TextView)localObject2).getText().toString());
          }
          localObject1 = ((View)localObject1).findViewById(2131370453);
          ((View)localObject1).setVisibility(0);
          this.a.this$0.jdField_a_of_type_AndroidViewView = ((View)localObject1);
          this.a.this$0.c = false;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = (Context)this.a.this$0.jdField_a_of_type_JavaLangRefSoftReference.get();
        if (localObject1 != null) {
          j = ((Context)localObject1).getResources().getDisplayMetrics().heightPixels;
        }
        localObject2 = new StringBuilder(128);
        if (localObject1 != null) {
          break label429;
        }
        ((StringBuilder)localObject2).append("|context is null");
      }
    }
    for (;;)
    {
      ((StringBuilder)localObject2).append("|screenHeight=").append(j).append("|emoSpaceY=").append(k).append("|dialogY=").append(m).append("|dialogHeight=").append(n).append("|moveY=").append(i);
      QLog.d("QQCustomDialogWtihInputAndChoose.meassure", 2, ((StringBuilder)localObject2).toString());
      return;
      i = m + n - k;
      break;
      label429:
      ((StringBuilder)localObject2).append("|context is not null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.6.1
 * JD-Core Version:    0.7.0.1
 */