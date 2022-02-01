package com.tencent.mobileqq.resourcesgrab;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import axbe;
import baky;
import balb;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;

public class ResourceGrabFragment
  extends LifeCycleFragment
{
  private balb jdField_a_of_type_Balb;
  private WeakReference<ResourceGrabView> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabFragment", 2, "doGrabResourceName");
    }
    View localView = getActivity().getWindow().getDecorView();
    this.jdField_a_of_type_Balb.a(localView, true);
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(ResourceGrabView paramResourceGrabView)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramResourceGrabView);
  }
  
  public void a(List<baky> paramList)
  {
    ResourceGrabView localResourceGrabView = (ResourceGrabView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localResourceGrabView != null) {
      localResourceGrabView.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Balb.a(paramList));
    }
  }
  
  public boolean a()
  {
    ResourceGrabView localResourceGrabView = (ResourceGrabView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    return (localResourceGrabView != null) && (localResourceGrabView.jdField_a_of_type_Boolean);
  }
  
  void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ThreadManager.getUIHandler().postDelayed(new ResourceGrabFragment.1(this), 200L);
      return;
    }
    e();
  }
  
  void c()
  {
    Object localObject = getActivity().getWindow().getDecorView();
    this.jdField_a_of_type_Balb.a((View)localObject, false);
    localObject = (ResourceGrabView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localObject != null) {
      ((ResourceGrabView)localObject).b();
    }
  }
  
  public void d()
  {
    View localView = getActivity().getWindow().getDecorView();
    this.jdField_a_of_type_Balb.a(localView, false);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Balb = ((balb)axbe.a(this).get(balb.class));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c();
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabFragment", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabFragment
 * JD-Core Version:    0.7.0.1
 */