import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class mzl
  extends ayxp
{
  public BidDownloader a;
  
  public mzl(QQAppInterface paramQQAppInterface, String paramString, BidDownloader paramBidDownloader)
  {
    super(paramQQAppInterface, paramString);
    this.a = paramBidDownloader;
  }
  
  protected void realCancel()
  {
    QLog.i(mzi.a, 1, "cancel predown bid=" + this.a.a);
  }
  
  protected void realStart()
  {
    QLog.i(mzi.a, 1, "start predown bid=" + this.a.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     mzl
 * JD-Core Version:    0.7.0.1
 */