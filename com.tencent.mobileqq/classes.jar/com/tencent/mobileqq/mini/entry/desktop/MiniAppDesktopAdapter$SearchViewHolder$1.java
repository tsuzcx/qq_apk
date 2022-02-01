package com.tencent.mobileqq.mini.entry.desktop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.apkg.FirstPageInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;

class MiniAppDesktopAdapter$SearchViewHolder$1
  implements View.OnClickListener
{
  MiniAppDesktopAdapter$SearchViewHolder$1(MiniAppDesktopAdapter.SearchViewHolder paramSearchViewHolder, WeakReference paramWeakReference) {}
  
  public void onClick(View paramView)
  {
    int i;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "SearchUseNative", 1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject;
    if (i != 0)
    {
      paramView = new Intent();
      if ((MiniAppDesktopAdapter.SearchViewHolder.access$2900(this.this$0) != null) && (MiniAppDesktopAdapter.SearchViewHolder.access$2900(this.this$0).mAppInfo != null) && (MiniAppDesktopAdapter.SearchViewHolder.access$2900(this.this$0).mAppInfo.firstPage != null))
      {
        localObject = Uri.decode(MiniAppDesktopAdapter.SearchViewHolder.access$2900(this.this$0).mAppInfo.firstPage.pagePath);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramView.putExtra("recommend_word", Uri.parse((String)localObject).getQueryParameter("w"));
        }
      }
      PublicFragmentActivity.a((Context)this.val$activity.get(), paramView, ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMiniAppSearchFragmentClass());
    }
    else
    {
      if ((MiniAppDesktopAdapter.SearchViewHolder.access$2900(this.this$0) == null) || (MiniAppDesktopAdapter.SearchViewHolder.access$2900(this.this$0).mAppInfo == null)) {
        QLog.e("MiniAppDesktopAdapter", 1, "click search bar searchInfo is null");
      }
      try
      {
        MiniAppDesktopAdapter.startMiniApp((Activity)this.val$activity.get(), MiniAppDesktopAdapter.SearchViewHolder.access$2900(this.this$0).mAppInfo, 3006);
      }
      catch (Exception paramView)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click search bar exception: ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramView));
        QLog.e("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject).toString());
      }
    }
    paramView = HardCodeUtil.a(2131904677);
    if (MiniAppDesktopAdapter.SearchViewHolder.access$3000(this.this$0).getText() != null) {
      paramView = MiniAppDesktopAdapter.SearchViewHolder.access$3000(this.this$0).getText().toString();
    }
    MiniProgramLpReportDC04239.reportAsync("desktop", "search", "click_search", paramView);
    if ((MiniAppDesktopAdapter.SearchViewHolder.access$2900(this.this$0) != null) && (MiniAppDesktopAdapter.SearchViewHolder.access$2900(this.this$0).mAppInfo != null) && (MiniAppDesktopAdapter.SearchViewHolder.access$2900(this.this$0).mAppInfo.tianshuAdId > 0)) {
      MiniAppUtils.miniAppTianShuReport("tianshu.78", "tianshu.78", String.valueOf(MiniAppDesktopAdapter.SearchViewHolder.access$2900(this.this$0).mAppInfo.tianshuAdId), 102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.SearchViewHolder.1
 * JD-Core Version:    0.7.0.1
 */