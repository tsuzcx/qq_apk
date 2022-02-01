package com.tencent.mobileqq.kandian.biz.config.api.impl;

import com.tencent.mobileqq.kandian.biz.config.api.IReadInJoyConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.MultiVideoConfigHandler;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/config/api/impl/ReadInJoyConfigImpl;", "Lcom/tencent/mobileqq/kandian/biz/config/api/IReadInJoyConfig;", "()V", "isEnterMultiMode", "", "videoFrom", "", "videoWidth", "videoHeight", "duration", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyConfigImpl
  implements IReadInJoyConfig
{
  public boolean isEnterMultiMode(int paramInt)
  {
    return MultiVideoConfigHandler.a(paramInt);
  }
  
  public boolean isEnterMultiMode(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return MultiVideoConfigHandler.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.config.api.impl.ReadInJoyConfigImpl
 * JD-Core Version:    0.7.0.1
 */