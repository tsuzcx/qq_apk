import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.widget.PullToZoomListView;
import com.tencent.widget.UpSideDownDrawable;

public class sze
  implements Runnable
{
  public sze(LikeRankingListActivity paramLikeRankingListActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    UpSideDownDrawable localUpSideDownDrawable = new UpSideDownDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.b.getWidth(), this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.b.getHeight());
    this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.b.setImageDrawable(localUpSideDownDrawable);
    localUpSideDownDrawable.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sze
 * JD-Core Version:    0.7.0.1
 */