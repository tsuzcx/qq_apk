package com.tencent.mobileqq.now.msfilivehead;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class AuthInfo
  extends MessageNano
{
  private static volatile AuthInfo[] a;
  public int a;
  public String a;
  public String b;
  
  public AuthInfo()
  {
    a();
  }
  
  public static AuthInfo[] a()
  {
    if (jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo == null) {
        jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo = new AuthInfo[0];
      }
      return jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo;
    }
  }
  
  public AuthInfo a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
    this.jdField_a_of_type_Int = 0;
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
      case 10: 
        this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 18: 
        this.b = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
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
    i = j;
    if (this.jdField_a_of_type_Int != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(3, this.jdField_a_of_type_Int);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.jdField_a_of_type_JavaLangString);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    if (this.jdField_a_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, this.jdField_a_of_type_Int);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.msfilivehead.AuthInfo
 * JD-Core Version:    0.7.0.1
 */