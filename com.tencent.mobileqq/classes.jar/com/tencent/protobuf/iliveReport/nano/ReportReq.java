package com.tencent.protobuf.iliveReport.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class ReportReq
  extends ExtendableMessageNano<ReportReq>
{
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  public int g;
  public String h;
  public String i;
  public int j;
  public int k;
  
  public ReportReq()
  {
    a();
  }
  
  public ReportReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = 0;
    this.h = "";
    this.i = "";
    this.j = 0;
    this.k = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public ReportReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 88: 
        this.k = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 80: 
        this.j = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 74: 
        this.i = paramCodedInputByteBufferNano.readString();
        break;
      case 66: 
        this.h = paramCodedInputByteBufferNano.readString();
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int n = super.computeSerializedSize();
    long l = this.a;
    int m = n;
    if (l != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    l = this.b;
    n = m;
    if (l != 0L) {
      n = m + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    l = this.c;
    m = n;
    if (l != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    l = this.d;
    n = m;
    if (l != 0L) {
      n = m + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    l = this.e;
    int i1 = n;
    if (l != 0L) {
      i1 = n + CodedOutputByteBufferNano.computeUInt64Size(5, l);
    }
    l = this.f;
    m = i1;
    if (l != 0L) {
      m = i1 + CodedOutputByteBufferNano.computeUInt64Size(6, l);
    }
    i1 = this.g;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(7, i1);
    }
    m = n;
    if (!this.h.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(8, this.h);
    }
    n = m;
    if (!this.i.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(9, this.i);
    }
    i1 = this.j;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(10, i1);
    }
    i1 = this.k;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(11, i1);
    }
    return n;
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
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    l = this.e;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, l);
    }
    l = this.f;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, l);
    }
    int m = this.g;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, m);
    }
    if (!this.h.equals("")) {
      paramCodedOutputByteBufferNano.writeString(8, this.h);
    }
    if (!this.i.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.i);
    }
    m = this.j;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, m);
    }
    m = this.k;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, m);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveReport.nano.ReportReq
 * JD-Core Version:    0.7.0.1
 */