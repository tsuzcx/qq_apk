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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/BasePage;", "Lcom/tencent/tkd/topicsdk/interfaces/PageProxy;", "()V", "isImmersiveStatusBar", "", "()Z", "isNightMode", "isSupportTranslateStatusBar", "isTranslateStatusBar", "view", "Landroid/view/View;", "finish", "", "finishAndKillPreviewPages", "killCount", "", "getArguments", "Landroid/os/Bundle;", "getImmersiveStatusBarStatus", "Lkotlin/Pair;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onResume", "setArguments", "bundle", "Companion", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
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
  
  @Nullable
  public Bundle a()
  {
    Bundle localBundle = super.a();
    if (localBundle != null) {
      localBundle.setClassLoader(BasePage.class.getClassLoader());
    }
    if (localBundle != null) {}
    for (localBundle = localBundle.getBundle("key_base_bundle");; localBundle = null)
    {
      if (localBundle != null) {
        localBundle.setClassLoader(BasePage.class.getClassLoader());
      }
      return localBundle;
    }
  }
  
  @Nullable
  public abstract View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup);
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (!a()) {
        break label52;
      }
      paramBundle = a();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getWindow();
        if (paramBundle != null) {
          paramBundle.addFlags(67108864);
        }
      }
    }
    for (;;)
    {
      return a(paramLayoutInflater, paramViewGroup);
      label52:
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramBundle = a();
        if (paramBundle != null)
        {
          Object localObject = paramBundle.getWindow();
          if (localObject != null) {
            if (c())
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
    }
  }
  
  @RequiresApi(23)
  @NotNull
  public Pair<Integer, Integer> a()
  {
    Object localObject;
    if (d())
    {
      localObject = a();
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getResources();
        if (localObject != null)
        {
          localObject = Integer.valueOf(((Resources)localObject).getColor(R.color.jdField_a_of_type_Int));
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
        }
      }
    }
    for (int i = ((Integer)localObject).intValue();; i = -1)
    {
      return new Pair(Integer.valueOf(i), Integer.valueOf(8192));
      localObject = null;
      break;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    if (jdField_a_of_type_Int > 0)
    {
      TLog.d("BasePage", getClass().getName() + " is killed cos' killCount == " + jdField_a_of_type_Int);
      c();
      jdField_a_of_type_Int -= 1;
    }
    Object localObject;
    label188:
    label190:
    do
    {
      for (;;)
      {
        return;
        super.b();
        localObject = a();
        if (localObject != null)
        {
          localObject = ((Activity)localObject).getWindow();
          if (localObject == null) {}
        }
        for (localObject = ((Window)localObject).getDecorView();; localObject = null)
        {
          if (!(localObject instanceof FrameLayout)) {
            break label188;
          }
          if (!d()) {
            break label190;
          }
          if (this.jdField_a_of_type_AndroidViewView != null) {
            break;
          }
          this.jdField_a_of_type_AndroidViewView = ((View)new LinearLayout(((FrameLayout)localObject).getContext()));
          View localView = this.jdField_a_of_type_AndroidViewView;
          if (localView != null)
          {
            Context localContext = ((FrameLayout)localObject).getContext();
            Intrinsics.checkExpressionValueIsNotNull(localContext, "decorView.context");
            localView.setBackgroundColor(localContext.getResources().getColor(R.color.jdField_a_of_type_Int));
          }
          ((FrameLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
          return;
        }
      }
    } while (this.jdField_a_of_type_AndroidViewView == null);
    ((FrameLayout)localObject).removeView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView = ((View)null);
  }
  
  public boolean b()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public final void c()
  {
    Activity localActivity = a();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.BasePage
 * JD-Core Version:    0.7.0.1
 */