package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import bofz;
import bozs;
import bozt;
import bpap;
import bpaq;
import com.tencent.common.app.AppInterface;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class DoodleOpController$1
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      bozs localbozs = (bozs)localIterator.next();
      if ((localbozs instanceof bpap))
      {
        AppInterface localAppInterface = bofz.a();
        this.this$0.a(localAppInterface, ((bpap)localbozs).c);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    this.this$0.jdField_a_of_type_Bpaq.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController.1
 * JD-Core Version:    0.7.0.1
 */