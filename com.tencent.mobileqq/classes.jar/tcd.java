import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.qphone.base.util.QLog;

public class tcd
  extends LBSObserver
{
  public tcd(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onUpdateGetSwitch| isSuc = " + paramBoolean1 + ", userType = " + paramInt + ", curSwitch = " + paramBoolean2);
    }
    if ((paramBoolean1) && (paramInt == 64)) {
      this.a.a(paramBoolean2);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onUpdateSetShareStatus| isSuc = " + paramBoolean1 + ", beShare = " + paramBoolean2);
    }
    if (!paramBoolean1) {
      this.a.a(2131436049, 1);
    }
    this.a.a(paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tcd
 * JD-Core Version:    0.7.0.1
 */