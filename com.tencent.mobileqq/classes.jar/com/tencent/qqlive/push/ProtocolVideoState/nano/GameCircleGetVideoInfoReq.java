package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GameCircleGetVideoInfoReq
  extends ExtendableMessageNano<GameCircleGetVideoInfoReq>
{
  public byte[] a;
  public byte[] b;
  public long c;
  
  public GameCircleGetVideoInfoReq()
  {
    a();
  }
  
  public GameCircleGetVideoInfoReq a()
  {
    this.a = WireFormatNano.EMPTY_BYTES;
    this.b = WireFormatNano.EMPTY_BYTES;
    this.c = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GameCircleGetVideoInfoReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 18)
        {
          if (i != 24)
          {
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readBytes();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readBytes();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeBytesSize(1, this.a) + CodedOutputByteBufferNano.computeBytesSize(2, this.b);
    long l = this.c;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeBytes(1, this.a);
    paramCodedOutputByteBufferNano.writeBytes(2, this.b);
    long l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.GameCircleGetVideoInfoReq
 * JD-Core Version:    0.7.0.1
 */