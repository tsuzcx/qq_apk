package com.tencent.mobileqq.wxmini.impl.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.wxmini.impl.loader.WxDFLoader;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class WxMiniDemoActivity$onCreate$1
  implements View.OnClickListener
{
  WxMiniDemoActivity$onCreate$1(WxMiniDemoActivity paramWxMiniDemoActivity) {}
  
  public final void onClick(View paramView)
  {
    if (WxDFLoader.a().b())
    {
      this.a.runOnUiThread((Runnable)new WxMiniDemoActivity.onCreate.1.1(this));
      return;
    }
    this.a.runOnUiThread((Runnable)new WxMiniDemoActivity.onCreate.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.WxMiniDemoActivity.onCreate.1
 * JD-Core Version:    0.7.0.1
 */