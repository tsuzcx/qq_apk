package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class EndLinkOldReq
  extends ExtendableMessageNano<EndLinkOldReq>
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
  
  public EndLinkOldReq()
  {
    a();
  }
  
  public EndLinkOldReq a()
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
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public EndLinkOldReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
    int k = super.computeSerializedSize();
    long l = this.a;
    int m = k;
    if (l != 0L) {
      m = k + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    int n = this.b;
    k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeUInt32Size(2, n);
    }
    n = this.c;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(3, n);
    }
    k = m;
    if (!this.d.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    n = this.e;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(5, n);
    }
    Extinfo localExtinfo = this.f;
    k = m;
    if (localExtinfo != null) {
      k = m + CodedOutputByteBufferNano.computeMessageSize(6, localExtinfo);
    }
    l = this.g;
    m = k;
    if (l != 0L) {
      m = k + CodedOutputByteBufferNano.computeUInt64Size(7, l);
    }
    n = this.h;
    k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeUInt32Size(8, n);
    }
    n = this.i;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(9, n);
    }
    n = this.j;
    k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeUInt32Size(10, n);
    }
    return k;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    int k = this.b;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, k);
    }
    k = this.c;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, k);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    k = this.e;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, k);
    }
    Extinfo localExtinfo = this.f;
    if (localExtinfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(6, localExtinfo);
    }
    l = this.g;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    k = this.h;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, k);
    }
    k = this.i;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, k);
    }
    k = this.j;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, k);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.EndLinkOldReq
 * JD-Core Version:    0.7.0.1
 */