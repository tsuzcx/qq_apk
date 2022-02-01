package com.tencent.mobileqq.kandian.biz.ugc.databinding;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/databinding/ReadInJoyTopicListAdapter$TopicViewHolder;", "", "layout", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "discussView", "Landroid/widget/TextView;", "getDiscussView", "()Landroid/widget/TextView;", "nameView", "getNameView", "readingStrView", "getReadingStrView", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyTopicListAdapter$TopicViewHolder
{
  @NotNull
  private final TextView a;
  @NotNull
  private final TextView b;
  @NotNull
  private final TextView c;
  
  public ReadInJoyTopicListAdapter$TopicViewHolder(@NotNull ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(2131447284);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(com.….id.textview_topic_title)");
    this.a = ((TextView)localView);
    localView = paramViewGroup.findViewById(2131448341);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(com.…leqq.R.id.tv_comment_num)");
    this.b = ((TextView)localView);
    paramViewGroup = paramViewGroup.findViewById(2131448687);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "layout.findViewById(com.…obileqq.R.id.tv_read_num)");
    this.c = ((TextView)paramViewGroup);
  }
  
  @NotNull
  public final TextView a()
  {
    return this.a;
  }
  
  @NotNull
  public final TextView b()
  {
    return this.b;
  }
  
  @NotNull
  public final TextView c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.databinding.ReadInJoyTopicListAdapter.TopicViewHolder
 * JD-Core Version:    0.7.0.1
 */