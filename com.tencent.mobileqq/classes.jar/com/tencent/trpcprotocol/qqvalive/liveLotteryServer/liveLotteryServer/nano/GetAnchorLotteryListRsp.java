package com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetAnchorLotteryListRsp
  extends ExtendableMessageNano<GetAnchorLotteryListRsp>
{
  public LotteryInfo[] a;
  public int b;
  
  public GetAnchorLotteryListRsp()
  {
    a();
  }
  
  public GetAnchorLotteryListRsp a()
  {
    this.a = LotteryInfo.a();
    this.b = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetAnchorLotteryListRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readInt32();
        }
      }
      else
      {
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        LotteryInfo[] arrayOfLotteryInfo = this.a;
        if (arrayOfLotteryInfo == null) {
          i = 0;
        } else {
          i = arrayOfLotteryInfo.length;
        }
        arrayOfLotteryInfo = new LotteryInfo[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfLotteryInfo, 0, i);
          j = i;
        }
        while (j < arrayOfLotteryInfo.length - 1)
        {
          arrayOfLotteryInfo[j] = new LotteryInfo();
          paramCodedInputByteBufferNano.readMessage(arrayOfLotteryInfo[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfLotteryInfo[j] = new LotteryInfo();
        paramCodedInputByteBufferNano.readMessage(arrayOfLotteryInfo[j]);
        this.a = arrayOfLotteryInfo;
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    Object localObject = this.a;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.a;
          i = j;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          i = j;
          if (localObject != null) {
            i = j + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
          }
          k += 1;
          j = i;
        }
      }
    }
    int k = this.b;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(2, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.a;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    int i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano.GetAnchorLotteryListRsp
 * JD-Core Version:    0.7.0.1
 */