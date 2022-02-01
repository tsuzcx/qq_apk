package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyResetUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyResetUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/ReadInJoyResetUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoyResetUtils;", "()V", "clearReadInJoyDatabase", "", "clearReadInJoyLocalFiles", "clearReadInJoySharedPreferences", "getLocalFilesPathForDebug", "", "getLocalResetVersion", "", "resetKandianRelatedManageConfigVersions", "resetLocalResetConfigVersionForDebug", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyResetUtilsImpl
  implements IReadInJoyResetUtils
{
  public void clearReadInJoyDatabase() {}
  
  public void clearReadInJoyLocalFiles() {}
  
  public void clearReadInJoySharedPreferences() {}
  
  @Nullable
  public String getLocalFilesPathForDebug()
  {
    return ReadInJoyResetUtils.h();
  }
  
  public int getLocalResetVersion()
  {
    return ReadInJoyResetUtils.a();
  }
  
  public void resetKandianRelatedManageConfigVersions() {}
  
  public void resetLocalResetConfigVersionForDebug() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.ReadInJoyResetUtilsImpl
 * JD-Core Version:    0.7.0.1
 */