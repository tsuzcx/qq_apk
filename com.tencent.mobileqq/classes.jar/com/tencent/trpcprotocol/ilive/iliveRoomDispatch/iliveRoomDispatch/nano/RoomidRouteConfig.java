package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class RoomidRouteConfig
  extends MessageNano
{
  private static volatile RoomidRouteConfig[] a;
  public String a;
  public long[] a;
  public String b;
  
  public RoomidRouteConfig()
  {
    a();
  }
  
  public static RoomidRouteConfig[] a()
  {
    if (jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig == null) {
          jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig = new RoomidRouteConfig[0];
        }
      }
    }
    return jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig;
  }
  
  public RoomidRouteConfig a()
  {
    this.jdField_a_of_type_ArrayOfLong = WireFormatNano.EMPTY_LONG_ARRAY;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
    this.cachedSize = -1;
    return this;
  }
  
  public RoomidRouteConfig a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      int j;
      long[] arrayOfLong;
      if (i != 8)
      {
        if (i != 10)
        {
          if (i != 18)
          {
            if (i != 26)
            {
              if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.b = paramCodedInputByteBufferNano.readString();
            }
          }
          else {
            this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
          }
        }
        else
        {
          int k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
          i = paramCodedInputByteBufferNano.getPosition();
          j = 0;
          while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
          {
            paramCodedInputByteBufferNano.readUInt64();
            j += 1;
          }
          paramCodedInputByteBufferNano.rewindToPosition(i);
          arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
          if (arrayOfLong == null) {
            i = 0;
          } else {
            i = arrayOfLong.length;
          }
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
          this.jdField_a_of_type_ArrayOfLong = arrayOfLong;
          paramCodedInputByteBufferNano.popLimit(k);
        }
      }
      else
      {
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 8);
        arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
        if (arrayOfLong == null) {
          i = 0;
        } else {
          i = arrayOfLong.length;
        }
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
        arrayOfLong[j] = paramCodedInputByteBufferNano.readUInt64();
        this.jdField_a_of_type_ArrayOfLong = arrayOfLong;
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize();
    long[] arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
    int i = k;
    if (arrayOfLong != null)
    {
      i = k;
      if (arrayOfLong.length > 0)
      {
        i = 0;
        j = 0;
        for (;;)
        {
          arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
          if (i >= arrayOfLong.length) {
            break;
          }
          j += CodedOutputByteBufferNano.computeUInt64SizeNoTag(arrayOfLong[i]);
          i += 1;
        }
        i = k + j + arrayOfLong.length * 1;
      }
    }
    int j = i;
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.jdField_a_of_type_JavaLangString);
    }
    i = j;
    if (!this.b.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.b);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long[] arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      int i = 0;
      for (;;)
      {
        arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
        if (i >= arrayOfLong.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeUInt64(1, arrayOfLong[i]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.RoomidRouteConfig
 * JD-Core Version:    0.7.0.1
 */