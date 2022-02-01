package io.envoyproxy.pgv.validate.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class SFixed32Rules
  extends ExtendableMessageNano<SFixed32Rules>
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int[] f;
  public int[] g;
  
  public SFixed32Rules()
  {
    a();
  }
  
  public SFixed32Rules a()
  {
    this.a = 0;
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = WireFormatNano.EMPTY_INT_ARRAY;
    this.g = WireFormatNano.EMPTY_INT_ARRAY;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SFixed32Rules a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 13)
      {
        if (i != 21)
        {
          if (i != 29)
          {
            if (i != 37)
            {
              if (i != 45)
              {
                int j;
                int[] arrayOfInt;
                int k;
                if (i != 50)
                {
                  if (i != 53)
                  {
                    if (i != 58)
                    {
                      if (i != 61)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                          return this;
                        }
                      }
                      else
                      {
                        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 61);
                        arrayOfInt = this.g;
                        if (arrayOfInt == null) {
                          i = 0;
                        } else {
                          i = arrayOfInt.length;
                        }
                        arrayOfInt = new int[j + i];
                        j = i;
                        if (i != 0)
                        {
                          System.arraycopy(this.g, 0, arrayOfInt, 0, i);
                          j = i;
                        }
                        while (j < arrayOfInt.length - 1)
                        {
                          arrayOfInt[j] = paramCodedInputByteBufferNano.readSFixed32();
                          paramCodedInputByteBufferNano.readTag();
                          j += 1;
                        }
                        arrayOfInt[j] = paramCodedInputByteBufferNano.readSFixed32();
                        this.g = arrayOfInt;
                      }
                    }
                    else
                    {
                      i = paramCodedInputByteBufferNano.readRawVarint32();
                      k = paramCodedInputByteBufferNano.pushLimit(i);
                      j = i / 4;
                      arrayOfInt = this.g;
                      if (arrayOfInt == null) {
                        i = 0;
                      } else {
                        i = arrayOfInt.length;
                      }
                      arrayOfInt = new int[j + i];
                      j = i;
                      if (i != 0)
                      {
                        System.arraycopy(this.g, 0, arrayOfInt, 0, i);
                        j = i;
                      }
                      while (j < arrayOfInt.length)
                      {
                        arrayOfInt[j] = paramCodedInputByteBufferNano.readSFixed32();
                        j += 1;
                      }
                      this.g = arrayOfInt;
                      paramCodedInputByteBufferNano.popLimit(k);
                    }
                  }
                  else
                  {
                    j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 53);
                    arrayOfInt = this.f;
                    if (arrayOfInt == null) {
                      i = 0;
                    } else {
                      i = arrayOfInt.length;
                    }
                    arrayOfInt = new int[j + i];
                    j = i;
                    if (i != 0)
                    {
                      System.arraycopy(this.f, 0, arrayOfInt, 0, i);
                      j = i;
                    }
                    while (j < arrayOfInt.length - 1)
                    {
                      arrayOfInt[j] = paramCodedInputByteBufferNano.readSFixed32();
                      paramCodedInputByteBufferNano.readTag();
                      j += 1;
                    }
                    arrayOfInt[j] = paramCodedInputByteBufferNano.readSFixed32();
                    this.f = arrayOfInt;
                  }
                }
                else
                {
                  i = paramCodedInputByteBufferNano.readRawVarint32();
                  k = paramCodedInputByteBufferNano.pushLimit(i);
                  j = i / 4;
                  arrayOfInt = this.f;
                  if (arrayOfInt == null) {
                    i = 0;
                  } else {
                    i = arrayOfInt.length;
                  }
                  arrayOfInt = new int[j + i];
                  j = i;
                  if (i != 0)
                  {
                    System.arraycopy(this.f, 0, arrayOfInt, 0, i);
                    j = i;
                  }
                  while (j < arrayOfInt.length)
                  {
                    arrayOfInt[j] = paramCodedInputByteBufferNano.readSFixed32();
                    j += 1;
                  }
                  this.f = arrayOfInt;
                  paramCodedInputByteBufferNano.popLimit(k);
                }
              }
              else
              {
                this.e = paramCodedInputByteBufferNano.readSFixed32();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readSFixed32();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readSFixed32();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readSFixed32();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readSFixed32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.a;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeSFixed32Size(1, k);
    }
    k = this.b;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeSFixed32Size(2, k);
    }
    k = this.c;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeSFixed32Size(3, k);
    }
    k = this.d;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeSFixed32Size(4, k);
    }
    k = this.e;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeSFixed32Size(5, k);
    }
    int[] arrayOfInt = this.f;
    j = i;
    if (arrayOfInt != null)
    {
      j = i;
      if (arrayOfInt.length > 0) {
        j = i + arrayOfInt.length * 4 + arrayOfInt.length * 1;
      }
    }
    arrayOfInt = this.g;
    i = j;
    if (arrayOfInt != null)
    {
      i = j;
      if (arrayOfInt.length > 0) {
        i = j + arrayOfInt.length * 4 + arrayOfInt.length * 1;
      }
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeSFixed32(1, i);
    }
    i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeSFixed32(2, i);
    }
    i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeSFixed32(3, i);
    }
    i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeSFixed32(4, i);
    }
    i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeSFixed32(5, i);
    }
    int[] arrayOfInt = this.f;
    int j = 0;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfInt = this.f;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeSFixed32(6, arrayOfInt[i]);
        i += 1;
      }
    }
    arrayOfInt = this.g;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = j;
      for (;;)
      {
        arrayOfInt = this.g;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeSFixed32(7, arrayOfInt[i]);
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.envoyproxy.pgv.validate.nano.SFixed32Rules
 * JD-Core Version:    0.7.0.1
 */