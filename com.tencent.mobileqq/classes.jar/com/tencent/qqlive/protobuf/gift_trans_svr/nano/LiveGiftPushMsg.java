package com.tencent.qqlive.protobuf.gift_trans_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;

public final class LiveGiftPushMsg
  extends ExtendableMessageNano<LiveGiftPushMsg>
{
  public int a;
  public int b;
  public String c;
  public int d;
  public long e;
  public String f;
  public int g;
  public int h;
  public String i;
  public String j;
  public String k;
  public long l;
  public int m;
  public boolean n;
  
  public LiveGiftPushMsg()
  {
    a();
  }
  
  public static LiveGiftPushMsg a(byte[] paramArrayOfByte)
  {
    return (LiveGiftPushMsg)MessageNano.mergeFrom(new LiveGiftPushMsg(), paramArrayOfByte);
  }
  
  public LiveGiftPushMsg a()
  {
    this.a = 0;
    this.b = 0;
    this.c = "";
    this.d = 0;
    this.e = 0L;
    this.f = "";
    this.g = 0;
    this.h = 0;
    this.i = "";
    this.j = "";
    this.k = "";
    this.l = 0L;
    this.m = 0;
    this.n = false;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public LiveGiftPushMsg a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 112: 
        this.n = paramCodedInputByteBufferNano.readBool();
        break;
      case 104: 
        this.m = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 96: 
        this.l = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 90: 
        this.k = paramCodedInputByteBufferNano.readString();
        break;
      case 82: 
        this.j = paramCodedInputByteBufferNano.readString();
        break;
      case 74: 
        this.i = paramCodedInputByteBufferNano.readString();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 50: 
        this.f = paramCodedInputByteBufferNano.readString();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 26: 
        this.c = paramCodedInputByteBufferNano.readString();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i2 = super.computeSerializedSize();
    int i3 = this.a;
    int i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(1, i3);
    }
    i3 = this.b;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(2, i3);
    }
    i1 = i2;
    if (!this.c.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    i3 = this.d;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(4, i3);
    }
    long l1 = this.e;
    i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(5, l1);
    }
    i2 = i1;
    if (!this.f.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    i3 = this.g;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(7, i3);
    }
    i3 = this.h;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(8, i3);
    }
    i1 = i2;
    if (!this.i.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(9, this.i);
    }
    i2 = i1;
    if (!this.j.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(10, this.j);
    }
    i3 = i2;
    if (!this.k.equals("")) {
      i3 = i2 + CodedOutputByteBufferNano.computeStringSize(11, this.k);
    }
    l1 = this.l;
    i1 = i3;
    if (l1 != 0L) {
      i1 = i3 + CodedOutputByteBufferNano.computeUInt64Size(12, l1);
    }
    i3 = this.m;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(13, i3);
    }
    boolean bool = this.n;
    i1 = i2;
    if (bool) {
      i1 = i2 + CodedOutputByteBufferNano.computeBoolSize(14, bool);
    }
    return i1;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i1 = this.a;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i1);
    }
    i1 = this.b;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i1);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    i1 = this.d;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i1);
    }
    long l1 = this.e;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, l1);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    i1 = this.g;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i1);
    }
    i1 = this.h;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i1);
    }
    if (!this.i.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.i);
    }
    if (!this.j.equals("")) {
      paramCodedOutputByteBufferNano.writeString(10, this.j);
    }
    if (!this.k.equals("")) {
      paramCodedOutputByteBufferNano.writeString(11, this.k);
    }
    l1 = this.l;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(12, l1);
    }
    i1 = this.m;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(13, i1);
    }
    boolean bool = this.n;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(14, bool);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.gift_trans_svr.nano.LiveGiftPushMsg
 * JD-Core Version:    0.7.0.1
 */