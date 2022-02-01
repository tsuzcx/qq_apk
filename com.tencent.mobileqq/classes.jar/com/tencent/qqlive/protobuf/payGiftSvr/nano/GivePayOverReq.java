package com.tencent.qqlive.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class GivePayOverReq
  extends ExtendableMessageNano<GivePayOverReq>
{
  public long a;
  public long b;
  public long c;
  public int d;
  public int e;
  public int f;
  public int g;
  public byte[] h;
  public long i;
  public byte[] j;
  public long k;
  public byte[] l;
  public TransparentMsg[] m;
  
  public GivePayOverReq()
  {
    a();
  }
  
  public GivePayOverReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = WireFormatNano.EMPTY_BYTES;
    this.i = 0L;
    this.j = WireFormatNano.EMPTY_BYTES;
    this.k = 0L;
    this.l = WireFormatNano.EMPTY_BYTES;
    this.m = TransparentMsg.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GivePayOverReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int n = paramCodedInputByteBufferNano.readTag();
      switch (n)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, n)) {
          return this;
        }
        break;
      case 106: 
        int i1 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 106);
        TransparentMsg[] arrayOfTransparentMsg = this.m;
        if (arrayOfTransparentMsg == null) {
          n = 0;
        } else {
          n = arrayOfTransparentMsg.length;
        }
        arrayOfTransparentMsg = new TransparentMsg[i1 + n];
        i1 = n;
        if (n != 0)
        {
          System.arraycopy(this.m, 0, arrayOfTransparentMsg, 0, n);
          i1 = n;
        }
        while (i1 < arrayOfTransparentMsg.length - 1)
        {
          arrayOfTransparentMsg[i1] = new TransparentMsg();
          paramCodedInputByteBufferNano.readMessage(arrayOfTransparentMsg[i1]);
          paramCodedInputByteBufferNano.readTag();
          i1 += 1;
        }
        arrayOfTransparentMsg[i1] = new TransparentMsg();
        paramCodedInputByteBufferNano.readMessage(arrayOfTransparentMsg[i1]);
        this.m = arrayOfTransparentMsg;
        break;
      case 98: 
        this.l = paramCodedInputByteBufferNano.readBytes();
        break;
      case 88: 
        this.k = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 82: 
        this.j = paramCodedInputByteBufferNano.readBytes();
        break;
      case 72: 
        this.i = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 66: 
        this.h = paramCodedInputByteBufferNano.readBytes();
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
    int i1 = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeUInt64Size(3, this.c) + CodedOutputByteBufferNano.computeUInt32Size(4, this.d);
    int i2 = this.e;
    int n = i1;
    if (i2 != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(5, i2);
    }
    i2 = this.f;
    i1 = n;
    if (i2 != 0) {
      i1 = n + CodedOutputByteBufferNano.computeUInt32Size(6, i2);
    }
    i2 = this.g;
    n = i1;
    if (i2 != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(7, i2);
    }
    i1 = n;
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      i1 = n + CodedOutputByteBufferNano.computeBytesSize(8, this.h);
    }
    long l1 = this.i;
    n = i1;
    if (l1 != 0L) {
      n = i1 + CodedOutputByteBufferNano.computeUInt64Size(9, l1);
    }
    i1 = n;
    if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
      i1 = n + CodedOutputByteBufferNano.computeBytesSize(10, this.j);
    }
    l1 = this.k;
    i2 = i1;
    if (l1 != 0L) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt64Size(11, l1);
    }
    n = i2;
    if (!Arrays.equals(this.l, WireFormatNano.EMPTY_BYTES)) {
      n = i2 + CodedOutputByteBufferNano.computeBytesSize(12, this.l);
    }
    Object localObject = this.m;
    i2 = n;
    if (localObject != null)
    {
      i2 = n;
      if (localObject.length > 0)
      {
        i1 = 0;
        for (;;)
        {
          localObject = this.m;
          i2 = n;
          if (i1 >= localObject.length) {
            break;
          }
          localObject = localObject[i1];
          i2 = n;
          if (localObject != null) {
            i2 = n + CodedOutputByteBufferNano.computeMessageSize(13, (MessageNano)localObject);
          }
          i1 += 1;
          n = i2;
        }
      }
    }
    return i2;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt64(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt64(3, this.c);
    paramCodedOutputByteBufferNano.writeUInt32(4, this.d);
    int n = this.e;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, n);
    }
    n = this.f;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, n);
    }
    n = this.g;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, n);
    }
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(8, this.h);
    }
    long l1 = this.i;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(9, l1);
    }
    if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(10, this.j);
    }
    l1 = this.k;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(11, l1);
    }
    if (!Arrays.equals(this.l, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(12, this.l);
    }
    Object localObject = this.m;
    if ((localObject != null) && (localObject.length > 0))
    {
      n = 0;
      for (;;)
      {
        localObject = this.m;
        if (n >= localObject.length) {
          break;
        }
        localObject = localObject[n];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(13, (MessageNano)localObject);
        }
        n += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.payGiftSvr.nano.GivePayOverReq
 * JD-Core Version:    0.7.0.1
 */