import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import com.tencent.av.utils.SignalStrengthReport;

public class kjg
  extends PhoneStateListener
{
  public kjg(SignalStrengthReport paramSignalStrengthReport) {}
  
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    this.a.c = this.a.a(paramSignalStrength);
    this.a.d = this.a.b(paramSignalStrength);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kjg
 * JD-Core Version:    0.7.0.1
 */