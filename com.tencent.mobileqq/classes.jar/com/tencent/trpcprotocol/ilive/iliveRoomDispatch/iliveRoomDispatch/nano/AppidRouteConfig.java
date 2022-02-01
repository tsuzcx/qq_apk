package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class AppidRouteConfig
  extends MessageNano
{
  private static volatile AppidRouteConfig[] d;
  public long[] a;
  public String b;
  public String c;
  
  public AppidRouteConfig()
  {
    b();
  }
  
  public static AppidRouteConfig[] a()
  {
    if (d == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (d == null) {
          d = new AppidRouteConfig[0];
        }
      }
    }
    return d;
  }
  
  public AppidRouteConfig a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 18)
          {
            if (i != 26)
            {
              if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.c = paramCodedInputByteBufferNano.readString();
            }
          }
          else {
            this.b = paramCodedInputByteBufferNano.readString();
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
  
  public AppidRouteConfig b()
  {
    this.a = WireFormatNano.EMPTY_LONG_ARRAY;
    this.b = "";
    this.c = "";
    this.cachedSize = -1;
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
    int j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    i = j;
    if (!this.c.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.c);
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
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.AppidRouteConfig
 * JD-Core Version:    0.7.0.1
 */