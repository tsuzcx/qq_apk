package com.tencent.mobileqq.highway.conn;

import com.tencent.mobileqq.highway.utils.EndPoint;

public abstract interface IConnection
{
  public abstract boolean connect();
  
  public abstract void disConnect();
  
  public abstract int getConnId();
  
  public abstract EndPoint getEndPoint();
  
  public abstract int getProtoType();
  
  public abstract boolean isIpv6();
  
  public abstract boolean isWritable();
  
  public abstract void setConnectListener(IConnectionListener paramIConnectionListener);
  
  public abstract void setUrgentFlag(boolean paramBoolean);
  
  public abstract void wakeupChannel();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.IConnection
 * JD-Core Version:    0.7.0.1
 */