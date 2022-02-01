import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.1.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

public class shm
  implements ViewTreeObserver.OnDrawListener
{
  int jdField_a_of_type_Int = 0;
  
  shm(shl paramshl, skq paramskq) {}
  
  public void onDraw()
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Shl.a.getWindow().getDecorView().post(new VideoFeedsAdapter.1.1(this, this));
      if (this.jdField_a_of_type_Skq == shl.a(this.jdField_a_of_type_Shl).jdField_a_of_type_Skq) {
        shl.a(this.jdField_a_of_type_Shl).a(this.jdField_a_of_type_Skq, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shm
 * JD-Core Version:    0.7.0.1
 */