package com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetLotteryPendantRsp
  extends ExtendableMessageNano<GetLotteryPendantRsp>
{
  public GetLotteryPendantRsp.Pendant[] a;
  
  public GetLotteryPendantRsp()
  {
    a();
  }
  
  public static GetLotteryPendantRsp a(byte[] paramArrayOfByte)
  {
    return (GetLotteryPendantRsp)MessageNano.mergeFrom(new GetLotteryPendantRsp(), paramArrayOfByte);
  }
  
  public GetLotteryPendantRsp a()
  {
    this.a = GetLotteryPendantRsp.Pendant.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetLotteryPendantRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        GetLotteryPendantRsp.Pendant[] arrayOfPendant = this.a;
        if (arrayOfPendant == null) {
          i = 0;
        } else {
          i = arrayOfPendant.length;
        }
        arrayOfPendant = new GetLotteryPendantRsp.Pendant[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfPendant, 0, i);
          j = i;
        }
        while (j < arrayOfPendant.length - 1)
        {
          arrayOfPendant[j] = new GetLotteryPendantRsp.Pendant();
          paramCodedInputByteBufferNano.readMessage(arrayOfPendant[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfPendant[j] = new GetLotteryPendantRsp.Pendant();
        paramCodedInputByteBufferNano.readMessage(arrayOfPendant[j]);
        this.a = arrayOfPendant;
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Object localObject = this.a;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        int j = 0;
        for (;;)
        {
          localObject = this.a;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
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
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano.GetLotteryPendantRsp
 * JD-Core Version:    0.7.0.1
 */