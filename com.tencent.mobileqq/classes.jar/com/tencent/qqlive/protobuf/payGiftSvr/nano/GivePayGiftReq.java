package com.tencent.qqlive.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class GivePayGiftReq
  extends ExtendableMessageNano<GivePayGiftReq>
{
  public long a;
  public long b;
  public long c;
  public int d;
  public int e;
  public int f;
  public int g;
  public long h;
  public int i;
  public int j;
  public byte[] k;
  public long l;
  public byte[] m;
  public int n;
  public long o;
  public String p;
  public String q;
  public ILiveGiftSite[] r;
  public byte[] s;
  public TransparentMsg[] t;
  
  public GivePayGiftReq()
  {
    a();
  }
  
  public GivePayGiftReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0L;
    this.i = 0;
    this.j = 0;
    this.k = WireFormatNano.EMPTY_BYTES;
    this.l = 0L;
    this.m = WireFormatNano.EMPTY_BYTES;
    this.n = 0;
    this.o = 0L;
    this.p = "";
    this.q = "";
    this.r = ILiveGiftSite.a();
    this.s = WireFormatNano.EMPTY_BYTES;
    this.t = TransparentMsg.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GivePayGiftReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 162: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 162);
        localObject = this.t;
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = localObject.length;
        }
        localObject = new TransparentMsg[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.t, 0, localObject, 0, i1);
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
        this.t = ((TransparentMsg[])localObject);
        break;
      case 154: 
        this.s = paramCodedInputByteBufferNano.readBytes();
        break;
      case 146: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 146);
        localObject = this.r;
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = localObject.length;
        }
        localObject = new ILiveGiftSite[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.r, 0, localObject, 0, i1);
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
        this.r = ((ILiveGiftSite[])localObject);
        break;
      case 138: 
        this.q = paramCodedInputByteBufferNano.readString();
        break;
      case 130: 
        this.p = paramCodedInputByteBufferNano.readString();
        break;
      case 120: 
        this.o = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 112: 
        this.n = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 106: 
        this.m = paramCodedInputByteBufferNano.readBytes();
        break;
      case 96: 
        this.l = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 90: 
        this.k = paramCodedInputByteBufferNano.readBytes();
        break;
      case 80: 
        this.j = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 72: 
        this.i = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readUInt64();
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
    int i2 = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeUInt64Size(3, this.c) + CodedOutputByteBufferNano.computeUInt32Size(4, this.d) + CodedOutputByteBufferNano.computeUInt32Size(5, this.e) + CodedOutputByteBufferNano.computeUInt32Size(6, this.f);
    int i3 = this.g;
    int i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(7, i3);
    }
    long l1 = this.h;
    i2 = i1;
    if (l1 != 0L) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt64Size(8, l1);
    }
    i3 = this.i;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(9, i3);
    }
    i3 = this.j;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(10, i3);
    }
    i1 = i2;
    if (!Arrays.equals(this.k, WireFormatNano.EMPTY_BYTES)) {
      i1 = i2 + CodedOutputByteBufferNano.computeBytesSize(11, this.k);
    }
    l1 = this.l;
    i2 = i1;
    if (l1 != 0L) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt64Size(12, l1);
    }
    i1 = i2;
    if (!Arrays.equals(this.m, WireFormatNano.EMPTY_BYTES)) {
      i1 = i2 + CodedOutputByteBufferNano.computeBytesSize(13, this.m);
    }
    i3 = this.n;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(14, i3);
    }
    l1 = this.o;
    i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(15, l1);
    }
    i2 = i1;
    if (!this.p.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(16, this.p);
    }
    i1 = i2;
    if (!this.q.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(17, this.q);
    }
    Object localObject = this.r;
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
          localObject = this.r;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + CodedOutputByteBufferNano.computeMessageSize(18, (MessageNano)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    i1 = i2;
    if (!Arrays.equals(this.s, WireFormatNano.EMPTY_BYTES)) {
      i1 = i2 + CodedOutputByteBufferNano.computeBytesSize(19, this.s);
    }
    localObject = this.t;
    i3 = i1;
    if (localObject != null)
    {
      i3 = i1;
      if (localObject.length > 0)
      {
        i2 = i4;
        for (;;)
        {
          localObject = this.t;
          i3 = i1;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + CodedOutputByteBufferNano.computeMessageSize(20, (MessageNano)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
      }
    }
    return i3;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt64(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt64(3, this.c);
    paramCodedOutputByteBufferNano.writeUInt32(4, this.d);
    paramCodedOutputByteBufferNano.writeUInt32(5, this.e);
    paramCodedOutputByteBufferNano.writeUInt32(6, this.f);
    int i1 = this.g;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i1);
    }
    long l1 = this.h;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(8, l1);
    }
    i1 = this.i;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, i1);
    }
    i1 = this.j;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, i1);
    }
    if (!Arrays.equals(this.k, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(11, this.k);
    }
    l1 = this.l;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(12, l1);
    }
    if (!Arrays.equals(this.m, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(13, this.m);
    }
    i1 = this.n;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(14, i1);
    }
    l1 = this.o;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(15, l1);
    }
    if (!this.p.equals("")) {
      paramCodedOutputByteBufferNano.writeString(16, this.p);
    }
    if (!this.q.equals("")) {
      paramCodedOutputByteBufferNano.writeString(17, this.q);
    }
    Object localObject = this.r;
    int i2 = 0;
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
    localObject = this.t;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = i2;
      for (;;)
      {
        localObject = this.t;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(20, (MessageNano)localObject);
        }
        i1 += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.payGiftSvr.nano.GivePayGiftReq
 * JD-Core Version:    0.7.0.1
 */