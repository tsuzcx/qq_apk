package dov.com.tencent.mobileqq.activity.richmedia;

import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import java.io.IOException;

class VideoFilterListDownloader$MyListDownloaderListener
  implements INetEngineListener
{
  VideoFilterListDownloader$MyListDownloaderListener(VideoFilterListDownloader paramVideoFilterListDownloader) {}
  
  public void onResp(NetResp paramNetResp)
  {
    boolean bool = false;
    FilterDesc localFilterDesc = (FilterDesc)paramNetResp.mReq.getUserData();
    if (localFilterDesc != null)
    {
      if (paramNetResp.mResult == 0) {
        break label96;
      }
      QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed. errorCode: " + paramNetResp.mErrCode + ", errorMsg: " + paramNetResp.mErrDesc + ", file: " + localFilterDesc.resurl);
      VideoFilterListDownloader.a(this.a, localFilterDesc, 0L, 5);
    }
    for (;;)
    {
      VideoFilterListDownloader.a(this.a, localFilterDesc, bool);
      return;
      label96:
      if (!localFilterDesc.resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
      {
        QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed: md5 is not match.");
        FileUtils.e(paramNetResp.mReq.mOutPath);
      }
      else
      {
        QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener resFile success. file: " + localFilterDesc.name + localFilterDesc.resurl);
        try
        {
          String str = CaptureVideoFilterManager.b;
          FileUtils.a(paramNetResp.mReq.mOutPath, str, false);
          if (localFilterDesc.bundle == null) {
            localFilterDesc.bundle = new Bundle();
          }
          VideoFilterListDownloader.a(this.a, localFilterDesc, FileUtils.a(paramNetResp.mReq.mOutPath), 0);
          FileUtils.e(paramNetResp.mReq.mOutPath);
          bool = true;
        }
        catch (IOException paramNetResp)
        {
          paramNetResp.printStackTrace();
          QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener  unzip file failed.");
          VideoFilterListDownloader.a(this.a, localFilterDesc, 0L, 4);
        }
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader.MyListDownloaderListener
 * JD-Core Version:    0.7.0.1
 */