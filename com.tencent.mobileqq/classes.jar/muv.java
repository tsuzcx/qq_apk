import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

class muv
  extends PhoneStateListener
{
  muv(mut parammut) {}
  
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    this.a.c = this.a.a(paramSignalStrength);
    this.a.d = this.a.b(paramSignalStrength);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     muv
 * JD-Core Version:    0.7.0.1
 */