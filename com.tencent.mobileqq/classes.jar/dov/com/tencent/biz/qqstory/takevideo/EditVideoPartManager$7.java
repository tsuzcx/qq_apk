package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import bigb;
import bjgz;
import com.tencent.qphone.base.util.QLog;

public class EditVideoPartManager$7
  implements Runnable
{
  public EditVideoPartManager$7(bigb parambigb) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.a();
    if (localBitmap != null) {}
    try
    {
      if (bigb.a(this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, 64))
      {
        if (bigb.jdField_a_of_type_Bjgz == null) {
          bigb.jdField_a_of_type_Bjgz = new bjgz();
        }
        bigb.jdField_a_of_type_Bjgz.c(localBitmap.getWidth(), localBitmap.getHeight());
      }
      return;
    }
    catch (Exception localException)
    {
      bigb.jdField_a_of_type_Bjgz = null;
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 1, "artImageRender init error, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.7
 * JD-Core Version:    0.7.0.1
 */