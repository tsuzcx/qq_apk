package com.tencent.tkd.topicsdk.selectowner;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.list.CommonListAdapter.BaseListViewHolder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/selectowner/SelectTopicView$MyTopicViewHolder;", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter$BaseListViewHolder;", "titleText", "Landroid/widget/TextView;", "introView", "coverImageView", "Landroid/widget/ImageView;", "checkView", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/ImageView;Landroid/widget/ImageView;)V", "getCheckView", "()Landroid/widget/ImageView;", "getCoverImageView", "getIntroView", "()Landroid/widget/TextView;", "getTitleText", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SelectTopicView$MyTopicViewHolder
  extends CommonListAdapter.BaseListViewHolder
{
  @NotNull
  private final TextView a;
  @NotNull
  private final TextView b;
  @NotNull
  private final ImageView c;
  @NotNull
  private final ImageView d;
  
  public SelectTopicView$MyTopicViewHolder(@NotNull TextView paramTextView1, @NotNull TextView paramTextView2, @NotNull ImageView paramImageView1, @NotNull ImageView paramImageView2)
  {
    this.a = paramTextView1;
    this.b = paramTextView2;
    this.c = paramImageView1;
    this.d = paramImageView2;
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
  public final ImageView c()
  {
    return this.c;
  }
  
  @NotNull
  public final ImageView d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selectowner.SelectTopicView.MyTopicViewHolder
 * JD-Core Version:    0.7.0.1
 */