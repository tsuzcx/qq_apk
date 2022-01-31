package com.tencent.mobileqq.mini.entry.desktop;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import bbkx;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDittoInfo;
import com.tencent.mobileqq.mini.entry.desktop.widget.DesktopDittoAreaView;

class MiniAppDesktopAdapter$DittoViewHolder
  extends RecyclerView.ViewHolder
{
  public MiniAppDesktopAdapter$DittoViewHolder(View paramView)
  {
    super(paramView);
  }
  
  public void bindView(DesktopDittoInfo paramDesktopDittoInfo)
  {
    String str = paramDesktopDittoInfo.dittoDls;
    if ((!TextUtils.isEmpty(str)) && ((this.itemView instanceof DesktopDittoAreaView)))
    {
      DesktopDittoAreaView localDesktopDittoAreaView = (DesktopDittoAreaView)this.itemView;
      localDesktopDittoAreaView.setContentAreaForJsonFile(str, true);
      localDesktopDittoAreaView.setDittoData(paramDesktopDittoInfo);
      this.itemView.setPadding(0, bbkx.b(20.0F), 0, 0);
      localDesktopDittoAreaView.handleExposureReport();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.DittoViewHolder
 * JD-Core Version:    0.7.0.1
 */