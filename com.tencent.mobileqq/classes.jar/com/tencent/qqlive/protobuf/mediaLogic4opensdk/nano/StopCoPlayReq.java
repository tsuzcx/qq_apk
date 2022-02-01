package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class StopCoPlayReq
  extends ExtendableMessageNano<StopCoPlayReq>
{
  public int a;
  public long[] b;
  
  public StopCoPlayReq()
  {
    a();
  }
  
  public StopCoPlayReq a()
  {
    this.a = 0;
    this.b = WireFormatNano.EMPTY_LONG_ARRAY;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public StopCoPlayReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        int j;
        long[] arrayOfLong;
        if (i != 16)
        {
          if (i != 18)
          {
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
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
            arrayOfLong = this.b;
            if (arrayOfLong == null) {
              i = 0;
            } else {
              i = arrayOfLong.length;
            }
            arrayOfLong = new long[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.b, 0, arrayOfLong, 0, i);
              j = i;
            }
            while (j < arrayOfLong.length)
            {
              arrayOfLong[j] = paramCodedInputByteBufferNano.readUInt64();
              j += 1;
            }
            this.b = arrayOfLong;
            paramCodedInputByteBufferNano.popLimit(k);
          }
        }
        else
        {
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 16);
          arrayOfLong = this.b;
          if (arrayOfLong == null) {
            i = 0;
          } else {
            i = arrayOfLong.length;
          }
          arrayOfLong = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, arrayOfLong, 0, i);
            j = i;
          }
          while (j < arrayOfLong.length - 1)
          {
            arrayOfLong[j] = paramCodedInputByteBufferNano.readUInt64();
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          arrayOfLong[j] = paramCodedInputByteBufferNano.readUInt64();
          this.b = arrayOfLong;
        }
      }
      else
      {
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a);
    long[] arrayOfLong = this.b;
    int i = k;
    if (arrayOfLong != null)
    {
      i = k;
      if (arrayOfLong.length > 0)
      {
        i = 0;
        int j = 0;
        for (;;)
        {
          arrayOfLong = this.b;
          if (i >= arrayOfLong.length) {
            break;
          }
          j += CodedOutputByteBufferNano.computeUInt64SizeNoTag(arrayOfLong[i]);
          i += 1;
        }
        i = k + j + arrayOfLong.length * 1;
      }
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    long[] arrayOfLong = this.b;
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      int i = 0;
      for (;;)
      {
        arrayOfLong = this.b;
        if (i >= arrayOfLong.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeUInt64(2, arrayOfLong[i]);
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.StopCoPlayReq
 * JD-Core Version:    0.7.0.1
 */