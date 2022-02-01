package com.tencent.qqlive.protobuf.iliveStreamControl.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class AnchorGearChooseReq
  extends ExtendableMessageNano<AnchorGearChooseReq>
{
  public long a;
  public long b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  
  public AnchorGearChooseReq()
  {
    a();
  }
  
  public AnchorGearChooseReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public AnchorGearChooseReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int k = paramCodedInputByteBufferNano.readTag();
      switch (k)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, k)) {
          return this;
        }
        break;
      case 80: 
        this.j = paramCodedInputByteBufferNano.readInt32();
        break;
      case 72: 
        this.i = paramCodedInputByteBufferNano.readInt32();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readInt32();
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readInt32();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readInt32();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readInt32();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readInt64();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int m = super.computeSerializedSize();
    long l = this.a;
    int k = m;
    if (l != 0L) {
      k = m + CodedOutputByteBufferNano.computeInt64Size(1, l);
    }
    l = this.b;
    m = k;
    if (l != 0L) {
      m = k + CodedOutputByteBufferNano.computeInt64Size(2, l);
    }
    int n = this.c;
    k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeUInt32Size(3, n);
    }
    n = this.d;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(4, n);
    }
    n = this.e;
    k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeInt32Size(5, n);
    }
    n = this.f;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeInt32Size(6, n);
    }
    n = this.g;
    k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeInt32Size(7, n);
    }
    n = this.h;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeInt32Size(8, n);
    }
    n = this.i;
    k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeInt32Size(9, n);
    }
    n = this.j;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeInt32Size(10, n);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(1, l);
    }
    l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(2, l);
    }
    int k = this.c;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, k);
    }
    k = this.d;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, k);
    }
    k = this.e;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, k);
    }
    k = this.f;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeInt32(6, k);
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
    k = this.j;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeInt32(10, k);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveStreamControl.nano.AnchorGearChooseReq
 * JD-Core Version:    0.7.0.1
 */