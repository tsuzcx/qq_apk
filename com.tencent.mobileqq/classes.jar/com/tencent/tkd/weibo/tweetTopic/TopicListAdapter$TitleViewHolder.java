package com.tencent.tkd.weibo.tweetTopic;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.tkd.weibo.component.R.id;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/TopicListAdapter$TitleViewHolder;", "", "layout", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class TopicListAdapter$TitleViewHolder
{
  @NotNull
  private final TextView a;
  
  public TopicListAdapter$TitleViewHolder(@NotNull ViewGroup paramViewGroup)
  {
    paramViewGroup = paramViewGroup.findViewById(R.id.m);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "layout.findViewById(R.id.tv_title)");
    this.a = ((TextView)paramViewGroup);
  }
  
  @NotNull
  public final TextView a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TopicListAdapter.TitleViewHolder
 * JD-Core Version:    0.7.0.1
 */