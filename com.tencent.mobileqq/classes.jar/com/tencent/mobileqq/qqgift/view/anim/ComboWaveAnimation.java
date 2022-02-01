package com.tencent.mobileqq.qqgift.view.anim;

import android.view.View;
import com.tencent.mobileqq.qqgift.mvvm.business.banner.BannerResManager;
import org.libpag.PAGComposition;
import org.libpag.PAGView;

public class ComboWaveAnimation
  extends BaseComboPagAnimation
{
  private int b = 1;
  
  public ComboWaveAnimation(View paramView)
  {
    super(paramView);
  }
  
  void a()
  {
    a(this.b);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    if (this.a == null) {
      return;
    }
    Object localObject = BannerResManager.b();
    if (localObject == null) {
      return;
    }
    localObject = ((BannerResManager)localObject).h(paramInt);
    if (localObject == null) {
      return;
    }
    this.a.setComposition((PAGComposition)localObject);
    this.a.setRepeatCount(2147483647);
    this.a.setScaleMode(3);
    this.a.play();
  }
  
  public void b()
  {
    if (this.a != null) {
      this.a.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.view.anim.ComboWaveAnimation
 * JD-Core Version:    0.7.0.1
 */