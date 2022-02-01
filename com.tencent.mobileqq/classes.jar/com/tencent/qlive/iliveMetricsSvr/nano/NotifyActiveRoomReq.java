package com.tencent.qlive.iliveMetricsSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class NotifyActiveRoomReq
  extends ExtendableMessageNano<NotifyActiveRoomReq>
{
  public IliveInfo a;
  
  public NotifyActiveRoomReq()
  {
    a();
  }
  
  public NotifyActiveRoomReq a()
  {
    this.a = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public NotifyActiveRoomReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
      }
      else
      {
        if (this.a == null) {
          this.a = new IliveInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    IliveInfo localIliveInfo = this.a;
    int i = j;
    if (localIliveInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, localIliveInfo);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    IliveInfo localIliveInfo = this.a;
    if (localIliveInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, localIliveInfo);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qlive.iliveMetricsSvr.nano.NotifyActiveRoomReq
 * JD-Core Version:    0.7.0.1
 */