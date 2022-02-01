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
      if ((paramView == LeftAppShortcutBarPanel.a(this.a)) && (this.a.a != null) && (LeftAppShortcutBarPanel.a(this.a) != null))
      {
        Object localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        ImageView localImageView = (ImageView)paramView.findViewById(2131377472);
        if (LeftAppShortcutBarPanel.a(this.a) != null) {
          if (!LeftAppShortcutBarPanel.a(this.a).a())
          {
            int i;
            if (LeftAppShortcutBarPanel.a(this.a).a() > 5) {
              i = ViewUtils.a(247.0F);
            } else {
              i = ViewUtils.a(LeftAppShortcutBarPanel.a(this.a).a() * 40 + 7);
            }
            LeftAppShortcutBarPanel.a(this.a).b(paramView, paramView.getWidth(), 0, localObject[0] - ViewUtils.a(175.0F) / 2, localObject[1] - i);
            localImageView.setImageResource(2130846404);
            localObject = (TextView)LeftAppShortcutBarPanel.a(this.a).findViewById(2131377459);
            if (localObject != null) {
              ((TextView)localObject).setVisibility(4);
            }
          }
          else
          {
            LeftAppShortcutBarPanel.a(this.a).d();
          }
        }
      }
      else
      {
        LeftAppShortcutBarPanel.a(this.a).onClick(paramView);
        if (LeftAppShortcutBarPanel.a(this.a) != null) {
          LeftAppShortcutBarPanel.a(this.a).a(paramView, 0);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel.1
 * JD-Core Version:    0.7.0.1
 */