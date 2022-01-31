import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager.SlideShowAdapter;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager.SlideShowViewHolder;
import com.tencent.biz.troopgift.GridListAdapter;
import com.tencent.mobileqq.util.DisplayUtil;

public class olw
  implements Runnable
{
  public olw(SlideShowPhotoListManager.SlideShowAdapter paramSlideShowAdapter, SlideShowPhotoListManager.SlideShowViewHolder paramSlideShowViewHolder) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowViewHolder.a.getWidth();
    int j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowViewHolder.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (SlideShowPhotoListManager.SlideShowAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter) == null)
    {
      int k = DisplayUtil.a(SlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter.a), 1.0F);
      new Paint().setTextSize(DisplayUtil.a(SlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter.a), 11.0F));
      int m = DisplayUtil.a(SlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter.a), 1.0F);
      SlideShowPhotoListManager.SlideShowAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter, GridListAdapter.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowViewHolder.a.setBackgroundDrawable(new BitmapDrawable(SlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter.a).getResources(), SlideShowPhotoListManager.SlideShowAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     olw
 * JD-Core Version:    0.7.0.1
 */