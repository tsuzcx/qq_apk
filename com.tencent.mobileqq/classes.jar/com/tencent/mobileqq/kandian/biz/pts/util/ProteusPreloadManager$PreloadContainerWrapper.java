package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.qqstory.utils.UIUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/util/ProteusPreloadManager$PreloadContainerWrapper;", "", "container", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;)V", "getContainer", "()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "setContainer", "screenWidth", "", "getScreenWidth", "()Ljava/lang/Number;", "setScreenWidth", "(Ljava/lang/Number;)V", "isSuitableSize", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ProteusPreloadManager$PreloadContainerWrapper
{
  @NotNull
  private Number a;
  @NotNull
  private Container b;
  
  public ProteusPreloadManager$PreloadContainerWrapper(@NotNull Container paramContainer)
  {
    this.b = paramContainer;
    this.a = ((Number)Integer.valueOf(UIUtils.c(this.b.getContext())));
  }
  
  @NotNull
  public final Number a()
  {
    return this.a;
  }
  
  public final boolean b()
  {
    int i = UIUtils.c(this.b.getContext());
    Number localNumber = this.a;
    return ((localNumber instanceof Integer)) && (i == ((Integer)localNumber).intValue());
  }
  
  @NotNull
  public final Container c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.ProteusPreloadManager.PreloadContainerWrapper
 * JD-Core Version:    0.7.0.1
 */