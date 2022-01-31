package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.widget.ImageView;
import bmkz;
import wsv;

public class LocalVideoSelectActivity$5$1
  implements Runnable
{
  public LocalVideoSelectActivity$5$1(bmkz parambmkz, Bitmap paramBitmap) {}
  
  public void run()
  {
    wsv.a("Q.qqstory.publish.edit.LocalVideoSelectActivity", "load cover completed and havePlaying=%s", Boolean.valueOf(LocalVideoSelectActivity.c(this.jdField_a_of_type_Bmkz.a)));
    if (!LocalVideoSelectActivity.c(this.jdField_a_of_type_Bmkz.a))
    {
      LocalVideoSelectActivity.a(this.jdField_a_of_type_Bmkz.a).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      LocalVideoSelectActivity.a(this.jdField_a_of_type_Bmkz.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity.5.1
 * JD-Core Version:    0.7.0.1
 */