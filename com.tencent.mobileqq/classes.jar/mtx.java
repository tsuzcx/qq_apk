import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

class mtx
  extends PhoneStateListener
{
  mtx(mtv parammtv) {}
  
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    this.a.c = this.a.a(paramSignalStrength);
    this.a.d = this.a.b(paramSignalStrength);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mtx
 * JD-Core Version:    0.7.0.1
 */