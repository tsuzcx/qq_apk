package dov.com.qq.im.capture.music.humrecognition.humming;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.humrecognition.recognize.RecognitionManager;
import java.io.File;

public class OriginalBgmRecognizer
  implements IRecognizer
{
  private float jdField_a_of_type_Float;
  private File jdField_a_of_type_JavaIoFile;
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaIoFile == null) || (!this.jdField_a_of_type_JavaIoFile.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("OriginalBgmRecognizer", 2, "recognize: invoked. info: audioFile not exist. mTargetAudioFile = " + this.jdField_a_of_type_JavaIoFile);
      }
      return;
    }
    RecognitionManager localRecognitionManager = (RecognitionManager)QIMManager.a().c(10);
    localRecognitionManager.a(this.jdField_a_of_type_Float);
    localRecognitionManager.a(this.jdField_a_of_type_JavaIoFile);
    localRecognitionManager.c();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.humming.OriginalBgmRecognizer
 * JD-Core Version:    0.7.0.1
 */