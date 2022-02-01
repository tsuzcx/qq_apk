package com.tencent.mobileqq.wxmini.impl.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity;
import com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity.Companion;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mobileqq/wxmini/impl/ui/DemoWxaListActivity$ItemAdapter$onBindViewHolder$1$1$2", "com/tencent/mobileqq/wxmini/impl/ui/DemoWxaListActivity$ItemAdapter$$special$$inlined$apply$lambda$2"}, k=3, mv={1, 1, 16})
final class DemoWxaListActivity$ItemAdapter$onBindViewHolder$$inlined$let$lambda$2
  implements View.OnLongClickListener
{
  DemoWxaListActivity$ItemAdapter$onBindViewHolder$$inlined$let$lambda$2(DemoWxaListActivity.WxaInfo paramWxaInfo, DemoWxaListActivity.ItemAdapter paramItemAdapter, RecyclerView.ViewHolder paramViewHolder) {}
  
  public final boolean onLongClick(View paramView)
  {
    WxaProfileActivity.Companion.show(this.b.a(), this.a.a());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.DemoWxaListActivity.ItemAdapter.onBindViewHolder..inlined.let.lambda.2
 * JD-Core Version:    0.7.0.1
 */