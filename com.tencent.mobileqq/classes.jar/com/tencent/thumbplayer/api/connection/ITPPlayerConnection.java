package com.tencent.thumbplayer.api.connection;

public abstract interface ITPPlayerConnection
{
  public abstract int activeAllConnections();
  
  public abstract int activeConnection(int paramInt);
  
  public abstract int addConnection(long paramLong1, TPPlayerConnectionNode paramTPPlayerConnectionNode1, long paramLong2, TPPlayerConnectionNode paramTPPlayerConnectionNode2);
  
  public abstract void deactiveAllConnections();
  
  public abstract void deactiveConnection(int paramInt);
  
  public abstract void init();
  
  public abstract void removeConnection(int paramInt);
  
  public abstract void uninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.connection.ITPPlayerConnection
 * JD-Core Version:    0.7.0.1
 */