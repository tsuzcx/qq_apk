package com.tencent.protobuf.iliveRoomPlay.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class PrepareReq
  extends MessageNano
{
  private static volatile PrepareReq[] _emptyArray;
  public int closePgcCrossLimit;
  public int closeSubAccountLimit;
  public int distributeSource;
  public int roomType;
  
  public PrepareReq()
  {
    clear();
  }
  
  public static PrepareReq[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new PrepareReq[0];
      }
      return _emptyArray;
    }
  }
  
  public static PrepareReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new PrepareReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static PrepareReq parseFrom(byte[] paramArrayOfByte)
  {
    return (PrepareReq)MessageNano.mergeFrom(new PrepareReq(), paramArrayOfByte);
  }
  
  public PrepareReq clear()
  {
    this.roomType = 0;
    this.closePgcCrossLimit = 0;
    this.closeSubAccountLimit = 0;
    this.distributeSource = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.roomType != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, this.roomType);
    }
    j = i;
    if (this.closePgcCrossLimit != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(2, this.closePgcCrossLimit);
    }
    i = j;
    if (this.closeSubAccountLimit != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(3, this.closeSubAccountLimit);
    }
    j = i;
    if (this.distributeSource != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(4, this.distributeSource);
    }
    return j;
  }
  
  public PrepareReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.roomType = paramCodedInputByteBufferNano.readInt32();
        break;
      case 16: 
        this.closePgcCrossLimit = paramCodedInputByteBufferNano.readInt32();
        break;
      case 24: 
        this.closeSubAccountLimit = paramCodedInputByteBufferNano.readInt32();
        break;
      }
      this.distributeSource = paramCodedInputByteBufferNano.readInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.roomType != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, this.roomType);
    }
    if (this.closePgcCrossLimit != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, this.closePgcCrossLimit);
    }
    if (this.closeSubAccountLimit != 0) {
      paramCodedOutputByteBufferNano.writeInt32(3, this.closeSubAccountLimit);
    }
    if (this.distributeSource != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, this.distributeSource);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.PrepareReq
 * JD-Core Version:    0.7.0.1
 */