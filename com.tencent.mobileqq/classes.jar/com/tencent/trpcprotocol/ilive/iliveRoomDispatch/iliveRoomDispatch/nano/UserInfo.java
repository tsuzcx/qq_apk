package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class UserInfo
  extends MessageNano
{
  private static volatile UserInfo[] i;
  public long a;
  public String b;
  public int c;
  public String d;
  public long e;
  public String f;
  public String g;
  public String h;
  
  public UserInfo()
  {
    b();
  }
  
  public static UserInfo[] a()
  {
    if (i == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (i == null) {
          i = new UserInfo[0];
        }
      }
    }
    return i;
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
        if (j != 18)
        {
          if (j != 40)
          {
            if (j != 50)
            {
              if (j != 56)
              {
                if (j != 66)
                {
                  if (j != 74)
                  {
                    if (j != 98)
                    {
                      if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, j)) {
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
                this.e = paramCodedInputByteBufferNano.readUInt64();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readString();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt32();
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
  
  public UserInfo b()
  {
    this.a = 0L;
    this.b = "";
    this.c = 0;
    this.d = "";
    this.e = 0L;
    this.f = "";
    this.g = "";
    this.h = "";
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.a;
    int k = j;
    if (l != 0L) {
      k = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    j = k;
    if (!this.b.equals("")) {
      j = k + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    int m = this.c;
    k = j;
    if (m != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(5, m);
    }
    j = k;
    if (!this.d.equals("")) {
      j = k + CodedOutputByteBufferNano.computeStringSize(6, this.d);
    }
    l = this.e;
    k = j;
    if (l != 0L) {
      k = j + CodedOutputByteBufferNano.computeUInt64Size(7, l);
    }
    j = k;
    if (!this.f.equals("")) {
      j = k + CodedOutputByteBufferNano.computeStringSize(8, this.f);
    }
    k = j;
    if (!this.g.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(9, this.g);
    }
    j = k;
    if (!this.h.equals("")) {
      j = k + CodedOutputByteBufferNano.computeStringSize(12, this.h);
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
    int j = this.c;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, j);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.d);
    }
    l = this.e;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(8, this.f);
    }
    if (!this.g.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.g);
    }
    if (!this.h.equals("")) {
      paramCodedOutputByteBufferNano.writeString(12, this.h);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.UserInfo
 * JD-Core Version:    0.7.0.1
 */