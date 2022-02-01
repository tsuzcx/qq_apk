package io.gift.pgv.validate.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class DoubleRules
  extends ExtendableMessageNano<DoubleRules>
{
  public double a;
  public double b;
  public double c;
  public double d;
  public double e;
  public double[] f;
  public double[] g;
  
  public DoubleRules()
  {
    a();
  }
  
  public DoubleRules a()
  {
    this.a = 0.0D;
    this.b = 0.0D;
    this.c = 0.0D;
    this.d = 0.0D;
    this.e = 0.0D;
    this.f = WireFormatNano.EMPTY_DOUBLE_ARRAY;
    this.g = WireFormatNano.EMPTY_DOUBLE_ARRAY;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public DoubleRules a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
                double[] arrayOfDouble;
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
                        arrayOfDouble = this.g;
                        if (arrayOfDouble == null) {
                          i = 0;
                        } else {
                          i = arrayOfDouble.length;
                        }
                        arrayOfDouble = new double[j + i];
                        j = i;
                        if (i != 0)
                        {
                          System.arraycopy(this.g, 0, arrayOfDouble, 0, i);
                          j = i;
                        }
                        while (j < arrayOfDouble.length)
                        {
                          arrayOfDouble[j] = paramCodedInputByteBufferNano.readDouble();
                          j += 1;
                        }
                        this.g = arrayOfDouble;
                        paramCodedInputByteBufferNano.popLimit(k);
                      }
                    }
                    else
                    {
                      j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 57);
                      arrayOfDouble = this.g;
                      if (arrayOfDouble == null) {
                        i = 0;
                      } else {
                        i = arrayOfDouble.length;
                      }
                      arrayOfDouble = new double[j + i];
                      j = i;
                      if (i != 0)
                      {
                        System.arraycopy(this.g, 0, arrayOfDouble, 0, i);
                        j = i;
                      }
                      while (j < arrayOfDouble.length - 1)
                      {
                        arrayOfDouble[j] = paramCodedInputByteBufferNano.readDouble();
                        paramCodedInputByteBufferNano.readTag();
                        j += 1;
                      }
                      arrayOfDouble[j] = paramCodedInputByteBufferNano.readDouble();
                      this.g = arrayOfDouble;
                    }
                  }
                  else
                  {
                    i = paramCodedInputByteBufferNano.readRawVarint32();
                    k = paramCodedInputByteBufferNano.pushLimit(i);
                    j = i / 8;
                    arrayOfDouble = this.f;
                    if (arrayOfDouble == null) {
                      i = 0;
                    } else {
                      i = arrayOfDouble.length;
                    }
                    arrayOfDouble = new double[j + i];
                    j = i;
                    if (i != 0)
                    {
                      System.arraycopy(this.f, 0, arrayOfDouble, 0, i);
                      j = i;
                    }
                    while (j < arrayOfDouble.length)
                    {
                      arrayOfDouble[j] = paramCodedInputByteBufferNano.readDouble();
                      j += 1;
                    }
                    this.f = arrayOfDouble;
                    paramCodedInputByteBufferNano.popLimit(k);
                  }
                }
                else
                {
                  j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 49);
                  arrayOfDouble = this.f;
                  if (arrayOfDouble == null) {
                    i = 0;
                  } else {
                    i = arrayOfDouble.length;
                  }
                  arrayOfDouble = new double[j + i];
                  j = i;
                  if (i != 0)
                  {
                    System.arraycopy(this.f, 0, arrayOfDouble, 0, i);
                    j = i;
                  }
                  while (j < arrayOfDouble.length - 1)
                  {
                    arrayOfDouble[j] = paramCodedInputByteBufferNano.readDouble();
                    paramCodedInputByteBufferNano.readTag();
                    j += 1;
                  }
                  arrayOfDouble[j] = paramCodedInputByteBufferNano.readDouble();
                  this.f = arrayOfDouble;
                }
              }
              else
              {
                this.e = paramCodedInputByteBufferNano.readDouble();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readDouble();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readDouble();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readDouble();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readDouble();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (Double.doubleToLongBits(this.a) != Double.doubleToLongBits(0.0D)) {
      i = j + CodedOutputByteBufferNano.computeDoubleSize(1, this.a);
    }
    j = i;
    if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(0.0D)) {
      j = i + CodedOutputByteBufferNano.computeDoubleSize(2, this.b);
    }
    i = j;
    if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(0.0D)) {
      i = j + CodedOutputByteBufferNano.computeDoubleSize(3, this.c);
    }
    j = i;
    if (Double.doubleToLongBits(this.d) != Double.doubleToLongBits(0.0D)) {
      j = i + CodedOutputByteBufferNano.computeDoubleSize(4, this.d);
    }
    i = j;
    if (Double.doubleToLongBits(this.e) != Double.doubleToLongBits(0.0D)) {
      i = j + CodedOutputByteBufferNano.computeDoubleSize(5, this.e);
    }
    double[] arrayOfDouble = this.f;
    j = i;
    if (arrayOfDouble != null)
    {
      j = i;
      if (arrayOfDouble.length > 0) {
        j = i + arrayOfDouble.length * 8 + arrayOfDouble.length * 1;
      }
    }
    arrayOfDouble = this.g;
    i = j;
    if (arrayOfDouble != null)
    {
      i = j;
      if (arrayOfDouble.length > 0) {
        i = j + arrayOfDouble.length * 8 + arrayOfDouble.length * 1;
      }
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (Double.doubleToLongBits(this.a) != Double.doubleToLongBits(0.0D)) {
      paramCodedOutputByteBufferNano.writeDouble(1, this.a);
    }
    if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(0.0D)) {
      paramCodedOutputByteBufferNano.writeDouble(2, this.b);
    }
    if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(0.0D)) {
      paramCodedOutputByteBufferNano.writeDouble(3, this.c);
    }
    if (Double.doubleToLongBits(this.d) != Double.doubleToLongBits(0.0D)) {
      paramCodedOutputByteBufferNano.writeDouble(4, this.d);
    }
    if (Double.doubleToLongBits(this.e) != Double.doubleToLongBits(0.0D)) {
      paramCodedOutputByteBufferNano.writeDouble(5, this.e);
    }
    double[] arrayOfDouble = this.f;
    int j = 0;
    int i;
    if ((arrayOfDouble != null) && (arrayOfDouble.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfDouble = this.f;
        if (i >= arrayOfDouble.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeDouble(6, arrayOfDouble[i]);
        i += 1;
      }
    }
    arrayOfDouble = this.g;
    if ((arrayOfDouble != null) && (arrayOfDouble.length > 0))
    {
      i = j;
      for (;;)
      {
        arrayOfDouble = this.g;
        if (i >= arrayOfDouble.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeDouble(7, arrayOfDouble[i]);
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.gift.pgv.validate.nano.DoubleRules
 * JD-Core Version:    0.7.0.1
 */