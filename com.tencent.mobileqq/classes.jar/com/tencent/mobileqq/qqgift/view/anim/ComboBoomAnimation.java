package com.tencent.mobileqq.qqgift.view.anim;

import android.view.View;
import com.tencent.mobileqq.qqgift.mvvm.business.banner.BannerResManager;
import org.libpag.PAGFile;
import org.libpag.PAGView;

public class ComboBoomAnimation
  extends BaseComboPagAnimation
{
  private PAGFile b;
  
  public ComboBoomAnimation(View paramView)
  {
    super(paramView);
  }
  
  void a()
  {
    if (this.b == null)
    {
      BannerResManager localBannerResManager = BannerResManager.b();
      if (localBannerResManager != null)
      {
        this.b = localBannerResManager.d();
        this.a.setComposition(this.b);
      }
    }
  }
  
  public void b()
  {
    if ((this.b != null) && (this.a != null))
    {
      this.a.setProgress(0.0D);
      this.a.play();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.view.anim.ComboBoomAnimation
 * JD-Core Version:    0.7.0.1
 */