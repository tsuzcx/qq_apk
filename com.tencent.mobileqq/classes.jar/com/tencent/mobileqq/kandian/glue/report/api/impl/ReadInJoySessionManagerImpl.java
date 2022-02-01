package com.tencent.mobileqq.kandian.glue.report.api.impl;

import com.tencent.mobileqq.kandian.glue.report.ReadInJoySessionManager;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoySessionManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/api/impl/ReadInJoySessionManagerImpl;", "Lcom/tencent/mobileqq/kandian/glue/report/api/IReadInJoySessionManager;", "()V", "getSceneSeriesNum", "", "getSceneTraceID", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoySessionManagerImpl
  implements IReadInJoySessionManager
{
  public int getSceneSeriesNum()
  {
    return ReadInJoySessionManager.a.b();
  }
  
  @Nullable
  public String getSceneTraceID()
  {
    return ReadInJoySessionManager.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.api.impl.ReadInJoySessionManagerImpl
 * JD-Core Version:    0.7.0.1
 */