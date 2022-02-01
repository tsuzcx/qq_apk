package io.envoyproxy.pgv.validate.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class Int32Rules
  extends ExtendableMessageNano<Int32Rules>
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int[] f;
  public int[] g;
  
  public Int32Rules()
  {
    a();
  }
  
  public Int32Rules a()
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
  
  public Int32Rules a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
                int[] arrayOfInt;
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
                          paramCodedInputByteBufferNano.readInt32();
                          j += 1;
                        }
                        paramCodedInputByteBufferNano.rewindToPosition(i);
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
                          arrayOfInt[j] = paramCodedInputByteBufferNano.readInt32();
                          j += 1;
                        }
                        this.g = arrayOfInt;
                        paramCodedInputByteBufferNano.popLimit(k);
                      }
                    }
                    else
                    {
                      j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 56);
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
                        arrayOfInt[j] = paramCodedInputByteBufferNano.readInt32();
                        paramCodedInputByteBufferNano.readTag();
                        j += 1;
                      }
                      arrayOfInt[j] = paramCodedInputByteBufferNano.readInt32();
                      this.g = arrayOfInt;
                    }
                  }
                  else
                  {
                    k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
                    i = paramCodedInputByteBufferNano.getPosition();
                    j = 0;
                    while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
                    {
                      paramCodedInputByteBufferNano.readInt32();
                      j += 1;
                    }
                    paramCodedInputByteBufferNano.rewindToPosition(i);
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
                      arrayOfInt[j] = paramCodedInputByteBufferNano.readInt32();
                      j += 1;
                    }
                    this.f = arrayOfInt;
                    paramCodedInputByteBufferNano.popLimit(k);
                  }
                }
                else
                {
                  j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 48);
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
                    arrayOfInt[j] = paramCodedInputByteBufferNano.readInt32();
                    paramCodedInputByteBufferNano.readTag();
                    j += 1;
                  }
                  arrayOfInt[j] = paramCodedInputByteBufferNano.readInt32();
                  this.f = arrayOfInt;
                }
              }
              else
              {
                this.e = paramCodedInputByteBufferNano.readInt32();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readInt32();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readInt32();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readInt32();
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
    int j = super.computeSerializedSize();
    int k = this.a;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    k = this.b;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(2, k);
    }
    k = this.c;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(3, k);
    }
    k = this.d;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(4, k);
    }
    k = this.e;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(5, k);
    }
    int[] arrayOfInt = this.f;
    int m = 0;
    j = i;
    if (arrayOfInt != null)
    {
      j = i;
      if (arrayOfInt.length > 0)
      {
        j = 0;
        k = 0;
        for (;;)
        {
          arrayOfInt = this.f;
          if (j >= arrayOfInt.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[j]);
          j += 1;
        }
        j = i + k + arrayOfInt.length * 1;
      }
    }
    arrayOfInt = this.g;
    i = j;
    if (arrayOfInt != null)
    {
      i = j;
      if (arrayOfInt.length > 0)
      {
        k = 0;
        i = m;
        for (;;)
        {
          arrayOfInt = this.g;
          if (i >= arrayOfInt.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[i]);
          i += 1;
        }
        i = j + k + arrayOfInt.length * 1;
      }
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, i);
    }
    i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(3, i);
    }
    i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, i);
    }
    i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, i);
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
        paramCodedOutputByteBufferNano.writeInt32(6, arrayOfInt[i]);
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
        paramCodedOutputByteBufferNano.writeInt32(7, arrayOfInt[i]);
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.envoyproxy.pgv.validate.nano.Int32Rules
 * JD-Core Version:    0.7.0.1
 */