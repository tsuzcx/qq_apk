package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.widget.ImageView;
import bmpl;
import wxe;

public class LocalVideoSelectActivity$5$1
  implements Runnable
{
  public LocalVideoSelectActivity$5$1(bmpl parambmpl, Bitmap paramBitmap) {}
  
  public void run()
  {
    wxe.a("Q.qqstory.publish.edit.LocalVideoSelectActivity", "load cover completed and havePlaying=%s", Boolean.valueOf(LocalVideoSelectActivity.c(this.jdField_a_of_type_Bmpl.a)));
    if (!LocalVideoSelectActivity.c(this.jdField_a_of_type_Bmpl.a))
    {
      LocalVideoSelectActivity.a(this.jdField_a_of_type_Bmpl.a).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      LocalVideoSelectActivity.a(this.jdField_a_of_type_Bmpl.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity.5.1
 * JD-Core Version:    0.7.0.1
 */