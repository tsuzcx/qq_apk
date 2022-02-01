package com.tencent.mobileqq.wxmini.impl.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/wxmini/impl/ui/DemoWxaListActivity$ItemAdapter$onBindViewHolder$1$1$1", "com/tencent/mobileqq/wxmini/impl/ui/DemoWxaListActivity$ItemAdapter$$special$$inlined$apply$lambda$1"}, k=3, mv={1, 1, 16})
final class DemoWxaListActivity$ItemAdapter$onBindViewHolder$$inlined$let$lambda$1
  implements View.OnClickListener
{
  DemoWxaListActivity$ItemAdapter$onBindViewHolder$$inlined$let$lambda$1(DemoWxaListActivity.WxaInfo paramWxaInfo, DemoWxaListActivity.ItemAdapter paramItemAdapter, RecyclerView.ViewHolder paramViewHolder) {}
  
  public final void onClick(View paramView)
  {
    WxMiniSDKImpl.a.c().launchWxaApp(this.b.a(), this.a.a(), this.a.d(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.DemoWxaListActivity.ItemAdapter.onBindViewHolder..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */