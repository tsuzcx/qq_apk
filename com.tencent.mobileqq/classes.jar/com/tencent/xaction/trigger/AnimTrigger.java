package com.tencent.xaction.trigger;

import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.openapi.api.IPublicAnim;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/AnimTrigger;", "Lcom/tencent/xaction/trigger/BaseTrigger;", "()V", "ANIM_END_TAG", "", "getANIM_END_TAG", "()Ljava/lang/String;", "ANIM_START_TAG", "getANIM_START_TAG", "monitor", "", "data", "Lcom/tencent/xaction/api/data/ViewData;", "iview", "Lcom/tencent/xaction/api/IView;", "notifyState", "", "key", "value", "", "startAnim", "stopAnim", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public class AnimTrigger
  extends BaseTrigger
{
  @NotNull
  private final String ANIM_END_TAG = "end";
  @NotNull
  private final String ANIM_START_TAG = "start";
  
  private final boolean startAnim()
  {
    if (getIView() != null)
    {
      if (getEngine() == null) {
        return false;
      }
      Object localObject = getIView();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((IView)localObject).getDecor().b();
      if (localObject != null)
      {
        IView localIView = getIView();
        if (localIView != null)
        {
          ((IPublicAnim)localIView).play();
          updateStatus((View)localObject, this.ANIM_START_TAG);
          setStatus("");
          return true;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.openapi.api.IPublicAnim");
      }
    }
    return false;
  }
  
  private final boolean stopAnim()
  {
    if (getIView() != null)
    {
      if (getEngine() == null) {
        return false;
      }
      Object localObject = getIView();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((IView)localObject).getDecor().b();
      if (localObject != null)
      {
        IView localIView = getIView();
        if (localIView != null)
        {
          ((IPublicAnim)localIView).end();
          updateStatus((View)localObject, this.ANIM_END_TAG);
          setStatus("");
          return true;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.openapi.api.IPublicAnim");
      }
    }
    return false;
  }
  
  @NotNull
  public final String getANIM_END_TAG()
  {
    return this.ANIM_END_TAG;
  }
  
  @NotNull
  public final String getANIM_START_TAG()
  {
    return this.ANIM_START_TAG;
  }
  
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
    if (((paramObject instanceof String)) && (Build.VERSION.SDK_INT >= 16))
    {
      if (Intrinsics.areEqual(paramObject, this.ANIM_START_TAG)) {
        return startAnim();
      }
      if (Intrinsics.areEqual(paramObject, this.ANIM_END_TAG)) {
        stopAnim();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.AnimTrigger
 * JD-Core Version:    0.7.0.1
 */