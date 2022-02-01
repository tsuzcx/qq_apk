package com.tencent.qqlive.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class BatchGetGiftReq
  extends ExtendableMessageNano<BatchGetGiftReq>
{
  public int[] a;
  public long b;
  public int c;
  
  public BatchGetGiftReq()
  {
    a();
  }
  
  public BatchGetGiftReq a()
  {
    this.a = WireFormatNano.EMPTY_INT_ARRAY;
    this.b = 0L;
    this.c = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public BatchGetGiftReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.c = paramCodedInputByteBufferNano.readUInt32();
            }
          }
          else {
            this.b = paramCodedInputByteBufferNano.readUInt64();
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
          arrayOfInt = this.a;
          if (arrayOfInt == null) {
            i = 0;
          } else {
            i = arrayOfInt.length;
          }
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.a, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length)
          {
            arrayOfInt[j] = paramCodedInputByteBufferNano.readUInt32();
            j += 1;
          }
          this.a = arrayOfInt;
          paramCodedInputByteBufferNano.popLimit(k);
        }
      }
      else
      {
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 8);
        arrayOfInt = this.a;
        if (arrayOfInt == null) {
          i = 0;
        } else {
          i = arrayOfInt.length;
        }
        arrayOfInt = new int[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfInt, 0, i);
          j = i;
        }
        while (j < arrayOfInt.length - 1)
        {
          arrayOfInt[j] = paramCodedInputByteBufferNano.readUInt32();
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfInt[j] = paramCodedInputByteBufferNano.readUInt32();
        this.a = arrayOfInt;
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize();
    int[] arrayOfInt = this.a;
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
          arrayOfInt = this.a;
          if (i >= arrayOfInt.length) {
            break;
          }
          j += CodedOutputByteBufferNano.computeUInt32SizeNoTag(arrayOfInt[i]);
          i += 1;
        }
        j = k + j + arrayOfInt.length * 1;
      }
    }
    long l = this.b;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    k = this.c;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int[] arrayOfInt = this.a;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfInt = this.a;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeUInt32(1, arrayOfInt[i]);
        i += 1;
      }
    }
    long l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    int i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.iliveGiftInfoNew.nano.BatchGetGiftReq
 * JD-Core Version:    0.7.0.1
 */