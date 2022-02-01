package com.tencent.tkd.topicsdk.framework;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import com.tencent.tkd.topicsdk.interfaces.PageProxy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/BasePage;", "Lcom/tencent/tkd/topicsdk/interfaces/PageProxy;", "()V", "isImmersiveStatusBar", "", "()Z", "isNightMode", "isSupportTranslateStatusBar", "isTranslateStatusBar", "view", "Landroid/view/View;", "addViewOnDecorView", "", "checkAndKillCurPage", "finish", "finishAndKillPreviewPages", "killCount", "", "getArguments", "Landroid/os/Bundle;", "getImmersiveStatusBarStatus", "Lkotlin/Pair;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onResume", "setArguments", "bundle", "Companion", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public abstract class BasePage
  extends PageProxy
{
  public static final BasePage.Companion b = new BasePage.Companion(null);
  private static int c;
  private View a;
  
  private final boolean n()
  {
    if (c > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getClass().getName());
      localStringBuilder.append(" is killed cos' killCount == ");
      localStringBuilder.append(c);
      TLog.d("BasePage", localStringBuilder.toString());
      l();
      c -= 1;
      return true;
    }
    return false;
  }
  
  private final void o()
  {
    Object localObject = b();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        break label28;
      }
    }
    localObject = null;
    label28:
    if ((localObject instanceof FrameLayout))
    {
      View localView;
      if (j())
      {
        if (this.a == null)
        {
          localObject = (FrameLayout)localObject;
          this.a = ((View)new LinearLayout(((FrameLayout)localObject).getContext()));
          localView = this.a;
          if (localView != null)
          {
            Context localContext = ((FrameLayout)localObject).getContext();
            Intrinsics.checkExpressionValueIsNotNull(localContext, "decorView.context");
            localView.setBackgroundColor(localContext.getResources().getColor(R.color.a));
          }
          ((FrameLayout)localObject).addView(this.a, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        }
      }
      else
      {
        localView = this.a;
        if (localView != null)
        {
          ((FrameLayout)localObject).removeView(localView);
          this.a = ((View)null);
        }
      }
    }
  }
  
  @Nullable
  public Bundle a()
  {
    Bundle localBundle = super.a();
    if (localBundle != null) {
      localBundle.setClassLoader(BasePage.class.getClassLoader());
    }
    if (localBundle != null) {
      localBundle = localBundle.getBundle("key_base_bundle");
    } else {
      localBundle = null;
    }
    if (localBundle != null) {
      localBundle.setClassLoader(BasePage.class.getClassLoader());
    }
    return localBundle;
  }
  
  @Nullable
  public abstract View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup);
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    if (Build.VERSION.SDK_INT >= 19) {
      if (g())
      {
        paramBundle = b();
        if (paramBundle != null)
        {
          paramBundle = paramBundle.getWindow();
          if (paramBundle != null) {
            paramBundle.addFlags(67108864);
          }
        }
      }
      else if (Build.VERSION.SDK_INT >= 23)
      {
        paramBundle = b();
        if (paramBundle != null)
        {
          Object localObject = paramBundle.getWindow();
          if ((localObject != null) && (i()))
          {
            ((Window)localObject).addFlags(-2147483648);
            ((Window)localObject).clearFlags(67108864);
            paramBundle = c();
            ((Window)localObject).setStatusBarColor(((Number)paramBundle.getFirst()).intValue());
            ((Window)localObject).setNavigationBarColor(((Number)paramBundle.getFirst()).intValue());
            localObject = ((Window)localObject).getDecorView();
            Intrinsics.checkExpressionValueIsNotNull(localObject, "decorView");
            ((View)localObject).setSystemUiVisibility(((Number)paramBundle.getSecond()).intValue());
          }
        }
      }
    }
    return a(paramLayoutInflater, paramViewGroup);
  }
  
  @RequiresApi(23)
  @NotNull
  public Pair<Integer, Integer> c()
  {
    label41:
    int i;
    if (j())
    {
      Object localObject = b();
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getResources();
        if (localObject != null)
        {
          localObject = Integer.valueOf(((Resources)localObject).getColor(R.color.a));
          break label41;
        }
      }
      localObject = null;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      i = ((Integer)localObject).intValue();
    }
    else
    {
      i = -1;
    }
    return new Pair(Integer.valueOf(i), Integer.valueOf(8192));
  }
  
  public boolean g()
  {
    return false;
  }
  
  public boolean h()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public boolean i()
  {
    return true;
  }
  
  public boolean j()
  {
    return false;
  }
  
  public void k()
  {
    if (n()) {
      return;
    }
    super.k();
    o();
  }
  
  public final void l()
  {
    Activity localActivity = b();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.BasePage
 * JD-Core Version:    0.7.0.1
 */