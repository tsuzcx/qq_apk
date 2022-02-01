package com.tencent.mobileqq.wxmini.impl.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class WxMiniDemoActivity$onCreate$4
  implements View.OnClickListener
{
  WxMiniDemoActivity$onCreate$4(WxMiniDemoActivity paramWxMiniDemoActivity) {}
  
  public final void onClick(View paramView)
  {
    WxMiniSDKImpl.a.c().launchByQRRawData((Context)this.a, "https://mp.weixin.qq.com/a/wDqchLjEQuQ8rfzn92-S?v=2", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.WxMiniDemoActivity.onCreate.4
 * JD-Core Version:    0.7.0.1
 */