import android.content.Context;
import android.text.TextUtils;
import com.google.zxing.client.android.wifi.BizWifiConfigManager;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class kna
  extends Thread
{
  public kna(SensorAPIJavaScript paramSensorAPIJavaScript, Context paramContext, String paramString) {}
  
  public void run()
  {
    int i = 15;
    String str = "";
    if ((i > 0) && (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a != null)) {
      if (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a.get() == null) {
        i = 2;
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.c = false;
        if (QLog.isDevelopLevel()) {
          QLog.d("SensorApi", 4, "run check end: " + i);
        }
        if (i != 0) {
          break label200;
        }
        int j = this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a();
        this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { Util.a(Integer.toString(i)), Util.a(str), Util.a(Integer.toString(j)) });
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("SensorApi", 4, "run check: " + i);
        }
        str = BizWifiConfigManager.a(this.jdField_a_of_type_AndroidContentContext);
        if (!TextUtils.isEmpty(str)) {
          i = 0;
        } else {
          try
          {
            Thread.sleep(2000L);
            i -= 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            i = 2;
          }
        }
      }
      continue;
      label200:
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { Util.a(Integer.toString(i)) });
      return;
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kna
 * JD-Core Version:    0.7.0.1
 */