package com.tencent.qlive.iliveMetricsSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class NotifyActiveRoomRsp
  extends ExtendableMessageNano<NotifyActiveRoomRsp>
{
  public NotifyActiveRoomRsp()
  {
    a();
  }
  
  public NotifyActiveRoomRsp a()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public NotifyActiveRoomRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    int i;
    do
    {
      i = paramCodedInputByteBufferNano.readTag();
    } while ((i != 0) && (storeUnknownField(paramCodedInputByteBufferNano, i)));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qlive.iliveMetricsSvr.nano.NotifyActiveRoomRsp
 * JD-Core Version:    0.7.0.1
 */