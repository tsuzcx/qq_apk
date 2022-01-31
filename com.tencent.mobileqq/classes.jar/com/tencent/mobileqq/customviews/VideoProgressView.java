package com.tencent.mobileqq.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import badl;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.MessageProgressView.RefreshProgressRunnable;

public class VideoProgressView
  extends MessageProgressView
{
  private boolean a = true;
  private float g;
  
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
      if (a())
      {
        a(paramCanvas, this.g);
        if (this.c == null) {
          break label68;
        }
        a(paramCanvas, this.c);
        label49:
        d(paramCanvas);
        e(paramCanvas);
      }
    }
    label68:
    do
    {
      return;
      c(paramCanvas);
      break;
      a(paramCanvas);
      break label49;
      if (this.d == 2)
      {
        d();
        f(paramCanvas);
        return;
      }
    } while (this.d != 3);
    d();
    g(paramCanvas);
  }
  
  public void setVideoCompressPercent(String paramString, float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      this.g = paramFloat;
      if (this.g >= 1.0F) {
        break label82;
      }
    }
    MessageProgressView.RefreshProgressRunnable localRefreshProgressRunnable;
    label82:
    for (boolean bool = true;; bool = false)
    {
      this.a = bool;
      if (this.d == 1)
      {
        localRefreshProgressRunnable = badl.a().a(paramString);
        if (localRefreshProgressRunnable != null) {
          break;
        }
        localRefreshProgressRunnable = new MessageProgressView.RefreshProgressRunnable(this, paramString);
        badl.a().a(paramString, localRefreshProgressRunnable);
        ViewCompat.postOnAnimation(this, localRefreshProgressRunnable);
      }
      return;
    }
    localRefreshProgressRunnable.a(this);
  }
  
  public void setVideoCompressStatus(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.VideoProgressView
 * JD-Core Version:    0.7.0.1
 */