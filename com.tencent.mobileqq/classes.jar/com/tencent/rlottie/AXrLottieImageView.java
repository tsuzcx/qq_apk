package com.tencent.rlottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

public class AXrLottieImageView
  extends AppCompatImageView
{
  private AXrLottieDrawable a;
  private boolean b = true;
  private boolean c;
  private boolean d;
  
  public AXrLottieImageView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public AXrLottieImageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AXrLottieImageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public AXrLottieDrawable getLottieDrawable()
  {
    return this.a;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.c = true;
    AXrLottieDrawable localAXrLottieDrawable = this.a;
    if (localAXrLottieDrawable != null)
    {
      localAXrLottieDrawable.setCallback(this);
      if (this.d) {
        this.a.start();
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.c = false;
    AXrLottieDrawable localAXrLottieDrawable = this.a;
    if (localAXrLottieDrawable != null) {
      localAXrLottieDrawable.c(false);
    }
  }
  
  public void setAutoRepeat(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    if ((paramDrawable instanceof AXrLottieDrawable))
    {
      this.a = ((AXrLottieDrawable)paramDrawable);
      this.a.b(this.b);
      this.a.a(true);
      this.d = this.a.isRunning();
    }
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
  }
  
  public void setImageURI(@Nullable Uri paramUri)
  {
    super.setImageURI(paramUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.AXrLottieImageView
 * JD-Core Version:    0.7.0.1
 */