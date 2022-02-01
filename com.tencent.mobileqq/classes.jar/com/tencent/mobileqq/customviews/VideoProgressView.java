package com.tencent.mobileqq.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import com.tencent.mobileqq.utils.MessageProgressController;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.RefreshProgressRunnable;

public class VideoProgressView
  extends MessageProgressView
{
  private boolean a = true;
  private float g = 0.0F;
  
  public VideoProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(String paramString, float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F) && (paramFloat > this.g)) {
      setVideoCompressPercent(paramString, paramFloat);
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  @TargetApi(11)
  public void onDraw(Canvas paramCanvas)
  {
    if (this.d == 1)
    {
      d();
      b(paramCanvas);
      if (a()) {
        a(paramCanvas, this.g);
      } else {
        c(paramCanvas);
      }
      if (this.c != null) {
        a(paramCanvas, this.c);
      } else {
        a(paramCanvas);
      }
      d(paramCanvas);
      e(paramCanvas);
      return;
    }
    if (this.d == 2)
    {
      d();
      f(paramCanvas);
      return;
    }
    if (this.d == 3)
    {
      d();
      g(paramCanvas);
    }
  }
  
  public void setVideoCompressPercent(String paramString, float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      this.g = paramFloat;
      boolean bool;
      if (this.g < 1.0F) {
        bool = true;
      } else {
        bool = false;
      }
      this.a = bool;
    }
    if (this.d == 1)
    {
      RefreshProgressRunnable localRefreshProgressRunnable = MessageProgressController.a().a(paramString);
      if (localRefreshProgressRunnable == null)
      {
        localRefreshProgressRunnable = new RefreshProgressRunnable(this, paramString, this.e);
        MessageProgressController.a().a(paramString, localRefreshProgressRunnable);
        ViewCompat.postOnAnimation(this, localRefreshProgressRunnable);
        return;
      }
      localRefreshProgressRunnable.a(this, this.e);
    }
  }
  
  public void setVideoCompressStatus(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.VideoProgressView
 * JD-Core Version:    0.7.0.1
 */