package com.tencent.mobileqq.kandian.repo.xtab.api.impl;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/aladdin/config/AladdinConfig;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class RIJXTabConfigHandler$_config$2
  extends Lambda
  implements Function0<AladdinConfig>
{
  public static final 2 INSTANCE = new 2();
  
  RIJXTabConfigHandler$_config$2()
  {
    super(0);
  }
  
  public final AladdinConfig invoke()
  {
    return Aladdin.getConfig(401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler._config.2
 * JD-Core Version:    0.7.0.1
 */