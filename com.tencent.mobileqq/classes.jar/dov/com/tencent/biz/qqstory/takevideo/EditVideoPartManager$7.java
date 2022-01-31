package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import bjww;
import bkxk;
import com.tencent.qphone.base.util.QLog;

public class EditVideoPartManager$7
  implements Runnable
{
  public EditVideoPartManager$7(bjww parambjww) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.a();
    if (localBitmap != null) {}
    try
    {
      if (bjww.a(this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, 64))
      {
        if (bjww.jdField_a_of_type_Bkxk == null) {
          bjww.jdField_a_of_type_Bkxk = new bkxk();
        }
        bjww.jdField_a_of_type_Bkxk.c(localBitmap.getWidth(), localBitmap.getHeight());
      }
      return;
    }
    catch (Exception localException)
    {
      bjww.jdField_a_of_type_Bkxk = null;
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 1, "artImageRender init error, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.7
 * JD-Core Version:    0.7.0.1
 */