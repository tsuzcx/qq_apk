package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.INearbyActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class TitlebarBaseFragment
  extends BaseFragment
{
  protected IphoneTitleBarActivity ag;
  protected int ah;
  protected boolean ai = false;
  protected TitlebarStatus aj;
  protected boolean ak = false;
  protected boolean al = false;
  protected View am;
  protected QQProgressNotifier an;
  
  public TitlebarBaseFragment()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new BaseFragment:");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" ");
      localStringBuilder.append(hashCode());
      QLog.i("Fragment", 2, localStringBuilder.toString());
    }
  }
  
  public boolean D()
  {
    return false;
  }
  
  public void E()
  {
    if ((getActivity() instanceof INearbyActivity)) {
      ((INearbyActivity)getActivity()).updateTitlebar(this.aj);
    }
  }
  
  public void dw_()
  {
    E();
    onHiddenChanged(false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageSelected() ");
      localStringBuilder.append(getClass().getSimpleName());
      QLog.d("Fragment", 2, localStringBuilder.toString());
    }
  }
  
  public void e() {}
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onActivityCreated() ");
      paramBundle.append(getClass().getSimpleName());
      paramBundle.append(" ");
      paramBundle.append(hashCode());
      QLog.d("Fragment", 2, paramBundle.toString());
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("NBase", 2, "onActivityResult() BaseFragment");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("onAttach() ");
      paramActivity.append(getClass().getSimpleName());
      paramActivity.append(" ");
      paramActivity.append(hashCode());
      QLog.d("Fragment", 2, paramActivity.toString());
    }
    if (this.aj == null) {
      this.aj = new TitlebarStatus(this);
    }
    this.ag = ((IphoneTitleBarActivity)getActivity());
    this.ai = true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate() ");
      paramBundle.append(getClass().getSimpleName());
      paramBundle.append(" ");
      paramBundle.append(hashCode());
      QLog.d("Fragment", 2, paramBundle.toString());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreateView() ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" ");
      localStringBuilder.append(hashCode());
      QLog.d("Fragment", 2, localStringBuilder.toString());
    }
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy() ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" ");
      localStringBuilder.append(hashCode());
      QLog.d("Fragment", 2, localStringBuilder.toString());
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.ak = false;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroyView() ");
      ((StringBuilder)localObject).append(getClass().getSimpleName());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(hashCode());
      QLog.d("Fragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.an;
    if (localObject != null) {
      ((QQProgressNotifier)localObject).b();
    }
    localObject = this.am;
    if (localObject != null)
    {
      localObject = (ViewGroup)((View)localObject).getParent();
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(this.am);
      }
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.ai = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDetach() ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" ");
      localStringBuilder.append(hashCode());
      QLog.d("Fragment", 2, localStringBuilder.toString());
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHiddenChanged() ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" ");
      localStringBuilder.append(hashCode());
      localStringBuilder.append(" hidden=");
      localStringBuilder.append(paramBoolean);
      QLog.d("Fragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      onPause();
      return;
    }
    onResume();
  }
  
  public void onPause()
  {
    super.onPause();
    this.al = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause() ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" ");
      localStringBuilder.append(hashCode());
      QLog.d("Fragment", 2, localStringBuilder.toString());
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.al = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume() ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" ");
      localStringBuilder.append(hashCode());
      QLog.d("Fragment", 2, localStringBuilder.toString());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStart() ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" ");
      localStringBuilder.append(hashCode());
      QLog.d("Fragment", 2, localStringBuilder.toString());
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStop() ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" ");
      localStringBuilder.append(hashCode());
      QLog.d("Fragment", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TitlebarBaseFragment
 * JD-Core Version:    0.7.0.1
 */