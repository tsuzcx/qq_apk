package com.tencent.qcircle.shadow.core.runtime;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.View;

public class PluginFragmentTransaction
{
  final FragmentTransaction mBase;
  final PluginFragmentManager mPluginFragmentManager;
  
  PluginFragmentTransaction(PluginFragmentManager paramPluginFragmentManager, FragmentTransaction paramFragmentTransaction)
  {
    this.mPluginFragmentManager = paramPluginFragmentManager;
    this.mBase = paramFragmentTransaction;
  }
  
  private Fragment getContainerFragment(ShadowFragment paramShadowFragment)
  {
    return paramShadowFragment.getContainerFragment().asFragment();
  }
  
  public PluginFragmentTransaction add(int paramInt, ShadowFragment paramShadowFragment)
  {
    this.mBase.add(paramInt, getContainerFragment(paramShadowFragment));
    return this;
  }
  
  public PluginFragmentTransaction add(int paramInt, ShadowFragment paramShadowFragment, String paramString)
  {
    this.mBase.add(paramInt, getContainerFragment(paramShadowFragment), paramString);
    return this;
  }
  
  public PluginFragmentTransaction add(ShadowFragment paramShadowFragment, String paramString)
  {
    this.mBase.add(getContainerFragment(paramShadowFragment), paramString);
    return this;
  }
  
  @TargetApi(21)
  public PluginFragmentTransaction addSharedElement(View paramView, String paramString)
  {
    this.mBase.addSharedElement(paramView, paramString);
    return this;
  }
  
  public PluginFragmentTransaction addToBackStack(String paramString)
  {
    this.mBase.addToBackStack(paramString);
    return this;
  }
  
  public PluginFragmentTransaction attach(ShadowFragment paramShadowFragment)
  {
    this.mBase.attach(getContainerFragment(paramShadowFragment));
    return this;
  }
  
  public int commit()
  {
    return this.mBase.commit();
  }
  
  public int commitAllowingStateLoss()
  {
    return this.mBase.commitAllowingStateLoss();
  }
  
  @TargetApi(24)
  public void commitNow()
  {
    this.mBase.commitNow();
  }
  
  @TargetApi(24)
  public void commitNowAllowingStateLoss()
  {
    this.mBase.commitNowAllowingStateLoss();
  }
  
  public PluginFragmentTransaction detach(ShadowFragment paramShadowFragment)
  {
    this.mBase.detach(getContainerFragment(paramShadowFragment));
    return this;
  }
  
  public PluginFragmentTransaction disallowAddToBackStack()
  {
    this.mBase.disallowAddToBackStack();
    return this;
  }
  
  public PluginFragmentTransaction hide(ShadowFragment paramShadowFragment)
  {
    this.mBase.hide(getContainerFragment(paramShadowFragment));
    return this;
  }
  
  public boolean isAddToBackStackAllowed()
  {
    return this.mBase.isAddToBackStackAllowed();
  }
  
  public boolean isEmpty()
  {
    return this.mBase.isEmpty();
  }
  
  public PluginFragmentTransaction remove(ShadowFragment paramShadowFragment)
  {
    this.mBase.remove(getContainerFragment(paramShadowFragment));
    return this;
  }
  
  public PluginFragmentTransaction replace(int paramInt, ShadowFragment paramShadowFragment)
  {
    this.mBase.replace(paramInt, getContainerFragment(paramShadowFragment));
    return this;
  }
  
  public PluginFragmentTransaction replace(int paramInt, ShadowFragment paramShadowFragment, String paramString)
  {
    this.mBase.replace(paramInt, getContainerFragment(paramShadowFragment), paramString);
    return this;
  }
  
  @TargetApi(26)
  public PluginFragmentTransaction runOnCommit(Runnable paramRunnable)
  {
    this.mBase.runOnCommit(paramRunnable);
    return this;
  }
  
  public PluginFragmentTransaction setBreadCrumbShortTitle(int paramInt)
  {
    this.mBase.setBreadCrumbShortTitle(paramInt);
    return this;
  }
  
  public PluginFragmentTransaction setBreadCrumbShortTitle(CharSequence paramCharSequence)
  {
    this.mBase.setBreadCrumbShortTitle(paramCharSequence);
    return this;
  }
  
  public PluginFragmentTransaction setBreadCrumbTitle(int paramInt)
  {
    this.mBase.setBreadCrumbTitle(paramInt);
    return this;
  }
  
  public PluginFragmentTransaction setBreadCrumbTitle(CharSequence paramCharSequence)
  {
    this.mBase.setBreadCrumbTitle(paramCharSequence);
    return this;
  }
  
  public PluginFragmentTransaction setCustomAnimations(int paramInt1, int paramInt2)
  {
    this.mBase.setCustomAnimations(paramInt1, paramInt2);
    return this;
  }
  
  public PluginFragmentTransaction setCustomAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mBase.setCustomAnimations(paramInt1, paramInt2, paramInt3, paramInt4);
    return this;
  }
  
  @TargetApi(26)
  public PluginFragmentTransaction setPrimaryNavigationFragment(ShadowFragment paramShadowFragment)
  {
    this.mBase.setPrimaryNavigationFragment(getContainerFragment(paramShadowFragment));
    return this;
  }
  
  @TargetApi(26)
  public PluginFragmentTransaction setReorderingAllowed(boolean paramBoolean)
  {
    this.mBase.setReorderingAllowed(paramBoolean);
    return this;
  }
  
  public PluginFragmentTransaction setTransition(int paramInt)
  {
    this.mBase.setTransition(paramInt);
    return this;
  }
  
  public PluginFragmentTransaction setTransitionStyle(int paramInt)
  {
    this.mBase.setTransitionStyle(paramInt);
    return this;
  }
  
  public PluginFragmentTransaction show(ShadowFragment paramShadowFragment)
  {
    this.mBase.show(getContainerFragment(paramShadowFragment));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.PluginFragmentTransaction
 * JD-Core Version:    0.7.0.1
 */