import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.MessageObserver;

public class tgp
  extends MessageObserver
{
  public tgp(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.a.a != null) && (this.a.a.a.equals(paramString))) {
      this.a.a(paramBoolean, false);
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.a.a != null) && (this.a.a.a.equals(paramString))) {
      this.a.a(paramBoolean, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tgp
 * JD-Core Version:    0.7.0.1
 */