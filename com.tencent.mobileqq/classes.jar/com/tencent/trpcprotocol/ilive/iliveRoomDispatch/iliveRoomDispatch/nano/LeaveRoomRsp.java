package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class LeaveRoomRsp
  extends MessageNano
{
  public LeaveRoomRsp()
  {
    a();
  }
  
  public LeaveRoomRsp a()
  {
    this.cachedSize = -1;
    return this;
  }
  
  public LeaveRoomRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    int i;
    do
    {
      i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      }
    } while (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.LeaveRoomRsp
 * JD-Core Version:    0.7.0.1
 */