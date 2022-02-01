package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.vas.tianshu.ITianshuWebManager;
import com.tencent.mobileqq.vas.tianshu.TianshuWebManagerImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/vas/tianshu/ITianshuWebManager;", "invoke"}, k=3, mv={1, 1, 16})
final class VasServiceImpl$tianshuWebManager$2
  extends Lambda
  implements Function0<ITianshuWebManager>
{
  VasServiceImpl$tianshuWebManager$2(VasServiceImpl paramVasServiceImpl)
  {
    super(0);
  }
  
  @NotNull
  public final ITianshuWebManager invoke()
  {
    return (ITianshuWebManager)VasServiceImpl.access$dynamicCall(this.this$0, new TianshuWebManagerImpl());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasServiceImpl.tianshuWebManager.2
 * JD-Core Version:    0.7.0.1
 */