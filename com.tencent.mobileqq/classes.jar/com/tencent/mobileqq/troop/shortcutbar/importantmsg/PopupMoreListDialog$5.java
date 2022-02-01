package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PopupMoreListDialog$5
  implements View.OnClickListener
{
  PopupMoreListDialog$5(PopupMoreListDialog paramPopupMoreListDialog) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (PopupMoreListDialog.a(this.a) == null) || (PopupMoreListDialog.a(this.a).a == null) || (PopupMoreListDialog.a(this.a) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView.getTag() instanceof ShortcutBarInfo))
      {
        PopupMoreListDialog.a(this.a).a(paramView);
        PopupMoreListDialog.a(this.a).b(paramView, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.PopupMoreListDialog.5
 * JD-Core Version:    0.7.0.1
 */