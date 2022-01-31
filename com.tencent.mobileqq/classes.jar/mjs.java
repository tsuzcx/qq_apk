import android.telephony.PhoneStateListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.qphone.base.util.QLog;

public class mjs
  extends PhoneStateListener
{
  public mjs(VideoVolumeControl paramVideoVolumeControl) {}
  
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
      this.a.d(true);
      return;
    }
    this.a.d(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mjs
 * JD-Core Version:    0.7.0.1
 */