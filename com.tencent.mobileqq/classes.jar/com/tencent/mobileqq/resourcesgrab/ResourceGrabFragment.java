package com.tencent.mobileqq.resourcesgrab;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;

public class ResourceGrabFragment
  extends LifeCycleFragment
{
  private ResourceGrabViewModel jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabViewModel;
  private WeakReference<ResourceGrabView> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabFragment", 2, "doGrabResourceName");
    }
    View localView = getBaseActivity().getWindow().getDecorView();
    this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabViewModel.a(localView, true);
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ThreadManager.getUIHandler().postDelayed(new ResourceGrabFragment.1(this), 200L);
      return;
    }
    d();
  }
  
  void a(ResourceGrabView paramResourceGrabView)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramResourceGrabView);
  }
  
  void a(List<ResourceGrabSkinData> paramList)
  {
    ResourceGrabView localResourceGrabView = (ResourceGrabView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localResourceGrabView != null) {
      localResourceGrabView.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabViewModel.a(paramList));
    }
  }
  
  boolean a()
  {
    ResourceGrabView localResourceGrabView = (ResourceGrabView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    return (localResourceGrabView != null) && (localResourceGrabView.jdField_a_of_type_Boolean);
  }
  
  void b()
  {
    Object localObject = getBaseActivity().getWindow().getDecorView();
    this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabViewModel.a((View)localObject, false);
    localObject = (ResourceGrabView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localObject != null) {
      ((ResourceGrabView)localObject).b();
    }
  }
  
  void c()
  {
    View localView = getBaseActivity().getWindow().getDecorView();
    this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabViewModel.a(localView, false);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabViewModel = ((ResourceGrabViewModel)ViewModelProviderHelper.a(this, ResourceGrabViewModel.a).get(ResourceGrabViewModel.class));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b();
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabFragment", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabFragment
 * JD-Core Version:    0.7.0.1
 */