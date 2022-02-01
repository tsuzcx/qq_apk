package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class EnterRoomEvent
  extends MessageNano
{
  public long a;
  
  public EnterRoomEvent()
  {
    a();
  }
  
  public EnterRoomEvent a()
  {
    this.a = 0L;
    this.cachedSize = -1;
    return this;
  }
  
  public EnterRoomEvent a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      this.a = paramCodedInputByteBufferNano.readUInt64();
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.a != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(5, this.a);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.a != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, this.a);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.EnterRoomEvent
 * JD-Core Version:    0.7.0.1
 */