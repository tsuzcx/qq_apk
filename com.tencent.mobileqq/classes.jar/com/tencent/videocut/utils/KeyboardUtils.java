package com.tencent.videocut.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/KeyboardUtils;", "", "()V", "hideKeyboard", "", "view", "Landroid/view/View;", "showKeyboard", "toggleSoftInput", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class KeyboardUtils
{
  @NotNull
  public static final KeyboardUtils a = new KeyboardUtils();
  
  public final void a(@NotNull View paramView)
  {
    Intrinsics.checkNotNullParameter(paramView, "view");
    Object localObject = paramView.getContext().getSystemService("input_method");
    if (localObject != null)
    {
      localObject = (InputMethodManager)localObject;
      paramView.requestFocus();
      ((InputMethodManager)localObject).showSoftInput(paramView, 0);
      return;
    }
    throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
  }
  
  public final void b(@NotNull View paramView)
  {
    Intrinsics.checkNotNullParameter(paramView, "view");
    Object localObject = paramView.getContext().getSystemService("input_method");
    if (localObject != null)
    {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      return;
    }
    throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.KeyboardUtils
 * JD-Core Version:    0.7.0.1
 */