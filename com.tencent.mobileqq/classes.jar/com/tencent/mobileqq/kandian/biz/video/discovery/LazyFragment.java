package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseFragment;

public abstract class LazyFragment
  extends BaseFragment
{
  protected View a;
  protected LayoutInflater b;
  protected ViewGroup c;
  private boolean d = false;
  private Bundle e;
  private FrameLayout f;
  private boolean g = false;
  
  public abstract int a();
  
  public void a(int paramInt)
  {
    if ((h() != null) && (h().getParent() != null))
    {
      Object localObject = this.f;
      if (localObject != null)
      {
        localObject = this.b.inflate(paramInt, (ViewGroup)localObject, false);
        this.f.addView((View)localObject);
        return;
      }
    }
    this.a = this.b.inflate(paramInt, this.c, false);
  }
  
  protected void a(Bundle paramBundle)
  {
    if ((getUserVisibleHint()) && (!this.d))
    {
      this.d = true;
      this.e = paramBundle;
      b(this.e);
      return;
    }
    this.e = paramBundle;
    g();
  }
  
  protected void b() {}
  
  protected void b(Bundle paramBundle)
  {
    a(a());
    c(paramBundle);
  }
  
  protected void c() {}
  
  public abstract void c(Bundle paramBundle);
  
  protected void d() {}
  
  protected void e() {}
  
  protected void f() {}
  
  protected void g()
  {
    this.f = new FrameLayout(this.c.getContext());
    this.f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.a = this.f;
  }
  
  public View h()
  {
    return this.a;
  }
  
  public void i()
  {
    if ((!this.d) && (h() != null))
    {
      this.d = true;
      b(this.e);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.b = paramLayoutInflater;
    this.c = paramViewGroup;
    a(paramBundle);
    View localView = this.a;
    if (localView == null) {
      return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    }
    return localView;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.a = null;
    this.c = null;
    this.b = null;
    if (this.d) {
      f();
    }
    this.d = false;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.d) {
      d();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.d) {
      c();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.d) && (!this.g) && (getUserVisibleHint()))
    {
      this.g = true;
      b();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if ((this.d) && (this.g) && (getUserVisibleHint()))
    {
      this.g = false;
      e();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((paramBoolean) && (!this.d)) {
      i();
    }
    if ((this.d) && (h() != null))
    {
      if (paramBoolean)
      {
        this.g = true;
        b();
        c();
        return;
      }
      this.g = false;
      d();
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.LazyFragment
 * JD-Core Version:    0.7.0.1
 */