package com.tencent.mobileqq.doutu.combo;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.doutu.IDoutuListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;

@TargetApi(11)
public class ComboUIManager
  implements Handler.Callback, View.OnTouchListener
{
  public BaseQQAppInterface a;
  public Activity b;
  public RelativeLayout c;
  Context d;
  Handler e = new WeakReferenceHandler(Looper.getMainLooper(), this);
  RelativeLayout f;
  ComboNavigateBar g;
  ComboMasterView h;
  ComboEggView i;
  public IDoutuListener j;
  private ComboObject k;
  private int l = 0;
  
  public ComboUIManager(BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity, IDoutuListener paramIDoutuListener, RelativeLayout paramRelativeLayout)
  {
    this.a = paramBaseQQAppInterface;
    this.b = paramActivity;
    this.c = paramRelativeLayout;
    this.d = paramRelativeLayout.getContext();
    this.j = paramIDoutuListener;
  }
  
  private void b(ComboObject paramComboObject)
  {
    if (this.g == null)
    {
      this.g = ((ComboNavigateBar)LayoutInflater.from(this.d).inflate(2131624082, null));
      this.g.a(this.a);
    }
    if (this.c.indexOfChild(this.g) == -1)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, Utils.a(32.0F, this.d.getResources()));
      localLayoutParams.addRule(11);
      localLayoutParams.topMargin = ((int)this.d.getResources().getDimension(2131299920) + Utils.a(22.0F, this.d.getResources()) + ImmersiveUtils.getStatusBarHeight(this.d));
      this.c.addView(this.g, localLayoutParams);
    }
    this.g.setInfo(paramComboObject);
  }
  
  private ComboMasterView c(ComboObject paramComboObject)
  {
    g();
    ComboMasterView localComboMasterView = (ComboMasterView)LayoutInflater.from(this.d).inflate(2131624081, null);
    localComboMasterView.a(this);
    if (localComboMasterView.a(paramComboObject))
    {
      paramComboObject = new RelativeLayout.LayoutParams(-1, -1);
      paramComboObject.addRule(13);
      this.f.addView(localComboMasterView, paramComboObject);
      localComboMasterView.a();
      return localComboMasterView;
    }
    b(paramComboObject);
    return null;
  }
  
  private ComboEggView d(ComboObject paramComboObject)
  {
    g();
    ComboEggView localComboEggView = (ComboEggView)LayoutInflater.from(this.d).inflate(2131624080, null);
    localComboEggView.a(this, this.a);
    if (localComboEggView.a(paramComboObject))
    {
      paramComboObject = new RelativeLayout.LayoutParams(-1, -1);
      paramComboObject.addRule(13);
      this.f.addView(localComboEggView, paramComboObject);
      localComboEggView.b();
      return localComboEggView;
    }
    b(paramComboObject);
    return null;
  }
  
  private void g()
  {
    if (this.f == null)
    {
      this.f = new RelativeLayout(this.d);
      this.f.setOnTouchListener(this);
    }
    FrameLayout localFrameLayout = (FrameLayout)this.b.getWindow().getDecorView();
    if (localFrameLayout.indexOfChild(this.f) == -1)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localFrameLayout.addView(this.f, localLayoutParams);
    }
  }
  
  private boolean h()
  {
    Object localObject = Runtime.getRuntime();
    long l1 = (((Runtime)localObject).totalMemory() - ((Runtime)localObject).freeMemory()) / 1048576L;
    long l2 = ((Runtime)localObject).maxMemory() / 1048576L;
    long l3 = l2 - l1;
    boolean bool;
    if (l3 < 10L) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" hasOOMDanger: ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" availHeapSizeInMB:");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(" maxHeapSizeInMB:");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(" usedMemInMB:");
      ((StringBuilder)localObject).append(l1);
      QLog.d("ComboUIManager", 2, ((StringBuilder)localObject).toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "ComboEggOOM", bool ^ true, l3, l1, null, "");
    return bool;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComboUIManager", 2, "uninit");
    }
    this.e.removeCallbacksAndMessages(null);
    c();
    f();
  }
  
  public void a(long paramLong)
  {
    this.e.sendEmptyMessageDelayed(12, paramLong);
  }
  
  public void a(Animator paramAnimator, ComboMasterView paramComboMasterView)
  {
    if (this.f != null)
    {
      paramAnimator = paramComboMasterView.a;
      if ((paramAnimator != null) && (this.k.b == paramAnimator.b)) {
        b(paramAnimator);
      }
      this.f.removeView(paramComboMasterView);
    }
    paramAnimator = this.j;
    if (paramAnimator != null) {
      paramAnimator.d();
    }
    this.h = null;
  }
  
  public void a(ComboEggView paramComboEggView)
  {
    if (this.f != null)
    {
      ComboObject localComboObject = paramComboEggView.f;
      if ((localComboObject != null) && (this.k.b == localComboObject.b)) {
        b(localComboObject);
      }
      this.f.removeView(paramComboEggView);
    }
    paramComboEggView = this.j;
    if (paramComboEggView != null) {
      paramComboEggView.d();
    }
    this.i = null;
  }
  
  public void a(ComboObject paramComboObject)
  {
    for (;;)
    {
      try
      {
        if (this.k != null)
        {
          int m = this.k.b;
          int n = paramComboObject.b;
          if (m >= n) {
            return;
          }
        }
        this.k = paramComboObject;
        Object localObject = this.e;
        bool = true;
        localObject = ((Handler)localObject).obtainMessage(1);
        ((Message)localObject).obj = paramComboObject;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("update  msg what:");
          localStringBuilder.append(((Message)localObject).what);
          localStringBuilder.append(" ");
          localStringBuilder.append(paramComboObject);
          QLog.d("ComboUIManager", 2, localStringBuilder.toString());
        }
        if (!paramComboObject.c) {
          ((Message)localObject).what = 1;
        } else if (ComboEggView.a(paramComboObject.b)) {
          ((Message)localObject).what = 3;
        } else if (paramComboObject.a.equals(this.a.getCurrentUin())) {
          ((Message)localObject).what = 2;
        } else {
          ((Message)localObject).what = 1;
        }
        if (QLog.isColorLevel())
        {
          paramComboObject = new StringBuilder();
          paramComboObject.append("update, mDoutuListener == null : ");
          if (this.j == null)
          {
            paramComboObject.append(bool);
            QLog.d("ComboUIManager", 2, paramComboObject.toString());
          }
        }
        else
        {
          if ((this.j != null) && (!this.j.b()) && (((Message)localObject).what < 11))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ComboUIManager", 2, "isTroopAioTipsShown");
            }
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ComboUIManager", 2, "update sendMessage");
          }
          this.e.sendMessageDelayed((Message)localObject, 0L);
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void b()
  {
    this.e.removeMessages(12);
  }
  
  public void c()
  {
    if (this.f != null)
    {
      localObject = (FrameLayout)this.b.getWindow().getDecorView();
      e();
      ((FrameLayout)localObject).removeView(this.f);
      this.f = null;
    }
    ComboResource.a();
    Object localObject = this.g;
    if (localObject != null)
    {
      RelativeLayout localRelativeLayout = this.c;
      if (localRelativeLayout != null) {
        localRelativeLayout.removeView((View)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ComboUIManager", 2, "clearViews, set mComboNavigateBar null");
      }
      this.g = null;
    }
  }
  
  public void d()
  {
    ComboObject localComboObject = e();
    if (localComboObject != null) {
      b(localComboObject);
    }
  }
  
  public ComboObject e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComboUIManager", 2, "clearAnimationView");
    }
    Object localObject = this.h;
    if (localObject != null)
    {
      ((ComboMasterView)localObject).a(this.f);
      localObject = new ComboObject(this.h.a.a, this.h.a.b);
      this.h = null;
      return localObject;
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((ComboEggView)localObject).a(this.f);
      localObject = new ComboObject(this.i.f.a, this.i.f.b);
      this.i = null;
      return localObject;
    }
    return null;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComboUIManager", 2, "removeListener");
    }
    this.j = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    ComboObject localComboObject = (ComboObject)paramMessage.obj;
    Object localObject1 = e();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[Doutu] + handleMessage : ");
      ((StringBuilder)localObject2).append(paramMessage.what);
      QLog.d("ComboUIManager", 2, ((StringBuilder)localObject2).toString());
    }
    int m = paramMessage.what;
    if (m != 1)
    {
      if ((m != 2) && (m != 3))
      {
        if (m != 11)
        {
          if (m != 12) {
            return true;
          }
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("[Doutu] + handleMessage : 12 ,mComboNavigateBar == null : ");
            boolean bool;
            if (this.g == null) {
              bool = true;
            } else {
              bool = false;
            }
            paramMessage.append(bool);
            QLog.d("ComboUIManager", 2, paramMessage.toString());
          }
          paramMessage = this.g;
          if (paramMessage != null) {
            paramMessage.a();
          }
          this.k = null;
          c();
          return true;
        }
        c();
        return true;
      }
      if (localComboObject.b > 999) {
        localComboObject.b = 999;
      }
      localObject2 = this.j;
      if ((localObject2 != null) && (!((IDoutuListener)localObject2).a()))
      {
        b(localComboObject);
        return true;
      }
      if (localObject1 != null) {
        b((ComboObject)localObject1);
      }
      localObject1 = this.j;
      if (localObject1 != null) {
        ((IDoutuListener)localObject1).c();
      }
      if (paramMessage.what == 2)
      {
        this.h = c(localComboObject);
        return true;
      }
      ReportController.b(this.a, "dc00898", "", "", "0X8008096", "0X8008096", 0, 0, "", "", "", "");
      if (h())
      {
        if (localComboObject.a.equals(this.a.getCurrentAccountUin()))
        {
          this.h = c(localComboObject);
          return true;
        }
        b(localComboObject);
        return true;
      }
      this.i = d(localComboObject);
      if (this.i == null)
      {
        b(localComboObject);
        return true;
      }
    }
    else
    {
      if (localComboObject.b > 999) {
        localComboObject.b = 999;
      }
      b(localComboObject);
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.h == null) && (this.i == null)) {
      return false;
    }
    d();
    paramView = this.j;
    if (paramView != null) {
      paramView.d();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboUIManager
 * JD-Core Version:    0.7.0.1
 */