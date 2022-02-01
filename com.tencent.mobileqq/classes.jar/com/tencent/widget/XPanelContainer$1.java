package com.tencent.widget;

import android.view.View.OnSystemUiVisibilityChangeListener;
import com.tencent.qphone.base.util.QLog;

class XPanelContainer$1
  implements View.OnSystemUiVisibilityChangeListener
{
  XPanelContainer$1(XPanelContainer paramXPanelContainer) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    boolean bool;
    if (paramInt == 0) {
      bool = false;
    } else {
      bool = true;
    }
    if (XPanelContainer.b != bool)
    {
      XPanelContainer.a(this.a, true);
      XPanelContainer.b = bool;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSystemUiVisibilityChange..visibility =  ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" context = ");
      localStringBuilder.append(this.a.getContext().getClass().getName());
      QLog.d("XPanelContainer", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.XPanelContainer.1
 * JD-Core Version:    0.7.0.1
 */