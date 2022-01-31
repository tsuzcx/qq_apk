import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.webviewplugin.OfflineWebResManager;

public class pai
  implements Runnable
{
  public pai(OfflineWebResManager paramOfflineWebResManager, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.b();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("Last_Check_Cache", System.currentTimeMillis()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pai
 * JD-Core Version:    0.7.0.1
 */