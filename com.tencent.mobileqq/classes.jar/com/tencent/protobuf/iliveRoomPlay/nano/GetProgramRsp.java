package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetProgramRsp
  extends MessageNano
{
  private static volatile GetProgramRsp[] _emptyArray;
  public ProgramInfo info;
  public String msg;
  public String programId;
  public int ret;
  
  public GetProgramRsp()
  {
    clear();
  }
  
  public static GetProgramRsp[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new GetProgramRsp[0];
      }
      return _emptyArray;
    }
  }
  
  public static GetProgramRsp parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new GetProgramRsp().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static GetProgramRsp parseFrom(byte[] paramArrayOfByte)
  {
    return (GetProgramRsp)MessageNano.mergeFrom(new GetProgramRsp(), paramArrayOfByte);
  }
  
  public GetProgramRsp clear()
  {
    this.ret = 0;
    this.msg = "";
    this.info = null;
    this.programId = "";
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.ret != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, this.ret);
    }
    j = i;
    if (!this.msg.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.msg);
    }
    i = j;
    if (this.info != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, this.info);
    }
    j = i;
    if (!this.programId.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.programId);
    }
    return j;
  }
  
  public GetProgramRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.ret = paramCodedInputByteBufferNano.readInt32();
        break;
      case 18: 
        this.msg = paramCodedInputByteBufferNano.readString();
        break;
      case 26: 
        if (this.info == null) {
          this.info = new ProgramInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.info);
        break;
      }
      this.programId = paramCodedInputByteBufferNano.readString();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.ret != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, this.ret);
    }
    if (!this.msg.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.msg);
    }
    if (this.info != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, this.info);
    }
    if (!this.programId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.programId);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.GetProgramRsp
 * JD-Core Version:    0.7.0.1
 */