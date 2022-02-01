package com.tencent.tkd.topicsdk.mediaselector;

import com.tencent.tkd.topicsdk.mvp.BasePresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IPresenter;", "Lcom/tencent/tkd/topicsdk/mvp/BasePresenter;", "Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IView;", "loadMedias", "", "panelType", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "callback", "Lkotlin/Function1;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface IMediaContract$IPresenter
  extends BasePresenter<IMediaContract.IView>
{
  public abstract void a(@NotNull PanelType paramPanelType, @Nullable Function1<? super PanelType, Unit> paramFunction1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.IMediaContract.IPresenter
 * JD-Core Version:    0.7.0.1
 */