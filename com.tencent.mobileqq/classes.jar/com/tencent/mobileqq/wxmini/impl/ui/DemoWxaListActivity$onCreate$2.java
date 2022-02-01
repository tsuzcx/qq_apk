package com.tencent.mobileqq.wxmini.impl.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class DemoWxaListActivity$onCreate$2
  implements View.OnClickListener
{
  DemoWxaListActivity$onCreate$2(DemoWxaListActivity paramDemoWxaListActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = DemoWxaListActivity.b(this.a).getText().toString();
    int i;
    if (((CharSequence)paramView).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    DemoWxaListActivity.a(this.a, paramView, 0, null, 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.DemoWxaListActivity.onCreate.2
 * JD-Core Version:    0.7.0.1
 */