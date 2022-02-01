package com.tencent.protobuf.payGiftSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class ILiveGiftSite
  extends MessageNano
{
  private static volatile ILiveGiftSite[] _emptyArray;
  public int x;
  public int y;
  
  public ILiveGiftSite()
  {
    clear();
  }
  
  public static ILiveGiftSite[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new ILiveGiftSite[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static ILiveGiftSite parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new ILiveGiftSite().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static ILiveGiftSite parseFrom(byte[] paramArrayOfByte)
  {
    return (ILiveGiftSite)MessageNano.mergeFrom(new ILiveGiftSite(), paramArrayOfByte);
  }
  
  public ILiveGiftSite clear()
  {
    this.x = 0;
    this.y = 0;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.x) + CodedOutputByteBufferNano.computeUInt32Size(2, this.y);
  }
  
  public ILiveGiftSite mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.y = paramCodedInputByteBufferNano.readUInt32();
        }
      }
      else {
        this.x = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.x);
    paramCodedOutputByteBufferNano.writeUInt32(2, this.y);
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.payGiftSvr.nano.ILiveGiftSite
 * JD-Core Version:    0.7.0.1
 */