package com.tencent.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GivePayOverRsp
  extends MessageNano
{
  private static volatile GivePayOverRsp[] _emptyArray;
  public int balance;
  public String errMsg;
  public int result;
  public long roomId;
  public long subRoomId;
  public long u64Balance;
  public long uin;
  
  public GivePayOverRsp()
  {
    clear();
  }
  
  public static GivePayOverRsp[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new GivePayOverRsp[0];
      }
      return _emptyArray;
    }
  }
  
  public static GivePayOverRsp parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new GivePayOverRsp().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static GivePayOverRsp parseFrom(byte[] paramArrayOfByte)
  {
    return (GivePayOverRsp)MessageNano.mergeFrom(new GivePayOverRsp(), paramArrayOfByte);
  }
  
  public GivePayOverRsp clear()
  {
    this.result = 0;
    this.errMsg = "";
    this.uin = 0L;
    this.balance = 0;
    this.u64Balance = 0L;
    this.roomId = 0L;
    this.subRoomId = 0L;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.result != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, this.result);
    }
    j = i;
    if (!this.errMsg.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.errMsg);
    }
    i = j;
    if (this.uin != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, this.uin);
    }
    j = i;
    if (this.balance != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, this.balance);
    }
    i = j;
    if (this.u64Balance != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(5, this.u64Balance);
    }
    j = i;
    if (this.roomId != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(6, this.roomId);
    }
    i = j;
    if (this.subRoomId != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(7, this.subRoomId);
    }
    return i;
  }
  
  public GivePayOverRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.result = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 18: 
        this.errMsg = paramCodedInputByteBufferNano.readString();
        break;
      case 24: 
        this.uin = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 32: 
        this.balance = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.u64Balance = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 48: 
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      }
      this.subRoomId = paramCodedInputByteBufferNano.readUInt64();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.result != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.result);
    }
    if (!this.errMsg.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.errMsg);
    }
    if (this.uin != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, this.uin);
    }
    if (this.balance != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, this.balance);
    }
    if (this.u64Balance != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, this.u64Balance);
    }
    if (this.roomId != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, this.roomId);
    }
    if (this.subRoomId != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, this.subRoomId);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.GivePayOverRsp
 * JD-Core Version:    0.7.0.1
 */