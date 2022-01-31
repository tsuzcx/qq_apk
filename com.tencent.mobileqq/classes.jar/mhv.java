import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyPullToZoomListView;
import com.tencent.qphone.base.util.QLog;

public class mhv
  implements Runnable
{
  float jdField_a_of_type_Float;
  long jdField_a_of_type_Long;
  public boolean a;
  long b;
  
  public mhv(ReadInJoyPullToZoomListView paramReadInJoyPullToZoomListView)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
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
    this.jdField_a_of_type_Float = (ReadInJoyPullToZoomListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView).getBottom() / ReadInJoyPullToZoomListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView.post(this);
    if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.a())) {
      QLog.d("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# startAnimation(): duration =" + paramLong + ", mScale=" + this.jdField_a_of_type_Float);
    }
  }
  
  public void run()
  {
    ReadInJoyPullToZoomListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView);
    float f1;
    float f2;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Float > 1.0D))
    {
      f1 = ((float)AnimationUtils.currentAnimationTimeMillis() - (float)this.b) / (float)this.jdField_a_of_type_Long;
      f2 = this.jdField_a_of_type_Float - (this.jdField_a_of_type_Float - 1.0F) * ReadInJoyPullToZoomListView.a().getInterpolation(f1);
      ViewGroup.LayoutParams localLayoutParams = ReadInJoyPullToZoomListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView).getLayoutParams();
      if (f2 <= 1.0F) {
        break label173;
      }
      localLayoutParams.height = ReadInJoyPullToZoomListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView);
      localLayoutParams.height = ((int)(ReadInJoyPullToZoomListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView) * f2));
      ReadInJoyPullToZoomListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView).setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView.post(this);
      if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.a())) {
        QLog.d("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# runing...... f1 = " + f1 + ", f2=" + f2);
      }
    }
    return;
    label173:
    if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.a())) {
      QLog.w("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# run() end! f1 = " + f1 + ", f2=" + f2);
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhv
 * JD-Core Version:    0.7.0.1
 */