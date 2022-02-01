package com.tencent.mobileqq.mini.entry.desktop;

import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import java.util.ArrayList;
import java.util.List;

class MiniAppDesktopAdapter$2
  extends RecyclerView.AdapterDataObserver
{
  MiniAppDesktopAdapter$2(MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      if ((MiniAppDesktopAdapter.access$2200(this.this$0).get(i) instanceof DesktopAppInfo)) {
        localArrayList.add((DesktopAppInfo)MiniAppDesktopAdapter.access$2300(this.this$0).get(i));
      }
      i += 1;
    }
    ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).onItemInserted(paramInt1, localArrayList);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).onItemMoved(paramInt1, paramInt2, paramInt3);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).onItemDeleted(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.2
 * JD-Core Version:    0.7.0.1
 */