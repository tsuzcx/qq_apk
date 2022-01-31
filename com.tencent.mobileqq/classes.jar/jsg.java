import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URI;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class jsg
  implements Runnable
{
  public jsg(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity, String paramString) {}
  
  public void run()
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.jdField_a_of_type_JavaLangString, 1, "getRedirectInfo, url[" + this.jdField_a_of_type_JavaLangString + "]");
    AudioHelper.b("加入讨论组_获取讨论组签名");
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    Object localObject1 = new BasicHttpContext();
    HttpGet localHttpGet = new HttpGet(this.jdField_a_of_type_JavaLangString);
    try
    {
      localDefaultHttpClient.execute(localHttpGet, (HttpContext)localObject1);
      localObject1 = ((HttpUriRequest)((HttpContext)localObject1).getAttribute("http.request")).getURI().toString();
      if (localObject2 == null) {
        break label365;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1 = localException1;
        localObject1 = null;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.jdField_a_of_type_JavaLangString, 2, "getRedirectInfo.run e = " + localException1);
        }
        localDefaultHttpClient.getConnectionManager().shutdown();
      }
    }
    finally
    {
      localDefaultHttpClient.getConnectionManager().shutdown();
    }
    if (localObject2.startsWith("http://qm.qq.com/cgi-bin/dc/ft?k="))
    {
      String str = localObject2.substring("http://qm.qq.com/cgi-bin/dc/ft?k=".length());
      QLog.w(this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.jdField_a_of_type_JavaLangString, 1, "getRedirectInfo.run, sig[" + str + "]");
      this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(str, 0);
      return;
    }
    label365:
    this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.a(0, -161);
    this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jsg
 * JD-Core Version:    0.7.0.1
 */