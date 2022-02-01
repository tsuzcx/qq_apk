package com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class CreateLivingLotteryReq
  extends ExtendableMessageNano<CreateLivingLotteryReq>
{
  public LotteryInfo a;
  
  public CreateLivingLotteryReq()
  {
    a();
  }
  
  public CreateLivingLotteryReq a()
  {
    this.a = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public CreateLivingLotteryReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          this.a = new LotteryInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    LotteryInfo localLotteryInfo = this.a;
    int i = j;
    if (localLotteryInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, localLotteryInfo);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    LotteryInfo localLotteryInfo = this.a;
    if (localLotteryInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, localLotteryInfo);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano.CreateLivingLotteryReq
 * JD-Core Version:    0.7.0.1
 */