package dov.com.qq.im.ae.cmshow;

import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResManager.AEDownloadCallBack;
import dov.com.qq.im.ae.util.AEQLog;
import eipc.EIPCResult;
import java.util.List;

class AECMShowQipcModule$CmShowAEDownloadCallBack
  implements AEResManager.AEDownloadCallBack
{
  private int jdField_a_of_type_Int = 0;
  private int b = 0;
  private int c;
  
  public AECMShowQipcModule$CmShowAEDownloadCallBack(AECMShowQipcModule paramAECMShowQipcModule, int paramInt)
  {
    this.c = paramInt;
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    AEQLog.b("AECMShowQipcModule", "CmShowAEDownloadCallBack, localFilePath=" + paramString + ", downloaded=" + paramBoolean + ", errorType=" + paramInt);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_Int + this.b == AECMShowQipcModule.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowQipcModule).size())
        {
          paramAEResInfo = new EIPCResult();
          if (this.b == 0) {
            break;
          }
          paramAEResInfo.code = -1;
          this.jdField_a_of_type_DovComQqImAeCmshowAECMShowQipcModule.callbackResult(this.c, paramAEResInfo);
        }
        return;
      }
      finally {}
      this.b += 1;
    }
    paramAEResInfo.code = 0;
    this.jdField_a_of_type_DovComQqImAeCmshowAECMShowQipcModule.callbackResult(this.c, paramAEResInfo);
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowQipcModule.CmShowAEDownloadCallBack
 * JD-Core Version:    0.7.0.1
 */