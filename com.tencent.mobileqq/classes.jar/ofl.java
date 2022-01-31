import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import cooperation.liveroom.LiveRoomGiftCallback;

class ofl
  implements LiveRoomGiftCallback
{
  ofl(ofi paramofi) {}
  
  public void onCall(int paramInt, String paramString)
  {
    if (paramInt == 7)
    {
      QLog.d("KandianAdPandent", 2, "Vpng play completion!");
      ofi.a(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ofl
 * JD-Core Version:    0.7.0.1
 */