package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LeftAppShortcutBarPanel$1
  implements View.OnClickListener
{
  LeftAppShortcutBarPanel$1(LeftAppShortcutBarPanel paramLeftAppShortcutBarPanel) {}
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      if ((paramView == LeftAppShortcutBarPanel.a(this.a)) && (this.a.d != null) && (LeftAppShortcutBarPanel.b(this.a) != null))
      {
        Object localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        ImageView localImageView = (ImageView)paramView.findViewById(2131445871);
        if (LeftAppShortcutBarPanel.c(this.a) != null) {
          if (!LeftAppShortcutBarPanel.c(this.a).c())
          {
            int i;
            if (LeftAppShortcutBarPanel.c(this.a).f() > 5) {
              i = ViewUtils.dip2px(247.0F);
            } else {
              i = ViewUtils.dip2px(LeftAppShortcutBarPanel.c(this.a).f() * 40 + 7);
            }
            LeftAppShortcutBarPanel.c(this.a).b(paramView, paramView.getWidth(), 0, localObject[0] - ViewUtils.dip2px(175.0F) / 2, localObject[1] - i);
            localImageView.setImageResource(2130847877);
            localObject = (TextView)LeftAppShortcutBarPanel.a(this.a).findViewById(2131445858);
            if (localObject != null) {
              ((TextView)localObject).setVisibility(4);
            }
          }
          else
          {
            LeftAppShortcutBarPanel.c(this.a).e();
          }
        }
      }
      else
      {
        LeftAppShortcutBarPanel.b(this.a).onClick(paramView);
        if (LeftAppShortcutBarPanel.d(this.a) != null) {
          LeftAppShortcutBarPanel.d(this.a).a(paramView, 0);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel.1
 * JD-Core Version:    0.7.0.1
 */