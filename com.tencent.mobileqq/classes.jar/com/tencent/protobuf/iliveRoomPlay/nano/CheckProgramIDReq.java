package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class CheckProgramIDReq
  extends MessageNano
{
  private static volatile CheckProgramIDReq[] _emptyArray;
  public String programId;
  public long uid;
  
  public CheckProgramIDReq()
  {
    clear();
  }
  
  public static CheckProgramIDReq[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new CheckProgramIDReq[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static CheckProgramIDReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new CheckProgramIDReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static CheckProgramIDReq parseFrom(byte[] paramArrayOfByte)
  {
    return (CheckProgramIDReq)MessageNano.mergeFrom(new CheckProgramIDReq(), paramArrayOfByte);
  }
  
  public CheckProgramIDReq clear()
  {
    this.uid = 0L;
    this.programId = "";
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.uid;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    j = i;
    if (!this.programId.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.programId);
    }
    return j;
  }
  
  public CheckProgramIDReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.programId = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.uid = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.uid;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    if (!this.programId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.programId);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.CheckProgramIDReq
 * JD-Core Version:    0.7.0.1
 */