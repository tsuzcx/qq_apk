package com.tencent.tkd.topicsdk.selecttopic;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.list.CommonListAdapter.BaseListViewHolder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/selecttopic/SelectTopicView$MyTopicViewHolder;", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter$BaseListViewHolder;", "titleText", "Landroid/widget/TextView;", "introView", "coverImageView", "Landroid/widget/ImageView;", "checkView", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/ImageView;Landroid/widget/ImageView;)V", "getCheckView", "()Landroid/widget/ImageView;", "getCoverImageView", "getIntroView", "()Landroid/widget/TextView;", "getTitleText", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SelectTopicView$MyTopicViewHolder
  extends CommonListAdapter.BaseListViewHolder
{
  @NotNull
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  @NotNull
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private final ImageView jdField_b_of_type_AndroidWidgetImageView;
  @NotNull
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public SelectTopicView$MyTopicViewHolder(@NotNull TextView paramTextView1, @NotNull TextView paramTextView2, @NotNull ImageView paramImageView1, @NotNull ImageView paramImageView2)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView1;
    this.jdField_b_of_type_AndroidWidgetTextView = paramTextView2;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView1;
    this.jdField_b_of_type_AndroidWidgetImageView = paramImageView2;
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
  public final ImageView b()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  @NotNull
  public final TextView b()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selecttopic.SelectTopicView.MyTopicViewHolder
 * JD-Core Version:    0.7.0.1
 */