package com.tencent.widget;

import android.app.Activity;
import android.os.IBinder;
import android.widget.Button;
import com.tencent.mobileqq.app.HardCodeUtil;

public class KandianPopupWindowForAd
  extends KandianPopupWindow
{
  public boolean k = true;
  
  public KandianPopupWindowForAd(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  protected void a(IBinder paramIBinder)
  {
    if (this.k) {
      super.a(paramIBinder);
    }
  }
  
  public void b()
  {
    super.b();
    this.a = false;
    if (this.b != null) {
      this.b.setText(HardCodeUtil.a(2131903886));
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.KandianPopupWindowForAd
 * JD-Core Version:    0.7.0.1
 */