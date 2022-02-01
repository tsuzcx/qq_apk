import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;

public class nvj
  extends AbsPreDownloadTask
{
  public BidDownloader a;
  
  public nvj(QQAppInterface paramQQAppInterface, String paramString, BidDownloader paramBidDownloader)
  {
    super(paramQQAppInterface, paramString);
    this.a = paramBidDownloader;
  }
  
  public void realCancel()
  {
    QLog.i(nvg.a, 1, "cancel predown bid=" + this.a.a);
  }
  
  public void realStart()
  {
    QLog.i(nvg.a, 1, "start predown bid=" + this.a.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nvj
 * JD-Core Version:    0.7.0.1
 */