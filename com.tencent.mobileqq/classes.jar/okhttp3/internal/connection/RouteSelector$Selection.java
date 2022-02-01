package okhttp3.internal.connection;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Route;

public final class RouteSelector$Selection
{
  private int nextRouteIndex = 0;
  private final List<Route> routes;
  
  RouteSelector$Selection(List<Route> paramList)
  {
    this.routes = paramList;
  }
  
  public List<Route> getAll()
  {
    return new ArrayList(this.routes);
  }
  
  public boolean hasNext()
  {
    return this.nextRouteIndex < this.routes.size();
  }
  
  public Route next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    List localList = this.routes;
    int i = this.nextRouteIndex;
    this.nextRouteIndex = (i + 1);
    return (Route)localList.get(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.connection.RouteSelector.Selection
 * JD-Core Version:    0.7.0.1
 */