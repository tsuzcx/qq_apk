package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetMemberNumberRsp
  extends MessageNano
{
  public RoomUserNumInfo a;
  
  public GetMemberNumberRsp()
  {
    a();
  }
  
  public GetMemberNumberRsp a()
  {
    this.a = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetMemberNumberRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
      }
      else
      {
        if (this.a == null) {
          this.a = new RoomUserNumInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    RoomUserNumInfo localRoomUserNumInfo = this.a;
    int i = j;
    if (localRoomUserNumInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, localRoomUserNumInfo);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    RoomUserNumInfo localRoomUserNumInfo = this.a;
    if (localRoomUserNumInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, localRoomUserNumInfo);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.GetMemberNumberRsp
 * JD-Core Version:    0.7.0.1
 */