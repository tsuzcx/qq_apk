import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

class mir
  extends PhoneStateListener
{
  mir(mip parammip) {}
  
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    this.a.c = this.a.a(paramSignalStrength);
    this.a.d = this.a.b(paramSignalStrength);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mir
 * JD-Core Version:    0.7.0.1
 */