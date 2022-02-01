package com.tencent.qqlive.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;

public final class EventData
  extends ExtendableMessageNano<EventData>
{
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public EnterRoomEvent f;
  public LeaveRoomEvent g;
  public HeartBeatEvent h;
  public HeartKick i;
  public UserInfo j;
  public RoomUserNumInfo k;
  public long l;
  public String m;
  
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
    this.k = null;
    this.l = 0L;
    this.m = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public EventData a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 138: 
        this.m = paramCodedInputByteBufferNano.readString();
        break;
      case 128: 
        this.l = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 106: 
        if (this.k == null) {
          this.k = new RoomUserNumInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.k);
        break;
      case 98: 
        if (this.j == null) {
          this.j = new UserInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.j);
        break;
      case 90: 
        if (this.i == null) {
          this.i = new HeartKick();
        }
        paramCodedInputByteBufferNano.readMessage(this.i);
        break;
      case 82: 
        if (this.h == null) {
          this.h = new HeartBeatEvent();
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
    int i1 = super.computeSerializedSize();
    long l1 = this.a;
    int n = i1;
    if (l1 != 0L) {
      n = i1 + CodedOutputByteBufferNano.computeUInt64Size(1, l1);
    }
    l1 = this.b;
    i1 = n;
    if (l1 != 0L) {
      i1 = n + CodedOutputByteBufferNano.computeUInt64Size(2, l1);
    }
    l1 = this.c;
    n = i1;
    if (l1 != 0L) {
      n = i1 + CodedOutputByteBufferNano.computeUInt64Size(3, l1);
    }
    l1 = this.d;
    i1 = n;
    if (l1 != 0L) {
      i1 = n + CodedOutputByteBufferNano.computeUInt64Size(5, l1);
    }
    l1 = this.e;
    n = i1;
    if (l1 != 0L) {
      n = i1 + CodedOutputByteBufferNano.computeUInt64Size(6, l1);
    }
    Object localObject = this.f;
    i1 = n;
    if (localObject != null) {
      i1 = n + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
    }
    localObject = this.g;
    n = i1;
    if (localObject != null) {
      n = i1 + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
    }
    localObject = this.h;
    i1 = n;
    if (localObject != null) {
      i1 = n + CodedOutputByteBufferNano.computeMessageSize(10, (MessageNano)localObject);
    }
    localObject = this.i;
    n = i1;
    if (localObject != null) {
      n = i1 + CodedOutputByteBufferNano.computeMessageSize(11, (MessageNano)localObject);
    }
    localObject = this.j;
    i1 = n;
    if (localObject != null) {
      i1 = n + CodedOutputByteBufferNano.computeMessageSize(12, (MessageNano)localObject);
    }
    localObject = this.k;
    n = i1;
    if (localObject != null) {
      n = i1 + CodedOutputByteBufferNano.computeMessageSize(13, (MessageNano)localObject);
    }
    l1 = this.l;
    i1 = n;
    if (l1 != 0L) {
      i1 = n + CodedOutputByteBufferNano.computeUInt64Size(16, l1);
    }
    n = i1;
    if (!this.m.equals("")) {
      n = i1 + CodedOutputByteBufferNano.computeStringSize(17, this.m);
    }
    return n;
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
    l1 = this.c;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l1);
    }
    l1 = this.d;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, l1);
    }
    l1 = this.e;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, l1);
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
      paramCodedOutputByteBufferNano.writeMessage(10, (MessageNano)localObject);
    }
    localObject = this.i;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(11, (MessageNano)localObject);
    }
    localObject = this.j;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(12, (MessageNano)localObject);
    }
    localObject = this.k;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(13, (MessageNano)localObject);
    }
    l1 = this.l;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(16, l1);
    }
    if (!this.m.equals("")) {
      paramCodedOutputByteBufferNano.writeString(17, this.m);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomDispatch.nano.EventData
 * JD-Core Version:    0.7.0.1
 */