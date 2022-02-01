package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class StartNewReq
  extends ExtendableMessageNano<StartNewReq>
{
  public long a;
  public int b;
  public int c;
  public String d;
  public int e;
  public Extinfo f;
  public long g;
  public int h;
  public int i;
  public int j;
  public String k;
  public long l;
  public long m;
  
  public StartNewReq()
  {
    a();
  }
  
  public StartNewReq a()
  {
    this.a = 0L;
    this.b = 0;
    this.c = 0;
    this.d = "";
    this.e = 0;
    this.f = null;
    this.g = 0L;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = "";
    this.l = 0L;
    this.m = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public StartNewReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int n = paramCodedInputByteBufferNano.readTag();
      switch (n)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, n)) {
          return this;
        }
        break;
      case 104: 
        this.m = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 96: 
        this.l = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 90: 
        this.k = paramCodedInputByteBufferNano.readString();
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
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 50: 
        if (this.f == null) {
          this.f = new Extinfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.f);
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 34: 
        this.d = paramCodedInputByteBufferNano.readString();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt32();
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
    long l1 = this.a;
    int i1 = n;
    if (l1 != 0L) {
      i1 = n + CodedOutputByteBufferNano.computeUInt64Size(1, l1);
    }
    int i2 = this.b;
    n = i1;
    if (i2 != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(2, i2);
    }
    i2 = this.c;
    i1 = n;
    if (i2 != 0) {
      i1 = n + CodedOutputByteBufferNano.computeUInt32Size(3, i2);
    }
    n = i1;
    if (!this.d.equals("")) {
      n = i1 + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    i2 = this.e;
    i1 = n;
    if (i2 != 0) {
      i1 = n + CodedOutputByteBufferNano.computeUInt32Size(5, i2);
    }
    Extinfo localExtinfo = this.f;
    n = i1;
    if (localExtinfo != null) {
      n = i1 + CodedOutputByteBufferNano.computeMessageSize(6, localExtinfo);
    }
    l1 = this.g;
    i1 = n;
    if (l1 != 0L) {
      i1 = n + CodedOutputByteBufferNano.computeUInt64Size(7, l1);
    }
    i2 = this.h;
    n = i1;
    if (i2 != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(8, i2);
    }
    i2 = this.i;
    i1 = n;
    if (i2 != 0) {
      i1 = n + CodedOutputByteBufferNano.computeUInt32Size(9, i2);
    }
    i2 = this.j;
    n = i1;
    if (i2 != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(10, i2);
    }
    i1 = n;
    if (!this.k.equals("")) {
      i1 = n + CodedOutputByteBufferNano.computeStringSize(11, this.k);
    }
    l1 = this.l;
    n = i1;
    if (l1 != 0L) {
      n = i1 + CodedOutputByteBufferNano.computeUInt64Size(12, l1);
    }
    l1 = this.m;
    i1 = n;
    if (l1 != 0L) {
      i1 = n + CodedOutputByteBufferNano.computeUInt64Size(13, l1);
    }
    return i1;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l1 = this.a;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l1);
    }
    int n = this.b;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, n);
    }
    n = this.c;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, n);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    n = this.e;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, n);
    }
    Extinfo localExtinfo = this.f;
    if (localExtinfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(6, localExtinfo);
    }
    l1 = this.g;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l1);
    }
    n = this.h;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, n);
    }
    n = this.i;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, n);
    }
    n = this.j;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, n);
    }
    if (!this.k.equals("")) {
      paramCodedOutputByteBufferNano.writeString(11, this.k);
    }
    l1 = this.l;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(12, l1);
    }
    l1 = this.m;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(13, l1);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.StartNewReq
 * JD-Core Version:    0.7.0.1
 */