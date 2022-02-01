package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/fastweb/util/RIJ3ClickUtils$clickRespObserver$1", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "onHandle3ClickResp", "", "type", "", "resultCode", "data", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJ3ClickUtils$clickRespObserver$1
  extends ReadInJoyObserver
{
  public void a(int paramInt1, int paramInt2, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "data");
    if (!RIJ3ClickUtils.a(RIJ3ClickUtils.a))
    {
      QLog.d("RIJ3ClickUtils", 1, "onHandle3Click request false!");
      return;
    }
    if ((paramInt1 != 6) && (paramInt1 != 7) && (paramInt1 != 5))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHandle3ClickResp error, type=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", resultCode={");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("}, data={");
      localStringBuilder.append(paramObject);
      localStringBuilder.append('}');
      QLog.d("RIJ3ClickUtils", 1, localStringBuilder.toString());
      return;
    }
    RIJ3ClickUtils.a(RIJ3ClickUtils.a, paramInt1, paramInt2, paramObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onHandle3ClickResp, type=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", resultCode=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", data=");
    localStringBuilder.append(paramObject);
    QLog.d("RIJ3ClickUtils", 1, localStringBuilder.toString());
    RIJ3ClickUtils.a(RIJ3ClickUtils.a, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.RIJ3ClickUtils.clickRespObserver.1
 * JD-Core Version:    0.7.0.1
 */