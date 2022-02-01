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
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (PopupMoreListDialog.a(this.a) == null) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 1))
    {
      paramRecyclerView = PopupMoreListDialog.a(this.a).getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager))
      {
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
        int m = paramRecyclerView.findFirstVisibleItemPosition();
        int k = paramRecyclerView.findLastVisibleItemPosition();
        int j = 0;
        int i = j;
        paramInt = k;
        if (k == 0) {
          if (PopupMoreListDialog.a(this.a) != null)
          {
            k = PopupMoreListDialog.a(this.a).size();
            i = j;
            paramInt = k;
            if (k > 6)
            {
              paramInt = 6;
              i = j;
            }
          }
          else
          {
            paramInt = 0;
            i = j;
          }
        }
        while (i < paramInt - m)
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
        }
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.PopupMoreListDialog.2
 * JD-Core Version:    0.7.0.1
 */