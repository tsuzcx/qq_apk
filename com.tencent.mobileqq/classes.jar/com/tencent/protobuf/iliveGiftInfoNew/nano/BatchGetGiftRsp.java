package com.tencent.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class BatchGetGiftRsp
  extends MessageNano
{
  private static volatile BatchGetGiftRsp[] _emptyArray;
  public GiftInfoRsp[] giftInfo;
  public int result;
  
  public BatchGetGiftRsp()
  {
    clear();
  }
  
  public static BatchGetGiftRsp[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new BatchGetGiftRsp[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static BatchGetGiftRsp parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new BatchGetGiftRsp().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static BatchGetGiftRsp parseFrom(byte[] paramArrayOfByte)
  {
    return (BatchGetGiftRsp)MessageNano.mergeFrom(new BatchGetGiftRsp(), paramArrayOfByte);
  }
  
  public BatchGetGiftRsp clear()
  {
    this.result = 0;
    this.giftInfo = GiftInfoRsp.emptyArray();
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.result;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    Object localObject = this.giftInfo;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.giftInfo;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public BatchGetGiftRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else
        {
          int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          GiftInfoRsp[] arrayOfGiftInfoRsp = this.giftInfo;
          if (arrayOfGiftInfoRsp == null) {
            i = 0;
          } else {
            i = arrayOfGiftInfoRsp.length;
          }
          arrayOfGiftInfoRsp = new GiftInfoRsp[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.giftInfo, 0, arrayOfGiftInfoRsp, 0, i);
            j = i;
          }
          while (j < arrayOfGiftInfoRsp.length - 1)
          {
            arrayOfGiftInfoRsp[j] = new GiftInfoRsp();
            paramCodedInputByteBufferNano.readMessage(arrayOfGiftInfoRsp[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          arrayOfGiftInfoRsp[j] = new GiftInfoRsp();
          paramCodedInputByteBufferNano.readMessage(arrayOfGiftInfoRsp[j]);
          this.giftInfo = arrayOfGiftInfoRsp;
        }
      }
      else {
        this.result = paramCodedInputByteBufferNano.readInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.result;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    Object localObject = this.giftInfo;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.giftInfo;
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
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.BatchGetGiftRsp
 * JD-Core Version:    0.7.0.1
 */