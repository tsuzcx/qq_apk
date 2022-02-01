package dov.com.qq.im.capture.util;

import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.lang.ref.WeakReference;

public class DoodleLayoutConnector
{
  private static DoodleLayoutConnector jdField_a_of_type_DovComQqImCaptureUtilDoodleLayoutConnector;
  private WeakReference<DoodleLayout> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<DoodleLayout> b;
  
  public static DoodleLayoutConnector a()
  {
    if (jdField_a_of_type_DovComQqImCaptureUtilDoodleLayoutConnector == null) {
      jdField_a_of_type_DovComQqImCaptureUtilDoodleLayoutConnector = new DoodleLayoutConnector();
    }
    return jdField_a_of_type_DovComQqImCaptureUtilDoodleLayoutConnector;
  }
  
  public DoodleLayout a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
          localObject1 = (DoodleLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        }
      }
    }
    for (;;)
    {
      if ((localObject1 == null) && (QLog.isColorLevel())) {
        QLog.e("DoodleLayoutConnector", 2, "getDoodleLayout null, not init yet");
      }
      return localObject1;
      localObject1 = localObject2;
      if (this.b != null)
      {
        localObject1 = localObject2;
        if (this.b.get() != null) {
          localObject1 = (DoodleLayout)this.b.get();
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayoutConnector", 2, "unbind " + paramInt);
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.b = null;
  }
  
  public void a(int paramInt, DoodleLayout paramDoodleLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayoutConnector", 2, "bind " + paramInt);
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDoodleLayout);
      return;
    }
    this.b = new WeakReference(paramDoodleLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.util.DoodleLayoutConnector
 * JD-Core Version:    0.7.0.1
 */