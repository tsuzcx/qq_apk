package com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.trpcprotocol.ilive.common.roomMsg.nano.MsgPolicy;

public final class ViewInfo
  extends ExtendableMessageNano<ViewInfo>
{
  private static volatile ViewInfo[] l;
  public long a;
  public long b;
  public String c;
  public long d;
  public UpdateFrequency e;
  public String f;
  public long g;
  public ViewItemInfo h;
  public MsgPolicy i;
  public long[] j;
  public ExtDataItem[] k;
  
  public ViewInfo()
  {
    b();
  }
  
  public static ViewInfo a(byte[] paramArrayOfByte)
  {
    return (ViewInfo)MessageNano.mergeFrom(new ViewInfo(), paramArrayOfByte);
  }
  
  public static ViewInfo[] a()
  {
    if (l == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (l == null) {
          l = new ViewInfo[0];
        }
      }
    }
    return l;
  }
  
  public ViewInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int m = paramCodedInputByteBufferNano.readTag();
      int n;
      Object localObject;
      switch (m)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, m)) {
          return this;
        }
        break;
      case 90: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 90);
        localObject = this.k;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new ExtDataItem[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.k, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = new ExtDataItem();
          paramCodedInputByteBufferNano.readMessage(localObject[n]);
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = new ExtDataItem();
        paramCodedInputByteBufferNano.readMessage(localObject[n]);
        this.k = ((ExtDataItem[])localObject);
        break;
      case 82: 
        int i1 = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
        m = paramCodedInputByteBufferNano.getPosition();
        n = 0;
        while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
        {
          paramCodedInputByteBufferNano.readUInt64();
          n += 1;
        }
        paramCodedInputByteBufferNano.rewindToPosition(m);
        localObject = this.j;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new long[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.j, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length)
        {
          localObject[n] = paramCodedInputByteBufferNano.readUInt64();
          n += 1;
        }
        this.j = ((long[])localObject);
        paramCodedInputByteBufferNano.popLimit(i1);
        break;
      case 80: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 80);
        localObject = this.j;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new long[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.j, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = paramCodedInputByteBufferNano.readUInt64();
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = paramCodedInputByteBufferNano.readUInt64();
        this.j = ((long[])localObject);
        break;
      case 74: 
        if (this.i == null) {
          this.i = new MsgPolicy();
        }
        paramCodedInputByteBufferNano.readMessage(this.i);
        break;
      case 66: 
        if (this.h == null) {
          this.h = new ViewItemInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.h);
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 50: 
        this.f = paramCodedInputByteBufferNano.readString();
        break;
      case 42: 
        if (this.e == null) {
          this.e = new UpdateFrequency();
        }
        paramCodedInputByteBufferNano.readMessage(this.e);
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 26: 
        this.c = paramCodedInputByteBufferNano.readString();
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
  
  public ViewInfo b()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = "";
    this.d = 0L;
    this.e = null;
    this.f = "";
    this.g = 0L;
    this.h = null;
    this.i = null;
    this.j = WireFormatNano.EMPTY_LONG_ARRAY;
    this.k = ExtDataItem.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int n = super.computeSerializedSize();
    long l1 = this.a;
    int m = n;
    if (l1 != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(1, l1);
    }
    l1 = this.b;
    n = m;
    if (l1 != 0L) {
      n = m + CodedOutputByteBufferNano.computeUInt64Size(2, l1);
    }
    m = n;
    if (!this.c.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    l1 = this.d;
    n = m;
    if (l1 != 0L) {
      n = m + CodedOutputByteBufferNano.computeUInt64Size(4, l1);
    }
    Object localObject = this.e;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano)localObject);
    }
    n = m;
    if (!this.f.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    l1 = this.g;
    m = n;
    if (l1 != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(7, l1);
    }
    localObject = this.h;
    int i1 = m;
    if (localObject != null) {
      i1 = m + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
    }
    localObject = this.i;
    n = i1;
    if (localObject != null) {
      n = i1 + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
    }
    localObject = this.j;
    int i2 = 0;
    m = n;
    if (localObject != null)
    {
      m = n;
      if (localObject.length > 0)
      {
        m = 0;
        i1 = 0;
        for (;;)
        {
          localObject = this.j;
          if (m >= localObject.length) {
            break;
          }
          i1 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(localObject[m]);
          m += 1;
        }
        m = n + i1 + localObject.length * 1;
      }
    }
    localObject = this.k;
    i1 = m;
    if (localObject != null)
    {
      i1 = m;
      if (localObject.length > 0)
      {
        n = i2;
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
    long l1 = this.a;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l1);
    }
    l1 = this.b;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l1);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    l1 = this.d;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l1);
    }
    Object localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(5, (MessageNano)localObject);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    l1 = this.g;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l1);
    }
    localObject = this.h;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)localObject);
    }
    localObject = this.i;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
    }
    localObject = this.j;
    int n = 0;
    int m;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = 0;
      for (;;)
      {
        localObject = this.j;
        if (m >= localObject.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeUInt64(10, localObject[m]);
        m += 1;
      }
    }
    localObject = this.k;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = n;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.ViewInfo
 * JD-Core Version:    0.7.0.1
 */