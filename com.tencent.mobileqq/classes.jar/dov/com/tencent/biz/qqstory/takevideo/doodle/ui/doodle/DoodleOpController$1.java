package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import bjal;
import bkev;
import bkew;
import bkfs;
import bkft;
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
      bkev localbkev = (bkev)localIterator.next();
      if ((localbkev instanceof bkfs))
      {
        AppInterface localAppInterface = bjal.a();
        this.this$0.a(localAppInterface, ((bkfs)localbkev).c);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    this.this$0.jdField_a_of_type_Bkft.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController.1
 * JD-Core Version:    0.7.0.1
 */