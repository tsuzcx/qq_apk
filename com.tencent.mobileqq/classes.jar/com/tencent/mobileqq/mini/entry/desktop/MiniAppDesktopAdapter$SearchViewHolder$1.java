package com.tencent.mobileqq.mini.entry.desktop;

import ajya;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class MiniAppDesktopAdapter$SearchViewHolder$1
  implements View.OnClickListener
{
  MiniAppDesktopAdapter$SearchViewHolder$1(MiniAppDesktopAdapter.SearchViewHolder paramSearchViewHolder, WeakReference paramWeakReference) {}
  
  public void onClick(View paramView)
  {
    if ((MiniAppDesktopAdapter.SearchViewHolder.access$2800(this.this$0) == null) || (MiniAppDesktopAdapter.SearchViewHolder.access$2800(this.this$0).mAppInfo == null)) {
      QLog.e("MiniAppDesktopAdapter", 1, "click search bar searchInfo is null");
    }
    paramView = new LaunchParam();
    paramView.scene = 3006;
    try
    {
      MiniAppController.launchMiniAppByAppInfo((Activity)this.val$activity.get(), MiniAppDesktopAdapter.SearchViewHolder.access$2800(this.this$0).mAppInfo, paramView);
      paramView = ajya.a(2131706804);
      if (MiniAppDesktopAdapter.SearchViewHolder.access$2900(this.this$0).getText() != null) {
        paramView = MiniAppDesktopAdapter.SearchViewHolder.access$2900(this.this$0).getText().toString();
      }
      MiniProgramLpReportDC04239.reportAsync("desktop", "search", "click_search", paramView);
      return;
    }
    catch (Exception paramView)
    {
      QLog.e("MiniAppDesktopAdapter", 1, "click search bar exception: " + Log.getStackTraceString(paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.SearchViewHolder.1
 * JD-Core Version:    0.7.0.1
 */