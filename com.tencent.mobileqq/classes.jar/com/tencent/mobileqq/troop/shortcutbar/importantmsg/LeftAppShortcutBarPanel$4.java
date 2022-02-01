package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class LeftAppShortcutBarPanel$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  LeftAppShortcutBarPanel$4(LeftAppShortcutBarPanel paramLeftAppShortcutBarPanel) {}
  
  public void onGlobalLayout()
  {
    LeftAppShortcutBarPanel.a(this.a, this.a.jdField_a_of_type_JavaUtilArrayList);
    if ((LeftAppShortcutBarPanel.a(this.a) != null) && (LeftAppShortcutBarPanel.a(this.a).getViewTreeObserver() != null) && (Build.VERSION.SDK_INT > 16) && (this.a.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)) {
      LeftAppShortcutBarPanel.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this.a.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel.4
 * JD-Core Version:    0.7.0.1
 */