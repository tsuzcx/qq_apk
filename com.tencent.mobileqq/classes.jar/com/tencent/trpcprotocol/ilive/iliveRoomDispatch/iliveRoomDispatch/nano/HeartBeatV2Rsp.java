package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class HeartBeatV2Rsp
  extends MessageNano
{
  public HeartBeatV2Rsp()
  {
    a();
  }
  
  public HeartBeatV2Rsp a()
  {
    this.cachedSize = -1;
    return this;
  }
  
  public HeartBeatV2Rsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    int i;
    do
    {
      i = paramCodedInputByteBufferNano.readTag();
    } while ((i != 0) && (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.HeartBeatV2Rsp
 * JD-Core Version:    0.7.0.1
 */