package cooperation.ilive.lite.module;

import com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule.InflateComponentTime;
import com.tencent.qphone.base.util.QLog;

public class IliveLuxuryGiftModule
  extends LiteLuxuryGiftModule
{
  protected RoomBizModule.InflateComponentTime getInflateTime()
  {
    return RoomBizModule.InflateComponentTime.ENTERROOM_INFLATE;
  }
  
  public void onDestroy()
  {
    try
    {
      super.onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.e("IliveLuxuryGiftModule", 1, "IliveLuxuryGiftModule destory error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveLuxuryGiftModule
 * JD-Core Version:    0.7.0.1
 */