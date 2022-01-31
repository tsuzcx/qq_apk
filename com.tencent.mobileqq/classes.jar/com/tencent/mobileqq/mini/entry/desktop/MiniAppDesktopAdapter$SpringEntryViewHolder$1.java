package com.tencent.mobileqq.mini.entry.desktop;

import ahfz;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;

class MiniAppDesktopAdapter$SpringEntryViewHolder$1
  implements View.OnClickListener
{
  MiniAppDesktopAdapter$SpringEntryViewHolder$1(MiniAppDesktopAdapter.SpringEntryViewHolder paramSpringEntryViewHolder, MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  public void onClick(View paramView)
  {
    paramView = MiniAppUtils.getAppInterface();
    if (paramView != null) {
      ((ahfz)paramView.getManager(342)).a(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.SpringEntryViewHolder.1
 * JD-Core Version:    0.7.0.1
 */