package cooperation.qqcircle.picload;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.data.Option;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class QCircleHttpUrlDW$1
  implements HostnameVerifier
{
  QCircleHttpUrlDW$1(Option paramOption) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    int i = RFLog.USR;
    paramString = new StringBuilder();
    paramString.append("seq = ");
    paramString.append(this.val$option.getSeq());
    paramString.append("getHttpConnection verify :");
    paramString.append(true);
    RFLog.i("QCircleFeedPicLoader", i, paramString.toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleHttpUrlDW.1
 * JD-Core Version:    0.7.0.1
 */