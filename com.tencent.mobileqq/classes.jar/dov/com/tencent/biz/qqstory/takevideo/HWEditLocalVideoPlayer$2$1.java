package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import bjxn;
import bjzl;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import ved;

class HWEditLocalVideoPlayer$2$1
  implements Runnable
{
  HWEditLocalVideoPlayer$2$1(HWEditLocalVideoPlayer.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      bjzl localbjzl = (bjzl)this.a.this$0.jdField_a_of_type_JavaUtilList.get(0);
      HWEditLocalVideoPlayer.a(this.a.this$0, localbjzl);
    }
    for (;;)
    {
      this.a.this$0.jdField_a_of_type_Bjxn.a(Message.obtain(null, 8));
      HWEditLocalVideoPlayer.a(this.a.this$0, this.a.this$0.jdField_a_of_type_Int);
      HWEditLocalVideoPlayer.a(this.a.this$0).set(true);
      this.a.this$0.jdField_a_of_type_Bjxn.e(true);
      return;
      ved.e("Q.qqstory.record.HWEditLocalVideoPlayer", "mFragmentInfos is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.2.1
 * JD-Core Version:    0.7.0.1
 */