package com.tencent.mobileqq.qqgamepub.mvp.presenter.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qqgamepub.mvp.model.base.IModel;
import com.tencent.mobileqq.qqgamepub.mvp.view.base.IView;
import java.lang.ref.WeakReference;

public abstract class BaseUIPresenter<V extends IView, M extends IModel>
  implements IPresenter<V>
{
  protected WeakReference<V> a;
  protected M b = a();
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }
  
  protected abstract M a();
  
  public void a(Activity paramActivity) {}
  
  public void a(Bundle paramBundle) {}
  
  public void a(V paramV)
  {
    this.a = new WeakReference(paramV);
  }
  
  public M b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    WeakReference localWeakReference = this.a;
    return (localWeakReference != null) && (localWeakReference.get() != null);
  }
  
  public void d()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference != null)
    {
      localWeakReference.clear();
      this.a = null;
    }
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public boolean j()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.base.BaseUIPresenter
 * JD-Core Version:    0.7.0.1
 */