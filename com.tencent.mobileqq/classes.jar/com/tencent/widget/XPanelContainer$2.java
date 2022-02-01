package com.tencent.widget;

import android.app.Activity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.qphone.base.util.QLog;

class XPanelContainer$2
  implements View.OnFocusChangeListener
{
  XPanelContainer$2(XPanelContainer paramXPanelContainer) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((QLog.isColorLevel()) && ((this.a.getContext() instanceof Activity))) {
      QLog.d("XPanelContainer", 2, new Object[] { "input focus changed, hasFocus=", Boolean.valueOf(paramBoolean), ", current focus=", ((Activity)this.a.getContext()).getCurrentFocus() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.XPanelContainer.2
 * JD-Core Version:    0.7.0.1
 */