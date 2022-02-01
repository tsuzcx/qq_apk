package com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class QQMessage
  extends ExtendableMessageNano<QQMessage>
{
  public String a;
  public String b;
  public String c;
  public String d;
  public int e;
  public int f;
  public String[] g;
  
  public QQMessage()
  {
    a();
  }
  
  public QQMessage a()
  {
    this.a = "";
    this.b = "";
    this.c = "";
    this.d = "";
    this.e = 0;
    this.f = 0;
    this.g = WireFormatNano.EMPTY_STRING_ARRAY;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public QQMessage a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 18)
        {
          if (i != 26)
          {
            if (i != 34)
            {
              if (i != 40)
              {
                if (i != 48)
                {
                  if (i != 58)
                  {
                    if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else
                  {
                    int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 58);
                    String[] arrayOfString = this.g;
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
                  i = paramCodedInputByteBufferNano.readInt32();
                  if ((i == 0) || (i == 1) || (i == 2)) {
                    this.f = i;
                  }
                }
              }
              else
              {
                i = paramCodedInputByteBufferNano.readInt32();
                if ((i == 0) || (i == 1)) {
                  this.e = i;
                }
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readString();
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
    j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    int k = j;
    if (!this.c.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    i = k;
    if (!this.d.equals("")) {
      i = k + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    k = this.e;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(5, k);
    }
    k = this.f;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(6, k);
    }
    Object localObject = this.g;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0;; m = n)
        {
          localObject = this.g;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          int i1 = k;
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
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    int i = this.e;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, i);
    }
    i = this.f;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(6, i);
    }
    Object localObject = this.g;
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
          paramCodedOutputByteBufferNano.writeString(7, (String)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano.QQMessage
 * JD-Core Version:    0.7.0.1
 */