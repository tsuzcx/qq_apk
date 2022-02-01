package com.tencent.qqlive.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class BaseInfo
  extends ExtendableMessageNano<BaseInfo>
{
  public String a;
  public int b;
  public String c;
  public int d;
  public int e;
  public int f;
  public String[] g;
  public String[] h;
  
  public BaseInfo()
  {
    a();
  }
  
  public BaseInfo a()
  {
    this.a = "";
    this.b = 0;
    this.c = "";
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = WireFormatNano.EMPTY_STRING_ARRAY;
    this.h = WireFormatNano.EMPTY_STRING_ARRAY;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public BaseInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 16)
        {
          if (i != 26)
          {
            if (i != 40)
            {
              if (i != 48)
              {
                if (i != 56)
                {
                  int j;
                  String[] arrayOfString;
                  if (i != 66)
                  {
                    if (i != 74)
                    {
                      if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                        return this;
                      }
                    }
                    else
                    {
                      j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 74);
                      arrayOfString = this.h;
                      if (arrayOfString == null) {
                        i = 0;
                      } else {
                        i = arrayOfString.length;
                      }
                      arrayOfString = new String[j + i];
                      j = i;
                      if (i != 0)
                      {
                        System.arraycopy(this.h, 0, arrayOfString, 0, i);
                        j = i;
                      }
                      while (j < arrayOfString.length - 1)
                      {
                        arrayOfString[j] = paramCodedInputByteBufferNano.readString();
                        paramCodedInputByteBufferNano.readTag();
                        j += 1;
                      }
                      arrayOfString[j] = paramCodedInputByteBufferNano.readString();
                      this.h = arrayOfString;
                    }
                  }
                  else
                  {
                    j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 66);
                    arrayOfString = this.g;
                    if (arrayOfString == null) {
                      i = 0;
                    } else {
                      i = arrayOfString.length;
                    }
                    arrayOfString = new String[j + i];
                    j = i;
                    if (i != 0)
                    {
                      System.arraycopy(this.g, 0, arrayOfString, 0, i);
                      j = i;
                    }
                    while (j < arrayOfString.length - 1)
                    {
                      arrayOfString[j] = paramCodedInputByteBufferNano.readString();
                      paramCodedInputByteBufferNano.readTag();
                      j += 1;
                    }
                    arrayOfString[j] = paramCodedInputByteBufferNano.readString();
                    this.g = arrayOfString;
                  }
                }
                else
                {
                  this.f = paramCodedInputByteBufferNano.readUInt32();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readUInt32();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt32();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt32();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.a.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    int k = this.b;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, k);
    }
    k = j;
    if (!this.c.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    j = this.d;
    i = k;
    if (j != 0) {
      i = k + CodedOutputByteBufferNano.computeUInt32Size(5, j);
    }
    k = this.e;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(6, k);
    }
    k = this.f;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(7, k);
    }
    Object localObject = this.g;
    int i2 = 0;
    j = i;
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
          localObject = this.g;
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
    localObject = this.h;
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
          localObject = this.h;
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
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    int i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, i);
    }
    i = this.f;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i);
    }
    Object localObject = this.g;
    int j = 0;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.g;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(8, (String)localObject);
        }
        i += 1;
      }
    }
    localObject = this.h;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = this.h;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(9, (String)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.roomAccess.nano.BaseInfo
 * JD-Core Version:    0.7.0.1
 */