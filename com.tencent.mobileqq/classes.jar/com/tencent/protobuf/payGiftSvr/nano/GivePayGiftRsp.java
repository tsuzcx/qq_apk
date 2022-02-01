package com.tencent.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GivePayGiftRsp
  extends MessageNano
{
  private static volatile GivePayGiftRsp[] _emptyArray;
  public int balance;
  public int contribute;
  public String errMsg;
  public int giftId;
  public int giftNum;
  public TransMsg[] multiTransMsg;
  public int result;
  public long roomId;
  public long subRoomId;
  public long u64Balance;
  public long uin;
  
  public GivePayGiftRsp()
  {
    clear();
  }
  
  public static GivePayGiftRsp[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new GivePayGiftRsp[0];
      }
      return _emptyArray;
    }
  }
  
  public static GivePayGiftRsp parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new GivePayGiftRsp().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static GivePayGiftRsp parseFrom(byte[] paramArrayOfByte)
  {
    return (GivePayGiftRsp)MessageNano.mergeFrom(new GivePayGiftRsp(), paramArrayOfByte);
  }
  
  public GivePayGiftRsp clear()
  {
    this.result = 0;
    this.errMsg = "";
    this.uin = 0L;
    this.balance = 0;
    this.u64Balance = 0L;
    this.contribute = 0;
    this.roomId = 0L;
    this.subRoomId = 0L;
    this.giftId = 0;
    this.giftNum = 0;
    this.multiTransMsg = TransMsg.emptyArray();
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
    if (this.contribute != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(6, this.contribute);
    }
    i = j;
    if (this.roomId != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(7, this.roomId);
    }
    j = i;
    if (this.subRoomId != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(8, this.subRoomId);
    }
    int k = j;
    if (this.giftId != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(9, this.giftId);
    }
    i = k;
    if (this.giftNum != 0) {
      i = k + CodedOutputByteBufferNano.computeUInt32Size(10, this.giftNum);
    }
    j = i;
    if (this.multiTransMsg != null)
    {
      j = i;
      if (this.multiTransMsg.length > 0)
      {
        j = 0;
        while (j < this.multiTransMsg.length)
        {
          TransMsg localTransMsg = this.multiTransMsg[j];
          k = i;
          if (localTransMsg != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(11, localTransMsg);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    return j;
  }
  
  public GivePayGiftRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.contribute = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 56: 
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 64: 
        this.subRoomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 72: 
        this.giftId = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 80: 
        this.giftNum = paramCodedInputByteBufferNano.readUInt32();
        break;
      }
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 90);
      if (this.multiTransMsg == null) {}
      TransMsg[] arrayOfTransMsg;
      for (i = 0;; i = this.multiTransMsg.length)
      {
        arrayOfTransMsg = new TransMsg[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.multiTransMsg, 0, arrayOfTransMsg, 0, i);
          j = i;
        }
        while (j < arrayOfTransMsg.length - 1)
        {
          arrayOfTransMsg[j] = new TransMsg();
          paramCodedInputByteBufferNano.readMessage(arrayOfTransMsg[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
      }
      arrayOfTransMsg[j] = new TransMsg();
      paramCodedInputByteBufferNano.readMessage(arrayOfTransMsg[j]);
      this.multiTransMsg = arrayOfTransMsg;
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
    if (this.contribute != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, this.contribute);
    }
    if (this.roomId != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, this.roomId);
    }
    if (this.subRoomId != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(8, this.subRoomId);
    }
    if (this.giftId != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, this.giftId);
    }
    if (this.giftNum != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, this.giftNum);
    }
    if ((this.multiTransMsg != null) && (this.multiTransMsg.length > 0))
    {
      int i = 0;
      while (i < this.multiTransMsg.length)
      {
        TransMsg localTransMsg = this.multiTransMsg[i];
        if (localTransMsg != null) {
          paramCodedOutputByteBufferNano.writeMessage(11, localTransMsg);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.GivePayGiftRsp
 * JD-Core Version:    0.7.0.1
 */