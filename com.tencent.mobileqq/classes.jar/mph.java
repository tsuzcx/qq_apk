import android.content.IntentFilter;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mph
  implements Runnable
{
  public mph(ReadInJoyGlobalReporter paramReadInJoyGlobalReporter) {}
  
  public void run()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      if (ReadInJoyGlobalReporter.b(this.a) == 0)
      {
        BaseApplicationImpl.getContext().registerReceiver(this.a.a, localIntentFilter);
        ReadInJoyGlobalReporter.a(this.a, 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyGlobalReporter", 2, "registerScreenListener");
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("ReadInJoyGlobalReporter", 2, "registerScreenListener:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mph
 * JD-Core Version:    0.7.0.1
 */