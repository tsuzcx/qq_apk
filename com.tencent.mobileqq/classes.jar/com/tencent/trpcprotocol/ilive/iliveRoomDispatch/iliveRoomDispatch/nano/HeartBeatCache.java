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
  public int a;
  public long a;
  public Map<Long, MsgString> a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  
  public HeartBeatCache()
  {
    a();
  }
  
  public HeartBeatCache a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    this.c = 0L;
    this.jdField_a_of_type_JavaUtilMap = null;
    this.d = 0L;
    this.e = 0L;
    this.jdField_a_of_type_Int = 0;
    this.f = 0L;
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
                      this.f = paramCodedInputByteBufferNano.readInt64();
                    }
                  }
                  else {
                    this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
                  }
                }
                else {
                  this.e = paramCodedInputByteBufferNano.readUInt64();
                }
              }
              else {
                this.d = paramCodedInputByteBufferNano.readInt64();
              }
            }
            else {
              this.jdField_a_of_type_JavaUtilMap = InternalNano.mergeMapEntry(paramCodedInputByteBufferNano, this.jdField_a_of_type_JavaUtilMap, localMapFactory, 4, 11, new MsgString(), 8, 18);
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
        this.jdField_a_of_type_Long = paramCodedInputByteBufferNano.readInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.jdField_a_of_type_Long;
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
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    j = i;
    if (localMap != null) {
      j = i + InternalNano.computeMapFieldSize(localMap, 4, 4, 11);
    }
    l = this.d;
    int k = j;
    if (l != 0L) {
      k = j + CodedOutputByteBufferNano.computeInt64Size(5, l);
    }
    l = this.e;
    i = k;
    if (l != 0L) {
      i = k + CodedOutputByteBufferNano.computeUInt64Size(6, l);
    }
    k = this.jdField_a_of_type_Int;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(7, k);
    }
    l = this.f;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(8, l);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.jdField_a_of_type_Long;
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
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      InternalNano.serializeMapField(paramCodedOutputByteBufferNano, localMap, 4, 4, 11);
    }
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(5, l);
    }
    l = this.e;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, l);
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i);
    }
    l = this.f;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(8, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.HeartBeatCache
 * JD-Core Version:    0.7.0.1
 */