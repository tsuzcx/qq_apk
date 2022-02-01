package com.tencent.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class BatchGetGiftReq
  extends MessageNano
{
  private static volatile BatchGetGiftReq[] _emptyArray;
  public int[] giftIds;
  public int needFullUrl;
  public long roomId;
  
  public BatchGetGiftReq()
  {
    clear();
  }
  
  public static BatchGetGiftReq[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new BatchGetGiftReq[0];
      }
      return _emptyArray;
    }
  }
  
  public static BatchGetGiftReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new BatchGetGiftReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static BatchGetGiftReq parseFrom(byte[] paramArrayOfByte)
  {
    return (BatchGetGiftReq)MessageNano.mergeFrom(new BatchGetGiftReq(), paramArrayOfByte);
  }
  
  public BatchGetGiftReq clear()
  {
    this.giftIds = WireFormatNano.EMPTY_INT_ARRAY;
    this.roomId = 0L;
    this.needFullUrl = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int i = 0;
    int k = super.computeSerializedSize();
    if ((this.giftIds != null) && (this.giftIds.length > 0))
    {
      j = 0;
      while (i < this.giftIds.length)
      {
        j += CodedOutputByteBufferNano.computeUInt32SizeNoTag(this.giftIds[i]);
        i += 1;
      }
    }
    for (int j = k + j + this.giftIds.length * 1;; j = k)
    {
      i = j;
      if (this.roomId != 0L) {
        i = j + CodedOutputByteBufferNano.computeUInt64Size(2, this.roomId);
      }
      j = i;
      if (this.needFullUrl != 0) {
        j = i + CodedOutputByteBufferNano.computeUInt32Size(4, this.needFullUrl);
      }
      return j;
    }
  }
  
  public BatchGetGiftReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      int j;
      int[] arrayOfInt;
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 8);
        if (this.giftIds == null) {}
        for (i = 0;; i = this.giftIds.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.giftIds, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length - 1)
          {
            arrayOfInt[j] = paramCodedInputByteBufferNano.readUInt32();
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
        }
        arrayOfInt[j] = paramCodedInputByteBufferNano.readUInt32();
        this.giftIds = arrayOfInt;
        break;
      case 10: 
        int k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
        i = paramCodedInputByteBufferNano.getPosition();
        j = 0;
        while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
        {
          paramCodedInputByteBufferNano.readUInt32();
          j += 1;
        }
        paramCodedInputByteBufferNano.rewindToPosition(i);
        if (this.giftIds == null) {}
        for (i = 0;; i = this.giftIds.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.giftIds, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length)
          {
            arrayOfInt[j] = paramCodedInputByteBufferNano.readUInt32();
            j += 1;
          }
        }
        this.giftIds = arrayOfInt;
        paramCodedInputByteBufferNano.popLimit(k);
        break;
      case 16: 
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      }
      this.needFullUrl = paramCodedInputByteBufferNano.readUInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.giftIds != null) && (this.giftIds.length > 0))
    {
      int i = 0;
      while (i < this.giftIds.length)
      {
        paramCodedOutputByteBufferNano.writeUInt32(1, this.giftIds[i]);
        i += 1;
      }
    }
    if (this.roomId != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, this.roomId);
    }
    if (this.needFullUrl != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, this.needFullUrl);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.BatchGetGiftReq
 * JD-Core Version:    0.7.0.1
 */