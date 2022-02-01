package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class ExtData
  extends MessageNano
{
  public long a;
  public ExtDataInfo[] a;
  
  public ExtData()
  {
    a();
  }
  
  public ExtData a()
  {
    this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo = ExtDataInfo.a();
    this.jdField_a_of_type_Long = 0L;
    this.cachedSize = -1;
    return this;
  }
  
  public ExtData a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 10: 
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        if (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo == null) {}
        ExtDataInfo[] arrayOfExtDataInfo;
        for (i = 0;; i = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo.length)
        {
          arrayOfExtDataInfo = new ExtDataInfo[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo, 0, arrayOfExtDataInfo, 0, i);
            j = i;
          }
          while (j < arrayOfExtDataInfo.length - 1)
          {
            arrayOfExtDataInfo[j] = new ExtDataInfo();
            paramCodedInputByteBufferNano.readMessage(arrayOfExtDataInfo[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
        }
        arrayOfExtDataInfo[j] = new ExtDataInfo();
        paramCodedInputByteBufferNano.readMessage(arrayOfExtDataInfo[j]);
        this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo = arrayOfExtDataInfo;
        break;
      }
      this.jdField_a_of_type_Long = paramCodedInputByteBufferNano.readUInt64();
    }
  }
  
  public int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int j = i;
    if (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo != null)
    {
      j = i;
      if (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo.length > 0)
      {
        int k = 0;
        for (;;)
        {
          j = i;
          if (k >= this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo.length) {
            break;
          }
          ExtDataInfo localExtDataInfo = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo[k];
          j = i;
          if (localExtDataInfo != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(1, localExtDataInfo);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (this.jdField_a_of_type_Long != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(2, this.jdField_a_of_type_Long);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo != null) && (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo.length > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo.length)
      {
        ExtDataInfo localExtDataInfo = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataInfo[i];
        if (localExtDataInfo != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, localExtDataInfo);
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_Long != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, this.jdField_a_of_type_Long);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.ExtData
 * JD-Core Version:    0.7.0.1
 */