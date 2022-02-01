package cooperation.ilive.util;

import com.tencent.ilive.LiveConfig;
import com.tencent.mobileqq.litelivesdk.sdkimpl.BaseLiteSDKImpl;

final class IlivePreloadHelper$2
  implements Runnable
{
  public void run()
  {
    BaseLiteSDKImpl.a(new LiveConfig());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.util.IlivePreloadHelper.2
 * JD-Core Version:    0.7.0.1
 */