import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.OfflineExpire;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;

public class knx
  extends AbsPreDownloadTask
{
  BidDownloader a;
  
  public knx(QQAppInterface paramQQAppInterface, String paramString, BidDownloader paramBidDownloader)
  {
    super(paramQQAppInterface, paramString);
    this.a = paramBidDownloader;
  }
  
  protected void a()
  {
    QLog.i(OfflineExpire.a, 1, "start predown bid=" + this.a.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     knx
 * JD-Core Version:    0.7.0.1
 */