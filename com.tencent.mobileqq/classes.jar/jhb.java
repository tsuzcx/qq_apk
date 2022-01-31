import android.os.Build;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class jhb
  implements Runnable
{
  public jhb(VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    if (!Build.MANUFACTURER.toLowerCase().equals("xiaomi")) {
      ImmersiveUtils.d = false;
    }
    boolean bool = ImmersiveUtils.a();
    long l2 = System.currentTimeMillis();
    VideoAppInterface.a(this.a, null);
    QLog.w(VideoAppInterface.c(), 1, "supportStatusBarDarkMode, support[" + bool + "], start[" + l1 + "], cost[" + (l2 - l1) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jhb
 * JD-Core Version:    0.7.0.1
 */