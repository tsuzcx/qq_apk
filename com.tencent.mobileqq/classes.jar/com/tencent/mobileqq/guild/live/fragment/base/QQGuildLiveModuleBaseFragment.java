package com.tencent.mobileqq.guild.live.fragment.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.control.QQGuildLiveModuleControl;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class QQGuildLiveModuleBaseFragment
  extends QPublicBaseFragment
{
  protected ViewModelStoreOwner b;
  protected QQGuildLiveModuleControl c;
  
  protected void a() {}
  
  protected void a(@NonNull View paramView) {}
  
  public void a(@NonNull ViewModelStoreOwner paramViewModelStoreOwner)
  {
    this.b = paramViewModelStoreOwner;
  }
  
  public void a(QQGuildLiveModuleControl paramQQGuildLiveModuleControl)
  {
    this.c = paramQQGuildLiveModuleControl;
  }
  
  @LayoutRes
  protected abstract int b();
  
  protected void cs_() {}
  
  public void f()
  {
    if ((getActivity() != null) && (!getActivity().isFinishing()))
    {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 2130772130);
    }
  }
  
  public AppRuntime i()
  {
    return MobileQQ.sMobileQQ.peekAppRuntime();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = getChildFragmentManager().getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment instanceof QQGuildLiveModuleBaseFragment)) {
        ((QQGuildLiveModuleBaseFragment)localFragment).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(b(), paramViewGroup, false);
    a(paramLayoutInflater);
    cs_();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Iterator localIterator = getChildFragmentManager().getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment instanceof QQGuildLiveModuleBaseFragment)) {
        ((QQGuildLiveModuleBaseFragment)localFragment).onNewIntent(paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
 * JD-Core Version:    0.7.0.1
 */