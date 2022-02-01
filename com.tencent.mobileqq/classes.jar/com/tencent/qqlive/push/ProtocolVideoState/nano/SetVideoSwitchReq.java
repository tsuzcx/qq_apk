package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class SetVideoSwitchReq
  extends ExtendableMessageNano<SetVideoSwitchReq>
{
  public long a;
  public long b;
  public long c;
  public long d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public byte[] j;
  public int k;
  public int l;
  public int m;
  
  public SetVideoSwitchReq()
  {
    a();
  }
  
  public SetVideoSwitchReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = WireFormatNano.EMPTY_BYTES;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SetVideoSwitchReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int n = paramCodedInputByteBufferNano.readTag();
      switch (n)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, n)) {
          return this;
        }
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
      case 82: 
        this.j = paramCodedInputByteBufferNano.readBytes();
        break;
      case 72: 
        this.i = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt64();
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
    int i1 = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeUInt64Size(3, this.c) + CodedOutputByteBufferNano.computeUInt64Size(4, this.d) + CodedOutputByteBufferNano.computeUInt32Size(5, this.e) + CodedOutputByteBufferNano.computeUInt32Size(6, this.f) + CodedOutputByteBufferNano.computeUInt32Size(7, this.g) + CodedOutputByteBufferNano.computeUInt32Size(8, this.h) + CodedOutputByteBufferNano.computeUInt32Size(9, this.i) + CodedOutputByteBufferNano.computeBytesSize(10, this.j);
    int i2 = this.k;
    int n = i1;
    if (i2 != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(11, i2);
    }
    i2 = this.l;
    i1 = n;
    if (i2 != 0) {
      i1 = n + CodedOutputByteBufferNano.computeUInt32Size(12, i2);
    }
    i2 = this.m;
    n = i1;
    if (i2 != 0) {
      n = i1 + CodedOutputByteBufferNano.computeUInt32Size(13, i2);
    }
    return n;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt64(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt64(3, this.c);
    paramCodedOutputByteBufferNano.writeUInt64(4, this.d);
    paramCodedOutputByteBufferNano.writeUInt32(5, this.e);
    paramCodedOutputByteBufferNano.writeUInt32(6, this.f);
    paramCodedOutputByteBufferNano.writeUInt32(7, this.g);
    paramCodedOutputByteBufferNano.writeUInt32(8, this.h);
    paramCodedOutputByteBufferNano.writeUInt32(9, this.i);
    paramCodedOutputByteBufferNano.writeBytes(10, this.j);
    int n = this.k;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, n);
    }
    n = this.l;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(12, n);
    }
    n = this.m;
    if (n != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(13, n);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.SetVideoSwitchReq
 * JD-Core Version:    0.7.0.1
 */