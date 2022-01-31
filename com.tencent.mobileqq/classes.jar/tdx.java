import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.CardObserver;

public class tdx
  extends CardObserver
{
  public tdx(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  protected void g(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.setResult(-1);
      this.a.b(2131434962);
    }
    for (;;)
    {
      this.a.a = false;
      this.a.finish();
      return;
      this.a.b(2131434963);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tdx
 * JD-Core Version:    0.7.0.1
 */