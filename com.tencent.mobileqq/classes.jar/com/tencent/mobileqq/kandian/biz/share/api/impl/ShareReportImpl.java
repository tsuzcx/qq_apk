package com.tencent.mobileqq.kandian.biz.share.api.impl;

import com.tencent.mobileqq.kandian.biz.share.api.IShareReport;
import com.tencent.mobileqq.kandian.repo.share.ShareReport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/api/impl/ShareReportImpl;", "Lcom/tencent/mobileqq/kandian/biz/share/api/IShareReport;", "()V", "value", "", "uinType", "getUinType", "()Ljava/lang/String;", "setUinType", "(Ljava/lang/String;)V", "reportResult", "", "success", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ShareReportImpl
  implements IShareReport
{
  @NotNull
  public String getUinType()
  {
    return ShareReport.a.a();
  }
  
  public void reportResult(boolean paramBoolean)
  {
    ShareReport.a.a(paramBoolean);
  }
  
  public void setUinType(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    ShareReport.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.api.impl.ShareReportImpl
 * JD-Core Version:    0.7.0.1
 */