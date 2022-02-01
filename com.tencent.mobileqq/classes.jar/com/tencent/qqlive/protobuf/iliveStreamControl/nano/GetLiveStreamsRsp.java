package com.tencent.qqlive.protobuf.iliveStreamControl.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetLiveStreamsRsp
  extends ExtendableMessageNano<GetLiveStreamsRsp>
{
  public int a;
  public String b;
  public Stream[] c;
  public int d;
  public int[] e;
  public int f;
  public int g;
  public GearInfo[] h;
  public int i;
  public int j;
  public int k;
  
  public GetLiveStreamsRsp()
  {
    a();
  }
  
  public static GetLiveStreamsRsp a(byte[] paramArrayOfByte)
  {
    return (GetLiveStreamsRsp)MessageNano.mergeFrom(new GetLiveStreamsRsp(), paramArrayOfByte);
  }
  
  public GetLiveStreamsRsp a()
  {
    this.a = 0;
    this.b = "";
    this.c = Stream.a();
    this.d = 0;
    this.e = WireFormatNano.EMPTY_INT_ARRAY;
    this.f = 0;
    this.g = 0;
    this.h = GearInfo.a();
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetLiveStreamsRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 96: 
        this.k = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 88: 
        this.j = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 80: 
        this.i = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 74: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 74);
        localObject = this.h;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new GearInfo[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.h, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = new GearInfo();
          paramCodedInputByteBufferNano.readMessage(localObject[n]);
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = new GearInfo();
        paramCodedInputByteBufferNano.readMessage(localObject[n]);
        this.h = ((GearInfo[])localObject);
        break;
      case 64: 
        this.g = paramCodedInputByteBufferNano.readInt32();
        break;
      case 56: 
        this.f = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 42: 
        int i1 = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
        m = paramCodedInputByteBufferNano.getPosition();
        n = 0;
        while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
        {
          paramCodedInputByteBufferNano.readInt32();
          n += 1;
        }
        paramCodedInputByteBufferNano.rewindToPosition(m);
        localObject = this.e;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new int[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.e, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length)
        {
          localObject[n] = paramCodedInputByteBufferNano.readInt32();
          n += 1;
        }
        this.e = ((int[])localObject);
        paramCodedInputByteBufferNano.popLimit(i1);
        break;
      case 40: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 40);
        localObject = this.e;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new int[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.e, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = paramCodedInputByteBufferNano.readInt32();
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = paramCodedInputByteBufferNano.readInt32();
        this.e = ((int[])localObject);
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readInt32();
        break;
      case 26: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
        localObject = this.c;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new Stream[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.c, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = new Stream();
          paramCodedInputByteBufferNano.readMessage(localObject[n]);
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = new Stream();
        paramCodedInputByteBufferNano.readMessage(localObject[n]);
        this.c = ((Stream[])localObject);
        break;
      case 18: 
        this.b = paramCodedInputByteBufferNano.readString();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int m = super.computeSerializedSize();
    int i1 = this.a;
    int n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeInt32Size(1, i1);
    }
    m = n;
    if (!this.b.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    Object localObject = this.c;
    int i2 = 0;
    n = m;
    if (localObject != null)
    {
      n = m;
      if (localObject.length > 0)
      {
        n = 0;
        for (;;)
        {
          localObject = this.c;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          i1 = m;
          if (localObject != null) {
            i1 = m + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
          }
          n += 1;
          m = i1;
        }
        n = m;
      }
    }
    i1 = this.d;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeInt32Size(4, i1);
    }
    localObject = this.e;
    i1 = m;
    if (localObject != null)
    {
      i1 = m;
      if (localObject.length > 0)
      {
        n = 0;
        i1 = 0;
        for (;;)
        {
          localObject = this.e;
          if (n >= localObject.length) {
            break;
          }
          i1 += CodedOutputByteBufferNano.computeInt32SizeNoTag(localObject[n]);
          n += 1;
        }
        i1 = m + i1 + localObject.length * 1;
      }
    }
    m = this.f;
    n = i1;
    if (m != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(7, m);
    }
    i1 = this.g;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeInt32Size(8, i1);
    }
    localObject = this.h;
    n = m;
    if (localObject != null)
    {
      n = m;
      if (localObject.length > 0)
      {
        i1 = i2;
        for (;;)
        {
          localObject = this.h;
          n = m;
          if (i1 >= localObject.length) {
            break;
          }
          localObject = localObject[i1];
          n = m;
          if (localObject != null) {
            n = m + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
          }
          i1 += 1;
          m = n;
        }
      }
    }
    i1 = this.i;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(10, i1);
    }
    i1 = this.j;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(11, i1);
    }
    i1 = this.k;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(12, i1);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int m = this.a;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, m);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    Object localObject = this.c;
    int n = 0;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = 0;
      for (;;)
      {
        localObject = this.c;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
        }
        m += 1;
      }
    }
    m = this.d;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, m);
    }
    localObject = this.e;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = 0;
      for (;;)
      {
        localObject = this.e;
        if (m >= localObject.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeInt32(5, localObject[m]);
        m += 1;
      }
    }
    m = this.f;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, m);
    }
    m = this.g;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeInt32(8, m);
    }
    localObject = this.h;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = n;
      for (;;)
      {
        localObject = this.h;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
        }
        m += 1;
      }
    }
    m = this.i;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, m);
    }
    m = this.j;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, m);
    }
    m = this.k;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(12, m);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveStreamControl.nano.GetLiveStreamsRsp
 * JD-Core Version:    0.7.0.1
 */