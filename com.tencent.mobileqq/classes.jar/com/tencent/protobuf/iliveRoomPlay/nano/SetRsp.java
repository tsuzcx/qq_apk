package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class SetRsp
  extends MessageNano
{
  private static volatile SetRsp[] _emptyArray;
  public String msg;
  public int ret;
  
  public SetRsp()
  {
    clear();
  }
  
  public static SetRsp[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new SetRsp[0];
      }
      return _emptyArray;
    }
  }
  
  public static SetRsp parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new SetRsp().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static SetRsp parseFrom(byte[] paramArrayOfByte)
  {
    return (SetRsp)MessageNano.mergeFrom(new SetRsp(), paramArrayOfByte);
  }
  
  public SetRsp clear()
  {
    this.ret = 0;
    this.msg = "";
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
    return j;
  }
  
  public SetRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      }
      this.msg = paramCodedInputByteBufferNano.readString();
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
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.SetRsp
 * JD-Core Version:    0.7.0.1
 */