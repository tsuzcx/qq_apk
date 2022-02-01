package com.tencent.mobileqq.mvvm;

import android.support.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.qphone.base.util.QLog;

public class LifeCycleDispatcher
  implements LifecycleOwner, ViewModelStoreOwner
{
  private LifecycleRegistry jdField_a_of_type_AndroidxLifecycleLifecycleRegistry = null;
  private ViewModelStore jdField_a_of_type_AndroidxLifecycleViewModelStore = null;
  
  private LifecycleRegistry a()
  {
    if (this.jdField_a_of_type_AndroidxLifecycleLifecycleRegistry == null) {
      this.jdField_a_of_type_AndroidxLifecycleLifecycleRegistry = new LifecycleRegistry(this);
    }
    return this.jdField_a_of_type_AndroidxLifecycleLifecycleRegistry;
  }
  
  private void a(Lifecycle.Event paramEvent)
  {
    try
    {
      a().handleLifecycleEvent(paramEvent);
      if (!QLog.isColorLevel()) {
        break label77;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dispatchLifeCycleEvent event -> ");
      localStringBuilder.append(paramEvent);
      QLog.d("LifeCycleDispatcher", 2, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder;
      label46:
      label77:
      break label46;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleLifecycleEvent fail : event -> ");
    localStringBuilder.append(paramEvent);
    QLog.e("LifeCycleDispatcher", 1, localStringBuilder.toString());
  }
  
  public void a()
  {
    a(Lifecycle.Event.ON_CREATE);
  }
  
  public void b()
  {
    a(Lifecycle.Event.ON_START);
  }
  
  public void c()
  {
    a(Lifecycle.Event.ON_RESUME);
  }
  
  public void d()
  {
    a(Lifecycle.Event.ON_PAUSE);
  }
  
  public void e()
  {
    a(Lifecycle.Event.ON_STOP);
  }
  
  public void f()
  {
    a(Lifecycle.Event.ON_DESTROY);
    getViewModelStore().clear();
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return a();
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (this.jdField_a_of_type_AndroidxLifecycleViewModelStore == null) {
      this.jdField_a_of_type_AndroidxLifecycleViewModelStore = new ViewModelStore();
    }
    return this.jdField_a_of_type_AndroidxLifecycleViewModelStore;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mvvm.LifeCycleDispatcher
 * JD-Core Version:    0.7.0.1
 */