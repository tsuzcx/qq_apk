package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class EventData
  extends MessageNano
{
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public EnterRoomEvent f;
  public LeaveRoomEvent g;
  public HeartKick h;
  public UserInfo i;
  public RoomUserNumInfo j;
  public long k;
  
  public EventData()
  {
    a();
  }
  
  public EventData a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
    this.j = null;
    this.k = 0L;
    this.cachedSize = -1;
    return this;
  }
  
  public EventData a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int m = paramCodedInputByteBufferNano.readTag();
      switch (m)
      {
      default: 
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, m)) {
          return this;
        }
        break;
      case 128: 
        this.k = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 106: 
        if (this.j == null) {
          this.j = new RoomUserNumInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.j);
        break;
      case 98: 
        if (this.i == null) {
          this.i = new UserInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.i);
        break;
      case 90: 
        if (this.h == null) {
          this.h = new HeartKick();
        }
        paramCodedInputByteBufferNano.readMessage(this.h);
        break;
      case 74: 
        if (this.g == null) {
          this.g = new LeaveRoomEvent();
        }
        paramCodedInputByteBufferNano.readMessage(this.g);
        break;
      case 66: 
        if (this.f == null) {
          this.f = new EnterRoomEvent();
        }
        paramCodedInputByteBufferNano.readMessage(this.f);
        break;
      case 48: 
        this.e = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 40: 
        this.d = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt64();
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
    int n = super.computeSerializedSize();
    long l = this.a;
    int m = n;
    if (l != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    l = this.b;
    n = m;
    if (l != 0L) {
      n = m + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    l = this.c;
    m = n;
    if (l != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    l = this.d;
    n = m;
    if (l != 0L) {
      n = m + CodedOutputByteBufferNano.computeUInt64Size(5, l);
    }
    l = this.e;
    m = n;
    if (l != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(6, l);
    }
    Object localObject = this.f;
    n = m;
    if (localObject != null) {
      n = m + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
    }
    localObject = this.g;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
    }
    localObject = this.h;
    n = m;
    if (localObject != null) {
      n = m + CodedOutputByteBufferNano.computeMessageSize(11, (MessageNano)localObject);
    }
    localObject = this.i;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.computeMessageSize(12, (MessageNano)localObject);
    }
    localObject = this.j;
    n = m;
    if (localObject != null) {
      n = m + CodedOutputByteBufferNano.computeMessageSize(13, (MessageNano)localObject);
    }
    l = this.k;
    m = n;
    if (l != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(16, l);
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
    l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, l);
    }
    l = this.e;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, l);
    }
    Object localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)localObject);
    }
    localObject = this.g;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
    }
    localObject = this.h;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(11, (MessageNano)localObject);
    }
    localObject = this.i;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(12, (MessageNano)localObject);
    }
    localObject = this.j;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(13, (MessageNano)localObject);
    }
    l = this.k;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(16, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.EventData
 * JD-Core Version:    0.7.0.1
 */