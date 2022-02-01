package com.tencent.tkd.topicsdk.mvp;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "BEAN", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class BaseListView$1
  implements View.OnClickListener
{
  BaseListView$1(BaseListView paramBaseListView) {}
  
  public final void onClick(View paramView)
  {
    ListContract.IListPresenter.DefaultImpls.a(BaseListView.b(this.a), null, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mvp.BaseListView.1
 * JD-Core Version:    0.7.0.1
 */