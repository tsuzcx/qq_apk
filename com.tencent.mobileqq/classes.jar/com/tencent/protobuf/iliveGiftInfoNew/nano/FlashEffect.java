package com.tencent.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class FlashEffect
  extends MessageNano
{
  private static volatile FlashEffect[] _emptyArray;
  public int type;
  public byte[] url;
  
  public FlashEffect()
  {
    clear();
  }
  
  public static FlashEffect[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new FlashEffect[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static FlashEffect parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new FlashEffect().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static FlashEffect parseFrom(byte[] paramArrayOfByte)
  {
    return (FlashEffect)MessageNano.mergeFrom(new FlashEffect(), paramArrayOfByte);
  }
  
  public FlashEffect clear()
  {
    this.type = 0;
    this.url = WireFormatNano.EMPTY_BYTES;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.type) + CodedOutputByteBufferNano.computeBytesSize(2, this.url);
  }
  
  public FlashEffect mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          this.url = paramCodedInputByteBufferNano.readBytes();
        }
      }
      else {
        this.type = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.type);
    paramCodedOutputByteBufferNano.writeBytes(2, this.url);
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.FlashEffect
 * JD-Core Version:    0.7.0.1
 */