package com.tencent.mobileqq.now.msfilivehead;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class ForwardReq
  extends MessageNano
{
  public long a;
  public long b;
  public String c;
  public int d;
  public String e;
  public byte[] f;
  public int g;
  public int h;
  public String i;
  public String j;
  public int k;
  public int l;
  public String m;
  public int n;
  public AuthInfo[] o;
  public byte[] p;
  public int q;
  
  public ForwardReq()
  {
    a();
  }
  
  public ForwardReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = "";
    this.d = 0;
    this.e = "";
    this.f = WireFormatNano.EMPTY_BYTES;
    this.g = 0;
    this.h = 0;
    this.i = "";
    this.j = "";
    this.k = 0;
    this.l = 0;
    this.m = "";
    this.n = 0;
    this.o = AuthInfo.a();
    this.p = WireFormatNano.EMPTY_BYTES;
    this.q = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public ForwardReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i1 = paramCodedInputByteBufferNano.readTag();
      switch (i1)
      {
      default: 
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i1)) {
          return this;
        }
        break;
      case 136: 
        this.q = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 130: 
        this.p = paramCodedInputByteBufferNano.readBytes();
        break;
      case 122: 
        int i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 122);
        AuthInfo[] arrayOfAuthInfo = this.o;
        if (arrayOfAuthInfo == null) {
          i1 = 0;
        } else {
          i1 = arrayOfAuthInfo.length;
        }
        arrayOfAuthInfo = new AuthInfo[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.o, 0, arrayOfAuthInfo, 0, i1);
          i2 = i1;
        }
        while (i2 < arrayOfAuthInfo.length - 1)
        {
          arrayOfAuthInfo[i2] = new AuthInfo();
          paramCodedInputByteBufferNano.readMessage(arrayOfAuthInfo[i2]);
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        arrayOfAuthInfo[i2] = new AuthInfo();
        paramCodedInputByteBufferNano.readMessage(arrayOfAuthInfo[i2]);
        this.o = arrayOfAuthInfo;
        break;
      case 112: 
        this.n = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 106: 
        this.m = paramCodedInputByteBufferNano.readString();
        break;
      case 96: 
        this.l = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 88: 
        this.k = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 82: 
        this.j = paramCodedInputByteBufferNano.readString();
        break;
      case 74: 
        this.i = paramCodedInputByteBufferNano.readString();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 50: 
        this.f = paramCodedInputByteBufferNano.readBytes();
        break;
      case 42: 
        this.e = paramCodedInputByteBufferNano.readString();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 26: 
        this.c = paramCodedInputByteBufferNano.readString();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i2 = super.computeSerializedSize();
    long l1 = this.a;
    int i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(1, l1);
    }
    l1 = this.b;
    i2 = i1;
    if (l1 != 0L) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt64Size(2, l1);
    }
    i1 = i2;
    if (!this.c.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    int i3 = this.d;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(4, i3);
    }
    i1 = i2;
    if (!this.e.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(5, this.e);
    }
    i2 = i1;
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      i2 = i1 + CodedOutputByteBufferNano.computeBytesSize(6, this.f);
    }
    i3 = this.g;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(7, i3);
    }
    i3 = this.h;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(8, i3);
    }
    i1 = i2;
    if (!this.i.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(9, this.i);
    }
    i2 = i1;
    if (!this.j.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(10, this.j);
    }
    i3 = this.k;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(11, i3);
    }
    i3 = this.l;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(12, i3);
    }
    i3 = i2;
    if (!this.m.equals("")) {
      i3 = i2 + CodedOutputByteBufferNano.computeStringSize(13, this.m);
    }
    i2 = this.n;
    i1 = i3;
    if (i2 != 0) {
      i1 = i3 + CodedOutputByteBufferNano.computeUInt32Size(14, i2);
    }
    Object localObject = this.o;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.o;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(15, (MessageNano)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    i1 = i2;
    if (!Arrays.equals(this.p, WireFormatNano.EMPTY_BYTES)) {
      i1 = i2 + CodedOutputByteBufferNano.computeBytesSize(16, this.p);
    }
    i3 = this.q;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(17, i3);
    }
    return i2;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l1 = this.a;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l1);
    }
    l1 = this.b;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l1);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    int i1 = this.d;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i1);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.e);
    }
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(6, this.f);
    }
    i1 = this.g;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i1);
    }
    i1 = this.h;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i1);
    }
    if (!this.i.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.i);
    }
    if (!this.j.equals("")) {
      paramCodedOutputByteBufferNano.writeString(10, this.j);
    }
    i1 = this.k;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, i1);
    }
    i1 = this.l;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(12, i1);
    }
    if (!this.m.equals("")) {
      paramCodedOutputByteBufferNano.writeString(13, this.m);
    }
    i1 = this.n;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(14, i1);
    }
    Object localObject = this.o;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.o;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(15, (MessageNano)localObject);
        }
        i1 += 1;
      }
    }
    if (!Arrays.equals(this.p, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(16, this.p);
    }
    i1 = this.q;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(17, i1);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.msfilivehead.ForwardReq
 * JD-Core Version:    0.7.0.1
 */