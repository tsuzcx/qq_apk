package com.tencent.mobileqq.forward;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ForwardShortVideoOption$1$1
  implements Runnable
{
  ForwardShortVideoOption$1$1(ForwardShortVideoOption.1 param1) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentImageURLDrawable.setBounds(0, 0, this.a.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicWidth(), this.a.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicHeight());
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImage(this.a.jdField_a_of_type_ComTencentImageURLDrawable, true, 0, true);
    if (this.a.jdField_a_of_type_Boolean)
    {
      if ((this.a.jdField_a_of_type_Int != 0) && (this.a.b != 0))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setVideoFormat(true, false, ShortVideoUtils.stringForFileSize(this.a.this$0.a, this.a.jdField_a_of_type_Int), ShortVideoUtils.stringForTime(this.a.b * 1000));
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setVideoFormat(true, false, null, null);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setVideoFormat(true, false, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShortVideoOption.1.1
 * JD-Core Version:    0.7.0.1
 */