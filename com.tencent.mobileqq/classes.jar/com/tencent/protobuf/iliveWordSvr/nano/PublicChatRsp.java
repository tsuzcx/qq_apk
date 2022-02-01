package com.tencent.protobuf.iliveWordSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class PublicChatRsp
  extends ExtendableMessageNano<PublicChatRsp>
{
  public PublicChatMsgRsp a;
  public int b;
  public byte[] c;
  public byte[] d;
  
  public PublicChatRsp()
  {
    a();
  }
  
  public PublicChatRsp a()
  {
    this.a = null;
    this.b = 0;
    this.c = WireFormatNano.EMPTY_BYTES;
    this.d = WireFormatNano.EMPTY_BYTES;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PublicChatRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 16)
        {
          if (i != 26)
          {
            if (i != 34)
            {
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readBytes();
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
      else
      {
        if (this.a == null) {
          this.a = new PublicChatMsgRsp();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    PublicChatMsgRsp localPublicChatMsgRsp = this.a;
    int i = j;
    if (localPublicChatMsgRsp != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, localPublicChatMsgRsp);
    }
    int k = this.b;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, k);
    }
    i = j;
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(3, this.c);
    }
    j = i;
    if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(4, this.d);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    PublicChatMsgRsp localPublicChatMsgRsp = this.a;
    if (localPublicChatMsgRsp != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, localPublicChatMsgRsp);
    }
    int i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i);
    }
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.c);
    }
    if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(4, this.d);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveWordSvr.nano.PublicChatRsp
 * JD-Core Version:    0.7.0.1
 */