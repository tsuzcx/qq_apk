package com.tencent.tkd.topicsdk.mediaselector;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/MediaPresenter;", "Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IPresenter;", "model", "Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IModel;", "(Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IModel;)V", "view", "Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IView;", "attachView", "", "detachView", "loadMedias", "panelType", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "callback", "Lkotlin/Function1;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class MediaPresenter
  implements IMediaContract.IPresenter
{
  private final IMediaContract.IModel jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorIMediaContract$IModel;
  private IMediaContract.IView jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorIMediaContract$IView;
  
  public MediaPresenter(@NotNull IMediaContract.IModel paramIModel)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorIMediaContract$IModel = paramIModel;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorIMediaContract$IView = ((IMediaContract.IView)null);
  }
  
  public void a(@NotNull IMediaContract.IView paramIView)
  {
    Intrinsics.checkParameterIsNotNull(paramIView, "view");
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorIMediaContract$IView = paramIView;
  }
  
  public void a(@NotNull PanelType paramPanelType, @Nullable Function1<? super PanelType, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelType, "panelType");
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorIMediaContract$IModel.a(paramPanelType, (Function2)new MediaPresenter.loadMedias.1(this, paramFunction1, paramPanelType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaPresenter
 * JD-Core Version:    0.7.0.1
 */