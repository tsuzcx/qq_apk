package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetProgramReq
  extends MessageNano
{
  private static volatile GetProgramReq[] _emptyArray;
  public String programId;
  
  public GetProgramReq()
  {
    clear();
  }
  
  public static GetProgramReq[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new GetProgramReq[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static GetProgramReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new GetProgramReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static GetProgramReq parseFrom(byte[] paramArrayOfByte)
  {
    return (GetProgramReq)MessageNano.mergeFrom(new GetProgramReq(), paramArrayOfByte);
  }
  
  public GetProgramReq clear()
  {
    this.programId = "";
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.programId.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.programId);
    }
    return i;
  }
  
  public GetProgramReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
      }
      else {
        this.programId = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.programId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.programId);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.GetProgramReq
 * JD-Core Version:    0.7.0.1
 */