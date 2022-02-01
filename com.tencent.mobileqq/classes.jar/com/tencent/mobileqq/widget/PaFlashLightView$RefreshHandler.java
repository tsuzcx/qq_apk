package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;

class PaFlashLightView$RefreshHandler
  extends Handler
{
  private WeakReference<PaFlashLightView> a;
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (PaFlashLightView)this.a.get();
    if (paramMessage == null) {
      return;
    }
    int i = paramMessage.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        paramMessage.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
        if (paramMessage.jdField_a_of_type_Boolean)
        {
          paramMessage.jdField_c_of_type_ComTencentImageURLImageView.startAnimation(paramMessage.jdField_a_of_type_AndroidViewAnimationAnimation);
          return;
        }
        paramMessage.jdField_c_of_type_ComTencentImageURLImageView.startAnimation(paramMessage.jdField_c_of_type_AndroidViewAnimationAnimation);
        return;
      }
      paramMessage.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (paramMessage.jdField_a_of_type_Boolean)
      {
        paramMessage.jdField_b_of_type_ComTencentImageURLImageView.startAnimation(paramMessage.jdField_b_of_type_AndroidViewAnimationAnimation);
        return;
      }
      paramMessage.jdField_b_of_type_ComTencentImageURLImageView.startAnimation(paramMessage.jdField_c_of_type_AndroidViewAnimationAnimation);
      return;
    }
    paramMessage.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if (paramMessage.jdField_a_of_type_Boolean)
    {
      paramMessage.startAnimation(paramMessage.jdField_a_of_type_AndroidViewAnimationAnimation);
      return;
    }
    paramMessage.startAnimation(paramMessage.jdField_c_of_type_AndroidViewAnimationAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PaFlashLightView.RefreshHandler
 * JD-Core Version:    0.7.0.1
 */