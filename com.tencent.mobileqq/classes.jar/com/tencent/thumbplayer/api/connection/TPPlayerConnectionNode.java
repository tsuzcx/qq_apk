package com.tencent.thumbplayer.api.connection;

import com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayerUtils;
import com.tencent.thumbplayer.core.connection.TPNativePlayerConnectionNode;

public class TPPlayerConnectionNode
{
  private TPNativePlayerConnectionNode nativeNode = new TPNativePlayerConnectionNode();
  
  public boolean addAction(int paramInt)
  {
    return this.nativeNode.addAction(TPThumbPlayerUtils.convert2NativeConnectionAction(paramInt));
  }
  
  public TPNativePlayerConnectionNode getNativeNode()
  {
    return this.nativeNode;
  }
  
  public void removeAction(int paramInt)
  {
    this.nativeNode.removeAction(TPThumbPlayerUtils.convert2NativeConnectionAction(paramInt));
  }
  
  public boolean setLongActionConfig(int paramInt1, int paramInt2, long paramLong)
  {
    return this.nativeNode.setLongActionConfig(TPThumbPlayerUtils.convert2NativeConnectionAction(paramInt1), TPThumbPlayerUtils.convert2NativeConnectionAction(paramInt2), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.connection.TPPlayerConnectionNode
 * JD-Core Version:    0.7.0.1
 */