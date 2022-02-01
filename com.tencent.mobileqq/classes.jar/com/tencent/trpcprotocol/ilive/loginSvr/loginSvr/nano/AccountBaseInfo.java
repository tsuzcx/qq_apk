package com.tencent.trpcprotocol.ilive.loginSvr.loginSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class AccountBaseInfo
  extends ExtendableMessageNano<AccountBaseInfo>
{
  public String a;
  public long b;
  public long c;
  public long d;
  public String e;
  public int f;
  public String g;
  public int h;
  public String i;
  public int j;
  
  public AccountBaseInfo()
  {
    a();
  }
  
  public AccountBaseInfo a()
  {
    this.a = "";
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = "";
    this.f = 0;
    this.g = "";
    this.h = 0;
    this.i = "";
    this.j = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public AccountBaseInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 74: 
        this.i = paramCodedInputByteBufferNano.readString();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 58: 
        this.g = paramCodedInputByteBufferNano.readString();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 42: 
        this.e = paramCodedInputByteBufferNano.readString();
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
      case 10: 
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int m = super.computeSerializedSize();
    int k = m;
    if (!this.a.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    long l = this.b;
    m = k;
    if (l != 0L) {
      m = k + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    l = this.c;
    k = m;
    if (l != 0L) {
      k = m + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    l = this.d;
    m = k;
    if (l != 0L) {
      m = k + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    k = m;
    if (!this.e.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(5, this.e);
    }
    int n = this.f;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(6, n);
    }
    k = m;
    if (!this.g.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(7, this.g);
    }
    n = this.h;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(8, n);
    }
    k = m;
    if (!this.i.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(9, this.i);
    }
    n = this.j;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(10, n);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    long l = this.b;
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
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.e);
    }
    int k = this.f;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, k);
    }
    if (!this.g.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.g);
    }
    k = this.h;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, k);
    }
    if (!this.i.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.i);
    }
    k = this.j;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, k);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.loginSvr.loginSvr.nano.AccountBaseInfo
 * JD-Core Version:    0.7.0.1
 */