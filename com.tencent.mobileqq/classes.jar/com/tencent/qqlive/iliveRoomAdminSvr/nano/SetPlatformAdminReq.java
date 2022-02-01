package com.tencent.qqlive.iliveRoomAdminSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class SetPlatformAdminReq
  extends ExtendableMessageNano<SetPlatformAdminReq>
{
  public long a;
  public long[] b;
  public boolean c;
  
  public SetPlatformAdminReq()
  {
    a();
  }
  
  public SetPlatformAdminReq a()
  {
    this.a = 0L;
    this.b = WireFormatNano.EMPTY_LONG_ARRAY;
    this.c = false;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SetPlatformAdminReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 24)
            {
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.c = paramCodedInputByteBufferNano.readBool();
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
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.a;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    long[] arrayOfLong = this.b;
    j = i;
    if (arrayOfLong != null)
    {
      j = i;
      if (arrayOfLong.length > 0)
      {
        j = 0;
        int k = 0;
        for (;;)
        {
          arrayOfLong = this.b;
          if (j >= arrayOfLong.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeUInt64SizeNoTag(arrayOfLong[j]);
          j += 1;
        }
        j = i + k + arrayOfLong.length * 1;
      }
    }
    boolean bool = this.c;
    i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(3, bool);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
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
    boolean bool = this.c;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(3, bool);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomAdminSvr.nano.SetPlatformAdminReq
 * JD-Core Version:    0.7.0.1
 */