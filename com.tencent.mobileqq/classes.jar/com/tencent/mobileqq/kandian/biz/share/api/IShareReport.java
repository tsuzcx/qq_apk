package com.tencent.mobileqq.kandian.biz.share.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/api/IShareReport;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "uinType", "", "getUinType", "()Ljava/lang/String;", "setUinType", "(Ljava/lang/String;)V", "reportResult", "", "success", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IShareReport
  extends QRouteApi
{
  @NotNull
  public abstract String getUinType();
  
  public abstract void reportResult(boolean paramBoolean);
  
  public abstract void setUinType(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.api.IShareReport
 * JD-Core Version:    0.7.0.1
 */