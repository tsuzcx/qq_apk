package com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;

public final class Config
  extends ExtendableMessageNano<Config>
{
  private static volatile Config[] k;
  public int a;
  public long b;
  public long c;
  public String d;
  public String e;
  public String f;
  public String g;
  public int h;
  public int i;
  public String j;
  
  public Config()
  {
    b();
  }
  
  public static Config[] a()
  {
    if (k == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (k == null) {
          k = new Config[0];
        }
      }
    }
    return k;
  }
  
  public Config a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 82: 
        this.j = paramCodedInputByteBufferNano.readString();
        break;
      case 72: 
        this.i = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 58: 
        this.g = paramCodedInputByteBufferNano.readString();
        break;
      case 50: 
        this.f = paramCodedInputByteBufferNano.readString();
        break;
      case 42: 
        this.e = paramCodedInputByteBufferNano.readString();
        break;
      case 34: 
        this.d = paramCodedInputByteBufferNano.readString();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readInt64();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readInt64();
        break;
      case 8: 
        m = paramCodedInputByteBufferNano.readInt32();
        if ((m == 0) || (m == 1) || (m == 2)) {
          this.a = m;
        }
        break;
      }
    }
    return this;
  }
  
  public Config b()
  {
    this.a = 0;
    this.b = 0L;
    this.c = 0L;
    this.d = "";
    this.e = "";
    this.f = "";
    this.g = "";
    this.h = 0;
    this.i = 0;
    this.j = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int n = super.computeSerializedSize();
    int i1 = this.a;
    int m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeInt32Size(1, i1);
    }
    long l = this.b;
    n = m;
    if (l != 0L) {
      n = m + CodedOutputByteBufferNano.computeInt64Size(2, l);
    }
    l = this.c;
    m = n;
    if (l != 0L) {
      m = n + CodedOutputByteBufferNano.computeInt64Size(3, l);
    }
    n = m;
    if (!this.d.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    m = n;
    if (!this.e.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(5, this.e);
    }
    i1 = m;
    if (!this.f.equals("")) {
      i1 = m + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    n = i1;
    if (!this.g.equals("")) {
      n = i1 + CodedOutputByteBufferNano.computeStringSize(7, this.g);
    }
    i1 = this.h;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(8, i1);
    }
    i1 = this.i;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(9, i1);
    }
    m = n;
    if (!this.j.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(10, this.j);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int m = this.a;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, m);
    }
    long l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(2, l);
    }
    l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(3, l);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.e);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    if (!this.g.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.g);
    }
    m = this.h;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, m);
    }
    m = this.i;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, m);
    }
    if (!this.j.equals("")) {
      paramCodedOutputByteBufferNano.writeString(10, this.j);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano.Config
 * JD-Core Version:    0.7.0.1
 */