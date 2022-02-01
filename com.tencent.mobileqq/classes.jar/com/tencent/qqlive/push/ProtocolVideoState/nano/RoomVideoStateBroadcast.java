package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class RoomVideoStateBroadcast
  extends ExtendableMessageNano<RoomVideoStateBroadcast>
{
  public long a;
  public long b;
  public int c;
  public int d;
  public int e;
  public VideoLiveInfo f;
  public int g;
  public int h;
  public byte[] i;
  public int j;
  public String k;
  
  public RoomVideoStateBroadcast()
  {
    a();
  }
  
  public static RoomVideoStateBroadcast a(byte[] paramArrayOfByte)
  {
    return (RoomVideoStateBroadcast)MessageNano.mergeFrom(new RoomVideoStateBroadcast(), paramArrayOfByte);
  }
  
  public RoomVideoStateBroadcast a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = null;
    this.g = 0;
    this.h = 0;
    this.i = WireFormatNano.EMPTY_BYTES;
    this.j = 0;
    this.k = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public RoomVideoStateBroadcast a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 90: 
        this.k = paramCodedInputByteBufferNano.readString();
        break;
      case 80: 
        this.j = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 74: 
        this.i = paramCodedInputByteBufferNano.readBytes();
        break;
      case 64: 
        m = paramCodedInputByteBufferNano.readInt32();
        if ((m == 0) || (m == 10)) {
          this.h = m;
        }
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 50: 
        if (this.f == null) {
          this.f = new VideoLiveInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.f);
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readInt32();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readInt32();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readInt32();
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
    int m = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeInt32Size(3, this.c) + CodedOutputByteBufferNano.computeInt32Size(4, this.d) + CodedOutputByteBufferNano.computeInt32Size(5, this.e);
    VideoLiveInfo localVideoLiveInfo = this.f;
    int n = m;
    if (localVideoLiveInfo != null) {
      n = m + CodedOutputByteBufferNano.computeMessageSize(6, localVideoLiveInfo);
    }
    int i1 = this.g;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(7, i1);
    }
    i1 = this.h;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeInt32Size(8, i1);
    }
    m = n;
    if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
      m = n + CodedOutputByteBufferNano.computeBytesSize(9, this.i);
    }
    i1 = this.j;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(10, i1);
    }
    m = n;
    if (!this.k.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(11, this.k);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt64(1, this.a);
    paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    paramCodedOutputByteBufferNano.writeInt32(3, this.c);
    paramCodedOutputByteBufferNano.writeInt32(4, this.d);
    paramCodedOutputByteBufferNano.writeInt32(5, this.e);
    VideoLiveInfo localVideoLiveInfo = this.f;
    if (localVideoLiveInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(6, localVideoLiveInfo);
    }
    int m = this.g;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, m);
    }
    m = this.h;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeInt32(8, m);
    }
    if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(9, this.i);
    }
    m = this.j;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, m);
    }
    if (!this.k.equals("")) {
      paramCodedOutputByteBufferNano.writeString(11, this.k);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.RoomVideoStateBroadcast
 * JD-Core Version:    0.7.0.1
 */