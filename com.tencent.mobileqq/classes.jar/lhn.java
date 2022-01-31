import android.content.Context;
import android.content.IntentFilter;
import com.tencent.av.app.VideoAppInterface;
import mqq.app.MobileQQ;

public class lhn
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private lho jdField_a_of_type_Lho;
  
  public lhn(VideoAppInterface paramVideoAppInterface)
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
      this.jdField_a_of_type_Lho = new lho();
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext().registerReceiver(this.jdField_a_of_type_Lho, localIntentFilter);
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
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_Lho != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext().unregisterReceiver(this.jdField_a_of_type_Lho);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lhn
 * JD-Core Version:    0.7.0.1
 */