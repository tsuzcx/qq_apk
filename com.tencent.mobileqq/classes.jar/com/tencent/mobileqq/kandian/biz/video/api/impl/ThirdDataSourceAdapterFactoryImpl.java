package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.image.AbsThirdDataSourceAdapter;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdDataSourceAdapter;
import com.tencent.mobileqq.kandian.biz.video.api.IThirdDataSourceAdapterFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/ThirdDataSourceAdapterFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IThirdDataSourceAdapterFactory;", "()V", "create", "Lcom/tencent/image/AbsThirdDataSourceAdapter;", "type", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ThirdDataSourceAdapterFactoryImpl
  implements IThirdDataSourceAdapterFactory
{
  @NotNull
  public AbsThirdDataSourceAdapter create(int paramInt)
  {
    return (AbsThirdDataSourceAdapter)new ThirdDataSourceAdapter(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.ThirdDataSourceAdapterFactoryImpl
 * JD-Core Version:    0.7.0.1
 */