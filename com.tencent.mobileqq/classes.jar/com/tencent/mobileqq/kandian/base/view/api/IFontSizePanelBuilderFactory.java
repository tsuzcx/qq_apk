package com.tencent.mobileqq.kandian.base.view.api;

import android.view.LayoutInflater;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/view/api/IFontSizePanelBuilderFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createFontSizePanelBuilder", "Lcom/tencent/mobileqq/kandian/base/view/api/IFontSizePanelBuilder;", "inflater", "Landroid/view/LayoutInflater;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IFontSizePanelBuilderFactory
  extends QRouteApi
{
  @NotNull
  public abstract IFontSizePanelBuilder createFontSizePanelBuilder(@Nullable LayoutInflater paramLayoutInflater);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.api.IFontSizePanelBuilderFactory
 * JD-Core Version:    0.7.0.1
 */