import com.tencent.biz.qrcode.CustomAccessibilityDelegate;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate.CallBack;

public class osk
  implements Runnable
{
  public osk(CustomAccessibilityDelegate paramCustomAccessibilityDelegate) {}
  
  public void run()
  {
    if (CustomAccessibilityDelegate.a(this.a) != null) {
      CustomAccessibilityDelegate.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osk
 * JD-Core Version:    0.7.0.1
 */