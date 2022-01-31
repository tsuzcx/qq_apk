import android.content.IntentFilter;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.qphone.base.util.QLog;

public class kam
  implements Runnable
{
  public kam(PSTNC2CActivity paramPSTNC2CActivity) {}
  
  public void run()
  {
    try
    {
      this.a.a = new kay(this.a);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.a.registerReceiver(this.a.a, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PSTNC2CActivity", 2, "Exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kam
 * JD-Core Version:    0.7.0.1
 */