package io.envoyproxy.pgv.validate.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class FloatRules
  extends ExtendableMessageNano<FloatRules>
{
  public float a;
  public float b;
  public float c;
  public float d;
  public float e;
  public float[] f;
  public float[] g;
  
  public FloatRules()
  {
    a();
  }
  
  public FloatRules a()
  {
    this.a = 0.0F;
    this.b = 0.0F;
    this.c = 0.0F;
    this.d = 0.0F;
    this.e = 0.0F;
    this.f = WireFormatNano.EMPTY_FLOAT_ARRAY;
    this.g = WireFormatNano.EMPTY_FLOAT_ARRAY;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public FloatRules a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
                float[] arrayOfFloat;
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
                        arrayOfFloat = this.g;
                        if (arrayOfFloat == null) {
                          i = 0;
                        } else {
                          i = arrayOfFloat.length;
                        }
                        arrayOfFloat = new float[j + i];
                        j = i;
                        if (i != 0)
                        {
                          System.arraycopy(this.g, 0, arrayOfFloat, 0, i);
                          j = i;
                        }
                        while (j < arrayOfFloat.length - 1)
                        {
                          arrayOfFloat[j] = paramCodedInputByteBufferNano.readFloat();
                          paramCodedInputByteBufferNano.readTag();
                          j += 1;
                        }
                        arrayOfFloat[j] = paramCodedInputByteBufferNano.readFloat();
                        this.g = arrayOfFloat;
                      }
                    }
                    else
                    {
                      i = paramCodedInputByteBufferNano.readRawVarint32();
                      k = paramCodedInputByteBufferNano.pushLimit(i);
                      j = i / 4;
                      arrayOfFloat = this.g;
                      if (arrayOfFloat == null) {
                        i = 0;
                      } else {
                        i = arrayOfFloat.length;
                      }
                      arrayOfFloat = new float[j + i];
                      j = i;
                      if (i != 0)
                      {
                        System.arraycopy(this.g, 0, arrayOfFloat, 0, i);
                        j = i;
                      }
                      while (j < arrayOfFloat.length)
                      {
                        arrayOfFloat[j] = paramCodedInputByteBufferNano.readFloat();
                        j += 1;
                      }
                      this.g = arrayOfFloat;
                      paramCodedInputByteBufferNano.popLimit(k);
                    }
                  }
                  else
                  {
                    j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 53);
                    arrayOfFloat = this.f;
                    if (arrayOfFloat == null) {
                      i = 0;
                    } else {
                      i = arrayOfFloat.length;
                    }
                    arrayOfFloat = new float[j + i];
                    j = i;
                    if (i != 0)
                    {
                      System.arraycopy(this.f, 0, arrayOfFloat, 0, i);
                      j = i;
                    }
                    while (j < arrayOfFloat.length - 1)
                    {
                      arrayOfFloat[j] = paramCodedInputByteBufferNano.readFloat();
                      paramCodedInputByteBufferNano.readTag();
                      j += 1;
                    }
                    arrayOfFloat[j] = paramCodedInputByteBufferNano.readFloat();
                    this.f = arrayOfFloat;
                  }
                }
                else
                {
                  i = paramCodedInputByteBufferNano.readRawVarint32();
                  k = paramCodedInputByteBufferNano.pushLimit(i);
                  j = i / 4;
                  arrayOfFloat = this.f;
                  if (arrayOfFloat == null) {
                    i = 0;
                  } else {
                    i = arrayOfFloat.length;
                  }
                  arrayOfFloat = new float[j + i];
                  j = i;
                  if (i != 0)
                  {
                    System.arraycopy(this.f, 0, arrayOfFloat, 0, i);
                    j = i;
                  }
                  while (j < arrayOfFloat.length)
                  {
                    arrayOfFloat[j] = paramCodedInputByteBufferNano.readFloat();
                    j += 1;
                  }
                  this.f = arrayOfFloat;
                  paramCodedInputByteBufferNano.popLimit(k);
                }
              }
              else
              {
                this.e = paramCodedInputByteBufferNano.readFloat();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readFloat();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readFloat();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readFloat();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readFloat();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (Float.floatToIntBits(this.a) != Float.floatToIntBits(0.0F)) {
      i = j + CodedOutputByteBufferNano.computeFloatSize(1, this.a);
    }
    j = i;
    if (Float.floatToIntBits(this.b) != Float.floatToIntBits(0.0F)) {
      j = i + CodedOutputByteBufferNano.computeFloatSize(2, this.b);
    }
    i = j;
    if (Float.floatToIntBits(this.c) != Float.floatToIntBits(0.0F)) {
      i = j + CodedOutputByteBufferNano.computeFloatSize(3, this.c);
    }
    j = i;
    if (Float.floatToIntBits(this.d) != Float.floatToIntBits(0.0F)) {
      j = i + CodedOutputByteBufferNano.computeFloatSize(4, this.d);
    }
    i = j;
    if (Float.floatToIntBits(this.e) != Float.floatToIntBits(0.0F)) {
      i = j + CodedOutputByteBufferNano.computeFloatSize(5, this.e);
    }
    float[] arrayOfFloat = this.f;
    j = i;
    if (arrayOfFloat != null)
    {
      j = i;
      if (arrayOfFloat.length > 0) {
        j = i + arrayOfFloat.length * 4 + arrayOfFloat.length * 1;
      }
    }
    arrayOfFloat = this.g;
    i = j;
    if (arrayOfFloat != null)
    {
      i = j;
      if (arrayOfFloat.length > 0) {
        i = j + arrayOfFloat.length * 4 + arrayOfFloat.length * 1;
      }
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (Float.floatToIntBits(this.a) != Float.floatToIntBits(0.0F)) {
      paramCodedOutputByteBufferNano.writeFloat(1, this.a);
    }
    if (Float.floatToIntBits(this.b) != Float.floatToIntBits(0.0F)) {
      paramCodedOutputByteBufferNano.writeFloat(2, this.b);
    }
    if (Float.floatToIntBits(this.c) != Float.floatToIntBits(0.0F)) {
      paramCodedOutputByteBufferNano.writeFloat(3, this.c);
    }
    if (Float.floatToIntBits(this.d) != Float.floatToIntBits(0.0F)) {
      paramCodedOutputByteBufferNano.writeFloat(4, this.d);
    }
    if (Float.floatToIntBits(this.e) != Float.floatToIntBits(0.0F)) {
      paramCodedOutputByteBufferNano.writeFloat(5, this.e);
    }
    float[] arrayOfFloat = this.f;
    int j = 0;
    int i;
    if ((arrayOfFloat != null) && (arrayOfFloat.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfFloat = this.f;
        if (i >= arrayOfFloat.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeFloat(6, arrayOfFloat[i]);
        i += 1;
      }
    }
    arrayOfFloat = this.g;
    if ((arrayOfFloat != null) && (arrayOfFloat.length > 0))
    {
      i = j;
      for (;;)
      {
        arrayOfFloat = this.g;
        if (i >= arrayOfFloat.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeFloat(7, arrayOfFloat[i]);
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.envoyproxy.pgv.validate.nano.FloatRules
 * JD-Core Version:    0.7.0.1
 */