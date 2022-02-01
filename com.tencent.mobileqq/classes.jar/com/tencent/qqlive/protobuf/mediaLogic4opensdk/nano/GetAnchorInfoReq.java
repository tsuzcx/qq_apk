package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class GetAnchorInfoReq
  extends ExtendableMessageNano<GetAnchorInfoReq>
{
  public long a;
  public long b;
  public int c;
  public long d;
  public int e;
  public int f;
  public int g;
  public long h;
  
  public GetAnchorInfoReq()
  {
    a();
  }
  
  public GetAnchorInfoReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0;
    this.d = 0L;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetAnchorInfoReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
                if (i != 48)
                {
                  if (i != 56)
                  {
                    if (i != 64)
                    {
                      if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                        return this;
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readUInt64();
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readUInt32();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt32();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readUInt32();
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
    int i = super.computeSerializedSize();
    long l = this.a;
    int j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    l = this.b;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    int k = this.c;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(3, k);
    }
    l = this.d;
    k = j;
    if (l != 0L) {
      k = j + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    j = this.e;
    i = k;
    if (j != 0) {
      i = k + CodedOutputByteBufferNano.computeUInt32Size(5, j);
    }
    k = this.f;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(6, k);
    }
    k = this.g;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(7, k);
    }
    l = this.h;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(8, l);
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
    int i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, i);
    }
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    i = this.f;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, i);
    }
    i = this.g;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i);
    }
    l = this.h;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(8, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.GetAnchorInfoReq
 * JD-Core Version:    0.7.0.1
 */