package com.tencent.timi.game.component.chat.input;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.utils.Logger;
import mqq.app.MobileQQ;

public final class KeyboardUtils
{
  private static int a;
  
  private KeyboardUtils()
  {
    throw new UnsupportedOperationException("u can't instantiate me...");
  }
  
  public static void a()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)MobileQQ.getContext().getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    localInputMethodManager.toggleSoftInput(0, 0);
  }
  
  public static void a(@NonNull View paramView)
  {
    a(paramView, 0);
  }
  
  public static void a(@NonNull View paramView, int paramInt)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)MobileQQ.getContext().getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    paramView.setFocusable(true);
    paramView.setFocusableInTouchMode(true);
    paramView.requestFocus();
    localInputMethodManager.showSoftInput(paramView, paramInt, new KeyboardUtils.1(new Handler()));
    localInputMethodManager.toggleSoftInput(2, 1);
  }
  
  public static void a(@NonNull View paramView, @NonNull Window paramWindow)
  {
    paramWindow = paramWindow.findViewById(16908290);
    if (paramWindow == null) {
      return;
    }
    paramView = paramView.getTag(-8);
    if (((paramView instanceof ViewTreeObserver.OnGlobalLayoutListener)) && (Build.VERSION.SDK_INT >= 16)) {
      paramWindow.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)paramView);
    }
  }
  
  public static void a(@NonNull View paramView, @NonNull Window paramWindow, @NonNull KeyboardUtils.OnSoftInputChangedListener paramOnSoftInputChangedListener)
  {
    if ((paramWindow.getAttributes().flags & 0x200) != 0) {
      paramWindow.clearFlags(512);
    }
    FrameLayout localFrameLayout = (FrameLayout)paramWindow.findViewById(16908290);
    paramWindow = new KeyboardUtils.3(paramWindow, new int[] { d(paramWindow) }, paramOnSoftInputChangedListener);
    localFrameLayout.getViewTreeObserver().addOnGlobalLayoutListener(paramWindow);
    paramView.setTag(-8, paramWindow);
  }
  
  public static void a(@NonNull Window paramWindow)
  {
    paramWindow = paramWindow.findViewById(16908290);
    if (paramWindow == null) {
      return;
    }
    Object localObject = paramWindow.getTag(-8);
    if (((localObject instanceof ViewTreeObserver.OnGlobalLayoutListener)) && (Build.VERSION.SDK_INT >= 16)) {
      paramWindow.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)localObject);
    }
  }
  
  public static void b(@NonNull View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)MobileQQ.getContext().getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  private static int d(@NonNull Window paramWindow)
  {
    paramWindow = paramWindow.getDecorView();
    Rect localRect = new Rect();
    paramWindow.getWindowVisibleDisplayFrame(localRect);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDecorViewInvisibleHeight: ");
    localStringBuilder.append(paramWindow.getBottom() - localRect.bottom);
    Logger.b("KeyboardUtils", localStringBuilder.toString());
    int i = Math.abs(paramWindow.getBottom() - localRect.bottom);
    if (i <= ScreenUtil.getNavigationBarHeight(MobileQQ.getContext()) + ViewUtils.getStatusBarHeight(MobileQQ.getContext()))
    {
      a = i;
      return 0;
    }
    return i - a;
  }
  
  private static int e(Window paramWindow)
  {
    paramWindow = paramWindow.findViewById(16908290);
    if (paramWindow == null) {
      return 0;
    }
    Rect localRect = new Rect();
    paramWindow.getWindowVisibleDisplayFrame(localRect);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getContentViewInvisibleHeight: ");
    localStringBuilder.append(paramWindow.getBottom() - localRect.bottom);
    Logger.b("KeyboardUtils", localStringBuilder.toString());
    int i = Math.abs(paramWindow.getBottom() - localRect.bottom);
    if (i <= ScreenUtil.getNavigationBarHeight(MobileQQ.getContext()) + ViewUtils.getStatusBarHeight(MobileQQ.getContext())) {
      return 0;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.KeyboardUtils
 * JD-Core Version:    0.7.0.1
 */