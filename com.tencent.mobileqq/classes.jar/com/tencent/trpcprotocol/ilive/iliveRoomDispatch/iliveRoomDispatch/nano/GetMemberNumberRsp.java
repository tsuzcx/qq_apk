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
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      }
      if (this.a == null) {
        this.a = new RoomUserNumInfo();
      }
      paramCodedInputByteBufferNano.readMessage(this.a);
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.a != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, this.a);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.a != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, this.a);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.GetMemberNumberRsp
 * JD-Core Version:    0.7.0.1
 */