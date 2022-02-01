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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new GivePayGiftRsp[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.result;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    j = i;
    if (!this.errMsg.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.errMsg);
    }
    long l = this.uin;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    k = this.balance;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    l = this.u64Balance;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(5, l);
    }
    k = this.contribute;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(6, k);
    }
    l = this.roomId;
    k = j;
    if (l != 0L) {
      k = j + CodedOutputByteBufferNano.computeUInt64Size(7, l);
    }
    l = this.subRoomId;
    i = k;
    if (l != 0L) {
      i = k + CodedOutputByteBufferNano.computeUInt64Size(8, l);
    }
    k = this.giftId;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(9, k);
    }
    k = this.giftNum;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(10, k);
    }
    Object localObject = this.multiTransMsg;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.multiTransMsg;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(11, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public GivePayGiftRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default: 
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
        break;
      case 90: 
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 90);
        TransMsg[] arrayOfTransMsg = this.multiTransMsg;
        if (arrayOfTransMsg == null) {
          i = 0;
        } else {
          i = arrayOfTransMsg.length;
        }
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
        arrayOfTransMsg[j] = new TransMsg();
        paramCodedInputByteBufferNano.readMessage(arrayOfTransMsg[j]);
        this.multiTransMsg = arrayOfTransMsg;
        break;
      case 80: 
        this.giftNum = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 72: 
        this.giftId = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.subRoomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 56: 
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 48: 
        this.contribute = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.u64Balance = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 32: 
        this.balance = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 24: 
        this.uin = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 18: 
        this.errMsg = paramCodedInputByteBufferNano.readString();
        break;
      case 8: 
        this.result = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.result;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    if (!this.errMsg.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.errMsg);
    }
    long l = this.uin;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    i = this.balance;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    l = this.u64Balance;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, l);
    }
    i = this.contribute;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, i);
    }
    l = this.roomId;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    l = this.subRoomId;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(8, l);
    }
    i = this.giftId;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, i);
    }
    i = this.giftNum;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, i);
    }
    Object localObject = this.multiTransMsg;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.multiTransMsg;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(11, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.GivePayGiftRsp
 * JD-Core Version:    0.7.0.1
 */