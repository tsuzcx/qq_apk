package com.tencent.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class PersonGetGiftRsp
  extends MessageNano
{
  private static volatile PersonGetGiftRsp[] _emptyArray;
  public GiftInfoRsp giftInfo;
  public int inRoom;
  public int result;
  
  public PersonGetGiftRsp()
  {
    clear();
  }
  
  public static PersonGetGiftRsp[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new PersonGetGiftRsp[0];
      }
      return _emptyArray;
    }
  }
  
  public static PersonGetGiftRsp parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new PersonGetGiftRsp().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static PersonGetGiftRsp parseFrom(byte[] paramArrayOfByte)
  {
    return (PersonGetGiftRsp)MessageNano.mergeFrom(new PersonGetGiftRsp(), paramArrayOfByte);
  }
  
  public PersonGetGiftRsp clear()
  {
    this.result = 0;
    this.giftInfo = null;
    this.inRoom = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.result != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, this.result);
    }
    j = i;
    if (this.giftInfo != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(2, this.giftInfo);
    }
    i = j;
    if (this.inRoom != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(3, this.inRoom);
    }
    return i;
  }
  
  public PersonGetGiftRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.result = paramCodedInputByteBufferNano.readInt32();
        break;
      case 18: 
        if (this.giftInfo == null) {
          this.giftInfo = new GiftInfoRsp();
        }
        paramCodedInputByteBufferNano.readMessage(this.giftInfo);
        break;
      }
      this.inRoom = paramCodedInputByteBufferNano.readUInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.result != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, this.result);
    }
    if (this.giftInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, this.giftInfo);
    }
    if (this.inRoom != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, this.inRoom);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.PersonGetGiftRsp
 * JD-Core Version:    0.7.0.1
 */