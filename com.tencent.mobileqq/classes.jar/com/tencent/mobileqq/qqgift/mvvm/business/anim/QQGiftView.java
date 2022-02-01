package com.tencent.mobileqq.qqgift.mvvm.business.anim;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationListener;
import com.tencent.mobileqq.qqgift.callback.IQQGiftEngineAnimationListener;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftAnimationView;
import com.tencent.mobileqq.qqgift.utils.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class QQGiftView
  extends FrameLayout
{
  private final IQQGiftAnimationEngine a;
  private IQQGiftEngineAnimationListener b;
  private GiftAnimData c = null;
  private QQGiftView.CheckTimeOutRunnable d = null;
  private final IQQGiftAnimationListener e = new QQGiftView.1(this);
  private IQQGiftAnimationView f;
  private final IQQGiftResDownloadModule g;
  
  public QQGiftView(Context paramContext, IQQGiftAnimationEngine paramIQQGiftAnimationEngine)
  {
    super(paramContext);
    this.a = paramIQQGiftAnimationEngine;
    this.g = paramIQQGiftAnimationEngine.b().g();
  }
  
  private void a(GiftAnimData paramGiftAnimData, QQGiftView.QQGiftAnimationResDownloadCallback paramQQGiftAnimationResDownloadCallback)
  {
    if (paramGiftAnimData != null) {}
    try
    {
      if (paramGiftAnimData == this.c)
      {
        if (paramQQGiftAnimationResDownloadCallback != null) {
          QQGiftView.QQGiftAnimationResDownloadCallback.a(paramQQGiftAnimationResDownloadCallback, true);
        }
        paramQQGiftAnimationResDownloadCallback = new StringBuilder();
        paramQQGiftAnimationResDownloadCallback.append("load ");
        paramQQGiftAnimationResDownloadCallback.append(paramGiftAnimData.d);
        paramQQGiftAnimationResDownloadCallback.append(" timeOut");
        QLog.e("QQGiftView", 1, paramQQGiftAnimationResDownloadCallback.toString());
        if (this.b != null) {
          this.b.onAnimationEnd(paramGiftAnimData);
        }
        return;
      }
      QLog.e("QQGiftView", 1, "checkDownload data is match");
      return;
    }
    finally {}
  }
  
  private void a(String paramString, GiftAnimData paramGiftAnimData)
  {
    try
    {
      if (paramGiftAnimData != this.c)
      {
        paramString = new StringBuilder();
        paramString.append(paramGiftAnimData.d);
        paramString.append(": onLoadSuccess but data is not match");
        QLog.e("QQGiftView", 1, paramString.toString());
        return;
      }
      d();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[playAnimation] ");
        localStringBuilder.append(paramGiftAnimData.d);
        localStringBuilder.append(" giftPath is ");
        localStringBuilder.append(paramString);
        QLog.d("QQGiftView", 1, localStringBuilder.toString());
      }
      this.f.a(paramString);
      return;
    }
    finally {}
  }
  
  private void b(GiftAnimData paramGiftAnimData)
  {
    try
    {
      this.c = paramGiftAnimData;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playAnimation type is ");
        localStringBuilder.append(paramGiftAnimData.b);
        localStringBuilder.append(" level:");
        localStringBuilder.append(paramGiftAnimData.m);
        QLog.i("QQGiftView", 1, localStringBuilder.toString());
      }
      c(paramGiftAnimData);
      if (this.f == null)
      {
        QLog.e("QQGiftView", 1, "giftAnimationView is null and called onAnimationEnd callback");
        if (this.b != null) {
          this.b.onAnimationEnd(paramGiftAnimData);
        }
        return;
      }
      d(paramGiftAnimData);
      e(paramGiftAnimData);
      return;
    }
    finally {}
  }
  
  private void b(String paramString, GiftAnimData paramGiftAnimData)
  {
    try
    {
      if (paramGiftAnimData != this.c)
      {
        paramString = new StringBuilder();
        paramString.append(paramGiftAnimData.d);
        paramString.append(": onLoadFailed and data is not match");
        QLog.e("QQGiftView", 1, paramString.toString());
        return;
      }
      d();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[playAnimation] load ");
      localStringBuilder.append(paramGiftAnimData.d);
      localStringBuilder.append(" gift failed ");
      localStringBuilder.append(paramString);
      QLog.e("QQGiftView", 1, localStringBuilder.toString());
      if (this.b != null) {
        this.b.onAnimationEnd(paramGiftAnimData);
      }
      return;
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      if (this.f != null) {
        this.f.a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(GiftAnimData paramGiftAnimData)
  {
    paramGiftAnimData = this.a.a(paramGiftAnimData);
    if (this.f != paramGiftAnimData)
    {
      removeAllViews();
      this.f = paramGiftAnimData;
      paramGiftAnimData = this.f;
      if (paramGiftAnimData != null)
      {
        paramGiftAnimData.a(this.e);
        addView(this.f.b());
      }
    }
  }
  
  private void d()
  {
    QQGiftView.CheckTimeOutRunnable localCheckTimeOutRunnable = this.d;
    if (localCheckTimeOutRunnable != null)
    {
      QQGiftView.CheckTimeOutRunnable.a(localCheckTimeOutRunnable, null);
      ThreadManager.b(this.d);
    }
  }
  
  private void d(GiftAnimData paramGiftAnimData)
  {
    this.f.b().setLayoutParams(this.f.a(paramGiftAnimData));
  }
  
  private void e(GiftAnimData paramGiftAnimData)
  {
    d();
    QQGiftView.QQGiftAnimationResDownloadCallback localQQGiftAnimationResDownloadCallback = new QQGiftView.QQGiftAnimationResDownloadCallback(this, paramGiftAnimData);
    this.d = new QQGiftView.CheckTimeOutRunnable(this, paramGiftAnimData, localQQGiftAnimationResDownloadCallback);
    ThreadManager.a(this.d, 15000L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[playAnimation] materialId is ");
      localStringBuilder.append(paramGiftAnimData.d);
      QLog.i("QQGiftView", 1, localStringBuilder.toString());
    }
    this.g.a(paramGiftAnimData.d, localQQGiftAnimationResDownloadCallback);
  }
  
  public void a()
  {
    QLog.i("QQGiftView", 1, "stop");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      c();
      return;
    }
    ThreadManager.a(new QQGiftView.3(this));
  }
  
  public void a(IQQGiftEngineAnimationListener paramIQQGiftEngineAnimationListener)
  {
    this.b = paramIQQGiftEngineAnimationListener;
  }
  
  public void a(GiftAnimData paramGiftAnimData)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramGiftAnimData);
      return;
    }
    ThreadManager.a(new QQGiftView.2(this, paramGiftAnimData));
  }
  
  public void b()
  {
    d();
    this.b = null;
    if ((getParent() instanceof ViewGroup)) {
      ((ViewGroup)getParent()).removeView(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.anim.QQGiftView
 * JD-Core Version:    0.7.0.1
 */