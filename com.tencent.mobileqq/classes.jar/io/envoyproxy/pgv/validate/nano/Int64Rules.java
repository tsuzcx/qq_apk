package io.envoyproxy.pgv.validate.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class Int64Rules
  extends ExtendableMessageNano<Int64Rules>
{
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long[] f;
  public long[] g;
  
  public Int64Rules()
  {
    a();
  }
  
  public Int64Rules a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = WireFormatNano.EMPTY_LONG_ARRAY;
    this.g = WireFormatNano.EMPTY_LONG_ARRAY;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public Int64Rules a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 16)
        {
          if (i != 24)
          {
            if (i != 32)
            {
              if (i != 40)
              {
                int j;
                long[] arrayOfLong;
                if (i != 48)
                {
                  int k;
                  if (i != 50)
                  {
                    if (i != 56)
                    {
                      if (i != 58)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                          return this;
                        }
                      }
                      else
                      {
                        k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
                        i = paramCodedInputByteBufferNano.getPosition();
                        j = 0;
                        while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
                        {
                          paramCodedInputByteBufferNano.readInt64();
                          j += 1;
                        }
                        paramCodedInputByteBufferNano.rewindToPosition(i);
                        arrayOfLong = this.g;
                        if (arrayOfLong == null) {
                          i = 0;
                        } else {
                          i = arrayOfLong.length;
                        }
                        arrayOfLong = new long[j + i];
                        j = i;
                        if (i != 0)
                        {
                          System.arraycopy(this.g, 0, arrayOfLong, 0, i);
                          j = i;
                        }
                        while (j < arrayOfLong.length)
                        {
                          arrayOfLong[j] = paramCodedInputByteBufferNano.readInt64();
                          j += 1;
                        }
                        this.g = arrayOfLong;
                        paramCodedInputByteBufferNano.popLimit(k);
                      }
                    }
                    else
                    {
                      j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 56);
                      arrayOfLong = this.g;
                      if (arrayOfLong == null) {
                        i = 0;
                      } else {
                        i = arrayOfLong.length;
                      }
                      arrayOfLong = new long[j + i];
                      j = i;
                      if (i != 0)
                      {
                        System.arraycopy(this.g, 0, arrayOfLong, 0, i);
                        j = i;
                      }
                      while (j < arrayOfLong.length - 1)
                      {
                        arrayOfLong[j] = paramCodedInputByteBufferNano.readInt64();
                        paramCodedInputByteBufferNano.readTag();
                        j += 1;
                      }
                      arrayOfLong[j] = paramCodedInputByteBufferNano.readInt64();
                      this.g = arrayOfLong;
                    }
                  }
                  else
                  {
                    k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
                    i = paramCodedInputByteBufferNano.getPosition();
                    j = 0;
                    while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
                    {
                      paramCodedInputByteBufferNano.readInt64();
                      j += 1;
                    }
                    paramCodedInputByteBufferNano.rewindToPosition(i);
                    arrayOfLong = this.f;
                    if (arrayOfLong == null) {
                      i = 0;
                    } else {
                      i = arrayOfLong.length;
                    }
                    arrayOfLong = new long[j + i];
                    j = i;
                    if (i != 0)
                    {
                      System.arraycopy(this.f, 0, arrayOfLong, 0, i);
                      j = i;
                    }
                    while (j < arrayOfLong.length)
                    {
                      arrayOfLong[j] = paramCodedInputByteBufferNano.readInt64();
                      j += 1;
                    }
                    this.f = arrayOfLong;
                    paramCodedInputByteBufferNano.popLimit(k);
                  }
                }
                else
                {
                  j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 48);
                  arrayOfLong = this.f;
                  if (arrayOfLong == null) {
                    i = 0;
                  } else {
                    i = arrayOfLong.length;
                  }
                  arrayOfLong = new long[j + i];
                  j = i;
                  if (i != 0)
                  {
                    System.arraycopy(this.f, 0, arrayOfLong, 0, i);
                    j = i;
                  }
                  while (j < arrayOfLong.length - 1)
                  {
                    arrayOfLong[j] = paramCodedInputByteBufferNano.readInt64();
                    paramCodedInputByteBufferNano.readTag();
                    j += 1;
                  }
                  arrayOfLong[j] = paramCodedInputByteBufferNano.readInt64();
                  this.f = arrayOfLong;
                }
              }
              else
              {
                this.e = paramCodedInputByteBufferNano.readInt64();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readInt64();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readInt64();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readInt64();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readInt64();
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
      i = j + CodedOutputByteBufferNano.computeInt64Size(1, l);
    }
    l = this.b;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeInt64Size(2, l);
    }
    l = this.c;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(3, l);
    }
    l = this.d;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeInt64Size(4, l);
    }
    l = this.e;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(5, l);
    }
    long[] arrayOfLong = this.f;
    int m = 0;
    j = i;
    int k;
    if (arrayOfLong != null)
    {
      j = i;
      if (arrayOfLong.length > 0)
      {
        j = 0;
        k = 0;
        for (;;)
        {
          arrayOfLong = this.f;
          if (j >= arrayOfLong.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeInt64SizeNoTag(arrayOfLong[j]);
          j += 1;
        }
        j = i + k + arrayOfLong.length * 1;
      }
    }
    arrayOfLong = this.g;
    i = j;
    if (arrayOfLong != null)
    {
      i = j;
      if (arrayOfLong.length > 0)
      {
        k = 0;
        i = m;
        for (;;)
        {
          arrayOfLong = this.g;
          if (i >= arrayOfLong.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeInt64SizeNoTag(arrayOfLong[i]);
          i += 1;
        }
        i = j + k + arrayOfLong.length * 1;
      }
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(1, l);
    }
    l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(2, l);
    }
    l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(3, l);
    }
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(4, l);
    }
    l = this.e;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(5, l);
    }
    long[] arrayOfLong = this.f;
    int j = 0;
    int i;
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfLong = this.f;
        if (i >= arrayOfLong.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeInt64(6, arrayOfLong[i]);
        i += 1;
      }
    }
    arrayOfLong = this.g;
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      i = j;
      for (;;)
      {
        arrayOfLong = this.g;
        if (i >= arrayOfLong.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeInt64(7, arrayOfLong[i]);
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.envoyproxy.pgv.validate.nano.Int64Rules
 * JD-Core Version:    0.7.0.1
 */