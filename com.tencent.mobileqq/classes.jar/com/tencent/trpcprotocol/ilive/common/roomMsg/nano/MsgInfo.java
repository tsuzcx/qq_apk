package com.tencent.trpcprotocol.ilive.common.roomMsg.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class MsgInfo
  extends ExtendableMessageNano<MsgInfo>
{
  private static volatile MsgInfo[] h;
  public long a;
  public int b;
  public byte[] c;
  public MsgPolicy d;
  public int e;
  public long f;
  public String g;
  
  public MsgInfo()
  {
    b();
  }
  
  public static MsgInfo[] a()
  {
    if (h == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (h == null) {
          h = new MsgInfo[0];
        }
      }
    }
    return h;
  }
  
  public MsgInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 34)
            {
              if (i != 40)
              {
                if (i != 48)
                {
                  if (i != 58)
                  {
                    if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readString();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt64();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readUInt32();
              }
            }
            else
            {
              if (this.d == null) {
                this.d = new MsgPolicy();
              }
              paramCodedInputByteBufferNano.readMessage(this.d);
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
  
  public MsgInfo b()
  {
    this.a = 0L;
    this.b = 0;
    this.c = WireFormatNano.EMPTY_BYTES;
    this.d = null;
    this.e = 0;
    this.f = 0L;
    this.g = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
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
    int k = this.b;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, k);
    }
    k = j;
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      k = j + CodedOutputByteBufferNano.computeBytesSize(3, this.c);
    }
    MsgPolicy localMsgPolicy = this.d;
    i = k;
    if (localMsgPolicy != null) {
      i = k + CodedOutputByteBufferNano.computeMessageSize(4, localMsgPolicy);
    }
    k = this.e;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    l = this.f;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(6, l);
    }
    j = i;
    if (!this.g.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(7, this.g);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    int i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i);
    }
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.c);
    }
    MsgPolicy localMsgPolicy = this.d;
    if (localMsgPolicy != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, localMsgPolicy);
    }
    i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    l = this.f;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, l);
    }
    if (!this.g.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.g);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.common.roomMsg.nano.MsgInfo
 * JD-Core Version:    0.7.0.1
 */