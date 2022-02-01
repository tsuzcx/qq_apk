import android.telephony.PhoneStateListener;
import com.tencent.qphone.base.util.QLog;

class mse
  extends PhoneStateListener
{
  mse(msb parammsb) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneStatusMonitor", 2, "onCallStateChanged, state[" + paramInt + "], isCalling[" + msb.a(this.a) + "]");
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onCallStateChanged(paramInt, paramString);
      return;
      if (msb.a(this.a))
      {
        msb.a(this.a, false);
        continue;
        if (!msb.a(this.a)) {
          msb.a(this.a, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mse
 * JD-Core Version:    0.7.0.1
 */