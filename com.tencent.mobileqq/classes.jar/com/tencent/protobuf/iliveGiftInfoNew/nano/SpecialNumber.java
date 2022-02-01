package com.tencent.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class SpecialNumber
  extends MessageNano
{
  private static volatile SpecialNumber[] _emptyArray;
  public byte[] specialName;
  public int specialNumber;
  
  public SpecialNumber()
  {
    clear();
  }
  
  public static SpecialNumber[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new SpecialNumber[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static SpecialNumber parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new SpecialNumber().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static SpecialNumber parseFrom(byte[] paramArrayOfByte)
  {
    return (SpecialNumber)MessageNano.mergeFrom(new SpecialNumber(), paramArrayOfByte);
  }
  
  public SpecialNumber clear()
  {
    this.specialNumber = 0;
    this.specialName = WireFormatNano.EMPTY_BYTES;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.specialNumber) + CodedOutputByteBufferNano.computeBytesSize(2, this.specialName);
  }
  
  public SpecialNumber mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          this.specialName = paramCodedInputByteBufferNano.readBytes();
        }
      }
      else {
        this.specialNumber = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.specialNumber);
    paramCodedOutputByteBufferNano.writeBytes(2, this.specialName);
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.SpecialNumber
 * JD-Core Version:    0.7.0.1
 */