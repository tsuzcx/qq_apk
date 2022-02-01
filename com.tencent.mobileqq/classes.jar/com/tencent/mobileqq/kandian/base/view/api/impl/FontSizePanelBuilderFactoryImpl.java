package com.tencent.mobileqq.kandian.base.view.api.impl;

import android.view.LayoutInflater;
import com.tencent.mobileqq.kandian.base.view.api.IFontSizePanelBuilder;
import com.tencent.mobileqq.kandian.base.view.api.IFontSizePanelBuilderFactory;
import com.tencent.mobileqq.kandian.base.view.widget.FontSizePanel.Builder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/view/api/impl/FontSizePanelBuilderFactoryImpl;", "Lcom/tencent/mobileqq/kandian/base/view/api/IFontSizePanelBuilderFactory;", "()V", "createFontSizePanelBuilder", "Lcom/tencent/mobileqq/kandian/base/view/api/IFontSizePanelBuilder;", "inflater", "Landroid/view/LayoutInflater;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FontSizePanelBuilderFactoryImpl
  implements IFontSizePanelBuilderFactory
{
  @NotNull
  public IFontSizePanelBuilder createFontSizePanelBuilder(@Nullable LayoutInflater paramLayoutInflater)
  {
    return (IFontSizePanelBuilder)new FontSizePanel.Builder(paramLayoutInflater);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.api.impl.FontSizePanelBuilderFactoryImpl
 * JD-Core Version:    0.7.0.1
 */