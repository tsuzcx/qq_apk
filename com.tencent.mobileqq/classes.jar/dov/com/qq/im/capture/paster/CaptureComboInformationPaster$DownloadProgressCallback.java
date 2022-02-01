package dov.com.qq.im.capture.paster;

import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import java.lang.ref.WeakReference;

class CaptureComboInformationPaster$DownloadProgressCallback
  implements QIMInformationPasterManager.IInformationPasterResDownloaderCallback
{
  private float jdField_a_of_type_Float;
  private WeakReference<CaptureComboInformationPaster> jdField_a_of_type_JavaLangRefWeakReference;
  
  public CaptureComboInformationPaster$DownloadProgressCallback(CaptureComboInformationPaster paramCaptureComboInformationPaster)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCaptureComboInformationPaster);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(boolean paramBoolean, String paramString, InfomationFacePackage.Item paramItem)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Float = 1.0F;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        ((CaptureComboInformationPaster)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b();
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Float = 0.0F;
    } while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null);
    ((CaptureComboInformationPaster)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.CaptureComboInformationPaster.DownloadProgressCallback
 * JD-Core Version:    0.7.0.1
 */