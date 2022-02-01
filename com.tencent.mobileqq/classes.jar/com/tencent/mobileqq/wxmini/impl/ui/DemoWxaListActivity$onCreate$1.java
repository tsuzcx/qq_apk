package com.tencent.mobileqq.wxmini.impl.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class DemoWxaListActivity$onCreate$1
  implements View.OnClickListener
{
  DemoWxaListActivity$onCreate$1(DemoWxaListActivity paramDemoWxaListActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = DemoWxaListActivity.a(this.a).getText().toString();
    int i;
    if (((CharSequence)paramView).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    WxMiniSDKImpl.a.c().launchWxaApp((Context)this.a, paramView, 0, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.DemoWxaListActivity.onCreate.1
 * JD-Core Version:    0.7.0.1
 */