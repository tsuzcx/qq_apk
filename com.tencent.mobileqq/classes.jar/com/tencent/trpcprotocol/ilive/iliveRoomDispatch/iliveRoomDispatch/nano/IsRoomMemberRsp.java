package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class IsRoomMemberRsp
  extends MessageNano
{
  public boolean a;
  
  public IsRoomMemberRsp()
  {
    a();
  }
  
  public IsRoomMemberRsp a()
  {
    this.a = false;
    this.cachedSize = -1;
    return this;
  }
  
  public IsRoomMemberRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      this.a = paramCodedInputByteBufferNano.readBool();
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.a) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(1, this.a);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.a) {
      paramCodedOutputByteBufferNano.writeBool(1, this.a);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.IsRoomMemberRsp
 * JD-Core Version:    0.7.0.1
 */