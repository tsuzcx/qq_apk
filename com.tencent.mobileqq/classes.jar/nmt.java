import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class nmt
  extends bezs
{
  public BidDownloader a;
  
  public nmt(QQAppInterface paramQQAppInterface, String paramString, BidDownloader paramBidDownloader)
  {
    super(paramQQAppInterface, paramString);
    this.a = paramBidDownloader;
  }
  
  protected void realCancel()
  {
    QLog.i(nmq.a, 1, "cancel predown bid=" + this.a.a);
  }
  
  protected void realStart()
  {
    QLog.i(nmq.a, 1, "start predown bid=" + this.a.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nmt
 * JD-Core Version:    0.7.0.1
 */