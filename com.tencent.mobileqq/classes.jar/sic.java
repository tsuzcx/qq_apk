import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class sic
  extends FileObserver
{
  sic(sib paramsib, String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramInt);
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScreenshotContentObserver", 2, "onEvent->time:" + System.currentTimeMillis() + ", path:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt != 256)) {}
    while ((paramString.equalsIgnoreCase(sib.a(this.jdField_a_of_type_Sib))) || (paramString.contains("temp")) || (sib.a(this.jdField_a_of_type_Sib) == null)) {
      return;
    }
    sib.a(this.jdField_a_of_type_Sib).a(null, this.jdField_a_of_type_JavaLangString + paramString, 1);
    sib.a(this.jdField_a_of_type_Sib, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sic
 * JD-Core Version:    0.7.0.1
 */