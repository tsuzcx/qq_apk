package com.tencent.thumbplayer.api.connection;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.core.connection.TPNativePlayerConnectionNode;

public class TPPlayerConnectionNode
{
  private TPNativePlayerConnectionNode nativeNode = new TPNativePlayerConnectionNode();
  
  public boolean addAction(@TPPlayerConnectionConstant.Action int paramInt)
  {
    return this.nativeNode.addAction(TPNativeKeyMapUtil.convertToNativeConnectionAction(paramInt));
  }
  
  public TPNativePlayerConnectionNode getNativeNode()
  {
    return this.nativeNode;
  }
  
  public void removeAction(@TPPlayerConnectionConstant.Action int paramInt)
  {
    this.nativeNode.removeAction(TPNativeKeyMapUtil.convertToNativeConnectionAction(paramInt));
  }
  
  public boolean setLongActionConfig(@TPPlayerConnectionConstant.Action int paramInt1, int paramInt2, long paramLong)
  {
    return this.nativeNode.setLongActionConfig(TPNativeKeyMapUtil.convertToNativeConnectionAction(paramInt1), TPNativeKeyMapUtil.convertToNativeConnectionConfig(paramInt2), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.connection.TPPlayerConnectionNode
 * JD-Core Version:    0.7.0.1
 */