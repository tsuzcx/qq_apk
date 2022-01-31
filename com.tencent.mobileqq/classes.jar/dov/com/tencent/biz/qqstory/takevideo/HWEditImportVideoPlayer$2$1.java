package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import bmnj;
import bmpc;
import bmpe;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import wxe;

class HWEditImportVideoPlayer$2$1
  implements Runnable
{
  HWEditImportVideoPlayer$2$1(HWEditImportVideoPlayer.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      bmpe localbmpe = (bmpe)this.a.this$0.jdField_a_of_type_JavaUtilList.get(0);
      bmpc.a(this.a.this$0, localbmpe);
    }
    for (;;)
    {
      this.a.this$0.jdField_a_of_type_Bmnj.a(Message.obtain(null, 8));
      bmpc.a(this.a.this$0).set(true);
      return;
      wxe.e("Q.qqstory.record.HWEditImportVideoPlayer", "mFragmentInfos is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.2.1
 * JD-Core Version:    0.7.0.1
 */