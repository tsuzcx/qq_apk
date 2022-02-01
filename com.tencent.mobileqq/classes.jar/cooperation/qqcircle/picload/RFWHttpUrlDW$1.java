package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class RFWHttpUrlDW$1
  implements HostnameVerifier
{
  RFWHttpUrlDW$1(Option paramOption) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    paramString = new StringBuilder();
    paramString.append("seq = ");
    paramString.append(this.val$option.getSeq());
    paramString.append("getHttpConnection verify :");
    paramString.append(true);
    QLog.i("QCircleFeedPicLoader", 1, paramString.toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.RFWHttpUrlDW.1
 * JD-Core Version:    0.7.0.1
 */