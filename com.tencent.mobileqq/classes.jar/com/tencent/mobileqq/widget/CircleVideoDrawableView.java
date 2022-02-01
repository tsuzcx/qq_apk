package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.qphone.base.util.QLog;

public class CircleVideoDrawableView
  extends CircleBubbleImageView
  implements VideoDrawable.OnAudioPlayOnceListener
{
  public URLDrawable a;
  public String d;
  CircleVideoDrawableView.VideoListener v;
  
  public CircleVideoDrawableView(Context paramContext)
  {
    super(paramContext);
  }
  
  public String getVideoPath()
  {
    return this.d;
  }
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, " onFinish ");
    }
    CircleVideoDrawableView.VideoListener localVideoListener = this.v;
    if (localVideoListener != null) {
      localVideoListener.b();
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == this.a)
    {
      setURLDrawable(paramURLDrawable);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.a) {
      setURLDrawable(paramURLDrawable);
    }
    super.onLoadSuccessed(paramURLDrawable);
    paramURLDrawable = this.a.getCurrDrawable();
    if ((paramURLDrawable != null) && ((paramURLDrawable instanceof VideoDrawable)))
    {
      paramURLDrawable = (VideoDrawable)paramURLDrawable;
      paramURLDrawable.resetAndPlayAudioOnce();
      paramURLDrawable.setOnAudioPlayOnceListener(this);
    }
    paramURLDrawable = this.v;
    if (paramURLDrawable != null) {
      paramURLDrawable.a();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    super.setImageDrawable(paramDrawable);
  }
  
  public void setURLDrawable(URLDrawable paramURLDrawable)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((URLDrawable)localObject).setURLDrawableListener(null);
      localObject = this.a.getCurrDrawable();
      if ((localObject != null) && ((localObject instanceof VideoDrawable)))
      {
        localObject = (VideoDrawable)localObject;
        ((VideoDrawable)localObject).stopAudio();
        ((VideoDrawable)localObject).setOnAudioPlayOnceListener(null);
      }
    }
    paramURLDrawable.setURLDrawableListener(this);
    setImageDrawable(paramURLDrawable);
    this.a = paramURLDrawable;
    paramURLDrawable = this.a.getCurrDrawable();
    if ((paramURLDrawable != null) && ((paramURLDrawable instanceof VideoDrawable))) {
      ((VideoDrawable)paramURLDrawable).setOnAudioPlayOnceListener(this);
    }
  }
  
  public void setVideoListener(CircleVideoDrawableView.VideoListener paramVideoListener)
  {
    this.v = paramVideoListener;
  }
  
  public void setVideoPath(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleVideoDrawableView
 * JD-Core Version:    0.7.0.1
 */