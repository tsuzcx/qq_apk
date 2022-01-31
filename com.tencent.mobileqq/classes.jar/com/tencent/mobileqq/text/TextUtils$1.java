package com.tencent.mobileqq.text;

import android.graphics.drawable.Drawable;
import banh;
import bani;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public final class TextUtils$1
  implements Runnable
{
  public TextUtils$1(int paramInt, bani parambani) {}
  
  public void run()
  {
    Drawable localDrawable = banh.b(BaseApplicationImpl.getContext().getResources(), this.jdField_a_of_type_Int);
    if ((localDrawable != null) && (this.jdField_a_of_type_Bani != null)) {
      this.jdField_a_of_type_Bani.a(localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.text.TextUtils.1
 * JD-Core Version:    0.7.0.1
 */