package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.mobileqq.cmshow.engine.model.BusinessConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/cmshow/engine/model/BusinessConfig;", "invoke"}, k=3, mv={1, 1, 16})
final class CECMShowEngine$businessConfig$2
  extends Lambda
  implements Function0<BusinessConfig>
{
  CECMShowEngine$businessConfig$2(CECMShowEngine paramCECMShowEngine)
  {
    super(0);
  }
  
  @NotNull
  public final BusinessConfig invoke()
  {
    return new BusinessConfig((Function3)new CECMShowEngine.businessConfig.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowEngine.businessConfig.2
 * JD-Core Version:    0.7.0.1
 */