package cooperation.qqcircle.picload;

import com.tencent.qphone.base.util.QLog;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class QCircleHttpUrlDW$1
  implements HostnameVerifier
{
  QCircleHttpUrlDW$1(Option paramOption) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    QLog.i(AbsPicDW.TAG, 1, "seq = " + this.val$option.getSeq() + "getHttpConnection verify :" + true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleHttpUrlDW.1
 * JD-Core Version:    0.7.0.1
 */