package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPAGAnimationViewImpl;
import com.tencent.mobileqq.qqgift.utils.PagLoader;
import com.tencent.qphone.base.util.QLog;

public class GiftBannerContainer
  extends FrameLayout
  implements BannerAnimListener
{
  private final BaseBannerView a;
  private BaseBannerView b;
  private BaseBannerView c;
  private int d = 0;
  private GiftAnimData e;
  private final BannerResManager f;
  private GiftBannerContainerListener g;
  private final Object h = new Object();
  
  public GiftBannerContainer(@NonNull Context paramContext, BannerResManager paramBannerResManager)
  {
    super(paramContext);
    this.f = paramBannerResManager;
    this.a = new DefaultBannerView(paramContext, paramBannerResManager);
    addView(this.a);
    this.a.setVisibility(8);
  }
  
  private void a(GiftAnimData paramGiftAnimData)
  {
    this.f.a(paramGiftAnimData.d, null);
  }
  
  private void a(GiftAnimData paramGiftAnimData, String paramString, int paramInt)
  {
    GiftBannerContainerListener localGiftBannerContainerListener = this.g;
    if (localGiftBannerContainerListener != null) {
      localGiftBannerContainerListener.h();
    }
    this.c.setVisibility(0);
    this.c.a(paramGiftAnimData, paramString);
    this.c.b(paramInt);
    paramString = ValueAnimator.ofInt(new int[] { getWidth(), 0 });
    paramString.setDuration(200L);
    paramString.setInterpolator(new DecelerateInterpolator());
    paramString.addUpdateListener(new GiftBannerContainer.1(this));
    paramString.addListener(new GiftBannerContainer.2(this, paramGiftAnimData));
    paramString.start();
  }
  
  public void a()
  {
    synchronized (this.h)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("stop playStatus is ");
      ((StringBuilder)localObject2).append(this.d);
      QLog.i("Gift_Banner_Container", 1, ((StringBuilder)localObject2).toString());
      if ((this.c != null) && (this.d != 0) && (this.d != 3))
      {
        localObject2 = this.e;
        this.e = null;
        this.c.b();
        this.c.clearAnimation();
        this.d = 2;
        if (this.g != null) {
          this.g.b((GiftAnimData)localObject2, this.c.a.getNum());
        }
      }
      return;
    }
  }
  
  public void a(GiftAnimData paramGiftAnimData, int paramInt)
  {
    synchronized (this.h)
    {
      boolean bool = this.f.b(paramGiftAnimData.d);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play isResExit ");
      localStringBuilder.append(bool);
      localStringBuilder.append(" pagIsLoad:");
      localStringBuilder.append(QQGiftPAGAnimationViewImpl.a.a());
      QLog.i("Gift_Banner_Container", 1, localStringBuilder.toString());
      this.e = paramGiftAnimData;
      if ((bool) && (QQGiftPAGAnimationViewImpl.a.a()))
      {
        if (this.b == null)
        {
          this.b = new AnimationBannerView(getContext(), this.f);
          addView(this.b);
        }
        this.c = this.b;
      }
      else
      {
        this.c = this.a;
        if (!bool) {
          a(paramGiftAnimData);
        }
      }
      a(paramGiftAnimData, this.f.a(paramGiftAnimData.d), paramInt);
      this.d = 1;
      if (this.g != null) {
        this.g.c(paramGiftAnimData);
      }
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    synchronized (this.h)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCurrentTargetNum ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" playStatus is ");
      localStringBuilder.append(this.d);
      QLog.i("Gift_Banner_Container", 1, localStringBuilder.toString());
      if ((this.d != 3) && (this.e != null))
      {
        this.e.o = paramInt;
        if (this.d == 2) {
          this.c.a(paramInt);
        }
        return true;
      }
      return false;
    }
  }
  
  public void b()
  {
    synchronized (this.h)
    {
      this.d = 3;
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -this.c.getWidth() });
      localValueAnimator.setDuration(200L);
      localValueAnimator.setInterpolator(new AccelerateInterpolator());
      localValueAnimator.addUpdateListener(new GiftBannerContainer.3(this));
      localValueAnimator.addListener(new GiftBannerContainer.4(this));
      localValueAnimator.start();
      return;
    }
  }
  
  public void b(GiftAnimData paramGiftAnimData, int paramInt)
  {
    if (paramGiftAnimData != this.e)
    {
      QLog.e("Gift_Banner_Container", 1, "banner animation end but not match");
      return;
    }
    QLog.i("Gift_Banner_Container", 1, "banner animation end");
    GiftBannerContainerListener localGiftBannerContainerListener = this.g;
    if (localGiftBannerContainerListener != null) {
      localGiftBannerContainerListener.b(paramGiftAnimData, paramInt);
    }
  }
  
  public void c(GiftAnimData paramGiftAnimData)
  {
    if (paramGiftAnimData != this.e)
    {
      QLog.e("Gift_Banner_Container", 1, "banner animation start but not match");
      return;
    }
    QLog.i("Gift_Banner_Container", 1, "banner animation start");
    GiftBannerContainerListener localGiftBannerContainerListener = this.g;
    if (localGiftBannerContainerListener != null) {
      localGiftBannerContainerListener.c(paramGiftAnimData);
    }
  }
  
  public void setBannerListener(GiftBannerContainerListener paramGiftBannerContainerListener)
  {
    this.g = paramGiftBannerContainerListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.GiftBannerContainer
 * JD-Core Version:    0.7.0.1
 */