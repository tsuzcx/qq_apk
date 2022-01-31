import android.telephony.PhoneStateListener;
import com.tencent.av.smallscreen.BaseSmallScreenService;

public class loh
  extends PhoneStateListener
{
  public loh(BaseSmallScreenService paramBaseSmallScreenService) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    super.onCallStateChanged(paramInt, paramString);
    this.a.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     loh
 * JD-Core Version:    0.7.0.1
 */