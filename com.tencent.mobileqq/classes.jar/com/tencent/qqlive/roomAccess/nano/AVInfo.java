package com.tencent.qqlive.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class AVInfo
  extends ExtendableMessageNano<AVInfo>
{
  public int a;
  public int b;
  public byte[] c;
  public int d;
  public byte[] e;
  public OpenSdkUrl f;
  public OpenSdkUrl g;
  public OpenSdkUrl h;
  public DesignatedStreamInfo i;
  public int j;
  public int k;
  public int l;
  public int m;
  public TrtcInfo n;
  public StreamIDInfo o;
  
  public AVInfo()
  {
    a();
  }
  
  public AVInfo a()
  {
    this.a = 0;
    this.b = 0;
    this.c = WireFormatNano.EMPTY_BYTES;
    this.d = 0;
    this.e = WireFormatNano.EMPTY_BYTES;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    this.n = null;
    this.o = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public AVInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i1 = paramCodedInputByteBufferNano.readTag();
      switch (i1)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, i1)) {
          return this;
        }
        break;
      case 122: 
        if (this.o == null) {
          this.o = new StreamIDInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.o);
        break;
      case 114: 
        if (this.n == null) {
          this.n = new TrtcInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.n);
        break;
      case 104: 
        this.m = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 96: 
        this.l = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 88: 
        this.k = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 80: 
        this.j = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 74: 
        if (this.i == null) {
          this.i = new DesignatedStreamInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.i);
        break;
      case 66: 
        if (this.h == null) {
          this.h = new OpenSdkUrl();
        }
        paramCodedInputByteBufferNano.readMessage(this.h);
        break;
      case 58: 
        if (this.g == null) {
          this.g = new OpenSdkUrl();
        }
        paramCodedInputByteBufferNano.readMessage(this.g);
        break;
      case 50: 
        if (this.f == null) {
          this.f = new OpenSdkUrl();
        }
        paramCodedInputByteBufferNano.readMessage(this.f);
        break;
      case 42: 
        this.e = paramCodedInputByteBufferNano.readBytes();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 26: 
        this.c = paramCodedInputByteBufferNano.readBytes();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i2 = super.computeSerializedSize();
    int i3 = this.a;
    int i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(1, i3);
    }
    i3 = this.b;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(2, i3);
    }
    i1 = i2;
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      i1 = i2 + CodedOutputByteBufferNano.computeBytesSize(3, this.c);
    }
    i3 = this.d;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(4, i3);
    }
    i1 = i2;
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      i1 = i2 + CodedOutputByteBufferNano.computeBytesSize(5, this.e);
    }
    Object localObject = this.f;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(6, (MessageNano)localObject);
    }
    localObject = this.g;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.computeMessageSize(7, (MessageNano)localObject);
    }
    localObject = this.h;
    i3 = i1;
    if (localObject != null) {
      i3 = i1 + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
    }
    localObject = this.i;
    i2 = i3;
    if (localObject != null) {
      i2 = i3 + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
    }
    i3 = this.j;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(10, i3);
    }
    i3 = this.k;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(11, i3);
    }
    i3 = this.l;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(12, i3);
    }
    i3 = this.m;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(13, i3);
    }
    localObject = this.n;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.computeMessageSize(14, (MessageNano)localObject);
    }
    localObject = this.o;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(15, (MessageNano)localObject);
    }
    return i2;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i1 = this.a;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i1);
    }
    i1 = this.b;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i1);
    }
    if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.c);
    }
    i1 = this.d;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i1);
    }
    if (!Arrays.equals(this.e, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(5, this.e);
    }
    Object localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(6, (MessageNano)localObject);
    }
    localObject = this.g;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(7, (MessageNano)localObject);
    }
    localObject = this.h;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)localObject);
    }
    localObject = this.i;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
    }
    i1 = this.j;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, i1);
    }
    i1 = this.k;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, i1);
    }
    i1 = this.l;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(12, i1);
    }
    i1 = this.m;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(13, i1);
    }
    localObject = this.n;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(14, (MessageNano)localObject);
    }
    localObject = this.o;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(15, (MessageNano)localObject);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.roomAccess.nano.AVInfo
 * JD-Core Version:    0.7.0.1
 */