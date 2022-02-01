package com.tencent.mobileqq.mini.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;
import java.lang.ref.WeakReference;

class MiniLoadingAdLayout$1
  implements View.OnClickListener
{
  MiniLoadingAdLayout$1(MiniLoadingAdLayout paramMiniLoadingAdLayout, boolean paramBoolean, AdProxy.ILoadingAdListener paramILoadingAdListener) {}
  
  public void onClick(View paramView)
  {
    QLog.i("MiniLoadingAdLayout", 1, "yuki LoadingAd reportClick");
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.c = 11;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)this.this$0.getContext());
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = MiniLoadingAdLayout.access$000(this.this$0);
    localParams.jdField_a_of_type_Boolean = true;
    localParams.b = MiniLoadingAdLayout.access$100(this.this$0);
    Bundle localBundle = new Bundle();
    localBundle.putString("big_brother_ref_source_key", "biz_src_miniappD");
    localParams.jdField_a_of_type_AndroidOsBundle = localBundle;
    GdtHandler.a(localParams);
    if (this.val$isSDK) {
      if (this.val$loadingAdListener != null) {
        this.val$loadingAdListener.onAdClick();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MiniProgramLpReportDC04239.reportMiniAppEvent(MiniLoadingAdLayout.access$200(this.this$0), MiniProgramLpReportDC04239.getAppType(MiniLoadingAdLayout.access$200(this.this$0)), null, "ad", "ad_loading", "click", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.1
 * JD-Core Version:    0.7.0.1
 */