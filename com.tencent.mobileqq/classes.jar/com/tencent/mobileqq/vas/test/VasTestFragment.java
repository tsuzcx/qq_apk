package com.tencent.mobileqq.vas.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import dalvik.system.PathClassLoader;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/test/VasTestFragment;", "Lcom/tencent/mobileqq/fragment/PublicBaseFragment;", "()V", "<set-?>", "Landroid/view/ViewGroup;", "container", "getContainer", "()Landroid/view/ViewGroup;", "testCase", "Lcom/tencent/mobileqq/vas/test/VasTestFragment$IVasTestFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "onDestroy", "Companion", "IVasTestFragment", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasTestFragment
  extends PublicBaseFragment
{
  public static final VasTestFragment.Companion a = new VasTestFragment.Companion(null);
  @Nullable
  private ViewGroup b;
  private VasTestFragment.IVasTestFragment c;
  private HashMap d;
  
  public void a()
  {
    HashMap localHashMap = this.d;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      paramBundle = getBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "baseActivity");
      paramBundle = paramBundle.getIntent();
      String str = paramBundle.getStringExtra("apk_path");
      paramBundle = Class.forName(paramBundle.getStringExtra("class_path"), true, (ClassLoader)new PathClassLoader(str, getClass().getClassLoader())).newInstance();
      if (paramBundle != null) {
        this.c = ((VasTestFragment.IVasTestFragment)paramBundle);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.vas.test.VasTestFragment.IVasTestFragment");
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("VasTestFragment", 1, (Throwable)paramBundle, new Object[0]);
      paramBundle = this.c;
      if (paramBundle != null) {
        paramBundle.a(this);
      }
    }
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = new RelativeLayout((Context)getActivity());
    paramLayoutInflater.setGravity(17);
    this.b = ((ViewGroup)paramLayoutInflater);
    paramLayoutInflater = (View)paramLayoutInflater;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    VasTestFragment.IVasTestFragment localIVasTestFragment = this.c;
    if (localIVasTestFragment != null) {
      localIVasTestFragment.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.test.VasTestFragment
 * JD-Core Version:    0.7.0.1
 */