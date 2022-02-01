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
  private LifecycleRegistry a = null;
  private ViewModelStore b = null;
  
  private void a(Lifecycle.Event paramEvent)
  {
    try
    {
      g().handleLifecycleEvent(paramEvent);
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
  
  private LifecycleRegistry g()
  {
    if (this.a == null) {
      this.a = new LifecycleRegistry(this);
    }
    return this.a;
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
    return g();
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (this.b == null) {
      this.b = new ViewModelStore();
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mvvm.LifeCycleDispatcher
 * JD-Core Version:    0.7.0.1
 */