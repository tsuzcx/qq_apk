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
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 18)
        {
          if (i != 26)
          {
            if (i != 32)
            {
              if (i != 40)
              {
                if (i != 48)
                {
                  if (i != 58)
                  {
                    if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else {
                    this.jdField_b_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
                  }
                }
                else {
                  this.d = paramCodedInputByteBufferNano.readUInt32();
                }
              }
              else {
                this.c = paramCodedInputByteBufferNano.readUInt32();
              }
            }
            else {
              this.jdField_b_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
            }
          }
          else {
            this.jdField_a_of_type_ArrayOfByte = paramCodedInputByteBufferNano.readBytes();
          }
        }
        else {
          this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.jdField_a_of_type_Int;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    k = i;
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      k = i + CodedOutputByteBufferNano.computeStringSize(2, this.jdField_a_of_type_JavaLangString);
    }
    j = k;
    if (!Arrays.equals(this.jdField_a_of_type_ArrayOfByte, WireFormatNano.EMPTY_BYTES)) {
      j = k + CodedOutputByteBufferNano.computeBytesSize(3, this.jdField_a_of_type_ArrayOfByte);
    }
    k = this.jdField_b_of_type_Int;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    k = this.c;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    k = this.d;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(6, k);
    }
    j = i;
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(7, this.jdField_b_of_type_JavaLangString);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.jdField_a_of_type_JavaLangString);
    }
    if (!Arrays.equals(this.jdField_a_of_type_ArrayOfByte, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(3, this.jdField_a_of_type_ArrayOfByte);
    }
    i = this.jdField_b_of_type_Int;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, i);
    }
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.jdField_b_of_type_JavaLangString);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.msfilivehead.ForwardRsp
 * JD-Core Version:    0.7.0.1
 */