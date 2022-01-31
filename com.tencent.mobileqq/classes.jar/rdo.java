import android.content.Context;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;

public class rdo
{
  private static String jdField_a_of_type_JavaLangString = Environment.getDataDirectory() + "/data/" + BaseApplicationImpl.sApplication.getBaseContext().getPackageName();
  private static boolean jdField_a_of_type_Boolean = a();
  
  private static boolean a()
  {
    boolean bool = false;
    if (AppSetting.jdField_a_of_type_JavaLangString.equals(bgmq.a("COPY_ASSET_VERSION", "", false))) {
      bool = true;
    }
    return bool;
  }
  
  public void a(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rdo
 * JD-Core Version:    0.7.0.1
 */