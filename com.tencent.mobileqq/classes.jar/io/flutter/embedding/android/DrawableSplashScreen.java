package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView.ScaleType;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class DrawableSplashScreen
  implements SplashScreen
{
  private final long crossfadeDurationInMillis;
  private final Drawable drawable;
  private final ImageView.ScaleType scaleType;
  private DrawableSplashScreen.DrawableSplashScreenView splashView;
  
  public DrawableSplashScreen(@NonNull Drawable paramDrawable)
  {
    this(paramDrawable, ImageView.ScaleType.FIT_XY, 500L);
  }
  
  public DrawableSplashScreen(@NonNull Drawable paramDrawable, @NonNull ImageView.ScaleType paramScaleType, long paramLong)
  {
    this.drawable = paramDrawable;
    this.scaleType = paramScaleType;
    this.crossfadeDurationInMillis = paramLong;
  }
  
  @Nullable
  public View createSplashView(@NonNull Context paramContext, @Nullable Bundle paramBundle)
  {
    this.splashView = new DrawableSplashScreen.DrawableSplashScreenView(paramContext);
    this.splashView.setSplashDrawable(this.drawable, this.scaleType);
    return this.splashView;
  }
  
  public void transitionToFlutter(@NonNull Runnable paramRunnable)
  {
    DrawableSplashScreen.DrawableSplashScreenView localDrawableSplashScreenView = this.splashView;
    if (localDrawableSplashScreenView == null)
    {
      paramRunnable.run();
      return;
    }
    localDrawableSplashScreenView.animate().alpha(0.0F).setDuration(this.crossfadeDurationInMillis).setListener(new DrawableSplashScreen.1(this, paramRunnable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.android.DrawableSplashScreen
 * JD-Core Version:    0.7.0.1
 */