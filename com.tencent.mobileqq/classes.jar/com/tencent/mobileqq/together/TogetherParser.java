package com.tencent.mobileqq.together;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.aio.media.aio_media.RspLatestPlayingState;

public abstract interface TogetherParser
{
  public abstract void a(int paramInt1, int paramInt2, String paramString);
  
  public abstract void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, Object paramObject);
  
  public abstract void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void a(ToServiceMsg paramToServiceMsg, aio_media.RspLatestPlayingState paramRspLatestPlayingState);
  
  public abstract void a(Object paramObject);
  
  public abstract void a(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherParser
 * JD-Core Version:    0.7.0.1
 */