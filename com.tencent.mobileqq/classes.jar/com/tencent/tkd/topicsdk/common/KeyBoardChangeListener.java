package com.tencent.tkd.topicsdk.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/KeyBoardChangeListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "contextObj", "", "(Ljava/lang/Object;)V", "listener", "Lcom/tencent/tkd/topicsdk/common/KeyBoardChangeListener$KeyboardListener;", "getListener", "()Lcom/tencent/tkd/topicsdk/common/KeyBoardChangeListener$KeyboardListener;", "setListener", "(Lcom/tencent/tkd/topicsdk/common/KeyBoardChangeListener$KeyboardListener;)V", "mContentView", "Landroid/view/View;", "mShowFlag", "", "mWindow", "Landroid/view/Window;", "destroy", "", "onGlobalLayout", "Companion", "KeyboardListener", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class KeyBoardChangeListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final KeyBoardChangeListener.Companion a = new KeyBoardChangeListener.Companion(null);
  @Nullable
  private KeyBoardChangeListener.KeyboardListener b;
  private boolean c;
  private Window d;
  private View e;
  
  private KeyBoardChangeListener(Object paramObject)
  {
    View localView;
    if ((paramObject instanceof Activity))
    {
      paramObject = (Activity)paramObject;
      localView = paramObject.findViewById(16908290);
      Intrinsics.checkExpressionValueIsNotNull(localView, "contextObj.findViewById(android.R.id.content)");
      this.e = localView;
      paramObject = paramObject.getWindow();
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "contextObj.window");
      this.d = paramObject;
    }
    else if ((paramObject instanceof Dialog))
    {
      paramObject = (Dialog)paramObject;
      localView = paramObject.findViewById(16908290);
      Intrinsics.checkExpressionValueIsNotNull(localView, "contextObj.findViewById(android.R.id.content)");
      this.e = localView;
      paramObject = paramObject.getWindow();
      if (paramObject == null) {
        Intrinsics.throwNpe();
      }
      this.d = paramObject;
    }
    paramObject = this.e;
    if (paramObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContentView");
    }
    paramObject.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
  }
  
  public final void a(@Nullable KeyBoardChangeListener.KeyboardListener paramKeyboardListener)
  {
    this.b = paramKeyboardListener;
  }
  
  public void onGlobalLayout()
  {
    Object localObject1 = this.e;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContentView");
    }
    if (((View)localObject1).getHeight() == 0)
    {
      Log.d("KeyboardChangeListener", "currHeight is 0");
      return;
    }
    localObject1 = DisplayUtils.a;
    Object localObject2 = this.d;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mWindow");
    }
    localObject2 = ((Window)localObject2).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "mWindow.context");
    int i = ((DisplayUtils)localObject1).b((Context)localObject2);
    localObject1 = new Rect();
    localObject2 = this.d;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mWindow");
    }
    ((Window)localObject2).getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    int j = ((Rect)localObject1).bottom;
    int k = i - j;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onGlobalLayout() called screenHeight ");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(" VisibleDisplayHeight ");
    ((StringBuilder)localObject1).append(j);
    Log.d("KeyboardChangeListener", ((StringBuilder)localObject1).toString());
    boolean bool;
    if (k > 300) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.c != bool)
    {
      this.c = bool;
      localObject1 = this.b;
      if (localObject1 != null) {
        ((KeyBoardChangeListener.KeyboardListener)localObject1).a(bool, k);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.KeyBoardChangeListener
 * JD-Core Version:    0.7.0.1
 */