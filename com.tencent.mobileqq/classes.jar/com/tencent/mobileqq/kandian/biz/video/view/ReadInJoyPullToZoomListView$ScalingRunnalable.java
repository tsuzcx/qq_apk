package com.tencent.mobileqq.kandian.biz.video.view;

import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyPullToZoomListView$ScalingRunnalable
  implements Runnable
{
  long a;
  boolean b = true;
  float c;
  long d;
  
  ReadInJoyPullToZoomListView$ScalingRunnalable(ReadInJoyPullToZoomListView paramReadInJoyPullToZoomListView) {}
  
  public void a()
  {
    this.b = true;
    if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.c())) {
      QLog.e("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# abortAnimation(): ");
    }
  }
  
  public void a(long paramLong)
  {
    this.d = AnimationUtils.currentAnimationTimeMillis();
    this.a = paramLong;
    this.c = (ReadInJoyPullToZoomListView.c(this.this$0).getBottom() / ReadInJoyPullToZoomListView.d(this.this$0));
    this.b = false;
    this.this$0.post(this);
    if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.c()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("#ScalingRunnalable# startAnimation(): duration =");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", mScale=");
      localStringBuilder.append(this.c);
      QLog.d("Q.readinjoy.video.PullToZoomListView", 2, localStringBuilder.toString());
    }
  }
  
  public void run()
  {
    ReadInJoyPullToZoomListView.b(this.this$0);
    if ((!this.b) && (this.c > 1.0D))
    {
      float f1 = ((float)AnimationUtils.currentAnimationTimeMillis() - (float)this.d) / (float)this.a;
      float f2 = this.c;
      f2 -= (f2 - 1.0F) * ReadInJoyPullToZoomListView.d().getInterpolation(f1);
      Object localObject = ReadInJoyPullToZoomListView.c(this.this$0).getLayoutParams();
      if (f2 > 1.0F)
      {
        ((ViewGroup.LayoutParams)localObject).height = ReadInJoyPullToZoomListView.d(this.this$0);
        ((ViewGroup.LayoutParams)localObject).height = ((int)(ReadInJoyPullToZoomListView.d(this.this$0) * f2));
        ReadInJoyPullToZoomListView.c(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.this$0.post(this);
        if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.c()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("#ScalingRunnalable# runing...... f1 = ");
          ((StringBuilder)localObject).append(f1);
          ((StringBuilder)localObject).append(", f2=");
          ((StringBuilder)localObject).append(f2);
          QLog.d("Q.readinjoy.video.PullToZoomListView", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.c()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#ScalingRunnalable# run() end! f1 = ");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(", f2=");
        ((StringBuilder)localObject).append(f2);
        QLog.w("Q.readinjoy.video.PullToZoomListView", 2, ((StringBuilder)localObject).toString());
      }
      this.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.view.ReadInJoyPullToZoomListView.ScalingRunnalable
 * JD-Core Version:    0.7.0.1
 */