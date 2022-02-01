import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.avgame.ui.AvGameLoadingActivity;
import com.tencent.avgame.ui.AvGameLoadingActivity.5.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class niy
  implements nax
{
  public niy(AvGameLoadingActivity paramAvGameLoadingActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, "onResDownloadStart");
    }
    this.a.jdField_a_of_type_Int = 0;
    AvGameLoadingActivity.a(this.a, this.a.jdField_a_of_type_Int);
    AvGameLoadingActivity.b(this.a, true);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, "onResDownloadProgress and percent is " + paramInt);
    }
    this.a.jdField_a_of_type_Int = (paramInt / this.a.b);
    AvGameLoadingActivity.a(this.a, this.a.jdField_a_of_type_Int);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, "onResDownloadReady");
    }
    SharedPreferences localSharedPreferences;
    if (AvGameLoadingActivity.e(this.a))
    {
      AvGameLoadingActivity.a(this.a);
      AvGameLoadingActivity.b(this.a, false);
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4);
      if (!paramString.endsWith("/")) {
        break label125;
      }
    }
    for (;;)
    {
      localSharedPreferences.edit().putString("resPath", paramString).commit();
      bcef.b(null, "dc00898", "", "", "0X800B043", "0X800B043", 0, 0, "", "", "", "");
      return;
      ThreadManager.getUIHandlerV2().postDelayed(new AvGameLoadingActivity.5.1(this), 150L);
      break;
      label125:
      paramString = paramString + File.separator;
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 1, "onResDownloadFailed");
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    bcef.b(null, "dc00898", "", "", "0X800B044", "0X800B044", 0, 0, "" + paramInt, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     niy
 * JD-Core Version:    0.7.0.1
 */