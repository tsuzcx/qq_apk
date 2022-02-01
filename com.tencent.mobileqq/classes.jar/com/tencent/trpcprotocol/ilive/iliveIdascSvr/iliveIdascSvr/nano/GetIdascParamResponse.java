package com.tencent.trpcprotocol.ilive.iliveIdascSvr.iliveIdascSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class GetIdascParamResponse
  extends ExtendableMessageNano<GetIdascParamResponse>
{
  public String a;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public int h;
  public long i;
  public String j;
  
  public GetIdascParamResponse()
  {
    a();
  }
  
  public GetIdascParamResponse a()
  {
    this.a = "";
    this.b = 0;
    this.c = "";
    this.d = "";
    this.e = "";
    this.f = "";
    this.g = "";
    this.h = 0;
    this.i = 0L;
    this.j = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetIdascParamResponse a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 82: 
        this.j = paramCodedInputByteBufferNano.readString();
        break;
      case 72: 
        this.i = paramCodedInputByteBufferNano.readUInt64();
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
      case 26: 
        this.c = paramCodedInputByteBufferNano.readString();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readInt32();
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
    int n = this.b;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeInt32Size(2, n);
    }
    k = m;
    if (!this.c.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    m = k;
    if (!this.d.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    k = m;
    if (!this.e.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(5, this.e);
    }
    m = k;
    if (!this.f.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(6, this.f);
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
    long l = this.i;
    k = m;
    if (l != 0L) {
      k = m + CodedOutputByteBufferNano.computeUInt64Size(9, l);
    }
    m = k;
    if (!this.j.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(10, this.j);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    int k = this.b;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, k);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
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
    k = this.h;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, k);
    }
    long l = this.i;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(9, l);
    }
    if (!this.j.equals("")) {
      paramCodedOutputByteBufferNano.writeString(10, this.j);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveIdascSvr.iliveIdascSvr.nano.GetIdascParamResponse
 * JD-Core Version:    0.7.0.1
 */