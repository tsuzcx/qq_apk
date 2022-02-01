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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new BatchGetGiftReq[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize();
    int[] arrayOfInt = this.giftIds;
    int j = k;
    if (arrayOfInt != null)
    {
      j = k;
      if (arrayOfInt.length > 0)
      {
        i = 0;
        j = 0;
        for (;;)
        {
          arrayOfInt = this.giftIds;
          if (i >= arrayOfInt.length) {
            break;
          }
          j += CodedOutputByteBufferNano.computeUInt32SizeNoTag(arrayOfInt[i]);
          i += 1;
        }
        j = k + j + arrayOfInt.length * 1;
      }
    }
    long l = this.roomId;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    k = this.needFullUrl;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    return j;
  }
  
  public BatchGetGiftReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      int j;
      int[] arrayOfInt;
      if (i != 8)
      {
        if (i != 10)
        {
          if (i != 16)
          {
            if (i != 32)
            {
              if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.needFullUrl = paramCodedInputByteBufferNano.readUInt32();
            }
          }
          else {
            this.roomId = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else
        {
          int k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
          i = paramCodedInputByteBufferNano.getPosition();
          j = 0;
          while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
          {
            paramCodedInputByteBufferNano.readUInt32();
            j += 1;
          }
          paramCodedInputByteBufferNano.rewindToPosition(i);
          arrayOfInt = this.giftIds;
          if (arrayOfInt == null) {
            i = 0;
          } else {
            i = arrayOfInt.length;
          }
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
          this.giftIds = arrayOfInt;
          paramCodedInputByteBufferNano.popLimit(k);
        }
      }
      else
      {
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 8);
        arrayOfInt = this.giftIds;
        if (arrayOfInt == null) {
          i = 0;
        } else {
          i = arrayOfInt.length;
        }
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
        arrayOfInt[j] = paramCodedInputByteBufferNano.readUInt32();
        this.giftIds = arrayOfInt;
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int[] arrayOfInt = this.giftIds;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfInt = this.giftIds;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeUInt32(1, arrayOfInt[i]);
        i += 1;
      }
    }
    long l = this.roomId;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    int i = this.needFullUrl;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.BatchGetGiftReq
 * JD-Core Version:    0.7.0.1
 */