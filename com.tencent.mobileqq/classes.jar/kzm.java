import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class kzm
  implements HttpRequestRetryHandler
{
  private static HashSet<Class<?>> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private static HashSet<Class<?>> b = new HashSet();
  private final int jdField_a_of_type_Int;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet.add(NoHttpResponseException.class);
    jdField_a_of_type_JavaUtilHashSet.add(UnknownHostException.class);
    jdField_a_of_type_JavaUtilHashSet.add(SocketException.class);
    b.add(InterruptedIOException.class);
    b.add(SSLException.class);
  }
  
  public kzm(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected boolean a(HashSet<Class<?>> paramHashSet, Throwable paramThrowable)
  {
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext()) {
      if (((Class)paramHashSet.next()).isInstance(paramThrowable)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("Translator", 2, "[retryRequest] exception:" + paramIOException + "executionCount:" + paramInt);
    }
    Boolean localBoolean = (Boolean)paramHttpContext.getAttribute("http.request_sent");
    int i;
    boolean bool1;
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      i = 1;
      if (paramInt <= this.jdField_a_of_type_Int) {
        break label136;
      }
      bool1 = false;
    }
    for (;;)
    {
      label83:
      if (bool1) {
        if (!((HttpUriRequest)paramHttpContext.getAttribute("http.request")).getMethod().equals("POST")) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        if (bool1)
        {
          SystemClock.sleep(1500L);
          return bool1;
          i = 0;
          break;
          label136:
          if (a(b, paramIOException))
          {
            bool1 = false;
            break label83;
          }
          if (a(jdField_a_of_type_JavaUtilHashSet, paramIOException))
          {
            bool1 = true;
            break label83;
          }
          if (i != 0) {
            break label197;
          }
          bool1 = true;
          break label83;
          bool1 = false;
          continue;
        }
        paramIOException.printStackTrace();
        return bool1;
      }
      label197:
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kzm
 * JD-Core Version:    0.7.0.1
 */