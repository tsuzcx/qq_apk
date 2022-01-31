import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo2.StoryLocalPublishPart;

class ora
  implements Runnable
{
  ora(oqz paramoqz, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      StoryLocalPublishPart.a(this.jdField_a_of_type_Oqz.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryLocalPublishPart).setImageDrawable(new BitmapDrawable(this.jdField_a_of_type_Oqz.jdField_a_of_type_AndroidViewView.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap));
      StoryLocalPublishPart.a(this.jdField_a_of_type_Oqz.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryLocalPublishPart).setOnClickListener(StoryLocalPublishPart.a(this.jdField_a_of_type_Oqz.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryLocalPublishPart));
      return;
    }
    SLog.d("story.publish.StoryLocalPublishPart", "queryFirstMediaThumbnail return null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ora
 * JD-Core Version:    0.7.0.1
 */