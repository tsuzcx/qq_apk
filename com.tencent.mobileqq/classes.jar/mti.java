import android.telephony.PhoneStateListener;
import com.tencent.qphone.base.util.QLog;

class mti
  extends PhoneStateListener
{
  mti(mtf parammtf) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneStatusMonitor", 2, "onCallStateChanged, state[" + paramInt + "], isCalling[" + mtf.a(this.a) + "]");
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onCallStateChanged(paramInt, paramString);
      return;
      if (mtf.a(this.a))
      {
        mtf.a(this.a, false);
        continue;
        if (!mtf.a(this.a)) {
          mtf.a(this.a, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mti
 * JD-Core Version:    0.7.0.1
 */