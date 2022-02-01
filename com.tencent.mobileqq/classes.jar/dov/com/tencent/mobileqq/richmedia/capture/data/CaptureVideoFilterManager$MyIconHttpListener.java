package dov.com.tencent.mobileqq.richmedia.capture.data;

import com.tencent.av.AVLog;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.util.concurrent.atomic.AtomicInteger;

class CaptureVideoFilterManager$MyIconHttpListener
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    FilterDesc localFilterDesc = (FilterDesc)paramNetResp.mReq.getUserData();
    if (paramNetResp.mResult != 0)
    {
      AVLog.printColorLog("CaptureVideoFilterManager", "download IconFile failed. errorCode: " + paramNetResp.mErrCode + ", errorMsg: " + paramNetResp.mErrDesc + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((CaptureVideoFilterManager.a(this.a).decrementAndGet() == 0) && (CaptureVideoFilterManager.a(this.a) != null)) {
      CaptureVideoFilterManager.a(this.a).a(true);
    }
    AVLog.printColorLog("CaptureVideoFilterManager", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.MyIconHttpListener
 * JD-Core Version:    0.7.0.1
 */