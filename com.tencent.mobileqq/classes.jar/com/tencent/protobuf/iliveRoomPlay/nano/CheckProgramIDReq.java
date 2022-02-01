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
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new CheckProgramIDReq[0];
      }
      return _emptyArray;
    }
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
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.uid != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, this.uid);
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
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.uid = paramCodedInputByteBufferNano.readUInt64();
        break;
      }
      this.programId = paramCodedInputByteBufferNano.readString();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.uid != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.uid);
    }
    if (!this.programId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.programId);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.CheckProgramIDReq
 * JD-Core Version:    0.7.0.1
 */