package dov.com.qq.im.ae.biz.qcircle.part.base;

import android.app.Fragment;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import java.util.List;

public abstract class AECircleBasePartFragment
  extends ReportFragment
  implements LifecycleOwner, ViewModelStoreOwner
{
  private LifecycleRegistry jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
  private ViewModelStore jdField_a_of_type_AndroidArchLifecycleViewModelStore;
  public View a;
  private AECirclePartManager jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager;
  
  protected abstract int a();
  
  public AECirclePartManager a()
  {
    return this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager;
  }
  
  protected abstract List<AECircleBasePart> a();
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager != null)
    {
      this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager.a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager.onActivityCreated(getActivity(), paramBundle);
    }
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
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager != null) {
      this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager != null) {
      this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager.a(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager = new AECirclePartManager(this, getView());
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager.a(a());
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    try
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(a(), paramViewGroup, false);
      a(paramLayoutInflater, paramViewGroup, paramBundle);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("BasePartFragment", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  @CallSuper
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
      this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager.onActivityDestroyed(getActivity());
      if (this.jdField_a_of_type_AndroidArchLifecycleViewModelStore != null) {
        this.jdField_a_of_type_AndroidArchLifecycleViewModelStore.clear();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
      this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager.onActivityPaused(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
      this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager.onActivityResumed(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
      this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager.onActivityStarted(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onStop()
  {
    super.onStop();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECirclePartManager.onActivityStopped(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.part.base.AECircleBasePartFragment
 * JD-Core Version:    0.7.0.1
 */