package com.tencent.upload.network.route;

import com.tencent.upload.utils.Const.FailureCode;

final class RouteStrategy$UsedRouteInfo
{
  public final int routeFailureCode;
  public final UploadRoute usedRoute;
  
  public RouteStrategy$UsedRouteInfo(UploadRoute paramUploadRoute, int paramInt)
  {
    this.usedRoute = paramUploadRoute;
    this.routeFailureCode = paramInt;
  }
  
  public String toString()
  {
    return String.format("[%1$s, %2$s]", new Object[] { this.usedRoute.toString(), Const.FailureCode.print(this.routeFailureCode) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.network.route.RouteStrategy.UsedRouteInfo
 * JD-Core Version:    0.7.0.1
 */