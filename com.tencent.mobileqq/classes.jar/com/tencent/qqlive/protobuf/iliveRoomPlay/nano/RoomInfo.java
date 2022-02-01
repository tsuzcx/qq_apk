package com.tencent.qqlive.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class RoomInfo
  extends ExtendableMessageNano<RoomInfo>
{
  public long a;
  public String b;
  public String c;
  public String d;
  public int e;
  public String f;
  public int g;
  public RoomRichTitle h;
  public String i;
  public String j;
  public byte[] k;
  public int l;
  public String m;
  public int n;
  public int o;
  public GameItem p;
  
  public RoomInfo()
  {
    a();
  }
  
  public RoomInfo a()
  {
    this.a = 0L;
    this.b = "";
    this.c = "";
    this.d = "";
    this.e = 0;
    this.f = "";
    this.g = 0;
    this.h = null;
    this.i = "";
    this.j = "";
    this.k = WireFormatNano.EMPTY_BYTES;
    this.l = 0;
    this.m = "";
    this.n = 0;
    this.o = 0;
    this.p = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public RoomInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i1 = paramCodedInputByteBufferNano.readTag();
      switch (i1)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, i1)) {
          return this;
        }
        break;
      case 8202: 
        if (this.p == null) {
          this.p = new GameItem();
        }
        paramCodedInputByteBufferNano.readMessage(this.p);
        break;
      case 8192: 
        i1 = paramCodedInputByteBufferNano.readInt32();
        if ((i1 == 0) || (i1 == 1) || (i1 == 2)) {
          this.o = i1;
        }
        break;
      case 112: 
        this.n = paramCodedInputByteBufferNano.readInt32();
        break;
      case 106: 
        this.m = paramCodedInputByteBufferNano.readString();
        break;
      case 96: 
        this.l = paramCodedInputByteBufferNano.readInt32();
        break;
      case 90: 
        this.k = paramCodedInputByteBufferNano.readBytes();
        break;
      case 82: 
        this.j = paramCodedInputByteBufferNano.readString();
        break;
      case 74: 
        this.i = paramCodedInputByteBufferNano.readString();
        break;
      case 66: 
        if (this.h == null) {
          this.h = new RoomRichTitle();
        }
        paramCodedInputByteBufferNano.readMessage(this.h);
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readInt32();
        break;
      case 50: 
        this.f = paramCodedInputByteBufferNano.readString();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readInt32();
        break;
      case 34: 
        this.d = paramCodedInputByteBufferNano.readString();
        break;
      case 26: 
        this.c = paramCodedInputByteBufferNano.readString();
        break;
      case 18: 
        this.b = paramCodedInputByteBufferNano.readString();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i2 = super.computeSerializedSize();
    long l1 = this.a;
    int i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(1, l1);
    }
    i2 = i1;
    if (!this.b.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    int i3 = i2;
    if (!this.c.equals("")) {
      i3 = i2 + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    i1 = i3;
    if (!this.d.equals("")) {
      i1 = i3 + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    i3 = this.e;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeInt32Size(5, i3);
    }
    i1 = i2;
    if (!this.f.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    i3 = this.g;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeInt32Size(7, i3);
    }
    Object localObject = this.h;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
    }
    i2 = i1;
    if (!this.i.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(9, this.i);
    }
    i3 = i2;
    if (!this.j.equals("")) {
      i3 = i2 + CodedOutputByteBufferNano.computeStringSize(10, this.j);
    }
    i1 = i3;
    if (!Arrays.equals(this.k, WireFormatNano.EMPTY_BYTES)) {
      i1 = i3 + CodedOutputByteBufferNano.computeBytesSize(11, this.k);
    }
    i3 = this.l;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeInt32Size(12, i3);
    }
    i3 = i2;
    if (!this.m.equals("")) {
      i3 = i2 + CodedOutputByteBufferNano.computeStringSize(13, this.m);
    }
    i2 = this.n;
    i1 = i3;
    if (i2 != 0) {
      i1 = i3 + CodedOutputByteBufferNano.computeInt32Size(14, i2);
    }
    i3 = this.o;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeInt32Size(1024, i3);
    }
    localObject = this.p;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.computeMessageSize(1025, (MessageNano)localObject);
    }
    return i1;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l1 = this.a;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l1);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    int i1 = this.e;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, i1);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    i1 = this.g;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeInt32(7, i1);
    }
    Object localObject = this.h;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)localObject);
    }
    if (!this.i.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.i);
    }
    if (!this.j.equals("")) {
      paramCodedOutputByteBufferNano.writeString(10, this.j);
    }
    if (!Arrays.equals(this.k, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(11, this.k);
    }
    i1 = this.l;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeInt32(12, i1);
    }
    if (!this.m.equals("")) {
      paramCodedOutputByteBufferNano.writeString(13, this.m);
    }
    i1 = this.n;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeInt32(14, i1);
    }
    i1 = this.o;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1024, i1);
    }
    localObject = this.p;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(1025, (MessageNano)localObject);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveRoomPlay.nano.RoomInfo
 * JD-Core Version:    0.7.0.1
 */