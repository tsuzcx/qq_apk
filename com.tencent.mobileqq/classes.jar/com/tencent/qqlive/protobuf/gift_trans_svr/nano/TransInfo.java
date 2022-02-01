package com.tencent.qqlive.protobuf.gift_trans_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class TransInfo
  extends ExtendableMessageNano<TransInfo>
{
  public int a;
  public long b;
  public long c;
  public int d;
  public int e;
  public String f;
  public int g;
  public int h;
  public String i;
  public int j;
  public int k;
  public long l;
  public ExtData[] m;
  
  public TransInfo()
  {
    a();
  }
  
  public TransInfo a()
  {
    this.a = 0;
    this.b = 0L;
    this.c = 0L;
    this.d = 0;
    this.e = 0;
    this.f = "";
    this.g = 0;
    this.h = 0;
    this.i = "";
    this.j = 0;
    this.k = 0;
    this.l = 0L;
    this.m = ExtData.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public TransInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        ExtData[] arrayOfExtData = this.m;
        if (arrayOfExtData == null) {
          n = 0;
        } else {
          n = arrayOfExtData.length;
        }
        arrayOfExtData = new ExtData[i1 + n];
        i1 = n;
        if (n != 0)
        {
          System.arraycopy(this.m, 0, arrayOfExtData, 0, n);
          i1 = n;
        }
        while (i1 < arrayOfExtData.length - 1)
        {
          arrayOfExtData[i1] = new ExtData();
          paramCodedInputByteBufferNano.readMessage(arrayOfExtData[i1]);
          paramCodedInputByteBufferNano.readTag();
          i1 += 1;
        }
        arrayOfExtData[i1] = new ExtData();
        paramCodedInputByteBufferNano.readMessage(arrayOfExtData[i1]);
        this.m = arrayOfExtData;
        break;
      case 96: 
        this.l = paramCodedInputByteBufferNano.readInt64();
        break;
      case 88: 
        this.k = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 80: 
        this.j = paramCodedInputByteBufferNano.readUInt32();
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
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i1 = super.computeSerializedSize();
    int i2 = this.a;
    int n = i1;
    if (i2 != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(1, i2);
    }
    long l1 = this.b;
    i2 = n;
    if (l1 != 0L) {
      i2 = n + CodedOutputByteBufferNano.computeUInt64Size(2, l1);
    }
    l1 = this.c;
    i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(3, l1);
    }
    i2 = this.d;
    n = i1;
    if (i2 != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(4, i2);
    }
    i2 = this.e;
    i1 = n;
    if (i2 != 0) {
      i1 = n + CodedOutputByteBufferNano.computeUInt32Size(5, i2);
    }
    i2 = i1;
    if (!this.f.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    i1 = this.g;
    n = i2;
    if (i1 != 0) {
      n = i2 + CodedOutputByteBufferNano.computeUInt32Size(7, i1);
    }
    i2 = this.h;
    i1 = n;
    if (i2 != 0) {
      i1 = n + CodedOutputByteBufferNano.computeUInt32Size(8, i2);
    }
    i2 = i1;
    if (!this.i.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(9, this.i);
    }
    i1 = this.j;
    n = i2;
    if (i1 != 0) {
      n = i2 + CodedOutputByteBufferNano.computeUInt32Size(10, i1);
    }
    i2 = this.k;
    i1 = n;
    if (i2 != 0) {
      i1 = n + CodedOutputByteBufferNano.computeUInt32Size(11, i2);
    }
    l1 = this.l;
    n = i1;
    if (l1 != 0L) {
      n = i1 + CodedOutputByteBufferNano.computeInt64Size(12, l1);
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
    int n = this.a;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, n);
    }
    long l1 = this.b;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l1);
    }
    l1 = this.c;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l1);
    }
    n = this.d;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, n);
    }
    n = this.e;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, n);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    n = this.g;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, n);
    }
    n = this.h;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, n);
    }
    if (!this.i.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.i);
    }
    n = this.j;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, n);
    }
    n = this.k;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, n);
    }
    l1 = this.l;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(12, l1);
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
 * Qualified Name:     com.tencent.qqlive.protobuf.gift_trans_svr.nano.TransInfo
 * JD-Core Version:    0.7.0.1
 */