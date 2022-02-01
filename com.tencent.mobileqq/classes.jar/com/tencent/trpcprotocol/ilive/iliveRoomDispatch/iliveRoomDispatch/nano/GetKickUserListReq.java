package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetKickUserListReq
  extends MessageNano
{
  public long a;
  public long b;
  public long c;
  public long d;
  
  public GetKickUserListReq()
  {
    a();
  }
  
  public GetKickUserListReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.cachedSize = -1;
    return this;
  }
  
  public GetKickUserListReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt64();
        break;
      }
      this.d = paramCodedInputByteBufferNano.readUInt64();
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.a != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, this.a);
    }
    j = i;
    if (this.b != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, this.b);
    }
    i = j;
    if (this.c != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, this.c);
    }
    j = i;
    if (this.d != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(4, this.d);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.a != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.a);
    }
    if (this.b != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    }
    if (this.c != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, this.c);
    }
    if (this.d != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, this.d);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.GetKickUserListReq
 * JD-Core Version:    0.7.0.1
 */