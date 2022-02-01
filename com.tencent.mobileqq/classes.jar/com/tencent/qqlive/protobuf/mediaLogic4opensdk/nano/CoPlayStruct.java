package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;

public final class CoPlayStruct
  extends ExtendableMessageNano<CoPlayStruct>
{
  private static volatile CoPlayStruct[] j;
  public long a;
  public String b;
  public Resolution c;
  public long d;
  public long e;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public CoPlayStruct()
  {
    b();
  }
  
  public static CoPlayStruct[] a()
  {
    if (j == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (j == null) {
          j = new CoPlayStruct[0];
        }
      }
    }
    return j;
  }
  
  public CoPlayStruct a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int k = paramCodedInputByteBufferNano.readTag();
      if (k == 0) {
        break;
      }
      if (k != 8)
      {
        if (k != 18)
        {
          if (k != 26)
          {
            if (k != 32)
            {
              if (k != 40)
              {
                if (k != 48)
                {
                  if (k != 56)
                  {
                    if (k != 64)
                    {
                      if (k != 72)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, k)) {
                          return this;
                        }
                      }
                      else {
                        this.i = paramCodedInputByteBufferNano.readInt32();
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readInt32();
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readInt32();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt32();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readUInt64();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt64();
            }
          }
          else
          {
            if (this.c == null) {
              this.c = new Resolution();
            }
            paramCodedInputByteBufferNano.readMessage(this.c);
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  public CoPlayStruct b()
  {
    this.a = 0L;
    this.b = "";
    this.c = null;
    this.d = 0L;
    this.e = 0L;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int m = super.computeSerializedSize();
    long l = this.a;
    int k = m;
    if (l != 0L) {
      k = m + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    m = k;
    if (!this.b.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    Resolution localResolution = this.c;
    k = m;
    if (localResolution != null) {
      k = m + CodedOutputByteBufferNano.computeMessageSize(3, localResolution);
    }
    l = this.d;
    int n = k;
    if (l != 0L) {
      n = k + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    l = this.e;
    m = n;
    if (l != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(5, l);
    }
    n = this.f;
    k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeUInt32Size(6, n);
    }
    n = this.g;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeInt32Size(7, n);
    }
    n = this.h;
    k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeInt32Size(8, n);
    }
    n = this.i;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeInt32Size(9, n);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    Resolution localResolution = this.c;
    if (localResolution != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, localResolution);
    }
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    l = this.e;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, l);
    }
    int k = this.f;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, k);
    }
    k = this.g;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeInt32(7, k);
    }
    k = this.h;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeInt32(8, k);
    }
    k = this.i;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeInt32(9, k);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.CoPlayStruct
 * JD-Core Version:    0.7.0.1
 */