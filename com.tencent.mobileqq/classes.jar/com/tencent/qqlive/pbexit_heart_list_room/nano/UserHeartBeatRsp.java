package com.tencent.qqlive.pbexit_heart_list_room.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;

public final class UserHeartBeatRsp
  extends ExtendableMessageNano<UserHeartBeatRsp>
{
  public int a;
  
  public UserHeartBeatRsp()
  {
    a();
  }
  
  public static UserHeartBeatRsp a(byte[] paramArrayOfByte)
  {
    return (UserHeartBeatRsp)MessageNano.mergeFrom(new UserHeartBeatRsp(), paramArrayOfByte);
  }
  
  public UserHeartBeatRsp a()
  {
    this.a = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public UserHeartBeatRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.a;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.pbexit_heart_list_room.nano.UserHeartBeatRsp
 * JD-Core Version:    0.7.0.1
 */