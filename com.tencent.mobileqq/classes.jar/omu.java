import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

class omu
  implements Runnable
{
  omu(omt paramomt, Bitmap paramBitmap) {}
  
  public void run()
  {
    int i = AIOUtils.a(47.0F, this.jdField_a_of_type_Omt.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.a(75.0F, this.jdField_a_of_type_Omt.jdField_a_of_type_AndroidContentContext.getResources());
    Bitmap localBitmap1 = BitmapUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap, i, j, false);
    if (localBitmap1 == null)
    {
      SLog.e("story.publish.StoryMultiFragmentPart", "resizeThumb = null.");
      return;
    }
    Bitmap localBitmap2 = new RoundedTransformation(AIOUtils.a(3.0F, this.jdField_a_of_type_Omt.jdField_a_of_type_AndroidContentContext.getResources()), 0, j * 1.0F / i, null, null).a(localBitmap1);
    if (localBitmap2 == null)
    {
      SLog.e("story.publish.StoryMultiFragmentPart", "roundThumb = null.");
      return;
    }
    i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    float f1 = ScreenUtil.a;
    float f2 = ScreenUtil.a(this.jdField_a_of_type_Omt.jdField_a_of_type_AndroidContentContext);
    if (i / j > f1 / f2) {}
    for (localBitmap1 = BitmapUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (int)(f1 / f2 * j), j, true); localBitmap1 == null; localBitmap1 = BitmapUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap, i, (int)(f2 / f1 * i), true))
    {
      SLog.e("story.publish.StoryMultiFragmentPart", "animBitmap = null.");
      return;
    }
    SLog.b("story.publish.StoryMultiFragmentPart", "post RunnableUpdateThumb");
    new Handler(Looper.getMainLooper()).post(new omw(this.jdField_a_of_type_Omt.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryMultiFragmentPart, localBitmap1, localBitmap2, this.jdField_a_of_type_Omt.jdField_a_of_type_AndroidContentContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omu
 * JD-Core Version:    0.7.0.1
 */