package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import com.tencent.common.app.AppInterface;
import dov.com.qq.im.capture.CaptureContext;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class DoodleOpController$1
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      DoodleLinePath localDoodleLinePath = (DoodleLinePath)localIterator.next();
      if ((localDoodleLinePath instanceof PersonalityLinePath))
      {
        AppInterface localAppInterface = CaptureContext.a();
        this.this$0.a(localAppInterface, ((PersonalityLinePath)localDoodleLinePath).c);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController.1
 * JD-Core Version:    0.7.0.1
 */