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
    if (jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo == null) {
          jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo = new AuthInfo[0];
        }
      }
    }
    return jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo;
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
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 18)
        {
          if (i != 24)
          {
            if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
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
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int j = i;
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(1, this.jdField_a_of_type_JavaLangString);
    }
    i = j;
    if (!this.b.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    int k = this.jdField_a_of_type_Int;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(3, k);
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
    int i = this.jdField_a_of_type_Int;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.msfilivehead.AuthInfo
 * JD-Core Version:    0.7.0.1
 */