package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class EventData
  extends MessageNano
{
  public long a;
  public EnterRoomEvent a;
  public HeartKick a;
  public LeaveRoomEvent a;
  public RoomUserNumInfo a;
  public UserInfo a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  
  public EventData()
  {
    a();
  }
  
  public EventData a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoEnterRoomEvent = null;
    this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoLeaveRoomEvent = null;
    this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoHeartKick = null;
    this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo = null;
    this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo = null;
    this.f = 0L;
    this.cachedSize = -1;
    return this;
  }
  
  public EventData a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default: 
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
        break;
      case 128: 
        this.f = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 106: 
        if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo == null) {
          this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo = new RoomUserNumInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo);
        break;
      case 98: 
        if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo == null) {
          this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo = new UserInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo);
        break;
      case 90: 
        if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoHeartKick == null) {
          this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoHeartKick = new HeartKick();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoHeartKick);
        break;
      case 74: 
        if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoLeaveRoomEvent == null) {
          this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoLeaveRoomEvent = new LeaveRoomEvent();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoLeaveRoomEvent);
        break;
      case 66: 
        if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoEnterRoomEvent == null) {
          this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoEnterRoomEvent = new EnterRoomEvent();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoEnterRoomEvent);
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
        this.jdField_a_of_type_Long = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.jdField_a_of_type_Long;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    l = this.b;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    l = this.c;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    l = this.d;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(5, l);
    }
    l = this.e;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(6, l);
    }
    Object localObject = this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoEnterRoomEvent;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoLeaveRoomEvent;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoHeartKick;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(11, (MessageNano)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(12, (MessageNano)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(13, (MessageNano)localObject);
    }
    l = this.f;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(16, l);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.jdField_a_of_type_Long;
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
    Object localObject = this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoEnterRoomEvent;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoLeaveRoomEvent;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoHeartKick;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(11, (MessageNano)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(12, (MessageNano)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(13, (MessageNano)localObject);
    }
    l = this.f;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(16, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.EventData
 * JD-Core Version:    0.7.0.1
 */