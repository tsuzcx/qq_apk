package com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class GetLuxuryGiftVideoConfigByCategoryReq
  extends MessageNano
{
  private static volatile GetLuxuryGiftVideoConfigByCategoryReq[] _emptyArray;
  public int category;
  public int level;
  
  public GetLuxuryGiftVideoConfigByCategoryReq()
  {
    clear();
  }
  
  public static GetLuxuryGiftVideoConfigByCategoryReq[] emptyArray()
  {
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new GetLuxuryGiftVideoConfigByCategoryReq[0];
      }
      return _emptyArray;
    }
  }
  
  public static GetLuxuryGiftVideoConfigByCategoryReq parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new GetLuxuryGiftVideoConfigByCategoryReq().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static GetLuxuryGiftVideoConfigByCategoryReq parseFrom(byte[] paramArrayOfByte)
  {
    return (GetLuxuryGiftVideoConfigByCategoryReq)MessageNano.mergeFrom(new GetLuxuryGiftVideoConfigByCategoryReq(), paramArrayOfByte);
  }
  
  public GetLuxuryGiftVideoConfigByCategoryReq clear()
  {
    this.category = 0;
    this.level = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.category != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, this.category);
    }
    j = i;
    if (this.level != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, this.level);
    }
    return j;
  }
  
  public GetLuxuryGiftVideoConfigByCategoryReq mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.category = paramCodedInputByteBufferNano.readUInt32();
        break;
      }
      this.level = paramCodedInputByteBufferNano.readUInt32();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.category != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.category);
    }
    if (this.level != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, this.level);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.GetLuxuryGiftVideoConfigByCategoryReq
 * JD-Core Version:    0.7.0.1
 */