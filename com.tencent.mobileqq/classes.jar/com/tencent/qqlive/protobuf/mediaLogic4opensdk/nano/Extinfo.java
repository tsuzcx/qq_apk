package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class Extinfo
  extends ExtendableMessageNano<Extinfo>
{
  public String a;
  public String b;
  public String c;
  public Resolution d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public KvPair[] j;
  
  public Extinfo()
  {
    a();
  }
  
  public Extinfo a()
  {
    this.a = "";
    this.b = "";
    this.c = "";
    this.d = null;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = KvPair.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public Extinfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 90: 
        int m = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 90);
        KvPair[] arrayOfKvPair = this.j;
        if (arrayOfKvPair == null) {
          k = 0;
        } else {
          k = arrayOfKvPair.length;
        }
        arrayOfKvPair = new KvPair[m + k];
        m = k;
        if (k != 0)
        {
          System.arraycopy(this.j, 0, arrayOfKvPair, 0, k);
          m = k;
        }
        while (m < arrayOfKvPair.length - 1)
        {
          arrayOfKvPair[m] = new KvPair();
          paramCodedInputByteBufferNano.readMessage(arrayOfKvPair[m]);
          paramCodedInputByteBufferNano.readTag();
          m += 1;
        }
        arrayOfKvPair[m] = new KvPair();
        paramCodedInputByteBufferNano.readMessage(arrayOfKvPair[m]);
        this.j = arrayOfKvPair;
        break;
      case 80: 
        this.i = paramCodedInputByteBufferNano.readUInt32();
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
      case 34: 
        if (this.d == null) {
          this.d = new Resolution();
        }
        paramCodedInputByteBufferNano.readMessage(this.d);
        break;
      case 26: 
        this.c = paramCodedInputByteBufferNano.readString();
        break;
      case 18: 
        this.b = paramCodedInputByteBufferNano.readString();
        break;
      case 10: 
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int m = super.computeSerializedSize();
    int k = m;
    if (!this.a.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    m = k;
    if (!this.b.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    k = m;
    if (!this.c.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    Object localObject = this.d;
    m = k;
    if (localObject != null) {
      m = k + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
    }
    int n = this.e;
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
    n = this.i;
    k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeUInt32Size(10, n);
    }
    localObject = this.j;
    n = k;
    if (localObject != null)
    {
      n = k;
      if (localObject.length > 0)
      {
        m = 0;
        for (;;)
        {
          localObject = this.j;
          n = k;
          if (m >= localObject.length) {
            break;
          }
          localObject = localObject[m];
          n = k;
          if (localObject != null) {
            n = k + CodedOutputByteBufferNano.computeMessageSize(11, (MessageNano)localObject);
          }
          m += 1;
          k = n;
        }
      }
    }
    return n;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    Object localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, (MessageNano)localObject);
    }
    int k = this.e;
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
    k = this.i;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, k);
    }
    localObject = this.j;
    if ((localObject != null) && (localObject.length > 0))
    {
      k = 0;
      for (;;)
      {
        localObject = this.j;
        if (k >= localObject.length) {
          break;
        }
        localObject = localObject[k];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(11, (MessageNano)localObject);
        }
        k += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.Extinfo
 * JD-Core Version:    0.7.0.1
 */