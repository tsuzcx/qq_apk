package com.tencent.mobileqq.qqgift.mvvm.business.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationListener;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.mobileqq.qqgift.utils.PagLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.libpag.PAGFile;
import org.libpag.PAGView;

public class QQGiftPAGAnimationViewImpl
  implements IQQGiftAnimationView
{
  public static PagLoader a = new PagLoader();
  private IQQGiftAnimationListener b = null;
  private PAGView c;
  private View d;
  private final Context e;
  private String f = "";
  
  public QQGiftPAGAnimationViewImpl(Context paramContext)
  {
    this.e = paramContext;
    e();
  }
  
  private void a(PAGFile paramPAGFile)
  {
    Object localObject = this.c;
    ViewGroup.LayoutParams localLayoutParams = null;
    if (localObject != null)
    {
      localLayoutParams = ((PAGView)localObject).getLayoutParams();
    }
    else
    {
      localObject = this.d;
      if (localObject != null) {
        localLayoutParams = ((View)localObject).getLayoutParams();
      } else {
        localObject = null;
      }
    }
    if (localLayoutParams == null) {
      return;
    }
    if ((localLayoutParams.height == -2) && (localLayoutParams.width == -2))
    {
      float f1 = paramPAGFile.width();
      float f2 = paramPAGFile.height();
      if ((f1 != 0.0F) && (f2 != 0.0F))
      {
        localLayoutParams.width = -1;
        localLayoutParams.height = ((int)(ImmersiveUtils.getScreenWidth() * f2 / f1));
        ((View)localObject).setLayoutParams(localLayoutParams);
        return;
      }
      paramPAGFile = new StringBuilder();
      paramPAGFile.append("adjustLayout width::");
      paramPAGFile.append(f1);
      paramPAGFile.append(" height::");
      paramPAGFile.append(f2);
      QLog.e("QQGiftPAGAnimationViewImpl", 1, paramPAGFile.toString());
    }
  }
  
  private void c()
  {
    this.c = new PAGView(this.e);
    this.c.setScaleMode(3);
    this.c.addListener(new QQGiftPAGAnimationViewImpl.1(this));
    d();
  }
  
  private void d()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((View)localObject).getParent() == null) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("change placeHolderView to PagView currentPath is ");
      ((StringBuilder)localObject).append(this.f);
      QLog.i("QQGiftPAGAnimationViewImpl", 1, ((StringBuilder)localObject).toString());
      localObject = (ViewGroup)this.d.getParent();
      ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
      ((ViewGroup)localObject).removeView(this.d);
      ((ViewGroup)localObject).addView(this.c, localLayoutParams);
      this.d = null;
      if (!TextUtils.isEmpty(this.f)) {
        a(this.f);
      }
    }
  }
  
  private void e()
  {
    if (a.a())
    {
      c();
      return;
    }
    QLog.i("QQGiftPAGAnimationViewImpl", 1, "pag is not loaded waiting loading");
    f();
  }
  
  private void f()
  {
    a.a(this.e, new QQGiftPAGAnimationViewImpl.2(this));
  }
  
  public FrameLayout.LayoutParams a(GiftAnimData paramGiftAnimData)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    if ((paramGiftAnimData.b == 1) && (paramGiftAnimData.m == 1))
    {
      localLayoutParams.gravity = 80;
      return localLayoutParams;
    }
    int i = paramGiftAnimData.m;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return localLayoutParams;
        }
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        return localLayoutParams;
      }
      localLayoutParams.width = -1;
      double d1 = ImmersiveUtils.getScreenWidth();
      Double.isNaN(d1);
      localLayoutParams.height = ((int)(d1 * 1.2D));
      localLayoutParams.gravity = 80;
      return localLayoutParams;
    }
    localLayoutParams.width = ImmersiveUtils.dpToPx(250.0F);
    localLayoutParams.height = ImmersiveUtils.dpToPx(250.0F);
    localLayoutParams.gravity = 81;
    localLayoutParams.bottomMargin = ImmersiveUtils.dpToPx(100.0F);
    return localLayoutParams;
  }
  
  public void a()
  {
    try
    {
      if ((this.c != null) && (this.c.isPlaying()))
      {
        this.c.stop();
      }
      else
      {
        this.f = "";
        if (this.b != null) {
          this.b.b();
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(IQQGiftAnimationListener paramIQQGiftAnimationListener)
  {
    this.b = paramIQQGiftAnimationListener;
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.c != null)
      {
        paramString = PAGFile.Load(paramString);
        if (paramString == null)
        {
          if (this.b != null) {
            this.b.b();
          }
          return;
        }
        a(paramString);
        this.c.setComposition(paramString);
        this.c.setProgress(0.0D);
        this.c.play();
      }
      else
      {
        this.f = paramString;
      }
      return;
    }
    finally {}
  }
  
  public View b()
  {
    PAGView localPAGView = this.c;
    Object localObject = localPAGView;
    if (localPAGView == null)
    {
      if (this.d == null) {
        this.d = new View(this.e);
      }
      QLog.i("QQGiftPAGAnimationViewImpl", 1, "waiting loadPag so return placeholderView");
      localObject = this.d;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPAGAnimationViewImpl
 * JD-Core Version:    0.7.0.1
 */