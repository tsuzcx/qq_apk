package com.tencent.mobileqq.extendfriend.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;

public class ExtendFriendBaseFragment2
  extends PublicBaseFragment
  implements LifecycleOwner, ViewModelStoreOwner
{
  private LifecycleRegistry jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
  private ViewModelStore jdField_a_of_type_AndroidArchLifecycleViewModelStore = new ViewModelStore();
  
  private void a(Lifecycle.Event paramEvent)
  {
    if (this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry == null) {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
    }
    a(paramEvent.toString());
    this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(paramEvent);
  }
  
  private void a(String paramString) {}
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    if (this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry == null) {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
    }
    return this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry;
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleViewModelStore;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(Lifecycle.Event.ON_CREATE);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a(Lifecycle.Event.ON_DESTROY);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (localFragmentActivity.isChangingConfigurations())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_AndroidArchLifecycleViewModelStore.clear();
      }
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    a(Lifecycle.Event.ON_PAUSE);
  }
  
  public void onResume()
  {
    super.onResume();
    a(Lifecycle.Event.ON_RESUME);
  }
  
  public void onStart()
  {
    super.onStart();
    a(Lifecycle.Event.ON_START);
  }
  
  public void onStop()
  {
    super.onStop();
    a(Lifecycle.Event.ON_STOP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.base.ExtendFriendBaseFragment2
 * JD-Core Version:    0.7.0.1
 */