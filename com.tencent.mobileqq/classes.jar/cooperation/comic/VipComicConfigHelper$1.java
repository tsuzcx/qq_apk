package cooperation.comic;

import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class VipComicConfigHelper$1
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.isSuccess()) {
      VipComicConfigHelper.a(paramEIPCResult.data.getString("config_json"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicConfigHelper.1
 * JD-Core Version:    0.7.0.1
 */