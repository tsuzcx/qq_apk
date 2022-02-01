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
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new BatchGetGiftRsp[0];
      }
      return _emptyArray;
    }
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
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.result != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, this.result);
    }
    j = i;
    if (this.giftInfo != null)
    {
      j = i;
      if (this.giftInfo.length > 0)
      {
        j = 0;
        while (j < this.giftInfo.length)
        {
          GiftInfoRsp localGiftInfoRsp = this.giftInfo[j];
          int k = i;
          if (localGiftInfoRsp != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(2, localGiftInfoRsp);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    return j;
  }
  
  public BatchGetGiftRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.result = paramCodedInputByteBufferNano.readInt32();
        break;
      }
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
      if (this.giftInfo == null) {}
      GiftInfoRsp[] arrayOfGiftInfoRsp;
      for (i = 0;; i = this.giftInfo.length)
      {
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
      }
      arrayOfGiftInfoRsp[j] = new GiftInfoRsp();
      paramCodedInputByteBufferNano.readMessage(arrayOfGiftInfoRsp[j]);
      this.giftInfo = arrayOfGiftInfoRsp;
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.result != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, this.result);
    }
    if ((this.giftInfo != null) && (this.giftInfo.length > 0))
    {
      int i = 0;
      while (i < this.giftInfo.length)
      {
        GiftInfoRsp localGiftInfoRsp = this.giftInfo[i];
        if (localGiftInfoRsp != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, localGiftInfoRsp);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.BatchGetGiftRsp
 * JD-Core Version:    0.7.0.1
 */