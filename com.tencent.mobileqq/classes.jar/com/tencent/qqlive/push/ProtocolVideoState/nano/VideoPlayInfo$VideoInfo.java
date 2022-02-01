package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class VideoPlayInfo$VideoInfo
  extends ExtendableMessageNano<VideoInfo>
{
  private static volatile VideoInfo[] q;
  public int a;
  public long b;
  public long c;
  public int d;
  public VideoLiveInfo e;
  public int f;
  public int g;
  public byte[] h;
  public GameCircleVideoLiveInfo i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public int p;
  
  public VideoPlayInfo$VideoInfo()
  {
    b();
  }
  
  public static VideoInfo[] a()
  {
    if (q == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (q == null) {
          q = new VideoInfo[0];
        }
      }
    }
    return q;
  }
  
  public VideoInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 128: 
        this.p = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 120: 
        this.o = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 112: 
        this.n = paramCodedInputByteBufferNano.readUInt32();
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
          this.i = new GameCircleVideoLiveInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.i);
        break;
      case 66: 
        this.h = paramCodedInputByteBufferNano.readBytes();
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        i1 = paramCodedInputByteBufferNano.readInt32();
        if ((i1 == 1) || (i1 == 2)) {
          this.f = i1;
        }
        break;
      case 42: 
        if (this.e == null) {
          this.e = new VideoLiveInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.e);
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public VideoInfo b()
  {
    this.a = 0;
    this.b = 0L;
    this.c = 0L;
    this.d = 0;
    this.e = null;
    this.f = 1;
    this.g = 0;
    this.h = WireFormatNano.EMPTY_BYTES;
    this.i = null;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    this.n = 0;
    this.o = 0;
    this.p = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i1 = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a);
    long l1 = this.b;
    int i2 = i1;
    if (l1 != 0L) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt64Size(2, l1);
    }
    l1 = this.c;
    i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(3, l1);
    }
    int i3 = this.d;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(4, i3);
    }
    Object localObject = this.e;
    i3 = i2;
    if (localObject != null) {
      i3 = i2 + CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano)localObject);
    }
    i2 = this.f;
    i1 = i3;
    if (i2 != 1) {
      i1 = i3 + CodedOutputByteBufferNano.computeInt32Size(6, i2);
    }
    i3 = this.g;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(7, i3);
    }
    i1 = i2;
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      i1 = i2 + CodedOutputByteBufferNano.computeBytesSize(8, this.h);
    }
    localObject = this.i;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
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
    i3 = this.n;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(14, i3);
    }
    i3 = this.o;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(15, i3);
    }
    i3 = this.p;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(16, i3);
    }
    return i1;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    long l1 = this.b;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l1);
    }
    l1 = this.c;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l1);
    }
    int i1 = this.d;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i1);
    }
    Object localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(5, (MessageNano)localObject);
    }
    i1 = this.f;
    if (i1 != 1) {
      paramCodedOutputByteBufferNano.writeInt32(6, i1);
    }
    i1 = this.g;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i1);
    }
    if (!Arrays.equals(this.h, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(8, this.h);
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
    i1 = this.n;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(14, i1);
    }
    i1 = this.o;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(15, i1);
    }
    i1 = this.p;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(16, i1);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.VideoPlayInfo.VideoInfo
 * JD-Core Version:    0.7.0.1
 */