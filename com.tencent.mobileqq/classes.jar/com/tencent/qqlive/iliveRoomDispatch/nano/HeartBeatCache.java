package com.tencent.qqlive.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MapFactories.MapFactory;
import java.util.Map;

public final class HeartBeatCache
  extends ExtendableMessageNano<HeartBeatCache>
{
  public long a;
  public long b;
  public long c;
  public Map<Long, MsgString> d;
  public long e;
  public long f;
  public int g;
  public long h;
  public Map<String, Long> i;
  public String j;
  
  public HeartBeatCache()
  {
    a();
  }
  
  public HeartBeatCache a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = null;
    this.e = 0L;
    this.f = 0L;
    this.g = 0;
    this.h = 0L;
    this.i = null;
    this.j = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public HeartBeatCache a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    MapFactories.MapFactory localMapFactory = MapFactories.getMapFactory();
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
      case 82: 
        this.j = paramCodedInputByteBufferNano.readString();
        break;
      case 74: 
        this.i = InternalNano.mergeMapEntry(paramCodedInputByteBufferNano, this.i, localMapFactory, 9, 4, null, 10, 16);
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readInt64();
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readInt64();
        break;
      case 34: 
        this.d = InternalNano.mergeMapEntry(paramCodedInputByteBufferNano, this.d, localMapFactory, 4, 11, new MsgString(), 8, 18);
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int m = super.computeSerializedSize();
    long l = this.a;
    int k = m;
    if (l != 0L) {
      k = m + CodedOutputByteBufferNano.computeInt64Size(1, l);
    }
    l = this.b;
    m = k;
    if (l != 0L) {
      m = k + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    l = this.c;
    k = m;
    if (l != 0L) {
      k = m + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    Map localMap = this.d;
    m = k;
    if (localMap != null) {
      m = k + InternalNano.computeMapFieldSize(localMap, 4, 4, 11);
    }
    l = this.e;
    int n = m;
    if (l != 0L) {
      n = m + CodedOutputByteBufferNano.computeInt64Size(5, l);
    }
    l = this.f;
    k = n;
    if (l != 0L) {
      k = n + CodedOutputByteBufferNano.computeUInt64Size(6, l);
    }
    n = this.g;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(7, n);
    }
    l = this.h;
    k = m;
    if (l != 0L) {
      k = m + CodedOutputByteBufferNano.computeInt64Size(8, l);
    }
    localMap = this.i;
    m = k;
    if (localMap != null) {
      m = k + InternalNano.computeMapFieldSize(localMap, 9, 9, 4);
    }
    k = m;
    if (!this.j.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(10, this.j);
    }
    return k;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(1, l);
    }
    l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    Map localMap = this.d;
    if (localMap != null) {
      InternalNano.serializeMapField(paramCodedOutputByteBufferNano, localMap, 4, 4, 11);
    }
    l = this.e;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(5, l);
    }
    l = this.f;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, l);
    }
    int k = this.g;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, k);
    }
    l = this.h;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(8, l);
    }
    localMap = this.i;
    if (localMap != null) {
      InternalNano.serializeMapField(paramCodedOutputByteBufferNano, localMap, 9, 9, 4);
    }
    if (!this.j.equals("")) {
      paramCodedOutputByteBufferNano.writeString(10, this.j);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveRoomDispatch.nano.HeartBeatCache
 * JD-Core Version:    0.7.0.1
 */