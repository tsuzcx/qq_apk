package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.widget.ImageView;
import bjyy;
import veg;

public class LocalVideoSelectActivity$5$1
  implements Runnable
{
  public LocalVideoSelectActivity$5$1(bjyy parambjyy, Bitmap paramBitmap) {}
  
  public void run()
  {
    veg.a("Q.qqstory.publish.edit.LocalVideoSelectActivity", "load cover completed and havePlaying=%s", Boolean.valueOf(LocalVideoSelectActivity.c(this.jdField_a_of_type_Bjyy.a)));
    if (!LocalVideoSelectActivity.c(this.jdField_a_of_type_Bjyy.a))
    {
      LocalVideoSelectActivity.a(this.jdField_a_of_type_Bjyy.a).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      LocalVideoSelectActivity.a(this.jdField_a_of_type_Bjyy.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity.5.1
 * JD-Core Version:    0.7.0.1
 */