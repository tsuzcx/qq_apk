package com.tencent.mobileqq.now.msfilivehead;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class ForwardRsp
  extends MessageNano
{
  public int a;
  public String a;
  public byte[] a;
  public int b;
  public String b;
  public int c;
  public int d;
  
  public ForwardRsp()
  {
    a();
  }
  
  public static ForwardRsp a(byte[] paramArrayOfByte)
  {
    return (ForwardRsp)MessageNano.mergeFrom(new ForwardRsp(), paramArrayOfByte);
  }
  
  public ForwardRsp a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfByte = WireFormatNano.EMPTY_BYTES;
    this.jdField_b_of_type_Int = 0;
    this.c = 0;
    this.d = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.cachedSize = -1;
    return this;
  }
  
  public ForwardRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 26: 
        this.jdField_a_of_type_ArrayOfByte = paramCodedInputByteBufferNano.readBytes();
        break;
      case 32: 
        this.jdField_b_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.c = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
        break;
      }
      this.jdField_b_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
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
    if (!Arrays.equals(this.jdField_a_of_type_ArrayOfByte, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(3, this.jdField_a_of_type_ArrayOfByte);
    }
    j = i;
    if (this.jdField_b_of_type_Int != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, this.jdField_b_of_type_Int);
    }
    i = j;
    if (this.c != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(5, this.c);
    }
    j = i;
    if (this.d != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(6, this.d);
    }
    i = j;
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(7, this.jdField_b_of_type_JavaLangString);
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
    if (!Arrays.equals(this.jdField_a_of_type_ArrayOfByte, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.jdField_a_of_type_ArrayOfByte);
    }
    if (this.jdField_b_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, this.jdField_b_of_type_Int);
    }
    if (this.c != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, this.c);
    }
    if (this.d != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, this.d);
    }
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.jdField_b_of_type_JavaLangString);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.msfilivehead.ForwardRsp
 * JD-Core Version:    0.7.0.1
 */