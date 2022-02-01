package com.tencent.widget;

import android.view.View.OnSystemUiVisibilityChangeListener;
import com.tencent.qphone.base.util.QLog;

class XPanelContainer$1
  implements View.OnSystemUiVisibilityChangeListener
{
  XPanelContainer$1(XPanelContainer paramXPanelContainer) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = false;; bool = true)
    {
      if (XPanelContainer.b != bool)
      {
        XPanelContainer.a(this.a, true);
        XPanelContainer.b = bool;
      }
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, "onSystemUiVisibilityChange..visibility =  " + paramInt + " context = " + this.a.getContext().getClass().getName());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.XPanelContainer.1
 * JD-Core Version:    0.7.0.1
 */