import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class nky
  extends beat
{
  public BidDownloader a;
  
  public nky(QQAppInterface paramQQAppInterface, String paramString, BidDownloader paramBidDownloader)
  {
    super(paramQQAppInterface, paramString);
    this.a = paramBidDownloader;
  }
  
  protected void realCancel()
  {
    QLog.i(nkv.a, 1, "cancel predown bid=" + this.a.a);
  }
  
  protected void realStart()
  {
    QLog.i(nkv.a, 1, "start predown bid=" + this.a.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nky
 * JD-Core Version:    0.7.0.1
 */