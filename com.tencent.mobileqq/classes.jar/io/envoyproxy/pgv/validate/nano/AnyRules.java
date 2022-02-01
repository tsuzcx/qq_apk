package io.envoyproxy.pgv.validate.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class AnyRules
  extends ExtendableMessageNano<AnyRules>
{
  public boolean a;
  public String[] b;
  public String[] c;
  
  public AnyRules()
  {
    a();
  }
  
  public AnyRules a()
  {
    this.a = false;
    this.b = WireFormatNano.EMPTY_STRING_ARRAY;
    this.c = WireFormatNano.EMPTY_STRING_ARRAY;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public AnyRules a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        String[] arrayOfString;
        if (i != 18)
        {
          if (i != 26)
          {
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else
          {
            j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
            arrayOfString = this.c;
            if (arrayOfString == null) {
              i = 0;
            } else {
              i = arrayOfString.length;
            }
            arrayOfString = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.c, 0, arrayOfString, 0, i);
              j = i;
            }
            while (j < arrayOfString.length - 1)
            {
              arrayOfString[j] = paramCodedInputByteBufferNano.readString();
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            arrayOfString[j] = paramCodedInputByteBufferNano.readString();
            this.c = arrayOfString;
          }
        }
        else
        {
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          arrayOfString = this.b;
          if (arrayOfString == null) {
            i = 0;
          } else {
            i = arrayOfString.length;
          }
          arrayOfString = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, arrayOfString, 0, i);
            j = i;
          }
          while (j < arrayOfString.length - 1)
          {
            arrayOfString[j] = paramCodedInputByteBufferNano.readString();
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          arrayOfString[j] = paramCodedInputByteBufferNano.readString();
          this.b = arrayOfString;
        }
      }
      else
      {
        this.a = paramCodedInputByteBufferNano.readBool();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    boolean bool = this.a;
    int i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(1, bool);
    }
    Object localObject = this.b;
    int i2 = 0;
    j = i;
    int k;
    int m;
    int i1;
    int n;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        k = 0;
        for (m = 0;; m = n)
        {
          localObject = this.b;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + CodedOutputByteBufferNano.computeStringSizeNoTag((String)localObject);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 1;
      }
    }
    localObject = this.c;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        k = 0;
        m = 0;
        i = i2;
        for (;;)
        {
          localObject = this.c;
          if (i >= localObject.length) {
            break;
          }
          localObject = localObject[i];
          i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + CodedOutputByteBufferNano.computeStringSizeNoTag((String)localObject);
          }
          i += 1;
          k = i1;
          m = n;
        }
        i = j + k + m * 1;
      }
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    boolean bool = this.a;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(1, bool);
    }
    Object localObject = this.b;
    int j = 0;
    int i;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.b;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(2, (String)localObject);
        }
        i += 1;
      }
    }
    localObject = this.c;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = this.c;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(3, (String)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.envoyproxy.pgv.validate.nano.AnyRules
 * JD-Core Version:    0.7.0.1
 */