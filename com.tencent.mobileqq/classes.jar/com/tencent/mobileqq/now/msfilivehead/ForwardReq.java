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
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
        break;
      case 136: 
        this.g = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 130: 
        this.jdField_b_of_type_ArrayOfByte = paramCodedInputByteBufferNano.readBytes();
        break;
      case 122: 
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 122);
        AuthInfo[] arrayOfAuthInfo = this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo;
        if (arrayOfAuthInfo == null) {
          i = 0;
        } else {
          i = arrayOfAuthInfo.length;
        }
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
        arrayOfAuthInfo[j] = new AuthInfo();
        paramCodedInputByteBufferNano.readMessage(arrayOfAuthInfo[j]);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo = arrayOfAuthInfo;
        break;
      case 112: 
        this.f = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 106: 
        this.jdField_e_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 96: 
        this.jdField_e_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 88: 
        this.jdField_d_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 82: 
        this.jdField_d_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 74: 
        this.jdField_c_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 64: 
        this.jdField_c_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 56: 
        this.jdField_b_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 50: 
        this.jdField_a_of_type_ArrayOfByte = paramCodedInputByteBufferNano.readBytes();
        break;
      case 42: 
        this.jdField_b_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 32: 
        this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 26: 
        this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 16: 
        this.jdField_b_of_type_Long = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 8: 
        this.jdField_a_of_type_Long = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.jdField_a_of_type_Long;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    l = this.jdField_b_of_type_Long;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    i = j;
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.jdField_a_of_type_JavaLangString);
    }
    int k = this.jdField_a_of_type_Int;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    i = j;
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(5, this.jdField_b_of_type_JavaLangString);
    }
    j = i;
    if (!Arrays.equals(this.jdField_a_of_type_ArrayOfByte, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(6, this.jdField_a_of_type_ArrayOfByte);
    }
    k = this.jdField_b_of_type_Int;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(7, k);
    }
    k = this.jdField_c_of_type_Int;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(8, k);
    }
    i = j;
    if (!this.jdField_c_of_type_JavaLangString.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(9, this.jdField_c_of_type_JavaLangString);
    }
    j = i;
    if (!this.jdField_d_of_type_JavaLangString.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(10, this.jdField_d_of_type_JavaLangString);
    }
    k = this.jdField_d_of_type_Int;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(11, k);
    }
    k = this.jdField_e_of_type_Int;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(12, k);
    }
    k = j;
    if (!this.jdField_e_of_type_JavaLangString.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(13, this.jdField_e_of_type_JavaLangString);
    }
    j = this.f;
    i = k;
    if (j != 0) {
      i = k + CodedOutputByteBufferNano.computeUInt32Size(14, j);
    }
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(15, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (!Arrays.equals(this.jdField_b_of_type_ArrayOfByte, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(16, this.jdField_b_of_type_ArrayOfByte);
    }
    k = this.g;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(17, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.jdField_a_of_type_Long;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    l = this.jdField_b_of_type_Long;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.jdField_a_of_type_JavaLangString);
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.jdField_b_of_type_JavaLangString);
    }
    if (!Arrays.equals(this.jdField_a_of_type_ArrayOfByte, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(6, this.jdField_a_of_type_ArrayOfByte);
    }
    i = this.jdField_b_of_type_Int;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i);
    }
    i = this.jdField_c_of_type_Int;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i);
    }
    if (!this.jdField_c_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.jdField_c_of_type_JavaLangString);
    }
    if (!this.jdField_d_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(10, this.jdField_d_of_type_JavaLangString);
    }
    i = this.jdField_d_of_type_Int;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, i);
    }
    i = this.jdField_e_of_type_Int;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(12, i);
    }
    if (!this.jdField_e_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(13, this.jdField_e_of_type_JavaLangString);
    }
    i = this.f;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(14, i);
    }
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqNowMsfiliveheadAuthInfo;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(15, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if (!Arrays.equals(this.jdField_b_of_type_ArrayOfByte, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(16, this.jdField_b_of_type_ArrayOfByte);
    }
    i = this.g;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(17, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.msfilivehead.ForwardReq
 * JD-Core Version:    0.7.0.1
 */