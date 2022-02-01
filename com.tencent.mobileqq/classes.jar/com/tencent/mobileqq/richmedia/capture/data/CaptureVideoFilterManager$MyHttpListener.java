package com.tencent.mobileqq.richmedia.capture.data;

import com.tencent.av.AVLog;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class CaptureVideoFilterManager$MyHttpListener
  implements INetEngineListener
{
  CaptureVideoFilterManager$MyHttpListener(CaptureVideoFilterManager paramCaptureVideoFilterManager) {}
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = (FilterDesc)paramNetResp.mReq.getUserData();
    if (paramNetResp.mResult != 0) {
      AVLog.printColorLog("CaptureVideoFilterManager", "download file failed. errorCode: " + paramNetResp.mErrCode + ", errorMsg: " + paramNetResp.mErrDesc + ", file: " + ((FilterDesc)localObject).resurl);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
      {
        AVLog.printColorLog("CaptureVideoFilterManager", "download file failed: md5 is not match.");
        FileUtils.e(paramNetResp.mReq.mOutPath);
        return;
      }
      AVLog.printColorLog("CaptureVideoFilterManager", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
      try
      {
        localObject = CaptureVideoFilterManager.b;
        FileUtils.a(paramNetResp.mReq.mOutPath, (String)localObject, false);
        FileUtils.e(paramNetResp.mReq.mOutPath);
        if ((CaptureVideoFilterManager.a(this.a).decrementAndGet() == 0) && (CaptureVideoFilterManager.a(this.a) != null))
        {
          CaptureVideoFilterManager.a(this.a).a(true);
          return;
        }
      }
      catch (IOException paramNetResp)
      {
        paramNetResp.printStackTrace();
        AVLog.printColorLog("CaptureVideoFilterManager", "unzip file failed.");
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.MyHttpListener
 * JD-Core Version:    0.7.0.1
 */