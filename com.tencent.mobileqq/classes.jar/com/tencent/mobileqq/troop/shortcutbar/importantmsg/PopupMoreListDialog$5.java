package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PopupMoreListDialog$5
  implements View.OnClickListener
{
  PopupMoreListDialog$5(PopupMoreListDialog paramPopupMoreListDialog) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (PopupMoreListDialog.f(this.a) != null) && (PopupMoreListDialog.e(this.a) != null) && ((paramView.getTag() instanceof ShortcutBarInfo)))
    {
      PopupMoreListDialog.e(this.a).a(paramView);
      PopupMoreListDialog.b(this.a).b(paramView, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.PopupMoreListDialog.5
 * JD-Core Version:    0.7.0.1
 */