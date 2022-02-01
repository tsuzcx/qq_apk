package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/ui/CommentLinkView$LinkAdatper;", "Landroid/widget/BaseAdapter;", "Landroid/view/View$OnClickListener;", "(Lcom/tencent/mobileqq/kandian/biz/comment/ui/CommentLinkView;)V", "getCount", "", "getItem", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData$CommentLinkData;", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "onClick", "", "v", "ViewHolder", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CommentLinkView$LinkAdatper
  extends BaseAdapter
  implements View.OnClickListener
{
  @NotNull
  public BaseCommentData.CommentLinkData a(int paramInt)
  {
    return (BaseCommentData.CommentLinkData)CommentLinkView.a(this.a).get(paramInt);
  }
  
  public int getCount()
  {
    return CommentLinkView.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @NotNull
  public View getView(int paramInt, @Nullable View paramView, @NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    int i = 0;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131626161, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "contentView");
      paramViewGroup = new CommentLinkView.LinkAdatper.ViewHolder(this, paramView);
      paramViewGroup.c().setOnClickListener((View.OnClickListener)this);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = paramView.getTag();
      if (paramViewGroup == null) {
        break label240;
      }
      paramViewGroup = (CommentLinkView.LinkAdatper.ViewHolder)paramViewGroup;
    }
    BaseCommentData.CommentLinkData localCommentLinkData = a(paramInt);
    paramViewGroup.c().setTag(localCommentLinkData);
    paramViewGroup.b().setText((CharSequence)localCommentLinkData.wording);
    String str = localCommentLinkData.iconUrl;
    if (str != null)
    {
      paramInt = i;
      if (((CharSequence)str).length() == 0) {
        paramInt = 1;
      }
      if (paramInt == 0)
      {
        paramViewGroup.a().setImageSrc(str);
        return paramView;
      }
    }
    int j = localCommentLinkData.type;
    i = 2130843872;
    paramInt = i;
    if (j != 1) {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j != 5) {
              paramInt = i;
            } else {
              paramInt = 2097479705;
            }
          }
          else {
            paramInt = 2130843873;
          }
        }
        else {
          paramInt = 2130843870;
        }
      }
      else {
        paramInt = 2130843869;
      }
    }
    paramViewGroup.a().setImageResource(paramInt);
    return paramView;
    label240:
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.comment.ui.CommentLinkView.LinkAdatper.ViewHolder");
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    paramView = paramView.getTag();
    if (paramView != null)
    {
      paramView = (BaseCommentData.CommentLinkData)paramView;
      CommentLinkView.a(this.a).remove(paramView);
      notifyDataSetChanged();
      paramView = this.a.getOnLinkEmptyListener();
      if (paramView != null) {
        paramView.c();
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentLinkView.LinkAdatper
 * JD-Core Version:    0.7.0.1
 */