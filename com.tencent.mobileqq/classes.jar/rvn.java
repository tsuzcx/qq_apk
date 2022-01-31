import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class rvn
  extends FileObserver
{
  rvn(rvm paramrvm, String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramInt);
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScreenshotContentObserver", 2, "onEvent->time:" + System.currentTimeMillis() + ", path:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt != 256)) {}
    while ((paramString.equalsIgnoreCase(rvm.a(this.jdField_a_of_type_Rvm))) || (paramString.contains("temp")) || (rvm.a(this.jdField_a_of_type_Rvm) == null)) {
      return;
    }
    rvm.a(this.jdField_a_of_type_Rvm).a(null, this.jdField_a_of_type_JavaLangString + paramString, 1);
    rvm.a(this.jdField_a_of_type_Rvm, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvn
 * JD-Core Version:    0.7.0.1
 */