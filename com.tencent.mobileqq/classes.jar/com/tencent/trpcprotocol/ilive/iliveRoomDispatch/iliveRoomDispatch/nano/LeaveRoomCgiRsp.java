package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class LeaveRoomCgiRsp
  extends MessageNano
{
  public LeaveRoomCgiRsp()
  {
    a();
  }
  
  public LeaveRoomCgiRsp a()
  {
    this.cachedSize = -1;
    return this;
  }
  
  public LeaveRoomCgiRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    int i;
    do
    {
      i = paramCodedInputByteBufferNano.readTag();
    } while ((i != 0) && (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.LeaveRoomCgiRsp
 * JD-Core Version:    0.7.0.1
 */