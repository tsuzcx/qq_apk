package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class BatchGetAnchorInfoReq
  extends ExtendableMessageNano<BatchGetAnchorInfoReq>
{
  public long[] a;
  public int b;
  
  public BatchGetAnchorInfoReq()
  {
    a();
  }
  
  public BatchGetAnchorInfoReq a()
  {
    this.a = WireFormatNano.EMPTY_LONG_ARRAY;
    this.b = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public BatchGetAnchorInfoReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      int j;
      long[] arrayOfLong;
      if (i != 8)
      {
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
          int k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
          i = paramCodedInputByteBufferNano.getPosition();
          j = 0;
          while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
          {
            paramCodedInputByteBufferNano.readUInt64();
            j += 1;
          }
          paramCodedInputByteBufferNano.rewindToPosition(i);
          arrayOfLong = this.a;
          if (arrayOfLong == null) {
            i = 0;
          } else {
            i = arrayOfLong.length;
          }
          arrayOfLong = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.a, 0, arrayOfLong, 0, i);
            j = i;
          }
          while (j < arrayOfLong.length)
          {
            arrayOfLong[j] = paramCodedInputByteBufferNano.readUInt64();
            j += 1;
          }
          this.a = arrayOfLong;
          paramCodedInputByteBufferNano.popLimit(k);
        }
      }
      else
      {
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 8);
        arrayOfLong = this.a;
        if (arrayOfLong == null) {
          i = 0;
        } else {
          i = arrayOfLong.length;
        }
        arrayOfLong = new long[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfLong, 0, i);
          j = i;
        }
        while (j < arrayOfLong.length - 1)
        {
          arrayOfLong[j] = paramCodedInputByteBufferNano.readUInt64();
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfLong[j] = paramCodedInputByteBufferNano.readUInt64();
        this.a = arrayOfLong;
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize();
    long[] arrayOfLong = this.a;
    int i = k;
    if (arrayOfLong != null)
    {
      i = k;
      if (arrayOfLong.length > 0)
      {
        i = 0;
        j = 0;
        for (;;)
        {
          arrayOfLong = this.a;
          if (i >= arrayOfLong.length) {
            break;
          }
          j += CodedOutputByteBufferNano.computeUInt64SizeNoTag(arrayOfLong[i]);
          i += 1;
        }
        i = k + j + arrayOfLong.length * 1;
      }
    }
    k = this.b;
    int j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(2, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long[] arrayOfLong = this.a;
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfLong = this.a;
        if (i >= arrayOfLong.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeUInt64(1, arrayOfLong[i]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.BatchGetAnchorInfoReq
 * JD-Core Version:    0.7.0.1
 */