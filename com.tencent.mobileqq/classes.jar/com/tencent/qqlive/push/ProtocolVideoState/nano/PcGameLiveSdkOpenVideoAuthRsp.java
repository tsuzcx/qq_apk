package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class PcGameLiveSdkOpenVideoAuthRsp
  extends ExtendableMessageNano<PcGameLiveSdkOpenVideoAuthRsp>
{
  public long a;
  public int b;
  public byte[] c;
  
  public PcGameLiveSdkOpenVideoAuthRsp()
  {
    a();
  }
  
  public PcGameLiveSdkOpenVideoAuthRsp a()
  {
    this.a = 0L;
    this.b = 0;
    this.c = WireFormatNano.EMPTY_BYTES;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PcGameLiveSdkOpenVideoAuthRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 16)
        {
          if (i != 26)
          {
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readBytes();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt32();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + CodedOutputByteBufferNano.computeUInt32Size(2, this.b) + CodedOutputByteBufferNano.computeBytesSize(3, this.c);
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt64(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt32(2, this.b);
    paramCodedOutputByteBufferNano.writeBytes(3, this.c);
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.PcGameLiveSdkOpenVideoAuthRsp
 * JD-Core Version:    0.7.0.1
 */