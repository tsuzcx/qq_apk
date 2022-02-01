package com.tencent.qqlive.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class RoomInfo
  extends ExtendableMessageNano<RoomInfo>
{
  public long a;
  public long b;
  public String c;
  public String d;
  public int e;
  public RoomRichTitle f;
  public int g;
  public int h;
  public String i;
  public String j;
  
  public RoomInfo()
  {
    a();
  }
  
  public RoomInfo a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = "";
    this.d = "";
    this.e = 0;
    this.f = null;
    this.g = 0;
    this.h = 0;
    this.i = "";
    this.j = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public RoomInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 82: 
        this.j = paramCodedInputByteBufferNano.readString();
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
        if (this.f == null) {
          this.f = new RoomRichTitle();
        }
        paramCodedInputByteBufferNano.readMessage(this.f);
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 34: 
        this.d = paramCodedInputByteBufferNano.readString();
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
  
  protected int computeSerializedSize()
  {
    int m = super.computeSerializedSize();
    long l = this.a;
    int k = m;
    if (l != 0L) {
      k = m + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    l = this.b;
    m = k;
    if (l != 0L) {
      m = k + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    int n = m;
    if (!this.c.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    k = n;
    if (!this.d.equals("")) {
      k = n + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    n = this.e;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(5, n);
    }
    RoomRichTitle localRoomRichTitle = this.f;
    n = m;
    if (localRoomRichTitle != null) {
      n = m + CodedOutputByteBufferNano.computeMessageSize(6, localRoomRichTitle);
    }
    m = this.g;
    k = n;
    if (m != 0) {
      k = n + CodedOutputByteBufferNano.computeUInt32Size(7, m);
    }
    n = this.h;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(8, n);
    }
    k = m;
    if (!this.i.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(9, this.i);
    }
    m = k;
    if (!this.j.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(10, this.j);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    int k = this.e;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, k);
    }
    RoomRichTitle localRoomRichTitle = this.f;
    if (localRoomRichTitle != null) {
      paramCodedOutputByteBufferNano.writeMessage(6, localRoomRichTitle);
    }
    k = this.g;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, k);
    }
    k = this.h;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, k);
    }
    if (!this.i.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.i);
    }
    if (!this.j.equals("")) {
      paramCodedOutputByteBufferNano.writeString(10, this.j);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.roomAccess.nano.RoomInfo
 * JD-Core Version:    0.7.0.1
 */