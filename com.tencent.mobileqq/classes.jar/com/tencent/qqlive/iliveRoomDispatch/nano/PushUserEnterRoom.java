package com.tencent.qqlive.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class PushUserEnterRoom
  extends ExtendableMessageNano<PushUserEnterRoom>
{
  public UserInfo a;
  public long b;
  public int c;
  public int d;
  public int e;
  public boolean f;
  public UserList g;
  public boolean h;
  public byte[] i;
  public int j;
  public int k;
  public int l;
  public String m;
  
  public PushUserEnterRoom()
  {
    a();
  }
  
  public PushUserEnterRoom a()
  {
    this.a = null;
    this.b = 0L;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = false;
    this.g = null;
    this.h = false;
    this.i = WireFormatNano.EMPTY_BYTES;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.m = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PushUserEnterRoom a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.m = paramCodedInputByteBufferNano.readString();
        break;
      case 96: 
        this.l = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 88: 
        this.k = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 80: 
        this.j = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 74: 
        this.i = paramCodedInputByteBufferNano.readBytes();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readBool();
        break;
      case 58: 
        if (this.g == null) {
          this.g = new UserList();
        }
        paramCodedInputByteBufferNano.readMessage(this.g);
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readBool();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 10: 
        if (this.a == null) {
          this.a = new UserInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i1 = super.computeSerializedSize();
    Object localObject = this.a;
    int n = i1;
    if (localObject != null) {
      n = i1 + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
    }
    long l1 = this.b;
    i1 = n;
    if (l1 != 0L) {
      i1 = n + CodedOutputByteBufferNano.computeUInt64Size(2, l1);
    }
    int i2 = this.c;
    n = i1;
    if (i2 != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(3, i2);
    }
    i2 = this.d;
    i1 = n;
    if (i2 != 0) {
      i1 = n + CodedOutputByteBufferNano.computeUInt32Size(4, i2);
    }
    i2 = this.e;
    n = i1;
    if (i2 != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(5, i2);
    }
    boolean bool = this.f;
    i1 = n;
    if (bool) {
      i1 = n + CodedOutputByteBufferNano.computeBoolSize(6, bool);
    }
    localObject = this.g;
    n = i1;
    if (localObject != null) {
      n = i1 + CodedOutputByteBufferNano.computeMessageSize(7, (MessageNano)localObject);
    }
    bool = this.h;
    i2 = n;
    if (bool) {
      i2 = n + CodedOutputByteBufferNano.computeBoolSize(8, bool);
    }
    i1 = i2;
    if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
      i1 = i2 + CodedOutputByteBufferNano.computeBytesSize(9, this.i);
    }
    i2 = this.j;
    n = i1;
    if (i2 != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(10, i2);
    }
    i2 = this.k;
    i1 = n;
    if (i2 != 0) {
      i1 = n + CodedOutputByteBufferNano.computeUInt32Size(11, i2);
    }
    i2 = this.l;
    n = i1;
    if (i2 != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(12, i2);
    }
    i1 = n;
    if (!this.m.equals("")) {
      i1 = n + CodedOutputByteBufferNano.computeStringSize(13, this.m);
    }
    return i1;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
    }
    long l1 = this.b;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l1);
    }
    int n = this.c;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, n);
    }
    n = this.d;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, n);
    }
    n = this.e;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, n);
    }
    boolean bool = this.f;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(6, bool);
    }
    localObject = this.g;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(7, (MessageNano)localObject);
    }
    bool = this.h;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(8, bool);
    }
    if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(9, this.i);
    }
    n = this.j;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, n);
    }
    n = this.k;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, n);
    }
    n = this.l;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(12, n);
    }
    if (!this.m.equals("")) {
      paramCodedOutputByteBufferNano.writeString(13, this.m);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomDispatch.nano.PushUserEnterRoom
 * JD-Core Version:    0.7.0.1
 */