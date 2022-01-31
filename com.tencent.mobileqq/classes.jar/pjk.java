import com.tencent.component.network.utils.http.PoolingClientConnectionManager;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;

public class pjk
  implements ClientConnectionRequest
{
  public pjk(PoolingClientConnectionManager paramPoolingClientConnectionManager, Future paramFuture) {}
  
  public void abortRequest()
  {
    this.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
  }
  
  public ManagedClientConnection getConnection(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkUtilsHttpPoolingClientConnectionManager.a(this.jdField_a_of_type_JavaUtilConcurrentFuture, paramLong, paramTimeUnit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pjk
 * JD-Core Version:    0.7.0.1
 */