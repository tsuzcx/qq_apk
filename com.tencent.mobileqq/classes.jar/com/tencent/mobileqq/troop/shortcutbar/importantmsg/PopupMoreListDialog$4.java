package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.troop.adapter.QuickRecyclerAdapter.OnItemClickListener;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;

class PopupMoreListDialog$4
  implements QuickRecyclerAdapter.OnItemClickListener
{
  PopupMoreListDialog$4(PopupMoreListDialog paramPopupMoreListDialog) {}
  
  public void a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramView != null)
    {
      if (paramViewHolder == null) {
        return;
      }
      if ((paramView.getTag() instanceof ShortcutBarInfo))
      {
        PopupMoreListDialog.e(this.a).onClick(paramView);
        PopupMoreListDialog.b(this.a).a(paramView, 1);
      }
    }
  }
  
  public boolean b(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.PopupMoreListDialog.4
 * JD-Core Version:    0.7.0.1
 */