package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.widget.ImageView;
import bged;
import bgee;
import bgew;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ArithmeticViewHolder$ImageUploadHandler$1
  implements Runnable
{
  public ArithmeticViewHolder$ImageUploadHandler$1(bgew parambgew, bgee parambgee) {}
  
  public void run()
  {
    ArithmeticViewHolder.a(this.jdField_a_of_type_Bgew.a).a();
    ArithmeticViewHolder.ArithmeticImageView localArithmeticImageView = (ArithmeticViewHolder.ArithmeticImageView)ArithmeticViewHolder.a(this.jdField_a_of_type_Bgew.a).get(this.jdField_a_of_type_Bgee);
    if (localArithmeticImageView == null) {}
    for (;;)
    {
      return;
      switch (this.jdField_a_of_type_Bgee.jdField_b_of_type_Int)
      {
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ArithmeticViewHolder", 2, "updateUploadStatus , status = " + this.jdField_a_of_type_Bgee.jdField_b_of_type_Int + " ;local path = " + this.jdField_a_of_type_Bgee.jdField_b_of_type_JavaLangString);
        return;
        localArithmeticImageView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localArithmeticImageView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        localArithmeticImageView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        localArithmeticImageView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(this.jdField_a_of_type_Bgee.a, this.jdField_a_of_type_Bgee.jdField_b_of_type_JavaLangString);
        continue;
        localArithmeticImageView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
        localArithmeticImageView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        continue;
        localArithmeticImageView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
        localArithmeticImageView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder.ImageUploadHandler.1
 * JD-Core Version:    0.7.0.1
 */