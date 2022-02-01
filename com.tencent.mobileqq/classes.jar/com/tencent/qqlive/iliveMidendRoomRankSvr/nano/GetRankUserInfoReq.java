package com.tencent.qqlive.iliveMidendRoomRankSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetRankUserInfoReq
  extends ExtendableMessageNano<GetRankUserInfoReq>
{
  public long[] a;
  
  public GetRankUserInfoReq()
  {
    a();
  }
  
  public GetRankUserInfoReq a()
  {
    this.a = WireFormatNano.EMPTY_LONG_ARRAY;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetRankUserInfoReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        int j = 0;
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
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long[] arrayOfLong = this.a;
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      int i = 0;
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
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveMidendRoomRankSvr.nano.GetRankUserInfoReq
 * JD-Core Version:    0.7.0.1
 */