import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class sif
  extends FileObserver
{
  sif(sie paramsie, String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramInt);
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScreenshotContentObserver", 2, "onEvent->time:" + System.currentTimeMillis() + ", path:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt != 256)) {}
    while ((paramString.equalsIgnoreCase(sie.a(this.jdField_a_of_type_Sie))) || (paramString.contains("temp")) || (sie.a(this.jdField_a_of_type_Sie) == null)) {
      return;
    }
    sie.a(this.jdField_a_of_type_Sie).a(null, this.jdField_a_of_type_JavaLangString + paramString, 1);
    sie.a(this.jdField_a_of_type_Sie, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sif
 * JD-Core Version:    0.7.0.1
 */