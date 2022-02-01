package com.tencent.mobileqq.mini.entry.desktop;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ditto.area.DittoArea;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDittoInfo;
import com.tencent.mobileqq.mini.entry.desktop.widget.DesktopDittoAreaView;
import com.tencent.mobileqq.utils.ViewUtils;

class MiniAppDesktopAdapter$DittoViewHolder
  extends RecyclerView.ViewHolder
  implements DesktopLifeCycleListener
{
  public MiniAppDesktopAdapter$DittoViewHolder(View paramView)
  {
    super(paramView);
  }
  
  private void clearDittoCache()
  {
    if ((this.itemView instanceof DesktopDittoAreaView)) {
      ((DesktopDittoAreaView)this.itemView).getCanvasArea().clearAllAreaCache();
    }
  }
  
  public void bindView(DesktopDittoInfo paramDesktopDittoInfo)
  {
    String str = paramDesktopDittoInfo.dittoDls;
    if ((!TextUtils.isEmpty(str)) && ((this.itemView instanceof DesktopDittoAreaView)))
    {
      DesktopDittoAreaView localDesktopDittoAreaView = (DesktopDittoAreaView)this.itemView;
      localDesktopDittoAreaView.setContentAreaForJsonFile(str, true);
      localDesktopDittoAreaView.setDittoData(paramDesktopDittoInfo);
      this.itemView.setPadding(0, ViewUtils.dpToPx(20.0F), 0, 0);
      localDesktopDittoAreaView.handleExposureReport();
    }
  }
  
  public void onAccountChanged()
  {
    clearDittoCache();
  }
  
  public void onDestroy()
  {
    clearDittoCache();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.DittoViewHolder
 * JD-Core Version:    0.7.0.1
 */