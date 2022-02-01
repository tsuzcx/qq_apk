package com.tencent.qcircle.shadow.core.runtime;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract interface IContainerFragment
{
  public abstract Fragment asFragment();
  
  public abstract void bindPluginFragment(ShadowFragment paramShadowFragment);
  
  public abstract Activity getActivity();
  
  public abstract Bundle getArguments();
  
  public abstract FragmentManager getChildFragmentManager();
  
  public abstract Context getContext();
  
  public abstract int getId();
  
  public abstract ShadowFragment getPluginFragment();
  
  public abstract String getTag();
  
  public abstract boolean getUserVisibleHint();
  
  public abstract View getView();
  
  public abstract boolean isAdded();
  
  public abstract boolean isDetached();
  
  public abstract boolean isHidden();
  
  public abstract boolean isInLayout();
  
  public abstract boolean isRemoving();
  
  public abstract boolean isResumed();
  
  public abstract boolean isVisible();
  
  public abstract void requestPermissions(String[] paramArrayOfString, int paramInt);
  
  public abstract void setArguments(Bundle paramBundle);
  
  public abstract void superOnHiddenChanged(boolean paramBoolean);
  
  public abstract void superSetHasOptionsMenu(boolean paramBoolean);
  
  public abstract void superSetMenuVisibility(boolean paramBoolean);
  
  public abstract void superSetRetainInstance(boolean paramBoolean);
  
  public abstract void superSetUserVisibleHint(boolean paramBoolean);
  
  public abstract void unbindPluginFragment();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.IContainerFragment
 * JD-Core Version:    0.7.0.1
 */