import android.telephony.PhoneStateListener;
import com.tencent.qphone.base.util.QLog;

class mtc
  extends PhoneStateListener
{
  mtc(msz parammsz) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneStatusMonitor", 2, "onCallStateChanged, state[" + paramInt + "], isCalling[" + msz.a(this.a) + "]");
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onCallStateChanged(paramInt, paramString);
      return;
      if (msz.a(this.a))
      {
        msz.a(this.a, false);
        continue;
        if (!msz.a(this.a)) {
          msz.a(this.a, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mtc
 * JD-Core Version:    0.7.0.1
 */