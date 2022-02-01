package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class PushOnVideoReq
  extends ExtendableMessageNano<PushOnVideoReq>
{
  public int a;
  public long b;
  public int c;
  public long d;
  public int e;
  public long f;
  public byte[] g;
  public int h;
  public int i;
  public int j;
  public long k;
  public long l;
  
  public PushOnVideoReq()
  {
    a();
  }
  
  public PushOnVideoReq a()
  {
    this.a = 0;
    this.b = 0L;
    this.c = 0;
    this.d = 0L;
    this.e = 0;
    this.f = 0L;
    this.g = WireFormatNano.EMPTY_BYTES;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = 0L;
    this.l = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PushOnVideoReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int m = paramCodedInputByteBufferNano.readTag();
      switch (m)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, m)) {
          return this;
        }
        break;
      case 96: 
        this.l = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 88: 
        this.k = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 80: 
        this.j = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 72: 
        this.i = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 58: 
        this.g = paramCodedInputByteBufferNano.readBytes();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int n = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeUInt32Size(3, this.c) + CodedOutputByteBufferNano.computeUInt64Size(4, this.d) + CodedOutputByteBufferNano.computeUInt32Size(5, this.e) + CodedOutputByteBufferNano.computeUInt64Size(6, this.f) + CodedOutputByteBufferNano.computeBytesSize(7, this.g);
    int i1 = this.h;
    int m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(8, i1);
    }
    i1 = this.i;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(9, i1);
    }
    i1 = this.j;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(10, i1);
    }
    long l1 = this.k;
    n = m;
    if (l1 != 0L) {
      n = m + CodedOutputByteBufferNano.computeUInt64Size(11, l1);
    }
    l1 = this.l;
    m = n;
    if (l1 != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(12, l1);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt32(3, this.c);
    paramCodedOutputByteBufferNano.writeUInt64(4, this.d);
    paramCodedOutputByteBufferNano.writeUInt32(5, this.e);
    paramCodedOutputByteBufferNano.writeUInt64(6, this.f);
    paramCodedOutputByteBufferNano.writeBytes(7, this.g);
    int m = this.h;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, m);
    }
    m = this.i;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, m);
    }
    m = this.j;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, m);
    }
    long l1 = this.k;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(11, l1);
    }
    l1 = this.l;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(12, l1);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.PushOnVideoReq
 * JD-Core Version:    0.7.0.1
 */