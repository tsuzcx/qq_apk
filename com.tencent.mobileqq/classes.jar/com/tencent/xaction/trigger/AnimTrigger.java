package com.tencent.xaction.trigger;

import android.os.Build.VERSION;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.data.ViewData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/AnimTrigger;", "Lcom/tencent/xaction/trigger/BaseTrigger;", "()V", "monitor", "", "data", "Lcom/tencent/xaction/api/data/ViewData;", "iview", "Lcom/tencent/xaction/api/IView;", "notifyState", "", "key", "", "value", "", "startAnim", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public final class AnimTrigger
  extends BaseTrigger
{
  public void monitor(@NotNull ViewData paramViewData, @NotNull IView paramIView)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "data");
    Intrinsics.checkParameterIsNotNull(paramIView, "iview");
    super.monitor(paramViewData, paramIView);
  }
  
  public boolean notifyState(@NotNull String paramString, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramObject, "value");
    if (((paramObject instanceof String)) && (Build.VERSION.SDK_INT >= 16)) {
      return startAnim();
    }
    return false;
  }
  
  public final boolean startAnim()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.trigger.AnimTrigger
 * JD-Core Version:    0.7.0.1
 */