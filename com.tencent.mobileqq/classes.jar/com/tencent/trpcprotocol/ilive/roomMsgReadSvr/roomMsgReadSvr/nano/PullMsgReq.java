package com.tencent.trpcprotocol.ilive.roomMsgReadSvr.roomMsgReadSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class PullMsgReq
  extends ExtendableMessageNano<PullMsgReq>
{
  public long a;
  public byte[] b;
  public ExtInfo c;
  public long d;
  public String e;
  
  public PullMsgReq()
  {
    a();
  }
  
  public PullMsgReq a()
  {
    this.a = 0L;
    this.b = WireFormatNano.EMPTY_BYTES;
    this.c = null;
    this.d = 0L;
    this.e = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PullMsgReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 18)
        {
          if (i != 26)
          {
            if (i != 32)
            {
              if (i != 42)
              {
                if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readString();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt64();
            }
          }
          else
          {
            if (this.c == null) {
              this.c = new ExtInfo();
            }
            paramCodedInputByteBufferNano.readMessage(this.c);
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readBytes();
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
    int j = super.computeSerializedSize();
    long l = this.a;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    j = i;
    if (!Arrays.equals(this.b, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(2, this.b);
    }
    ExtInfo localExtInfo = this.c;
    i = j;
    if (localExtInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, localExtInfo);
    }
    l = this.d;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    i = j;
    if (!this.e.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(5, this.e);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    if (!Arrays.equals(this.b, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(2, this.b);
    }
    ExtInfo localExtInfo = this.c;
    if (localExtInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, localExtInfo);
    }
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.e);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomMsgReadSvr.roomMsgReadSvr.nano.PullMsgReq
 * JD-Core Version:    0.7.0.1
 */