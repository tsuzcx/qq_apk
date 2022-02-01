package com.tencent.mobileqq.kandian.biz.biu.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/biu/api/IBiuBehaviour;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getBiuButtonClickBehaviour", "", "getBiuButtonClickBehaviourStr", "", "getBiuButtonLongClickBehaviour", "getBiuButtonLongClickBehaviourStr", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IBiuBehaviour
  extends QRouteApi
{
  public abstract int getBiuButtonClickBehaviour();
  
  @NotNull
  public abstract String getBiuButtonClickBehaviourStr();
  
  public abstract int getBiuButtonLongClickBehaviour();
  
  @NotNull
  public abstract String getBiuButtonLongClickBehaviourStr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.api.IBiuBehaviour
 * JD-Core Version:    0.7.0.1
 */