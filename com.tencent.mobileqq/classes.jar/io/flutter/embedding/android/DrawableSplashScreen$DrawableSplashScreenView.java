package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class DrawableSplashScreen$DrawableSplashScreenView
  extends ImageView
{
  public DrawableSplashScreen$DrawableSplashScreenView(@NonNull Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public DrawableSplashScreen$DrawableSplashScreenView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawableSplashScreen$DrawableSplashScreenView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setSplashDrawable(@Nullable Drawable paramDrawable)
  {
    setSplashDrawable(paramDrawable, ImageView.ScaleType.FIT_XY);
  }
  
  public void setSplashDrawable(@Nullable Drawable paramDrawable, @NonNull ImageView.ScaleType paramScaleType)
  {
    setScaleType(paramScaleType);
    setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.android.DrawableSplashScreen.DrawableSplashScreenView
 * JD-Core Version:    0.7.0.1
 */