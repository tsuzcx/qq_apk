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
  private static int jdField_a_of_type_Int;
  public static final BasePage.Companion a;
  private View jdField_a_of_type_AndroidViewView;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkFrameworkBasePage$Companion = new BasePage.Companion(null);
  }
  
  private final boolean a()
  {
    if (jdField_a_of_type_Int > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getClass().getName());
      localStringBuilder.append(" is killed cos' killCount == ");
      localStringBuilder.append(jdField_a_of_type_Int);
      TLog.d("BasePage", localStringBuilder.toString());
      c();
      jdField_a_of_type_Int -= 1;
      return true;
    }
    return false;
  }
  
  private final void f()
  {
    Object localObject = a();
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
      if (g())
      {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          localObject = (FrameLayout)localObject;
          this.jdField_a_of_type_AndroidViewView = ((View)new LinearLayout(((FrameLayout)localObject).getContext()));
          localView = this.jdField_a_of_type_AndroidViewView;
          if (localView != null)
          {
            Context localContext = ((FrameLayout)localObject).getContext();
            Intrinsics.checkExpressionValueIsNotNull(localContext, "decorView.context");
            localView.setBackgroundColor(localContext.getResources().getColor(R.color.jdField_a_of_type_Int));
          }
          ((FrameLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        }
      }
      else
      {
        localView = this.jdField_a_of_type_AndroidViewView;
        if (localView != null)
        {
          ((FrameLayout)localObject).removeView(localView);
          this.jdField_a_of_type_AndroidViewView = ((View)null);
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
      if (p_())
      {
        paramBundle = a();
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
        paramBundle = a();
        if (paramBundle != null)
        {
          Object localObject = paramBundle.getWindow();
          if ((localObject != null) && (f()))
          {
            ((Window)localObject).addFlags(-2147483648);
            ((Window)localObject).clearFlags(67108864);
            paramBundle = a();
            ((Window)localObject).setStatusBarColor(((Number)paramBundle.getFirst()).intValue());
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
  public Pair<Integer, Integer> a()
  {
    label41:
    int i;
    if (g())
    {
      Object localObject = a();
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getResources();
        if (localObject != null)
        {
          localObject = Integer.valueOf(((Resources)localObject).getColor(R.color.jdField_a_of_type_Int));
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
  
  public void b()
  {
    if (a()) {
      return;
    }
    super.b();
    f();
  }
  
  public final void c()
  {
    Activity localActivity = a();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  public boolean e()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public boolean f()
  {
    return true;
  }
  
  public boolean g()
  {
    return false;
  }
  
  public boolean p_()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.BasePage
 * JD-Core Version:    0.7.0.1
 */