package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class UserInfo
  extends MessageNano
{
  private static volatile UserInfo[] a;
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public UserInfo()
  {
    a();
  }
  
  public static UserInfo[] a()
  {
    if (jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo == null) {
        jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo = new UserInfo[0];
      }
      return jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoUserInfo;
    }
  }
  
  public UserInfo a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = 0L;
    this.c = "";
    this.d = "";
    this.e = "";
    this.cachedSize = -1;
    return this;
  }
  
  public UserInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 18: 
        this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 40: 
        this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 50: 
        this.jdField_b_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 56: 
        this.jdField_b_of_type_Long = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 66: 
        this.c = paramCodedInputByteBufferNano.readString();
        break;
      case 74: 
        this.d = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.e = paramCodedInputByteBufferNano.readString();
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
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.jdField_a_of_type_JavaLangString);
    }
    i = j;
    if (this.jdField_a_of_type_Int != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(5, this.jdField_a_of_type_Int);
    }
    j = i;
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(6, this.jdField_b_of_type_JavaLangString);
    }
    i = j;
    if (this.jdField_b_of_type_Long != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(7, this.jdField_b_of_type_Long);
    }
    j = i;
    if (!this.c.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(8, this.c);
    }
    i = j;
    if (!this.d.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(9, this.d);
    }
    j = i;
    if (!this.e.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(12, this.e);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.jdField_a_of_type_Long != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.jdField_a_of_type_Long);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, this.jdField_a_of_type_Int);
    }
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_b_of_type_Long != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, this.jdField_b_of_type_Long);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(8, this.c);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.d);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(12, this.e);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.UserInfo
 * JD-Core Version:    0.7.0.1
 */