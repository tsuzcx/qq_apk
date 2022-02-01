package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class SetVideoSwitchByVideoSvrReq
  extends ExtendableMessageNano<SetVideoSwitchByVideoSvrReq>
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
  
  public SetVideoSwitchByVideoSvrReq()
  {
    a();
  }
  
  public SetVideoSwitchByVideoSvrReq a()
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
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SetVideoSwitchByVideoSvrReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        m = paramCodedInputByteBufferNano.readInt32();
        if ((m == -4) || (m == -3) || (m == -2) || (m == -1) || (m == 0) || (m == 4) || (m == 5) || (m == 6)) {
          this.g = m;
        }
        break;
      case 48: 
        m = paramCodedInputByteBufferNano.readInt32();
        switch (m)
        {
        default: 
          break;
        }
        this.f = m;
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
    int n = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeUInt64Size(3, this.c) + CodedOutputByteBufferNano.computeUInt64Size(4, this.d) + CodedOutputByteBufferNano.computeUInt32Size(5, this.e) + CodedOutputByteBufferNano.computeInt32Size(6, this.f) + CodedOutputByteBufferNano.computeInt32Size(7, this.g) + CodedOutputByteBufferNano.computeUInt32Size(8, this.h) + CodedOutputByteBufferNano.computeUInt32Size(9, this.i) + CodedOutputByteBufferNano.computeBytesSize(10, this.j);
    int i1 = this.k;
    int m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(11, i1);
    }
    i1 = this.l;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(12, i1);
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
    paramCodedOutputByteBufferNano.writeInt32(6, this.f);
    paramCodedOutputByteBufferNano.writeInt32(7, this.g);
    paramCodedOutputByteBufferNano.writeUInt32(8, this.h);
    paramCodedOutputByteBufferNano.writeUInt32(9, this.i);
    paramCodedOutputByteBufferNano.writeBytes(10, this.j);
    int m = this.k;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, m);
    }
    m = this.l;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(12, m);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.SetVideoSwitchByVideoSvrReq
 * JD-Core Version:    0.7.0.1
 */