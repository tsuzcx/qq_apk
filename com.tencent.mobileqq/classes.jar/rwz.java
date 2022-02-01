import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.1.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

public class rwz
  implements ViewTreeObserver.OnDrawListener
{
  int jdField_a_of_type_Int = 0;
  
  rwz(rwy paramrwy, sar paramsar) {}
  
  public void onDraw()
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int == 1)
    {
      rwy.a(this.jdField_a_of_type_Rwy).getWindow().getDecorView().post(new VideoFeedsAdapter.1.1(this, this));
      if (this.jdField_a_of_type_Sar == rwy.a(this.jdField_a_of_type_Rwy).jdField_a_of_type_Sar) {
        rwy.a(this.jdField_a_of_type_Rwy).a(this.jdField_a_of_type_Sar, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwz
 * JD-Core Version:    0.7.0.1
 */