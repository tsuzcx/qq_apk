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
  private WeakReference<ResourceGrabView> a;
  private ResourceGrabViewModel b;
  private boolean c = false;
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabFragment", 2, "doGrabResourceName");
    }
    View localView = getBaseActivity().getWindow().getDecorView();
    this.b.a(localView, true);
    this.c = true;
  }
  
  void a()
  {
    if (!this.c)
    {
      ThreadManager.getUIHandler().postDelayed(new ResourceGrabFragment.1(this), 200L);
      return;
    }
    e();
  }
  
  void a(ResourceGrabView paramResourceGrabView)
  {
    this.a = new WeakReference(paramResourceGrabView);
  }
  
  void a(List<ResourceGrabSkinData> paramList)
  {
    ResourceGrabView localResourceGrabView = (ResourceGrabView)this.a.get();
    if (localResourceGrabView != null) {
      localResourceGrabView.b.setText(this.b.b(paramList));
    }
  }
  
  boolean b()
  {
    ResourceGrabView localResourceGrabView = (ResourceGrabView)this.a.get();
    return (localResourceGrabView != null) && (localResourceGrabView.a);
  }
  
  void c()
  {
    Object localObject = getBaseActivity().getWindow().getDecorView();
    this.b.a((View)localObject, false);
    localObject = (ResourceGrabView)this.a.get();
    if (localObject != null) {
      ((ResourceGrabView)localObject).b();
    }
  }
  
  void d()
  {
    View localView = getBaseActivity().getWindow().getDecorView();
    this.b.a(localView, false);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = ((ResourceGrabViewModel)ViewModelProviderHelper.a(this, ResourceGrabViewModel.a).get(ResourceGrabViewModel.class));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabFragment
 * JD-Core Version:    0.7.0.1
 */