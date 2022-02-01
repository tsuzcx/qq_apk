package com.tencent.mobileqq.leba.qcircle.mainbiz;

import android.text.TextUtils;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import java.util.ArrayList;
import java.util.List;

class LebaQCirclePart$2
  implements Runnable
{
  LebaQCirclePart$2(LebaQCirclePart paramLebaQCirclePart, int paramInt, QBaseActivity paramQBaseActivity, boolean paramBoolean1, String paramString, List paramList, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if (this.this$0.c != null) {
        this.this$0.c.setVisibility(0);
      }
      CustomWidgetUtil.a(this.this$0.c, 9, this.jdField_a_of_type_Int, 0);
      CustomWidgetUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.this$0.c, 9, this.this$0.b());
      if (this.this$0.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.this$0.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    for (;;)
    {
      try
      {
        ((RelativeLayout.LayoutParams)this.this$0.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).rightMargin = 0;
        if (this.jdField_a_of_type_Boolean)
        {
          if (this.this$0.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            CustomWidgetUtil.a(this.this$0.jdField_a_of_type_AndroidWidgetTextView, 8, 0, 0);
            CustomWidgetUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.this$0.jdField_a_of_type_AndroidWidgetTextView, 8, this.this$0.b());
            if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
              this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_JavaUtilList);
            }
            this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          ArrayList localArrayList = new ArrayList();
          if (this.jdField_a_of_type_JavaUtilList != null) {
            localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
          }
          if ((this.this$0.jdField_b_of_type_AndroidWidgetImageSwitcher != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null)) {
            this.this$0.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.a(localArrayList);
          }
          this.this$0.q();
          return;
          if (this.this$0.c == null) {
            break;
          }
          this.this$0.c.setVisibility(8);
          break;
        }
        if (this.b)
        {
          if (this.this$0.jdField_a_of_type_AndroidWidgetTextView == null) {
            continue;
          }
          this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          CustomWidgetUtil.a(this.this$0.jdField_a_of_type_AndroidWidgetTextView, 8, this.jdField_a_of_type_Int, 0);
          CustomWidgetUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.this$0.jdField_a_of_type_AndroidWidgetTextView, 10, this.this$0.b());
          continue;
        }
        if (!this.c) {
          break label416;
        }
      }
      catch (Exception localException)
      {
        QLog.e("QCircleEeveeRedPoint_LebaQCirclePartImpl", 1, "updateQQCircleRedFlag" + localException);
        return;
      }
      this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_JavaUtilList);
      continue;
      label416:
      if (this.d) {
        this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_JavaUtilList);
      } else if (this.this$0.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mainbiz.LebaQCirclePart.2
 * JD-Core Version:    0.7.0.1
 */