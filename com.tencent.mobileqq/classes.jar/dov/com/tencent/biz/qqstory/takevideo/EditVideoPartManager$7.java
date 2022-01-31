package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import bjxn;
import bkyb;
import com.tencent.qphone.base.util.QLog;

public class EditVideoPartManager$7
  implements Runnable
{
  public EditVideoPartManager$7(bjxn parambjxn) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.a();
    if (localBitmap != null) {}
    try
    {
      if (bjxn.a(this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, 64))
      {
        if (bjxn.jdField_a_of_type_Bkyb == null) {
          bjxn.jdField_a_of_type_Bkyb = new bkyb();
        }
        bjxn.jdField_a_of_type_Bkyb.c(localBitmap.getWidth(), localBitmap.getHeight());
      }
      return;
    }
    catch (Exception localException)
    {
      bjxn.jdField_a_of_type_Bkyb = null;
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 1, "artImageRender init error, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.7
 * JD-Core Version:    0.7.0.1
 */