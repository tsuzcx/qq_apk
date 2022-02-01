package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetMemberListRsp
  extends MessageNano
{
  public UserList a;
  public boolean a;
  
  public GetMemberListRsp()
  {
    a();
  }
  
  public GetMemberListRsp a()
  {
    this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserList = null;
    this.jdField_a_of_type_Boolean = false;
    this.cachedSize = -1;
    return this;
  }
  
  public GetMemberListRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 16)
        {
          if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.jdField_a_of_type_Boolean = paramCodedInputByteBufferNano.readBool();
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserList == null) {
          this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserList = new UserList();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserList);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    UserList localUserList = this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserList;
    int i = j;
    if (localUserList != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, localUserList);
    }
    boolean bool = this.jdField_a_of_type_Boolean;
    j = i;
    if (bool) {
      j = i + CodedOutputByteBufferNano.computeBoolSize(2, bool);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    UserList localUserList = this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserList;
    if (localUserList != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, localUserList);
    }
    boolean bool = this.jdField_a_of_type_Boolean;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(2, bool);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.GetMemberListRsp
 * JD-Core Version:    0.7.0.1
 */