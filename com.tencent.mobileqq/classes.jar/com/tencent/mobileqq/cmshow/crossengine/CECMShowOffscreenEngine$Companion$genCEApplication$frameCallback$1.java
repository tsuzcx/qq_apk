package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.crossengine.FrameCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine$Companion$genCEApplication$frameCallback$1", "Lcom/tencent/crossengine/FrameCallback;", "onFrameCallback", "", "worldName", "", "pixels", "", "width", "", "height", "byteLength", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECMShowOffscreenEngine$Companion$genCEApplication$frameCallback$1
  implements FrameCallback
{
  public void onFrameCallback(@NotNull String paramString, @Nullable byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "worldName");
    if (paramArrayOfByte != null)
    {
      int i;
      if (paramArrayOfByte.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return;
      }
      Object localObject = (CECMShowOffscreenEngine)CECMShowOffscreenEngine.n().get(paramString);
      if (localObject != null)
      {
        localObject = CECMShowOffscreenEngine.c((CECMShowOffscreenEngine)localObject);
        if (localObject != null) {
          ((CERenderService)localObject).a(paramString, paramArrayOfByte, paramInt1, paramInt2, paramInt3);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine.Companion.genCEApplication.frameCallback.1
 * JD-Core Version:    0.7.0.1
 */