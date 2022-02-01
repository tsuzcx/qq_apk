package com.tencent.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class TransMsg
  extends MessageNano
{
  private static volatile TransMsg[] _emptyArray;
  public byte[] msgData;
  public int msgType;
  
  public TransMsg()
  {
    clear();
  }
  
  public static TransMsg[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new TransMsg[0];
      }
      return _emptyArray;
    }
  }
  
  public static TransMsg parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new TransMsg().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static TransMsg parseFrom(byte[] paramArrayOfByte)
  {
    return (TransMsg)MessageNano.mergeFrom(new TransMsg(), paramArrayOfByte);
  }
  
  public TransMsg clear()
  {
    this.msgType = 0;
    this.msgData = WireFormatNano.EMPTY_BYTES;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.msgType != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, this.msgType);
    }
    j = i;
    if (!Arrays.equals(this.msgData, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(2, this.msgData);
    }
    return j;
  }
  
  public TransMsg mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.msgType = paramCodedInputByteBufferNano.readUInt32();
        break;
      }
      this.msgData = paramCodedInputByteBufferNano.readBytes();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.msgType != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.msgType);
    }
    if (!Arrays.equals(this.msgData, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(2, this.msgData);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.TransMsg
 * JD-Core Version:    0.7.0.1
 */