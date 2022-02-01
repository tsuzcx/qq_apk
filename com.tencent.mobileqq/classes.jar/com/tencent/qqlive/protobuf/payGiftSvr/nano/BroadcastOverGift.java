package com.tencent.qqlive.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class BroadcastOverGift
  extends ExtendableMessageNano<BroadcastOverGift>
{
  public int a;
  public long b;
  public byte[] c;
  public long d;
  public byte[] e;
  public long f;
  public long g;
  public int h;
  public int i;
  public int j;
  public int k;
  public byte[] l;
  public long m;
  public byte[] n;
  public byte[] o;
  public long p;
  public byte[] q;
  public TransparentMsg[] r;
  public byte[] s;
  public int t;
  public int u;
  
  public BroadcastOverGift()
  {
    a();
  }
  
  public BroadcastOverGift a()
  {
    this.a = 0;
    this.b = 0L;
    this.c = WireFormatNano.EMPTY_BYTES;
    this.d = 0L;
    this.e = WireFormatNano.EMPTY_BYTES;
    this.f = 0L;
    this.g = 0L;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.l = WireFormatNano.EMPTY_BYTES;
    this.m = 0L;
    this.n = WireFormatNano.EMPTY_BYTES;
    this.o = WireFormatNano.EMPTY_BYTES;
    this.p = 0L;
    this.q = WireFormatNano.EMPTY_BYTES;
    this.r = TransparentMsg.a();
    this.s = WireFormatNano.EMPTY_BYTES;
    this.t = 0;
    this.u = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public BroadcastOverGift a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 176: 
        this.u = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 168: 
        this.t = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 154: 
        this.s = paramCodedInputByteBufferNano.readBytes();
        break;
      case 146: 
        int i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 146);
        TransparentMsg[] arrayOfTransparentMsg = this.r;
        if (arrayOfTransparentMsg == null) {
          i1 = 0;
        } else {
          i1 = arrayOfTransparentMsg.length;
        }
        arrayOfTransparentMsg = new TransparentMsg[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.r, 0, arrayOfTransparentMsg, 0, i1);
          i2 = i1;
        }
        while (i2 < arrayOfTransparentMsg.length - 1)
        {
          arrayOfTransparentMsg[i2] = new TransparentMsg();
          paramCodedInputByteBufferNano.readMessage(arrayOfTransparentMsg[i2]);
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        arrayOfTransparentMsg[i2] = new TransparentMsg();
        paramCodedInputByteBufferNano.readMessage(arrayOfTransparentMsg[i2]);
        this.r = arrayOfTransparentMsg;
        break;
      case 138: 
        this.q = paramCodedInputByteBufferNano.readBytes();
        break;
      case 128: 
        this.p = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 122: 
        this.o = paramCodedInputByteBufferNano.readBytes();
        break;
      case 114: 
        this.n = paramCodedInputByteBufferNano.readBytes();
        break;
      case 104: 
        this.m = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 98: 
        this.l = paramCodedInputByteBufferNano.readBytes();
        break;
      case 88: 
        this.k = paramCodedInputByteBufferNano.readUInt32();
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
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 42: 
        this.e = paramCodedInputByteBufferNano.readBytes();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 26: 
        this.c = paramCodedInputByteBufferNano.readBytes();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i2 = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeBytesSize(3, this.c) + CodedOutputByteBufferNano.computeUInt64Size(4, this.d) + CodedOutputByteBufferNano.computeBytesSize(5, this.e);
    long l1 = this.f;
    int i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(6, l1);
    }
    l1 = this.g;
    i2 = i1;
    if (l1 != 0L) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt64Size(7, l1);
    }
    int i3 = this.h;
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
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(10, i3);
    }
    i3 = this.k;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(11, i3);
    }
    i1 = i2;
    if (!Arrays.equals(this.l, WireFormatNano.EMPTY_BYTES)) {
      i1 = i2 + CodedOutputByteBufferNano.computeBytesSize(12, this.l);
    }
    l1 = this.m;
    i2 = i1;
    if (l1 != 0L) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt64Size(13, l1);
    }
    i1 = i2;
    if (!Arrays.equals(this.n, WireFormatNano.EMPTY_BYTES)) {
      i1 = i2 + CodedOutputByteBufferNano.computeBytesSize(14, this.n);
    }
    i2 = i1;
    if (!Arrays.equals(this.o, WireFormatNano.EMPTY_BYTES)) {
      i2 = i1 + CodedOutputByteBufferNano.computeBytesSize(15, this.o);
    }
    l1 = this.p;
    i3 = i2;
    if (l1 != 0L) {
      i3 = i2 + CodedOutputByteBufferNano.computeUInt64Size(16, l1);
    }
    i1 = i3;
    if (!Arrays.equals(this.q, WireFormatNano.EMPTY_BYTES)) {
      i1 = i3 + CodedOutputByteBufferNano.computeBytesSize(17, this.q);
    }
    Object localObject = this.r;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.r;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(18, (MessageNano)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    i3 = i2;
    if (!Arrays.equals(this.s, WireFormatNano.EMPTY_BYTES)) {
      i3 = i2 + CodedOutputByteBufferNano.computeBytesSize(19, this.s);
    }
    i2 = this.t;
    i1 = i3;
    if (i2 != 0) {
      i1 = i3 + CodedOutputByteBufferNano.computeUInt32Size(21, i2);
    }
    i3 = this.u;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(22, i3);
    }
    return i2;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    paramCodedOutputByteBufferNano.writeBytes(3, this.c);
    paramCodedOutputByteBufferNano.writeUInt64(4, this.d);
    paramCodedOutputByteBufferNano.writeBytes(5, this.e);
    long l1 = this.f;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, l1);
    }
    l1 = this.g;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l1);
    }
    int i1 = this.h;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i1);
    }
    i1 = this.i;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, i1);
    }
    i1 = this.j;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, i1);
    }
    i1 = this.k;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, i1);
    }
    if (!Arrays.equals(this.l, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(12, this.l);
    }
    l1 = this.m;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(13, l1);
    }
    if (!Arrays.equals(this.n, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(14, this.n);
    }
    if (!Arrays.equals(this.o, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(15, this.o);
    }
    l1 = this.p;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(16, l1);
    }
    if (!Arrays.equals(this.q, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(17, this.q);
    }
    Object localObject = this.r;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.r;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(18, (MessageNano)localObject);
        }
        i1 += 1;
      }
    }
    if (!Arrays.equals(this.s, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(19, this.s);
    }
    i1 = this.t;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(21, i1);
    }
    i1 = this.u;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(22, i1);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.payGiftSvr.nano.BroadcastOverGift
 * JD-Core Version:    0.7.0.1
 */