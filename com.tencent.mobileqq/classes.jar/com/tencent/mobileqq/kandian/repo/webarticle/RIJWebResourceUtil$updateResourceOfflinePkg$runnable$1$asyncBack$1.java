package com.tencent.mobileqq.kandian.repo.webarticle;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/repo/webarticle/RIJWebResourceUtil$updateResourceOfflinePkg$runnable$1$asyncBack$1", "Lcom/tencent/biz/common/offline/AsyncBack;", "loaded", "", "param", "", "code", "", "progress", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJWebResourceUtil$updateResourceOfflinePkg$runnable$1$asyncBack$1
  implements AsyncBack
{
  public void loaded(@Nullable String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateResourceOfflinePkg], loaded param = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", code = ");
    localStringBuilder.append(paramInt);
    QLog.i("RIJWebResourceUtil", 1, localStringBuilder.toString());
    if ((paramInt == 0) && (paramString == null))
    {
      QLog.i("RIJWebResourceUtil", 1, "[updateResourceOfflinePkg] download finished.");
      RIJWebResourceUtil.a.a(true);
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.RIJWebResourceUtil.updateResourceOfflinePkg.runnable.1.asyncBack.1
 * JD-Core Version:    0.7.0.1
 */