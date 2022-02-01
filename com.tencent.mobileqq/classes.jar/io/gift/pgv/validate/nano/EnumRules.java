package io.gift.pgv.validate.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class EnumRules
  extends ExtendableMessageNano<EnumRules>
{
  public int a;
  public boolean b;
  public int[] c;
  public int[] d;
  
  public EnumRules()
  {
    a();
  }
  
  public EnumRules a()
  {
    this.a = 0;
    this.b = false;
    this.c = WireFormatNano.EMPTY_INT_ARRAY;
    this.d = WireFormatNano.EMPTY_INT_ARRAY;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public EnumRules a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          int j;
          int[] arrayOfInt;
          if (i != 24)
          {
            int k;
            if (i != 26)
            {
              if (i != 32)
              {
                if (i != 34)
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
                  arrayOfInt = this.d;
                  if (arrayOfInt == null) {
                    i = 0;
                  } else {
                    i = arrayOfInt.length;
                  }
                  arrayOfInt = new int[j + i];
                  j = i;
                  if (i != 0)
                  {
                    System.arraycopy(this.d, 0, arrayOfInt, 0, i);
                    j = i;
                  }
                  while (j < arrayOfInt.length)
                  {
                    arrayOfInt[j] = paramCodedInputByteBufferNano.readInt32();
                    j += 1;
                  }
                  this.d = arrayOfInt;
                  paramCodedInputByteBufferNano.popLimit(k);
                }
              }
              else
              {
                j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 32);
                arrayOfInt = this.d;
                if (arrayOfInt == null) {
                  i = 0;
                } else {
                  i = arrayOfInt.length;
                }
                arrayOfInt = new int[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.d, 0, arrayOfInt, 0, i);
                  j = i;
                }
                while (j < arrayOfInt.length - 1)
                {
                  arrayOfInt[j] = paramCodedInputByteBufferNano.readInt32();
                  paramCodedInputByteBufferNano.readTag();
                  j += 1;
                }
                arrayOfInt[j] = paramCodedInputByteBufferNano.readInt32();
                this.d = arrayOfInt;
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
              arrayOfInt = this.c;
              if (arrayOfInt == null) {
                i = 0;
              } else {
                i = arrayOfInt.length;
              }
              arrayOfInt = new int[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.c, 0, arrayOfInt, 0, i);
                j = i;
              }
              while (j < arrayOfInt.length)
              {
                arrayOfInt[j] = paramCodedInputByteBufferNano.readInt32();
                j += 1;
              }
              this.c = arrayOfInt;
              paramCodedInputByteBufferNano.popLimit(k);
            }
          }
          else
          {
            j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 24);
            arrayOfInt = this.c;
            if (arrayOfInt == null) {
              i = 0;
            } else {
              i = arrayOfInt.length;
            }
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramCodedInputByteBufferNano.readInt32();
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            arrayOfInt[j] = paramCodedInputByteBufferNano.readInt32();
            this.c = arrayOfInt;
          }
        }
        else
        {
          this.b = paramCodedInputByteBufferNano.readBool();
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
    boolean bool = this.b;
    i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(2, bool);
    }
    int[] arrayOfInt = this.c;
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
          arrayOfInt = this.c;
          if (j >= arrayOfInt.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[j]);
          j += 1;
        }
        j = i + k + arrayOfInt.length * 1;
      }
    }
    arrayOfInt = this.d;
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
          arrayOfInt = this.d;
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
    boolean bool = this.b;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(2, bool);
    }
    int[] arrayOfInt = this.c;
    int j = 0;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfInt = this.c;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeInt32(3, arrayOfInt[i]);
        i += 1;
      }
    }
    arrayOfInt = this.d;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = j;
      for (;;)
      {
        arrayOfInt = this.d;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeInt32(4, arrayOfInt[i]);
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.gift.pgv.validate.nano.EnumRules
 * JD-Core Version:    0.7.0.1
 */