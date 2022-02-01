package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class AuthInfo
  extends MessageNano
{
  public int a;
  public long a;
  public String a;
  
  public AuthInfo()
  {
    a();
  }
  
  public AuthInfo a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.cachedSize = -1;
    return this;
  }
  
  public AuthInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 18: 
        this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.jdField_a_of_type_Long = paramCodedInputByteBufferNano.readUInt64();
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.jdField_a_of_type_Int != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, this.jdField_a_of_type_Int);
    }
    j = i;
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.jdField_a_of_type_JavaLangString);
    }
    i = j;
    if (this.jdField_a_of_type_Long != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, this.jdField_a_of_type_Long);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.jdField_a_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.jdField_a_of_type_Int);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Long != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, this.jdField_a_of_type_Long);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.AuthInfo
 * JD-Core Version:    0.7.0.1
 */