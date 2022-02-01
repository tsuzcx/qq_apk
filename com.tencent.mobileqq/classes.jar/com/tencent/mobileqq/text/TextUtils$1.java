package com.tencent.mobileqq.text;

import android.graphics.drawable.Drawable;
import behh;
import behi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public final class TextUtils$1
  implements Runnable
{
  public TextUtils$1(int paramInt, behi parambehi) {}
  
  public void run()
  {
    Drawable localDrawable = behh.b(BaseApplicationImpl.getContext().getResources(), this.jdField_a_of_type_Int);
    if ((localDrawable != null) && (this.jdField_a_of_type_Behi != null)) {
      this.jdField_a_of_type_Behi.a(localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.TextUtils.1
 * JD-Core Version:    0.7.0.1
 */