package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.crossengine.CEJSEventListener;
import com.tencent.mobileqq.cmshow.crossengine.util.CEChannelUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "worldName", "kotlin.jvm.PlatformType", "params", "onScriptEvent"}, k=3, mv={1, 1, 16})
final class CECMShowEngine$initEngine$1
  implements CEJSEventListener
{
  CECMShowEngine$initEngine$1(CECMShowEngine paramCECMShowEngine) {}
  
  @NotNull
  public final String onScriptEvent(String paramString1, String paramString2)
  {
    CEChannelUtil localCEChannelUtil = CEChannelUtil.a;
    paramString1 = CECMShowEngine.a(this.a);
    if (paramString1 != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramString2, "params");
      paramString1 = paramString1.a(paramString2);
    }
    else
    {
      paramString1 = null;
    }
    return localCEChannelUtil.a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowEngine.initEngine.1
 * JD-Core Version:    0.7.0.1
 */