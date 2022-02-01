package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LeftAppShortcutBarPanel$2
  implements View.OnClickListener
{
  LeftAppShortcutBarPanel$2(LeftAppShortcutBarPanel paramLeftAppShortcutBarPanel) {}
  
  public void onClick(View paramView)
  {
    if (LeftAppShortcutBarPanel.b(this.a) != null)
    {
      LeftAppShortcutBarPanel.b(this.a).a(paramView);
      if (LeftAppShortcutBarPanel.d(this.a) != null) {
        LeftAppShortcutBarPanel.d(this.a).b(paramView, 0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel.2
 * JD-Core Version:    0.7.0.1
 */