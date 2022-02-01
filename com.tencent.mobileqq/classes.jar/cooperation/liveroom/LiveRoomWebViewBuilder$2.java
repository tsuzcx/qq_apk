package cooperation.liveroom;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.qphone.base.util.QLog;

class LiveRoomWebViewBuilder$2
  implements TeleScreenRunnable
{
  LiveRoomWebViewBuilder$2(LiveRoomWebViewBuilder paramLiveRoomWebViewBuilder, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      LiveRoomWebViewBuilder.access$000(this.this$0).startActivity(this.val$intent);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("LiveRoomWebViewBuilder", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomWebViewBuilder.2
 * JD-Core Version:    0.7.0.1
 */