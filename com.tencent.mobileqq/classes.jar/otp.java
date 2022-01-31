import android.view.View;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.util.AccessibilityUtil;

public class otp
  implements Runnable
{
  public otp(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    CustomAccessibilityDelegate localCustomAccessibilityDelegate = new CustomAccessibilityDelegate(this.a.d, this.a);
    this.a.d.setAccessibilityDelegate(localCustomAccessibilityDelegate);
    AccessibilityUtil.a(this.a.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otp
 * JD-Core Version:    0.7.0.1
 */