package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/ui/CommentLinkView$LinkAdatper$ViewHolder;", "", "root", "Landroid/view/View;", "(Lcom/tencent/mobileqq/kandian/biz/comment/ui/CommentLinkView$LinkAdatper;Landroid/view/View;)V", "vDelete", "getVDelete", "()Landroid/view/View;", "vDescription", "Landroid/widget/TextView;", "getVDescription", "()Landroid/widget/TextView;", "vIcon", "Lcom/tencent/mobileqq/kandian/biz/common/widget/NativeReadInjoyImageView;", "getVIcon", "()Lcom/tencent/mobileqq/kandian/biz/common/widget/NativeReadInjoyImageView;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
final class CommentLinkView$LinkAdatper$ViewHolder
{
  @NotNull
  private final View jdField_a_of_type_AndroidViewView;
  @NotNull
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private final NativeReadInjoyImageView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView;
  
  public CommentLinkView$LinkAdatper$ViewHolder(View paramView)
  {
    paramView = localObject.findViewById(2131368343);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "root.findViewById(R.id.icon)");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView = ((NativeReadInjoyImageView)paramView);
    paramView = localObject.findViewById(2131365536);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "root.findViewById(R.id.description)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView);
    paramView = localObject.findViewById(2131365494);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "root.findViewById(R.id.delete)");
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  @NotNull
  public final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  @NotNull
  public final NativeReadInjoyImageView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentLinkView.LinkAdatper.ViewHolder
 * JD-Core Version:    0.7.0.1
 */