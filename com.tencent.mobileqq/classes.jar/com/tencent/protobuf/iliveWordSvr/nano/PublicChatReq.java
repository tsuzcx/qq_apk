package com.tencent.protobuf.iliveWordSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class PublicChatReq
  extends ExtendableMessageNano<PublicChatReq>
{
  public PublicChatMsgReq a;
  
  public PublicChatReq()
  {
    a();
  }
  
  public PublicChatReq a()
  {
    this.a = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PublicChatReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          this.a = new PublicChatMsgReq();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    PublicChatMsgReq localPublicChatMsgReq = this.a;
    int i = j;
    if (localPublicChatMsgReq != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, localPublicChatMsgReq);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    PublicChatMsgReq localPublicChatMsgReq = this.a;
    if (localPublicChatMsgReq != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, localPublicChatMsgReq);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveWordSvr.nano.PublicChatReq
 * JD-Core Version:    0.7.0.1
 */