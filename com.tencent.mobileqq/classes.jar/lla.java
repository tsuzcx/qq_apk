import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public final class lla
  implements Runnable
{
  public lla(boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    Object localObject = ReadInJoyHelper.a(ReadInJoyUtils.a(), this.jdField_a_of_type_Boolean, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove(this.jdField_a_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).apply();
      QLog.d("ReadInJoyUtils", 2, "delete data in sp successful ! key : " + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lla
 * JD-Core Version:    0.7.0.1
 */