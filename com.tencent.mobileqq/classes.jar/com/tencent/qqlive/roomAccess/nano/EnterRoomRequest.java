package com.tencent.qqlive.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class EnterRoomRequest
  extends ExtendableMessageNano<EnterRoomRequest>
{
  public long a;
  public String b;
  public byte[] c;
  public String[] d;
  public byte[] e;
  public String f;
  public String g;
  public String h;
  
  public EnterRoomRequest()
  {
    a();
  }
  
  public EnterRoomRequest a()
  {
    this.a = 0L;
    this.b = "";
    this.c = WireFormatNano.EMPTY_BYTES;
    this.d = WireFormatNano.EMPTY_STRING_ARRAY;
    this.e = WireFormatNano.EMPTY_BYTES;
    this.f = "";
    this.g = "";
    this.h = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public EnterRoomRequest a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 18)
        {
          if (i != 26)
          {
            if (i != 34)
            {
              if (i != 42)
              {
                if (i != 50)
                {
                  if (i != 58)
                  {
                    if (i != 66)
                    {
                      if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                        return this;
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readString();
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readString();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readString();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readBytes();
              }
            }
            else
            {
              int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
              String[] arrayOfString = this.d;
              if (arrayOfString == null) {
                i = 0;
              } else {
                i = arrayOfString.length;
              }
              arrayOfString = new String[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.d, 0, arrayOfString, 0, i);
                j = i;
              }
              while (j < arrayOfString.length - 1)
              {
                arrayOfString[j] = paramCodedInputByteBufferNano.readString();
                paramCodedInputByteBufferNano.readTag();
                j += 1;
              }
              arrayOfString[j] = paramCodedInputByteBufferNano.readString();
              this.d = arrayOfString;
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readBytes();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt64();
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
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    i = j;
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(3, this.c);
    }
    Object localObject = this.d;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        int k = 0;
        int n;
        for (int m = 0;; m = n)
        {
          localObject = this.d;
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
    i = j;
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(5, this.e);
    }
    j = i;
    if (!this.f.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    i = j;
    if (!this.g.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(7, this.g);
    }
    j = i;
    if (!this.h.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(8, this.h);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.c);
    }
    Object localObject = this.d;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.d;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(4, (String)localObject);
        }
        i += 1;
      }
    }
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(5, this.e);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    if (!this.g.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.g);
    }
    if (!this.h.equals("")) {
      paramCodedOutputByteBufferNano.writeString(8, this.h);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.roomAccess.nano.EnterRoomRequest
 * JD-Core Version:    0.7.0.1
 */