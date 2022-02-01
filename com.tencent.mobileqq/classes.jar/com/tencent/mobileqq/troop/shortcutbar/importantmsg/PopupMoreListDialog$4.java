package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.QuickRecyclerAdapter.OnItemClickListener;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;

class PopupMoreListDialog$4
  implements QuickRecyclerAdapter.OnItemClickListener
{
  PopupMoreListDialog$4(PopupMoreListDialog paramPopupMoreListDialog) {}
  
  public void a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramView == null) || (paramViewHolder == null)) {}
    while (!(paramView.getTag() instanceof ShortcutBarInfo)) {
      return;
    }
    PopupMoreListDialog.a(this.a).onClick(paramView);
    PopupMoreListDialog.a(this.a).a(paramView, 1);
  }
  
  public boolean a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.PopupMoreListDialog.4
 * JD-Core Version:    0.7.0.1
 */