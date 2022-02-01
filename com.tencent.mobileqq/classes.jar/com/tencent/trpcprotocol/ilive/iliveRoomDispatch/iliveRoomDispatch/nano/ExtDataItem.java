package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class ExtDataItem
  extends MessageNano
{
  private static volatile ExtDataItem[] a;
  public String a;
  public String b;
  
  public ExtDataItem()
  {
    a();
  }
  
  public static ExtDataItem[] a()
  {
    if (jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem == null) {
        jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem = new ExtDataItem[0];
      }
      return jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoExtDataItem;
    }
  }
  
  public ExtDataItem a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
    this.cachedSize = -1;
    return this;
  }
  
  public ExtDataItem a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.b = paramCodedInputByteBufferNano.readString();
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.jdField_a_of_type_JavaLangString);
    }
    j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.jdField_a_of_type_JavaLangString);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.ExtDataItem
 * JD-Core Version:    0.7.0.1
 */