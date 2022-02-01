package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetRoomNumExtraInfoRsp
  extends MessageNano
{
  public int a;
  public int b;
  
  public GetRoomNumExtraInfoRsp()
  {
    a();
  }
  
  public GetRoomNumExtraInfoRsp a()
  {
    this.a = 0;
    this.b = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public GetRoomNumExtraInfoRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.a = paramCodedInputByteBufferNano.readUInt32();
        break;
      }
      this.b = paramCodedInputByteBufferNano.readUInt32();
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.a != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, this.a);
    }
    j = i;
    if (this.b != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, this.b);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.a != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    }
    if (this.b != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, this.b);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.GetRoomNumExtraInfoRsp
 * JD-Core Version:    0.7.0.1
 */