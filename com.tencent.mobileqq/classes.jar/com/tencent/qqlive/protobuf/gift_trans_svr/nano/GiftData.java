package com.tencent.qqlive.protobuf.gift_trans_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;

public final class GiftData
  extends ExtendableMessageNano<GiftData>
{
  public int a;
  public String b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public CornerIcon i;
  public FreeInfo j;
  
  public GiftData()
  {
    a();
  }
  
  public GiftData a()
  {
    this.a = 0;
    this.b = "";
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = null;
    this.j = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GiftData a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        if (this.j == null) {
          this.j = new FreeInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.j);
        break;
      case 74: 
        if (this.i == null) {
          this.i = new CornerIcon();
        }
        paramCodedInputByteBufferNano.readMessage(this.i);
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readInt32();
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt32();
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
        this.b = paramCodedInputByteBufferNano.readString();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int m = super.computeSerializedSize();
    int n = this.a;
    int k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeUInt32Size(1, n);
    }
    m = k;
    if (!this.b.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    n = this.c;
    k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeUInt32Size(3, n);
    }
    n = this.d;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(4, n);
    }
    n = this.e;
    k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeUInt32Size(5, n);
    }
    n = this.f;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(6, n);
    }
    n = this.g;
    k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeUInt32Size(7, n);
    }
    n = this.h;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeInt32Size(8, n);
    }
    Object localObject = this.i;
    k = m;
    if (localObject != null) {
      k = m + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
    }
    localObject = this.j;
    m = k;
    if (localObject != null) {
      m = k + CodedOutputByteBufferNano.computeMessageSize(10, (MessageNano)localObject);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int k = this.a;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, k);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    k = this.c;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, k);
    }
    k = this.d;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, k);
    }
    k = this.e;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, k);
    }
    k = this.f;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, k);
    }
    k = this.g;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, k);
    }
    k = this.h;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeInt32(8, k);
    }
    Object localObject = this.i;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
    }
    localObject = this.j;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(10, (MessageNano)localObject);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.gift_trans_svr.nano.GiftData
 * JD-Core Version:    0.7.0.1
 */