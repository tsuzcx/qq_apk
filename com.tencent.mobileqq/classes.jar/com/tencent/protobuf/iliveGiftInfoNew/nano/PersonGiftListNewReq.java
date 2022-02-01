package com.tencent.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class PersonGiftListNewReq
  extends MessageNano
{
  private static volatile PersonGiftListNewReq[] _emptyArray;
  public int from;
  public int msgType;
  public int needFullUrl;
  public long roomId;
  public int roomType;
  
  public PersonGiftListNewReq()
  {
    clear();
  }
  
  public static PersonGiftListNewReq[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new PersonGiftListNewReq[0];
      }
      return _emptyArray;
    }
  }
  
  public static PersonGiftListNewReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new PersonGiftListNewReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static PersonGiftListNewReq parseFrom(byte[] paramArrayOfByte)
  {
    return (PersonGiftListNewReq)MessageNano.mergeFrom(new PersonGiftListNewReq(), paramArrayOfByte);
  }
  
  public PersonGiftListNewReq clear()
  {
    this.roomId = 0L;
    this.from = 0;
    this.roomType = 0;
    this.msgType = 0;
    this.needFullUrl = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.roomId != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, this.roomId);
    }
    j = i;
    if (this.from != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, this.from);
    }
    i = j;
    if (this.roomType != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(3, this.roomType);
    }
    j = i;
    if (this.msgType != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, this.msgType);
    }
    i = j;
    if (this.needFullUrl != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(5, this.needFullUrl);
    }
    return i;
  }
  
  public PersonGiftListNewReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.from = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 24: 
        this.roomType = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 32: 
        this.msgType = paramCodedInputByteBufferNano.readUInt32();
        break;
      }
      this.needFullUrl = paramCodedInputByteBufferNano.readUInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.roomId != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.roomId);
    }
    if (this.from != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, this.from);
    }
    if (this.roomType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, this.roomType);
    }
    if (this.msgType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, this.msgType);
    }
    if (this.needFullUrl != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, this.needFullUrl);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.PersonGiftListNewReq
 * JD-Core Version:    0.7.0.1
 */