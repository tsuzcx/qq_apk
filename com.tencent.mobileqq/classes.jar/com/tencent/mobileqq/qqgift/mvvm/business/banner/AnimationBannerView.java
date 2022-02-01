package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import android.content.Context;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.qphone.base.util.QLog;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

class AnimationBannerView
  extends BaseBannerView
  implements PAGView.PAGViewListener
{
  private PAGView l;
  private boolean m = false;
  private boolean n = false;
  
  public AnimationBannerView(Context paramContext, BannerResManager paramBannerResManager)
  {
    super(paramContext, paramBannerResManager);
  }
  
  private void a(String paramString, GiftAnimData paramGiftAnimData)
  {
    PAGFile localPAGFile = PAGFile.Load(paramString);
    if (localPAGFile == null)
    {
      paramGiftAnimData = new StringBuilder();
      paramGiftAnimData.append("showPag but pagFile is null path:");
      paramGiftAnimData.append(paramString);
      QLog.e("Gift_Banner_BannerView", 1, paramGiftAnimData.toString());
      return;
    }
    this.l.setComposition(localPAGFile);
    this.h.a(paramGiftAnimData.k, new AnimationBannerView.1(this, paramGiftAnimData, localPAGFile));
    this.h.a(paramGiftAnimData.l, new AnimationBannerView.2(this, paramGiftAnimData, localPAGFile));
    this.l.flush();
  }
  
  private void g()
  {
    if (this.l.isPlaying()) {
      this.l.stop();
    }
  }
  
  private void h()
  {
    if (this.l.getComposition() != null)
    {
      this.l.setProgress(0.0D);
      this.l.play();
      return;
    }
    QLog.e("Gift_Banner_BannerView", 1, "playPag but file is null");
    this.n = true;
  }
  
  protected void a()
  {
    super.a();
    this.l = ((PAGView)findViewById(2131439780));
    this.l.addListener(this);
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("play targetNum is ");
    localStringBuilder.append(paramInt);
    QLog.i("Gift_Banner_BannerView", 1, localStringBuilder.toString());
    if (!this.j)
    {
      this.m = false;
      this.n = false;
      h();
    }
    super.a(paramInt);
  }
  
  public void a(GiftAnimData paramGiftAnimData, String paramString)
  {
    super.a(paramGiftAnimData, paramString);
    a(paramString, paramGiftAnimData);
  }
  
  public void b()
  {
    QLog.i("Gift_Banner_BannerView", 1, "stop");
    super.b();
    g();
    this.m = false;
    this.n = false;
  }
  
  int c()
  {
    return 2131627975;
  }
  
  public void d()
  {
    super.d();
    this.m = false;
    if (QLog.isColorLevel()) {
      QLog.i("Gift_Banner_BannerView", 1, "onHitStart");
    }
    if (this.g != null) {
      this.g.c(this.f);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHitEnd isPagOver:");
      localStringBuilder.append(this.n);
      QLog.i("Gift_Banner_BannerView", 1, localStringBuilder.toString());
    }
    this.m = true;
    if (this.n) {
      f();
    }
  }
  
  public void onAnimationCancel(PAGView paramPAGView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Gift_Banner_BannerView", 1, "onAnimationCancel");
    }
  }
  
  public void onAnimationEnd(PAGView paramPAGView)
  {
    if (QLog.isColorLevel())
    {
      paramPAGView = new StringBuilder();
      paramPAGView.append("onAnimationEnd isHitOver:");
      paramPAGView.append(this.m);
      QLog.i("Gift_Banner_BannerView", 1, paramPAGView.toString());
    }
    if (!this.j) {
      return;
    }
    this.n = true;
    if (this.m) {
      f();
    }
    h();
  }
  
  public void onAnimationRepeat(PAGView paramPAGView)
  {
    if (QLog.isColorLevel())
    {
      paramPAGView = new StringBuilder();
      paramPAGView.append("onAnimationEnd isHitOver:");
      paramPAGView.append(this.m);
      QLog.i("Gift_Banner_BannerView", 1, paramPAGView.toString());
    }
  }
  
  public void onAnimationStart(PAGView paramPAGView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Gift_Banner_BannerView", 1, "onPagAnimationStart");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.AnimationBannerView
 * JD-Core Version:    0.7.0.1
 */