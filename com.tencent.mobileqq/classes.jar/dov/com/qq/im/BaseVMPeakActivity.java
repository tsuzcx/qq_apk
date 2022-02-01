package dov.com.qq.im;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BaseVMPeakActivity
  extends PeakActivity
  implements LifecycleOwner, ViewModelStoreOwner
{
  private LifecycleRegistry jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
  private ViewModelStore jdField_a_of_type_AndroidArchLifecycleViewModelStore;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public Lifecycle getLifecycle()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry;
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (BaseApplicationImpl.getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    if (this.jdField_a_of_type_AndroidArchLifecycleViewModelStore == null) {
      this.jdField_a_of_type_AndroidArchLifecycleViewModelStore = new ViewModelStore();
    }
    return this.jdField_a_of_type_AndroidArchLifecycleViewModelStore;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
      if ((this.jdField_a_of_type_AndroidArchLifecycleViewModelStore != null) && (!isChangingConfigurations())) {
        this.jdField_a_of_type_AndroidArchLifecycleViewModelStore.clear();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onStop()
  {
    super.onStop();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.BaseVMPeakActivity
 * JD-Core Version:    0.7.0.1
 */