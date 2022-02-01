import android.telephony.PhoneStateListener;
import com.tencent.qphone.base.util.QLog;

public class sgd
  extends PhoneStateListener
{
  sgd(sgc paramsgc) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "onCallStateChanged:" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.a.c(true);
      return;
    case 2: 
      this.a.c(true);
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgd
 * JD-Core Version:    0.7.0.1
 */