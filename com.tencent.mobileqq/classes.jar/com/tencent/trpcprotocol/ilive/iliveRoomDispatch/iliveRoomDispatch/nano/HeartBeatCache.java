package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MapFactories.MapFactory;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Map;

public final class HeartBeatCache
  extends MessageNano
{
  public long a;
  public long b;
  public long c;
  public Map<Long, MsgString> d;
  public long e;
  public long f;
  public int g;
  public long h;
  
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
    this.cachedSize = -1;
    return this;
  }
  
  public HeartBeatCache a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    MapFactories.MapFactory localMapFactory = MapFactories.getMapFactory();
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 16)
        {
          if (i != 24)
          {
            if (i != 34)
            {
              if (i != 40)
              {
                if (i != 48)
                {
                  if (i != 56)
                  {
                    if (i != 64)
                    {
                      if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                        return this;
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readInt64();
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readUInt32();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt64();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readInt64();
              }
            }
            else {
              this.d = InternalNano.mergeMapEntry(paramCodedInputByteBufferNano, this.d, localMapFactory, 4, 11, new MsgString(), 8, 18);
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt64();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.a;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(1, l);
    }
    l = this.b;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    l = this.c;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    Map localMap = this.d;
    j = i;
    if (localMap != null) {
      j = i + InternalNano.computeMapFieldSize(localMap, 4, 4, 11);
    }
    l = this.e;
    int k = j;
    if (l != 0L) {
      k = j + CodedOutputByteBufferNano.computeInt64Size(5, l);
    }
    l = this.f;
    i = k;
    if (l != 0L) {
      i = k + CodedOutputByteBufferNano.computeUInt64Size(6, l);
    }
    k = this.g;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(7, k);
    }
    l = this.h;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(8, l);
    }
    return i;
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
    int i = this.g;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i);
    }
    l = this.h;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(8, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.HeartBeatCache
 * JD-Core Version:    0.7.0.1
 */