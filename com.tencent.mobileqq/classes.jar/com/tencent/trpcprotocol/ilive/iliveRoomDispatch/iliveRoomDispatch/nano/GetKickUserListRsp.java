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
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 18)
        {
          if (i != 24)
          {
            if (i != 34)
            {
              if (i != 40)
              {
                if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else {
                this.b = paramCodedInputByteBufferNano.readUInt64();
              }
            }
            else
            {
              if (this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo == null) {
                this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo = new RoomUserNumInfo();
              }
              paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo);
            }
          }
          else {
            this.jdField_a_of_type_Boolean = paramCodedInputByteBufferNano.readBool();
          }
        }
        else
        {
          int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          UserInfo[] arrayOfUserInfo = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo;
          if (arrayOfUserInfo == null) {
            i = 0;
          } else {
            i = arrayOfUserInfo.length;
          }
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
          arrayOfUserInfo[j] = new UserInfo();
          paramCodedInputByteBufferNano.readMessage(arrayOfUserInfo[j]);
          this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo = arrayOfUserInfo;
        }
      }
      else {
        this.jdField_a_of_type_Long = paramCodedInputByteBufferNano.readInt64();
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
      i = j + CodedOutputByteBufferNano.computeInt64Size(1, l);
    }
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        for (;;)
        {
          localObject = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    boolean bool = this.jdField_a_of_type_Boolean;
    i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(3, bool);
    }
    localObject = this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
    }
    l = this.b;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(5, l);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.jdField_a_of_type_Long;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(1, l);
    }
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    boolean bool = this.jdField_a_of_type_Boolean;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(3, bool);
    }
    localObject = this.jdField_a_of_type_ComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomUserNumInfo;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, (MessageNano)localObject);
    }
    l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.GetKickUserListRsp
 * JD-Core Version:    0.7.0.1
 */