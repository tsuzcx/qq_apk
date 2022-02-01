import android.telephony.PhoneStateListener;
import com.tencent.qphone.base.util.QLog;

class msl
  extends PhoneStateListener
{
  msl(msi parammsi) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneStatusMonitor", 2, "onCallStateChanged, state[" + paramInt + "], isCalling[" + msi.a(this.a) + "]");
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onCallStateChanged(paramInt, paramString);
      return;
      if (msi.a(this.a))
      {
        msi.a(this.a, false);
        continue;
        if (!msi.a(this.a)) {
          msi.a(this.a, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     msl
 * JD-Core Version:    0.7.0.1
 */