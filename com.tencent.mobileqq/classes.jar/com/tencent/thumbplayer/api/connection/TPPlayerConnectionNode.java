package com.tencent.thumbplayer.api.connection;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapConnectionAction;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapConnectionConfig;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.core.connection.TPNativePlayerConnectionNode;

public class TPPlayerConnectionNode
{
  private TPNativePlayerConnectionNode nativeNode = new TPNativePlayerConnectionNode();
  
  public boolean addAction(@TPPlayerConnectionConstant.Action int paramInt)
  {
    return this.nativeNode.addAction(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapConnectionAction.class, paramInt));
  }
  
  public TPNativePlayerConnectionNode getNativeNode()
  {
    return this.nativeNode;
  }
  
  public void removeAction(@TPPlayerConnectionConstant.Action int paramInt)
  {
    this.nativeNode.removeAction(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapConnectionAction.class, paramInt));
  }
  
  public boolean setLongActionConfig(@TPPlayerConnectionConstant.Action int paramInt1, int paramInt2, long paramLong)
  {
    return this.nativeNode.setLongActionConfig(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapConnectionAction.class, paramInt1), TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapConnectionConfig.class, paramInt2), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.connection.TPPlayerConnectionNode
 * JD-Core Version:    0.7.0.1
 */