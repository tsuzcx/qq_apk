package com.tencent.mobileqq.msg.api.impl;

import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.msg.api.IForwardOrderManager;

public class ForwardOrderManagerImpl
  implements IForwardOrderManager
{
  public void mapUniSeqId(long paramLong1, long paramLong2, int paramInt)
  {
    ForwardOrderManager.a().a(paramLong1, paramLong2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.impl.ForwardOrderManagerImpl
 * JD-Core Version:    0.7.0.1
 */