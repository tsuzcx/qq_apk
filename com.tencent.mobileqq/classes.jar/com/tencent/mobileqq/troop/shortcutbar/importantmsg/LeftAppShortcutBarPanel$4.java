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
    LeftAppShortcutBarPanel localLeftAppShortcutBarPanel = this.a;
    LeftAppShortcutBarPanel.a(localLeftAppShortcutBarPanel, localLeftAppShortcutBarPanel.a);
    if ((LeftAppShortcutBarPanel.a(this.a) != null) && (LeftAppShortcutBarPanel.a(this.a).getViewTreeObserver() != null) && (Build.VERSION.SDK_INT > 16) && (this.a.i != null)) {
      LeftAppShortcutBarPanel.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this.a.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel.4
 * JD-Core Version:    0.7.0.1
 */