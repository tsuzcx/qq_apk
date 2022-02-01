package com.tencent.xaction.trigger.touch;

import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/touch/TouchEventHelper;", "", "()V", "obtainTouchDelegate", "Lcom/tencent/xaction/trigger/touch/TouchDelegateProxy;", "view", "Landroid/view/View;", "setClickListener", "", "clickListener", "Landroid/view/View$OnClickListener;", "setTouchListener", "touchListener", "Landroid/view/View$OnTouchListener;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class TouchEventHelper
{
  public static final TouchEventHelper a = new TouchEventHelper();
  
  private final TouchDelegateProxy a(View paramView)
  {
    Object localObject = paramView.getTouchDelegate();
    if ((localObject instanceof TouchDelegateProxy)) {
      return (TouchDelegateProxy)localObject;
    }
    localObject = new TouchDelegateProxy(paramView, (TouchDelegate)localObject);
    paramView.setTouchDelegate((TouchDelegate)localObject);
    return localObject;
  }
  
  public final void a(@Nullable View paramView, @Nullable View.OnClickListener paramOnClickListener)
  {
    if (paramView != null)
    {
      if (paramOnClickListener == null) {
        return;
      }
      paramView.setClickable(true);
      a(paramView).a(paramOnClickListener);
    }
  }
  
  public final void a(@NotNull View paramView, @NotNull View.OnTouchListener paramOnTouchListener)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramOnTouchListener, "touchListener");
    a(paramView).a(paramOnTouchListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.touch.TouchEventHelper
 * JD-Core Version:    0.7.0.1
 */