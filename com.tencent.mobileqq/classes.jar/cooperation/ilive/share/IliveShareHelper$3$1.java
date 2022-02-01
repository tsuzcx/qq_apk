package cooperation.ilive.share;

import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class IliveShareHelper$3$1
  implements EIPCResultCallback
{
  IliveShareHelper$3$1(IliveShareHelper.3 param3) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null)) {
      IliveShareHelper.access$102(this.this$1.this$0, paramEIPCResult.data.getString("accountName"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.share.IliveShareHelper.3.1
 * JD-Core Version:    0.7.0.1
 */