package com.tencent.protobuf.iliveWordSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class PublicChatMsgRsp
  extends ExtendableMessageNano<PublicChatMsgRsp>
{
  public int a;
  public long b;
  public byte[] c;
  
  public PublicChatMsgRsp()
  {
    a();
  }
  
  public PublicChatMsgRsp a()
  {
    this.a = 0;
    this.b = 0L;
    this.c = WireFormatNano.EMPTY_BYTES;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PublicChatMsgRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          this.b = paramCodedInputByteBufferNano.readUInt64();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt32Size(1, this.a);
    long l = this.b;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    j = i;
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(3, this.c);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeInt32(1, this.a);
    long l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.c);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveWordSvr.nano.PublicChatMsgRsp
 * JD-Core Version:    0.7.0.1
 */