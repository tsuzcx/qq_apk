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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new PersonGiftListNewReq[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    long l = this.roomId;
    int j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    int k = this.from;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(2, k);
    }
    k = this.roomType;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(3, k);
    }
    k = this.msgType;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    k = this.needFullUrl;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(5, k);
    }
    return j;
  }
  
  public PersonGiftListNewReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 16)
        {
          if (i != 24)
          {
            if (i != 32)
            {
              if (i != 40)
              {
                if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else {
                this.needFullUrl = paramCodedInputByteBufferNano.readUInt32();
              }
            }
            else {
              this.msgType = paramCodedInputByteBufferNano.readUInt32();
            }
          }
          else {
            this.roomType = paramCodedInputByteBufferNano.readUInt32();
          }
        }
        else {
          this.from = paramCodedInputByteBufferNano.readUInt32();
        }
      }
      else {
        this.roomId = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.roomId;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    int i = this.from;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i);
    }
    i = this.roomType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, i);
    }
    i = this.msgType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    i = this.needFullUrl;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.PersonGiftListNewReq
 * JD-Core Version:    0.7.0.1
 */