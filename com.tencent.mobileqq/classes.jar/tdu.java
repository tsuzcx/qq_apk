import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class tdu
  extends CardObserver
{
  public tdu(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!this.a.a.a.equals(paramString)) {
      return;
    }
    this.a.e();
    if (paramBoolean)
    {
      this.a.a(2131433453, 2);
      return;
    }
    this.a.a(2131433452, 1);
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2 != this.a.c.a()))
    {
      this.a.c.setOnCheckedChangeListener(null);
      this.a.c.setChecked(paramBoolean2);
      this.a.c.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2 != this.a.c.a()))
    {
      this.a.c.setOnCheckedChangeListener(null);
      this.a.c.setChecked(paramBoolean2);
      this.a.c.setOnCheckedChangeListener(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tdu
 * JD-Core Version:    0.7.0.1
 */