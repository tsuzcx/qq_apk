package com.tencent.mobileqq.text;

import android.graphics.drawable.Drawable;
import axku;
import axkv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public final class TextUtils$2
  implements Runnable
{
  public TextUtils$2(int paramInt, axkv paramaxkv) {}
  
  public void run()
  {
    Drawable localDrawable = axku.a(BaseApplicationImpl.getContext().getResources(), this.jdField_a_of_type_Int);
    if ((localDrawable != null) && (this.jdField_a_of_type_Axkv != null)) {
      this.jdField_a_of_type_Axkv.a(localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.text.TextUtils.2
 * JD-Core Version:    0.7.0.1
 */