package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class ReqVideoAccessInfo
  extends ExtendableMessageNano<ReqVideoAccessInfo>
{
  public int a;
  public int b;
  public long c;
  public long d;
  public int e;
  public int f;
  public int g;
  public long h;
  public int i;
  
  public ReqVideoAccessInfo()
  {
    a();
  }
  
  public ReqVideoAccessInfo a()
  {
    this.a = 0;
    this.b = 0;
    this.c = 0L;
    this.d = 0L;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0L;
    this.i = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public ReqVideoAccessInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int j = paramCodedInputByteBufferNano.readTag();
      if (j == 0) {
        break;
      }
      if (j != 8)
      {
        if (j != 16)
        {
          if (j != 24)
          {
            if (j != 32)
            {
              if (j != 56)
              {
                if (j != 64)
                {
                  if (j != 72)
                  {
                    if (j != 80)
                    {
                      if (j != 88)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, j)) {
                          return this;
                        }
                      }
                      else {
                        this.i = paramCodedInputByteBufferNano.readUInt32();
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
            this.c = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt32();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a) + CodedOutputByteBufferNano.computeUInt32Size(2, this.b) + CodedOutputByteBufferNano.computeUInt64Size(3, this.c) + CodedOutputByteBufferNano.computeUInt64Size(4, this.d);
    int m = this.e;
    int j = k;
    if (m != 0) {
      j = k + CodedOutputByteBufferNano.computeUInt32Size(7, m);
    }
    m = this.f;
    k = j;
    if (m != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(8, m);
    }
    m = this.g;
    j = k;
    if (m != 0) {
      j = k + CodedOutputByteBufferNano.computeUInt32Size(9, m);
    }
    long l = this.h;
    k = j;
    if (l != 0L) {
      k = j + CodedOutputByteBufferNano.computeUInt64Size(10, l);
    }
    m = this.i;
    j = k;
    if (m != 0) {
      j = k + CodedOutputByteBufferNano.computeUInt32Size(11, m);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt32(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt64(3, this.c);
    paramCodedOutputByteBufferNano.writeUInt64(4, this.d);
    int j = this.e;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, j);
    }
    j = this.f;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, j);
    }
    j = this.g;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, j);
    }
    long l = this.h;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(10, l);
    }
    j = this.i;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, j);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.ReqVideoAccessInfo
 * JD-Core Version:    0.7.0.1
 */