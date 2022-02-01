package com.tencent.mobileqq.kandian.biz.pts;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/IProteusItemView;", "", "addContainer", "", "container", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "clearChilds", "getContainer", "getModel", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/IReadInJoyModel;", "getProteusItemView", "Landroid/view/View;", "getTemplateBean", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;", "setInternalTag", "tag", "key", "", "setModel", "model", "onLastReadRefreshListener", "Lcom/tencent/mobileqq/kandian/biz/pts/OnLastReadRefreshListener;", "setTemplateBean", "newTemplateBean", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IProteusItemView
{
  @NotNull
  public abstract View a();
  
  @Nullable
  public abstract TemplateBean a();
  
  @Nullable
  public abstract Container a();
  
  @Nullable
  public abstract IReadInJoyModel a();
  
  public abstract void a(@Nullable Container paramContainer);
  
  public abstract void c();
  
  public abstract void setInternalTag(int paramInt, @NotNull Object paramObject);
  
  public abstract void setInternalTag(@NotNull Object paramObject);
  
  public abstract void setModel(@Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable OnLastReadRefreshListener paramOnLastReadRefreshListener);
  
  public abstract void setTemplateBean(@Nullable TemplateBean paramTemplateBean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.IProteusItemView
 * JD-Core Version:    0.7.0.1
 */