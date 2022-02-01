import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.1.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

public class rux
  implements ViewTreeObserver.OnDrawListener
{
  int jdField_a_of_type_Int = 0;
  
  rux(ruw paramruw, ryo paramryo) {}
  
  public void onDraw()
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int == 1)
    {
      ruw.a(this.jdField_a_of_type_Ruw).getWindow().getDecorView().post(new VideoFeedsAdapter.1.1(this, this));
      if (this.jdField_a_of_type_Ryo == ruw.a(this.jdField_a_of_type_Ruw).jdField_a_of_type_Ryo) {
        ruw.a(this.jdField_a_of_type_Ruw).a(this.jdField_a_of_type_Ryo, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rux
 * JD-Core Version:    0.7.0.1
 */