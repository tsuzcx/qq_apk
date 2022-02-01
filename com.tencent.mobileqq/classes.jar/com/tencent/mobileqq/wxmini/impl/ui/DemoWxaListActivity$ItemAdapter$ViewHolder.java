package com.tencent.mobileqq.wxmini.impl.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wxmini/impl/ui/DemoWxaListActivity$ItemAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "wxmini_impl_release"}, k=1, mv={1, 1, 16})
public final class DemoWxaListActivity$ItemAdapter$ViewHolder
  extends RecyclerView.ViewHolder
{
  @NotNull
  private ImageView a;
  @NotNull
  private final TextView b;
  
  public DemoWxaListActivity$ItemAdapter$ViewHolder(@NotNull View paramView)
  {
    super(paramView);
    View localView = paramView.findViewById(1862402054);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.icon)");
    this.a = ((ImageView)localView);
    paramView = paramView.findViewById(1862402055);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.title)");
    this.b = ((TextView)paramView);
  }
  
  @NotNull
  public final ImageView a()
  {
    return this.a;
  }
  
  @NotNull
  public final TextView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.DemoWxaListActivity.ItemAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */