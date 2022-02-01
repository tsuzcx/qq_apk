package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.api.IRequestCallback;
import java.util.concurrent.atomic.AtomicBoolean;

public class RequestFilter
  extends RequestAck
{
  public RequestFilter(String paramString, int paramInt1, byte[] paramArrayOfByte1, long paramLong, IRequestCallback paramIRequestCallback, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2)
  {
    super(paramString, paramInt1, paramArrayOfByte1, paramLong, paramIRequestCallback, paramArrayOfByte2, paramArrayOfByte3, paramInt2);
  }
  
  public void onError(int paramInt)
  {
    this.cb.onFailed(paramInt);
    this.isCancel.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestFilter
 * JD-Core Version:    0.7.0.1
 */