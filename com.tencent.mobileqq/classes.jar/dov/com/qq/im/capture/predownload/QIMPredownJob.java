package dov.com.qq.im.capture.predownload;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboBase;
import dov.com.qq.im.capture.data.CaptureComboDownloadListener;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.paster.CaptureComboPasterFactory;
import java.util.ArrayList;

public class QIMPredownJob
  implements CaptureComboDownloadListener
{
  public static final String[] a;
  public int a;
  public CaptureComboBase a;
  QIMPredownJob.Listener a;
  public String a;
  public int b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "NoNeedDown", "NoFound", "NeedDown" };
  }
  
  public int a()
  {
    CaptureComboBase localCaptureComboBase = a();
    int i;
    if (localCaptureComboBase != null) {
      if (localCaptureComboBase.a() == 2) {
        i = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMPredownManager", 2, String.format("getState %s %s %s %s ", new Object[] { toString(), "" + localCaptureComboBase, jdField_a_of_type_ArrayOfJavaLangString[i], QIMPredownManager.jdField_a_of_type_ArrayOfJavaLangString[this.b] }));
      }
      return i;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public CaptureComboBase a()
  {
    Object localObject1 = this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboBase;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      switch (this.b)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboBase = ((CaptureComboBase)localObject1);
      localObject2 = localObject1;
      return localObject2;
      localObject1 = ((CaptureComboManager)QIMManager.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = ((CaptureComboManager)QIMManager.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = CaptureComboPasterFactory.a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = CaptureComboPasterFactory.a("", this.jdField_a_of_type_JavaLangString, "forPredownlaod", 0.0F, 0.0F, 0.0F);
      continue;
      localObject1 = CaptureComboPasterFactory.b(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = CaptureComboPasterFactory.a(this.jdField_a_of_type_JavaLangString, new ArrayList(), 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void a()
  {
    CaptureComboBase localCaptureComboBase = a();
    if (localCaptureComboBase != null)
    {
      localCaptureComboBase.a(this);
      localCaptureComboBase.b();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "starDownload: " + this + localCaptureComboBase);
    }
  }
  
  public void a(CaptureComboBase paramCaptureComboBase) {}
  
  public void a(CaptureComboBase paramCaptureComboBase, int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCapturePredownloadQIMPredownJob$Listener.a(false, this);
  }
  
  public void a(QIMPredownJob.Listener paramListener)
  {
    this.jdField_a_of_type_DovComQqImCapturePredownloadQIMPredownJob$Listener = paramListener;
  }
  
  public void b(CaptureComboBase paramCaptureComboBase)
  {
    this.jdField_a_of_type_DovComQqImCapturePredownloadQIMPredownJob$Listener.a(true, this);
  }
  
  public String toString()
  {
    return "QIMPredownJob{" + this.jdField_a_of_type_Int + "," + QIMPredownManager.jdField_a_of_type_ArrayOfJavaLangString[this.b] + "," + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.predownload.QIMPredownJob
 * JD-Core Version:    0.7.0.1
 */