package com.tencent.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class PersonGetGiftReq
  extends MessageNano
{
  private static volatile PersonGetGiftReq[] _emptyArray;
  public int giftId;
  public int needFullUrl;
  public long roomId;
  public long subRoomId;
  
  public PersonGetGiftReq()
  {
    clear();
  }
  
  public static PersonGetGiftReq[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new PersonGetGiftReq[0];
      }
      return _emptyArray;
    }
  }
  
  public static PersonGetGiftReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new PersonGetGiftReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static PersonGetGiftReq parseFrom(byte[] paramArrayOfByte)
  {
    return (PersonGetGiftReq)MessageNano.mergeFrom(new PersonGetGiftReq(), paramArrayOfByte);
  }
  
  public PersonGetGiftReq clear()
  {
    this.giftId = 0;
    this.subRoomId = 0L;
    this.roomId = 0L;
    this.needFullUrl = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.giftId);
    int i = j;
    if (this.subRoomId != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(2, this.subRoomId);
    }
    j = i;
    if (this.roomId != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(3, this.roomId);
    }
    i = j;
    if (this.needFullUrl != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(4, this.needFullUrl);
    }
    return i;
  }
  
  public PersonGetGiftReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.giftId = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 16: 
        this.subRoomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 24: 
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      }
      this.needFullUrl = paramCodedInputByteBufferNano.readUInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.giftId);
    if (this.subRoomId != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, this.subRoomId);
    }
    if (this.roomId != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, this.roomId);
    }
    if (this.needFullUrl != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, this.needFullUrl);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.PersonGetGiftReq
 * JD-Core Version:    0.7.0.1
 */