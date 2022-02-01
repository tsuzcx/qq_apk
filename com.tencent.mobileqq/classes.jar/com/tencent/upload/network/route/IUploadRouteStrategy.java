package com.tencent.upload.network.route;

public abstract interface IUploadRouteStrategy
{
  public abstract ServerRouteTable getServerRouteTable();
  
  public abstract UploadRoute next(UploadRoute paramUploadRoute, int paramInt);
  
  public abstract UploadRoute reset();
  
  public abstract boolean save(UploadRoute paramUploadRoute);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.route.IUploadRouteStrategy
 * JD-Core Version:    0.7.0.1
 */