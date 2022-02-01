package cooperation.gmersdk_warper;

import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class TMG_Downloader$DownloadContrl$1
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
    if (this.c.c == localHttpNetReq) {
      this.c.c = null;
    }
    boolean bool = QLog.isColorLevel();
    int i = 1;
    if (bool) {
      QLog.i("TMG_Downloader", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localHttpNetReq.mReqUrl, Integer.valueOf(paramNetResp.mResult), Integer.valueOf(paramNetResp.mHttpCode), this.a }));
    }
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = new File(localHttpNetReq.mOutPath);
      if (paramNetResp.exists()) {
        try
        {
          paramNetResp = paramNetResp.getParent();
          FileUtils.uncompressZip(localHttpNetReq.mOutPath, paramNetResp, false);
          TMG_Downloader.a(this.b.a);
        }
        catch (Exception paramNetResp)
        {
          paramNetResp.printStackTrace();
        }
      }
    }
    i = 0;
    if (i != 0)
    {
      if (this.c.d != null)
      {
        this.c.d.a(100);
        this.c.d.a(0, "Download Complete!!!");
      }
      this.c.a = false;
      return;
    }
    if (this.c.d != null) {
      this.c.d.a(2, "");
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    } else if (paramLong1 >= paramLong2) {
      i = 99;
    } else {
      i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    }
    if (this.c.d != null) {
      this.c.d.a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.gmersdk_warper.TMG_Downloader.DownloadContrl.1
 * JD-Core Version:    0.7.0.1
 */