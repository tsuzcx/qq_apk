package com.tencent.videocut.utils;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/KeyboardStateHelper;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "activityRootView", "Landroid/view/View;", "isSoftKeyboardOpened", "", "(Landroid/view/View;Z)V", "()Z", "setSoftKeyboardOpened", "(Z)V", "lastSoftKeyboardHeightInPx", "", "listeners", "", "Lcom/tencent/videocut/utils/KeyboardStateHelper$KeyboardStateListener;", "mFirstHeight", "addSoftKeyboardStateListener", "", "listener", "notifyOnSoftKeyboardClosed", "notifyOnSoftKeyboardOpened", "keyboardHeightInPx", "onGlobalLayout", "recycler", "removeSoftKeyboardStateListener", "Companion", "KeyboardStateListener", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class KeyboardStateHelper
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  @NotNull
  public static final KeyboardStateHelper.Companion a = new KeyboardStateHelper.Companion(null);
  private final List<KeyboardStateHelper.KeyboardStateListener> b;
  private int c;
  private int d;
  private View e;
  private boolean f;
  
  @JvmOverloads
  public KeyboardStateHelper(@Nullable View paramView)
  {
    this(paramView, false, 2, null);
  }
  
  @JvmOverloads
  public KeyboardStateHelper(@Nullable View paramView, boolean paramBoolean)
  {
    this.e = paramView;
    this.f = paramBoolean;
    this.b = ((List)new LinkedList());
    paramView = this.e;
    if (paramView != null)
    {
      paramView = paramView.getViewTreeObserver();
      if (paramView != null) {
        paramView.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      }
    }
  }
  
  private final void a(int paramInt)
  {
    this.d = paramInt;
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((KeyboardStateHelper.KeyboardStateListener)localIterator.next()).a(paramInt);
    }
  }
  
  private final void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((KeyboardStateHelper.KeyboardStateListener)localIterator.next()).a();
    }
  }
  
  public final void a()
  {
    this.b.clear();
    Object localObject;
    if (Build.VERSION.SDK_INT < 16)
    {
      localObject = this.e;
      if (localObject != null)
      {
        localObject = ((View)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
    }
    else
    {
      localObject = this.e;
      if (localObject != null)
      {
        localObject = ((View)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
    }
    this.e = ((View)null);
  }
  
  public final void a(@NotNull KeyboardStateHelper.KeyboardStateListener paramKeyboardStateListener)
  {
    Intrinsics.checkNotNullParameter(paramKeyboardStateListener, "listener");
    this.b.add(paramKeyboardStateListener);
  }
  
  public final void b(@Nullable KeyboardStateHelper.KeyboardStateListener paramKeyboardStateListener)
  {
    Collection localCollection = (Collection)this.b;
    if (localCollection != null)
    {
      TypeIntrinsics.asMutableCollection(localCollection).remove(paramKeyboardStateListener);
      return;
    }
    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
  }
  
  public final boolean b()
  {
    return this.f;
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    View localView = this.e;
    if (localView != null) {
      localView.getWindowVisibleDisplayFrame(localRect);
    }
    int i = localRect.height();
    int j = this.c;
    if (j == 0)
    {
      this.c = i;
      return;
    }
    i = j - i;
    if ((!this.f) && (i >= 250))
    {
      this.f = true;
      a(i);
      return;
    }
    if ((this.f) && (i < 100))
    {
      this.f = false;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.KeyboardStateHelper
 * JD-Core Version:    0.7.0.1
 */