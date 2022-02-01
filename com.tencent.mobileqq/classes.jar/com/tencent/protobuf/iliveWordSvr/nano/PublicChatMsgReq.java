package com.tencent.protobuf.iliveWordSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class PublicChatMsgReq
  extends ExtendableMessageNano<PublicChatMsgReq>
{
  public long a;
  public long b;
  public long c;
  public int d;
  public byte[] e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public byte[] k;
  public long l;
  public int m;
  public long n;
  public byte[] o;
  public int p;
  public String q;
  
  public PublicChatMsgReq()
  {
    a();
  }
  
  public PublicChatMsgReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0;
    this.e = WireFormatNano.EMPTY_BYTES;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = WireFormatNano.EMPTY_BYTES;
    this.l = 0L;
    this.m = 0;
    this.n = 0L;
    this.o = WireFormatNano.EMPTY_BYTES;
    this.p = 0;
    this.q = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PublicChatMsgReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i1 = paramCodedInputByteBufferNano.readTag();
      switch (i1)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, i1)) {
          return this;
        }
        break;
      case 138: 
        this.q = paramCodedInputByteBufferNano.readString();
        break;
      case 128: 
        this.p = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 122: 
        this.o = paramCodedInputByteBufferNano.readBytes();
        break;
      case 112: 
        this.n = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 104: 
        this.m = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 96: 
        this.l = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 90: 
        this.k = paramCodedInputByteBufferNano.readBytes();
        break;
      case 80: 
        this.j = paramCodedInputByteBufferNano.readSInt32();
        break;
      case 72: 
        this.i = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 42: 
        this.e = paramCodedInputByteBufferNano.readBytes();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
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
    int i2 = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeUInt64Size(3, this.c);
    int i3 = this.d;
    int i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(4, i3);
    }
    i2 = i1;
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      i2 = i1 + CodedOutputByteBufferNano.computeBytesSize(5, this.e);
    }
    i3 = this.f;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(6, i3);
    }
    i3 = this.g;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(7, i3);
    }
    i3 = this.h;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(8, i3);
    }
    i3 = this.i;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(9, i3);
    }
    i3 = this.j;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeSInt32Size(10, i3);
    }
    i2 = i1;
    if (!Arrays.equals(this.k, WireFormatNano.EMPTY_BYTES)) {
      i2 = i1 + CodedOutputByteBufferNano.computeBytesSize(11, this.k);
    }
    long l1 = this.l;
    i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(12, l1);
    }
    i3 = this.m;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(13, i3);
    }
    l1 = this.n;
    i3 = i2;
    if (l1 != 0L) {
      i3 = i2 + CodedOutputByteBufferNano.computeUInt64Size(14, l1);
    }
    i1 = i3;
    if (!Arrays.equals(this.o, WireFormatNano.EMPTY_BYTES)) {
      i1 = i3 + CodedOutputByteBufferNano.computeBytesSize(15, this.o);
    }
    i3 = this.p;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(16, i3);
    }
    i1 = i2;
    if (!this.q.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(17, this.q);
    }
    return i1;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt64(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt64(3, this.c);
    int i1 = this.d;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i1);
    }
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(5, this.e);
    }
    i1 = this.f;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, i1);
    }
    i1 = this.g;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i1);
    }
    i1 = this.h;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i1);
    }
    i1 = this.i;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, i1);
    }
    i1 = this.j;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeSInt32(10, i1);
    }
    if (!Arrays.equals(this.k, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(11, this.k);
    }
    long l1 = this.l;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(12, l1);
    }
    i1 = this.m;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(13, i1);
    }
    l1 = this.n;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(14, l1);
    }
    if (!Arrays.equals(this.o, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(15, this.o);
    }
    i1 = this.p;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(16, i1);
    }
    if (!this.q.equals("")) {
      paramCodedOutputByteBufferNano.writeString(17, this.q);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveWordSvr.nano.PublicChatMsgReq
 * JD-Core Version:    0.7.0.1
 */