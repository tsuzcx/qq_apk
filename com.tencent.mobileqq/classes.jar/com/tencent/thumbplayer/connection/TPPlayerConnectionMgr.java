package com.tencent.thumbplayer.connection;

import com.tencent.thumbplayer.api.connection.ITPPlayerConnection;
import com.tencent.thumbplayer.api.connection.TPPlayerConnectionNode;
import com.tencent.thumbplayer.core.connection.TPNativePlayerConnectionMgr;

public class TPPlayerConnectionMgr
  implements ITPPlayerConnection
{
  private TPNativePlayerConnectionMgr mNativeConnection = new TPNativePlayerConnectionMgr();
  
  public int activeAllConnections()
  {
    return this.mNativeConnection.activeAllConnections();
  }
  
  public int activeConnection(int paramInt)
  {
    return this.mNativeConnection.activeConnection(paramInt);
  }
  
  public int addConnection(long paramLong1, TPPlayerConnectionNode paramTPPlayerConnectionNode1, long paramLong2, TPPlayerConnectionNode paramTPPlayerConnectionNode2)
  {
    return this.mNativeConnection.addConnection(paramLong1, paramTPPlayerConnectionNode1.getNativeNode(), paramLong2, paramTPPlayerConnectionNode2.getNativeNode());
  }
  
  public void deactiveAllConnections()
  {
    this.mNativeConnection.deactiveAllConnections();
  }
  
  public void deactiveConnection(int paramInt)
  {
    this.mNativeConnection.deactiveConnection(paramInt);
  }
  
  public void init()
  {
    this.mNativeConnection.init();
  }
  
  public void removeConnection(int paramInt)
  {
    this.mNativeConnection.removeConnection(paramInt);
  }
  
  public void uninit()
  {
    this.mNativeConnection.unInit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.connection.TPPlayerConnectionMgr
 * JD-Core Version:    0.7.0.1
 */