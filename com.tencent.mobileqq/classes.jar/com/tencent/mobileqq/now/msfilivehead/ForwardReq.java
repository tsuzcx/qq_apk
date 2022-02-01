package com.tencent.mobileqq.now.msfilivehead;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class ForwardReq
  extends MessageNano
{
  public int a;
  public long a;
  public String a;
  public byte[] a;
  public AuthInfo[] a;
  public int b;
  public long b;
  public String b;
  public byte[] b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public int g;
  
  public ForwardReq()
  {
    a();
  }
  
  public ForwardReq a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfByte = WireFormatNano.EMPTY_BYTES;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "";
    this.f = 0;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo = AuthInfo.a();
    this.jdField_b_of_type_ArrayOfByte = WireFormatNano.EMPTY_BYTES;
    this.g = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public ForwardReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 16: 
        this.jdField_b_of_type_Long = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 26: 
        this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 32: 
        this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 42: 
        this.jdField_b_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 50: 
        this.jdField_a_of_type_ArrayOfByte = paramCodedInputByteBufferNano.readBytes();
        break;
      case 56: 
        this.jdField_b_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.jdField_c_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 74: 
        this.jdField_c_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 82: 
        this.jdField_d_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 88: 
        this.jdField_d_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 96: 
        this.jdField_e_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 106: 
        this.jdField_e_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 112: 
        this.f = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 122: 
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 122);
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo == null) {}
        AuthInfo[] arrayOfAuthInfo;
        for (i = 0;; i = this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo.length)
        {
          arrayOfAuthInfo = new AuthInfo[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo, 0, arrayOfAuthInfo, 0, i);
            j = i;
          }
          while (j < arrayOfAuthInfo.length - 1)
          {
            arrayOfAuthInfo[j] = new AuthInfo();
            paramCodedInputByteBufferNano.readMessage(arrayOfAuthInfo[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
        }
        arrayOfAuthInfo[j] = new AuthInfo();
        paramCodedInputByteBufferNano.readMessage(arrayOfAuthInfo[j]);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo = arrayOfAuthInfo;
        break;
      case 130: 
        this.jdField_b_of_type_ArrayOfByte = paramCodedInputByteBufferNano.readBytes();
        break;
      }
      this.g = paramCodedInputByteBufferNano.readUInt32();
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
    if (this.jdField_b_of_type_Long != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, this.jdField_b_of_type_Long);
    }
    i = j;
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.jdField_a_of_type_JavaLangString);
    }
    j = i;
    if (this.jdField_a_of_type_Int != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, this.jdField_a_of_type_Int);
    }
    i = j;
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(5, this.jdField_b_of_type_JavaLangString);
    }
    j = i;
    if (!Arrays.equals(this.jdField_a_of_type_ArrayOfByte, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(6, this.jdField_a_of_type_ArrayOfByte);
    }
    i = j;
    if (this.jdField_b_of_type_Int != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(7, this.jdField_b_of_type_Int);
    }
    j = i;
    if (this.jdField_c_of_type_Int != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(8, this.jdField_c_of_type_Int);
    }
    i = j;
    if (!this.jdField_c_of_type_JavaLangString.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(9, this.jdField_c_of_type_JavaLangString);
    }
    j = i;
    if (!this.jdField_d_of_type_JavaLangString.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(10, this.jdField_d_of_type_JavaLangString);
    }
    i = j;
    if (this.jdField_d_of_type_Int != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(11, this.jdField_d_of_type_Int);
    }
    j = i;
    if (this.jdField_e_of_type_Int != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(12, this.jdField_e_of_type_Int);
    }
    int k = j;
    if (!this.jdField_e_of_type_JavaLangString.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(13, this.jdField_e_of_type_JavaLangString);
    }
    i = k;
    if (this.f != 0) {
      i = k + CodedOutputByteBufferNano.computeUInt32Size(14, this.f);
    }
    j = i;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo != null)
    {
      j = i;
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo.length > 0)
      {
        j = 0;
        while (j < this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo.length)
        {
          AuthInfo localAuthInfo = this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo[j];
          k = i;
          if (localAuthInfo != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(15, localAuthInfo);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (!Arrays.equals(this.jdField_b_of_type_ArrayOfByte, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(16, this.jdField_b_of_type_ArrayOfByte);
    }
    j = i;
    if (this.g != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(17, this.g);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.jdField_a_of_type_Long != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.jdField_a_of_type_Long);
    }
    if (this.jdField_b_of_type_Long != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, this.jdField_b_of_type_Long);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, this.jdField_a_of_type_Int);
    }
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.jdField_b_of_type_JavaLangString);
    }
    if (!Arrays.equals(this.jdField_a_of_type_ArrayOfByte, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(6, this.jdField_a_of_type_ArrayOfByte);
    }
    if (this.jdField_b_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, this.jdField_b_of_type_Int);
    }
    if (this.jdField_c_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, this.jdField_c_of_type_Int);
    }
    if (!this.jdField_c_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.jdField_c_of_type_JavaLangString);
    }
    if (!this.jdField_d_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(10, this.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_d_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, this.jdField_d_of_type_Int);
    }
    if (this.jdField_e_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(12, this.jdField_e_of_type_Int);
    }
    if (!this.jdField_e_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(13, this.jdField_e_of_type_JavaLangString);
    }
    if (this.f != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(14, this.f);
    }
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo.length > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo.length)
      {
        AuthInfo localAuthInfo = this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo[i];
        if (localAuthInfo != null) {
          paramCodedOutputByteBufferNano.writeMessage(15, localAuthInfo);
        }
        i += 1;
      }
    }
    if (!Arrays.equals(this.jdField_b_of_type_ArrayOfByte, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(16, this.jdField_b_of_type_ArrayOfByte);
    }
    if (this.g != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(17, this.g);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.msfilivehead.ForwardReq
 * JD-Core Version:    0.7.0.1
 */