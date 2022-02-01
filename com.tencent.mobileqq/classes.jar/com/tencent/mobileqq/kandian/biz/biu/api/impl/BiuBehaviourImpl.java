package com.tencent.mobileqq.kandian.biz.biu.api.impl;

import com.tencent.mobileqq.kandian.biz.biu.api.IBiuBehaviour;
import com.tencent.mobileqq.kandian.repo.biu.BiuBehaviour;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/biu/api/impl/BiuBehaviourImpl;", "Lcom/tencent/mobileqq/kandian/biz/biu/api/IBiuBehaviour;", "()V", "getBiuButtonClickBehaviour", "", "getBiuButtonClickBehaviourStr", "", "getBiuButtonLongClickBehaviour", "getBiuButtonLongClickBehaviourStr", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BiuBehaviourImpl
  implements IBiuBehaviour
{
  public int getBiuButtonClickBehaviour()
  {
    return BiuBehaviour.a();
  }
  
  @NotNull
  public String getBiuButtonClickBehaviourStr()
  {
    if (getBiuButtonClickBehaviour() == 1) {
      return "fastBiu";
    }
    return "normalBiu";
  }
  
  public int getBiuButtonLongClickBehaviour()
  {
    return BiuBehaviour.b();
  }
  
  @NotNull
  public String getBiuButtonLongClickBehaviourStr()
  {
    if (getBiuButtonLongClickBehaviour() == 1) {
      return "fastBiu";
    }
    return "normalBiu";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.api.impl.BiuBehaviourImpl
 * JD-Core Version:    0.7.0.1
 */