import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoDownloadManager.VideoDownloadCallback;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.IOException;

public class lkv
  implements INetEngine.INetEngineListener
{
  public lkv(ReadInJoyVideoDownloadManager paramReadInJoyVideoDownloadManager) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyVideoDownloadManager", 2, "onUpdateProgeress() curOffset=" + paramLong1 + "，totalLen=" + paramLong2 + ", progress=" + i);
    }
    if (ReadInJoyVideoDownloadManager.a(this.a) != null) {
      ReadInJoyVideoDownloadManager.a(this.a).a(i);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.a == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyVideoDownloadManager", 2, "onResult() resp.mResult=" + paramNetResp.a);
      }
      Object localObject;
      if (bool)
      {
        localObject = new File(ReadInJoyVideoDownloadManager.a(this.a));
        paramNetResp = "";
      }
      try
      {
        localObject = MD5FileUtil.a((File)localObject);
        paramNetResp = (NetResp)localObject;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
      ReadInJoyVideoDownloadManager.a(this.a, ReadInJoyVideoDownloadManager.a(this.a) + "_" + paramNetResp);
      FileUtils.c(ReadInJoyVideoDownloadManager.a(this.a), ReadInJoyVideoDownloadManager.b(this.a));
      if (ReadInJoyVideoDownloadManager.a(this.a) != null) {
        ReadInJoyVideoDownloadManager.a(this.a).a(ReadInJoyVideoDownloadManager.c(this.a), ReadInJoyVideoDownloadManager.b(this.a), bool);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lkv
 * JD-Core Version:    0.7.0.1
 */