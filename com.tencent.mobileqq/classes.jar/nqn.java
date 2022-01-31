import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import cooperation.liveroom.LiveRoomGiftCallback;

class nqn
  implements LiveRoomGiftCallback
{
  nqn(nqi paramnqi) {}
  
  public void onCall(int paramInt, String paramString)
  {
    if (paramInt == 7)
    {
      QLog.d("KandianAdPandent", 2, "Vpng play completion!");
      nqi.a(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqn
 * JD-Core Version:    0.7.0.1
 */