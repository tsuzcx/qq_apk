package com.tencent.protobuf.iliveRecentRoomMsg.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.tencent.protobuf.iliveWordSvr.nano.HippoMsgChat;

public final class AddHippoMsgChatReq
  extends ExtendableMessageNano<AddHippoMsgChatReq>
{
  public HippoMsgChat a;
  
  public AddHippoMsgChatReq()
  {
    a();
  }
  
  public AddHippoMsgChatReq a()
  {
    this.a = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public AddHippoMsgChatReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
      }
      else
      {
        if (this.a == null) {
          this.a = new HippoMsgChat();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    HippoMsgChat localHippoMsgChat = this.a;
    int i = j;
    if (localHippoMsgChat != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, localHippoMsgChat);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    HippoMsgChat localHippoMsgChat = this.a;
    if (localHippoMsgChat != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, localHippoMsgChat);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveRecentRoomMsg.nano.AddHippoMsgChatReq
 * JD-Core Version:    0.7.0.1
 */