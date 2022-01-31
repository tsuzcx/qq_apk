import android.telephony.PhoneStateListener;
import com.tencent.av.smallscreen.BaseSmallScreenService;

public class joi
  extends PhoneStateListener
{
  public joi(BaseSmallScreenService paramBaseSmallScreenService) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    super.onCallStateChanged(paramInt, paramString);
    this.a.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     joi
 * JD-Core Version:    0.7.0.1
 */