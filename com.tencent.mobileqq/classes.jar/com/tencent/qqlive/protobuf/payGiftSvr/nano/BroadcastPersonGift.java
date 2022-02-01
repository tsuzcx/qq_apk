package com.tencent.qqlive.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class BroadcastPersonGift
  extends ExtendableMessageNano<BroadcastPersonGift>
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
  public ILiveGiftSite[] l;
  public byte[] m;
  public long n;
  public long o;
  public byte[] p;
  public byte[] q;
  public int r;
  public long s;
  public byte[] t;
  public TransparentMsg[] u;
  public byte[] v;
  public int w;
  public int x;
  
  public BroadcastPersonGift()
  {
    a();
  }
  
  public BroadcastPersonGift a()
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
    this.l = ILiveGiftSite.a();
    this.m = WireFormatNano.EMPTY_BYTES;
    this.n = 0L;
    this.o = 0L;
    this.p = WireFormatNano.EMPTY_BYTES;
    this.q = WireFormatNano.EMPTY_BYTES;
    this.r = 0;
    this.s = 0L;
    this.t = WireFormatNano.EMPTY_BYTES;
    this.u = TransparentMsg.a();
    this.v = WireFormatNano.EMPTY_BYTES;
    this.w = 0;
    this.x = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public BroadcastPersonGift a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i1 = paramCodedInputByteBufferNano.readTag();
      int i2;
      Object localObject;
      switch (i1)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, i1)) {
          return this;
        }
        break;
      case 200: 
        this.x = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 192: 
        this.w = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 178: 
        this.v = paramCodedInputByteBufferNano.readBytes();
        break;
      case 170: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 170);
        localObject = this.u;
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = localObject.length;
        }
        localObject = new TransparentMsg[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.u, 0, localObject, 0, i1);
          i2 = i1;
        }
        while (i2 < localObject.length - 1)
        {
          localObject[i2] = new TransparentMsg();
          paramCodedInputByteBufferNano.readMessage(localObject[i2]);
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        localObject[i2] = new TransparentMsg();
        paramCodedInputByteBufferNano.readMessage(localObject[i2]);
        this.u = ((TransparentMsg[])localObject);
        break;
      case 162: 
        this.t = paramCodedInputByteBufferNano.readBytes();
        break;
      case 152: 
        this.s = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 144: 
        this.r = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 138: 
        this.q = paramCodedInputByteBufferNano.readBytes();
        break;
      case 130: 
        this.p = paramCodedInputByteBufferNano.readBytes();
        break;
      case 120: 
        this.o = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 112: 
        this.n = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 106: 
        this.m = paramCodedInputByteBufferNano.readBytes();
        break;
      case 98: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 98);
        localObject = this.l;
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = localObject.length;
        }
        localObject = new ILiveGiftSite[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.l, 0, localObject, 0, i1);
          i2 = i1;
        }
        while (i2 < localObject.length - 1)
        {
          localObject[i2] = new ILiveGiftSite();
          paramCodedInputByteBufferNano.readMessage(localObject[i2]);
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        localObject[i2] = new ILiveGiftSite();
        paramCodedInputByteBufferNano.readMessage(localObject[i2]);
        this.l = ((ILiveGiftSite[])localObject);
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
    i1 = this.j;
    i3 = i2;
    if (i1 != 0) {
      i3 = i2 + CodedOutputByteBufferNano.computeUInt32Size(10, i1);
    }
    i2 = this.k;
    i1 = i3;
    if (i2 != 0) {
      i1 = i3 + CodedOutputByteBufferNano.computeUInt32Size(11, i2);
    }
    Object localObject = this.l;
    int i4 = 0;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        for (;;)
        {
          localObject = this.l;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + CodedOutputByteBufferNano.computeMessageSize(12, (MessageNano)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    i1 = i2;
    if (!Arrays.equals(this.m, WireFormatNano.EMPTY_BYTES)) {
      i1 = i2 + CodedOutputByteBufferNano.computeBytesSize(13, this.m);
    }
    l1 = this.n;
    i2 = i1;
    if (l1 != 0L) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt64Size(14, l1);
    }
    l1 = this.o;
    i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(15, l1);
    }
    i2 = i1;
    if (!Arrays.equals(this.p, WireFormatNano.EMPTY_BYTES)) {
      i2 = i1 + CodedOutputByteBufferNano.computeBytesSize(16, this.p);
    }
    i1 = i2;
    if (!Arrays.equals(this.q, WireFormatNano.EMPTY_BYTES)) {
      i1 = i2 + CodedOutputByteBufferNano.computeBytesSize(17, this.q);
    }
    i3 = this.r;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(18, i3);
    }
    l1 = this.s;
    i3 = i2;
    if (l1 != 0L) {
      i3 = i2 + CodedOutputByteBufferNano.computeUInt64Size(19, l1);
    }
    i1 = i3;
    if (!Arrays.equals(this.t, WireFormatNano.EMPTY_BYTES)) {
      i1 = i3 + CodedOutputByteBufferNano.computeBytesSize(20, this.t);
    }
    localObject = this.u;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = i4;
        for (;;)
        {
          localObject = this.u;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(21, (MessageNano)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    i3 = i2;
    if (!Arrays.equals(this.v, WireFormatNano.EMPTY_BYTES)) {
      i3 = i2 + CodedOutputByteBufferNano.computeBytesSize(22, this.v);
    }
    i2 = this.w;
    i1 = i3;
    if (i2 != 0) {
      i1 = i3 + CodedOutputByteBufferNano.computeUInt32Size(24, i2);
    }
    i3 = this.x;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(25, i3);
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
    Object localObject = this.l;
    int i2 = 0;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.l;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(12, (MessageNano)localObject);
        }
        i1 += 1;
      }
    }
    if (!Arrays.equals(this.m, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(13, this.m);
    }
    l1 = this.n;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(14, l1);
    }
    l1 = this.o;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(15, l1);
    }
    if (!Arrays.equals(this.p, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(16, this.p);
    }
    if (!Arrays.equals(this.q, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(17, this.q);
    }
    i1 = this.r;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(18, i1);
    }
    l1 = this.s;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(19, l1);
    }
    if (!Arrays.equals(this.t, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(20, this.t);
    }
    localObject = this.u;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = i2;
      for (;;)
      {
        localObject = this.u;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(21, (MessageNano)localObject);
        }
        i1 += 1;
      }
    }
    if (!Arrays.equals(this.v, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(22, this.v);
    }
    i1 = this.w;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(24, i1);
    }
    i1 = this.x;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(25, i1);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.payGiftSvr.nano.BroadcastPersonGift
 * JD-Core Version:    0.7.0.1
 */