package com.tencent.mobileqq.richmedia.capture.data;

import com.tencent.av.AVLog;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class CaptureVideoFilterManager$MyHttpListenerforBeauty
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = (CaptureVideoFilterManager.SkinColorFilterDesc)paramNetResp.mReq.getUserData();
    AVLog.printColorLog("CaptureVideoFilterManager", "download file call back. file = " + ((CaptureVideoFilterManager.SkinColorFilterDesc)localObject).a);
    if (paramNetResp.mResult != 0)
    {
      AVLog.printColorLog("CaptureVideoFilterManager", "download file faild. errcode = " + paramNetResp.mErrCode);
      return;
    }
    if (!((CaptureVideoFilterManager.SkinColorFilterDesc)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
    {
      AVLog.printColorLog("CaptureVideoFilterManager", "download file faild : md5 is not match.");
      FileUtils.e(paramNetResp.mReq.mOutPath);
      return;
    }
    AVLog.printColorLog("CaptureVideoFilterManager", "download file successed.");
    try
    {
      localObject = CaptureVideoFilterManager.a();
      FileUtils.a(paramNetResp.mReq.mOutPath, (String)localObject, false);
      FileUtils.e(paramNetResp.mReq.mOutPath);
      return;
    }
    catch (IOException paramNetResp)
    {
      paramNetResp.printStackTrace();
      AVLog.printColorLog("CaptureVideoFilterManager", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.MyHttpListenerforBeauty
 * JD-Core Version:    0.7.0.1
 */