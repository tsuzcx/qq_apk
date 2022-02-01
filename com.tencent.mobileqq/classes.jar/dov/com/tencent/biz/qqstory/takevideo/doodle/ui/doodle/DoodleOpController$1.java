package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import bplg;
import bqns;
import bqnt;
import bqop;
import bqoq;
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
      bqns localbqns = (bqns)localIterator.next();
      if ((localbqns instanceof bqop))
      {
        AppInterface localAppInterface = bplg.a();
        this.this$0.a(localAppInterface, ((bqop)localbqns).c);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    this.this$0.jdField_a_of_type_Bqoq.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController.1
 * JD-Core Version:    0.7.0.1
 */