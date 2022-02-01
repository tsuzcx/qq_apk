package com.tencent.qqlive.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GivePayGiftRsp
  extends ExtendableMessageNano<GivePayGiftRsp>
{
  public int a;
  public String b;
  public long c;
  public int d;
  public long e;
  public int f;
  public long g;
  public long h;
  public int i;
  public int j;
  public TransMsg[] k;
  
  public GivePayGiftRsp()
  {
    a();
  }
  
  public GivePayGiftRsp a()
  {
    this.a = 0;
    this.b = "";
    this.c = 0L;
    this.d = 0;
    this.e = 0L;
    this.f = 0;
    this.g = 0L;
    this.h = 0L;
    this.i = 0;
    this.j = 0;
    this.k = TransMsg.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GivePayGiftRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 90: 
        int n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 90);
        TransMsg[] arrayOfTransMsg = this.k;
        if (arrayOfTransMsg == null) {
          m = 0;
        } else {
          m = arrayOfTransMsg.length;
        }
        arrayOfTransMsg = new TransMsg[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.k, 0, arrayOfTransMsg, 0, m);
          n = m;
        }
        while (n < arrayOfTransMsg.length - 1)
        {
          arrayOfTransMsg[n] = new TransMsg();
          paramCodedInputByteBufferNano.readMessage(arrayOfTransMsg[n]);
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        arrayOfTransMsg[n] = new TransMsg();
        paramCodedInputByteBufferNano.readMessage(arrayOfTransMsg[n]);
        this.k = arrayOfTransMsg;
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
        this.g = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt64();
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
    int n = super.computeSerializedSize();
    int i1 = this.a;
    int m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(1, i1);
    }
    n = m;
    if (!this.b.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    long l = this.c;
    m = n;
    if (l != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    i1 = this.d;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(4, i1);
    }
    l = this.e;
    m = n;
    if (l != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(5, l);
    }
    i1 = this.f;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(6, i1);
    }
    l = this.g;
    i1 = n;
    if (l != 0L) {
      i1 = n + CodedOutputByteBufferNano.computeUInt64Size(7, l);
    }
    l = this.h;
    m = i1;
    if (l != 0L) {
      m = i1 + CodedOutputByteBufferNano.computeUInt64Size(8, l);
    }
    i1 = this.i;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(9, i1);
    }
    i1 = this.j;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(10, i1);
    }
    Object localObject = this.k;
    i1 = m;
    if (localObject != null)
    {
      i1 = m;
      if (localObject.length > 0)
      {
        n = 0;
        for (;;)
        {
          localObject = this.k;
          i1 = m;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          i1 = m;
          if (localObject != null) {
            i1 = m + CodedOutputByteBufferNano.computeMessageSize(11, (MessageNano)localObject);
          }
          n += 1;
          m = i1;
        }
      }
    }
    return i1;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int m = this.a;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, m);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    long l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    m = this.d;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, m);
    }
    l = this.e;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, l);
    }
    m = this.f;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, m);
    }
    l = this.g;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    l = this.h;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(8, l);
    }
    m = this.i;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, m);
    }
    m = this.j;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, m);
    }
    Object localObject = this.k;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = 0;
      for (;;)
      {
        localObject = this.k;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(11, (MessageNano)localObject);
        }
        m += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.payGiftSvr.nano.GivePayGiftRsp
 * JD-Core Version:    0.7.0.1
 */