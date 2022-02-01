package com.tencent.mobileqq.wxmini.impl.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxaapi.TdiAuthListener;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class WxMiniDemoActivity$onCreate$2
  implements View.OnClickListener
{
  WxMiniDemoActivity$onCreate$2(WxMiniDemoActivity paramWxMiniDemoActivity) {}
  
  public final void onClick(View paramView)
  {
    WxMiniSDKImpl.a.c().sendAuth((TdiAuthListener)new WxMiniDemoActivity.onCreate.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.WxMiniDemoActivity.onCreate.2
 * JD-Core Version:    0.7.0.1
 */