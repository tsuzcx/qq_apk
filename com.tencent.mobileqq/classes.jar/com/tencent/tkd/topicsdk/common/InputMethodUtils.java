package com.tencent.tkd.topicsdk.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/InputMethodUtils;", "", "()V", "hideInputMethod", "", "context", "Landroid/content/Context;", "windowToken", "Landroid/os/IBinder;", "isSoftInputShowing", "", "activity", "Landroid/app/Activity;", "showInputMethod", "view", "Landroid/view/View;", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class InputMethodUtils
{
  public static final InputMethodUtils a = new InputMethodUtils();
  
  public final void a(@NotNull Context paramContext, @NotNull IBinder paramIBinder)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramIBinder, "windowToken");
    paramContext = paramContext.getSystemService("input_method");
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
    paramContext = (InputMethodManager)paramContext;
    if (paramContext.isActive()) {
      paramContext.hideSoftInputFromWindow(paramIBinder, 0);
    }
  }
  
  public final void a(@NotNull Context paramContext, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    paramContext = paramContext.getSystemService("input_method");
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
    paramContext = (InputMethodManager)paramContext;
    paramView.requestFocus();
    paramContext.showSoftInput(paramView, 0);
  }
  
  public final boolean a(@Nullable Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      Object localObject = paramActivity.getWindow();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "act.window");
      localObject = ((Window)localObject).getDecorView();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "act.window.decorView");
      int i = ((View)localObject).getHeight();
      localObject = new Rect();
      paramActivity = paramActivity.getWindow();
      Intrinsics.checkExpressionValueIsNotNull(paramActivity, "act.window");
      paramActivity.getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      bool1 = bool2;
      if (i * 2 / 3 > ((Rect)localObject).bottom) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.InputMethodUtils
 * JD-Core Version:    0.7.0.1
 */