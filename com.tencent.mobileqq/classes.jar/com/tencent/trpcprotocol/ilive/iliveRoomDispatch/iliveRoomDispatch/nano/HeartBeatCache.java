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
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        this.jdField_a_of_type_Long = paramCodedInputByteBufferNano.readInt64();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 34: 
        this.jdField_a_of_type_JavaUtilMap = InternalNano.mergeMapEntry(paramCodedInputByteBufferNano, this.jdField_a_of_type_JavaUtilMap, localMapFactory, 4, 11, new MsgString(), 8, 18);
        break;
      case 40: 
        this.d = paramCodedInputByteBufferNano.readInt64();
        break;
      case 48: 
        this.e = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 56: 
        this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.f = paramCodedInputByteBufferNano.readInt64();
      }
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.jdField_a_of_type_Long != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(1, this.jdField_a_of_type_Long);
    }
    j = i;
    if (this.b != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, this.b);
    }
    i = j;
    if (this.c != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, this.c);
    }
    j = i;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      j = i + InternalNano.computeMapFieldSize(this.jdField_a_of_type_JavaUtilMap, 4, 4, 11);
    }
    i = j;
    if (this.d != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(5, this.d);
    }
    j = i;
    if (this.e != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(6, this.e);
    }
    i = j;
    if (this.jdField_a_of_type_Int != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(7, this.jdField_a_of_type_Int);
    }
    j = i;
    if (this.f != 0L) {
      j = i + CodedOutputByteBufferNano.computeInt64Size(8, this.f);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.jdField_a_of_type_Long != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(1, this.jdField_a_of_type_Long);
    }
    if (this.b != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, this.b);
    }
    if (this.c != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, this.c);
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      InternalNano.serializeMapField(paramCodedOutputByteBufferNano, this.jdField_a_of_type_JavaUtilMap, 4, 4, 11);
    }
    if (this.d != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(5, this.d);
    }
    if (this.e != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, this.e);
    }
    if (this.jdField_a_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, this.jdField_a_of_type_Int);
    }
    if (this.f != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(8, this.f);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.HeartBeatCache
 * JD-Core Version:    0.7.0.1
 */