package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import botw;
import bppu;
import com.tencent.qphone.base.util.QLog;

public class EditVideoPartManager$5
  implements Runnable
{
  public EditVideoPartManager$5(botw parambotw) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.a();
    if (localBitmap != null) {}
    try
    {
      if (botw.a(this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c, 64))
      {
        if (botw.jdField_a_of_type_Bppu == null) {
          botw.jdField_a_of_type_Bppu = new bppu();
        }
        botw.jdField_a_of_type_Bppu.c(localBitmap.getWidth(), localBitmap.getHeight());
      }
      return;
    }
    catch (Exception localException)
    {
      botw.jdField_a_of_type_Bppu = null;
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 1, "artImageRender init error, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.5
 * JD-Core Version:    0.7.0.1
 */