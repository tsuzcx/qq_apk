package com.tencent.mobileqq.mini.entry.desktop;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbEntryBannerView;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSpringEntryInfo;
import com.tencent.qphone.base.util.QLog;

class MiniAppDesktopAdapter$SpringEntryViewHolder
  extends RecyclerView.ViewHolder
{
  private SpringHbEntryBannerView entryBannerView;
  
  public MiniAppDesktopAdapter$SpringEntryViewHolder(MiniAppDesktopAdapter paramMiniAppDesktopAdapter, View paramView)
  {
    super(paramView);
    try
    {
      this.entryBannerView = ((SpringHbEntryBannerView)paramView);
      this.entryBannerView.setOnClickListener(new MiniAppDesktopAdapter.SpringEntryViewHolder.1(this, paramMiniAppDesktopAdapter));
      return;
    }
    catch (Throwable paramMiniAppDesktopAdapter)
    {
      QLog.e("MiniAppDesktopAdapter", 1, paramMiniAppDesktopAdapter, new Object[0]);
    }
  }
  
  public void bindView(DesktopSpringEntryInfo paramDesktopSpringEntryInfo)
  {
    this.entryBannerView.setBannerBg(paramDesktopSpringEntryInfo.bannerInfo, this.this$0.isDesktopOpened);
    if (QLog.isColorLevel()) {
      QLog.i("springHb_MiniAppDesktopAdapter", 1, "SpringEntryViewHolder,bannerInfo:" + paramDesktopSpringEntryInfo.bannerInfo + ",isDesktopOpened:" + this.this$0.isDesktopOpened);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.SpringEntryViewHolder
 * JD-Core Version:    0.7.0.1
 */