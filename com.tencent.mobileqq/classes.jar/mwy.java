import android.app.Activity;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.qqstory.view.WeShiGuideDialog;

public final class mwy
  implements View.OnSystemUiVisibilityChangeListener
{
  public mwy(WeShiGuideDialog paramWeShiGuideDialog, Activity paramActivity) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWeShiGuideDialog.getWindow().getDecorView().setSystemUiVisibility(5894);
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof VideoFeedsPlayActivity)) {
      ((VideoFeedsPlayActivity)this.jdField_a_of_type_AndroidAppActivity).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwy
 * JD-Core Version:    0.7.0.1
 */