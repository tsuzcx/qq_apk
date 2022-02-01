package cooperation.comic.utils;

import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class BoodoHippyBirdge$1
  implements EIPCResultCallback
{
  BoodoHippyBirdge$1(BoodoHippyBirdge.ICheckPluginListener paramICheckPluginListener) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data;
    int i = paramEIPCResult.getInt("retCode");
    paramEIPCResult = paramEIPCResult.getString("msg");
    if (this.a != null) {
      this.a.a(i, paramEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.utils.BoodoHippyBirdge.1
 * JD-Core Version:    0.7.0.1
 */