package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class LeftAppShortcutBarPanel$3
  implements PopupWindow.OnDismissListener
{
  LeftAppShortcutBarPanel$3(LeftAppShortcutBarPanel paramLeftAppShortcutBarPanel) {}
  
  public void onDismiss()
  {
    if ((LeftAppShortcutBarPanel.a(this.a) != null) && (LeftAppShortcutBarPanel.a(this.a) != null))
    {
      Object localObject = (ImageView)LeftAppShortcutBarPanel.a(this.a).findViewById(2131378047);
      if (localObject != null)
      {
        ((ImageView)localObject).setImageResource(2130846530);
        localObject = (TextView)LeftAppShortcutBarPanel.a(this.a).findViewById(2131378034);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
      }
      LeftAppShortcutBarPanel.a(this.a).c();
      ThreadManager.getUIHandler().postDelayed(new LeftAppShortcutBarPanel.3.1(this), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel.3
 * JD-Core Version:    0.7.0.1
 */