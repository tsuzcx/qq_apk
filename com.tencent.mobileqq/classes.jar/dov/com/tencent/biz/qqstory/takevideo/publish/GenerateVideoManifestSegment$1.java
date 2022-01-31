package dov.com.tencent.biz.qqstory.takevideo.publish;

import biuk;
import bjkk;
import com.tencent.maxvideo.mediadevice.AVCodec;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.concurrent.atomic.AtomicBoolean;
import urk;

public class GenerateVideoManifestSegment$1
  implements Runnable
{
  public GenerateVideoManifestSegment$1(biuk parambiuk, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    try
    {
      urk.a("Q.qqstory.publish.edit.GenerateVideoManifestSegment", "Async, mVideoCacheDir:%s, before call AVideoCodec.recordSubmit()", this.a.jdField_a_of_type_JavaLangString);
      bjkk.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      urk.e("Q.qqstory.publish.edit.GenerateVideoManifestSegment", "Async, mVideoCacheDir:%s, call AVideoCodec.recordSubmit() error = %s", new Object[] { this.a.jdField_a_of_type_JavaLangString, localUnsatisfiedLinkError });
      synchronized (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.GenerateVideoManifestSegment.1
 * JD-Core Version:    0.7.0.1
 */