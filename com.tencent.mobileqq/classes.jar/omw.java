import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo2.StoryMultiFragmentPart;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class omw
  implements Runnable
{
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Bitmap b;
  
  public omw(StoryMultiFragmentPart paramStoryMultiFragmentPart, @NonNull Bitmap paramBitmap1, @NonNull Bitmap paramBitmap2, Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap1;
    this.b = paramBitmap2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if ((StoryMultiFragmentPart.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryMultiFragmentPart) == null) || (StoryMultiFragmentPart.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryMultiFragmentPart) == null) || (StoryMultiFragmentPart.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryMultiFragmentPart) == null))
    {
      SLog.e("story.publish.StoryMultiFragmentPart", "RunnableUpdateThumb error. mFragmentAnimThumbView == null or mFragmentThumbView == null or mFragmentNumView == null.");
      return;
    }
    StoryMultiFragmentPart.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryMultiFragmentPart).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    StoryMultiFragmentPart.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryMultiFragmentPart).setVisibility(0);
    StoryMultiFragmentPart.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryMultiFragmentPart).setVisibility(8);
    int i = ScreenUtil.a;
    int j = ScreenUtil.a(this.jdField_a_of_type_AndroidContentContext);
    int k = AIOUtils.a(47.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int m = AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int n = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i1 = AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    SLog.c("story.publish.StoryMultiFragmentPart", "startScaleAnim. sWidth:" + i + " sHeight:" + j + " dWidth:" + k + " dHeight:" + m + " sMarginLeft:" + 0 + " sMarginBottom:" + 0 + " dMarginLeft:" + n + " dMarginBottom:" + i1);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(300L);
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.addUpdateListener(new omx(this, k, i, m, j, n, i1));
    localValueAnimator.addListener(new omy(this));
    localValueAnimator.start();
  }
  
  public void run()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omw
 * JD-Core Version:    0.7.0.1
 */