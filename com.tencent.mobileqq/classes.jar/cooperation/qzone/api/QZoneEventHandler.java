package cooperation.qzone.api;

import android.content.Intent;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import cooperation.qzone.util.QZLog;

public class QZoneEventHandler
{
  private static final String TAG = "QZoneEventHandler";
  
  public static boolean handleActivityEvent(Object paramObject, int paramInt1, int paramInt2, Intent paramIntent)
  {
    QZLog.i("QZoneEventHandler", "handleActivityEvent: " + paramInt1 + " " + paramInt2);
    switch (paramInt1)
    {
    default: 
      return false;
    }
    if (((paramObject instanceof FriendChatPie)) && (((FriendChatPie)paramObject).a != null)) {
      ((FriendChatPie)paramObject).a.a(paramInt1, paramInt2, paramIntent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.api.QZoneEventHandler
 * JD-Core Version:    0.7.0.1
 */