package com.tencent.qqlive.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class GetGamePanelReq
  extends ExtendableMessageNano<GetGamePanelReq>
{
  public GetGamePanelReq()
  {
    a();
  }
  
  public GetGamePanelReq a()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetGamePanelReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveRoomPlay.nano.GetGamePanelReq
 * JD-Core Version:    0.7.0.1
 */