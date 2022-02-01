package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqexpand.widget.FillBirthdayDialog;
import com.tencent.mobileqq.qqexpand.widget.FillBirthdayDialog.OnConfirmListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/fragment/ExpandBirthPickFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "Companion", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandBirthPickFragment
  extends QPublicBaseFragment
{
  public static final ExpandBirthPickFragment.Companion a;
  private HashMap a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandBirthPickFragment$Companion = new ExpandBirthPickFragment.Companion(null);
  }
  
  public void a()
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = new FrameLayout((Context)getQBaseActivity());
    int i = 0;
    paramLayoutInflater.setBackgroundColor(0);
    if (getQBaseActivity().mSystemBarComp == null)
    {
      getQBaseActivity().setImmersiveStatus(0);
    }
    else
    {
      getQBaseActivity().mSystemBarComp.setStatusBarDrawable(null);
      getQBaseActivity().mSystemBarComp.setStatusBarColor(0);
      getQBaseActivity().mSystemBarComp.setStatusColor(0);
    }
    paramViewGroup = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "qBaseActivity");
    paramViewGroup = (Context)paramViewGroup;
    paramBundle = getArguments();
    if (paramBundle != null) {
      i = paramBundle.getInt("birth_date", 0);
    }
    paramViewGroup = new FillBirthdayDialog(paramViewGroup, i, (FillBirthdayDialog.OnConfirmListener)new ExpandBirthPickFragment.onCreateView.fillBirthdayDialog.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("ExpandBirthPickFragment", 2, "showFillBirthdayDialog do show");
    }
    paramViewGroup.show();
    return (View)paramLayoutInflater;
  }
  
  public void onPause()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.overridePendingTransition(0, 0);
    }
    super.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandBirthPickFragment
 * JD-Core Version:    0.7.0.1
 */