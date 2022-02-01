import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.1.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

public class rnv
  implements ViewTreeObserver.OnDrawListener
{
  int jdField_a_of_type_Int = 0;
  
  rnv(rnu paramrnu, rrm paramrrm) {}
  
  public void onDraw()
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int == 1)
    {
      rnu.a(this.jdField_a_of_type_Rnu).getWindow().getDecorView().post(new VideoFeedsAdapter.1.1(this, this));
      if (this.jdField_a_of_type_Rrm == rnu.a(this.jdField_a_of_type_Rnu).jdField_a_of_type_Rrm) {
        rnu.a(this.jdField_a_of_type_Rnu).a(this.jdField_a_of_type_Rrm, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnv
 * JD-Core Version:    0.7.0.1
 */