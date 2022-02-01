package com.tencent.qqlive.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class FakeUserRsp
  extends ExtendableMessageNano<FakeUserRsp>
{
  public FakeUserRsp()
  {
    a();
  }
  
  public FakeUserRsp a()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public FakeUserRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    int i;
    do
    {
      i = paramCodedInputByteBufferNano.readTag();
    } while ((i != 0) && (storeUnknownField(paramCodedInputByteBufferNano, i)));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomDispatch.nano.FakeUserRsp
 * JD-Core Version:    0.7.0.1
 */