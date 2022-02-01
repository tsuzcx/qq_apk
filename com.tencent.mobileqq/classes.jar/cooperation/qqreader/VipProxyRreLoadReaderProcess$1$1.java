package cooperation.qqreader;

import com.tencent.biz.common.offline.AsyncBack;
import cooperation.qqreader.utils.Log;

class VipProxyRreLoadReaderProcess$1$1
  implements AsyncBack
{
  VipProxyRreLoadReaderProcess$1$1(VipProxyRreLoadReaderProcess.1 param1) {}
  
  public void loaded(String paramString, int paramInt)
  {
    Log.d("VipProxyRreLoadReaderProcess", "Load offline package finish, code = " + paramInt);
    if (paramInt != 0) {
      Log.a("VipProxyRreLoadReaderProcess", "offline update failed.");
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.VipProxyRreLoadReaderProcess.1.1
 * JD-Core Version:    0.7.0.1
 */