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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new GetProgramRsp[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.ret;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    j = i;
    if (!this.msg.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.msg);
    }
    ProgramInfo localProgramInfo = this.info;
    i = j;
    if (localProgramInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, localProgramInfo);
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
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 18)
        {
          if (i != 26)
          {
            if (i != 34)
            {
              if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.programId = paramCodedInputByteBufferNano.readString();
            }
          }
          else
          {
            if (this.info == null) {
              this.info = new ProgramInfo();
            }
            paramCodedInputByteBufferNano.readMessage(this.info);
          }
        }
        else {
          this.msg = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.ret = paramCodedInputByteBufferNano.readInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.ret;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    if (!this.msg.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.msg);
    }
    ProgramInfo localProgramInfo = this.info;
    if (localProgramInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, localProgramInfo);
    }
    if (!this.programId.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.programId);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.GetProgramRsp
 * JD-Core Version:    0.7.0.1
 */