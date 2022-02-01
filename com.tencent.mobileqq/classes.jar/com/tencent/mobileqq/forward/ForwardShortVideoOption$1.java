package com.tencent.mobileqq.forward;

import android.app.Activity;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ForwardShortVideoOption$1
  implements Runnable
{
  ForwardShortVideoOption$1(ForwardShortVideoOption paramForwardShortVideoOption, URLDrawable paramURLDrawable, QQCustomDialog paramQQCustomDialog, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    URLDrawableHelper.decodeLocalImage(this.jdField_a_of_type_ComTencentImageURLDrawable, null, false);
    this.this$0.a.runOnUiThread(new ForwardShortVideoOption.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShortVideoOption.1
 * JD-Core Version:    0.7.0.1
 */