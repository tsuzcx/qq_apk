package com.tencent.widget;

import android.app.Activity;
import android.os.IBinder;
import android.widget.Button;
import com.tencent.mobileqq.app.HardCodeUtil;

public class KandianPopupWindowForAd
  extends KandianPopupWindow
{
  public boolean b = true;
  
  public KandianPopupWindowForAd(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131706012));
    }
    b();
  }
  
  protected void a(IBinder paramIBinder)
  {
    if (this.b) {
      super.a(paramIBinder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.KandianPopupWindowForAd
 * JD-Core Version:    0.7.0.1
 */