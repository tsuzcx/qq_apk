package com.tencent.mobileqq.wxmini.impl.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class WxMiniDemoActivity$onCreate$5
  implements View.OnClickListener
{
  WxMiniDemoActivity$onCreate$5(WxMiniDemoActivity paramWxMiniDemoActivity) {}
  
  public final void onClick(View paramView)
  {
    ((IWxMiniManager)QRoute.api(IWxMiniManager.class)).startWxMiniAppById((Context)this.a, "wxe5f52902cf4de896", "", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.WxMiniDemoActivity.onCreate.5
 * JD-Core Version:    0.7.0.1
 */