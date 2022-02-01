package com.tencent.upload.network.route;

import com.tencent.upload.utils.Const.FileType;

public class DebugRouteStrategy
  implements IUploadRouteStrategy
{
  private UploadRoute mDebugUploadRoute = RouteFactory.getDebugRoute();
  
  public ServerRouteTable getServerRouteTable()
  {
    return new DebugRouteStrategy.1(this, -1, null, null, null, Const.FileType.Photo);
  }
  
  public UploadRoute next(UploadRoute paramUploadRoute, int paramInt)
  {
    return null;
  }
  
  public UploadRoute reset()
  {
    return this.mDebugUploadRoute;
  }
  
  public boolean save(UploadRoute paramUploadRoute)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.route.DebugRouteStrategy
 * JD-Core Version:    0.7.0.1
 */