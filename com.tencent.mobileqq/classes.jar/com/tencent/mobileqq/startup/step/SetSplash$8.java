package com.tencent.mobileqq.startup.step;

import android.widget.ImageView;
import com.tencent.mobileqq.splashad.SplashADView.SplashADViewPresenter;

final class SetSplash$8
  implements SplashADView.SplashADViewPresenter
{
  SetSplash$8(ImageView paramImageView1, ImageView paramImageView2) {}
  
  public void a()
  {
    ImageView localImageView = this.a;
    if ((localImageView != null) && (this.b != null))
    {
      localImageView.setVisibility(8);
      this.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.8
 * JD-Core Version:    0.7.0.1
 */