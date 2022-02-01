package com.tencent.qqlive.pbexit_heart_list_room.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class LeaveLiveRoomRsp
  extends ExtendableMessageNano<LeaveLiveRoomRsp>
{
  public LeaveLiveRoomRsp()
  {
    a();
  }
  
  public LeaveLiveRoomRsp a()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public LeaveLiveRoomRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    int i;
    do
    {
      i = paramCodedInputByteBufferNano.readTag();
    } while ((i != 0) && (storeUnknownField(paramCodedInputByteBufferNano, i)));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.pbexit_heart_list_room.nano.LeaveLiveRoomRsp
 * JD-Core Version:    0.7.0.1
 */