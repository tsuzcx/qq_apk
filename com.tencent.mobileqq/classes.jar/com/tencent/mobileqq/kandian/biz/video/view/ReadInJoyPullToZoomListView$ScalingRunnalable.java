package com.tencent.mobileqq.kandian.biz.video.view;

import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyPullToZoomListView$ScalingRunnalable
  implements Runnable
{
  float jdField_a_of_type_Float;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean = true;
  long b;
  
  ReadInJoyPullToZoomListView$ScalingRunnalable(ReadInJoyPullToZoomListView paramReadInJoyPullToZoomListView) {}
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.a())) {
      QLog.e("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# abortAnimation(): ");
    }
  }
  
  public void a(long paramLong)
  {
    this.b = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Float = (ReadInJoyPullToZoomListView.a(this.this$0).getBottom() / ReadInJoyPullToZoomListView.a(this.this$0));
    this.jdField_a_of_type_Boolean = false;
    this.this$0.post(this);
    if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.a()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("#ScalingRunnalable# startAnimation(): duration =");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", mScale=");
      localStringBuilder.append(this.jdField_a_of_type_Float);
      QLog.d("Q.readinjoy.video.PullToZoomListView", 2, localStringBuilder.toString());
    }
  }
  
  public void run()
  {
    ReadInJoyPullToZoomListView.a(this.this$0);
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Float > 1.0D))
    {
      float f1 = ((float)AnimationUtils.currentAnimationTimeMillis() - (float)this.b) / (float)this.jdField_a_of_type_Long;
      float f2 = this.jdField_a_of_type_Float;
      f2 -= (f2 - 1.0F) * ReadInJoyPullToZoomListView.a().getInterpolation(f1);
      Object localObject = ReadInJoyPullToZoomListView.a(this.this$0).getLayoutParams();
      if (f2 > 1.0F)
      {
        ((ViewGroup.LayoutParams)localObject).height = ReadInJoyPullToZoomListView.a(this.this$0);
        ((ViewGroup.LayoutParams)localObject).height = ((int)(ReadInJoyPullToZoomListView.a(this.this$0) * f2));
        ReadInJoyPullToZoomListView.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.this$0.post(this);
        if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.a()))
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
      if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.a()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#ScalingRunnalable# run() end! f1 = ");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(", f2=");
        ((StringBuilder)localObject).append(f2);
        QLog.w("Q.readinjoy.video.PullToZoomListView", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.view.ReadInJoyPullToZoomListView.ScalingRunnalable
 * JD-Core Version:    0.7.0.1
 */