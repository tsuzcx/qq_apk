package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class AppidRouteConfig
  extends MessageNano
{
  private static volatile AppidRouteConfig[] a;
  public String a;
  public long[] a;
  public String b;
  
  public AppidRouteConfig()
  {
    a();
  }
  
  public static AppidRouteConfig[] a()
  {
    if (jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig == null) {
        jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig = new AppidRouteConfig[0];
      }
      return jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig;
    }
  }
  
  public AppidRouteConfig a()
  {
    this.jdField_a_of_type_ArrayOfLong = WireFormatNano.EMPTY_LONG_ARRAY;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
    this.cachedSize = -1;
    return this;
  }
  
  public AppidRouteConfig a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      int j;
      long[] arrayOfLong;
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 8);
        if (this.jdField_a_of_type_ArrayOfLong == null) {}
        for (i = 0;; i = this.jdField_a_of_type_ArrayOfLong.length)
        {
          arrayOfLong = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.jdField_a_of_type_ArrayOfLong, 0, arrayOfLong, 0, i);
            j = i;
          }
          while (j < arrayOfLong.length - 1)
          {
            arrayOfLong[j] = paramCodedInputByteBufferNano.readUInt64();
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
        }
        arrayOfLong[j] = paramCodedInputByteBufferNano.readUInt64();
        this.jdField_a_of_type_ArrayOfLong = arrayOfLong;
        break;
      case 10: 
        int k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
        i = paramCodedInputByteBufferNano.getPosition();
        j = 0;
        while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
        {
          paramCodedInputByteBufferNano.readUInt64();
          j += 1;
        }
        paramCodedInputByteBufferNano.rewindToPosition(i);
        if (this.jdField_a_of_type_ArrayOfLong == null) {}
        for (i = 0;; i = this.jdField_a_of_type_ArrayOfLong.length)
        {
          arrayOfLong = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.jdField_a_of_type_ArrayOfLong, 0, arrayOfLong, 0, i);
            j = i;
          }
          while (j < arrayOfLong.length)
          {
            arrayOfLong[j] = paramCodedInputByteBufferNano.readUInt64();
            j += 1;
          }
        }
        this.jdField_a_of_type_ArrayOfLong = arrayOfLong;
        paramCodedInputByteBufferNano.popLimit(k);
        break;
      case 18: 
        this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.b = paramCodedInputByteBufferNano.readString();
    }
  }
  
  public int computeSerializedSize()
  {
    int i = 0;
    int k = super.computeSerializedSize();
    if ((this.jdField_a_of_type_ArrayOfLong != null) && (this.jdField_a_of_type_ArrayOfLong.length > 0))
    {
      j = 0;
      while (i < this.jdField_a_of_type_ArrayOfLong.length)
      {
        j += CodedOutputByteBufferNano.computeUInt64SizeNoTag(this.jdField_a_of_type_ArrayOfLong[i]);
        i += 1;
      }
    }
    for (int j = k + j + this.jdField_a_of_type_ArrayOfLong.length * 1;; j = k)
    {
      i = j;
      if (!this.jdField_a_of_type_JavaLangString.equals("")) {
        i = j + CodedOutputByteBufferNano.computeStringSize(2, this.jdField_a_of_type_JavaLangString);
      }
      j = i;
      if (!this.b.equals("")) {
        j = i + CodedOutputByteBufferNano.computeStringSize(3, this.b);
      }
      return j;
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.jdField_a_of_type_ArrayOfLong != null) && (this.jdField_a_of_type_ArrayOfLong.length > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLong.length)
      {
        paramCodedOutputByteBufferNano.writeUInt64(1, this.jdField_a_of_type_ArrayOfLong[i]);
        i += 1;
      }
    }
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.jdField_a_of_type_JavaLangString);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.b);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.AppidRouteConfig
 * JD-Core Version:    0.7.0.1
 */