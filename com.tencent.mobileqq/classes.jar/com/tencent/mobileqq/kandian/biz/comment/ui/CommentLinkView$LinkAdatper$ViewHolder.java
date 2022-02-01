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
  private final NativeReadInjoyImageView b;
  @NotNull
  private final TextView c;
  @NotNull
  private final View d;
  
  public CommentLinkView$LinkAdatper$ViewHolder(View paramView)
  {
    paramView = localObject.findViewById(2131435219);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "root.findViewById(R.id.icon)");
    this.b = ((NativeReadInjoyImageView)paramView);
    paramView = localObject.findViewById(2131431757);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "root.findViewById(R.id.description)");
    this.c = ((TextView)paramView);
    paramView = localObject.findViewById(2131431708);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "root.findViewById(R.id.delete)");
    this.d = paramView;
  }
  
  @NotNull
  public final NativeReadInjoyImageView a()
  {
    return this.b;
  }
  
  @NotNull
  public final TextView b()
  {
    return this.c;
  }
  
  @NotNull
  public final View c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentLinkView.LinkAdatper.ViewHolder
 * JD-Core Version:    0.7.0.1
 */