import com.tencent.component.network.utils.http.pool.PoolEntry;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;

public class pji
  extends PoolEntry
{
  HttpRoute jdField_a_of_type_OrgApacheHttpConnRoutingHttpRoute;
  private RouteTracker jdField_a_of_type_OrgApacheHttpConnRoutingRouteTracker;
  
  public pji(Log paramLog, String paramString, HttpRoute paramHttpRoute, OperatedClientConnection paramOperatedClientConnection, long paramLong, TimeUnit paramTimeUnit)
  {
    super(paramString, paramHttpRoute, paramOperatedClientConnection, paramLong, paramTimeUnit);
    this.jdField_a_of_type_OrgApacheHttpConnRoutingHttpRoute = paramHttpRoute;
    this.jdField_a_of_type_OrgApacheHttpConnRoutingRouteTracker = new RouteTracker(paramHttpRoute);
  }
  
  HttpRoute a()
  {
    return this.jdField_a_of_type_OrgApacheHttpConnRoutingRouteTracker.toRoute();
  }
  
  RouteTracker a()
  {
    return this.jdField_a_of_type_OrgApacheHttpConnRoutingRouteTracker;
  }
  
  public void a()
  {
    this.jdField_a_of_type_OrgApacheHttpConnRoutingRouteTracker = new RouteTracker(this.jdField_a_of_type_OrgApacheHttpConnRoutingHttpRoute);
  }
  
  public boolean a()
  {
    return !((OperatedClientConnection)b()).isOpen();
  }
  
  public boolean a(long paramLong)
  {
    return super.a(paramLong);
  }
  
  public void b()
  {
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)b();
    try
    {
      localOperatedClientConnection.close();
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pji
 * JD-Core Version:    0.7.0.1
 */