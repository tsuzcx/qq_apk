package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class SoftKeyboardHeight$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  SoftKeyboardHeight$1(SoftKeyboardHeight paramSoftKeyboardHeight) {}
  
  public void onGlobalLayout()
  {
    if (!SoftKeyboardHeight.a(this.a)) {}
    for (;;)
    {
      return;
      Object localObject = new Rect();
      SoftKeyboardHeight.a(this.a).getWindowVisibleDisplayFrame((Rect)localObject);
      int j = SoftKeyboardHeight.a(this.a) - ((Rect)localObject).height();
      SoftKeyboardHeight.a(this.a, ((Rect)localObject).height());
      if (j > SoftKeyboardHeight.b(this.a) / 3) {}
      for (int i = 1; i != 0; i = 0)
      {
        SoftKeyboardHeight.a(this.a, false);
        if (QLog.isColorLevel()) {
          QLog.d("SoftKeyboardHeight", 2, new Object[] { "onGlobalLayout, keyboard height:", Integer.valueOf(j) });
        }
        localObject = BaseApplication.getContext().getSharedPreferences("sp_soft_keyboard", 0);
        if (((SharedPreferences)localObject).getInt("key_height", 0) != j) {
          ((SharedPreferences)localObject).edit().putInt("key_height", j).commit();
        }
        if (SoftKeyboardHeight.a(this.a) != null) {
          SoftKeyboardHeight.a(this.a).a(j, false);
        }
        this.a.a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoftKeyboardHeight.1
 * JD-Core Version:    0.7.0.1
 */