package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyWebDataManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/ReadInJoyWebDataManagerImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IReadInJoyWebDataManager;", "()V", "addLog", "", "content", "", "getCSRFToken", "skey", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyWebDataManagerImpl
  implements IReadInJoyWebDataManager
{
  public void addLog(@Nullable String paramString)
  {
    ReadInJoyWebDataManager.b(paramString);
  }
  
  @Nullable
  public String getCSRFToken(@Nullable String paramString)
  {
    return ReadInJoyWebDataManager.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.ReadInJoyWebDataManagerImpl
 * JD-Core Version:    0.7.0.1
 */