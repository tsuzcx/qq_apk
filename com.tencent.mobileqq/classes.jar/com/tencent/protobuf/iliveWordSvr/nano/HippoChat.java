package com.tencent.protobuf.iliveWordSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class HippoChat
  extends ExtendableMessageNano<HippoChat>
{
  public long a;
  public byte[] b;
  public int c;
  public int d;
  public int e;
  public long f;
  public long g;
  public long h;
  public String i;
  public String j;
  public long k;
  
  public HippoChat()
  {
    a();
  }
  
  public HippoChat a()
  {
    this.a = 0L;
    this.b = WireFormatNano.EMPTY_BYTES;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0L;
    this.g = 0L;
    this.h = 0L;
    this.i = "";
    this.j = "";
    this.k = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public HippoChat a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.k = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 82: 
        this.j = paramCodedInputByteBufferNano.readString();
        break;
      case 74: 
        this.i = paramCodedInputByteBufferNano.readString();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 18: 
        this.b = paramCodedInputByteBufferNano.readBytes();
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
    n = m;
    if (!Arrays.equals(this.b, WireFormatNano.EMPTY_BYTES)) {
      n = m + CodedOutputByteBufferNano.computeBytesSize(2, this.b);
    }
    int i1 = this.c;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(3, i1);
    }
    i1 = this.d;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(4, i1);
    }
    i1 = this.e;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(5, i1);
    }
    l = this.f;
    n = m;
    if (l != 0L) {
      n = m + CodedOutputByteBufferNano.computeUInt64Size(6, l);
    }
    l = this.g;
    m = n;
    if (l != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(7, l);
    }
    l = this.h;
    n = m;
    if (l != 0L) {
      n = m + CodedOutputByteBufferNano.computeUInt64Size(8, l);
    }
    m = n;
    if (!this.i.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(9, this.i);
    }
    n = m;
    if (!this.j.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(10, this.j);
    }
    l = this.k;
    m = n;
    if (l != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(11, l);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    if (!Arrays.equals(this.b, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(2, this.b);
    }
    int m = this.c;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, m);
    }
    m = this.d;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, m);
    }
    m = this.e;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, m);
    }
    l = this.f;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, l);
    }
    l = this.g;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    l = this.h;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(8, l);
    }
    if (!this.i.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.i);
    }
    if (!this.j.equals("")) {
      paramCodedOutputByteBufferNano.writeString(10, this.j);
    }
    l = this.k;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(11, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveWordSvr.nano.HippoChat
 * JD-Core Version:    0.7.0.1
 */