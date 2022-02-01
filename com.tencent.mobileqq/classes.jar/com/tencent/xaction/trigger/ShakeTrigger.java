package com.tencent.xaction.trigger;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.trigger.shake.ShakeRecognizer;
import com.tencent.xaction.trigger.shake.ShakeRecognizer.OnShakeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/ShakeTrigger;", "Lcom/tencent/xaction/trigger/AnimTrigger;", "Lcom/tencent/xaction/trigger/shake/ShakeRecognizer$OnShakeListener;", "Landroid/view/View$OnAttachStateChangeListener;", "()V", "mShakeRecognizer", "Lcom/tencent/xaction/trigger/shake/ShakeRecognizer;", "monitor", "", "data", "Lcom/tencent/xaction/api/data/ViewData;", "iview", "Lcom/tencent/xaction/api/IView;", "onShake", "onViewAttachedToWindow", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class ShakeTrigger
  extends AnimTrigger
  implements View.OnAttachStateChangeListener, ShakeRecognizer.OnShakeListener
{
  private ShakeRecognizer mShakeRecognizer;
  
  public void monitor(@NotNull ViewData paramViewData, @NotNull IView paramIView)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "data");
    Intrinsics.checkParameterIsNotNull(paramIView, "iview");
    super.monitor(paramViewData, paramIView);
    paramViewData = paramIView.getDecor().b();
    if (paramViewData != null)
    {
      paramViewData.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
      paramViewData = paramViewData.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewData, "view.context");
      this.mShakeRecognizer = new ShakeRecognizer(paramViewData, (ShakeRecognizer.OnShakeListener)this);
      setStatus("");
    }
  }
  
  public void onShake()
  {
    Object localObject = getIView();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((IView)localObject).getDecor().b();
    if (localObject != null)
    {
      updateStatus((View)localObject, getANIM_START_TAG());
      setStatus("");
    }
  }
  
  public void onViewAttachedToWindow(@Nullable View paramView)
  {
    paramView = this.mShakeRecognizer;
    if (paramView == null) {
      Intrinsics.throwNpe();
    }
    paramView.a();
  }
  
  public void onViewDetachedFromWindow(@Nullable View paramView)
  {
    paramView = this.mShakeRecognizer;
    if (paramView == null) {
      Intrinsics.throwNpe();
    }
    paramView.b();
    this.mShakeRecognizer = ((ShakeRecognizer)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.ShakeTrigger
 * JD-Core Version:    0.7.0.1
 */