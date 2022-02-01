package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.crossengine.offscreen.OffscreenWorldCallback;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine$Companion$genCEApplication$offscreenCallback$1", "Lcom/tencent/crossengine/offscreen/OffscreenWorldCallback;", "onOffscreenWorldCreated", "", "worldName", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECMShowOffscreenEngine$Companion$genCEApplication$offscreenCallback$1
  implements OffscreenWorldCallback
{
  public void a(@Nullable String paramString)
  {
    paramString = (CECMShowOffscreenEngine)CECMShowOffscreenEngine.a().get(paramString);
    if (paramString != null)
    {
      paramString = CECMShowOffscreenEngine.a(paramString);
      if (paramString != null) {
        paramString.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine.Companion.genCEApplication.offscreenCallback.1
 * JD-Core Version:    0.7.0.1
 */