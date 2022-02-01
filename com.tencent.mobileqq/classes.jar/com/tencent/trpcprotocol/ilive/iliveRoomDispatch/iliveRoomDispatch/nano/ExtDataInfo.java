package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class ExtDataInfo
  extends MessageNano
{
  private static volatile ExtDataInfo[] a;
  public long a;
  public ExtDataItem[] a;
  
  public ExtDataInfo()
  {
    a();
  }
  
  public static ExtDataInfo[] a()
  {
    if (jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo == null) {
        jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo = new ExtDataInfo[0];
      }
      return jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo;
    }
  }
  
  public ExtDataInfo a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem = ExtDataItem.a();
    this.cachedSize = -1;
    return this;
  }
  
  public ExtDataInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.jdField_a_of_type_Long = paramCodedInputByteBufferNano.readUInt64();
        break;
      }
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
      if (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem == null) {}
      ExtDataItem[] arrayOfExtDataItem;
      for (i = 0;; i = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem.length)
      {
        arrayOfExtDataItem = new ExtDataItem[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem, 0, arrayOfExtDataItem, 0, i);
          j = i;
        }
        while (j < arrayOfExtDataItem.length - 1)
        {
          arrayOfExtDataItem[j] = new ExtDataItem();
          paramCodedInputByteBufferNano.readMessage(arrayOfExtDataItem[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
      }
      arrayOfExtDataItem[j] = new ExtDataItem();
      paramCodedInputByteBufferNano.readMessage(arrayOfExtDataItem[j]);
      this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem = arrayOfExtDataItem;
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.jdField_a_of_type_Long != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, this.jdField_a_of_type_Long);
    }
    j = i;
    if (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem != null)
    {
      j = i;
      if (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem.length > 0)
      {
        j = 0;
        while (j < this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem.length)
        {
          ExtDataItem localExtDataItem = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem[j];
          int k = i;
          if (localExtDataItem != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(2, localExtDataItem);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.jdField_a_of_type_Long != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.jdField_a_of_type_Long);
    }
    if ((this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem != null) && (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem.length > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem.length)
      {
        ExtDataItem localExtDataItem = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem[i];
        if (localExtDataItem != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, localExtDataItem);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.ExtDataInfo
 * JD-Core Version:    0.7.0.1
 */