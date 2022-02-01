import android.os.Handler;
import android.os.Message;
import com.tencent.avgame.ui.AvGameLoadingActivity;
import com.tencent.mobileqq.dinifly.LottieDrawable;

public class nix
  implements ncc
{
  public nix(AvGameLoadingActivity paramAvGameLoadingActivity) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    localMessage.obj = paramLottieDrawable;
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nix
 * JD-Core Version:    0.7.0.1
 */