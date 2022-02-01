package com.tencent.tkd.topicsdk.kdcommunity;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityPresenter;", "Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityContract$IPresenter;", "model", "Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityContract$IModel;", "(Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityContract$IModel;)V", "getModel", "()Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityContract$IModel;", "view", "Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityContract$IView;", "attachView", "", "detachView", "refreshCommunityList", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class KDCommunityPresenter
  implements KDCommunityContract.IPresenter
{
  private KDCommunityContract.IView a;
  @NotNull
  private final KDCommunityContract.IModel b;
  
  public KDCommunityPresenter(@NotNull KDCommunityContract.IModel paramIModel)
  {
    this.b = paramIModel;
  }
  
  public void a()
  {
    this.a = ((KDCommunityContract.IView)null);
  }
  
  public void a(@NotNull KDCommunityContract.IView paramIView)
  {
    Intrinsics.checkParameterIsNotNull(paramIView, "view");
    this.a = paramIView;
  }
  
  public void b()
  {
    KDCommunityContract.IView localIView = this.a;
    if (localIView != null)
    {
      localIView.e();
      localIView.a();
      this.b.a((Function3)new KDCommunityPresenter.refreshCommunityList.1.1(localIView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.kdcommunity.KDCommunityPresenter
 * JD-Core Version:    0.7.0.1
 */