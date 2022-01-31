import com.tencent.component.network.utils.http.pool.ConnFactory;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.DefaultClientConnection;

class pjh
  implements ConnFactory
{
  public OperatedClientConnection a(HttpRoute paramHttpRoute)
  {
    return new DefaultClientConnection();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pjh
 * JD-Core Version:    0.7.0.1
 */