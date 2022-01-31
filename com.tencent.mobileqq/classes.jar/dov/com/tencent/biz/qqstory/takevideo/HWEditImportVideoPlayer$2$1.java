package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import bjxn;
import bjzg;
import bjzi;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import ved;

class HWEditImportVideoPlayer$2$1
  implements Runnable
{
  HWEditImportVideoPlayer$2$1(HWEditImportVideoPlayer.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      bjzi localbjzi = (bjzi)this.a.this$0.jdField_a_of_type_JavaUtilList.get(0);
      bjzg.a(this.a.this$0, localbjzi);
    }
    for (;;)
    {
      this.a.this$0.jdField_a_of_type_Bjxn.a(Message.obtain(null, 8));
      bjzg.a(this.a.this$0).set(true);
      return;
      ved.e("Q.qqstory.record.HWEditImportVideoPlayer", "mFragmentInfos is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.2.1
 * JD-Core Version:    0.7.0.1
 */