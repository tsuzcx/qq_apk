package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetKickUserListRsp
  extends MessageNano
{
  public long a;
  public RoomUserNumInfo a;
  public boolean a;
  public UserInfo[] a;
  public long b;
  
  public GetKickUserListRsp()
  {
    a();
  }
  
  public GetKickUserListRsp a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo = UserInfo.a();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo = null;
    this.b = 0L;
    this.cachedSize = -1;
    return this;
  }
  
  public GetKickUserListRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.jdField_a_of_type_Long = paramCodedInputByteBufferNano.readInt64();
        break;
      case 18: 
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
        if (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo == null) {}
        UserInfo[] arrayOfUserInfo;
        for (i = 0;; i = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo.length)
        {
          arrayOfUserInfo = new UserInfo[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo, 0, arrayOfUserInfo, 0, i);
            j = i;
          }
          while (j < arrayOfUserInfo.length - 1)
          {
            arrayOfUserInfo[j] = new UserInfo();
            paramCodedInputByteBufferNano.readMessage(arrayOfUserInfo[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
        }
        arrayOfUserInfo[j] = new UserInfo();
        paramCodedInputByteBufferNano.readMessage(arrayOfUserInfo[j]);
        this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo = arrayOfUserInfo;
        break;
      case 24: 
        this.jdField_a_of_type_Boolean = paramCodedInputByteBufferNano.readBool();
        break;
      case 34: 
        if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo == null) {
          this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo = new RoomUserNumInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo);
        break;
      }
      this.b = paramCodedInputByteBufferNano.readUInt64();
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.jdField_a_of_type_Long != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(1, this.jdField_a_of_type_Long);
    }
    j = i;
    if (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo != null)
    {
      j = i;
      if (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo.length > 0)
      {
        j = 0;
        while (j < this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo.length)
        {
          UserInfo localUserInfo = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo[j];
          int k = i;
          if (localUserInfo != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(2, localUserInfo);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.jdField_a_of_type_Boolean) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(3, this.jdField_a_of_type_Boolean);
    }
    j = i;
    if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(4, this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo);
    }
    i = j;
    if (this.b != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(5, this.b);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.jdField_a_of_type_Long != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(1, this.jdField_a_of_type_Long);
    }
    if ((this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo != null) && (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo.length > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo.length)
      {
        UserInfo localUserInfo = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo[i];
        if (localUserInfo != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, localUserInfo);
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_Boolean) {
      paramCodedOutputByteBufferNano.writeBool(3, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo);
    }
    if (this.b != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, this.b);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.GetKickUserListRsp
 * JD-Core Version:    0.7.0.1
 */