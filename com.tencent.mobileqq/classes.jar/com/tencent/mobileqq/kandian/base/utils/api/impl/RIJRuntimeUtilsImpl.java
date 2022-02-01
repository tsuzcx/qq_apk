package com.tencent.mobileqq.kandian.base.utils.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/RIJRuntimeUtilsImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IRIJRuntimeUtils;", "()V", "getAppRuntime", "Lmqq/app/AppRuntime;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRuntimeUtilsImpl
  implements IRIJRuntimeUtils
{
  @Nullable
  public AppRuntime getAppRuntime()
  {
    AppRuntime localAppRuntime = (AppRuntime)null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.impl.RIJRuntimeUtilsImpl
 * JD-Core Version:    0.7.0.1
 */