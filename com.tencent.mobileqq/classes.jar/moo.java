import android.telephony.PhoneStateListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoVolumeControl;
import com.tencent.qphone.base.util.QLog;

public class moo
  extends PhoneStateListener
{
  public moo(FastWebVideoVolumeControl paramFastWebVideoVolumeControl) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 2, "onCallStateChanged:" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.a.b(true);
      return;
    }
    this.a.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     moo
 * JD-Core Version:    0.7.0.1
 */