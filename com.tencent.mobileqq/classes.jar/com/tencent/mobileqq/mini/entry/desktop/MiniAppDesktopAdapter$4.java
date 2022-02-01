package com.tencent.mobileqq.mini.entry.desktop;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.qphone.base.util.QLog;

class MiniAppDesktopAdapter$4
  implements View.OnLongClickListener
{
  MiniAppDesktopAdapter$4(MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((!(paramView instanceof Integer)) && (QLog.isColorLevel())) {
      QLog.i("MiniAppDesktopAdapter", 2, "onLongClick. obj = " + paramView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.4
 * JD-Core Version:    0.7.0.1
 */