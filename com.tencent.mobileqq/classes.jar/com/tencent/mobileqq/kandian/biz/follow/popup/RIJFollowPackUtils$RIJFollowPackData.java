package com.tencent.mobileqq.kandian.biz.follow.popup;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/follow/popup/RIJFollowPackUtils$RIJFollowPackData;", "", "templateBean", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;", "container", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)V", "getArticleInfo", "()Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "getContainer", "()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "getTemplateBean", "()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFollowPackUtils$RIJFollowPackData
{
  @NotNull
  private final TemplateBean a;
  @NotNull
  private final ViewBase b;
  @NotNull
  private final AbsBaseArticleInfo c;
  
  public RIJFollowPackUtils$RIJFollowPackData(@NotNull TemplateBean paramTemplateBean, @NotNull ViewBase paramViewBase, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.a = paramTemplateBean;
    this.b = paramViewBase;
    this.c = paramAbsBaseArticleInfo;
  }
  
  @NotNull
  public final TemplateBean a()
  {
    return this.a;
  }
  
  @NotNull
  public final ViewBase b()
  {
    return this.b;
  }
  
  @NotNull
  public final AbsBaseArticleInfo c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RIJFollowPackData))
      {
        paramObject = (RIJFollowPackData)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.c;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJFollowPackData(templateBean=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", container=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", articleInfo=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.popup.RIJFollowPackUtils.RIJFollowPackData
 * JD-Core Version:    0.7.0.1
 */