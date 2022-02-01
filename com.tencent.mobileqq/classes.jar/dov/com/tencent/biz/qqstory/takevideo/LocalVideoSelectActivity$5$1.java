package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;

class LocalVideoSelectActivity$5$1
  implements Runnable
{
  LocalVideoSelectActivity$5$1(LocalVideoSelectActivity.5 param5, Bitmap paramBitmap) {}
  
  public void run()
  {
    SLog.a("Q.qqstory.publish.edit.LocalVideoSelectActivity", "load cover completed and havePlaying=%s", Boolean.valueOf(LocalVideoSelectActivity.c(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalVideoSelectActivity$5.a)));
    if (!LocalVideoSelectActivity.c(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalVideoSelectActivity$5.a))
    {
      LocalVideoSelectActivity.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalVideoSelectActivity$5.a).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      LocalVideoSelectActivity.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalVideoSelectActivity$5.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity.5.1
 * JD-Core Version:    0.7.0.1
 */