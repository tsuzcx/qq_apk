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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new PrepareRsp[0];
        }
      }
    }
    return _emptyArray;
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
    RoomInfo localRoomInfo = this.info;
    k = j;
    if (localRoomInfo != null) {
      k = j + CodedOutputByteBufferNano.computeMessageSize(3, localRoomInfo);
    }
    i = k;
    if (!this.defaultRoomName.equals("")) {
      i = k + CodedOutputByteBufferNano.computeStringSize(4, this.defaultRoomName);
    }
    k = this.logoNum;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(5, k);
    }
    return j;
  }
  
  public PrepareRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
              if (i != 40)
              {
                if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else {
                this.logoNum = paramCodedInputByteBufferNano.readInt32();
              }
            }
            else {
              this.defaultRoomName = paramCodedInputByteBufferNano.readString();
            }
          }
          else
          {
            if (this.info == null) {
              this.info = new RoomInfo();
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
    RoomInfo localRoomInfo = this.info;
    if (localRoomInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, localRoomInfo);
    }
    if (!this.defaultRoomName.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.defaultRoomName);
    }
    i = this.logoNum;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(5, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.PrepareRsp
 * JD-Core Version:    0.7.0.1
 */