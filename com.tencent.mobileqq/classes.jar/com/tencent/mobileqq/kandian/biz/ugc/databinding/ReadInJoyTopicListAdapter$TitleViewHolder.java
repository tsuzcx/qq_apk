package com.tencent.mobileqq.kandian.biz.ugc.databinding;

import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/databinding/ReadInJoyTopicListAdapter$TitleViewHolder;", "", "layout", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyTopicListAdapter$TitleViewHolder
{
  @NotNull
  private final TextView a;
  
  public ReadInJoyTopicListAdapter$TitleViewHolder(@NotNull ViewGroup paramViewGroup)
  {
    paramViewGroup = paramViewGroup.findViewById(2097545468);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "layout.findViewById(R.id.tv_title)");
    this.a = ((TextView)paramViewGroup);
  }
  
  @NotNull
  public final TextView a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.databinding.ReadInJoyTopicListAdapter.TitleViewHolder
 * JD-Core Version:    0.7.0.1
 */