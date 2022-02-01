package com.tencent.mobileqq.magicface.view;

import android.view.View;
import android.widget.TextView;
import avli;
import avmr;
import avmu;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

public class MagicfaceViewController$7$1
  implements Runnable
{
  public MagicfaceViewController$7$1(avmu paramavmu, avli paramavli) {}
  
  public void run()
  {
    
    if (this.jdField_a_of_type_Avmu.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Avmu.jdField_a_of_type_Avmr.c();
    }
    for (;;)
    {
      this.jdField_a_of_type_Avmu.jdField_a_of_type_Avmr.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_Avmu.jdField_a_of_type_Avmr.jdField_b_of_type_AndroidWidgetTextView.setText("");
      if ((this.jdField_a_of_type_Avli != null) && ("gravity".equalsIgnoreCase(this.jdField_a_of_type_Avli.c))) {
        this.jdField_a_of_type_Avmu.jdField_a_of_type_Avmr.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.turnOffShake();
      }
      return;
      ((View)this.jdField_a_of_type_Avmu.jdField_a_of_type_Avmr.jdField_b_of_type_Avmn).setBackgroundColor(this.jdField_a_of_type_Avli.jdField_a_of_type_Int);
      this.jdField_a_of_type_Avmu.jdField_a_of_type_Avmr.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.7.1
 * JD-Core Version:    0.7.0.1
 */