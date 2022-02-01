package com.tencent.tkd.weibo.tweetTopic;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tkd.weibo.component.R.id;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/TopicListAdapter$TopicViewHolder;", "", "layout", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "discussView", "Landroid/widget/TextView;", "getDiscussView", "()Landroid/widget/TextView;", "dividerView", "Landroid/view/View;", "getDividerView", "()Landroid/view/View;", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "setIconView", "(Landroid/widget/ImageView;)V", "nameView", "getNameView", "operationView", "getOperationView", "readingStrView", "getReadingStrView", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class TopicListAdapter$TopicViewHolder
{
  @NotNull
  private ImageView a;
  @NotNull
  private final TextView b;
  @NotNull
  private final TextView c;
  @NotNull
  private final View d;
  @NotNull
  private final TextView e;
  @NotNull
  private final TextView f;
  
  public TopicListAdapter$TopicViewHolder(@NotNull ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(R.id.c);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.iv_icon)");
    this.a = ((ImageView)localView);
    localView = paramViewGroup.findViewById(R.id.m);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.tv_title)");
    this.b = ((TextView)localView);
    localView = paramViewGroup.findViewById(R.id.i);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.tv_discuss)");
    this.c = ((TextView)localView);
    localView = paramViewGroup.findViewById(R.id.n);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.view_divider)");
    this.d = localView;
    localView = paramViewGroup.findViewById(R.id.k);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.tv_operation)");
    this.e = ((TextView)localView);
    paramViewGroup = paramViewGroup.findViewById(R.id.l);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "layout.findViewById(R.id.tv_read)");
    this.f = ((TextView)paramViewGroup);
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
  
  @NotNull
  public final TextView c()
  {
    return this.c;
  }
  
  @NotNull
  public final View d()
  {
    return this.d;
  }
  
  @NotNull
  public final TextView e()
  {
    return this.e;
  }
  
  @NotNull
  public final TextView f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TopicListAdapter.TopicViewHolder
 * JD-Core Version:    0.7.0.1
 */