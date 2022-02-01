package com.tencent.qqlive.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class Program
  extends ExtendableMessageNano<Program>
{
  public String a;
  public int b;
  public int c;
  public long d;
  public long e;
  public int f;
  public int g;
  public BaseInfo h;
  public int i;
  public int j;
  public KeyValue[] k;
  public int l;
  
  public Program()
  {
    a();
  }
  
  public Program a()
  {
    this.a = "";
    this.b = 0;
    this.c = 0;
    this.d = 0L;
    this.e = 0L;
    this.f = 0;
    this.g = 0;
    this.h = null;
    this.i = 0;
    this.j = 0;
    this.k = KeyValue.a();
    this.l = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public Program a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 96: 
        this.l = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 90: 
        int n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 90);
        KeyValue[] arrayOfKeyValue = this.k;
        if (arrayOfKeyValue == null) {
          m = 0;
        } else {
          m = arrayOfKeyValue.length;
        }
        arrayOfKeyValue = new KeyValue[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.k, 0, arrayOfKeyValue, 0, m);
          n = m;
        }
        while (n < arrayOfKeyValue.length - 1)
        {
          arrayOfKeyValue[n] = new KeyValue();
          paramCodedInputByteBufferNano.readMessage(arrayOfKeyValue[n]);
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        arrayOfKeyValue[n] = new KeyValue();
        paramCodedInputByteBufferNano.readMessage(arrayOfKeyValue[n]);
        this.k = arrayOfKeyValue;
        break;
      case 80: 
        this.j = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 72: 
        this.i = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 66: 
        if (this.h == null) {
          this.h = new BaseInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.h);
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt32();
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
    int n = m;
    if (!this.a.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    int i1 = this.b;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(2, i1);
    }
    i1 = this.c;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(3, i1);
    }
    long l1 = this.d;
    m = n;
    if (l1 != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(4, l1);
    }
    l1 = this.e;
    n = m;
    if (l1 != 0L) {
      n = m + CodedOutputByteBufferNano.computeUInt64Size(5, l1);
    }
    i1 = this.f;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(6, i1);
    }
    i1 = this.g;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(7, i1);
    }
    Object localObject = this.h;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
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
    localObject = this.k;
    n = m;
    if (localObject != null)
    {
      n = m;
      if (localObject.length > 0)
      {
        i1 = 0;
        for (;;)
        {
          localObject = this.k;
          n = m;
          if (i1 >= localObject.length) {
            break;
          }
          localObject = localObject[i1];
          n = m;
          if (localObject != null) {
            n = m + CodedOutputByteBufferNano.computeMessageSize(11, (MessageNano)localObject);
          }
          i1 += 1;
          m = n;
        }
      }
    }
    i1 = this.l;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(12, i1);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    int m = this.b;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, m);
    }
    m = this.c;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, m);
    }
    long l1 = this.d;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l1);
    }
    l1 = this.e;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, l1);
    }
    m = this.f;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, m);
    }
    m = this.g;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, m);
    }
    Object localObject = this.h;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)localObject);
    }
    m = this.i;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, m);
    }
    m = this.j;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, m);
    }
    localObject = this.k;
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
    m = this.l;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(12, m);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.roomAccess.nano.Program
 * JD-Core Version:    0.7.0.1
 */