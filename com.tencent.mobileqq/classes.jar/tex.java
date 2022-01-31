import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.contacts.base.CardConfigManager;

public class tex
  implements Runnable
{
  public tex(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    CardConfigManager localCardConfigManager = new CardConfigManager(this.a.app);
    PermisionPrivacyActivity.a(this.a, localCardConfigManager.a());
    this.a.runOnUiThread(new tey(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tex
 * JD-Core Version:    0.7.0.1
 */