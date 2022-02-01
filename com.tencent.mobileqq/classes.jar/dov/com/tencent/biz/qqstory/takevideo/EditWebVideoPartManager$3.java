package dov.com.tencent.biz.qqstory.takevideo;

import bouq;
import bpsl;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.concurrent.atomic.AtomicBoolean;

public class EditWebVideoPartManager$3
  implements Runnable
{
  public EditWebVideoPartManager$3(bouq parambouq, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditWebVideoActivity", 2, "stopRecord(): Async, mVideoCacheDir:" + this.a.jdField_a_of_type_JavaLangString + ",is to call AVideoCodec.recordSubmit()");
      }
      bpsl.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        synchronized (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
        {
          this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("EditWebVideoActivity", 2, "stopRecord(): Async, mVideoCacheDir:" + this.a.jdField_a_of_type_JavaLangString + ", call AVideoCodec.recordSubmit() fail, error = " + localUnsatisfiedLinkError.getMessage());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.3
 * JD-Core Version:    0.7.0.1
 */