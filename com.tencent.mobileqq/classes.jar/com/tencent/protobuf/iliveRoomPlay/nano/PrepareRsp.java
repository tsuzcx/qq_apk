package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class PrepareRsp
  extends MessageNano
{
  private static volatile PrepareRsp[] _emptyArray;
  public String defaultRoomName;
  public RoomInfo info;
  public int logoNum;
  public String msg;
  public int ret;
  
  public PrepareRsp()
  {
    clear();
  }
  
  public static PrepareRsp[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new PrepareRsp[0];
      }
      return _emptyArray;
    }
  }
  
  public static PrepareRsp parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new PrepareRsp().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static PrepareRsp parseFrom(byte[] paramArrayOfByte)
  {
    return (PrepareRsp)MessageNano.mergeFrom(new PrepareRsp(), paramArrayOfByte);
  }
  
  public PrepareRsp clear()
  {
    this.ret = 0;
    this.msg = "";
    this.info = null;
    this.defaultRoomName = "";
    this.logoNum = 0;
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
    if (!this.defaultRoomName.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.defaultRoomName);
    }
    i = j;
    if (this.logoNum != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(5, this.logoNum);
    }
    return i;
  }
  
  public PrepareRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          this.info = new RoomInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.info);
        break;
      case 34: 
        this.defaultRoomName = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.logoNum = paramCodedInputByteBufferNano.readInt32();
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
    if (!this.defaultRoomName.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.defaultRoomName);
    }
    if (this.logoNum != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, this.logoNum);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.PrepareRsp
 * JD-Core Version:    0.7.0.1
 */