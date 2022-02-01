package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import bqgk;
import brgc;
import com.tencent.qphone.base.util.QLog;

public class EditVideoPartManager$7
  implements Runnable
{
  public EditVideoPartManager$7(bqgk parambqgk) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.a();
    if (localBitmap != null) {}
    try
    {
      if (bqgk.a(this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, 64))
      {
        if (bqgk.jdField_a_of_type_Brgc == null) {
          bqgk.jdField_a_of_type_Brgc = new brgc();
        }
        bqgk.jdField_a_of_type_Brgc.c(localBitmap.getWidth(), localBitmap.getHeight());
      }
      return;
    }
    catch (Exception localException)
    {
      bqgk.jdField_a_of_type_Brgc = null;
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 1, "artImageRender init error, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.7
 * JD-Core Version:    0.7.0.1
 */