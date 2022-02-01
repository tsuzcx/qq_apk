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
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new PrepareReq[0];
        }
      }
    }
    return _emptyArray;
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
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.roomType;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    k = this.closePgcCrossLimit;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(2, k);
    }
    k = this.closeSubAccountLimit;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(3, k);
    }
    k = this.distributeSource;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(4, k);
    }
    return j;
  }
  
  public PrepareReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
              this.distributeSource = paramCodedInputByteBufferNano.readInt32();
            }
          }
          else {
            this.closeSubAccountLimit = paramCodedInputByteBufferNano.readInt32();
          }
        }
        else {
          this.closePgcCrossLimit = paramCodedInputByteBufferNano.readInt32();
        }
      }
      else {
        this.roomType = paramCodedInputByteBufferNano.readInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.roomType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    i = this.closePgcCrossLimit;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, i);
    }
    i = this.closeSubAccountLimit;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(3, i);
    }
    i = this.distributeSource;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveRoomPlay.nano.PrepareReq
 * JD-Core Version:    0.7.0.1
 */