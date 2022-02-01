package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class RoomUserNumInfo
  extends MessageNano
{
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  
  public RoomUserNumInfo()
  {
    a();
  }
  
  public RoomUserNumInfo a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = 0L;
    this.h = 0L;
    this.cachedSize = -1;
    return this;
  }
  
  public RoomUserNumInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 40: 
        this.d = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 48: 
        this.e = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 56: 
        this.f = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 64: 
        this.g = paramCodedInputByteBufferNano.readUInt64();
        break;
      }
      this.h = paramCodedInputByteBufferNano.readUInt64();
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.a != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, this.a);
    }
    j = i;
    if (this.b != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, this.b);
    }
    i = j;
    if (this.c != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, this.c);
    }
    j = i;
    if (this.d != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(5, this.d);
    }
    i = j;
    if (this.e != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(6, this.e);
    }
    j = i;
    if (this.f != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(7, this.f);
    }
    i = j;
    if (this.g != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(8, this.g);
    }
    j = i;
    if (this.h != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(9, this.h);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.a != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.a);
    }
    if (this.b != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    }
    if (this.c != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, this.c);
    }
    if (this.d != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, this.d);
    }
    if (this.e != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, this.e);
    }
    if (this.f != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, this.f);
    }
    if (this.g != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(8, this.g);
    }
    if (this.h != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(9, this.h);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.RoomUserNumInfo
 * JD-Core Version:    0.7.0.1
 */