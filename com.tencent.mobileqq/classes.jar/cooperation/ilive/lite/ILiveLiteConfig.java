package cooperation.ilive.lite;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class ILiveLiteConfig
{
  private static int a = -1;
  
  public static boolean a()
  {
    if (a == -1) {
      a = BaseApplicationImpl.getContext().getSharedPreferences("ilive_config_sp", 4).getInt("web_view_single", 0);
    }
    return a == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.ILiveLiteConfig
 * JD-Core Version:    0.7.0.1
 */