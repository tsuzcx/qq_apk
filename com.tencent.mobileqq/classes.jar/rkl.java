import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class rkl
  extends ConfigObserver
{
  public rkl(AboutActivity paramAboutActivity) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    AboutActivity.a(this.a, paramUpgradeDetailWrapper);
    paramUpgradeDetailWrapper = this.a.app.a();
    AboutActivity.a(this.a, paramUpgradeDetailWrapper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rkl
 * JD-Core Version:    0.7.0.1
 */