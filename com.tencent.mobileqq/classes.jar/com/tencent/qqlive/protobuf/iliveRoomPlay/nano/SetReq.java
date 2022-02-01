package com.tencent.qqlive.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class SetReq
  extends ExtendableMessageNano<SetReq>
{
  public long a;
  public Tlv[] b;
  public RoomRichTitle c;
  public String d;
  public String e;
  public String f;
  public int g;
  public int h;
  public int i;
  public int j;
  public GameItem k;
  
  public SetReq()
  {
    a();
  }
  
  public SetReq a()
  {
    this.a = 0L;
    this.b = Tlv.a();
    this.c = null;
    this.d = "";
    this.e = "";
    this.f = "";
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SetReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 8202: 
        if (this.k == null) {
          this.k = new GameItem();
        }
        paramCodedInputByteBufferNano.readMessage(this.k);
        break;
      case 8192: 
        m = paramCodedInputByteBufferNano.readInt32();
        if ((m == 0) || (m == 1) || (m == 2)) {
          this.j = m;
        }
        break;
      case 72: 
        this.i = paramCodedInputByteBufferNano.readInt32();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readInt32();
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readInt32();
        break;
      case 50: 
        this.f = paramCodedInputByteBufferNano.readString();
        break;
      case 42: 
        this.e = paramCodedInputByteBufferNano.readString();
        break;
      case 34: 
        this.d = paramCodedInputByteBufferNano.readString();
        break;
      case 26: 
        if (this.c == null) {
          this.c = new RoomRichTitle();
        }
        paramCodedInputByteBufferNano.readMessage(this.c);
        break;
      case 18: 
        int n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
        Tlv[] arrayOfTlv = this.b;
        if (arrayOfTlv == null) {
          m = 0;
        } else {
          m = arrayOfTlv.length;
        }
        arrayOfTlv = new Tlv[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.b, 0, arrayOfTlv, 0, m);
          n = m;
        }
        while (n < arrayOfTlv.length - 1)
        {
          arrayOfTlv[n] = new Tlv();
          paramCodedInputByteBufferNano.readMessage(arrayOfTlv[n]);
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        arrayOfTlv[n] = new Tlv();
        paramCodedInputByteBufferNano.readMessage(arrayOfTlv[n]);
        this.b = arrayOfTlv;
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int n = super.computeSerializedSize();
    long l = this.a;
    int m = n;
    if (l != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    Object localObject = this.b;
    n = m;
    if (localObject != null)
    {
      n = m;
      if (localObject.length > 0)
      {
        i1 = 0;
        for (;;)
        {
          localObject = this.b;
          n = m;
          if (i1 >= localObject.length) {
            break;
          }
          localObject = localObject[i1];
          n = m;
          if (localObject != null) {
            n = m + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
          }
          i1 += 1;
          m = n;
        }
      }
    }
    localObject = this.c;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
    }
    n = m;
    if (!this.d.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    m = n;
    if (!this.e.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(5, this.e);
    }
    n = m;
    if (!this.f.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    int i1 = this.g;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeInt32Size(7, i1);
    }
    i1 = this.h;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeInt32Size(8, i1);
    }
    i1 = this.i;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeInt32Size(9, i1);
    }
    i1 = this.j;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeInt32Size(1024, i1);
    }
    localObject = this.k;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.computeMessageSize(1025, (MessageNano)localObject);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    Object localObject = this.b;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = 0;
      for (;;)
      {
        localObject = this.b;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
        }
        m += 1;
      }
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.e);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    int m = this.g;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeInt32(7, m);
    }
    m = this.h;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeInt32(8, m);
    }
    m = this.i;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeInt32(9, m);
    }
    m = this.j;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1024, m);
    }
    localObject = this.k;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(1025, (MessageNano)localObject);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveRoomPlay.nano.SetReq
 * JD-Core Version:    0.7.0.1
 */