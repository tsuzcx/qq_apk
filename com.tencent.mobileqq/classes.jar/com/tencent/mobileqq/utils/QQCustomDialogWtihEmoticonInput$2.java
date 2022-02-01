package com.tencent.mobileqq.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;

class QQCustomDialogWtihEmoticonInput$2
  implements View.OnTouchListener
{
  QQCustomDialogWtihEmoticonInput$2(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840141);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130840141));
    if (this.a.c)
    {
      QQCustomDialogWtihEmoticonInput.a(this.a);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_AndroidViewWindowManager.removeView(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView());
      } else {
        this.a.jdField_a_of_type_AndroidViewWindowManager.removeView(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
      }
      paramView = this.a;
      paramView.c = false;
      paramView = paramView.getWindow().getAttributes();
      paramView.y = 0;
      this.a.getWindow().setAttributes(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.2
 * JD-Core Version:    0.7.0.1
 */