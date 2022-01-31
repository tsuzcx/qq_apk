import android.telephony.PhoneStateListener;
import com.tencent.qphone.base.util.QLog;

class qvq
  extends PhoneStateListener
{
  qvq(qvo paramqvo) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoVolumeController", 2, "onCallStateChanged:" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.a.a(true);
      return;
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qvq
 * JD-Core Version:    0.7.0.1
 */