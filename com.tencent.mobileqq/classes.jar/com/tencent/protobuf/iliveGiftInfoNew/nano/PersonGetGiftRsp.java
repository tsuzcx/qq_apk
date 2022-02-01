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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new PersonGetGiftRsp[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.result;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    GiftInfoRsp localGiftInfoRsp = this.giftInfo;
    j = i;
    if (localGiftInfoRsp != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(2, localGiftInfoRsp);
    }
    k = this.inRoom;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(3, k);
    }
    return i;
  }
  
  public PersonGetGiftRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 24)
          {
            if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.inRoom = paramCodedInputByteBufferNano.readUInt32();
          }
        }
        else
        {
          if (this.giftInfo == null) {
            this.giftInfo = new GiftInfoRsp();
          }
          paramCodedInputByteBufferNano.readMessage(this.giftInfo);
        }
      }
      else {
        this.result = paramCodedInputByteBufferNano.readInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.result;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    GiftInfoRsp localGiftInfoRsp = this.giftInfo;
    if (localGiftInfoRsp != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, localGiftInfoRsp);
    }
    i = this.inRoom;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.PersonGetGiftRsp
 * JD-Core Version:    0.7.0.1
 */