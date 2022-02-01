package com.tencent.mobileqq.qqgift.mvvm.business.anim;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.callback.IQQGiftEngineAnimationListener;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftAnimationView;
import com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPAGAnimationViewImpl;
import com.tencent.mobileqq.qqgift.mvvm.business.view.builder.IQQGiftAnimationViewBuilder;
import com.tencent.mobileqq.qqgift.utils.PagLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

abstract class BaseGiftAnimationEngine
  implements IQQGiftAnimationEngine
{
  protected QQGiftView a;
  protected CopyOnWriteArrayList<IQQGiftAnimationViewBuilder> b = new CopyOnWriteArrayList();
  protected IQQGiftSDK c;
  protected Context d;
  protected volatile boolean e = false;
  protected volatile boolean f = true;
  protected final List<IQQGiftEngineAnimationListener> g = new ArrayList();
  
  public BaseGiftAnimationEngine(Context paramContext, IQQGiftSDK paramIQQGiftSDK)
  {
    this.d = paramContext;
    this.c = paramIQQGiftSDK;
  }
  
  public IQQGiftAnimationView a(GiftAnimData paramGiftAnimData)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      IQQGiftAnimationView localIQQGiftAnimationView = ((IQQGiftAnimationViewBuilder)localIterator.next()).a(this.d, paramGiftAnimData);
      if (localIQQGiftAnimationView != null) {
        return localIQQGiftAnimationView;
      }
    }
    return null;
  }
  
  public void a()
  {
    QQGiftPAGAnimationViewImpl.a.a(this.d, null);
    this.a = new QQGiftView(this.d, this);
    this.a.setVisibility(4);
    this.b.add(new BaseGiftAnimationEngine.1(this));
    this.b.add(new BaseGiftAnimationEngine.2(this));
    this.f = false;
  }
  
  public void a(IQQGiftEngineAnimationListener paramIQQGiftEngineAnimationListener)
  {
    if ((paramIQQGiftEngineAnimationListener != null) && (!this.g.contains(paramIQQGiftEngineAnimationListener))) {
      this.g.add(paramIQQGiftEngineAnimationListener);
    }
  }
  
  public IQQGiftSDK b()
  {
    return this.c;
  }
  
  public void b(IQQGiftEngineAnimationListener paramIQQGiftEngineAnimationListener)
  {
    this.g.remove(paramIQQGiftEngineAnimationListener);
  }
  
  public void b(GiftAnimData paramGiftAnimData)
  {
    a(paramGiftAnimData, -1);
  }
  
  public void c()
  {
    this.f = true;
    QQGiftView localQQGiftView = this.a;
    if (localQQGiftView != null)
    {
      localQQGiftView.b();
      this.a = null;
    }
    this.g.clear();
    this.b.clear();
    this.d = null;
  }
  
  public View d()
  {
    return e();
  }
  
  public View e()
  {
    return this.a;
  }
  
  public View f()
  {
    return null;
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.anim.BaseGiftAnimationEngine
 * JD-Core Version:    0.7.0.1
 */