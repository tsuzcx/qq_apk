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
  private float a = 0.0F;
  private boolean b = true;
  
  public VideoProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(String paramString, float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F) && (paramFloat > this.a)) {
      setVideoCompressPercent(paramString, paramFloat);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  @TargetApi(11)
  public void onDraw(Canvas paramCanvas)
  {
    if (this.g == 1)
    {
      d();
      b(paramCanvas);
      if (a()) {
        a(paramCanvas, this.a);
      } else {
        c(paramCanvas);
      }
      if (this.i != null) {
        a(paramCanvas, this.i);
      } else {
        a(paramCanvas);
      }
      d(paramCanvas);
      e(paramCanvas);
      return;
    }
    if (this.g == 2)
    {
      d();
      f(paramCanvas);
      return;
    }
    if (this.g == 3)
    {
      d();
      g(paramCanvas);
    }
  }
  
  public void setVideoCompressPercent(String paramString, float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      this.a = paramFloat;
      boolean bool;
      if (this.a < 1.0F) {
        bool = true;
      } else {
        bool = false;
      }
      this.b = bool;
    }
    if (this.g == 1)
    {
      RefreshProgressRunnable localRefreshProgressRunnable = MessageProgressController.a().a(paramString);
      if (localRefreshProgressRunnable == null)
      {
        localRefreshProgressRunnable = new RefreshProgressRunnable(this, paramString, this.h);
        MessageProgressController.a().a(paramString, localRefreshProgressRunnable);
        ViewCompat.postOnAnimation(this, localRefreshProgressRunnable);
        return;
      }
      localRefreshProgressRunnable.a(this, this.h);
    }
  }
  
  public void setVideoCompressStatus(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.VideoProgressView
 * JD-Core Version:    0.7.0.1
 */