package com.tencent.mobileqq.vas.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
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
  public static final VasTestFragment.Companion a;
  @Nullable
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private VasTestFragment.IVasTestFragment jdField_a_of_type_ComTencentMobileqqVasTestVasTestFragment$IVasTestFragment;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasTestVasTestFragment$Companion = new VasTestFragment.Companion(null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      paramBundle = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "activity");
      paramBundle = paramBundle.getIntent();
      String str = paramBundle.getStringExtra("apk_path");
      paramBundle = Class.forName(paramBundle.getStringExtra("class_path"), true, (ClassLoader)new PathClassLoader(str, getClass().getClassLoader())).newInstance();
      if (paramBundle == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.vas.test.VasTestFragment.IVasTestFragment");
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("VasTestFragment", 1, (Throwable)paramBundle, new Object[0]);
    }
    for (;;)
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqVasTestVasTestFragment$IVasTestFragment;
      if (paramBundle != null) {
        paramBundle.a(this);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqVasTestVasTestFragment$IVasTestFragment = ((VasTestFragment.IVasTestFragment)paramBundle);
    }
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @NotNull ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    paramLayoutInflater = new FrameLayout((Context)getActivity());
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater);
    paramLayoutInflater.setBackgroundColor(-1);
    paramLayoutInflater = (View)paramLayoutInflater;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    VasTestFragment.IVasTestFragment localIVasTestFragment = this.jdField_a_of_type_ComTencentMobileqqVasTestVasTestFragment$IVasTestFragment;
    if (localIVasTestFragment != null) {
      localIVasTestFragment.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.test.VasTestFragment
 * JD-Core Version:    0.7.0.1
 */