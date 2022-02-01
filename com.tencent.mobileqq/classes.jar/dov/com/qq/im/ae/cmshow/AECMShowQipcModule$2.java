package dov.com.qq.im.ae.cmshow;

import android.os.Bundle;
import eipc.EIPCResult;
import java.util.HashMap;

class AECMShowQipcModule$2
  implements AECMShowResourceManager.CMJoyEssentialDownloadCallback
{
  AECMShowQipcModule$2(AECMShowQipcModule paramAECMShowQipcModule, int paramInt) {}
  
  public void a(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_resource_download_all_succeeded", paramBoolean);
    localBundle.putSerializable("key_resource_download_result", paramHashMap);
    this.jdField_a_of_type_DovComQqImAeCmshowAECMShowQipcModule.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowQipcModule.2
 * JD-Core Version:    0.7.0.1
 */