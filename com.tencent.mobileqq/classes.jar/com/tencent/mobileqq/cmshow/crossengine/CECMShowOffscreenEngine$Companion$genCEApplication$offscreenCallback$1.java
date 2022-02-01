package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.crossengine.offscreen.OffscreenWorldCallback;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine$Companion$genCEApplication$offscreenCallback$1", "Lcom/tencent/crossengine/offscreen/OffscreenWorldCallback;", "onOffscreenSurfaceReady", "", "worldName", "", "onOffscreenWorldCreated", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECMShowOffscreenEngine$Companion$genCEApplication$offscreenCallback$1
  implements OffscreenWorldCallback
{
  public void a(@Nullable String paramString)
  {
    paramString = (CECMShowOffscreenEngine)CECMShowOffscreenEngine.n().get(paramString);
    if (paramString != null)
    {
      paramString = CECMShowOffscreenEngine.c(paramString);
      if (paramString != null) {
        paramString.d();
      }
    }
  }
  
  public void b(@Nullable String paramString)
  {
    paramString = (CECMShowOffscreenEngine)CECMShowOffscreenEngine.n().get(paramString);
    if (paramString != null)
    {
      paramString = CECMShowOffscreenEngine.c(paramString);
      if (paramString != null) {
        paramString.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine.Companion.genCEApplication.offscreenCallback.1
 * JD-Core Version:    0.7.0.1
 */