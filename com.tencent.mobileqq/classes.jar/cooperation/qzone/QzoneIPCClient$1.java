package cooperation.qzone;

import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

class QzoneIPCClient$1
  extends QIPCModule
{
  QzoneIPCClient$1(QzoneIPCClient paramQzoneIPCClient, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("put_config".endsWith(paramString))
    {
      QLog.d("QzoneIPCClient", 3, "serverCallbackModule oncall " + paramString);
      LocalMultiProcConfig.clearAllConfig();
      LocalMultiProcConfig.loadAllConfig();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCClient.1
 * JD-Core Version:    0.7.0.1
 */