import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class tfj
  implements IStatusListener
{
  public tfj(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void a(int paramInt, RichStatus paramRichStatus, Object paramObject) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    PermisionPrivacyActivity.a(this.a, this.a.g.a(), paramBoolean);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1) {
      PermisionPrivacyActivity.a(this.a, 2131436066);
    }
    PermisionPrivacyActivity.a(this.a, this.a.g.a(), PermisionPrivacyActivity.a(this.a).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tfj
 * JD-Core Version:    0.7.0.1
 */