package com.tencent.tkd.weibo.tweetTopic;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tkd.weibo.component.R.id;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/TopicListAdapter$TopicViewHolder;", "", "layout", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "descView", "Landroid/widget/TextView;", "getDescView", "()Landroid/widget/TextView;", "setDescView", "(Landroid/widget/TextView;)V", "dividerView", "Landroid/view/View;", "getDividerView", "()Landroid/view/View;", "setDividerView", "(Landroid/view/View;)V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "setIconView", "(Landroid/widget/ImageView;)V", "nameView", "getNameView", "setNameView", "operationView", "getOperationView", "setOperationView", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class TopicListAdapter$TopicViewHolder
{
  @NotNull
  private View jdField_a_of_type_AndroidViewView;
  @NotNull
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  @NotNull
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private TextView b;
  @NotNull
  private TextView c;
  
  public TopicListAdapter$TopicViewHolder(@NotNull ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.iv_icon)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramViewGroup.findViewById(R.id.q);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.tv_title)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView);
    localView = paramViewGroup.findViewById(R.id.m);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.tv_desc)");
    this.b = ((TextView)localView);
    localView = paramViewGroup.findViewById(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.view_divider)");
    this.jdField_a_of_type_AndroidViewView = localView;
    paramViewGroup = paramViewGroup.findViewById(R.id.p);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "layout.findViewById(R.id.tv_operation)");
    this.c = ((TextView)paramViewGroup);
  }
  
  @NotNull
  public final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @NotNull
  public final ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TopicListAdapter.TopicViewHolder
 * JD-Core Version:    0.7.0.1
 */