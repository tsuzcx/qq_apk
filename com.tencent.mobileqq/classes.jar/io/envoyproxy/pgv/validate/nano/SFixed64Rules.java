package io.envoyproxy.pgv.validate.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class SFixed64Rules
  extends ExtendableMessageNano<SFixed64Rules>
{
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long[] f;
  public long[] g;
  
  public SFixed64Rules()
  {
    a();
  }
  
  public SFixed64Rules a()
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
  
  public SFixed64Rules a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 9)
      {
        if (i != 17)
        {
          if (i != 25)
          {
            if (i != 33)
            {
              if (i != 41)
              {
                int j;
                long[] arrayOfLong;
                if (i != 49)
                {
                  int k;
                  if (i != 50)
                  {
                    if (i != 57)
                    {
                      if (i != 58)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                          return this;
                        }
                      }
                      else
                      {
                        i = paramCodedInputByteBufferNano.readRawVarint32();
                        k = paramCodedInputByteBufferNano.pushLimit(i);
                        j = i / 8;
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
                          arrayOfLong[j] = paramCodedInputByteBufferNano.readSFixed64();
                          j += 1;
                        }
                        this.g = arrayOfLong;
                        paramCodedInputByteBufferNano.popLimit(k);
                      }
                    }
                    else
                    {
                      j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 57);
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
                        arrayOfLong[j] = paramCodedInputByteBufferNano.readSFixed64();
                        paramCodedInputByteBufferNano.readTag();
                        j += 1;
                      }
                      arrayOfLong[j] = paramCodedInputByteBufferNano.readSFixed64();
                      this.g = arrayOfLong;
                    }
                  }
                  else
                  {
                    i = paramCodedInputByteBufferNano.readRawVarint32();
                    k = paramCodedInputByteBufferNano.pushLimit(i);
                    j = i / 8;
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
                      arrayOfLong[j] = paramCodedInputByteBufferNano.readSFixed64();
                      j += 1;
                    }
                    this.f = arrayOfLong;
                    paramCodedInputByteBufferNano.popLimit(k);
                  }
                }
                else
                {
                  j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 49);
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
                    arrayOfLong[j] = paramCodedInputByteBufferNano.readSFixed64();
                    paramCodedInputByteBufferNano.readTag();
                    j += 1;
                  }
                  arrayOfLong[j] = paramCodedInputByteBufferNano.readSFixed64();
                  this.f = arrayOfLong;
                }
              }
              else
              {
                this.e = paramCodedInputByteBufferNano.readSFixed64();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readSFixed64();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readSFixed64();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readSFixed64();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readSFixed64();
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
      i = j + CodedOutputByteBufferNano.computeSFixed64Size(1, l);
    }
    l = this.b;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeSFixed64Size(2, l);
    }
    l = this.c;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeSFixed64Size(3, l);
    }
    l = this.d;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeSFixed64Size(4, l);
    }
    l = this.e;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeSFixed64Size(5, l);
    }
    long[] arrayOfLong = this.f;
    j = i;
    if (arrayOfLong != null)
    {
      j = i;
      if (arrayOfLong.length > 0) {
        j = i + arrayOfLong.length * 8 + arrayOfLong.length * 1;
      }
    }
    arrayOfLong = this.g;
    i = j;
    if (arrayOfLong != null)
    {
      i = j;
      if (arrayOfLong.length > 0) {
        i = j + arrayOfLong.length * 8 + arrayOfLong.length * 1;
      }
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeSFixed64(1, l);
    }
    l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeSFixed64(2, l);
    }
    l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeSFixed64(3, l);
    }
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeSFixed64(4, l);
    }
    l = this.e;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeSFixed64(5, l);
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
        paramCodedOutputByteBufferNano.writeSFixed64(6, arrayOfLong[i]);
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
        paramCodedOutputByteBufferNano.writeSFixed64(7, arrayOfLong[i]);
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.envoyproxy.pgv.validate.nano.SFixed64Rules
 * JD-Core Version:    0.7.0.1
 */