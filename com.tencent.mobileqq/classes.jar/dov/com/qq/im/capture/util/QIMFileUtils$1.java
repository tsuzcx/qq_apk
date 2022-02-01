package dov.com.qq.im.capture.util;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class QIMFileUtils$1
  implements Runnable
{
  QIMFileUtils$1(File paramFile, String paramString1, String paramString2) {}
  
  public void run()
  {
    FileUtils.a(this.jdField_a_of_type_JavaIoFile.getPath() + File.separator, this.jdField_a_of_type_JavaLangString, this.b);
    if (QLog.isColorLevel()) {
      QLog.i("QIMFileUtils", 2, "paster config save to file " + this.jdField_a_of_type_JavaIoFile.getPath() + File.separator + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.util.QIMFileUtils.1
 * JD-Core Version:    0.7.0.1
 */