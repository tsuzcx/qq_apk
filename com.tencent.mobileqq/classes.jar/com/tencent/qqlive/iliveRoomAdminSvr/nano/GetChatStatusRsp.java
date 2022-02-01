package com.tencent.qqlive.iliveRoomAdminSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetChatStatusRsp
  extends ExtendableMessageNano<GetChatStatusRsp>
{
  public int a;
  public String b;
  public long[] c;
  
  public GetChatStatusRsp()
  {
    a();
  }
  
  public static GetChatStatusRsp a(byte[] paramArrayOfByte)
  {
    return (GetChatStatusRsp)MessageNano.mergeFrom(new GetChatStatusRsp(), paramArrayOfByte);
  }
  
  public GetChatStatusRsp a()
  {
    this.a = 0;
    this.b = "";
    this.c = WireFormatNano.EMPTY_LONG_ARRAY;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetChatStatusRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          int j;
          long[] arrayOfLong;
          if (i != 24)
          {
            if (i != 26)
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
              arrayOfLong = this.c;
              if (arrayOfLong == null) {
                i = 0;
              } else {
                i = arrayOfLong.length;
              }
              arrayOfLong = new long[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.c, 0, arrayOfLong, 0, i);
                j = i;
              }
              while (j < arrayOfLong.length)
              {
                arrayOfLong[j] = paramCodedInputByteBufferNano.readUInt64();
                j += 1;
              }
              this.c = arrayOfLong;
              paramCodedInputByteBufferNano.popLimit(k);
            }
          }
          else
          {
            j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 24);
            arrayOfLong = this.c;
            if (arrayOfLong == null) {
              i = 0;
            } else {
              i = arrayOfLong.length;
            }
            arrayOfLong = new long[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, arrayOfLong, 0, i);
              j = i;
            }
            while (j < arrayOfLong.length - 1)
            {
              arrayOfLong[j] = paramCodedInputByteBufferNano.readUInt64();
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            arrayOfLong[j] = paramCodedInputByteBufferNano.readUInt64();
            this.c = arrayOfLong;
          }
        }
        else
        {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int k = this.a;
    int j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    i = j;
    if (!this.b.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    long[] arrayOfLong = this.c;
    j = i;
    if (arrayOfLong != null)
    {
      j = i;
      if (arrayOfLong.length > 0)
      {
        j = 0;
        k = 0;
        for (;;)
        {
          arrayOfLong = this.c;
          if (j >= arrayOfLong.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeUInt64SizeNoTag(arrayOfLong[j]);
          j += 1;
        }
        j = i + k + arrayOfLong.length * 1;
      }
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    long[] arrayOfLong = this.c;
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfLong = this.c;
        if (i >= arrayOfLong.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeUInt64(3, arrayOfLong[i]);
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomAdminSvr.nano.GetChatStatusRsp
 * JD-Core Version:    0.7.0.1
 */