package com.tencent.mobileqq.mini.ui;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class FileMaterialAppListAdapter$doOnBindViewHolder$2
  implements View.OnClickListener
{
  FileMaterialAppListAdapter$doOnBindViewHolder$2(FileMaterialAppListAdapter paramFileMaterialAppListAdapter, FileMaterialAppListAdapter.ItemViewHolder paramItemViewHolder) {}
  
  public final void onClick(View paramView)
  {
    paramView = FileMaterialAppListAdapter.access$getMItemClickListener$p(this.this$0);
    if (paramView != null) {
      paramView.onItemClicked(this.$holder.getData());
    }
    FileMaterialAppListAdapter.access$reportItemClickedOrExposed(this.this$0, this.$holder.getData(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.FileMaterialAppListAdapter.doOnBindViewHolder.2
 * JD-Core Version:    0.7.0.1
 */