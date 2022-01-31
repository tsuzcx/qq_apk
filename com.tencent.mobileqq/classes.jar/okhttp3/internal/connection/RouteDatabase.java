package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

public final class RouteDatabase
{
  private final Set<Route> failedRoutes = new LinkedHashSet();
  
  public void connected(Route paramRoute)
  {
    try
    {
      this.failedRoutes.remove(paramRoute);
      return;
    }
    finally
    {
      paramRoute = finally;
      throw paramRoute;
    }
  }
  
  public void failed(Route paramRoute)
  {
    try
    {
      this.failedRoutes.add(paramRoute);
      return;
    }
    finally
    {
      paramRoute = finally;
      throw paramRoute;
    }
  }
  
  public boolean shouldPostpone(Route paramRoute)
  {
    try
    {
      boolean bool = this.failedRoutes.contains(paramRoute);
      return bool;
    }
    finally
    {
      paramRoute = finally;
      throw paramRoute;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.connection.RouteDatabase
 * JD-Core Version:    0.7.0.1
 */