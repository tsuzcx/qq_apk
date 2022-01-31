import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

class mwh
  extends PhoneStateListener
{
  mwh(mwf parammwf) {}
  
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    this.a.c = this.a.a(paramSignalStrength);
    this.a.d = this.a.b(paramSignalStrength);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mwh
 * JD-Core Version:    0.7.0.1
 */