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
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.jdField_a_of_type_Long = paramCodedInputByteBufferNano.readUInt64();
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
      case 66: 
        if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoEnterRoomEvent == null) {
          this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoEnterRoomEvent = new EnterRoomEvent();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoEnterRoomEvent);
        break;
      case 74: 
        if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoLeaveRoomEvent == null) {
          this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoLeaveRoomEvent = new LeaveRoomEvent();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoLeaveRoomEvent);
        break;
      case 90: 
        if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoHeartKick == null) {
          this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoHeartKick = new HeartKick();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoHeartKick);
        break;
      case 98: 
        if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo == null) {
          this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo = new UserInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo);
        break;
      case 106: 
        if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo == null) {
          this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo = new RoomUserNumInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo);
        break;
      }
      this.f = paramCodedInputByteBufferNano.readUInt64();
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.jdField_a_of_type_Long != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, this.jdField_a_of_type_Long);
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
    if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoEnterRoomEvent != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(8, this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoEnterRoomEvent);
    }
    i = j;
    if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoLeaveRoomEvent != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(9, this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoLeaveRoomEvent);
    }
    j = i;
    if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoHeartKick != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(11, this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoHeartKick);
    }
    i = j;
    if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(12, this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo);
    }
    j = i;
    if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(13, this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo);
    }
    i = j;
    if (this.f != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(16, this.f);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.jdField_a_of_type_Long != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.jdField_a_of_type_Long);
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
    if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoEnterRoomEvent != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoEnterRoomEvent);
    }
    if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoLeaveRoomEvent != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoLeaveRoomEvent);
    }
    if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoHeartKick != null) {
      paramCodedOutputByteBufferNano.writeMessage(11, this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoHeartKick);
    }
    if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(12, this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo);
    }
    if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(13, this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo);
    }
    if (this.f != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(16, this.f);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.EventData
 * JD-Core Version:    0.7.0.1
 */