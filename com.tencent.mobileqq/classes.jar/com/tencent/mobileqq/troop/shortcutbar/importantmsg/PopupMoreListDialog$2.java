package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import java.util.ArrayList;

class PopupMoreListDialog$2
  extends RecyclerView.OnScrollListener
{
  PopupMoreListDialog$2(PopupMoreListDialog paramPopupMoreListDialog) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = 0;
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (PopupMoreListDialog.a(this.a) == null) {
      break label18;
    }
    for (;;)
    {
      label18:
      return;
      if ((paramInt == 0) || (paramInt == 1))
      {
        paramRecyclerView = PopupMoreListDialog.a(this.a).getLayoutManager();
        if (!(paramRecyclerView instanceof LinearLayoutManager)) {
          break;
        }
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
        int k = paramRecyclerView.findFirstVisibleItemPosition();
        paramInt = paramRecyclerView.findLastVisibleItemPosition();
        if (paramInt == 0) {
          if (PopupMoreListDialog.a(this.a) != null)
          {
            int j = PopupMoreListDialog.a(this.a).size();
            paramInt = j;
            if (j > 6) {
              paramInt = 6;
            }
          }
        }
        while (i < paramInt - k)
        {
          if (PopupMoreListDialog.a(this.a).getChildAt(i) != null)
          {
            paramRecyclerView = PopupMoreListDialog.a(this.a).getChildAt(i);
            if ((paramRecyclerView.getTag() != null) && ((paramRecyclerView.getTag() instanceof ShortcutBarInfo)))
            {
              paramRecyclerView = (ShortcutBarInfo)paramRecyclerView.getTag();
              PopupMoreListDialog.a(this.a).c(Long.valueOf(paramRecyclerView.a()), Long.valueOf(paramRecyclerView.b()));
            }
          }
          i += 1;
          continue;
          paramInt = 0;
        }
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.PopupMoreListDialog.2
 * JD-Core Version:    0.7.0.1
 */