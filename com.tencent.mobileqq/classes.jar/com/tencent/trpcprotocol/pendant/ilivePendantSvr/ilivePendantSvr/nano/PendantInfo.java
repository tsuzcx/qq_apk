package com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class PendantInfo
  extends ExtendableMessageNano<PendantInfo>
{
  private static volatile PendantInfo[] m;
  public String a;
  public String b;
  public String c;
  public int d;
  public long e;
  public long f;
  public long g;
  public PicUrlNumExtend h;
  public WebViewExtend i;
  public long j;
  public ExtDataItem[] k;
  public long l;
  
  public PendantInfo()
  {
    b();
  }
  
  public static PendantInfo[] a()
  {
    if (m == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (m == null) {
          m = new PendantInfo[0];
        }
      }
    }
    return m;
  }
  
  public PendantInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 808: 
        this.l = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 802: 
        int i1 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 802);
        ExtDataItem[] arrayOfExtDataItem = this.k;
        if (arrayOfExtDataItem == null) {
          n = 0;
        } else {
          n = arrayOfExtDataItem.length;
        }
        arrayOfExtDataItem = new ExtDataItem[i1 + n];
        i1 = n;
        if (n != 0)
        {
          System.arraycopy(this.k, 0, arrayOfExtDataItem, 0, n);
          i1 = n;
        }
        while (i1 < arrayOfExtDataItem.length - 1)
        {
          arrayOfExtDataItem[i1] = new ExtDataItem();
          paramCodedInputByteBufferNano.readMessage(arrayOfExtDataItem[i1]);
          paramCodedInputByteBufferNano.readTag();
          i1 += 1;
        }
        arrayOfExtDataItem[i1] = new ExtDataItem();
        paramCodedInputByteBufferNano.readMessage(arrayOfExtDataItem[i1]);
        this.k = arrayOfExtDataItem;
        break;
      case 80: 
        this.j = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 74: 
        if (this.i == null) {
          this.i = new WebViewExtend();
        }
        paramCodedInputByteBufferNano.readMessage(this.i);
        break;
      case 66: 
        if (this.h == null) {
          this.h = new PicUrlNumExtend();
        }
        paramCodedInputByteBufferNano.readMessage(this.h);
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readInt64();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readInt64();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readInt64();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
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
  
  public PendantInfo b()
  {
    this.a = "";
    this.b = "";
    this.c = "";
    this.d = 0;
    this.e = 0L;
    this.f = 0L;
    this.g = 0L;
    this.h = null;
    this.i = null;
    this.j = 0L;
    this.k = ExtDataItem.a();
    this.l = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i1 = super.computeSerializedSize();
    int n = i1;
    if (!this.a.equals("")) {
      n = i1 + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    i1 = n;
    if (!this.b.equals("")) {
      i1 = n + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    n = i1;
    if (!this.c.equals("")) {
      n = i1 + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    int i2 = this.d;
    i1 = n;
    if (i2 != 0) {
      i1 = n + CodedOutputByteBufferNano.computeUInt32Size(4, i2);
    }
    long l1 = this.e;
    n = i1;
    if (l1 != 0L) {
      n = i1 + CodedOutputByteBufferNano.computeInt64Size(5, l1);
    }
    l1 = this.f;
    i1 = n;
    if (l1 != 0L) {
      i1 = n + CodedOutputByteBufferNano.computeInt64Size(6, l1);
    }
    l1 = this.g;
    n = i1;
    if (l1 != 0L) {
      n = i1 + CodedOutputByteBufferNano.computeInt64Size(7, l1);
    }
    Object localObject = this.h;
    i1 = n;
    if (localObject != null) {
      i1 = n + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
    }
    localObject = this.i;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
    }
    l1 = this.j;
    n = i2;
    if (l1 != 0L) {
      n = i2 + CodedOutputByteBufferNano.computeUInt64Size(10, l1);
    }
    localObject = this.k;
    i1 = n;
    if (localObject != null)
    {
      i1 = n;
      if (localObject.length > 0)
      {
        i2 = 0;
        for (;;)
        {
          localObject = this.k;
          i1 = n;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i1 = n;
          if (localObject != null) {
            i1 = n + CodedOutputByteBufferNano.computeMessageSize(100, (MessageNano)localObject);
          }
          i2 += 1;
          n = i1;
        }
      }
    }
    l1 = this.l;
    n = i1;
    if (l1 != 0L) {
      n = i1 + CodedOutputByteBufferNano.computeUInt64Size(101, l1);
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
    int n = this.d;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, n);
    }
    long l1 = this.e;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(5, l1);
    }
    l1 = this.f;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(6, l1);
    }
    l1 = this.g;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(7, l1);
    }
    Object localObject = this.h;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)localObject);
    }
    localObject = this.i;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
    }
    l1 = this.j;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(10, l1);
    }
    localObject = this.k;
    if ((localObject != null) && (localObject.length > 0))
    {
      n = 0;
      for (;;)
      {
        localObject = this.k;
        if (n >= localObject.length) {
          break;
        }
        localObject = localObject[n];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(100, (MessageNano)localObject);
        }
        n += 1;
      }
    }
    l1 = this.l;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(101, l1);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.PendantInfo
 * JD-Core Version:    0.7.0.1
 */