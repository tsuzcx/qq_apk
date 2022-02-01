package com.tencent.mobileqq.kandian.biz.viola.api.impl;

import com.tencent.mobileqq.kandian.biz.viola.api.IReadInJoyWebRenderSoLoader;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInjoyWebRenderSoLoader;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/impl/ReadInJoyWebRenderSoLoaderImpl;", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IReadInJoyWebRenderSoLoader;", "()V", "getSoLibPath", "", "unzip", "", "filepath", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyWebRenderSoLoaderImpl
  implements IReadInJoyWebRenderSoLoader
{
  @Nullable
  public String getSoLibPath()
  {
    return ReadInjoyWebRenderSoLoader.a();
  }
  
  public boolean unzip(@Nullable String paramString)
  {
    return ReadInjoyWebRenderSoLoader.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.impl.ReadInJoyWebRenderSoLoaderImpl
 * JD-Core Version:    0.7.0.1
 */