package cooperation.ilive.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ilive.LiveConfig;
import com.tencent.ilive.audiencepages.room.AudienceRoomViewPager;
import com.tencent.mobileqq.litelivesdk.sdkimpl.BaseLiteSDKImpl;

final class IlivePreloadHelper$2
  implements Runnable
{
  public void run()
  {
    BaseLiteSDKImpl.a(new LiveConfig());
    try
    {
      new AudienceRoomViewPager(BaseApplicationImpl.getContext());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.util.IlivePreloadHelper.2
 * JD-Core Version:    0.7.0.1
 */