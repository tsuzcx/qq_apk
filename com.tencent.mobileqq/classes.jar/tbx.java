import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.contacts.base.CardConfigManager;

public class tbx
  implements Runnable
{
  public tbx(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    CardConfigManager localCardConfigManager = new CardConfigManager(this.a.app);
    PermisionPrivacyActivity.a(this.a, localCardConfigManager.a());
    this.a.runOnUiThread(new tby(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tbx
 * JD-Core Version:    0.7.0.1
 */