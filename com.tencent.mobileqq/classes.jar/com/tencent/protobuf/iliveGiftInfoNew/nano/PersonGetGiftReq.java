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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new PersonGetGiftReq[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.giftId);
    long l = this.subRoomId;
    int j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    l = this.roomId;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    int k = this.needFullUrl;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    return j;
  }
  
  public PersonGetGiftReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
              if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.needFullUrl = paramCodedInputByteBufferNano.readUInt32();
            }
          }
          else {
            this.roomId = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else {
          this.subRoomId = paramCodedInputByteBufferNano.readUInt64();
        }
      }
      else {
        this.giftId = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.giftId);
    long l = this.subRoomId;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    l = this.roomId;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    int i = this.needFullUrl;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.PersonGetGiftReq
 * JD-Core Version:    0.7.0.1
 */