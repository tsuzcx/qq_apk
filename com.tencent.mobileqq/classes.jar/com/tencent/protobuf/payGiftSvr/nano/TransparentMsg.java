package com.tencent.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class TransparentMsg
  extends MessageNano
{
  private static volatile TransparentMsg[] _emptyArray;
  public byte[] msgData;
  public int msgType;
  
  public TransparentMsg()
  {
    clear();
  }
  
  public static TransparentMsg[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new TransparentMsg[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static TransparentMsg parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new TransparentMsg().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static TransparentMsg parseFrom(byte[] paramArrayOfByte)
  {
    return (TransparentMsg)MessageNano.mergeFrom(new TransparentMsg(), paramArrayOfByte);
  }
  
  public TransparentMsg clear()
  {
    this.msgType = 0;
    this.msgData = WireFormatNano.EMPTY_BYTES;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.msgType;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    j = i;
    if (!Arrays.equals(this.msgData, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(2, this.msgData);
    }
    return j;
  }
  
  public TransparentMsg mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.msgData = paramCodedInputByteBufferNano.readBytes();
        }
      }
      else {
        this.msgType = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.msgType;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    if (!Arrays.equals(this.msgData, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(2, this.msgData);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.TransparentMsg
 * JD-Core Version:    0.7.0.1
 */