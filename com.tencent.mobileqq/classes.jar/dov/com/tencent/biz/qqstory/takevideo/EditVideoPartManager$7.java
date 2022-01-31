package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import bmix;
import bnjl;
import com.tencent.qphone.base.util.QLog;

public class EditVideoPartManager$7
  implements Runnable
{
  public EditVideoPartManager$7(bmix parambmix) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.a();
    if (localBitmap != null) {}
    try
    {
      if (bmix.a(this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, 64))
      {
        if (bmix.jdField_a_of_type_Bnjl == null) {
          bmix.jdField_a_of_type_Bnjl = new bnjl();
        }
        bmix.jdField_a_of_type_Bnjl.c(localBitmap.getWidth(), localBitmap.getHeight());
      }
      return;
    }
    catch (Exception localException)
    {
      bmix.jdField_a_of_type_Bnjl = null;
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 1, "artImageRender init error, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.7
 * JD-Core Version:    0.7.0.1
 */