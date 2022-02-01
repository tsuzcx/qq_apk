package com.tencent.qqlive.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class UserInfo
  extends ExtendableMessageNano<UserInfo>
{
  private static volatile UserInfo[] j;
  public long a;
  public String b;
  public int c;
  public String d;
  public long e;
  public byte[] f;
  public String g;
  public String h;
  public long i;
  
  public UserInfo()
  {
    b();
  }
  
  public static UserInfo[] a()
  {
    if (j == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (j == null) {
          j = new UserInfo[0];
        }
      }
    }
    return j;
  }
  
  public UserInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int k = paramCodedInputByteBufferNano.readTag();
      if (k == 0) {
        break;
      }
      if (k != 8)
      {
        if (k != 18)
        {
          if (k != 40)
          {
            if (k != 50)
            {
              if (k != 56)
              {
                if (k != 66)
                {
                  if (k != 74)
                  {
                    if (k != 98)
                    {
                      if (k != 808)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, k)) {
                          return this;
                        }
                      }
                      else {
                        this.i = paramCodedInputByteBufferNano.readInt64();
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
                  this.f = paramCodedInputByteBufferNano.readBytes();
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
    this.f = WireFormatNano.EMPTY_BYTES;
    this.g = "";
    this.h = "";
    this.i = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize();
    long l = this.a;
    int m = k;
    if (l != 0L) {
      m = k + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    k = m;
    if (!this.b.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    int n = this.c;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(5, n);
    }
    k = m;
    if (!this.d.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(6, this.d);
    }
    l = this.e;
    m = k;
    if (l != 0L) {
      m = k + CodedOutputByteBufferNano.computeUInt64Size(7, l);
    }
    k = m;
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      k = m + CodedOutputByteBufferNano.computeBytesSize(8, this.f);
    }
    m = k;
    if (!this.g.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(9, this.g);
    }
    k = m;
    if (!this.h.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(12, this.h);
    }
    l = this.i;
    m = k;
    if (l != 0L) {
      m = k + CodedOutputByteBufferNano.computeInt64Size(101, l);
    }
    return m;
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
    int k = this.c;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, k);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.d);
    }
    l = this.e;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(8, this.f);
    }
    if (!this.g.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.g);
    }
    if (!this.h.equals("")) {
      paramCodedOutputByteBufferNano.writeString(12, this.h);
    }
    l = this.i;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(101, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomDispatch.nano.UserInfo
 * JD-Core Version:    0.7.0.1
 */