package com.tencent.protobuf.newRoomsvrPushmsg.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class UserInfo
  extends ExtendableMessageNano<UserInfo>
{
  private static volatile UserInfo[] l;
  public long a;
  public String b;
  public int c;
  public long d;
  public int e;
  public String f;
  public long g;
  public byte[] h;
  public byte[] i;
  public int j;
  public String k;
  
  public UserInfo()
  {
    b();
  }
  
  public static UserInfo[] a()
  {
    if (l == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (l == null) {
          l = new UserInfo[0];
        }
      }
    }
    return l;
  }
  
  public UserInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int m = paramCodedInputByteBufferNano.readTag();
      switch (m)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, m)) {
          return this;
        }
        break;
      case 98: 
        this.k = paramCodedInputByteBufferNano.readString();
        break;
      case 88: 
        this.j = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 74: 
        this.i = paramCodedInputByteBufferNano.readBytes();
        break;
      case 66: 
        this.h = paramCodedInputByteBufferNano.readBytes();
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 50: 
        this.f = paramCodedInputByteBufferNano.readString();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 18: 
        this.b = paramCodedInputByteBufferNano.readString();
        break;
      case 8: 
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
    this.f = "";
    this.g = 0L;
    this.h = WireFormatNano.EMPTY_BYTES;
    this.i = WireFormatNano.EMPTY_BYTES;
    this.j = 0;
    this.k = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int m = super.computeSerializedSize();
    long l1 = this.a;
    int n = m;
    if (l1 != 0L) {
      n = m + CodedOutputByteBufferNano.computeUInt64Size(1, l1);
    }
    m = n;
    if (!this.b.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    int i1 = this.c;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(3, i1);
    }
    l1 = this.d;
    m = n;
    if (l1 != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(4, l1);
    }
    i1 = this.e;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(5, i1);
    }
    m = n;
    if (!this.f.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    l1 = this.g;
    n = m;
    if (l1 != 0L) {
      n = m + CodedOutputByteBufferNano.computeUInt64Size(7, l1);
    }
    i1 = n;
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      i1 = n + CodedOutputByteBufferNano.computeBytesSize(8, this.h);
    }
    m = i1;
    if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
      m = i1 + CodedOutputByteBufferNano.computeBytesSize(9, this.i);
    }
    i1 = this.j;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(11, i1);
    }
    m = n;
    if (!this.k.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(12, this.k);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l1 = this.a;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l1);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    int m = this.c;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, m);
    }
    l1 = this.d;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l1);
    }
    m = this.e;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, m);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    l1 = this.g;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l1);
    }
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(8, this.h);
    }
    if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(9, this.i);
    }
    m = this.j;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, m);
    }
    if (!this.k.equals("")) {
      paramCodedOutputByteBufferNano.writeString(12, this.k);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.newRoomsvrPushmsg.nano.UserInfo
 * JD-Core Version:    0.7.0.1
 */