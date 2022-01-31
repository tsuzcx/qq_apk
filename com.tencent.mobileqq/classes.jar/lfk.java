import android.content.Context;
import android.content.IntentFilter;
import com.tencent.av.app.VideoAppInterface;
import mqq.app.MobileQQ;

public class lfk
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private lfl jdField_a_of_type_Lfl;
  
  public lfk(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void a()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.jdField_a_of_type_Lfl = new lfl();
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext().registerReceiver(this.jdField_a_of_type_Lfl, localIntentFilter);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_Lfl != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext().unregisterReceiver(this.jdField_a_of_type_Lfl);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfk
 * JD-Core Version:    0.7.0.1
 */