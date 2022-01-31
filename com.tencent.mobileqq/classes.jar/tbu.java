import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.qcall.LightalkSwitchManager;
import com.tencent.mobileqq.qcall.LightalkSwitchObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressNotifier;

public class tbu
  extends LightalkSwitchObserver
{
  public tbu(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
    if (!paramBoolean) {
      PermisionPrivacyActivity.a(this.a, 2131436049);
    }
    PermisionPrivacyActivity.a(this.a, this.a.i.a(), PermisionPrivacyActivity.a(this.a).b());
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.a, this.a.i.a(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tbu
 * JD-Core Version:    0.7.0.1
 */