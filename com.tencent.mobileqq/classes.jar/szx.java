import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class szx
  extends FileObserver
{
  szx(szw paramszw, String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramInt);
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScreenshotContentObserver", 2, "onEvent->time:" + System.currentTimeMillis() + ", path:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt != 256)) {}
    while ((paramString.equalsIgnoreCase(szw.a(this.jdField_a_of_type_Szw))) || (paramString.contains("temp")) || (szw.a(this.jdField_a_of_type_Szw) == null)) {
      return;
    }
    szw.a(this.jdField_a_of_type_Szw).a(null, this.jdField_a_of_type_JavaLangString + paramString, 1);
    szw.a(this.jdField_a_of_type_Szw, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     szx
 * JD-Core Version:    0.7.0.1
 */