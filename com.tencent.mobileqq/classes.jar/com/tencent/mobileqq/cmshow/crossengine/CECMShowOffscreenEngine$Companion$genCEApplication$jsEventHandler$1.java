package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.crossengine.CEJSEventListener;
import com.tencent.mobileqq.cmshow.crossengine.util.CEChannelUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine$Companion$genCEApplication$jsEventHandler$1", "Lcom/tencent/crossengine/CEJSEventListener;", "onScriptEvent", "", "worldName", "params", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECMShowOffscreenEngine$Companion$genCEApplication$jsEventHandler$1
  implements CEJSEventListener
{
  @NotNull
  public String onScriptEvent(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "worldName");
    Intrinsics.checkParameterIsNotNull(paramString2, "params");
    paramString1 = (CECMShowOffscreenEngine)CECMShowOffscreenEngine.a().get(paramString1);
    if (paramString1 != null)
    {
      CEChannelUtil localCEChannelUtil = CEChannelUtil.a;
      paramString1 = CECMShowOffscreenEngine.a(paramString1);
      if (paramString1 != null) {
        paramString1 = paramString1.a(paramString2);
      } else {
        paramString1 = null;
      }
      return localCEChannelUtil.a(paramString1);
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine.Companion.genCEApplication.jsEventHandler.1
 * JD-Core Version:    0.7.0.1
 */