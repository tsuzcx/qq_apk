package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;
import com.tencent.widget.HeightAdaptableListView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/ui/CommentLinkView;", "Lcom/tencent/widget/HeightAdaptableListView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mobileqq/kandian/biz/comment/ui/CommentLinkView$LinkAdatper;", "linkDataList", "", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData$CommentLinkData;", "onLinkEmptyListener", "Lcom/tencent/mobileqq/kandian/biz/comment/ui/CommentLinkView$OnLinkDeleteListener;", "getOnLinkEmptyListener", "()Lcom/tencent/mobileqq/kandian/biz/comment/ui/CommentLinkView$OnLinkDeleteListener;", "setOnLinkEmptyListener", "(Lcom/tencent/mobileqq/kandian/biz/comment/ui/CommentLinkView$OnLinkDeleteListener;)V", "setData", "", "data", "LinkAdatper", "OnLinkDeleteListener", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CommentLinkView
  extends HeightAdaptableListView
{
  private List<BaseCommentData.CommentLinkData> a = (List)new ArrayList(0);
  private CommentLinkView.LinkAdatper b;
  @Nullable
  private CommentLinkView.OnLinkDeleteListener c;
  
  public CommentLinkView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public CommentLinkView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommentLinkView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHeightAdaptMode(2, 0);
  }
  
  @Nullable
  public final CommentLinkView.OnLinkDeleteListener getOnLinkEmptyListener()
  {
    return this.c;
  }
  
  public final void setData(@Nullable List<BaseCommentData.CommentLinkData> paramList)
  {
    if (paramList == null) {
      paramList = (List)new ArrayList(0);
    }
    this.a = paramList;
    paramList = this.b;
    if (paramList == null)
    {
      this.b = new CommentLinkView.LinkAdatper(this);
      setAdapter((ListAdapter)this.b);
      return;
    }
    if (paramList == null) {
      Intrinsics.throwNpe();
    }
    paramList.notifyDataSetChanged();
  }
  
  public final void setOnLinkEmptyListener(@Nullable CommentLinkView.OnLinkDeleteListener paramOnLinkDeleteListener)
  {
    this.c = paramOnLinkDeleteListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentLinkView
 * JD-Core Version:    0.7.0.1
 */