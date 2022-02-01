package com.tencent.mobileqq.flashshow.helper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FSPopupWindowHelper$1
  implements View.OnClickListener
{
  FSPopupWindowHelper$1(FSPopupWindowHelper paramFSPopupWindowHelper, FSPopupWindowHelper.MenuClickListener paramMenuClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.a != null)
    {
      int i = paramView.getId();
      if (i == 2131433383) {
        this.a.a(FSPopupWindowHelper.MenuType.a);
      } else if (i == 2131433379) {
        this.a.a(FSPopupWindowHelper.MenuType.b);
      } else if (i == 2131433380) {
        this.a.a(FSPopupWindowHelper.MenuType.c);
      } else if (i == 2131433382) {
        this.a.a(FSPopupWindowHelper.MenuType.d);
      } else if (i == 2131433381) {
        this.a.a(FSPopupWindowHelper.MenuType.e);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSPopupWindowHelper.1
 * JD-Core Version:    0.7.0.1
 */