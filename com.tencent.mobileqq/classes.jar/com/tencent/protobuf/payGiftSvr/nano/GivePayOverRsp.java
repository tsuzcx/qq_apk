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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new GivePayOverRsp[0];
        }
      }
    }
    return _emptyArray;
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
    l = this.roomId;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(6, l);
    }
    l = this.subRoomId;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(7, l);
    }
    return i;
  }
  
  public GivePayOverRsp mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 32)
            {
              if (i != 40)
              {
                if (i != 48)
                {
                  if (i != 56)
                  {
                    if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else {
                    this.subRoomId = paramCodedInputByteBufferNano.readUInt64();
                  }
                }
                else {
                  this.roomId = paramCodedInputByteBufferNano.readUInt64();
                }
              }
              else {
                this.u64Balance = paramCodedInputByteBufferNano.readUInt64();
              }
            }
            else {
              this.balance = paramCodedInputByteBufferNano.readUInt32();
            }
          }
          else {
            this.uin = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else {
          this.errMsg = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
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
    l = this.roomId;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, l);
    }
    l = this.subRoomId;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(7, l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.GivePayOverRsp
 * JD-Core Version:    0.7.0.1
 */