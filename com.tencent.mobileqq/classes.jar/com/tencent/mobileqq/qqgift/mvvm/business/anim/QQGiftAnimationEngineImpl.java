package com.tencent.mobileqq.qqgift.mvvm.business.anim;

import android.content.Context;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.callback.IQQGiftEngineAnimationListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class QQGiftAnimationEngineImpl
  extends BaseGiftAnimationEngine
{
  private final Vector<GiftAnimData> h = new Vector();
  private final IQQGiftEngineAnimationListener i = new QQGiftAnimationEngineImpl.1(this);
  
  public QQGiftAnimationEngineImpl(Context paramContext, IQQGiftSDK paramIQQGiftSDK)
  {
    super(paramContext, paramIQQGiftSDK);
  }
  
  private void b(GiftAnimData paramGiftAnimData, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.h.size()))
    {
      this.h.add(paramInt, paramGiftAnimData);
      return;
    }
    this.h.add(paramGiftAnimData);
  }
  
  private void h()
  {
    try
    {
      boolean bool = this.f;
      if (bool) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("playNext size is ");
      ((StringBuilder)localObject1).append(this.h.size());
      QLog.i("QQGiftAnimationEngineImpl", 1, ((StringBuilder)localObject1).toString());
      if (this.h.size() > 0)
      {
        localObject1 = (GiftAnimData)this.h.remove(0);
        if (localObject1 != null)
        {
          this.a.a((GiftAnimData)localObject1);
          return;
        }
      }
      this.a.setVisibility(4);
      this.e = false;
      return;
    }
    finally {}
  }
  
  public void a()
  {
    super.a();
    this.a.a(this.i);
  }
  
  public void a(GiftAnimData paramGiftAnimData, int paramInt)
  {
    try
    {
      boolean bool = this.f;
      if (bool) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addGiftAnimation isPlaying is ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" curSize is ");
      localStringBuilder.append(this.h.size());
      QLog.i("QQGiftAnimationEngineImpl", 1, localStringBuilder.toString());
      if (!this.e)
      {
        this.e = true;
        this.a.a(paramGiftAnimData);
      }
      else
      {
        b(paramGiftAnimData, paramInt);
      }
      return;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      QLog.d("QQGiftAnimationEngineImpl", 1, "release engine");
      super.c();
      this.h.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.anim.QQGiftAnimationEngineImpl
 * JD-Core Version:    0.7.0.1
 */