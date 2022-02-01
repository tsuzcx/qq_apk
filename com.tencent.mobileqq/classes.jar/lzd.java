import android.telephony.PhoneStateListener;
import com.tencent.av.smallscreen.BaseSmallScreenService;

public class lzd
  extends PhoneStateListener
{
  public lzd(BaseSmallScreenService paramBaseSmallScreenService) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    super.onCallStateChanged(paramInt, paramString);
    this.a.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lzd
 * JD-Core Version:    0.7.0.1
 */