package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class NotifyVideoArriveByVideoSvrReq
  extends ExtendableMessageNano<NotifyVideoArriveByVideoSvrReq>
{
  public long a;
  public long b;
  public int c;
  public int d;
  public int e;
  public int f;
  public byte[] g;
  public byte[] h;
  public int i;
  public int j;
  
  public NotifyVideoArriveByVideoSvrReq()
  {
    a();
  }
  
  public NotifyVideoArriveByVideoSvrReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = WireFormatNano.EMPTY_BYTES;
    this.h = WireFormatNano.EMPTY_BYTES;
    this.i = 0;
    this.j = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public NotifyVideoArriveByVideoSvrReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int k = paramCodedInputByteBufferNano.readTag();
      switch (k)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, k)) {
          return this;
        }
        break;
      case 80: 
        this.j = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 72: 
        this.i = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 66: 
        this.h = paramCodedInputByteBufferNano.readBytes();
        break;
      case 58: 
        this.g = paramCodedInputByteBufferNano.readBytes();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt32();
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
    int m = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeUInt32Size(3, this.c) + CodedOutputByteBufferNano.computeUInt32Size(4, this.d) + CodedOutputByteBufferNano.computeUInt32Size(5, this.e);
    int n = this.f;
    int k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeUInt32Size(6, n);
    }
    n = k;
    if (!Arrays.equals(this.g, WireFormatNano.EMPTY_BYTES)) {
      n = k + CodedOutputByteBufferNano.computeBytesSize(7, this.g);
    }
    m = n;
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      m = n + CodedOutputByteBufferNano.computeBytesSize(8, this.h);
    }
    n = this.i;
    k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeUInt32Size(9, n);
    }
    n = this.j;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(10, n);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt64(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    paramCodedOutputByteBufferNano.writeUInt32(3, this.c);
    paramCodedOutputByteBufferNano.writeUInt32(4, this.d);
    paramCodedOutputByteBufferNano.writeUInt32(5, this.e);
    int k = this.f;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, k);
    }
    if (!Arrays.equals(this.g, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(7, this.g);
    }
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(8, this.h);
    }
    k = this.i;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, k);
    }
    k = this.j;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, k);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.NotifyVideoArriveByVideoSvrReq
 * JD-Core Version:    0.7.0.1
 */