package com.tencent.qqlive.iliveRoomAdminSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;

public final class AdminDetail
  extends ExtendableMessageNano<AdminDetail>
{
  private static volatile AdminDetail[] j;
  public long a;
  public String b;
  public String c;
  public String d;
  public boolean e;
  public String f;
  public boolean g;
  public boolean h;
  public boolean i;
  
  public AdminDetail()
  {
    b();
  }
  
  public static AdminDetail[] a()
  {
    if (j == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (j == null) {
          j = new AdminDetail[0];
        }
      }
    }
    return j;
  }
  
  public AdminDetail a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (k != 26)
          {
            if (k != 34)
            {
              if (k != 40)
              {
                if (k != 50)
                {
                  if (k != 56)
                  {
                    if (k != 64)
                    {
                      if (k != 72)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, k)) {
                          return this;
                        }
                      }
                      else {
                        this.i = paramCodedInputByteBufferNano.readBool();
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readBool();
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readBool();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readString();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readBool();
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
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  public AdminDetail b()
  {
    this.a = 0L;
    this.b = "";
    this.c = "";
    this.d = "";
    this.e = false;
    this.f = "";
    this.g = false;
    this.h = false;
    this.i = false;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int m = super.computeSerializedSize();
    long l = this.a;
    int k = m;
    if (l != 0L) {
      k = m + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    m = k;
    if (!this.b.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    k = m;
    if (!this.c.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    m = k;
    if (!this.d.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    boolean bool = this.e;
    k = m;
    if (bool) {
      k = m + CodedOutputByteBufferNano.computeBoolSize(5, bool);
    }
    m = k;
    if (!this.f.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    bool = this.g;
    k = m;
    if (bool) {
      k = m + CodedOutputByteBufferNano.computeBoolSize(7, bool);
    }
    bool = this.h;
    m = k;
    if (bool) {
      m = k + CodedOutputByteBufferNano.computeBoolSize(8, bool);
    }
    bool = this.i;
    k = m;
    if (bool) {
      k = m + CodedOutputByteBufferNano.computeBoolSize(9, bool);
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
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    boolean bool = this.e;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(5, bool);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    bool = this.g;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(7, bool);
    }
    bool = this.h;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(8, bool);
    }
    bool = this.i;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(9, bool);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomAdminSvr.nano.AdminDetail
 * JD-Core Version:    0.7.0.1
 */