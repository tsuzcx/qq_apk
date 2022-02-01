package com.tencent.tkd.topicsdk.selectowner;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.topicsdk.mvp.ListContract.IListPresenter.DefaultImpls;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "BEAN", "HOLDER", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter$BaseListViewHolder;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class BaseSelectView$1
  implements View.OnClickListener
{
  BaseSelectView$1(BaseSelectView paramBaseSelectView) {}
  
  public final void onClick(View paramView)
  {
    ListContract.IListPresenter.DefaultImpls.a(BaseSelectView.b(this.a), null, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selectowner.BaseSelectView.1
 * JD-Core Version:    0.7.0.1
 */