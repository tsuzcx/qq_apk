package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class EnterRoomReq
  extends MessageNano
{
  public long a;
  public String a;
  public String b;
  public String c;
  
  public EnterRoomReq()
  {
    a();
  }
  
  public EnterRoomReq a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
    this.c = "";
    this.cachedSize = -1;
    return this;
  }
  
  public EnterRoomReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 26: 
        this.b = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.c = paramCodedInputByteBufferNano.readString();
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
    if (!this.b.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.b);
    }
    j = i;
    if (!this.c.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.c);
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
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.b);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.c);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.EnterRoomReq
 * JD-Core Version:    0.7.0.1
 */