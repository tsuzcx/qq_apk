package com.tencent.qqlive.iliveRoomAdminSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class SetChatStatusReq
  extends ExtendableMessageNano<SetChatStatusReq>
{
  public long a;
  public long b;
  public long c;
  public int d;
  public int e;
  
  public SetChatStatusReq()
  {
    a();
  }
  
  public SetChatStatusReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0;
    this.e = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SetChatStatusReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
              if (i != 40)
              {
                if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readUInt32();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt32();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt64();
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
    l = this.b;
    int k = i;
    if (l != 0L) {
      k = i + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    l = this.c;
    j = k;
    if (l != 0L) {
      j = k + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    k = this.d;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    k = this.e;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    int i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomAdminSvr.nano.SetChatStatusReq
 * JD-Core Version:    0.7.0.1
 */