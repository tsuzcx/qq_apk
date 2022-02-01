package com.tencent.protobuf.iliveWordSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;

public final class HippoMsgChat
  extends ExtendableMessageNano<HippoMsgChat>
{
  private static volatile HippoMsgChat[] h;
  public long a;
  public int b;
  public int c;
  public long d;
  public BroadCastMsg e;
  public String f;
  public long g;
  
  public HippoMsgChat()
  {
    b();
  }
  
  public static HippoMsgChat[] a()
  {
    if (h == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (h == null) {
          h = new HippoMsgChat[0];
        }
      }
    }
    return h;
  }
  
  public HippoMsgChat a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 24)
          {
            if (i != 32)
            {
              if (i != 42)
              {
                if (i != 50)
                {
                  if (i != 56)
                  {
                    if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readUInt64();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readString();
                }
              }
              else
              {
                if (this.e == null) {
                  this.e = new BroadCastMsg();
                }
                paramCodedInputByteBufferNano.readMessage(this.e);
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt64();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt32();
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
  
  public HippoMsgChat b()
  {
    this.a = 0L;
    this.b = 0;
    this.c = 0;
    this.d = 0L;
    this.e = null;
    this.f = "";
    this.g = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    long l = this.a;
    int j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    int k = this.b;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(2, k);
    }
    k = this.c;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(3, k);
    }
    l = this.d;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    BroadCastMsg localBroadCastMsg = this.e;
    j = i;
    if (localBroadCastMsg != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(5, localBroadCastMsg);
    }
    i = j;
    if (!this.f.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    l = this.g;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(7, l);
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
    i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, i);
    }
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    BroadCastMsg localBroadCastMsg = this.e;
    if (localBroadCastMsg != null) {
      paramCodedOutputByteBufferNano.writeMessage(5, localBroadCastMsg);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    l = this.g;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveWordSvr.nano.HippoMsgChat
 * JD-Core Version:    0.7.0.1
 */