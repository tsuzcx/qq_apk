package com.tencent.qqlive.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class UserInfo
  extends ExtendableMessageNano<UserInfo>
{
  public long a;
  public int b;
  public String c;
  public long d;
  public String e;
  public long f;
  public int g;
  public String h;
  public String i;
  
  public UserInfo()
  {
    a();
  }
  
  public UserInfo a()
  {
    this.a = 0L;
    this.b = 0;
    this.c = "";
    this.d = 0L;
    this.e = "";
    this.f = 0L;
    this.g = 0;
    this.h = "";
    this.i = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public UserInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int j = paramCodedInputByteBufferNano.readTag();
      if (j == 0) {
        break;
      }
      if (j != 8)
      {
        if (j != 16)
        {
          if (j != 26)
          {
            if (j != 40)
            {
              if (j != 50)
              {
                if (j != 56)
                {
                  if (j != 64)
                  {
                    if (j != 74)
                    {
                      if (j != 82)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, j)) {
                          return this;
                        }
                      }
                      else {
                        this.i = paramCodedInputByteBufferNano.readString();
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readString();
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readUInt32();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt64();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readString();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt64();
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
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize();
    long l = this.a;
    int j = k;
    if (l != 0L) {
      j = k + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    int m = this.b;
    k = j;
    if (m != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(2, m);
    }
    j = k;
    if (!this.c.equals("")) {
      j = k + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    l = this.d;
    k = j;
    if (l != 0L) {
      k = j + CodedOutputByteBufferNano.computeUInt64Size(5, l);
    }
    m = k;
    if (!this.e.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(6, this.e);
    }
    l = this.f;
    j = m;
    if (l != 0L) {
      j = m + CodedOutputByteBufferNano.computeUInt64Size(7, l);
    }
    m = this.g;
    k = j;
    if (m != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(8, m);
    }
    j = k;
    if (!this.h.equals("")) {
      j = k + CodedOutputByteBufferNano.computeStringSize(9, this.h);
    }
    k = j;
    if (!this.i.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(10, this.i);
    }
    return k;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    int j = this.b;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, j);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, l);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.e);
    }
    l = this.f;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    j = this.g;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, j);
    }
    if (!this.h.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.h);
    }
    if (!this.i.equals("")) {
      paramCodedOutputByteBufferNano.writeString(10, this.i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.roomAccess.nano.UserInfo
 * JD-Core Version:    0.7.0.1
 */