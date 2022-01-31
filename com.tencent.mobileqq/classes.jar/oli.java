import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.publish.GenerateVideoManifestSegment;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class oli
  implements Runnable
{
  public oli(GenerateVideoManifestSegment paramGenerateVideoManifestSegment, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    try
    {
      SLog.a("Q.qqstory.publish.edit.GenerateVideoManifestSegment", "Async, mVideoFileDir:%s, before call AVideoCodec.recordSubmit()", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
      RecordManager.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      SLog.e("Q.qqstory.publish.edit.GenerateVideoManifestSegment", "Async, mVideoFileDir:%s, call AVideoCodec.recordSubmit() error = %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, localUnsatisfiedLinkError });
      synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oli
 * JD-Core Version:    0.7.0.1
 */