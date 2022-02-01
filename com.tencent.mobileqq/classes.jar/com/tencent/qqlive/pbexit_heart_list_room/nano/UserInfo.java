package com.tencent.qqlive.pbexit_heart_list_room.nano;

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
  public long d;
  public int e;
  public byte[] f;
  public byte[] g;
  public int h;
  public String i;
  
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
          if (k != 24)
          {
            if (k != 32)
            {
              if (k != 40)
              {
                if (k != 50)
                {
                  if (k != 74)
                  {
                    if (k != 88)
                    {
                      if (k != 98)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, k)) {
                          return this;
                        }
                      }
                      else {
                        this.i = paramCodedInputByteBufferNano.readString();
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readUInt32();
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readBytes();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readBytes();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readUInt32();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt64();
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
    this.d = 0L;
    this.e = 0;
    this.f = WireFormatNano.EMPTY_BYTES;
    this.g = WireFormatNano.EMPTY_BYTES;
    this.h = 0;
    this.i = "";
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
      m = k + CodedOutputByteBufferNano.computeUInt32Size(3, n);
    }
    l = this.d;
    k = m;
    if (l != 0L) {
      k = m + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    n = this.e;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(5, n);
    }
    n = m;
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      n = m + CodedOutputByteBufferNano.computeBytesSize(6, this.f);
    }
    k = n;
    if (!Arrays.equals(this.g, WireFormatNano.EMPTY_BYTES)) {
      k = n + CodedOutputByteBufferNano.computeBytesSize(9, this.g);
    }
    n = this.h;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(11, n);
    }
    k = m;
    if (!this.i.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(12, this.i);
    }
    return k;
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
      paramCodedOutputByteBufferNano.writeUInt32(3, k);
    }
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    k = this.e;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, k);
    }
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(6, this.f);
    }
    if (!Arrays.equals(this.g, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(9, this.g);
    }
    k = this.h;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, k);
    }
    if (!this.i.equals("")) {
      paramCodedOutputByteBufferNano.writeString(12, this.i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.pbexit_heart_list_room.nano.UserInfo
 * JD-Core Version:    0.7.0.1
 */