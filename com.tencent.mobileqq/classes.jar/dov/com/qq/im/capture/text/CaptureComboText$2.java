package dov.com.qq.im.capture.text;

import com.tencent.qphone.base.util.QLog;

class CaptureComboText$2
  implements DynamicTextConfigManager.IDynamicTextResDownloadCallback
{
  CaptureComboText$2(CaptureComboText paramCaptureComboText) {}
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText onUpdateProgress, progress is : " + paramFloat);
    }
    CaptureComboText.a(this.a, paramFloat);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText onDownloadFinish, success: " + paramBoolean);
    }
    if (paramBoolean)
    {
      CaptureComboText.a(this.a, 3);
      this.a.b();
      return;
    }
    CaptureComboText.a(this.a, 2);
    this.a.a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.CaptureComboText.2
 * JD-Core Version:    0.7.0.1
 */