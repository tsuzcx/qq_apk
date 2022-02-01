package com.tencent.mobileqq.mini.entry.desktop;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.activity.springfestival.HBEntryBannerData;
import com.tencent.mobileqq.activity.springfestival.HBEntryBannerView;
import java.lang.ref.WeakReference;

public class MiniAppDesktopAdapter$HBEntryViewHolder
  extends RecyclerView.ViewHolder
{
  private WeakReference<Activity> activityWeakReference;
  private HBEntryBannerView hbEntryHeadLayout;
  
  public MiniAppDesktopAdapter$HBEntryViewHolder(View paramView, WeakReference<Activity> paramWeakReference)
  {
    super(paramWeakReference);
    this.hbEntryHeadLayout = ((HBEntryBannerView)paramWeakReference);
    Object localObject;
    this.activityWeakReference = localObject;
  }
  
  public void bindView(HBEntryBannerData paramHBEntryBannerData)
  {
    HBEntryBannerView localHBEntryBannerView = this.hbEntryHeadLayout;
    if (localHBEntryBannerView != null) {
      localHBEntryBannerView.a(this.activityWeakReference, paramHBEntryBannerData, this.this$0.isDesktopOpened);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.HBEntryViewHolder
 * JD-Core Version:    0.7.0.1
 */